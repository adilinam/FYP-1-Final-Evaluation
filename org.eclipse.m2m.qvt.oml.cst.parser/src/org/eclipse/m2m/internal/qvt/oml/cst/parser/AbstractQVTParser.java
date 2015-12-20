/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 410470, 416584, 419299 
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import java.util.ArrayList;
import java.util.List;

import lpg.runtime.IToken;
import lpg.runtime.Token;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CatchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ComputeExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ElementWithBody;
import org.eclipse.m2m.internal.qvt.oml.cst.ExceptionDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.IntermediateClassDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.PackageRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.QualifierKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RaiseExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveInExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TryExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.WhileExpCS;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler.Severity;
import org.eclipse.ocl.parser.AbstractOCLParser;

public abstract class AbstractQVTParser extends AbstractOCLParser {

	private boolean isCSTTokenEnabled = false;
	
	protected AbstractQVTParser(QVTOLexer lexStream) {
		super(lexStream);
	}
	
	public void enableCSTTokens(boolean enable) {
		this.isCSTTokenEnabled = enable;
	}
	
	protected void reportWarning(String message, int startOffset, int endOffset) {
        BasicEnvironment env = getEnvironment();
        if (env != null && env.getProblemHandler() != null) {
        	env.getProblemHandler().parserProblem(Severity.WARNING, message, "", startOffset, endOffset); //$NON-NLS-1$
        }
	}
	
	protected void reportError(String message, int startOffset, int endOffset) {
        BasicEnvironment env = getEnvironment();
        if (env != null && env.getProblemHandler() != null) {
        	env.getProblemHandler().parserProblem(Severity.ERROR, message, "", startOffset, endOffset); //$NON-NLS-1$
        }
	}
	
	public abstract String getTokenKindName(int kind);
	
	protected final void setBodyOffsets(ElementWithBody element, CSTNode start, IToken end) {
		element.setBodyStartLocation(start.getEndOffset());
		element.setBodyEndLocation(end.getStartOffset());
	}
		
	protected final Object setupTopLevel(EList<CSTNode> unitElements) {
		validateTopLevelElementOrder(unitElements);
		
		UnitCS unitCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createUnitCS();
		unitCS.eSetDeliver(false);
		
		List<MappingModuleCS> modules = new ArrayList<MappingModuleCS>();
	    List<ModelTypeCS> modeltypes = new ArrayList<ModelTypeCS>();
	    List<ClassifierDefCS> classifiers = new ArrayList<ClassifierDefCS>();
	    List<ModulePropertyCS> properties = new ArrayList<ModulePropertyCS>();
	    List<MappingQueryCS> helpers = new ArrayList<MappingQueryCS>();
	    List<MappingRuleCS> mappings = new ArrayList<MappingRuleCS>();
	    List<ConstructorCS> constructors = new ArrayList<ConstructorCS>();
	    List<RenameCS> renamings = new ArrayList<RenameCS>();
	    List<ImportCS> imports = new ArrayList<ImportCS>();
	    List<TagCS> tags = new ArrayList<TagCS>();
	    
	    CSTNode startingUnitElement = null;
	    CSTNode trailingUnitElement = null;

	    for (CSTNode unitElement : unitElements) {
	        if (unitElement instanceof MappingModuleCS) {
	            modules.add((MappingModuleCS) unitElement);
	        } else if (unitElement instanceof ModelTypeCS) {
	            modeltypes.add((ModelTypeCS) unitElement);
	        } else if (unitElement instanceof ClassifierDefCS) {
	            classifiers.add((ClassifierDefCS) unitElement);
	        } else if (unitElement instanceof ModulePropertyCS) {
	            properties.add((ModulePropertyCS) unitElement);
	        } else if (unitElement instanceof MappingQueryCS) {
	            helpers.add((MappingQueryCS) unitElement);
	        } else if (unitElement instanceof MappingRuleCS) {
	            mappings.add((MappingRuleCS) unitElement);
	        } else if (unitElement instanceof ConstructorCS) {
	            constructors.add((ConstructorCS) unitElement);
	        } else if (unitElement instanceof RenameCS) {
	            renamings.add((RenameCS) unitElement);
	        } else if (unitElement instanceof ImportCS) {
	            imports.add((ImportCS) unitElement);
	        } else if (unitElement instanceof TagCS) {
	            tags.add((TagCS) unitElement);
	        } else if (unitElement == null) { // error recovery
	        	continue;
	        } else {
	            throw new RuntimeException("Unknown unit_element: " + unitElement); //$NON-NLS-1$
	        }
        	assert (unitElement != null); // must have been checked before
	        if (startingUnitElement == null) {
	        	startingUnitElement = unitElement;
	        }
	        trailingUnitElement = unitElement;
	    }
	    if (modules.isEmpty()) {
	    	if (startingUnitElement != null && startingUnitElement.getStartToken() != null) {
	            reportError(Messages.NoModulesDeclared, startingUnitElement.getStartToken().getTokenIndex(),
	            		trailingUnitElement.getEndToken().getTokenIndex()
	                    );
	    	}
            return null;
	    }
	    if ((modules.size() > 1) && (unitElements.size() != modules.size() + imports.size() + modeltypes.size())) {
	        reportError(Messages.MultipleModulesExtraUnitElements, startingUnitElement.getStartOffset(), trailingUnitElement.getEndOffset());
	    }
        for (MappingModuleCS moduleCS : modules) {
        	moduleCS.eSetDeliver(false);
        	// Clone modeltypes
        	List<ModelTypeCS> modeltypesCopy = new ArrayList<ModelTypeCS>();
            for (ModelTypeCS modeltypeCS : modeltypes) {
            	modeltypeCS.eSetDeliver(false);
            	EcoreUtil.Copier copier = new EcoreUtil.Copier();
    		    EObject modeltypeCSCopy = copier.copy(modeltypeCS);
    		    copier.copyReferences();
            	modeltypesCopy.add((ModelTypeCS)modeltypeCSCopy);
            }
            moduleCS.getMetamodels().addAll(modeltypesCopy);
            
        	// Clone imports
        	List<ImportCS> importsCopy = new ArrayList<ImportCS>();
            for (ImportCS importCS : imports) {
            	importCS.eSetDeliver(false);
            	EcoreUtil.Copier copier = new EcoreUtil.Copier();
    		    EObject importCSCopy = copier.copy(importCS);
    		    copier.copyReferences();
    		    importsCopy.add((ImportCS)importCSCopy);
            }
            moduleCS.getImports().addAll(importsCopy);
        }
	    if (modules.size() == 1) {
	        MappingModuleCS moduleCS = modules.get(0);
            moduleCS.getProperties().addAll(properties);
            moduleCS.getMethods().addAll(helpers);
            moduleCS.getMethods().addAll(mappings);
            moduleCS.getMethods().addAll(constructors);
            moduleCS.getRenamings().addAll(renamings);
            moduleCS.getClassifierDefCS().addAll(classifiers);
            moduleCS.getTags().addAll(tags);
            setOffsets(moduleCS, startingUnitElement, trailingUnitElement);
	    }

		unitCS.getTopLevelElements().addAll(modules);
	    return unitCS;
	}
	
