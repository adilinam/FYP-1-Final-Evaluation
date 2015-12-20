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
package org.eclipse.m2m.internal.tests.qvt.oml.ui.editor;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.IQvtAnnotationTypes;
import org.eclipse.m2m.tests.qvt.oml.util.ProblemSourceAnnotationHelper;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.RegionInfo;

public class TestQvtProblemAnnotations extends AbstractTestQvtEditorSupport {

	private List<QvtMessage> fProblems;
	
	public TestQvtProblemAnnotations(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();		
		fProblems = getQVTDocumentProvider(fEditor).getCompiledModule().getProblems();
	}
		
	public void testProblemAnnotations() throws Exception {		
		List<AnnotationData> sourceAnnotations = readSourceAnnotations(fEditor);
		assertFalse(sourceAnnotations.isEmpty());
		
		ProblemSourceAnnotationHelper problemHelper = new ProblemSourceAnnotationHelper(sourceAnnotations);
		IAnnotationHover hover = fEditor.getQvtConfiguration().getAnnotationHover(fEditor.getEditorSourceViewer());

		
		for (QvtMessage problemMessage : fProblems) {
			AnnotationData expectedAnnotation = problemHelper.findAnnotationByPosition(problemMessage);
			assertNotNull(expectedAnnotation);
			
			Annotation foundEditorAnnotation = findAnnotation(expectedAnnotation.getAnnotatedRegion());
			assertNotNull(foundEditorAnnotation);			

			assertTrue(ProblemSourceAnnotationHelper.isTheSameSeverity(expectedAnnotation, problemMessage));
			if(ProblemSourceAnnotationHelper.isError(expectedAnnotation)) {
				assertEquals(IQvtAnnotationTypes.ERROR, foundEditorAnnotation.getType());
			} else if(ProblemSourceAnnotationHelper.isWarning(expectedAnnotation)) {
				assertEquals(IQvtAnnotationTypes.WARNING, foundEditorAnnotation.getType());
			} else {
				fail("Unexpected problem severity"); //$NON-NLS-1$
			}
			
			assertTrue("Problem message must be used", problemMessage.getMessage().contains(foundEditorAnnotation.getText())); //$NON-NLS-1$
			
			int line = fEditor.getDocumentProvider().getDocument(fEditor.getEditorInput())
				.getLineOfOffset(problemMessage.getOffset());
			String hoverText = hover.getHoverInfo(fEditor.getEditorSourceViewer(), line);
			assertTrue("Hover text should include problem message", //$NON-NLS-1$
					hoverText != null && hoverText.contains(problemMessage.getMessage()));			
		}		
	}
	
	private Annotation findAnnotation(RegionInfo region) {
		Iterator<?> it = fEditor.getAnnotationModel().getAnnotationIterator();
		while(it.hasNext()) {
			Annotation nextAnnotation = (Annotation) it.next();
			Position pos = fEditor.getAnnotationModel().getPosition(nextAnnotation); 
			if(region.getOffset() == pos.offset && region.getLength() == pos.length) {
				return nextAnnotation;
			}
		}
		
		return null;
	}
}
