/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui;

import java.io.IOException;
import java.io.Reader;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * Reads from a document either forwards or backwards. May be configured to skip
 * comments and strings.
 */
public class QvtCodeReader {

    public QvtCodeReader() {
    }

    /**
     * Returns the offset of the last read character. Should only be called
     * after read has been called.
     */
    public int getOffset() {
        return myForward ? myOffset - 1 : myOffset;
    }

    public void configureForwardReader(IDocument document, int offset,
            int length, boolean skipComments, boolean skipStrings) {
        myDocument = document;
        myOffset = offset;
        mySkipComments = skipComments;
        mySkipStrings = skipStrings;

        myForward = true;
        myEnd = Math.min(myDocument.getLength(), myOffset + length);
    }

    public void configureBackwardReader(IDocument document, int offset,
            boolean skipComments, boolean skipStrings) throws IOException {
        myDocument = document;
        myOffset = offset;
        mySkipComments = skipComments;
        mySkipStrings = skipStrings;

        myForward = false;
        try {
            myCachedLineNumber = myDocument.getLineOfOffset(myOffset);
        } catch (BadLocationException x) {
            throw new IOException(x.getMessage());
        }
    }

    /*
     * @see Reader#close()
     */
    public void close() {
        myDocument = null;
    }

    /*
     * @see SingleCharReader#read()
     */
    public int read() throws IOException {
        try {
            return myForward ? readForwards() : readBackwards();
        } catch (BadLocationException x) {
            throw new IOException(x.getMessage());
        }
    }

    private void gotoCommentEnd() throws BadLocationException {
        while (myOffset < myEnd) {
            char current = myDocument.getChar(myOffset++);
            if (current == '*') {
                if (myOffset < myEnd && myDocument.getChar(myOffset) == '/') {
                    ++myOffset;
                    return;
                }
            }
        }
    }

    private void gotoStringEnd(char delimiter) throws BadLocationException {
        while (myOffset < myEnd) {
            char current = myDocument.getChar(myOffset++);
            if (current == '\\') {
                // ignore escaped characters
                ++myOffset;
            } else if (current == delimiter) {
                return;
            }
        }
    }

    private void gotoLineEnd() throws BadLocationException {
        int line = myDocument.getLineOfOffset(myOffset);
        myOffset = myDocument.getLineOffset(line + 1);
    }

    private int readForwards() throws BadLocationException {
        while (myOffset < myEnd) {
            char current = myDocument.getChar(myOffset++);

            switch (current) {
                case '/' :

                    if (mySkipComments && myOffset < myEnd) {
                        char next = myDocument.getChar(myOffset);
                        if (next == '*') {
                            // a comment starts, advance to the comment end
                            ++myOffset;
                            gotoCommentEnd();
                            continue;
                        } /*else if (next == '/') {
                            // '//'-comment starts, advance to the line end
                            gotoLineEnd();
                            continue;
                        }*/
                    }

                    return current;
                    
                case '-' :
                	
                	if (mySkipComments && myOffset < myEnd) {
                		char next = myDocument.getChar(myOffset);
                        if (next == '-') {
                        	 // '--'-comment starts, advance to the line end
                            gotoLineEnd();
                            continue;
                        } 
                	}
                	
                	return current;

                case '"' :
                case '\'' :

                    if (mySkipStrings) {
                        gotoStringEnd(current);
                        continue;
                    }

                    return current;
            }

            return current;
        }

        return EOF;
    }

    private void handleSingleLineComment() throws BadLocationException {
        int line = myDocument.getLineOfOffset(myOffset);
        if (line < myCachedLineNumber) {
            myCachedLineNumber = line;
            myCachedLineOffset = myDocument.getLineOffset(line);
            int offset = myOffset;
            while (myCachedLineOffset < offset) {
                char current = myDocument.getChar(offset--);
                if (current == '-' && myCachedLineOffset <= offset
                        && myDocument.getChar(offset) == '-') {
                    myOffset = offset;
                    return;
                }
            }
        }
    }

    private void gotoCommentStart() throws BadLocationException {
        while (0 < myOffset) {
            char current = myDocument.getChar(myOffset--);
            if (current == '*' && 0 <= myOffset
                    && myDocument.getChar(myOffset) == '/')
                return;
        }
    }

    private void gotoStringStart(char delimiter) throws BadLocationException {
        while (0 < myOffset) {
            char current = myDocument.getChar(myOffset);
            if (current == delimiter) {
                if (!(0 <= myOffset && myDocument.getChar(myOffset - 1) == '\\'))
                    return;
            }
            --myOffset;
        }
    }

    private int readBackwards() throws BadLocationException {

        while (0 < myOffset) {
            --myOffset;

            handleSingleLineComment();

            char current = myDocument.getChar(myOffset);
            switch (current) {
                case '/' :

                    if (mySkipComments && myOffset > 1) {
                        char next = myDocument.getChar(myOffset - 1);
                        if (next == '*') {
                            // a comment ends, advance to the comment start
                            myOffset -= 2;
                            gotoCommentStart();
                            continue;
                        }
                    }

                    return current;

                case '\'' :

                    if (mySkipStrings) {
                        --myOffset;
                        gotoStringStart(current);
                        continue;
                    }

                    return current;
            }

            return current;
        }

        return EOF;
    }

    public int read(char cbuf[], int off, int len) throws IOException {
        int end = off + len;
        for (int i = off; i < end; i++) {
            int ch = read();
            if (ch == -1) {
                if (i == off) {
                    return -1;
                } else {
                    return i - off;
                }
            }
            cbuf[i] = (char) ch;
        }
        return len;
    }

    /**
     * @see Reader#ready()
     */
    public boolean ready() {
        return true;
    }

    /**
     * Gets the content as a String
     */
    public String getString() throws IOException {
        StringBuffer buf = new StringBuffer();
        int ch;
        while ((ch = read()) != -1) {
            buf.append((char) ch);
        }
        return buf.toString();
    }

    /** The EOF character */
    public static final int EOF = -1;

    private boolean mySkipComments = false;
    private boolean mySkipStrings = false;
    private boolean myForward = false;

    private IDocument myDocument;
    private int myOffset;

    private int myEnd = -1;
    private int myCachedLineNumber = -1;
    private int myCachedLineOffset = -1;
}