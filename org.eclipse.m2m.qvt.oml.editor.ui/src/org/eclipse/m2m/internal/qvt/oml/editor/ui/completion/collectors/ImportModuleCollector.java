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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lpg.runtime.IToken;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.blackbox.AbstractCompilationUnitDescriptor;
import org.eclipse.m2m.internal.qvt.oml.blackbox.BlackboxRegistry;
import org.eclipse.m2m.internal.qvt.oml.blackbox.ResolutionContextImpl;
import org.eclipse.m2m.internal.qvt.oml.common.project.CompiledTransformation;
import org.eclipse.m2m.internal.qvt.oml.common.project.TransformationRegistry;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolver;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformationRegistry;

/**
 * @author aigdalov
 * Created on Oct 1, 2007
 */

public class ImportModuleCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        return leftToken.getKind() == QVTOParsersym.TK_import;
    }


    public void addPropoposals(Collection<ICompletionProposal> proposals,
            QvtCompletionData data) {
        addLocalModulesProposals(proposals, data);
        addDeployedModulesProposals(proposals, data);
        final ResolutionContextImpl loadContext = new ResolutionContextImpl(data.getCFile().getURI());
        for (AbstractCompilationUnitDescriptor abstractCompilationUnitDescriptor : BlackboxRegistry.INSTANCE.getCompilationUnitDescriptors(loadContext)) {
            String proposalString = abstractCompilationUnitDescriptor.getQualifiedName();
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.MAPPING, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);        	
		}        
        
    }

    private void addLocalModulesProposals(
            Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        UnitProxy unit = data.getCFile();
		URI compiledFileURI = unit.getURI();
        IResource compiledFile = URIUtils.getResource(compiledFileURI);
        if(compiledFile.getType() != IResource.FILE) {
        	return;
        }

        addFolderProposals(unit, proposals, data, new String[] {});
    }
    
    private void addFolderProposals(UnitProxy excludedFile,
            Collection<ICompletionProposal> proposals, QvtCompletionData data, String[] path) {

		final List<UnitProxy> members = new ArrayList<UnitProxy>();
		
		UnitResolver resolver = excludedFile.getResolver();
		// FIXME - avoid the assumption that a unit resolver is also a provider
		// for now, import proposals are available only if this recondition is true
		if(resolver instanceof UnitProvider) {
			UnitProvider unitProvider = (UnitProvider) resolver;			
			UnitProvider.UnitVisitor visitor = new UnitProvider.UnitVisitor() {
				public boolean visitUnit(UnitProxy unit) {
					members.add(unit);
					return true;
				}
			};
			
			unitProvider.accept(visitor, null /* default namespace */,
					UnitProvider.UnitVisitor.DEPTH_INFINITE, false);
			
			Collections.sort(members, new Comparator<UnitProxy>() {
				public int compare(UnitProxy unit1, UnitProxy unit2) {
					return unit1.getQualifiedName().compareTo(unit2.getQualifiedName());
				}
			});
		}	

        for (UnitProxy memberUnit : members) {
        	if(!memberUnit.equals(excludedFile)) {
        		String qualifiedName = memberUnit.getQualifiedName(); 
                QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(qualifiedName, CategoryImageConstants.CLASS, data);
                CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
            }
        }
    }


    private void addDeployedModulesProposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        List<CompiledTransformation> transformations = QvtTransformationRegistry.getInstance().getTransformations(TransformationRegistry.EMPTY_FILTER);
        for (CompiledTransformation transformation : transformations) {
            String proposalString = transformation.getId();
            QvtCompletionProposal info = CompletionProposalUtil.createCompletionProposal(proposalString, CategoryImageConstants.CLASS, data);
            CompletionProposalUtil.addProposalIfNecessary(proposals, info, data);
        }
    }
}