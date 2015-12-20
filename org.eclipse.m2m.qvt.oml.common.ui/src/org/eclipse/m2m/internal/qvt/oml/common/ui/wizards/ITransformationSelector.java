/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards;

/**
 * An interface for wizard pages used for transformation sleection
 * Allowes to select a transformation by string ID (ID contents differs 
 * depending on transformation type) 
 * @author abreslav
 */
public interface ITransformationSelector {

    /**
     * @return String ID of the selected transformation or <code>null</code>
     * if selection is empty
     */
    public String getSelectedTransformationId();
    
    /**
     * Selects a transformation by Id
     * @param id - string ID
     */
    public void setSelectedTransformationId(String id);
    
}
