/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.bbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.m2m.qvt.oml.util.Dictionary;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.MutableList;

public class Bug289982_Library {
	
	private static final String BLACKBOX_TEXT = "blackbox"; //$NON-NLS-1$
	

	/*
	 * blackbox constructor EPackage::EPackage();
	 */	
	@Operation (kind=Kind.CONSTRUCTOR, contextual = true)
	public void EPackage(EPackage self) {
		self.setName(BLACKBOX_TEXT);
	}	

	/*
	 * blackbox constructor EPackage::EPackage(c : List(String));
	 */
	@Operation (kind=Kind.CONSTRUCTOR, contextual = true)
	public void EPackage(EPackage self, MutableList<String> c) {
		c.add(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
	}	

	/*
	 * blackbox constructor EModelElement::EModelElement();
	 */
	@Operation (kind=Kind.CONSTRUCTOR, contextual = true)
	public void EModelElement(EModelElement self) {
		EAnnotation annot = EcoreFactory.eINSTANCE.createEAnnotation();
		annot.setSource(BLACKBOX_TEXT);
		self.getEAnnotations().add(annot);
	}	


	/*
	 * blackbox helper EPackage::contextualHelper();
	 */
	@Operation (kind=Kind.HELPER, contextual = true)
	public void contextualHelper(EPackage self) {
		self.setName(BLACKBOX_TEXT);
	}	
	
	/*
	 * blackbox helper nonContextualHelper();
	 */
	@Operation (kind=Kind.HELPER)
	public void nonContextualHelper() {
	}	
	
	/*
	 * blackbox helper EPackage::contextualHelper(c : List(String)) : Set(String);
	 */
	@Operation (kind=Kind.HELPER, contextual = true)
	public Set<String> contextualHelper(EPackage self, MutableList<String> c) {
		self.setName(BLACKBOX_TEXT);
		Set<String> set = new HashSet<String>(c);
		return set;
	}	

	/*
	 * blackbox helper nonContextualHelper(c : List(String)) : Set(String);
	 */
	@Operation (kind=Kind.HELPER)
	public Set<String> nonContextualHelper(MutableList<String> c) {
		Set<String> set = new HashSet<String>(c);
		return set;
	}	

	/*
	 * blackbox helper EPackage::contextualHelperWithExecContext();
	 */
	@Operation (kind=Kind.HELPER, contextual = true, withExecutionContext = true)
	public void contextualHelperWithExecContext(IContext context, EPackage self) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
	}	

	/*
	 * blackbox helper nonContextualHelperWithExecContext();
	 */
	@Operation (kind=Kind.HELPER, withExecutionContext = true)
	public void nonContextualHelperWithExecContext(IContext context) {
		context.getLog().log(BLACKBOX_TEXT);
	}

