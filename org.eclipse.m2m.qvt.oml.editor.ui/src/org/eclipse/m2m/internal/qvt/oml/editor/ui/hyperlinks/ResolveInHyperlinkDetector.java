/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveInExp;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;


/**
 * @author vrepeshko
 */
public class ResolveInHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {		
		CSTNode element = context.getSyntaxElement();
		
		if (element instanceof ResolveInExpCS) {
			ResolveInExpCS resolveInExpCS = (ResolveInExpCS) element;

			TypeCS type = resolveInExpCS.getInMappingType();		
			SimpleNameCS inMappingNameCS = resolveInExpCS.getInMappingName();
			if(type != null && inMappingNameCS != null) {
				String mappingName = inMappingNameCS.getValue();
				int mappingNameStartOffset = inMappingNameCS.getStartOffset();
				int length = inMappingNameCS.getEndOffset() - inMappingNameCS.getStartOffset() + 1;
					
				if(HyperlinkUtil.isOffsetInRange(context.getRegion().getOffset(), 
						mappingNameStartOffset, 
						mappingNameStartOffset + mappingName.length())) {
					
					MappingDeclarationCS mappingDeclCS = findReferencedDefinitionCS(resolveInExpCS);
					if(mappingDeclCS != null) {
						URI sourceURI = CSTHelper.getSourceFile(mappingDeclCS);
						if(sourceURI == null) {
							return null;
						}
						
						IRegion destReg = HyperlinkUtil.createRegion(getLinkDestinationNode(mappingDeclCS));
						return new QvtFileHyperlink(new Region(mappingNameStartOffset, length), sourceURI, destReg, destReg);
					}
				}
			}
		}
		
		return null;
	}
		
	public static MappingOperation findReferencedDefinition(ResolveInExpCS resolveInExpCS) {
		ResolveInExp resolveInAST = ASTBindingHelper.resolveASTNode(resolveInExpCS, ResolveInExp.class);
		if(resolveInAST != null) { 
			return resolveInAST.getInMapping();
		}
		
		return null;
	}
	
	private static MappingDeclarationCS findReferencedDefinitionCS(ResolveInExpCS resolveInExpCS) {
		MappingOperation mappingOperation = findReferencedDefinition(resolveInExpCS);
		if(mappingOperation != null) {
			MappingRuleCS mappingRuleCS = ASTBindingHelper.resolveCSTNode(mappingOperation, MappingRuleCS.class);
			if(mappingRuleCS != null) {
				return mappingRuleCS.getMappingDeclarationCS();
			}
		}
		
		return null;
	}	
	
	private static CSTNode getLinkDestinationNode(MappingDeclarationCS mappingDeclCS) {
		CSTNode linkDestCS = mappingDeclCS.getSimpleNameCS();
		if(linkDestCS == null) {
			linkDestCS = mappingDeclCS;
		}
		
		return linkDestCS;
	}
}
