/*******************************************************************************
 * Copyright (c) 2009, 2013 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland - initial API and implementation
 *******************************************************************************/
package qvto.ecore2uml.invoke;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import qvto.ecore2uml.internal.invoke.InvokeActivator;


public class ConvertEcore2UML {

	public static final URI transformationURI = 
		URI.createPlatformPluginURI("/qvto.ecore2uml/transforms/Ecore2UML.qvto", true);
	

	public static void convertEcore2UML(Resource ecoreResource, Resource umlResource) {
		
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		ModelExtent input = new BasicModelExtent(ecoreResource.getContents());
		ModelExtent output = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();
		ExecutionDiagnostic diagnostic = executor.execute(context, input, output);
		
		if(diagnostic.getSeverity() == Diagnostic.OK) {
			umlResource.getContents().addAll(output.getContents());
		} else {
			IStatus status = BasicDiagnostic.toIStatus(diagnostic);
			InvokeActivator.getDefault().getLog().log(status);
		}
	}	
}
