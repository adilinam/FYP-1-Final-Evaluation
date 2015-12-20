/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.samples.ui;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.m2m.internal.qvt.oml.samples.QVTSamplesPlugin;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.IOverwriteQuery;
import org.eclipse.ui.wizards.datatransfer.ImportOperation;
import org.eclipse.ui.wizards.datatransfer.ZipFileStructureProvider;
import org.osgi.framework.Bundle;


/**
 * Sample project creation operation
 */
public class SampleProjectsCreationOperation implements IRunnableWithProgress {

	protected static abstract class OverwriteQuery implements IOverwriteQuery {

		public OverwriteQuery(final Shell shell) {
			myShell = shell;
		}
		
		public String queryOverwrite(final String file) {
	         String[] returnCodes = getReturnCodes();
	         int returnVal = openDialog(file);
	         return returnVal < 0 ? CANCEL : returnCodes[returnVal];
		}   
	    
		protected abstract String[] getOptions();
		
		protected abstract String[] getReturnCodes();
		
		protected int getDefaultIndex() {
			return 0;
		}
		
	    private int openDialog(final String file) {
	        final int[] result = { IDialogConstants.CANCEL_ID };
	        myShell.getDisplay().syncExec(new Runnable() {
	            public void run() {
	                String title = Messages.SampleProjectsCreationOperation_overwrite_title;
                    String msg = NLS.bind(Messages.SampleProjectsCreationOperation_overwrite_message, file);
	                MessageDialog dialog = new MessageDialog(myShell, title, null, msg, 
	                		MessageDialog.QUESTION, getOptions(), getDefaultIndex());
	                result[0] = dialog.open();
	            }
	        });
	        return result[0];
	    }
	     
	    private final Shell myShell;
	}
	
    public SampleProjectsCreationOperation(SampleProject project, final Shell shell) {
        myOverwriteQuery = createOverwriteQuery(shell);
        myProjectOverwriteQuery = createProjectOverwriteQuery(shell);
        myProject = project;
    }

    public IProject getCreatedProject() {
		return myCreatedProject;
	}
    
    public void run(final IProgressMonitor monitor) throws InvocationTargetException {
        try {
            IWorkspaceRunnable op = new IWorkspaceRunnable() {
                public void run(IProgressMonitor localMonitor) throws CoreException {
                    localMonitor.beginTask(Messages.SampleProjectsCreationOperation_creatingProjects, 4);  
                    try {
                        myCreatedProject = importProject(myProject, new SubProgressMonitor(localMonitor, 4));
                        myCreatedProject.build(IncrementalProjectBuilder.FULL_BUILD, new SubProgressMonitor(localMonitor, 1));
                    }
                    catch (InterruptedException e) {
                        throw new OperationCanceledException();
                    }
                    catch (InvocationTargetException e) {
                        throwCoreException(e);
                    }
                }
            };
            ResourcesPlugin.getWorkspace().run(op, monitor);
        } catch (CoreException e) {
            throw new InvocationTargetException(e);
        } catch (OperationCanceledException e) {
            throw e;
        } finally {
            monitor.done();
        }
    }
    
