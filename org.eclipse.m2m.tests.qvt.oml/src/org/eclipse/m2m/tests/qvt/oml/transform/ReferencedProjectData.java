/*******************************************************************************
 * Copyright (c) 2009, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.m2m.tests.qvt.oml.TestProject;

public class ReferencedProjectData extends FilesToFilesData {
	
	private TestTransformation referencedProjectTestCase;
	private boolean isUseCycleReferences;
	
	public ReferencedProjectData(String myName, String referencedName, boolean useCycleReferences) {
		super(myName);
		
		ModelTestData referencedProjectTestData = new FilesToFilesData(referencedName) {
			@Override
			public boolean isUseCompiledXmi() {
				return ReferencedProjectData.this.isUseCompiledXmi();
			}
		};
		
		referencedProjectTestCase = new TestTransformation(referencedProjectTestData) {
			
			@Override
			protected String getProjectName() {
		    	return "ReferencedTransformationTest"; //$NON-NLS-1$
		    }
		};
		
		isUseCycleReferences = useCycleReferences;
	}
	
	@Override
	public void prepare(TestProject project) throws Exception {
		referencedProjectTestCase.setUp();
		
		super.prepare(project);
		
		IProject referencedProject = referencedProjectTestCase.getProject();
		IProject myProject = project.getProject();
		
		IProjectDescription desc = myProject.getDescription();
		desc.setReferencedProjects(new IProject[] {referencedProject});
		myProject.setDescription(desc, null);				

		if (isUseCycleReferences) {
			IProjectDescription referencedDesc = referencedProject.getDescription();
			referencedDesc.setReferencedProjects(new IProject[] {myProject});
			referencedProject.setDescription(referencedDesc, null);
		}
	}
	
	@Override
	public void dispose(TestProject project) throws Exception {
		super.dispose(project);

		IProject myProject = project.getProject();
		
		IProjectDescription desc = myProject.getDescription();
		desc.setReferencedProjects(new IProject[] {});
		myProject.setDescription(desc, null);				
		
		if (isUseCycleReferences) {
			IProject referencedProject = referencedProjectTestCase.getProject();
			
			IProjectDescription referencedDesc = referencedProject.getDescription();
			referencedDesc.setReferencedProjects(new IProject[] {});
			referencedProject.setDescription(referencedDesc, null);
		}
	}

}
