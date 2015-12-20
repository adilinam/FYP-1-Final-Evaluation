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

public interface QVTOLexersym {
    public final static int
      Char_CtlCharNotWS = 103,
      Char_LF = 93,
      Char_CR = 94,
      Char_HT = 76,
      Char_FF = 100,
      Char_a = 17,
      Char_b = 18,
      Char_c = 19,
      Char_d = 20,
      Char_e = 13,
      Char_f = 21,
      Char_g = 22,
      Char_h = 23,
      Char_i = 24,
      Char_j = 25,
      Char_k = 26,
      Char_l = 27,
      Char_m = 28,
      Char_n = 29,
      Char_o = 30,
      Char_p = 31,
      Char_q = 32,
      Char_r = 33,
      Char_s = 34,
      Char_t = 35,
      Char_u = 36,
      Char_v = 37,
      Char_w = 38,
      Char_x = 39,
      Char_y = 40,
      Char_z = 41,
      Char__ = 42,
      Char_A = 43,
      Char_B = 44,
      Char_C = 45,
      Char_D = 46,
      Char_E = 14,
      Char_F = 47,
      Char_G = 48,
      Char_H = 49,
      Char_I = 50,
      Char_J = 51,
      Char_K = 52,
      Char_L = 53,
      Char_M = 54,
      Char_N = 55,
      Char_O = 56,
      Char_P = 57,
      Char_Q = 58,
      Char_R = 59,
      Char_S = 60,
      Char_T = 61,
      Char_U = 62,
      Char_V = 63,
      Char_W = 64,
      Char_X = 65,
      Char_Y = 66,
      Char_Z = 67,
      Char_0 = 1,
      Char_1 = 2,
      Char_2 = 3,
      Char_3 = 4,
      Char_4 = 5,
      Char_5 = 6,
      Char_6 = 7,
      Char_7 = 8,
      Char_8 = 9,
      Char_9 = 10,
      Char_AfterASCIINotAcute = 68,
      Char_Space = 69,
      Char_DoubleQuote = 77,
      Char_SingleQuote = 70,
      Char_Percent = 95,
      Char_VerticalBar = 78,
      Char_Exclamation = 79,
      Char_AtSign = 80,
      Char_BackQuote = 81,
      Char_Acute = 102,
      Char_Tilde = 82,
      Char_Sharp = 96,
      Char_DollarSign = 83,
      Char_Ampersand = 97,
      Char_Caret = 98,
      Char_Colon = 71,
      Char_SemiColon = 84,
      Char_BackSlash = 99,
      Char_LeftBrace = 85,
      Char_RightBrace = 86,
      Char_LeftBracket = 87,
      Char_RightBracket = 88,
      Char_QuestionMark = 89,
      Char_Comma = 90,
      Char_Dot = 12,
      Char_LessThan = 72,
      Char_GreaterThan = 15,
      Char_Plus = 73,
      Char_Minus = 16,
      Char_Slash = 74,
      Char_Star = 75,
      Char_LeftParen = 91,
      Char_RightParen = 92,
      Char_Equal = 11,
      Char_EOF = 101;

    public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "0", //$NON-NLS-1$
                 "1", //$NON-NLS-1$
                 "2", //$NON-NLS-1$
                 "3", //$NON-NLS-1$
                 "4", //$NON-NLS-1$
                 "5", //$NON-NLS-1$
                 "6", //$NON-NLS-1$
                 "7", //$NON-NLS-1$
                 "8", //$NON-NLS-1$
                 "9", //$NON-NLS-1$
                 "Equal", //$NON-NLS-1$
                 "Dot", //$NON-NLS-1$
                 "e", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "GreaterThan", //$NON-NLS-1$
                 "Minus", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "i", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "n", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "r", //$NON-NLS-1$
                 "s", //$NON-NLS-1$
                 "t", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "z", //$NON-NLS-1$
                 "_", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "F", //$NON-NLS-1$
                 "G", //$NON-NLS-1$
                 "H", //$NON-NLS-1$
                 "I", //$NON-NLS-1$
                 "J", //$NON-NLS-1$
                 "K", //$NON-NLS-1$
                 "L", //$NON-NLS-1$
                 "M", //$NON-NLS-1$
                 "N", //$NON-NLS-1$
                 "O", //$NON-NLS-1$
                 "P", //$NON-NLS-1$
                 "Q", //$NON-NLS-1$
                 "R", //$NON-NLS-1$
                 "S", //$NON-NLS-1$
                 "T", //$NON-NLS-1$
                 "U", //$NON-NLS-1$
                 "V", //$NON-NLS-1$
                 "W", //$NON-NLS-1$
                 "X", //$NON-NLS-1$
                 "Y", //$NON-NLS-1$
                 "Z", //$NON-NLS-1$
                 "AfterASCIINotAcute", //$NON-NLS-1$
                 "Space", //$NON-NLS-1$
                 "SingleQuote", //$NON-NLS-1$
                 "Colon", //$NON-NLS-1$
                 "LessThan", //$NON-NLS-1$
                 "Plus", //$NON-NLS-1$
                 "Slash", //$NON-NLS-1$
                 "Star", //$NON-NLS-1$
                 "HT", //$NON-NLS-1$
                 "DoubleQuote", //$NON-NLS-1$
                 "VerticalBar", //$NON-NLS-1$
                 "Exclamation", //$NON-NLS-1$
                 "AtSign", //$NON-NLS-1$
                 "BackQuote", //$NON-NLS-1$
                 "Tilde", //$NON-NLS-1$
                 "DollarSign", //$NON-NLS-1$
                 "SemiColon", //$NON-NLS-1$
                 "LeftBrace", //$NON-NLS-1$
                 "RightBrace", //$NON-NLS-1$
                 "LeftBracket", //$NON-NLS-1$
                 "RightBracket", //$NON-NLS-1$
                 "QuestionMark", //$NON-NLS-1$
                 "Comma", //$NON-NLS-1$
                 "LeftParen", //$NON-NLS-1$
                 "RightParen", //$NON-NLS-1$
                 "LF", //$NON-NLS-1$
                 "CR", //$NON-NLS-1$
                 "Percent", //$NON-NLS-1$
                 "Sharp", //$NON-NLS-1$
                 "Ampersand", //$NON-NLS-1$
                 "Caret", //$NON-NLS-1$
                 "BackSlash", //$NON-NLS-1$
                 "FF", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "Acute", //$NON-NLS-1$
                 "CtlCharNotWS" //$NON-NLS-1$
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
