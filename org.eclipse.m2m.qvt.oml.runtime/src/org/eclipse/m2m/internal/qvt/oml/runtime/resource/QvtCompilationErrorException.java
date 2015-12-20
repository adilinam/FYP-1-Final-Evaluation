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

package org.eclipse.m2m.internal.qvt.oml.runtime.resource;

import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;

/**
 * @author sboyko
 *
 */
public class QvtCompilationErrorException extends XMIException {

	private static final long serialVersionUID = 1L;
	
	public QvtCompilationErrorException(QvtMessage qvtMessage, String location, int line) {
		super(qvtMessage.getMessage(), location, line, 0);
	}

}
