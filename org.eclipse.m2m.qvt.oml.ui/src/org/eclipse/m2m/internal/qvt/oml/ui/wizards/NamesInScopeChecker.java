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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class NamesInScopeChecker {

	protected NamesInScopeChecker() {
		super();
	}
	
	protected abstract boolean isDefined(String newName);
	
	protected abstract void doDefine(String newName);	

	/**
	 * @return <code>true</code> if newly defined, <code>false</code>if
	 *         such it was defined already
	 */
	public boolean defineName(String name) {
		if(name == null) {
			throw new IllegalArgumentException();
		}
		
		if(isDefined(name)) {
			return false;
		}

		doDefine(name);
		return true;
	}
	
	public String checkedDefineName(String name) {
		if(defineName(name)) {
			return name;
		}
		
		final int MAX_TRIALS_COUNT = 200;
		for (int i = 1; i < MAX_TRIALS_COUNT; i++) {
			String newName = name + i;
			if(defineName(newName)) {
				return newName;
			}
		}

		return name;
	}
	
	public static class UniqueNameSet extends NamesInScopeChecker {
		
		private Set<String> definedNames;
				
		public UniqueNameSet() {
			definedNames = new HashSet<String>(5);
		}
		
		public UniqueNameSet(String[] initialNames) {
			definedNames = new HashSet<String>(Arrays.asList(initialNames));
		}		
		
		@Override
		protected void doDefine(String newName) {
			definedNames.add(newName);			
		}
		
		@Override
		protected boolean isDefined(String newName) {		
			return definedNames.contains(newName);
		}
	}
}