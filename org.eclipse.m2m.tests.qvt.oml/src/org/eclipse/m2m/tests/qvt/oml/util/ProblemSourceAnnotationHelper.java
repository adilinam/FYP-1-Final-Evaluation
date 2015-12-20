/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.Position;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.RegionInfo;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;


public class ProblemSourceAnnotationHelper {
	
	private static final String ERROR_TAG = "error"; //$NON-NLS-1$
	private static final String WARN_TAG = "warn"; //$NON-NLS-1$
	
	private Map<Position, AnnotationData> fPositionedMap = new LinkedHashMap<Position, AnnotationData>();
	
	public ProblemSourceAnnotationHelper(List<AnnotationData> annotations) {
		for (AnnotationData nextAnnotation : annotations) {
			RegionInfo region = nextAnnotation.getAnnotatedRegion();
			fPositionedMap.put(new Position(region.getOffset(), region.getLength()), nextAnnotation);
		}
	}
	
	public Map<Position, AnnotationData> getProblemsMap() {
		return Collections.unmodifiableMap(fPositionedMap);
	}
		
	public static boolean isTheSameSeverity(AnnotationData sourceAnnotation, QvtMessage message) {
		return (message.getSeverity() == QvtMessage.SEVERITY_ERROR && isError(sourceAnnotation)) ||
		(message.getSeverity() == QvtMessage.SEVERITY_WARNING && isWarning(sourceAnnotation));
	}
	
	public AnnotationData findAnnotationByPosition(QvtMessage message) {		
		return fPositionedMap.get(new Position(message.getOffset(), message.getLength()));
	}
	
	public static boolean isError(AnnotationData sourceAnnotation) {
		return ERROR_TAG.equals(sourceAnnotation.getName());
	}

	public static boolean isWarning(AnnotationData sourceAnnotation) {
		return WARN_TAG.equals(sourceAnnotation.getName());
	}
	
	public void assertMarchingProblems(List<QvtMessage> problems) throws AssertionFailedError {
		for (QvtMessage problemMessage : problems) {
			AnnotationData expectedAnnotation = findAnnotationByPosition(problemMessage);
			TestCase.assertNotNull("Unexpected compilation problem message. " + problemMessage, expectedAnnotation); //$NON-NLS-1$
							
			TestCase.assertTrue(ProblemSourceAnnotationHelper.isTheSameSeverity(expectedAnnotation, problemMessage));
			
			if(ProblemSourceAnnotationHelper.isError(expectedAnnotation)) {
				TestCase.assertEquals(QvtMessage.SEVERITY_ERROR, problemMessage.getSeverity());
			} else if(ProblemSourceAnnotationHelper.isWarning(expectedAnnotation)) {
				TestCase.assertEquals(QvtMessage.SEVERITY_WARNING, problemMessage.getSeverity());
			} else {
				TestCase.fail("Unexpected problem severity"); //$NON-NLS-1$
			}
			
			TestCase.assertTrue("Problem message must be used", problemMessage.getMessage().contains(problemMessage.getMessage())); //$NON-NLS-1$			
		}
	}
	
	public static ProblemSourceAnnotationHelper assertCompilationProblemMatchExpectedAnnotations(CompiledUnit compiledModule) throws AssertionFailedError {
		ProblemSourceAnnotationHelper problemSourceAnnotationHelper = ProblemSourceAnnotationHelper.create(compiledModule);
		problemSourceAnnotationHelper.assertMarchingProblems(compiledModule.getProblems());
		return problemSourceAnnotationHelper;
	}
	
	public static ProblemSourceAnnotationHelper create(CompiledUnit compiledModule) throws AssertionFailedError {
		URI source = compiledModule.getURI();		
		try {
			InputStream is = new ExtensibleURIConverterImpl().createInputStream(source);
			String contents = FileUtil.getStreamContents(is, ResourcesPlugin.getEncoding());
			SourceAnnotationReader annotationReader = new SourceAnnotationReader(contents, false);
			return new ProblemSourceAnnotationHelper(annotationReader.getAnnotations());
		} catch (IOException e) {
			e.printStackTrace();
			TestCase.fail("Failed to read source file. " + e); //$NON-NLS-1$
		}
		return null;
	}
	
}
