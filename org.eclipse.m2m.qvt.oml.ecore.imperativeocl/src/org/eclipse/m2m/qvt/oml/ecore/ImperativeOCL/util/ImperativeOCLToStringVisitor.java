/**
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 * 
 * $Id: ImperativeOCLToStringVisitor.java,v 1.3 2009/05/15 16:14:34 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AltExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssertExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BreakExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.CatchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ContinueExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.DictLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeExpression;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.LogExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.OrderedTupleLiteralPart;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.RaiseExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ReturnExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.SwitchExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.TryExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnlinkExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.UnpackExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.WhileExp;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * Implementation of {@link ImperativeOCLVisitor} to have the String representation of a {@link ImperativeExpression ImperativeOCL expression} 
 *  
 * @author Adolfo Sánchez-Barbudo Herrera (adolfosbh)
 *
 */
public class ImperativeOCLToStringVisitor extends  ToStringVisitor<EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>
				implements ImperativeOCLVisitor<String>{
	
	private static final String NOT_IMPLEMENTED = "<not-implemented-in-string-visitor>"; //$NON-NLS-1$
	
	
	public static ImperativeOCLToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = Environment.Registry.INSTANCE.getEnvironmentFor(element);
		return new ImperativeOCLToStringVisitor(env);
	}
	protected ImperativeOCLToStringVisitor(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);		
	}
	public String visitAltExp(AltExp astNode) {		
		return NOT_IMPLEMENTED;
	}
	public String visitAssertExp(AssertExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitAssignExp(AssignExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitBlockExp(BlockExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitBreakExp(BreakExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitCatchtExp(CatchExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitComputeExp(ComputeExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitContinueExp(ContinueExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitDictLiteralExp(DictLiteralExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitDictLiteralPart(DictLiteralPart astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitForExp(ForExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitImperativeIterateExp(DictLiteralExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitInstantiationExp(InstantiationExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitLogExp(LogExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitRaiseExp(RaiseExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitReturnExp(ReturnExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitSwitchExp(SwitchExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitTryExp(LogExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitUnlinkExp(UnlinkExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitUnpackExp(LogExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitVariableInitExp(LogExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitImperativeIterateExp(ImperativeIterateExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitTryExp(TryExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitUnpackExp(UnpackExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitVariableInitExp(VariableInitExp astNode) {
		return NOT_IMPLEMENTED;
	}
	public String visitWhileExp(WhileExp astNode) {
		return NOT_IMPLEMENTED;
	}
}
