/*******************************************************************************
 * Copyright (c) 2009, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Christopher Gerking - bugs 391289, 431082
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.project.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.io.eclipse.EclipseFile;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompilerUtils;
import org.eclipse.m2m.internal.qvt.oml.compiler.ExeXMISerializer;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.Logger;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.project.QVTOProjectPlugin;
import org.eclipse.m2m.internal.qvt.oml.project.nature.NatureUtils;



public class QVTOBuilder extends IncrementalProjectBuilder {
	
    public static final String SAVE_AST_XMI = "internal.save.xmi"; //$NON-NLS-1$

	public interface BuildListener {
        void buildPerformed();
    }
	
	
	// FIXME - not used?
    private static final List<BuildListener> ourListeners = new Vector<BuildListener>();
    
    private QVTOBuilderConfig myConfig;
	        
    public QVTOBuilder() {
    	super();
    }
    
    
	@Override
	protected IProject[] build(int kind, Map<String,String> args, IProgressMonitor monitor) throws CoreException {
    					
   		monitor = new ProgressMonitorWrapper(monitor == null ? new NullProgressMonitor() : monitor) {
   			@Override
   			public boolean isCanceled() {
   				return super.isCanceled() || isInterrupted();
   			}
   		};
    	
   		try {
	    	monitor.setTaskName("Build " + getProject().getFullPath().toString()); //$NON-NLS-1$
	    		    	
	        if (kind == IncrementalProjectBuilder.FULL_BUILD) {
	            fullBuild(monitor);
	        } else {
	            incrementalBuild(monitor);
	        }
   		} finally {
   			monitor.done();
   		}
   		
        fireBuildEvent();
                
        IProject[] projectDependencies = getConfig().getProjectDependencies(true);
        
        return projectDependencies;
	    	    
    }
    
    private void fullBuild(IProgressMonitor monitor) throws CoreException {
        rebuildAll(monitor);
    }
    
    @Override
	protected void clean(final IProgressMonitor monitor) throws CoreException {        
        
   		monitor.setTaskName("Clean " + getProject().getFullPath().toString()); //$NON-NLS-1$
		
    	getProject().accept(new IResourceProxyVisitor() {
			public boolean visit(IResourceProxy proxy) throws CoreException {
				if (proxy.getType() == IResource.FILE) {
					if (MDAConstants.QVTO_FILE_EXTENSION.equals(proxy.requestFullPath().getFileExtension())) {
						proxy.requestResource().deleteMarkers(QVTOProjectPlugin.PROBLEM_MARKER, true, IResource.DEPTH_INFINITE);
					}
					return false;
				}
				return true;
			}
    		
    	}, IContainer.INCLUDE_TEAM_PRIVATE_MEMBERS);
    	
    	monitor.done();
    }
    
    private void incrementalBuild(IProgressMonitor monitor) throws CoreException {
    	boolean needsRebuild = hasQVTModification(getProject());
    	if(!needsRebuild) {
    		IProject[] referencedProjects = getConfig().getProjectDependencies(true);
    		for (int i = 0; i < referencedProjects.length; i++) {
				IProject refProject = referencedProjects[i];
				needsRebuild = !refProject.isAccessible() || hasQVTModification(refProject);
				if(needsRebuild) {
					break;
				}
			}    		
    	}

        if(needsRebuild) {
            rebuildAll(monitor);
        }
    }
    
    private boolean hasQVTModification(final IProject project) throws CoreException {
    	IResourceDelta delta = getDelta(project);

        final boolean[] rebuild = { false };
        if (delta != null) {
            delta.accept(new IResourceDeltaVisitor() {
                public boolean visit(IResourceDelta delta) throws CoreException {
                	if((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
                		if(IResource.FOLDER == delta.getResource().getType()) {
                			// update QVT source container if its folder is moved
                			IContainer srcContainer = QVTOBuilderConfig.getConfig(project).getSourceContainer();
                			if(delta.getMovedFromPath().equals(srcContainer.getFullPath())) {
                				try {			
                					QVTOBuilderConfig config = QVTOBuilderConfig.getConfig(project);
                					config.setSourceContainer((IFolder)delta.getResource());
                					config.save();
                				} catch (CoreException e) {
									QvtPlugin.getDefault().log(e.getStatus());
								}
                			}
                		}
                	}

                	if(delta.getResource().getType() == IResource.FILE) {
	                    IPath projectRelativePath = delta.getResource().getProjectRelativePath();
	                    if(".project".equals(projectRelativePath.toString()) || //$NON-NLS-1$
	                    	"plugin.xml".equals(projectRelativePath.toString()) || //$NON-NLS-1$
	                    	"META-INF/MANIFEST.MF".equals(projectRelativePath.toString())) { //$NON-NLS-1$
	                        rebuild[0] = true;
	                        return false;                    	
	                    }
	                    if (MDAConstants.QVTO_FILE_EXTENSION.equals(projectRelativePath.getFileExtension())) {
	                        rebuild[0] = true;
	                        return false;
	                    }
	                    
	                    IFile mappingsFile = MetamodelURIMappingHelper.getMappingFileHandle(project);
	                    if(mappingsFile != null && mappingsFile.exists() && projectRelativePath.equals(mappingsFile.getProjectRelativePath())) {
	                        rebuild[0] = true;
	                        return false;
	                    }
	                    
	                    if(delta.getResource().getType() == IResource.FILE && MetamodelRegistry.isMetamodelFileName(delta.getResource().getName())) {
	                        rebuild[0] = true;
	                        return false;
	                    }
                	}
                    
                    return true;
                }
            });
        }
        return rebuild[0];
    }
    
    private void rebuildAll(IProgressMonitor monitor) throws CoreException {
    	
		SubMonitor progress = SubMonitor.convert(monitor, "Rebuild all", 10); //$NON-NLS-1$
		
        IFile[] files = collectFiles(progress.newChild(1, SubMonitor.SUPPRESS_NONE));
        
        CompiledUnit[] units;
		try {
			QvtCompilerOptions options = new QvtCompilerOptions();
			options.setGenerateCompletionData(false);
			
			EclipseFile[] sources = new EclipseFile[files.length];
			for (int i = 0; i < sources.length; i++) {
				sources[i] = new EclipseFile(files[i]);
			}
			
	        QVTOCompiler compiler = CompilerUtils.createCompiler();
	        List<UnitProxy> allUnits = UnitResolverFactory.Registry.INSTANCE.findAllUnits(URIUtils.getResourceURI(getProject()));

	        units = compiler.compile(allUnits.toArray(new UnitProxy[allUnits.size()]),
						options, CompilerUtils.createMonitor(BasicMonitor.toMonitor(progress.newChild(8, SubMonitor.SUPPRESS_NONE)), 8));
	        
	        if(shouldSaveXMI()) {
	        	ResourceSet metamodelResourceSet = compiler.getResourceSet();
	        	Registry registry = MetamodelURIMappingHelper.mappingsToEPackageRegistry(getProject(), metamodelResourceSet);
	        	ExeXMISerializer.saveUnitXMI(units, registry != null ? registry : EPackage.Registry.INSTANCE);
	        }
		}
		catch (OperationCanceledException e) {
			throw e;
		}
		catch (Exception e) {
			throw new CoreException(QVTOProjectPlugin.createStatus(IStatus.ERROR, e.getMessage(), e));
		}
		
        for (int i = 0; i < units.length; i++) {                    
        	if(monitor.isCanceled()) {
            	CompilerUtils.throwOperationCanceled();
            }
            
        	CompiledUnit nextUnit = units[i];
        	URI sourceURI = nextUnit.getURI();
        	IFile sourceFile = URIUtils.getFile(sourceURI);
        	
        	sourceFile.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);

            List<QvtMessage> messages = nextUnit.getProblems();            
            for (QvtMessage nextMessage : messages) {
                createQvtMarker(sourceFile, nextMessage);
            }
        }
        
        progress.worked(1);
    }
        
    private void createQvtMarker(IFile curFile, QvtMessage e) {
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put(IMarker.CHAR_START, Integer.valueOf(e.getOffset()));
        attributes.put(IMarker.CHAR_END, Integer.valueOf(e.getOffset() + e.getLength()));
        attributes.put(IMarker.MESSAGE, e.getMessage());
        attributes.put(IMarker.SEVERITY, Integer.valueOf(e.getSeverity()));
        if (e.getLineNum() >= 0) {
        	attributes.put(IMarker.LINE_NUMBER, Integer.valueOf(e.getLineNum()));
        }
        try {
            IMarker marker = curFile.createMarker(QVTOProjectPlugin.PROBLEM_MARKER);
            marker.setAttributes(attributes);
        }
        catch (CoreException e1) {
            Logger.getLogger().log(Logger.WARNING, "QVTOBuilder: failed to create marker", e1);//$NON-NLS-1$
        }                   
    }


    private QVTOBuilderConfig getConfig() throws CoreException {
        if (myConfig == null) {
            myConfig = QVTOBuilderConfig.getConfig(getProject());            
        }
        return myConfig;
    }
    
    private IFile[] collectFiles(IProgressMonitor monitor) throws CoreException {
    	
        final ArrayList<IFile> result = new ArrayList<IFile>();
        getProject().refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 1));
        
        IContainer srcContainer = null;
        try {
        	srcContainer = QVTOBuilderConfig.getConfig(getProject()).getSourceContainer();
        } catch (CoreException e) {
        	QvtPlugin.getDefault().log(e.getStatus());
		}
        
        if(srcContainer == null || !srcContainer.exists()) {
        	return new IFile[0];
        }
        
        srcContainer.accept(new IResourceProxyVisitor() {
            public boolean visit(IResourceProxy proxy) throws CoreException {
                if(proxy.getType() == IResource.FILE) {
                    if(!MDAConstants.QVTO_FILE_EXTENSION.equals(proxy.requestFullPath().getFileExtension())) {
                        return false;
                    }
                    IFile file = (IFile) proxy.requestResource();
                    result.add(file);
                    return false;
                }
                return true;
            }
        }, IContainer.INCLUDE_TEAM_PRIVATE_MEMBERS);
        
        return (IFile[]) result.toArray(new IFile[result.size()]);
    }
    
    public static String getFileContents(IFile file) {
    	try {
    		return FileUtil.getStreamContents(file.getContents(), file.getCharset());
    	}
    	catch(Exception e) {
    		return ""; //$NON-NLS-1$
    	}
    }
    
    public static void addBuildListener(final BuildListener l) {
        ourListeners.add(l);
    }
    
    public static void removeBuildListener(final BuildListener l) {
        ourListeners.remove(l);
    }
        
    private static void fireBuildEvent() {
        for (BuildListener l : ourListeners) {
            l.buildPerformed();
        }
    }

    private boolean shouldSaveXMI() {
		try {
			ICommand buildCommand = NatureUtils.findCommand(getProject(), QVTOProjectPlugin.BUILDER_ID);
			if(buildCommand != null) {
				Map<?, ?> arguments = buildCommand.getArguments();
				// Remark: internal option for saving xmi, used for testing at the moment
				Object strValue = arguments.get(SAVE_AST_XMI);
				return Boolean.valueOf(String.valueOf(strValue));
			}
		} catch (CoreException e) {
			QVTOProjectPlugin.log(e);
		}

		return false;		
    }

}
