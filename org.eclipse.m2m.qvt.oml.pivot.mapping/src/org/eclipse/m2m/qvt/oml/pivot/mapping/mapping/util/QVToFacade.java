/**
 * 
 * @author QuestLab
 * @author AbdulAli
 * @author FitashHaq
 * @since 10 October 2015
 */
package org.eclipse.m2m.qvt.oml.pivot.mapping.mapping.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationBody;
import org.eclipse.m2m.internal.qvt.oml.expressions.impl.ConstructorImpl;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactoryRegistry;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.utilities.PivotObjectImpl;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ParserException;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLFactory;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalFactory;


import simpleuml.SimpleumlPackage;

public class QVToFacade extends OCLInternal {
	public static @NonNull QVToFacade newInstance() {
		return newInstance(BasicProjectManager.createDefaultProjectManager(), null);
	}

	public static @NonNull QVToFacade newInstance(@NonNull ProjectManager projectManager,
			@Nullable ResourceSet externalResourceSet) {
		EnvironmentFactoryInternal environmentFactory = ASResourceFactoryRegistry.INSTANCE
				.createEnvironmentFactory(projectManager, externalResourceSet);
		QVToFacade qvto = newInstance(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}

		return qvto;
	}

	public static @NonNull QVToFacade newInstance(@NonNull EnvironmentFactoryInternal environmentFactory) {
		return new QVToFacade(environmentFactory);
	}

	//private OCL ocl;
	private MetamodelManagerInternal metamodelManager = getMetamodelManager();

	public QVToFacade(@NonNull EnvironmentFactoryInternal environmentFactory) {
		super(environmentFactory);
		metamodelManager = getMetamodelManager();
		EPackage.Registry registry = new EPackageRegistryImpl();
		//registry.put(EXTLibraryPackage.eNS_URI, EXTLibraryPackage.eINSTANCE);
		//ocl = OCL.newInstance(registry);
		//ResourceSet resourceSet = ocl.getResourceSet();
		//org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup.doSetup();
	}

	public @NonNull Helper createHelper(@NonNull EOperation traditionalHelper) {
		Helper pivotHelper = QVTOperationalFactory.eINSTANCE.createHelper();
		// mapParamters(traditionalHelper,pivotHelper);
		pivotHelper.setName(traditionalHelper.getName());
		// pivotHelper.setType(metamodelManager.getASOfEcore(Type.class,
		// traditionalHelper.getEType())); // FIXME Bug 479445
		((PivotObjectImpl) pivotHelper).setESObject(traditionalHelper);
		return pivotHelper;
	}

	private void mapParamters(@NonNull EOperation traditionalOperation, ImperativeOperation pivotImperativeOperation) {
		EList<EParameter> parameters = traditionalOperation.getEParameters();
		// Logger.getLogger().log(Logger.INFO, .getName(), parameters.get(0));
		List<Parameter> pivotParameters = pivotImperativeOperation.getOwnedParameters();
		for (EParameter parameter : traditionalOperation.getEParameters()) {
			Parameter pivotParameter = copyParameterData(parameter);
			pivotParameters.add(pivotParameter);
		}
	}

	private Parameter copyParameterData(EParameter parameter) {
		MappingParameter pivotParameter = QVTOperationalFactory.eINSTANCE.createMappingParameter();
		pivotParameter.setName(parameter.getName());
		Logger.getLogger().log(Logger.INFO, parameter.getName(), parameter);
		pivotParameter.setType(createPivotType(parameter.getEType()));
		return pivotParameter;
	}


	public @NonNull MappingOperation createMappingOperation(@NonNull EOperation traditionalMappingOperation) {
		MappingOperation pivotMappingOperation = QVTOperationalFactory.eINSTANCE.createMappingOperation();
		mapParamters(traditionalMappingOperation, pivotMappingOperation);
		pivotMappingOperation.setName(traditionalMappingOperation.getName());
		pivotMappingOperation
		.setType(createPivotType(traditionalMappingOperation.getEType()));
		((PivotObjectImpl) pivotMappingOperation).setESObject(traditionalMappingOperation);
		return pivotMappingOperation;
	}

	private void mapBody(OperationBody traditionalBody, MappingOperation pivotMappingOperation) {
		// body.accept();
	}

	public @NonNull EntryOperation createEntryOperation(@NonNull EOperation traditionalEntryOperation) {
		EntryOperation pivotEntryOperation = QVTOperationalFactory.eINSTANCE.createEntryOperation();
		mapParamters(traditionalEntryOperation, pivotEntryOperation);
		pivotEntryOperation.setName(traditionalEntryOperation.getName());
		pivotEntryOperation.setType(createPivotType(traditionalEntryOperation.getEType()));
		((PivotObjectImpl) pivotEntryOperation).setESObject(traditionalEntryOperation);

		return pivotEntryOperation;

	}

