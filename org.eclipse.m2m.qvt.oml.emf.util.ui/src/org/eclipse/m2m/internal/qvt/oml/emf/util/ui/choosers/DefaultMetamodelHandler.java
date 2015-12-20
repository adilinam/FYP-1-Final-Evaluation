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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import org.eclipse.emf.ecore.resource.ResourceSet;


public class DefaultMetamodelHandler implements IMetamodelHandler {
    public IResultSaver getSaver() {
        return new ResourceSaver();
    }

    public ISourceChooser getSourceChooser(ResourceSet rs) {
        return new ResourceSourceChooser(true, rs);
    }

    public ISourceChooser getSourceAdaptableChooser(ResourceSet rs) {
        return new ResourceSourceChooser(true, rs);
    }

    public IDestinationChooser getSourceDestChooser(ResourceSet rs) {
        return new ResourceSourceDestChooser(rs);
    }

}
