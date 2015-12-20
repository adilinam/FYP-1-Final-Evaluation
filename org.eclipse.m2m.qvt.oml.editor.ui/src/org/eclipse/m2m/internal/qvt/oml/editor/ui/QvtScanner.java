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
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QvtKeywords;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.IQVTColors;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager;

public class QvtScanner extends RuleBasedScanner {

	private static final String[] IGNORED_KWDS = new String[] {
			"String", //$NON-NLS-1$
			"Boolean", //$NON-NLS-1$
			"Integer", //$NON-NLS-1$
			"Real", //$NON-NLS-1$
			"OclVoid" //$NON-NLS-1$
	};
	
    public QvtScanner(QVTColorManager manager) {
        IToken keyWord = manager.getColor(IQVTColors.KEYWORD).createToken();
        IToken defaultToken = manager.getColor(IQVTColors.DEFAULT).createToken();

        List<IRule> rules = new ArrayList<IRule>();
        rules.add(new WhitespaceRule(new QvtWhitespaceDetector()));

        WordRule wordRule = new WordRule(new IWordDetector() {
            public boolean isWordPart(char character) {
                return Character.isJavaIdentifierPart(character);
            }

            public boolean isWordStart(char character) {
                return Character.isJavaIdentifierStart(character);
            }
        }, defaultToken); 
        
        addKeywords(wordRule, keyWord);
        rules.add(wordRule);
        
        setRules(rules.toArray(new IRule[rules.size()]));
    }

    private void addKeywords(WordRule wordRule, IToken keyWord) {
    	Set<String> ignored = new HashSet<String>(Arrays.asList(IGNORED_KWDS));
    	for (String keyword : QvtKeywords.KEYWORDS) {
    		if(!ignored.contains(keyword)) {
    			wordRule.addWord(keyword, keyWord);
    		}
		}
    }
}
