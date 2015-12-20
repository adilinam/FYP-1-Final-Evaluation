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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtDocumentProvider;
import org.eclipse.ocl.cst.CSTNode;


public class QvtTextHover implements ITextHover, ITextHoverExtension2 {
	
    private final QvtDocumentProvider myDocumentProvider;
    private final IElementInfoProvider[] myElementInfoProviders;	
	
    public QvtTextHover(final QvtDocumentProvider documentProvider) {
        myDocumentProvider = documentProvider;
        myElementInfoProviders = new IElementInfoProvider[] {
        		new OperationCallInfoProvider(),
        		new PropertyCallInfoProvider(),
        		new VariableExpressionInfoProvider(),
        		new PatternPropertyExpressionInfoProvider(),
        		new PathNameInfoProvider(),
        		new ModuleImportInfoProvider(),
        		new ResolveInMappingInfoProvider(),
        		new ModelTypeInfoProvider()
        };
    }

    public IRegion getHoverRegion(final ITextViewer textViewer, final int offset) {
        return new Region(offset, 0);
    }
        
    public Object getHoverInfo2(final ITextViewer textViewer, final IRegion hoverRegion) {
    	return getHoverInfo(textViewer, hoverRegion);
    }
    
    public String getHoverInfo(final ITextViewer textViewer, final IRegion hoverRegion) {
        if (checkCompiledUnit(myDocumentProvider.getCompiledModule()) && 
        	textViewer != null && textViewer.getDocument() != null) {
	        
	        Annotation annotation = getAnnotation(textViewer, hoverRegion.getOffset());
        	if (annotation != null) {
        		return annotation.getText();
        	}
        	
        	CSTNode rootCS = myDocumentProvider.getCompiledModule().getUnitCST();
        	List<CSTNode> elements = CSTHelper.selectTargetedElements(rootCS, hoverRegion);
        	if(!elements.isEmpty()) {
        		try {
        			return getElementsInfo(elements, textViewer, hoverRegion);
				} catch (Exception e) {
					Activator.log(e);
				}
        	}
        }
       
        return ""; //$NON-NLS-1$
    }
    
    public Annotation getAnnotation(final ITextViewer textViewer, final int offset) {
    	if (textViewer instanceof ISourceViewer) {
 			final IAnnotationModel annotationModel = ((ISourceViewer) textViewer).getAnnotationModel();
 			if (annotationModel == null) {
 				return null;
 			}
 			ArrayList<Annotation> annotations = new ArrayList<Annotation>();
 			for (Iterator<?> iter = annotationModel.getAnnotationIterator(); iter.hasNext();) {
 				Annotation annotation = (Annotation)iter.next();
 				if (annotation.isPersistent() && !annotation.isMarkedDeleted()) {
	 				Position position = annotationModel.getPosition(annotation);
	 				if (position != null && position.includes(offset)) {
	 					annotations.add(annotation);
	 				}
 				}
 			}
 			if (!annotations.isEmpty()) { 
	 			Collections.sort(annotations, new Comparator<Annotation>() {
					public int compare(final Annotation o1, final Annotation o2) {
						Position p1 = annotationModel.getPosition(o1);
						Position p2 = annotationModel.getPosition(o2);
						return p1.getLength() - p2.getLength();
					}
	 			});
	 			return (Annotation) annotations.get(0);
 			}
 		}
    	return null;
    }

    
    private String getElementsInfo(final List<CSTNode> elements, ITextViewer textViewer, IRegion hoverRegion) {
    	for (CSTNode nextElement : elements) {
        	for (int i = 0; i < myElementInfoProviders.length; i++) {
    			IElementInfoProvider provider = myElementInfoProviders[i];
    			try {
    				String info = provider.getElementInfo(nextElement, textViewer, hoverRegion);
    				if (info != null && info.length() > 0) {
    					return info;
    				}
    			} catch (NullPointerException e) {
    				// ignore
    			}
    		}    		
		}
    	return ""; //$NON-NLS-1$
    }
    
    private boolean checkCompiledUnit(final CompiledUnit unit) {
        return unit != null && unit.getUnitCST() != null;
    }    
}
