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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.edit;

/**
 * @author pkobiakov
 */
public interface TreeEdit {
	public int getCost();
	
	public static final int DELETE_INSERT_COST = 1000;
	public static final int UNWANTED_CHANGE_COST = 1000000;
	
	TreeEdit NULL_EDIT = new TreeEdit() {
		public int getCost() {
			return 0;
		}
	};
}
