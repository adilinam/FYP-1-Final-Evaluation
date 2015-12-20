/*******************************************************************************
 * Copyright (c) 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Boyko Sergey - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.qvt.oml.util.Trace;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

import junit.framework.TestCase;

public class IncrementalUpdateExecutorTest extends TransformationExecutorTest {
	
	public IncrementalUpdateExecutorTest() {
		super("bug463572", Arrays.asList("in.ecore"), Arrays.asList("expected.ecore")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	@Override
	protected void setUp() {
		super.setUp();
		executionContext.getSessionData().setValue(QVTEvaluationOptions.INCREMENTAL_UPDATE_TRACE, Trace.createEmptyTrace());
	}
	
	@Override
	protected void runTest() throws Throwable {
		// 1. pass - create output model and appropriate trace
		super.runTest();
		
		Resource outResource = resSet.createResource(URI.createURI("output:/expected.ecore")); //$NON-NLS-1$
		outResource.getContents().addAll(extents.get(1).getContents());
		List<EObject> outObjects = new ArrayList<EObject>(outResource.getContents());
		
		
		// 2. pass - update output model in context of existing trace
		super.runTest();
		
		TestCase.assertEquals("IncUpdate should not change objects", outObjects.size(), extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size(); ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		
		
		// 3. pass - repeat previous
		super.runTest();
		
		TestCase.assertEquals("IncUpdate should not change objects", outObjects.size(), extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size(); ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		
		
		// 4. pass - add new package to the input (at tail)
		extents.get(0).add(EcoreFactory.eINSTANCE.createEPackage());
		
		super.runTest();
		
		TestCase.assertEquals("IncUpdate should update output", outObjects.size()+1, extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size()-1; ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		List<EObject> content = extents.get(1).getContents();
		TestCase.assertEquals("IncUpdate should not change objects resource", content.get(content.size()-1).eResource(), null);
		
		ECollections.setEList(outResource.getContents(), extents.get(1).getContents());
		outObjects = new ArrayList<EObject>(outResource.getContents());
		
		
		// 5. pass - repeat previous
		super.runTest();
		
		TestCase.assertEquals("IncUpdate should update output", outObjects.size(), extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size(); ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}

		
		// 6. pass - add new package to the input (at head)
		content = new ArrayList<EObject>();
		content.add(EcoreFactory.eINSTANCE.createEPackage());
		content.addAll(extents.get(0).getContents());
		extents.get(0).setContents(content);
		
		super.runTest();
		
		TestCase.assertEquals("IncUpdate should update output", outObjects.size()+1, extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size()-1; ++i) {
			EObject o = extents.get(1).getContents().get(i+1);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		
		
		// 7. pass - remove newly added packages
		content = new ArrayList<EObject>(extents.get(0).getContents());
		content.remove(content.size()-1);
		content.remove(0);
		extents.get(0).setContents(content);
		
		super.runTest();
		
		outObjects.remove(outObjects.size()-1);
		
		TestCase.assertEquals("IncUpdate should update output", outObjects.size(), extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size(); ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		
		ECollections.setEList(outResource.getContents(), extents.get(1).getContents());
		outObjects = new ArrayList<EObject>(outResource.getContents());

	
		// 8. pass - remove nested classifier (at tail)
		outResource.eAdapters().add(fAdapter);
		outResource.eSetDeliver(true);
		
		EList<EClassifier> eClassifiers = ((EPackage) extents.get(0).getContents().get(0)).getEClassifiers();
		EClassifier removedCls = eClassifiers.remove(eClassifiers.size()-1);
		
		super.runTest();
		
		outObjects.remove(outObjects.size()-1);
		
		TestCase.assertEquals("IncUpdate should update output", outObjects.size(), extents.get(1).getContents().size());
		for (int i = 0; i < extents.get(1).getContents().size(); ++i) {
			EObject o = extents.get(1).getContents().get(i);
			EObject oOut = outObjects.get(i);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}		
		TestCase.assertEquals(fNotifications.size(), 2);
		TestCase.assertEquals(fNotifications.get(0).getEventType(), Notification.SET);
		TestCase.assertEquals(fNotifications.get(0).getFeature(), EcorePackage.eINSTANCE.getEClassifier_EPackage());
		TestCase.assertEquals(fNotifications.get(0).getNewValue(), null);
		TestCase.assertEquals(fNotifications.get(1).getEventType(), Notification.REMOVE);
		TestCase.assertEquals(fNotifications.get(1).getFeature(), EcorePackage.eINSTANCE.getEPackage_EClassifiers());
		TestCase.assertEquals(fNotifications.get(1).getNewValue(), null);
		
		fNotifications.clear();
		
		
		// 9. pass - add nested classifier (at head)
		eClassifiers.add(0, removedCls);
		
		super.runTest();

		TestCase.assertEquals("IncUpdate should update output", outObjects.size()+1, extents.get(1).getContents().size());
		{
			EObject o = extents.get(1).getContents().get(0);
			EObject oOut = outObjects.get(0);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		{
			EObject o = extents.get(1).getContents().get(extents.get(1).getContents().size()-1);
			EObject oOut = outObjects.get(outObjects.size()-1);
			ModelTestData.assertEquals("IncUpdate should not change objects or their order", o, oOut);
			TestCase.assertEquals("IncUpdate should not change objects resource", o.eResource(), outResource);
		}
		TestCase.assertEquals(fNotifications.size(), 1);
		TestCase.assertEquals(fNotifications.get(0).getEventType(), Notification.ADD);
		TestCase.assertEquals(fNotifications.get(0).getFeature(), EcorePackage.eINSTANCE.getEPackage_EClassifiers());
		
		fNotifications.clear();
		
	}
	
	
	private EContentAdapter fAdapter = new EContentAdapter() {
	    @Override
	    public void notifyChanged(Notification notification) {
	    	fNotifications.add(notification);
	    }
	};
	
	private List<Notification> fNotifications = new ArrayList<Notification>();
	
}
