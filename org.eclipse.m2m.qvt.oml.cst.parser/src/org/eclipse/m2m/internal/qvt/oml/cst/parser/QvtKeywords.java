/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class QvtKeywords {

	private static final Set<String> tempKeywords = new HashSet<String>(); 
	static {
    	for (String string : QVTOParsersym.orderedTerminalSymbols) {
    		if (!string.equals(string.toUpperCase())) { // filter out primitive literals, operators and empty-string tokens
                tempKeywords.add(string);
    		}
		}
	}
		
	public static final Set<String> KEYWORDS = Collections.unmodifiableSet(tempKeywords);	
	
	private QvtKeywords() {
	}

	public static boolean isKeyword(String aString) {
		return KEYWORDS.contains(aString);
	}
}
