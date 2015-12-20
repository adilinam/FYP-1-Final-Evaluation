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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvto.examples.pivot.imperativeocl.utilities.ImperativeOCLAS2XMIidVisitor;

/**
 * An AbstractQVTOperationalAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTOperationalAS2XMIidVisitor
	extends ImperativeOCLAS2XMIidVisitor
	implements QVTOperationalVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}	

	public @Nullable Boolean visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Boolean visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		return visitOperationBody(object);
	}

	public @Nullable Boolean visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		return visitProperty(object);
	}

	public @Nullable Boolean visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Boolean visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Boolean visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable Boolean visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		return visitOperation(object);
	}

	public @Nullable Boolean visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		return visitModule(object);
	}

	public @Nullable Boolean visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		return visitOperationBody(object);
	}

	public @Nullable Boolean visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		return visitImperativeCallExp(object);
	}

	public @Nullable Boolean visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Boolean visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		return visitVarParameter(object);
	}

	public @Nullable Boolean visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		return visitVarParameter(object);
	}

	public @Nullable Boolean visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		return visitClass(object);
	}

	public @Nullable Boolean visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		return visitClass(object);
	}

	public @Nullable Boolean visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		return visitInstantiationExp(object);
	}

	public @Nullable Boolean visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		return visitModule(object);
	}

	public @Nullable Boolean visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		return visitCallExp(object);
	}

	public @Nullable Boolean visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		return visitResolveExp(object);
	}

	public @Nullable Boolean visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		return visitElement(object);
	}

	public @Nullable Boolean visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		return visitVariable(object);
	}
}
