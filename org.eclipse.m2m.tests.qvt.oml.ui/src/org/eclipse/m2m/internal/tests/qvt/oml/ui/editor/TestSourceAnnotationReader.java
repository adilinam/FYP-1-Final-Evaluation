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

import junit.framework.TestCase;

import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.RegionInfo;

public class TestSourceAnnotationReader extends TestCase {

	public TestSourceAnnotationReader(String name) {
		super(name);
	}
	
	public void testAnnotations() throws Exception {
		String source = "Aa/*<pos id='idval'/>*/Bb Cc/*<w code='5' refid='idval'>*/{contents}/*</w>*/Dd"; //$NON-NLS-1$
		SourceAnnotationReader reader = new SourceAnnotationReader(source);
		List<AnnotationData> annotations = reader.getAnnotations();
		
		assertEquals(2, annotations.size());

		AnnotationData a1 = annotations.get(0);
		assertEquals("pos", a1.getName()); //$NON-NLS-1$
		assertEquals("idval", a1.getAttrValue("id")); //$NON-NLS-1$ //$NON-NLS-2$

		assertEquals(reader.getSource().indexOf("Bb"), a1.getAnnotatedRegion().getOffset());
		assertEquals(a1.getAnnotatedRegion().getLength(), 0);		
		
		AnnotationData a2 = annotations.get(1);	
		assertEquals("w", a2.getName()); //$NON-NLS-1$
		assertEquals("5", a2.getAttrValue("code")); //$NON-NLS-1$ //$NON-NLS-2$
		assertEquals("idval", a2.getAttrValue("refid")); //$NON-NLS-1$ //$NON-NLS-2$		
		assertEquals("{contents}", getRegionContents(reader.getSource(), a2.getAnnotatedRegion())); //$NON-NLS-1$
		assertEquals("{contents}".length(), a2.getAnnotatedRegion().getLength()); //$NON-NLS-1$		
		assertEquals('{', reader.getSource().charAt(a2.getAnnotatedRegion().getOffset()));		
	}
	
	private static String getRegionContents(String source, RegionInfo region) {
		return source.substring(region.getOffset(), region.getOffset() + region.getLength());
	}
}
