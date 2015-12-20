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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.debug.core.IStreamListener;
import org.eclipse.debug.core.model.IFlushableStreamMonitor;

/**
 * A stream monitor connected to a Writer 
 */
public class WriterMonitor extends Writer implements IFlushableStreamMonitor {

	private List<IStreamListener> fListeners;
	private IStreamListener[] fCachedListeners;
	
	private final StringBuffer fContents;
	private boolean fIsBuffered;

	public WriterMonitor() {
		fContents = new StringBuffer();		
		fIsBuffered = true;
		fListeners = new LinkedList<IStreamListener>();
	}
	
	public void flushContents() {
		fContents.setLength(0);
	}

	public boolean isBuffered() {
		return fIsBuffered;
	}

	public void setBuffered(boolean buffer) {
		fIsBuffered = buffer;
	}
	
	public String getContents() {
		return fContents.toString();
	}
	
	private void notifyListeners(String newText) {
		IStreamListener[] listeners = getListeners();
		for (IStreamListener listener : listeners) {
			try {
				listener.streamAppended(newText, this);
			} catch(RuntimeException e) {
				// ignore a stupid listener
			}
		}
	}

	private synchronized IStreamListener[] getListeners() {
		synchronized(fListeners) {
			if(fCachedListeners == null) {
				fCachedListeners = fListeners.toArray(new IStreamListener[fListeners.size()]);
			}
			
			return fCachedListeners;
		}
	}
	
	public void addListener(IStreamListener listener) {
		synchronized(fListeners) {
			if (!fListeners.contains(listener)) {
				fListeners.add(listener);
				fCachedListeners = null;
			}
		}
	}

	public void removeListener(IStreamListener listener) {
		synchronized(fListeners) {
			fListeners.remove(listener);
			fCachedListeners = null;
		}
	}

	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		fContents.append(cbuf, off, len);		
		notifyListeners(new String(cbuf, off, len));
	}	
	
	// Writer operations
	@Override
	public void close() throws IOException {
		// do nothing
	}

	@Override
	public void flush() throws IOException {
		// do nothing
	}
}
