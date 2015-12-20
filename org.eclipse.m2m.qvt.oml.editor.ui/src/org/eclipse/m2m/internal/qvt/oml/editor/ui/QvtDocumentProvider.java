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

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.editors.text.StorageDocumentProvider;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;


public class QvtDocumentProvider extends TextFileDocumentProvider {
		
	public QvtDocumentProvider() {
		IDocumentProvider parentProvider = new ForwardingDocumentProvider(
				QvtPartitionScanner.QVT_PARTITIONING,
				new QvtDocumentSetupParticipant(),
				new StorageDocumentProvider());

		setParentDocumentProvider(parentProvider);
	}
	
    public void setMappingModule(final CompiledUnit compiledUnit) {
        myCompiledModule = compiledUnit;
    }
    
    public CompiledUnit getCompiledModule() {
        return myCompiledModule;
    }

    @Override
	protected IAnnotationModel createAnnotationModel(IFile file) {
    	return new ResourceMarkerAnnotationModel(file);
    }
    
    private CompiledUnit myCompiledModule;
}