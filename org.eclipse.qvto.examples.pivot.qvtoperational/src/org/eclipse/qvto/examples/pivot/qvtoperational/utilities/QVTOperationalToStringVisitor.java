package org.eclipse.qvto.examples.pivot.qvtoperational.utilities;
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


import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.utilities.ImperativeOCLToStringVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

public class QVTOperationalToStringVisitor extends ImperativeOCLToStringVisitor implements QVTOperationalVisitor<String>
{
	protected static class QVTOperationalToStringFactory implements ToStringVisitor.Factory
	{
		protected QVTOperationalToStringFactory() {
			ToStringVisitor.addFactory(this);
			ImperativeOCLToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTOperationalToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTOperationalPackage eInstance = QVTOperationalPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static @NonNull ToStringVisitor.Factory FACTORY = new QVTOperationalToStringFactory();
	
	public QVTOperationalToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	public @Nullable String visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		return visitImperativeOperation(object);
	}

	public @Nullable String visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		return visitOperationBody(object);
	}

	public @Nullable String visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		return visitProperty(object);
	}

	public @Nullable String visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		return visitElement(object);
	}

	public @Nullable String visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		return visitElement(object);
	}

	public @Nullable String visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		return visitElement(object);
	}

	public @Nullable String visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable String visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		return visitImperativeOperation(object);
	}

	public @Nullable String visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable String visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		return visitOperation(object);
	}

	public @Nullable String visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		return visitModule(object);
	}

	public @Nullable String visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		return visitOperationBody(object);
	}

	public @Nullable String visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		return visitImperativeCallExp(object);
	}

	public @Nullable String visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable String visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		return visitVarParameter(object);
	}

	public @Nullable String visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		context.append(object.getName());
		context.append(" : ");
		context.append(object.getKind());
		return null;
	}

	public @Nullable String visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		return visitClass(object);
	}

	public @Nullable String visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		return visitClass(object);
	}

	public @Nullable String visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		return visitElement(object);
	}

	public @Nullable String visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		return visitInstantiationExp(object);
	}

	public @Nullable String visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		return visitElement(object);
	}

	public @Nullable String visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		return visitModule(object);
	}

	public @Nullable String visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		return visitCallExp(object);
	}

	public @Nullable String visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		return visitResolveExp(object);
	}

	public @Nullable String visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		return visitElement(object);
	}

	public @Nullable String visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		return visitVariable(object);
	}
}
