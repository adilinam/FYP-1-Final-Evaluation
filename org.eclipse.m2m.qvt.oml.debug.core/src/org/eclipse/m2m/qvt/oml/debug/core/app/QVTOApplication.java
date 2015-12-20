/*******************************************************************************
 * Copyright (c) 2009, 2015 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.app;

import java.io.PrintWriter;
import java.util.ArrayList;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.m2m.internal.qvt.oml.TransformationRunner;
import org.eclipse.m2m.qvt.oml.ExecutionContext;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.debug.core.launch.TransformationRunnerFactory;
import org.eclipse.m2m.qvt.oml.util.WriterLog;

public class QVTOApplication implements IApplication {

	public static final String ID = "org.eclipse.m2m.qvt.oml.debug.QVTOApplication"; //$NON-NLS-1$

	public static final String ARG_PORT = "-port"; //$NON-NLS-1$
	public static final String ARG_TRANSFORMATION = "-transform"; //$NON-NLS-1$
	public static final String ARG_PARAM = "-param"; //$NON-NLS-1$
	/**
	 * @since 1.5
	 */
	public static final String ARG_MMAPINGS = "-mmapings"; //$NON-NLS-1$
	public static final String ARG_TRACE = "-trace"; //$NON-NLS-1$
	/**
	 * @since 1.5
	 */
	public static final String ARG_TRACE_SAVE = "-trace_save"; //$NON-NLS-1$
	/**
	 * @since 1.5
	 */
	public static final String ARG_TRACE_INCREMENTAL = "-trace_incremental"; //$NON-NLS-1$

	public static final String ARG_HELP = "-help"; //$NON-NLS-1$

	private static final String CMD_LINE_USAGE = ID + " " + //$NON-NLS-1$ 
			squareBracket(ARG_TRANSFORMATION + " uri") + " " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_PARAM + " uri") + " ... " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_MMAPINGS + " nsURI;uri") + " ... " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_TRACE + " uri") + " " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_TRACE_SAVE) + " " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_TRACE_INCREMENTAL) + " " + //$NON-NLS-1$ //$NON-NLS-2$
			squareBracket(ARG_HELP);


	private TransformationRunnerFactory fRunnerFactory;
	private ExecutionContext fContext;

	public QVTOApplication() {
		super();
	}

	public Object start(IApplicationContext context) throws Exception {
		int exitCode = 0;
		if (processCommandLine(context)) {
			try {
				exitCode = doRun(createRunner());
			} catch(DiagnosticException e) {
				exitCode = -1;
				System.err.println(e.getDiagnostic());
			}
		} else {
			exitCode = -1;
			// Note: particular problems reported per argument processed
			System.err.println(getCommandLineUsage());
		}

		return new Integer(exitCode);

	}

	public void stop() {
		// do nothing
	}

	protected int doRun(TransformationRunner runner) {
		Diagnostic diagnostic = runner.execute(getExecutionContext());

		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			System.err.println(diagnostic);
			return -1;
		}
		return 0;
	}

	protected final TransformationRunnerFactory getRunnerFactory() {
		if (fRunnerFactory == null) {
			fRunnerFactory = createRunnerFactory();
		}

		return fRunnerFactory;
	}

	protected TransformationRunnerFactory createRunnerFactory() {
		return new TransformationRunnerFactory();
	}

	protected boolean processCommandLine(IApplicationContext context) {
		String[] argsArray = (String[]) context.getArguments().get(
				IApplicationContext.APPLICATION_ARGS);
		
		boolean hasError = false;
		for (String nextArg : argsArray) {
			boolean processResult = processCommandLineArg(nextArg);		
			hasError = hasError && processResult;
		}

		return !hasError;
	}

	protected boolean processCommandLineArg(String nextArg) {
		TransformationRunnerFactory factory = getRunnerFactory();

		if (factory.modelParamURI == null) {
			factory.modelParamURI = new ArrayList<String>();
		}

		if (isValueSpecArg(ARG_TRANSFORMATION, nextArg)) {
			String val = getArgValue(ARG_TRANSFORMATION, nextArg);
			factory.transformationURI = val;

		} else if (isValueSpecArg(ARG_PARAM, nextArg)) {
			String val = getArgValue(ARG_PARAM, nextArg);
			factory.modelParamURI.add(val);

		} else if (isValueSpecArg(ARG_MMAPINGS, nextArg)) {
			String val = getArgValue(ARG_MMAPINGS, nextArg);
			String[] mmaping = val.split(";");
			if (mmaping.length != 2) {
				throw new IllegalArgumentException("Malformed argument: " + ARG_MMAPINGS + " " + nextArg); //$NON-NLS-1$ //$NON-NLS-2$
			}
			factory.addMetamodelMapping(mmaping[0], mmaping[1]);

		} else if (isValueSpecArg(ARG_TRACE, nextArg)) {
			String val = getArgValue(ARG_TRACE, nextArg);
			factory.traceFileURI = val;

		} else if (isValueSpecArg(ARG_TRACE_SAVE, nextArg)) {
			factory.isSaveTrace = true;

		} else if (isValueSpecArg(ARG_TRACE_INCREMENTAL, nextArg)) {
			factory.isIncrementalUpdate = true;

		} else if (ARG_HELP.equals(nextArg)) {
			System.out.println(getCommandLineUsage());
			
		} else {
			System.err.println("Unsupported argument: " + nextArg); //$NON-NLS-1$
			return false;
		}

		return true;
	}

	protected TransformationRunner createRunner() throws DiagnosticException {

		TransformationRunner runner = getRunnerFactory().createRunner();
		return runner;
	}
	
	protected ExecutionContext createExecutionContext() {
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setLog(new WriterLog(new PrintWriter(System.out), true));
		return context;
	}
	
	protected final ExecutionContext getExecutionContext() {
		if(fContext == null) {
			fContext = createExecutionContext(); 
		}
		return fContext;
	}

	protected String getCommandLineUsage() {
		return CMD_LINE_USAGE;
	}

	protected static boolean isValueSpecArg(String argName, String argDef) {
		if (argDef.startsWith(argName)) {
			String spec = argDef.substring(argName.length());
			return spec.length() > 1 && spec.charAt(0) == '=';
		}

		return false;
	}

	protected static String getArgValue(String argName, String argDef) {
		if (argDef.startsWith(argName)) {
			String spec = argDef.substring(argName.length());
			if (spec.length() > 1 && spec.charAt(0) == '=') {
				return spec.substring(1);
			}
		}
		throw new IllegalArgumentException("no value in argument" + argDef); //$NON-NLS-1$
	}

	private static String squareBracket(String str) {
		return "[" + str + "]"; //$NON-NLS-1$ //$NON-NLS-2$ 
	}
}
