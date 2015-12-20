/*******************************************************************************
 * Copyright (c) 2009, 2014 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - Bug394188
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.compile;

import java.io.BufferedReader;
import java.io.File;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.URIUnitResolver;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitContents;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.osgi.framework.Bundle;

import junit.framework.TestCase;

/**
 * @author dvorak
 */
public class URIUnitResolverTest extends TestCase {
	
	private static final URI TEST_UNIT_PLUGIN_URI = URI.createPlatformPluginURI(
			"/" + AllTests.BUNDLE_ID +"/deployed/org/eclipse/Foo.qvto", true);
	
	
	public URIUnitResolverTest(String name) {
		super(name);
	}
	
	public void testBaseAndNamespace() throws Exception {
		URI baseURI = URI.createPlatformPluginURI(AllTests.BUNDLE_ID, true);
		
		URIUnitResolver resolver = new URIUnitResolver(Collections.singletonList(baseURI));
		UnitProxy unit = resolver.resolveUnit("deployed.org.eclipse.Foo");
		assertNotNull(unit);
		assertContents(unit);
		
		assertEquals("deployed.org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(TEST_UNIT_PLUGIN_URI, //$NON-NLS-1$
				unit.getURI());		
	}
	
	public void testNamespace() throws Exception {
		URI baseURI = URI.createPlatformPluginURI(AllTests.BUNDLE_ID + "/deployed", true);
		
		URIUnitResolver resolver = new URIUnitResolver(Collections.singletonList(baseURI));
		
		UnitProxy unit = resolver.resolveUnit("org.eclipse.Foo");
		assertEquals("org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(TEST_UNIT_PLUGIN_URI, //$NON-NLS-1$
				unit.getURI());
		assertContents(unit);		
	}

	public void testDefaultNamespace() throws Exception {
		URI baseURI = URI.createPlatformPluginURI(AllTests.BUNDLE_ID + "/deployed/org/eclipse", true);
		
		URIUnitResolver resolver = new URIUnitResolver(Collections.singletonList(baseURI));
		
		UnitProxy unit = resolver.resolveUnit("Foo");
		assertNull(unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(TEST_UNIT_PLUGIN_URI, //$NON-NLS-1$
				unit.getURI());
		assertContents(unit);		
	}
	
	public void testTrailPathSepBaseAndNamespace() throws Exception {
		URI baseURI = URI.createURI(URI.createPlatformPluginURI(AllTests.BUNDLE_ID, true).toString() + "/");
		
		URIUnitResolver resolver = new URIUnitResolver(Collections.singletonList(baseURI));
		UnitProxy unit = resolver.resolveUnit("deployed.org.eclipse.Foo");
		assertNotNull(unit);
		
		assertEquals("deployed.org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(TEST_UNIT_PLUGIN_URI, //$NON-NLS-1$
				unit.getURI());
		
	}
	
	public void testUnresolvedByURI() throws Exception {
		URI baseURI = URI.createURI(URI.createPlatformPluginURI(AllTests.BUNDLE_ID, true).toString());		
		URIUnitResolver resolver = new URIUnitResolver(Collections.singletonList(baseURI));
		
		String notExisting = "I'm Not there";
		assertNull(resolver.resolveUnit(notExisting));		
		assertNull(UnitResolverFactory.Registry.INSTANCE.getUnit(URI.createURI(notExisting)));		
	}	
	
	public void testFileURI() throws Exception {
		Bundle testBundle = Platform.getBundle(AllTests.BUNDLE_ID);
		File bundleFile = FileLocator.getBundleFile(testBundle);
		assertNotNull(bundleFile);
		
		URI baseURI = URI.createURI(bundleFile.toURI().toString());
		assertEquals("file", baseURI.scheme());

		URIUnitResolver resolver = new URIUnitResolver(baseURI);
		UnitProxy unit = resolver.resolveUnit("deployed.org.eclipse.Foo");
		
		assertNotNull(unit);
		assertContents(unit);
		
		assertEquals("deployed.org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
	
		// test direct unit proxy constructor for a URI
		if(baseURI.hasTrailingPathSeparator()) {
			baseURI = baseURI.trimSegments(1);
		}
		assertEquals(baseURI.appendSegments(new String[] { "deployed", "org", "eclipse", "Foo.qvto"}),				
				unit.getURI());
		
		UnitProxy unitByURI = UnitResolverFactory.Registry.INSTANCE.getUnit(unit.getURI());		
		assertNotNull(unitByURI);		
		assertContents(unitByURI);
		assertEquals(unit.getURI(), unitByURI.getURI());		
		
		// expect default namespace as we had no knowledge about
		assertNull(unitByURI.getNamespace());
		assertEquals(unitByURI.getName(), unitByURI.getQualifiedName());
	}

	private static void assertContents(UnitProxy unit) throws Exception {
		UnitContents contents = unit.getContents();
		assertTrue(contents instanceof UnitContents.CSTContents);
		UnitContents.CSTContents cst = (UnitContents.CSTContents) contents;
		BufferedReader reader = new BufferedReader(cst.getContents());
		while(reader.readLine() != null) {
			// do nothing but read all contents
		}
	}
}
