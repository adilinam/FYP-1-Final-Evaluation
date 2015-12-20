/**
 * <copyright>
 * </copyright>
 *
 * $Id: VarParameterImpl.java,v 1.3 2009/12/09 14:03:26 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.DirectionKind;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.VarParameter;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EMOF.MultiplicityElement;
import org.eclipse.qvt.declarative.emof.EMOF.Operation;
import org.eclipse.qvt.declarative.emof.EMOF.Parameter;
import org.eclipse.qvt.declarative.emof.EssentialOCL.impl.VariableImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Var Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getIsOrdered <em>Is Ordered</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getLower <em>Lower</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getUpper <em>Upper</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getCtxOwner <em>Ctx Owner</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.m2m.qvt.oml.emof.QVTOperational.impl.VarParameterImpl#getResOwner <em>Res Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VarParameterImpl extends VariableImpl implements VarParameter {
	/**
	 * The default value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_ORDERED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getIsOrdered() <em>Is Ordered</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsOrdered()
	 * @generated
	 * @ordered
	 */
	protected Boolean isOrdered = IS_ORDERED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsUnique()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean IS_UNIQUE_EDEFAULT = Boolean.TRUE;

	/**
	 * The cached value of the '{@link #getIsUnique() <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsUnique()
	 * @generated
	 * @ordered
	 */
	protected Boolean isUnique = IS_UNIQUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LOWER_EDEFAULT = new Integer(1);

	/**
	 * The cached value of the '{@link #getLower() <em>Lower</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLower()
	 * @generated
	 * @ordered
	 */
	protected Integer lower = LOWER_EDEFAULT;

	/**
	 * The default value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected static final Integer UPPER_EDEFAULT = new Integer(1);

	/**
	 * The cached value of the '{@link #getUpper() <em>Upper</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpper()
	 * @generated
	 * @ordered
	 */
	protected Integer upper = UPPER_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKind KIND_EDEFAULT = DirectionKind.IN;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected DirectionKind kind = KIND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VarParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalPackage.Literals.VAR_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsOrdered() {
		return isOrdered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOrdered(Boolean newIsOrdered) {
		Boolean oldIsOrdered = isOrdered;
		isOrdered = newIsOrdered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED, oldIsOrdered, isOrdered));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getIsUnique() {
		return isUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUnique(Boolean newIsUnique) {
		Boolean oldIsUnique = isUnique;
		isUnique = newIsUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE, oldIsUnique, isUnique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLower() {
		return lower;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLower(Integer newLower) {
		Integer oldLower = lower;
		lower = newLower;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__LOWER, oldLower, lower));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getUpper() {
		return upper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpper(Integer newUpper) {
		Integer oldUpper = upper;
		upper = newUpper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__UPPER, oldUpper, upper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperation() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__OPERATION) return null;
		return (Operation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperation(Operation newOperation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOperation, QVTOperationalPackage.VAR_PARAMETER__OPERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(Operation newOperation) {
		if (newOperation != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__OPERATION && newOperation != null)) {
			if (EcoreUtil.isAncestor(this, newOperation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOperation != null)
				msgs = ((InternalEObject)newOperation).eInverseAdd(this, EMOFPackage.OPERATION__OWNED_PARAMETER, Operation.class, msgs);
			msgs = basicSetOperation(newOperation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__OPERATION, newOperation, newOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getCtxOwner() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER) return null;
		return (ImperativeOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCtxOwner(ImperativeOperation newCtxOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCtxOwner, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCtxOwner(ImperativeOperation newCtxOwner) {
		if (newCtxOwner != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER && newCtxOwner != null)) {
			if (EcoreUtil.isAncestor(this, newCtxOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCtxOwner != null)
				msgs = ((InternalEObject)newCtxOwner).eInverseAdd(this, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, ImperativeOperation.class, msgs);
			msgs = basicSetCtxOwner(newCtxOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER, newCtxOwner, newCtxOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKind getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(DirectionKind newKind) {
		DirectionKind oldKind = kind;
		kind = newKind == null ? KIND_EDEFAULT : newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOperation getResOwner() {
		if (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__RES_OWNER) return null;
		return (ImperativeOperation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResOwner(ImperativeOperation newResOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResOwner, QVTOperationalPackage.VAR_PARAMETER__RES_OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResOwner(ImperativeOperation newResOwner) {
		if (newResOwner != eInternalContainer() || (eContainerFeatureID() != QVTOperationalPackage.VAR_PARAMETER__RES_OWNER && newResOwner != null)) {
			if (EcoreUtil.isAncestor(this, newResOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResOwner != null)
				msgs = ((InternalEObject)newResOwner).eInverseAdd(this, QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT, ImperativeOperation.class, msgs);
			msgs = basicSetResOwner(newResOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalPackage.VAR_PARAMETER__RES_OWNER, newResOwner, newResOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOperation((Operation)otherEnd, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCtxOwner((ImperativeOperation)otherEnd, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResOwner((ImperativeOperation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				return basicSetOperation(null, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return basicSetCtxOwner(null, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return basicSetResOwner(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				return eInternalContainer().eInverseRemove(this, EMOFPackage.OPERATION__OWNED_PARAMETER, Operation.class, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.IMPERATIVE_OPERATION__CONTEXT, ImperativeOperation.class, msgs);
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return eInternalContainer().eInverseRemove(this, QVTOperationalPackage.IMPERATIVE_OPERATION__RESULT, ImperativeOperation.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED:
				return getIsOrdered();
			case QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE:
				return getIsUnique();
			case QVTOperationalPackage.VAR_PARAMETER__LOWER:
				return getLower();
			case QVTOperationalPackage.VAR_PARAMETER__UPPER:
				return getUpper();
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				return getOperation();
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return getCtxOwner();
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				return getKind();
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return getResOwner();
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED:
				setIsOrdered((Boolean)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE:
				setIsUnique((Boolean)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__LOWER:
				setLower((Integer)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__UPPER:
				setUpper((Integer)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				setOperation((Operation)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				setCtxOwner((ImperativeOperation)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				setKind((DirectionKind)newValue);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				setResOwner((ImperativeOperation)newValue);
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED:
				setIsOrdered(IS_ORDERED_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE:
				setIsUnique(IS_UNIQUE_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__LOWER:
				setLower(LOWER_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__UPPER:
				setUpper(UPPER_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				setOperation((Operation)null);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				setCtxOwner((ImperativeOperation)null);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				setResOwner((ImperativeOperation)null);
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
			case QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED:
				return IS_ORDERED_EDEFAULT == null ? isOrdered != null : !IS_ORDERED_EDEFAULT.equals(isOrdered);
			case QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE:
				return IS_UNIQUE_EDEFAULT == null ? isUnique != null : !IS_UNIQUE_EDEFAULT.equals(isUnique);
			case QVTOperationalPackage.VAR_PARAMETER__LOWER:
				return LOWER_EDEFAULT == null ? lower != null : !LOWER_EDEFAULT.equals(lower);
			case QVTOperationalPackage.VAR_PARAMETER__UPPER:
				return UPPER_EDEFAULT == null ? upper != null : !UPPER_EDEFAULT.equals(upper);
			case QVTOperationalPackage.VAR_PARAMETER__OPERATION:
				return getOperation() != null;
			case QVTOperationalPackage.VAR_PARAMETER__CTX_OWNER:
				return getCtxOwner() != null;
			case QVTOperationalPackage.VAR_PARAMETER__KIND:
				return kind != KIND_EDEFAULT;
			case QVTOperationalPackage.VAR_PARAMETER__RES_OWNER:
				return getResOwner() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED: return EMOFPackage.MULTIPLICITY_ELEMENT__IS_ORDERED;
				case QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE: return EMOFPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE;
				case QVTOperationalPackage.VAR_PARAMETER__LOWER: return EMOFPackage.MULTIPLICITY_ELEMENT__LOWER;
				case QVTOperationalPackage.VAR_PARAMETER__UPPER: return EMOFPackage.MULTIPLICITY_ELEMENT__UPPER;
				default: return -1;
			}
		}
		if (baseClass == Parameter.class) {
			switch (derivedFeatureID) {
				case QVTOperationalPackage.VAR_PARAMETER__OPERATION: return EMOFPackage.PARAMETER__OPERATION;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MultiplicityElement.class) {
			switch (baseFeatureID) {
				case EMOFPackage.MULTIPLICITY_ELEMENT__IS_ORDERED: return QVTOperationalPackage.VAR_PARAMETER__IS_ORDERED;
				case EMOFPackage.MULTIPLICITY_ELEMENT__IS_UNIQUE: return QVTOperationalPackage.VAR_PARAMETER__IS_UNIQUE;
				case EMOFPackage.MULTIPLICITY_ELEMENT__LOWER: return QVTOperationalPackage.VAR_PARAMETER__LOWER;
				case EMOFPackage.MULTIPLICITY_ELEMENT__UPPER: return QVTOperationalPackage.VAR_PARAMETER__UPPER;
				default: return -1;
			}
		}
		if (baseClass == Parameter.class) {
			switch (baseFeatureID) {
				case EMOFPackage.PARAMETER__OPERATION: return QVTOperationalPackage.VAR_PARAMETER__OPERATION;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isOrdered: ");
		result.append(isOrdered);
		result.append(", isUnique: ");
		result.append(isUnique);
		result.append(", lower: ");
		result.append(lower);
		result.append(", upper: ");
		result.append(upper);
		result.append(", kind: ");
		result.append(kind);
		result.append(')');
		return result.toString();
	}

} //VarParameterImpl
