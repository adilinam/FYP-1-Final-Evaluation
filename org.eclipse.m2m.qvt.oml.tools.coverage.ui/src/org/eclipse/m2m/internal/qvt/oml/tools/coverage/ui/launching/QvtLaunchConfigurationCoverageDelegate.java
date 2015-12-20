/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.launching;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ShallowProcess;
import org.eclipse.m2m.internal.qvt.oml.common.launch.StreamsProxy;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegateBase;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.QVTOCoverageDecorator;
import org.eclipse.m2m.qvt.oml.tools.coverage.ui.CoveragePlugin;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

@SuppressWarnings("restriction")
public class QvtLaunchConfigurationCoverageDelegate extends QvtLaunchConfigurationDelegateBase {

    public static final String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.m2m.qvt.oml.QvtTransformation"; //$NON-NLS-1$

    private static final int LAUNCH_ERROR_CODE = 210;
    private static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QvtRuntimePlugin.ID,
            LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$

    public QvtLaunchConfigurationCoverageDelegate() {
    }

    // FIXME - do refactoring of this area
    @Override
    public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch,
            final IProgressMonitor monitor) throws CoreException {

        try {
            final QvtTransformation qvtTransformation = new QvtInterpretedTransformation(getQvtModule(configuration));

            final StreamsProxy streamsProxy = new StreamsProxy();

            ShallowProcess.IRunnable r = new ShallowProcess.IRunnable() {

                @Override
                public void run() throws Exception {
                    IStatus status = QvtLaunchConfigurationDelegateBase.validate(qvtTransformation, configuration);
                    if (status.getSeverity() > IStatus.WARNING) {
                        throw new CoreException(status);
                    }

                    Context context = QvtLaunchUtil.createContext(configuration);
                    context.setLog(new WriterLog(streamsProxy.getOutputWriter()));
                    context.setProgressMonitor(monitor);

                    // Install the decorators for collecting coverage data
                    ArrayList<Class<? extends QvtGenericVisitorDecorator>> decorators = new ArrayList<Class<? extends QvtGenericVisitorDecorator>>();
                    decorators.add(QVTOCoverageDecorator.class);
                    context.getSessionData().setValue(QVTEvaluationOptions.VISITOR_DECORATORS, decorators);

                    QvtLaunchConfigurationDelegateBase.doLaunch(qvtTransformation, configuration, context);

                    qvtTransformation.cleanup();

                    // Save the collected coverage data to disk and activate the coverage view
                    CoveragePlugin.getDefault().showCoverageView(QVTOCoverageDecorator.data);
                    QVTOCoverageDecorator.data.clear();
                }
            };

            r = getSafeRunnable(qvtTransformation, r);
            final ShallowProcess process = new ShallowProcess(launch, r) {
                boolean isTerminated = false;

                @Override
                public void terminate() throws DebugException {
                    monitor.setCanceled(true);
                    isTerminated = true;
                    super.terminate();
                }

                @Override
                public boolean isTerminated() {
                    return isTerminated || super.isTerminated();
                }

                @Override
                public boolean canTerminate() {
                    return !isTerminated();
                }
            };

            process.setStreamsProxy(streamsProxy);

            Thread processThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        process.run();
                    } catch (Exception e) {
                        if (e instanceof QvtRuntimeException == false) {
                            // QVT runtime exception are legal QVT transformation level errors

                            IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(
                                    fgLaunchErrorStatus);
                            if (statusHandler != null) {
                                IStatus actualStatus = new Status(IStatus.ERROR, QvtRuntimePlugin.ID,
                                        LAUNCH_ERROR_CODE, e.getMessage(), e.getMessage() == null ? e : null);
                                try {
                                    statusHandler.handleStatus(actualStatus, configuration);
                                } catch (CoreException coreExc) {
                                    QvtPlugin.getDefault().log(coreExc.getStatus());
                                }
                            }

                            QvtPlugin.error(e);
                        }
                    }

                    try {
                        launch.terminate();
                    } catch (DebugException e) {
                        QvtPlugin.getDefault().log(e.getStatus());
                    }
                }
            }, "QVT Run"); //$NON-NLS-1$

            processThread.start();
        } catch (Exception e) {
            throw new CoreException(org.eclipse.m2m.internal.qvt.oml.runtime.util.MiscUtil.makeErrorStatus(e));
        }
    }

}
