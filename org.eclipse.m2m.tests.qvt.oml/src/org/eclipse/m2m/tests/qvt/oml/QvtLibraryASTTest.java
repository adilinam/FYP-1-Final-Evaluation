/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.tests.qvt.oml.ParserTests.TestData;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;


public class QvtLibraryASTTest extends TestQvtParser {
	
	private static final String TEST_NAME = "blackboxlibASTmodel"; //$NON-NLS-N$

	private static TestData createTestData() {
		return new TestData(TEST_NAME, 0, 0);
	}
	
	public QvtLibraryASTTest(String testName) {		
		super(createTestData());
		assertEquals(TEST_NAME, testName);
	}
		
	public QvtLibraryASTTest() {
		super(createTestData()); //$NON-NLS-1$
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
	}
		    
	@Override
	public void runTest() throws Exception {
		super.runTest();
				
		checkLibrary((Library)QvtOperationalStdLibrary.INSTANCE.getStdLibModule());
		EList<ModuleImport> moduleImports = getCompiledResults()[0].getModules().get(0).getModuleImport();		
		assertEquals(moduleImports.size(), 2);
		
		for (ModuleImport nextImport : moduleImports) {
			checkLibrary((Library)nextImport.getImportedModule());
		}
	}
	
	private void checkLibrary(Library library) {
		File libFile = new File(getDestinationFolder(), library.getName());
		TestUtil.assertPersistableAST(QvtOperationalStdLibrary.INSTANCE.getStdLibModule(), 
				URI.createURI(libFile.toURI().toString(), true)); //$NON-NLS-1$
		
		assertTrue("library file " + libFile + " must have been saved", libFile.exists()); //$NON-NLS-1$		
	}
}
