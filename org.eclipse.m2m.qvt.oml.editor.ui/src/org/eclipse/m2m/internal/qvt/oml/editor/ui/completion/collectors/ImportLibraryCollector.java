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

import lpg.runtime.IToken;

import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;

/**
 * @author aigdalov
 * Created on Oct 1, 2007
 */

public class ImportLibraryCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        if (leftToken.getKind() == QVTOParsersym.TK_library) {
            IToken importToken = data.getLeftToken(1);
            if ((importToken != null) && (importToken.getKind() == QVTOParsersym.TK_import)) {
                return true;
            }
        }
        return false;
    }


    public void addPropoposals(Collection<ICompletionProposal> proposals,
            QvtCompletionData data) {
//        LibrariesRegistry librariesRegistry = OclQvtoPlugin.getDefault().getLibrariesRegistry();
//        for (Library library : librariesRegistry.getLibraries()) {
//            String proposalString = library.getId();
//            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.MAPPING, data);
//            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
//        }
        
        final ResolutionContextImpl loadContext = new ResolutionContextImpl(data.getCFile().getURI());
        for (AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor : BlackboxRegistry.INSTANCE.getCompilationUnitDescriptors(loadContext)) {
            String proposalString = abstractCompilationUnitDescriptor.getQualifiedName();
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.MAPPING, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);        	
		}
    }
}