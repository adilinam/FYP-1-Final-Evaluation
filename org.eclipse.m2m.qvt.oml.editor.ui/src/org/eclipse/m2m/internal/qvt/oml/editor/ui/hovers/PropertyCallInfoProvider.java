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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.PropertyCallExp;


/**
 * @author vrepeshko
 */
public class PropertyCallInfoProvider implements IElementInfoProvider {

	public String getElementInfo(final Object element, ITextViewer textViewer, IRegion region) {
		if (false == element instanceof SimpleNameCS) {
			return null;
		}

		if (element instanceof PropertyCallExp) {
			PropertyCallExp propertyCallExp = (PropertyCallExp) element;
			String propertyName = propertyCallExp.getName(); //NameUtil.buildPropertyName(propertyCallExp.getReferredProperty(), null);
			return propertyName;
		}
		return null;
	}

}
