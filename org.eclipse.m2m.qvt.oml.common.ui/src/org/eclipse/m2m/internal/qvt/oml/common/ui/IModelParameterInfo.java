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
package org.eclipse.m2m.internal.qvt.oml.common.ui;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

public interface IModelParameterInfo {

	public enum Direction {
		in,
		inout,
		out;
		
		public static String[] stringValues() {
			Direction[] values = values();
			String[] names = new String[values.length];
			int i = 0;
			for (Direction direction : values) {
				names[i++] = direction.name();
			}
			return names;
		}
	}

	String getName();

	EPackage getMetamodel();

	EClassifier getEntryParamType();

	String getEntryParamTypeName();

	String getModelTypeName();

	Direction getDirection();
	
	boolean isInParameter();
	
	boolean isOutParameter();
	
	boolean isInOutParameter();	
}
