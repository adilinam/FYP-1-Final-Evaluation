/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assign Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl#getLValueCS <em>LValue CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssignStatementCSImpl#isIncremental <em>Incremental</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignStatementCSImpl extends StatementCSImpl implements AssignStatementCS {
	/**
	 * The cached value of the '{@link #getLValueCS() <em>LValue CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLValueCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS lValueCS;

	/**
	 * The cached value of the '{@link #getOclExpressionCS() <em>Ocl Expression CS</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclExpressionCS()
	 * @generated
	 * @ordered
	 */
	protected ExpCS oclExpressionCS;

	/**
	 * The default value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INCREMENTAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIncremental() <em>Incremental</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIncremental()
	 * @generated
	 * @ordered
	 */
	protected boolean incremental = INCREMENTAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignStatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLCSPackage.Literals.ASSIGN_STATEMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getLValueCS() {
		return lValueCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLValueCS(ExpCS newLValueCS, NotificationChain msgs) {
		ExpCS oldLValueCS = lValueCS;
		lValueCS = newLValueCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, oldLValueCS, newLValueCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLValueCS(ExpCS newLValueCS) {
		if (newLValueCS != lValueCS) {
			NotificationChain msgs = null;
			if (lValueCS != null)
				msgs = ((InternalEObject)lValueCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, null, msgs);
			if (newLValueCS != null)
				msgs = ((InternalEObject)newLValueCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, null, msgs);
			msgs = basicSetLValueCS(newLValueCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS, newLValueCS, newLValueCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getOclExpressionCS() {
		return oclExpressionCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOclExpressionCS(ExpCS newOclExpressionCS, NotificationChain msgs) {
		ExpCS oldOclExpressionCS = oclExpressionCS;
		oclExpressionCS = newOclExpressionCS;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, oldOclExpressionCS, newOclExpressionCS);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclExpressionCS(ExpCS newOclExpressionCS) {
		if (newOclExpressionCS != oclExpressionCS) {
			NotificationChain msgs = null;
			if (oclExpressionCS != null)
				msgs = ((InternalEObject)oclExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			if (newOclExpressionCS != null)
				msgs = ((InternalEObject)newOclExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			msgs = basicSetOclExpressionCS(newOclExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS, newOclExpressionCS, newOclExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIncremental() {
		return incremental;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncremental(boolean newIncremental) {
		boolean oldIncremental = incremental;
		incremental = newIncremental;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__INCREMENTAL, oldIncremental, incremental));
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
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return basicSetLValueCS(null, msgs);
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return basicSetOclExpressionCS(null, msgs);
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
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return getLValueCS();
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return getOclExpressionCS();
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				return isIncremental();
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
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				setLValueCS((ExpCS)newValue);
				return;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((ExpCS)newValue);
				return;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				setIncremental((Boolean)newValue);
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
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				setLValueCS((ExpCS)null);
				return;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((ExpCS)null);
				return;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				setIncremental(INCREMENTAL_EDEFAULT);
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
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__LVALUE_CS:
				return lValueCS != null;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS:
				return oclExpressionCS != null;
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS__INCREMENTAL:
				return incremental != INCREMENTAL_EDEFAULT;
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
		return (R) ((ImperativeOCLCSVisitor<?>)visitor).visitAssignStatementCS(this);
	}

} //AssignStatementCSImpl
