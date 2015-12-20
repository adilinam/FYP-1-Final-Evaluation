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
package org.eclipse.m2m.internal.qvt.oml.tools.coverage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.InternalEvaluator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageData;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageDataPersistor;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.TransformationCoverageData;
import org.eclipse.ocl.utilities.ASTNode;

@SuppressWarnings("restriction")
public class QVTOCoverageDecorator extends QvtGenericVisitorDecorator {

    public static CoverageData data = null;

    public QVTOCoverageDecorator(InternalEvaluator qvtExtVisitor) {
        super(qvtExtVisitor);
        data = new CoverageData();
    }

    @Override
    protected Object genericPreVisitAST(ASTNode element) {
        TransformationCoverageData data = getTransformationCoverageData();
        if (data != null) {
            data.touch(element);
        }
        return super.genericPreVisitAST(element);
    }

    // Note: strangely enough this method is only invoked in case of running the transformation using the
    // TransformationExecutor. In case the transformation is launched using the launch configuration, this method is
    // somehow not invoked.
    @Override
    public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
        Object ret = super.execute(transformation);

        // Save after each execution
        CoverageDataPersistor persistor = new CoverageDataPersistor();
        persistor.save(data);
        return ret;
    }

    private TransformationCoverageData getTransformationCoverageData() {

        QvtOperationalEvaluationEnv evalEnv = (QvtOperationalEvaluationEnv) getEvaluationEnvironment();
        InternalEvaluationEnv internEnv = evalEnv.getAdapter(InternalEvaluationEnv.class);

        TransformationCoverageData transformationData = null;

        if (internEnv.getCurrentModule() != null) {
            Module module = internEnv.getCurrentModule().getModule();

            IModuleSourceInfo moduleSource = ASTBindingHelper.getModuleSourceBinding(module);
            URI uri = moduleSource.getSourceURI().appendFragment(module.getName());

            // See if we already have a data for that module.
            for (TransformationCoverageData transData : data.getData()) {
                if (transData.getURI().equals(uri)) {
                    transformationData = transData;
                }
            }

            // Otherwise create a new one
            if (transformationData == null) {
                transformationData = new TransformationCoverageData(uri);
                // And store it in CoverageData, since that's what gets saved
                // later.
                data.add(transformationData);
            }
        }

        return transformationData;
    }

}
