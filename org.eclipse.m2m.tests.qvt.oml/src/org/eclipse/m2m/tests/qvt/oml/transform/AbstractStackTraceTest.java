/*******************************************************************************
 * Copyright (c) 2008, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.transform;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;

public abstract class AbstractStackTraceTest extends TestTransformation {

	protected boolean fEnableLineNumbers = true;
	protected boolean fUseCompiledXMI = true;
	protected StringWriter fLogger = new StringWriter();

	public AbstractStackTraceTest(ModelTestData data) {
		super(data);
	}
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		
		buildTestProject();
	}	
	
	protected static void assertValidQVTRuntimeException(QvtRuntimeException exception) {
		assertNotNull(exception);
		assertNotNull(exception.getQvtStackTrace());
		assertTrue(exception.getQvtStackTrace().size() > 0);
	}

	protected QvtRuntimeException runQvtModuleTestCase(String testCaseName) throws Exception {
		return runQvtModuleTestCase(testCaseName, null);
	}
	
	protected QvtRuntimeException runQvtModuleTestCase(String testCaseName, Map<String, Object> configProperties) throws Exception {
	    ITransformer transformer = createTransformer();
		try {
			Map<String, Object> passedProps = (configProperties == null) ? Collections.<String, Object>emptyMap() : configProperties;
			Map<String, Object> extProps = new HashMap<String, Object>(passedProps);
			extProps.put("testcase", testCaseName);		//$NON-NLS-1$		
			IContext context = QvtLaunchUtil.createContext(extProps);
			
			transformer.transform(
					getIFile(getData().getTransformation(getProject())),
					getData().getIn(getProject()), getData().getTrace(getProject()), context);
		} catch (QvtRuntimeException e) {
			return e;			
		}
		
		return null;
	}

	protected String loadExpectedStackDump(String testCase) throws IOException {
		return loadExpectedDump(testCase + ".stack"); //$NON-NLS-1$
	}

	protected void assertLogMatch(String testCase) throws Exception {
		String expectedContents = loadExpectedLogDump(testCase);
		assertFalse("Non-empty log expected", expectedContents.length() == 0); //$NON-NLS-1$
		
		String logContents = fLogger != null ? fLogger.getBuffer().toString() : ""; //$NON-NLS-1$
		assertFalse("Non-empty log expected", logContents.length() == 0); //$NON-NLS-1$
		
		assertEqualContents(expectedContents, logContents);
	}

	private String loadExpectedLogDump(String testCase) throws IOException {
		return loadExpectedDump(testCase + ".log.txt"); //$NON-NLS-1$
	}

	private String loadExpectedDump(String fileName) throws IOException {
		File parentFolder = getData().getTransformation(getTestProject().getProject()).getParentFile();
		FileReader freader = new FileReader(new File(parentFolder, fileName));
		
		CharBuffer buf = CharBuffer.allocate(1024);
		StringBuilder result = new StringBuilder();
		
	    for (;;) {
	        int read = freader.read(buf);            
	        if (read < 0) {
	            break;
	        }
	        
	        buf.flip();
	        result.append(buf);
	    }
	    
	    freader.close();
	    
		return result.toString();
	}

	private ITransformer createTransformer() {
		
		boolean useCompiledXMI = fUseCompiledXMI && getData().isUseCompiledXmi();
		
		return new TestQvtInterpreter.DefaultTransformer(useCompiledXMI, getData().getResourceSet(null)) {
			
			@Override
			protected QvtInterpretedTransformation getTransformation(IFile transformation) {
				QvtInterpretedTransformation transf = super.getTransformation(transformation);
				
				if (!fUseCompiledXMI) {
					QvtCompilerOptions options = new QvtCompilerOptions();
		        	options.setGenerateCompletionData(false);
		        	options.setSourceLineNumbersEnabled(fEnableLineNumbers);	        	
		        	transf.setQvtCompilerOptions(options);
				}
				
				return transf;	
			}
			
			@Override
	        public List<URI> transform(IFile transformation, List<URI> inUris, URI traceUri, IContext context) throws Exception {
	        	QvtInterpretedTransformation transf = getTransformation(transformation);
	        	
	        	if(!fUseCompiledXMI) {
	        		TestUtil.assertAllPersistableAST(transf.getModule().getUnit());
	        	}	        	
	        	
	        	Context qvtContext = QvtLaunchUtil.createContext(context.getConfigProperties());
	        	qvtContext.setLog(new WriterLog(fLogger));
	            
	        	return launchTransform(transformation, inUris, traceUri, qvtContext, transf);
	        }
		};
	}	

}