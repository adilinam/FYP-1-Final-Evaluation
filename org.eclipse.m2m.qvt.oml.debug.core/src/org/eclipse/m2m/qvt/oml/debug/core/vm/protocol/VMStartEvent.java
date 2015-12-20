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

public class VMStartEvent extends VMEvent {

	private static final long serialVersionUID = 4489918763664221834L;

	public final boolean suspendOnStartup;
	public final String mainModuleName;
	
	public VMStartEvent(String mainModuleName, boolean suspendOnStartup) {
		this.suspendOnStartup = suspendOnStartup;
		this.mainModuleName = mainModuleName;
	}
}