/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction;

import lpg.runtime.IToken;

/**
* @author aigdalov
* Created on Nov 21, 2007
*/
class Result {
    private IToken myStartToken;
    private IToken myEndToken;
    private String myString;
    private Scope myScope;
    private IToken myLastKnownGoodToken;
    
    public Result(IToken startToken, IToken endToken, String string, Scope scope) {
        myStartToken = startToken;
        myEndToken = endToken;
        myString = string;
        myScope = scope;
    }

    public Result(IToken startToken, IToken endToken, String string, Scope scope, IToken lastKnownGoodToken) {
        this(startToken, endToken, string, scope);
        myLastKnownGoodToken = lastKnownGoodToken;
    }

    public IToken getStartToken() {
        return myStartToken;
    }
    
    public void setStartToken(IToken startToken) {
        myStartToken = startToken;
    }
    
    public IToken getEndToken() {
        return myEndToken;
    }
    
    public void setEndToken(IToken endToken) {
        myEndToken = endToken;
    }
    
    public String getString() {
        return myString;
    }
    
    public void setString(String string) {
        myString = string;
    }
    
    public Scope getScope() {
        return myScope;
    }
    
    public void setScope(Scope scope) {
        myScope = scope;
    }

    public IToken getLastKnownGoodToken() {
        return myLastKnownGoodToken;
    }

    public void setLastKnownGoodToken(IToken lastKnownGoodToken) {
        myLastKnownGoodToken = lastKnownGoodToken;
    }
}