/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.ocl.types.OCLStandardLibrary;

public interface VMFrameExecutionContext {
	
	EClassifier getOCLType(EStructuralFeature feature);
	
	List<EStructuralFeature> getAllFeatures(EClass eClass);
	/**
	 * TODO - 
	 * Note: with derived properties may execute QVTO engine, throw QVTRuntimeException!!!
	 * Should be evaluated at separate thread and QVTO Evaluator, to be interruptible
	 */
	Object getValue(EStructuralFeature feature, EObject target);
	
	QvtOperationalEvaluationEnv getEvalEnv();
	
	OCLStandardLibrary<EClassifier> getStandardLibrary();
}