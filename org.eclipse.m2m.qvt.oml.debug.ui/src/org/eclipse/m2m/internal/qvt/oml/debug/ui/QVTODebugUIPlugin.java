/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;


/**
 * The activator class controls the plug-in life cycle
 */
public class QVTODebugUIPlugin extends AbstractUIPlugin {

	// The plug-in fBreakpointID
	public static final String PLUGIN_ID = "org.eclipse.m2m.qvt.oml.debug.ui"; //$NON-NLS-1$
	
	public static final String DEBUG_EDITOR_ID  = "org.eclipse.m2m.qvt.oml.editor.ui.QvtEditor"; //$NON-NLS-1$	

	// The shared instance
	private static QVTODebugUIPlugin plugin;

	/**
	 * The constructor
	 */
	public QVTODebugUIPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static QVTODebugUIPlugin getDefault() {
		return plugin;
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void log(Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, 100001,
				"Unexpected exception caught", e)); //$NON-NLS-1$
	}

	public static IStatus createStatus(int severity, String message) {
		return new Status(severity, PLUGIN_ID, 0, message, null);
	}

	public static IStatus createErrorStatus(String message) {
		return createStatus(IStatus.ERROR, message);
	}

	/**
	 * Returns the active workbench window
	 * 
	 * @return the active workbench window
	 */
	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}

	/**
	 * Returns the active workbench shell or <code>null</code> if none
	 * 
	 * @return the active workbench shell or <code>null</code> if none
	 */
	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}

	public static void statusDialog(IStatus status) {
		switch (status.getSeverity()) {
		case IStatus.ERROR:
			statusDialog(DebugUIMessages.StatusDialog_Error, status);
			break;
		case IStatus.WARNING:
			statusDialog(DebugUIMessages.StatusDialog_Warning, status);
			break;
		case IStatus.INFO:
			statusDialog(DebugUIMessages.StatusDialog_Information,
					status);
			break;
		}
	}

	public static void statusDialog(String title, IStatus status) {
		Shell shell = getActiveWorkbenchShell();
		if (shell != null) {
			switch (status.getSeverity()) {
			case IStatus.ERROR:
				ErrorDialog.openError(shell, title, null, status);
				break;
			case IStatus.WARNING:
				MessageDialog.openWarning(shell, title, status.getMessage());
				break;
			case IStatus.INFO:
				MessageDialog
						.openInformation(shell, title, status.getMessage());
				break;
			}
		}
	}

	public static final Display getStandardDisplay() {
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		return display;
	}
	
	@Override
	protected ImageRegistry createImageRegistry() {
		ImageRegistry imageRegistry = super.createImageRegistry();
		imageRegistry.put(QVTODebugImages.LOCAL_VARIABLE, imageDescriptor("localvar_obj.gif")); //$NON-NLS-1$		
		imageRegistry.put(QVTODebugImages.THIS_VARIABLE, imageDescriptor("thisvar_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTODebugImages.PREDEFINED_VARIABLE, imageDescriptor("predefvar_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTODebugImages.MODEL_PARAMETER, imageDescriptor("modelpar_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTODebugImages.ATTRIBUTE, imageDescriptor("attribute_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTODebugImages.REFERENCE, imageDescriptor("reference_obj.gif")); //$NON-NLS-1$
		imageRegistry.put(QVTODebugImages.COLLECTION_ELEMENT, imageDescriptor("index_element_obj.gif")); //$NON-NLS-1$
		
		imageRegistry.put(QVTODebugImages.INTERM_PROPERTY,				
				overlayImage("intermprop_ovr.gif", //$NON-NLS-1$ 
						imageRegistry.get(QVTODebugImages.ATTRIBUTE),
						IDecoration.BOTTOM_RIGHT));		
		
		imageRegistry.put(QVTODebugImages.CONDITIONAL_BPNT_ENABLED,
				overlayImage("conditional_ovr.gif", //$NON-NLS-1$ 
						DebugUITools.getImage(IDebugUIConstants.IMG_OBJS_BREAKPOINT),
						IDecoration.TOP_LEFT));
		imageRegistry.put(QVTODebugImages.CONDITIONAL_BPNT_DISABLED,
				overlayImage(
						"conditional_ovr_disabled.gif", //$NON-NLS-1$
						DebugUITools.getImage(IDebugUIConstants.IMG_OBJS_BREAKPOINT_DISABLED),
						IDecoration.TOP_LEFT));

		return imageRegistry;
	}

	private ImageDescriptor imageDescriptor(String imagePath) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + imagePath); //$NON-NLS-1$
	}
	
    private final ImageDescriptor overlayImage(String overImagePath, Image base, int quadrant) {
        ImageDescriptor decorator = imageDescriptor(overImagePath);
        return new DecorationOverlayIcon(base, decorator, quadrant);
    }	
}