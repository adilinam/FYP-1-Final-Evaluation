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
package simpleuml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import simpleuml.Association;
import simpleuml.DataType;
import simpleuml.Enumeration;
import simpleuml.EnumerationLiteral;
import simpleuml.Generalization;
import simpleuml.Model;
import simpleuml.PrimitiveType;
import simpleuml.Property;
import simpleuml.SimpleumlFactory;
import simpleuml.SimpleumlPackage;
import simpleuml.TaggedValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimpleumlFactoryImpl extends EFactoryImpl implements SimpleumlFactory {
    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimpleumlFactory init() {
		try {
			SimpleumlFactory theSimpleumlFactory = (SimpleumlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0.0/Operational/examples/simpleuml"); //$NON-NLS-1$ 
			if (theSimpleumlFactory != null) {
				return theSimpleumlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimpleumlFactoryImpl();
	}

				/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimpleumlFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    @Override
				public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimpleumlPackage.MODEL: return createModel();
			case SimpleumlPackage.PACKAGE: return createPackage();
			case SimpleumlPackage.CLASS: return createClass();
			case SimpleumlPackage.PROPERTY: return createProperty();
			case SimpleumlPackage.ASSOCIATION: return createAssociation();
			case SimpleumlPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case SimpleumlPackage.DATA_TYPE: return createDataType();
			case SimpleumlPackage.ENUMERATION: return createEnumeration();
			case SimpleumlPackage.ENUMERATION_LITERAL: return createEnumerationLiteral();
			case SimpleumlPackage.GENERALIZATION: return createGeneralization();
			case SimpleumlPackage.TAGGED_VALUE: return createTaggedValue();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public simpleuml.Package createPackage() {
		PackageImpl package_ = new PackageImpl();
		return package_;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public simpleuml.Class createClass() {
		ClassImpl class_ = new ClassImpl();
		return class_;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EnumerationLiteral createEnumerationLiteral() {
		EnumerationLiteralImpl enumerationLiteral = new EnumerationLiteralImpl();
		return enumerationLiteral;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public Generalization createGeneralization() {
		GeneralizationImpl generalization = new GeneralizationImpl();
		return generalization;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TaggedValue createTaggedValue() {
		TaggedValueImpl taggedValue = new TaggedValueImpl();
		return taggedValue;
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimpleumlPackage getSimpleumlPackage() {
		return (SimpleumlPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
				public static SimpleumlPackage getPackage() {
		return SimpleumlPackage.eINSTANCE;
	}

} //SimpleumlFactoryImpl
