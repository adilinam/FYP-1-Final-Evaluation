/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - Bug 376274
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.compiler.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtilPlugin;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.EmfStandaloneMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelDesc;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;

import junit.framework.TestCase;


public class TestMetamodelRegistry extends TestCase {
	private static final String METAMODEL_ID = "qvt.tests.metamodelID"; //$NON-NLS-1$
	private static final URI platformTestModelURI = URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvt.oml/models/javaless.ecore", false); //$NON-NLS-1$
	private static final String NESTED_PACKAGE_NAME = "nested"; //$NON-NLS-1$
	
	private TestProject myProject;
    private URI testEcoreFileURI;
    private MetamodelRegistry metamodelRegistry;
	
	@Override
	public void setUp() throws Exception {
		myProject = new TestProject("MModelREgistryTest", new String[] {QVTOProjectPlugin.NATURE_ID}); //$NON-NLS-1$
        
		Resource mappingResource = MetamodelURIMappingHelper.createMappingResource(myProject.getProject());
        MappingContainer allMappings = MetamodelURIMappingHelper.createNewMappings(mappingResource);
        
        URIMapping uriMapping = MModelURIMapFactory.eINSTANCE.createURIMapping();
        uriMapping.setSourceURI(METAMODEL_ID);
        
        URIMapping nestedUriMapping = MModelURIMapFactory.eINSTANCE.createURIMapping();
        nestedUriMapping.setSourceURI(METAMODEL_ID + "." + NESTED_PACKAGE_NAME);
        
        URIMapping overridingUriMapping = MModelURIMapFactory.eINSTANCE.createURIMapping();
        overridingUriMapping.setSourceURI(EcorePackage.eNS_URI);
                
        testEcoreFileURI = prepareTestMetamodel();
        uriMapping.setTargetURI(testEcoreFileURI.toString());
        nestedUriMapping.setTargetURI(platformTestModelURI.appendFragment("//" + NESTED_PACKAGE_NAME).toString());
        overridingUriMapping.setTargetURI("invalid");
        
        allMappings.getMapping().add(uriMapping);
        allMappings.getMapping().add(nestedUriMapping);
        allMappings.getMapping().add(overridingUriMapping);
        
        mappingResource.save(null);
        // TODO - should rather be MetamodelURIMappingHelper operation
        // refresh .settings folder structure        
        myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
        
        assertTrue(MetamodelURIMappingHelper.hasMappingResource(myProject.getProject()));  
        
        IMetamodelRegistryProvider.IRepositoryContext ctx = createContext();
        metamodelRegistry = new WorkspaceMetamodelRegistryProvider().getRegistry(ctx);
	}

	private IMetamodelRegistryProvider.IRepositoryContext createContext() {
		IFile projectDescFile = myProject.getProject().getFile(".project");
        URI projectDescURI = URIUtils.getResourceURI(projectDescFile);
		IMetamodelRegistryProvider.IRepositoryContext ctx = MetamodelRegistryProvider.createContext(projectDescURI);
		return ctx;
	}
	
	@Override
	public void tearDown() throws Exception {
        myProject.delete();
	}
		
	public void testProjectContextRegistration() throws Exception {
        IMetamodelRegistryProvider.IRepositoryContext ctx = createContext();

        IMetamodelDesc metamodelDesc = new WorkspaceMetamodelRegistryProvider()
        	.getRegistry(ctx).getMetamodelDesc(METAMODEL_ID);
        assertNotNull(metamodelDesc);
        
        EPackage ePackage = metamodelDesc.getModel();
        assertEquals(ePackage.eResource().getURI(), testEcoreFileURI);
    }

	public void testGlobalContextRegistration() throws Exception {
		String knownID = EcorePackage.eINSTANCE.getNsURI();
        IMetamodelDesc metamodelDesc = metamodelRegistry.getMetamodelDesc(knownID);
        assertNotNull(metamodelDesc);
        assertSame(EcorePackage.eINSTANCE, metamodelDesc.getModel());
    }
	
