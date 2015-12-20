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

/**
 */
public interface DecorableImperativeOCLCSVisitor<R> extends ImperativeOCLCSVisitor<R>, org.eclipse.ocl.xtext.essentialoclcs.util.DecorableEssentialOCLCSVisitor<R>
{
	void setUndecoratedVisitor(@NonNull org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor<R> visitor);
}
