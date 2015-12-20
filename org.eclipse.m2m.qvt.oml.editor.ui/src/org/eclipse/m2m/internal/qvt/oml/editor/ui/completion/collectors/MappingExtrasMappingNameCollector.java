/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
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
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;

/**
 * @author aigdalov
 */

public class MappingExtrasMappingNameCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        return isCollectorApplicable(data.getLeftToken());
	}

    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        MappingMethodCS[] allImperativeOperationsCS = data.getAllImperativeOperationsCS();
        for (MappingMethodCS mappingMethodCS : allImperativeOperationsCS) {
            if (mappingMethodCS instanceof MappingRuleCS) {
                StringBuilder stringBuilder = new StringBuilder();
                MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
                TypeCS contextType = mappingDeclarationCS.getContextType();
                if (contextType != null) {
                    stringBuilder.append(QvtOperationalParserUtil.getStringRepresentation(contextType));
                    stringBuilder.append(EmfUtil.PATH_SEPARATOR);
                }
                SimpleNameCS mappingName = mappingDeclarationCS.getSimpleNameCS();
                if(mappingName != null) {                
                    stringBuilder.append(mappingName.getValue());
                }
                QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(stringBuilder.toString(), CategoryImageConstants.MAPPING, data);
                CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
            }
        }
    }
    
    public static final boolean isCollectorApplicable(IToken token) {
        while ((token != null) && QvtCompletionData.isKindOf(token, QVTOParsersym.TK_COMMA)) {
            IToken previousToken = LightweightParserUtil.getPreviousToken(token);
            if (previousToken != null) {
                IToken[] scopedIdentifier = LightweightParserUtil.getScopedIdentifier(previousToken);
                if (scopedIdentifier == null) {
                    return false;
                }
                token = LightweightParserUtil.getPreviousToken(scopedIdentifier[0]);
            }
        }
        if ((token != null) && QvtCompletionData.isKindOf(token, QVTOParsersym.TK_inherits, QVTOParsersym.TK_merges, QVTOParsersym.TK_disjuncts)) {
            return true;
        }
        return false;
    }
}