    protected IOverwriteQuery createOverwriteQuery(final Shell shell) {
        return new OverwriteQuery(shell) {
        	@Override
			protected String[] getOptions() {
        		return new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, 
        				IDialogConstants.YES_TO_ALL_LABEL, IDialogConstants.CANCEL_LABEL };
        	}
        	
        	@Override
			protected String[] getReturnCodes() {
        		return new String[] { YES, NO, ALL, CANCEL };
        	}
        };
    }
    
    protected IOverwriteQuery createProjectOverwriteQuery(final Shell shell) {
    	return new OverwriteQuery(shell) {
        	@Override
			protected String[] getOptions() {
        		return new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, 
        				IDialogConstants.CANCEL_LABEL };
        	}
        	
        	@Override
			protected String[] getReturnCodes() {
        		return new String[] { YES, NO, CANCEL };
        	}
        };
    }
    
    private void throwCoreException(final InvocationTargetException e) throws CoreException {
        Status status= new Status(IStatus.ERROR, 
        		QVTSamplesPlugin.ID,
                IStatus.OK,
                e.getMessage(),
                e.getCause());
        throw new CoreException(status);
    }

    /**
     * Creates new sample project using specified <code>sampleProject</code>
     */
    private IProject importProject(final SampleProject sampleProject,
			final IProgressMonitor monitor) throws CoreException,
			InvocationTargetException, InterruptedException {
		String path = sampleProject.getArchive();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		IProject project = root.getProject(sampleProject.getName());
		if (project.exists()) {
			final String overwrite = myProjectOverwriteQuery
					.queryOverwrite(project.getName());
			if (IOverwriteQuery.YES.equals(overwrite)
					|| IOverwriteQuery.ALL.equals(overwrite)) {
				project.delete(true, true, new SubProgressMonitor(monitor, 1));
				project = root.getProject(sampleProject.getName());
			} else if (IOverwriteQuery.NO.equals(overwrite)
					|| IOverwriteQuery.NO_ALL.equals(overwrite)) {
				return project;
			} else {
				throw new OperationCanceledException();
			}
		}
		
		project.create(new SubProgressMonitor(monitor, 1));
		project.open(new NullProgressMonitor());
		
		Bundle bundle = Platform.getBundle(sampleProject.getNamespace());
		ZipFile zipFile = getZipFileFromPluginDir(path, bundle);
		importFilesFromZip(zipFile, project.getFullPath(), new SubProgressMonitor(monitor, 1));
		createSampleManifest(project, sampleProject, new SubProgressMonitor(
				monitor, 1));
		IProjectDescription description = project.getDescription();

		String tempName = "temp" + System.currentTimeMillis(); //$NON-NLS-1$
		while (root.getProject(tempName).exists()) {
			tempName += System.currentTimeMillis();
		}
		description.setName(tempName);
		project.setDescription(description, null);
		description.setName(sampleProject.getName());
		project.setDescription(description, null);
		return project;
	}

    private IFile createSampleManifest(final IProject project,
            final SampleProject sampleProject, final IProgressMonitor monitor)
            throws CoreException {
        IFile file = project.getFile(SAMPLE_PROPERTIES);
        if (!file.exists()) {
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                Properties properties = new Properties();
                createSampleManifestContent(sampleProject, properties);
                properties.store(out, ""); //$NON-NLS-1$
                out.flush();
                String contents = out.toString();
                out.close();
                ByteArrayInputStream stream = new ByteArrayInputStream(contents
                        .getBytes("UTF8")); //$NON-NLS-1$
                file.create(stream, true, monitor);
                stream.close();
            } catch (UnsupportedEncodingException e) {
            } catch (IOException e) {
            }
        }
        return file;
    }

    private void createSampleManifestContent(final SampleProject sampleProject,
            final Properties properties) {
        writeProperty(properties, "name", sampleProject.getName()); //$NON-NLS-1$ 
        writeProperty(properties, "projectName", sampleProject.getName()); //$NON-NLS-1$
        writeProperty(properties, "description", sampleProject.getDescription()); //$NON-NLS-1$
        writeProperty(properties, "helpHref", sampleProject.getHelpHref()); //$NON-NLS-1$
    }

    private void writeProperty(final Properties properties, final String name, 
            final String value) {
        if (value == null) {
            return;
        }
        properties.setProperty(name, value);
    }

    private ZipFile getZipFileFromPluginDir(final String pluginRelativePath, final Bundle bundle) throws CoreException {
        try {
            URL entry = FileLocator.find(bundle, new Path(pluginRelativePath), null);
            if(entry == null) {
                throw new IllegalArgumentException(NLS.bind(Messages.SampleProjectsCreationOperation_NoEntry, pluginRelativePath, bundle));
            }
            return new ZipFile(FileLocator.toFileURL(entry).getFile());
        } catch (Exception e) {
            String message = pluginRelativePath + ": " + e.getMessage(); //$NON-NLS-1$
            Status status = new Status(IStatus.ERROR, QVTSamplesPlugin.ID,
                    IStatus.ERROR, message, e);
            throw new CoreException(status);
        }
    }

    private void importFilesFromZip(final ZipFile srcZipFile, final IPath destPath,
            final IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
        ZipFileStructureProvider structureProvider = new ZipFileStructureProvider(
                srcZipFile);
        ImportOperation op = new ImportOperation(destPath, structureProvider.getRoot(), structureProvider, myOverwriteQuery);
        op.run(monitor);
    }
    
    private IProject myCreatedProject;
    private final SampleProject myProject;
    private final IOverwriteQuery myOverwriteQuery;
    private final IOverwriteQuery myProjectOverwriteQuery;
    
    private static final String SAMPLE_PROPERTIES = "sample.properties"; //$NON-NLS-1$
}