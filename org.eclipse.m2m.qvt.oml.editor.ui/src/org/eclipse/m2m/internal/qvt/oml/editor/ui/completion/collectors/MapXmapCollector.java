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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * @author Aleksandr Igdalov
 * Created on Aug 7, 2007
 */

public class MapXmapCollector extends AbstractCallExpSourceCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
        if (super.isApplicableInternal(data)) {
            return true;
        }
        return QvtCompletionData.isKindOf(data.getLeftToken(), LightweightParserUtil.MAPPING_CALL_TERMINALS);
    }

    public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
        IToken accessorToken = getAccessorToken(data);
        EClassifier classifier = getCallExpSourceType(accessorToken, data);
        if (classifier == null) {
            CompletionProposalUtil.addAllContextlessMappings(proposals, data);
        } else {
            CompletionProposalUtil.addMappingOperations(proposals, classifier, data);
            if (QvtCompletionData.isKindOf(accessorToken, QVTOParsersym.TK_ARROW)) {
                CollectionType collection = (CollectionType) classifier;
                EClassifier elementType = collection.getElementType();
                CompletionProposalUtil.addMappingOperations(proposals, elementType, data);
            }
        }
    }
    
    protected TypedElement<EClassifier> getCallExpSource(QvtCompletionData data) {
        IToken accessorToken = data.getLeftToken(1);
        if ((accessorToken == null) || (getAccessorToken(data) == null)) {
            return null;
        }
        return getCallExpSource(accessorToken, data);
    }
    
    private static IToken getAccessorToken(QvtCompletionData data) {
        IToken leftToken = data.getLeftToken();
        if (QvtCompletionData.isKindOf(leftToken, LightweightParserUtil.MAPPING_CALL_TERMINALS)) {
            return data.getLeftToken(1);
        }
        return null;
    }
}