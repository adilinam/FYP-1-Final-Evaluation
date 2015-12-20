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
 *     Christopher Gerking - bug 427237
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.compiler.ResolverUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ModelContent;
import org.eclipse.m2m.internal.qvt.oml.runtime.generator.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;

public class QvtCompiledTransformation implements QvtTransformation, CompiledTransformation {
   
	public static QvtCompiledTransformation createLibraryModule(String namespace, String id, String file) {
		QvtCompiledTransformation result = new QvtCompiledTransformation(namespace, id, file);
		return result;
	}
	
	public QvtCompiledTransformation(String namespace, String id, String file) {
        myNamespace = namespace;
        myId = id;
        this.transformationFilePath = file != null ? new Path(file) :
        	new Path(ResolverUtils.toNamespaceRelativeUnitFilePath(id));
    }
	
	protected QvtTransformation getImpl() throws MdaException {
		if(qvtTransformationImpl == null) {
			qvtTransformationImpl = getInterpreterFactory().create(myId);
		}
		return qvtTransformationImpl;
	}

    public String getModuleName() {
    	return transformationFilePath.removeFileExtension().lastSegment();
    }
    
    public URI getURI() throws MdaException {
    	return getUri();
    }

	public ResourceSet getResourceSet() throws MdaException {
		return getImpl().getResourceSet();
	}
    
	public void cleanup() throws MdaException {
		getImpl().cleanup();
	}

    public TransformationRunner.Out run(TransformationRunner.In in) throws MdaException {
        return getImpl().run(in);
    }
    
    public String getId() {
        return myId;
    }

    public URI getUri() {
    	return URI.createPlatformPluginURI(myNamespace, false).appendSegments(transformationFilePath.segments());
    }

    public String getNamespace() {
        return myNamespace;
    }

    public List<TransformationParameter> getParameters() throws MdaException {
    	return getImpl().getParameters();
    }

	public boolean hasEntryOperation() throws MdaException {
		return getImpl().hasEntryOperation();
	}
	
	public boolean isBlackbox() throws MdaException {
		return getImpl().isBlackbox();
	}

    @Override
	public String toString() {
    	/*
    	String listParams = ""; //$NON-NLS-1$
    	try {
    		for (TransformationParameter param : getParameters()) {
    			if (listParams.length() > 0) {
    				listParams += ", "; //$NON-NLS-1$
    			}
    			listParams += toString(param);
    		}
    	}
    	catch (MdaException e) {
    		listParams = null;
    	}
    	if (listParams == null) {
    		return myId;
    	}
        return myId + "(" + listParams + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        */
    	return myId;
    }

//    private static String toString(TransformationParameter param) {
//    	if (param.getEntryType() != null) {
//    		return EmfUtil.getFullName(param.getEntryType());
//    	}
//    	if (param.getMetamodels().isEmpty()) {
//    		return param.getName();
//    	}
//        return EmfUtil.getFullName(param.getMetamodels().get(0));
//    }

    @Override
	public boolean equals(Object obj) {
        if (obj instanceof QvtCompiledTransformation == false) {
            return false;
        }
        QvtCompiledTransformation trans = (QvtCompiledTransformation) obj;
        return trans.getId().equals(getId());
    }

    @Override
	public int hashCode() {
        return myId.hashCode();
    }

    public Set<QvtConfigurationProperty> getConfigurationProperties() throws MdaException {
    	return getImpl().getConfigurationProperties();
    }
    
    public ModelContent loadInput(URI inputObjectURI) throws MdaException {
    	return qvtTransformationImpl.loadInput(inputObjectURI);
    }    
    
	private static QvtTransformationInterpreterFactory getInterpreterFactory() throws MdaException {
    	if (implFactory != null) {
    		return implFactory;
    	}
		IExtensionRegistry pluginRegistry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = pluginRegistry.getExtensionPoint(QvtTransformationInterpreterFactory.Descriptor.FACTORY_POINT_ID);
		if (extensionPoint != null) {
			IExtension[] allExtensions = extensionPoint.getExtensions();
			// take only first suitable factory
			for (IExtension ext : allExtensions) {
				IConfigurationElement[] elements = ext.getConfigurationElements();
				Object factoryObj = null;
				try {
					factoryObj = elements[0].createExecutableExtension(QvtTransformationInterpreterFactory.Descriptor.CLASS_ATTR);
				} catch (CoreException e) {
					throw new MdaException(e);
				}
				return implFactory = (QvtTransformationInterpreterFactory) factoryObj;
			}
		}
		throw new MdaException(Messages.NoQvtImplementorFactoryRegistered);
    }
    
    private static QvtTransformationInterpreterFactory implFactory;
    
    private final String myNamespace;

    private final String myId;
    
    private QvtTransformation qvtTransformationImpl;

    private IPath transformationFilePath;

}
