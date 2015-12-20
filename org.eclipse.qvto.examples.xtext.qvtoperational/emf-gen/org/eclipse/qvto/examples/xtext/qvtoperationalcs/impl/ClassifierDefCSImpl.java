/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.TypeCS;
import org.eclipse.ocl.xtext.basecs.impl.ElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier Def CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl#getSimpleNameCS <em>Simple Name CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.ClassifierDefCSImpl#getTags <em>Tags</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassifierDefCSImpl extends ElementCSImpl implements ClassifierDefCS {
	/**
	 * The default value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected static final String SIMPLE_NAME_CS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSimpleNameCS() <em>Simple Name CS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSimpleNameCS()
	 * @generated
	 * @ordered
	 */
	protected String simpleNameCS = SIMPLE_NAME_CS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeCS> extends_;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassifierProperty2CS> properties;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EList<TagCS> tags;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierDefCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.CLASSIFIER_DEF_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSimpleNameCS() {
		return simpleNameCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSimpleNameCS(String newSimpleNameCS) {
		String oldSimpleNameCS = simpleNameCS;
		simpleNameCS = newSimpleNameCS;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.CLASSIFIER_DEF_CS__SIMPLE_NAME_CS, oldSimpleNameCS, simpleNameCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeCS> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectContainmentEList<TypeCS>(TypeCS.class, this, QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassifierProperty2CS> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<ClassifierProperty2CS>(ClassifierProperty2CS.class, this, QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TagCS> getTags() {
		if (tags == null) {
			tags = new EObjectContainmentEList<TagCS>(TagCS.class, this, QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS);
		}
		return tags;
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
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS:
				return ((InternalEList<?>)getTags()).basicRemove(otherEnd, msgs);
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
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__SIMPLE_NAME_CS:
				return getSimpleNameCS();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS:
				return getExtends();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES:
				return getProperties();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS:
				return getTags();
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
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__SIMPLE_NAME_CS:
				setSimpleNameCS((String)newValue);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends TypeCS>)newValue);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends ClassifierProperty2CS>)newValue);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS:
				getTags().clear();
				getTags().addAll((Collection<? extends TagCS>)newValue);
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
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__SIMPLE_NAME_CS:
				setSimpleNameCS(SIMPLE_NAME_CS_EDEFAULT);
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS:
				getExtends().clear();
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES:
				getProperties().clear();
				return;
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS:
				getTags().clear();
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
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__SIMPLE_NAME_CS:
				return SIMPLE_NAME_CS_EDEFAULT == null ? simpleNameCS != null : !SIMPLE_NAME_CS_EDEFAULT.equals(simpleNameCS);
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case QVTOperationalCSPackage.CLASSIFIER_DEF_CS__TAGS:
				return tags != null && !tags.isEmpty();
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitClassifierDefCS(this);
	}

} //ClassifierDefCSImpl
