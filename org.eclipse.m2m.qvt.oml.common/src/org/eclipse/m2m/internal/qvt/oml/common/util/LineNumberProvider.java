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
package org.eclipse.m2m.internal.qvt.oml.common.util;

/**
 * An interface for objects providing lines
 */
public interface LineNumberProvider {

    /**
	 * Returns offset of the given line end
	 * 
	 * @param lineNumber -
	 *            number of line (one-based)
	 * @return offset of the last character of the line that is line-delimiter -
	 *         '\n'
	 */
    public int getLineEnd(int lineNumber);
    
    /**
     * @return Number of lines
     */
    public int getLineCount();
    
    /**
	 * Returns number of a line containing given offset
	 * 
	 * @param offset -
	 *            an offset to look for
	 * @return (one-based) line number or -1 if no line found
	 */
    public int getLineNumber(int offset);
}
