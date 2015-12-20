/*******************************************************************************
 * Copyright (c) 2007, 2012 Borland Software Corporation and others.
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

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * @author vrepeshko
 */
public class CompletionTestDataCreator extends CompletionTest {

	public CompletionTestDataCreator(final String folder) {
		super(folder);
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		
		File proposalsFile = getExpectedProposalsFile();
		File folder = proposalsFile.getParentFile();
		File updateMarkerFile = new File(folder, ICompletionTestConstants.UPDATE_MARKER_FILE);
		
		if (updateMarkerFile.exists()) {
			PrintWriter writer = new PrintWriter(new FileWriter(getExpectedProposalsFile()));
			try {
				writer.print(myProposalBuffer);
				writer.flush();
				System.err.println(folder.getName() + "/" + proposalsFile.getName() + " - updated"); //$NON-NLS-1$ //$NON-NLS-2$
			} finally {
				try {
					writer.close();
				} catch (Exception ex) {
					// ignore
				}
			}
			updateMarkerFile.delete();
		}
	}
	
	private final StringBuffer myProposalBuffer = new StringBuffer();

}
