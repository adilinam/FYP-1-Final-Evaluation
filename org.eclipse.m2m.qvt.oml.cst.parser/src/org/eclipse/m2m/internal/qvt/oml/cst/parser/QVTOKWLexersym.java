/**
* Essential OCL Keyword Lexer
* <copyright>
*
* Copyright (c) 2005, 2009 IBM Corporation and others.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   IBM - Initial API and implementation
*   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
*   E.D.Willink - Bug 285633, 292112
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (242153)
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - Introducing new LPG templates (299396) 
*
* </copyright>
*
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

public interface QVTOKWLexersym {
    public final static int
      Char_DollarSign = 41,
      Char_Percent = 42,
      Char__ = 43,
      Char_a = 7,
      Char_b = 21,
      Char_c = 10,
      Char_d = 11,
      Char_e = 1,
      Char_f = 15,
      Char_g = 17,
      Char_h = 18,
      Char_i = 4,
      Char_j = 25,
      Char_k = 26,
      Char_l = 5,
      Char_m = 14,
      Char_n = 3,
      Char_o = 8,
      Char_p = 13,
      Char_q = 27,
      Char_r = 6,
      Char_s = 9,
      Char_t = 2,
      Char_u = 12,
      Char_v = 19,
      Char_w = 23,
      Char_x = 24,
      Char_y = 16,
      Char_z = 44,
      Char_A = 29,
      Char_B = 30,
      Char_C = 31,
      Char_D = 32,
      Char_E = 33,
      Char_F = 45,
      Char_G = 46,
      Char_H = 47,
      Char_I = 20,
      Char_J = 48,
      Char_K = 49,
      Char_L = 34,
      Char_M = 50,
      Char_N = 35,
      Char_O = 22,
      Char_P = 51,
      Char_Q = 52,
      Char_R = 36,
      Char_S = 28,
      Char_T = 37,
      Char_U = 38,
      Char_V = 39,
      Char_W = 53,
      Char_X = 54,
      Char_Y = 55,
      Char_Z = 56,
      Char_EOF = 40;

    public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "e", //$NON-NLS-1$
                 "t", //$NON-NLS-1$
                 "n", //$NON-NLS-1$
                 "i", //$NON-NLS-1$
                 "l", //$NON-NLS-1$
                 "r", //$NON-NLS-1$
                 "a", //$NON-NLS-1$
                 "o", //$NON-NLS-1$
                 "s", //$NON-NLS-1$
                 "c", //$NON-NLS-1$
                 "d", //$NON-NLS-1$
                 "u", //$NON-NLS-1$
                 "p", //$NON-NLS-1$
                 "m", //$NON-NLS-1$
                 "f", //$NON-NLS-1$
                 "y", //$NON-NLS-1$
                 "g", //$NON-NLS-1$
                 "h", //$NON-NLS-1$
                 "v", //$NON-NLS-1$
                 "I", //$NON-NLS-1$
                 "b", //$NON-NLS-1$
                 "O", //$NON-NLS-1$
                 "w", //$NON-NLS-1$
                 "x", //$NON-NLS-1$
                 "j", //$NON-NLS-1$
                 "k", //$NON-NLS-1$
                 "q", //$NON-NLS-1$
                 "S", //$NON-NLS-1$
                 "A", //$NON-NLS-1$
                 "B", //$NON-NLS-1$
                 "C", //$NON-NLS-1$
                 "D", //$NON-NLS-1$
                 "E", //$NON-NLS-1$
                 "L", //$NON-NLS-1$
                 "N", //$NON-NLS-1$
                 "R", //$NON-NLS-1$
                 "T", //$NON-NLS-1$
                 "U", //$NON-NLS-1$
                 "V", //$NON-NLS-1$
                 "EOF", //$NON-NLS-1$
                 "DollarSign", //$NON-NLS-1$
                 "Percent", //$NON-NLS-1$
                 "_", //$NON-NLS-1$
                 "z", //$NON-NLS-1$
                 "F", //$NON-NLS-1$
                 "G", //$NON-NLS-1$
                 "H", //$NON-NLS-1$
                 "J", //$NON-NLS-1$
                 "K", //$NON-NLS-1$
                 "M", //$NON-NLS-1$
                 "P", //$NON-NLS-1$
                 "Q", //$NON-NLS-1$
                 "W", //$NON-NLS-1$
                 "X", //$NON-NLS-1$
                 "Y", //$NON-NLS-1$
                 "Z" //$NON-NLS-1$
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
