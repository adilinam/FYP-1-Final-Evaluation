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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IRegion;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.AnnotationData;
import org.eclipse.m2m.tests.qvt.oml.util.SourceAnnotationReader.RegionInfo;

class HyperLinkHelper {

	static class SourceHyperLink {
		final AnnotationData link;
		final IRegion targeRegion;
		final String targetModule;
		final URI targetElemenUri;
		
		SourceHyperLink(AnnotationData link, final RegionInfo target) {
			this.link = link;
			this.targeRegion = new IRegion() {

				public int getLength() {
					return target.getLength();
				}

				public int getOffset() {
					return target.getOffset();
				}
				
			};
			this.targetModule = null;
			this.targetElemenUri = null;
			
		}

		SourceHyperLink(AnnotationData link, IRegion target) {
			this.link = link;
			this.targeRegion = target;
			this.targetModule = null;
			this.targetElemenUri = null;
			
		}

		SourceHyperLink(AnnotationData link, URI targetElemenUri) {
			this.link = link;
			this.targetElemenUri = targetElemenUri;
			this.targetModule = null;
			this.targeRegion = null;
		}
		
		SourceHyperLink(AnnotationData link, String sourceModule) {
			this.link = link;
			this.targetModule = sourceModule;
			this.targetElemenUri = null;
			this.targeRegion = null;
		}
		
		@Override
		public String toString() {
			return link.toString();
		}
	}
	
	public static final String HYPERLINK_TAG = "link"; //$NON-NLS-1$
	public static final String HYPERLINK_REF_ATTR = "ref";	//$NON-NLS-1$
	public static final String HYPERLINK_MODULE_ATTR = "module"; //$NON-NLS-1$	
	public static final String HYPERLINK_ELEMENT_URI_ATTR = "elementUri"; //$NON-NLS-1$		
	public static final String REGION_TAG = "region"; //$NON-NLS-1$
	public static final String REGION_ID_ATTR = "id"; //$NON-NLS-1$

	
	private List<SourceHyperLink> fHLinks = new ArrayList<SourceHyperLink>();
	private Map<String, AnnotationData> fTargetRegions = new HashMap<String, AnnotationData>();
	
	
	HyperLinkHelper(List<AnnotationData> annotations) {
		fTargetRegions = new HashMap<String, AnnotationData>();
		List<AnnotationData> links = new ArrayList<AnnotationData>();
		
		for (AnnotationData a : annotations) {
			if(HYPERLINK_TAG.equals(a.getName())) {
				links.add(a);
			} 
			else if(REGION_TAG.equals(a.getName())) {
				String id = a.getAttrValue(REGION_ID_ATTR);
				if(id != null) {
					if(fTargetRegions.put(id, a) != null) {
						throw new RuntimeException("Region already defined. " + a); //$NON-NLS-1$
					}
				}
			} 
			else {
				throw new RuntimeException("Uknown test source annotation type"); //$NON-NLS-1$
			}
		}
		
		for (AnnotationData nextLink : links) {
			String refId = nextLink.getAttrValue(HYPERLINK_REF_ATTR);
			if(refId != null) {
				AnnotationData targetReg = fTargetRegions.get(refId);
				if(targetReg == null && nextLink.getAttrValue(HYPERLINK_MODULE_ATTR) == null) {
					throw new RuntimeException("No target region for link annotation found:" + nextLink); //$NON-NLS-1$
				}

				if(nextLink.getAttrValue(HYPERLINK_MODULE_ATTR) != null) {				
					fHLinks.add(new SourceHyperLink(nextLink, nextLink.getAttrValue(HYPERLINK_MODULE_ATTR)));
				} else {
					fHLinks.add(new SourceHyperLink(nextLink, targetReg.getAnnotatedRegion()));
				}
			} 
			else if(nextLink.getAttrValue(HYPERLINK_ELEMENT_URI_ATTR) != null) {
				URI uri = URI.createURI(nextLink.getAttrValue(HYPERLINK_ELEMENT_URI_ATTR));
				fHLinks.add(new SourceHyperLink(nextLink, uri));
			}
			else {
				throw new RuntimeException("Hyperlink annotation must specify 'ref' or 'elementUri' attribute"); //$NON-NLS-1$
			}			
		}
	}
	
	public List<SourceHyperLink> getHyperLinks() {
		return fHLinks;
	}	
	
	public AnnotationData getTargetRegion(String id) {
		return fTargetRegions.get(id);
	}
}
