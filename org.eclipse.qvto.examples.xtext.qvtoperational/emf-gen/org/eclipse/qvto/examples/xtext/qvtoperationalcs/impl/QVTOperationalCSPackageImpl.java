/**
 */
package org.eclipse.qvto.examples.xtext.qvtoperationalcs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeOCLCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierKind;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierProperty2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ClassifierPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.CompleteSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConfigPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ConstructorCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ContextualPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.DirectionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ElementWithBody;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ExceptionCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.FeatureKey;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImperativeOperationCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ImportKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitOp;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.InitPartCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.LibraryImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.LocalPropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingBodyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingCallExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingEndCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingExtensionKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingInitCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingMethodCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingQueryCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingRuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MappingSectionsCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MetamodelKind;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModelTypeRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleKindEnum;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModulePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ModuleUsageCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.MultiplicityDefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ObjectExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.OppositePropertyCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PackageRefCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ParameterDeclarationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathName2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PrimitiveTypeCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSFactory;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToClassCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToImportCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToLibraryCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVToOperationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.QualifierKindCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.RenameCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveInExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ResolveOpArgsExpCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.ScopedNameCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.SimpleSignatureCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.StereotypeQualifierCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TagCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TopLevelCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TransformationRefineCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypeSpecCS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.TypedTypeRef2CS;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.UnitCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTOperationalCSPackageImpl extends EPackageImpl implements QVTOperationalCSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathName2CSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathElement2CSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedTypeRef2CSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToClassCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToImportCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToLibraryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qvToOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initPartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metamodelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stereotypeQualifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tagCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierProperty2CSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constructorCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementWithBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeOperationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryImportCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingBodyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEndCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingInitCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingMethodCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingQueryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingRuleCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSectionsCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleKindCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modulePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleUsageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicityDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oppositePropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDeclarationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass renameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveOpArgsExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scopedNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationRefineCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resolveInExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum classifierKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum featureKeyEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum initOpEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum metamodelKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindCSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum importKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum mappingExtensionKindCSEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum moduleKindEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum qualifierKindCSEEnum = null;

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
	 * @see org.eclipse.qvto.examples.xtext.qvtoperationalcs.QVTOperationalCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTOperationalCSPackageImpl() {
		super(eNS_URI, QVTOperationalCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTOperationalCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTOperationalCSPackage init() {
		if (isInited) return (QVTOperationalCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTOperationalCSPackage.eNS_URI);

		// Obtain or create and register package
		QVTOperationalCSPackageImpl theQVTOperationalCSPackage = (QVTOperationalCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTOperationalCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTOperationalCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ImperativeOCLCSPackage.eINSTANCE.eClass();
		QVTOperationalPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTOperationalCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTOperationalCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTOperationalCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTOperationalCSPackage.eNS_URI, theQVTOperationalCSPackage);
		return theQVTOperationalCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathName2CS() {
		return pathName2CSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathName2CS_OwnedPathElements2() {
		return (EReference)pathName2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPathElement2CS() {
		return pathElement2CSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPathElement2CS_Name() {
		return (EAttribute)pathElement2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPathElement2CS_OwningPathNameCS() {
		return (EReference)pathElement2CSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedTypeRef2CS() {
		return typedTypeRef2CSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRef2CS_OwnedPathName() {
		return (EReference)typedTypeRef2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRef2CS_OwnedBinding() {
		return (EReference)typedTypeRef2CSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_OwnedTypes() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToClassCS() {
		return qvToClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQVToClassCS_Intermediate() {
		return (EAttribute)qvToClassCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToImportCS() {
		return qvToImportCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQVToImportCS_Unit() {
		return (EReference)qvToImportCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQVToImportCS_ImportedUnitElement() {
		return (EAttribute)qvToImportCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToLibraryCS() {
		return qvToLibraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQVToOperationCS() {
		return qvToOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQVToOperationCS_Stereotypes() {
		return (EReference)qvToOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitPartCS() {
		return initPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInitPartCS_InitOp() {
		return (EAttribute)initPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPartCS_Expression() {
		return (EReference)initPartCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetamodelCS() {
		return metamodelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetamodelCS_MetamodelKind() {
		return (EAttribute)metamodelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeCS() {
		return primitiveTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierPropertyCS() {
		return classifierPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_Stereotypes() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierPropertyCS_Opposite() {
		return (EAttribute)classifierPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStereotypeQualifierCS() {
		return stereotypeQualifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStereotypeQualifierCS_Stereotype() {
		return (EAttribute)stereotypeQualifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTagCS() {
		return tagCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_ElementPath() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_Expression() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionCS() {
		return exceptionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierDefCS() {
		return classifierDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierDefCS_SimpleNameCS() {
		return (EAttribute)classifierDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Extends() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Properties() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_Tags() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierProperty2CS() {
		return classifierProperty2CSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_StereotypeQualifiers() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_FeatureKeys() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Multiplicity() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierProperty2CS_Opposite() {
		return (EReference)classifierProperty2CSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierProperty2CS_IsOrdered() {
		return (EAttribute)classifierProperty2CSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteSignatureCS() {
		return completeSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_SimpleSignature() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompleteSignatureCS_ResultParams() {
		return (EReference)completeSignatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigPropertyCS() {
		return configPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigPropertyCS_TypeCS() {
		return (EReference)configPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstructorCS() {
		return constructorCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstructorCS_Expressions() {
		return (EReference)constructorCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualPropertyCS() {
		return contextualPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_ScopedNameCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_TypeCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextualPropertyCS_OclExpressionCS() {
		return (EReference)contextualPropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementWithBody() {
		return elementWithBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyStartLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementWithBody_BodyEndLocation() {
		return (EAttribute)elementWithBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeOperationCallExpCS() {
		return imperativeOperationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImperativeOperationCallExpCS_Module() {
		return (EAttribute)imperativeOperationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryImportCS() {
		return libraryImportCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalPropertyCS() {
		return localPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_TypeCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalPropertyCS_OclExpressionCS() {
		return (EReference)localPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBodyCS() {
		return mappingBodyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingBodyCS_HasPopulationKeyword() {
		return (EAttribute)mappingBodyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallExpCS() {
		return mappingCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallExpCS_Strict() {
		return (EAttribute)mappingCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingOperationCS() {
		return mappingOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Results() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingOperationCS_Direction() {
		return (EAttribute)mappingOperationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingOperationCS_IsQuery() {
		return (EAttribute)mappingOperationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_When() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Where() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Inherits() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Disjuncts() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Merges() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_Refines() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingOperationCS_ScopedName() {
		return (EReference)mappingOperationCSEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingEndCS() {
		return mappingEndCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingInitCS() {
		return mappingInitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingMethodCS() {
		return mappingMethodCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingMethodCS_BlackBox() {
		return (EAttribute)mappingMethodCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingMethodCS_MappingDeclarationCS() {
		return (EReference)mappingMethodCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingQueryCS() {
		return mappingQueryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingQueryCS_Expressions() {
		return (EReference)mappingQueryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingQueryCS_IsSimpleDefinition() {
		return (EAttribute)mappingQueryCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingRuleCS() {
		return mappingRuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_Guard() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_MappingBody() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionCS() {
		return mappingSectionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_Statements() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionCS_MappingRuleCS() {
		return (EReference)mappingSectionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingSectionsCS() {
		return mappingSectionsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingInitCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingBodyCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingSectionsCS_MappingEndCS() {
		return (EReference)mappingSectionsCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleKindCS() {
		return moduleKindCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleKindCS_ModuleKind() {
		return (EAttribute)moduleKindCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleRefCS() {
		return moduleRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_ModulePath() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleRefCS_Parameters() {
		return (EReference)moduleRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeCS() {
		return modelTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelTypeCS_ComplianceKind() {
		return (EAttribute)modelTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_PackageRefs() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_Where() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelTypeRefCS() {
		return modelTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleCS() {
		return moduleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleCS_Parameters() {
		return (EReference)moduleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleCS_ModuleUsages() {
		return (EReference)moduleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleCS_Tags() {
		return (EReference)moduleCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleCS_Qualifiers() {
		return (EAttribute)moduleCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModulePropertyCS() {
		return modulePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModulePropertyCS_SimpleNameCS() {
		return (EAttribute)modulePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleUsageCS() {
		return moduleUsageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleUsageCS_ImportKind() {
		return (EAttribute)moduleUsageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleUsageCS_ModuleKind() {
		return (EAttribute)moduleUsageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModuleUsageCS_ModuleRefs() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicityDefCS() {
		return multiplicityDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_LowerBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicityDefCS_UpperBound() {
		return (EReference)multiplicityDefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectExpCS() {
		return objectExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_SimpleNameCS() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_IsImplicit() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOppositePropertyCS() {
		return oppositePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_IsNavigable() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOppositePropertyCS_SimpleNameCS() {
		return (EAttribute)oppositePropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOppositePropertyCS_Multiplicity() {
		return (EReference)oppositePropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDeclarationCS() {
		return parameterDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationCS_Direction() {
		return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDeclarationCS_InitPart() {
		return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRenameCS() {
		return renameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_TypeCS() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRenameCS_SimpleNameCS() {
		return (EAttribute)renameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRenameCS_OriginalName() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveOpArgsExpCS() {
		return resolveOpArgsExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Target() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveOpArgsExpCS_Condition() {
		return (EReference)resolveOpArgsExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRefCS() {
		return packageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_PackagePath() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_Uri() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScopedNameCS() {
		return scopedNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScopedNameCS_TypeCS() {
		return (EReference)scopedNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScopedNameCS_Name() {
		return (EAttribute)scopedNameCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleSignatureCS() {
		return simpleSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleSignatureCS_Parameter() {
		return (EReference)simpleSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationCS() {
		return transformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationCS_Refines() {
		return (EReference)transformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationRefineCS() {
		return transformationRefineCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationRefineCS_ModuleRefCS() {
		return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationRefineCS_SimpleNameCS() {
		return (EAttribute)transformationRefineCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeSpecCS() {
		return typeSpecCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeSpecCS_OwnedType() {
		return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeSpecCS_ExtentLocation() {
		return (EAttribute)typeSpecCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitCS() {
		return unitCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitCS_Segment() {
		return (EAttribute)unitCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_TopLevelElements() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Modules() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_ModelTypes() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Imports() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveExpCS() {
		return resolveExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_One() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsInverse() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveExpCS_IsDeferred() {
		return (EAttribute)resolveExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Target() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveExpCS_Condition() {
		return (EReference)resolveExpCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResolveInExpCS() {
		return resolveInExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResolveInExpCS_InMappingType() {
		return (EReference)resolveInExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResolveInExpCS_InMappingName() {
		return (EAttribute)resolveInExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getClassifierKind() {
		return classifierKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFeatureKey() {
		return featureKeyEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInitOp() {
		return initOpEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMetamodelKind() {
		return metamodelKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKindCS() {
		return directionKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getImportKindEnum() {
		return importKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMappingExtensionKindCS() {
		return mappingExtensionKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getModuleKindEnum() {
		return moduleKindEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getQualifierKindCS() {
		return qualifierKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTOperationalCSFactory getQVTOperationalCSFactory() {
		return (QVTOperationalCSFactory)getEFactoryInstance();
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
		pathName2CSEClass = createEClass(PATH_NAME2_CS);
		createEReference(pathName2CSEClass, PATH_NAME2_CS__OWNED_PATH_ELEMENTS2);

		pathElement2CSEClass = createEClass(PATH_ELEMENT2_CS);
		createEAttribute(pathElement2CSEClass, PATH_ELEMENT2_CS__NAME);
		createEReference(pathElement2CSEClass, PATH_ELEMENT2_CS__OWNING_PATH_NAME_CS);

		typedTypeRef2CSEClass = createEClass(TYPED_TYPE_REF2_CS);
		createEReference(typedTypeRef2CSEClass, TYPED_TYPE_REF2_CS__OWNED_PATH_NAME);
		createEReference(typedTypeRef2CSEClass, TYPED_TYPE_REF2_CS__OWNED_BINDING);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_TYPES);

		qvToClassCSEClass = createEClass(QV_TO_CLASS_CS);
		createEAttribute(qvToClassCSEClass, QV_TO_CLASS_CS__INTERMEDIATE);

		qvToImportCSEClass = createEClass(QV_TO_IMPORT_CS);
		createEReference(qvToImportCSEClass, QV_TO_IMPORT_CS__UNIT);
		createEAttribute(qvToImportCSEClass, QV_TO_IMPORT_CS__IMPORTED_UNIT_ELEMENT);

		qvToLibraryCSEClass = createEClass(QV_TO_LIBRARY_CS);

		qvToOperationCSEClass = createEClass(QV_TO_OPERATION_CS);
		createEReference(qvToOperationCSEClass, QV_TO_OPERATION_CS__STEREOTYPES);

		initPartCSEClass = createEClass(INIT_PART_CS);
		createEAttribute(initPartCSEClass, INIT_PART_CS__INIT_OP);
		createEReference(initPartCSEClass, INIT_PART_CS__EXPRESSION);

		metamodelCSEClass = createEClass(METAMODEL_CS);
		createEAttribute(metamodelCSEClass, METAMODEL_CS__METAMODEL_KIND);

		primitiveTypeCSEClass = createEClass(PRIMITIVE_TYPE_CS);

		classifierPropertyCSEClass = createEClass(CLASSIFIER_PROPERTY_CS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__STEREOTYPES);
		createEAttribute(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__OPPOSITE);

		stereotypeQualifierCSEClass = createEClass(STEREOTYPE_QUALIFIER_CS);
		createEAttribute(stereotypeQualifierCSEClass, STEREOTYPE_QUALIFIER_CS__STEREOTYPE);

		tagCSEClass = createEClass(TAG_CS);
		createEReference(tagCSEClass, TAG_CS__ELEMENT_PATH);
		createEReference(tagCSEClass, TAG_CS__EXPRESSION);

		exceptionCSEClass = createEClass(EXCEPTION_CS);

		classifierDefCSEClass = createEClass(CLASSIFIER_DEF_CS);
		createEAttribute(classifierDefCSEClass, CLASSIFIER_DEF_CS__SIMPLE_NAME_CS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__EXTENDS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__PROPERTIES);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__TAGS);

		classifierProperty2CSEClass = createEClass(CLASSIFIER_PROPERTY2_CS);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__STEREOTYPE_QUALIFIERS);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__FEATURE_KEYS);
		createEReference(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__MULTIPLICITY);
		createEReference(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__OPPOSITE);
		createEAttribute(classifierProperty2CSEClass, CLASSIFIER_PROPERTY2_CS__IS_ORDERED);

		completeSignatureCSEClass = createEClass(COMPLETE_SIGNATURE_CS);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__RESULT_PARAMS);

		configPropertyCSEClass = createEClass(CONFIG_PROPERTY_CS);
		createEReference(configPropertyCSEClass, CONFIG_PROPERTY_CS__TYPE_CS);

		constructorCSEClass = createEClass(CONSTRUCTOR_CS);
		createEReference(constructorCSEClass, CONSTRUCTOR_CS__EXPRESSIONS);

		contextualPropertyCSEClass = createEClass(CONTEXTUAL_PROPERTY_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__TYPE_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		elementWithBodyEClass = createEClass(ELEMENT_WITH_BODY);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_START_LOCATION);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_END_LOCATION);

		imperativeOperationCallExpCSEClass = createEClass(IMPERATIVE_OPERATION_CALL_EXP_CS);
		createEAttribute(imperativeOperationCallExpCSEClass, IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE);

		libraryImportCSEClass = createEClass(LIBRARY_IMPORT_CS);

		localPropertyCSEClass = createEClass(LOCAL_PROPERTY_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__TYPE_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		mappingBodyCSEClass = createEClass(MAPPING_BODY_CS);
		createEAttribute(mappingBodyCSEClass, MAPPING_BODY_CS__HAS_POPULATION_KEYWORD);

		mappingCallExpCSEClass = createEClass(MAPPING_CALL_EXP_CS);
		createEAttribute(mappingCallExpCSEClass, MAPPING_CALL_EXP_CS__STRICT);

		mappingOperationCSEClass = createEClass(MAPPING_OPERATION_CS);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__RESULTS);
		createEAttribute(mappingOperationCSEClass, MAPPING_OPERATION_CS__DIRECTION);
		createEAttribute(mappingOperationCSEClass, MAPPING_OPERATION_CS__IS_QUERY);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__WHEN);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__WHERE);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__INHERITS);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__DISJUNCTS);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__MERGES);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__REFINES);
		createEReference(mappingOperationCSEClass, MAPPING_OPERATION_CS__SCOPED_NAME);

		mappingEndCSEClass = createEClass(MAPPING_END_CS);

		mappingInitCSEClass = createEClass(MAPPING_INIT_CS);

		mappingMethodCSEClass = createEClass(MAPPING_METHOD_CS);
		createEAttribute(mappingMethodCSEClass, MAPPING_METHOD_CS__BLACK_BOX);
		createEReference(mappingMethodCSEClass, MAPPING_METHOD_CS__MAPPING_DECLARATION_CS);

		mappingQueryCSEClass = createEClass(MAPPING_QUERY_CS);
		createEReference(mappingQueryCSEClass, MAPPING_QUERY_CS__EXPRESSIONS);
		createEAttribute(mappingQueryCSEClass, MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION);

		mappingRuleCSEClass = createEClass(MAPPING_RULE_CS);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__GUARD);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_BODY);

		mappingSectionCSEClass = createEClass(MAPPING_SECTION_CS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__STATEMENTS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__MAPPING_RULE_CS);

		mappingSectionsCSEClass = createEClass(MAPPING_SECTIONS_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_INIT_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_BODY_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_END_CS);

		moduleKindCSEClass = createEClass(MODULE_KIND_CS);
		createEAttribute(moduleKindCSEClass, MODULE_KIND_CS__MODULE_KIND);

		moduleRefCSEClass = createEClass(MODULE_REF_CS);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__MODULE_PATH);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__PARAMETERS);

		modelTypeCSEClass = createEClass(MODEL_TYPE_CS);
		createEAttribute(modelTypeCSEClass, MODEL_TYPE_CS__COMPLIANCE_KIND);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__PACKAGE_REFS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__WHERE);

		modelTypeRefCSEClass = createEClass(MODEL_TYPE_REF_CS);

		moduleCSEClass = createEClass(MODULE_CS);
		createEReference(moduleCSEClass, MODULE_CS__PARAMETERS);
		createEReference(moduleCSEClass, MODULE_CS__MODULE_USAGES);
		createEReference(moduleCSEClass, MODULE_CS__TAGS);
		createEAttribute(moduleCSEClass, MODULE_CS__QUALIFIERS);

		modulePropertyCSEClass = createEClass(MODULE_PROPERTY_CS);
		createEAttribute(modulePropertyCSEClass, MODULE_PROPERTY_CS__SIMPLE_NAME_CS);

		moduleUsageCSEClass = createEClass(MODULE_USAGE_CS);
		createEAttribute(moduleUsageCSEClass, MODULE_USAGE_CS__IMPORT_KIND);
		createEAttribute(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_KIND);
		createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_REFS);

		multiplicityDefCSEClass = createEClass(MULTIPLICITY_DEF_CS);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__LOWER_BOUND);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__UPPER_BOUND);

		objectExpCSEClass = createEClass(OBJECT_EXP_CS);
		createEAttribute(objectExpCSEClass, OBJECT_EXP_CS__SIMPLE_NAME_CS);
		createEAttribute(objectExpCSEClass, OBJECT_EXP_CS__IS_IMPLICIT);

		oppositePropertyCSEClass = createEClass(OPPOSITE_PROPERTY_CS);
		createEAttribute(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__IS_NAVIGABLE);
		createEAttribute(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS);
		createEReference(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__MULTIPLICITY);

		parameterDeclarationCSEClass = createEClass(PARAMETER_DECLARATION_CS);
		createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__DIRECTION);
		createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__INIT_PART);

		renameCSEClass = createEClass(RENAME_CS);
		createEReference(renameCSEClass, RENAME_CS__TYPE_CS);
		createEAttribute(renameCSEClass, RENAME_CS__SIMPLE_NAME_CS);
		createEReference(renameCSEClass, RENAME_CS__ORIGINAL_NAME);

		resolveOpArgsExpCSEClass = createEClass(RESOLVE_OP_ARGS_EXP_CS);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__TARGET);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__CONDITION);

		packageRefCSEClass = createEClass(PACKAGE_REF_CS);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__PACKAGE_PATH);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__URI);

		scopedNameCSEClass = createEClass(SCOPED_NAME_CS);
		createEReference(scopedNameCSEClass, SCOPED_NAME_CS__TYPE_CS);
		createEAttribute(scopedNameCSEClass, SCOPED_NAME_CS__NAME);

		simpleSignatureCSEClass = createEClass(SIMPLE_SIGNATURE_CS);
		createEReference(simpleSignatureCSEClass, SIMPLE_SIGNATURE_CS__PARAMETER);

		transformationCSEClass = createEClass(TRANSFORMATION_CS);
		createEReference(transformationCSEClass, TRANSFORMATION_CS__REFINES);

		transformationRefineCSEClass = createEClass(TRANSFORMATION_REFINE_CS);
		createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__MODULE_REF_CS);
		createEAttribute(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS);

		typeSpecCSEClass = createEClass(TYPE_SPEC_CS);
		createEReference(typeSpecCSEClass, TYPE_SPEC_CS__OWNED_TYPE);
		createEAttribute(typeSpecCSEClass, TYPE_SPEC_CS__EXTENT_LOCATION);

		unitCSEClass = createEClass(UNIT_CS);
		createEAttribute(unitCSEClass, UNIT_CS__SEGMENT);
		createEReference(unitCSEClass, UNIT_CS__TOP_LEVEL_ELEMENTS);
		createEReference(unitCSEClass, UNIT_CS__MODULES);
		createEReference(unitCSEClass, UNIT_CS__MODEL_TYPES);
		createEReference(unitCSEClass, UNIT_CS__IMPORTS);

		resolveExpCSEClass = createEClass(RESOLVE_EXP_CS);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__ONE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_INVERSE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_DEFERRED);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__TARGET);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__CONDITION);

		resolveInExpCSEClass = createEClass(RESOLVE_IN_EXP_CS);
		createEReference(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE);
		createEAttribute(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_NAME);

		// Create enums
		classifierKindEEnum = createEEnum(CLASSIFIER_KIND);
		featureKeyEEnum = createEEnum(FEATURE_KEY);
		initOpEEnum = createEEnum(INIT_OP);
		metamodelKindEEnum = createEEnum(METAMODEL_KIND);
		directionKindCSEEnum = createEEnum(DIRECTION_KIND_CS);
		importKindEnumEEnum = createEEnum(IMPORT_KIND_ENUM);
		mappingExtensionKindCSEEnum = createEEnum(MAPPING_EXTENSION_KIND_CS);
		moduleKindEnumEEnum = createEEnum(MODULE_KIND_ENUM);
		qualifierKindCSEEnum = createEEnum(QUALIFIER_KIND_CS);
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
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);
		ImperativeOCLCSPackage theImperativeOCLCSPackage = (ImperativeOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(ImperativeOCLCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pathName2CSEClass.getESuperTypes().add(theBaseCSPackage.getPivotableElementCS());
		pathElement2CSEClass.getESuperTypes().add(theBaseCSPackage.getPivotableElementCS());
		typedTypeRef2CSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());
		qvToClassCSEClass.getESuperTypes().add(theBaseCSPackage.getStructuredClassCS());
		qvToImportCSEClass.getESuperTypes().add(theBaseCSPackage.getImportCS());
		qvToLibraryCSEClass.getESuperTypes().add(this.getModuleCS());
		qvToOperationCSEClass.getESuperTypes().add(theBaseCSPackage.getOperationCS());
		initPartCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		metamodelCSEClass.getESuperTypes().add(theBaseCSPackage.getPackageCS());
		primitiveTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getDataTypeCS());
		classifierPropertyCSEClass.getESuperTypes().add(theBaseCSPackage.getStructuralFeatureCS());
		stereotypeQualifierCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		tagCSEClass.getESuperTypes().add(theBaseCSPackage.getAnnotationCS());
		exceptionCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		classifierDefCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		classifierProperty2CSEClass.getESuperTypes().add(this.getLocalPropertyCS());
		completeSignatureCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		configPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		constructorCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		contextualPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		elementWithBodyEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		imperativeOperationCallExpCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getCallExpCS());
		libraryImportCSEClass.getESuperTypes().add(this.getQVToImportCS());
		localPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		mappingBodyCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingCallExpCSEClass.getESuperTypes().add(this.getImperativeOperationCallExpCS());
		mappingOperationCSEClass.getESuperTypes().add(theBaseCSPackage.getOperationCS());
		mappingEndCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingInitCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingMethodCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		mappingQueryCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingRuleCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingSectionCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		mappingSectionCSEClass.getESuperTypes().add(this.getElementWithBody());
		mappingSectionsCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		moduleKindCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		moduleRefCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		modelTypeCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		modelTypeCSEClass.getESuperTypes().add(this.getElementWithBody());
		modelTypeRefCSEClass.getESuperTypes().add(theBaseCSPackage.getParameterCS());
		moduleCSEClass.getESuperTypes().add(theBaseCSPackage.getStructuredClassCS());
		modulePropertyCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		moduleUsageCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		multiplicityDefCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		objectExpCSEClass.getESuperTypes().add(theImperativeOCLCSPackage.getExpressionBlockCS());
		oppositePropertyCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		parameterDeclarationCSEClass.getESuperTypes().add(theBaseCSPackage.getParameterCS());
		renameCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		resolveOpArgsExpCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		packageRefCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		scopedNameCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		simpleSignatureCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		transformationCSEClass.getESuperTypes().add(this.getModuleCS());
		transformationRefineCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		typeSpecCSEClass.getESuperTypes().add(theBaseCSPackage.getTypedRefCS());
		unitCSEClass.getESuperTypes().add(theBaseCSPackage.getElementCS());
		resolveExpCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getCallExpCS());
		resolveInExpCSEClass.getESuperTypes().add(this.getResolveExpCS());

		// Initialize classes and features; add operations and parameters
		initEClass(pathName2CSEClass, PathName2CS.class, "PathName2CS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathName2CS_OwnedPathElements2(), this.getPathElement2CS(), null, "ownedPathElements2", null, 0, -1, PathName2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathElement2CSEClass, PathElement2CS.class, "PathElement2CS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPathElement2CS_Name(), theEcorePackage.getEString(), "name", null, 0, 1, PathElement2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPathElement2CS_OwningPathNameCS(), this.getPathName2CS(), null, "owningPathNameCS", null, 0, 1, PathElement2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedTypeRef2CSEClass, TypedTypeRef2CS.class, "TypedTypeRef2CS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedTypeRef2CS_OwnedPathName(), this.getPathName2CS(), null, "ownedPathName", null, 0, 1, TypedTypeRef2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedTypeRef2CS_OwnedBinding(), theBaseCSPackage.getTemplateBindingCS(), null, "ownedBinding", null, 0, 1, TypedTypeRef2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_OwnedTypes(), theBaseCSPackage.getTypeCS(), null, "ownedTypes", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qvToClassCSEClass, QVToClassCS.class, "QVToClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQVToClassCS_Intermediate(), ecorePackage.getEBoolean(), "intermediate", null, 1, 1, QVToClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qvToImportCSEClass, QVToImportCS.class, "QVToImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQVToImportCS_Unit(), this.getUnitCS(), null, "unit", null, 0, 1, QVToImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getQVToImportCS_ImportedUnitElement(), ecorePackage.getEString(), "importedUnitElement", null, 0, -1, QVToImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qvToLibraryCSEClass, QVToLibraryCS.class, "QVToLibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qvToOperationCSEClass, QVToOperationCS.class, "QVToOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQVToOperationCS_Stereotypes(), this.getStereotypeQualifierCS(), null, "stereotypes", null, 0, 1, QVToOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initPartCSEClass, InitPartCS.class, "InitPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInitPartCS_InitOp(), this.getInitOp(), "initOp", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitPartCS_Expression(), theEssentialOCLCSPackage.getExpCS(), null, "expression", null, 0, 1, InitPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metamodelCSEClass, MetamodelCS.class, "MetamodelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetamodelCS_MetamodelKind(), this.getMetamodelKind(), "metamodelKind", null, 0, 1, MetamodelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeCSEClass, PrimitiveTypeCS.class, "PrimitiveTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierPropertyCSEClass, ClassifierPropertyCS.class, "ClassifierPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierPropertyCS_Stereotypes(), theBaseCSPackage.getElementCS(), null, "stereotypes", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierPropertyCS_Opposite(), ecorePackage.getEString(), "opposite", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stereotypeQualifierCSEClass, StereotypeQualifierCS.class, "StereotypeQualifierCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStereotypeQualifierCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, -1, StereotypeQualifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tagCSEClass, TagCS.class, "TagCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTagCS_ElementPath(), this.getPathName2CS(), null, "elementPath", null, 1, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTagCS_Expression(), theEssentialOCLCSPackage.getExpCS(), null, "expression", null, 0, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exceptionCSEClass, ExceptionCS.class, "ExceptionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierDefCSEClass, ClassifierDefCS.class, "ClassifierDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierDefCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 1, 1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Extends(), theBaseCSPackage.getTypeCS(), null, "extends", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Properties(), this.getClassifierProperty2CS(), null, "properties", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierDefCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classifierProperty2CSEClass, ClassifierProperty2CS.class, "ClassifierProperty2CS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierProperty2CS_StereotypeQualifiers(), ecorePackage.getEString(), "stereotypeQualifiers", null, 0, -1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierProperty2CS_FeatureKeys(), ecorePackage.getEString(), "featureKeys", null, 0, -1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierProperty2CS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierProperty2CS_Opposite(), this.getOppositePropertyCS(), null, "opposite", null, 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierProperty2CS_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", "true", 0, 1, ClassifierProperty2CS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeSignatureCSEClass, CompleteSignatureCS.class, "CompleteSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompleteSignatureCS_SimpleSignature(), this.getSimpleSignatureCS(), null, "simpleSignature", null, 1, 1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompleteSignatureCS_ResultParams(), this.getParameterDeclarationCS(), null, "resultParams", null, 0, -1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configPropertyCSEClass, ConfigPropertyCS.class, "ConfigPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigPropertyCS_TypeCS(), theBaseCSPackage.getTypeCS(), null, "typeCS", null, 0, 1, ConfigPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constructorCSEClass, ConstructorCS.class, "ConstructorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstructorCS_Expressions(), theEssentialOCLCSPackage.getExpCS(), null, "expressions", null, 0, -1, ConstructorCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextualPropertyCSEClass, ContextualPropertyCS.class, "ContextualPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextualPropertyCS_ScopedNameCS(), this.getScopedNameCS(), null, "scopedNameCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualPropertyCS_TypeCS(), theBaseCSPackage.getTypeCS(), null, "typeCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextualPropertyCS_OclExpressionCS(), theEssentialOCLCSPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementWithBodyEClass, ElementWithBody.class, "ElementWithBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementWithBody_BodyStartLocation(), ecorePackage.getEInt(), "bodyStartLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getElementWithBody_BodyEndLocation(), ecorePackage.getEInt(), "bodyEndLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeOperationCallExpCSEClass, ImperativeOperationCallExpCS.class, "ImperativeOperationCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativeOperationCallExpCS_Module(), ecorePackage.getEString(), "module", null, 0, 1, ImperativeOperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryImportCSEClass, LibraryImportCS.class, "LibraryImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localPropertyCSEClass, LocalPropertyCS.class, "LocalPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalPropertyCS_TypeCS(), theBaseCSPackage.getTypeCS(), null, "typeCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLocalPropertyCS_OclExpressionCS(), theEssentialOCLCSPackage.getExpCS(), null, "oclExpressionCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingBodyCSEClass, MappingBodyCS.class, "MappingBodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingBodyCS_HasPopulationKeyword(), ecorePackage.getEBoolean(), "hasPopulationKeyword", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallExpCSEClass, MappingCallExpCS.class, "MappingCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallExpCS_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, MappingCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingOperationCSEClass, MappingOperationCS.class, "MappingOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingOperationCS_Results(), this.getParameterDeclarationCS(), null, "results", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingOperationCS_Direction(), this.getDirectionKindCS(), "direction", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingOperationCS_IsQuery(), ecorePackage.getEBoolean(), "isQuery", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_When(), theImperativeOCLCSPackage.getBlockExpCS(), null, "when", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Where(), theImperativeOCLCSPackage.getBlockExpCS(), null, "where", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Inherits(), this.getPathName2CS(), null, "inherits", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Disjuncts(), this.getPathName2CS(), null, "disjuncts", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Merges(), this.getPathName2CS(), null, "merges", null, 0, -1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_Refines(), this.getPathName2CS(), null, "refines", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingOperationCS_ScopedName(), this.getPathName2CS(), null, "scopedName", null, 0, 1, MappingOperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEndCSEClass, MappingEndCS.class, "MappingEndCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingInitCSEClass, MappingInitCS.class, "MappingInitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingMethodCSEClass, MappingMethodCS.class, "MappingMethodCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingMethodCS_BlackBox(), ecorePackage.getEBoolean(), "blackBox", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingMethodCS_MappingDeclarationCS(), this.getMappingOperationCS(), null, "mappingDeclarationCS", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingQueryCSEClass, MappingQueryCS.class, "MappingQueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingQueryCS_Expressions(), theEssentialOCLCSPackage.getExpCS(), null, "expressions", null, 0, -1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingQueryCS_IsSimpleDefinition(), ecorePackage.getEBoolean(), "isSimpleDefinition", null, 0, 1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingRuleCSEClass, MappingRuleCS.class, "MappingRuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingRuleCS_Guard(), theEssentialOCLCSPackage.getExpCS(), null, "guard", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingRuleCS_MappingBody(), this.getMappingSectionsCS(), null, "mappingBody", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSectionCSEClass, MappingSectionCS.class, "MappingSectionCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSectionCS_Statements(), theEssentialOCLCSPackage.getExpCS(), null, "statements", null, 0, -1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionCS_MappingRuleCS(), this.getMappingRuleCS(), null, "mappingRuleCS", null, 0, 1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSectionsCSEClass, MappingSectionsCS.class, "MappingSectionsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSectionsCS_MappingInitCS(), this.getMappingInitCS(), null, "mappingInitCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionsCS_MappingBodyCS(), this.getMappingBodyCS(), null, "mappingBodyCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingSectionsCS_MappingEndCS(), this.getMappingEndCS(), null, "mappingEndCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleKindCSEClass, ModuleKindCS.class, "ModuleKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleKindCS_ModuleKind(), this.getModuleKindEnum(), "moduleKind", null, 0, 1, ModuleKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleRefCSEClass, ModuleRefCS.class, "ModuleRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleRefCS_ModulePath(), this.getPathName2CS(), null, "modulePath", null, 1, 1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleRefCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeCSEClass, ModelTypeCS.class, "ModelTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelTypeCS_ComplianceKind(), theEcorePackage.getEString(), "complianceKind", "strict", 0, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeCS_PackageRefs(), this.getPackageRefCS(), null, "packageRefs", null, 1, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelTypeCS_Where(), theImperativeOCLCSPackage.getBlockExpCS(), null, "where", null, 0, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelTypeRefCSEClass, ModelTypeRefCS.class, "ModelTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleCSEClass, ModuleCS.class, "ModuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModuleCS_Parameters(), theBaseCSPackage.getParameterCS(), null, "parameters", null, 0, -1, ModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleCS_ModuleUsages(), this.getModuleUsageCS(), null, "moduleUsages", null, 0, -1, ModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, ModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModuleCS_Qualifiers(), theEcorePackage.getEString(), "qualifiers", null, 0, -1, ModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modulePropertyCSEClass, ModulePropertyCS.class, "ModulePropertyCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModulePropertyCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, ModulePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleUsageCSEClass, ModuleUsageCS.class, "ModuleUsageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleUsageCS_ImportKind(), this.getImportKindEnum(), "importKind", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModuleUsageCS_ModuleKind(), this.getModuleKindEnum(), "moduleKind", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModuleUsageCS_ModuleRefs(), this.getModuleRefCS(), null, "moduleRefs", null, 1, -1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicityDefCSEClass, MultiplicityDefCS.class, "MultiplicityDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicityDefCS_LowerBound(), theEssentialOCLCSPackage.getPrimitiveLiteralExpCS(), null, "lowerBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicityDefCS_UpperBound(), theEssentialOCLCSPackage.getPrimitiveLiteralExpCS(), null, "upperBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectExpCSEClass, ObjectExpCS.class, "ObjectExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectExpCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectExpCS_IsImplicit(), ecorePackage.getEBoolean(), "isImplicit", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oppositePropertyCSEClass, OppositePropertyCS.class, "OppositePropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOppositePropertyCS_IsNavigable(), ecorePackage.getEBoolean(), "isNavigable", "true", 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOppositePropertyCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOppositePropertyCS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterDeclarationCSEClass, ParameterDeclarationCS.class, "ParameterDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterDeclarationCS_Direction(), this.getDirectionKindCS(), "direction", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDeclarationCS_InitPart(), this.getInitPartCS(), null, "initPart", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(renameCSEClass, RenameCS.class, "RenameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRenameCS_TypeCS(), theBaseCSPackage.getTypeCS(), null, "typeCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRenameCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRenameCS_OriginalName(), theEssentialOCLCSPackage.getStringLiteralExpCS(), null, "originalName", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolveOpArgsExpCSEClass, ResolveOpArgsExpCS.class, "ResolveOpArgsExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveOpArgsExpCS_Target(), theEssentialOCLCSPackage.getVariableCS(), null, "target", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveOpArgsExpCS_Condition(), theEssentialOCLCSPackage.getExpCS(), null, "condition", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageRefCSEClass, PackageRefCS.class, "PackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageRefCS_PackagePath(), this.getPathName2CS(), null, "packagePath", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageRefCS_Uri(), theEssentialOCLCSPackage.getStringLiteralExpCS(), null, "uri", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scopedNameCSEClass, ScopedNameCS.class, "ScopedNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScopedNameCS_TypeCS(), theBaseCSPackage.getTypeCS(), null, "typeCS", null, 0, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScopedNameCS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleSignatureCSEClass, SimpleSignatureCS.class, "SimpleSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleSignatureCS_Parameter(), this.getParameterDeclarationCS(), null, "parameter", null, 0, -1, SimpleSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationCSEClass, TransformationCS.class, "TransformationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationCS_Refines(), this.getModuleRefCS(), null, "refines", null, 0, 1, TransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationRefineCSEClass, TransformationRefineCS.class, "TransformationRefineCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformationRefineCS_ModuleRefCS(), this.getModuleRefCS(), null, "moduleRefCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransformationRefineCS_SimpleNameCS(), ecorePackage.getEString(), "simpleNameCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecCSEClass, TypeSpecCS.class, "TypeSpecCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeSpecCS_OwnedType(), theBaseCSPackage.getTypedRefCS(), null, "ownedType", null, 1, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeSpecCS_ExtentLocation(), ecorePackage.getEString(), "extentLocation", null, 0, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitCS_Segment(), ecorePackage.getEString(), "segment", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_TopLevelElements(), theBaseCSPackage.getElementCS(), null, "topLevelElements", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Modules(), this.getModuleCS(), null, "modules", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_ModelTypes(), this.getModelTypeCS(), null, "modelTypes", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getUnitCS_Imports(), this.getQVToImportCS(), null, "imports", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(resolveExpCSEClass, ResolveExpCS.class, "ResolveExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResolveExpCS_One(), ecorePackage.getEBoolean(), "one", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExpCS_IsInverse(), ecorePackage.getEBoolean(), "isInverse", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveExpCS_IsDeferred(), ecorePackage.getEBoolean(), "isDeferred", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveExpCS_Target(), theEssentialOCLCSPackage.getVariableCS(), null, "target", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResolveExpCS_Condition(), theEssentialOCLCSPackage.getExpCS(), null, "condition", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resolveInExpCSEClass, ResolveInExpCS.class, "ResolveInExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResolveInExpCS_InMappingType(), theBaseCSPackage.getTypeCS(), null, "inMappingType", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResolveInExpCS_InMappingName(), ecorePackage.getEString(), "inMappingName", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(classifierKindEEnum, ClassifierKind.class, "ClassifierKind");
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.DATATYPE);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.PRIMITIVE);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.EXCEPTION);
		addEEnumLiteral(classifierKindEEnum, ClassifierKind.CLASS);

		initEEnum(featureKeyEEnum, FeatureKey.class, "FeatureKey");
		addEEnumLiteral(featureKeyEEnum, FeatureKey.COMPOSES);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.REFERRENCES);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.READONLY);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.DERIVED);
		addEEnumLiteral(featureKeyEEnum, FeatureKey.STATIC);

		initEEnum(initOpEEnum, InitOp.class, "InitOp");
		addEEnumLiteral(initOpEEnum, InitOp.EQUALS);
		addEEnumLiteral(initOpEEnum, InitOp.COLON_EQUALS);
		addEEnumLiteral(initOpEEnum, InitOp.COLON_COLON_EQUALS);

		initEEnum(metamodelKindEEnum, MetamodelKind.class, "MetamodelKind");
		addEEnumLiteral(metamodelKindEEnum, MetamodelKind.METAMODEL);
		addEEnumLiteral(metamodelKindEEnum, MetamodelKind.PACKAGE);

		initEEnum(directionKindCSEEnum, DirectionKindCS.class, "DirectionKindCS");
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.IN);
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.OUT);
		addEEnumLiteral(directionKindCSEEnum, DirectionKindCS.INOUT);

		initEEnum(importKindEnumEEnum, ImportKindEnum.class, "ImportKindEnum");
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.EXTENSION);
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.ACCESS);

		initEEnum(mappingExtensionKindCSEEnum, MappingExtensionKindCS.class, "MappingExtensionKindCS");
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.DISJUNCTS);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.MERGES);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.INHERITS);

		initEEnum(moduleKindEnumEEnum, ModuleKindEnum.class, "ModuleKindEnum");
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.TRANSFORMATION);
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.LIBRARY);

		initEEnum(qualifierKindCSEEnum, QualifierKindCS.class, "QualifierKindCS");
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.ABSTRACT);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.BLACKBOX);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.STATIC);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTOperationalCSPackageImpl
