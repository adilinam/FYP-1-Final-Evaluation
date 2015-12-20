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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 */
public interface ImperativeOCLVisitor<R> extends org.eclipse.ocl.pivot.util.Visitor<R>
{
	@Nullable R visitAltExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AltExp object);
	@Nullable R visitAssertExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssertExp object);
	@Nullable R visitAssignExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.AssignExp object);
	@Nullable R visitBlockExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BlockExp object);
	@Nullable R visitBreakExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.BreakExp object);
	@Nullable R visitCatchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.CatchExp object);
	@Nullable R visitComputeExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ComputeExp object);
	@Nullable R visitContinueExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ContinueExp object);
	@Nullable R visitDictLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralExp object);
	@Nullable R visitDictLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictLiteralPart object);
	@Nullable R visitDictionaryType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.DictionaryType object);
	@Nullable R visitForExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ForExp object);
	@Nullable R visitImperativeExpression(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeExpression object);
	@Nullable R visitImperativeIterateExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeIterateExp object);
	@Nullable R visitImperativeLoopExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeLoopExp object);
	@Nullable R visitInstantiationExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.InstantiationExp object);
	@Nullable R visitListLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListLiteralExp object);
	@Nullable R visitListType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ListType object);
	@Nullable R visitLogExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.LogExp object);
	@Nullable R visitOrderedTupleLiteralExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralExp object);
	@Nullable R visitOrderedTupleLiteralPart(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleLiteralPart object);
	@Nullable R visitOrderedTupleType(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.OrderedTupleType object);
	@Nullable R visitRaiseExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.RaiseExp object);
	@Nullable R visitReturnExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.ReturnExp object);
	@Nullable R visitSwitchExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.SwitchExp object);
	@Nullable R visitTryExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.TryExp object);
	@Nullable R visitTypedef(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.Typedef object);
	@Nullable R visitUnlinkExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnlinkExp object);
	@Nullable R visitUnpackExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.UnpackExp object);
	@Nullable R visitVariableInitExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.VariableInitExp object);
	@Nullable R visitWhileExp(@NonNull org.eclipse.qvto.examples.pivot.imperativeocl.WhileExp object);
}
