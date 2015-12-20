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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.MDAConstants;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.osgi.util.NLS;

public class TransformationUtil {
    
	public static final String DEFAULT_RESULT_EXTENSION = "psm"; //$NON-NLS-1$

    private TransformationUtil() {}
    
    public static void getErrors(CompiledUnit unit, List<QvtMessage> errors, boolean concreteSyntaxOnly) {
    	if(concreteSyntaxOnly && !MDAConstants.QVTO_FILE_EXTENSION.equals(unit.getURI().fileExtension())) {
    		return;
    	}

        errors.addAll(unit.getErrors());
        for (CompiledUnit imp : unit.getCompiledImports()) {
            getErrors(imp, errors, concreteSyntaxOnly);
        }
    }
    
    public static void getWarnings(CompiledUnit unit, List<QvtMessage> warnings, boolean concreteSyntaxOnly) {
    	if(concreteSyntaxOnly && !MDAConstants.QVTO_FILE_EXTENSION.equals(unit.getURI().fileExtension())) {
    		return;
    	}
    	
        warnings.addAll(unit.getWarnings());
        for (CompiledUnit imp : unit.getCompiledImports()) {
            getWarnings(imp, warnings, concreteSyntaxOnly);
        }
    }
    
	public static QvtModule getQvtModule(final URI uriTransf) throws MdaException {
		if (uriTransf == null) {
			throw new MdaException(NLS.bind(Messages.TransformationUtil_InvalidUri, uriTransf));
		}

		IFile ifile = WorkspaceUtils.getWorkspaceFile(uriTransf);
		if (ifile != null && ifile.exists()) {
			return new WorkspaceQvtModule(ifile);
		}
		
		return new DeployedQvtModule(uriTransf);
	}
	
	public static String getTransformationFqn(QvtTransformation transformation) {
		if (transformation == null) {
			return null;
		}
		
		try {
			return transformation.getURI().toString();
		}
		catch (MdaException e) {
			return transformation.toString();
		}
	}

	public static boolean isRunnable(QvtTransformation transformation) throws MdaException {
		return transformation.hasEntryOperation() || transformation.isBlackbox();
	}
	
}
