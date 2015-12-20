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

import java.io.IOException;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DefaultIndentLineAutoEditStrategy;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextUtilities;

/**
 * @author vrepeshko
 */
public class QvtIndentAutoEditStrategy extends DefaultIndentLineAutoEditStrategy {

	public QvtIndentAutoEditStrategy() {
		super();
	}
	
	@Override
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		String newLineDelimeter = getNewLineDelimeter(document, command);
		boolean customized = false;
		if (newLineDelimeter != null) {
			customized = smartAutoIndentAfterNewLine(document, command, newLineDelimeter);
		}
		
		if(!customized) {
			super.customizeDocumentCommand(document, command);
		}
	}

	/**
	 * Smart indents after '{'.
	 * 
	 * @param document
	 *            the document to work on
	 * @param command
	 *            the command to deal with
	 * @param newLineDelimeter
	 *            the new line delimenter to use when needed
	 */
	private boolean smartAutoIndentAfterNewLine(IDocument document, DocumentCommand command, String newLineDelimeter) {
		if (!checkCommandOffset(document, command)) {
			return false;
		}

		try {
			IRegion info = DocumentUtils.getLineInformationOfOffset(document, command.offset);
			int currentLineStart = info.getOffset();
			String whiteSpace = DocumentUtils.getStartingWhiteSpace(document, currentLineStart, command.offset);
			String currentLineText = document.get(currentLineStart, info.getLength());
			String cmdText = command.text + whiteSpace;
			if (currentLineText.trim().endsWith("{")) { //$NON-NLS-1$
				cmdText += '\t';
				if (computeBraceBalance(document) > 0) {
					command.caretOffset = command.offset + cmdText.length();
					command.shiftsCaret = false;
					cmdText += newLineDelimeter + whiteSpace + "}"; //$NON-NLS-1$
					command.text = cmdText;
					return true;
				}
			}
		} catch (BadLocationException e) {
			// ignore
		} catch (IOException e) {
			// ignore
		}
		
		return false;
	}

	private int computeBraceBalance(IDocument document) throws IOException {
		QvtCodeReader codeReader = new QvtCodeReader();
		codeReader.configureForwardReader(document, 0, document.getLength(), true, true);
		int balance = 0;
		int next;
		while ((next = codeReader.read()) != QvtCodeReader.EOF) {
			char c = (char) next;
			if (c == '{') {
				++balance;
			} else if (c == '}') {
				--balance;
			}
		}
		return balance;
	}
	
	private static String getNewLineDelimeter(IDocument document, DocumentCommand command) {
		if (command.length != 0 || command.text == null) {
			return null;
		}
		String[] legalLineDelimiters = document.getLegalLineDelimiters();
		int i = TextUtilities.endsWith(legalLineDelimiters, command.text);
		return (i != -1) ? legalLineDelimiters[i] : null;
	}

	private static boolean checkCommandOffset(IDocument document, DocumentCommand command) {
		return command.offset != -1 && document.getLength() != 0;
	}

}
