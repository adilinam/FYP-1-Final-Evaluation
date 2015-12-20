/*******************************************************************************
 * Copyright (c) 2013, 2014 S.Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     S.Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.debugger;

import java.io.File;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.IJobManager;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.Launch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.IInternalDebugUIConstants;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.m2m.internal.qvt.oml.common.io.FileUtil;
import org.eclipse.m2m.internal.qvt.oml.common.launch.IQvtLaunchConstants;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData.TargetType;
import org.eclipse.m2m.internal.qvt.oml.debug.ui.RetargettableActionAdapterFactory;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.emf.util.WorkspaceUtils;
import org.eclipse.m2m.internal.qvt.oml.project.builder.QVTOBuilder;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchConfigurationDelegate;
import org.eclipse.m2m.internal.qvt.oml.runtime.launch.QvtLaunchUtil;
import org.eclipse.m2m.internal.tests.qvt.oml.debugger.DebugEventLogger.LogRecord;
import org.eclipse.m2m.internal.tests.qvt.oml.debugger.MarkedTransformation.LineMarker;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOBreakpoint;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.launch.QVTODebugConfiguration;
import org.eclipse.m2m.qvt.oml.debug.core.srclookup.QVTOSourceLookupDirector;
import org.eclipse.m2m.tests.qvt.oml.AllTests;
import org.eclipse.m2m.tests.qvt.oml.TestProject;
import org.eclipse.m2m.tests.qvt.oml.transform.ModelTestData;
import org.eclipse.m2m.tests.qvt.oml.util.ReaderInputStream;
import org.eclipse.m2m.tests.qvt.oml.util.TestUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * A JUnit test class for QVTO Debugger execution
 * @author sboyko
 */
public class TestQvtoDebugger extends TestCase {

	public TestQvtoDebugger(ModelTestData data) {
		super(data.getName());
	}
    
