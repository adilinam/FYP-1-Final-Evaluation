/*******************************************************************************
 * Copyright (c) 2010 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.debug.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugElement;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.core.model.IWatchExpression;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IDebugUIConstants;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOVariable;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Mostly identical to WatchAction from JDT
 */
public class QVTOWatchAction implements IPartListener, IWorkbenchWindowActionDelegate, IEditorActionDelegate{

    private IAction fAction;
    private IWorkbenchPart fTargetPart;
    private IWorkbenchWindow fWindow;
    private Object fSelection;
    private IRegion fRegion;
    
    /**
     * The new target part to use with the evaluation completes.
     */
    private IWorkbenchPart fNewTargetPart= null;
    
    /**
     * Used to resolve editor input for selected stack frame
     */
    private IDebugModelPresentation fPresentation;
            
    public QVTOWatchAction() {
        super();
    }
    
    private void run() {
        Object selectedObject= fSelection;
        if (selectedObject instanceof IStructuredSelection) {
            IStructuredSelection selection = (IStructuredSelection) selectedObject;
            Iterator<?> elements = selection.iterator();
            while (elements.hasNext()) {
                try {
                    createWatchExpression(((IVariable) elements.next()).getName());
                }
                catch (DebugException e) {
    				QVTODebugCore.log(e);
                    return;
                }
            }
            
            showExpressionView();
        }
        else if (selectedObject instanceof String) {
            createWatchExpression((String) selectedObject);
            showExpressionView();
        }
    }

    /**
     * Make the expression view visible or open one
     * if required.
     */
    private void showExpressionView() {
        if (getTargetPart().getSite().getId().equals(IDebugUIConstants.ID_EXPRESSION_VIEW)) {
            return;
        }
        IWorkbenchPage page = getActivePage();
        if (page != null) {
            IViewPart part = page.findView(IDebugUIConstants.ID_EXPRESSION_VIEW);
            if (part == null) {
                try {
                    page.showView(IDebugUIConstants.ID_EXPRESSION_VIEW);
                }
                catch (PartInitException e) {
                    reportError(e.getStatus().getMessage());
                }
            } else {
                page.bringToTop(part);
            }
        }
    }
    
    private void createWatchExpression(String expr) {
        IWatchExpression expression= DebugPlugin.getDefault().getExpressionManager().newWatchExpression(expr);
        DebugPlugin.getDefault().getExpressionManager().addExpression(expression);
        IAdaptable object = DebugUITools.getDebugContext();
        IDebugElement context= null;
        if (object instanceof IDebugElement) {
            context = (IDebugElement) object;
        }
        else if (object instanceof ILaunch) {
            context = ((ILaunch) object).getDebugTarget();
        }
        expression.setExpressionContext(context);
    }
    
    private static IWorkbenchWindow getActiveWorkbenchWindow() {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    }   
    
    private static IWorkbenchPage getActivePage() {
        IWorkbenchWindow w = getActiveWorkbenchWindow();
        if (w != null) {
            return w.getActivePage();
        }
        return null;
    }

    private void reportError(String message) {
        throw new RuntimeException(message); 
    }
    
    /** 
     * Disposes this action's debug model presentation, if
     * one was created.
     */
    private void disposeDebugModelPresentation() {
        if (fPresentation != null) {
            fPresentation.dispose();
        }
    }

    private void setWindow(IWorkbenchWindow window) {
        fWindow = window;
    }
    
    private void setNewTargetPart(IWorkbenchPart newTargetPart) {
        fNewTargetPart = newTargetPart;
    }
    
    private void setTargetPart(IWorkbenchPart part) {
        fTargetPart= part;
    }

    private void setSelectedObject(Object selection) {
        fSelection = selection;
    }
    
    private IWorkbenchPart getTargetPart() {
        return fTargetPart;
    }

    private void setAction(IAction action) {
        fAction = action;
    }
    
    private ISelection getTargetSelection() {
        IWorkbenchPart part = getTargetPart();
        if (part != null) {
            ISelectionProvider provider = part.getSite().getSelectionProvider();
            if (provider != null) {
                return provider.getSelection();
            }
        }
        return null;
    }
    