	public void testNestedPackageRegistration() throws Exception {
		IMetamodelRegistryProvider.IRepositoryContext ctx = createContext();
		
        IMetamodelDesc metamodelDesc = new WorkspaceMetamodelRegistryProvider()
        	.getRegistry(ctx).getMetamodelDesc(METAMODEL_ID + "." + NESTED_PACKAGE_NAME);
        assertNotNull(metamodelDesc);
        
        EPackage ePackage = metamodelDesc.getModel();
                
        assertEquals(ePackage.getName(), NESTED_PACKAGE_NAME);
    }
	
	public void testBug376644PackageRegistryFallback() throws Exception {
		IMetamodelRegistryProvider.IRepositoryContext ctx = createContext();

        IMetamodelDesc metamodelDesc = new WorkspaceMetamodelRegistryProvider()
        	.getRegistry(ctx).getMetamodelDesc(EcorePackage.eNS_URI);
        assertNotNull(metamodelDesc);
        assertTrue(EmfUtilPlugin.isSuccess(metamodelDesc.getLoadStatus()));
        
        EPackage ePackage = metamodelDesc.getModel();
        assertSame(EcorePackage.eINSTANCE, ePackage);
	}
	
	public void testBug441094DelegatePackageRegistry() {
		EPackage myEPackage = EcoreFactory.eINSTANCE.createEPackage();
		
		final String ID = "myPackageID";
		
		EPackage.Registry delegateRegistry = new EPackageRegistryImpl();
		delegateRegistry.put(ID, myEPackage);
		EPackage.Registry packageRegistry = new EPackageRegistryImpl(delegateRegistry);
						
		IMetamodelProvider provider = new EmfStandaloneMetamodelProvider(packageRegistry);
		MetamodelRegistry metaRegistry = new MetamodelRegistry(provider);
				
		EPackage result = metaRegistry.toEPackageRegistry().getEPackage(ID);
		assertSame(myEPackage, result);
	}
	
	public void testBug326651UpdateMetamodel() throws Exception {
		
		final String ID = "myPackageID";
		EPackage p1 = EcoreFactory.eINSTANCE.createEPackage();
		EPackage p2 = EcoreFactory.eINSTANCE.createEPackage();
		
		EPackage.Registry packageRegistry = new EPackageRegistryImpl();
		packageRegistry.put(ID, p1);
		
		MetamodelRegistry registry = new MetamodelRegistry(new EmfStandaloneMetamodelProvider(packageRegistry));
		
		IMetamodelDesc desc = registry.getMetamodelDesc(ID);
		assertSame(p1, desc.getModel());
		
		packageRegistry.put(ID, p2);
		
		desc = registry.getMetamodelDesc(ID);
		assertSame(p2, desc.getModel());
		
	}
	
	public void testBug435699IllegalRegistration() throws Exception {
		
		final String ID = "myPackageID";
		
		EPackage.Descriptor descriptor = new EPackage.Descriptor() {
			
			public EPackage getEPackage() {
				throw new UnsupportedOperationException();
			}
			
			public EFactory getEFactory() {
				return null;
			}
		};
		
		EPackage.Registry packageRegistry = new EPackageRegistryImpl();
		packageRegistry.put(ID, descriptor);
		
		MetamodelRegistry registry = new MetamodelRegistry(new EmfStandaloneMetamodelProvider(packageRegistry));
		
		IMetamodelDesc desc = registry.getMetamodelDesc(ID);
				
		assertNotNull(desc);
		assertTrue(desc.getLoadStatus().getSeverity() == Diagnostic.ERROR);
		
		try {
			registry.getMetamodelDesc("unregisteredID");
			fail();
		}
		catch(EmfException e) {
			// succeed;
		}
		
	}
	
	private URI prepareTestMetamodel() throws IOException {
		IFile ecoreFile = myProject.project.getFile("javaless.ecore"); //$NON-NLS-1$
        URI uri = URI.createPlatformResourceURI(ecoreFile.getFullPath().toString(), false);
		
        Resource testMetamodelUri = new ResourceSetImpl().getResource(platformTestModelURI, true);
		testMetamodelUri.setURI(uri);
		testMetamodelUri.save(null);
		
		return uri;
	}	
}
