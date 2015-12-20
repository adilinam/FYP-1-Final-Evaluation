/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bug 427237
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;

public interface QvtTransformation {

	public interface TransformationParameter {
		public enum DirectionKind {
			IN,
			INOUT,
			OUT;
		}

		DirectionKind getDirectionKind();
		
		/**
		 * 
		 * @return name of transformation parameter, may be empty
		 */
		String getName();

		/**
		 * 
		 * @return list of model type's metamodels
		 */
		List<EPackage> getMetamodels();
		
		/**
		 * 
		 * @return model type name
		 */
		String getModelTypeName();
		
		/**
		 * 
		 * @return type of appropriate parameter declaration in main(), may be <b>null</b>
		 */
		EClassifier getEntryType();
		
		/**
		 * 
		 * @return name of appropriate parameter declaration in main()
		 */
		String getEntryName();
	}
	
    String getModuleName() throws MdaException;
    
    URI getURI() throws MdaException;

    Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException;

    List<TransformationParameter> getParameters() throws MdaException;
    
    boolean hasEntryOperation() throws MdaException;
    
    boolean isBlackbox() throws MdaException;

    ResourceSet getResourceSet() throws MdaException;

    TransformationRunner.Out run(TransformationRunner.In in) throws MdaException;
    
    ModelContent loadInput(URI inputObjectURI) throws MdaException;
    
    void cleanup() throws MdaException;
    
}