    private boolean textHasContent(String text) {
        if (text != null) {
            int length= text.length();
            if (length > 0) {
                for (int i= 0; i < length; i++) {
                    if (Character.isLetterOrDigit(text.charAt(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private Object resolveSelectedObjectUsingToken(Object selectedObject, ITextSelection ts, IEditorPart editor) {
        ITextEditor textEditor= (ITextEditor) editor;
        IDocument doc= textEditor.getDocumentProvider().getDocument(editor.getEditorInput());
        fRegion= JavaWordFinder.findWord(doc, ts.getOffset());
        if (fRegion != null) {
            try {
                selectedObject= doc.get(fRegion.getOffset(), fRegion.getLength());
            }
            catch (BadLocationException e) {
            }
        }
        return selectedObject;
    }

    /**
     * Resolves the selected object in the target part, or <code>null</code>
     * if there is no selection.
     */
    private void resolveSelectedObject() {
        Object selectedObject= null;
        fRegion = null;
        ISelection selection= getTargetSelection();
        if (selection instanceof ITextSelection) {
            ITextSelection ts = (ITextSelection)selection;
            String text= ts.getText();
            if (textHasContent(text)) {
                selectedObject= text;
                fRegion = new Region(ts.getOffset(), ts.getLength());
            }
            else if (getTargetPart() instanceof IEditorPart) {
                IEditorPart editor= (IEditorPart) getTargetPart();
                if (editor instanceof ITextEditor) {
                    selectedObject = resolveSelectedObjectUsingToken(selectedObject, ts, editor);
                }
            }
        }
        else if (selection instanceof IStructuredSelection) {
            if (!selection.isEmpty()) {
                if (getTargetPart().getSite().getId().equals(IDebugUIConstants.ID_DEBUG_VIEW)) {
                    //work on the editor selection
                    IEditorPart editor= getTargetPart().getSite().getPage().getActiveEditor();
                    setTargetPart(editor);
                    selection= getTargetSelection();
                    if (selection instanceof ITextSelection) {
                        ITextSelection ts = (ITextSelection)selection;
                        String text= ts.getText();
                        if (textHasContent(text)) {
                            selectedObject= text;
                        }
                        else if (editor instanceof ITextEditor) {
                            selectedObject = resolveSelectedObjectUsingToken(selectedObject, ts, editor);
                        }
                    }
                } else {
                    IStructuredSelection ss= (IStructuredSelection)selection;
                    Iterator<?> elements = ss.iterator();
                    while (elements.hasNext()) {
                        if (!(elements.next() instanceof QVTOVariable)) {
                            setSelectedObject(null);
                            return;
                        }
                    }
                    selectedObject= ss;
                }           
            }
        }
        setSelectedObject(selectedObject);
    }

    /**
     * Updates the enabled state of the action that this is a
     * delegate for.
     */
    private void update() {
        if (fAction != null) {
            resolveSelectedObject();
        }
    }
    
    public void dispose() {
        disposeDebugModelPresentation();
        IWorkbenchWindow win = fWindow;
        if (win != null) {
            win.getPartService().removePartListener(this);
        }
    }

    public void init(IWorkbenchWindow window) {
        setWindow(window);
        IWorkbenchPage page= window.getActivePage();
        if (page != null) {
            setTargetPart(page.getActivePart());
        }
        window.getPartService().addPartListener(this);
        update();
    }

    public void run(IAction action) {
        update();
        run();        
    }

    public void selectionChanged(IAction action, ISelection selection) { 
        setAction(action);
    }   

    /**
     * @see IPartListener#partActivated(IWorkbenchPart)
     */
    public void partActivated(IWorkbenchPart part) {
        setTargetPart(part);
    }

    /**
     * @see IPartListener#partBroughtToTop(IWorkbenchPart)
     */
    public void partBroughtToTop(IWorkbenchPart part) {
    }

    /**
     * @see IPartListener#partClosed(IWorkbenchPart)
     */
    public void partClosed(IWorkbenchPart part) {
        if (part == getTargetPart()) {
            setTargetPart(null);
        }
        if (part == fNewTargetPart) {
            setNewTargetPart(null);
        }
    }

    /**
     * @see IPartListener#partDeactivated(IWorkbenchPart)
     */
    public void partDeactivated(IWorkbenchPart part) {
    }

    /**
     * @see IPartListener#partOpened(IWorkbenchPart)
     */
    public void partOpened(IWorkbenchPart part) {
    }
    
    public void setActiveEditor(IAction action, IEditorPart targetEditor) {
        setAction(action);
        setTargetPart(targetEditor);
    }

    private static class JavaWordFinder {
        
        public static IRegion findWord(IDocument document, int offset) {
            
            int start= -1;
            int end= -1;
            
            
            try {
                
                int pos= offset;
                char c;
                
                while (pos >= 0) {
                    c= document.getChar(pos);
                    if (!Character.isJavaIdentifierPart(c)) {
                        break;
                    }
                    --pos;
                }
                
                start= pos;
                
                pos= offset;
                int length= document.getLength();
                
                while (pos < length) {
                    c= document.getChar(pos);
                    if (!Character.isJavaIdentifierPart(c)) {
                        break;
                    }
                    ++pos;
                }
                
                end= pos;
                
            }
            catch (BadLocationException x) {
            }
            
            if (start > -1 && end > -1) {
                if (start == offset && end == offset) {
                    return new Region(offset, 0);
                }
                else if (start == offset) {
                    return new Region(start, end - start);
                }
                else {
                    return new Region(start + 1, end - start - 1);
                }
            }
            
            return null;
        }
    }

}
