/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalTypesUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.swt.graphics.Image;

public class QvtOutlineLabelProvider implements ILabelProvider {
	
	public static final String TAGS_NODE = "tags"; //$NON-NLS-1$
    public static final String METAMODELS_NODE = "metamodels"; //$NON-NLS-1$
    public static final String IMPORTS_NODE = "imports"; //$NON-NLS-1$
    public static final String PROPERTIES_NODE = "properties"; //$NON-NLS-1$
    public static final String LIBRARY_NODE = "library"; //$NON-NLS-1$
    
    
    
	public QvtOutlineLabelProvider() {
	}
	
    public Image getImage(Object element) {
    	OutlineNode node = (OutlineNode)element;
    	switch (node.getType()) {
			case QvtOutlineNodeType.IMPORTED_METAMODELS:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.IMPORTED_MODULES:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.METAMODEL:
				return CompletionProposalUtil.getImage(CategoryImageConstants.PACKAGE);
				
			case QvtOutlineNodeType.TYPE:	
			case QvtOutlineNodeType.MAPPING_MODULE:
				return CompletionProposalUtil.getImage(CategoryImageConstants.CLASS);
				
			case QvtOutlineNodeType.UNIT:
				return CompletionProposalUtil.getImage(CategoryImageConstants.QVT_SRC_FILE);				
			case QvtOutlineNodeType.TAGS:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.TAG:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPDECL);
			case QvtOutlineNodeType.PROPERTIES:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPCONT);
			case QvtOutlineNodeType.PROPERTY:
				return CompletionProposalUtil.getImage(CategoryImageConstants.PROPERTY);
			case QvtOutlineNodeType.MAPPING_RULE: {				
				CSTNode syntaxElement = node.getSyntaxElement();
				if (syntaxElement instanceof MappingMethodCS) {
					if(syntaxElement instanceof MappingRuleCS) {
						return CompletionProposalUtil.getImage(CategoryImageConstants.MAPPING);
					} else if(syntaxElement instanceof MappingQueryCS) {
						return CompletionProposalUtil.getImage(CategoryImageConstants.IMPERATIVE_OPERATION);
					} else if(syntaxElement instanceof ConstructorCS) {
						return CompletionProposalUtil.getImage(CategoryImageConstants.OPERATION);
					}
				}
				
			}
			case QvtOutlineNodeType.IMPORTED_LIBRARY:
				return CompletionProposalUtil.getImage(CategoryImageConstants.IMG_OBJS_IMPCONT);
			default:
				return null;
		}
    }

    public String getText(final Object element) {
    	return element.toString();
    }

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    public void removeListener(ILabelProviderListener listener) {
    }
    
    
    
    public static String getMappingModuleLabel(final MappingModuleCS m) {
    	return (m == null || m.getHeaderCS() == null || m.getHeaderCS().getPathNameCS() == null) ? "" : //$NON-NLS-1$
    		getImportLabel(m.getHeaderCS().getPathNameCS()); 
    }

    public static String getMappingRuleLabel(final MappingMethodCS r) {
    	return getMappingDeclarationAsString(r.getMappingDeclarationCS());
    }

    public static String getRenameLabel(final RenameCS r) {
    	return r.getOriginalName().getStringSymbol() + " := " + r.getSimpleNameCS().getValue(); //$NON-NLS-1$
    }
    
    public static String getTagLabel(final TagCS tag) {
    	StringBuilder buf = new StringBuilder();
    	if(tag.getName() != null) {
    		buf.append(tag.getName().getStringSymbol()).append(' ');
    	}
    	
    	ScopedNameCS scopedNameCS = tag.getScopedNameCS();    	
    	if(scopedNameCS != null) {
    		if(scopedNameCS.getTypeCS() != null) {
    			String type = getTypeAsString(scopedNameCS.getTypeCS());
    			buf.append(type).append("::"); //$NON-NLS-1$
    		}
    		if(scopedNameCS.getName() != null) {
    			buf.append(scopedNameCS.getName());
    		}
    	}
    	
    	buf.append(" = "); //$NON-NLS-1$
    	if(tag.getOclExpressionCS() instanceof StringLiteralExpCS) {
    		StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS) tag.getOclExpressionCS();
    		buf.append(stringLiteralExpCS.getStringSymbol());
    	}
		return buf.toString();
    }    
    
    public static String getClassifierLabel(final ClassifierDefCS classifierDefCS) {
    	SimpleNameCS simpleNameCS = classifierDefCS.getSimpleNameCS();
    	if(simpleNameCS != null && simpleNameCS.getValue() != null) {
    		return simpleNameCS.getValue();
    	}
    	return "..."; //$NON-NLS-1$
    }
    
    public static String getPropertyLabel(final ModulePropertyCS prop) {
    	StringBuilder buf = new StringBuilder();
    	if(prop instanceof ContextualPropertyCS) {
    		ContextualPropertyCS ctxPropCS = (ContextualPropertyCS) prop;
    		if(ctxPropCS.getTypeCS() != null) {
    			buf.append(getTypeAsString(ctxPropCS.getTypeCS())).append("::"); //$NON-NLS-1$
    		}
    	}
    	
    	buf.append(prop.getSimpleNameCS().getValue());
    	TypeCS typeCS = null;
    	if(prop instanceof LocalPropertyCS) {
    		typeCS = ((LocalPropertyCS) prop).getTypeCS();
    	} else if(prop instanceof ConfigPropertyCS) {
    		typeCS = ((ConfigPropertyCS) prop).getTypeCS();
    	} else if(prop instanceof ContextualPropertyCS) {
    		typeCS = ((ContextualPropertyCS) prop).getTypeCS();
    	}
    	
    	if(typeCS != null) {
    		buf.append(" : ").append(getTypeAsString(typeCS)); //$NON-NLS-1$
    	}
    	
    	return buf.toString();
    }

    public static String getImportLabel(final PathNameCS path) {
        StringBuffer buffer = null;
        for (SimpleNameCS part : path.getSimpleNames()) {
			if (buffer != null) {
                buffer.append("."); //$NON-NLS-1$
			} else {
                buffer = new StringBuffer();
			}
            buffer.append(part.getValue());
		}
		return buffer == null ? "" : buffer.toString(); //$NON-NLS-1$
    }

    public static String getMetamodelLabel(final ModelTypeCS modelTypeCS) {
    	StringLiteralExpCS uriCS = modelTypeCS.getPackageRefs().get(0).getUriCS();
    	if (uriCS == null) {
    		return ""; //$NON-NLS-1$
    	}
    	return uriCS.getStringSymbol();
    }
    
    private static String getMappingDeclarationAsString(final MappingDeclarationCS decl) {
    	if (decl == null) {
    		return ""; //$NON-NLS-1$
    	}
    	List<String> listParam = new ArrayList<String>();
    	for (ParameterDeclarationCS param : decl.getParameters()) {
    		listParam.add(getParameterDeclarationAsString(param));
    	}
    	String context = ""; //$NON-NLS-1$
    	if (decl.getContextType() == null) {
        	EObject rootContainer = EcoreUtil.getRootContainer(decl);
        	if (rootContainer instanceof MappingModuleCS) {
        		context = getMappingModuleLabel((MappingModuleCS) rootContainer);
        	}
    	}
    	else {
    		context = getTypeAsString(decl.getContextType());
    	}
    	if (context.length() > 0) {
    		context += "::"; //$NON-NLS-1$
    	}
		return getMappingDeclarationAsString(decl.getSimpleNameCS().getValue(), context, listParam);
    }


    public static String getMappingDeclarationAsString(String name, String contextType, List<String> params){
    	StringBuffer result = new StringBuffer (contextType);
    	result.append(name);
    	result.append("("); //$NON-NLS-1$
    	for (Iterator<String> it = params.iterator(); it.hasNext(); ){
    		result.append(it.next());
    		if (it.hasNext()) {
    			result.append(", "); //$NON-NLS-1$
    		}
    	}
    	result.append(")"); //$NON-NLS-1$
    	return result.toString();
    }
    
    private static String getParameterDeclarationAsString(final ParameterDeclarationCS decl) {
    	StringBuffer result = new StringBuffer();
    	if (decl.getDirectionKind().getValue() == DirectionKindEnum.IN_VALUE) {
    		result.append("in "); //$NON-NLS-1$
    	} else if (decl.getDirectionKind().getValue() == DirectionKindEnum.OUT_VALUE) {
    		result.append("out "); //$NON-NLS-1$
    	} else if (decl.getDirectionKind().getValue() == DirectionKindEnum.INOUT_VALUE) {
    		result.append("inout "); //$NON-NLS-1$
    	}
    	
    	if(decl.getSimpleNameCS() != null) {
    		result.append(decl.getSimpleNameCS().getValue());
    	}
        
        String typeName = getTypeAsString(decl.getTypeSpecCS().getTypeCS());
        result.append(":").append(typeName); //$NON-NLS-1$
    	
    	return result.toString();
    }
    
    private static String getTypeAsString(TypeCS type) {
    	String typeName;
        if (type instanceof EClassifier) {
            typeName = QvtOperationalTypesUtil.getTypeFullName((EClassifier) type);
        }
        else if (type != null) {
            typeName = QvtOperationalUtil.getStringRepresentation(type);
        }
        else {
        	typeName = VoidType.SINGLETON_NAME;
        }
        
        return typeName;
    }
}
