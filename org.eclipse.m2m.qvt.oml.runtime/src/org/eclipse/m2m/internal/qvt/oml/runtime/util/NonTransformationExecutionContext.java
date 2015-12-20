/*******************************************************************************
 * Copyright (c) 2008, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.util;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalStdLibrary;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.evaluator.ImportToNonTransformCtxHelper;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.library.Context;

/**
 * This class represents an execution context which is not a QVT transformation but a generic
 * executor.
 * <p>
 * The motivation of this class is allowing a generic client to reuse existing QVT Libraries in
 * other execution environments. Operation call objects can be invoked within a given execution context.
 * <p>
 * The execution context is constructed with as set of library modules that are imported into the scope of 
 * the context. Only QVT libraries and its helper operations are supported, only operations from the 
 * libraries that are already imported in the context can be called.
 * </p>
 * See the following example code snippet:
 <pre>
 Module module = ...; // get a valid AST of a library
 NonTransformationExecutionContext execContext = new NonTransformationExecutionContext(Collections.singleton(module));

 // find a helper method of interest
 Helper operation = findOperationByName(module, "fooHelper");
 // create a call object for the operation
 HelperOperationCall call = execContext.createHelperCall(operation);

 // calls with the 'self' contextual instance actual parameter values
 call.invoke("aContextString1", new Object[] { "aStringArg1" });
 call.invoke("aContextString2", new Object[] { "aStringArg2" });
 ...
 // we finished our work
 execContext.dispose();
 </pre>
 */
public class NonTransformationExecutionContext {
	
	private QvtOperationalEvaluationVisitorImpl fEvaluator;
	private LinkedHashSet<Module> fLibraryImports;
	
	/**
	 * Constructs new execution context and imports the given list of
	 * 
	 * @param libraryImports
	 *            the QVT libraries to be imported into the scope of the
	 *            execution context
	 * 
	 * @exception IllegalArgumentException
	 *                if <code>libraryImports</code> is <code>null</code>
	 */
	public NonTransformationExecutionContext(Set<Module> libraryImports) {
		if(libraryImports == null) {
			throw new IllegalArgumentException();	
		}
		
		fLibraryImports = new LinkedHashSet<Module>(libraryImports);
		
		Context context = new Context();
		ImportToNonTransformCtxHelper importProvider = new ImportToNonTransformCtxHelper(fLibraryImports, true);
		fEvaluator = QvtOperationalEvaluationVisitorImpl.createNonTransformationExecutionContextVisitor(context, importProvider);
	}
	
	/**
	 * Creates the call object for the give helper operation.
	 * <p>
	 * Note: A helper operation is either a <code>query</code> or a
	 * <code>helper</code> with side effects
	 * 
	 * @param operation
	 *            an operation defined in one of the libraries imported into
	 *            this execution context
	 * @return the call object on which invocations with actual parameter values
	 *         can be performed
	 * @exception IllegalArgumentException
	 *                if the given operation is not from a library already
	 *                imported to this execution context
	 */
	public HelperOperationCall createHelperCall(Helper operation) {
		if(operation == null) {
			throw new IllegalArgumentException("null operation"); //$NON-NLS-1$
		}
		
		Module owningModule = QvtOperationalParserUtil.getOwningModule(operation);
		if(owningModule == null || 
			!(owningModule == QvtOperationalStdLibrary.INSTANCE.getStdLibModule() ||
					fLibraryImports.contains(owningModule))) {
			
			throw new IllegalArgumentException("Operation not imported from a library"); //$NON-NLS-1$
		}
		
		return new HelperOperationCall(operation, this);
	}

	/**
	 * Disposes this execution context.
	 * <p>
	 * Frees any resources acquired by this context during execution
	 */
	public void dispose() {
		// TODO - remove me
		//getEvaluator().getOperationalEvaluationEnv().dispose();
	}
	
	/**
	 * Get the QVT evaluation visitor used by this execution context
	 */
	QvtOperationalEvaluationVisitorImpl getEvaluator() {
		return fEvaluator;
	}
	
	@Override
	public String toString() {	
		StringBuilder buf = new StringBuilder();
		for (Module importedLib : fLibraryImports) {
			buf.append(importedLib.getName());
		}
		return buf.toString();
	}	
}
