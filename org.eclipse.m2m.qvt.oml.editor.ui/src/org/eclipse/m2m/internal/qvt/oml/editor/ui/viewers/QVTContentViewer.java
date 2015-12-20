/*******************************************************************************
 * Copyright (c) 2009, 2012 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.viewers;

import org.eclipse.compare.CompareConfiguration;
import org.eclipse.compare.contentmergeviewer.TextMergeViewer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtConfiguration;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtPartitionScanner;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;


public class QVTContentViewer extends TextMergeViewer {
	
	public QVTContentViewer(Composite parent, int style, CompareConfiguration configuration) {
		super(parent, style, configuration);		
	}
	
	@Override
	protected void configureTextViewer(TextViewer textViewer) {
		if(textViewer instanceof ISourceViewer){
			IPreferenceStore store = new ChainedPreferenceStore(
					new IPreferenceStore[] {
							Activator.getDefault().getPreferenceStore(),
							EditorsUI.getPreferenceStore() });
			
			SourceViewerConfiguration configuration = new QvtConfiguration(new QVTColorManager(store, Activator.getDefault().getColorManager()), store);
			((ISourceViewer)textViewer).configure(configuration);
		}
	}
	
	@Override
	protected void setupDocument(IDocument document) {
		super.setupDocument(document);

		doSetupDocument(document);
	}
		
	static IDocument doSetupDocument(IDocument document) {
		 IDocumentPartitioner partitioner = new FastPartitioner(
				new QvtPartitionScanner(), new String[] {
						QvtPartitionScanner.QVT_STRING,
						QvtPartitionScanner.QVT_ML_COMMENT,
						QvtPartitionScanner.QVT_SL_COMMENT,
						QvtPartitionScanner.QVT_DOCUMENTATION
						});

		partitioner.connect(document);

		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension3 = (IDocumentExtension3) document;
			extension3.setDocumentPartitioner(
					QvtPartitionScanner.QVT_PARTITIONING, partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}	
		
		return document;	
	}	
}
