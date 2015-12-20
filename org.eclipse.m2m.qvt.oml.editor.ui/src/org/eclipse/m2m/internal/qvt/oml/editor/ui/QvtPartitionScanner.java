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

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;

public class QvtPartitionScanner extends RuleBasedPartitionScanner {
	
	/**
	 * Detector for empty comments.
	 */
	static class EmptyCommentDetector implements IWordDetector {

		/*
		 * @see IWordDetector#isWordStart
		 */
		public boolean isWordStart(char c) {
			return (c == '/');
		}

		/*
		 * @see IWordDetector#isWordPart
		 */
		public boolean isWordPart(char c) {
			return (c == '*' || c == '/');
		}
	}
        
	/**
	 * Word rule for empty comments.
	 */
	static class EmptyCommentRule extends WordRule implements IPredicateRule {

		private IToken fSuccessToken;
		/**
		 * Constructor for EmptyCommentRule.
		 * @param successToken
		 */
		public EmptyCommentRule(IToken successToken) {
			super(new EmptyCommentDetector());
			fSuccessToken= successToken;
			addWord("/**/", fSuccessToken); //$NON-NLS-1$
		}

		/*
		 * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
		 */
		public IToken evaluate(ICharacterScanner scanner, boolean resume) {
			return evaluate(scanner);
		}

		/*
		 * @see IPredicateRule#getSuccessToken()
		 */
		public IToken getSuccessToken() {
			return fSuccessToken;
		}
	}
	

	public final static String QVT_PARTITIONING = "__qvt_partitioning"; //$NON-NLS-1$
	
	public final static String QVT_DOCUMENTATION = "__qvt_documentation"; //$NON-NLS-1$	
    public final static String QVT_SL_COMMENT = "__qvt_sl_comment"; //$NON-NLS-1$
    public final static String QVT_ML_COMMENT = "__qvt_ml_comment"; //$NON-NLS-1$    
    public final static String QVT_STRING = "__qvt_string"; //$NON-NLS-1$
    
    private static final char ESCAPE_CHAR = '\\';

    public QvtPartitionScanner() {

    	IToken qvtDocumentation = new Token(QVT_DOCUMENTATION);
        IToken qvtSLComment = new Token(QVT_SL_COMMENT);
        IToken qvtMLComment = new Token(QVT_ML_COMMENT);        
        IToken qvtString = new Token(QVT_STRING);
        
        IPredicateRule[] rules = new IPredicateRule[] {
        	// Add special case word rule to differentiate from javadoc like comments
        	new EmptyCommentRule(qvtMLComment),
        		
        	new MultiLineRule("/**", "*/", qvtDocumentation), //$NON-NLS-1$ //$NON-NLS-2$        		
            new MultiLineRule("/*", "*/", qvtMLComment), //$NON-NLS-1$ //$NON-NLS-2$
            new EndOfLineRule("--", qvtSLComment), //$NON-NLS-1$
            new EndOfLineRule("//", qvtSLComment), //$NON-NLS-1$
            new MultiLineRule("'", "'", qvtString, ESCAPE_CHAR, true), //$NON-NLS-1$ //$NON-NLS-2$
            new MultiLineRule("\"", "\"", qvtString, ESCAPE_CHAR, true), //$NON-NLS-1$ //$NON-NLS-2$        	
        };
        setPredicateRules(rules);
    }    
}
