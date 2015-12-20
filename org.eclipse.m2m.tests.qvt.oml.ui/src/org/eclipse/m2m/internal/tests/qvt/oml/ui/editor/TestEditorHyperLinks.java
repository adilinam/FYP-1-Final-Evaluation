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


import java.util.List;

import junit.framework.AssertionFailedError;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks.QvtHyperlinkDetector;
import org.eclipse.m2m.internal.tests.qvt.oml.ui.editor.HyperLinkHelper.SourceHyperLink;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;


public class TestEditorHyperLinks extends AbstractTestQvtEditorSupport {

	private static final int TEST_LINK_COUNT = 38;
	
	// TODO - Should not be copied here but exposed by Metamodel Browser
	private static final String METAMODEL_BROWSER_VIEW_ID = "org.eclipse.m2m.internal.qvt.oml.common.views.MetamodelBrowserView"; //$NON-NLS-1$

	public TestEditorHyperLinks(String test) {
		super(test);
	}
	
	public void testhyperlinks() throws Exception {
		doTest(TEST_LINK_COUNT);
	}
	
	private void doRunTestChecks(int[] testResult) {
		final List<AnnotationData> sourceAnnotations = readSourceAnnotations(fEditor);		
		HyperLinkHelper hyperLinkBindings = new HyperLinkHelper(sourceAnnotations);
		for (SourceHyperLink sourceHLink : hyperLinkBindings.getHyperLinks()) {
			IRegion pointerReg = new Region(sourceHLink.link.getAnnotatedRegion().getOffset(), 0);
			
			IHyperlink[] hyperlinks = new QvtHyperlinkDetector(fEditor.getQVTDocumentProvider()).detectHyperlinks(fEditor.getEditorSourceViewer(), pointerReg, false);
			assertNotNull(message("No hyperlink detected for", sourceHLink), hyperlinks); //$NON-NLS-1$
			assertEquals(1, hyperlinks.length);
			
			IHyperlink hlink = hyperlinks[0];
			IRegion hlinkRegion = new Region(sourceHLink.link.getAnnotatedRegion().getOffset(), sourceHLink.link.getAnnotatedRegion().getLength());					
			assertEquals(sourceHLink.toString(), 
					hlink.getHyperlinkRegion().getOffset(), hlinkRegion.getOffset());
			assertEquals(sourceHLink.toString(), 
					hlink.getHyperlinkRegion().getLength(), hlinkRegion.getLength());					
			
			ITextHover hover = fEditor.getQvtConfiguration().getTextHover(fEditor.getEditorSourceViewer(), null);
			assertNotNull("Text hover must be available", hover); //$NON-NLS-1$
			String hoverText = (String)((ITextHoverExtension2)hover).getHoverInfo2(fEditor.getEditorSourceViewer(), pointerReg);
			assertTrue(message("No hover for hyperlink", sourceHLink), //$NON-NLS-1$ 
					hoverText != null && hoverText.trim().length() > 0);
			
			// Navigate to hyper-link destination			
			hlink.open();
			
			if(sourceHLink.targetModule != null) {
				QvtEditor mainEditor = fEditor;
				IFile mainSourceFile = getSourceFile(mainEditor);
				IFile targetFile = (IFile)mainSourceFile.getParent().findMember(sourceHLink.targetModule + ".qvto"); //$NON-NLS-1$
				QvtEditor expectedActiveEditor = openInEditor(targetFile);							
				assertSame(expectedActiveEditor, getActiveEditor());
				assertNotSame(expectedActiveEditor, mainEditor);

				List<AnnotationData> targetAnnotations = readSourceAnnotations(expectedActiveEditor);
				AnnotationData target = new HyperLinkHelper(targetAnnotations).getTargetRegion(sourceHLink.link.getAttrValue(HyperLinkHelper.HYPERLINK_REF_ATTR));
				
				Point targetPost = expectedActiveEditor.getEditorSourceViewer().getSelectedRange();
				int targetOffset = target.getAnnotatedRegion().getOffset();
				int targetRangeLen = target.getAnnotatedRegion().getLength();
				assertEquals(sourceHLink.toString(), targetPost.x, targetOffset);
				assertEquals(sourceHLink.toString(), targetPost.y, targetRangeLen);							
				
				expectedActiveEditor.close(false);
				testResult[0]++;						
				
			} else if(sourceHLink.targeRegion != null) {						
				Point targetPost = fEditor.getEditorSourceViewer().getSelectedRange();					
				int targetOffset = sourceHLink.targeRegion.getOffset();
				int targetRangeLen = sourceHLink.targeRegion.getLength();
				assertEquals(message("Link failed:", sourceHLink), targetPost.x, targetOffset);
				assertEquals(sourceHLink.toString(), targetPost.y, targetRangeLen);							
				
				testResult[0]++;
			} else if(sourceHLink.targetElemenUri != null) {
				EModelElement targetElement = findResolvedTargetMetamodelElement();
				assertNotNull(message("Navigated element must be selected", sourceHLink), //$NON-NLS-1$ 
						targetElement);
				URI resolvedUri = EcoreUtil.getURI(targetElement);
				assertNotNull(message("Element of expected URI must be found", sourceHLink), //$NON-NLS-1$
						sourceHLink.targetElemenUri.equals(resolvedUri)); 
				
				testResult[0]++;
			}
		}
	}	
	
	private void doTest(int expectedHyperLinkCount) throws AssertionFailedError {		
		final int[] testResult = new int[] { 0 };
		final Throwable[] testError = new Throwable[] { null };
		
		Display.getCurrent().syncExec(new Runnable() {			
			public void run() {
				try {
					doRunTestChecks(testResult);
				} catch (Throwable e) {
					testError[0] = e;
				}
			}
		});			
		
		if(testError[0] != null) {
			Throwable t = testError[0];
			if(t instanceof AssertionFailedError) {
				throw (AssertionFailedError)t;
			} 
			
			t.printStackTrace();			
			fail(t.toString());			
		}
		
		assertTrue("Not all hyper links have been resolved succesfully", testResult[0] >= expectedHyperLinkCount); //$NON-NLS-1$
	}
	
	
	private EModelElement findResolvedTargetMetamodelElement() {
		IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(METAMODEL_BROWSER_VIEW_ID);
		assertNotNull(view);
		assertFalse(view.getViewSite().getSelectionProvider().getSelection().isEmpty());

		ISelection sel = view.getViewSite().getSelectionProvider().getSelection();
		if(sel instanceof IStructuredSelection) {			
			IStructuredSelection structSel = (IStructuredSelection) sel;
			Object elementHolder = structSel.getFirstElement();
			assertTrue("Must be IAdaptable element", elementHolder instanceof IAdaptable); //$NON-NLS-1$
			IAdaptable adaptable = (IAdaptable)elementHolder;
			return (EModelElement)adaptable.getAdapter(EModelElement.class);
		}
		
		return null;
	}
			
	private String message(String message, SourceHyperLink link) {
		return message + " - " + link.toString(); //$NON-NLS-1$
	}
}
