/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 272869, 268636, 413130, 404647, 414363, 401521,
 *                         414616, 419299, 414619, 415024, 413391, 424584
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ParserTests {
    public static Test suite() {
        TestSuite suite = new TestSuite("QVT parser"); //$NON-NLS-1$
        
        suite.addTest(new QvtLibraryASTTest());
        
        for (int i = 0; i < ourData.length; i++) {
            TestData data = ourData[i];
            suite.addTest(new TestQvtParser(data));
        }
        
        return suite;
    }
    
    public static class TestData {
        public TestData(String dir, int errCount) { 
        	this(dir, errCount, -1);
        }
        
        public TestData(String dir, int errCount, int warnCount) {
            myDir = dir; 
            myErrCount = errCount; 
            myWarnCount = warnCount;
            usesSourceAnnotations = false;
        }
        
        public String getDir() { return myDir; }
        public int getErrCount() { return myErrCount; }
        public int getWarnCount() { return myWarnCount; }
        
        public int getAllProblemsCount() {
			return myErrCount + myWarnCount;
		}
        
        public boolean usesSourceAnnotations() {
        	return usesSourceAnnotations;
		}
        
        private final String myDir;
        private final int myErrCount;
        private final int myWarnCount;
        private boolean usesSourceAnnotations;

        /**
         * Creates that should be check for match of compilation problems with expected problem 
         * annotation in the test QVT sources 
         */
        public static TestData createSourceChecked(String dir, int errCount, int warnCount) {
        	TestData data = new TestData(dir, errCount, warnCount);
        	data.usesSourceAnnotations = true; 
        	return data;
        }
    }
    
    
    static TestData getTestData(String name) {
    	for (TestData data : ourData) {
			if(name.equals(data.getDir())) {
				return data;
			}
		}
    	
    	throw new IllegalArgumentException("No such testdata: " + name); //$NON-NLS-1$
    }
    
    private static TestData[] ourData = new TestData[] {
    	TestData.createSourceChecked("abstractout", 3, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("collectionAssignment", 4, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("overload_multipleParams", 0, 19), //$NON-NLS-1$
    	TestData.createSourceChecked("overload_singleParam", 0, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("mainInLibrary", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("dynamicpackage", 0, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("importedInstances", 1, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("moduleElementErrorRecovery_265452", 7, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("unitElementErrorRecovery_264517_1", 1, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("unitElementErrorRecovery_264517_2", 3, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("unitElementErrorRecovery_264675", 3, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("nestedPropertiesAssignment_262757", 7, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("collectionOperationNotFound_224093", 3, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("deprecated_importLocation", 0, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("misplacedTopElements", 0, 4), //$NON-NLS-1$
    	TestData.createSourceChecked("escape_sequences_250630", 4, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("multiline_strings_262733", 1, 0), //$NON-NLS-1$    	
    	TestData.createSourceChecked("deprecated_rename", 0, 1), //$NON-NLS-1$    	
    	TestData.createSourceChecked("varInitExpWithResult_261623", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("_while_261024", 4, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("listtype", 7, 0), //$NON-NLS-1$   	
    	TestData.createSourceChecked("listtype2", 7, 0), //$NON-NLS-1$   	
        //new TestData("orderedsetdoesnotconformtoset", 1), //$NON-NLS-1$
        TestData.createSourceChecked("computeExp_252269", 3, 1), //$NON-NLS-1$       
    	new TestData("implicitsource_ocl_234354", 7, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("duplicateModelTypeDef", 1, 0),    	 //$NON-NLS-1$
    	TestData.createSourceChecked("blackboxlib_annotation_java", 1, 2), //$NON-NLS-1$
    	TestData.createSourceChecked("dupImportFileUnit", 0, 1),    	 //$NON-NLS-1$
    	TestData.createSourceChecked("dupImportLibrary", 0, 1),    	 //$NON-NLS-1$
    	TestData.createSourceChecked("testmodelparamtype", 3, 0),    	 //$NON-NLS-1$
    	TestData.createSourceChecked("resolvecond", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("intermPropClash", 9, 0),    	    	 //$NON-NLS-1$
    	TestData.createSourceChecked("noClassInImplicitPopulate", 3, 1),    	 //$NON-NLS-1$
    	TestData.createSourceChecked("parmnamesclash", 22, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("stdlibElementAsOut", 7, 0),    	 //$NON-NLS-1$
        TestData.createSourceChecked("bug2732_wrongcondition", 1, 1), //$NON-NLS-1$      
        TestData.createSourceChecked("varscope", 10, 0), //$NON-NLS-1$      
    	TestData.createSourceChecked("_while", 12, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("implicitCallSrc", 16, 6), //$NON-NLS-1$    	
    	TestData.createSourceChecked("libraryWithModuleElements", 2, 0), //$NON-NLS-1$    	
    	new TestData("assert_log", 0), //$NON-NLS-1$    	
        new TestData("opersignatureparamclash", 1), //$NON-NLS-1$    	
        new TestData("collectreturntype", 0), //$NON-NLS-1$
        new TestData("nocollectoncollection", 0), //$NON-NLS-1$
        	///Commented out, due to migration to OCL 1.2, TODO - clarify the current error reporting with MDT, seems to be incorrect
        	// new TestData("nonstaticcallinstaticcontext", 1), //$NON-NLS-1$ 
        new TestData("virtrettypemismatch", 1), //$NON-NLS-1$
        new TestData("missinglibmmimport", 1), //$NON-NLS-1$
        new TestData("noglobalallinstances", 0), //$NON-NLS-1$ 
        new TestData("imp", 0), //$NON-NLS-1$ // TODO: independent parsing for imports
        new TestData("imp2", 0), //$NON-NLS-1$
        new TestData("imp3", 0), //$NON-NLS-1$
        TestData.createSourceChecked("impError", 3, 0), //$NON-NLS-1$        
        new TestData("assignereadonlyprop", 1), //$NON-NLS-1$
        new TestData("nonbooleanguard", 1), //$NON-NLS-1$
        TestData.createSourceChecked("sameparamname", 2, 0), //$NON-NLS-1$
        new TestData("badtype", 1), //$NON-NLS-1$
        new TestData("simple", 0),   //$NON-NLS-1$
        new TestData("selfimport", 1), //$NON-NLS-1$
        new TestData("normalimport", 0), //$NON-NLS-1$
        new TestData("missingmappingcall", 1), //$NON-NLS-1$
        new TestData("missingfeature", 1), //$NON-NLS-1$
        new TestData("featuretypemismatch", 1), //$NON-NLS-1$
        new TestData("initvariable", 1), //$NON-NLS-1$
        new TestData("missingvariablereference", 1), //$NON-NLS-1$
        new TestData("optionalout", 0), //$NON-NLS-1$
        new TestData("nonassignableout", 1), //$NON-NLS-1$
        TestData.createSourceChecked("wrongout", 3, 0), //$NON-NLS-1$
        new TestData("outininitvar", 0), //$NON-NLS-1$
        new TestData("modifyfeature", 0), //$NON-NLS-1$
        new TestData("missingout", 2), //$NON-NLS-1$
        new TestData("modifyfeatureerror", 2), //$NON-NLS-1$
        new TestData("bodywithsemicolon", 0), //$NON-NLS-1$
        new TestData("modifyparam", 0), //$NON-NLS-1$
        TestData.createSourceChecked("wrongparamnameinout", 2, 0), //$NON-NLS-1$
        new TestData("modifyfeatureininiterror", 2), //$NON-NLS-1$
        TestData.createSourceChecked("voidout", 2, 0), //$NON-NLS-1$
        new TestData("modifyinparam", 1), //$NON-NLS-1$
        new TestData("modifyresult", 0), //$NON-NLS-1$
        new TestData("wrongorderininit", 1), //$NON-NLS-1$
        new TestData("duplicateinitvariable", 1), //$NON-NLS-1$
        TestData.createSourceChecked("missingObjectType", 1, 0), // replaced former 'nestedouterror' //$NON-NLS-1$
        new TestData("emptyinit", 0), //$NON-NLS-1$
        new TestData("assignresultininit", 0), //$NON-NLS-1$
        new TestData("assign_inoutParam", 2), //$NON-NLS-1$
        new TestData("assign_inParam", 2), //$NON-NLS-1$
        new TestData("assign_varThis", 1), //$NON-NLS-1$                        
        
        new TestData("errorinexpressionlist", 1), //$NON-NLS-1$
        new TestData("largefile", 0), //$NON-NLS-1$
        new TestData("calldump", 0), //$NON-NLS-1$
        new TestData("missingparamname", 2), //$NON-NLS-1$
        new TestData("nameclash", 1), //$NON-NLS-1$
        new TestData("emptymodule", 0), //$NON-NLS-1$
        new TestData("props", 0), //$NON-NLS-1$
        new TestData("duplicatelocalproperty", 1), //$NON-NLS-1$
        new TestData("wrongorderinproperty", 1), //$NON-NLS-1$
        new TestData("implicitpopulation", 0), //$NON-NLS-1$
        new TestData("implicitpopulationwithinit", 0), //$NON-NLS-1$
        new TestData("mapkeyword", 0), //$NON-NLS-1$
        new TestData("endsectfull", 0), //$NON-NLS-1$
        new TestData("endsectimplicitpopulation", 0), //$NON-NLS-1$
        new TestData("endsectimplicitpopulationnoinit", 0), //$NON-NLS-1$
        new TestData("endsectinitnopopulation", 0), //$NON-NLS-1$
        new TestData("endsectonly", 0), //$NON-NLS-1$
        new TestData("endsectpopulationnoinit", 0), //$NON-NLS-1$
        new TestData("configpropstype", 0), //$NON-NLS-1$

        new TestData("mm_header1", 1), //$NON-NLS-1$
        new TestData("mm_header2", 1), //$NON-NLS-1$
        new TestData("mm_header3", 1), //$NON-NLS-1$
        new TestData("mm_header4", 1), //$NON-NLS-1$
        new TestData("mm_header5", 2), //$NON-NLS-1$
        new TestData("mm_header6", 1), //$NON-NLS-1$
        new TestData("mm_header7", 1), //$NON-NLS-1$
        new TestData("entryOpDupl", 1), //$NON-NLS-1$
        new TestData("resolveIn_ambiguity", 1), //$NON-NLS-1$
        new TestData("bug205303_2", 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug325192", 8, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug268636", 5, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug272869", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug413130", 0, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("bug404647_2", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug414363", 0, 28), //$NON-NLS-1$
    	TestData.createSourceChecked("bug401521", 2, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug414616", 2, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug419299", 8, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug414619", 0, 5), //$NON-NLS-1$
    	TestData.createSourceChecked("bug415024", 1, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug413391", 10, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug424912", 0, 6), //$NON-NLS-1$
    	TestData.createSourceChecked("bug289982_ambiguousLib", 0, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("bug289982_undefinedLib", 0, 1), //$NON-NLS-1$
    	TestData.createSourceChecked("bug289982_validation", 7, 7), //$NON-NLS-1$
    	TestData.createSourceChecked("bug424584", 11, 0), //$NON-NLS-1$
    	new TestData("bug428028", 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug425634", 0, 6), //$NON-NLS-1$
    	new TestData("bug433585", 0), //$NON-NLS-1$
    	new TestData("bug438038", 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug446375", 2, 0), //$NON-NLS-1$
    	TestData.createSourceChecked("bug468303", 0, 1), //$NON-NLS-1$
    };
}
