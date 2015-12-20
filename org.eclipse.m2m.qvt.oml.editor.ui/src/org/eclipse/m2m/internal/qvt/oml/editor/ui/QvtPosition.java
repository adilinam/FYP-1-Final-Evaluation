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
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.projection.IProjectionPosition;

/**
 * @author vrepeshko
 */
public class QvtPosition extends Position implements IProjectionPosition {

	public QvtPosition(int offset, int length) {
		super(offset, length);
	}

	public int computeCaptionOffset(IDocument document) throws BadLocationException {
		return 0;
	}

	public IRegion[] computeProjectionRegions(IDocument document) throws BadLocationException {
		int firstLine = document.getLineOfOffset(getOffset());
		int lastLine = document.getLineOfOffset(getOffset() + getLength());

		if (firstLine < lastLine) {
			int postOffset = document.getLineOffset(firstLine + 1);
			return new IRegion[] { new Region(postOffset, getOffset() + getLength() - postOffset) };
		}

		return null;
	}

}
