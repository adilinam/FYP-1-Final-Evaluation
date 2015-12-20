/**
* Essential OCL Lexer
* <copyright>
*
* Copyright (c) 2005, 2010 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   Borland - Bug 242880
*   E.D.Willink - Bug 292112, 295166
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396)
*
* </copyright>
*
* $Id: EssentialOCLLexer.gi,v 1.5 2010/02/11 15:40:41 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006-2008 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
*/
/**
* <copyright>
*
* Copyright (c) 2006-2008 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*
* </copyright>
*
*/

package org.eclipse.m2m.internal.qvt.oml.cst.parser;

import lpg.runtime.*;
import org.eclipse.ocl.lpg.AbstractLexer;

import java.io.Reader;

import org.eclipse.ocl.Environment;
import org.eclipse.ocl.lpg.BasicEnvironment;
import org.eclipse.ocl.lpg.DerivedPrsStream;
import org.eclipse.ocl.lpg.DerivedLexStream;
import org.eclipse.ocl.util.OCLUtil;

@SuppressWarnings("nls") //$NON-NLS-1$
public class QVTOLexer extends AbstractLexer implements RuleAction
{
    private QVTOLexerLpgLexStream lexStream;
    
    private static ParseTable prs = new QVTOLexerprs();
    @Override
    public ParseTable getParseTable() { return prs; }

    private LexParser lexParser = new LexParser();
    @Override
    public LexParser getParser() { return lexParser; }

    public int getToken(int i) { return lexParser.getToken(i); }
    public int getRhsFirstTokenIndex(int i) { return lexParser.getFirstToken(i); }
    public int getRhsLastTokenIndex(int i) { return lexParser.getLastToken(i); }

    public int getLeftSpan() { return lexParser.getToken(1); }
    public int getRightSpan() { return lexParser.getLastToken(); }

    @Override
    public void resetKeywordLexer()
    {
        if (kwLexer == null)
              this.kwLexer = new QVTOKWLexer(lexStream.getInputChars(), QVTOParsersym.TK_IDENTIFIER);
        else this.kwLexer.setInputChars(lexStream.getInputChars());
    }

    @Override
    public void reset(char[] input_chars, String filename)
    {
        reset(input_chars, filename, 1);
    }
    
