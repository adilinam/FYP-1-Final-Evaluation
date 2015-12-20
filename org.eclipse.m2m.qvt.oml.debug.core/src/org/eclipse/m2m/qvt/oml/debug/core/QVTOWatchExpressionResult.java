/*******************************************************************************
 * Copyright (c) 2010 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IWatchExpressionResult;

public class QVTOWatchExpressionResult implements IWatchExpressionResult {
    
	public QVTOWatchExpressionResult(String expressionText, IValue value, String[] errorMessages) {
        myExpressionText = expressionText;
        myValue = value;
        myErrorMessages = errorMessages;
    }
    
    public IValue getValue() {
        return myValue;
    }

    public boolean hasErrors() {
        return myErrorMessages.length > 0;
    }

    public String[] getErrorMessages() {
        return myErrorMessages;
    }

    public String getExpressionText() {
        return myExpressionText;
    }

    public DebugException getException() {
        return null;
    }
    
    private final String myExpressionText;
    private final IValue myValue;
    private final String[] myErrorMessages;
}
