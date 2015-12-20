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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;

/**
 * TODO - use new TextSourceViewerConfiguration for QVT
 */
public class QvtAnnotationHover extends DefaultAnnotationHover {

	QvtAnnotationHover() {
		super();
	}
	
	@Override
	protected boolean isIncluded(Annotation annotation) {
		AnnotationPreference preference = EditorsUI.getAnnotationPreferenceLookup().getAnnotationPreference(annotation);
		if (preference != null && preference.getVerticalRulerPreferenceValue()) {
			return annotation.getText() != null;
		}
		return false;		
	}
}
