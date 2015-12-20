/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package rdb.view.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import rdb.Column;
import rdb.Element;
import rdb.NamedColumnSet;
import rdb.NamedElement;
import rdb.SchemaElement;
import rdb.view.ReferencedViewColumn;
import rdb.view.View;
import rdb.view.ViewAlias;
import rdb.view.ViewColumn;
import rdb.view.ViewExpressionColumn;
import rdb.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see rdb.view.ViewPackage
 * @generated
 */
public class ViewAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static ViewPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public ViewAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ViewPackage.eINSTANCE;
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
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected ViewSwitch<Adapter> modelSwitch =
		new ViewSwitch<Adapter>() {
			@Override
			public Adapter caseView(View object) {
				return createViewAdapter();
			}
			@Override
			public Adapter caseViewAlias(ViewAlias object) {
				return createViewAliasAdapter();
			}
			@Override
			public Adapter caseViewColumn(ViewColumn object) {
				return createViewColumnAdapter();
			}
			@Override
			public Adapter caseViewExpressionColumn(ViewExpressionColumn object) {
				return createViewExpressionColumnAdapter();
			}
			@Override
			public Adapter caseReferencedViewColumn(ReferencedViewColumn object) {
				return createReferencedViewColumnAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseSchemaElement(SchemaElement object) {
				return createSchemaElementAdapter();
			}
			@Override
			public Adapter caseNamedColumnSet(NamedColumnSet object) {
				return createNamedColumnSetAdapter();
			}
			@Override
			public Adapter caseColumn(Column object) {
				return createColumnAdapter();
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
	 * Creates a new adapter for an object of class '{@link rdb.view.View <em>View</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.view.View
	 * @generated
	 */
    public Adapter createViewAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.view.ViewAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.view.ViewAlias
	 * @generated
	 */
    public Adapter createViewAliasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.view.ViewColumn <em>Column</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.view.ViewColumn
	 * @generated
	 */
    public Adapter createViewColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.view.ViewExpressionColumn <em>Expression Column</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.view.ViewExpressionColumn
	 * @generated
	 */
    public Adapter createViewExpressionColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.view.ReferencedViewColumn <em>Referenced View Column</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.view.ReferencedViewColumn
	 * @generated
	 */
    public Adapter createReferencedViewColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.Element
	 * @generated
	 */
    public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.NamedElement
	 * @generated
	 */
    public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.SchemaElement <em>Schema Element</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.SchemaElement
	 * @generated
	 */
    public Adapter createSchemaElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.NamedColumnSet <em>Named Column Set</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.NamedColumnSet
	 * @generated
	 */
    public Adapter createNamedColumnSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link rdb.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see rdb.Column
	 * @generated
	 */
    public Adapter createColumnAdapter() {
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

} //ViewAdapterFactory
