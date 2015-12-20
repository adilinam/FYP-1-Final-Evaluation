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
package simpleuml;

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
 * @see simpleuml.SimpleumlFactory
 * @model kind="package"
 * @generated
 */
public interface SimpleumlPackage extends EPackage {
    /**
	 * The package name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNAME = "simpleuml"; //$NON-NLS-1$

    /**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_URI = "http://www.eclipse.org/qvt/1.0.0/Operational/examples/simpleuml"; //$NON-NLS-1$

    /**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    String eNS_PREFIX = "uml"; //$NON-NLS-1$

    /**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    SimpleumlPackage eINSTANCE = simpleuml.impl.SimpleumlPackageImpl.init();

    /**
	 * The meta object id for the '{@link simpleuml.impl.ModelElementImpl <em>Model Element</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.ModelElementImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getModelElement()
	 * @generated
	 */
    int MODEL_ELEMENT = 10;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_ELEMENT__NAME = 0;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_ELEMENT__STEREOTYPE = 1;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_ELEMENT__TAGGED_VALUE = 2;

    /**
	 * The number of structural features of the '<em>Model Element</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_ELEMENT_FEATURE_COUNT = 3;

    /**
	 * The meta object id for the '{@link simpleuml.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.ClassifierImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getClassifier()
	 * @generated
	 */
    int CLASSIFIER = 9;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASSIFIER__NAME = MODEL_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASSIFIER__STEREOTYPE = MODEL_ELEMENT__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASSIFIER__TAGGED_VALUE = MODEL_ELEMENT__TAGGED_VALUE;

    /**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASSIFIER_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link simpleuml.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.PackageImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getPackage()
	 * @generated
	 */
    int PACKAGE = 1;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__NAME = CLASSIFIER__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__STEREOTYPE = CLASSIFIER__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__TAGGED_VALUE = CLASSIFIER__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__OWNER = CLASSIFIER_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE__OWNED_ELEMENTS = CLASSIFIER_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link simpleuml.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.ModelImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getModel()
	 * @generated
	 */
    int MODEL = 0;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__NAME = PACKAGE__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__STEREOTYPE = PACKAGE__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__TAGGED_VALUE = PACKAGE__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__OWNER = PACKAGE__OWNER;

    /**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL__OWNED_ELEMENTS = PACKAGE__OWNED_ELEMENTS;

    /**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int MODEL_FEATURE_COUNT = PACKAGE_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link simpleuml.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.TypeImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getType()
	 * @generated
	 */
    int TYPE = 13;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TYPE__NAME = CLASSIFIER__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TYPE__STEREOTYPE = CLASSIFIER__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TYPE__TAGGED_VALUE = CLASSIFIER__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TYPE__OWNER = CLASSIFIER_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link simpleuml.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.DataTypeImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getDataType()
	 * @generated
	 */
    int DATA_TYPE = 6;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__NAME = TYPE__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__STEREOTYPE = TYPE__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__TAGGED_VALUE = TYPE__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__OWNER = TYPE__OWNER;

    /**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE__ATTRIBUTES = TYPE_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int DATA_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link simpleuml.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.ClassImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getClass_()
	 * @generated
	 */
    int CLASS = 2;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__NAME = DATA_TYPE__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__STEREOTYPE = DATA_TYPE__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__TAGGED_VALUE = DATA_TYPE__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__OWNER = DATA_TYPE__OWNER;

    /**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__ATTRIBUTES = DATA_TYPE__ATTRIBUTES;

    /**
	 * The feature id for the '<em><b>Generalizations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__GENERALIZATIONS = DATA_TYPE_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS__ABSTRACT = DATA_TYPE_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int CLASS_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link simpleuml.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.PropertyImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getProperty()
	 * @generated
	 */
    int PROPERTY = 3;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY__NAME = MODEL_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY__STEREOTYPE = MODEL_ELEMENT__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY__TAGGED_VALUE = MODEL_ELEMENT__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY__TYPE = MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY__OWNER = MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PROPERTY_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
	 * The meta object id for the '{@link simpleuml.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.AssociationImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getAssociation()
	 * @generated
	 */
    int ASSOCIATION = 4;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__NAME = MODEL_ELEMENT__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__STEREOTYPE = MODEL_ELEMENT__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__TAGGED_VALUE = MODEL_ELEMENT__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__OWNER = MODEL_ELEMENT_FEATURE_COUNT + 0;

