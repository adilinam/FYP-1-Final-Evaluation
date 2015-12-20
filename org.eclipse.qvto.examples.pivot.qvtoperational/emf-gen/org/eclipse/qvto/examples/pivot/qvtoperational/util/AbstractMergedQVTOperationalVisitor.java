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
 * An AbstractMergedQVTOperationalVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTOperationalVisitor<R, C>
	extends org.eclipse.qvto.examples.pivot.imperativeocl.util.AbstractMergedImperativeOCLVisitor<R, C>
	implements QVTOperationalVisitor<R>
{
	protected AbstractMergedQVTOperationalVisitor(@NonNull C context) {
		super(context);
	}

	public @Nullable R visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		return visiting(object);
	}

	public @Nullable R visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		return visiting(object);
	}

	public @Nullable R visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		return visiting(object);
	}

	public @Nullable R visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		return visiting(object);
	}

	public @Nullable R visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		return visiting(object);
	}

	public @Nullable R visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		return visiting(object);
	}

	public @Nullable R visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		return visiting(object);
	}

	public @Nullable R visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		return visiting(object);
	}

	public @Nullable R visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		return visiting(object);
	}

	public @Nullable R visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		return visiting(object);
	}

	public @Nullable R visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		return visiting(object);
	}

	public @Nullable R visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		return visiting(object);
	}

	public @Nullable R visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		return visiting(object);
	}

	public @Nullable R visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		return visiting(object);
	}

	public @Nullable R visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		return visiting(object);
	}

	public @Nullable R visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		return visiting(object);
	}

	public @Nullable R visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		return visiting(object);
	}

	public @Nullable R visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		return visiting(object);
	}

	public @Nullable R visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		return visiting(object);
	}

	public @Nullable R visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		return visiting(object);
	}

	public @Nullable R visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		return visiting(object);
	}

	public @Nullable R visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		return visiting(object);
	}

	public @Nullable R visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		return visiting(object);
	}

	public @Nullable R visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		return visiting(object);
	}

	public @Nullable R visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		return visiting(object);
	}

	public @Nullable R visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		return visiting(object);
	}
}
