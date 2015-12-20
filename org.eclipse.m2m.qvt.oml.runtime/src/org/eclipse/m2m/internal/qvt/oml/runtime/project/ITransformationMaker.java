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
 *******************************************************************************/
/**
 * 
 */
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;


public interface ITransformationMaker {
	
	QvtTransformation makeTransformation(URI uri) throws MdaException;

	void cleanup() throws MdaException;
	
	
	class CachedTransformationMaker implements ITransformationMaker {

    	private Map<URI, QvtTransformation> transformationsMap = new HashMap<URI, QvtTransformation>();
    	
		public QvtTransformation makeTransformation(URI uri) throws MdaException {
			
			QvtTransformation transformation = transformationsMap.get(uri);			
			if (transformation == null) {
				QvtModule qvtModule = TransformationUtil.getQvtModule(uri);
				transformation = new QvtInterpretedTransformation(qvtModule);
				transformationsMap.put(uri, transformation);
			}			
			return transformation;
		}
		
		public void cleanup() throws MdaException {
			for (QvtTransformation transformation : transformationsMap.values()) {
				transformation.cleanup();
			}
			transformationsMap.clear();
		}
	}
	
}