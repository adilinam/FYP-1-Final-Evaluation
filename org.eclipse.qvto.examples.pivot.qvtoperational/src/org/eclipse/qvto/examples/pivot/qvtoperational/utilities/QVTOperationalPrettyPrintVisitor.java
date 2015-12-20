package org.eclipse.qvto.examples.pivot.qvtoperational.utilities;
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


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.qvto.examples.pivot.imperativeocl.utilities.ImperativeOCLPrettyPrintVisitor;
import org.eclipse.qvto.examples.pivot.qvtoperational.Constructor;
import org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain;
import org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Helper;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.Library;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation;
import org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModelType;
import org.eclipse.qvto.examples.pivot.qvtoperational.Module;
import org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport;
import org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody;
import org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp;
import org.eclipse.qvto.examples.pivot.qvtoperational.Tag;
import org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.QVTOperationalVisitor;

public class QVTOperationalPrettyPrintVisitor extends ImperativeOCLPrettyPrintVisitor implements QVTOperationalVisitor<Object>
{	
	public QVTOperationalPrettyPrintVisitor(@NonNull PrettyPrinter context) {
		super(context);
	}

	@Nullable
	public Object visitConstructor(Constructor object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitConstructorBody(ConstructorBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitContextualProperty(ContextualProperty object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDummyRelation(DummyRelation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDummyRelationDomain(DummyRelationDomain object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitDummyRelationalTransformation(
			DummyRelationalTransformation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitEntryOperation(EntryOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitHelper(Helper object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitImperativeCallExp(ImperativeCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitImperativeOperation(ImperativeOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitLibrary(Library object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitMappingBody(MappingBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitMappingCallExp(MappingCallExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitMappingOperation(MappingOperation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitMappingParameter(MappingParameter object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitModelParameter(ModelParameter object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitModelType(ModelType object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitModule(Module object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitModuleImport(ModuleImport object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitObjectExp(ObjectExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitOperationBody(OperationBody object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitOperationalTransformation(
			OperationalTransformation object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitResolveExp(ResolveExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitResolveInExp(ResolveInExp object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitTag(Tag object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public Object visitVarParameter(VarParameter object) {
		// TODO Auto-generated method stub
		return null;
	}
}
