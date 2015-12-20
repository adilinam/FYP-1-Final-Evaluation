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
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Statement CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.ExpressionStatementCSImpl#getOclExpressionCS <em>Ocl Expression CS</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionStatementCSImpl extends StatementCSImpl implements ExpressionStatementCS {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionStatementCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLCSPackage.Literals.EXPRESSION_STATEMENT_CS;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS, oldOclExpressionCS, newOclExpressionCS);
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
				msgs = ((InternalEObject)oclExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			if (newOclExpressionCS != null)
				msgs = ((InternalEObject)newOclExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS, null, msgs);
			msgs = basicSetOclExpressionCS(newOclExpressionCS, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS, newOclExpressionCS, newOclExpressionCS));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS:
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
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS:
				return getOclExpressionCS();
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
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((ExpCS)newValue);
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
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS:
				setOclExpressionCS((ExpCS)null);
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
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS:
				return oclExpressionCS != null;
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
		return (R) ((ImperativeOCLCSVisitor<?>)visitor).visitExpressionStatementCS(this);
	}

} //ExpressionStatementCSImpl
