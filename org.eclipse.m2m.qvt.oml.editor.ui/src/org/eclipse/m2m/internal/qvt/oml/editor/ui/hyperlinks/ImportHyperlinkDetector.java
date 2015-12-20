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
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

/**
 * @author vrepeshko
 */
public class ImportHyperlinkDetector implements IHyperlinkDetectorHelper {

	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		
		URI sourceFileURI = findDefinition(syntaxElement);
		if(sourceFileURI != null) {			
			IRegion destRegion = new Region(0, 0); // point to the beginning

			ImportCS importCS = getImport(syntaxElement);
			CSTNode linkNodeCS = (importCS != null) ? importCS.getPathNameCS() : null;
			if(linkNodeCS == null) {
				linkNodeCS = syntaxElement;
			}
			
			IRegion hlinkReg = HyperlinkUtil.createRegion(linkNodeCS);						
			return new QvtFileHyperlink(hlinkReg, sourceFileURI, destRegion, destRegion);
		}
		
		return null;
	}
	
	public static URI findDefinition(CSTNode syntaxElement) {		
		ImportCS importCS = getImport(syntaxElement);		
		if(importCS != null && importCS.getAst() instanceof URI) {
			return (URI) importCS.getAst();
		}
		
		return null;
	}

	private static ImportCS getImport(CSTNode syntaxElement) {
		ImportCS importCS = null;		
		if ((syntaxElement instanceof ImportCS)) {
			importCS = (ImportCS) syntaxElement;
		} else if(syntaxElement instanceof PathNameCS && syntaxElement.eContainer() instanceof ImportCS) {
			importCS = (ImportCS) syntaxElement.eContainer();
		}
		return importCS;
	}
	
}
