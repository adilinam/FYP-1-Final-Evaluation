/*******************************************************************************
 * Copyright (c) 2007, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 267917
 *     Christopher Gerking - bug 427237
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImportKind;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelType;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModuleImport;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.QvtRuntimePlugin;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation.TransformationParameter;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.EMFType;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.internal.qvt.oml.stdlib.ConversionUtils;
import org.eclipse.ocl.types.VoidType;
import org.eclipse.osgi.util.NLS;

public abstract class QvtModule {
    private QvtCompilerOptions myQvtCompilerOptions;

    protected QvtModule() {		
    }

    public abstract CompiledUnit getUnit() throws MdaException;
    
    /**
     * Obtain QVTO Module instance with at most semantic warnings.
     * <br>
     * IO errors and syntax errors are wrapped with MdaException.  
     * Semantic errors are thrown as MdaException (see MdaException.getStatus(), org.eclipse.core.runtime.MultiStatus),
     * this can be turned off with QvtCompilerOptions.setModuleWithErrorAllowed()
     * 
     * @return org.eclipse.m2m.internal.qvt.oml.expressions.Module instance
     * @throws MdaException
     */
    public abstract Module getModule() throws MdaException;
    
    public abstract ResourceSet getResourceSet() throws MdaException;

	public abstract void cleanup();
    
    public List<TransformationParameter> getParameters() throws MdaException {
        Module module = getModule();
        if(module instanceof OperationalTransformation == false) {
        	return Collections.emptyList();
        }
        
        OperationalTransformation transfModule = (OperationalTransformation) module;
        ImperativeOperation mainMethod = QvtOperationalParserUtil.getMainOperation(module);
        if(!transfModule.isIsBlackbox() && mainMethod == null) {
        	return Collections.emptyList();
        }

        List<TransformationParameter> transfParams = new ArrayList<TransformationParameter>(transfModule.getModelParameter().size());
        for (ModelParameter modelParam : transfModule.getModelParameter()) {
            MappingParameter refinedParam = findMainParameter(mainMethod, modelParam);
            transfParams.add(createTransfParam(modelParam, refinedParam));
        }

        if (transfParams.isEmpty() && mainMethod != null) {
            for (EParameter mainParam : mainMethod.getEParameters()) {
                transfParams.add(createTransfParam((MappingParameter) mainParam));
            }
            for (VarParameter mainParam : mainMethod.getResult()) {
                if (mainParam.getEType() instanceof VoidType<?>) {
                    continue;
                }
                transfParams.add(createTransfParam((MappingParameter) mainParam));
            }
        }

        return transfParams;
    }
    
    public QvtCompilerOptions getQvtCompilerOptions() {
        return myQvtCompilerOptions;
    }

    public void setQvtCompilerOptions(QvtCompilerOptions options) {
        myQvtCompilerOptions = options;
    }

    private TransformationParameter createTransfParam(final MappingParameter mainParam) {
        return new TransformationParameter() {

            public DirectionKind getDirectionKind() {
                if (mainParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.IN) {
                    return DirectionKind.IN;
                }
                if (mainParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
                    return DirectionKind.OUT;
                }
                return DirectionKind.INOUT;
            }

            public String getEntryName() {
                return mainParam.getName() != null ? mainParam.getName() : ""; //$NON-NLS-1$
            }

            public EClassifier getEntryType() {
                return mainParam.getEType();
            }

            public List<EPackage> getMetamodels() {
                EObject rootContainer = EcoreUtil.getRootContainer(mainParam.getEType());
                if (rootContainer instanceof EPackage) {
                    return Collections.singletonList((EPackage) rootContainer);
                }
                return Collections.emptyList();
            }

            public String getModelTypeName() {
                if (getMetamodels().isEmpty()) {
                    return ""; //$NON-NLS-1$
                }
                return getMetamodels().get(0).getName();
            }

            public String getName() {
                return getEntryName();
            }

        };
    }

    private TransformationParameter createTransfParam(final ModelParameter modelParam, final MappingParameter refinedParam) {
        return new TransformationParameter() {

            public DirectionKind getDirectionKind() {
                if (modelParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.IN) {
                    return DirectionKind.IN;
                }
                if (modelParam.getKind() == org.eclipse.m2m.internal.qvt.oml.expressions.DirectionKind.OUT) {
                    return DirectionKind.OUT;
                }
                return DirectionKind.INOUT;
            }

            public String getEntryName() {
                return refinedParam != null ? refinedParam.getName() : ""; //$NON-NLS-1$
            }

            public EClassifier getEntryType() {
                return refinedParam != null ? refinedParam.getEType() : null;
            }

            public List<EPackage> getMetamodels() {
            	return ((ModelType)modelParam.getType()).getMetamodel();
            }

            public String getModelTypeName() {
                if (modelParam.getEType() instanceof ModelType) {
                    return ((ModelType) modelParam.getEType()).getName();
                }
                return ""; //$NON-NLS-1$
            }

            public String getName() {
                return modelParam.getName();
            }

        };
    }

    private MappingParameter findMainParameter(ImperativeOperation mainMethod, ModelParameter modelParam) {
        if (mainMethod != null) {
            for (EParameter mainParam : mainMethod.getEParameters()) {
                if (((MappingParameter) mainParam).getExtent() == modelParam) {
                    return (MappingParameter) mainParam;
                }
            }
            for (VarParameter mainParam : mainMethod.getResult()) {
                if (((MappingParameter) mainParam).getExtent() == modelParam) {
                    return (MappingParameter) mainParam;
                }
            }
        }
        return null;
    }

    /**
     * Collects all the configuration properties used by this module
     * including the ones declared by imported modules
     * @return LinkedHashSet of properties
     * @throws MdaException as {@link #getModule()} does
     */
    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
        CompiledUnit unit = getUnit();
        if (unit == null) {
            return Collections.<QvtConfigurationProperty>emptySet();
        }
        Set<Module> moduleSet = new HashSet<Module>();

        for (Module nextModule : unit.getModules()) {
            collectImports(nextModule, ImportKind.EXTENSION, moduleSet);			
		}

        Set<QvtConfigurationProperty> propSet = new LinkedHashSet<QvtConfigurationProperty>();
        for (Module m : moduleSet) {
            collectProperties(m, propSet);
        }
        return propSet;
    }

    /**
     * @return A string representation uniquely identifying the given QVT module.
     */
    @Override
    public abstract String toString();

    protected void checkModuleErrors(CompiledUnit unit) throws MdaException {    	
        // List<QvtMessage> errors = new ArrayList<QvtMessage>();
        // FIXME  
        // no need to check imports recursively as the compiled modules reports error on bad imports
        // => for now, get only the directly owned errors, including "import has compilation error!"
        // TransformationUtil.getErrors(unit, errors);
        List<QvtMessage> errors = unit.getErrors();
		if(errors.isEmpty()) {
        	return;
        }
        
        MultiStatus multistatus = new MultiStatus(QvtRuntimePlugin.ID, 1, NLS.bind(Messages.TransformationUtil_ParseTransformationError, toString(), errors.size()), null);
        for (QvtMessage msg : errors) {
            IStatus status = new Status(msg.getSeverity() == QvtMessage.SEVERITY_ERROR ? IStatus.ERROR : IStatus.WARNING,
            		QvtRuntimePlugin.ID, 1, msg.toString(), null);
            multistatus.merge(status);
        }
        throw new MdaException(multistatus);
    }	

    /**
     * Collects all the imported modules (including ones imported implicitly), non-recursive,
     * cyclic-import compatible
     * @param module - root module
     * @param kind - the kind of import to select or <code>null</code> is any kind is acceptable
     * @param moduleSet - resulting set
     */
    private void collectImports(Module module, ImportKind kind, Set<Module> moduleSet) {
    	assert module != null;
    	
        // WFS on imports graph
        Queue<Module> queue = new LinkedList<Module>();
        queue.offer(module);
        while (!queue.isEmpty()) {
            Module m = queue.poll();
            moduleSet.add(m);
            for (ModuleImport imp : m.getModuleImport()) {
            	if(kind == null || kind == imp.getKind()) {
	                Module element = imp.getImportedModule();
	                if (!moduleSet.contains(element)) {
	                    moduleSet.add(element);
	                    queue.offer(element);                    
	                }
            	}
            }
        }
    }


    /**
     * Collects configuration properties declared by a mapping module
     * @param module - a mapping module
     * @param propSet - a set to put properties to
     */
    private void collectProperties(Module module, Set<QvtConfigurationProperty> propSet) {
        for (EStructuralFeature property : module.getConfigProperty()) {
                EClassifier type = property.getEType();
                if (type instanceof EDataType) {
                	ConversionUtils.setupConversionDelegate(type);
                    propSet.add(
                            new QvtConfigurationProperty(
                                    property.getName(), 
                                    new EMFType((EDataType) type)
                            )
                    );
                    
                } else if (QvtOperationalUtil.isPrimitiveType(type)) {
                    propSet.add(
                            new QvtConfigurationProperty(
                                    property.getName(), 
                                    new QvtPrimitiveType(type)
                            )
                    );
                }
        }
    }

}