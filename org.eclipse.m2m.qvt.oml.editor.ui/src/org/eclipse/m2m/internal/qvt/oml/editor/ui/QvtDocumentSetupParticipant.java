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

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;

/**
 * @author vrepeshko
 */
public class QvtDocumentSetupParticipant implements IDocumentSetupParticipant {

	public void setup(IDocument document) {
		IDocumentPartitioner partitioner = new FastPartitioner(new QvtPartitionScanner(), new String[] {
				QvtPartitionScanner.QVT_STRING, 
				QvtPartitionScanner.QVT_SL_COMMENT,
				QvtPartitionScanner.QVT_ML_COMMENT,
				QvtPartitionScanner.QVT_DOCUMENTATION});
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension3 = (IDocumentExtension3) document;
			extension3.setDocumentPartitioner(QvtPartitionScanner.QVT_PARTITIONING, partitioner);
		} else {
			document.setDocumentPartitioner(partitioner);
		}
		partitioner.connect(document);
	}

}
