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

import java.util.Collection;

import lpg.runtime.IToken;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.expressions.OCLExpression;

/**
 * @author aigdalov
 * Created on Sep 13, 2007
 */

public class IteratorShorthandCollector extends AbstractCollector {
    private static final String ITERATOR_TOKEN_FLAG = IteratorShorthandCollector.class.toString() + "ITERATOR_TOKEN_FLAG"; //$NON-NLS-1$
    
    private static final int[] ZERO_DEPTH_TERMINATORS = {
        QVTOParsersym.TK_BAR
    };
    
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        IToken iteratorToken = data.getParentBracingExpression(new QvtCompletionData.ITokenQualificator() {
		        	public boolean isSuited(IToken token) {
		        		return QvtCompletionData.isKindOf(token, LightweightParserUtil.QVTO_ITERATOR_TERMINALS_WITH_IMPLICIT_ITERATOR);        		
		        	}
		        },
		        QVTOParsersym.TK_LPAREN, QVTOParsersym.TK_RPAREN,
                1, ZERO_DEPTH_TERMINATORS, LightweightParserUtil.OCLEXPRESSION_MANDATORY_TERMINATION_TOKENS, null);            
        if (iteratorToken != null) {
            data.getUserData().put(ITERATOR_TOKEN_FLAG, iteratorToken);
            return true;
        }
        iteratorToken = data.getParentBracingExpression(new QvtCompletionData.ITokenQualificator() {
		        	public boolean isSuited(IToken token) {
		        		return QvtCompletionData.isKindOf(token, LightweightParserUtil.OCL_ITERATOR_TERMINALS);        		
		        	}
		        },
        		QVTOParsersym.TK_LPAREN, QVTOParsersym.TK_RPAREN,
                1, ZERO_DEPTH_TERMINATORS, LightweightParserUtil.OCLEXPRESSION_MANDATORY_TERMINATION_TOKENS, null);            
        if (iteratorToken != null) {
            data.getUserData().put(ITERATOR_TOKEN_FLAG, iteratorToken);
            return true;
        }
        return false;
    }

    public void addPropoposals(Collection<ICompletionProposal> proposals,
            QvtCompletionData data) {
        IToken iteratorToken = (IToken) data.getUserData().get(ITERATOR_TOKEN_FLAG);
        int accessorTokenIndex = iteratorToken.getTokenIndex() - 1;
        if (accessorTokenIndex < 0) {
            return;
        }
        IToken accessorToken = data.getPrsStream().getTokenAt(accessorTokenIndex);
        OCLExpression<EClassifier> source = LightweightParserUtil.getOclExpression(accessorToken, data, LightweightParserUtil.ParserTypeEnum.LIGHTWEIGHT_PARSER);
        if (source == null) {
            return;
        }
        EClassifier sourceType = source.getType();
        EClassifier elementType;
        if (sourceType instanceof CollectionType) {
            CollectionType collectionType = (CollectionType) sourceType;
            elementType = collectionType.getElementType();
        } else {
            elementType = sourceType;
        }
        CompletionProposalUtil.addContextProposals(proposals, elementType, true, true, data);
    }
}