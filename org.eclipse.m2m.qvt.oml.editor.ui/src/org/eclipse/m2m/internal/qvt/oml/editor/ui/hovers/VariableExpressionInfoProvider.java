/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks.VariableHyperlinkDetector;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.ASTNode;



/**
 * @author vrepeshko
 */
public class VariableExpressionInfoProvider implements IElementInfoProvider {
	
	public VariableExpressionInfoProvider() {
		super();
	}

	public String getElementInfo(final Object element, ITextViewer textViewer, IRegion region) {
		if (element instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS) element;
			CSTNode nodeCS = VariableHyperlinkDetector.resolveVariableDeclaration(nameCS);
			if (nodeCS != null) { 
				EcoreEnvironment env = CSTHelper.getEnvironment(nameCS);
				ASTNode varNode = ASTBindingHelper.resolveASTNode(nodeCS);
				if(varNode instanceof Variable) {
					Variable var = (Variable)varNode;
					return SignatureUtil.getVariableSignature(env, var);
				} else if(varNode instanceof VarParameter) {
					VarParameter varParameter = (VarParameter) varNode;
					return SignatureUtil.getTypedElementSignature(env.getUMLReflection(), varParameter);
				}
			}
		}
		
		return null;
	}
}
