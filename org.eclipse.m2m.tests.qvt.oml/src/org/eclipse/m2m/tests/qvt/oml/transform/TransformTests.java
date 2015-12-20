/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 302594, 309762, 377882, 388325, 392080, 392153
 *                         397215, 397959, 358709, 388801, 254962, 414555
 *     Alex Paperno - bugs 410470, 392429, 294127, 400720, 314443, 404647, 413131,
 *                         274105, 274505, 415029, 419299, 403440, 267917, 420970,
 *                         424584, 424869
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QVTEvaluationOptions;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.qvt.oml.TransformationExecutor.BlackboxRegistry;
import org.eclipse.m2m.qvt.oml.ocl.legacy.libraries.EmfToolsLibrary;
import org.eclipse.m2m.qvt.oml.ocl.legacy.libraries.StringLibrary;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.tests.qvt.oml.TestBlackboxLibrary;
import org.eclipse.m2m.tests.qvt.oml.bbox.AnnotatedJavaLibrary;
import org.eclipse.m2m.tests.qvt.oml.bbox.Bug289982_Library;
import org.eclipse.m2m.tests.qvt.oml.bbox.Bug427237_Library;
import org.eclipse.m2m.tests.qvt.oml.bbox.SimpleJavaLibrary;
import org.eclipse.m2m.tests.qvt.oml.callapi.DebugExecutorTest;
import org.eclipse.m2m.tests.qvt.oml.callapi.TestQvtExecutor;
import org.eclipse.m2m.tests.qvt.oml.transform.javaless.JavalessQvtTest;
import org.eclipse.m2m.tests.qvt.oml.transform.javaless.JavalessUtil;

import generics.GenericsPackage;
import junit.framework.Test;
import junit.framework.TestSuite;
import simpleuml.SimpleumlPackage;
import testqvt.TestqvtPackage;


/**
 * @author pkobiakov
 */
public class TransformTests {
    public static Test suite() {
        return interpreterSuite();
    }

