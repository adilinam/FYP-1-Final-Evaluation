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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lpg.runtime.IToken;
import lpg.runtime.IPrsStream;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;

/**
 * @author aigdalov
 */

public class ColonColonCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
		return leftToken.getKind() == QVTOParsersym.TK_COLONCOLON;
	}

	public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
    	IToken leftToken = data.getLeftToken();
    	IPrsStream prsStream = data.getPrsStream();
		List<String> pathName = new ArrayList<String>();
		IToken pathNameFirstToken = leftToken;
		for (int i = leftToken.getTokenIndex(); i >= 1; i -= 2) {
			IToken colonColon = prsStream.getTokenAt(i);
			if (colonColon.getKind() != QVTOParsersym.TK_COLONCOLON) {
				break;
			}
			IToken name = prsStream.getTokenAt(i - 1);
			pathNameFirstToken = name;
			pathName.add(0, name.toString());
		}
        QvtOperationalEnv env = data.getEnvironment();
        
        // Is it a modeltype?
		if (pathName.size() == 1) {
		    ModelType modelType = env.getModelType(pathName.get(0));
		    if (modelType != null) {
		        List<EPackage> metamodels = modelType.getMetamodel();
                for (EPackage pack : metamodels) {
                    QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(pack.getName(), CategoryImageConstants.PACKAGE, data);
                    CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
                }
                for (EPackage pack : metamodels) {
                    CompletionProposalUtil.addPackageContentsProposals(proposals, data, pack);
                }
		        return;
		    }
		}
        
		// Is it an EPackage?
        EPackage pack = env.lookupPackage(pathName);
		if (pack != null) {
	        CompletionProposalUtil.addPackageContentsProposals(proposals, data, pack);
	        return;
	    }

		// Is it an EEnum?
		EClassifier classifier = env.lookupClassifier(pathName);
		if (classifier instanceof EEnum) {
		    EEnum eEnum = (EEnum) classifier;
		    for (EEnumLiteral enumLiteral : eEnum.getELiterals()) {
                QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(enumLiteral.getName(), CategoryImageConstants.ENUM_LITERAL, data);
                CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
            }
		}
		if (classifier != null) {
		    IToken prevToken = LightweightParserUtil.getPreviousToken(pathNameFirstToken);
		    if (prevToken != null) {
	            if (QvtCompletionData.isKindOf(prevToken, QVTOParsersym.TK_LPAREN)) {
	                IToken resolveToken = LightweightParserUtil.getPreviousToken(prevToken);
	                if ((resolveToken != null) && (QvtCompletionData.isKindOf(resolveToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS))) {
	                    CompletionProposalUtil.addAllMappingNamesProposals(proposals, data, classifier, false, true, true);
	                }
	            }
	            if (MappingExtrasMappingNameCollector.isCollectorApplicable(prevToken)) {
	                CompletionProposalUtil.addAllMappingNamesProposals(proposals, data, classifier, false, false, false);
	            }
		    }
		}
    }
}