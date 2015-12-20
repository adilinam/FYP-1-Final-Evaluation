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
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler;

import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CFileData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction.ScopedVariablesExtractor;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class ImperativeOperationHandler implements IKeywordHandler {
    private final ScopedVariablesExtractor myScopedVariablesExtractor = new ScopedVariablesExtractor();
    
    public String handle(IToken keyword, IPrsStream prsStream, QvtCompletionData data, CFileData cFileData) {
        if (QvtCompletionData.isKindOf(keyword, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS)) {
            if (QvtCompletionData.isKindOf(keyword, QVTOParsersym.TK_main)) {
                IToken previousToken = LightweightParserUtil.getPreviousToken(keyword);
                if ((previousToken != null) && QvtCompletionData.isKindOf(previousToken, QVTOParsersym.TK_mapping)) {
                    // This is the 'mapping main' case which was already handled on the previous step
                    return null;
                }
            }
            IToken[] tokens = QvtCompletionData.extractTokens(keyword, QvtCompletionData.MAPPING_DECLARATION_TRAILING_TOKEN_KINDS);
            if (tokens != null) {
                String mappingText = '\n' + LightweightParserUtil.getText(tokens); 
                if (keyword == data.getParentImperativeOperation()) {
                    String variables = myScopedVariablesExtractor.extractVariables(tokens[tokens.length - 1], data);
                    String wrappedVars = variables;
                    if (QvtCompletionData.isKindOf(keyword, QVTOParsersym.TK_mapping)) {
                        wrappedVars = "init {\n" + variables + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$
                    }
                    return mappingText + " {\n " + wrappedVars + "\n}"; //$NON-NLS-1$ //$NON-NLS-2$
                }
                return mappingText + ';'; 
            }
        }
        return null;
    }
}