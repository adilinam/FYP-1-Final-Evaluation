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
package simpleuml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import simpleuml.Association;
import simpleuml.Classifier;
import simpleuml.DataType;
import simpleuml.Enumeration;
import simpleuml.EnumerationLiteral;
import simpleuml.Generalization;
import simpleuml.Model;
import simpleuml.ModelElement;
import simpleuml.Packageable;
import simpleuml.PrimitiveType;
import simpleuml.Property;
import simpleuml.SimpleumlPackage;
import simpleuml.TaggedValue;
import simpleuml.Type;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see simpleuml.SimpleumlPackage
 * @generated
 */
public class SimpleumlAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static SimpleumlPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public SimpleumlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SimpleumlPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    @Override
				public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected SimpleumlSwitch<Adapter> modelSwitch =
        new SimpleumlSwitch<Adapter>() {
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter casePackage(simpleuml.Package object) {
				return createPackageAdapter();
			}
			@Override
			public Adapter caseClass(simpleuml.Class object) {
				return createClassAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseAssociation(Association object) {
				return createAssociationAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object) {
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseEnumeration(Enumeration object) {
				return createEnumerationAdapter();
			}
			@Override
			public Adapter caseEnumerationLiteral(EnumerationLiteral object) {
				return createEnumerationLiteralAdapter();
			}
			@Override
			public Adapter caseClassifier(Classifier object) {
				return createClassifierAdapter();
			}
			@Override
			public Adapter caseModelElement(ModelElement object) {
				return createModelElementAdapter();
			}
			@Override
			public Adapter caseGeneralization(Generalization object) {
				return createGeneralizationAdapter();
			}
			@Override
			public Adapter caseTaggedValue(TaggedValue object) {
				return createTaggedValueAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter casePackageable(Packageable object) {
				return createPackageableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    @Override
				public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Model
	 * @generated
	 */
    public Adapter createModelAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Package
	 * @generated
	 */
    public Adapter createPackageAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Class
	 * @generated
	 */
    public Adapter createClassAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Property
	 * @generated
	 */
    public Adapter createPropertyAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Association
	 * @generated
	 */
    public Adapter createAssociationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.PrimitiveType
	 * @generated
	 */
    public Adapter createPrimitiveTypeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.DataType
	 * @generated
	 */
    public Adapter createDataTypeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Enumeration
	 * @generated
	 */
    public Adapter createEnumerationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.EnumerationLiteral
	 * @generated
	 */
    public Adapter createEnumerationLiteralAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Classifier
	 * @generated
	 */
    public Adapter createClassifierAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.ModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.ModelElement
	 * @generated
	 */
    public Adapter createModelElementAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Generalization
	 * @generated
	 */
    public Adapter createGeneralizationAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.TaggedValue <em>Tagged Value</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.TaggedValue
	 * @generated
	 */
    public Adapter createTaggedValueAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Type
	 * @generated
	 */
    public Adapter createTypeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link simpleuml.Packageable <em>Packageable</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see simpleuml.Packageable
	 * @generated
	 */
    public Adapter createPackageableAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //SimpleumlAdapterFactory
