/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks.ObjectPropertyHyperlinkDetector;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.EcoreEnvironment;


/**
 * @author vrepeshko
 */
public class PatternPropertyExpressionInfoProvider implements
		IElementInfoProvider {

	public String getElementInfo(final Object element, ITextViewer textViewer, IRegion region) {
		if (element instanceof CSTNode) {
			CSTNode syntaxElement = (CSTNode) element;
			EStructuralFeature feature = ObjectPropertyHyperlinkDetector.findDefinition(syntaxElement);
			if(feature != null) {
				EcoreEnvironment env = CSTHelper.getEnvironment(syntaxElement);
				return SignatureUtil.getPropertySignature(feature, env);				
			}
		}
		
		return null;
	}

}
