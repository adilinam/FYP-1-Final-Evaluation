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
package org.eclipse.m2m.tests.qvt.oml.ocl2qvt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.OCLEnvironmentWithQVTAccessFactory;

import junit.framework.TestCase;

public class OCLEnvWithQVTAccessDiagnosticTest extends TestCase {

	public OCLEnvWithQVTAccessDiagnosticTest() {
		super();
	}
	
	public void testCSTAndBlackboxSuccess() throws Exception {
		Diagnostic diagnostic = createFactoryDiagnostic(
			"qvto://blackbox/org.eclipse.m2m.tests.qvt.oml.bbox.SimpleJavaLibrary",
			"qvto://blackbox/org.bar.Foo",
			"platform:/plugin/org.eclipse.m2m.tests.qvt.oml/parserTestData/externlib/successLib.qvto");
		assertTrue(diagnostic.getSeverity() == Diagnostic.OK);
	}
	
	public void testCompilationErrors() throws Exception {
		String uri = "platform:/plugin/org.eclipse.m2m.tests.qvt.oml/parserTestData/externlib/errorsLib.qvto";
		Diagnostic diagnostic = createFactoryDiagnostic(uri);
		assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);
		List<Diagnostic> children = diagnostic.getChildren();
		assertFalse(children.isEmpty());
		assertEquals(uri, children.get(0).getSource());
	}

	public void testUnresolved() throws Exception {
		String badURI = "platform:/plugin/never.exist";
		String okURI = "qvto://blackbox/org.eclipse.m2m.tests.qvt.oml.bbox.SimpleJavaLibrary";
		Diagnostic diagnostic = createFactoryDiagnostic(okURI, badURI);
		assertTrue(diagnostic.getSeverity() == Diagnostic.ERROR);
		List<Diagnostic> children = diagnostic.getChildren();
		assertEquals(1, children.size());
		assertEquals(badURI, children.get(0).getData().get(0).toString());
	}	
	
	
	private static Diagnostic createFactoryDiagnostic(String... uriStr) {
		List<URI> uris = new ArrayList<URI>();
		for (String string : uriStr) {
			uris.add(URI.createURI(string));
		}
		return new OCLEnvironmentWithQVTAccessFactory(uris).getDiagnostic();
	}
}
