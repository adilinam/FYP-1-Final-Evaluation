/**
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 * 
 * $Id: QVTOperationalToStringVisitor.java,v 1.1 2009/01/25 23:12:23 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLToStringVisitor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ObjectExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;

/**
 * Implementation of {@link QVTOperationalVisitor} to have the String representation of the {@link ImperativeExpression QVTOperational expressions}
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 *
 */
public class QVTOperationalToStringVisitor extends ImperativeOCLToStringVisitor
		implements QVTOperationalVisitor<String> {
	
	protected QVTOperationalToStringVisitor(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);
	}

	public static QVTOperationalToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = ClassUtils.asClassUnchecked(Environment.Registry.INSTANCE.getEnvironmentFor(element));
		return new QVTOperationalToStringVisitor(env);
	}
	
	public String visitResolveExp(ResolveExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
	
	public String visitImperativeCallExp(ImperativeCallExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}

	public String visitMappingCallExp(MappingCallExp astNode) {		
		return "<not-implemented-in-string-visitor>";
	}

	public String visitObjectExp(ObjectExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}

	public String visitResolveInExp(ResolveExp astNode) {
		return "<not-implemented-in-string-visitor>";
	}
}
