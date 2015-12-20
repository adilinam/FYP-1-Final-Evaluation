/*******************************************************************************
 * Copyright (c) 2008, 2015 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - Bug 388331 
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lpg.runtime.IToken;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtEnvironmentBase;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalFileEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtKeywords;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.TypeExp;
import org.eclipse.ocl.ecore.VoidType;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.swt.graphics.Image;

/**
 * @author aigdalov
 */

public class CompletionProposalUtil {
    private static final int[] PREDEFINED_TYPES = {
        QVTOParsersym.TK_OclAny,
        QVTOParsersym.TK_OclVoid,
        QVTOParsersym.TK_OclInvalid,
        QVTOParsersym.TK_Boolean,
        QVTOParsersym.TK_Integer,
        QVTOParsersym.TK_UnlimitedNatural,
        QVTOParsersym.TK_Real,
        QVTOParsersym.TK_String,
        QVTOParsersym.TK_Collection,
        QVTOParsersym.TK_Set,
        QVTOParsersym.TK_OrderedSet,
        QVTOParsersym.TK_Bag,
        QVTOParsersym.TK_Sequence
    };
    
    private static final int[] PREDEFINED_INSTANCES = {
        QVTOParsersym.TK_null,
        QVTOParsersym.TK_invalid,
        QVTOParsersym.TK_true,
        QVTOParsersym.TK_false
    };
    
    private static final int[] RVALUE_TERMINALS = {
        QVTOParsersym.TK_if,
        QVTOParsersym.TK_let,
        QVTOParsersym.TK_not,
        QVTOParsersym.TK_object,
        QVTOParsersym.TK_while,
        QVTOParsersym.TK_late,
        QVTOParsersym.TK_resolveIn,
        QVTOParsersym.TK_resolveoneIn,
        QVTOParsersym.TK_invresolveIn,
        QVTOParsersym.TK_invresolveoneIn
    };
    
    public static final void addRValues(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        CompletionProposalUtil.addVariables(proposals, data);
        CompletionProposalUtil.addModuleFeatures(proposals, data);
        //CompletionProposalUtil.addOperations(proposals, data.getEnvironment().getQVTStandartLibrary().getStdLibModule(), data);
        CompletionProposalUtil.addModuleOperations(proposals, data);
        CompletionProposalUtil.addAllTypes(proposals, data);
        CompletionProposalUtil.addKeywords(proposals, PREDEFINED_INSTANCES, data);
        CompletionProposalUtil.addKeywords(proposals, RVALUE_TERMINALS, data);
    }
    
    public static final void addContextProposals(Collection<ICompletionProposal> proposals, EClassifier owner, 
    		boolean addResolveFamily, boolean isImplicitSource, QvtCompletionData data) {
        CompletionProposalUtil.addStructuralFeatures(proposals, owner, data);
        CompletionProposalUtil.addOperations(proposals, owner, data);
        CompletionProposalUtil.addKeywords(proposals, LightweightParserUtil.MAPPING_CALL_TERMINALS, data);
        if (owner instanceof CollectionType) {
            CompletionProposalUtil.addKeywords(proposals, LightweightParserUtil.FOR_EXP_TERMINALS, data);
            CompletionProposalUtil.addKeywords(proposals, LightweightParserUtil.QVTO_ITERATOR_TERMINALS, data);
        }
        if (addResolveFamily) {
            CompletionProposalUtil.addKeyword(proposals, QVTOParsersym.TK_late, data);
            int[] resolveTerminals = isImplicitSource ? LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS : LightweightParserUtil.RESOLVE_FAMILY_TERMINALS; 
            CompletionProposalUtil.addKeywords(proposals, resolveTerminals, data);
        }
    }
    
    public static final void addKeyword(Collection<ICompletionProposal> proposals, int keyword, QvtCompletionData data) {
        QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(LightweightParserUtil.getTokenText(keyword), CategoryImageConstants.KEYWORD, data);
        CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
    }
    
    public static final void addKeywords(Collection<ICompletionProposal> proposals, int[] keywords, QvtCompletionData data) {
        for (int keyword : keywords) {
            addKeyword(proposals, keyword, data);
        }
    }
    
