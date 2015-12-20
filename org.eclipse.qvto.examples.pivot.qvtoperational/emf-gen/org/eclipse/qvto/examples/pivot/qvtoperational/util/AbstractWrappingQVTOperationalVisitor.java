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
 * from: org.eclipse.qvto.examples.pivot.qvtoperational/model/QVTOperational.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.pivot.qvtoperational.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTOperationalVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTOperationalVisitor<R, C, D extends QVTOperationalVisitor<R>, P>
	extends org.eclipse.qvto.examples.pivot.imperativeocl.util.AbstractWrappingImperativeOCLVisitor<R, C, D, P>
	implements QVTOperationalVisitor<R>
{
	protected AbstractWrappingQVTOperationalVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	public @Nullable R visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitConstructor(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitConstructorBody(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitContextualProperty(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDummyRelation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDummyRelationDomain(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitDummyRelationalTransformation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitEntryOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitHelper(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitImperativeOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitLibrary(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingBody(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingCallExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingOperation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitModelParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitModelType(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitModule(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitModuleImport(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitObjectExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationBody(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationalTransformation(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitResolveExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitResolveInExp(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitTag(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	public @Nullable R visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		P prologue = preVisit(object);
		try {
			R result = delegate.visitVarParameter(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
