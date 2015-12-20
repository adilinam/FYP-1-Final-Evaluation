/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.bindings.TriggerSequence;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry.CategoryDescriptor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry.CollectorDescriptor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry.CollectorRegistry;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.keys.IBindingService;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

/**
 * @author aigdalov
 */

public class QvtCompletionProcessor implements IContentAssistProcessor {
    private final static char[] ACTIVATION = {'.', '>' /* -> */, '@'};
    private final int INITIAL_CATEGORY_INDEX = -1;
    private final int NO_CATEGORY_INDEX = -1;

	private final ContentAssistant myContentAssistant;

	private List<CategoryDescriptor> myCategories = Collections.emptyList();
    private int myCategoryIndex = INITIAL_CATEGORY_INDEX;

    private final ITextEditor myEditor;
    private int myOffset = -1;
    
    public QvtCompletionProcessor(final ITextEditor editor, final ISourceViewer sourceViewer, ContentAssistant contentAssistant) {
        myEditor = editor;
		myContentAssistant = contentAssistant;
		
		// See corresponding snippet in org.eclipse.jdt.internal.ui.text.java.ContentAssistProcessor
		myContentAssistant.addCompletionListener(new ICompletionListener() {
			
			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent)
			 */
			public void assistSessionStarted(ContentAssistEvent event) {
				if (event.processor != QvtCompletionProcessor.this)
					return;
				
				myCategoryIndex = INITIAL_CATEGORY_INDEX;

				if (event.assistant instanceof ContentAssistant) {
					ContentAssistant contentAssistant = (ContentAssistant) event.assistant;
					contentAssistant.setRepeatedInvocationMode(true);
					contentAssistant.setStatusLineVisible(true);
					KeySequence binding = getIterationBinding();
					contentAssistant.setRepeatedInvocationTrigger(binding);
					contentAssistant.setShowEmptyList(true);
				}
			}
			
			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionEnded(org.eclipse.jface.text.contentassist.ContentAssistEvent)
			 */
			public void assistSessionEnded(ContentAssistEvent event) {
				myOffset = -1;
			}

			/*
			 * @see org.eclipse.jface.text.contentassist.ICompletionListener#selectionChanged(org.eclipse.jface.text.contentassist.ICompletionProposal, boolean)
			 */
			public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
			}
			
			private KeySequence getIterationBinding() {
			    final IBindingService bindingSvc= (IBindingService) PlatformUI.getWorkbench().getAdapter(IBindingService.class);
				TriggerSequence binding= bindingSvc.getBestActiveBindingFor(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
				if (binding instanceof KeySequence)
					return (KeySequence) binding;
				return null;
		    }
		});
    }

    public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
        try {
        	UnitProxy unitProxy = (UnitProxy) myEditor.getAdapter(UnitProxy.class);
        	if(unitProxy == null) {
        		return null;
        	}
        	
            QvtCompletionData data = new QvtCompletionData(myEditor, viewer, unitProxy, offset);
            if (!data.isValid()) {
                return disableNextCodeCompletionPage();
            }
            if ((myCategoryIndex == INITIAL_CATEGORY_INDEX) 
                    || (myOffset == offset)) { // Ctrl + Space pressed again
                int categoryIndex = updateCategoryIndex(data);
                if (categoryIndex == NO_CATEGORY_INDEX) {
                    return disableNextCodeCompletionPage();
                }
                CategoryDescriptor nextCategory = getNextCategory();
                if (nextCategory == null) {
                    disableNextCodeCompletionPage();
                } else {
                    myContentAssistant.setStatusLineVisible(true);
                    myContentAssistant.setStatusMessage(NLS.bind(Messages.QvtCompletionProcessor_PressCtrlSpace,
                            nextCategory.getLabel()));
                }
            }
            Collection<ICompletionProposal> proposals = new LinkedHashSet<ICompletionProposal>();
            for (CollectorDescriptor collectorDescriptor : CollectorRegistry.getCollectors(getCurrentCategory().getId())) {
                ICollector collector = collectorDescriptor.getCollector();
                if (collector.isApplicable(data)) {
                    collector.addPropoposals(proposals, data);
                }
            }
            return proposals.toArray(new ICompletionProposal[proposals.size()]);
        } finally {
            myOffset = offset;
        }
    }

    private ICompletionProposal[] disableNextCodeCompletionPage() {
    	myContentAssistant.setStatusLineVisible(false);
    	return null;
	}
    
    private int updateCategoryIndex(QvtCompletionData data) {
    	if (myCategoryIndex == INITIAL_CATEGORY_INDEX) { /* -1 */
    		myCategories = new ArrayList<CategoryDescriptor>();
    		CategoryDescriptor[] allCategories = CollectorRegistry.getCategories();
    		for (CategoryDescriptor categoryDescriptor : allCategories) {
    			List<CollectorDescriptor> collectorDescriptors = 
    				CollectorRegistry.getCollectors(categoryDescriptor.getId());
    			boolean isApplicable = false;
    			if (collectorDescriptors != null) {
    				for (CollectorDescriptor collectorDescriptor : collectorDescriptors) {
    					ICollector collector = collectorDescriptor.getCollector();
    					if (collector.isApplicable(data)) {
    						isApplicable = true;
    						break;
    					}
    				}
    			}
				if (isApplicable) {
					myCategories.add(categoryDescriptor);
				}
			}
    	}
    	if (myCategories.isEmpty()) {
    		return NO_CATEGORY_INDEX;
    	}
    	myCategoryIndex ++;
    	if (myCategoryIndex == myCategories.size()) {
    		myCategoryIndex = 0;
    	}
    	return myCategoryIndex;
    }
    
    public CategoryDescriptor getCurrentCategory() {
    	if (myCategories.isEmpty()) {
    		return null;
    	}
    	return myCategories.get(myCategoryIndex);
    }
    
    public CategoryDescriptor getNextCategory() {
    	if (myCategories.size() == 1) {
    		return null;
    	}
    	int index = myCategoryIndex + 1;
    	if (index == myCategories.size()) {
    		index = 0;
    	}
    	return myCategories.get(index);
    }
    
    public CategoryDescriptor getLastCategory() {
    	if (myCategories.isEmpty()) {
    		return null;
    	}
    	return myCategories.get(myCategories.size() - 1);
    }
    
    public static final CSTNode findLeftmostCSTNode(CSTNode root, int offset) {
        CSTNode result = null;
        for (TreeIterator<EObject> iterator = root.eAllContents(); iterator.hasNext(); ) {
            EObject next = iterator.next();
            if (next instanceof CSTNode) {
                CSTNode child = (CSTNode) next;
                if (child.getEndOffset() < offset) {
                    if ((result == null)
                            || (child.getEndOffset() > result.getEndOffset())
                            || ((child.getEndOffset() == result.getEndOffset()) 
                                    && (child.getStartOffset() < result.getStartOffset()))) {
                        result = child;
                    }
                }
            }
        }
        return result;
    }

    public IContextInformation[] computeContextInformation(ITextViewer viewer,
            int offset) {
        return null;
    }

    public char[] getCompletionProposalAutoActivationCharacters() {
        return ACTIVATION;
    }

    public char[] getContextInformationAutoActivationCharacters() {
        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return null;
    }

    public String getErrorMessage() {
        return null;
    }
}