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

public class ResolveTypeCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        return isCollectorApplicable(data);
    }
    
    public static final boolean isCollectorApplicable(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
	    if (isResolveStart(leftToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS)
	            && !isResolveStart(leftToken, LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS)) {
	        return true;
	    }
        if (QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_COMMA)) {
            IToken prevToken = leftToken;
            boolean isColonColonExpected = false;
            while ((prevToken = LightweightParserUtil.getPreviousToken(prevToken)) != null) {
                if (isColonColonExpected) {
                    if (!QvtCompletionData.isKindOf(prevToken, QVTOParsersym.TK_COLONCOLON)) {
                        return isResolveStart(prevToken, LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS);
                    }
                } else if (!QvtCompletionData.isKindOf(prevToken, QVTOParsersym.TK_IDENTIFIER)) {
                    return false;
                }
                isColonColonExpected = !isColonColonExpected;
            }
        }
		return false;
	}
	
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        CompletionProposalUtil.addModelTypes(proposals, data);
    }
    
    private static boolean isResolveStart(IToken lParen, int... resolveFamilyType) {
        if (QvtCompletionData.isKindOf(lParen, QVTOParsersym.TK_LPAREN)) {
            IToken resolveToken = LightweightParserUtil.getPreviousToken(lParen);
            if ((resolveToken != null) 
                    && QvtCompletionData.isKindOf(resolveToken, resolveFamilyType)) {
              return true;
            }
        }
        return false;
    }
}