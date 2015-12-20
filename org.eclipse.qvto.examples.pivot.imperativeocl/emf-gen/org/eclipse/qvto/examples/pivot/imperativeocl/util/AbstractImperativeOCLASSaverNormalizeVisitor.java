/*******************************************************************************
 * <copyright>
 * Copyright (c) 2013 Willink Transformations, University of York, and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *   Adolfo Sanchez-Barbudo (University of York) - Bug397429
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.pivot.imperativeocl/model/ImperativeOCL.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.pivot.imperativeocl.util;

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.utilities.ASSaverNormalizeVisitor;

/**
 * An AbstractImperativeOCLASSaverNormalizeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractImperativeOCLASSaverNormalizeVisitor
	extends ASSaverNormalizeVisitor
	implements ImperativeOCLVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractImperativeOCLASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	public @Nullable Object visitAltExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitAssertExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitAssignExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitBlockExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitBreakExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitCatchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitComputeExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitContinueExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitDictLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitDictLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Object visitDictionaryType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		return visitCollectionType(object);
	}

	public @Nullable Object visitForExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Object visitImperativeExpression(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		return visitOCLExpression(object);
	}

	public @Nullable Object visitImperativeIterateExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Object visitImperativeLoopExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		return visitLoopExp(object);
	}

	public @Nullable Object visitInstantiationExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitListLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitListType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		return visitCollectionType(object);
	}

	public @Nullable Object visitLogExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable Object visitOrderedTupleLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Object visitOrderedTupleLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Object visitOrderedTupleType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		return visitClass(object);
	}

	public @Nullable Object visitRaiseExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitReturnExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitSwitchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitTryExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitTypedef(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		return visitClass(object);
	}

	public @Nullable Object visitUnlinkExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitUnpackExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitVariableInitExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Object visitWhileExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		return visitImperativeExpression(object);
	}
}
