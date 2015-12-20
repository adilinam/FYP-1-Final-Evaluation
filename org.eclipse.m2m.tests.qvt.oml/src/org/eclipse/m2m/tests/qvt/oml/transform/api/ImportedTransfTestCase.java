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
package org.eclipse.m2m.tests.qvt.oml.transform.api;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.qvt.oml.runtime.util.QvtoTransformationHelper;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;

/**
 * @author sboyko
 */
@SuppressWarnings("deprecation")
public class ImportedTransfTestCase extends ApiTestCase {
	
    public ImportedTransfTestCase(ModelTestData data) {
        super(data);
    }
    
    public ImportedTransfTestCase(String testName) {
    	super(testName);
    }
    
    @Override
    public void runTest() throws Exception {
		IFile qvtoFile = getIFile(getData().getName() + MDAConstants.QVTO_FILE_EXTENSION_WITH_DOT);
    	
		List<URI> importedTransformations = new QvtoTransformationHelper(qvtoFile).getImportedTransformations();
		
		Iterator<URI> itrImported = importedTransformations.iterator();
		List<URI> expected = getData().getExpected(getProject());
		for (URI uri : expected) {
			if (!itrImported.hasNext()) {
				throw new Exception("Missed imported model URI"); //$NON-NLS-1$
			}
			URI nextImport = itrImported.next();
			if (!nextImport.equals(uri)) {
				throw new Exception("Unexpected imported model URI: " + nextImport); //$NON-NLS-1$
			}
		}
    }
    
}
