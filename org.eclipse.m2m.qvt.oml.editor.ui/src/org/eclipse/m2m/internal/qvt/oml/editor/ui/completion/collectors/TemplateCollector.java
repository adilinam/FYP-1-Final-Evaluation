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

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtTemplateCompletionProcessor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.ICollector;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 */
public class TemplateCollector implements ICollector {
    private final QvtTemplateCompletionProcessor myQvtTemplateCompletionProcessor = new QvtTemplateCompletionProcessor();

	public boolean isApplicable(QvtCompletionData data) {
		return true;
	}
	
	public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
		ICompletionProposal[] templateProposals = 
			myQvtTemplateCompletionProcessor.computeCompletionProposals(data.getViewer(), data.getOffset());
		Collections.addAll(proposals, templateProposals);
	}
}