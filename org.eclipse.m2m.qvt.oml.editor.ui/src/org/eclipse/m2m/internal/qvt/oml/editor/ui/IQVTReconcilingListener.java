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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;

public interface IQVTReconcilingListener {
	/**
	 * Called before reconciling is started.
	 */
	void aboutToBeReconciled();

	/**
	 * Called after reconciling has been finished.
	 * 
	 * @param unit the compilation unit or <code>null</code> if the unit failed to be compiled
	 * @param monitor the progress monitor or <code>null</code> if no monitor is available
	 */
	void reconciled(CompiledUnit unit, IProgressMonitor monitor);
}