    /**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__SOURCE = MODEL_ELEMENT_FEATURE_COUNT + 1;

    /**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION__TARGET = MODEL_ELEMENT_FEATURE_COUNT + 2;

    /**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ASSOCIATION_FEATURE_COUNT = MODEL_ELEMENT_FEATURE_COUNT + 3;

    /**
	 * The meta object id for the '{@link simpleuml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.PrimitiveTypeImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getPrimitiveType()
	 * @generated
	 */
    int PRIMITIVE_TYPE = 5;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_TYPE__NAME = TYPE__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_TYPE__STEREOTYPE = TYPE__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_TYPE__TAGGED_VALUE = TYPE__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_TYPE__OWNER = TYPE__OWNER;

    /**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PRIMITIVE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

    /**
	 * The meta object id for the '{@link simpleuml.impl.EnumerationImpl <em>Enumeration</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.EnumerationImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getEnumeration()
	 * @generated
	 */
    int ENUMERATION = 7;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION__NAME = TYPE__NAME;

    /**
	 * The feature id for the '<em><b>Stereotype</b></em>' attribute list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION__STEREOTYPE = TYPE__STEREOTYPE;

    /**
	 * The feature id for the '<em><b>Tagged Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION__TAGGED_VALUE = TYPE__TAGGED_VALUE;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION__OWNER = TYPE__OWNER;

    /**
	 * The feature id for the '<em><b>Owned Literal</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION__OWNED_LITERAL = TYPE_FEATURE_COUNT + 0;

    /**
	 * The number of structural features of the '<em>Enumeration</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

    /**
	 * The meta object id for the '{@link simpleuml.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.EnumerationLiteralImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getEnumerationLiteral()
	 * @generated
	 */
    int ENUMERATION_LITERAL = 8;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION_LITERAL__NAME = 0;

    /**
	 * The number of structural features of the '<em>Enumeration Literal</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int ENUMERATION_LITERAL_FEATURE_COUNT = 1;

    /**
	 * The meta object id for the '{@link simpleuml.impl.GeneralizationImpl <em>Generalization</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.GeneralizationImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getGeneralization()
	 * @generated
	 */
    int GENERALIZATION = 11;

    /**
	 * The feature id for the '<em><b>General</b></em>' reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int GENERALIZATION__GENERAL = 0;

    /**
	 * The feature id for the '<em><b>Is Substitutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int GENERALIZATION__IS_SUBSTITUTABLE = 1;

    /**
	 * The number of structural features of the '<em>Generalization</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int GENERALIZATION_FEATURE_COUNT = 2;

    /**
	 * The meta object id for the '{@link simpleuml.impl.TaggedValueImpl <em>Tagged Value</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.TaggedValueImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getTaggedValue()
	 * @generated
	 */
    int TAGGED_VALUE = 12;

    /**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAGGED_VALUE__NAME = 0;

    /**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAGGED_VALUE__VALUE = 1;

    /**
	 * The number of structural features of the '<em>Tagged Value</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int TAGGED_VALUE_FEATURE_COUNT = 2;

    /**
	 * The meta object id for the '{@link simpleuml.impl.PackageableImpl <em>Packageable</em>}' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @see simpleuml.impl.PackageableImpl
	 * @see simpleuml.impl.SimpleumlPackageImpl#getPackageable()
	 * @generated
	 */
    int PACKAGEABLE = 14;

    /**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGEABLE__OWNER = 0;

    /**
	 * The number of structural features of the '<em>Packageable</em>' class.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
    int PACKAGEABLE_FEATURE_COUNT = 1;


    /**
	 * Returns the meta object for class '{@link simpleuml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see simpleuml.Model
	 * @generated
	 */
    EClass getModel();

    /**
	 * Returns the meta object for class '{@link simpleuml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see simpleuml.Package
	 * @generated
	 */
    EClass getPackage();

    /**
	 * Returns the meta object for the containment reference list '{@link simpleuml.Package#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see simpleuml.Package#getOwnedElements()
	 * @see #getPackage()
	 * @generated
	 */
    EReference getPackage_OwnedElements();

    /**
	 * Returns the meta object for class '{@link simpleuml.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see simpleuml.Class
	 * @generated
	 */
    EClass getClass_();

    /**
	 * Returns the meta object for the containment reference list '{@link simpleuml.Class#getGeneralizations <em>Generalizations</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Generalizations</em>'.
	 * @see simpleuml.Class#getGeneralizations()
	 * @see #getClass_()
	 * @generated
	 */
    EReference getClass_Generalizations();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.Class#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see simpleuml.Class#isAbstract()
	 * @see #getClass_()
	 * @generated
	 */
    EAttribute getClass_Abstract();

