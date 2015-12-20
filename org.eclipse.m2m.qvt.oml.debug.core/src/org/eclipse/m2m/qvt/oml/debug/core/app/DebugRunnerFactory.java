/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.util.List;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.qvt.oml.debug.core.launch.TransformationRunnerFactory;

public class DebugRunnerFactory extends TransformationRunnerFactory {
	
	public DebugRunnerFactory() {
		super();
	}
	
	protected TransformationRunner createRunner(URI transformationURI, EPackage.Registry packageRegistry, List<URI> modelParamURIs) {
		return new DebugTransformationRunner(transformationURI, packageRegistry, modelParamURIs);
	}

	@Override
	public DebugTransformationRunner createRunner() throws DiagnosticException {
		return (DebugTransformationRunner) super.createRunner();
	}
}
