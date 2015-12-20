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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.Collection;

import org.eclipse.jface.text.contentassist.ICompletionProposal;

/**
 * @author aigdalov
 */

public interface ICollector {
	public boolean isApplicable(QvtCompletionData data);
    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data);
}