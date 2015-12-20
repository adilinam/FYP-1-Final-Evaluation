/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.ocl.cst.CSTNode;

class FoldingStructureUpdater implements IQVTReconcilingListener {
	
    private Annotation[] myAnnotations = new Annotation[0];
    
    private ProjectionViewer myViewer;
	
	
	public FoldingStructureUpdater(ProjectionViewer viewer) {
		if(viewer == null) {
			throw new IllegalArgumentException();
		}
		
		myViewer = viewer;
	}
	
	public void aboutToBeReconciled() {	
		// do nothing
	}
	
	public void reconciled(CompiledUnit unit, IProgressMonitor monitor) {
		if(monitor.isCanceled()) {
			return;
		}
		
		List<Position> newFoldingPositions = Collections.emptyList();
		if(unit != null) {
			newFoldingPositions = getNewFoldingPositions(unit);
		}

		if(monitor.isCanceled()) {
			return;
		}
		
		updateFoldingStructure(newFoldingPositions, monitor);
	}
	
	private List<Position> getNewFoldingPositions(CompiledUnit compilationResult) {
		ArrayList<Position> positions = new ArrayList<Position>();
		UnitCS unitCST = compilationResult.getUnitCST();
		addListPosition(unitCST.getImports(), positions);		
		addListPosition(unitCST.getModelTypes(), positions);
		
		for(MappingModuleCS mappingModuleCS : unitCST.getModules()) {			
//	commented out elements with mixed ordering
// WBN : to calculate groups of elements of the same kind    
//		    addListPosition(mappingModuleCS.getImports(), positions);
//		    addListPosition(mappingModuleCS.getMetamodels(), positions);
//		    addListPosition(mappingModuleCS.getProperties(), positions);
//		    addListPosition(mappingModuleCS.getRenamings(), positions);
		    
		    for(ClassifierDefCS classifierDefCS : mappingModuleCS.getClassifierDefCS()) {
		    	positions.add(createPosition(classifierDefCS.getStartOffset(), classifierDefCS.getEndOffset()));
		    }
		
		    for (MappingMethodCS method : mappingModuleCS.getMethods()) {
		        positions.add(createPosition(method.getStartOffset(), method.getEndOffset()));
		    }
		}
		
		return positions;
	}
	
    public void updateFoldingStructure(List<Position> positions, IProgressMonitor monitor) {
    	if (myViewer == null || myViewer.getProjectionAnnotationModel() == null) {
    		return;
    	}
    	
        ProjectionAnnotationModel model = myViewer.getProjectionAnnotationModel();
    	        
        Map<Annotation, Position> newAnnotationMap = new LinkedHashMap<Annotation, Position>();
        for (Position position : positions) {
    		if(monitor.isCanceled()) {
    			return;
    		}
        	
    		Annotation annotation = new ProjectionAnnotation();    		
    		newAnnotationMap.put(annotation, position);
        }
        
		synchronized (getLockObject(model)) {
			model.replaceAnnotations(myAnnotations, newAnnotationMap);
		}
		
        myAnnotations = newAnnotationMap.keySet().toArray(new Annotation[newAnnotationMap.size()]);
    }
        
    private void addListPosition(final List<? extends CSTNode> list, final List<Position> positionList) {
        if (!list.isEmpty()) {
            int start = getStart(list);
            int end = getEnd(list);
            if (start >= 0 && end >= start) {
                positionList.add(createPosition(start, end));
            }
        }
    }
    
    private int getStart(final List<? extends CSTNode> list) {
        int start = Integer.MAX_VALUE;
        for (CSTNode element : list) {
            if (element != null) {
                start = Math.min(start, element.getStartOffset());
            }
        }
        return start;
    }
    
    private int getEnd(final List<? extends CSTNode> list) {
        int end = -1;
        for (CSTNode element : list) {
            if (element != null) {
                end = Math.max(end, element.getEndOffset());
            }
        }
        return end;
    }
    
    private QvtPosition createPosition(int start, int end) {
    	IRegion region = new Region(start, end - start);
		IRegion normalized = alignRegion(region);
		if (normalized != null) {
			region = normalized;
		}
    	return new QvtPosition(region.getOffset(), region.getLength());
    }
    
	/**
	 * Aligns <code>region</code> to start and end at a line offset. The
	 * region's start is decreased to the next line offset, and the end offset
	 * increased to the next line start or the end of the document.
	 * <code>null</code> is returned if <code>region</code> is
	 * <code>null</code> itself or does not comprise at least one line
	 * delimiter, as a single line cannot be folded.
	 * 
	 * @param region
	 *            the region to align, may be <code>null</code>
	 * @return a region equal or greater than <code>region</code> that is
	 *         aligned with line offsets, <code>null</code> if the region is
	 *         too small to be foldable (e.g. covers only one line)
	 */
	private final IRegion alignRegion(IRegion region) {
		if (region == null) {
			return null;
		}
		
		IDocument document = getDocument();
		try {
			int start = document.getLineOfOffset(region.getOffset());
			int end = document.getLineOfOffset(region.getOffset() + region.getLength());
			if (start >= end) {
				return null;
			}

			int offset = document.getLineOffset(start);
			int endOffset;
			if (document.getNumberOfLines() > end + 1) {
				endOffset = document.getLineOffset(end + 1);
			} else {
				endOffset = document.getLineOffset(end) + document.getLineLength(end);
			}

			return new Region(offset, endOffset - offset);
		} catch (BadLocationException x) {
			// concurrent modification
			return null;
		}
	}
		
	private Object getLockObject(IAnnotationModel annotationModel) {
		if (annotationModel instanceof ISynchronizable) {
			Object lock= ((ISynchronizable)annotationModel).getLockObject();
			if (lock != null)
				return lock;
		}
		return annotationModel;
	}
	
	private IDocument getDocument() {
		return myViewer.getDocument();
	}
}