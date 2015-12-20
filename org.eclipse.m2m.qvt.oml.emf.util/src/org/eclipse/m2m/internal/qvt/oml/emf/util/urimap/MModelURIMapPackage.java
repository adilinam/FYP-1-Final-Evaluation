/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.emf.util.urimap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory
 * @model kind="package"
 * @generated
 */
public interface MModelURIMapPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "urimap"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///www.eclipse.org/m2m/qvt/oml/MModelUriMap/1.0.0"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "uriMap"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MModelURIMapPackage eINSTANCE = org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MappingContainerImpl <em>Mapping Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MappingContainerImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapPackageImpl#getMappingContainer()
	 * @generated
	 */
	int MAPPING_CONTAINER = 0;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONTAINER__MAPPING = 0;

	/**
	 * The number of structural features of the '<em>Mapping Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl <em>URI Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapPackageImpl#getURIMapping()
	 * @generated
	 */
	int URI_MAPPING = 1;

	/**
	 * The feature id for the '<em><b>Source URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_MAPPING__SOURCE_URI = 0;

	/**
	 * The feature id for the '<em><b>Target URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_MAPPING__TARGET_URI = 1;

	/**
	 * The number of structural features of the '<em>URI Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int URI_MAPPING_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer <em>Mapping Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Container</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer
	 * @generated
	 */
	EClass getMappingContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer#getMapping()
	 * @see #getMappingContainer()
	 * @generated
	 */
	EReference getMappingContainer_Mapping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping <em>URI Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>URI Mapping</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping
	 * @generated
	 */
	EClass getURIMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getSourceURI <em>Source URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source URI</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getSourceURI()
	 * @see #getURIMapping()
	 * @generated
	 */
	EAttribute getURIMapping_SourceURI();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getTargetURI <em>Target URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target URI</em>'.
	 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping#getTargetURI()
	 * @see #getURIMapping()
	 * @generated
	 */
	EAttribute getURIMapping_TargetURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MModelURIMapFactory getMModelURIMapFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MappingContainerImpl <em>Mapping Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MappingContainerImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapPackageImpl#getMappingContainer()
		 * @generated
		 */
		EClass MAPPING_CONTAINER = eINSTANCE.getMappingContainer();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CONTAINER__MAPPING = eINSTANCE.getMappingContainer_Mapping();

		/**
		 * The meta object literal for the '{@link org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl <em>URI Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.URIMappingImpl
		 * @see org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.impl.MModelURIMapPackageImpl#getURIMapping()
		 * @generated
		 */
		EClass URI_MAPPING = eINSTANCE.getURIMapping();

		/**
		 * The meta object literal for the '<em><b>Source URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_MAPPING__SOURCE_URI = eINSTANCE.getURIMapping_SourceURI();

		/**
		 * The meta object literal for the '<em><b>Target URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute URI_MAPPING__TARGET_URI = eINSTANCE.getURIMapping_TargetURI();

	}

} //MModelURIMapPackage
