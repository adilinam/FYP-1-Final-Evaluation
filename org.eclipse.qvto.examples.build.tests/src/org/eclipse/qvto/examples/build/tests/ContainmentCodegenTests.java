package org.eclipse.qvto.examples.build.tests;

import org.eclipse.ocl.examples.codegen.oclinjunit.JUnitCodeGenerator;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ContainmentCodegenTests {

	OCLInternal ocl;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		EssentialOCLStandaloneSetup.doSetup();
		OCLstdlib.install();
	}
	
	@Before
	public void setUp()
			throws Exception {
		
		ocl = OCLInternal.newInstance();
	}

	@After
	public void tearDown()
			throws Exception {
	}

	@Test
	public void test() throws Exception {
		Operation myOp = createTestOperation();

		ExpressionInOCL opBody = createOperationBody("2 + 3", myOp);
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(ocl.getEnvironmentFactory(), opBody, getJavaPacakgeName(), myOp.getName());
		int i = 0;
		
		// TODO test something
	}
	
	@Test
	public void test2() throws Exception {
		Operation myOp = createTestOperation();
		
		ExpressionInOCL opBody = createOperationBody(
			"MyClass{"
			+ " myProp1 = 2,"
			+ " myProp2 = 'foo'"
			+ "}", myOp);		
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(ocl.getEnvironmentFactory(), opBody, getJavaPacakgeName(), myOp.getName());

		int i = 0;
		
		// TODO test something
		
		
	}
	
	@Test
	public void test3() throws Exception {
		Operation myOp = createTestOperation();
		
		ExpressionInOCL opBody = createOperationBody(
			"Tuple{"
			+ " p1 = 2,"
			+ " p2 = 'foo'"
			+ "}", myOp);
		
		// TODO use the containtment code generator when implemented
		String genCode = JUnitCodeGenerator.generateClassFile(ocl.getEnvironmentFactory(), opBody,  getJavaPacakgeName(), myOp.getName());

		int i = 0;
		
		// TODO test something
	}
	
	protected Operation createTestOperation() {		

		MetamodelManagerInternal mManager = ocl.getMetamodelManager();
		Class myClass = PivotFactory.eINSTANCE.createClass();
		myClass.setName("MyClass");
		Property p1 = PivotFactory.eINSTANCE.createProperty();
		p1.setName("myProp1");
		p1.setType(mManager.getStandardLibrary().getIntegerType());
		Property p2 = PivotFactory.eINSTANCE.createProperty();
		p2.setName("myProp2");
		p2.setType(mManager.getStandardLibrary().getStringType());		
		Operation myOp = PivotFactory.eINSTANCE.createOperation();		
		myOp.setName("myOp");
		myOp.setType(mManager.getStandardLibrary().getIntegerType());
		
		
		ocl.getEnvironmentFactory().getCompleteEnvironment().addOrphanClass(myClass);
		myClass.getOwnedProperties().add(p1);
		myClass.getOwnedProperties().add(p2);
		myClass.getOwnedOperations().add(myOp);
		return myOp;
	}
	
	protected ExpressionInOCL createQuery(String query, Type context) throws Exception {
		OCLHelper helper = ocl.createOCLHelper(context);		
		return helper.createQuery(query);		
	}
	
	protected ExpressionInOCL createOperationBody(String bodyExpression, Operation operation) throws Exception {
		OCLHelper helper = ocl.createOCLHelper(operation);
		return helper.createBodyCondition(bodyExpression);
	}
	
	protected String getJavaPacakgeName() {
		return "tests_package";
	}
//	protected CodeGenHelper getCodeGenHelper(@NonNull MetaModelManager metaModelManager) throws Exception {
//		URI genModelURI = URI.createPlatformResourceURI(
//				"/org.eclipse.ocl.examples.pivot/model/Pivot.merged.genmodel",
//				true);
//		Resource genModelResource = resourceSet.getResource(genModelURI, true);
//		String errorsString = PivotUtil.formatResourceDiagnostics(
//				genModelResource.getErrors(), "Loading " + genModelURI, "\n");
//		if (errorsString != null) {
//			throw new IllegalStateException("Errors in pivot.merged.genmodel");
//		}
//		GenModel genModel = (GenModel) genModelResource.getContents().get(0);
//		return new JavaGenModelCodeGenHelper(genModel, metaModelManager);
//	}
	
	
}
