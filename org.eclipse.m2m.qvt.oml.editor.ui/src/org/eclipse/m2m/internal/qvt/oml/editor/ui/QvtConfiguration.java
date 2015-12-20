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
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.IQVTColors;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProcessor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers.QvtTextHover;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.hyperlinks.QvtHyperlinkDetector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.ITextEditor;


public class QvtConfiguration extends TextSourceViewerConfiguration {

	/**
	 * @generated
	 */
	public static final class QVTPresentationReconciler extends PresentationReconciler {
		/**
		 * Last used document
		 * @generated
		 */
		private IDocument fLastDocument;

		private QVTPresentationReconciler() {
			super();
		}
		
		/**
		 * Constructs a "repair description" for the given damage and returns
		 * this description as a text presentation.
		 * <p>
		 * NOTE: Should not be used if this reconciler is installed on a viewer.
		 * </p>
		 * @generated
		 */
		public TextPresentation createRepairDescription(IRegion damage, IDocument document) {
			if (document != fLastDocument) {
				setDocumentToDamagers(document);
				setDocumentToRepairers(document);
				fLastDocument = document;
			}
			return createPresentation(damage, document);
		}
	}		
		
	public QvtConfiguration(ITextEditor editor, QVTColorManager colorManager, IPreferenceStore store) {
		super(store);

		if(colorManager == null || store == null) {
			throw new IllegalArgumentException();
		}
		
        myColorManager = colorManager;
        myEditor = editor;
    }
	
	public QvtConfiguration(QVTColorManager colorManager, IPreferenceStore store) {
		this(null, colorManager, store);
    }
    
    @Override
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
        return new String[] {
            IDocument.DEFAULT_CONTENT_TYPE,
            QvtPartitionScanner.QVT_DOCUMENTATION,
            QvtPartitionScanner.QVT_SL_COMMENT,
            QvtPartitionScanner.QVT_ML_COMMENT,
            QvtPartitionScanner.QVT_STRING };
    }
    
    @Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(ISourceViewer sourceViewer, 
    		String contentType) {
        if (doubleClickStrategy == null)
            doubleClickStrategy = new QvtDoubleClickStrategy();
        return doubleClickStrategy;
    }

    protected QvtScanner getQvtScanner() {
        if (scanner == null) {
            scanner = new QvtScanner(myColorManager);
            scanner.setDefaultReturnToken(myColorManager.getColor(IQVTColors.DEFAULT).createToken());
        }
        return scanner;
    }

    @Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        PresentationReconciler reconciler = new QVTPresentationReconciler();
        reconciler.setDocumentPartitioning(QvtPartitionScanner.QVT_PARTITIONING);
        
        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getQvtScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        NonRuleBasedDamagerRepairer slCommentRepairer =
            new NonRuleBasedDamagerRepairer(
                    myColorManager.getColor(IQVTColors.LINE_COMMENT).createToken());
        reconciler.setDamager(slCommentRepairer, QvtPartitionScanner.QVT_SL_COMMENT);
        reconciler.setRepairer(slCommentRepairer, QvtPartitionScanner.QVT_SL_COMMENT);

        NonRuleBasedDamagerRepairer mlCommentRepairer =
            new NonRuleBasedDamagerRepairer(
                    myColorManager.getColor(IQVTColors.MULTILINE_COMMENT).createToken());
        reconciler.setDamager(mlCommentRepairer, QvtPartitionScanner.QVT_ML_COMMENT);
        reconciler.setRepairer(mlCommentRepairer, QvtPartitionScanner.QVT_ML_COMMENT);

        DefaultDamagerRepairer d = new DefaultDamagerRepairer(
				new CommentScanner(myColorManager, IQVTColors.MULTILINE_COMMENT));
		reconciler.setDamager(d, QvtPartitionScanner.QVT_ML_COMMENT);
		reconciler.setRepairer(d, QvtPartitionScanner.QVT_ML_COMMENT);
		
        d = new DefaultDamagerRepairer(
				new CommentScanner(myColorManager, IQVTColors.MULTILINE_COMMENT));
		reconciler.setDamager(d, QvtPartitionScanner.QVT_SL_COMMENT);
		reconciler.setRepairer(d, QvtPartitionScanner.QVT_SL_COMMENT);
		
		
		NonRuleBasedDamagerRepairer docRepairer = new NonRuleBasedDamagerRepairer(
				myColorManager.getColor(IQVTColors.DOC_OTHERS).createToken());
		reconciler.setDamager(docRepairer, QvtPartitionScanner.QVT_DOCUMENTATION);
		reconciler.setRepairer(docRepairer, QvtPartitionScanner.QVT_DOCUMENTATION);

		d = new DefaultDamagerRepairer(
				new CommentScanner(myColorManager, IQVTColors.DOC_OTHERS));
		reconciler.setDamager(d, QvtPartitionScanner.QVT_DOCUMENTATION);
		reconciler.setRepairer(d, QvtPartitionScanner.QVT_DOCUMENTATION);
		

		NonRuleBasedDamagerRepairer stringRepairer = new NonRuleBasedDamagerRepairer(
				myColorManager.getColor(IQVTColors.STRING).createToken());
		reconciler.setDamager(stringRepairer, QvtPartitionScanner.QVT_STRING);
		reconciler.setRepairer(stringRepairer, QvtPartitionScanner.QVT_STRING);        
		
        return reconciler;
    }
    
    @Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
    	if(!isQVTDocProvidereditorAvailable()) {
    		return null;
    	}
    	
        myContentAssistant = new ContentAssistant();        
        QvtCompletionProcessor processor = new QvtCompletionProcessor(myEditor, sourceViewer, myContentAssistant);
