/*******************************************************************************
 * Copyright (c) 2009, 2015 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 466289
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtPlugin;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.osgi.util.NLS;

public class TransformationRunnerFactory {

	public String transformationURI;
	
	public List<String> modelParamURI;

	public String traceFileURI;
	
	/**
	 * @since 1.5
	 */
	public boolean isSaveTrace;
	
	/**
	 * @since 1.5
	 */
	public boolean isIncrementalUpdate;
	
	public EPackage.Registry packageRegistry;
	
	private ResourceSet mmapingsRs;
	

	public TransformationRunner createRunner() throws DiagnosticException {
		BasicDiagnostic diagnostic = QvtPlugin.createDiagnostic("Transformation runner problems");
		
		URI uri = null;
		try {
			uri = toURI(this.transformationURI, "transformation");
		} catch(DiagnosticException e) {
			diagnostic.add(e.getDiagnostic());
		}

		List<URI> paramURIs = new ArrayList<URI>();
		if(this.modelParamURI != null) {
			for (String paramURIStr : this.modelParamURI) {
				try {
					paramURIs.add(toURI(paramURIStr, "model parameter"));
				} catch(DiagnosticException e) {
					diagnostic.add(e.getDiagnostic());
				}
			}
		} else {
			diagnostic.add(QvtPlugin.createErrorDiagnostic("No model parameters passed to transformation", null));
		}

		if(diagnostic.getSeverity() == Diagnostic.ERROR) {
			throw new DiagnosticException(diagnostic);
		}
		
		TransformationRunner runner = createRunner(uri, this.packageRegistry, paramURIs);
		
		runner.setIncrementalUpdate(isIncrementalUpdate);
		runner.setSaveTrace(isSaveTrace);
		
		if(traceFileURI != null) {
			try {
				runner.setTraceFile(toURI(traceFileURI, "trace file"));
			} catch(DiagnosticException e) {
				diagnostic.add(e.getDiagnostic());
			}
		}

		return runner;
	}
	
	protected TransformationRunner createRunner(URI transformationURI, EPackage.Registry packageRegistry, List<URI> modelParamURIs) {
		return new TransformationRunner(transformationURI, packageRegistry, modelParamURIs);
	}
	
	/**
	 * @since 1.5
	 */
	public void addMetamodelMapping(String nsURI, String uriLocation) {
		if (mmapingsRs == null) {
			mmapingsRs = new ResourceSetImpl();
			packageRegistry = mmapingsRs.getPackageRegistry();
		}

		try {
			EPackage metamodel = WorkspaceMetamodelProvider.loadResourceMetamodel(uriLocation, mmapingsRs);
			packageRegistry.put(nsURI, metamodel);
		} catch (Exception e) {
			throw new IllegalArgumentException("Malformed metamodel mapping location", e); //$NON-NLS-1$
		}
	}
	
	private URI toURI(String uriStr, String uriType) throws DiagnosticException {
		IllegalArgumentException exc = null;
		if(uriStr != null) {
			try {
				return URI.createURI(uriStr, true);
			} catch(IllegalArgumentException e) {
				exc = e; 
			}
		}

		String message = NLS.bind("Invalid {0} URI : ''{1}''", uriType, uriStr);
		throw new DiagnosticException(QvtPlugin.createErrorDiagnostic(message, exc));
	}
}
