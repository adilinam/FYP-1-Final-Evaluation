/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalAstWalker;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ObjectExp;
import org.eclipse.m2m.internal.qvt.oml.expressions.ResolveExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.BlockExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ComputeExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ForExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.VariableInitExp;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.utilities.Visitable;

class ASTElementContextEnv extends QvtOperationalEnv {

	private final class EnvVariableCollector extends QvtOperationalAstWalker {
		private final EObject astContext;
		private final List<Variable> varStack;
		private final List<Variable> result;

		private EnvVariableCollector(EObject astContext) {
			// use NOP external node processor, we need to customize the
			// visiting protocol			
			super(
				new NodeProcessor() {
					public void process(Visitable e, Visitable parent) {
						// do nothing
					}
				});
			
			this.astContext = astContext;
			
			this.varStack = new ArrayList<Variable>();
			this.result = new ArrayList<Variable>();
		}
		
		List<Variable> getVariables() {
			return result;
		}

		protected void doProcess(Visitable e, Visitable parent) {
			if (e == astContext) {							
				result.addAll(varStack);
			}

			if (!result.isEmpty()) {
				// preserve the env collected so far
				return;
			}

			if (e != null) {
				getNodeProcessor().process(e, parent);
				e.accept(this);
			}
		}

		@Override
		public Object visitVariableInitExp(VariableInitExp variableInitExp) {
			Variable var = variableInitExp.getReferredVariable();
			varStack.add(var);
			Object result = super.visitVariableInitExp(variableInitExp);
			// Note: no remove is needed, the scope handling for BlockExp
			// will handle that
			return result;
		}

		@Override
		public Object visitLetExp(LetExp<EClassifier, EParameter> letExp) {
			org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> var = letExp
					.getVariable();
			varStack.add((Variable) var);
			Object result = super.visitLetExp(letExp);
			varStack.remove((Variable) var);
			return result;
		}

		@Override
		public Object visitObjectExp(ObjectExp objectExp) {
			Variable var = objectExp.getReferredObject();
			varStack.add((Variable) var);
			Object result = super.visitObjectExp(objectExp);
			varStack.remove((Variable) var);
			return result;
		}

		@Override
		public Object visitResolveExp(ResolveExp resolveExp) {
			Variable var = resolveExp.getTarget();
			if (var != null) {
				varStack.add(var);
			}
			Object result = super.visitResolveExp(resolveExp);
			if (var != null) {
				varStack.remove(var);
			}
			return result;
		}

		@Override
		public Object visitIteratorExp(
				IteratorExp<EClassifier, EParameter> callExp) {
			addVars(varStack, callExp);

			Object result = super.visitIteratorExp(callExp);

			removeVars(varStack, callExp);
			return result;
		}

		@Override
		public Object visitIterateExp(
				IterateExp<EClassifier, EParameter> callExp) {
			addVars(varStack, callExp);
			Object result = super.visitIterateExp(callExp);
			removeVars(varStack, callExp);
			return result;
		}

		@Override
		public Object visitForExp(ForExp forExp) {
			addVars(varStack, forExp);
			Object result = super.visitForExp(forExp);
			removeVars(varStack, forExp);
			return result;
		}

		@Override
		public Object visitImperativeIterateExp(
				ImperativeIterateExp imperativeIterateExp) {
			addVars(varStack, imperativeIterateExp);
			Object result = super
					.visitImperativeIterateExp(imperativeIterateExp);
			removeVars(varStack, imperativeIterateExp);
			return result;
		}

		@Override
		public Object visitBlockExp(BlockExp blockExp) {
			List<Variable> saveVarStack = new ArrayList<Variable>(varStack);

			Object result = super.visitBlockExp(blockExp);

			varStack.clear();
			varStack.addAll(saveVarStack);
			return result;
		}

		@Override
		public Object visitComputeExp(ComputeExp computeExp) {
			Variable var = computeExp.getReturnedElement();
			if (var != null) {
				varStack.add(var);
			}

			Object result = super.visitComputeExp(computeExp);

			if (var != null) {
				varStack.remove(var);
			}

			return result;
		}

		private void removeVars(final List<Variable> varStack,
				LoopExp<EClassifier, EParameter> itExp) {
			for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> iter : itExp
					.getIterator()) {
				varStack.remove((Variable) iter);
			}
		}

		private void addVars(final List<Variable> varStack,
				LoopExp<EClassifier, EParameter> itExp) {
			for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> iter : itExp
					.getIterator()) {
				varStack.add((Variable) iter);
			}
		}
	}

	
	private StringBuilder fErrors = new StringBuilder();

	
	ASTElementContextEnv(QvtOperationalEnv parent, EObject astElement) {
		super(parent);
		initializeContextVariables(astElement);
	}

	StringBuilder getErrorTxtBuffer() {
		return fErrors;
	}

	@Override
	public boolean hasErrors() {
		return fErrors.length() > 0;
	}

	@Override
	public void reportError(String message, int startOffset, int endOffset) {
		// do not propagate fErrors to the root environment
		fErrors.append(message).append('\n');
	}

	@Override
	public void reportWarning(String message, int startOffset, int endOffset) {
		// not important
	}

	private void initializeContextVariables(final EObject astContext) {
		EnvVariableCollector varCollector = new EnvVariableCollector(astContext);
		
		EOperation contextOperation = this.getContextOperation();
		if(contextOperation instanceof ImperativeOperation) {
			varCollector.visitImperativeOperation((ImperativeOperation) contextOperation);
		}
		
		List<Variable> variables = varCollector.getVariables();
		if (!variables.isEmpty()) {
			for (Variable variable : variables) {
				String name = variable.getName();
				boolean isExplicit = !name.startsWith(QvtOperationalEnv.GENERATED_NAME_SPECIAL_PREFIX);
				this.addElement(name, variable, isExplicit);
			}
		}
	}
}