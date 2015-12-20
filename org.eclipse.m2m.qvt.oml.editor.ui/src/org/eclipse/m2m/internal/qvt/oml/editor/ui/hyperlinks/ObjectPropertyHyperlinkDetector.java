/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNodeAccess;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.PropertyCallExp;


public class ObjectPropertyHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		EStructuralFeature referredFeature = findDefinition(syntaxElement);			
		if(referredFeature != null) {
			ModulePropertyCS propertyCS = findDefinitionCS(referredFeature);
			if(propertyCS != null) {
				URI sourceFileURI = CSTHelper.getSourceFile(propertyCS);
				CSTNode destNodeCS = (propertyCS.getSimpleNameCS() != null) ? propertyCS.getSimpleNameCS() : propertyCS;
				IRegion destRegion = HyperlinkUtil.createRegion(destNodeCS);						
				return new QvtFileHyperlink(HyperlinkUtil.createRegion(syntaxElement), sourceFileURI, destRegion, destRegion);	
			}
			
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(syntaxElement), referredFeature);
		}
		
		return null;
	}
	
	public static ModulePropertyCS findDefinitionCS(EStructuralFeature referencedFeature) {
		ModulePropertyCS referencedDefinitionCS;
		ASTSyntheticNode referencedDefinitionAST = ASTSyntheticNodeAccess.getASTNode(referencedFeature);
		if(referencedDefinitionAST != null) {
			referencedDefinitionCS = ASTSyntheticNodeAccess.getCST(referencedDefinitionAST, ModulePropertyCS.class);
		} else {
			referencedDefinitionCS = ASTBindingHelper.resolveCSTNode(referencedFeature, ModulePropertyCS.class);
		}
		return referencedDefinitionCS;
	}
	
	public static EStructuralFeature findDefinition(CSTNode syntaxElement) {
		if (syntaxElement instanceof SimpleNameCS || syntaxElement instanceof ScopedNameCS) {
			Object ast = syntaxElement.getAst();
			if(ast instanceof EStructuralFeature) {
				return (EStructuralFeature)  ast;
			} else if(ast instanceof PropertyCallExp) {
				return ((PropertyCallExp) ast).getReferredProperty();
			}
		}
		
		return null;
	}
}
