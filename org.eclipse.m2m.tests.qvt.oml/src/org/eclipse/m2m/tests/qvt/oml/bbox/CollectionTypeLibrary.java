/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.bbox;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.m2m.internal.qvt.oml.stdlib.MutableListImpl;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;


public class CollectionTypeLibrary {
	
	public CollectionTypeLibrary() {
		 super();
	}
		
	@Operation (kind=Kind.HELPER, contextual = true)
	public <T> Collection<T> commonCollectionOperation(Collection<T> self) {
		return new MutableListImpl<T>();
	}
	
	@Operation (kind=Kind.OPERATION, contextual = true)
	public <T> Set<T> setOperation(Set<T> self) {
		return new HashSet<T>();
	}	
	
	
	@Operation (kind=Kind.QUERY, contextual = true)
	public String stringCollectionAny(Collection<String> self) {
		return self.iterator().next();
	}	
}
