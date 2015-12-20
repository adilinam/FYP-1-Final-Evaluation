/*******************************************************************************
 * Copyright (c) 2009, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.callapi;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author sboyko
 */
public class SourceContainerTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Source container in deployed plugins"); //$NON-NLS-1$
		
		suite.addTest(new DeployedPluginText("TransformationProjectRelPath",
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvto.transformationProject/root/RootTransformation.qvto", true)));

		suite.addTest(new DeployedPluginText("TransformationProjectFullPath",
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvto.transformationProject/transforms/root/RootTransformation.qvto", true)));
		
		suite.addTest(new DeployedPluginText("PlainProject",
				URI.createPlatformPluginURI("org.eclipse.m2m.tests.qvto.pluginProject/transforms/root/RootTransformation.qvto", true)));
		
		// test transformation deployed with 'org.eclipse.m2m.tests.qvto.deployedTransfProject' plug-in
		suite.addTest(new DeployedPluginText("DeployedTransfProject",
				URI.createURI("deployedTransformationId", true)));
		
		return suite;
	}


	private static class DeployedPluginText extends TestCase {
		private final URI myUri;
		
		DeployedPluginText(String name, URI uri) {
			super(name);
			myUri = uri;
		}
		
		@Override
		protected void runTest() throws Throwable {
			TransformationExecutor executor = new TransformationExecutor(myUri);
			ExecutionDiagnostic diagnostic = executor.execute(new ExecutionContextImpl());
					
			assertEquals(Diagnostic.OK, diagnostic.getSeverity());
		}
		
	}
}
