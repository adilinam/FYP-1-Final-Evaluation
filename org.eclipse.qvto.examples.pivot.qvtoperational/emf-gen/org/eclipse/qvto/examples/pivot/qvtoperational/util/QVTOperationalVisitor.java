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
 */
public interface QVTOperationalVisitor<R> extends org.eclipse.qvto.examples.pivot.imperativeocl.util.ImperativeOCLVisitor<R>
{
	@Nullable R visitConstructor(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Constructor object);
	@Nullable R visitConstructorBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ConstructorBody object);
	@Nullable R visitContextualProperty(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ContextualProperty object);
	@Nullable R visitDummyRelation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelation object);
	@Nullable R visitDummyRelationDomain(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationDomain object);
	@Nullable R visitDummyRelationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.DummyRelationalTransformation object);
	@Nullable R visitEntryOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.EntryOperation object);
	@Nullable R visitHelper(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Helper object);
	@Nullable R visitImperativeCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeCallExp object);
	@Nullable R visitImperativeOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ImperativeOperation object);
	@Nullable R visitLibrary(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Library object);
	@Nullable R visitMappingBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingBody object);
	@Nullable R visitMappingCallExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingCallExp object);
	@Nullable R visitMappingOperation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingOperation object);
	@Nullable R visitMappingParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.MappingParameter object);
	@Nullable R visitModelParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelParameter object);
	@Nullable R visitModelType(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModelType object);
	@Nullable R visitModule(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Module object);
	@Nullable R visitModuleImport(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ModuleImport object);
	@Nullable R visitObjectExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ObjectExp object);
	@Nullable R visitOperationBody(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationBody object);
	@Nullable R visitOperationalTransformation(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.OperationalTransformation object);
	@Nullable R visitResolveExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveExp object);
	@Nullable R visitResolveInExp(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.ResolveInExp object);
	@Nullable R visitTag(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.Tag object);
	@Nullable R visitVarParameter(@NonNull org.eclipse.qvto.examples.pivot.qvtoperational.VarParameter object);
}
