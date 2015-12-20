/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - Bug 388331
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

public class ResolveInMappingNameCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
		if (leftToken.getKind() == QVTOParsersym.TK_LPAREN) {
		    IToken resolveInToken = data.getLeftToken(1);
		    if ((resolveInToken != null) 
		            && QvtCompletionData.isKindOf(resolveInToken, LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS)) {
              return true;
		    }
		}
		return false;
	}

    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        CompletionProposalUtil.addAllMappingNamesProposals(proposals, data, null, true, false, true);
    }
}