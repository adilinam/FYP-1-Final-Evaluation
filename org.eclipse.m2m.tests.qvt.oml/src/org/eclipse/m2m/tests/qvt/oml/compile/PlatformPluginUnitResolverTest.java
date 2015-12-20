/*******************************************************************************
 * Copyright (c) 2009, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.compile;

import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.PlatformPluginUnitResolver;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.osgi.framework.Bundle;

import junit.framework.TestCase;

/**
 * @author dvorak
 */
public class PlatformPluginUnitResolverTest extends TestCase {

	private Bundle fBundle;
	
	public PlatformPluginUnitResolverTest(String name) {
		super(name);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		fBundle = Platform.getBundle(AllTests.BUNDLE_ID);
		assertNotNull(fBundle);
	}

	public void testInRootUnitResolver() throws Exception {
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(fBundle);
		UnitProxy unit = resolver.resolveUnit("deployed.org.eclipse.Foo");
		assertResolvedCompiledUnit(unit);
		
		assertEquals("deployed.org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(URI.createPlatformPluginURI("/org.eclipse.m2m.tests.qvt.oml/deployed/org/eclipse/Foo.qvto", false), //$NON-NLS-1$
				unit.getURI());
		assertNotNull(unit);
	}
	
	public void testInContainerUnitResolver() throws Exception {
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(fBundle, new Path("deployed"));
		UnitProxy unit = resolver.resolveUnit("org.eclipse.Foo");
		assertResolvedCompiledUnit(unit);
		
		assertEquals("org.eclipse", unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(URI.createPlatformPluginURI("/org.eclipse.m2m.tests.qvt.oml/deployed/org/eclipse/Foo.qvto", false), //$NON-NLS-1$
				unit.getURI());
		assertNotNull(unit);
	}

	public void testUnresolvedUnit() throws Exception {
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(fBundle, new Path("deployed"));
		UnitProxy unit = resolver.resolveUnit("org.eclipse.Foo_xxxxxxx");
		assertNull(unit);
	}	
	
	public void testDefaultNSUnitResolver() throws Exception {
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(fBundle, new Path("deployed/org/eclipse"));
		UnitProxy unit = resolver.resolveUnit("Foo"); //$NON-NLS-1$
		assertResolvedCompiledUnit(unit);
		
		assertNull(unit.getNamespace());
		assertEquals("Foo", unit.getName());
		assertEquals(URI.createPlatformPluginURI("/org.eclipse.m2m.tests.qvt.oml/deployed/org/eclipse/Foo.qvto", false), //$NON-NLS-1$
				unit.getURI());
		assertNotNull(unit);
	}
	
	public void testCrossNSUnitResolver() throws Exception {
		PlatformPluginUnitResolver resolver = new PlatformPluginUnitResolver(fBundle, new Path("/deployed"));
		PlatformPluginUnitResolver.setupResolver(resolver, true, true);
		
		UnitProxy unit = resolver.resolveUnit("a.b.Foo"); //$NON-NLS-1$
		assertResolvedCompiledUnit(unit);
		
		assertEquals("a.b", unit.getNamespace()); //$NON-NLS-1$
		assertEquals("Foo", unit.getName()); //$NON-NLS-1$
		assertEquals(URI.createPlatformPluginURI("/org.eclipse.m2m.tests.qvt.oml/deployed/a/b/Foo.qvto", false), //$NON-NLS-1$
				unit.getURI());
		assertNotNull(unit);
	}
	
	public void testUnitAccessByURI() throws Exception {
		URI uri = URI.createPlatformPluginURI("/org.eclipse.m2m.tests.qvt.oml/deployed/a/T1.qvto", false);
		
		UnitProxy unit = UnitResolverFactory.Registry.INSTANCE.getUnit(uri);
		assertResolvedCompiledUnit(unit);

		// deployed included in the namespace as we have not any container info passed
		assertEquals("deployed.a", unit.getNamespace()); //$NON-NLS-1$
		assertEquals("T1", unit.getName()); //$NON-NLS-1$

		assertEquals(uri, unit.getURI());
		assertNotNull(unit);
	}

	
	private void assertResolvedCompiledUnit(UnitProxy unit) {
		assertNotNull("Unit must be resolved", unit); //$NON-NLS-1$
		QVTOCompiler compiler = CompilerUtils.createCompiler();
		try {
			CompiledUnit compiledUnit = compiler.compile(unit, null, null);
			assertTrue("Unit must not have compilation problems", compiledUnit.getProblems().isEmpty());
		} catch (MdaException e) {
			fail(e.getLocalizedMessage());
		}
	}
	

}
