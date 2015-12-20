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
package org.eclipse.m2m.qvt.oml.tools.coverage.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageData;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.CoverageModel;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui.CoverageView;
import org.eclipse.m2m.qvt.oml.tools.coverage.Activator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CoveragePlugin extends AbstractUIPlugin {

    public static final String PLUGIN_ID = Activator.PLUGIN_ID;
    public static final String UI_PLUGIN_ID = "org.eclipse.m2m.qvt.oml.tools.coverage.ui";

    private static CoveragePlugin plugin;

    // The identifiers for the preferences
    public static final String LOW_THRESHOLD_PREFERENCE = "org.eclipse.m2m.qvt.oml.tools.coverage.threshold.low";
    public static final String HIGH_THRESHOLD_PREFERENCE = "org.eclipse.m2m.qvt.oml.tools.coverage.threshold.high";

    // The default values for the preferences
    public static final int DEFAULT_LOW_THRESHOLD = 30;
    public static final int DEFAULT_HIGH_THRESHOLD = 90;

    public CoveragePlugin() {
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static CoveragePlugin getDefault() {
        return plugin;
    }

    @Override
    protected void initializeDefaultPreferences(IPreferenceStore store) {
        store.setDefault(LOW_THRESHOLD_PREFERENCE, DEFAULT_LOW_THRESHOLD);
        store.setDefault(HIGH_THRESHOLD_PREFERENCE, DEFAULT_HIGH_THRESHOLD);
    }

    public void showCoverageView(CoverageData data) {
        Display.getDefault().asyncExec(new Runnable() {
			@Override
            public void run() {
                try {
                    PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(CoverageView.VIEW_ID);
                    CoverageView view = (CoverageView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                            .getActivePage().findView(CoverageView.VIEW_ID);
                    view.setLoading(true);

                } catch (PartInitException e) {
                	Activator.error("Coverage View failed", e);
                }
            }
        });

        final CoverageModel coverageModel = new CoverageModel(data);

        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                // Note that we don't have a guarantee the async block above has
                // run first... we just assume.
                CoverageView view = (CoverageView) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .findView(CoverageView.VIEW_ID);
                view.setLoading(false);
                view.update(coverageModel);

                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view);
            }
        });
    }

}
