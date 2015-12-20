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

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.core.runtime.Assert;
import org.eclipse.m2m.internal.qvt.oml.common.util.StringLineNumberProvider;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SourceAnnotationReader {

	private String fSource;	
	private List<CommentTag> fcommentTags;
	private List<AnnotationData> fAnnotations;
	private SAXParser fParser;
	private StringLineNumberProvider fLineNumberProvider;	
	
	public SourceAnnotationReader(String sourceCode) {
		this(sourceCode, true);
	}
	
	public SourceAnnotationReader(String sourceCode, boolean trimAnnotationFromSource) {
		fSource = sourceCode;
		fcommentTags = new ArrayList<CommentTag>();
		fAnnotations = new ArrayList<AnnotationData>();
		try {
			fParser = SAXParserFactory.newInstance().newSAXParser();
		} catch (Exception e) {
			throw new RuntimeException("Failed to create parser"); //$NON-NLS-1$
		} 
		
		parse();
		if(trimAnnotationFromSource){
			makeSourceAdjustments();
		}
		
		fLineNumberProvider = new StringLineNumberProvider(fSource);
	}
	
	public String getSource() {
		return fSource;
	}
		
	public List<AnnotationData> getAnnotations() {
		return Collections.unmodifiableList(fAnnotations);
	}
	
	private void makeSourceAdjustments() {
		StringBuilder buf = new StringBuilder(fSource);		
		int shiftOffset = 0;
		
		for (AnnotationData annotation : fAnnotations) {						
			RegionInfo reg = annotation.getAnnotatedRegion();
			
			CommentTag open = reg.openTag;
			CommentTag close = reg.closeTag;
			
			shiftOffset = trimTag(buf, open, shiftOffset);			
			if(open != close) {
				annotation.fRegion.fStartOffset -= (shiftOffset);
				annotation.fRegion.fEndOffset -= (shiftOffset);
				
				shiftOffset = trimTag(buf, close, shiftOffset);			
			} else {
				if(annotation.fRegion.fStartOffset > 0) {
					annotation.fRegion.fStartOffset -= (shiftOffset);
					annotation.fRegion.fEndOffset -= (shiftOffset);
				}
			}
		}
		fSource = buf.toString();
	}
			
	private void parse() {
		int length = fSource.length();
		int leftOffset = -1;
		int rightOffset = -1;
		
		for(int i = 0; i < length; i++) { 
			char c = fSource.charAt(i); 
			if(c == '/' && i + 1 < length && fSource.charAt(i + 1) == '*') {
				leftOffset = i;
				
			} else if(c == '*' && i + 1 < length && fSource.charAt(i + 1) == '/') {
				rightOffset = i;
			}
			
			if(leftOffset >= 0 && rightOffset >= 0) {				
				String text = fSource.substring(leftOffset + 2, rightOffset);
				fcommentTags.add(new CommentTag(leftOffset, rightOffset + 2, text));
				leftOffset = -1;
				rightOffset = -1;				
			}
		}
		
		processCommentTags();
	}
	
	private void processCommentTags() {
		List<RegionInfo> result = new ArrayList<RegionInfo>();		
		CommentTag leftTag = null;
		CommentTag rightTag = null;		
		
		for (CommentTag tag : fcommentTags) {
			if(leftTag == null) {
				if(tag.fIsSimpleTag) {
					int endPos = tag.fEndOffset;
					if(tag.fEndOffset == fSource.length() - 1) {
						endPos = tag.fStartOffset - 1;
					} else if(tag.fStartOffset == 0) {
						endPos = 0;
					}
					RegionInfo reg = new RegionInfo(endPos, endPos, tag.fTextPart);
					handleRegion(reg, tag, tag);
				} else {
					leftTag = tag;
				}
				continue;
			}
			
			if(rightTag == null) {
				rightTag = tag;
			}
			
			RegionInfo reg = new RegionInfo(leftTag.fEndOffset, rightTag.fStartOffset, leftTag.fTextPart + rightTag.fTextPart);					
			result.add(reg);
			handleRegion(reg, leftTag, rightTag);

			leftTag = rightTag = null;
		}
	}
	
	private void handleRegion(RegionInfo regionInfo, CommentTag openTag, CommentTag closeTag) {
		try {
			regionInfo.openTag = openTag;
			regionInfo.closeTag = closeTag;
			parseXMLContents(regionInfo);
		} catch (Exception e) {
			throw new RuntimeException("Error in source test annotation tag at:" + openTag + closeTag, e); //$NON-NLS-1$
		}
	}
	
	private void parseXMLContents(final RegionInfo regionInfo) throws Exception {
		class XMLHandler extends DefaultHandler {
		    @Override
			public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
		    	AnnotationData data = new AnnotationData(qName, regionInfo);
		    	for(int i = 0; i < attributes.getLength(); i++) {
		    		data.addAttr(attributes.getQName(i), attributes.getValue(i));
		    	}
		    	SourceAnnotationReader.this.fAnnotations.add(data);
		    }
		};
		
		XMLHandler handler = new XMLHandler();		
		String xmlBody = regionInfo.fMetaBody;
		fParser.parse(new InputSource(new StringReader(xmlBody)), handler);		
	}
	
	public class AnnotationData {
		private Map<String, String> fAttrs = Collections.emptyMap();
		private RegionInfo fRegion;
		private String fName;
		private int fLineNum;
		
		private AnnotationData(String name, RegionInfo region) {
			fRegion = region;
			fName = name;
			fLineNum = -1;
		}		
		
		private void addAttr(String name, String value) {
			if(fAttrs.isEmpty()) {
				fAttrs = new HashMap<String, String>(3);
			}			
			fAttrs.put(name, value);
		}
		
		public String getName() {
			return fName;
		}
		
		public String getAttrValue(String name) {
			return fAttrs.get(name);
		}
		
		public RegionInfo getAnnotatedRegion() {
			return fRegion;
		}		
		
		public int getLineNumber() {
			if(fLineNum < 0) {
				fLineNum = SourceAnnotationReader.this.fLineNumberProvider.getLineNumber(fRegion.getOffset());				
			}
				
			return fLineNum;
		}
		
		@Override
		public String toString() {
			return fName + " - " + fRegion + "(line:" + getLineNumber() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
		}
	}
	
	
	public static class RegionInfo {
		private int fStartOffset;
		private int fEndOffset;
		private final String fMetaBody;
		private CommentTag openTag;
		private CommentTag closeTag;		
		
		private RegionInfo(int startOffset, int endOffset, String metaDataContents) {
			fStartOffset = startOffset;
			fEndOffset = endOffset;
			fMetaBody = metaDataContents;
		}
		
		public CommentTag getOpenTag() {
			return openTag;
		}
		
		public CommentTag getCloseTag() {
			return closeTag;
		}
		
		public int getOffset() {
			return fStartOffset;
		}
		
		public int getLength() {
			return fEndOffset - fStartOffset;
		}
		
		@Override
		public String toString() {
			return fMetaBody + " (" + fEndOffset + ", " + fStartOffset + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
	
	/**
	 * @return new shift offset
	 */
	private static int trimTag(StringBuilder buf, CommentTag tag, int shiftOffset) {		
		int startOffset = tag.fStartOffset - shiftOffset;
		int endOffset = tag.fEndOffset - shiftOffset;
		buf.replace(startOffset, endOffset, ""); //$NON-NLS-1$

		return shiftOffset + tag.length() - 1;
	}	
	
	public static class CommentTag {		
		final int fStartOffset;
		final int fEndOffset;
		final String fTextPart;
		final boolean fIsSimpleTag;
		
		CommentTag(int offset, int endOffset, String text) {
			fStartOffset = offset;
			fEndOffset = endOffset;			
			fIsSimpleTag = text != null && (text.trim().endsWith("/>")); //$NON-NLS-1$
			fTextPart = text;			
		}
		
		public int length() {
			return fEndOffset - fStartOffset + 1;
		}
		
		public int offset() {
			return fEndOffset;
		}
		
		@Override
		public String toString() {		
			return fTextPart;
		}
	}

	public static class Position {

		/** The offset of the position */
		private int offset;
		/** The length of the position */
		private int length;

		/**
		 * Creates a new position with the given offset and length.
		 *
		 * @param offset the position offset, must be >= 0
		 * @param length the position length, must be >= 0
		 */
		public Position(int offset, int length) {
			Assert.isTrue(offset >= 0);
			Assert.isTrue(length >= 0);
			this.offset = offset;
			this.length = length;
		}

		@Override
		public int hashCode() {
		 	return (offset << 24) | (length << 16);
		 }

		@Override
		public boolean equals(Object other) {
			if (other instanceof Position) {
				Position rp= (Position) other;
				return (rp.offset == offset) && (rp.length == length);
			}
			return super.equals(other);
		}

		@Override
		public String toString() {
			String position= "offset: " + offset + ", length: " + length; //$NON-NLS-1$//$NON-NLS-2$
			return position;
		}
	}

}
