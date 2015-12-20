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

import java.io.IOException;
import java.io.PrintWriter;

import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.qvt.oml.debug.core.launch.TransformationRunnerFactory;

public class QVTODebugApplication extends QVTOApplication {

	public static final String ID = "org.eclipse.m2m.qvt.oml.debug.core.QVTODebugApplication"; //$NON-NLS-1$
	
	public static final String ARG_PORT = "-port"; //$NON-NLS-1$
	
	private static final int PORT_UNDEFINED = -1;
	
	
	private int fPort = PORT_UNDEFINED;	
	
	public QVTODebugApplication() {
		super();
	}
	
	protected int doRun(TransformationRunner runner) {		
		DebugTransformationRunner dbgRunner = (DebugTransformationRunner) runner;
		dbgRunner.setErrorLog(new PrintWriter(System.err));
		
		VMInitializer vmProvider = new VMInitializer(dbgRunner, getExecutionContext());
		vmProvider.startBackgrouInitialization();

		try {
			VMServer server = new VMServer(fPort, vmProvider);		
			return server.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	protected boolean processCommandLineArg(String nextArg) {		
		if(isValueSpecArg(ARG_PORT, nextArg)) {
			String val = getArgValue(ARG_PORT, nextArg);
			try {					
				fPort = Integer.parseInt(val);
			} catch (NumberFormatException e) {
				System.err.println("Invalid port specified: " + nextArg);
				return false; 
			}				

			return true;
		}
		
		return super.processCommandLineArg(nextArg);
	}
	
	@Override
	protected TransformationRunnerFactory createRunnerFactory() {
		return new DebugRunnerFactory();
	}	
	
	@Override
	protected String getCommandLineUsage() {	
		return super.getCommandLineUsage() + " " + squareBracket(ARG_PORT); //$NON-NLS-1$
	}
		
	private static String squareBracket(String str) {
		return "[" + str + "]"; //$NON-NLS-1$ //$NON-NLS-2$ 
	}	
}
