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
package org.eclipse.m2m.tests.qvt.oml.transform.javaless;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.qvt.oml.util.IContext;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.transform.TestQvtInterpreter;

public class JavalessQvtTest extends TestQvtInterpreter {
		
	private static final String PREFIX = "javaless_"; //$NON-NLS-1$
	
	private final boolean isPatchOutput;
	 
	public JavalessQvtTest(ModelTestData testData, boolean patchOutput) {
		super(createJavalessData(testData));
		setName(PREFIX + testData.getName());
		isPatchOutput = patchOutput;
	}
	
	public static JavalessFilesToFilesData createJavalessData(ModelTestData testData) {
		if(testData instanceof JavalessFilesToFilesData) {
			return (JavalessFilesToFilesData) testData;
		}
		
		if(!JavalessUtil.isValidJavalessData(testData)) {
			throw new IllegalArgumentException("Not a valid javaless test"); //$NON-NLS-1$
		}
		
		return new JavalessFilesToFilesData(testData);
	}
	
	@Override
	protected ITransformer getTransformer() {
		return new DefaultTransformer(getData(), getProject()) {
			@Override
			public List<URI> transform(IFile transformation, List<URI> inUris, URI traceUri, IContext qvtContext) throws Exception {
				List<URI> outUris = super.transform(transformation, inUris, traceUri, qvtContext);
				processOutputUri(outUris);
				return outUris;
			}
		};
	}

	protected void processOutputUri(List<URI> outUris) throws Exception {
		if (!isPatchOutput) {
			return;
		}
		for (URI uri : outUris) {
			File file = URIUtils.getResource(uri).getLocation().toFile();
			String contents = FileUtil.getStreamContents(new FileInputStream(file), ModelTestData.ENCODING);
			contents = JavalessUtil.patchContents(contents);
			FileUtil.setContents(file, new ByteArrayInputStream(contents.getBytes(ModelTestData.ENCODING)));
		}
	}
}
