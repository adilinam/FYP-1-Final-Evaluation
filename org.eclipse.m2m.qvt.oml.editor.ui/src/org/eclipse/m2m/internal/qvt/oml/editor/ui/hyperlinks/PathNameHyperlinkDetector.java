/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNode;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTSyntheticNodeAccess;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ConstructorOperationAdapter;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.CSTHelper;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.InstantiationExp;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;


/**
 * @author vrepeshko
 */
public class PathNameHyperlinkDetector implements IHyperlinkDetectorHelper {

	private static class EModelElementRef {
		final EModelElement element;
		final IRegion sourceLinkRegion;
		
		private EModelElementRef(EModelElement element, IRegion sourceLinkRegion) {
			this.element = element;
			this.sourceLinkRegion = sourceLinkRegion;
		}		
	}
	
	public IHyperlink detectHyperlink(IDetectionContext context) {		
		CSTNode syntaxElement = context.getSyntaxElement();		
		EModelElementRef elementRef = findReferencedMetamodelElement(syntaxElement, context.getRegion());
		
		if(elementRef != null) {
			EModelElement element = elementRef.element;
			CSTNode cstNode = ASTBindingHelper.resolveCSTNode(element, CSTNode.class);
			if(cstNode == null) {
				ASTSyntheticNode referencedDefinitionAST = ASTSyntheticNodeAccess.getASTNode(element);
				if(referencedDefinitionAST != null) {
					cstNode = ASTSyntheticNodeAccess.getCST(referencedDefinitionAST, CSTNode.class);
				}
			}
			if(cstNode != null) {
				URI sourceURI = CSTHelper.getSourceFile(cstNode);
				if(sourceURI != null) {
					if(cstNode instanceof ModelTypeCS) {
						// TODO - use QVT model Switch to get destination region specific to various CST							
						cstNode = ((ModelTypeCS) cstNode).getIdentifierCS();  
					} else if(cstNode instanceof MappingModuleCS) {
						MappingModuleCS moduleCS = (MappingModuleCS) cstNode;
						if(moduleCS.getHeaderCS() != null) {
							cstNode = moduleCS.getHeaderCS();
							if(moduleCS.getHeaderCS().getPathNameCS() != null) {
								cstNode = moduleCS.getHeaderCS().getPathNameCS(); 
							}
						}
					} else if(cstNode instanceof ClassifierDefCS) {
						cstNode = ((ClassifierDefCS) cstNode).getSimpleNameCS();
					}
					IRegion destReg = HyperlinkUtil.createRegion(cstNode);
					return new QvtFileHyperlink(elementRef.sourceLinkRegion, sourceURI, destReg, destReg);
				}
			}
			
			return new MetamodelElementHyperlink(elementRef.sourceLinkRegion, elementRef.element);			
		}

		return null;
	}
	
	public static EModelElement findReferencedElementDefinition(CSTNode syntaxElement, IRegion region) {
		EModelElementRef ref = findReferencedMetamodelElement(syntaxElement, region);
		return (ref != null) ? ref.element : null;
	}
	
