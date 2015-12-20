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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.TupleLiteralExp;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.ASTNode;


public class VariableHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();
		CSTNode targetCS = null;	
		
		if (syntaxElement instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS)context.getSyntaxElement();			
			CSTNode varDeclElement = resolveVariableDeclaration(nameCS);
			
			if(varDeclElement instanceof ParameterDeclarationCS) {
				ParameterDeclarationCS paramDeclCS = (ParameterDeclarationCS) varDeclElement;
				SimpleNameCS paramNameCS = paramDeclCS.getSimpleNameCS();
				if(paramNameCS != null && paramNameCS.getValue() != null) {
					targetCS = paramNameCS;
				}
			} else if(varDeclElement instanceof VariableInitializationCS) {
				// resolve declared variable
				VariableInitializationCS varDecl = (VariableInitializationCS)varDeclElement;
				SimpleNameCS varName = varDecl.getSimpleNameCS();
				if(varName != null && varName.getValue() != null) {
					targetCS = varName;
				}
			} else if(varDeclElement instanceof VariableCS) {
				targetCS = varDeclElement;
			}
			
		} else if(syntaxElement instanceof VariableCS) {			
			EObject eContainer = syntaxElement.eContainer();
			if(eContainer instanceof TupleLiteralExp) {
				// TODO - not trivial as multiple tuple types CST may exist but are always resolved to 
				// a single TupleType EClassifier instance => no unambiguous way to go to a definition location
				return null;
			}
		}
		
		if(targetCS != null) {
			IRegion linkRegion = HyperlinkUtil.createRegion(syntaxElement);
			IRegion targetRegion = HyperlinkUtil.createRegion(targetCS);
			URI sourceURI = context.getModule().getURI();
			return new QvtFileHyperlink(linkRegion, sourceURI, targetRegion, targetRegion); 
		}
		
		return null;
	}
	
	/**
	 * @return <code>VariableInitializationCS</code> or <code>ParameterDeclarationCS</code> if successfully
	 * 	resolve, <code>null</code> otherwise.
	 */
	public static CSTNode resolveVariableDeclaration(SimpleNameCS nameCS) {
		if(nameCS.eContainer() instanceof VariableExpCS) {
			ASTNode varExpNodeAS = ASTBindingHelper.resolveASTNode(nameCS);
			
			if(varExpNodeAS instanceof VariableExp) {
				VariableExp variableExp = (VariableExp) varExpNodeAS;
				Variable<EClassifier, EParameter> var = variableExp.getReferredVariable();

				if(var != null) {
					if(var.getRepresentedParameter() != null) {
						EParameter param = var.getRepresentedParameter();
						
						if(param instanceof VarParameter) {
							// resolve operation parameter reference
							VarParameter varParam = (VarParameter) param;
							CSTNode paramCS = ASTBindingHelper.resolveCSTNode(varParam);
							if(paramCS instanceof ParameterDeclarationCS) {
								ParameterDeclarationCS paramDeclCS = (ParameterDeclarationCS) paramCS;
								return paramDeclCS;
							}
						}
					}
					
					CSTNode cstVarNode = ASTBindingHelper.resolveCSTNode(var);
					if(cstVarNode instanceof VariableInitializationCS) {
						// resolve declared variable
						VariableInitializationCS varDecl = (VariableInitializationCS) cstVarNode;
						return varDecl;						
						
					} else if(cstVarNode instanceof VariableCS) {					
						return cstVarNode;
					}
				}
			}
		} else if(nameCS.eContainer() instanceof ParameterDeclarationCS) {
			return (ParameterDeclarationCS) nameCS.eContainer();
		} else if(nameCS.eContainer() instanceof TypeSpecCS) {
			// model extent qualifier used with type
			TypeSpecCS typeSpecCS = (TypeSpecCS) nameCS.eContainer();
			if(nameCS != typeSpecCS.getSimpleNameCS()) {
				return null;
			}

			ModelParameter modelParam = lookupModelParameter(getEnv(nameCS), nameCS.getValue());
			if(modelParam != null) {
				return ASTBindingHelper.resolveCSTNode(modelParam, CSTNode.class);
			}
		}
		
		return null;
	}	
	
	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	

	private static ModelParameter lookupModelParameter(QvtOperationalEnv env, String paramName) {
		if(env.getModuleContextType() instanceof OperationalTransformation == false) {
			return null;
		}
		
		OperationalTransformation module = (OperationalTransformation) env.getModuleContextType();
		for (ModelParameter nextParam : module.getModelParameter()) {
			if(paramName.equals(nextParam.getName())) {
				return nextParam;
			}
		}
		return null;
	}
}
