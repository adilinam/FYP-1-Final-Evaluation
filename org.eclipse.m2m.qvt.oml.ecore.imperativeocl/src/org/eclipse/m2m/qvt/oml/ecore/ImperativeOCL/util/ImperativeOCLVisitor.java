/**
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera  - initial API and implementation
 * s
 * $Id: ImperativeOCLVisitor.java,v 1.1 2009/01/25 23:10:43 radvorak Exp $
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
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.Visitor;

/**
 * An {@link Visitor OCL Visitor} extension, to visit {@link ImperativeExpression ImperativeOCL expressions}.
 * 
 * @author Adolfo Sanchez-Barbudo Herrera (adolfosbh)
 *
 */
public interface ImperativeOCLVisitor<T> extends Visitor<T, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {

	T visitAltExp(AltExp astNode);
	T visitAssertExp(AssertExp astNode);
	T visitAssignExp(AssignExp astNode);
	T visitBlockExp(BlockExp astNode);
	T visitBreakExp(BreakExp astNode);
	T visitCatchtExp(CatchExp astNode);
	T visitComputeExp(ComputeExp astNode);
	T visitContinueExp(ContinueExp astNode);
	T visitDictLiteralExp(DictLiteralExp astNode);
	T visitDictLiteralPart(DictLiteralPart astNode);
	T visitForExp(ForExp astNode);
	T visitImperativeIterateExp(ImperativeIterateExp astNode);
	T visitInstantiationExp(InstantiationExp astNode);
	T visitLogExp(LogExp astNode);
	T visitOrderedTupleLiteralExp(OrderedTupleLiteralExp astNode);
	T visitOrderedTupleLiteralPart(OrderedTupleLiteralPart astNode);
	T visitRaiseExp(RaiseExp astNode);
	T visitReturnExp(ReturnExp astNode);
	T visitSwitchExp(SwitchExp astNode);
	T visitTryExp(TryExp astNode);
	T visitUnlinkExp(UnlinkExp astNode);
	T visitUnpackExp(UnpackExp astNode);
	T visitVariableInitExp(VariableInitExp astNode);
	T visitWhileExp(WhileExp astNode);
	
	
	//T visitImperativeExpression(ImperativeExpression astNode);
	//T visitImperativeLoopExp(ImperativeLoopExp astNode);	

	
}
