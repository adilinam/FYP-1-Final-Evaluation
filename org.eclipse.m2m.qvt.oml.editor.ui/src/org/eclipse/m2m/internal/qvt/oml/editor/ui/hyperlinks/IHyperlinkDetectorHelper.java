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

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.ocl.cst.CSTNode;


/**
 * @author vrepeshko
 */
public interface IHyperlinkDetectorHelper {

	IHyperlink detectHyperlink(IDetectionContext context);
	
	interface IDetectionContext {
		
		CompiledUnit getModule();
		
		CSTNode getSyntaxElement();
		
		IRegion getRegion();
		
		ITextViewer geTextViewer();
	}
}