    public void setUp() throws Exception {
		if (myProject != null) {
			return;
		}

		Display.getCurrent().syncExec(new Runnable() {
			public void run() {
				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_SWITCH_TO_PERSPECTIVE, MessageDialogWithToggle.NEVER);
				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_ACTIVATE_DEBUG_VIEW, Boolean.FALSE.toString());
				DebugUIPlugin.getDefault().getPreferenceStore().putValue(IInternalDebugUIConstants.PREF_SWITCH_PERSPECTIVE_ON_SUSPEND, MessageDialogWithToggle.NEVER);
			}
		});
		
		TestUtil.turnOffAutoBuilding();
		
		myProject = new TestProject(PROJECT_NAME, new String[] {});

        ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager.getLaunchConfigurationType(QvtLaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE_ID);
		myLaunchConfigurationWorkingCopy = type.newInstance(null, CONFIG_NAME);

		copyModelData(TestUtil.getPluginRelativeFile(AllTests.BUNDLE_ID + ".ui", TEST_DATA_FOLDER + "/tests"));  //$NON-NLS-1$  //$NON-NLS-2$
	}
	
    public void tearDown() throws Exception {
        IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWorkbenchWindow != null) {
            IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
            if (activePage != null) {
                IEditorPart activeEditor = activePage.getActiveEditor();
                if (activeEditor != null) {
                    activePage.closeEditor(activeEditor, false);
                }
            }
        }
	}
    
    @Override
    protected void runTest() throws Throwable {
   		doTest(getName());
    }
    
    /**
     * Copies all files from a specified source project folder to a <i>debuggerTestData</i> folder 
     * of a temporary project
     * @param srcFolder - project-relative
     * @throws Exception
     */
    private void copyModelData(File srcFolder) throws Exception {
        File folder = new File(myProject.getProject().getLocation().toString() + "/" + TEST_DATA_FOLDER); //$NON-NLS-1$
        folder.mkdirs();
        FileUtil.copyFolder(srcFolder, folder);
        myProject.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
    }

    /**
     * Suspends current thread until the debugger listener resumes it
     * @param time - maximum time to wait in milliseconds, 0 for no time-bound
     * @throws InterruptedException
     */
    public void waitForDebugger(int time) throws InterruptedException {
    	synchronized(this) {
			if (time > 0) {
				this.wait(time);
			}
			else {
				this.wait();
			}
		};	    	
    }
    
    /**
     * Adds a breakpoint on the given line to the module currently selected in launch
     * configuration
     * @param line - line number to set a breakpoint on
     * @throws CoreException
     * @throws InterruptedException 
     * @throws OperationCanceledException 
     */
    private void addBreakpoint(QvtEditor qvtEditor, final int line) throws CoreException, OperationCanceledException, InterruptedException {
		//IToggleBreakpointsTarget breakpointAdapter = (IToggleBreakpointsTarget) qvtEditor.getAdapter(IToggleBreakpointsTarget.class);
    	IToggleBreakpointsTarget breakpointAdapter = (IToggleBreakpointsTarget)  new RetargettableActionAdapterFactory().getAdapter(qvtEditor, IToggleBreakpointsTarget.class);
		breakpointAdapter.toggleLineBreakpoints(qvtEditor, new ITextSelection() {
			public boolean isEmpty() {
				return false;
			}
			public String getText() {
				return null;
			}
			public int getStartLine() {
				return line-1;
			}
			public int getOffset() {
				return 0;
			}
			public int getLength() {
				return 1;
			}
			public int getEndLine() {
				return getStartLine();
			}
		});
		
		IJobManager jobMan = Job.getJobManager();
		jobMan.join(QVTOBreakpoint.QVTO_BREAKPOINT_JOBFAMILY, new NullProgressMonitor());
    }

    private String getProjectFileName(String folder, String file) {
    	return myProject.project.getName() + "/" + TEST_DATA_FOLDER + "/" + folder + "/" + file;  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }
    
    private String getProjectFilePath(String folder, String file) {
    	return MessageFormat.format("{0}/{1}/{2}/{3}", new Object[] {myProject.project.getLocation(), TEST_DATA_FOLDER, folder, file});  //$NON-NLS-1$ 
    }
    
    /**
     * @param folder - debuggerTestData-realtive folder name without a starting slash (/)
     *                 structure of such a folder is:
     *                 /markedTest.qvt - a transformation the debugger is being tested on with breakpoint markers
     *                                   markers are deleted before launching debugger
     *                 /test.xml       - an XML description of debugging scenario
     *                 /in.ecore       - input EMF ecore model
     * @throws Exception 
     */
    private void setTestData(String folder) throws Exception {
    	// Parse transformation file for breakpoint labels
    	String markedName = getProjectFileName(folder, MARKED_TEST_FILE);
		IFile markedFile = WorkspaceUtils.getWorkspaceFile(markedName);
    	String markedData = QVTOBuilder.getFileContents(markedFile);
    	myMarkedTrans = new MarkedTransformation(markedData);
    	
		// Creating a clean test file (without breakpoint markers)
    	String testName = getProjectFileName(folder, TEST_FILE); 
    	IFile testFile = WorkspaceUtils.getWorkspaceFile(testName);
    	testFile.delete(false, null);
    	testFile.create(new ReaderInputStream(myMarkedTrans.getCleanText()), true, null);
    	
    	// Set launch configuration parameters
    	myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.MODULE, URIUtils.getResourceURI(testFile).toString());
    	QvtLaunchUtil.saveTargetUriData(myLaunchConfigurationWorkingCopy, new TargetUriData(TargetType.EXISTING_CONTAINER, 
    			URI.createPlatformResourceURI(getProjectFileName(folder, IN_MODEL), true).toString(), null, false), 1);
        myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.ELEM_COUNT, 1); 	
		myLaunchConfigurationWorkingCopy.setAttribute(IQvtLaunchConstants.TRACE_FILE, getProjectFileName(folder, TRACE_FILE));
		myLaunchConfigurationWorkingCopy.doSave();

    	// Parse a script
    	myScript = new Script(getProjectFilePath(folder, SCRIPT_FILE), myMarkedTrans);

    	// Open script in editor
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		QvtEditor qvtEditor = (QvtEditor) IDE.openEditor(page, testFile);
		
		// Force compilation in editor
    	qvtEditor.getValidCompiledModule(10000);
    	
		// Set up the specified breakpoints
    	for (final LineMarker rec : myMarkedTrans.getBreakpointLineMarkers()) {
   			addBreakpoint(qvtEditor, rec.lineNumber);
    	}
    }

    /**
     * Launches the debugger with a configuration set up by {@link #setTestData(String)}
     * @throws CoreException
     * @throws InterruptedException 
     */
    private void runDebugger() throws CoreException, InterruptedException {
		ILaunchConfiguration config = myLaunchConfigurationWorkingCopy.doSave();

		QVTODebugConfiguration debugConfig = new QVTODebugConfiguration();
		ILaunch launch = new Launch(config, ILaunchManager.DEBUG_MODE, new QVTOSourceLookupDirector());

        myListener = new DebugEventLogger(this, myScript);
        DebugPlugin.getDefault().addDebugEventListener(myListener);

		debugConfig.launch(config, ILaunchManager.DEBUG_MODE, launch, new NullProgressMonitor());
        
        while(!launch.isTerminated()) {
        	while (Display.getDefault().readAndDispatch()) {
        	}
        	Thread.sleep(10);
        }
    	
        DebugPlugin.getDefault().removeDebugEventListener(myListener);
    }
    
    /**
     * Loads test data and performs a test
     * @throws CoreException 
     * @throws InterruptedException 
     * @see #setTestData(String)
     */
    private void doTest(String folder) throws Exception {
    	System.out.println(MessageFormat.format(LOADING_TEST_MESSAGE, new Object[]{folder}));
    	setTestData(folder);
    	System.out.println(RUNNING_DEBUGGER_MESSAGE);
    	runDebugger();
    	System.out.println(MessageFormat.format(TEST_FINISHED_MESSAGE, new Object[]{folder}));

    	// Check up set breakpoints
    	Collection<LineMarker> allBreakpoints = myMarkedTrans.getBreakpointLineMarkers();
    	Set<Integer> physicalBreakpoints = getPhysicalBreakpoints();
    	for (LineMarker rec : allBreakpoints) {
			assertTrue(
					MessageFormat.format(rec.fail?BREAKPOINT_SET_MESSAGE:BREAKPOINT_NOT_SET_MESSAGE, new Object[]{rec, myLaunchConfigurationWorkingCopy.getAttribute(IQvtLaunchConstants.MODULE, "")}),  //$NON-NLS-1$
					(!physicalBreakpoints.contains(rec.lineNumber)) == rec.fail
			) ;
    	}
    	
    	// Check up debugger log
    	for (LogRecord rec : myListener.getLog()) {
			System.out.println(rec.toString(myMarkedTrans));
			assertTrue(MessageFormat.format(WRONG_LINE_NUMBER_MESSAGE, new Object[]{rec.getCommand(), rec.toString()}), rec.getLineNumber() == rec.getCommand().lineNumber);
			assertTrue(MessageFormat.format(WRONG_CAUSE_MESSAGE,
					new Object[]{rec.getCommand(), LogRecord.eventDetailToString(rec.getEventDetail())}), rec.getEventDetail() == rec.getCommand().getEventDetail());
		}		
		assertFalse(
				MessageFormat.format(SCRIPT_NOT_FINISHED_MESSAGE, new Object[]{getProjectFileName(folder, SCRIPT_FILE)}),  
				myScript.hasNextCommand()
		);
    }
    
	private Set<Integer> getPhysicalBreakpoints() throws CoreException {
		Set<Integer> physicalBreakpoints = new HashSet<Integer>();
		
		IBreakpointManager manager = DebugPlugin.getDefault().getBreakpointManager();
		IBreakpoint[] qvtBreakpoints = manager.getBreakpoints(QVTODebugCore.MODEL_ID);
		for (int i = 0; i < qvtBreakpoints.length; i++) {
			if (qvtBreakpoints[i] instanceof QVTOBreakpoint == false) {
				continue;
			}			
			QVTOBreakpoint breakpoint = (QVTOBreakpoint) qvtBreakpoints[i];
            if (breakpoint.isEnabled()) {
            	physicalBreakpoints.add(breakpoint.getLineNumber());
            }
		}
		
		return physicalBreakpoints;
	}
    
    
	private static TestProject myProject;
	private static ILaunchConfigurationWorkingCopy myLaunchConfigurationWorkingCopy;
	private DebugEventLogger myListener; 
	private Script myScript;
    private MarkedTransformation myMarkedTrans;

    private static final String PROJECT_NAME = "DebuggerTest"; //$NON-NLS-1$
    private static final String CONFIG_NAME = "debugConfig"; //$NON-NLS-1$
    private static final String TEST_DATA_FOLDER = "debuggerTestData"; //$NON-NLS-1$
    private static final String MARKED_TEST_FILE = "markedTest.qvto"; //$NON-NLS-1$
    private static final String TEST_FILE = "test.qvto"; //$NON-NLS-1$
    private static final String IN_MODEL = "in.ecore"; //$NON-NLS-1$
    private static final String TRACE_FILE = "in.ecore.trace"; //$NON-NLS-1$
    private static final String SCRIPT_FILE = "test.xml"; //$NON-NLS-1$
    private static final String LOADING_TEST_MESSAGE = "DebuggerTester: Loading test {0}"; //$NON-NLS-1$
    private static final String RUNNING_DEBUGGER_MESSAGE = "DebuggerTester: Running debugger..."; //$NON-NLS-1$
    private static final String TEST_FINISHED_MESSAGE = "DebuggerTester: Debugging finished: {0}"; //$NON-NLS-1$
    private static final String BREAKPOINT_SET_MESSAGE = "Breakpoint set incorrectly: {0} in {1}"; //$NON-NLS-1$
    private static final String BREAKPOINT_NOT_SET_MESSAGE = "Breakpoint not set incorrectly: {0} in {1}"; //$NON-NLS-1$
    private static final String WRONG_LINE_NUMBER_MESSAGE = "Line numbers don''t correspond: {0} vs {1}."; //$NON-NLS-1$
    private static final String WRONG_CAUSE_MESSAGE = "Stop causes don''t correspond: {0} vs \"{1}\"."; //$NON-NLS-1$
    private static final String SCRIPT_NOT_FINISHED_MESSAGE = "Script not finished: {0}"; //$NON-NLS-1$
}
