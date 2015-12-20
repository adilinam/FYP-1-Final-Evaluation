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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ConstructorOperationAdapter;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.internal.qvt.oml.expressions.Constructor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.utilities.ASTNode;


public class OperationHyperlinkDetector implements IHyperlinkDetectorHelper {
	
	public IHyperlink detectHyperlink(IDetectionContext context) {
		CSTNode syntaxElement = context.getSyntaxElement();

		if (syntaxElement instanceof InstantiationExpCS) {
			if (false == syntaxElement.getAst() instanceof InstantiationExp) {
				return null;
			}
			InstantiationExp instExp = (InstantiationExp) syntaxElement.getAst();
			Adapter adapter = EcoreUtil.getAdapter(instExp.eAdapters(), ConstructorOperationAdapter.class);
			if (adapter == null) {
				return null;
			}
			Constructor constructor = ((ConstructorOperationAdapter) adapter).getReferredConstructor();
			CSTNode resultCS = ASTBindingHelper.resolveCSTNode(constructor);
			CSTNode nameCS = (InstantiationExpCS) syntaxElement;//((InstantiationExpCS) syntaxElement).getTypeSpecCS();
			if (resultCS instanceof MappingMethodCS) {
				MappingMethodCS methodCS = (MappingMethodCS) resultCS;
				IRegion destRegion = getGoToOperationRegion(methodCS);
				URI sourceURI = ASTBindingHelper.resolveModuleFile(CSTHelper.getModule(methodCS));
				return new QvtFileHyperlink(HyperlinkUtil.createRegion(nameCS), sourceURI, 
								destRegion, destRegion);
			}
			// proceed as with ordinary ecore metamodel operation
			return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), constructor);						
		}
		
		if (syntaxElement instanceof SimpleNameCS) {
			SimpleNameCS nameCS = (SimpleNameCS) syntaxElement;						
			EOperation operation = resolveOperationDecl(nameCS);
			if(operation != null) {
				// handle specially operations defined in a QVT module
				MappingMethodCS methodCS = resolveImperativeOperationDecl(nameCS);
				if(methodCS != null) {
					IRegion destRegion = getGoToOperationRegion(methodCS);
					URI sourceURI = ASTBindingHelper.resolveModuleFile(CSTHelper.getModule(methodCS));
					return new QvtFileHyperlink(HyperlinkUtil.createRegion(nameCS), sourceURI, 
									destRegion, destRegion);
				}
				// proceed as with ordinary ecore metamodel operation
				return new MetamodelElementHyperlink(HyperlinkUtil.createRegion(nameCS), operation);						
			}
		}
		
		return null;		
	}
	

	public static EOperation resolveOperationDecl(SimpleNameCS nameCS) {
		if(nameCS.eContainer() instanceof OperationCallExpCS) {				
			OperationCallExpCS featureCallExpCS = (OperationCallExpCS)nameCS.eContainer();
			ASTNode featureASTNode = ASTBindingHelper.resolveASTNode(featureCallExpCS);
			
			if(featureASTNode instanceof OperationCallExp) {
				OperationCallExp operationCallExp = (OperationCallExp) featureASTNode;
				return operationCallExp.getReferredOperation();
			}
		} 
		return null;
	}
	
	
	public static MappingMethodCS resolveImperativeOperationDecl(SimpleNameCS nameCS) {
		EOperation operation = resolveOperationDecl(nameCS);
		if(operation instanceof ImperativeOperation) {
			CSTNode resultCS = ASTBindingHelper.resolveCSTNode((ImperativeOperation) operation);
			return (resultCS instanceof MappingMethodCS) ? (MappingMethodCS) resultCS : null;
		}
		return null;
	}
	
	private IRegion getGoToOperationRegion(MappingMethodCS mappingMethodCS) {
		int startOffset = mappingMethodCS.getStartOffset();
		int length = 0;

		MappingDeclarationCS decl = mappingMethodCS.getMappingDeclarationCS();
		if(decl != null) { 
			SimpleNameCS simpleName = decl.getSimpleNameCS();
			length = simpleName != null ? simpleName.getValue().length() : length;

			TypeCS context = decl.getContextType();
			if(context != null) {
				startOffset = mappingMethodCS.getMappingDeclarationCS().getContextType().getEndOffset();
				startOffset += 3; // skip '::' qualified name delimiter
			} else {
				startOffset = simpleName.getStartOffset();
			}
		}
 
		return new Region(startOffset, length);
	}
}
