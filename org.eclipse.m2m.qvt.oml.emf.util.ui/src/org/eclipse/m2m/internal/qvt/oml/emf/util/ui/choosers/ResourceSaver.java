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
package org.eclipse.m2m.internal.qvt.oml.emf.util.ui.choosers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.EmfUtilUiPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;


public class ResourceSaver implements IResultSaver{
    public IStatus canSave(EClassifier cls, URI destUri) {
		URI converted = URIConverter.INSTANCE.normalize(destUri);
		
		IStatus okStatus = new Status(IStatus.OK, EmfUtilUiPlugin.ID, IStatus.OK, "", null);//$NON-NLS-1$
		String scheme = converted.scheme();
		if (converted.isFile()) {
			if (!"file".equals(scheme) && !"platform".equals(scheme)) { //$NON-NLS-1$ //$NON-NLS-2$
				return new Status(IStatus.ERROR, EmfUtilUiPlugin.ID, IStatus.ERROR, Messages.format(Messages.ResourceSaver_UriNotFile, new Object[] {destUri, scheme}), null);
			}
		}
		else {
			if ("archive".equals(scheme)) { //$NON-NLS-1$
				return okStatus;  
			}
			else if (converted.isPlatformResource()) {
				return okStatus;
			}
//			else if (isEFSScheme(scheme)) {
//				return true;
//			}
			else {
				try	{
					URL url = new URL(destUri.toString());
					url.openConnection();
					return okStatus;
				}
				catch (MalformedURLException e) {
				}
				catch (IOException e) {
				}
			}
		}
    	return new Status(IStatus.ERROR, EmfUtilUiPlugin.ID, IStatus.ERROR, NLS.bind(Messages.ResourceSaver_UriCorrupted, destUri), null);
    }
    	
    public void clean(URI destUri) throws Exception {
        IFile file = org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils.getFile(destUri);
        if(file == null) {
            return;
        }
        
        file.delete(true, true, null);
    }
    
    public boolean select(EObject obj, IWorkbenchPage page) throws CoreException {
        Resource resource = obj.eResource();
        if(resource == null) {
            return false;
        }
        URIConverter uriConverter = resource.getResourceSet() != null ? resource.getResourceSet().getURIConverter() : URIConverter.INSTANCE;
        URI uri = uriConverter.normalize(resource.getURI());
        
        IEditorDescriptor defaultEditorDescriptor = null;
        IFile file = URIUtils.getFile(uri);
        if(file == null || !file.exists()) {
        	try {
        		defaultEditorDescriptor = IDE.getEditorDescriptor(uri.toFileString());
        	} catch (RuntimeException e) {
        	}
            file = null;
        } else {
            defaultEditorDescriptor = IDE.getDefaultEditor(file);
			resource.setURI(URI.createPlatformResourceURI(file.getFullPath().toString(), true));
        }        
        if (defaultEditorDescriptor == null) {
        	return false;
        }

        IEditorPart part = null;
        String defaultID = defaultEditorDescriptor.getId();
		if (EditorsUI.DEFAULT_TEXT_EDITOR_ID.equals(defaultID)) {
			if (file == null) {
				part = openInEditor(page, uri);
			} else {
				part = openEditor(page, file, "org.eclipse.emf.ecore.presentation.ReflectiveEditorID"); //$NON-NLS-1$
			}
        }
		if (part == null) {
			if (file == null) {
				part = openInEditor(page, uri);
			} else {
				part = openEditor(page, file, defaultID);
			}
		}
		if (part == null) {
			return false;
		}
        if(part instanceof IGotoMarker == false) {
            return true;
        }
        
        IGotoMarker gotoMarker = (IGotoMarker) part;
        IMarker marker = makeMarker(obj, file);
        
        try {
        	gotoMarker.gotoMarker(marker);
        } finally {
            marker.delete();
        }

        return true;
    }

	private IEditorPart openEditor(IWorkbenchPage page, IFile file, String id) {
		try {
			return IDE.openEditor(page, file, id, true);
		} 
		catch (PartInitException e) {
			// ignore
		}
		return null;
	}
    
	private IEditorPart openInEditor(IWorkbenchPage page, URI uri) {
		IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(uri.toFileString()));
		if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
			try {
				return IDE.openEditorOnFileStore(page, fileStore);
			} catch (PartInitException e) {
			}
		}
		return null;
	}

    public URI getUri(EObject obj) {
        return obj == null ? null : EcoreUtil.getURI(obj);
    }
    
    private IMarker makeMarker(EObject obj, IFile file) throws CoreException {
        URI uri = EcoreUtil.getURI(obj);
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put(EValidator.URI_ATTRIBUTE, String.valueOf(uri));
        
        IMarker marker = (file == null ? new ShallowMarker(EValidator.MARKER) : file.createMarker(EValidator.MARKER));
        marker.setAttributes(attributes);        
        return marker;
    }
    
    
    private static class ShallowMarker implements IMarker {
    	
    	private final Map<String, Object> myAttributes = new HashMap<String, Object>();
    	private final long myCreationTime;
    	private final String myType;
    	
    	public ShallowMarker(String type) {
    		myCreationTime = System.currentTimeMillis();
    		myType = type;
		}

		public Object getAdapter(Class adapter) {
			return null;
		}

		public void delete() throws CoreException {
		}

		public boolean exists() {
			return false;
		}

		public Object getAttribute(String attributeName) throws CoreException {
			return myAttributes.get(attributeName);
		}

		public int getAttribute(String attributeName, int defaultValue) {
			Object object = myAttributes.get(attributeName);
			if (object instanceof Integer) {
				return ((Integer) object).intValue();
			}
			return defaultValue;
		}

		public String getAttribute(String attributeName, String defaultValue) {
			Object object = myAttributes.get(attributeName);
			if (object instanceof String) {
				return (String) object;
			}
			return defaultValue;
		}

		public boolean getAttribute(String attributeName, boolean defaultValue) {
			Object object = myAttributes.get(attributeName);
			if (object instanceof Boolean) {
				return (Boolean) object;
			}
			return defaultValue;
		}

		public Map<String, Object> getAttributes() throws CoreException {
			return myAttributes;
		}

		public Object[] getAttributes(String[] attributeNames) throws CoreException {
			Object[] result = new Object[attributeNames.length];
			for (int i = 0; i < attributeNames.length; i++) {
				result[i] = getAttribute(attributeNames[i]);
			}
			return result;
		}

		public long getCreationTime() throws CoreException {
			return myCreationTime;
		}

		public long getId() {
			return myCreationTime;
		}

		public IResource getResource() {
			return null;
		}

		public String getType() throws CoreException {
			return IMarker.MARKER;
		}

		public boolean isSubtypeOf(String superType) throws CoreException {
			return myType.equals(superType);
		}

		public void setAttribute(String attributeName, int value) throws CoreException {
			myAttributes.put(attributeName, value);
		}

		public void setAttribute(String attributeName, Object value) throws CoreException {
			myAttributes.put(attributeName, value);
		}

		public void setAttribute(String attributeName, boolean value) throws CoreException {
			myAttributes.put(attributeName, value);
		}

		public void setAttributes(String[] attributeNames, Object[] values) throws CoreException {
			Assert.isTrue(attributeNames.length == values.length);
			for (int i = 0; i < attributeNames.length; i++) {
				setAttribute(attributeNames[i], values[i]);
			}
		}

		public void setAttributes(Map<String, ? extends Object> attributes) throws CoreException {
			myAttributes.clear();
			myAttributes.putAll(attributes);
		}
		
    }

}
