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
 * from: org.eclipse.qvto.examples.pivot.qvtoperational/model/QVTOperational.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.pivot.qvtoperational.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractDelegatingQVTOperationalVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTOperationalVisitor<R, C, D extends QVTOperationalVisitor<R>>
	extends org.eclipse.qvto.examples.pivot.imperativeocl.util.AbstractDelegatingImperativeOCLVisitor<R, C, D>
	implements QVTOperationalVisitor<R>
{
	protected AbstractDelegatingQVTOperationalVisitor(@NonNull D delegate, @NonNull C context) {
		super(delegate, context);
	}

	@Override
	public @Nullable R visiting(@NonNull org.eclipse.ocl.pivot.util.Visitable visitable) {
		return delegate.visiting(visitable);
	}

	public @Nullable R visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		return delegate.visitConstructor(object);
	}

	public @Nullable R visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		return delegate.visitConstructorBody(object);
	}

	public @Nullable R visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		return delegate.visitContextualProperty(object);
	}

	public @Nullable R visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		return delegate.visitDummyRelation(object);
	}

	public @Nullable R visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		return delegate.visitDummyRelationDomain(object);
	}

	public @Nullable R visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		return delegate.visitDummyRelationalTransformation(object);
	}

	public @Nullable R visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		return delegate.visitEntryOperation(object);
	}

	public @Nullable R visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		return delegate.visitHelper(object);
	}

	public @Nullable R visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		return delegate.visitImperativeCallExp(object);
	}

	public @Nullable R visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		return delegate.visitImperativeOperation(object);
	}

	public @Nullable R visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		return delegate.visitLibrary(object);
	}

	public @Nullable R visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		return delegate.visitMappingBody(object);
	}

	public @Nullable R visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		return delegate.visitMappingCallExp(object);
	}

	public @Nullable R visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		return delegate.visitMappingOperation(object);
	}

	public @Nullable R visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		return delegate.visitMappingParameter(object);
	}

	public @Nullable R visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		return delegate.visitModelParameter(object);
	}

	public @Nullable R visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		return delegate.visitModelType(object);
	}

	public @Nullable R visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		return delegate.visitModule(object);
	}

	public @Nullable R visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		return delegate.visitModuleImport(object);
	}

	public @Nullable R visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		return delegate.visitObjectExp(object);
	}

	public @Nullable R visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		return delegate.visitOperationBody(object);
	}

	public @Nullable R visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		return delegate.visitOperationalTransformation(object);
	}

	public @Nullable R visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		return delegate.visitResolveExp(object);
	}

	public @Nullable R visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		return delegate.visitResolveInExp(object);
	}

	public @Nullable R visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		return delegate.visitTag(object);
	}

	public @Nullable R visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		return delegate.visitVarParameter(object);
	}
}
