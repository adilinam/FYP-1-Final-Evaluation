/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * @author vrepeshko
 */
public abstract class AbstractClassifierProvider implements IClassifierProvider {

	protected AbstractClassifierProvider(final List<EPackage> rootPackages) {
		for (Iterator<EPackage> iter = rootPackages.iterator(); iter.hasNext();) {
			EPackage pack = iter.next();
			collectClassifiers(pack, myClassifiers);
		}
	}
	
	public EClassifier[] getClassifiers(final String query) {
		List<EClassifier> result = new ArrayList<EClassifier>();
		String normalizedQuery = normalizeQuery(query);
		
		if (normalizedQuery.length() > 0) {
			for (EClassifier classifier : myClassifiers) {
				if (isMatching(classifier, normalizedQuery)) {
					result.add(classifier);
				}
			}
			
			sortClassifiers(result);
		}
		return (EClassifier[]) result.toArray(new EClassifier[result.size()]); 
	}

	protected String normalizeQuery(final String query) {
		return query;
	}

	protected abstract boolean isMatching(EClassifier classifier, String query);

	protected void sortClassifiers(final List<EClassifier> result) {
		Collections.sort(result, new Comparator<EClassifier>() {
			public int compare(EClassifier c1, EClassifier c2) {
				return String.CASE_INSENSITIVE_ORDER.compare(c1.getName(), c2.getName());
			}
		});
	}
	
	private void collectClassifiers(final EPackage current, final Set<EClassifier> classifiers) {
		classifiers.addAll(current.getEClassifiers());
		for (EPackage pack : current.getESubpackages()) {
			collectClassifiers(pack, classifiers);
		}
	}
	
	private final Set<EClassifier> myClassifiers = new HashSet<EClassifier>();
	
}
