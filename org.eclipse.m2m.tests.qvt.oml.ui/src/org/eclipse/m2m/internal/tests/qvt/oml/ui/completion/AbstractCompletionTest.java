/*******************************************************************************
 * Copyright (c) 2007-2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.ui.completion;


import java.util.LinkedHashSet;
import java.util.Set;

import junit.framework.TestCase;

/**
 * @author vrepeshko
 */
public abstract class AbstractCompletionTest extends TestCase {

	protected AbstractCompletionTest(final String name) {
		super(name);
	}
	
	@Override
	protected void runTest() throws Throwable {
		testCompletion();
	}
	
	public void testCompletion() throws Exception {
		
		Set<String> actualProposals = getActualProposalStrings();
		Set<String> actualProposalsTemp = new LinkedHashSet<String>(actualProposals);
		Set<String> expectedProposals = getExpectedProposalStrings();
		Set<String> expectedProposalsTemp = new LinkedHashSet<String>(expectedProposals);

		if (isStrict()) {
			actualProposalsTemp.removeAll(expectedProposals);
		} else {
			actualProposalsTemp.clear();
		}
		expectedProposalsTemp.removeAll(actualProposals);
		
		if (!actualProposalsTemp.isEmpty() || !expectedProposalsTemp.isEmpty()) {
			// We shouldn't be here
			StringBuilder errors = new StringBuilder();
			for (String proposal : expectedProposalsTemp) {
				errors.append("Expected proposal not found: " + proposal + "\n");  //$NON-NLS-1$//$NON-NLS-2$
			}
			if (isStrict()) {
				for (String proposal : actualProposalsTemp) {
					errors.append("Unexpected proposal found: " + proposal + "\n");  //$NON-NLS-1$//$NON-NLS-2$
				}
			}
			assertTrue(errors.toString(), false);
		}
	}
	
	protected abstract Set<String> getActualProposalStrings();
	protected abstract Set<String> getExpectedProposalStrings();
	protected abstract boolean isStrict();
}
