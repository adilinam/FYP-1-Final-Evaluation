/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.prettyprint.EssentialOCLPrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvto.examples.pivot.imperativeocl.AltExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType;
import org.eclipse.qvto.examples.pivot.imperativeocl.ForExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ListType;
import org.eclipse.qvto.examples.pivot.imperativeocl.LogExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart;
import org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType;
import org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.TryExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.Typedef;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

public class ImperativeOCLPrettyPrintVisitor extends EssentialOCLPrettyPrintVisitor implements ImperativeOCLVisitor<Object>
{	
	public ImperativeOCLPrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Nullable
	public Object visitAltExp(AltExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitAssertExp(AssertExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitAssignExp(AssignExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitBlockExp(BlockExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitBreakExp(BreakExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitCatchExp(CatchExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitComputeExp(ComputeExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitContinueExp(ContinueExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDictLiteralExp(DictLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDictLiteralPart(DictLiteralPart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDictionaryType(DictionaryType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitForExp(ForExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitImperativeExpression(ImperativeExpression object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitImperativeIterateExp(ImperativeIterateExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitImperativeLoopExp(ImperativeLoopExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitInstantiationExp(InstantiationExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitListLiteralExp(ListLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitListType(ListType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitLogExp(LogExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitOrderedTupleLiteralExp(OrderedTupleLiteralExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitOrderedTupleLiteralPart(OrderedTupleLiteralPart object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitOrderedTupleType(OrderedTupleType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitRaiseExp(RaiseExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitReturnExp(ReturnExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitSwitchExp(SwitchExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitTryExp(TryExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitTypedef(Typedef object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitUnlinkExp(UnlinkExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitUnpackExp(UnpackExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitVariableInitExp(VariableInitExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitWhileExp(WhileExp object) {
		// TODO Auto-generated method stub
		return null;
	}
}
