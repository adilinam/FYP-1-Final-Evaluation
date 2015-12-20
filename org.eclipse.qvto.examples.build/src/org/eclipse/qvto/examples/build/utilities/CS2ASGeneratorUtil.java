package org.eclipse.qvto.examples.build.utilities;

import org.eclipse.emf.ecore.EOperation;


/**
 * Util class with some static methods used by the CS2AS Generation
 * @author asbh
 *
 */
public class CS2ASGeneratorUtil {
	
	private static final String AST_OPERATION_NAME = "ast";
	
	/**
	 * Method comprising the heuristic to determine if a given {@link EOperation} 
	 * is an ast operation to provide the AS element corresponding the CS one.
	 * 
	 * FIXME So far, it uses the name of the operation and number of parameters 
	 * to identify the AST operation. Fragile 
	 * 
	 * @param eOperation
	 * @return <code>true</code> if this the CS2AS AST operation.
	 */
	public static boolean isAstOperation(EOperation eOperation) {
		if (AST_OPERATION_NAME.equals(eOperation.getName())
			&& eOperation.getEParameters().size() == 0) {
			return true;
		}
		return false;
	}
}
