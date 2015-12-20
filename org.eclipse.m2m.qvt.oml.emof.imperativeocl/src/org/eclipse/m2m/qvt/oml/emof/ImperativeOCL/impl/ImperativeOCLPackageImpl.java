/**
 * <copyright>
 * </copyright>
 *
 * $Id: ImperativeOCLPackageImpl.java,v 1.3 2009/12/09 14:03:56 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.DictionaryType;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeLoopExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLFactory;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListLiteralExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.OrderedTupleType;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SeverityKind;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.Typedef;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.WhileExp;
import org.eclipse.qvt.declarative.emof.EMOF.EMOFPackage;
import org.eclipse.qvt.declarative.emof.EssentialOCL.EssentialOCLPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImperativeOCLPackageImpl extends EPackageImpl implements ImperativeOCLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass altExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeIterateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeLoopExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleLiteralExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleLiteralPartEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedTupleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass raiseExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unlinkExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unpackExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum severityKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.m2m.qvt.oml.emof.ImperativeOCL.ImperativeOCLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ImperativeOCLPackageImpl() {
		super(eNS_URI, ImperativeOCLFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ImperativeOCLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ImperativeOCLPackage init() {
		if (isInited) return (ImperativeOCLPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLPackage.eNS_URI);

		// Obtain or create and register package
		ImperativeOCLPackageImpl theImperativeOCLPackage = (ImperativeOCLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ImperativeOCLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ImperativeOCLPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EssentialOCLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theImperativeOCLPackage.createPackageContents();

		// Initialize created meta-data
		theImperativeOCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theImperativeOCLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ImperativeOCLPackage.eNS_URI, theImperativeOCLPackage);
		return theImperativeOCLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAltExp() {
		return altExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAltExp_Body() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAltExp_Condition() {
		return (EReference)altExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertExp() {
		return assertExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExp_Assertion() {
		return (EReference)assertExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExp_Log() {
		return (EReference)assertExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertExp_Severity() {
		return (EAttribute)assertExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignExp() {
		return assignExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_DefaultValue() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignExp_IsReset() {
		return (EAttribute)assignExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_Left() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignExp_Value() {
		return (EReference)assignExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockExp() {
		return blockExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockExp_Body() {
		return (EReference)blockExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakExp() {
		return breakExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatchExp() {
		return catchExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExp_Body() {
		return (EReference)catchExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExp_Exception() {
		return (EReference)catchExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeExp() {
		return computeExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExp_Body() {
		return (EReference)computeExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExp_ReturnedElement() {
		return (EReference)computeExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinueExp() {
		return continueExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralExp() {
		return dictLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralExp_Part() {
		return (EReference)dictLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralPart() {
		return dictLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPart_Key() {
		return (EReference)dictLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPart_Value() {
		return (EReference)dictLiteralPartEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictionaryType() {
		return dictionaryTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictionaryType_KeyType() {
		return (EReference)dictionaryTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForExp() {
		return forExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeExpression() {
		return imperativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeIterateExp() {
		return imperativeIterateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeIterateExp_Target() {
		return (EReference)imperativeIterateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeLoopExp() {
		return imperativeLoopExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeLoopExp_Condition() {
		return (EReference)imperativeLoopExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiationExp() {
		return instantiationExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_Argument() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_Extent() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExp_InstantiatedClass() {
		return (EReference)instantiationExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListLiteralExp() {
		return listLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListLiteralExp_Element() {
		return (EReference)listLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogExp() {
		return logExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogExp_Condition() {
		return (EReference)logExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleLiteralExp() {
		return orderedTupleLiteralExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleLiteralExp_Part() {
		return (EReference)orderedTupleLiteralExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleLiteralPart() {
		return orderedTupleLiteralPartEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleLiteralPart_Value() {
		return (EReference)orderedTupleLiteralPartEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedTupleType() {
		return orderedTupleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOrderedTupleType_ElementType() {
		return (EReference)orderedTupleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRaiseExp() {
		return raiseExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExp_Argument() {
		return (EReference)raiseExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExp_Exception() {
		return (EReference)raiseExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnExp() {
		return returnExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnExp_Value() {
		return (EReference)returnExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchExp() {
		return switchExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExp_AlternativePart() {
		return (EReference)switchExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExp_ElsePart() {
		return (EReference)switchExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTryExp() {
		return tryExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExp_ExceptClause() {
		return (EReference)tryExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExp_TryBody() {
		return (EReference)tryExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedef() {
		return typedefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedef_Base() {
		return (EReference)typedefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedef_Condition() {
		return (EReference)typedefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnlinkExp() {
		return unlinkExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnlinkExp_Item() {
		return (EReference)unlinkExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnlinkExp_Target() {
		return (EReference)unlinkExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnpackExp() {
		return unpackExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnpackExp_Source() {
		return (EReference)unpackExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnpackExp_TargetVariable() {
		return (EReference)unpackExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitExp() {
		return variableInitExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitExp_ReferredVariable() {
		return (EReference)variableInitExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableInitExp_WithResult() {
		return (EAttribute)variableInitExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileExp() {
		return whileExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExp_Body() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExp_Condition() {
		return (EReference)whileExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSeverityKind() {
		return severityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeOCLFactory getImperativeOCLFactory() {
		return (ImperativeOCLFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		altExpEClass = createEClass(ALT_EXP);
		createEReference(altExpEClass, ALT_EXP__BODY);
		createEReference(altExpEClass, ALT_EXP__CONDITION);

		assertExpEClass = createEClass(ASSERT_EXP);
		createEReference(assertExpEClass, ASSERT_EXP__ASSERTION);
		createEReference(assertExpEClass, ASSERT_EXP__LOG);
		createEAttribute(assertExpEClass, ASSERT_EXP__SEVERITY);

		assignExpEClass = createEClass(ASSIGN_EXP);
		createEReference(assignExpEClass, ASSIGN_EXP__DEFAULT_VALUE);
		createEAttribute(assignExpEClass, ASSIGN_EXP__IS_RESET);
		createEReference(assignExpEClass, ASSIGN_EXP__LEFT);
		createEReference(assignExpEClass, ASSIGN_EXP__VALUE);

		blockExpEClass = createEClass(BLOCK_EXP);
		createEReference(blockExpEClass, BLOCK_EXP__BODY);

		breakExpEClass = createEClass(BREAK_EXP);

		catchExpEClass = createEClass(CATCH_EXP);
		createEReference(catchExpEClass, CATCH_EXP__BODY);
		createEReference(catchExpEClass, CATCH_EXP__EXCEPTION);

		computeExpEClass = createEClass(COMPUTE_EXP);
		createEReference(computeExpEClass, COMPUTE_EXP__BODY);
		createEReference(computeExpEClass, COMPUTE_EXP__RETURNED_ELEMENT);

		continueExpEClass = createEClass(CONTINUE_EXP);

		dictLiteralExpEClass = createEClass(DICT_LITERAL_EXP);
		createEReference(dictLiteralExpEClass, DICT_LITERAL_EXP__PART);

		dictLiteralPartEClass = createEClass(DICT_LITERAL_PART);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__KEY);
		createEReference(dictLiteralPartEClass, DICT_LITERAL_PART__VALUE);

		dictionaryTypeEClass = createEClass(DICTIONARY_TYPE);
		createEReference(dictionaryTypeEClass, DICTIONARY_TYPE__KEY_TYPE);

		forExpEClass = createEClass(FOR_EXP);

		imperativeExpressionEClass = createEClass(IMPERATIVE_EXPRESSION);

		imperativeIterateExpEClass = createEClass(IMPERATIVE_ITERATE_EXP);
		createEReference(imperativeIterateExpEClass, IMPERATIVE_ITERATE_EXP__TARGET);

		imperativeLoopExpEClass = createEClass(IMPERATIVE_LOOP_EXP);
		createEReference(imperativeLoopExpEClass, IMPERATIVE_LOOP_EXP__CONDITION);

		instantiationExpEClass = createEClass(INSTANTIATION_EXP);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__ARGUMENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__EXTENT);
		createEReference(instantiationExpEClass, INSTANTIATION_EXP__INSTANTIATED_CLASS);

		listLiteralExpEClass = createEClass(LIST_LITERAL_EXP);
		createEReference(listLiteralExpEClass, LIST_LITERAL_EXP__ELEMENT);

		listTypeEClass = createEClass(LIST_TYPE);

		logExpEClass = createEClass(LOG_EXP);
		createEReference(logExpEClass, LOG_EXP__CONDITION);

		orderedTupleLiteralExpEClass = createEClass(ORDERED_TUPLE_LITERAL_EXP);
		createEReference(orderedTupleLiteralExpEClass, ORDERED_TUPLE_LITERAL_EXP__PART);

		orderedTupleLiteralPartEClass = createEClass(ORDERED_TUPLE_LITERAL_PART);
		createEReference(orderedTupleLiteralPartEClass, ORDERED_TUPLE_LITERAL_PART__VALUE);

		orderedTupleTypeEClass = createEClass(ORDERED_TUPLE_TYPE);
		createEReference(orderedTupleTypeEClass, ORDERED_TUPLE_TYPE__ELEMENT_TYPE);

		raiseExpEClass = createEClass(RAISE_EXP);
		createEReference(raiseExpEClass, RAISE_EXP__ARGUMENT);
		createEReference(raiseExpEClass, RAISE_EXP__EXCEPTION);

		returnExpEClass = createEClass(RETURN_EXP);
		createEReference(returnExpEClass, RETURN_EXP__VALUE);

		switchExpEClass = createEClass(SWITCH_EXP);
		createEReference(switchExpEClass, SWITCH_EXP__ALTERNATIVE_PART);
		createEReference(switchExpEClass, SWITCH_EXP__ELSE_PART);

		tryExpEClass = createEClass(TRY_EXP);
		createEReference(tryExpEClass, TRY_EXP__EXCEPT_CLAUSE);
		createEReference(tryExpEClass, TRY_EXP__TRY_BODY);

		typedefEClass = createEClass(TYPEDEF);
		createEReference(typedefEClass, TYPEDEF__BASE);
		createEReference(typedefEClass, TYPEDEF__CONDITION);

		unlinkExpEClass = createEClass(UNLINK_EXP);
		createEReference(unlinkExpEClass, UNLINK_EXP__ITEM);
		createEReference(unlinkExpEClass, UNLINK_EXP__TARGET);

		unpackExpEClass = createEClass(UNPACK_EXP);
		createEReference(unpackExpEClass, UNPACK_EXP__SOURCE);
		createEReference(unpackExpEClass, UNPACK_EXP__TARGET_VARIABLE);

		variableInitExpEClass = createEClass(VARIABLE_INIT_EXP);
		createEReference(variableInitExpEClass, VARIABLE_INIT_EXP__REFERRED_VARIABLE);
		createEAttribute(variableInitExpEClass, VARIABLE_INIT_EXP__WITH_RESULT);

		whileExpEClass = createEClass(WHILE_EXP);
		createEReference(whileExpEClass, WHILE_EXP__BODY);
		createEReference(whileExpEClass, WHILE_EXP__CONDITION);

		// Create enums
		severityKindEEnum = createEEnum(SEVERITY_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EssentialOCLPackage theEssentialOCLPackage = (EssentialOCLPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLPackage.eNS_URI);
		EMOFPackage theEMOFPackage = (EMOFPackage)EPackage.Registry.INSTANCE.getEPackage(EMOFPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		altExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assertExpEClass.getESuperTypes().add(this.getImperativeExpression());
		assignExpEClass.getESuperTypes().add(this.getImperativeExpression());
		blockExpEClass.getESuperTypes().add(this.getImperativeExpression());
		breakExpEClass.getESuperTypes().add(this.getImperativeExpression());
		catchExpEClass.getESuperTypes().add(this.getImperativeExpression());
		computeExpEClass.getESuperTypes().add(this.getImperativeExpression());
		continueExpEClass.getESuperTypes().add(this.getImperativeExpression());
		dictLiteralExpEClass.getESuperTypes().add(theEssentialOCLPackage.getLiteralExp());
		dictLiteralPartEClass.getESuperTypes().add(theEMOFPackage.getElement());
		dictionaryTypeEClass.getESuperTypes().add(theEssentialOCLPackage.getCollectionType());
		forExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeExpressionEClass.getESuperTypes().add(theEssentialOCLPackage.getOclExpression());
		imperativeIterateExpEClass.getESuperTypes().add(this.getImperativeLoopExp());
		imperativeLoopExpEClass.getESuperTypes().add(theEssentialOCLPackage.getLoopExp());
		imperativeLoopExpEClass.getESuperTypes().add(this.getImperativeExpression());
		instantiationExpEClass.getESuperTypes().add(this.getImperativeExpression());
		listLiteralExpEClass.getESuperTypes().add(theEssentialOCLPackage.getLiteralExp());
		listTypeEClass.getESuperTypes().add(theEssentialOCLPackage.getCollectionType());
		logExpEClass.getESuperTypes().add(theEssentialOCLPackage.getOperationCallExp());
		logExpEClass.getESuperTypes().add(this.getImperativeExpression());
		orderedTupleLiteralExpEClass.getESuperTypes().add(theEssentialOCLPackage.getLiteralExp());
		orderedTupleLiteralPartEClass.getESuperTypes().add(theEMOFPackage.getElement());
		orderedTupleTypeEClass.getESuperTypes().add(theEMOFPackage.getClass_());
		raiseExpEClass.getESuperTypes().add(this.getImperativeExpression());
		returnExpEClass.getESuperTypes().add(this.getImperativeExpression());
		switchExpEClass.getESuperTypes().add(this.getImperativeExpression());
		tryExpEClass.getESuperTypes().add(this.getImperativeExpression());
		typedefEClass.getESuperTypes().add(theEMOFPackage.getClass_());
		unlinkExpEClass.getESuperTypes().add(this.getImperativeExpression());
		unpackExpEClass.getESuperTypes().add(this.getImperativeExpression());
		variableInitExpEClass.getESuperTypes().add(this.getImperativeExpression());
		whileExpEClass.getESuperTypes().add(this.getImperativeExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(altExpEClass, AltExp.class, "AltExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAltExp_Body(), theEssentialOCLPackage.getOclExpression(), null, "body", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAltExp_Condition(), theEssentialOCLPackage.getOclExpression(), null, "condition", null, 1, 1, AltExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assertExpEClass, AssertExp.class, "AssertExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssertExp_Assertion(), theEssentialOCLPackage.getOclExpression(), null, "assertion", null, 1, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertExp_Log(), this.getLogExp(), null, "log", null, 0, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertExp_Severity(), this.getSeverityKind(), "severity", "error", 0, 1, AssertExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignExpEClass, AssignExp.class, "AssignExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignExp_DefaultValue(), theEssentialOCLPackage.getOclExpression(), null, "defaultValue", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignExp_IsReset(), theEMOFPackage.getBoolean(), "isReset", null, 0, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignExp_Left(), theEssentialOCLPackage.getOclExpression(), null, "left", null, 1, 1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignExp_Value(), theEssentialOCLPackage.getOclExpression(), null, "value", null, 0, -1, AssignExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockExpEClass, BlockExp.class, "BlockExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockExp_Body(), theEssentialOCLPackage.getOclExpression(), null, "body", null, 0, -1, BlockExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(breakExpEClass, BreakExp.class, "BreakExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(catchExpEClass, CatchExp.class, "CatchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCatchExp_Body(), theEssentialOCLPackage.getOclExpression(), null, "body", null, 0, -1, CatchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCatchExp_Exception(), theEMOFPackage.getType(), null, "exception", null, 0, -1, CatchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computeExpEClass, ComputeExp.class, "ComputeExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputeExp_Body(), theEssentialOCLPackage.getOclExpression(), null, "body", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComputeExp_ReturnedElement(), theEssentialOCLPackage.getVariable(), null, "returnedElement", null, 1, 1, ComputeExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(continueExpEClass, ContinueExp.class, "ContinueExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dictLiteralExpEClass, DictLiteralExp.class, "DictLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralExp_Part(), this.getDictLiteralPart(), null, "part", null, 0, -1, DictLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dictLiteralPartEClass, DictLiteralPart.class, "DictLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictLiteralPart_Key(), theEssentialOCLPackage.getOclExpression(), null, "key", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDictLiteralPart_Value(), theEssentialOCLPackage.getOclExpression(), null, "value", null, 1, 1, DictLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dictionaryTypeEClass, DictionaryType.class, "DictionaryType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictionaryType_KeyType(), theEMOFPackage.getType(), null, "keyType", null, 0, 1, DictionaryType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forExpEClass, ForExp.class, "ForExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeExpressionEClass, ImperativeExpression.class, "ImperativeExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeIterateExpEClass, ImperativeIterateExp.class, "ImperativeIterateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeIterateExp_Target(), theEssentialOCLPackage.getVariable(), null, "target", null, 0, 1, ImperativeIterateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeLoopExpEClass, ImperativeLoopExp.class, "ImperativeLoopExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeLoopExp_Condition(), theEssentialOCLPackage.getOclExpression(), null, "condition", null, 0, 1, ImperativeLoopExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(instantiationExpEClass, InstantiationExp.class, "InstantiationExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstantiationExp_Argument(), theEssentialOCLPackage.getOclExpression(), null, "argument", null, 0, -1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantiationExp_Extent(), theEssentialOCLPackage.getVariable(), null, "extent", null, 0, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstantiationExp_InstantiatedClass(), theEMOFPackage.getClass_(), null, "instantiatedClass", null, 1, 1, InstantiationExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listLiteralExpEClass, ListLiteralExp.class, "ListLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListLiteralExp_Element(), theEssentialOCLPackage.getOclExpression(), null, "element", null, 0, -1, ListLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logExpEClass, LogExp.class, "LogExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogExp_Condition(), theEssentialOCLPackage.getOclExpression(), null, "condition", null, 0, 1, LogExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderedTupleLiteralExpEClass, OrderedTupleLiteralExp.class, "OrderedTupleLiteralExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleLiteralExp_Part(), this.getOrderedTupleLiteralPart(), null, "part", null, 0, -1, OrderedTupleLiteralExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderedTupleLiteralPartEClass, OrderedTupleLiteralPart.class, "OrderedTupleLiteralPart", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleLiteralPart_Value(), theEssentialOCLPackage.getOclExpression(), null, "value", null, 1, 1, OrderedTupleLiteralPart.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orderedTupleTypeEClass, OrderedTupleType.class, "OrderedTupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOrderedTupleType_ElementType(), theEMOFPackage.getType(), null, "elementType", null, 0, -1, OrderedTupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(raiseExpEClass, RaiseExp.class, "RaiseExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRaiseExp_Argument(), theEssentialOCLPackage.getOclExpression(), null, "argument", null, 0, 1, RaiseExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRaiseExp_Exception(), theEMOFPackage.getType(), null, "exception", null, 1, 1, RaiseExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnExpEClass, ReturnExp.class, "ReturnExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnExp_Value(), theEssentialOCLPackage.getOclExpression(), null, "value", null, 0, 1, ReturnExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchExpEClass, SwitchExp.class, "SwitchExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchExp_AlternativePart(), this.getAltExp(), null, "alternativePart", null, 0, -1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExp_ElsePart(), theEssentialOCLPackage.getOclExpression(), null, "elsePart", null, 0, 1, SwitchExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tryExpEClass, TryExp.class, "TryExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTryExp_ExceptClause(), this.getCatchExp(), null, "exceptClause", null, 0, -1, TryExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTryExp_TryBody(), theEssentialOCLPackage.getOclExpression(), null, "tryBody", null, 0, -1, TryExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedefEClass, Typedef.class, "Typedef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedef_Base(), theEMOFPackage.getType(), null, "base", null, 1, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedef_Condition(), theEssentialOCLPackage.getOclExpression(), null, "condition", null, 0, 1, Typedef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unlinkExpEClass, UnlinkExp.class, "UnlinkExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnlinkExp_Item(), theEssentialOCLPackage.getOclExpression(), null, "item", null, 1, 1, UnlinkExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnlinkExp_Target(), theEssentialOCLPackage.getOclExpression(), null, "target", null, 1, 1, UnlinkExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unpackExpEClass, UnpackExp.class, "UnpackExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnpackExp_Source(), theEssentialOCLPackage.getOclExpression(), null, "source", null, 1, 1, UnpackExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnpackExp_TargetVariable(), theEssentialOCLPackage.getVariable(), null, "targetVariable", null, 1, -1, UnpackExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableInitExpEClass, VariableInitExp.class, "VariableInitExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableInitExp_ReferredVariable(), theEssentialOCLPackage.getVariable(), null, "referredVariable", null, 1, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableInitExp_WithResult(), theEMOFPackage.getBoolean(), "withResult", "false", 0, 1, VariableInitExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileExpEClass, WhileExp.class, "WhileExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileExp_Body(), theEssentialOCLPackage.getOclExpression(), null, "body", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileExp_Condition(), theEssentialOCLPackage.getOclExpression(), null, "condition", null, 1, 1, WhileExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(severityKindEEnum, SeverityKind.class, "SeverityKind");
		addEEnumLiteral(severityKindEEnum, SeverityKind.ERROR);
		addEEnumLiteral(severityKindEEnum, SeverityKind.WARNING);
		addEEnumLiteral(severityKindEEnum, SeverityKind.FATAL);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";		
		addAnnotation
		  (getAltExp_Body(), 
		   source, 
		   new String[] {
			 "body", "altBodyOwner"
		   });		
		addAnnotation
		  (getAltExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "altCondOwner"
		   });		
		addAnnotation
		  (getAssertExp_Assertion(), 
		   source, 
		   new String[] {
			 "body", "assertOwner"
		   });		
		addAnnotation
		  (getAssignExp_DefaultValue(), 
		   source, 
		   new String[] {
			 "body", "defaultOwner"
		   });		
		addAnnotation
		  (getAssignExp_Left(), 
		   source, 
		   new String[] {
			 "body", "leftOwner"
		   });		
		addAnnotation
		  (getAssignExp_Value(), 
		   source, 
		   new String[] {
			 "body", "valueOwner"
		   });		
		addAnnotation
		  (getBlockExp_Body(), 
		   source, 
		   new String[] {
			 "body", "blockOwner"
		   });		
		addAnnotation
		  (getCatchExp_Exception(), 
		   source, 
		   new String[] {
			 "body", "tryExpression"
		   });		
		addAnnotation
		  (getComputeExp_Body(), 
		   source, 
		   new String[] {
			 "body", "computeOwner"
		   });		
		addAnnotation
		  (getComputeExp_ReturnedElement(), 
		   source, 
		   new String[] {
			 "body", "computeOwner"
		   });		
		addAnnotation
		  (getDictLiteralExp_Part(), 
		   source, 
		   new String[] {
			 "body", "partOwner"
		   });		
		addAnnotation
		  (getDictLiteralPart_Key(), 
		   source, 
		   new String[] {
			 "body", "keyOwner"
		   });		
		addAnnotation
		  (getDictLiteralPart_Value(), 
		   source, 
		   new String[] {
			 "body", "valOwner"
		   });		
		addAnnotation
		  (getDictionaryType_KeyType(), 
		   source, 
		   new String[] {
			 "body", "keyDict"
		   });		
		addAnnotation
		  (getImperativeIterateExp_Target(), 
		   source, 
		   new String[] {
			 "body", "tgtOwner"
		   });		
		addAnnotation
		  (getImperativeLoopExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "loopCondOwner"
		   });		
		addAnnotation
		  (getInstantiationExp_Argument(), 
		   source, 
		   new String[] {
			 "body", "argOwner"
		   });		
		addAnnotation
		  (getListLiteralExp_Element(), 
		   source, 
		   new String[] {
			 "body", "elementOwner"
		   });		
		addAnnotation
		  (getLogExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "logOwner"
		   });		
		addAnnotation
		  (getOrderedTupleLiteralExp_Part(), 
		   source, 
		   new String[] {
			 "body", "partOwner"
		   });		
		addAnnotation
		  (getOrderedTupleLiteralPart_Value(), 
		   source, 
		   new String[] {
			 "body", "tupValOwner"
		   });		
		addAnnotation
		  (getOrderedTupleType_ElementType(), 
		   source, 
		   new String[] {
			 "body", "eltTuple"
		   });		
		addAnnotation
		  (getRaiseExp_Exception(), 
		   source, 
		   new String[] {
			 "body", "raiseExpression"
		   });		
		addAnnotation
		  (getSwitchExp_AlternativePart(), 
		   source, 
		   new String[] {
			 "body", "altOwner"
		   });		
		addAnnotation
		  (getSwitchExp_ElsePart(), 
		   source, 
		   new String[] {
			 "body", "elsePartOwner"
		   });		
		addAnnotation
		  (getTryExp_ExceptClause(), 
		   source, 
		   new String[] {
			 "body", "exceptOwner"
		   });		
		addAnnotation
		  (getTryExp_TryBody(), 
		   source, 
		   new String[] {
			 "body", "tryBodyOwner"
		   });		
		addAnnotation
		  (getUnlinkExp_Item(), 
		   source, 
		   new String[] {
			 "body", "itemUnlink"
		   });		
		addAnnotation
		  (getUnlinkExp_Target(), 
		   source, 
		   new String[] {
			 "body", "tgtUnlink"
		   });		
		addAnnotation
		  (getVariableInitExp_ReferredVariable(), 
		   source, 
		   new String[] {
			 "body", "declaration"
		   });		
		addAnnotation
		  (getWhileExp_Body(), 
		   source, 
		   new String[] {
			 "body", "whileOwner"
		   });		
		addAnnotation
		  (getWhileExp_Condition(), 
		   source, 
		   new String[] {
			 "body", "whileExpression"
		   });
	}

} //ImperativeOCLPackageImpl
