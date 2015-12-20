/**
 */
package org.eclipse.qvto.examples.xtext.imperativeoclcs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.*;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ForExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSFactory;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.RaiseExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeOCLCSFactoryImpl extends EFactoryImpl implements ImperativeOCLCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImperativeOCLCSFactory init() {
		try {
			ImperativeOCLCSFactory theImperativeOCLCSFactory = (ImperativeOCLCSFactory)EPackage.Registry.INSTANCE.getEFactory(ImperativeOCLCSPackage.eNS_URI);
			if (theImperativeOCLCSFactory != null) {
				return theImperativeOCLCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImperativeOCLCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLCSFactoryImpl() {
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
			case ImperativeOCLCSPackage.ASSERT_EXP_CS: return createAssertExpCS();
			case ImperativeOCLCSPackage.ASSIGN_STATEMENT_CS: return createAssignStatementCS();
			case ImperativeOCLCSPackage.BLOCK_EXP_CS: return createBlockExpCS();
			case ImperativeOCLCSPackage.DICT_LITERAL_EXP_CS: return createDictLiteralExpCS();
			case ImperativeOCLCSPackage.DICT_LITERAL_PART_CS: return createDictLiteralPartCS();
			case ImperativeOCLCSPackage.DICT_TYPE_CS: return createDictTypeCS();
			case ImperativeOCLCSPackage.COMPUTE_EXP_CS: return createComputeExpCS();
			case ImperativeOCLCSPackage.IMPERATIVE_ITERATE_EXP_CS: return createImperativeIterateExpCS();
			case ImperativeOCLCSPackage.IMPERATIVE_LOOP_EXP_CS: return createImperativeLoopExpCS();
			case ImperativeOCLCSPackage.INSTANTIATION_EXP_CS: return createInstantiationExpCS();
			case ImperativeOCLCSPackage.DO_EXP_CS: return createDoExpCS();
			case ImperativeOCLCSPackage.EXCEPT_CS: return createExceptCS();
			case ImperativeOCLCSPackage.EXPRESSION_BLOCK_CS: return createExpressionBlockCS();
			case ImperativeOCLCSPackage.EXPRESSION_STATEMENT_CS: return createExpressionStatementCS();
			case ImperativeOCLCSPackage.FOR_EXP_CS: return createForExpCS();
			case ImperativeOCLCSPackage.LIST_TYPE_CS: return createListTypeCS();
			case ImperativeOCLCSPackage.LIST_LITERAL_EXP_CS: return createListLiteralExpCS();
			case ImperativeOCLCSPackage.LOG_EXP_CS: return createLogExpCS();
			case ImperativeOCLCSPackage.QUIT_EXP_CS: return createQuitExpCS();
			case ImperativeOCLCSPackage.RAISE_EXP_CS: return createRaiseExpCS();
			case ImperativeOCLCSPackage.RETURN_EXP_CS: return createReturnExpCS();
			case ImperativeOCLCSPackage.SWITCH_ALT_CS: return createSwitchAltCS();
			case ImperativeOCLCSPackage.SWITCH_EXP_CS: return createSwitchExpCS();
			case ImperativeOCLCSPackage.TRY_EXP_CS: return createTryExpCS();
			case ImperativeOCLCSPackage.VARIABLE_INITIALIZATION_CS: return createVariableInitializationCS();
			case ImperativeOCLCSPackage.WHILE_EXP_CS: return createWhileExpCS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertExpCS createAssertExpCS() {
		AssertExpCSImpl assertExpCS = new AssertExpCSImpl();
		return assertExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignStatementCS createAssignStatementCS() {
		AssignStatementCSImpl assignStatementCS = new AssignStatementCSImpl();
		return assignStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockExpCS createBlockExpCS() {
		BlockExpCSImpl blockExpCS = new BlockExpCSImpl();
		return blockExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralExpCS createDictLiteralExpCS() {
		DictLiteralExpCSImpl dictLiteralExpCS = new DictLiteralExpCSImpl();
		return dictLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictLiteralPartCS createDictLiteralPartCS() {
		DictLiteralPartCSImpl dictLiteralPartCS = new DictLiteralPartCSImpl();
		return dictLiteralPartCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DictTypeCS createDictTypeCS() {
		DictTypeCSImpl dictTypeCS = new DictTypeCSImpl();
		return dictTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeExpCS createComputeExpCS() {
		ComputeExpCSImpl computeExpCS = new ComputeExpCSImpl();
		return computeExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeIterateExpCS createImperativeIterateExpCS() {
		ImperativeIterateExpCSImpl imperativeIterateExpCS = new ImperativeIterateExpCSImpl();
		return imperativeIterateExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeLoopExpCS createImperativeLoopExpCS() {
		ImperativeLoopExpCSImpl imperativeLoopExpCS = new ImperativeLoopExpCSImpl();
		return imperativeLoopExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstantiationExpCS createInstantiationExpCS() {
		InstantiationExpCSImpl instantiationExpCS = new InstantiationExpCSImpl();
		return instantiationExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoExpCS createDoExpCS() {
		DoExpCSImpl doExpCS = new DoExpCSImpl();
		return doExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExceptCS createExceptCS() {
		ExceptCSImpl exceptCS = new ExceptCSImpl();
		return exceptCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionBlockCS createExpressionBlockCS() {
		ExpressionBlockCSImpl expressionBlockCS = new ExpressionBlockCSImpl();
		return expressionBlockCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatementCS createExpressionStatementCS() {
		ExpressionStatementCSImpl expressionStatementCS = new ExpressionStatementCSImpl();
		return expressionStatementCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForExpCS createForExpCS() {
		ForExpCSImpl forExpCS = new ForExpCSImpl();
		return forExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListTypeCS createListTypeCS() {
		ListTypeCSImpl listTypeCS = new ListTypeCSImpl();
		return listTypeCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListLiteralExpCS createListLiteralExpCS() {
		ListLiteralExpCSImpl listLiteralExpCS = new ListLiteralExpCSImpl();
		return listLiteralExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogExpCS createLogExpCS() {
		LogExpCSImpl logExpCS = new LogExpCSImpl();
		return logExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuitExpCS createQuitExpCS() {
		QuitExpCSImpl quitExpCS = new QuitExpCSImpl();
		return quitExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RaiseExpCS createRaiseExpCS() {
		RaiseExpCSImpl raiseExpCS = new RaiseExpCSImpl();
		return raiseExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnExpCS createReturnExpCS() {
		ReturnExpCSImpl returnExpCS = new ReturnExpCSImpl();
		return returnExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchAltCS createSwitchAltCS() {
		SwitchAltCSImpl switchAltCS = new SwitchAltCSImpl();
		return switchAltCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpCS createSwitchExpCS() {
		SwitchExpCSImpl switchExpCS = new SwitchExpCSImpl();
		return switchExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TryExpCS createTryExpCS() {
		TryExpCSImpl tryExpCS = new TryExpCSImpl();
		return tryExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableInitializationCS createVariableInitializationCS() {
		VariableInitializationCSImpl variableInitializationCS = new VariableInitializationCSImpl();
		return variableInitializationCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileExpCS createWhileExpCS() {
		WhileExpCSImpl whileExpCS = new WhileExpCSImpl();
		return whileExpCS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLCSPackage getImperativeOCLCSPackage() {
		return (ImperativeOCLCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImperativeOCLCSPackage getPackage() {
		return ImperativeOCLCSPackage.eINSTANCE;
	}

} //ImperativeOCLCSFactoryImpl
