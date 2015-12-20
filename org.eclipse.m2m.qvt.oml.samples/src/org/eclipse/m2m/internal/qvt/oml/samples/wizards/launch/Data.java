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
package org.eclipse.m2m.internal.qvt.oml.samples.wizards.launch;

import java.text.MessageFormat;

import org.eclipse.m2m.internal.qvt.oml.samples.ui.SampleProject;


public class Data {

	private String myURI;
	private SampleProject myProject;

	public Data(String uri, SampleProject project) {
		myURI = uri;
		myProject = project;
	}

	public String getURI() {
        return MessageFormat.format(myURI, myProject.getName());
	}
    
    public SampleProject getProject() {
        return myProject;
    }

}
