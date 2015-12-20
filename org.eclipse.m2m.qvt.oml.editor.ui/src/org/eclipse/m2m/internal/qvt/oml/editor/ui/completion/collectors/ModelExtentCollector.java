/*******************************************************************************
 * Copyright (c) 2008, 2010 Borland Software Corporation and others.
 * 
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
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.ocl.cst.SimpleNameCS;

/**
 * @author aigdalov
 * Created on May 18, 2009
 */
public class ModelExtentCollector extends AbstractCollector {

	@Override
	protected boolean isApplicableInternal(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
		return QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_AT_SIGN);
	}

	public void addPropoposals(Collection<ICompletionProposal> proposals,
			QvtCompletionData data) {
		MappingModuleCS mappingModuleCS = data.getCurrentMappingModuleCS();
		if (mappingModuleCS != null) {
			TransformationHeaderCS headerCS = mappingModuleCS.getHeaderCS();
			if (headerCS != null) {
				for (ParameterDeclarationCS parameterDeclarationCS :headerCS.getParameters()) {
					if (parameterDeclarationCS != null) {
						DirectionKindEnum directionKind = parameterDeclarationCS.getDirectionKind();
						if ((directionKind == DirectionKindEnum.INOUT) || (directionKind == DirectionKindEnum.OUT)) {
							SimpleNameCS simpleNameCS = parameterDeclarationCS.getSimpleNameCS();
							if (simpleNameCS != null) {
								String extentName = simpleNameCS.getValue();
								if (extentName != null) {
									QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(extentName, CategoryImageConstants.TYPE, data);
									CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
								}
							}
						}
					}
				}
			}
		}
	}

}
