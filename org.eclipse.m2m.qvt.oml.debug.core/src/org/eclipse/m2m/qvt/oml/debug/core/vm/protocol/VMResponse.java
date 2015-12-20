/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm.protocol;

import java.io.Serializable;

public class VMResponse implements Serializable {
	
	private static final long serialVersionUID = -5622330458726111494L;

	public static final int STATUS_OK = 0;
	public static final int STATUS_ERROR = 1;
	
	public final int status;
	
	protected VMResponse() {
		this(STATUS_OK);
	}
	
	protected VMResponse(int status) {
		this.status = status;
	}
		
	public boolean isOK() {
		return status == STATUS_OK;
	}
	
	public static VMResponse createOK() {
		return new VMResponse();
	}
	
	public static VMResponse createERROR() {
		return new VMResponse(STATUS_ERROR);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " status: " + status;
	}
}