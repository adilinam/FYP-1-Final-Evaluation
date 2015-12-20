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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;

/**
 * @author vrepeshko
 */
public class ProblemUpdater implements IQVTReconcilingListener {
	
	private IAnnotationModel fAnnotationModel;
	
	ProblemUpdater(IAnnotationModel annotationModel) {
		if(annotationModel == null) {
			throw new IllegalArgumentException();
		}
		fAnnotationModel = annotationModel;
	}
		
	public void reconciled(CompiledUnit unit, IProgressMonitor monitor) {
		if(unit == null) {
			return;
		}
		
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        if(monitor.isCanceled()) {
        	return;
        }

        reportProblems(unit, monitor);        

        // TODO - no need for this, the QVTEditor should not create me 
        // is not editing a qvt file in a source container!!!
//        if (options.isReportErrors() && options.isShowAnnotations()) {
//        	reportProblems(unit, editor.getAnnotationModel());
//        }        
	}
	
	public void aboutToBeReconciled() {
		// do nothing
	}
	
	private void reportProblems(CompiledUnit unit, IProgressMonitor monitor) {		
		List<Annotation> annotationsToRemove = new ArrayList<Annotation>();
		for (Iterator<?> iter = fAnnotationModel.getAnnotationIterator(); iter.hasNext();) {
			Annotation annotation = (Annotation) iter.next();
			String annotationType = annotation.getType();
			
			if (IQvtAnnotationTypes.ERROR.equals(annotationType) || 
				IQvtAnnotationTypes.WARNING.equals(annotationType)) {
				annotationsToRemove.add(annotation);
			}
		}
		
		if(monitor.isCanceled()) {
			return;
		}
		
		Map<Annotation, Position> annotationsToAdd = new HashMap<Annotation, Position>();
		for (QvtMessage problem : unit.getProblems()) {
			if (checkProblem(problem)) {
				annotationsToAdd.put(createProblemAnnotation(problem), createProblemPosition(problem));
			}
		}
		
		if(monitor.isCanceled()) {
			return;
		}
		
		if (fAnnotationModel instanceof IAnnotationModelExtension) {
			IAnnotationModelExtension modelExtension = ((IAnnotationModelExtension) fAnnotationModel);
			modelExtension.replaceAnnotations(annotationsToRemove.toArray(new Annotation[annotationsToRemove.size()]), annotationsToAdd);
		} else {
			for (Annotation annotation : annotationsToRemove) {
				fAnnotationModel.removeAnnotation(annotation);
			}
			for (Map.Entry<Annotation, Position> entry : annotationsToAdd.entrySet()) {
				fAnnotationModel.addAnnotation(entry.getKey(), entry.getValue());
			}
		}
	}

	private static boolean checkProblem(QvtMessage problem) {
		return problem != null && problem.getOffset() >= 0 && problem.getLength() >= 0;
	}
	
	private Annotation createProblemAnnotation(QvtMessage problem) {
		return new Annotation(getAnnotationType(problem.getSeverity()), true, problem.getMessage());
	}
	
	private String getAnnotationType(int severity) {
		switch (severity) {
		case IMarker.SEVERITY_ERROR:
			return IQvtAnnotationTypes.ERROR;
		case IMarker.SEVERITY_WARNING:
			return IQvtAnnotationTypes.WARNING;
		}
		throw new IllegalArgumentException();
	}
	
	private Position createProblemPosition(QvtMessage problem) {
		return new Position(problem.getOffset(), problem.getLength());
	}	
}
