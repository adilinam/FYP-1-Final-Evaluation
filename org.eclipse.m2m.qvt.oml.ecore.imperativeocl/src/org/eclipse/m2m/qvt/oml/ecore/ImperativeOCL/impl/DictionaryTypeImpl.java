/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: DictionaryTypeImpl.java,v 1.2 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLPlugin;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLValidator;
import org.eclipse.ocl.ecore.impl.CollectionTypeImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dictionary Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl.DictionaryTypeImpl#getKeyType <em>Key Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DictionaryTypeImpl extends CollectionTypeImpl implements DictionaryType {
	/**
	 * The cached value of the '{@link #getKeyType() <em>Key Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier keyType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected DictionaryTypeImpl() {
		super();
		setInstanceClass(Map.class);
 	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.DICTIONARY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getKeyType() {
		if (keyType != null && keyType.eIsProxy()) {
			InternalEObject oldKeyType = (InternalEObject)keyType;
			keyType = (EClassifier)eResolveProxy(oldKeyType);
			if (keyType != oldKeyType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE, oldKeyType, keyType));
			}
		}
		return keyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetKeyType() {
		return keyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyType(EClassifier newKeyType) {
		EClassifier oldKeyType = keyType;
		keyType = newKeyType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE, oldKeyType, keyType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE:
				if (resolve) return getKeyType();
				return basicGetKeyType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE:
				setKeyType((EClassifier)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE:
				setKeyType((EClassifier)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImperativeOCLPackage.DICTIONARY_TYPE__KEY_TYPE:
				return keyType != null;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 *
	 * Overwriting of the method checkCollectionTypeName
	 * @generated NOT
	 */
	@Override
	public boolean checkCollectionTypeName(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		boolean result=true;
		
		String name = getName();
   	EClassifier elementType = getElementType();
   	EClassifier keyType = getKeyType();
   	if (elementType != null
   		&& keyType != null) {
   		String elementTypeName = elementType.getName();
   		String keyTypeName = keyType.getName();
   		if (!("Dictionary("+ keyTypeName + ","+ elementTypeName+")").equals(name)) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
   			result = false;
   	}
   	
       if (!result) {
           if (diagnostics != null) {
               diagnostics.add
                   (new BasicDiagnostic
                       (Diagnostic.ERROR,
                       ImperativeOCLValidator.DIAGNOSTIC_SOURCE,
                       0,
                       ImperativeOCLPlugin.INSTANCE.getString(
                       	"_UI_InvalidDictionaryTypeName_diagnostic", //$NON-NLS-1$ 
                       	new Object[] {ImperativeOCLValidator.getObjectLabel(this, context)}),
                       new Object [] { this }));
           }
       }
       return result;
	}
} //DictionaryTypeImpl
