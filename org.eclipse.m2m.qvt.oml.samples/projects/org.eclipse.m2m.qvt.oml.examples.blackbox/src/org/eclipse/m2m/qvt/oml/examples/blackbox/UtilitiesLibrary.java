/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.examples.blackbox;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Parameter;
import org.eclipse.ocl.util.Bag;
import org.eclipse.ocl.util.CollectionUtil;


public class UtilitiesLibrary {
	
	public UtilitiesLibrary() {
		super();
	}

	public Date createDate(String dateStr) {
		return (Date)EcoreFactory.eINSTANCE.createFromString(EcorePackage.eINSTANCE.getEDate(), dateStr);
	}
	
	@Operation(contextual=true)
	public static boolean before(Date self, Date when) {
		return self.before(when);
	}
	
	@Operation(contextual=true)
	public static List<String> split(
			String self, 
			@Parameter(name="regexp") String regexp) {
		return CollectionUtil.createNewSequence(Arrays.asList(self.split(regexp)));
	}

	@Operation(contextual=true)
	public static String getQualifiedName(EClassifier self) {
		return self.getEPackage().getName() + "::" + self.getName();
	}

	public static Set<LinkedHashSet<List<Bag<Boolean>>>> testAllCollectionTypes(boolean element) {
		final Bag<Boolean> createNewBag = CollectionUtil.createNewBag();
		createNewBag.add(element);
		final List<Bag<Boolean>> createNewSequence = CollectionUtil.createNewSequence();
		createNewSequence.add(createNewBag);
		final LinkedHashSet<List<Bag<Boolean>>> createNewOrderedSet = CollectionUtil.createNewOrderedSet();
		createNewOrderedSet.add(createNewSequence);
		final Set<LinkedHashSet<List<Bag<Boolean>>>> result = CollectionUtil.createNewSet();
		result.add(createNewOrderedSet);
		return result;
	}
}
