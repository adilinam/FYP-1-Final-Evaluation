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
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

/**
 * @author vrepeshko
 */
public class DocumentUtils {

	/**
	 * Returns the first offset greater than <code>offset</code> and smaller
	 * than <code>end</code> whose character is not a space or tab character.
	 * If no such offset is found, <code>end</code> is returned.
	 * 
	 * @param document
	 *            the document to search in
	 * @param offset
	 *            the offset at which searching start
	 * @param end
	 *            the offset at which searching stops
	 * @return the offset in the specified range whose character is not a space
	 *         or tab
	 * @exception BadLocationException
	 *                if position is an invalid range in the given document
	 */
	public static int findEndOfWhiteSpace(IDocument document, int offset, int end) throws BadLocationException {
		while (offset < end) {
			char c = document.getChar(offset);
			if (c != ' ' && c != '\t') {
				return offset;
			}
			offset++;
		}
		return end;
	}

	/**
	 * Returns the line information of the offset.
	 * 
	 * @param document
	 *            the document
	 * @param offset
	 *            the offset
	 * @return the line information of offset
	 * @throws BadLocationException
	 *             if position is an invalid range in the given document
	 */
	public static IRegion getLineInformationOfOffset(IDocument document, int offset) throws BadLocationException {
		int p = (offset == document.getLength()) ? (offset - 1) : offset;
        if (p < 0) {
            p = 0;
        }
		IRegion info = document.getLineInformationOfOffset(p);
		return info;
	}

	/**
	 * Returns the starting offset as a string.
	 * 
	 * @param document
	 *            the document
	 * @param offset
	 *            the offset at which searching start
	 * @param end
	 *            the offset at which searching stops
	 * @return the stating white space as a string
	 * @throws BadLocationException
	 */
	public static String getStartingWhiteSpace(IDocument document, int offset, int end) throws BadLocationException {
		int whiteSpaceEnd = findEndOfWhiteSpace(document, offset, end);
		return (whiteSpaceEnd > offset) ? document.get(offset, whiteSpaceEnd - offset) : ""; //$NON-NLS-1$
	}

}
