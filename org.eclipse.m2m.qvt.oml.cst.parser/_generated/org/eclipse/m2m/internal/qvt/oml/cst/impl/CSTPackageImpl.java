/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 * 
 * 
 *
 * $Id: CSTPackageImpl.java,v 1.33 2010/01/29 15:23:40 sboyko Exp $
 */
package org.eclipse.m2m.internal.qvt.oml.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BreakExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory;
import org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContinueExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.ExceptionDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeLoopExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.IntermediateClassDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CSTPackageImpl extends EPackageImpl implements CSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2007 Borland Software Corporation\r\n\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\n  \r\nContributors:\r\n    Borland Software Corporation - initial API and implementation\r\n\r\n"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingModuleCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importCSEClass = null;

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
	private EClass renameCSEClass = null;

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
	private EClass configPropertyCSEClass = null;

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
	private EClass contextualPropertyCSEClass = null;

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
	private EClass classifierPropertyCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateClassDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionDefCSEClass = null;

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
	private EClass multiplicityDefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingDeclarationCSEClass = null;

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
	private EClass simpleSignatureCSEClass = null;

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
	private EClass mappingMethodCSEClass = null;

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
	private EClass mappingQueryCSEClass = null;

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
	private EClass mappingSectionCSEClass = null;

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
	private EClass mappingEndCSEClass = null;

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
	private EClass statementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computeExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeLoopExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeIterateExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchAltExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableInitializationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionStatementCSEClass = null;

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
	private EClass objectExpCSEClass = null;

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
	private EClass imperativeOperationCallExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directionKindCSEClass = null;

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
	private EClass modelTypeCSEClass = null;

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
	private EClass transformationHeaderCSEClass = null;

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
	private EClass moduleUsageCSEClass = null;

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
	private EClass logExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingExtensionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instantiationExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictionaryTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dictLiteralPartCSEClass = null;

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
	private EClass unitCSEClass = null;

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
	private EClass scopedNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tryExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catchExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass raiseExpCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionKindEnumEEnum = null;

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
	 * @see org.eclipse.m2m.internal.qvt.oml.cst.CSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CSTPackageImpl() {
		super(eNS_URI, CSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CSTPackage init() {
		if (isInited) return (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);

		// Obtain or create and register package
		CSTPackageImpl theCSTPackage = (CSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		org.eclipse.ocl.cst.CSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCSTPackage.createPackageContents();

		// Initialize created meta-data
		theCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CSTPackage.eNS_URI, theCSTPackage);
		return theCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingModuleCS() {
		return mappingModuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_HeaderCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Imports() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Metamodels() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Renamings() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Properties() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Methods() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_ClassifierDefCS() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingModuleCS_Tags() {
		return (EReference)mappingModuleCSEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryCS() {
		return libraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_PathNameCS() {
		return (EReference)importCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getRenameCS_SimpleNameCS() {
		return (EReference)renameCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getModulePropertyCS() {
		return modulePropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModulePropertyCS_SimpleNameCS() {
		return (EReference)modulePropertyCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getClassifierDefCS() {
		return classifierDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierDefCS_SimpleNameCS() {
		return (EReference)classifierDefCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getClassifierPropertyCS() {
		return classifierPropertyCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_StereotypeQualifiers() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_FeatureKeys() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_Multiplicity() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierPropertyCS_Opposite() {
		return (EReference)classifierPropertyCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierPropertyCS_IsOrdered() {
		return (EAttribute)classifierPropertyCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediateClassDefCS() {
		return intermediateClassDefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionDefCS() {
		return exceptionDefCSEClass;
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
	public EReference getOppositePropertyCS_SimpleNameCS() {
		return (EReference)oppositePropertyCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getMappingDeclarationCS() {
		return mappingDeclarationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingDeclarationCS_Qualifiers() {
		return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_SimpleNameCS() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_ContextType() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_Parameters() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_Result() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_DirectionKindCS() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingDeclarationCS_MappingExtension() {
		return (EReference)mappingDeclarationCSEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingDeclarationCS_IsQuery() {
		return (EAttribute)mappingDeclarationCSEClass.getEStructuralFeatures().get(7);
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
	public EReference getParameterDeclarationCS_SimpleNameCS() {
		return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDeclarationCS_TypeSpecCS() {
		return (EReference)parameterDeclarationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterDeclarationCS_DirectionKind() {
		return (EAttribute)parameterDeclarationCSEClass.getEStructuralFeatures().get(2);
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
	public EReference getSimpleSignatureCS_Params() {
		return (EReference)simpleSignatureCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getMappingRuleCS() {
		return mappingRuleCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_Guards() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_Posts() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingRuleCS_MappingBody() {
		return (EReference)mappingRuleCSEClass.getEStructuralFeatures().get(2);
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
	public EAttribute getMappingQueryCS_IsSimpleDefinition() {
		return (EAttribute)mappingQueryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingQueryCS_Body() {
		return (EReference)mappingQueryCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getConstructorCS_Body() {
		return (EReference)constructorCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getMappingInitCS() {
		return mappingInitCSEClass;
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
	public EClass getStatementCS() {
		return statementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockExpCS() {
		return blockExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockExpCS_BodyExpressions() {
		return (EReference)blockExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputeExpCS() {
		return computeExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExpCS_ReturnedElement() {
		return (EReference)computeExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputeExpCS_Body() {
		return (EReference)computeExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileExpCS() {
		return whileExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExpCS_Body() {
		return (EReference)whileExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExpCS_Condition() {
		return (EReference)whileExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileExpCS_ResultVar() {
		return (EReference)whileExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeLoopExpCS() {
		return imperativeLoopExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeLoopExpCS_Condition() {
		return (EReference)imperativeLoopExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForExpCS() {
		return forExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImperativeIterateExpCS() {
		return imperativeIterateExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeIterateExpCS_Target() {
		return (EReference)imperativeIterateExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchExpCS() {
		return switchExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpCS_AlternativePart() {
		return (EReference)switchExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpCS_ElsePart() {
		return (EReference)switchExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchAltExpCS() {
		return switchAltExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchAltExpCS_Condition() {
		return (EReference)switchAltExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchAltExpCS_Body() {
		return (EReference)switchAltExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableInitializationCS() {
		return variableInitializationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializationCS_OclExpressionCS() {
		return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializationCS_SimpleNameCS() {
		return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableInitializationCS_TypeCS() {
		return (EReference)variableInitializationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableInitializationCS_WithResult() {
		return (EAttribute)variableInitializationCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignStatementCS() {
		return assignStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatementCS_LValueCS() {
		return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignStatementCS_OclExpressionCS() {
		return (EReference)assignStatementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignStatementCS_Incremental() {
		return (EAttribute)assignStatementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakExpCS() {
		return breakExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinueExpCS() {
		return continueExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionStatementCS() {
		return expressionStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionStatementCS_OclExpressionCS() {
		return (EReference)expressionStatementCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getObjectExpCS() {
		return objectExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExpCS_SimpleNameCS() {
		return (EReference)objectExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectExpCS_Expressions() {
		return (EReference)objectExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectExpCS_IsImplicit() {
		return (EAttribute)objectExpCSEClass.getEStructuralFeatures().get(2);
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
	public EClass getImperativeOperationCallExpCS() {
		return imperativeOperationCallExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImperativeOperationCallExpCS_Module() {
		return (EReference)imperativeOperationCallExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectionKindCS() {
		return directionKindCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDirectionKindCS_DirectionKind() {
		return (EAttribute)directionKindCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getResolveInExpCS_InMappingName() {
		return (EReference)resolveInExpCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getModelTypeCS_IdentifierCS() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_ComplianceKindCS() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_PackageRefs() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelTypeCS_WhereStatements() {
		return (EReference)modelTypeCSEClass.getEStructuralFeatures().get(3);
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
	public EReference getPackageRefCS_PathNameCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageRefCS_UriCS() {
		return (EReference)packageRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformationHeaderCS() {
		return transformationHeaderCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransformationHeaderCS_Qualifiers() {
		return (EAttribute)transformationHeaderCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_PathNameCS() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_Parameters() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_ModuleUsages() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformationHeaderCS_TransformationRefineCS() {
		return (EReference)transformationHeaderCSEClass.getEStructuralFeatures().get(4);
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
	public EReference getModuleRefCS_PathNameCS() {
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
	public EReference getModuleUsageCS_ModuleKindCS() {
		return (EReference)moduleUsageCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getTransformationRefineCS_SimpleNameCS() {
		return (EReference)transformationRefineCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getTypeSpecCS_TypeCS() {
		return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeSpecCS_SimpleNameCS() {
		return (EReference)typeSpecCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogExpCS() {
		return logExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogExpCS_Condition() {
		return (EReference)logExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertExpCS() {
		return assertExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExpCS_Assertion() {
		return (EReference)assertExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExpCS_Log() {
		return (EReference)assertExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertExpCS_Severity() {
		return (EReference)assertExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnExpCS() {
		return returnExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnExpCS_Value() {
		return (EReference)returnExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingExtensionCS() {
		return mappingExtensionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingExtensionCS_Kind() {
		return (EAttribute)mappingExtensionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingExtensionCS_MappingIdentifiers() {
		return (EReference)mappingExtensionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstantiationExpCS() {
		return instantiationExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExpCS_TypeSpecCS() {
		return (EReference)instantiationExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstantiationExpCS_Arguments() {
		return (EReference)instantiationExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListTypeCS() {
		return listTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListTypeCS_TypeCS() {
		return (EReference)listTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListLiteralExpCS() {
		return listLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListLiteralExpCS_CollectionLiteralParts() {
		return (EReference)listLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictionaryTypeCS() {
		return dictionaryTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictionaryTypeCS_Key() {
		return (EReference)dictionaryTypeCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictionaryTypeCS_Value() {
		return (EReference)dictionaryTypeCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralExpCS() {
		return dictLiteralExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralExpCS_Parts() {
		return (EReference)dictLiteralExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDictLiteralPartCS() {
		return dictLiteralPartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPartCS_Key() {
		return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDictLiteralPartCS_Value() {
		return (EReference)dictLiteralPartCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getTagCS_Name() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_ScopedNameCS() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTagCS_OclExpressionCS() {
		return (EReference)tagCSEClass.getEStructuralFeatures().get(2);
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
	public EReference getUnitCS_TopLevelElements() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Modules() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_ModelTypes() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitCS_Imports() {
		return (EReference)unitCSEClass.getEStructuralFeatures().get(3);
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
	public EClass getTryExpCS() {
		return tryExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExpCS_TryBody() {
		return (EReference)tryExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTryExpCS_ExceptClauses() {
		return (EReference)tryExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatchExpCS() {
		return catchExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExpCS_Body() {
		return (EReference)catchExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExpCS_Exceptions() {
		return (EReference)catchExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCatchExpCS_SimpleNameCS() {
		return (EReference)catchExpCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRaiseExpCS() {
		return raiseExpCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExpCS_Exception() {
		return (EReference)raiseExpCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRaiseExpCS_Argument() {
		return (EReference)raiseExpCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionKindEnum() {
		return directionKindEnumEEnum;
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
	public EEnum getQualifierKindCS() {
		return qualifierKindCSEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CSTFactory getCSTFactory() {
		return (CSTFactory)getEFactoryInstance();
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
		mappingModuleCSEClass = createEClass(MAPPING_MODULE_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__HEADER_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__IMPORTS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METAMODELS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__RENAMINGS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__PROPERTIES);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__METHODS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__CLASSIFIER_DEF_CS);
		createEReference(mappingModuleCSEClass, MAPPING_MODULE_CS__TAGS);

		libraryCSEClass = createEClass(LIBRARY_CS);

		importCSEClass = createEClass(IMPORT_CS);
		createEReference(importCSEClass, IMPORT_CS__PATH_NAME_CS);

		libraryImportCSEClass = createEClass(LIBRARY_IMPORT_CS);

		renameCSEClass = createEClass(RENAME_CS);
		createEReference(renameCSEClass, RENAME_CS__TYPE_CS);
		createEReference(renameCSEClass, RENAME_CS__SIMPLE_NAME_CS);
		createEReference(renameCSEClass, RENAME_CS__ORIGINAL_NAME);

		modulePropertyCSEClass = createEClass(MODULE_PROPERTY_CS);
		createEReference(modulePropertyCSEClass, MODULE_PROPERTY_CS__SIMPLE_NAME_CS);

		configPropertyCSEClass = createEClass(CONFIG_PROPERTY_CS);
		createEReference(configPropertyCSEClass, CONFIG_PROPERTY_CS__TYPE_CS);

		localPropertyCSEClass = createEClass(LOCAL_PROPERTY_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__TYPE_CS);
		createEReference(localPropertyCSEClass, LOCAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		contextualPropertyCSEClass = createEClass(CONTEXTUAL_PROPERTY_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__SCOPED_NAME_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__TYPE_CS);
		createEReference(contextualPropertyCSEClass, CONTEXTUAL_PROPERTY_CS__OCL_EXPRESSION_CS);

		classifierDefCSEClass = createEClass(CLASSIFIER_DEF_CS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__SIMPLE_NAME_CS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__EXTENDS);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__PROPERTIES);
		createEReference(classifierDefCSEClass, CLASSIFIER_DEF_CS__TAGS);

		classifierPropertyCSEClass = createEClass(CLASSIFIER_PROPERTY_CS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__STEREOTYPE_QUALIFIERS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__FEATURE_KEYS);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__MULTIPLICITY);
		createEReference(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__OPPOSITE);
		createEAttribute(classifierPropertyCSEClass, CLASSIFIER_PROPERTY_CS__IS_ORDERED);

		intermediateClassDefCSEClass = createEClass(INTERMEDIATE_CLASS_DEF_CS);

		exceptionDefCSEClass = createEClass(EXCEPTION_DEF_CS);

		oppositePropertyCSEClass = createEClass(OPPOSITE_PROPERTY_CS);
		createEAttribute(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__IS_NAVIGABLE);
		createEReference(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__SIMPLE_NAME_CS);
		createEReference(oppositePropertyCSEClass, OPPOSITE_PROPERTY_CS__MULTIPLICITY);

		multiplicityDefCSEClass = createEClass(MULTIPLICITY_DEF_CS);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__LOWER_BOUND);
		createEReference(multiplicityDefCSEClass, MULTIPLICITY_DEF_CS__UPPER_BOUND);

		mappingDeclarationCSEClass = createEClass(MAPPING_DECLARATION_CS);
		createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__QUALIFIERS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__SIMPLE_NAME_CS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__CONTEXT_TYPE);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__PARAMETERS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__RESULT);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__DIRECTION_KIND_CS);
		createEReference(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__MAPPING_EXTENSION);
		createEAttribute(mappingDeclarationCSEClass, MAPPING_DECLARATION_CS__IS_QUERY);

		parameterDeclarationCSEClass = createEClass(PARAMETER_DECLARATION_CS);
		createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__SIMPLE_NAME_CS);
		createEReference(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__TYPE_SPEC_CS);
		createEAttribute(parameterDeclarationCSEClass, PARAMETER_DECLARATION_CS__DIRECTION_KIND);

		simpleSignatureCSEClass = createEClass(SIMPLE_SIGNATURE_CS);
		createEReference(simpleSignatureCSEClass, SIMPLE_SIGNATURE_CS__PARAMS);

		completeSignatureCSEClass = createEClass(COMPLETE_SIGNATURE_CS);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__SIMPLE_SIGNATURE);
		createEReference(completeSignatureCSEClass, COMPLETE_SIGNATURE_CS__RESULT_PARAMS);

		mappingMethodCSEClass = createEClass(MAPPING_METHOD_CS);
		createEAttribute(mappingMethodCSEClass, MAPPING_METHOD_CS__BLACK_BOX);
		createEReference(mappingMethodCSEClass, MAPPING_METHOD_CS__MAPPING_DECLARATION_CS);

		mappingRuleCSEClass = createEClass(MAPPING_RULE_CS);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__GUARDS);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__POSTS);
		createEReference(mappingRuleCSEClass, MAPPING_RULE_CS__MAPPING_BODY);

		mappingQueryCSEClass = createEClass(MAPPING_QUERY_CS);
		createEAttribute(mappingQueryCSEClass, MAPPING_QUERY_CS__IS_SIMPLE_DEFINITION);
		createEReference(mappingQueryCSEClass, MAPPING_QUERY_CS__BODY);

		constructorCSEClass = createEClass(CONSTRUCTOR_CS);
		createEReference(constructorCSEClass, CONSTRUCTOR_CS__BODY);

		mappingSectionCSEClass = createEClass(MAPPING_SECTION_CS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__STATEMENTS);
		createEReference(mappingSectionCSEClass, MAPPING_SECTION_CS__MAPPING_RULE_CS);

		mappingInitCSEClass = createEClass(MAPPING_INIT_CS);

		mappingEndCSEClass = createEClass(MAPPING_END_CS);

		mappingSectionsCSEClass = createEClass(MAPPING_SECTIONS_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_INIT_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_BODY_CS);
		createEReference(mappingSectionsCSEClass, MAPPING_SECTIONS_CS__MAPPING_END_CS);

		statementCSEClass = createEClass(STATEMENT_CS);

		blockExpCSEClass = createEClass(BLOCK_EXP_CS);
		createEReference(blockExpCSEClass, BLOCK_EXP_CS__BODY_EXPRESSIONS);

		computeExpCSEClass = createEClass(COMPUTE_EXP_CS);
		createEReference(computeExpCSEClass, COMPUTE_EXP_CS__RETURNED_ELEMENT);
		createEReference(computeExpCSEClass, COMPUTE_EXP_CS__BODY);

		whileExpCSEClass = createEClass(WHILE_EXP_CS);
		createEReference(whileExpCSEClass, WHILE_EXP_CS__BODY);
		createEReference(whileExpCSEClass, WHILE_EXP_CS__CONDITION);
		createEReference(whileExpCSEClass, WHILE_EXP_CS__RESULT_VAR);

		imperativeLoopExpCSEClass = createEClass(IMPERATIVE_LOOP_EXP_CS);
		createEReference(imperativeLoopExpCSEClass, IMPERATIVE_LOOP_EXP_CS__CONDITION);

		forExpCSEClass = createEClass(FOR_EXP_CS);

		imperativeIterateExpCSEClass = createEClass(IMPERATIVE_ITERATE_EXP_CS);
		createEReference(imperativeIterateExpCSEClass, IMPERATIVE_ITERATE_EXP_CS__TARGET);

		switchExpCSEClass = createEClass(SWITCH_EXP_CS);
		createEReference(switchExpCSEClass, SWITCH_EXP_CS__ALTERNATIVE_PART);
		createEReference(switchExpCSEClass, SWITCH_EXP_CS__ELSE_PART);

		switchAltExpCSEClass = createEClass(SWITCH_ALT_EXP_CS);
		createEReference(switchAltExpCSEClass, SWITCH_ALT_EXP_CS__CONDITION);
		createEReference(switchAltExpCSEClass, SWITCH_ALT_EXP_CS__BODY);

		variableInitializationCSEClass = createEClass(VARIABLE_INITIALIZATION_CS);
		createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__OCL_EXPRESSION_CS);
		createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__SIMPLE_NAME_CS);
		createEReference(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__TYPE_CS);
		createEAttribute(variableInitializationCSEClass, VARIABLE_INITIALIZATION_CS__WITH_RESULT);

		assignStatementCSEClass = createEClass(ASSIGN_STATEMENT_CS);
		createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__LVALUE_CS);
		createEReference(assignStatementCSEClass, ASSIGN_STATEMENT_CS__OCL_EXPRESSION_CS);
		createEAttribute(assignStatementCSEClass, ASSIGN_STATEMENT_CS__INCREMENTAL);

		breakExpCSEClass = createEClass(BREAK_EXP_CS);

		continueExpCSEClass = createEClass(CONTINUE_EXP_CS);

		expressionStatementCSEClass = createEClass(EXPRESSION_STATEMENT_CS);
		createEReference(expressionStatementCSEClass, EXPRESSION_STATEMENT_CS__OCL_EXPRESSION_CS);

		mappingBodyCSEClass = createEClass(MAPPING_BODY_CS);
		createEAttribute(mappingBodyCSEClass, MAPPING_BODY_CS__HAS_POPULATION_KEYWORD);

		objectExpCSEClass = createEClass(OBJECT_EXP_CS);
		createEReference(objectExpCSEClass, OBJECT_EXP_CS__SIMPLE_NAME_CS);
		createEReference(objectExpCSEClass, OBJECT_EXP_CS__EXPRESSIONS);
		createEAttribute(objectExpCSEClass, OBJECT_EXP_CS__IS_IMPLICIT);

		mappingCallExpCSEClass = createEClass(MAPPING_CALL_EXP_CS);
		createEAttribute(mappingCallExpCSEClass, MAPPING_CALL_EXP_CS__STRICT);

		imperativeOperationCallExpCSEClass = createEClass(IMPERATIVE_OPERATION_CALL_EXP_CS);
		createEReference(imperativeOperationCallExpCSEClass, IMPERATIVE_OPERATION_CALL_EXP_CS__MODULE);

		directionKindCSEClass = createEClass(DIRECTION_KIND_CS);
		createEAttribute(directionKindCSEClass, DIRECTION_KIND_CS__DIRECTION_KIND);

		elementWithBodyEClass = createEClass(ELEMENT_WITH_BODY);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_START_LOCATION);
		createEAttribute(elementWithBodyEClass, ELEMENT_WITH_BODY__BODY_END_LOCATION);

		resolveExpCSEClass = createEClass(RESOLVE_EXP_CS);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__ONE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_INVERSE);
		createEAttribute(resolveExpCSEClass, RESOLVE_EXP_CS__IS_DEFERRED);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__TARGET);
		createEReference(resolveExpCSEClass, RESOLVE_EXP_CS__CONDITION);

		resolveInExpCSEClass = createEClass(RESOLVE_IN_EXP_CS);
		createEReference(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_TYPE);
		createEReference(resolveInExpCSEClass, RESOLVE_IN_EXP_CS__IN_MAPPING_NAME);

		modelTypeCSEClass = createEClass(MODEL_TYPE_CS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__IDENTIFIER_CS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__COMPLIANCE_KIND_CS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__PACKAGE_REFS);
		createEReference(modelTypeCSEClass, MODEL_TYPE_CS__WHERE_STATEMENTS);

		packageRefCSEClass = createEClass(PACKAGE_REF_CS);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__PATH_NAME_CS);
		createEReference(packageRefCSEClass, PACKAGE_REF_CS__URI_CS);

		transformationHeaderCSEClass = createEClass(TRANSFORMATION_HEADER_CS);
		createEAttribute(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__QUALIFIERS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PATH_NAME_CS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__PARAMETERS);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__MODULE_USAGES);
		createEReference(transformationHeaderCSEClass, TRANSFORMATION_HEADER_CS__TRANSFORMATION_REFINE_CS);

		moduleKindCSEClass = createEClass(MODULE_KIND_CS);
		createEAttribute(moduleKindCSEClass, MODULE_KIND_CS__MODULE_KIND);

		moduleRefCSEClass = createEClass(MODULE_REF_CS);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__PATH_NAME_CS);
		createEReference(moduleRefCSEClass, MODULE_REF_CS__PARAMETERS);

		moduleUsageCSEClass = createEClass(MODULE_USAGE_CS);
		createEAttribute(moduleUsageCSEClass, MODULE_USAGE_CS__IMPORT_KIND);
		createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_KIND_CS);
		createEReference(moduleUsageCSEClass, MODULE_USAGE_CS__MODULE_REFS);

		transformationRefineCSEClass = createEClass(TRANSFORMATION_REFINE_CS);
		createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__MODULE_REF_CS);
		createEReference(transformationRefineCSEClass, TRANSFORMATION_REFINE_CS__SIMPLE_NAME_CS);

		typeSpecCSEClass = createEClass(TYPE_SPEC_CS);
		createEReference(typeSpecCSEClass, TYPE_SPEC_CS__TYPE_CS);
		createEReference(typeSpecCSEClass, TYPE_SPEC_CS__SIMPLE_NAME_CS);

		logExpCSEClass = createEClass(LOG_EXP_CS);
		createEReference(logExpCSEClass, LOG_EXP_CS__CONDITION);

		assertExpCSEClass = createEClass(ASSERT_EXP_CS);
		createEReference(assertExpCSEClass, ASSERT_EXP_CS__ASSERTION);
		createEReference(assertExpCSEClass, ASSERT_EXP_CS__LOG);
		createEReference(assertExpCSEClass, ASSERT_EXP_CS__SEVERITY);

		returnExpCSEClass = createEClass(RETURN_EXP_CS);
		createEReference(returnExpCSEClass, RETURN_EXP_CS__VALUE);

		mappingExtensionCSEClass = createEClass(MAPPING_EXTENSION_CS);
		createEAttribute(mappingExtensionCSEClass, MAPPING_EXTENSION_CS__KIND);
		createEReference(mappingExtensionCSEClass, MAPPING_EXTENSION_CS__MAPPING_IDENTIFIERS);

		instantiationExpCSEClass = createEClass(INSTANTIATION_EXP_CS);
		createEReference(instantiationExpCSEClass, INSTANTIATION_EXP_CS__TYPE_SPEC_CS);
		createEReference(instantiationExpCSEClass, INSTANTIATION_EXP_CS__ARGUMENTS);

		listTypeCSEClass = createEClass(LIST_TYPE_CS);
		createEReference(listTypeCSEClass, LIST_TYPE_CS__TYPE_CS);

		listLiteralExpCSEClass = createEClass(LIST_LITERAL_EXP_CS);
		createEReference(listLiteralExpCSEClass, LIST_LITERAL_EXP_CS__COLLECTION_LITERAL_PARTS);

		dictionaryTypeCSEClass = createEClass(DICTIONARY_TYPE_CS);
		createEReference(dictionaryTypeCSEClass, DICTIONARY_TYPE_CS__KEY);
		createEReference(dictionaryTypeCSEClass, DICTIONARY_TYPE_CS__VALUE);

		dictLiteralExpCSEClass = createEClass(DICT_LITERAL_EXP_CS);
		createEReference(dictLiteralExpCSEClass, DICT_LITERAL_EXP_CS__PARTS);

		dictLiteralPartCSEClass = createEClass(DICT_LITERAL_PART_CS);
		createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__KEY);
		createEReference(dictLiteralPartCSEClass, DICT_LITERAL_PART_CS__VALUE);

		tagCSEClass = createEClass(TAG_CS);
		createEReference(tagCSEClass, TAG_CS__NAME);
		createEReference(tagCSEClass, TAG_CS__SCOPED_NAME_CS);
		createEReference(tagCSEClass, TAG_CS__OCL_EXPRESSION_CS);

		unitCSEClass = createEClass(UNIT_CS);
		createEReference(unitCSEClass, UNIT_CS__TOP_LEVEL_ELEMENTS);
		createEReference(unitCSEClass, UNIT_CS__MODULES);
		createEReference(unitCSEClass, UNIT_CS__MODEL_TYPES);
		createEReference(unitCSEClass, UNIT_CS__IMPORTS);

		resolveOpArgsExpCSEClass = createEClass(RESOLVE_OP_ARGS_EXP_CS);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__TARGET);
		createEReference(resolveOpArgsExpCSEClass, RESOLVE_OP_ARGS_EXP_CS__CONDITION);

		scopedNameCSEClass = createEClass(SCOPED_NAME_CS);
		createEReference(scopedNameCSEClass, SCOPED_NAME_CS__TYPE_CS);
		createEAttribute(scopedNameCSEClass, SCOPED_NAME_CS__NAME);

		tryExpCSEClass = createEClass(TRY_EXP_CS);
		createEReference(tryExpCSEClass, TRY_EXP_CS__TRY_BODY);
		createEReference(tryExpCSEClass, TRY_EXP_CS__EXCEPT_CLAUSES);

		catchExpCSEClass = createEClass(CATCH_EXP_CS);
		createEReference(catchExpCSEClass, CATCH_EXP_CS__BODY);
		createEReference(catchExpCSEClass, CATCH_EXP_CS__EXCEPTIONS);
		createEReference(catchExpCSEClass, CATCH_EXP_CS__SIMPLE_NAME_CS);

		raiseExpCSEClass = createEClass(RAISE_EXP_CS);
		createEReference(raiseExpCSEClass, RAISE_EXP_CS__EXCEPTION);
		createEReference(raiseExpCSEClass, RAISE_EXP_CS__ARGUMENT);

		// Create enums
		directionKindEnumEEnum = createEEnum(DIRECTION_KIND_ENUM);
		moduleKindEnumEEnum = createEEnum(MODULE_KIND_ENUM);
		importKindEnumEEnum = createEEnum(IMPORT_KIND_ENUM);
		mappingExtensionKindCSEEnum = createEEnum(MAPPING_EXTENSION_KIND_CS);
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
		org.eclipse.ocl.cst.CSTPackage theCSTPackage_1 = (org.eclipse.ocl.cst.CSTPackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.ocl.cst.CSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingModuleCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		libraryCSEClass.getESuperTypes().add(this.getMappingModuleCS());
		importCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		libraryImportCSEClass.getESuperTypes().add(this.getImportCS());
		renameCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		modulePropertyCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		configPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		localPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		contextualPropertyCSEClass.getESuperTypes().add(this.getModulePropertyCS());
		classifierDefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		classifierPropertyCSEClass.getESuperTypes().add(this.getLocalPropertyCS());
		intermediateClassDefCSEClass.getESuperTypes().add(this.getClassifierDefCS());
		exceptionDefCSEClass.getESuperTypes().add(this.getClassifierDefCS());
		oppositePropertyCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		multiplicityDefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		mappingDeclarationCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		parameterDeclarationCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		simpleSignatureCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		completeSignatureCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		mappingMethodCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		mappingRuleCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingQueryCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		constructorCSEClass.getESuperTypes().add(this.getMappingMethodCS());
		mappingSectionCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		mappingSectionCSEClass.getESuperTypes().add(this.getElementWithBody());
		mappingInitCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingEndCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		mappingSectionsCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		statementCSEClass.getESuperTypes().add(theCSTPackage_1.getOCLExpressionCS());
		blockExpCSEClass.getESuperTypes().add(this.getStatementCS());
		computeExpCSEClass.getESuperTypes().add(this.getStatementCS());
		whileExpCSEClass.getESuperTypes().add(this.getStatementCS());
		imperativeLoopExpCSEClass.getESuperTypes().add(theCSTPackage_1.getLoopExpCS());
		imperativeLoopExpCSEClass.getESuperTypes().add(this.getStatementCS());
		forExpCSEClass.getESuperTypes().add(this.getImperativeLoopExpCS());
		imperativeIterateExpCSEClass.getESuperTypes().add(this.getImperativeLoopExpCS());
		switchExpCSEClass.getESuperTypes().add(this.getStatementCS());
		switchAltExpCSEClass.getESuperTypes().add(this.getStatementCS());
		variableInitializationCSEClass.getESuperTypes().add(this.getStatementCS());
		assignStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		breakExpCSEClass.getESuperTypes().add(this.getStatementCS());
		continueExpCSEClass.getESuperTypes().add(this.getStatementCS());
		expressionStatementCSEClass.getESuperTypes().add(this.getStatementCS());
		mappingBodyCSEClass.getESuperTypes().add(this.getMappingSectionCS());
		objectExpCSEClass.getESuperTypes().add(this.getInstantiationExpCS());
		objectExpCSEClass.getESuperTypes().add(this.getElementWithBody());
		mappingCallExpCSEClass.getESuperTypes().add(this.getImperativeOperationCallExpCS());
		imperativeOperationCallExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOperationCallExpCS());
		directionKindCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		resolveExpCSEClass.getESuperTypes().add(theCSTPackage_1.getCallExpCS());
		resolveInExpCSEClass.getESuperTypes().add(this.getResolveExpCS());
		modelTypeCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		modelTypeCSEClass.getESuperTypes().add(this.getElementWithBody());
		packageRefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		transformationHeaderCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		moduleKindCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		moduleRefCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		moduleUsageCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		transformationRefineCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		typeSpecCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		logExpCSEClass.getESuperTypes().add(theCSTPackage_1.getOperationCallExpCS());
		assertExpCSEClass.getESuperTypes().add(this.getStatementCS());
		returnExpCSEClass.getESuperTypes().add(this.getStatementCS());
		mappingExtensionCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		instantiationExpCSEClass.getESuperTypes().add(this.getStatementCS());
		listTypeCSEClass.getESuperTypes().add(theCSTPackage_1.getTypeCS());
		listLiteralExpCSEClass.getESuperTypes().add(theCSTPackage_1.getLiteralExpCS());
		dictionaryTypeCSEClass.getESuperTypes().add(theCSTPackage_1.getTypeCS());
		dictLiteralExpCSEClass.getESuperTypes().add(theCSTPackage_1.getLiteralExpCS());
		dictLiteralPartCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		tagCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		unitCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		resolveOpArgsExpCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		scopedNameCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		tryExpCSEClass.getESuperTypes().add(this.getStatementCS());
		catchExpCSEClass.getESuperTypes().add(theCSTPackage_1.getCSTNode());
		raiseExpCSEClass.getESuperTypes().add(this.getStatementCS());

		// Initialize classes and features; add operations and parameters
		initEClass(mappingModuleCSEClass, MappingModuleCS.class, "MappingModuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMappingModuleCS_HeaderCS(), this.getTransformationHeaderCS(), null, "headerCS", null, 1, 1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Metamodels(), this.getModelTypeCS(), null, "metamodels", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Renamings(), this.getRenameCS(), null, "renamings", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Properties(), this.getModulePropertyCS(), null, "properties", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Methods(), this.getMappingMethodCS(), null, "methods", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_ClassifierDefCS(), this.getClassifierDefCS(), null, "classifierDefCS", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingModuleCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, MappingModuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImportCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(libraryImportCSEClass, LibraryImportCS.class, "LibraryImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(renameCSEClass, RenameCS.class, "RenameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRenameCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRenameCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRenameCS_OriginalName(), theCSTPackage_1.getStringLiteralExpCS(), null, "originalName", null, 0, 1, RenameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modulePropertyCSEClass, ModulePropertyCS.class, "ModulePropertyCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModulePropertyCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, ModulePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(configPropertyCSEClass, ConfigPropertyCS.class, "ConfigPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConfigPropertyCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, ConfigPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(localPropertyCSEClass, LocalPropertyCS.class, "LocalPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLocalPropertyCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getLocalPropertyCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, LocalPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(contextualPropertyCSEClass, ContextualPropertyCS.class, "ContextualPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getContextualPropertyCS_ScopedNameCS(), this.getScopedNameCS(), null, "scopedNameCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getContextualPropertyCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getContextualPropertyCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, ContextualPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierDefCSEClass, ClassifierDefCS.class, "ClassifierDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassifierDefCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 1, 1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierDefCS_Extends(), theCSTPackage_1.getTypeCS(), null, "extends", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierDefCS_Properties(), this.getClassifierPropertyCS(), null, "properties", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierDefCS_Tags(), this.getTagCS(), null, "tags", null, 0, -1, ClassifierDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierPropertyCSEClass, ClassifierPropertyCS.class, "ClassifierPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassifierPropertyCS_StereotypeQualifiers(), theCSTPackage_1.getSimpleNameCS(), null, "stereotypeQualifiers", null, 0, -1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierPropertyCS_FeatureKeys(), theCSTPackage_1.getSimpleNameCS(), null, "featureKeys", null, 0, -1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierPropertyCS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierPropertyCS_Opposite(), this.getOppositePropertyCS(), null, "opposite", null, 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassifierPropertyCS_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", "true", 0, 1, ClassifierPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(intermediateClassDefCSEClass, IntermediateClassDefCS.class, "IntermediateClassDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(exceptionDefCSEClass, ExceptionDefCS.class, "ExceptionDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(oppositePropertyCSEClass, OppositePropertyCS.class, "OppositePropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getOppositePropertyCS_IsNavigable(), ecorePackage.getEBoolean(), "isNavigable", "true", 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getOppositePropertyCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOppositePropertyCS_Multiplicity(), this.getMultiplicityDefCS(), null, "multiplicity", null, 0, 1, OppositePropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(multiplicityDefCSEClass, MultiplicityDefCS.class, "MultiplicityDefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMultiplicityDefCS_LowerBound(), theCSTPackage_1.getPrimitiveLiteralExpCS(), null, "lowerBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMultiplicityDefCS_UpperBound(), theCSTPackage_1.getPrimitiveLiteralExpCS(), null, "upperBound", null, 1, 1, MultiplicityDefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingDeclarationCSEClass, MappingDeclarationCS.class, "MappingDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingDeclarationCS_Qualifiers(), this.getQualifierKindCS(), "qualifiers", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_ContextType(), theCSTPackage_1.getTypeCS(), null, "contextType", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_Result(), this.getParameterDeclarationCS(), null, "result", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_DirectionKindCS(), this.getDirectionKindCS(), null, "directionKindCS", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingDeclarationCS_MappingExtension(), this.getMappingExtensionCS(), null, "mappingExtension", null, 0, -1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getMappingDeclarationCS_IsQuery(), ecorePackage.getEBoolean(), "isQuery", null, 0, 1, MappingDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterDeclarationCSEClass, ParameterDeclarationCS.class, "ParameterDeclarationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterDeclarationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getParameterDeclarationCS_TypeSpecCS(), this.getTypeSpecCS(), null, "typeSpecCS", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getParameterDeclarationCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, ParameterDeclarationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simpleSignatureCSEClass, SimpleSignatureCS.class, "SimpleSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimpleSignatureCS_Params(), this.getParameterDeclarationCS(), null, "params", null, 0, -1, SimpleSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(completeSignatureCSEClass, CompleteSignatureCS.class, "CompleteSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCompleteSignatureCS_SimpleSignature(), this.getSimpleSignatureCS(), null, "simpleSignature", null, 1, 1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCompleteSignatureCS_ResultParams(), this.getParameterDeclarationCS(), null, "resultParams", null, 0, -1, CompleteSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingMethodCSEClass, MappingMethodCS.class, "MappingMethodCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingMethodCS_BlackBox(), ecorePackage.getEBoolean(), "blackBox", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingMethodCS_MappingDeclarationCS(), this.getMappingDeclarationCS(), null, "mappingDeclarationCS", null, 0, 1, MappingMethodCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingRuleCSEClass, MappingRuleCS.class, "MappingRuleCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMappingRuleCS_Guards(), theCSTPackage_1.getOCLExpressionCS(), null, "guards", null, 0, -1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingRuleCS_Posts(), theCSTPackage_1.getOCLExpressionCS(), null, "posts", null, 0, -1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingRuleCS_MappingBody(), this.getMappingSectionsCS(), null, "mappingBody", null, 0, 1, MappingRuleCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingQueryCSEClass, MappingQueryCS.class, "MappingQueryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingQueryCS_IsSimpleDefinition(), ecorePackage.getEBoolean(), "isSimpleDefinition", null, 0, 1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingQueryCS_Body(), this.getBlockExpCS(), null, "body", null, 0, 1, MappingQueryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(constructorCSEClass, ConstructorCS.class, "ConstructorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getConstructorCS_Body(), this.getBlockExpCS(), null, "body", null, 0, 1, ConstructorCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingSectionCSEClass, MappingSectionCS.class, "MappingSectionCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMappingSectionCS_Statements(), theCSTPackage_1.getOCLExpressionCS(), null, "statements", null, 0, -1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingSectionCS_MappingRuleCS(), this.getMappingRuleCS(), null, "mappingRuleCS", null, 0, 1, MappingSectionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingInitCSEClass, MappingInitCS.class, "MappingInitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mappingEndCSEClass, MappingEndCS.class, "MappingEndCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(mappingSectionsCSEClass, MappingSectionsCS.class, "MappingSectionsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getMappingSectionsCS_MappingInitCS(), this.getMappingInitCS(), null, "mappingInitCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingSectionsCS_MappingBodyCS(), this.getMappingBodyCS(), null, "mappingBodyCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getMappingSectionsCS_MappingEndCS(), this.getMappingEndCS(), null, "mappingEndCS", null, 0, 1, MappingSectionsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(statementCSEClass, StatementCS.class, "StatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(blockExpCSEClass, BlockExpCS.class, "BlockExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getBlockExpCS_BodyExpressions(), theCSTPackage_1.getOCLExpressionCS(), null, "bodyExpressions", null, 0, -1, BlockExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(computeExpCSEClass, ComputeExpCS.class, "ComputeExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getComputeExpCS_ReturnedElement(), theCSTPackage_1.getVariableCS(), null, "returnedElement", null, 1, 1, ComputeExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getComputeExpCS_Body(), theCSTPackage_1.getOCLExpressionCS(), null, "body", null, 1, 1, ComputeExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(whileExpCSEClass, WhileExpCS.class, "WhileExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getWhileExpCS_Body(), theCSTPackage_1.getOCLExpressionCS(), null, "body", null, 1, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWhileExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWhileExpCS_ResultVar(), theCSTPackage_1.getVariableCS(), null, "resultVar", null, 0, 1, WhileExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(imperativeLoopExpCSEClass, ImperativeLoopExpCS.class, "ImperativeLoopExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeLoopExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 1, 1, ImperativeLoopExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(forExpCSEClass, ForExpCS.class, "ForExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(imperativeIterateExpCSEClass, ImperativeIterateExpCS.class, "ImperativeIterateExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeIterateExpCS_Target(), theCSTPackage_1.getVariableCS(), null, "target", null, 0, 1, ImperativeIterateExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(switchExpCSEClass, SwitchExpCS.class, "SwitchExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSwitchExpCS_AlternativePart(), this.getSwitchAltExpCS(), null, "alternativePart", null, 1, -1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSwitchExpCS_ElsePart(), theCSTPackage_1.getOCLExpressionCS(), null, "elsePart", null, 0, 1, SwitchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(switchAltExpCSEClass, SwitchAltExpCS.class, "SwitchAltExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSwitchAltExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 1, 1, SwitchAltExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getSwitchAltExpCS_Body(), theCSTPackage_1.getOCLExpressionCS(), null, "body", null, 1, 1, SwitchAltExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(variableInitializationCSEClass, VariableInitializationCS.class, "VariableInitializationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getVariableInitializationCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableInitializationCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getVariableInitializationCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getVariableInitializationCS_WithResult(), ecorePackage.getEBoolean(), "withResult", "false", 1, 1, VariableInitializationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(assignStatementCSEClass, AssignStatementCS.class, "AssignStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssignStatementCS_LValueCS(), theCSTPackage_1.getOCLExpressionCS(), null, "lValueCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssignStatementCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getAssignStatementCS_Incremental(), ecorePackage.getEBoolean(), "incremental", null, 0, 1, AssignStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(breakExpCSEClass, BreakExpCS.class, "BreakExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(continueExpCSEClass, ContinueExpCS.class, "ContinueExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(expressionStatementCSEClass, ExpressionStatementCS.class, "ExpressionStatementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getExpressionStatementCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, ExpressionStatementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingBodyCSEClass, MappingBodyCS.class, "MappingBodyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingBodyCS_HasPopulationKeyword(), ecorePackage.getEBoolean(), "hasPopulationKeyword", null, 0, 1, MappingBodyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(objectExpCSEClass, ObjectExpCS.class, "ObjectExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getObjectExpCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getObjectExpCS_Expressions(), theCSTPackage_1.getOCLExpressionCS(), null, "expressions", null, 0, -1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getObjectExpCS_IsImplicit(), ecorePackage.getEBoolean(), "isImplicit", null, 0, 1, ObjectExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingCallExpCSEClass, MappingCallExpCS.class, "MappingCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingCallExpCS_Strict(), ecorePackage.getEBoolean(), "strict", null, 0, 1, MappingCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(imperativeOperationCallExpCSEClass, ImperativeOperationCallExpCS.class, "ImperativeOperationCallExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getImperativeOperationCallExpCS_Module(), theCSTPackage_1.getSimpleNameCS(), null, "module", null, 0, 1, ImperativeOperationCallExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(directionKindCSEClass, DirectionKindCS.class, "DirectionKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDirectionKindCS_DirectionKind(), this.getDirectionKindEnum(), "directionKind", null, 0, 1, DirectionKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementWithBodyEClass, ElementWithBody.class, "ElementWithBody", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getElementWithBody_BodyStartLocation(), ecorePackage.getEInt(), "bodyStartLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getElementWithBody_BodyEndLocation(), ecorePackage.getEInt(), "bodyEndLocation", "0", 0, 1, ElementWithBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(resolveExpCSEClass, ResolveExpCS.class, "ResolveExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getResolveExpCS_One(), ecorePackage.getEBoolean(), "one", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getResolveExpCS_IsInverse(), ecorePackage.getEBoolean(), "isInverse", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getResolveExpCS_IsDeferred(), ecorePackage.getEBoolean(), "isDeferred", null, 1, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getResolveExpCS_Target(), theCSTPackage_1.getVariableCS(), null, "target", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getResolveExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, ResolveExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(resolveInExpCSEClass, ResolveInExpCS.class, "ResolveInExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getResolveInExpCS_InMappingType(), theCSTPackage_1.getTypeCS(), null, "inMappingType", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getResolveInExpCS_InMappingName(), theCSTPackage_1.getSimpleNameCS(), null, "inMappingName", null, 1, 1, ResolveInExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelTypeCSEClass, ModelTypeCS.class, "ModelTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelTypeCS_IdentifierCS(), theCSTPackage_1.getSimpleNameCS(), null, "identifierCS", null, 1, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelTypeCS_ComplianceKindCS(), theCSTPackage_1.getStringLiteralExpCS(), null, "complianceKindCS", null, 0, 1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelTypeCS_PackageRefs(), this.getPackageRefCS(), null, "packageRefs", null, 1, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelTypeCS_WhereStatements(), theCSTPackage_1.getOCLExpressionCS(), null, "whereStatements", null, 0, -1, ModelTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageRefCSEClass, PackageRefCS.class, "PackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPackageRefCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPackageRefCS_UriCS(), theCSTPackage_1.getStringLiteralExpCS(), null, "uriCS", null, 0, 1, PackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(transformationHeaderCSEClass, TransformationHeaderCS.class, "TransformationHeaderCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTransformationHeaderCS_Qualifiers(), this.getQualifierKindCS(), "qualifiers", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTransformationHeaderCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 1, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTransformationHeaderCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTransformationHeaderCS_ModuleUsages(), this.getModuleUsageCS(), null, "moduleUsages", null, 0, -1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTransformationHeaderCS_TransformationRefineCS(), this.getTransformationRefineCS(), null, "transformationRefineCS", null, 0, 1, TransformationHeaderCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(moduleKindCSEClass, ModuleKindCS.class, "ModuleKindCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getModuleKindCS_ModuleKind(), this.getModuleKindEnum(), "moduleKind", null, 0, 1, ModuleKindCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(moduleRefCSEClass, ModuleRefCS.class, "ModuleRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModuleRefCS_PathNameCS(), theCSTPackage_1.getPathNameCS(), null, "pathNameCS", null, 1, 1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModuleRefCS_Parameters(), this.getParameterDeclarationCS(), null, "parameters", null, 0, -1, ModuleRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(moduleUsageCSEClass, ModuleUsageCS.class, "ModuleUsageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getModuleUsageCS_ImportKind(), this.getImportKindEnum(), "importKind", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModuleUsageCS_ModuleKindCS(), this.getModuleKindCS(), null, "moduleKindCS", null, 0, 1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModuleUsageCS_ModuleRefs(), this.getModuleRefCS(), null, "moduleRefs", null, 1, -1, ModuleUsageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(transformationRefineCSEClass, TransformationRefineCS.class, "TransformationRefineCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTransformationRefineCS_ModuleRefCS(), this.getModuleRefCS(), null, "moduleRefCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTransformationRefineCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 1, 1, TransformationRefineCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeSpecCSEClass, TypeSpecCS.class, "TypeSpecCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeSpecCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 1, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeSpecCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, TypeSpecCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(logExpCSEClass, LogExpCS.class, "LogExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLogExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, LogExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(assertExpCSEClass, AssertExpCS.class, "AssertExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAssertExpCS_Assertion(), theCSTPackage_1.getOCLExpressionCS(), null, "assertion", null, 1, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssertExpCS_Log(), this.getLogExpCS(), null, "log", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAssertExpCS_Severity(), theCSTPackage_1.getSimpleNameCS(), null, "severity", null, 0, 1, AssertExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(returnExpCSEClass, ReturnExpCS.class, "ReturnExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReturnExpCS_Value(), theCSTPackage_1.getOCLExpressionCS(), null, "value", null, 0, 1, ReturnExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(mappingExtensionCSEClass, MappingExtensionCS.class, "MappingExtensionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMappingExtensionCS_Kind(), this.getMappingExtensionKindCS(), "kind", "disjuncts", 0, 1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getMappingExtensionCS_MappingIdentifiers(), this.getScopedNameCS(), null, "mappingIdentifiers", null, 1, -1, MappingExtensionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(instantiationExpCSEClass, InstantiationExpCS.class, "InstantiationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getInstantiationExpCS_TypeSpecCS(), this.getTypeSpecCS(), null, "typeSpecCS", null, 1, 1, InstantiationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getInstantiationExpCS_Arguments(), theCSTPackage_1.getOCLExpressionCS(), null, "arguments", null, 0, -1, InstantiationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(listTypeCSEClass, ListTypeCS.class, "ListTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getListTypeCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, ListTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(listLiteralExpCSEClass, ListLiteralExpCS.class, "ListLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getListLiteralExpCS_CollectionLiteralParts(), theCSTPackage_1.getCollectionLiteralPartCS(), null, "collectionLiteralParts", null, 0, -1, ListLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dictionaryTypeCSEClass, DictionaryTypeCS.class, "DictionaryTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictionaryTypeCS_Key(), theCSTPackage_1.getTypeCS(), null, "key", null, 0, 1, DictionaryTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDictionaryTypeCS_Value(), theCSTPackage_1.getTypeCS(), null, "value", null, 0, 1, DictionaryTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dictLiteralExpCSEClass, DictLiteralExpCS.class, "DictLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictLiteralExpCS_Parts(), this.getDictLiteralPartCS(), null, "parts", null, 0, -1, DictLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dictLiteralPartCSEClass, DictLiteralPartCS.class, "DictLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDictLiteralPartCS_Key(), theCSTPackage_1.getLiteralExpCS(), null, "key", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDictLiteralPartCS_Value(), theCSTPackage_1.getOCLExpressionCS(), null, "value", null, 0, 1, DictLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tagCSEClass, TagCS.class, "TagCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTagCS_Name(), theCSTPackage_1.getStringLiteralExpCS(), null, "name", null, 1, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTagCS_ScopedNameCS(), this.getScopedNameCS(), null, "scopedNameCS", null, 0, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTagCS_OclExpressionCS(), theCSTPackage_1.getOCLExpressionCS(), null, "oclExpressionCS", null, 0, 1, TagCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(unitCSEClass, UnitCS.class, "UnitCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getUnitCS_TopLevelElements(), theCSTPackage_1.getCSTNode(), null, "topLevelElements", null, 0, -1, UnitCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnitCS_Modules(), this.getMappingModuleCS(), null, "modules", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnitCS_ModelTypes(), this.getModelTypeCS(), null, "modelTypes", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getUnitCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, UnitCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(resolveOpArgsExpCSEClass, ResolveOpArgsExpCS.class, "ResolveOpArgsExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getResolveOpArgsExpCS_Target(), theCSTPackage_1.getVariableCS(), null, "target", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getResolveOpArgsExpCS_Condition(), theCSTPackage_1.getOCLExpressionCS(), null, "condition", null, 0, 1, ResolveOpArgsExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(scopedNameCSEClass, ScopedNameCS.class, "ScopedNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getScopedNameCS_TypeCS(), theCSTPackage_1.getTypeCS(), null, "typeCS", null, 0, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getScopedNameCS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ScopedNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tryExpCSEClass, TryExpCS.class, "TryExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTryExpCS_TryBody(), this.getBlockExpCS(), null, "tryBody", null, 1, 1, TryExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTryExpCS_ExceptClauses(), this.getCatchExpCS(), null, "exceptClauses", null, 1, -1, TryExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(catchExpCSEClass, CatchExpCS.class, "CatchExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCatchExpCS_Body(), this.getBlockExpCS(), null, "body", null, 1, 1, CatchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCatchExpCS_Exceptions(), theCSTPackage_1.getTypeCS(), null, "exceptions", null, 0, -1, CatchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getCatchExpCS_SimpleNameCS(), theCSTPackage_1.getSimpleNameCS(), null, "simpleNameCS", null, 0, 1, CatchExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(raiseExpCSEClass, RaiseExpCS.class, "RaiseExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRaiseExpCS_Exception(), theCSTPackage_1.getTypeCS(), null, "exception", null, 1, 1, RaiseExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRaiseExpCS_Argument(), theCSTPackage_1.getOCLExpressionCS(), null, "argument", null, 0, 1, RaiseExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(directionKindEnumEEnum, DirectionKindEnum.class, "DirectionKindEnum"); //$NON-NLS-1$
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.DEFAULT);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.IN);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.OUT);
		addEEnumLiteral(directionKindEnumEEnum, DirectionKindEnum.INOUT);

		initEEnum(moduleKindEnumEEnum, ModuleKindEnum.class, "ModuleKindEnum"); //$NON-NLS-1$
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.TRANSFORMATION);
		addEEnumLiteral(moduleKindEnumEEnum, ModuleKindEnum.LIBRARY);

		initEEnum(importKindEnumEEnum, ImportKindEnum.class, "ImportKindEnum"); //$NON-NLS-1$
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.EXTENSION);
		addEEnumLiteral(importKindEnumEEnum, ImportKindEnum.ACCESS);

		initEEnum(mappingExtensionKindCSEEnum, MappingExtensionKindCS.class, "MappingExtensionKindCS"); //$NON-NLS-1$
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.DISJUNCTS);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.MERGES);
		addEEnumLiteral(mappingExtensionKindCSEEnum, MappingExtensionKindCS.INHERITS);

		initEEnum(qualifierKindCSEEnum, QualifierKindCS.class, "QualifierKindCS"); //$NON-NLS-1$
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.ABSTRACT);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.BLACKBOX);
		addEEnumLiteral(qualifierKindCSEEnum, QualifierKindCS.STATIC);

		// Create resource
		createResource(eNS_URI);
	}

} //CSTPackageImpl
