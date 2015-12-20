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

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ICharacterPairMatcher;

/**
 * Helper class for match pairs of characters.
 */
public class QvtPairMatcher implements ICharacterPairMatcher {
    
    public QvtPairMatcher(char[] pairs) {
        myPairs= pairs;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#match(org.eclipse.jface.text.IDocument, int)
     */
    public IRegion match(IDocument document, int offset) {
        myOffset= offset;

        if (myOffset < 0)
            return null;

        myDocument= document;

        if (myDocument != null && matchPairsAt() && myStartPos != myEndPos)
            return new Region(myStartPos, myEndPos - myStartPos + 1);
            
        return null;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#getAnchor()
     */
    public int getAnchor() {
        return myAnchor;
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#dispose()
     */
    public void dispose() {
        clear();
        myDocument= null;
        myReader= null;
    }
    
    /*
     * @see org.eclipse.jface.text.source.ICharacterPairMatcher#clear()
     */
    public void clear() {
        if (myReader != null) {
            myReader.close();
        }
    }
    
    protected boolean matchPairsAt() {

        int i;
        int pairIndex1= myPairs.length;
        int pairIndex2= myPairs.length;

        myStartPos= -1;
        myEndPos= -1;

        // get the chars preceding and following the start position
        try {

            char prevChar= myDocument.getChar(Math.max(myOffset - 1, 0));
// modified behavior for http://dev.eclipse.org/bugs/show_bug.cgi?id=16879          
//          char nextChar= fDocument.getChar(fOffset);

            // search for opening peer character next to the activation point
            for (i= 0; i < myPairs.length; i= i + 2) {
//              if (nextChar == fPairs[i]) {
//                  fStartPos= fOffset;
//                  pairIndex1= i;
//              } else 
                if (prevChar == myPairs[i]) {
                    myStartPos= myOffset - 1;
                    pairIndex1= i;
                }
            }
            
            // search for closing peer character next to the activation point
            for (i= 1; i < myPairs.length; i= i + 2) {
                if (prevChar == myPairs[i]) {
                    myEndPos= myOffset - 1;
                    pairIndex2= i;
                } 
//              else if (nextChar == fPairs[i]) {
//                  fEndPos= fOffset;
//                  pairIndex2= i;
//              }
            }

            if (myEndPos > -1) {
                myAnchor= RIGHT;
                myStartPos= searchForOpeningPeer(myEndPos, myPairs[pairIndex2 - 1], myPairs[pairIndex2], myDocument);
                if (myStartPos > -1)
                    return true;
                else
                    myEndPos= -1;
            }   else if (myStartPos > -1) {
                myAnchor= LEFT;
                myEndPos= searchForClosingPeer(myStartPos, myPairs[pairIndex1], myPairs[pairIndex1 + 1], myDocument);
                if (myEndPos > -1)
                    return true;
                else
                    myStartPos= -1;
            }

        } catch (BadLocationException x) {
        } catch (IOException x) {
        }

        return false;
    }
    
    protected int searchForClosingPeer(int offset, int openingPeer, int closingPeer, IDocument document) throws IOException {
        myReader.configureForwardReader(document, offset + 1, document.getLength(), true, true);
        
        int stack= 1;
        int c= myReader.read();
        while (c != QvtCodeReader.EOF) {
            if (c == openingPeer && c != closingPeer)
                stack++;
            else if (c == closingPeer)
                stack--;
                
            if (stack == 0)
                return myReader.getOffset();
                
            c= myReader.read();
        }
        
        return  -1;
    }
    
    protected int searchForOpeningPeer(int offset, int openingPeer, int closingPeer, IDocument document) throws IOException {
        
        myReader.configureBackwardReader(document, offset, true, true);
        
        int stack= 1;
        int c= myReader.read();
        while (c != QvtCodeReader.EOF) {
            if (c == closingPeer && c != openingPeer)
                stack++;
            else if (c == openingPeer)
                stack--;
                
            if (stack == 0)
                return myReader.getOffset();
                
            c= myReader.read();
        }
        
        return -1;
    }
    
    protected char[] myPairs;
    protected IDocument myDocument;
    protected int myOffset;
    
    protected int myStartPos;
    protected int myEndPos;
    protected int myAnchor;
    
    protected QvtCodeReader myReader = new QvtCodeReader();
}