    @Override
    public void reset(char[] input_chars, String filename, int tab)
    {
        lexStream = new QVTOLexerLpgLexStream(getOCLEnvironment(), input_chars, filename, tab);
        lexParser.reset(lexStream, prs, this);
        resetKeywordLexer();
    }

    
    public QVTOLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment) {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
        oclEnvironment = environment;
    }

	public QVTOLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] chars) {
		this(environment, chars, "OCL", ECLIPSE_TAB_VALUE); //$NON-NLS-1$
	}

    public QVTOLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename, int tab) {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
        oclEnvironment = environment;
        reset(input_chars, filename, tab);            
    }

	private final Environment<?,?,?,?,?,?,?,?,?,?,?,?> oclEnvironment;
    
	public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
    	return oclEnvironment;
    }

    @Override
    public DerivedLexStream getILexStream() { return lexStream; }

    /**
     * @deprecated replaced by {@link #getILexStream()}
     */
    @Deprecated
    @Override
    public ILexStream getLexStream() { return lexStream; }

    private void initializeLexer(DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        if (lexStream.getInputChars() == null)
            throw new NullPointerException("LexStream was not initialized"); //$NON-NLS-1$
        lexStream.setPrsStream(prsStream);
        prsStream.makeToken(start_offset, end_offset, 0); // Token list must start with a bad token
    }

    private void addEOF(DerivedPrsStream prsStream, int end_offset)
    {
        prsStream.makeToken(end_offset, end_offset, QVTOParsersym.TK_EOF_TOKEN); // and end with the end of file token
        prsStream.setStreamLength(prsStream.getSize());
    }

    @Override
    public void lexer(DerivedPrsStream prsStream)
    {
        lexer(null, prsStream);
    }
    
    @Override
    public void lexer(Monitor monitor, DerivedPrsStream prsStream)
    {
        initializeLexer(prsStream, 0, -1);
        lexParser.parseCharacters(monitor);  // Lex the input characters
        addEOF(prsStream, lexStream.getStreamIndex());
    }

    @Override
    public void lexer(DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        lexer(null, prsStream, start_offset, end_offset);
    }
    
    @Override
    public void lexer(Monitor monitor, DerivedPrsStream prsStream, int start_offset, int end_offset)
    {
        if (start_offset <= 1)
             initializeLexer(prsStream, 0, -1);
        else initializeLexer(prsStream, start_offset - 1, start_offset - 1);

        lexParser.parseCharacters(monitor, start_offset, end_offset);

        addEOF(prsStream, (end_offset >= lexStream.getStreamIndex() ? lexStream.getStreamIndex() : end_offset + 1));
    }

    /**
     * If a parse stream was not passed to this Lexical analyser then we
     * simply report a lexical error. Otherwise, we produce a bad token.
     */
    @Override
    public void reportLexicalError(int startLoc, int endLoc) {
        IPrsStream prs_stream = lexStream.getIPrsStream();
        if (prs_stream == null)
            lexStream.reportLexicalError(startLoc, endLoc);
        else {
            //
            // Remove any token that may have been processed that fall in the
            // range of the lexical error... then add one error token that spans
            // the error range.
            //
            for (int i = prs_stream.getSize() - 1; i > 0; i--) {
                if (prs_stream.getStartOffset(i) >= startLoc)
                     prs_stream.removeLastToken();
                else break;
            }
            prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to the prsStream
        }        
    }

    //
    // The Lexer contains an array of characters as the input stream to be parsed.
    // There are methods to retrieve and classify characters.
    // The lexparser "token" is implemented simply as the index of the next character in the array. //$NON-NLS-1$
    // The Lexer extends the abstract class LpgLexStream with an implementation of the abstract
    // method getKind.  The template defines the Lexer class and the lexer() method.
    // A driver creates the action class, "Lexer", passing an Option object to the constructor. //$NON-NLS-1$
    //
    QVTOKWLexer kwLexer;
    boolean printTokens;
    private final static int ECLIPSE_TAB_VALUE = 4;

    @Override
    public int [] getKeywordKinds() { return kwLexer.getKeywordKinds(); }


    /**
     * @deprecated function replaced by {@link #reset(char [] content, String filename)}
     */
    @Deprecated
    public void initialize(char [] content, String filename)
    {
        reset(content, filename);
    }
    
    final void makeToken(int left_token, int right_token, int kind)
    {
        lexStream.makeToken(left_token, right_token, kind);
    }
    
    final void makeToken(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.makeToken(startOffset, endOffset, kind);
        if (printTokens) printValue(startOffset, endOffset);
    }

    final void makeComment(int kind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan();
        lexStream.getIPrsStream().makeAdjunct(startOffset, endOffset, kind);
    }

    final void skipToken()
    {
        if (printTokens) printValue(getLeftSpan(), getRightSpan());
    }
    
    final void checkForKeyWord()
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    //
    // This flavor of checkForKeyWord is necessary when the default kind
    // (which is returned when the keyword filter doesn't match) is something
    // other than _IDENTIFIER.
    //
    final void checkForKeyWord(int defaultKind)
    {
        int startOffset = getLeftSpan(),
            endOffset = getRightSpan(),
            kwKind = kwLexer.lexer(startOffset, endOffset);
        if (kwKind == QVTOParsersym.TK_IDENTIFIER)
            kwKind = defaultKind;
        lexStream.makeToken(startOffset, endOffset, kwKind);
        if (printTokens) printValue(startOffset, endOffset);
    }
    
    final void printValue(int startOffset, int endOffset)
    {
        String s = new String(lexStream.getInputChars(), startOffset, endOffset - startOffset + 1);
        System.out.print(s);
    }

    //
    //
    //
    static class QVTOLexerLpgLexStream extends DerivedLexStream
    {
    public final static int tokenKind[] =
    {
        QVTOLexersym.Char_CtlCharNotWS,    // 000    0x00
        QVTOLexersym.Char_CtlCharNotWS,    // 001    0x01
        QVTOLexersym.Char_CtlCharNotWS,    // 002    0x02
        QVTOLexersym.Char_CtlCharNotWS,    // 003    0x03
        QVTOLexersym.Char_CtlCharNotWS,    // 004    0x04
        QVTOLexersym.Char_CtlCharNotWS,    // 005    0x05
        QVTOLexersym.Char_CtlCharNotWS,    // 006    0x06
        QVTOLexersym.Char_CtlCharNotWS,    // 007    0x07
        QVTOLexersym.Char_CtlCharNotWS,    // 008    0x08
        QVTOLexersym.Char_HT,              // 009    0x09
        QVTOLexersym.Char_LF,              // 010    0x0A
        QVTOLexersym.Char_CtlCharNotWS,    // 011    0x0B
        QVTOLexersym.Char_FF,              // 012    0x0C
        QVTOLexersym.Char_CR,              // 013    0x0D
        QVTOLexersym.Char_CtlCharNotWS,    // 014    0x0E
        QVTOLexersym.Char_CtlCharNotWS,    // 015    0x0F
        QVTOLexersym.Char_CtlCharNotWS,    // 016    0x10
        QVTOLexersym.Char_CtlCharNotWS,    // 017    0x11
        QVTOLexersym.Char_CtlCharNotWS,    // 018    0x12
        QVTOLexersym.Char_CtlCharNotWS,    // 019    0x13
        QVTOLexersym.Char_CtlCharNotWS,    // 020    0x14
        QVTOLexersym.Char_CtlCharNotWS,    // 021    0x15
        QVTOLexersym.Char_CtlCharNotWS,    // 022    0x16
        QVTOLexersym.Char_CtlCharNotWS,    // 023    0x17
        QVTOLexersym.Char_CtlCharNotWS,    // 024    0x18
        QVTOLexersym.Char_CtlCharNotWS,    // 025    0x19
        QVTOLexersym.Char_CtlCharNotWS,    // 026    0x1A
        QVTOLexersym.Char_CtlCharNotWS,    // 027    0x1B
        QVTOLexersym.Char_CtlCharNotWS,    // 028    0x1C
        QVTOLexersym.Char_CtlCharNotWS,    // 029    0x1D
        QVTOLexersym.Char_CtlCharNotWS,    // 030    0x1E
        QVTOLexersym.Char_CtlCharNotWS,    // 031    0x1F
        QVTOLexersym.Char_Space,           // 032    0x20
        QVTOLexersym.Char_Exclamation,     // 033    0x21
        QVTOLexersym.Char_DoubleQuote,     // 034    0x22
        QVTOLexersym.Char_Sharp,           // 035    0x23
        QVTOLexersym.Char_DollarSign,      // 036    0x24
        QVTOLexersym.Char_Percent,         // 037    0x25
        QVTOLexersym.Char_Ampersand,       // 038    0x26
        QVTOLexersym.Char_SingleQuote,     // 039    0x27
        QVTOLexersym.Char_LeftParen,       // 040    0x28
        QVTOLexersym.Char_RightParen,      // 041    0x29
        QVTOLexersym.Char_Star,            // 042    0x2A
        QVTOLexersym.Char_Plus,            // 043    0x2B
        QVTOLexersym.Char_Comma,           // 044    0x2C
        QVTOLexersym.Char_Minus,           // 045    0x2D
        QVTOLexersym.Char_Dot,             // 046    0x2E
        QVTOLexersym.Char_Slash,           // 047    0x2F
        QVTOLexersym.Char_0,               // 048    0x30
        QVTOLexersym.Char_1,               // 049    0x31
        QVTOLexersym.Char_2,               // 050    0x32
        QVTOLexersym.Char_3,               // 051    0x33
        QVTOLexersym.Char_4,               // 052    0x34
        QVTOLexersym.Char_5,               // 053    0x35
        QVTOLexersym.Char_6,               // 054    0x36
        QVTOLexersym.Char_7,               // 055    0x37
        QVTOLexersym.Char_8,               // 056    0x38
        QVTOLexersym.Char_9,               // 057    0x39
        QVTOLexersym.Char_Colon,           // 058    0x3A
        QVTOLexersym.Char_SemiColon,       // 059    0x3B
        QVTOLexersym.Char_LessThan,        // 060    0x3C
        QVTOLexersym.Char_Equal,           // 061    0x3D
        QVTOLexersym.Char_GreaterThan,     // 062    0x3E
        QVTOLexersym.Char_QuestionMark,    // 063    0x3F
        QVTOLexersym.Char_AtSign,          // 064    0x40
        QVTOLexersym.Char_A,               // 065    0x41
        QVTOLexersym.Char_B,               // 066    0x42
        QVTOLexersym.Char_C,               // 067    0x43
        QVTOLexersym.Char_D,               // 068    0x44
        QVTOLexersym.Char_E,               // 069    0x45
        QVTOLexersym.Char_F,               // 070    0x46
        QVTOLexersym.Char_G,               // 071    0x47
        QVTOLexersym.Char_H,               // 072    0x48
        QVTOLexersym.Char_I,               // 073    0x49
        QVTOLexersym.Char_J,               // 074    0x4A
        QVTOLexersym.Char_K,               // 075    0x4B
        QVTOLexersym.Char_L,               // 076    0x4C
        QVTOLexersym.Char_M,               // 077    0x4D
        QVTOLexersym.Char_N,               // 078    0x4E
        QVTOLexersym.Char_O,               // 079    0x4F
        QVTOLexersym.Char_P,               // 080    0x50
        QVTOLexersym.Char_Q,               // 081    0x51
        QVTOLexersym.Char_R,               // 082    0x52
        QVTOLexersym.Char_S,               // 083    0x53
        QVTOLexersym.Char_T,               // 084    0x54
        QVTOLexersym.Char_U,               // 085    0x55
        QVTOLexersym.Char_V,               // 086    0x56
        QVTOLexersym.Char_W,               // 087    0x57
        QVTOLexersym.Char_X,               // 088    0x58
        QVTOLexersym.Char_Y,               // 089    0x59
        QVTOLexersym.Char_Z,               // 090    0x5A
        QVTOLexersym.Char_LeftBracket,     // 091    0x5B
        QVTOLexersym.Char_BackSlash,       // 092    0x5C
        QVTOLexersym.Char_RightBracket,    // 093    0x5D
        QVTOLexersym.Char_Caret,           // 094    0x5E
        QVTOLexersym.Char__,               // 095    0x5F
        QVTOLexersym.Char_BackQuote,       // 096    0x60
        QVTOLexersym.Char_a,               // 097    0x61
        QVTOLexersym.Char_b,               // 098    0x62
        QVTOLexersym.Char_c,               // 099    0x63
        QVTOLexersym.Char_d,               // 100    0x64
        QVTOLexersym.Char_e,               // 101    0x65
        QVTOLexersym.Char_f,               // 102    0x66
        QVTOLexersym.Char_g,               // 103    0x67
        QVTOLexersym.Char_h,               // 104    0x68
        QVTOLexersym.Char_i,               // 105    0x69
        QVTOLexersym.Char_j,               // 106    0x6A
        QVTOLexersym.Char_k,               // 107    0x6B
        QVTOLexersym.Char_l,               // 108    0x6C
        QVTOLexersym.Char_m,               // 109    0x6D
        QVTOLexersym.Char_n,               // 110    0x6E
        QVTOLexersym.Char_o,               // 111    0x6F
        QVTOLexersym.Char_p,               // 112    0x70
        QVTOLexersym.Char_q,               // 113    0x71
        QVTOLexersym.Char_r,               // 114    0x72
        QVTOLexersym.Char_s,               // 115    0x73
        QVTOLexersym.Char_t,               // 116    0x74
        QVTOLexersym.Char_u,               // 117    0x75
        QVTOLexersym.Char_v,               // 118    0x76
        QVTOLexersym.Char_w,               // 119    0x77
        QVTOLexersym.Char_x,               // 120    0x78
        QVTOLexersym.Char_y,               // 121    0x79
        QVTOLexersym.Char_z,               // 122    0x7A
        QVTOLexersym.Char_LeftBrace,       // 123    0x7B
        QVTOLexersym.Char_VerticalBar,     // 124    0x7C
        QVTOLexersym.Char_RightBrace,      // 125    0x7D
        QVTOLexersym.Char_Tilde,           // 126    0x7E
        QVTOLexersym.Char_CtlCharNotWS,    // 127    0x7F

        QVTOLexersym.Char_Acute,           // for the acute accent 0xb4
        QVTOLexersym.Char_AfterASCIINotAcute,      // for all chars in range 0x80..0xfffe excluding the acute accent
        QVTOLexersym.Char_EOF              // for '\uffff' or 65535 
    };
            
    @Override
    public final int getKind(int i)  // Classify character at ith location
    {
        char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
        return (c < 128) // ASCII Character
                  ? tokenKind[c] 
                  : (c == '\uffff')
                      ?QVTOLexersym.Char_EOF
                      : (c == '\u00b4')
                            ? QVTOLexersym.Char_EOF
                            : QVTOLexersym.Char_AfterASCIINotAcute;
    }

    @Override
    public String[] orderedExportedSymbols() { return QVTOParsersym.orderedTerminalSymbols; }

    public QVTOLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, String filename, int tab) throws java.io.IOException
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), filename, tab);
    }

    public QVTOLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename, int tab)
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), input_chars, filename, tab);
    }

    public QVTOLexerLpgLexStream(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, char[] input_chars, String filename)
    {
        super(OCLUtil.getAdapter(environment, BasicEnvironment.class), input_chars, filename, 1);
    }
    }

    