	/*
	 * blackbox helper EPackage::contextualHelperWithExecContext(c : List(String)) : Set(String);
	 */
	@Operation (kind=Kind.HELPER, contextual = true, withExecutionContext = true)
	public Set<String> contextualHelperWithExecContext(IContext context, EPackage self, MutableList<String> c) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
		Set<String> set = new HashSet<String>(c);
		return set;
	}

	/*
	 * blackbox helper nonContextualHelperWithExecContext(c : List(String)) : Set(String);
	 */
	@Operation (kind=Kind.HELPER, withExecutionContext = true)
	public Set<String> nonContextualHelperWithExecContext(IContext context, MutableList<String> c) {
		context.getLog().log(BLACKBOX_TEXT);
		Set<String> set = new HashSet<String>(c);
		return set;
	}


	/*
	 * blackbox query EClass::contextualQuery();
	 */
	@Operation (kind=Kind.QUERY, contextual = true)
	public void contextualQuery(EClass self) {
		self.setName(BLACKBOX_TEXT);
	}

	/*
	 * blackbox query nonContextualQuery();
	 */
	@Operation (kind=Kind.QUERY)
	public void nonContextualQuery() {
	}

	/*
	 * blackbox query EClass::contextualQuery(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.QUERY, contextual = true)
	public List<String> contextualQuery(EClass self, Dictionary<String, Integer> c) {
		self.setName(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}

	/*
	 * blackbox query nonContextualQuery(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.QUERY)
	public List<String> nonContextualQuery(Dictionary<String, Integer> c) {
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}

	/*
	 * blackbox query EClass::contextualQueryWithExecContext();
	 */
	@Operation (kind=Kind.QUERY, contextual = true, withExecutionContext = true)
	public void contextualQueryWithExecContext(IContext context, EClass self) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
	}

	/*
	 * blackbox query nonContextualQueryWithExecContext();
	 */
	@Operation (kind=Kind.QUERY, withExecutionContext = true)
	public void nonContextualQueryWithExecContext(IContext context) {
		context.getLog().log(BLACKBOX_TEXT);
	}

	/*
	 * blackbox query EClass::contextualQueryWithExecContext(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.QUERY, contextual = true, withExecutionContext = true)
	public List<String> contextualQueryWithExecContext(IContext context, EClass self, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}

	/*
	 * blackbox query nonContextualQueryWithExecContext(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.QUERY, withExecutionContext = true)
	public List<String> nonContextualQueryWithExecContext(IContext context, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}


	/*
	 * blackbox helper EClass::contextualOperation();
	 */
	@Operation (kind=Kind.OPERATION, contextual = true)
	public void contextualOperation(EClass self) {
		self.setName(BLACKBOX_TEXT);
	}	
	
	/*
	 * blackbox helper nonContextualOperation();
	 */
	@Operation (kind=Kind.OPERATION)
	public void nonContextualOperation() {
	}	
	
	/*
	 * blackbox helper EClass::contextualOperation(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.OPERATION, contextual = true)
	public List<String> contextualOperation(EClass self, Dictionary<String, Integer> c) {
		self.setName(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}	

	/*
	 * blackbox helper nonContextualOperation(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.OPERATION)
	public List<String> nonContextualOperation(Dictionary<String, Integer> c) {
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}	

	/*
	 * blackbox helper EClass::contextualOperationWithExecContext();
	 */
	@Operation (kind=Kind.OPERATION, contextual = true, withExecutionContext = true)
	public void contextualOperationWithExecContext(IContext context, EClass self) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
	}	

	/*
	 * blackbox helper nonContextualOperationWithExecContext();
	 */
	@Operation (kind=Kind.OPERATION, withExecutionContext = true)
	public void nonContextualOperationWithExecContext(IContext context) {
		context.getLog().log(BLACKBOX_TEXT);
	}

	/*
	 * blackbox helper EClass::contextualOperationWithExecContext(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.OPERATION, contextual = true, withExecutionContext = true)
	public List<String> contextualOperationWithExecContext(IContext context, EClass self, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		self.setName(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}

	/*
	 * blackbox helper nonContextualOperationWithExecContext(c : Dict(String, Integer)) : Sequence(String);
	 */
	@Operation (kind=Kind.OPERATION, withExecutionContext = true)
	public List<String> nonContextualOperationWithExecContext(IContext context, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		List<String> list = new ArrayList<String>(c.keys());
		return list;
	}


	/*
	 * blackbox mapping EClassifier::contextualMapping() : EClassifier;
	 */
	@Operation (kind=Kind.MAPPING, contextual = true)
	public EClassifier contextualMapping(EClassifier self) {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(self.getName());
		return cls;
	}

	/*
	 * blackbox mapping nonContextualMapping() : EClassifier;
	 */
	@Operation (kind=Kind.MAPPING)
	public EClassifier nonContextualMapping() {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(BLACKBOX_TEXT);
		return cls;
	}

	/*
	 * blackbox mapping EClassifier::contextualMapping(r : Real, c : Collection(Real), e : EModelElement) : Sequence(EClassifier);
	 */
	@Operation (kind=Kind.MAPPING, contextual = true)
	public List<EClassifier> contextualMapping(EClassifier self, Double f, Collection<Double> c, EModelElement e) {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(self.getName() + c.size());
		if (e instanceof ENamedElement) {
			((ENamedElement) e).setName(((ENamedElement) e).getName() + f.intValue());
		}
		return new ArrayList<EClassifier>(Arrays.asList(cls));
	}

	/*
	 * blackbox mapping nonContextualMapping(r : Real, c : Collection(Real), e : EModelElement) : Sequence(EClassifier);
	 */
	@Operation (kind=Kind.MAPPING)
	public List<EClassifier> nonContextualMapping(Double f, Collection<Double> c, EModelElement e) {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(BLACKBOX_TEXT + c.size());
		if (e instanceof ENamedElement) {
			((ENamedElement) e).setName(((ENamedElement) e).getName() + f.intValue());
		}
		return new ArrayList<EClassifier>(Arrays.asList(cls));
	}

	/*
	 * blackbox mapping EClassifier::contextualMappingWithExecContext() : EClassifier;
	 */
	@Operation (kind=Kind.MAPPING, contextual = true, withExecutionContext = true)
	public EClassifier contextualMappingWithExecContext(IContext context, EClassifier self) {
		context.getLog().log(BLACKBOX_TEXT);
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(self.getName());
		return cls;
	}

	/*
	 * blackbox mapping nonContextualMappingWithExecContext() : EClassifier;
	 */
	@Operation (kind=Kind.MAPPING, withExecutionContext = true)
	public EClassifier nonContextualMappingWithExecContext(IContext context) {
		context.getLog().log(BLACKBOX_TEXT);
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(BLACKBOX_TEXT);
		return cls;
	}

	/*
	 * blackbox mapping EClassifier::contextualMappingWithExecContext(c : Dict(String, Integer)) : Sequence(EClassifier);
	 */
	@Operation (kind=Kind.MAPPING, contextual = true, withExecutionContext = true)
	public List<EClassifier> contextualMappingWithExecContext(IContext context, EClassifier self, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(self.getName() + c.size());
		return new ArrayList<EClassifier>(Arrays.asList(cls));
	}

	/*
	 * blackbox mapping nonContextualMappingWithExecContext(c : Dict(String, Integer)) : Sequence(EClassifier);
	 */
	@Operation (kind=Kind.MAPPING, withExecutionContext = true)
	public List<EClassifier> nonContextualMappingWithExecContext(IContext context, Dictionary<String, Integer> c) {
		context.getLog().log(BLACKBOX_TEXT);
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		cls.setName(BLACKBOX_TEXT + c.size());
		return new ArrayList<EClassifier>(Arrays.asList(cls));
	}

	
	// Query stubs that are equal for QVT->Java type mappings
	//
	@Operation (kind=Kind.QUERY)
	public int ambiguousQuery(ArrayList<String> c) {
		return c.size();
	}
	
	@Operation (kind=Kind.QUERY)
	public int ambiguousQuery(LinkedList<String> c) {
		return c.size();
	}
	
}
