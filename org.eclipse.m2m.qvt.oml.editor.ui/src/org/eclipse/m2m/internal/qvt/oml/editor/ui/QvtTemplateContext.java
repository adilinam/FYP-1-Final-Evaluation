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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultLineTracker;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ILineTracker;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.templates.DocumentTemplateContext;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateBuffer;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateException;
import org.eclipse.jface.text.templates.TemplateTranslator;

/**
 * @author vrepeshko
 */
public class QvtTemplateContext extends DocumentTemplateContext {

	public QvtTemplateContext(TemplateContextType type, IDocument document, int offset, int length) {
		super(type, document, offset, length);
	}

	@Override
	public TemplateBuffer evaluate(Template template) throws BadLocationException, TemplateException {
		if (!canEvaluate(template)) {
			return null;
		}

		TemplateTranslator translator = new TemplateTranslator();
		TemplateBuffer buffer = translator.translate(getUpdatedPattern(template.getPattern(), !isReadOnly()));
		
		getContextType().resolve(buffer, this);
		
		return buffer;
	}
	
	private String getUpdatedPattern(String pattern, boolean updateIndentation) throws BadLocationException {
		IDocument document = getDocument();
		int offset = getCompletionOffset();
		IRegion info = DocumentUtils.getLineInformationOfOffset(document, offset);
		String whiteSpace = DocumentUtils.getStartingWhiteSpace(document, info.getOffset(), offset);
		String validLineDelimeter = getValidLineDelimeter(document);
		
		ILineTracker tracker = new DefaultLineTracker();
		tracker.set(pattern);
		int numberOfLines = tracker.getNumberOfLines();
		if (numberOfLines == 1) {
			return pattern;
		}
		
		StringBuilder newPattern = new StringBuilder();
		for (int i = 0; i < numberOfLines; i++) {
			if (updateIndentation && i > 0) {
				newPattern.append(whiteSpace);
			}
			IRegion region = tracker.getLineInformation(i);
			String line = pattern.substring(region.getOffset(), region.getOffset() + region.getLength());
			newPattern.append(line);
			if (i < numberOfLines - 1) {
				newPattern.append(validLineDelimeter);
			}
		}
		
		return newPattern.toString();
	}
	
	private String getValidLineDelimeter(IDocument document) {
		String delimeter = null;
		for (int i = 0, lineCount = document.getNumberOfLines(); i < lineCount && delimeter == null; i++) {
			try {
				delimeter = document.getLineDelimiter(i);
			} catch (BadLocationException e) {
				// ignore
			}
		}
		if (delimeter == null) {
			delimeter = document.getLegalLineDelimiters()[0];
		}
		return delimeter;
	}
	
}
