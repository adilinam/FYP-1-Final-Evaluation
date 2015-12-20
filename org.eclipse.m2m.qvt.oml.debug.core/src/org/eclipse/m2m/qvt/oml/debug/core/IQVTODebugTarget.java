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
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMEventListener;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResponse;



interface IQVTODebugTarget extends IDebugTarget {

	VMResponse sendRequest(VMRequest request) throws DebugException;
	
	void addVMEventListener(VMEventListener listener);
	
	boolean removeVMEventListener(VMEventListener listener);

}