    public static TestSuite interpreterSuite() {
        TestSuite suite = new TestSuite("QVT interpreter"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        suite.addTest(new TestFailedTransformation(new FileToFileData("scr878") { //$NON-NLS-1$
        	@Override
        	public IContext getContext() {
	    		IContext ctx = super.getContext();
	    		ctx.getSessionData().setValue(QVTEvaluationOptions.FLAG_READONLY_GUARD_ENABLED, Boolean.TRUE);
	    		return ctx;
        	}
        }));
        suite.addTest(new TestFailedTransformation(new FilesToFilesData("bug301134"))); //$NON-NLS-1$
        suite.addTest(new TestFailedTransformation(new FilesToFilesData("bug323915"))); //$NON-NLS-1$
        suite.addTest(new TestFailedTransformation(new FilesToFilesData("bug370098") { //$NON-NLS-1$
        	@Override
        	public IContext getContext() {
        		IContext ctx = super.getContext();
        		ctx.getSessionData().setValue(QVTEvaluationOptions.EVALUATION_MAX_STACK_DEPTH, 10);
        		return ctx;
        	}
        }));
        suite.addTest(new TestFailedTransformation(new FilesToFilesData("bug289982_failed"))); //$NON-NLS-1$

        for (ModelTestData data : datas) {
            suite.addTest(new TestQvtInterpreter(data));
        }
        
		suite.addTest(new TestIncorrectTransformation(
				new ReferencedProjectData("bug433937_wrongImport", "bug433937_referenced", false) { //$NON-NLS-1$ //$NON-NLS-2$
					@Override
					public boolean isUseCompiledXmi() {
						// TODO it should be possible to run this test with the
						// using of compiled XMI
						return false;
					}
				}));
		suite.addTest(new TestIncorrectTransformation(
				new ReferencedProjectData("bug433937_wrongImport", "bug433937_referenced", true) { //$NON-NLS-1$ //$NON-NLS-2$
					@Override
					public boolean isUseCompiledXmi() {
						// TODO it should be possible to run this test with the
						// using of compiled XMI
						return false;
					}
				}));

        suite.addTestSuite(TestStackTrace.class);
        suite.addTestSuite(TestInvalidConfigProperty.class);
        suite.addTestSuite(TestBlackboxLibContext.class);

        return suite;
    }

    public static TestSuite javalessSuite() {
        TestSuite suite = new TestSuite("QVT javaless"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        for (ModelTestData data : datas) {
            if(!JAVALESS_EXCLUDES.contains(data.getName()) && JavalessUtil.isValidJavalessData(data)) {
                JavalessQvtTest test = new JavalessQvtTest(data, JAVALESS_PATCH_OUTPUT.contains(data.getName()));                
                suite.addTest(test);
            }
        }

        return suite;
    }

    public static TestSuite walkerSuite() {
        TestSuite suite = new TestSuite("QVT walker"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        for (ModelTestData data : datas) {
            suite.addTest(new TestQvtWalker(data));
        }

        return suite;
    }

    public static TestSuite executorSuite() {
        TestSuite suite = new TestSuite("QVT executor"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        for (ModelTestData data : datas) {
            suite.addTest(new TestQvtExecutor(data));
        }
        
        return suite;
    }

    public static TestSuite debugExecutorSuite() {
        TestSuite suite = new TestSuite("QVT debug executor"); //$NON-NLS-1$

        ModelTestData[] datas = createTestData();

        for (ModelTestData data : datas) {
            suite.addTest(new DebugExecutorTest(data));
        }
        
        return suite;
    }

    
    public static ModelTestData[] createTestData() {
        return new ModelTestData[] {     		
        		new FilesToFilesData("dicttype"), //$NON-NLS-1$
        		new FileToFileData("transf_inheritance") { //$NON-NLS-1$
        			@Override
        			public List<? extends EPackage> getUsedPackages() {
        				List<EPackage> packages = new ArrayList<EPackage>(super.getUsedPackages());
        				packages.add(SimpleumlPackage.eINSTANCE);
        				packages.add(ExpressionsPackage.eINSTANCE);	
        				packages.add(GenericsPackage.eINSTANCE);
        				return packages;
        			}
        			
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        			}
        		},
        		new FilesToFilesData("uml2_stereotypeApplication", Arrays.asList("in1.ecore", "in2.ecore"), Arrays.asList("expected1.ecore", "expected2.ecore", "expected3.ecore")) {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        			}
        		}, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
        		new FilesToFilesData("subobjects", Arrays.asList("in.ecore"), Collections.<String>emptyList()), //$NON-NLS-1$ //$NON-NLS-2$
        		new FileToFileData("virtual_contextVsOverride"), //$NON-NLS-1$
                new FileToFileData("numconversion", "in.xmi", "expected.pack").includeMetamodelFile("mm.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
                new FilesToFilesData("bug329971", Arrays.asList("Class1.xmi"), Collections.<String>emptyList()).includeMetamodelFile("test1.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        		new FileToFileData("overload_205062"), //$NON-NLS-1$
        		new FileToFileData("overload_singleParam"), //$NON-NLS-1$   
        		new FileToFileData("overload_multipleParams"), //$NON-NLS-1$        		        		
        		new FileToFileData("operation_override"), //$NON-NLS-1$
        		new FileToFileData("fqn_noncontextual") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$
        		new FileToFileData("fqnMainCalls_272937"), //$NON-NLS-1$        		
        		new FileToFileData("fqnMainCalls_271987"), //$NON-NLS-1$        		
        		new FileToFileData("fqnOperationCalls_271789"), //$NON-NLS-1$        		
        		new FileToFileData("importedInstances"), //$NON-NLS-1$        		
        		new FileToFileData("import_access_extends"), //$NON-NLS-1$        		
        		new FileToFileData("import_access_extends_cfgprop", new String[][] { //$NON-NLS-1$ 
        				new String[] { "attrNum", "10" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "outClassName", "ClassFromImportedTransf3_cfgprop" } //$NON-NLS-1$ //$NON-NLS-2$
        		}),         		        		
        		new FileToFileData("slashSingleLineComments_266478"), //$NON-NLS-1$
        		new FileToFileData("nestedPropertiesAssignment_262757"), //$NON-NLS-1$
        		new FileToFileData("listLiteral_259754") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$
        		new FileToFileData("escape_sequences_250630"), //$NON-NLS-1$
        		new FileToFileData("multilineStrings_262733"), //$NON-NLS-1$
        		new FileToFileData("doubleQuoteStrings_262734"), //$NON-NLS-1$
        		new FileToFileData("varInitGroup_261841"), //$NON-NLS-1$
        		new FileToFileData("chainedAssignments_261024"), //$NON-NLS-1$
        		new FileToFileData("_while_261024"), //$NON-NLS-1$
        		new FileToFileData("varInitExpWithResult_260985"), //$NON-NLS-1$
        		new FileToFileData("stdlibModel"), //$NON-NLS-1$        		
        		new FileToFileData("stdlibList") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        			}
        		}, //$NON-NLS-1$
        		new FileToFileData("stdlibDict"), //$NON-NLS-1$        		        		
                new FileToFileData("libraryHeaderWithSignature_257575"), //$NON-NLS-1$                
                new FileToFileData("intermSimple"), //$NON-NLS-1$                
        		new FilesToFilesData("intermProperties", Collections.<String>emptyList(), Arrays.asList("intermProperties.ecore")),        		 //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("intermWithCrossRefs", Collections.<String>emptyList(), Arrays.asList("intermWithCrossRefs.ecore")),        		 //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("intermWithExtends", Collections.<String>emptyList(), Arrays.asList("intermWithExtends.ecore")),        		 //$NON-NLS-1$ //$NON-NLS-2$
        		new FileToFileData("intermWithoutExtent"),        		 //$NON-NLS-1$
        		new FilesToFilesData("constructors", Collections.<String>emptyList(), Arrays.asList("constructors_x.ecore", "constructors_y.ecore")),        		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("libraryWithModuleElements_257184"), //$NON-NLS-1$                
                new FileToFileData("transformationWithModuleElements_257055"), //$NON-NLS-1$                
                new FileToFileData("objectExpBodyExpressions_253051"), //$NON-NLS-1$                
                new FileToFileData("mappingBodyExpressions_252358"), //$NON-NLS-1$                
                new FileToFileData("helperSimpleDef_252173"), //$NON-NLS-1$                
                new FileToFileData("compositetransf"), //$NON-NLS-1$                
                new FileToFileData("computeExp_250403"), //$NON-NLS-1$
                new FileToFileData("forExp_245275") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$
                new FileToFileData("bug244701"), //$NON-NLS-1$
        		new FileToFileData("virtualPredefinedTypeOpers"), //$NON-NLS-1$        		
        		new FileToFileData("blackboxlib_237781") {
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(TestBlackboxLibrary.class, "TestBlackboxLibrary", "TestBlackboxLibrary", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        			};
        		}, //$NON-NLS-1$        		
                new FileToFileData("blackboxlib_annotation_java") {
        			@Override
        			public List<? extends EPackage> getUsedPackages() {
        				List<EPackage> packages = new ArrayList<EPackage>(super.getUsedPackages());
        				packages.add(TestqvtPackage.eINSTANCE);
        				return packages;
        			}
        			
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug233984"), //$NON-NLS-1$
                new FileToFileData("collectionMappingResult"), //$NON-NLS-1$
        		new FileToFileData("intermediateprop_import"), //$NON-NLS-1$ 
                new FileToFileData("intermediateprop_resolve", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("intermediateprop_trace", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        		new FilesToFilesData("multiresultpars", Collections.singletonList("in.ecore"), Arrays.asList("expected_x.ecore", "expected_y.ecore")),        		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FilesToFilesData("simpletag"),           		 //$NON-NLS-1$
        		new FileToFileData("stdlibString") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("stdlibelement", Collections.singletonList("in.ecore"), Arrays.asList("expected_x.ecore", "expected_y.ecore")),           		 //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FileToFileData("mapDisjuncts"), //$NON-NLS-1$ 
        		new FileToFileData("mapInherits"), //$NON-NLS-1$        		
        		new FileToFileData("mapMultipleInherits"), //$NON-NLS-1$        		
        		new FileToFileData("mapMerges"), //$NON-NLS-1$        
                new FileToFileData("bug2437_1"), //$NON-NLS-1$                
                new FileToFileData("bug2437_2") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug2437_3") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug2437_4") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug2437_5") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug2839") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
        		new FileToFileData("populationSection"), //$NON-NLS-1$
        		new FileToFileData("inoutMapping"), //$NON-NLS-1$
        		new FileToFileData("objectExp"), //$NON-NLS-1$        		
                new FileToFileData("bug2787") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$                
                new FileToFileData("bug2741"), //$NON-NLS-1$                
                new FileToFileData("bug2732"), //$NON-NLS-1$                
    			new FileToFileData("bug_214938"), //$NON-NLS-1$    			
		    	new FileToFileData("moduleProperty"), //$NON-NLS-1$    			
                new FileToFileData("simplestXCollectShorthand"), //$NON-NLS-1$                
                new FileToFileData("bug216317"), //$NON-NLS-1$                
                new FileToFileData("oclAllInstances"), //$NON-NLS-1$                
                new FileToFileData("_while"), //$NON-NLS-1$
        
                new FileToFileData("oclannotation", "in.ecore", "expected.xmi").includeMetamodelFile("metamodel.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$    			
                new FileToFileData("importedvirtuals"), //$NON-NLS-1$    	
                new FileToFileData("ocl_test"), //$NON-NLS-1$    			
                new FileToFileData("tuples"), //$NON-NLS-1$    			
                new FileToFileData("oclany"), //$NON-NLS-1$    			
                new FileToFileData("modifyvar"), //$NON-NLS-1$
                new FileToFileData("abstractresult"), //$NON-NLS-1$
                new FileToFileData("bagorderedsetintersection"), //$NON-NLS-1$
                new FileToFileData("nullsource"), //$NON-NLS-1$ 		
                new FileToFileData("isunique"), //$NON-NLS-1$ 		
                new FileToFileData("fqntraces"), //$NON-NLS-1$ 

                new FileToFileData("equndefined"), //$NON-NLS-1$
                new FileToFileData("propertycollect"), //$NON-NLS-1$
                new FileToFileData("resolvenoinput"), //$NON-NLS-1$
                new FileToFileData("addundefined"), //$NON-NLS-1$
                new FileToFileData("propuseprop"), //$NON-NLS-1$
                new FileToFileData("importedprops", new String[][] { //$NON-NLS-1$
                        {"t1", "some"}//$NON-NLS-1$ //$NON-NLS-2$
                }), 
                new FileToFileData("resolveall"), //$NON-NLS-1$
                
                new FileToFileData("imports"), //$NON-NLS-1$
                new FileToFileData("imports_transformations"), //$NON-NLS-1$        
                new FileToFileData("assigntoprimfeature"), //$NON-NLS-1$    	
                new FileToFileData("assigntonullowner"), //$NON-NLS-1$
                new FileToFileData("firstlast") {
        			@Override
        			public List<? extends EPackage> getUsedPackages() {
        				List<EPackage> packages = new ArrayList<EPackage>(super.getUsedPackages());
        				packages.add(TestqvtPackage.eINSTANCE);
        				return packages;
        			}
        		}, //$NON-NLS-1$
                new FileToFileData("accessbooleans", "testqvt.testqvt", "expected.ecore") {
        			@Override
        			public List<? extends EPackage> getUsedPackages() {
        				List<EPackage> packages = new ArrayList<EPackage>(super.getUsedPackages());
        				packages.add(TestqvtPackage.eINSTANCE);
        				return packages;
        			}
        		},   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
                new FileToFileData("localstrings"), //$NON-NLS-1$
                new FileToFileData("castinttodouble"), //$NON-NLS-1$
                new FileToFileData("stringescaping"), //$NON-NLS-1$
                new FileToFileData("exists"), //$NON-NLS-1$
                new FileToFileData("nestednativeops") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(StringLibrary.class, "Strings", "Strings");
        			}
        		}, //$NON-NLS-1$
                new FileToFileData("scr23070"), //$NON-NLS-1$
                new FileToFileData("iterateoverintset"), //$NON-NLS-1$
                new FileToFileData("addrealtostring"), //$NON-NLS-1$
                new FileToFileData("invalidcollectioncast"), //$NON-NLS-1$
                new FileToFileData("virtscr20707"), //$NON-NLS-1$
                new FileToFileData("calloclIsUndefinedforundefined"), //$NON-NLS-1$
                new FileToFileData("callvirtforundefined"),  //$NON-NLS-1$
                new FileToFileData("omittedobject"), //$NON-NLS-1$
                new FileToFileData("omittedobjectwithinit"), //$NON-NLS-1$
                new FileToFileData("primtypesecore") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(EmfToolsLibrary.class, "emf.tools", "tools", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        			}
        		}, //$NON-NLS-1$
                new FileToFileData("scr21329"), //$NON-NLS-1$
                new FileToFileData("scr21121"), //$NON-NLS-1$
                new FileToFileData("scr20811"), //$NON-NLS-1$
                new FileToFileData("scr20041"), //$NON-NLS-1$
                new FileToFileData("scr20038"), //$NON-NLS-1$
                new FileToFileData("scr20667"), //$NON-NLS-1$
                new FileToFileData("scr20469"), //$NON-NLS-1$
                new FileToFileData("scr20471"), //$NON-NLS-1$
                new FileToFileData("scr19364"), //$NON-NLS-1$
                new FileToFileData("scr18739"), //$NON-NLS-1$
                new FileToFileData("scr18514", "pim.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("oclastype"),  //$NON-NLS-1$
                new FileToFileData("usebooleanprop", "in.simpleuml", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("getpropfromundefined"), //$NON-NLS-1$ 
                new FileToFileData("javakeywords"),  //$NON-NLS-1$
                new FileToFileData("scr17812"),  //$NON-NLS-1$
                new FileToFileData("scr18783"), //$NON-NLS-1$
                new FileToFileData("boxing"), //$NON-NLS-1$
                new FileToFileData("scr18572"), //$NON-NLS-1$
                new FileToFileData("propinit"),  //$NON-NLS-1$
                new FileToFileData("allinstances"),  //$NON-NLS-1$
                new FileToFileData("customop", "in.simpleuml", "expected.ecore"),  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("returnundefinedfromquery"), //$NON-NLS-1$ 
                new FileToFileData("addclass"), //$NON-NLS-1$ 
                new FileToFileData("addclassviamodificationininit"), //$NON-NLS-1$ 
                new FileToFileData("addclassviaoutinocl"), //$NON-NLS-1$ 
                new FileToFileData("addclassviasequence"), //$NON-NLS-1$ 
                new FileToFileData("assignresultininit"), //$NON-NLS-1$ 
                new FileToFileData("copynameviacontextmapping"), //$NON-NLS-1$ 
                new FileToFileData("emptyout"), //$NON-NLS-1$ 
                new FileToFileData("full"), //$NON-NLS-1$ 
                new FileToFileData("invresolve_"), //$NON-NLS-1$ 
                new FileToFileData("invresolvebyrule"), //$NON-NLS-1$ 
                new FileToFileData("removeclassesinwhile"), //$NON-NLS-1$ 
                new FileToFileData("resolvebeforeoutcompletion"), //$NON-NLS-1$ 
                new FileToFileData("resolvebyrule"), //$NON-NLS-1$ 
                new FileToFileData("simple"), //$NON-NLS-1$ 
                new FileToFileData("simpleconfigproperty",  //$NON-NLS-1$ 
                        new String[][] {
                        {"FOO", "foo"},  //$NON-NLS-1$ //$NON-NLS-2$
                }), 
                new FileToFileData("simpleproperty"), //$NON-NLS-1$ 
                new FileToFileData("simplerename"), //$NON-NLS-1$ 
                new FileToFileData("simpleresolve"), //$NON-NLS-1$ 
                new FileToFileData("useresultinsameout"), //$NON-NLS-1$ 
                new FileToFileData("virt"), //$NON-NLS-1$ 
                new FileToFileData("overload"), //$NON-NLS-1$ 
                new FileToFileData("voidreturn"), //$NON-NLS-1$ 

                new FileToFileData("lateresolve", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("lateresolvebyrule", "in.simpleuml", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("lateresolve_many", "in.ecore", "expected.simpleuml"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$        
                new FileToFileData("skippopulation", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("iteratetest", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("mapkeyword", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

                new FileToFileData("initsectresultpatch"), //$NON-NLS-1$
                new FileToFileData("endsectresultpatch"), //$NON-NLS-1$

                new FileToFileData("inoutcontextparam", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("inoutcontextparamnoresult", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

                new FileToFileData("contextlesscall", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("setundefinedtoprimitive", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("varassign", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("bugzilla443", "in.ecore", "expected.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                new FileToFileData("resolve_notype"), //$NON-NLS-1$        
                new FileToFileData("resolve_type"), //$NON-NLS-1$        
                new FileToFileData("resolve_vardecl"), //$NON-NLS-1$        
                new FileToFileData("resolve_vardeclcond"), //$NON-NLS-1$        
                new FileToFileData("resolve_vardeclcondwithvar"), //$NON-NLS-1$        
                new FileToFileData("resolve_resolveone"), //$NON-NLS-1$        
                new FileToFileData("resolve_resolveIn"), //$NON-NLS-1$        
                new FileToFileData("resolve_resolveoneIn"), //$NON-NLS-1$        
                new FileToFileData("resolve_invresolveoneIn"), //$NON-NLS-1$        
                new FileToFileData("resolve_lateresolveoneIn"), //$NON-NLS-1$        
                new FileToFileData("resolve_lateresolveoneInaccess"), //$NON-NLS-1$        
                new FileToFileData("bug204126_1"), //$NON-NLS-1$        
                new FileToFileData("bug204126_2"), //$NON-NLS-1$        
                new FileToFileData("bug204126_3"), //$NON-NLS-1$        
                new FileToFileData("bug204126_4"), //$NON-NLS-1$        
                new FileToFileData("bug204126_5"), //$NON-NLS-1$        
                new FileToFileData("bug204126_6"), //$NON-NLS-1$        
                new FileToFileData("bug204126_7"), //$NON-NLS-1$        
                new FileToFileData("bug205303_1"), //$NON-NLS-1$        
                new FileToFileData("bug219075_1"), //$NON-NLS-1$        
        		new FilesToFilesData("continue_break"), //$NON-NLS-1$
        		new FileToFileData("continue_perf") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(EmfToolsLibrary.class, "emf.tools", "tools", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("unspecified_multiplicity", Collections.<String>emptyList(), Collections.singletonList("expected.xmi")) //$NON-NLS-1$ //$NON-NLS-2$
        			.includeMetamodelFile("MyUnbound.ecore"), //$NON-NLS-1$
        		new FilesToFilesData("nullableEnum", Collections.<String>emptyList(), Collections.singletonList("expected.xmi")) //$NON-NLS-1$ //$NON-NLS-2$
        			.includeMetamodelFile("NullableEnumTest.ecore"), //$NON-NLS-1$
        		new FilesToFilesData("bug302594"), //$NON-NLS-1$
        		new FileToFileData("bug309762"), //$NON-NLS-1$
        		new FilesToFilesData("bug377882"), //$NON-NLS-1$
        		new FilesToFilesData("bug388325"), //$NON-NLS-1$
        		new FileToFileData("bug392080"), //$NON-NLS-1$
        		new FileToFileData("bug392153"), //$NON-NLS-1$
        		new FileToFileData("bug397215"), //$NON-NLS-1$
        		new FileToFileData("bug397959"),  //$NON-NLS-1$
        		new FileToFileData("bug358709"), //$NON-NLS-1$
        		new FilesToFilesData("bug388801"), //$NON-NLS-1$
        		new FileToFileData("bug254962"), //$NON-NLS-1$
        		new FilesToFilesData("bug325192"), //$NON-NLS-1$
        		new FileToFileData("bug314443"), //$NON-NLS-1$
        		new FilesToFilesData("bug400720"), //$NON-NLS-1$
        		new FilesToFilesData("bug294127"), //$NON-NLS-1$
        		new FilesToFilesData("bug392429"), //$NON-NLS-1$
        		new FilesToFilesData("bug410470"), //$NON-NLS-1$
        		new FilesToFilesData("bug404647"), //$NON-NLS-1$
        		new FilesToFilesData("bug413131"), //$NON-NLS-1$
        		new FileToFileData("bug274105_274505"), //$NON-NLS-1$
        		new FileToFileData("bug414555"), //$NON-NLS-1$
        		new FilesToFilesData("bug414472"), //$NON-NLS-1$
        		new FileToFileData("bug416584", new String[][] { //$NON-NLS-1$ 
        				new String[] { "libProp", "123" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "prop", "prop" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "prop2", "prop2" }, //$NON-NLS-1$ //$NON-NLS-2$
        		}),         		        		
        		new FilesToFilesData("bug417751"), //$NON-NLS-1$
        		new FilesToFilesData("bug415029"), //$NON-NLS-1$
        		new FilesToFilesData("bug417996"), //$NON-NLS-1$
        		new FilesToFilesData("bug417779", Arrays.asList("in.ecore", "in2.ecore"), Arrays.asList("expected.ecore", "expected2.ecore")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FilesToFilesData("bug418512", Collections.singletonList("in.ecore"), Collections.<String>emptyList()), //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("bug415209"), //$NON-NLS-1$
        		new FilesToFilesData("bug415315"), //$NON-NLS-1$
        		new FilesToFilesData("bug415661"), //$NON-NLS-1$
        		new FilesToFilesData("bug415310"), //$NON-NLS-1$
        		new FilesToFilesData("bug419299"), //$NON-NLS-1$
        		new FilesToFilesData("bug224094"), //$NON-NLS-1$
        		new FilesToFilesData("bug390088"), //$NON-NLS-1$
        		new FileToFileData("bug403440"), //$NON-NLS-1$
        		new FileToFileData("bug414642"), //$NON-NLS-1$
        		new FilesToFilesData("bug267917", Collections.<String>emptyList(), Collections.<String>emptyList(), new String[][] { //$NON-NLS-1$ 
        				new String[] { "optionsDict1", "b=b1, c=c1, a=a1" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict2", "b=10, c=100, a=-1" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict3", "true=false, false=true" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict4", "b=2.2, c=3.3, a=1.1" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict5", "1=a, 2=b, 3=c" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict6", "1=true, 2=false" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsDict7", null }, //$NON-NLS-1$
        				new String[] { "optionsSet", "1.0, 1.1, 1.2" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsList", "foo, bar" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsSequence", "-1, 10" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "optionsOrderedSet", "bar, foo" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedDict1", "[a\\\\a=[a, b], a\\,a=[b, c], a\\[\\[a=[b, c]]" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedDict2", "[[3.0=]=[4=4.0], [1.0=a]=[2=2.0]]" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedSet1", "[[1.0]]" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedSet2", "[[1.1], [2.2], [0.0, 3.3]]" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedSet3", "[]" }, //$NON-NLS-1$ //$NON-NLS-2$
        				new String[] { "nestedSet4", "[[]]" }, //$NON-NLS-1$ //$NON-NLS-2$
        		}),
        		new FilesToFilesData("bug420970", Arrays.asList("test1.ecore", "test2.ecore", "in.ecore"), Arrays.asList("expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FileToFileData("bug392156"), //$NON-NLS-1$
        		new FilesToFilesData("bug424086"), //$NON-NLS-1$
        		new FilesToFilesData("bug422315"), //$NON-NLS-1$
        		new FilesToFilesData("bug424740"), //$NON-NLS-1$
        		new FilesToFilesData("bug418961"), //$NON-NLS-1$
        		new FilesToFilesData("bug424979"), //$NON-NLS-1$
        		new FilesToFilesData("bug289982_importless") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(Bug289982_Library.class, "org.bar.Foo", "Bug289982_Lib", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        				blackboxRegistry.registerModule(TestBlackboxLibrary.class, "TestBlackboxLibrary", "TestBlackboxLibrary", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        				blackboxRegistry.registerModule(SimpleJavaLibrary.class);
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("bug289982") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(Bug289982_Library.class, "org.bar.Foo", "Bug289982_Lib", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        				blackboxRegistry.registerModule(TestBlackboxLibrary.class, "TestBlackboxLibrary", "TestBlackboxLibrary", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        				blackboxRegistry.registerModule(SimpleJavaLibrary.class);
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("bug400233") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("bug424584", Collections.<String>emptyList(), Collections.singletonList("expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("bug386115", Arrays.asList("Container.xmi", "model.ecore"), Collections.<String>emptyList()).includeMetamodelFile("model.ecore"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FilesToFilesData("bug427348"), //$NON-NLS-1$
        		new FilesToFilesData("bug428316"), //$NON-NLS-1$
        		new FilesToFilesData("bug428618"), //$NON-NLS-1$
        		new FilesToFilesData("bug424896"), //$NON-NLS-1$
        		new FileToFileData("bug427237", //$NON-NLS-1$
                        new String[][] {
                        {"prop", "1"},  //$NON-NLS-1$ //$NON-NLS-2$
                }) {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(Bug427237_Library.class);
        			}
        		}, 
        		new FileToFileData("bug427237a") {
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(Bug427237_Library.class);
        			}
        		}, //$NON-NLS-1$
        		new FilesToFilesData("bug425069"), //$NON-NLS-1$
        		new FilesToFilesData("bug432786"), //$NON-NLS-1$
        		new FilesToFilesData("bug397398"), //$NON-NLS-1$
        		new FilesToFilesData("bug433292"), //$NON-NLS-1$
        		new FilesToFilesData("bug370098"), //$NON-NLS-1$
        		new FilesToFilesData("bug326871"), //$NON-NLS-1$
        		new FilesToFilesData("bug326871a"), //$NON-NLS-1$
        		new FilesToFilesData("emptyExtents", Arrays.asList("in1.ecore", "in2.ecore"), Collections.singletonList("expected.ecore")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        		new FilesToFilesData("urilessModeltype"), //$NON-NLS-1$
        		new FilesToFilesData("bug449445"), //$NON-NLS-1$
        		new FilesToFilesData("bug449912", Collections.<String>emptyList(), Collections.singletonList("expected.qvtoperational")), //$NON-NLS-1$ //$NON-NLS-2$
        		new ReferencedProjectData("bug433937", "bug433937_referenced", false) { //$NON-NLS-1$ //$NON-NLS-2$
        			@Override
        			public boolean isUseCompiledXmi() {
        				// TODO it should be possible to run this test with the using of compiled XMI
        				return false;
        			}
        		}, 
        		new ReferencedProjectData("bug433937", "bug433937_referenced", true) { //$NON-NLS-1$ //$NON-NLS-2$
        			@Override
        			public boolean isUseCompiledXmi() {
        				// TODO it should be possible to run this test with the using of compiled XMI
        				return false;
        			}
        		}, 
        		new FilesToFilesData("bug457433", Arrays.asList("in.ecore", "in2.ecore"), Collections.<String>emptyList()), //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("bug440514"), //$NON-NLS-1$
        		new FilesToFilesData("bug415024"), //$NON-NLS-1$
        		new FilesToFilesData("bug463395"), //$NON-NLS-1$
        		new FilesToFilesData("bug463396"), //$NON-NLS-1$
        		new FilesToFilesData("bug463410"), //$NON-NLS-1$
        		new FilesToFilesData("bug463416", Collections.<String>emptyList(), Collections.singletonList("expected.ecore")), //$NON-NLS-1$
        		new FileToFileData("bug463572") { //$NON-NLS-1$
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(EmfToolsLibrary.class, "emf.tools", "tools", new String[] {"http://www.eclipse.org/emf/2002/Ecore"});
        			}
        		},
        		new FilesToFilesData("bug466705") { //$NON-NLS-1$
        			@Override
        			public void prepare(BlackboxRegistry blackboxRegistry) {
        				blackboxRegistry.registerModule(AnnotatedJavaLibrary.class, "org.bar.Foo", "FooJavaLib");
        				blackboxRegistry.registerModule(SimpleJavaLibrary.class);
        			}
        		},
        		new FilesToFilesData("bug467325"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600", Arrays.asList("in.ecore"), Collections.<String>emptyList()), //$NON-NLS-1$ //$NON-NLS-2$
        		new FilesToFilesData("bug467600_Bag"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600_Collection"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600_List"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600_OrderedSet"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600_Sequence"), //$NON-NLS-1$
        		new FilesToFilesData("bug467600_Set"), //$NON-NLS-1$
        		new FilesToFilesData("bug475123"), //$NON-NLS-1$ 
        	};
    }

    private static final Set<String> JAVALESS_EXCLUDES = new HashSet<String>(Arrays.asList(new String[] {
    		// uses getDataTypeInstance() defined on ecore 
            "primtypesecore", //$NON-NLS-1$
            
            // failed to save compiled XMI (ocl problems) 
            "operation_override", "import_access_extends", "import_access_extends_cfgprop", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            
            // fqn access are not correctly patched 
            "importedInstances", "fqn_noncontextual", "fqnOperationCalls_271789", "fqnMainCalls_271987", "fqnMainCalls_272937", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
            "transf_inheritance", //$NON-NLS-1$
            
            // input models use reference that is not in required format: eSuperTypes = "#//NEW_Class1" instead of "//@eClassifiers.0" 
            "assigntonullowner", //$NON-NLS-1$
            "resolveall", //$NON-NLS-1$
            "bug420970", //$NON-NLS-1$
          	"bug467600", //$NON-NLS-1$
            
            // uses getEClassifier() defined on ecore 
            "bug2787", "bug2839", "bug2437_4", "bug2437_5", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    		
            // invoking ecore-specific blackbox operations, which cause mismatching param types in javaless mode
            "blackboxlib_237781", //$NON-NLS-1$
            "uml2_stereotypeApplication", //$NON-NLS-1$
            "bug289982_importless", //$NON-NLS-1$
          	"bug289982", //$NON-NLS-1$
          	"bug326871", //$NON-NLS-1$
          	"bug326871a", //$NON-NLS-1$
          	"bug466705", //$NON-NLS-1$ 
            "blackboxlib_annotation_java", //$NON-NLS-1$

    		// EObjects are created inside blackbox transformation and later merged with javaless objects 
            "bug427237a", //$NON-NLS-1$
            
            // EObjects for incremental update are loaded from original 'in.ecore' so they don't match with those from 'in.ecore.javaless' 
            "bug463572", //$NON-NLS-1$ 
                  	
            // use of Eclipse project references requires patching across multiple projects
          	"bug433937", //$NON-NLS-1$
          	
    }));

    private static final Set<String> JAVALESS_PATCH_OUTPUT = new HashSet<String>(Arrays.asList(new String[] {
    		// EObjects are created inside blackbox transformation thus don't belong to javaless package 
            "bug427237", //$NON-NLS-1$
    }));
}
