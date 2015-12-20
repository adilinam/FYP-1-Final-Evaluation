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

import lpg.runtime.IToken;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public abstract class AbstractMetamodelCollector extends AbstractCollector {
    @Override
    protected boolean isApplicableInternal(QvtCompletionData data) {
		IToken leftToken = data.getLeftToken();
		return QvtCompletionData.isKindOf(leftToken, QVTOParsersym.TK_uses);
	}


	protected static final String getProposalString(QvtCompletionData data, EPackage pack) {
		String nsUriLiteral = '\'' + pack.getNsURI() + '\'';
		String proposalString;
		if ((data.getLeftToken().getKind() == QVTOParsersym.TK_uses)
				&& (pack.getName() != null)
				&& (pack.getName().trim().length() != 0)) {
			proposalString = pack.getName() + '(' + nsUriLiteral + ")"; //$NON-NLS-1$
		} else {
			proposalString = nsUriLiteral;
		}
		return proposalString;
	}
}