    /**
	 * Returns the meta object for class '{@link simpleuml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see simpleuml.Property
	 * @generated
	 */
    EClass getProperty();

    /**
	 * Returns the meta object for the reference '{@link simpleuml.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see simpleuml.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
    EReference getProperty_Type();

    /**
	 * Returns the meta object for the container reference '{@link simpleuml.Property#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml.Property#getOwner()
	 * @see #getProperty()
	 * @generated
	 */
    EReference getProperty_Owner();

    /**
	 * Returns the meta object for class '{@link simpleuml.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see simpleuml.Association
	 * @generated
	 */
    EClass getAssociation();

    /**
	 * Returns the meta object for the reference '{@link simpleuml.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see simpleuml.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
    EReference getAssociation_Source();

    /**
	 * Returns the meta object for the reference '{@link simpleuml.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see simpleuml.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
    EReference getAssociation_Target();

    /**
	 * Returns the meta object for class '{@link simpleuml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see simpleuml.PrimitiveType
	 * @generated
	 */
    EClass getPrimitiveType();

    /**
	 * Returns the meta object for class '{@link simpleuml.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see simpleuml.DataType
	 * @generated
	 */
    EClass getDataType();

    /**
	 * Returns the meta object for the containment reference list '{@link simpleuml.DataType#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see simpleuml.DataType#getAttributes()
	 * @see #getDataType()
	 * @generated
	 */
    EReference getDataType_Attributes();

    /**
	 * Returns the meta object for class '{@link simpleuml.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration</em>'.
	 * @see simpleuml.Enumeration
	 * @generated
	 */
    EClass getEnumeration();

    /**
	 * Returns the meta object for the containment reference list '{@link simpleuml.Enumeration#getOwnedLiteral <em>Owned Literal</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Literal</em>'.
	 * @see simpleuml.Enumeration#getOwnedLiteral()
	 * @see #getEnumeration()
	 * @generated
	 */
    EReference getEnumeration_OwnedLiteral();

    /**
	 * Returns the meta object for class '{@link simpleuml.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal</em>'.
	 * @see simpleuml.EnumerationLiteral
	 * @generated
	 */
    EClass getEnumerationLiteral();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.EnumerationLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simpleuml.EnumerationLiteral#getName()
	 * @see #getEnumerationLiteral()
	 * @generated
	 */
    EAttribute getEnumerationLiteral_Name();

    /**
	 * Returns the meta object for class '{@link simpleuml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see simpleuml.Classifier
	 * @generated
	 */
    EClass getClassifier();

    /**
	 * Returns the meta object for class '{@link simpleuml.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Element</em>'.
	 * @see simpleuml.ModelElement
	 * @generated
	 */
    EClass getModelElement();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.ModelElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simpleuml.ModelElement#getName()
	 * @see #getModelElement()
	 * @generated
	 */
    EAttribute getModelElement_Name();

    /**
	 * Returns the meta object for the attribute list '{@link simpleuml.ModelElement#getStereotype <em>Stereotype</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Stereotype</em>'.
	 * @see simpleuml.ModelElement#getStereotype()
	 * @see #getModelElement()
	 * @generated
	 */
    EAttribute getModelElement_Stereotype();

    /**
	 * Returns the meta object for the containment reference list '{@link simpleuml.ModelElement#getTaggedValue <em>Tagged Value</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tagged Value</em>'.
	 * @see simpleuml.ModelElement#getTaggedValue()
	 * @see #getModelElement()
	 * @generated
	 */
    EReference getModelElement_TaggedValue();

    /**
	 * Returns the meta object for class '{@link simpleuml.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization</em>'.
	 * @see simpleuml.Generalization
	 * @generated
	 */
    EClass getGeneralization();

    /**
	 * Returns the meta object for the reference '{@link simpleuml.Generalization#getGeneral <em>General</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>General</em>'.
	 * @see simpleuml.Generalization#getGeneral()
	 * @see #getGeneralization()
	 * @generated
	 */
    EReference getGeneralization_General();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.Generalization#isIsSubstitutable <em>Is Substitutable</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Substitutable</em>'.
	 * @see simpleuml.Generalization#isIsSubstitutable()
	 * @see #getGeneralization()
	 * @generated
	 */
    EAttribute getGeneralization_IsSubstitutable();

