/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.qvt.oml.tools.coverage.Activator;
import org.eclipse.m2m.qvt.oml.tools.coverage.ui.CoveragePlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

public class CoverageView extends ViewPart {

    public static final String VIEW_ID = "org.eclipse.m2m.qvt.oml.tools.coverage.ui.coverageView";

    protected static final int COLUMN_ELEMENT = 0;

    private TreeViewer viewer;
    private CoverageModel coverageModel;
    private Composite myParent;

    public CoverageView() {
    }

    @Override
    public void createPartControl(Composite parent) {
        myParent = parent;
        loadViewer();
    }

    private void loadViewer() {
        viewer = new TreeViewer(myParent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        viewer.getTree().setHeaderVisible(true);
        viewer.getTree().setLinesVisible(true);

        TreeViewerColumn column0 = new TreeViewerColumn(viewer, SWT.LEFT);
        column0.getColumn().setText("Module");
        column0.getColumn().setWidth(200);
        column0.setLabelProvider(new PathLabelProvider());

        TreeViewerColumn column00 = new TreeViewerColumn(viewer, SWT.LEFT);
        column00.getColumn().setText("Total function coverage");
        column00.getColumn().setWidth(150);
        column00.setLabelProvider(new TotalLabelProvider());

        TreeViewerColumn column1 = new TreeViewerColumn(viewer, SWT.LEFT);
        column1.getColumn().setText("Mapping Coverage");
        column1.getColumn().setWidth(130);
        column1.setLabelProvider(new MappingLabelProvider());

        TreeViewerColumn column2 = new TreeViewerColumn(viewer, SWT.LEFT);
        column2.getColumn().setText("Helper Coverage");
        column2.getColumn().setWidth(130);
        column2.setLabelProvider(new HelperLabelProvider());

        TreeViewerColumn column3 = new TreeViewerColumn(viewer, SWT.LEFT);
        column3.getColumn().setText("Constructor Coverage");
        column3.getColumn().setWidth(130);
        column3.setLabelProvider(new ConstructorLabelProvider());

        TreeViewerColumn column4 = new TreeViewerColumn(viewer, SWT.LEFT);
        column4.getColumn().setText("Estimated Expression Coverage");
        column4.getColumn().setWidth(200);
        column4.setLabelProvider(new ExpressionLabelProvider());

        viewer.setContentProvider(new ViewContentProvider());
        viewer.addDoubleClickListener(new TransformationClickListener());
    }

    public void clear() {
        removeMarkers();
        //update(new CoverageModel(new CoverageData()));
    }

    private void removeMarkers() {
    	if (coverageModel == null) {
    		return;
    	}
    	
        for (ProjectCoverageModel pcm : coverageModel.getProjectModels()) {
            for (TransformationCoverageModel tcm : pcm.getTransformationModels()) {
                IFile file = tcm.getFile();
                CoverageAnnotator annotator = new CoverageAnnotator();
                annotator.removeAnnotations(file);
            }
        }
    }

    public void setLoading(boolean loading) {
        if (loading) {
            viewer.getTree().setLinesVisible(false);
        } else {
            viewer.getTree().setLinesVisible(true);
        }
    }

    public void update(CoverageModel model) {
        if (viewer == null) {
            loadViewer();
        }
        
       	removeMarkers();

        coverageModel = model;
        viewer.setInput(coverageModel);

        viewer.expandAll();
    }

    class TransformationClickListener implements IDoubleClickListener {
		@Override
        public void doubleClick(DoubleClickEvent event) {

            IStructuredSelection thisSelection = (IStructuredSelection) event.getSelection();
            Object selectedElement = thisSelection.getFirstElement();

            if (selectedElement instanceof TransformationCoverageModel) {
                final TransformationCoverageModel transformationModel = (TransformationCoverageModel) selectedElement;

                // Annotate expressions
                final IFile file = transformationModel.getFile();
                final CoverageAnnotator annotator = new CoverageAnnotator();

                annotator.annotateTouched(file, transformationModel.getTouchedRanges());
                annotator.annotateUntouched(file, transformationModel.getUntouchedRanges());

                // Open
                try {
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                	Activator.error("Failed to activate coveraged file", e);
                }
            }

        }
    }

    class ViewContentProvider implements ITreeContentProvider {

        @Override
        public void dispose() {
        }

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        @Override
        public Object[] getElements(Object inputElement) {
            return coverageModel.getProjectModels();
        }

        @Override
        public Object[] getChildren(Object parentElement) {
            if (parentElement instanceof ProjectCoverageModel) {
                return ((ProjectCoverageModel) parentElement).getTransformationModels();
            }
            return null;
        }

        @Override
        public Object getParent(Object element) {
            return null;
        }

        @Override
        public boolean hasChildren(Object element) {
            if (element instanceof ProjectCoverageModel) {
                return true;
            }
            return false;
        }

    }

    class PathLabelProvider extends ColumnLabelProvider {
        @Override
        public String getText(Object element) {
            if (element instanceof ProjectCoverageModel) {
                return ((ProjectCoverageModel) element).getProject().getName();
            } else if (element instanceof TransformationCoverageModel) {
                return ((TransformationCoverageModel) element).getModule().getName();
            }
            return "";
        }

    }

    abstract class ColoredLabelProvider extends ColumnLabelProvider {

        public abstract int getUntouchedNodesCount(ProjectCoverageModel model);

        public abstract int getTouchedNodesCount(ProjectCoverageModel model);

        public abstract int getUntouchedNodesCount(TransformationCoverageModel model);

        public abstract int getTouchedNodesCount(TransformationCoverageModel model);

        @Override
        public String getText(Object element) {
            if (element instanceof ProjectCoverageModel) {
                return formatCoverage(getUntouchedNodesCount((ProjectCoverageModel) element),
                        getTouchedNodesCount((ProjectCoverageModel) element));
            } else if (element instanceof TransformationCoverageModel) {
                return formatCoverage(getUntouchedNodesCount((TransformationCoverageModel) element),
                        getTouchedNodesCount((TransformationCoverageModel) element));
            }
            return "";
        }

        @Override
        public Color getBackground(Object element) {

            int touched = 0;
            int untouched = 0;

            if (element instanceof TransformationCoverageModel) {
                touched = getTouchedNodesCount((TransformationCoverageModel) element);
                untouched = getUntouchedNodesCount((TransformationCoverageModel) element);
            } else if (element instanceof ProjectCoverageModel) {
                touched = getTouchedNodesCount((ProjectCoverageModel) element);
                untouched = getUntouchedNodesCount((ProjectCoverageModel) element);
            }

            double percent = computePercent(touched + untouched, touched);
            if (percent * 100 >= CoveragePlugin.getDefault().getPreferenceStore()
                    .getInt(CoveragePlugin.HIGH_THRESHOLD_PREFERENCE)) {
                // green
                return new Color(Display.getCurrent(), 154, 205, 50);
            } else if (percent * 100 < CoveragePlugin.getDefault().getPreferenceStore()
                    .getInt(CoveragePlugin.LOW_THRESHOLD_PREFERENCE)) {
                // red
                return new Color(Display.getCurrent(), 250, 128, 114);
            }
            return super.getBackground(element);

        }

        @Override
        public Font getFont(Object element) {

            if (element instanceof ProjectCoverageModel) {
                Font afont = new Font(Display.getCurrent(), "Arial", 8, SWT.BOLD);
                return afont;
            }

            return super.getFont(element);

        }
    }

    class TotalLabelProvider extends ColoredLabelProvider {

        @Override
        public int getTouchedNodesCount(TransformationCoverageModel model) {
            return model.getTouchedMappingNodes().size() + model.getTouchedHelperNodes().size()
                    + model.getTouchedConstructorNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(TransformationCoverageModel model) {
            return model.getUntouchedMappingNodes().size() + model.getUntouchedHelperNodes().size()
                    + model.getUntouchedConstructorNodes().size();
        }

        @Override
        public int getTouchedNodesCount(ProjectCoverageModel model) {
            return model.getTouchedMappingNodes().size() + model.getTouchedHelperNodes().size()
                    + model.getTouchedConstructorNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(ProjectCoverageModel model) {
            return model.getUntouchedMappingNodes().size() + model.getUntouchedHelperNodes().size()
                    + model.getUntouchedConstructorNodes().size();
        }
    }

    class MappingLabelProvider extends ColoredLabelProvider {

        @Override
        public int getTouchedNodesCount(TransformationCoverageModel model) {
            return model.getTouchedMappingNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(TransformationCoverageModel model) {
            return model.getUntouchedMappingNodes().size();
        }

        @Override
        public int getTouchedNodesCount(ProjectCoverageModel model) {
            return model.getTouchedMappingNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(ProjectCoverageModel model) {
            return model.getUntouchedMappingNodes().size();
        }

    }

    class HelperLabelProvider extends ColoredLabelProvider {

        @Override
        public int getTouchedNodesCount(TransformationCoverageModel model) {
            return model.getTouchedHelperNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(TransformationCoverageModel model) {
            return model.getUntouchedHelperNodes().size();
        }

        @Override
        public int getTouchedNodesCount(ProjectCoverageModel model) {
            return model.getTouchedHelperNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(ProjectCoverageModel model) {
            return model.getUntouchedHelperNodes().size();
        }
    }

    class ConstructorLabelProvider extends ColoredLabelProvider {
        @Override
        public int getTouchedNodesCount(TransformationCoverageModel model) {
            return model.getTouchedConstructorNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(TransformationCoverageModel model) {
            return model.getUntouchedConstructorNodes().size();
        }

        @Override
        public int getTouchedNodesCount(ProjectCoverageModel model) {
            return model.getTouchedConstructorNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(ProjectCoverageModel model) {
            return model.getUntouchedConstructorNodes().size();
        }
    }

    class ExpressionLabelProvider extends ColoredLabelProvider {
        @Override
        public int getTouchedNodesCount(TransformationCoverageModel model) {
            return model.getTouchedExpressionNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(TransformationCoverageModel model) {
            return model.getUntouchedExpressionNodes().size();
        }

        @Override
        public int getTouchedNodesCount(ProjectCoverageModel model) {
            return model.getTouchedExpressionNodes().size();
        }

        @Override
        public int getUntouchedNodesCount(ProjectCoverageModel model) {
            return model.getUntouchedExpressionNodes().size();
        }
    }

    private String formatCoverage(int untouched, int touched) {
        int total = untouched + touched;
        double percent = computePercent(total, touched);

        return (int) (percent * 100) + "% (" + touched + " of " + total + ")";
    }

    private double computePercent(int total, int touched) {
        double percent;
        if (total == 0) {
            percent = 1;
        } else {
            percent = (double) touched / total;
        }

        return percent;
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
    	clear();
        myParent = null;
    }

}
