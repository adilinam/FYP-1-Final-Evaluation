/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;


import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;

public interface IQVTODebuggerShell {

	void sessionStarted(QVTODebugEvaluator evaluator);
	
	VMRequest popRequest();

	VMRequest waitAndPopRequest(VMEvent suspend) throws InterruptedException;
	
	VMRequest peekRequest();
	
	void handleVMEvent(VMEvent event);	

	VMBreakpointManager getBreakPointManager();
}