//        QvtTemplateCompletionProcessor processor = new QvtTemplateCompletionProcessor();
		myContentAssistant.setRestoreCompletionProposalSize(getSettings("completion_proposal_size")); //$NON-NLS-1$
        myContentAssistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
        myContentAssistant.setContentAssistProcessor(processor, QvtPartitionScanner.QVT_STRING);
        myContentAssistant.setDocumentPartitioning(QvtPartitionScanner.QVT_PARTITIONING);
        myContentAssistant.enableAutoInsert(true);
        myContentAssistant.enableAutoActivation(true);
        myContentAssistant.setAutoActivationDelay(ASSIST_AUTO_ACTIVATION_DELAY);
        myContentAssistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
        myContentAssistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
        myContentAssistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        myContentAssistant.setProposalSelectorBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));
        return myContentAssistant;
    }
    
  
    @Override
	public IReconciler getReconciler(final ISourceViewer sourceViewer) {
    	if(myEditor == null) {
    		return null;
    	}
        QvtReconcilingStrategy strategy = new QvtReconcilingStrategy(myEditor);

		QvtReconciler reconciler = new QvtReconciler(myEditor, strategy, false);
        reconciler.setDelay(RECONCILER_DELAY);
		
        return reconciler;
    }
            
    @Override
	public IAutoEditStrategy[] getAutoEditStrategies(ISourceViewer sourceViewer, String contentType) {
		return new IAutoEditStrategy[] {  new QvtIndentAutoEditStrategy() };		
			
		//return super.getAutoEditStrategies(sourceViewer, contentType);		
	}
    
    @Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
    	return new QvtAnnotationHover();
    }
    
    @Override
	public ITextHover getTextHover(final ISourceViewer sourceViewer, final String contentType) {
    	if(!isQVTDocProvidereditorAvailable()) {
    		return null;
    	}
        return new QvtTextHover((QvtDocumentProvider) myEditor.getDocumentProvider());
    }

    @Override
    public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
    	if(!isQVTDocProvidereditorAvailable()) {
    		return null;
    	}
    	
    	List<IHyperlinkDetector> detectors = new ArrayList<IHyperlinkDetector>();
		detectors.add(new QvtHyperlinkDetector((QvtDocumentProvider) myEditor.getDocumentProvider()));
    	return detectors.toArray(new IHyperlinkDetector[detectors.size()]);
    }
    
	private IDialogSettings getSettings(String sectionName) {
		IDialogSettings settings= Activator.getDefault().getDialogSettings().getSection(sectionName);
		if (settings == null)
			settings= Activator.getDefault().getDialogSettings().addNewSection(sectionName);

		return settings;
	}

	private boolean isQVTDocProvidereditorAvailable() {
		return myEditor != null && myEditor.getDocumentProvider() instanceof QvtDocumentProvider;
	}	
	
	private QvtDoubleClickStrategy doubleClickStrategy;
    private QvtScanner scanner;
    private QVTColorManager myColorManager;
    private ContentAssistant myContentAssistant;
    private ITextEditor myEditor;    
	
	private static final int ASSIST_AUTO_ACTIVATION_DELAY = 200;
	private static final int RECONCILER_DELAY = 500;	
}