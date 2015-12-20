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
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.controls;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.m2m.internal.qvt.oml.common.ui.controls.UniSelectTransformationControl.ISelectionListener.TreeAction;
import org.eclipse.m2m.internal.qvt.oml.common.ui.dialogs.Messages;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.IElementCollector;
import org.eclipse.ui.progress.WorkbenchJob;

/**
 * @author sboyko
 */
public abstract class AbstractDeferredAdapter implements IDeferredWorkbenchAdapter {
	
	private volatile IProgressMonitor fetchMonitor;
	private final TreeViewer viewer;

	public AbstractDeferredAdapter(TreeViewer viewer) {
		this.viewer = viewer;
    }

    public abstract Object[] getChildren(Object o);
    
    public abstract boolean isAccepted(Object object, IProgressMonitor monitor);
    
    public abstract TreeAction getTreeAction(Object object, IProgressMonitor monitor);
    
	public void cancel() {
		WorkbenchJob updateJob = new WorkbenchJob(Messages.DeferredAdapter_cancelJob) {
			@Override
			public IStatus runInUIThread(IProgressMonitor updateMonitor) {
				final IProgressMonitor monitor = fetchMonitor;
				if (monitor != null) {
					monitor.setCanceled(true);
				}
				return Status.OK_STATUS;
			}
		};
		updateJob.setSystem(true);
		updateJob.schedule();
	}

    public void fetchDeferredChildren(Object object, IElementCollector collector, IProgressMonitor monitor) {
    	fetchMonitor = monitor;
        Object[] children = getChildren(object);
        monitor.beginTask(Messages.DeferredAdapter_loadingContents, children.length);
        for (Object child : children) {
            if (monitor.isCanceled()) {
            	break;
            }
            if (isAccepted(child, monitor)) {
            	collector.add(child, monitor);
                checkTreeAction(child, monitor);
            }
            monitor.worked(1);
        }
        monitor.done();
        collector.done();
        fetchMonitor = null;
    }

    private void checkTreeAction(final Object object, final IProgressMonitor monitor) {
    	final TreeAction treeAction = getTreeAction(object, monitor);
    	if (treeAction == TreeAction.NONE) {
    		return;
    	}
    	
		WorkbenchJob updateJob = new WorkbenchJob(Messages.DeferredAdapter_expandNode) {
			@Override
			public IStatus runInUIThread(IProgressMonitor updateMonitor) {
				if (!viewer.getControl().isDisposed()) {
					if (treeAction == TreeAction.EXPAND) {
						viewer.expandToLevel(object, 1);
					}
					if (treeAction == TreeAction.SELECT) {
						viewer.setSelection(new StructuredSelection(object), true);
						viewer.getTree().showSelection();
					}
				}
				return Status.OK_STATUS;
			}
		};
		updateJob.setSystem(true);
		updateJob.schedule();
	}

	public ISchedulingRule getRule(Object arg0) {
    	return null;//new BatchSimilarSchedulingRule("transformation.tree.rule"); //$NON-NLS-1$
    }

    public boolean isContainer() {
        return true;
    }

    public ImageDescriptor getImageDescriptor(Object object) {
        return null;
    }

    public Object getParent(Object o) {
        return null;
    }

//    /**
//     * A simple job scheduling rule.
//     */
//    private class BatchSimilarSchedulingRule implements ISchedulingRule {
//        public BatchSimilarSchedulingRule(String id) {
//        	myId = id;
//        }
//
//        /*
//         * @see org.eclipse.core.runtime.jobs.ISchedulingRule#isConflicting(org.eclipse.core.runtime.jobs.ISchedulingRule)
//         */
//        public boolean isConflicting(ISchedulingRule rule) {
////            if (rule instanceof BatchSimilarSchedulingRule) {
////                return ((BatchSimilarSchedulingRule) rule).myId.equals(myId);
////            }
//            return false;
//        }
//
//        /*
//         * @see org.eclipse.core.runtime.jobs.ISchedulingRule#contains(org.eclipse.core.runtime.jobs.ISchedulingRule)
//         */
//        public boolean contains(ISchedulingRule rule) {
//            return this == rule;
//        }
//
//        final String myId;
//    }
}
