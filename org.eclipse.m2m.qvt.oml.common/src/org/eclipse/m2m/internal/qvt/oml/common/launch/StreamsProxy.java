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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.debug.core.model.IStreamMonitor;
import org.eclipse.debug.core.model.IStreamsProxy;

/**
 * @author vrepeshko
 */
public class StreamsProxy implements IStreamsProxy {

	public StreamsProxy() {
		myOutputStreamMonitor = new WriterMonitor();
		myErrStreamMonitor = new WriterMonitor();
	}
	
	public IStreamMonitor getErrorStreamMonitor() {
		return myErrStreamMonitor;
	}

	public IStreamMonitor getOutputStreamMonitor() {
		return myOutputStreamMonitor;
	}
	
	public Writer getOutputWriter() {
		return myOutputStreamMonitor;
	}
	
	public Writer getErrWriter() {
		return myErrStreamMonitor;
	}	

	public void write(String input) throws IOException {
	}
	
	private final WriterMonitor myOutputStreamMonitor;
	private final WriterMonitor myErrStreamMonitor;
}
