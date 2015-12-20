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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator;

/** @author pkobiakov */
public class CompareUtil {
	private CompareUtil() {}
	
	public static int compareNulls(Object leftValue, Object rightValue) {
		if(leftValue == null) {
			if(rightValue != null) {
				return -1;
			}
		}
		
		if(rightValue == null) {
			if(leftValue != null) {
				return 1;
			}
		}
		
		return 0;
	}
}
