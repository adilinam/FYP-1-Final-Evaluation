/*******************************************************************************
 * <copyright>
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvto.examples.xtext.qvtoperational/model/QVTOperationalCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvto.examples.xtext.qvtoperationalcs.util;

import org.eclipse.jdt.annotation.NonNull;

/*
 * An AbstractQVTOperationalCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractQVTOperationalCSVisitor<R, C>
	extends org.eclipse.qvto.examples.xtext.imperativeoclcs.util.AbstractImperativeOCLCSVisitor<R, C>
	implements QVTOperationalCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTOperationalCSVisitor(@NonNull C context) {
		super(context);
	}
}
