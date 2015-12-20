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

import java.util.ArrayList;

/**
 * Implemens quick search of a line number for a given position within a string
 */
public class StringLineNumberProvider implements LineNumberProvider {
    
    /**
     * Creates a new StringLineNumberProvider object for the given string
     * @param s - the string to parse into lines
     */
    public StringLineNumberProvider(String s) {
        myLineEnds = new ArrayList<Integer>();
        parseString(s);
    }
    
    public int getLineEnd(int lineNumber) {
        return getLineEndInt(lineNumber - 1); 
    }
    
    public int getLineCount() {
        return myLineEnds.size();
    }
    
    public int getLineNumber(int offset){
        if (offset < 0) {
            return -1;
        }
        return getLineNumberInt(offset) + 1;
    }
    
    /* Internal implementation: zero-based line numeration */
    private int getLineEndInt(int lineNumber) {
        return ((Integer) myLineEnds.get(lineNumber)).intValue(); 
    }
    
    /* Internal implementation: zero-based line numeration
     * Dihotomic search of a line containig given offset 
     */
    public int getLineNumberInt(int offset){
        int a = 0;
        if (getLineEndInt(a) >= offset) {
            return a;
        }
        int b = myLineEnds.size() - 1;
        if (getLineEndInt(b) < offset) {
            return b;
        }
        int result = b;
        while (a <= b) {
            int c = (a + b) / 2;
            int cValue = getLineEndInt(c);
            if (cValue > offset) {
                result = c;
                b = c - 1;
            }
            else if (cValue < offset) {
                a = c + 1;
            }
            else return c;
        }
        return result;
    }

    /* Find out line ends */
    private void parseString(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\n') {
                myLineEnds.add(new Integer(i));
            }
            // Workaround for the case when \r is present and \n is lost
            if ((s.charAt(i) == '\r') && (i < s.length() - 1)) {
                if (s.charAt(i + 1) != '\n') {
                    myLineEnds.add(new Integer(i));
                }
            }
        }
        if ((s.length() != 0 ) && (
                myLineEnds.isEmpty() ||
                (getLineEndInt(getLineCount() - 1) != s.length() - 1)
           )) {
            myLineEnds.add(new Integer(s.length() - 1));
        }
    }

    private final ArrayList<Integer> myLineEnds;
}
