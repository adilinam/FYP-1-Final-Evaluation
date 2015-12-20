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

import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CFileData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 * Created on Nov 6, 2007
 */
public class ScriptHeaderHandler implements IKeywordHandler {
    public String handle(IToken keyword, IPrsStream prsStream, QvtCompletionData data, CFileData fileData) {
        if (keyword.getTokenIndex() == 0) {
            IToken[] headerTokens = QvtCompletionData.extractTokens(keyword, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS);
            if (headerTokens != null) {
                return LightweightParserUtil.getText(headerTokens);
            }
        }
        return null;
    }
}