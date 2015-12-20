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
import org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.util.ImperativeOCLCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assert Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl#getAssertion <em>Assertion</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl#getLog <em>Log</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.imperativeoclcs.impl.AssertExpCSImpl#getSeverity <em>Severity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssertExpCSImpl extends StatementCSImpl implements AssertExpCS {
	/**
	 * The cached value of the '{@link #getAssertion() <em>Assertion</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssertion()
	 * @generated
	 * @ordered
	 */
	protected ExpCS assertion;

	/**
	 * The cached value of the '{@link #getLog() <em>Log</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLog()
	 * @generated
	 * @ordered
	 */
	protected LogExpCS log;

	/**
	 * The default value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected static final String SEVERITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeverity() <em>Severity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeverity()
	 * @generated
	 * @ordered
	 */
	protected String severity = SEVERITY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssertExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLCSPackage.Literals.ASSERT_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpCS getAssertion() {
		return assertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssertion(ExpCS newAssertion, NotificationChain msgs) {
		ExpCS oldAssertion = assertion;
		assertion = newAssertion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION, oldAssertion, newAssertion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssertion(ExpCS newAssertion) {
		if (newAssertion != assertion) {
			NotificationChain msgs = null;
			if (assertion != null)
				msgs = ((InternalEObject)assertion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION, null, msgs);
			if (newAssertion != null)
				msgs = ((InternalEObject)newAssertion).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION, null, msgs);
			msgs = basicSetAssertion(newAssertion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION, newAssertion, newAssertion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogExpCS getLog() {
		return log;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLog(LogExpCS newLog, NotificationChain msgs) {
		LogExpCS oldLog = log;
		log = newLog;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG, oldLog, newLog);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLog(LogExpCS newLog) {
		if (newLog != log) {
			NotificationChain msgs = null;
			if (log != null)
				msgs = ((InternalEObject)log).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG, null, msgs);
			if (newLog != null)
				msgs = ((InternalEObject)newLog).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG, null, msgs);
			msgs = basicSetLog(newLog, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG, newLog, newLog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeverity(String newSeverity) {
		String oldSeverity = severity;
		severity = newSeverity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImperativeOCLCSPackage.ASSERT_EXP_CS__SEVERITY, oldSeverity, severity));
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION:
				return basicSetAssertion(null, msgs);
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG:
				return basicSetLog(null, msgs);
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION:
				return getAssertion();
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG:
				return getLog();
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__SEVERITY:
				return getSeverity();
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION:
				setAssertion((ExpCS)newValue);
				return;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG:
				setLog((LogExpCS)newValue);
				return;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__SEVERITY:
				setSeverity((String)newValue);
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION:
				setAssertion((ExpCS)null);
				return;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG:
				setLog((LogExpCS)null);
				return;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__SEVERITY:
				setSeverity(SEVERITY_EDEFAULT);
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__ASSERTION:
				return assertion != null;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__LOG:
				return log != null;
			case ImperativeOCLCSPackage.ASSERT_EXP_CS__SEVERITY:
				return SEVERITY_EDEFAULT == null ? severity != null : !SEVERITY_EDEFAULT.equals(severity);
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
		return (R) ((ImperativeOCLCSVisitor<?>)visitor).visitAssertExpCS(this);
	}

} //AssertExpCSImpl
