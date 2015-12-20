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

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 */

public class OclExpressionStartCollector extends AbstractCollector {
    private static final int[] INAPPLICABLE_BRACING_EXPRESSIONS = {
        QVTOParsersym.TK_switch,
        QVTOParsersym.TK_Tuple
    };
        
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
		if (QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_LPAREN)) {
		    if (TypeStartCollector.isCollectorApplicable(data)) {
		        return false;
		    }
		    IToken previousToken = data.getLeftToken(1);
		    if ((previousToken != null) 
		            && QvtCompletionData.isKindOf(previousToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS)) {
                return false; 
		    }
		}
		if (QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_SEMICOLON, QVTOParsersym.TK_LBRACE)) {
		    IToken parentBracingExpression = data.getParentBracingExpression(new QvtCompletionData.ITokenQualificator() {
		            	public boolean isSuited(IToken token) {
		            		return QvtCompletionData.isKindOf(token, INAPPLICABLE_BRACING_EXPRESSIONS);        		
		            	}
		            },
		    		QVTOParsersym.TK_LBRACE, QVTOParsersym.TK_RBRACE, 1, null, null, null);
		    if ((parentBracingExpression != null) 
		            && QvtCompletionData.isKindOf(parentBracingExpression, INAPPLICABLE_BRACING_EXPRESSIONS)) {
		        return false;
		    }
		}
		if (data.getParentBracingExpression(new QvtCompletionData.ITokenQualificator() {
		        	public boolean isSuited(IToken token) {
		        		return QvtCompletionData.isKindOf(token, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS);        		
		        	}
		        },
				QVTOParsersym.TK_LBRACE, QVTOParsersym.TK_RBRACE, Integer.MAX_VALUE, null, null, LightweightParserUtil.MAPPING_CLAUSE_TOKENS) != null) {
		    if (ResolveTypeCollector.isCollectorApplicable(data)) {
		        return false;
		    }
		    if (QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_RPAREN)) {
		        // check for switch ... { case(...) /*@*/
	            IToken bracingSwitch = data.getParentBracingExpression(new QvtCompletionData.ITokenQualificator() {
			            	public boolean isSuited(IToken token) {
			            		return QvtCompletionData.isKindOf(token, new int[] {QVTOParsersym.TK_switch});        		
			            	}
			            },
	            		QVTOParsersym.TK_LBRACE, QVTOParsersym.TK_RBRACE, 1, null, null, null);
	            if (bracingSwitch != null) {
	                IToken caseToken = LightweightParserUtil.getPreviousTokenByKind(leftToken, QVTOParsersym.TK_case);
	                return (caseToken != null) && (bracingSwitch.getEndOffset() < caseToken.getStartOffset());
	            }
		    }
	        return QvtCompletionData.isKindOf(leftToken, LightweightParserUtil.OCLEXPRESSION_START_TOKENS);
		}
		return false;
	}

	public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
		CompletionProposalUtil.addRValues(proposals, data);
	}
}