    public static final void addProposalIfNecessary(Collection<ICompletionProposal> proposals, QvtCompletionProposal info, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
		if (currentToken != null) {
            int len = data.getOffset() - currentToken.getStartOffset();
            String startText = currentToken.toString().substring(0, len);
            String replacementString = info.getReplacementString();
            if ((replacementString.equals(startText)) // replacement is useless
                    || !replacementString.toUpperCase().startsWith(startText.toUpperCase())) {
                return;
            }
        }
        proposals.add(info);
    }
    
    public static final void addAllTypes(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        addModelTypes(proposals, data);
        for (int predefinedType : PREDEFINED_TYPES) {
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(QVTOParsersym.orderedTerminalSymbols[predefinedType], CategoryImageConstants.TYPE, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }
    
    public static final void addModelTypes(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        for (ModelType modelType : data.getEnvironment().getModelTypeRegistry().values()) {
            if ((modelType.getName() != null) && (modelType.getName().trim().length() != 0)) {
                QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(modelType, data);
                CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
            }
        }
        for (Map.Entry<String, Object> entry : data.getEnvironment().getEPackageRegistry().entrySet()) {
            Object pack = entry.getValue();
            if (pack instanceof EPackage) {
                QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal((EPackage) pack, data);
                CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
            }
        }
        for (ModelType modelType : data.getEnvironment().getModelTypeRegistry().values()) {
            List<EPackage> metamodels = modelType.getMetamodel();
            for (EPackage pack : metamodels) {
                addPackageContentsProposals(proposals, data, pack);
            }
        }
    }
    
    public static final void addPackageContentsProposals(Collection<ICompletionProposal> proposals, QvtCompletionData data, EPackage pack) {
        for (EClassifier classifier : pack.getEClassifiers()) {
            String imageCategory;
            String classifierName = classifier.getName();
            if (classifier instanceof EClass) {
                imageCategory = CategoryImageConstants.CLASS;
                classifierName = escapeNameIfNecessary(classifierName);
            } else if (classifier instanceof EEnum) {
                imageCategory = CategoryImageConstants.ENUM;
            } else if (classifier instanceof EDataType) {
                imageCategory = CategoryImageConstants.DATATYPE;
            } else {
                imageCategory = CategoryImageConstants.CLASSIFIER;
            }
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(classifierName, imageCategory, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
        for (EPackage subPack : pack.getESubpackages()) {
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(subPack.getName(), CategoryImageConstants.PACKAGE, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }    
    
    public static final void addVariables(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        QvtOperationalEnv env = data.getEnvironment();
		Variable<EClassifier, EParameter> selfVariable = env.lookup(QvtOperationalEnv.SELF_VARIABLE_NAME);
        if ((selfVariable != null) && !(selfVariable.getType() instanceof VoidType)) {
        	QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(selfVariable, data);
            addProposalIfNecessary(proposals, info, data);
        }
        for (Variable<EClassifier, EParameter> variable : env.getVariables()) {
            String name = variable.getName();            
			if ((name != null) && (name.trim().length() > 0) && !name.startsWith(QvtEnvironmentBase.GENERATED_NAME_SPECIAL_PREFIX)) {
            	QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(variable, data);
                addProposalIfNecessary(proposals, info, data);
            }
        }
    }
    
    public static final void addStructuralFeatures(Collection<ICompletionProposal> proposals, EClassifier owner, QvtCompletionData data) {
        List<EStructuralFeature> attributes = TypeUtil.getAttributes(data.getEnvironment(), owner);
        for (EStructuralFeature structuralFeature : attributes) {
        	QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(structuralFeature, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }
    
    public static final void addOperations(Collection<ICompletionProposal> proposals, EClassifier owner, QvtCompletionData data) {
        List<EOperation> operations = CompletionProposalUtil.getOperations(owner, data.getEnvironment());
        addOperationsInternal(operations, proposals, data);
    }

    public static final void addModuleOperations(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        MappingMethodCS[] allImperativeOperationsCS = data.getAllImperativeOperationsCS();
        for (MappingMethodCS mappingMethodCS : allImperativeOperationsCS) {
            MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
            if (mappingDeclarationCS != null) {
                TypeCS contextTypeCS = mappingDeclarationCS.getContextType();
                if (contextTypeCS == null) {
                    QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(mappingMethodCS, data);
                    CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
                }
            }
        }
                
        List<Module> allLibs = getNativeLibraries(data);
        for (Module module : allLibs) {
        	for (EOperation nextLibOper : TypeUtil.getOperations(data.getEnvironment(), module)) {
        		if(data.getEnvironment().getUMLReflection().getOwningClassifier(nextLibOper) == module) {
        			QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(nextLibOper, data);
        			CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        		}
			}
		}
    }
    
    private static List<Module> getNativeLibraries(QvtCompletionData data) {
    	List<Module> result = new LinkedList<Module>();
    	
    	Collection<QvtEnvironmentBase> imports = new LinkedHashSet<QvtEnvironmentBase>();
    	imports.addAll(data.getEnvironment().getImportsByExtends());
    	imports.addAll(data.getEnvironment().getImportsByAccess());    	
    	
		for (Object sibling : imports) {
    		if(sibling instanceof QvtOperationalModuleEnv) {
    			if(sibling instanceof QvtOperationalFileEnv) {
    				// parsed concrete syntax from a file
    				continue;
    			}
    			Module module = ((QvtOperationalModuleEnv)sibling).getModuleContextType();
    			result.add(module);
    		}
		}    	    	
    	return result;
    }
    
    public static final void addAllContextlessMappings(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        MappingMethodCS[] allImperativeOperationsCS = data.getAllImperativeOperationsCS();
        for (MappingMethodCS mappingMethodCS : allImperativeOperationsCS) {
            if (mappingMethodCS instanceof MappingRuleCS) {
                MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
                if (mappingDeclarationCS != null) {
                    TypeCS contextTypeCS = mappingDeclarationCS.getContextType();
                    if (contextTypeCS == null) {
                        QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(mappingMethodCS, data);
                        CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
                    }
                }
            }
        }
    }

    public static final void addModuleFeatures(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        MappingModuleCS[] allMappingModulesCS = data.getAllMappingModulesCS();
        for (MappingModuleCS mappingModuleCS : allMappingModulesCS) {
            Module module = (Module) ASTBindingHelper.resolveASTNode(mappingModuleCS);
            if(module != null) {
            	addStructuralFeatures(proposals, module, data);
            }
        } 
    }

    public static final void addMappingOperations(Collection<ICompletionProposal> proposals, EClassifier owner, QvtCompletionData data) {
        List<EOperation> operations = CompletionProposalUtil.getMappingOperations(owner, data.getEnvironment());
        addOperationsInternal(operations, proposals, data);
    }

    public static final void addOperationsInternal(List<EOperation> operations, Collection<ICompletionProposal> proposals, QvtCompletionData data) {
    	SKIP:
        for (EOperation operation : operations) {
        	if (isGenericCommonT(operation.getEType(), data.getEnvironment())) {
        		continue;
        	}
        	if (!KNOW_FUNCTIONS_WITH_T2_PARAM.contains(operation.getName())) {
	        	for (EParameter param : operation.getEParameters()) {
	            	if (isGenericT2(param.getEType(), data.getEnvironment())) {
	            		continue SKIP;
	            	}
	        	}
        	}
        	
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(operation, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }

	private static boolean isGenericT2(EClassifier eType, QvtOperationalEnv env) {
		if (eType instanceof CollectionType) {
			return isGenericT2(((CollectionType) eType).getElementType(), env);
		}
		return eType == env.getOCLStandardLibrary().getT2();
	}
    
	private static boolean isGenericCommonT(EClassifier eType, QvtOperationalEnv env) {
		if (eType instanceof CollectionType) {
			return isGenericCommonT(((CollectionType) eType).getElementType(), env);
		}
		return eType == env.getQVTStandardLibrary().getCommonT();
	}
    
    public static final QvtCompletionProposal createCompletionProposal(EStructuralFeature structuralFeature, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
		int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String proposalString = escapeNameIfNecessary(structuralFeature.getName()); 
        if (proposalString == null) {
            proposalString = "null"; //$NON-NLS-1$
        }
        String type = getTypeNameAndMultiplicity(structuralFeature);
        String displayString = proposalString + " : " + type;  //$NON-NLS-1$
        Image image = structuralFeature.isChangeable() ?
                CompletionProposalUtil.getImage(CategoryImageConstants.PROPERTY)
                : CompletionProposalUtil.getImage(CategoryImageConstants.PROPERTY, CategoryImageConstants.READONLY);
        return new QvtCompletionProposal(proposalString,
                replacementOffset,
                replacementLength,
                proposalString.length(),
                image,
                displayString,
                null,
                null);
    }
    
    public static final QvtCompletionProposal createCompletionProposal(Variable<EClassifier, EParameter> variable, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
		int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String proposalString = variable.getName();
        String displayString = proposalString;
        if (variable.getType() != null) {
            displayString += " : " + QvtOperationalTypesUtil.getTypeName(variable.getType());  //$NON-NLS-1$
        }
        Image image = CompletionProposalUtil.getImage(CategoryImageConstants.VARIABLE);
        return new QvtCompletionProposal(variable.getName(),
                replacementOffset,
                replacementLength,
                variable.getName().length(),
                image,
                displayString,
                null,
                null);
    }
    
    public static final QvtCompletionProposal createCompletionProposal(EOperation operation, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
        int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String proposalString = operation.getName(); 
        StringBuilder parametersStringBuilder = new StringBuilder(); 
        for (EParameter parameter : operation.getEParameters()) {
            if (parametersStringBuilder.length() != 0) {
                parametersStringBuilder.append(", "); //$NON-NLS-1$
            }
            parametersStringBuilder.append(parameter.getName());
            parametersStringBuilder.append(" : "); //$NON-NLS-1$
            parametersStringBuilder.append(getTypeNameAndMultiplicity(parameter));
        }

        String displayString = proposalString + "(" + parametersStringBuilder + ")";  //$NON-NLS-1$ //$NON-NLS-2$
        if (operation.getEType() != null) {
            displayString += " : " + getTypeNameAndMultiplicity(operation); //$NON-NLS-1$
        }

        Image image = null;
        if (QvtOperationalUtil.isMappingOperation(operation)) {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.MAPPING);
        } else if (QvtOperationalUtil.isImperativeOperation(operation)) {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.IMPERATIVE_OPERATION);
        } else {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.OPERATION);
        }
        String replacementString = operation.getName() + "()"; //$NON-NLS-1$
        int cursorPosition = operation.getEParameters().isEmpty() ? replacementString.length()
                : replacementString.length() - 1; 
        return new QvtCompletionProposal(replacementString,
                replacementOffset,
                replacementLength,
                cursorPosition,
                image,
                displayString,
                null,
                null);
    }

    public static final QvtCompletionProposal createCompletionProposal(MappingMethodCS mappingMethodCS, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
        int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
        String methodName = mappingDeclarationCS.getSimpleNameCS().getValue();
        
        MappingModuleCS mappingModuleCS = (MappingModuleCS) mappingMethodCS.eContainer();
        CFileData cFileData = data.getQvtCompiler().getCFileData(mappingModuleCS);
        String lightweightScript = cFileData.getLightweightScript();
        String displayString = lightweightScript.substring(mappingDeclarationCS.getSimpleNameCS().getStartOffset(), mappingDeclarationCS.getEndOffset() + 1);

        Image image = null;
        if (mappingMethodCS instanceof MappingRuleCS) {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.MAPPING);
        } else if (mappingMethodCS instanceof MappingQueryCS) {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.IMPERATIVE_OPERATION);
        } else {
            image = CompletionProposalUtil.getImage(CategoryImageConstants.OPERATION);
        }
        String replacementString = methodName + "()"; //$NON-NLS-1$
        int cursorPosition = mappingDeclarationCS.getParameters().isEmpty() ? replacementString.length()
                : replacementString.length() - 1; 
        return new QvtCompletionProposal(replacementString,
                replacementOffset,
                replacementLength,
                cursorPosition,
                image,
                displayString,
                null,
                null);
    }

    public static QvtCompletionProposal createCompletionProposal(ModelType modelType, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
        int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String proposalString = modelType.getName(); 
        Image image = CompletionProposalUtil.getImage(CategoryImageConstants.MODELTYPE);
        return new QvtCompletionProposal(proposalString,
                replacementOffset,
                replacementLength,
                proposalString.length(),
                image,
                proposalString,
                null,
                null);
    }
    
    public static QvtCompletionProposal createCompletionProposal(EPackage pack, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
        int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String proposalString = pack.getName(); 
        Image image = CompletionProposalUtil.getImage(CategoryImageConstants.PACKAGE);
        return new QvtCompletionProposal(proposalString,
                replacementOffset,
                replacementLength,
                proposalString.length(),
                image,
                proposalString,
                null,
                null);
    }
    
    public static final QvtCompletionProposal createCompletionProposal(String proposalString, String category, QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
		int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        Image image = CompletionProposalUtil.getImage(category);
        return new QvtCompletionProposal(proposalString,
                replacementOffset,
                replacementLength,
                proposalString.length(),
                image,
                proposalString,
                null,
                null);
    }

    public static final ImageDescriptor getImageDescriptor(final String key) {
        ImageDescriptor descriptor = getImageRegistry().getDescriptor(key);
        if (descriptor == null) {
            ImageDescriptor id = imageDescriptorFromPlugin("icons/" + key + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$
            getImageRegistry().put(key, id);
            return getImageRegistry().getDescriptor(key);
        }
        return descriptor;
    }
    
    // workaround for OclVoid
    public static final List<EOperation> getOperations(EClassifier owner, QvtOperationalEnv env) {
        Collection<EOperation> rawOperations = getAllOperations(owner, env);
        List<EOperation> operations = new ArrayList<EOperation>();
        for (EOperation operation : rawOperations) {
            // removing unnecessary allInstances()
            if (!PredefinedType.ALL_INSTANCES_NAME.equals(operation.getName())) {
                operations.add(operation);
            }
        }
        EClassifier resolvedOwnerType = TypeUtil.resolveType(env, owner);
        if (resolvedOwnerType instanceof Module == false) {        
            if (!(resolvedOwnerType instanceof CollectionType)) {
                // adding a single allInstances() operation
                operations.add(buildAllInstancesOperation(env));
            }
            return operations;
        }
        return operations;
    }
    
    public static final List<EOperation> getMappingOperations(EClassifier owner, QvtOperationalEnv env) {
        List<EOperation> operations = getOperations(owner, env);
        List<EOperation> result = new ArrayList<EOperation>();
        for (EOperation operation : operations) {
            if (QvtOperationalUtil.isMappingOperation(operation)) {
                result.add(operation);
            }
        }
        return result;
    }
    
    public static final Image getImage(String key) {
        Image image = getImageRegistry().get(key);
        if (image == null) {
            ImageDescriptor id = imageDescriptorFromPlugin("icons/" + key + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$
            getImageRegistry().put(key, id);
            return getImageRegistry().get(key);
        }
        return image;
    }
    
    public static final Image getImage(String imageKey, String decoratorKey) {
        String key = imageKey + decoratorKey;
        Image image = getImageRegistry().get(key);
        if (image == null) {
            Image baseImage = getImage(imageKey);
            ImageDescriptor decoratorId = imageDescriptorFromPlugin("icons/" + decoratorKey + ".gif"); //$NON-NLS-1$ //$NON-NLS-2$
            DecorationOverlayIcon decoratedIconId = new DecorationOverlayIcon(baseImage, decoratorId, IDecoration.BOTTOM_RIGHT);
            getImageRegistry().put(key, decoratedIconId);
            return getImageRegistry().get(key);
        }
        return image;
    }
    
    public static final void addAllMappingNamesProposals(Collection<ICompletionProposal> proposals, QvtCompletionData data, 
            EClassifier owner, boolean longForm, boolean withContextOnly, boolean withResultOnly) {
        List<String> mappingNames = CompletionProposalUtil.getAllMappingNames(data, owner, longForm, withContextOnly, withResultOnly);
        for (String mapping : mappingNames) {
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(mapping, CategoryImageConstants.MAPPING, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }

    public static final List<String> getAllMappingNames(QvtCompletionData data, EClassifier owner, boolean longForm, boolean withContextOnly, boolean withResultOnly) {
        EClassifier resolvedOwner = (owner == null) ? null : TypeUtil.resolveType(data.getEnvironment(), owner);
        List<String> mappingNames = new ArrayList<String>();
        for (MappingMethodCS methodCS : data.getAllImperativeOperationsCS()) {
            if (methodCS instanceof MappingRuleCS) {
                MappingDeclarationCS declarationCS = methodCS.getMappingDeclarationCS();
                if (withContextOnly 
                        && (declarationCS.getContextType() == null)) {
                    continue;
                }
                if (withResultOnly 
                        && (declarationCS.getResult().isEmpty())) {
                    continue;
                }
                TypeCS contextTypeCS = declarationCS.getContextType();
                if (resolvedOwner != null) {
                    if (contextTypeCS == null) {
                        continue;
                    }
                    OCLExpression<EClassifier> contextType = LightweightParserUtil.getOclExpression(contextTypeCS, data);
                    if (!(contextType instanceof TypeExp)) {
                        continue;
                    }
                    EClassifier resolvedContextType = TypeUtil.resolveType(data.getEnvironment(), ((TypeExp) contextType).getReferredType());
                    if (!resolvedOwner.equals(resolvedContextType)) {
                        continue;
                    }
                }
                StringBuilder sb = new StringBuilder();
                if (contextTypeCS instanceof PathNameCS) {
                    if (longForm) {
                        PathNameCS pathNameCS = (PathNameCS) contextTypeCS;
                        for (SimpleNameCS name : pathNameCS.getSimpleNames()) {
                            sb.append(name.getValue());
                            sb.append("::"); //$NON-NLS-1$
                        }
                    }
                }
                String shortName = declarationCS.getSimpleNameCS().getValue();
                sb.append(shortName);
                String mappingName = sb.toString();
                if (!mappingNames.remove(mappingName)) { // overloaded mappings cannot be used in ResolveInExp
                    mappingNames.add(mappingName);
                }
            }
        }
        return mappingNames;
    }
    
    private static ImageDescriptor imageDescriptorFromPlugin(String imageFilePath) {
        return Activator.imageDescriptorFromPlugin(Activator.getDefault().getBundle().getSymbolicName(), imageFilePath);
    }

    private static ImageRegistry getImageRegistry() {
        return Activator.getDefault().getImageRegistry();
    }
    
    private static String getTypeNameAndMultiplicity(ETypedElement typedElement) {
        if (typedElement.getEType() == null) {
            return "?"; //$NON-NLS-1$
        }
        String elementType = QvtOperationalTypesUtil.getTypeName(typedElement.getEType());
        if (typedElement.isMany()) {
            String collectionType;
            if (typedElement.isUnique()) {
                collectionType = typedElement.isOrdered() ? OrderedSetType.SINGLETON_NAME : SetType.SINGLETON_NAME;
            } else {
                collectionType = typedElement.isOrdered() ? SequenceType.SINGLETON_NAME : BagType.SINGLETON_NAME;
            }
            return collectionType + '(' + QvtOperationalTypesUtil.getTypeName(typedElement.getEType()) + ')';
        }
        return elementType;
    }
    
    private static Collection<EOperation> getAllOperations(EClassifier owner, QvtOperationalEnv env) {
        Set<EOperation> result = new LinkedHashSet<EOperation>(TypeUtil.getOperations(env, owner));
        if (owner instanceof CollectionType) {
            CollectionType collType = (CollectionType) owner;
            
            result.addAll(collType.oclIterators());
        }
        
        for (Iterator<EOperation> it = result.iterator(); it.hasNext();) {
			EOperation op = it.next();
			if(isFilteredOutPredefinedOperation(op)) {
				it.remove();
			}
		}
        
        return result;
    }
    
    private static EOperation buildAllInstancesOperation(QvtOperationalEnv env) {
        OCLStandardLibrary<EClassifier> oclStdLib = env.getOCLStandardLibrary();
        EOperation result = EcoreFactory.eINSTANCE.createEOperation();
        
        result.setName(PredefinedType.ALL_INSTANCES_NAME);
        result.setEType(oclStdLib.getSet());
        
        EParameter param = EcoreFactory.eINSTANCE.createEParameter();
        EClassifier oclType = oclStdLib.getOclType();
        param.setName(oclType.getName());
        param.setEType(oclType);

        result.getEParameters().add(param);
        return result;
    }
    
    private static String escapeNameIfNecessary(String name) {
        if (QvtKeywords.isKeyword(name)) {
            return '_' + name;
        }
        return name;
    }
    
    private static boolean isFilteredOutPredefinedOperation(EOperation operation) {
    	String name = operation.getName();
    	if(name != null) {
    		int code = OCLStandardLibraryUtil.getOperationCode(name);
    		switch (code) {
			case PredefinedType.LESS_THAN :
			case PredefinedType.LESS_THAN_EQUAL :
			case PredefinedType.GREATER_THAN :
			case PredefinedType.GREATER_THAN_EQUAL :
				return true;
			}
    		return false;
    	}
    	return true;
    }
    
    private static final Set<String> KNOW_FUNCTIONS_WITH_T2_PARAM = new HashSet<String>(Arrays.asList(PredefinedType.PRODUCT_NAME));

}
