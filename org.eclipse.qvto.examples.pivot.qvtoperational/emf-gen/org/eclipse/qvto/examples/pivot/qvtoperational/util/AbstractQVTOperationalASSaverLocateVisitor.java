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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvto.examples.pivot.imperativeocl.utilities.ImperativeOCLASSaverLocateVisitor;

/**
 * An AbstractQVTOperationalASSaverLocateVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTOperationalASSaverLocateVisitor
	extends ImperativeOCLASSaverLocateVisitor
	implements QVTOperationalVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalASSaverLocateVisitor(@NonNull ASSaver context) {
		super(context);
	}	

	public @Nullable Object visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Object visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object) {
		return visitOperationBody(object);
	}

	public @Nullable Object visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object) {
		return visitProperty(object);
	}

	public @Nullable Object visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object) {
		return visitElement(object);
	}

	public @Nullable Object visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object) {
		return visitElement(object);
	}

	public @Nullable Object visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object) {
		return visitElement(object);
	}

	public @Nullable Object visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Object visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Object visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object) {
		return visitOperationCallExp(object);
	}

	public @Nullable Object visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object) {
		return visitOperation(object);
	}

	public @Nullable Object visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object) {
		return visitModule(object);
	}

	public @Nullable Object visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object) {
		return visitOperationBody(object);
	}

	public @Nullable Object visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object) {
		return visitImperativeCallExp(object);
	}

	public @Nullable Object visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object) {
		return visitImperativeOperation(object);
	}

	public @Nullable Object visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object) {
		return visitVarParameter(object);
	}

	public @Nullable Object visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object) {
		return visitVarParameter(object);
	}

	public @Nullable Object visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object) {
		return visitClass(object);
	}

	public @Nullable Object visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object) {
		return visitClass(object);
	}

	public @Nullable Object visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object) {
		return visitElement(object);
	}

	public @Nullable Object visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object) {
		return visitInstantiationExp(object);
	}

	public @Nullable Object visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object) {
		return visitElement(object);
	}

	public @Nullable Object visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object) {
		return visitModule(object);
	}

	public @Nullable Object visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object) {
		return visitCallExp(object);
	}

	public @Nullable Object visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object) {
		return visitResolveExp(object);
	}

	public @Nullable Object visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object) {
		return visitElement(object);
	}

	public @Nullable Object visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object) {
		return visitVariable(object);
	}
}
