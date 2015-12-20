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
import org.eclipse.ocl.xtext.basecs.impl.OperationCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.util.QVTOperationalCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getResults <em>Results</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#isIsQuery <em>Is Query</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getWhen <em>When</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getWhere <em>Where</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getInherits <em>Inherits</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getDisjuncts <em>Disjuncts</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getMerges <em>Merges</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl.MappingOperationCSImpl#getScopedName <em>Scoped Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingOperationCSImpl extends OperationCSImpl implements MappingOperationCS {
	/**
	 * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResults()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDeclarationCS> results;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionKindCS DIRECTION_EDEFAULT = DirectionKindCS.IN;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionKindCS direction = DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_QUERY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsQuery() <em>Is Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsQuery()
	 * @generated
	 * @ordered
	 */
	protected boolean isQuery = IS_QUERY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected BlockExpCS when;

	/**
	 * The cached value of the '{@link #getWhere() <em>Where</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere()
	 * @generated
	 * @ordered
	 */
	protected BlockExpCS where;

	/**
	 * The cached value of the '{@link #getInherits() <em>Inherits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInherits()
	 * @generated
	 * @ordered
	 */
	protected EList<PathName2CS> inherits;

	/**
	 * The cached value of the '{@link #getDisjuncts() <em>Disjuncts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisjuncts()
	 * @generated
	 * @ordered
	 */
	protected EList<PathName2CS> disjuncts;

	/**
	 * The cached value of the '{@link #getMerges() <em>Merges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMerges()
	 * @generated
	 * @ordered
	 */
	protected EList<PathName2CS> merges;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected PathName2CS refines;

	/**
	 * The cached value of the '{@link #getScopedName() <em>Scoped Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopedName()
	 * @generated
	 * @ordered
	 */
	protected PathName2CS scopedName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTOperationalCSPackage.Literals.MAPPING_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDeclarationCS> getResults() {
		if (results == null) {
			results = new EObjectContainmentEList<ParameterDeclarationCS>(ParameterDeclarationCS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS);
		}
		return results;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionKindCS getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(DirectionKindCS newDirection) {
		DirectionKindCS oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsQuery() {
		return isQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsQuery(boolean newIsQuery) {
		boolean oldIsQuery = isQuery;
		isQuery = newIsQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY, oldIsQuery, isQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(BlockExpCS newWhen, NotificationChain msgs) {
		BlockExpCS oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(BlockExpCS newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS getWhere() {
		return where;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhere(BlockExpCS newWhere, NotificationChain msgs) {
		BlockExpCS oldWhere = where;
		where = newWhere;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE, oldWhere, newWhere);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhere(BlockExpCS newWhere) {
		if (newWhere != where) {
			NotificationChain msgs = null;
			if (where != null)
				msgs = ((InternalEObject)where).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE, null, msgs);
			if (newWhere != null)
				msgs = ((InternalEObject)newWhere).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE, null, msgs);
			msgs = basicSetWhere(newWhere, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE, newWhere, newWhere));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathName2CS> getInherits() {
		if (inherits == null) {
			inherits = new EObjectContainmentEList<PathName2CS>(PathName2CS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS);
		}
		return inherits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathName2CS> getDisjuncts() {
		if (disjuncts == null) {
			disjuncts = new EObjectContainmentEList<PathName2CS>(PathName2CS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS);
		}
		return disjuncts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PathName2CS> getMerges() {
		if (merges == null) {
			merges = new EObjectContainmentEList<PathName2CS>(PathName2CS.class, this, QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES);
		}
		return merges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathName2CS getRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRefines(PathName2CS newRefines, NotificationChain msgs) {
		PathName2CS oldRefines = refines;
		refines = newRefines;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES, oldRefines, newRefines);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefines(PathName2CS newRefines) {
		if (newRefines != refines) {
			NotificationChain msgs = null;
			if (refines != null)
				msgs = ((InternalEObject)refines).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES, null, msgs);
			if (newRefines != null)
				msgs = ((InternalEObject)newRefines).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES, null, msgs);
			msgs = basicSetRefines(newRefines, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES, newRefines, newRefines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathName2CS getScopedName() {
		return scopedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScopedName(PathName2CS newScopedName, NotificationChain msgs) {
		PathName2CS oldScopedName = scopedName;
		scopedName = newScopedName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME, oldScopedName, newScopedName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopedName(PathName2CS newScopedName) {
		if (newScopedName != scopedName) {
			NotificationChain msgs = null;
			if (scopedName != null)
				msgs = ((InternalEObject)scopedName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME, null, msgs);
			if (newScopedName != null)
				msgs = ((InternalEObject)newScopedName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME, null, msgs);
			msgs = basicSetScopedName(newScopedName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME, newScopedName, newScopedName));
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS:
				return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN:
				return basicSetWhen(null, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE:
				return basicSetWhere(null, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS:
				return ((InternalEList<?>)getInherits()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS:
				return ((InternalEList<?>)getDisjuncts()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES:
				return ((InternalEList<?>)getMerges()).basicRemove(otherEnd, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES:
				return basicSetRefines(null, msgs);
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME:
				return basicSetScopedName(null, msgs);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS:
				return getResults();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION:
				return getDirection();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				return isIsQuery();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN:
				return getWhen();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE:
				return getWhere();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS:
				return getInherits();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS:
				return getDisjuncts();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES:
				return getMerges();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES:
				return getRefines();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME:
				return getScopedName();
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS:
				getResults().clear();
				getResults().addAll((Collection<? extends ParameterDeclarationCS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION:
				setDirection((DirectionKindCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				setIsQuery((Boolean)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN:
				setWhen((BlockExpCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE:
				setWhere((BlockExpCS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS:
				getInherits().clear();
				getInherits().addAll((Collection<? extends PathName2CS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS:
				getDisjuncts().clear();
				getDisjuncts().addAll((Collection<? extends PathName2CS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES:
				getMerges().clear();
				getMerges().addAll((Collection<? extends PathName2CS>)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES:
				setRefines((PathName2CS)newValue);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME:
				setScopedName((PathName2CS)newValue);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS:
				getResults().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				setIsQuery(IS_QUERY_EDEFAULT);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN:
				setWhen((BlockExpCS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE:
				setWhere((BlockExpCS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS:
				getInherits().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS:
				getDisjuncts().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES:
				getMerges().clear();
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES:
				setRefines((PathName2CS)null);
				return;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME:
				setScopedName((PathName2CS)null);
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
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__RESULTS:
				return results != null && !results.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__IS_QUERY:
				return isQuery != IS_QUERY_EDEFAULT;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHEN:
				return when != null;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__WHERE:
				return where != null;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__INHERITS:
				return inherits != null && !inherits.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__DISJUNCTS:
				return disjuncts != null && !disjuncts.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__MERGES:
				return merges != null && !merges.isEmpty();
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__REFINES:
				return refines != null;
			case QVTOperationalCSPackage.MAPPING_OPERATION_CS__SCOPED_NAME:
				return scopedName != null;
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
		return (R) ((QVTOperationalCSVisitor<?>)visitor).visitMappingOperationCS(this);
	}

} //MappingOperationCSImpl
