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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.ICollector;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 * Created on Mar 19, 2008
 */
public abstract class AbstractCollector implements ICollector {
    public boolean isApplicable(QvtCompletionData data) {
        if (data.getLeftToken() == null) {
            return false;
        }
        return isApplicableInternal(data);
    }
    
    protected abstract boolean isApplicableInternal(QvtCompletionData data);
}