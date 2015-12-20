package org.eclipse.qvto.examples.xtext.qvtoperational.tests;

import org.eclipse.qvto.examples.pivot.qvtoperational.utilities.QVTOperationalToStringVisitor;

public class QVToXtextTestCase extends AbstractQVToXtextTestCase {

	
	public void testOCLInEcoreLoadAsString() throws Exception {
		
		String testFile =			
			"package mm1 : mm1 = 'mm1' {"				
			+	"class c1	{\n"
			+	"	attribute prop1 : String;\n" 
			+	"}\n" 
			+	"class c2 extends c1 {\n"
			+	"	property prop2 : c1;\n"
			+	"}\n"
			+"}";
		doLoadFromString("loadAsString.oclinecore", testFile);
	}
	
	public void testQVToLoadAsString() throws Exception {
				
		String testFile =
			"metamodel mm1 {\n"
			+	"class c1 {\n"
			+	"	prop1 : String ;\n"	
			+	"};\n" 
			+	"class c2 "
			// FIXME not supported yet + "extends c1\n"
			+ " {\n"
			+	"	prop2 : c1;\n"
			+	"};\n"
			+"}";
		doLoadFromString("loadAsString.qvto2", testFile);
	}
	
	public void testSimpleMetamodelDefinition() throws Exception {
		String testFile =
				"metamodel mm1 {\n"
				// FIXME not supported yet+ "	datatype myDataType;\n" 
				+ "	class c1 {\n"
				+ "		prop1 : String;\n"
				+ "	}\n;"
				+ "};";
		doLoadFromString("simpleMetamodelDefinition.qvto2", testFile);
	}
	
	public void testSimpleMetamodelDefinitionWithoutOptionalSemicolon() throws Exception {
		String testFile =
				"metamodel mm1 {\n"
				// FIXME not supported yet+ "	datatype myDataType\n" 
				+ "	class c1 {\n"
				+ "		composes prop1 : String ;\n"
				+ "	}\n"
				+ "}";
		doLoadFromString("simpleMetamodelDefinitionWithouOptionalSemicolon.qvto2", testFile);
	}
	
	public void testModelTypeDeclarations() throws Exception {
		String testFile =
				"modeltype MM1 \"strict\" uses \"m1URI\";\n"
				+ "modeltype MM2 uses \"m2URI\";\n"
				+ "modeltype MM3 uses abc(\"m3URI\");\n"
				+ "modeltype MM2_3 uses \"m2URI\", abc(\"m3URI\");";
		doLoadFromString("modelTypeDeclarations.qvto2", testFile);
	}
	
	public void testSimpleTransformationDeclaration() throws Exception {
		QVTOperationalToStringVisitor.FACTORY.getClass();
		String testFile =
				"modeltype MM1 uses \"m1URI\";\n"
				+ "transformation t1(inout m1 : MM1);";
		doLoadFromString("simpleTransformationDeclaration.qvto2", testFile);
	}
	
	public void testSimpleBlackboxTransformationDeclaration() throws Exception {
		String testFile =
				"modeltype MM1 uses \"m1URI\";\n"						
				+ "blackbox transformation t1(inout m1 : MM1);";
		doLoadFromString("simpleBlackboxTransformationDeclaration.qvto2", testFile);
	}
	
	public void testSimpleLibraryDeclaration() throws Exception {
		String testFile =
				"modeltype MM1 uses \"m1URI\";\n"						
						+ "library l1(MM1);";
		doLoadFromString("simpleLibraryDeclaration.qvto2", testFile);
	}
	
	public void testSimpleBlackboxLibraryDeclaration() throws Exception {
		String testFile =
				"modeltype MM1 uses \"m1URI\";\n"						
						+ "blackbox library l1(MM1);";
		doLoadFromString("simpleBlackboxLibraryDeclaration.qvto2", testFile);
	}
		
	public void testSimpleMappingDefinition() throws Exception {
		String testFile =
				"modeltype MM1 uses \"m1URI\";\n"						
				+ " transformation t1(inout m1 : MM1) {"
				+ " mapping m1 (in p1 : String);\n"
				+ "}";
		doLoadFromString("simpleMappingDefinition.qvto2", testFile);
	}
}
