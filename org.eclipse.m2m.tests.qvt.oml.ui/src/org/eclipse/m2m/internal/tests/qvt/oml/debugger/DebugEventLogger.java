/*******************************************************************************
 * Copyright (c) 2013 S.Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     S.Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.tests.qvt.oml.debugger;

import java.text.MessageFormat;
import java.util.ArrayList;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IWatchExpression;
import org.eclipse.m2m.qvt.oml.debug.core.QVTOThread;
import org.eclipse.m2m.qvt.oml.debug.core.vm.VMLocation;

/**
 * A listener for <code>DebugPlugin</code> events
 * Writes a <code>log</code>  - a list of (@link <code>LogRecord</code>)
 * @see <code>DebugPlugin</code>
 */
class DebugEventLogger implements IDebugEventSetListener {
    
    /**
     * Creates a new event listener object that will resume a thread containing a <code>lock</code>
     * object after obtaining <code>TERMINATE</code> event 
     * @param lock - a thread lock to be sent a <code>notify()</code> call on <code>TERMINATE</code> event
     * @see <code>DebugEvent</code> 
     */
    public DebugEventLogger(Object lock, Script script) {
        myLog = new ArrayList<LogRecord>();
        myLock = lock;
        myScript = script;
    }

    /**
     * @see <code>IDebugEventSetListener#handleDebugEvents</code>
     */
    public void handleDebugEvents(DebugEvent[] events) {
        for (int i = 0; i < events.length; i++) {
            switch (events[i].getKind())
            {
            case DebugEvent.SUSPEND: // The program has been interrupted
            	if (false == events[i].getSource() instanceof QVTOThread) {
            		return;
            	}
            	QVTOThread thread = (QVTOThread) events[i].getSource();
                Script.Command command = null;
                if (myScript.hasNextCommand()) {
                    command = myScript.nextCommand();
                }
                try {
                    try {
                        if (events[i].getData() instanceof VMLocation) { 
                            // location information provided
                            // @see QVTOThread.handleEvent() implementation
                        	VMLocation location = (VMLocation) events[i].getData();
                            int detail = events[i].getDetail();
                            int line = location.getLineNum();
                            myLog.add(new LogRecord(detail, line, command));
                        }
                    }
                    finally {
                        if (command != null) {
                            IWatchExpression expr = DebugPlugin.getDefault().getExpressionManager().newWatchExpression("100 = 1");
                            expr.setExpressionContext(thread);
                            switch (command.code) {
                            case Script.RESUME_CODE:
                                thread.resume();
                                break;
                            case Script.STEP_INTO_CODE:
                                thread.stepInto();
                                break;
                            case Script.STEP_OVER_CODE:
                                thread.stepOver();
                                break;
                            case Script.STEP_RETURN_CODE:
                                thread.stepReturn();
                                break;
                            }
                        }
                        else {
                            thread.resume();
                        }
                    }
                }
                catch (DebugException e) {
                    System.err.println(e);                          
                }
                break;
            case DebugEvent.TERMINATE: // Debugger has terminated
                // Resume the main thread  
                synchronized(myLock) {
                    myLock.notifyAll();
                }
                break;
            }
        }
    }

    /**
     * @return Log - a list of <code>LogRecord</code> objects
     */
    public ArrayList<LogRecord> getLog() {
        return myLog;
    }
    
    /**
     * Stores a record from debugger's event log.
     */
    static class LogRecord {
        /**
         * Creates a log record consisting of an eventDetail (cause of program interruption,
         * see {@link <code>DebugEvent</code>}) and a line in sorce file where the interruption 
         * occured
         * @param eventDetail - event detail (see {@<code>DebugEvent.getDetail()</code>})
         * @param line - line number
         */
        public LogRecord(int eventDetail, int line, Script.Command command) {
            this.eventDetail = eventDetail;
            this.lineNumber = line;
            this.command = command;
        }
        
        public static String eventDetailToString(int eventDetail) {
            String message;
            switch (eventDetail) {
            case DebugEvent.BREAKPOINT: 
                message = BREAKPOINT_MESSAGE;
                break;
            case DebugEvent.STEP_INTO: 
                message = STEP_INTO_MESSAGE;
                break;
            case DebugEvent.STEP_OVER: 
                message = STEP_OVER_MESSAGE;
                break;
            case DebugEvent.STEP_RETURN: 
                message = RETURN_MESSAGE;
                break;
            default:
                message = String.valueOf(eventDetail);
            }
            return message;
        }
        
        public String toString(MarkedTransformation markedTrans) {
            MarkedTransformation.LineMarker marker = markedTrans.getLineMarker(lineNumber);
            String name = (marker != null)?marker.name:NAME_NONE;
            return eventDetailToString(eventDetail) + MessageFormat.format(LINE_PATTERN, new Object[] {name, new Integer(lineNumber)});
        }
        
        public Script.Command getCommand() {
        	return command;
        }
        
        public int getLineNumber() {
        	return lineNumber;
        }
        
        public int getEventDetail() {
        	return eventDetail;
        }
        
        private final int eventDetail;
        private final int lineNumber;
        private final Script.Command command;
        
        private static final String BREAKPOINT_MESSAGE = "Breakpoint"; //$NON-NLS-1$
        private static final String STEP_INTO_MESSAGE = "Step into"; //$NON-NLS-1$
        private static final String STEP_OVER_MESSAGE = "Step over"; //$NON-NLS-1$
        private static final String RETURN_MESSAGE = "Return"; //$NON-NLS-1$
        private static final String LINE_PATTERN = " (name {0}, line {1})"; //$NON-NLS-1$
        private static final String NAME_NONE = "<unknown>"; //$NON-NLS-1$
    }
    
    private final Script myScript;
    private final Object myLock;
    private final ArrayList<LogRecord> myLog;
}

