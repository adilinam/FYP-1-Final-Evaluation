/*******************************************************************************
 * Copyright (c) 2013 S. Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConfigPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline.actions.ShowFQNAction;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.swt.graphics.Image;

public class OutlineLabelProvider implements ILabelProvider {
    private final ShowFQNAction myShowFQNAction;
    
    public OutlineLabelProvider(QvtOutlineInformationControl qvtOutlineInformationControl) {
        myShowFQNAction = qvtOutlineInformationControl.getShowFQNAction();
    }
    
	public String getText(Object element) {
        if (element instanceof MappingModuleCS) {
            MappingModuleCS mappingModuleCS = (MappingModuleCS) element;
            TransformationHeaderCS headerCS = mappingModuleCS.getHeaderCS();
            if (headerCS != null) {
                PathNameCS nameCS = headerCS.getPathNameCS();
                if (nameCS != null) {
                    return QvtOperationalParserUtil.getStringRepresentation(nameCS, "."); //$NON-NLS-1$
                }
            }
        } else if (element instanceof MappingMethodCS) {
            MappingMethodCS mappingMethodCS = (MappingMethodCS) element;
            MappingDeclarationCS mappingDeclarationCS = mappingMethodCS.getMappingDeclarationCS();
            if (mappingDeclarationCS != null) {
                return getDeclaration(mappingDeclarationCS);
            }
        } else if (element instanceof ModulePropertyCS) {
            ModulePropertyCS modulePropertyCS = (ModulePropertyCS) element;
            TypeCS returnTypeCS = null;
            if (modulePropertyCS instanceof LocalPropertyCS) {
            	returnTypeCS = ((LocalPropertyCS) modulePropertyCS).getTypeCS();
            } else if (modulePropertyCS instanceof ContextualPropertyCS) {
            	returnTypeCS = ((ContextualPropertyCS) modulePropertyCS).getTypeCS();
            } else if (modulePropertyCS instanceof ConfigPropertyCS) {
            	returnTypeCS = ((ConfigPropertyCS) modulePropertyCS).getTypeCS();
            }
            SimpleNameCS simpleNameCS = modulePropertyCS.getSimpleNameCS();
            if (simpleNameCS != null) {
            	String labelText = simpleNameCS.getValue();
            	if (isShowFQN() && (modulePropertyCS instanceof ContextualPropertyCS)) {
            		ContextualPropertyCS contextualPropertyCS = (ContextualPropertyCS) modulePropertyCS;
            		ScopedNameCS scopedNameCS = contextualPropertyCS.getScopedNameCS();
            		if (scopedNameCS != null) {
            			TypeCS contextTypeCS = scopedNameCS.getTypeCS();
            			if (contextTypeCS != null) {
            				labelText = QvtOperationalParserUtil.getStringRepresentation(contextTypeCS)
            							+ EmfUtil.PATH_SEPARATOR + labelText;
            			}
            		}
            	}
            	if (returnTypeCS != null) {
            		labelText += " : " + QvtOperationalParserUtil.getStringRepresentation(returnTypeCS); //$NON-NLS-1$
            	}
                return labelText;
            }
        } else if  (element instanceof ClassifierDefCS) {
        	ClassifierDefCS classifierDefCS = (ClassifierDefCS) element;
            SimpleNameCS simpleNameCS = classifierDefCS.getSimpleNameCS();
            if (simpleNameCS != null) {
                return simpleNameCS.getValue();
            }
        } 
        return null;
    }

    private String getDeclaration(MappingDeclarationCS mappingDeclarationCS) {
        StringBuilder stringBuilder = new StringBuilder();
        if (isShowFQN()) {
            TypeCS contextType = mappingDeclarationCS.getContextType();
            if (contextType != null) {
                stringBuilder.append(QvtOperationalParserUtil.getStringRepresentation(contextType));
                stringBuilder.append(EmfUtil.PATH_SEPARATOR);
            }
        }
        SimpleNameCS mappingName = mappingDeclarationCS.getSimpleNameCS();
        if(mappingName != null) {                
            stringBuilder.append(mappingName.getValue());
            stringBuilder.append('(');
            boolean isFirstParam = true;
            for (ParameterDeclarationCS param : mappingDeclarationCS.getParameters()) {
                if (!isFirstParam) {
                    stringBuilder.append(", "); //$NON-NLS-1$
                }
                TypeSpecCS paramTypeSpec = param.getTypeSpecCS();
                if (paramTypeSpec != null) {
                    TypeCS paramType = paramTypeSpec.getTypeCS();
                    if (paramType != null) {
                        stringBuilder.append(QvtOperationalParserUtil.getStringRepresentation(paramType));
                    }
                }
                SimpleNameCS paramName = param.getSimpleNameCS();
                if (paramName != null) {
                    stringBuilder.append(' ');
                    stringBuilder.append(paramName.getValue());
                }
                isFirstParam = false;                
            }
            stringBuilder.append(')');
        }
        TypeSpecCS returnTypeSpec = (!mappingDeclarationCS.getResult().isEmpty()) ? mappingDeclarationCS.getResult().get(0).getTypeSpecCS() : null;
        if (returnTypeSpec != null) {
            TypeCS returnType = returnTypeSpec.getTypeCS();
            if (returnType != null) {
                stringBuilder.append(" : "); //$NON-NLS-1$
                stringBuilder.append(QvtOperationalParserUtil.getStringRepresentation(returnType));
            }
        }
        return stringBuilder.toString();
    }
    
    public Image getImage(Object element) {
        if (element instanceof MappingModuleCS) {
            return CompletionProposalUtil.getImage(CategoryImageConstants.PACKAGE);
        } else if (element instanceof MappingRuleCS) {
            return CompletionProposalUtil.getImage(CategoryImageConstants.MAPPING);
        } else if (element instanceof MappingQueryCS) {
            return CompletionProposalUtil.getImage(CategoryImageConstants.IMPERATIVE_OPERATION);
        } else if (element instanceof ModulePropertyCS) {
            return CompletionProposalUtil.getImage(CategoryImageConstants.PROPERTY);
        } else if (element instanceof ClassifierDefCS) {
            return CompletionProposalUtil.getImage(CategoryImageConstants.CLASS);
        }
        return null;
    } 

    public void addListener(ILabelProviderListener listener) {
    }

    public void dispose() {
    }

    public boolean isLabelProperty(Object element, String property) {
        return true;
    }

    public void removeListener(ILabelProviderListener listener) {
    }
    
    public boolean isShowFQN() {
        return myShowFQNAction.isChecked();
    }
}