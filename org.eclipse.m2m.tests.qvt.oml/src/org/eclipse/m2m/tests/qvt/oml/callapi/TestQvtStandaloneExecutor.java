/*******************************************************************************
 * Copyright (c) 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Christopher Gerking - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

public class TestQvtStandaloneExecutor extends TestQvtExecutor {
	
	private ModelTestData data;
	
	public TestQvtStandaloneExecutor(ModelTestData data) {
		super(data);
		this.data = data;
		uriCreator = new FileUriCreator(data.getName());
	}
	
	@Override
	protected void setUp() {
		data.prepare(TransformationExecutor.BlackboxRegistry.INSTANCE);	
		super.setUp();
	}
	
	@Override
	protected ResourceSet createResourceSet() {
		ResourceSet rs = super.createResourceSet();
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
    	return rs;
	}
	
	protected ResourceSet getMetamodelResolutionRS() {
		ResourceSet rs = super.getMetamodelResolutionRS();
		
		for(String modelString : inModels) {
			String fileExtension = modelString.substring(modelString.lastIndexOf(".") + 1);
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, new XMIResourceFactoryImpl());
		}
		
		for(String modelString : outModels) {
			String fileExtension = modelString.substring(modelString.lastIndexOf(".") + 1);
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, new XMIResourceFactoryImpl());
		}
			
		for(EPackage pack : data.getUsedPackages()) {
			rs.getPackageRegistry().put(pack.getNsURI(), pack);
		}
				
		return rs;
	}
	
	static class FileUriCreator extends UriCreator {
		
		FileUriCreator(String name) {
			super(name);
		}
		
		URI getTransformationUri() {
			return URI.createFileURI(new File("").getAbsolutePath()).appendSegment(getTestDataFolder()).appendSegment(ModelTestData.MODEL_FOLDER).appendSegment(getName()).appendSegment(getName()).appendFileExtension(MDAConstants.QVTO_FILE_EXTENSION);
		}
		
		URI getModelUri(String name) {
			return URI.createFileURI(new File("").getAbsolutePath()).appendSegment(getTestDataFolder()).appendSegment(ModelTestData.MODEL_FOLDER).appendSegment(getName()).appendSegment(name);
		}
		
		URI getTraceUri() {
			return URI.createFileURI(new File("").getAbsolutePath()).appendSegment(getTestDataFolder()).appendSegment(ModelTestData.MODEL_FOLDER).appendSegment(getName()).appendSegment(getName()).appendFileExtension(MDAConstants.QVTO_TRACEFILE_EXTENSION);
		}
		
	}
	
}
