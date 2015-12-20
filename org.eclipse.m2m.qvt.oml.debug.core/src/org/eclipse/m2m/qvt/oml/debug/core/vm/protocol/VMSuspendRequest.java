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


public class VMSuspendRequest extends VMRequest {
	
	private static final long serialVersionUID = -5297559608628409741L;

	public final int detail;
	
	public VMSuspendRequest(int detail) {
		this.detail = detail;
	}
}