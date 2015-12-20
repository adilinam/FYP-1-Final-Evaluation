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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * @author vrepeshko
 */
public class WriterOutputStream extends OutputStream {

	public WriterOutputStream(Writer writer) {
		if (writer == null) {
			throw new IllegalArgumentException();
		}
		myWriter = writer;
	}
	
	@Override
	public void write(int b) throws IOException {
		myByteArrayOutputStream.write(b);
		myCount++;
		if (myCount == BUFFER_SIZE) {
			flush();
		}
	}

	@Override
	public void flush() throws IOException {
		if (myCount == 0) {
			return;
		}
		try {
			myWriter.write(myByteArrayOutputStream.toString());
		} finally {
			myCount = 0;
			myByteArrayOutputStream.reset();
		}
	}
	
	@Override
	public void close() throws IOException {
		try {
			flush();
		} finally {
			myWriter.close();
		}
	}
	
	private int myCount = 0;
	
	private final Writer myWriter;
	
	private final ByteArrayOutputStream myByteArrayOutputStream = new ByteArrayOutputStream(BUFFER_SIZE);
	
	private static final int BUFFER_SIZE = 8192;
	
}
