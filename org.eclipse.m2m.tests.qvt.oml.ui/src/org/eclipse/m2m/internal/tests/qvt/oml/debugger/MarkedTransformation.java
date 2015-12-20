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
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import org.eclipse.m2m.internal.qvt.oml.common.util.StringLineNumberProvider;

/**
 * Represents a marked transformation file, parses it and produces marker name to line number 
 * mappings along with "clean text" - without markers.
 * A line marker is set in the transformation file to denote a simple label and maybe an
 * attempt to set up a breakpoint.<br>
 * An assert annotation is set somewhere in the file to check up an equality type condition.<br>
 * A syntax of <b>markers</b> is the following:<br>
 * <ol>
 *   <li> A marker token starts at <i>the first symbol</i> of the line<br>
 *   <li> A marker token begins with a <i>prefix</i> "<code>--!@#</code>" (<code>LINE_MARKER_PREFIX</code>)<br>
 *   <li> A substring from the first symbol after prefix and up to the first whitespace
 *    character is the marker's <i>name</i><br>
 *   <li> A name <i>cannot</i> start with a digit<br>
 *   <li> To denote an attempt to set up a breakpoint on the line <i>following</i> the one 
 *    with the marker put a "breakpoint" keyword (<code>BREAKPOINT</code>) after the name (separated by a 
 *    whitespace)<br>
 *   <li> To denote that an attempt to set a breakpoint <i>must fail</i> put a "fail" (<code>BREAKPOINT_FAIL</code>) 
 *    keyword after "breakpoint keyword"<br>
 * </ol>
 * Examples:<br>
 *   <code>--!@#b1</code> // simply names the next line as "b1"<br>
 *   <code>--!@#b1 breakpoint</code> // denotes an attempt to set a breakpoint on the next line
 *                      which must fall into success<br>
 *   <code>--!@#b1 breakpoint fail</code> // the same as the previuos but an attempt must fail<br>
 * A syntax of <b>assert annotations</b> is the following:<br>
 * <ol>
 *   <li> An annotation token starts at <i>the first symbol</i> of the line<br>
 *   <li> An annotation token begins with a <i>prefix</i> "<code>--!@@</code>"<br>
 *   <li> A substring from the first symbol after prefix and up to the first "<code>@</code>" character is the expression
 *   being examined. This must be a valid OCL boolean expression. It's asserted to be true
 * </ol>
 * Examples:<br>
 *   <code>--!@@model.name = '123123123'</code> // checks up given expression
 */
class MarkedTransformation {
    /**
     * @param markedData - a <b><i>text</i></b> of the transformation with line markers
     */
    public MarkedTransformation(String markedData) {
        myLineRecs = new LinkedHashMap<Object,LineMarker>();
        myCleanText = parseAndFilterMarkedFile(markedData);
    }

    /**
     * Parses a transformation file with markers (see {@link LineMarker})<br>
     * Fills in myLineRecs and myLineToName maps
     * @param fileName - a name of file to be parsed
     * @return a text of the file without markers
     */
    public String parseAndFilterMarkedFile(String markedData) {
        String cleanData = ""; //$NON-NLS-1$
        StringLineNumberProvider lnp = new StringLineNumberProvider(markedData);
        String[] lines = new String[lnp.getLineCount()]; 
        int prevEnd = 0;
        for (int i = 0; i < lnp.getLineCount(); i++) {
           lines[i] = markedData.substring(prevEnd, lnp.getLineEnd(i + 1) + 1);
           prevEnd = lnp.getLineEnd(i + 1) + 1;
        }
        /* Parsing a file for line-markers */
        int lineCounter = 0;
        boolean actualFlag;
        for (int absoluteLine = 0; absoluteLine < lines.length; absoluteLine++) {
            final String line = lines[absoluteLine]; 
            lineCounter++;
            actualFlag = true;
            if (line.startsWith(LINE_MARKER_PREFIX)) {
                int nameLen = 0;
                boolean breakpoint = false;
                boolean fail = false;
                int failOfs = 0;
                int bpOfs = 0;
                // A state-machine
                int state = 0; // looking for name
                for (int i = LINE_MARKER_PREFIX.length(); (i < line.length()) && (state != -1); i++) {
                    switch (state) {
                    case 0: // looking for name
                        if (Character.isWhitespace(line.charAt(i))) {
                            if (nameLen == 0) {
                                state = -1; // exit
                            }
                            else {
                                state = 1; // looking for "breakpoint"
                            }
                        }
                        else {
                             if (Character.isDigit(line.charAt(i)) && (nameLen == 0)) {
                                System.err.println(MessageFormat.format(MARKER_NAME_START_MESSAGE, new Object[]{new Integer(absoluteLine), line.trim()})); 
                                state = -1; // exit
                            }
                            else {
                                nameLen++;
                            }
                        }
                        break;
                    case 1: // looking for "breakpoint"
                        if (Character.isWhitespace(line.charAt(i))) {                               
                            if (bpOfs > 0) {
                                breakpoint = bpOfs == BREAKPOINT.length();
                                state = (breakpoint)?2:-1; // looking for "fail" if a breakpoint found, exit otherwise
                            }
                        }
                        else {
                             if (line.charAt(i) == BREAKPOINT.charAt(bpOfs)) {
                                 bpOfs++;
                             }
                             else {
                                 state = -1; // exit
                             }
                        }
                        break;
                    case 2: // looking for "fail"
                        if (Character.isWhitespace(line.charAt(i))) {                               
                            if (failOfs > 0) {
                                fail = failOfs == BREAKPOINT_FAIL.length();
                                state = -1; // exit
                            }
                        }
                        else {
                             if (line.charAt(i) == BREAKPOINT_FAIL.charAt(failOfs)) {
                                 failOfs++;
                             }
                             else {
                                 state = -1; // exit
                             }
                        }
                        break;
                    case -1: // exit;
                        break;
                    }
                    
                }
                if (nameLen == 0) {
                    System.err.println(MessageFormat.format(NO_NAME_FOUND_MESSAGE, new Object[]{new Integer(absoluteLine), line.trim()})); 
                } 
                else {
                    String name = line.substring(LINE_MARKER_PREFIX.length(), LINE_MARKER_PREFIX.length() + nameLen);
                    if (myLineRecs.containsKey(name)) {
                        throw new RuntimeException(MessageFormat.format(DUPLICATE_MARKER_NAME_MESSAGE, new Object[]{name, new Integer(absoluteLine), line.trim()}));
                    }
                    LineMarker marker = new LineMarker(lineCounter, absoluteLine, name, breakpoint, fail);
                    // The same hash stores line numbers and names as keys for the same object
                    myLineRecs.put(name, marker);
                    myLineRecs.put(new Integer(lineCounter), marker);
                    actualFlag = false;
                    lineCounter--;
                }
            }
            if (actualFlag) {
                cleanData = cleanData.concat(line);
            }
        }
        return cleanData;
    }

