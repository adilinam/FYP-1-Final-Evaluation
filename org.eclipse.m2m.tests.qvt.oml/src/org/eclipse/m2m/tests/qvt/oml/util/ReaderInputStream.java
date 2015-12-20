/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

/**
 * An adapter to InputStream for StringReader
 */
public class ReaderInputStream extends InputStream {
	
	public ReaderInputStream(final String string) {
		myReader = new StringReader(string);
	}
	
	@Override
	public int read() throws IOException {
		return myReader.read();
	}
	
	private final StringReader myReader;
	
}
