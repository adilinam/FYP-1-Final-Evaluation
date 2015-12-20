/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.imperativeocl/model/ImperativeOCLCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.xtext.imperativeoclcs.util;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractExtendingImperativeOCLCSVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingImperativeOCLCSVisitor<R, C>
	extends org.eclipse.ocl.xtext.essentialoclcs.util.AbstractExtendingEssentialOCLCSVisitor<R, C>
	implements ImperativeOCLCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingImperativeOCLCSVisitor(@NonNull C context) {
		super(context);
	}	

	public @Nullable R visitAssertExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.AssertExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitAssignStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.AssignStatementCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitBlockExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.BlockExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitComputeExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ComputeExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitDictLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitDictLiteralPartCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.DictLiteralPartCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitDictTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.DictTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitDoExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.DoExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitExceptCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ExceptCS object) {
		return visitElementCS(object);
	}

	public @Nullable R visitExpressionBlockCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionBlockCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitExpressionStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ExpressionStatementCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitForExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ForExpCS object) {
		return visitImperativeLoopExpCS(object);
	}

	public @Nullable R visitImperativeIterateExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeIterateExpCS object) {
		return visitImperativeLoopExpCS(object);
	}

	public @Nullable R visitImperativeLoopExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ImperativeLoopExpCS object) {
		return visitCallExpCS(object);
	}

	public @Nullable R visitInstantiationExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.InstantiationExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitListLiteralExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ListLiteralExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitListTypeCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ListTypeCS object) {
		return visitTypedRefCS(object);
	}

	public @Nullable R visitLogExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.LogExpCS object) {
		return visitCallExpCS(object);
	}

	public @Nullable R visitQuitExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.QuitExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitRaiseExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.RaiseExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitReturnExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.ReturnExpCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitStatementCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.StatementCS object) {
		return visitExpCS(object);
	}

	public @Nullable R visitSwitchAltCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchAltCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitSwitchExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.SwitchExpCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitTryExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.TryExpCS object) {
		return visitExpressionBlockCS(object);
	}

	public @Nullable R visitVariableInitializationCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.VariableInitializationCS object) {
		return visitStatementCS(object);
	}

	public @Nullable R visitWhileExpCS(@NonNull org.eclipse.qvto.examples.xtext.imperativeoclcs.WhileExpCS object) {
		return visitExpressionBlockCS(object);
	}
}
