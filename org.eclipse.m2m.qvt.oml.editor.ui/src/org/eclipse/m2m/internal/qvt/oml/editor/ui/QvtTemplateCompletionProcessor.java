/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension2;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.swt.graphics.Image;

/**
 * @author vrepeshko
 */
public class QvtTemplateCompletionProcessor extends TemplateCompletionProcessor {
	
	public QvtTemplateCompletionProcessor() {
		myContextType = Activator.getDefault().getContextTypeRegistry().getContextType(QvtTemplateContextType.ID);
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		ICompletionProposal[] allProposals = super.computeCompletionProposals(viewer, offset);
		List<ICompletionProposal> validProposals = new ArrayList<ICompletionProposal>(allProposals.length);
		for (ICompletionProposal proposal : allProposals) {
			if (proposal instanceof ICompletionProposalExtension2) {
				if (!((ICompletionProposalExtension2) proposal).validate(viewer.getDocument(), offset, null)) {
					continue;
				}
			}
			validProposals.add(proposal);
		}
		Collections.sort(validProposals, new Comparator<ICompletionProposal>() {
		
			public int compare(ICompletionProposal o1, ICompletionProposal o2) {
				return String.CASE_INSENSITIVE_ORDER.compare(o1.getDisplayString(), o2.getDisplayString());
			}
		
		});
		return validProposals.toArray(new ICompletionProposal[validProposals.size()]);
	}
	
	@Override
	protected TemplateContextType getContextType(ITextViewer viewer, IRegion region) {
		return myContextType;
	}
	
	@Override
	protected TemplateContext createContext(ITextViewer viewer, IRegion region) {
		TemplateContextType contextType = getContextType(viewer, region);
		if (contextType != null) {
			IDocument document = viewer.getDocument();
			return new QvtTemplateContext(contextType, document, region.getOffset(), region.getLength());
		}
		return null;
	}

	@Override
	protected Image getImage(Template template) {
		return CompletionProposalUtil.getImage(CategoryImageConstants.TEMPLATE);
	}

	@Override
	protected Template[] getTemplates(String contextTypeId) {
		return Activator.getDefault().getTemplateStore().getTemplates(contextTypeId);
	}
	
	private final TemplateContextType myContextType;

}

