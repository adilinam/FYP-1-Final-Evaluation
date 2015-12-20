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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;


/**
 * @author vrepeshko
 */
public class ModelTypeHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		EPackage ePackage = findReferencedPackageDefinition(syntaxElement);		
		if(ePackage != null) {
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(syntaxElement), ePackage);
		}
		
		return null;
	}

	public static EPackage findReferencedPackageDefinition(CSTNode syntaxElement) {
		PackageRefCS packageRefCS = null;
		if(syntaxElement.eContainer() instanceof PackageRefCS) {
			packageRefCS = (PackageRefCS) syntaxElement.eContainer();						
			if((syntaxElement instanceof PathNameCS) || 
				((syntaxElement instanceof StringLiteralExpCS) && packageRefCS.getUriCS() == syntaxElement)) {
				Object ast = syntaxElement.getAst();
				if(ast instanceof EPackage) {
					return (EPackage) ast;
				}
			}
		}		
	
		if(syntaxElement instanceof SimpleNameCS && syntaxElement.getAst() instanceof ModelType) {
			ModelType modelType = (ModelType) syntaxElement.getAst();
			if(!modelType.getMetamodel().isEmpty()) {
				// TODO - multiple links for multiple metamodels
				return modelType.getMetamodel().get(0);
			}
		}
		
		return null;
	}	
}
