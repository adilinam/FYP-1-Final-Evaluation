/**
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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;

/**
 * An AbstractImperativeOCLAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractImperativeOCLAS2XMIidVisitor
	extends AS2XMIidVisitor
	implements ImperativeOCLVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractImperativeOCLAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	public @Nullable Boolean visitAltExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitAssertExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitAssignExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitBlockExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitBreakExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitCatchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitComputeExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitContinueExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitDictLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Boolean visitDictLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitDictionaryType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		return visitCollectionType(object);
	}

	public @Nullable Boolean visitForExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Boolean visitImperativeExpression(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		return visitOCLExpression(object);
	}

	public @Nullable Boolean visitImperativeIterateExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable Boolean visitImperativeLoopExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		return visitLoopExp(object);
	}

	public @Nullable Boolean visitInstantiationExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitListLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Boolean visitListType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		return visitCollectionType(object);
	}

	public @Nullable Boolean visitLogExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable Boolean visitOrderedTupleLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable Boolean visitOrderedTupleLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitOrderedTupleType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		return visitClass(object);
	}

	public @Nullable Boolean visitRaiseExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitReturnExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitSwitchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitTryExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitTypedef(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		return visitClass(object);
	}

	public @Nullable Boolean visitUnlinkExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitUnpackExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitVariableInitExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable Boolean visitWhileExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		return visitImperativeExpression(object);
	}
}
