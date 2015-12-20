/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl#getSegment <em>Segment</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl#getTopLevelElements <em>Top Level Elements</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl#getModelTypes <em>Model Types</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.UnitCSImpl#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnitCSImpl extends ElementCSImpl implements UnitCS {
	/**
	 * The cached value of the '{@link #getSegment() <em>Segment</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSegment()
	 * @generated
	 * @ordered
	 */
	protected EList<String> segment;

	/**
	 * The cached value of the '{@link #getTopLevelElements() <em>Top Level Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTopLevelElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ElementCS> topLevelElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.UNIT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getSegment() {
		if (segment == null) {
			segment = new EDataTypeEList<String>(String.class, this, QVTOperationalCSPackage.UNIT_CS__SEGMENT);
		}
		return segment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ElementCS> getTopLevelElements() {
		if (topLevelElements == null) {
			topLevelElements = new EObjectContainmentEList<ElementCS>(ElementCS.class, this, QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS);
		}
		return topLevelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModuleCS> getModules() {
		// TODO: implement this method to return the 'Modules' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelTypeCS> getModelTypes() {
		// TODO: implement this method to return the 'Model Types' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<QVToImportCS> getImports() {
		// TODO: implement this method to return the 'Imports' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return ((InternalEList<?>)getTopLevelElements()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalCSPackage.UNIT_CS__SEGMENT:
				return getSegment();
			case QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return getTopLevelElements();
			case QVTOperationalCSPackage.UNIT_CS__MODULES:
				return getModules();
			case QVTOperationalCSPackage.UNIT_CS__MODEL_TYPES:
				return getModelTypes();
			case QVTOperationalCSPackage.UNIT_CS__IMPORTS:
				return getImports();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTOperationalCSPackage.UNIT_CS__SEGMENT:
				getSegment().clear();
				getSegment().addAll((Collection<? extends String>)newValue);
				return;
			case QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
				getTopLevelElements().addAll((Collection<? extends ElementCS>)newValue);
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
			case QVTOperationalCSPackage.UNIT_CS__SEGMENT:
				getSegment().clear();
				return;
			case QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				getTopLevelElements().clear();
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
			case QVTOperationalCSPackage.UNIT_CS__SEGMENT:
				return segment != null && !segment.isEmpty();
			case QVTOperationalCSPackage.UNIT_CS__TOP_LEVEL_ELEMENTS:
				return topLevelElements != null && !topLevelElements.isEmpty();
			case QVTOperationalCSPackage.UNIT_CS__MODULES:
				return !getModules().isEmpty();
			case QVTOperationalCSPackage.UNIT_CS__MODEL_TYPES:
				return !getModelTypes().isEmpty();
			case QVTOperationalCSPackage.UNIT_CS__IMPORTS:
				return !getImports().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(BaseCSVisitor<R> visitor) {
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitUnitCS(this);
	}

} //UnitCSImpl