    /**
	 * Returns the meta object for class '{@link simpleuml.TaggedValue <em>Tagged Value</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tagged Value</em>'.
	 * @see simpleuml.TaggedValue
	 * @generated
	 */
    EClass getTaggedValue();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.TaggedValue#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see simpleuml.TaggedValue#getName()
	 * @see #getTaggedValue()
	 * @generated
	 */
    EAttribute getTaggedValue_Name();

    /**
	 * Returns the meta object for the attribute '{@link simpleuml.TaggedValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see simpleuml.TaggedValue#getValue()
	 * @see #getTaggedValue()
	 * @generated
	 */
    EAttribute getTaggedValue_Value();

    /**
	 * Returns the meta object for class '{@link simpleuml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see simpleuml.Type
	 * @generated
	 */
    EClass getType();

    /**
	 * Returns the meta object for class '{@link simpleuml.Packageable <em>Packageable</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Packageable</em>'.
	 * @see simpleuml.Packageable
	 * @generated
	 */
    EClass getPackageable();

    /**
	 * Returns the meta object for the container reference '{@link simpleuml.Packageable#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see simpleuml.Packageable#getOwner()
	 * @see #getPackageable()
	 * @generated
	 */
    EReference getPackageable_Owner();

    /**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
    SimpleumlFactory getSimpleumlFactory();

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
		 * The meta object literal for the '{@link simpleuml.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.ModelImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getModel()
		 * @generated
		 */
		EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.PackageImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_ELEMENTS = eINSTANCE.getPackage_OwnedElements();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.ClassImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Generalizations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__GENERALIZATIONS = eINSTANCE.getClass_Generalizations();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__ABSTRACT = eINSTANCE.getClass_Abstract();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.PropertyImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNER = eINSTANCE.getProperty_Owner();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.AssociationImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.PrimitiveTypeImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.DataTypeImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__ATTRIBUTES = eINSTANCE.getDataType_Attributes();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.EnumerationImpl <em>Enumeration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.EnumerationImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getEnumeration()
		 * @generated
		 */
		EClass ENUMERATION = eINSTANCE.getEnumeration();

		/**
		 * The meta object literal for the '<em><b>Owned Literal</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION__OWNED_LITERAL = eINSTANCE.getEnumeration_OwnedLiteral();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.EnumerationLiteralImpl <em>Enumeration Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.EnumerationLiteralImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getEnumerationLiteral()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL = eINSTANCE.getEnumerationLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL__NAME = eINSTANCE.getEnumerationLiteral_Name();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.ClassifierImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.ModelElementImpl <em>Model Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.ModelElementImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getModelElement()
		 * @generated
		 */
		EClass MODEL_ELEMENT = eINSTANCE.getModelElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__NAME = eINSTANCE.getModelElement_Name();

		/**
		 * The meta object literal for the '<em><b>Stereotype</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_ELEMENT__STEREOTYPE = eINSTANCE.getModelElement_Stereotype();

		/**
		 * The meta object literal for the '<em><b>Tagged Value</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_ELEMENT__TAGGED_VALUE = eINSTANCE.getModelElement_TaggedValue();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.GeneralizationImpl <em>Generalization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.GeneralizationImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getGeneralization()
		 * @generated
		 */
		EClass GENERALIZATION = eINSTANCE.getGeneralization();

		/**
		 * The meta object literal for the '<em><b>General</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__GENERAL = eINSTANCE.getGeneralization_General();

		/**
		 * The meta object literal for the '<em><b>Is Substitutable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERALIZATION__IS_SUBSTITUTABLE = eINSTANCE.getGeneralization_IsSubstitutable();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.TaggedValueImpl <em>Tagged Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.TaggedValueImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getTaggedValue()
		 * @generated
		 */
		EClass TAGGED_VALUE = eINSTANCE.getTaggedValue();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_VALUE__NAME = eINSTANCE.getTaggedValue_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAGGED_VALUE__VALUE = eINSTANCE.getTaggedValue_Value();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.TypeImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link simpleuml.impl.PackageableImpl <em>Packageable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see simpleuml.impl.PackageableImpl
		 * @see simpleuml.impl.SimpleumlPackageImpl#getPackageable()
		 * @generated
		 */
		EClass PACKAGEABLE = eINSTANCE.getPackageable();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGEABLE__OWNER = eINSTANCE.getPackageable_Owner();

	}

} //SimpleumlPackage
