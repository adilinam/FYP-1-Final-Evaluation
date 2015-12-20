/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import lpg.runtime.IToken;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * @author Aleksandr Igdalov
 * Created on Aug 7, 2007
 */

public abstract class AbstractCallExpSourceCollector extends AbstractCollector {
    private static final int[] MODULE_KEYWORDS = {
        QVTOParsersym.TK_transformation,
        QVTOParsersym.TK_library
    };
    
    private static final int[] UNEXPECTED_TRANSFORMATION_NAME_TOKENS = {
        QVTOParsersym.TK_SEMICOLON, 
        QVTOParsersym.TK_LBRACE
    };
    
    private static final String CALLEXP_SOURCE_FLAG = AccessorCollector.class.toString() + "CALLEXP_SOURCE_FLAG"; //$NON-NLS-1$
    
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        TypedElement<EClassifier> callExpSource = getCallExpSource(data);
        if (callExpSource != null) {
            data.getUserData().put(CALLEXP_SOURCE_FLAG, callExpSource);
        }
        return callExpSource != null;
    }
    
    protected EClassifier getCallExpSourceType(IToken accessorToken, QvtCompletionData data) {
        QvtOperationalEnv env = data.getEnvironment();
        @SuppressWarnings("unchecked")
        TypedElement<EClassifier> callExpSource = (TypedElement<EClassifier>) data.getUserData().get(CALLEXP_SOURCE_FLAG);
        if (callExpSource == null) {
            return null;
        }
        EClassifier classifier = callExpSource.getType();
        if ((accessorToken.getKind() == QVTOParsersym.TK_ARROW)
                && !(classifier instanceof CollectionType)) {
            classifier = (EClassifier) env.getOCLFactory().createSetType(classifier); 
        } else if ((accessorToken.getKind() == QVTOParsersym.TK_DOT)
                && (classifier instanceof CollectionType)){
            classifier = ((CollectionType) classifier).getElementType();
        }
        return classifier;
    }
    
    protected TypedElement<EClassifier> getCallExpSource(IToken accessorToken, QvtCompletionData data) {
        if ((accessorToken.getKind() == QVTOParsersym.TK_DOT) 
                || (accessorToken.getKind() == QVTOParsersym.TK_ARROW)) {
            if (!data.isWithin(MODULE_KEYWORDS, UNEXPECTED_TRANSFORMATION_NAME_TOKENS)) {
                return LightweightParserUtil.getOclExpression(accessorToken, data, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_PARSER);
            }
        }
        return null;
    }

    protected abstract TypedElement<EClassifier> getCallExpSource(QvtCompletionData data);

}