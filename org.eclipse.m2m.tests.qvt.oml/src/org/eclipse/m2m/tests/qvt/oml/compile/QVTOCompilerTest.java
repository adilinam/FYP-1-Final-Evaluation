/*******************************************************************************
 * Copyright (c) 2015 Y.Blankenstein and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Yuri Blankenstein - Compiler with history 
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.compile;

import java.io.BufferedReader;
import java.util.Collections;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.URIUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.tests.qvt.oml.AllTests;

import junit.framework.TestCase;

/**
 * @author yblanken
 */
public class QVTOCompilerTest extends TestCase {

	private static final Monitor NULL_MONITOR = BasicMonitor.toMonitor(new NullProgressMonitor());

	URIUnitResolver fResolver;

	public QVTOCompilerTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		URI baseURI = URI.createPlatformPluginURI(AllTests.BUNDLE_ID, true);
		fResolver = new URIUnitResolver(Collections.singletonList(baseURI));
	}

	public void testCreateCompiler() throws Exception {
		UnitProxy fooUnit = fResolver.resolveUnit("deployed.org.eclipse.Foo");
		assertNotNull(fooUnit);
		assertContents(fooUnit);

		UnitProxy barUnit = fResolver.resolveUnit("deployed.org.eclipse.Bar");
		assertNotNull(barUnit);
		assertContents(barUnit);

		QVTOCompiler compiler = QVTOCompiler.createCompiler(EPackage.Registry.INSTANCE);
		try {
			CompiledUnit foo = compiler.compile(fooUnit, null, NULL_MONITOR);
			assertNotNull(foo);
			assertNotNull(foo.getCompiledImports());
			assertEquals(1, foo.getCompiledImports().size());

			CompiledUnit bar = compiler.compile(barUnit, null, NULL_MONITOR);
			assertNotNull(bar);
			assertNotNull(bar.getCompiledImports());
			assertEquals(1, bar.getCompiledImports().size());

			assertNotSame(foo.getCompiledImports().get(0), bar.getCompiledImports().get(0));
		} finally {
			compiler.cleanup();
		}
	}

	public void testCreateCompilerWithHistory() throws Exception {
		UnitProxy fooUnit = fResolver.resolveUnit("deployed.org.eclipse.Foo");
		assertNotNull(fooUnit);
		assertContents(fooUnit);

		UnitProxy barUnit = fResolver.resolveUnit("deployed.org.eclipse.Bar");
		assertNotNull(barUnit);
		assertContents(barUnit);

		QVTOCompiler compiler = QVTOCompiler.createCompilerWithHistory(null);
		try {
			CompiledUnit foo = compiler.compile(fooUnit, null, NULL_MONITOR);
			assertNotNull(foo);
			assertNotNull(foo.getCompiledImports());
			assertEquals(1, foo.getCompiledImports().size());

			CompiledUnit bar = compiler.compile(barUnit, null, NULL_MONITOR);
			assertNotNull(bar);
			assertNotNull(bar.getCompiledImports());
			assertEquals(1, bar.getCompiledImports().size());

			assertSame(foo.getCompiledImports().get(0), bar.getCompiledImports().get(0));
		} finally {
			compiler.cleanup();
		}
	}

	private static void assertContents(UnitProxy unit) throws Exception {
		UnitContents contents = unit.getContents();
		assertTrue(contents instanceof UnitContents.CSTContents);
		UnitContents.CSTContents cst = (UnitContents.CSTContents) contents;
		BufferedReader reader = new BufferedReader(cst.getContents());
		while (reader.readLine() != null) {
			// do nothing but read all contents
		}
	}
}
