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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.emf;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/** @author pkobiakov */
public class Util {
	private Util() {}
	
	public static String toString(EObject obj) {
		return toString(obj, false);
	}
	
	public static String toString(EObject obj, boolean skipRefs) {
		StringBuffer s = new StringBuffer();
		for(Iterator<?> featureIt = obj.eClass().getEAllStructuralFeatures().iterator(); featureIt.hasNext(); ) {
			EStructuralFeature feature = (EStructuralFeature)featureIt.next();
			if(feature.isDerived()) {
				continue;
			}
			
			if(feature instanceof EReference) {
				EReference refFeature = (EReference)feature;
				if(refFeature.isContainment()) {
					continue;
				}
				if(skipRefs) {
					continue;
				}
				//System.err.println("reference=" + refFeature);
			}
			
			Object value = obj.eGet(feature);
			Object defaultValue = feature.getDefaultValue(); 
			if(defaultValue == null) {
				if(value == null) {
					continue;
				}
				
				if(value instanceof List<?> && ((List<?>)value).isEmpty()) {
					continue;
				}
			}
			else {
				if(defaultValue.equals(value)) {
					continue;
				}
			}
			
			String valueString = getStringValue(value);

			if(s.length() > 0) {
				s.append(";"); //$NON-NLS-1$
			}
			s.append(feature.getName()).append("=").append(valueString); //$NON-NLS-1$
		}
		
		return obj.eClass().getName() + "(" + s.toString() + ")";  //$NON-NLS-1$ //$NON-NLS-2$
	}

	private static String getStringValue(Object value) {
		String valueString;
		
		if(value == null) {
			valueString = "" + null; //$NON-NLS-1$
		}
		else if(value instanceof EObject) {
			valueString = value.toString(); // Util.toString((EObject)value, true);
		}
		else if(value instanceof List<?>) {
			valueString = ""; //$NON-NLS-1$
			for(Iterator<?> compIt = ((List<?>)value).iterator(); compIt.hasNext(); ) {
				Object comp = compIt.next();
				if(valueString.length() > 0) {
					valueString += ","; //$NON-NLS-1$
				}
				valueString += comp instanceof EObject ? comp.toString() : getStringValue(comp); //Util.toString((EObject)comp) : getStringValue(comp);
			}
		}
		else {
			 valueString = value.toString();
		}
		
		return valueString;
	}
	
	public static String toStringList(List<?> objs) {
		StringBuffer s = new StringBuffer();
		for(Iterator<?> objIt = objs.iterator(); objIt.hasNext(); ) {
			EObject obj = (EObject)objIt.next();
			s.append(obj.eClass().getName()).append(","); //$NON-NLS-1$
		}
		return "[" + s.toString() + "]";  //$NON-NLS-1$//$NON-NLS-2$
	}
}
