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
package org.eclipse.m2m.internal.qvt.oml.ui.wizards.project;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.ui.QVTUIPlugin;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ide.undo.CreateFolderOperation;
import org.eclipse.ui.ide.undo.MoveResourcesOperation;
import org.eclipse.ui.ide.undo.WorkspaceUndoUtil;


class SourceContainerUpdater {
	
	private IContainer fCurrentContainer;
	
	
	public SourceContainerUpdater(IContainer existingContainer) {
		if(existingContainer == null) {
			throw new IllegalArgumentException();
		}
		
		this.fCurrentContainer = existingContainer;
	}

	/**
	 * Performs validation on the given source container path.
	 * 
	 * @param srcContainerPath
	 *            source container path relative to its project container.
	 *            <p>
	 *            Remark: <code>null</code> value is accepted and identifies
	 *            the project container.
	 *            
	 * @return status object representing the validation result
	 */
	public static IStatus validate(String srcContainerPath) {
		IStatus result = Status.OK_STATUS;
		
    	if(srcContainerPath == null || srcContainerPath.length() == 0) {
    		// Remark:
    		// Allow this as we can avoid the problem with the source folder interference 
    		// with namespaces when deployed
    		
    		//return QVTUIPlugin.createStatus(IStatus.INFO, Messages.SourceContainerUpdater_ProjectAsSourceFolderNotRecommened);
    	} else if(srcContainerPath.trim().length() == 0) {
    		return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.SourceContainerUpdater_NonBlankSourceFolderExpected); 
    	} else {
			IPath path = new Path(srcContainerPath);
			if(!path.isValidPath(srcContainerPath)) {
				return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.SourceContainerUpdater_InvalidSourceFolder);
			} else if(path.isAbsolute() || path.isUNC() || path.getDevice() != null ) {
				return QVTUIPlugin.createStatus(IStatus.ERROR, Messages.SourceContainerUpdater_RelativeSourceFolderExpected);
			} else {
				result = ResourcesPlugin.getWorkspace().validatePath("/" + path.toString(), IResource.PROJECT | IResource.FOLDER | IResource.FILE);				 //$NON-NLS-1$
			}
    	}
    	
    	return result;
	}
		
	public IStatus setContainer(IContainer newContainer, boolean moveExistingSources, IProgressMonitor monitor, Shell shell) {
		IStatus result = Status.OK_STATUS;
		
		if(newContainer.getType() == IResource.FOLDER) {
			result = ensureDestinationExists((IFolder)newContainer, monitor);
			if(!result.isOK()) {
				return result;
			}
		}
		
		List<IResource> rootItems = collectRootMoveCandidates(fCurrentContainer);
		IResource[] sources = rootItems.toArray(new IResource[rootItems.size()]);		

		IPath destPath = newContainer.getFullPath();
		result = validateMoveSource(sources, destPath);
		
		//MoveFilesAndFoldersOperation moveOperation = new MoveFilesAndFoldersOperation(fShell);
		//moveOperation.validateDestination(newSourceContainer, sources);
		//moveOperation.copyResources(sources, newSourceContainer);

		if(result.isOK()) {
			MoveResourcesOperation moveOperation = new MoveResourcesOperation(sources, destPath, "Moving");	//$NON-NLS-1$		
			try {
				moveOperation.setQuietCompute(false);	
				result = moveOperation.execute(monitor, WorkspaceUndoUtil.getUIInfoAdapter(shell));
			} catch (ExecutionException e) {
				QVTUIPlugin.log(e);
				try {
					if(moveOperation.canUndo()) {
						moveOperation.undo(monitor, null);
					}
				} catch (ExecutionException e1) {
					QVTUIPlugin.log(e);
				}
			}
		}
		
		return result;
	}
	
	static IStatus ensureDestinationExists(IFolder container, IProgressMonitor monitor) {
		IProgressMonitor safeMonitor = monitor != null ? monitor : new NullProgressMonitor();
		
		try {
			CreateFolderOperation operation = new CreateFolderOperation(container, null, "Creating source container"); //$NON-NLS-1$
			return operation.execute(safeMonitor, null);
		} catch (ExecutionException e) {
			return QVTUIPlugin.createStatus(IStatus.ERROR, e.getLocalizedMessage(), e);
		}
	}

	private IStatus validateMoveSource(IResource[] resourceToBeMoved, IPath destPath) {
		for (int i = 0; i < resourceToBeMoved.length; i++) {
			if(resourceToBeMoved[i].getFullPath().isPrefixOf(destPath)) {
				// FIXME - 
				//return QVTUIPlugin.createStatus(IStatus.ERROR, "Invalid destination source container", null);
			}
		}
		
		return Status.OK_STATUS;
	}
	
	private static List<IResource> collectRootMoveCandidates(IContainer rootContainer) {
		final List<IResource> candidates = new ArrayList<IResource>();
		
		final boolean isProjectContainer = rootContainer.getType() == IResource.PROJECT;
		
		try {
			rootContainer.accept(new IResourceProxyVisitor() {
				int depth = 0;
				
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if(depth > 0) {
						if(proxy.getType() == IResource.FOLDER) {
							if(!isProjectContainer || isQvtNamespaceFolder(((IFolder)proxy.requestResource()))) {
								candidates.add(proxy.requestResource());
							}
						} else if(proxy.getType() == IResource.FILE) {
							if(isQvtSourceFile(proxy)) {
								candidates.add(proxy.requestResource());
							}
						}
					}
					
					return (depth == 0) ? (depth = 1) > 0 : false; // allow only for DEPTH_1
				}
			}, 0);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return candidates; 
	}
	
	static boolean isQvtNamespaceFolder(IFolder folder) {
		final boolean[] foundQvtSource = new boolean[] { false };
		final boolean[] foundOtherSource = new boolean[] { false };
		
		try {
			folder.accept(new IResourceProxyVisitor() {
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if(isQvtSourceFile(proxy)) {
						foundQvtSource[0] = true;
					} else if(proxy.getType() == IResource.FILE) {
						foundOtherSource[0] = true;
					}
					return !foundOtherSource[0];
				}
			}, 0);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		return foundQvtSource[0];
	}
	
	static boolean isQvtSourceFile(IResourceProxy proxy) {
		return proxy.getType() == IResource.FILE && proxy.getName().endsWith(MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
	}
	
	static class QvtSourceFinder implements IResourceProxyVisitor {
		private int depth = IResource.DEPTH_ZERO;
		private int nextDepth = IResource.DEPTH_ZERO;
		
		private List<IResource> sources = new ArrayList<IResource>();
		
		QvtSourceFinder() {
		}

		public void setDepth(int depth) {
			this.depth = depth;
		}
		
		public boolean visit(IResourceProxy proxy) throws CoreException {
			
			if(proxy.getType() == IResource.FILE &&
				proxy.getName().endsWith(MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT)) {
				sources.add(proxy.requestResource());
			}

			if(nextDepth == IResource.DEPTH_ZERO) {
				depth = IResource.DEPTH_ONE;
			} 
			
			return depth != IResource.DEPTH_ZERO;
		}
	};
}
