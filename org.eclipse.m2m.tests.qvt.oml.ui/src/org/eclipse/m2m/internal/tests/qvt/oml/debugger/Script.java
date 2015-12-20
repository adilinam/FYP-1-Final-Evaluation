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
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.debug.core.DebugEvent;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Responsible for parsing a script file (XML) into commands and for storing 
 * those commands 
 */
class Script {
    public Script(String fileName, MarkedTransformation markedTrans) throws Exception {
        myCommandList = new ArrayList<Command>();
        myMarkedTrans = markedTrans;
        myModule = fileName;
        parseFile(fileName);
        reset();
    }
        
    private void parseFile(String fileName) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setErrorHandler(new ErrorHandler() {
            public void error(SAXParseException arg0) throws SAXException {
                System.err.println(arg0);
            }

            public void fatalError(SAXParseException arg0) throws SAXException {
                System.err.println(arg0);
            }

            public void warning(SAXParseException arg0) throws SAXException {
                System.err.println(arg0);
            }
        });
        Document document = builder.parse(fileName);
        NodeList commands = document.getDocumentElement().getChildNodes();
        int prevCode = INVALID_CODE; // no previous command
        for (int i = 0; i < commands.getLength(); i++) {
            Node node = commands.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            // Retrieve code
            String command = node.getNodeName();
            int code = commandToCode(command);
            if (code == BREAKPOINT_CODE) {
                throw new ScriptException(MessageFormat.format(INVALID_COMMAND_MESSAGE, new Object[]{command})); 
            }
            // Retrieve line number
            String markerName = node.getAttributes().getNamedItem(LINE).getNodeValue();
            int lineNumber = -1;
            if (Character.isDigit(markerName.charAt(0))) {
                lineNumber = Integer.valueOf(markerName).intValue();
            }
            else {
                MarkedTransformation.LineMarker myRec = myMarkedTrans.getLineMarker(markerName);
                if (myRec == null) {
                    throw new ScriptException(MessageFormat.format(UNKNOWN_NAME_MESSAGE, new Object[]{markerName, myModule})); 
                }
                lineNumber = myRec.lineNumber;
            }
            // Retrieve cause
            Node causeNode = node.getAttributes().getNamedItem(CAUSE);
            int cause = commandToCode(causeNode.getNodeValue());
            if (cause == NONE_CODE) {
                // Stop might is caused by result of the previous command
                cause = prevCode;
                if (cause == INVALID_CODE) {
                    throw new Exception(MessageFormat.format(INVALID_CAUSE_MESSAGE, new Object[]{command, markerName}));
                }
            }
            myCommandList.add(new Command(node.toString(), code, lineNumber, cause));
            prevCode = code;
        }
    }
    
    /**
     * Converts given command into a code
     * @param command - a string command
     * @return command's code, 0 for unknown command 
     */
    private int commandToCode(String command) throws ScriptException {
        if (command.equals(RESUME_STRING)) {
            return RESUME_CODE;
        }
        else if (command.equals(STEP_OVER_STRING)) {
            return STEP_OVER_CODE;
        } 
        else if (command.equals(STEP_INTO_STRING)) {
            return STEP_INTO_CODE;
        } 
        else if (command.equals(STEP_RETURN_STRING)) {
            return STEP_RETURN_CODE;
        } 
        else if (command.equals(BREAKPOINT_STRING)) {
            return BREAKPOINT_CODE;
        } 
        else if (command.equals(NONE_STRING)) {
            return NONE_CODE;
        } 
        else {
            throw new ScriptException(MessageFormat.format(UNKNOWN_COMMAND_MESSAGE, new Object[]{command}));
        }
    }
    
    /**
     * Sets internal iterator to the beginning of the command list 
     */
    public void reset() {
        myIterator = myCommandList.iterator();
    }
    
    /**
     * @return <code>true</code> if there are commands left in the list
     */
    public boolean hasNextCommand() {
        return myIterator.hasNext();
    }
    
    /**
     * @return next <code>Command</code>
     */
    public Command nextCommand() {
        return myIterator.next();
    }
    
    /**
     * Represents a script command command 
     */
    public class Command {
        public Command(String command, int code, int lineNumber, int cause) {
            this.command = command;
            this.code = code;
            this.lineNumber = lineNumber;
            this.cause = cause;
        }
        
        /**
         * @return DebugEvent.getDetail() representation of cause field
         */
        public int getEventDetail() {
            switch (cause) {
            case STEP_OVER_CODE:
                return DebugEvent.STEP_OVER;
            case STEP_INTO_CODE:
                return DebugEvent.STEP_INTO;
            case STEP_RETURN_CODE:
                return DebugEvent.STEP_RETURN;
            case BREAKPOINT_CODE:
                return DebugEvent.BREAKPOINT;
            default:
                return DebugEvent.UNSPECIFIED;
            }
        }
        
        public String toString() {
            return command;
        }
        
        public final String command; 
        public final int code; 
        public final int lineNumber; 
        public final int cause; 
    }
    
    public class ScriptException extends Exception {
        public ScriptException(String s) {
            super(s);
        }
        private static final long serialVersionUID = 380437041238179652L;
    }
    
    
    private final List<Command> myCommandList;
    private Iterator<Command> myIterator;
    private final MarkedTransformation myMarkedTrans;
    private String myModule;

    /* Code and Cause strings */
    private static final String RESUME_STRING = "resume"; //$NON-NLS-1$
    private static final String STEP_OVER_STRING = "stepOver"; //$NON-NLS-1$
    private static final String STEP_INTO_STRING = "stepInto"; //$NON-NLS-1$
    private static final String STEP_RETURN_STRING = "return"; //$NON-NLS-1$
    private static final String BREAKPOINT_STRING = "breakpoint"; //$NON-NLS-1$
    private static final String NONE_STRING = "none"; //$NON-NLS-1$
    /* Code and Cause codes */
    public static final int RESUME_CODE = 1;
    public static final int STEP_OVER_CODE = 2;
    public static final int STEP_INTO_CODE = 3;
    public static final int STEP_RETURN_CODE = 4;
    public static final int BREAKPOINT_CODE = 5;
    public static final int NONE_CODE = 0;
    public static final int INVALID_CODE = -1;
    /* Attribute names */
    private static final String LINE = "line"; //$NON-NLS-1$
    private static final String CAUSE = "cause"; //$NON-NLS-1$
    /* Error messages */
    private static final String UNKNOWN_COMMAND_MESSAGE = "Unknown command: {0}";  //$NON-NLS-1$
    private static final String UNKNOWN_NAME_MESSAGE = "Unknown marker name: {0} in {1}"; //$NON-NLS-1$
    private static final String INVALID_CAUSE_MESSAGE = "Invalid cause: {0} line=\"{1}\""; //$NON-NLS-1$
    private static final String INVALID_COMMAND_MESSAGE = "Invalid command: {0}"; //$NON-NLS-1$
}
