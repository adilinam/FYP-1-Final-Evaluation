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

import java.util.ArrayList;
import java.util.List;

/**
* @author aigdalov
* Created on Nov 21, 2007
*/
class Scope {
    private Scope myParent;
    private List<String> myVariables;
    
    public Scope(Scope parent) {
        myParent = parent;
    }
    
    public Scope getParent() {
        return myParent;
    }
    
    public void addVariable(String varDecl) {
        if (myVariables == null) {
            myVariables = new ArrayList<String>();
        }
        myVariables.add(varDecl);
    }
    
    private void serialize(StringBuilder stringBuilder) {
        if (myParent != null) {
            myParent.serialize(stringBuilder);
        }
        if (myVariables != null) {
            for (String varDecl : myVariables) {
                stringBuilder.append(varDecl);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(stringBuilder);
        return stringBuilder.toString();
    }
}