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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

public interface QvtOutlineNodeType {
    
    public static final int MAPPING_MODULE = 0;
    public static final int IMPORTED_MODULES = 1;
    public static final int METAMODEL = 2;
    public static final int IMPORTED_METAMODELS = 3;
    public static final int TAG = 4;
    public static final int TAGS = 5;
    public static final int PROPERTY = 6;
    public static final int PROPERTIES = 7;
    public static final int MAPPING_RULE = 8;
    public static final int IMPORTED_LIBRARY = 9;
    public static final int UNIT = 10;    
    public static final int TYPE = 11;    
}
