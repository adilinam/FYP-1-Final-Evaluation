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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;


/**
 * @author vrepeshko
 */
public class ComplexClassifierProvider extends AbstractClassifierProvider implements IClassifierProvider {

	public ComplexClassifierProvider(final List<EPackage> rootPackages) {
		super(rootPackages);
	}
	
	@Override
	protected String normalizeQuery(final String query) {
		StringBuffer result = new StringBuffer();
		
		String[] parts = query.split(EmfUtil.PATH_SEPARATOR);
		for (int i = 0; i < parts.length; i++) {
			result.append(parts[i].trim());
			if (i != parts.length - 1) {
				result.append(EmfUtil.PATH_SEPARATOR);
			}
		}
		
		// check if first part is empty and add a separator after it
		if (query.startsWith(EmfUtil.PATH_SEPARATOR)) {
			result.insert(0, EmfUtil.PATH_SEPARATOR);
		}
		
		// check if last part is empty and add a separator before it
		if (query.endsWith(EmfUtil.PATH_SEPARATOR)) {
			result.append(EmfUtil.PATH_SEPARATOR);
		}
		
		return result.toString();
	}
	
	@Override
	protected boolean isMatching(final EClassifier classifier, final String query) {
		final int index = query.lastIndexOf(EmfUtil.PATH_SEPARATOR);
		
		// no package part
		if (index == -1) {
			return isMatchingClassifier(classifier, query);
		}
		
		String packageQuery = query.substring(0, index);
		String classifierQuery = query.substring(index + EmfUtil.PATH_SEPARATOR.length());
		
		return isMatchingClassifier(classifier, classifierQuery) 
			&& isMatchingPackage(classifier.getEPackage(), packageQuery);
	}

	protected boolean isMatchingPackage(final EPackage ePackage, final String packageQuery) {
		return matches(EmfUtil.getFullName(ePackage), packageQuery, false);
	}

	protected boolean isMatchingClassifier(final EClassifier classifier, final String classifierQuery) {
		return matches(classifier.getName(), classifierQuery, true);
	}
	
	protected boolean matches(final String str, final String pattern, final boolean prefix) {
		String string = (str == null) ? "" : str; //$NON-NLS-1$
		
		List<String> parts = new ArrayList<String>(Arrays.asList(pattern.split("\\*"))); //$NON-NLS-1$

		if (pattern.startsWith("*")) { //$NON-NLS-1$
			parts.add(0, ""); //$NON-NLS-1$
		}
		if (pattern.endsWith("*")) { //$NON-NLS-1$
			parts.add(""); //$NON-NLS-1$
		}
		
		int offset = 0;
		boolean firstPart = true;
		
		for (Iterator<String> iter = parts.iterator(); iter.hasNext(); firstPart = false) {
			String part = (String) iter.next();
			boolean found = false;
			
			while (!found) {
				int index = 0;
				for (; index < part.length(); index++) {
					if (offset + index >= string.length()) {
						return false;
					}
					
					char pc = Character.toLowerCase(part.charAt(index));
					char sc = Character.toLowerCase(string.charAt(offset + index));
					if (pc == '?') {
						// skip
					} else if (pc != sc) {
						if (firstPart) {
							return false;
						}
						offset++;
						break;
					}
				}
				found = (index == part.length());
			}
			
			offset += part.length();
			
			// empty last part matches all remaining chars
			if (part.length() == 0 && !iter.hasNext()) {
				offset = string.length();
			}
		}
		
		return prefix || offset == string.length();
	}
	
}