    /**
     * @param name - Marker's name
     * @return a line marker with given name
     */
    public LineMarker getLineMarker(String name) {
        return (LineMarker) myLineRecs.get(name);
    }
    
    /**
     * @param lineNumber - number of line in a <b><i>clean</i></b> file - without markers
     * @return a line marker of given line
     */
    public LineMarker getLineMarker(int lineNumber) {
        return (LineMarker) myLineRecs.get(new Integer(lineNumber));
    }
    
    /**
     * @return Clean transformation text - without any markers
     */
    public String getCleanText() {
        return myCleanText;
    }
    
    /**
     * @return A collection of all the markers specified for this transformation
     */
    public Collection<LineMarker> getBreakpointLineMarkers() {
    	Collection<LineMarker> result = new LinkedHashSet<LineMarker>();
    	for (LineMarker rec : myLineRecs.values()) {
    		if (rec.breakpoint) {
    			result.add(rec);
    		}
    	}
        return result;
    }
    
    /**
     * Represents a line marker
     */
    public class LineMarker {
        /**
         * Creates a new marker object
         * @param lineNumber - line number in clean text
         * @param absoluteLine - line number in marked text
         * @param name - marker name
         * @param breakpoint - "breakpoint"
         * @param fail  - "fail"
         */
        public LineMarker(int lineNumber, int absoluteLine, String name, boolean breakpoint, boolean fail) {
            this.name = name;
            this.lineNumber = lineNumber;
            this.absoluteLine = absoluteLine;
            this.breakpoint = breakpoint;
            this.fail = fail;
        }
        
        public String toString() {
            return MessageFormat.format("line {4}({0}): \"{1} {2} {3}\"", new Object[] { new Integer(lineNumber), name, ((breakpoint)?BREAKPOINT:""), ((fail)?BREAKPOINT_FAIL:""), new Integer(absoluteLine)}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        }
        
        public final int lineNumber;
        public final int absoluteLine;
        public final String name;
        public final boolean breakpoint;
        public final boolean fail;
    }

    private final HashMap<Object, LineMarker> myLineRecs;
    private final String myCleanText;

    private static final String LINE_MARKER_PREFIX = "--!@#";  //$NON-NLS-1$
    private static final String BREAKPOINT = "breakpoint";  //$NON-NLS-1$
    private static final String BREAKPOINT_FAIL = "fail"; //$NON-NLS-1$
    private static final String MARKER_NAME_START_MESSAGE = "A line marker name cannot start with a digit: line {0}:{1}"; //$NON-NLS-1$
    private static final String NO_NAME_FOUND_MESSAGE = "No name found. Line marker ignored: line {0}:{1}"; //$NON-NLS-1$
    private static final String DUPLICATE_MARKER_NAME_MESSAGE = "Duplicate marker name \"{0}\": line {1}:{2}"; //$NON-NLS-1$
}
