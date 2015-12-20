/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ImperativeOCLFactoryImpl.java,v 1.4 2009/12/09 12:45:12 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.*;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SeverityKind;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.Typedef;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeOCLFactoryImpl extends EFactoryImpl implements ImperativeOCLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImperativeOCLFactory init() {
		try {
			ImperativeOCLFactory theImperativeOCLFactory = (ImperativeOCLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/qvt/1.0/ImperativeOCL"); //$NON-NLS-1$ 
			if (theImperativeOCLFactory != null) {
				return theImperativeOCLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImperativeOCLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLFactoryImpl() {
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
			case ImperativeOCLPackage.ALT_EXP: return createAltExp();
			case ImperativeOCLPackage.ASSERT_EXP: return createAssertExp();
			case ImperativeOCLPackage.ASSIGN_EXP: return createAssignExp();
			case ImperativeOCLPackage.BLOCK_EXP: return createBlockExp();
			case ImperativeOCLPackage.BREAK_EXP: return createBreakExp();
			case ImperativeOCLPackage.CATCH_EXP: return createCatchExp();
			case ImperativeOCLPackage.COMPUTE_EXP: return createComputeExp();
			case ImperativeOCLPackage.CONTINUE_EXP: return createContinueExp();
			case ImperativeOCLPackage.DICT_LITERAL_EXP: return createDictLiteralExp();
			case ImperativeOCLPackage.DICT_LITERAL_PART: return createDictLiteralPart();
			case ImperativeOCLPackage.DICTIONARY_TYPE: return createDictionaryType();
			case ImperativeOCLPackage.FOR_EXP: return createForExp();
			case ImperativeOCLPackage.IMPERATIVE_ITERATE_EXP: return createImperativeIterateExp();
			case ImperativeOCLPackage.INSTANTIATION_EXP: return createInstantiationExp();
			case ImperativeOCLPackage.LIST_LITERAL_EXP: return createListLiteralExp();
			case ImperativeOCLPackage.LIST_TYPE: return createListType();
			case ImperativeOCLPackage.LOG_EXP: return createLogExp();
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_EXP: return createOrderedTupleLiteralExp();
			case ImperativeOCLPackage.ORDERED_TUPLE_LITERAL_PART: return createOrderedTupleLiteralPart();
			case ImperativeOCLPackage.ORDERED_TUPLE_TYPE: return createOrderedTupleType();
			case ImperativeOCLPackage.RAISE_EXP: return createRaiseExp();
			case ImperativeOCLPackage.RETURN_EXP: return createReturnExp();
			case ImperativeOCLPackage.SWITCH_EXP: return createSwitchExp();
			case ImperativeOCLPackage.TRY_EXP: return createTryExp();
			case ImperativeOCLPackage.TYPEDEF: return createTypedef();
			case ImperativeOCLPackage.UNLINK_EXP: return createUnlinkExp();
			case ImperativeOCLPackage.UNPACK_EXP: return createUnpackExp();
			case ImperativeOCLPackage.VARIABLE_INIT_EXP: return createVariableInitExp();
			case ImperativeOCLPackage.WHILE_EXP: return createWhileExp();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ImperativeOCLPackage.SEVERITY_KIND:
				return createSeverityKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ImperativeOCLPackage.SEVERITY_KIND:
				return convertSeverityKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AltExp createAltExp() {
		AltExpImpl altExp = new AltExpImpl();
		return altExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertExp createAssertExp() {
		AssertExpImpl assertExp = new AssertExpImpl();
		return assertExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignExp createAssignExp() {
		AssignExpImpl assignExp = new AssignExpImpl();
		return assignExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExp createBlockExp() {
		BlockExpImpl blockExp = new BlockExpImpl();
		return blockExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakExp createBreakExp() {
		BreakExpImpl breakExp = new BreakExpImpl();
		return breakExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatchExp createCatchExp() {
		CatchExpImpl catchExp = new CatchExpImpl();
		return catchExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeExp createComputeExp() {
		ComputeExpImpl computeExp = new ComputeExpImpl();
		return computeExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueExp createContinueExp() {
		ContinueExpImpl continueExp = new ContinueExpImpl();
		return continueExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralExp createDictLiteralExp() {
		DictLiteralExpImpl dictLiteralExp = new DictLiteralExpImpl();
		return dictLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralPart createDictLiteralPart() {
		DictLiteralPartImpl dictLiteralPart = new DictLiteralPartImpl();
		return dictLiteralPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictionaryType createDictionaryType() {
		DictionaryTypeImpl dictionaryType = new DictionaryTypeImpl();
		return dictionaryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForExp createForExp() {
		ForExpImpl forExp = new ForExpImpl();
		return forExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeIterateExp createImperativeIterateExp() {
		ImperativeIterateExpImpl imperativeIterateExp = new ImperativeIterateExpImpl();
		return imperativeIterateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationExp createInstantiationExp() {
		InstantiationExpImpl instantiationExp = new InstantiationExpImpl();
		return instantiationExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @since 3.0
	 */
	public ListLiteralExp createListLiteralExp() {
		ListLiteralExpImpl listLiteralExp = new ListLiteralExpImpl();
		return listLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListType createListType() {
		ListTypeImpl listType = new ListTypeImpl();
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogExp createLogExp() {
		LogExpImpl logExp = new LogExpImpl();
		return logExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedTupleLiteralExp createOrderedTupleLiteralExp() {
		OrderedTupleLiteralExpImpl orderedTupleLiteralExp = new OrderedTupleLiteralExpImpl();
		return orderedTupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedTupleLiteralPart createOrderedTupleLiteralPart() {
		OrderedTupleLiteralPartImpl orderedTupleLiteralPart = new OrderedTupleLiteralPartImpl();
		return orderedTupleLiteralPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedTupleType createOrderedTupleType() {
		OrderedTupleTypeImpl orderedTupleType = new OrderedTupleTypeImpl();
		return orderedTupleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RaiseExp createRaiseExp() {
		RaiseExpImpl raiseExp = new RaiseExpImpl();
		return raiseExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnExp createReturnExp() {
		ReturnExpImpl returnExp = new ReturnExpImpl();
		return returnExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExp createSwitchExp() {
		SwitchExpImpl switchExp = new SwitchExpImpl();
		return switchExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TryExp createTryExp() {
		TryExpImpl tryExp = new TryExpImpl();
		return tryExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Typedef createTypedef() {
		TypedefImpl typedef = new TypedefImpl();
		return typedef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnlinkExp createUnlinkExp() {
		UnlinkExpImpl unlinkExp = new UnlinkExpImpl();
		return unlinkExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnpackExp createUnpackExp() {
		UnpackExpImpl unpackExp = new UnpackExpImpl();
		return unpackExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitExp createVariableInitExp() {
		VariableInitExpImpl variableInitExp = new VariableInitExpImpl();
		return variableInitExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExp createWhileExp() {
		WhileExpImpl whileExp = new WhileExpImpl();
		return whileExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeverityKind createSeverityKindFromString(EDataType eDataType, String initialValue) {
		SeverityKind result = SeverityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSeverityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLPackage getImperativeOCLPackage() {
		return (ImperativeOCLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImperativeOCLPackage getPackage() {
		return ImperativeOCLPackage.eINSTANCE;
	}

} //ImperativeOCLFactoryImpl