	protected final CSTNode createLocalPropertyCS(IToken tokenText, TypeCS sym, OCLExpressionCS sym2) {
		LocalPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLocalPropertyCS();
		prop.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		prop.setOclExpressionCS(sym2);
		return prop;
	}

	protected final CSTNode createConfigPropertyCS(IToken tokenText, TypeCS sym) {
		ConfigPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createConfigPropertyCS();
		prop.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, tokenText);
		prop.setSimpleNameCS(nameCS);
		prop.setTypeCS(sym);
		return prop;
	}

	protected final CSTNode createContextualPropertyCS(ScopedNameCS scopedNameCS, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		ContextualPropertyCS prop = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContextualPropertyCS();
		prop.eSetDeliver(false);
		prop.setSimpleNameCS(createSimpleNameCS(scopedNameCS));
		prop.setScopedNameCS(scopedNameCS);
		prop.setTypeCS(typeCS);
		prop.setOclExpressionCS(oclExpressionCS);
		return prop;
	}

	protected final CSTNode createRenameCS(TypeCS sym, IToken tokenText, StringLiteralExpCS sym2) {
		RenameCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createRenameCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(sym);
		result.setOriginalName(sym2);
		return result;
	}

	protected final CSTNode createImportCS(PathNameCS sym) {
		ImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImportCS();
		imp.eSetDeliver(false);
		imp.setPathNameCS(sym);
		return imp;
	}
	
	protected final MappingModuleCS createLibraryCS(TransformationHeaderCS header, EList<CSTNode> moduleElements) {
	    LibraryCS libraryCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryCS();
	    libraryCS.eSetDeliver(false);
	    return initializeModule(libraryCS, header, moduleElements);
	}

	protected final MappingModuleCS createMappingModuleCS(TransformationHeaderCS header, EList<CSTNode> moduleElements) {
	    MappingModuleCS moduleCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingModuleCS();
	    moduleCS.eSetDeliver(false);
	    return initializeModule(moduleCS, header, moduleElements);
	}

	private MappingModuleCS initializeModule(MappingModuleCS moduleCS, TransformationHeaderCS header, EList<CSTNode> moduleElements) {
        moduleCS.setHeaderCS(header);
        
        List<ClassifierDefCS> classifiers = new ArrayList<ClassifierDefCS>();
        List<ModulePropertyCS> properties = new ArrayList<ModulePropertyCS>();
        List<MappingQueryCS> helpers = new ArrayList<MappingQueryCS>();
        List<MappingRuleCS> mappings = new ArrayList<MappingRuleCS>();
	    List<ConstructorCS> constructors = new ArrayList<ConstructorCS>();
        List<TagCS> tags = new ArrayList<TagCS>();

        for (CSTNode moduleElement : moduleElements) {
            if (moduleElement instanceof ClassifierDefCS) {
                classifiers.add((ClassifierDefCS) moduleElement);
            } else if (moduleElement instanceof ModulePropertyCS) {
                properties.add((ModulePropertyCS) moduleElement);
            } else if (moduleElement instanceof MappingQueryCS) {
                helpers.add((MappingQueryCS) moduleElement);
            } else if (moduleElement instanceof MappingRuleCS) {
                mappings.add((MappingRuleCS) moduleElement);
	        } else if (moduleElement instanceof ConstructorCS) {
	            constructors.add((ConstructorCS) moduleElement);
            } else if (moduleElement instanceof TagCS) {
                tags.add((TagCS) moduleElement);
            } else if (moduleElement == null) { // error recovery
                continue;
            } else {
                throw new RuntimeException("Unknown module_element: " + moduleElement); //$NON-NLS-1$
            }
        }

        moduleCS.getClassifierDefCS().addAll(classifiers);
        moduleCS.getProperties().addAll(properties);
        moduleCS.getMethods().addAll(helpers);
        moduleCS.getMethods().addAll(mappings);
        moduleCS.getMethods().addAll(constructors);
        moduleCS.getTags().addAll(tags);
        return moduleCS;
	}

	protected final MappingQueryCS createMappingQueryCS(boolean isEntryOp, MappingDeclarationCS sym, BlockExpCS bodyCS) {
		if (sym != null && sym.getSimpleNameCS() != null 
				&& !isEntryOp && QVTOParsersym.orderedTerminalSymbols[QVTOParsersym.TK_main].equals(sym.getSimpleNameCS().getValue())) {
			reportWarning(Messages.EntryOp_DisallowedDeclAsHelper, sym.getStartOffset(), sym.getEndOffset());
		}
		MappingQueryCS query = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingQueryCS();
		query.eSetDeliver(false);
		query.setMappingDeclarationCS(sym);
		query.setBody(bodyCS);
		return query;
	}

	protected final MappingRuleCS createMappingRuleCS(MappingDeclarationCS mappingDecl, EList<OCLExpressionCS> guards,
			EList<OCLExpressionCS> posts, MappingSectionsCS mappingBody) {
		MappingRuleCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingRuleCS();
		result.eSetDeliver(false);
		result.setMappingDeclarationCS(mappingDecl);
		result.getGuards().addAll(guards);
		result.getPosts().addAll(posts);
		result.setMappingBody(mappingBody);
		return result;
	}

	protected final CSTNode createLibraryImportCS(PathNameCS sym) {
		LibraryImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryImportCS();
		imp.eSetDeliver(false);
		imp.setPathNameCS(sym);
		return imp;
	}

	protected final CSTNode createVariableInitializationCS(IToken identifier, TypeCS typeCS, OCLExpressionCS initExpressionCS, boolean withResult) {
		VariableInitializationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createVariableInitializationCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, identifier);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, identifier);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(typeCS);
		result.setOclExpressionCS(initExpressionCS);
		result.setWithResult(withResult);
		return result;
	}

	protected final CSTNode createExpressionStatementCS(OCLExpressionCS sym) {
		ExpressionStatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createExpressionStatementCS();
		result.eSetDeliver(false);
		result.setOclExpressionCS(sym);
		return result;
	}

	protected final CSTNode createMappingEndCS(EList<OCLExpressionCS> statements, int endOffset, int startOffset) {
		MappingEndCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingEndCS();
		result.eSetDeliver(false);
		initializeMappingSection(result, statements, endOffset, startOffset);		
		return result;
	}

	protected final CSTNode createMappingInitCS(EList<OCLExpressionCS> statements, int endOffset, int startOffset) {
		MappingInitCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingInitCS();
		result.eSetDeliver(false);
		initializeMappingSection(result, statements, endOffset, startOffset);		
		return result;
	}
	
	protected final CSTNode createMappingSectionsCS(MappingInitCS mappingInitCS, MappingBodyCS mappingPopulationCS, MappingEndCS mappingEndCS) {
	    if ((mappingInitCS == null) && (mappingPopulationCS == null) && (mappingEndCS == null)) {
	        return null;
	    }
	    MappingSectionsCS mappingSectionsCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingSectionsCS();
	    mappingSectionsCS.eSetDeliver(false);
	    mappingSectionsCS.setMappingInitCS(mappingInitCS);
	    mappingSectionsCS.setMappingBodyCS(mappingPopulationCS);
	    mappingSectionsCS.setMappingEndCS(mappingEndCS);
	    setOffsetsForComplexNode(mappingSectionsCS, mappingInitCS, mappingPopulationCS, mappingEndCS);
	    return mappingSectionsCS;
    }
	
	private final void setOffsetsForComplexNode(CSTNode complexNode, CSTNode... cstParts) {
	    for (CSTNode cstPart : cstParts) {
	        if (cstPart != null) {
	            complexNode.setStartOffset(cstPart.getStartOffset());
	            break;
	        }
	    }
	    for (int i = cstParts.length - 1; i >= 0; i--) {
            if (cstParts[i] != null) {
                complexNode.setEndOffset(cstParts[i].getEndOffset());
                break;
            }
	    }
	}
	
	private void initializeMappingSection(MappingSectionCS section, EList<OCLExpressionCS> statements,
			int endOffset, int startOffset) {
				section.getStatements().addAll(statements);
				section.setBodyStartLocation(startOffset);
				section.setBodyEndLocation(endOffset);
			}

	protected final ParameterDeclarationCS createResultParameterDeclarationCS(TypeSpecCS typeSpecCS) {
		DirectionKindCS directionKindCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		directionKindCS.eSetDeliver(false);
		directionKindCS.setDirectionKind(DirectionKindEnum.OUT);
		return createParameterDeclarationCS(directionKindCS, null, typeSpecCS);
	}
	
	protected final ParameterDeclarationCS createParameterDeclarationCS(DirectionKindCS sym, IToken tokenText, TypeSpecCS typeSpecCS) {
		ParameterDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = null;
		if (tokenText != null) {
			nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText);
			nameCS.eSetDeliver(false);
			setOffsets(nameCS, tokenText);
		}
		else {
			//nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
		}
		result.setSimpleNameCS(nameCS);
		result.setTypeSpecCS(typeSpecCS);
		if (sym != null) {
			result.setDirectionKind(sym.getDirectionKind());
		}
		return result;
	}

	protected final TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
		TypeSpecCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTypeSpecCS();
		result.eSetDeliver(false);
		result.setTypeCS(typeCS);
		setOffsets(result, typeCS);
		if (extentLocation != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, extentLocation);
			nameCS.eSetDeliver(false);
			setOffsets(nameCS, extentLocation);
			result.setSimpleNameCS(nameCS);
			result.setEndOffset(extentLocation.getEndOffset());
		}
		return result;
	}

	protected final CSTNode createDirectionKindCS(DirectionKindEnum kind) {
		DirectionKindCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		result.eSetDeliver(false);
		result.setDirectionKind(kind);
		return result;
	}

	protected final CSTNode createCompleteSignatureCS(SimpleSignatureCS simpleSignatureCS, EList<ParameterDeclarationCS> resultList) {
	    CompleteSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createCompleteSignatureCS();
	    result.eSetDeliver(false);
	    result.setSimpleSignature(simpleSignatureCS);
	    result.getResultParams().addAll(resultList);
        return result;
    }

    protected final SimpleSignatureCS createSimpleSignatureCS(EList<ParameterDeclarationCS> paramsCS) {
        SimpleSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSimpleSignatureCS();
        result.eSetDeliver(false);
        result.getParams().addAll(paramsCS);
        return result;
    }

    protected final MappingDeclarationCS createMappingDeclarationCS(DirectionKindCS directionKindCS, ScopedNameCS scopedNameCS,
			EList<ParameterDeclarationCS> parameters, EList<ParameterDeclarationCS> resultParameters) {
		MappingDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingDeclarationCS();
		result.eSetDeliver(false);
		result.setDirectionKindCS(directionKindCS);
		if(resultParameters != null) {
			result.getResult().addAll(resultParameters);
		}
		result.getParameters().addAll(parameters);
		result.setSimpleNameCS(createSimpleNameCS(scopedNameCS));

		result.setContextType(scopedNameCS.getTypeCS());
		return result;
	}
	
	private SimpleNameCS createSimpleNameCS(ScopedNameCS scopedNameCS) {
		SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, scopedNameCS.getName());
		simpleNameCS.eSetDeliver(false);
		
		int endOffset = scopedNameCS.getEndOffset();
		int length = (simpleNameCS.getValue() != null) ?  simpleNameCS.getValue().length() : 0;			
		simpleNameCS.setStartOffset(endOffset - (length > 0 ? length-1 : 0));
		simpleNameCS.setEndOffset(endOffset);

		return simpleNameCS;
	}
	
	protected final CSTNode createAssignStatementCS(OCLExpressionCS sym, OCLExpressionCS sym2, boolean b) {
		AssignStatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createAssignStatementCS();
		result.eSetDeliver(false);
		result.setLValueCS(sym);
		result.setOclExpressionCS(sym2);
		result.setIncremental(b);
		return result;
	}
	
	protected final ObjectExpCS setupOutExpCS(ObjectExpCS result, EList<OCLExpressionCS> expressions, int startOffset, int endOffset) {
		result.eSetDeliver(false);
		result.getExpressions().addAll(expressions);
		result.setBodyStartLocation(startOffset);
		result.setBodyEndLocation(endOffset);
		if(result.getStartOffset() <= 0) {
			result.setStartOffset(startOffset);
		}
		if(result.getEndOffset() <= 0) {
			result.setEndOffset(endOffset);
		}
		return result;
	}

	protected final ObjectExpCS createOutExpCS(SimpleNameCS optVarNameCS, TypeSpecCS optTypeSpecCS) {
		ObjectExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createObjectExpCS();
		result.eSetDeliver(false);
		result.setSimpleNameCS(optVarNameCS);
		result.setTypeSpecCS(optTypeSpecCS);

		assert optVarNameCS != null || optTypeSpecCS != null;
		CSTNode posNodeCS = optVarNameCS == null ? optTypeSpecCS : optVarNameCS;
		result.setStartOffset(posNodeCS.getStartOffset());
		result.setEndOffset(posNodeCS.getEndOffset());
		return result;
	}

	protected final MappingBodyCS createMappingBodyCS(List<? extends OCLExpressionCS> expCS, boolean hasPopulationKeyword) {
		MappingBodyCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingBodyCS();
		result.eSetDeliver(false);
		for (OCLExpressionCS oclExpCS : expCS) {
			oclExpCS.eSetDeliver(false);
		}
		result.getStatements().addAll(expCS);
		result.setHasPopulationKeyword(hasPopulationKeyword);
		return result;
	}
	
	protected final ImperativeOperationCallExpCS createFeatureFQNOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments) {
		ImperativeOperationCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeOperationCallExpCS();
		result.eSetDeliver(false);
		return setupImperativeOperationCallExpCS(moduleName, operationName,	arguments, result);
	}
	
	protected CSTNode createIfExpCSExt(OCLExpressionCS condition,
			OCLExpressionCS thenExpression, EList<SwitchAltExpCS> elifExpressions, OCLExpressionCS elseExpression) {
		SwitchAltExpCS firstAlt = (SwitchAltExpCS) createSwitchAltExpCS(condition, thenExpression);
		firstAlt.setStartOffset(condition.getStartOffset());
		firstAlt.setEndOffset(thenExpression != null ? thenExpression.getEndOffset() : condition.getEndOffset());
		
		EList<SwitchAltExpCS> altExp = new BasicEList<SwitchAltExpCS>(elifExpressions.size()+1);
		altExp.add(firstAlt);		
		for (SwitchAltExpCS elifPart : elifExpressions) {
			altExp.add(elifPart);
		}
		
		return createSwitchExpCS(altExp, elseExpression);
	}
	
	@Override
	protected OperationCallExpCS createDotOperationCallExpCS(OCLExpressionCS oclExpressionCS, PathNameCS pathNameCs,
			SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,	EList<OCLExpressionCS> arguments) {
		if (pathNameCs != null && pathNameCs.getSimpleNames().size() == 1) {
			ImperativeOperationCallExpCS result = createFeatureFQNOperationCallExpCS(pathNameCs.getSimpleNames().get(0), simpleNameCS, arguments);
			if (oclExpressionCS != null) {
				result.setSource(oclExpressionCS);
				result.setIsAtomic(true);
			}
			result.setAccessor(oclExpressionCS != null ? DotOrArrowEnum.DOT_LITERAL : DotOrArrowEnum.NONE_LITERAL);
			if (isAtPre(isMarkedPreCS)) {
				result.setIsMarkedPreCS(isMarkedPreCS);
			}
			return result;
		}
		return super.createDotOperationCallExpCS(oclExpressionCS, pathNameCs, simpleNameCS, isMarkedPreCS, arguments);
	}

	private ImperativeOperationCallExpCS setupImperativeOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments,
			ImperativeOperationCallExpCS result) {
		result.setModule(moduleName);
		result.setSimpleNameCS(operationName);
		result.getArguments().addAll(arguments);
		return result;
	}

	protected final CSTNode createFeatureMappingCallExpCS(SimpleNameCS moduleNameCS, SimpleNameCS mappingNameCS, EList<OCLExpressionCS> arguments,
			boolean b) {
		MappingCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
		result.eSetDeliver(false);
		setupImperativeOperationCallExpCS(moduleNameCS, mappingNameCS, arguments, result);
		result.setStrict(b);
		return result;
	}

	protected final CSTNode createMappingCallExpCS(PathNameCS pathNameCS, EList<OCLExpressionCS> arguments, boolean b) {
		MappingCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingCallExpCS();
		result.eSetDeliver(false);
		if (pathNameCS.getSimpleNames().size() > 0) {
			SimpleNameCS simpleNameCS = pathNameCS.getSimpleNames().get(pathNameCS.getSimpleNames().size()-1);
			result.setSimpleNameCS(simpleNameCS);
		}		
		if (pathNameCS.getSimpleNames().size() > 0) {
			result.setSource(pathNameCS);
		}
		result.getArguments().addAll(arguments);
		result.setStrict(b);
		result.setIsMarkedPreCS(CSTFactory.eINSTANCE.createIsMarkedPreCS());
		return result;
	}

	protected final CSTNode createResolveOpArgsExpCS(IToken target, TypeCS typeCS, OCLExpressionCS condition) {
	    ResolveOpArgsExpCS resolveOpArgsExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createResolveOpArgsExpCS();
	    resolveOpArgsExpCS.eSetDeliver(false);
	    VariableCS variableCS = CSTFactory.eINSTANCE.createVariableCS();
	    variableCS.eSetDeliver(false);
	    variableCS.setTypeCS(typeCS);
	    if (target == null) {
			setOffsets(variableCS, typeCS);
	    } else {
	        variableCS.setName(target.toString());
			setOffsets(variableCS, target, typeCS);
	    }
	    resolveOpArgsExpCS.setTarget(variableCS);
	    resolveOpArgsExpCS.setCondition(condition);
	    return resolveOpArgsExpCS;
	}

	protected final CSTNode createResolveExpCS(IToken lateToken, IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
	    return populateResolveExpCS(org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createResolveExpCS(), 
	            lateToken, opCode, resolveOpArgsExpCS);
	}

	protected final CSTNode createResolveInExpCS(IToken lateToken, IToken opCode,
			ScopedNameCS mapping, ResolveOpArgsExpCS resolveOpArgsExpCS) {
		ResolveInExpCS resolveInExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createResolveInExpCS();
		resolveInExpCS.eSetDeliver(false);
		resolveInExpCS.setInMappingType(mapping.getTypeCS());
		
		SimpleNameCS mappingNameCS = CSTFactory.eINSTANCE.createSimpleNameCS();
		mappingNameCS.eSetDeliver(false);
		mappingNameCS.setValue(mapping.getName());
		
		mappingNameCS.setStartOffset(mapping.getStartOffset());
		if(mapping.getName() != null) {
			mappingNameCS.setStartOffset(mapping.getEndOffset() - mapping.getName().length() + 1);
		}
		mappingNameCS.setEndOffset(mapping.getEndOffset());
		
		resolveInExpCS.setInMappingName(mappingNameCS);
		return populateResolveExpCS(resolveInExpCS, lateToken, opCode, resolveOpArgsExpCS);
	}

	protected final CSTNode populateResolveExpCS(ResolveExpCS resolveExpCS, IToken lateToken,
			IToken opCode, ResolveOpArgsExpCS resolveOpArgsExpCS) {
	    resolveExpCS.setIsDeferred((lateToken != null) && getTokenKindName(QVTOParsersym.TK_late).equals(lateToken.toString()));
	    String opCodeText = opCode.toString();
	    resolveExpCS.setOne(opCodeText.indexOf("one") > 0); //$NON-NLS-1$
	    resolveExpCS.setIsInverse(opCodeText.indexOf("inv") == 0); //$NON-NLS-1$
	    if (resolveOpArgsExpCS != null) {
	        resolveExpCS.setTarget(resolveOpArgsExpCS.getTarget());
	        resolveExpCS.setCondition(resolveOpArgsExpCS.getCondition());
	    }
	    
	    SimpleNameCS operCodeSimpleName = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
	    operCodeSimpleName.eSetDeliver(false);
	    operCodeSimpleName.setStartOffset(opCode.getStartOffset());
	    operCodeSimpleName.setEndOffset(opCode.getEndOffset());
	    resolveExpCS.setSimpleNameCS(operCodeSimpleName);		    
	    
	    return resolveExpCS;
	}

	protected final ScopedNameCS createScopedNameCS(TypeCS typeCS, String name) {
		ScopedNameCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createScopedNameCS();
		result.eSetDeliver(false);
		result.setTypeCS(typeCS);
		result.setName(name);
		if(typeCS != null) {
			result.setStartOffset(typeCS.getStartOffset());
			result.setEndOffset(typeCS.getEndOffset());
			if(name != null) {
				result.setEndOffset(result.getEndOffset() + name.length());
			}
		}
		return result;
	}
	
	protected CSTNode createWhileExpCS(VariableCS resultVar, OCLExpressionCS cond, BlockExpCS body) {
		WhileExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createWhileExpCS();
		result.eSetDeliver(false);
		result.setCondition(cond);
		result.setResultVar(resultVar);
		result.setBody(body);
		return result;
	}		
	
	protected final CSTNode createLogExpCS(EList<OCLExpressionCS> args, OCLExpressionCS condition) {
		LogExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLogExpCS();
		result.eSetDeliver(false);
		String name = getTokenKindName(QVTOParsersym.TK_log);
		result.setSimpleNameCS(createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, name));

		for (OCLExpressionCS expCS : args) {
			expCS.eSetDeliver(false);
		}
		result.getArguments().addAll(args);		
		result.setCondition(condition);		
		return result;
	}
	
	protected final CSTNode createAssertExpCS(OCLExpressionCS assertCondition, SimpleNameCS severityIdentifier, LogExpCS logExpCS) {
		AssertExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createAssertExpCS();
		result.eSetDeliver(false);
		result.setAssertion(assertCondition);
		result.setSeverity(severityIdentifier);
		result.setLog(logExpCS);
		return result;
	}
	

	protected final CSTNode createForExpCS(IToken opCode, EList<IToken> iterators, OCLExpressionCS condition, BlockExpCS body) {
	    ForExpCS forExpCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createForExpCS();
	    forExpCS.eSetDeliver(false);

	    SimpleNameCS operCodeSimpleName = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
	    operCodeSimpleName.eSetDeliver(false);
        operCodeSimpleName.setStartOffset(opCode.getStartOffset());
        operCodeSimpleName.setEndOffset(opCode.getEndOffset());
        forExpCS.setSimpleNameCS(operCodeSimpleName);

        if ((iterators != null) && !iterators.isEmpty()) {
            VariableCS[] iterVars = new VariableCS[iterators.size()];
            for (int i = 0, n = iterVars.length; i < n; i++) {
                iterVars[i] = createVariableCS(iterators.get(i), null, null);
                setOffsets(iterVars[i], iterators.get(i));
            }
            forExpCS.setVariable1(iterVars[0]);
            if (iterVars.length > 1) {
                forExpCS.setVariable2(iterVars[1]);
            }
        }
        
        forExpCS.setCondition(condition);
        forExpCS.setBody(body);
        
        return forExpCS;
    }

    protected final CSTNode createSwitchExpCS(EList<SwitchAltExpCS> altExps, OCLExpressionCS elseExp) {
		SwitchExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSwitchExpCS();
		result.eSetDeliver(false);
		result.getAlternativePart().addAll(altExps);
		result.setElsePart(elseExp);
		return result;
	}

	protected final CSTNode createSwitchAltExpCS(OCLExpressionCS cond, OCLExpressionCS body) {
		SwitchAltExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSwitchAltExpCS();
		result.eSetDeliver(false);
		result.setCondition(cond);
		result.setBody(body);
		return result;
	}

	protected final CSTNode createSwitchAltExpCSDeprecated(OCLExpressionCS cond, OCLExpressionCS body) {
		SwitchAltExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSwitchAltExpCS();
		result.eSetDeliver(false);
		result.setCondition(cond);
		result.setBody(body);
        
    	int startOffset = (cond != null ? cond.getStartOffset() : (body != null ? body.getStartOffset() : -1));
    	int endOffset = (body != null ? body.getEndOffset() : (cond != null ? cond.getEndOffset() : -1));
		reportWarning(Messages.AbstractQVTParser_DeprecatedSwitchAltExp, startOffset, endOffset);

		return result;
	}

    protected final BlockExpCS createBlockExpCS(EList<OCLExpressionCS> expressions) {
        BlockExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBlockExpCS();
        result.eSetDeliver(false);
        for (OCLExpressionCS expCS : expressions) {
        	expCS.eSetDeliver(false);
        }
        result.getBodyExpressions().addAll(expressions);
        return result;
    }

    protected final CSTNode createComputeExpCS(VariableCS declarator, OCLExpressionCS body) {
        ComputeExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createComputeExpCS();
        result.eSetDeliver(false);
        result.setReturnedElement(declarator);
        result.setBody(body);
        return result;
    }

	protected final ModelTypeCS createModelTypeCS(IToken identifier, StringLiteralExpCS complianceKind, 
			EList<PackageRefCS> packageRefList, EList<StatementCS> whereList) {
		ModelTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModelTypeCS();
		result.eSetDeliver(false);
		SimpleNameCS identifierCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL,
					(identifier.getIPrsStream() == null ? null : identifier));
		identifierCS.eSetDeliver(false);
		identifierCS.setStartOffset(identifier.getStartOffset());
		identifierCS.setEndOffset(identifier.getEndOffset());
		result.setIdentifierCS(identifierCS);
		result.setComplianceKindCS(complianceKind);
		result.getPackageRefs().addAll(packageRefList);
		result.getWhereStatements().addAll(whereList);		
		return result;
	}

	protected final CSTNode createPackageRefCS(PathNameCS scopedIdentifierCS, StringLiteralExpCS uriCS) {
		PackageRefCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createPackageRefCS();
		result.setPathNameCS(scopedIdentifierCS);
		result.setUriCS(uriCS);
		return result;
	}

	protected final CSTNode createModuleKindCS(ModuleKindEnum moduleKind) {
		ModuleKindCS moduleKindCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleKindCS();
		moduleKindCS.eSetDeliver(false);
		moduleKindCS.setModuleKind(moduleKind);
		return moduleKindCS;
	}

	protected final CSTNode createModuleRefCS(PathNameCS pathNameCS, SimpleSignatureCS signature) {
		ModuleRefCS moduleRefCS = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleRefCS();
		moduleRefCS.eSetDeliver(false);
		moduleRefCS.setPathNameCS(pathNameCS);
		if (signature != null) {
	        moduleRefCS.getParameters().addAll(signature.getParams());
		}
		return moduleRefCS;
	}

	protected final CSTNode createModuleUsageCS(ImportKindEnum importKind, ModuleKindCS moduleKindCS, EList<ModuleRefCS> moduleRefs) {
		ModuleUsageCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createModuleUsageCS();
		result.eSetDeliver(false);
		result.setImportKind(importKind);
		result.setModuleKindCS(moduleKindCS);
		result.getModuleRefs().addAll(moduleRefs);
		return result;
	}

	protected final CSTNode createTransformationRefineCS(ModuleRefCS moduleRefCS) {
		TransformationRefineCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTransformationRefineCS();
		result.eSetDeliver(false);
		result.setModuleRefCS(moduleRefCS);
		return result;
	}

	protected final TransformationHeaderCS createTransformationHeaderCS(EList<SimpleNameCS> qualifiers, 
			PathNameCS pathNameCS, SimpleSignatureCS simpleSignatureCS, EList<ModuleUsageCS> transfUsages, 
			TransformationRefineCS transfRefineCS) {
		TransformationHeaderCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTransformationHeaderCS();
		result.eSetDeliver(false);
		result.getQualifiers().addAll(createQualifiersListCS(qualifiers));
		result.getParameters().addAll(simpleSignatureCS.getParams());
		result.getModuleUsages().addAll(transfUsages);
		result.setTransformationRefineCS(transfRefineCS);
		result.setPathNameCS(pathNameCS);
		return result;
	}
	
    protected ImperativeIterateExpCS createImperativeIterateExpCS(
            SimpleNameCS simpleNameCS,
            EList<VariableCS> iterators,
            VariableCS target,
            OCLExpressionCS body,
            OCLExpressionCS condition) {
        ImperativeIterateExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeIterateExpCS();
        result.eSetDeliver(false);
        result.setSimpleNameCS(simpleNameCS);
        if (iterators.size() > 0) {
            result.setVariable1(iterators.get(0));
            if (iterators.size() > 1) {
                result.setVariable2(iterators.get(1));
            }
        }
        if (target != null) {
            result.setTarget(target);
        }
        result.setBody(body);
        result.setCondition(condition);
        return result;
    }
    
    protected InstantiationExpCS createNewRuleCallExpCS(TypeSpecCS typeSpecCS, List<OCLExpressionCS> arguments) {
    	InstantiationExpCS call = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createInstantiationExpCS();
    	call.eSetDeliver(false);
		call.setTypeSpecCS(typeSpecCS);
		call.getArguments().addAll(arguments);
    	return call;
    }
    
    protected ReturnExpCS createReturnExpCS(OCLExpressionCS value) {
    	ReturnExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createReturnExpCS();
    	result.eSetDeliver(false);
    	result.setValue(value);
    	return result;
    }

    protected MappingExtensionCS createMappingExtension(String extensionKindLiteral, EList<ScopedNameCS> identifierList) {
    	MappingExtensionKindCS kind = MappingExtensionKindCS.getByName(extensionKindLiteral);
    	assert kind != null;
    	
    	MappingExtensionCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMappingExtensionCS();
    	result.eSetDeliver(false);
    	result.setKind(kind);
    	if(identifierList != null) {
    		result.getMappingIdentifiers().addAll(identifierList);
    	}
    	
    	return result;
    }

    protected final int getEndOffset(int ensuredOffset, EList<? extends CSTNode>... listOpt) {
        int offset = ensuredOffset;
        for (EList<? extends CSTNode> list : listOpt) {
            if (list.size() == 0) {
                continue;
            }
            CSTNode node = list.get(list.size()-1);
            offset = node.getEndOffset();
        }
        return offset;
    }
    
	protected final int getEndOffset(IToken token, EList<? extends CSTNode>... listOpt) {
		int offset = token.getEndOffset();
		for (EList<? extends CSTNode> list : listOpt) {
			if (list.size() == 0) {
				continue;
			}
			CSTNode node = list.get(list.size()-1);
			offset = node.getEndOffset();
		}
		return offset;
	}
	
	protected boolean isTokenOfType(IToken token, int kind) {
	    return (token != null) && (token.getKind() == kind);
	}
	
	protected EList<QualifierKindCS> createQualifiersListCS(EList<SimpleNameCS> qualifiersNames) {
		EList<QualifierKindCS> result = new BasicEList<QualifierKindCS>();
		
		for (SimpleNameCS nextQualifier : qualifiersNames) {
			QualifierKindCS nameCS = QualifierKindCS.getByName(nextQualifier.getValue());
			assert nameCS != null;
			result.add(nameCS);
		}
		return result;
	}

	protected CSTNode createRaiseExpCS(TypeCS excType, OCLExpressionCS argumentCS) {
		RaiseExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createRaiseExpCS();
		result.eSetDeliver(false);
		if (excType == null) {
			SimpleNameCS excNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "Exception");
			excNameCS.eSetDeliver(false);
			excType = createPathNameCS(excNameCS);			
		}
    	result.setException(excType);
    	result.setArgument(argumentCS);
		return result;
	}
	
	protected CSTNode createTryExpCS(BlockExpCS tryBody, EList<CatchExpCS> catchExpList) {
		TryExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTryExpCS();
		result.eSetDeliver(false);
		result.setTryBody(tryBody);
		if (catchExpList != null) {
			result.getExceptClauses().addAll(catchExpList);
		}
		return result;
	}
	
	protected CSTNode createCatchExpCS(IToken nameToken, EList<TypeCS> exceptionTypeList, BlockExpCS body) {
		CatchExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createCatchExpCS();
		result.eSetDeliver(false);
		result.setBody(body);
		if (nameToken != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, nameToken);
			nameCS.eSetDeliver(false);
			setOffsets(nameCS, nameToken);
			result.setSimpleNameCS(nameCS);
		}		
		if (exceptionTypeList != null) {
			result.getExceptions().addAll(exceptionTypeList);
		}			
		return result;
	}	
	
	protected CSTNode createIntermediateClassDefCS(IToken nameToken, EList<TypeCS> extentionList, EList<CSTNode> featureList) {
		IntermediateClassDefCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createIntermediateClassDefCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, nameToken);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, nameToken);
		result.setSimpleNameCS(nameCS);
		result.getExtends().addAll(extentionList);
		
		for (CSTNode nodeCS : featureList) {
			if (nodeCS instanceof ClassifierPropertyCS) {
				result.getProperties().add((ClassifierPropertyCS) nodeCS);
			}
			if (nodeCS instanceof TagCS) {
				result.getTags().add((TagCS) nodeCS);
			}
		}
		
		return result;
	}

	protected CSTNode createExceptionDefCS(IToken nameToken, EList<TypeCS> extentionList, EList<CSTNode> featureList) {
		ExceptionDefCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createExceptionDefCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, nameToken);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, nameToken);
		result.setSimpleNameCS(nameCS);
		result.getExtends().addAll(extentionList);
		
		for (CSTNode nodeCS : featureList) {
			if (nodeCS instanceof ClassifierPropertyCS) {
				result.getProperties().add((ClassifierPropertyCS) nodeCS);
			}
			if (nodeCS instanceof TagCS) {
				result.getTags().add((TagCS) nodeCS);
			}
		}
		
		return result;
	}

	
	protected CSTNode createClassifierPropertyCS(EList<IToken> stereotypeQualifieres, EList<SimpleNameCS> featureKeys,
			IToken nameToken, TypeCS typeSpecCS, boolean isOrdered, OCLExpressionCS initPartCS, MultiplicityDefCS multiplicityDefCS,
			OppositePropertyCS oppositePropertyCS) {
		ClassifierPropertyCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createClassifierPropertyCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, nameToken);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, nameToken);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(typeSpecCS);
		result.setOclExpressionCS(initPartCS);
		result.setIsOrdered(isOrdered);
		result.setMultiplicity(multiplicityDefCS);
		result.setOpposite(oppositePropertyCS);
		result.getFeatureKeys().addAll(featureKeys);
		for (IToken token : stereotypeQualifieres) {
			SimpleNameCS stereotypeQualifierCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, token);
			stereotypeQualifierCS.eSetDeliver(false);
			setOffsets(stereotypeQualifierCS, token);
			result.getStereotypeQualifiers().add(stereotypeQualifierCS);
		}
		return result;
	}

	protected CSTNode createMultiplicityDefCS(PrimitiveLiteralExpCS lowerBound, PrimitiveLiteralExpCS upperBound) {
		MultiplicityDefCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createMultiplicityDefCS();
		result.eSetDeliver(false);
		result.setLowerBound(lowerBound);
		result.setUpperBound(upperBound);
		return result;
	}

	protected CSTNode createOppositePropertyCS(IToken nameToken, boolean isNavigable, MultiplicityDefCS multiplicityCS) {
		OppositePropertyCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createOppositePropertyCS();
		result.eSetDeliver(false);
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, nameToken);
		nameCS.eSetDeliver(false);
		setOffsets(nameCS, nameToken);
		result.setSimpleNameCS(nameCS);
		result.setIsNavigable(isNavigable);
		result.setMultiplicity(multiplicityCS);
		return result;
	}

	protected ListTypeCS createListTypeCS(TypeCS typeCS) {
		ListTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListTypeCS();
		result.eSetDeliver(false);
		result.setTypeCS(typeCS);
		return result;
	}

	protected ListLiteralExpCS createListLiteralExpCS(EList<CollectionLiteralPartCS> collectionLiteralParts) {
		ListLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListLiteralExpCS();
		result.eSetDeliver(false);
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	protected DictionaryTypeCS createDictTypeCS(TypeCS keyTypeCS, TypeCS valueTypeCS) {
		DictionaryTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictionaryTypeCS();
		result.eSetDeliver(false);
		result.setKey(keyTypeCS);
		result.setValue(valueTypeCS);
		return result;
	}	
	
	protected DictLiteralExpCS createDictLiteralExpCS(EList<DictLiteralPartCS> parts) {		
		DictLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralExpCS();
		result.eSetDeliver(false);
		result.getParts().addAll(parts);
		return result;
	}
	
	protected DictLiteralPartCS createDictLiteralPartCS(LiteralExpCS keyLiteralCS, OCLExpressionCS valueExpCS) {
		DictLiteralPartCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralPartCS();
		result.eSetDeliver(false);
		result.setKey(keyLiteralCS);
		result.setValue(valueExpCS);
		return result;
	}
	
	protected VariableCS getVariableFromAssignment(AssignStatementCS assignStatementCS) {
		if(assignStatementCS.isIncremental()) {
			reportError(Messages.InvalidAdditiveAssignmentUsage, assignStatementCS.getStartOffset(), assignStatementCS.getEndOffset());			
		}
		
		OCLExpressionCS lValueCS = assignStatementCS.getLValueCS();
		if (lValueCS instanceof VariableExpCS) {
			VariableExpCS variableExpCS = (VariableExpCS) lValueCS;
			SimpleNameCS simpleNameCS = variableExpCS.getSimpleNameCS();
			if (simpleNameCS.getType() == SimpleTypeEnum.IDENTIFIER_LITERAL) { 
				VariableCS variableCS = createVariableCS(simpleNameCS, null, assignStatementCS.getOclExpressionCS());
				variableCS.setStartOffset(lValueCS.getStartOffset());
				variableCS.setEndOffset(lValueCS.getEndOffset());				
				return variableCS;
			}
		}

		reportError(Messages.IdentifierExpectedOnLeftSide, lValueCS.getStartOffset(), lValueCS.getEndOffset());

		return createVariableCS(new Token() {
					@Override
					public String toString() {
						return "error_var"; //$NON-NLS-1$
					}
				},
				null, assignStatementCS.getOclExpressionCS());
	}
	
	protected CSTNode createTagCS(StringLiteralExpCS tagId, ScopedNameCS scopedIdentifier, OCLExpressionCS tagValue) {
		TagCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTagCS();
		result.eSetDeliver(false);
		result.setName(tagId);
		result.setScopedNameCS(scopedIdentifier);
		result.setOclExpressionCS(tagValue);
		
		return result;
	}
	
	protected final ConstructorCS createConstructorCS(MappingDeclarationCS methodDecl, BlockExpCS bodyCS) {
		ConstructorCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createConstructorCS();
		result.eSetDeliver(false);
		result.setMappingDeclarationCS(methodDecl);
		result.setBody(bodyCS);
		return result;
	}

	protected final StatementCS createBreakCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBreakExpCS();
		result.eSetDeliver(false);
		return result;
	}

	protected final StatementCS createContinueCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContinueExpCS();
		result.eSetDeliver(false);
		return result;
	}

	protected PathNameCS createPathNameCS(IToken token) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.eSetDeliver(false);
		SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, token);
		simpleNameCS.eSetDeliver(false);
		setOffsets(simpleNameCS, token);
		result.getSimpleNames().add(simpleNameCS);
		return result;
	}
	
	@Override
	protected PathNameCS createPathNameCS(SimpleNameCS name) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.eSetDeliver(false);
		name.eSetDeliver(false);
		result.getSimpleNames().add(name);
		return result;
	}

	protected PathNameCS extendPathNameCS(PathNameCS path, IToken token) {
		SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, token);
		simpleNameCS.eSetDeliver(false);
		setOffsets(simpleNameCS, token);

		path.eSetDeliver(false);
		path.getSimpleNames().add(simpleNameCS);
		return path;
	}
	
	protected VariableCS createVariableCS(IToken token, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.eSetDeliver(false);
		result.setName(unSingleQuote(token));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, final String name) {
		return super.createSimpleNameCS(type, new Token() {
			@Override
			public String toString() {
				return name;
			}
		});
	}
	
	@Override
	protected StringLiteralExpCS extendStringLiteralExpCS(StringLiteralExpCS string, IToken token) {

		int tokenLine = token.getLine();
		IToken prevToken = getIPrsStream().getIToken(token.getTokenIndex() - 1);
		int prevTokenLine = prevToken.getLine();
		if (prevTokenLine == tokenLine) {
			reportError("Multiline string literals must be located in different lines!",  //$NON-NLS-1$
					prevToken.getStartOffset(), token.getEndOffset());
		}

		return super.extendStringLiteralExpCS(string, token);
	}
	
	@Override
	protected String unSingleQuote(String quoted) {
		int quotedLength = quoted.length();
		if ((quotedLength >= 2) && (quoted.charAt(0) == '"') && (quoted.charAt(quotedLength-1) == '"')) {
			return quoted.substring(1, quotedLength-1);
		}
		else {
			return super.unSingleQuote(quoted);
		}
	}
	
	@Override
	protected void setOffsets(CSTNode cstNode, IToken startEnd) {
		super.setOffsets(cstNode, startEnd);
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		super.setOffsets(cstNode, startEnd);
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		super.setOffsets(cstNode, start, end);
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		super.setOffsets(cstNode, start, end);
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		if (end == null) {
			super.setOffsets(cstNode, start);
		}
		else {
			super.setOffsets(cstNode, start, end);
		}
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		super.setOffsets(cstNode, start, end);
		
		if(!isCSTTokenEnabled) {
			cstNode.setStartToken(null);
			cstNode.setEndToken(null);
		}
	}

	@Override
	protected boolean isNonStdSQSupported() {
		return false;
	}
	
	private void validateTopLevelElementOrder(EList<CSTNode> topElements) {		
		boolean otherThenImportOccured = false;
		boolean moduleAlreadyDeclared = false;		

		for (CSTNode nextElement : topElements) {
			if(nextElement instanceof MappingModuleCS) {
				moduleAlreadyDeclared = true;
				continue;
			}
			
			if(nextElement instanceof ImportCS) {
				if(otherThenImportOccured) {				
					reportWarning(Messages.ImportMustBeFirstInCompilationUnit, 
							nextElement.getStartOffset(), nextElement.getEndOffset());
				}
			} else {
				otherThenImportOccured = true;
			}
			
			if(!moduleAlreadyDeclared) {
				if(nextElement instanceof ModulePropertyCS) {
					ModulePropertyCS propertyCS = (ModulePropertyCS) nextElement; 
					CSTNode problemCS = propertyCS.getSimpleNameCS() != null ? propertyCS.getSimpleNameCS() : propertyCS; 
					reportWarning(Messages.ModuleDeclarationMustPrecedeThisElement, 
							problemCS.getStartOffset(), problemCS.getEndOffset());				
				}
				else if(nextElement instanceof MappingMethodCS) {
					MappingMethodCS methodCS = (MappingMethodCS) nextElement;
					CSTNode problemCS = methodCS.getMappingDeclarationCS() != null ? methodCS.getMappingDeclarationCS() : methodCS;				
					reportWarning(Messages.ModuleDeclarationMustPrecedeThisElement,
							problemCS.getStartOffset(), problemCS.getEndOffset());				
				}
				else if(nextElement instanceof ClassifierDefCS) {
					ClassifierDefCS classifierCS = (ClassifierDefCS) nextElement; 
					CSTNode problemCS = classifierCS.getSimpleNameCS() != null ? classifierCS.getSimpleNameCS() : classifierCS; 
					reportWarning(Messages.ModuleDeclarationMustPrecedeThisElement,
							problemCS.getStartOffset(), problemCS.getEndOffset());				
				}
			}
		} 
	}	
}
