/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D. Willink and others.
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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor;

public class ImperativeOCLToStringVisitor extends ToStringVisitor implements ImperativeOCLVisitor<String>
{
	protected static class ImperativeOCLToStringFactory implements ToStringVisitor.Factory
	{
		protected ImperativeOCLToStringFactory() {
			ToStringVisitor.addFactory(this);
			ToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new ImperativeOCLToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			ImperativeOCLPackage eInstance = ImperativeOCLPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new ImperativeOCLToStringFactory();
	
	public ImperativeOCLToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	public @Nullable String visitAltExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitAssertExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitAssignExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitBlockExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitBreakExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitCatchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitComputeExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitContinueExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitDictLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable String visitDictLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable String visitDictionaryType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object) {
		return visitCollectionType(object);
	}

	public @Nullable String visitForExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable String visitImperativeExpression(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object) {
		return visitOCLExpression(object);
	}

	public @Nullable String visitImperativeIterateExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object) {
		return visitImperativeLoopExp(object);
	}

	public @Nullable String visitImperativeLoopExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object) {
		return visitLoopExp(object);
	}

	public @Nullable String visitInstantiationExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitListLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable String visitListType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListType object) {
		return visitCollectionType(object);
	}

	public @Nullable String visitLogExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable String visitOrderedTupleLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object) {
		return visitLiteralExp(object);
	}

	public @Nullable String visitOrderedTupleLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object) {
		return visitElement(object);
	}

	public @Nullable String visitOrderedTupleType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object) {
		return visitClass(object);
	}

	public @Nullable String visitRaiseExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitReturnExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitSwitchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitTryExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitTypedef(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object) {
		return visitClass(object);
	}

	public @Nullable String visitUnlinkExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitUnpackExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitVariableInitExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object) {
		return visitImperativeExpression(object);
	}

	public @Nullable String visitWhileExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object) {
		return visitImperativeExpression(object);
	}
}
