/**
 * Copyright (c) 2008 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera  - initial API and implementation
 * 
 * $Id: QVTOperationalVisitor.java,v 1.1 2009/01/25 23:12:24 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.QVTOperational.util;

import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLVisitor;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ImperativeCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.MappingCallExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ObjectExp;
import org.eclipse.m2m.qvt.oml.ecore.QVTOperational.ResolveExp;
import org.eclipse.ocl.utilities.Visitor;

/**
 * An {@link Visitor OCL Visitor} extension, to visit {@link ImperativeExpression QVTOperational expressions}.
 * @author Adolfo Sánchez-Barbudo Herrera (adolfosbh).
 *
 */
public interface QVTOperationalVisitor<T> extends		
		ImperativeOCLVisitor<T> {
		
	T visitResolveExp(ResolveExp astNode);
	T visitResolveInExp(ResolveExp astNode);
	T visitImperativeCallExp(ImperativeCallExp astNode);
	T visitMappingCallExp(MappingCallExp astNode);
	T visitObjectExp(ObjectExp astNode);
}