// Some OCL additions to make lexer work with an input reader
/**
 * @since 3.0
 */
public QVTOLexer(Environment<?,?,?,?,?,?,?,?,?,?,?,?> environment, Reader reader, String filename) throws java.io.IOException {
	super(OCLUtil.getAdapter(environment, BasicEnvironment.class));
	oclEnvironment = environment;
	reset(reader, filename);
}

// OCL addition to reset the lexer stream from an input reader
/**
 * @since 3.0
 */
@Override
public void reset(Reader reader, String filename) throws java.io.IOException {
	char[] input_chars = getInputChars(reader);
    reset(input_chars, filename, ECLIPSE_TAB_VALUE);
}

    public void ruleAction(int ruleNumber)
    {
        switch(ruleNumber)
        {

            //
            // Rule 1:  Token ::= Identifier
            //
            case 1: { 
				checkForKeyWord();
	              break;
            }
	
            //
            // Rule 2:  Token ::= _ SingleQuote SLNotSQOpt SingleQuote
            //
            case 2: { 
				makeToken(QVTOParsersym.TK_QUOTED_IDENTIFIER);
	              break;
            }
	
            //
            // Rule 3:  Token ::= SingleQuote SLNotSQOpt SingleQuote
            //
            case 3: { 
				makeToken(QVTOParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 4:  Token ::= Acute SLNotSQOpt Acute
            //
            case 4: { 
				makeToken(QVTOParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 5:  Token ::= BackQuote SLNotSQOpt Acute
            //
            case 5: { 
				makeToken(QVTOParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 6:  Token ::= IntegerLiteral
            //
            case 6:
                break; 
	
            //
            // Rule 7:  Token ::= IntegerLiteral DotToken
            //
            case 7:
                break; 
	
            //
            // Rule 8:  Token ::= IntegerLiteral DotDotToken
            //
            case 8:
                break; 
	
            //
            // Rule 9:  Token ::= RealLiteral
            //
            case 9: { 
				makeToken(QVTOParsersym.TK_REAL_LITERAL);
	              break;
            }
	
            //
            // Rule 10:  Token ::= SLC
            //
            case 10: { 
				makeComment(QVTOParsersym.TK_SINGLE_LINE_COMMENT);
	              break;
            }
	
            //
            // Rule 11:  Token ::= / * Inside Stars /
            //
            case 11: { 
                makeComment(QVTOParsersym.TK_MULTI_LINE_COMMENT);
                  break;
            }
    
            //
            // Rule 12:  Token ::= WS
            //
            case 12: { 
				skipToken();
	              break;
            }
	
            //
            // Rule 13:  Token ::= +
            //
            case 13: { 
				makeToken(QVTOParsersym.TK_PLUS);
	              break;
            }
	
            //
            // Rule 14:  Token ::= -
            //
            case 14: { 
				makeToken(QVTOParsersym.TK_MINUS);
	              break;
            }
	
            //
            // Rule 15:  Token ::= *
            //
            case 15: { 
				makeToken(QVTOParsersym.TK_MULTIPLY);
	              break;
            }
	
            //
            // Rule 16:  Token ::= /
            //
            case 16: { 
				makeToken(QVTOParsersym.TK_DIVIDE);
	              break;
            }
	
            //
            // Rule 17:  Token ::= (
            //
            case 17: { 
				makeToken(QVTOParsersym.TK_LPAREN);
	              break;
            }
	
            //
            // Rule 18:  Token ::= )
            //
            case 18: { 
				makeToken(QVTOParsersym.TK_RPAREN);
	              break;
            }
	
            //
            // Rule 19:  Token ::= >
            //
            case 19: { 
				makeToken(QVTOParsersym.TK_GREATER);
	              break;
            }
	
            //
            // Rule 20:  Token ::= <
            //
            case 20: { 
				makeToken(QVTOParsersym.TK_LESS);
	              break;
            }
	
            //
            // Rule 21:  Token ::= =
            //
            case 21: { 
				makeToken(QVTOParsersym.TK_EQUAL);
	              break;
            }
	
            //
            // Rule 22:  Token ::= > =
            //
            case 22: { 
				makeToken(QVTOParsersym.TK_GREATER_EQUAL);
	              break;
            }
	
            //
            // Rule 23:  Token ::= < =
            //
            case 23: { 
				makeToken(QVTOParsersym.TK_LESS_EQUAL);
	              break;
            }
	
            //
            // Rule 24:  Token ::= < >
            //
            case 24: { 
				makeToken(QVTOParsersym.TK_NOT_EQUAL);
	              break;
            }
	
            //
            // Rule 25:  Token ::= [
            //
            case 25: { 
				makeToken(QVTOParsersym.TK_LBRACKET);
	              break;
            }
	
            //
            // Rule 26:  Token ::= ]
            //
            case 26: { 
				makeToken(QVTOParsersym.TK_RBRACKET);
	              break;
            }
	
            //
            // Rule 27:  Token ::= {
            //
            case 27: { 
				makeToken(QVTOParsersym.TK_LBRACE);
	              break;
            }
	
            //
            // Rule 28:  Token ::= }
            //
            case 28: { 
				makeToken(QVTOParsersym.TK_RBRACE);
	              break;
            }
	
            //
            // Rule 29:  Token ::= - >
            //
            case 29: { 
				makeToken(QVTOParsersym.TK_ARROW);
	              break;
            }
	
            //
            // Rule 30:  Token ::= |
            //
            case 30: { 
				makeToken(QVTOParsersym.TK_BAR);
	              break;
            }
	
            //
            // Rule 31:  Token ::= ,
            //
            case 31: { 
				makeToken(QVTOParsersym.TK_COMMA);
	              break;
            }
	
            //
            // Rule 32:  Token ::= :
            //
            case 32: { 
				makeToken(QVTOParsersym.TK_COLON);
	              break;
            }
	
            //
            // Rule 33:  Token ::= : :
            //
            case 33: { 
				makeToken(QVTOParsersym.TK_COLONCOLON);
	              break;
            }
	
            //
            // Rule 34:  Token ::= ;
            //
            case 34: { 
				makeToken(QVTOParsersym.TK_SEMICOLON);
	              break;
            }
	
            //
            // Rule 35:  Token ::= DotToken
            //
            case 35:
                break; 
	
            //
            // Rule 36:  DotToken ::= .
            //
            case 36: { 
				makeToken(QVTOParsersym.TK_DOT);
	              break;
            }
	
            //
            // Rule 37:  Token ::= DotDotToken
            //
            case 37:
                break; 
	
            //
            // Rule 38:  DotDotToken ::= . .
            //
            case 38: { 
				makeToken(QVTOParsersym.TK_DOTDOT);
	              break;
            }
	
            //
            // Rule 39:  IntegerLiteral ::= Integer
            //
            case 39: { 
				makeToken(QVTOParsersym.TK_INTEGER_LITERAL);
	              break;
            }
	
            //
            // Rule 264:  Token ::= : =
            //
            case 264: { 
				makeToken(QVTOParsersym.TK_RESET_ASSIGN);
	              break;
            }
	
            //
            // Rule 265:  Token ::= + =
            //
            case 265: { 
				makeToken(QVTOParsersym.TK_ADD_ASSIGN);
	              break;
            }
	
            //
            // Rule 266:  Token ::= !
            //
            case 266: { 
				makeToken(QVTOParsersym.TK_EXCLAMATION_MARK);
	              break;
            }
	
            //
            // Rule 267:  Token ::= : : =
            //
            case 267: { 
				makeToken(QVTOParsersym.TK_COLONCOLONEQUAL);
	              break;
            }
	
            //
            // Rule 268:  Token ::= ?
            //
            case 268: { 
				makeToken(QVTOParsersym.TK_QUESTIONMARK);
	              break;
            }
	
            //
            // Rule 275:  Token ::= DoubleQuote SLNotDQOpt DoubleQuote
            //
            case 275: { 
				makeToken(QVTOParsersym.TK_STRING_LITERAL);
	              break;
            }
	
            //
            // Rule 279:  Token ::= < <
            //
            case 279: { 
				makeToken(QVTOParsersym.TK_STEREOTYPE_QUALIFIER_OPEN);
	              break;
            }
	
            //
            // Rule 280:  Token ::= > >
            //
            case 280: { 
				makeToken(QVTOParsersym.TK_STEREOTYPE_QUALIFIER_CLOSE);
	              break;
            }
	
            //
            // Rule 281:  Token ::= . . .
            //
            case 281: { 
				makeToken(QVTOParsersym.TK_MULTIPLICITY_RANGE);
	              break;
            }
	
            //
            // Rule 282:  Token ::= ~
            //
            case 282: { 
				makeToken(QVTOParsersym.TK_TILDE_SIGN);
	              break;
            }
	
            //
            // Rule 283:  Token ::= ! =
            //
            case 283: { 
				makeToken(QVTOParsersym.TK_NOT_EQUAL_EXEQ);
	              break;
            }
	
            //
            // Rule 284:  Token ::= @
            //
            case 284: { 
				makeToken(QVTOParsersym.TK_AT_SIGN);
	              break;
            }
	
    
            default:
                break;
        }
        return;
    }
}

