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
package org.eclipse.m2m.internal.qvt.oml.samples.ui;

import java.util.ArrayList;

import org.eclipse.core.resources.IProject;


/**
 * Provides sample project information - default name, path to ZIP file with project content
 */
public class SampleProject {
    
    public static interface Action {
        void perform(SampleProject sample, IProject project) throws Exception;
    }
    
    public SampleProject(final String name, final String archive, final String namespace) {
        this(name, archive, namespace, null);
    }
    
    public SampleProject(final String name, final String archive, final String namespace, final String fileToOpen) {
        this(name, archive, namespace, fileToOpen, Messages.SamplesWizardPage_projectName);
    }
    
    /**
     * @param name new project default name
     * @param archive plug-in bundle relative path to ZIP file that contains project content
     * @param namespace plug-in bundle symbolic name
     * @param fileToOpen file to open after project creation
     * @param label a label to be shown in wizard
     */
    public SampleProject(final String name, final String archive, final String namespace,
    		final String fileToOpen, String label) {
        myName = name;
        myArchive = archive;
        myNamespace = namespace;
        myFileToOpen = fileToOpen;
        myLabel = label;
    }
    
    public String getName() {
        return myName;
    }
    
    public void setName(final String name) {
        myName = name;
    }
    
    public String getArchive() {
        return myArchive;
    }
    
    public String getNamespace() {
        return myNamespace;
    }
    
    public String getFileToOpen() {
		return myFileToOpen;
	}
    
    public String getLabel() {
        return myLabel;
    }
    public String getDescription() {
        return myDescription;
    }

    public void setDescription(String description) {
        myDescription = description;
    }
    
    public String getHelpHref() {
        return myHelpHref;
    }

    public void setHelpHref(String helpHref) {
        myHelpHref = helpHref;
    }
    
    public void performActions(IProject project) throws Exception {
        for (Action action : myActions) {
            action.perform(this, project);
        }
    }
    
    public void addAction(Action action) {
        myActions.add(action);
    }
    
    private String myName;
    private String myLabel;
    private final String myArchive;
    private final String myNamespace;
    private final String myFileToOpen;
    private ArrayList<Action> myActions = new ArrayList<Action>(2);

    private String myDescription;
    private String myHelpHref;
}