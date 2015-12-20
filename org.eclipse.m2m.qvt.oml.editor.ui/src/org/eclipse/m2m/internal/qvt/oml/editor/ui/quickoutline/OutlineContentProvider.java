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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.swt.widgets.Tree;

public class OutlineContentProvider implements ITreeContentProvider {
    private final QvtOutlineInformationControl myQvtOutlineInformationControl;
    private boolean isShowImportedInfo;        
    private QvtCompletionData myQvtCompletionData;

    /**
     * Creates a new Outline content provider.
     * @param qvtOutlineInformationControl 
     *
     * @param showInheritedMembers <code>true</code> iff inherited members are shown
     */
    public OutlineContentProvider(QvtOutlineInformationControl qvtOutlineInformationControl, boolean showInheritedMembers) {
        myQvtOutlineInformationControl = qvtOutlineInformationControl;
        isShowImportedInfo= showInheritedMembers;
    }

    public boolean isShowingImportedMembers() {
        return isShowImportedInfo;
    }

    public void toggleShowInheritedMembers() {
        TreeViewer treeViewer = myQvtOutlineInformationControl.getTreeViewer();
        Tree tree = treeViewer.getTree();

        tree.setRedraw(false);
        isShowImportedInfo = !isShowImportedInfo;
        treeViewer.refresh();
        treeViewer.expandToLevel(2);

        // reveal selection
        Object selectedElement = myQvtOutlineInformationControl.getSelectedElement();
        if (selectedElement != null)
            treeViewer.reveal(selectedElement);

        tree.setRedraw(true);
    }

    public Object[] getChildren(Object element) {
    	List<Object> children = new ArrayList<Object>();
        if (QvtElementProvider.FAKE_ROOT == element) {
            if (isShowImportedInfo) {
            	children.addAll(Arrays.asList(myQvtCompletionData.getAllMappingModulesCS()));
           } else {
                MappingModuleCS currentMappingModuleCS = myQvtCompletionData.getCurrentMappingModuleCS();
                if (currentMappingModuleCS != null) {
                	children.add(currentMappingModuleCS); 
                }
            }
        } else if (element instanceof MappingModuleCS) {
            MappingModuleCS mappingModuleCS = (MappingModuleCS) element;
            children.addAll(mappingModuleCS.getProperties());
            children.addAll(mappingModuleCS.getMethods());
            children.addAll(mappingModuleCS.getClassifierDefCS());
        } else if (element instanceof ClassifierDefCS) {
        	ClassifierDefCS mappingModuleCS = (ClassifierDefCS) element;
            children.addAll(mappingModuleCS.getProperties());
        }
        if (myQvtOutlineInformationControl.getStringMatcher() != null) {
            List<Object> filteredChildren = new ArrayList<Object>();
            for (Object child : children) {
                if (myQvtOutlineInformationControl.isStringMatcherOk(child) 
                		|| hasChildren(child)) {
                	filteredChildren.add(child);
                }
            }
            children = filteredChildren;
        }
        return children.toArray();
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        QvtEditor editor = myQvtOutlineInformationControl.getEditor();
    	UnitProxy unitProxy = (UnitProxy) editor.getAdapter(UnitProxy.class);
    	if(unitProxy == null) {
        	//FIXME:AF: what should be done here?
    	} else {
    		myQvtCompletionData = new QvtCompletionData(editor,
                    myQvtOutlineInformationControl.getSourceViewer(), unitProxy, 0);
    	}
    }

    public void dispose() {
    }

    public Object getParent(Object element) {
        return null;
    }

    public boolean hasChildren(Object element) {
        return getChildren(element).length != 0;
    }

    public Object[] getElements(Object inputElement) {
        return getChildren(inputElement);
    }
}