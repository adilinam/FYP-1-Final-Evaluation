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
package org.eclipse.m2m.internal.qvt.oml.common.ui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class CommonUIUtils {
	
	private CommonUIUtils() {
	}

	public static void runInUiThread(final Runnable r) {
	    Display display = getStandardDisplay();
	    if (display.getThread().equals(Thread.currentThread())) {
	        r.run();
	        return;
	    }
	    
	    final RuntimeException[] exception = new RuntimeException[1];
	    final Object lock = new Object();       
	    Runnable rr = new Runnable() {
	        public void run() {
	            try {
	                r.run();
	            }
	            catch(RuntimeException e) {
	                exception[0] = e;
	            }
	            synchronized (lock) {
	                lock.notifyAll();
	            }
	        }
	    };
	    synchronized (lock) {
	        getStandardDisplay().asyncExec(rr);
	        try {
	            lock.wait();
	        } 
	        catch (InterruptedException e) {
	        }
	    }
	    
	    if (exception[0] != null ) {
	        throw exception[0];
	    }
	}

	/**
	 * Returns the standard display to be used. The method first checks, if
	 * the thread calling this method has an associated display. If so, this
	 * display is returned. Otherwise the method returns the default display.
	 */
	public static Display getStandardDisplay() {
		Display display= Display.getCurrent();
		if (display == null) {
			display= Display.getDefault();
		}
		return display;		
	}

	/**
	 * Returns the currently active workbench window shell or <code>null</code>
	 * if none.
	 * 
	 * @return the currently active workbench window shell or <code>null</code>
	 */
	public static Shell getShell() {
		if (CommonUIUtils.getActiveWorkbenchWindow() != null) {
			return CommonUIUtils.getActiveWorkbenchWindow().getShell();
		}
		return null;
	}

	/**
	 * Returns the currently active workbench window or <code>null</code>
	 * if none.
	 * 
	 * @return the currently active workbench window or <code>null</code>
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
	}
	
	
}