	private static EModelElementRef findReferencedMetamodelElement(CSTNode syntaxElement, IRegion region) {
		Object astObj = syntaxElement.getAst();
		
		if(astObj instanceof EClassifier) {
			if (syntaxElement instanceof SimpleNameCS) {			
				if(astObj instanceof EModelElement) {
					return new EModelElementRef((EModelElement)astObj, HyperlinkUtil.createRegion(syntaxElement));
				}
			} else if (syntaxElement instanceof PathNameCS && !isConstructorCS(syntaxElement)) {						
				if(astObj instanceof ENamedElement) {
					PathNameCS pathNameCS  = (PathNameCS) syntaxElement;	

					int[] selectedNamePos = new int[1];
					//IRegion resultRegion = refineRegion(pathNameCS, region, selectedNamePos);
					IRegion resultRegion = getPathRegion(pathNameCS, region, selectedNamePos);					
					if(resultRegion != null) {
						ENamedElement ast = (ENamedElement) pathNameCS.getAst();
						int pos = selectedNamePos[0];
						final EList<SimpleNameCS> csNames = pathNameCS.getSimpleNames();
						
						if(pos >= 0 && pos < csNames.size() - 1) {
							QvtOperationalEnv env = getEnv(pathNameCS);

							List<SimpleNameCS> selectedNames = csNames.subList(0, pos + 1);
							List<String> stringNames = new ArrayList<String>(selectedNames.size());
							for (SimpleNameCS nameCS : selectedNames) {
								stringNames.add(nameCS.getValue());
							}
							
							ast = env.lookupClassifier(stringNames);
							if(ast == null) {
								ast = env.lookupPackage(stringNames);
							}
						}
						
						if(ast != null) {
							return new EModelElementRef(ast, resultRegion);
						}
					}
				}
			}
		}
		else if(astObj instanceof EEnumLiteral) {
			return new EModelElementRef((EEnumLiteral) astObj, HyperlinkUtil.createRegion(syntaxElement));
		}
		
		return null;
	}	
	
	private static boolean isConstructorCS(CSTNode syntaxElement) {
		if (false == syntaxElement.eContainer() instanceof InstantiationExpCS) {
			return false;
		}
		InstantiationExpCS constructorCS = (InstantiationExpCS) syntaxElement.eContainer();
		if (false == constructorCS.getAst() instanceof InstantiationExp) {
			return false;
		}
		InstantiationExp instExp = (InstantiationExp) constructorCS.getAst();
		Adapter adapter = EcoreUtil.getAdapter(instExp.eAdapters(), ConstructorOperationAdapter.class);
		return adapter != null && ((ConstructorOperationAdapter) adapter).getReferredConstructor() != null;
	}

	
	private static IRegion getPathRegion(PathNameCS pathNameCS, IRegion selection, int[] selectedPos) {
		int[] positions = getPathPos(pathNameCS);		
		if(positions == null) {
			return HyperlinkUtil.createRegion(pathNameCS); 
		}
			
		int nameOffset = pathNameCS.getStartOffset();
		int i = 0;
		for (SimpleNameCS name : pathNameCS.getSimpleNames()) {
			int offset = selection.getOffset();
			if(nameOffset <= offset && offset <= nameOffset + name.getValue().length()) {
				selectedPos[0] = i;				
				return new Region(nameOffset, name.getValue().length());
			}

			if(i == positions.length) {
				break;
			}
			
			nameOffset = positions[i++];			
		}
		
		return HyperlinkUtil.createRegion(pathNameCS);
	}
	
	private static int[] getPathPos(PathNameCS pathNameCS) {		
		EList<SimpleNameCS> sequenceOfNames = pathNameCS.getSimpleNames();
		if(sequenceOfNames.size() == 1) {
			return null;
		}
		
		int size = sequenceOfNames.size() - 1;
		int[] positions = new int[size];
		Arrays.fill(positions, -1);
		
		IToken startToken = pathNameCS.getStartToken();
		IToken endToken = pathNameCS.getEndToken();
		
		IPrsStream prsStream = startToken.getIPrsStream();
		IToken nextToken = startToken;
		
		int tokenIndex = 1;
		int i = 0;		
		while(nextToken != endToken) {
			nextToken = prsStream.getIToken(startToken.getTokenIndex() + tokenIndex++);
			if(nextToken.getKind() == QVTOParsersym.TK_IDENTIFIER) {
				positions[i++] = nextToken.getStartOffset();
				if(i == positions.length) {
					// safety exit in case we have inconsistent start end token
					break;
				}
			}
		}

		return positions;
	}
	
	private static QvtOperationalEnv getEnv(CSTNode node) {
		return (QvtOperationalEnv)CSTHelper.getEnvironment(node);
	}	
}