	public VariableExp createVariableExp(org.eclipse.ocl.expressions.VariableExp<EClassifier, EParameter> v)
	{
		org.eclipse.ocl.pivot.VariableExp pivotVariableExp = PivotFactory.eINSTANCE.createVariableExp();
		Variable<EClassifier, EParameter> vd = v.getReferredVariable();
		String varName = vd.getName();
		pivotVariableExp.setName(varName);
		Logger.getLogger().log(Logger.INFO, "Variable name => "+varName, varName);
		
		EClassifier variableType = v.getType();
		pivotVariableExp.setType(createPivotType(v.getType()));  //FIXME: Can not convert all types like OperationaTransformationImp
		Logger.getLogger().log(Logger.INFO, "Variable type => "+variableType, variableType);
		
		return pivotVariableExp;
	}

	public org.eclipse.ocl.pivot.OperationCallExp createOperationCallExp(OperationCallExp<EClassifier, EOperation> callExp)
	{
		org.eclipse.ocl.pivot.OperationCallExp pivotOperationalCallExp = PivotFactory.eINSTANCE.createOperationCallExp();
		//pivotOperationalCallExp.setType(createPivotType(callExp.getType())); //FIXME Bug 479445
		return pivotOperationalCallExp;
	}
	
	public PropertyCallExp createPropertyCallExp()
	{
		return PivotFactory.eINSTANCE.createPropertyCallExp();
	}
	
	public org.eclipse.ocl.pivot.Variable createVariable()
	{
		return PivotFactory.eINSTANCE.createVariable();
	}
	
	public <T extends Element> T createPivotType(EClassifier traditionalType){
		return (T) metamodelManager.getASOfEcore(Type.class, traditionalType);
	}
	
	public IteratorExp createIteratorExp(org.eclipse.ocl.expressions.IteratorExp<EClassifier, EParameter> callExp)
	{
		org.eclipse.ocl.pivot.IteratorExp pivotIteratorExp = PivotFactory.eINSTANCE.createIteratorExp();
		pivotIteratorExp.setType(createPivotType(callExp.getType())); //FIXME: Can not convert SequenceTypeImpl,OrderedSetTypeImpl 
		return pivotIteratorExp;
	}
	
	public OperationalTransformation createOperationalTransformation()
	{
		return QVTOperationalFactory.eINSTANCE.createOperationalTransformation();
	}
	
	public MappingBody createMappingBody()
	{
		return QVTOperationalFactory.eINSTANCE.createMappingBody();
	}
	
	public ObjectExp createObjectExp(org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp objectExp)
	{
		org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp pivotObjectExp = QVTOperationalFactory.eINSTANCE.createObjectExp();
		pivotObjectExp.setType(createPivotType(objectExp.getType()));
		return pivotObjectExp;
	}
	
	public org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp createAssignExpOCL(AssignExp assignExp)
	{
		org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp pivotAssignExp = ImperativeOCLFactory.eINSTANCE.createAssignExp();
		//pivotAssignExp.setType(metamodelManager.getASOfEcore(Type.class, assignExp.getType())); // FIXME Bug 479445
		return pivotAssignExp;
	}
	
	public org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody createOperationBody()
	{
		return QVTOperationalFactory.eINSTANCE.createOperationBody();
	}
	org.eclipse.ocl.pivot.CollectionLiteralExp createCollectionLiteralExp(CollectionLiteralExp<EClassifier> cl)
	{
		org.eclipse.ocl.pivot.CollectionLiteralExp collectionLiteralExp = PivotFactory.eINSTANCE.createCollectionLiteralExp();
		collectionLiteralExp.setType(createPivotType(cl.getType())); // FIXME: Can not convert type
		return collectionLiteralExp;
	}
	public Constructor createConstructor(@NonNull EOperation traditionalEntryOperation) 
	{
		Constructor pivotConstructor= QVTOperationalFactory.eINSTANCE.createConstructor();
		pivotConstructor.setName(traditionalEntryOperation.getName());
		//pivotConstructor.setType(metamodelManager.getASOfEcore(Type.class, traditionalEntryOperation.getEType()));   // // FIXME Bug 479445
		((PivotObjectImpl)pivotConstructor).setESObject(traditionalEntryOperation);
		return pivotConstructor;
	}
	
	// public Object createVisitOperationBody(OperationBody operationBody) {
	// org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody
	// }
	// 

	/*public ExpressionInOCL createOperationCallExp(@NonNull String callExp) {
		org.eclipse.ocl.pivot.ExpressionInOCL expression = null;
		try {
			//expression = ocl.createQuery(EXTLibraryPackage.Literals.LIBRARY,callExp);
			expression = ocl.createQuery(SimpleumlPackage.Literals.PACKAGE,"package2schema(root)->union(root.getSubpackages()->collect(p | package2schemas(p))->asOrderedSet())->asOrderedSet()");
		} catch (ParserException e) {
			Logger.getLogger().log(Logger.SEVERE, callExp + " cannot be parsed", callExp);
			e.printStackTrace();
		}
		return expression;
	}*/

}
