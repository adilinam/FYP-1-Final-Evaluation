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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation;

/**
 * @author Aleksandr Igdalov
 */
public class StringNode extends Node {
    public StringNode(Object parent, String object) {
        super(parent, object);
    }
    
    @Override
	public String getObject() {
        return (String) super.getObject();
    }
}