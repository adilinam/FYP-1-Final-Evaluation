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



public class QVTOKWLexer extends QVTOKWLexerprs
{
    private char[] inputChars;
    private final int keywordKind[] = new int[121 + 1];

    public int[] getKeywordKinds() { return keywordKind; }

    public int lexer(int curtok, int lasttok)
    {
        int current_kind = getKind(inputChars[curtok]),
            act;

        for (act = tAction(START_STATE, current_kind);
             act > NUM_RULES && act < ACCEPT_ACTION;
             act = tAction(act, current_kind))
        {
            curtok++;
            current_kind = (curtok > lasttok
                                   ? Char_EOF
                                   : getKind(inputChars[curtok]));
        }

        if (act > ERROR_ACTION)
        {
            curtok++;
            act -= ERROR_ACTION;
        }

        return keywordKind[act == ERROR_ACTION  || curtok <= lasttok ? 0 : act];
    }

    public void setInputChars(char[] inputChars) { this.inputChars = inputChars; }


    final static int tokenKind[] = new int[128];
    static
    {
        tokenKind['$'] = QVTOKWLexersym.Char_DollarSign;
        tokenKind['%'] = QVTOKWLexersym.Char_Percent;
        tokenKind['_'] = QVTOKWLexersym.Char__;

        tokenKind['a'] = QVTOKWLexersym.Char_a;
        tokenKind['b'] = QVTOKWLexersym.Char_b;
        tokenKind['c'] = QVTOKWLexersym.Char_c;
        tokenKind['d'] = QVTOKWLexersym.Char_d;
        tokenKind['e'] = QVTOKWLexersym.Char_e;
        tokenKind['f'] = QVTOKWLexersym.Char_f;
        tokenKind['g'] = QVTOKWLexersym.Char_g;
        tokenKind['h'] = QVTOKWLexersym.Char_h;
        tokenKind['i'] = QVTOKWLexersym.Char_i;
        tokenKind['j'] = QVTOKWLexersym.Char_j;
        tokenKind['k'] = QVTOKWLexersym.Char_k;
        tokenKind['l'] = QVTOKWLexersym.Char_l;
        tokenKind['m'] = QVTOKWLexersym.Char_m;
        tokenKind['n'] = QVTOKWLexersym.Char_n;
        tokenKind['o'] = QVTOKWLexersym.Char_o;
        tokenKind['p'] = QVTOKWLexersym.Char_p;
        tokenKind['q'] = QVTOKWLexersym.Char_q;
        tokenKind['r'] = QVTOKWLexersym.Char_r;
        tokenKind['s'] = QVTOKWLexersym.Char_s;
        tokenKind['t'] = QVTOKWLexersym.Char_t;
        tokenKind['u'] = QVTOKWLexersym.Char_u;
        tokenKind['v'] = QVTOKWLexersym.Char_v;
        tokenKind['w'] = QVTOKWLexersym.Char_w;
        tokenKind['x'] = QVTOKWLexersym.Char_x;
        tokenKind['y'] = QVTOKWLexersym.Char_y;
        tokenKind['z'] = QVTOKWLexersym.Char_z;

        tokenKind['A'] = QVTOKWLexersym.Char_A;
        tokenKind['B'] = QVTOKWLexersym.Char_B;
        tokenKind['C'] = QVTOKWLexersym.Char_C;
        tokenKind['D'] = QVTOKWLexersym.Char_D;
        tokenKind['E'] = QVTOKWLexersym.Char_E;
        tokenKind['F'] = QVTOKWLexersym.Char_F;
        tokenKind['G'] = QVTOKWLexersym.Char_G;
        tokenKind['H'] = QVTOKWLexersym.Char_H;
        tokenKind['I'] = QVTOKWLexersym.Char_I;
        tokenKind['J'] = QVTOKWLexersym.Char_J;
        tokenKind['K'] = QVTOKWLexersym.Char_K;
        tokenKind['L'] = QVTOKWLexersym.Char_L;
        tokenKind['M'] = QVTOKWLexersym.Char_M;
        tokenKind['N'] = QVTOKWLexersym.Char_N;
        tokenKind['O'] = QVTOKWLexersym.Char_O;
        tokenKind['P'] = QVTOKWLexersym.Char_P;
        tokenKind['Q'] = QVTOKWLexersym.Char_Q;
        tokenKind['R'] = QVTOKWLexersym.Char_R;
        tokenKind['S'] = QVTOKWLexersym.Char_S;
        tokenKind['T'] = QVTOKWLexersym.Char_T;
        tokenKind['U'] = QVTOKWLexersym.Char_U;
        tokenKind['V'] = QVTOKWLexersym.Char_V;
        tokenKind['W'] = QVTOKWLexersym.Char_W;
        tokenKind['X'] = QVTOKWLexersym.Char_X;
        tokenKind['Y'] = QVTOKWLexersym.Char_Y;
        tokenKind['Z'] = QVTOKWLexersym.Char_Z;
    };

    final int getKind(char c)
    {
        return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */ ? tokenKind[c] : 0);
    }


    public QVTOKWLexer(char[] inputChars, int identifierKind)
    {
        this.inputChars = inputChars;
        keywordKind[0] = identifierKind;

        //
        // Rule 1:  KeyWord ::= s e l f
        //
        
		keywordKind[1] = (QVTOParsersym.TK_self);
	  
	
        //
        // Rule 2:  KeyWord ::= i f
        //
        
		keywordKind[2] = (QVTOParsersym.TK_if);
	  
	
        //
        // Rule 3:  KeyWord ::= t h e n
        //
        
		keywordKind[3] = (QVTOParsersym.TK_then);
	  
	
        //
        // Rule 4:  KeyWord ::= e l s e
        //
        
		keywordKind[4] = (QVTOParsersym.TK_else);
	  
	
        //
        // Rule 5:  KeyWord ::= e n d i f
        //
        
		keywordKind[5] = (QVTOParsersym.TK_endif);
	  
	
        //
        // Rule 6:  KeyWord ::= a n d
        //
        
		keywordKind[6] = (QVTOParsersym.TK_and);
	  
	
        //
        // Rule 7:  KeyWord ::= o r
        //
        
		keywordKind[7] = (QVTOParsersym.TK_or);
	  
	
        //
        // Rule 8:  KeyWord ::= x o r
        //
        
		keywordKind[8] = (QVTOParsersym.TK_xor);
	  
	
        //
        // Rule 9:  KeyWord ::= n o t
        //
        
		keywordKind[9] = (QVTOParsersym.TK_not);
	  
	
        //
        // Rule 10:  KeyWord ::= i m p l i e s
        //
        
		keywordKind[10] = (QVTOParsersym.TK_implies);
	  
	
        //
        // Rule 11:  KeyWord ::= l e t
        //
        
		keywordKind[11] = (QVTOParsersym.TK_let);
	  
	
        //
        // Rule 12:  KeyWord ::= i n
        //
        
		keywordKind[12] = (QVTOParsersym.TK_in);
	  
	
        //
        // Rule 13:  KeyWord ::= t r u e
        //
        
		keywordKind[13] = (QVTOParsersym.TK_true);
	  
	
        //
        // Rule 14:  KeyWord ::= f a l s e
        //
        
		keywordKind[14] = (QVTOParsersym.TK_false);
	  
	
        //
        // Rule 15:  KeyWord ::= S e t
        //
        
		keywordKind[15] = (QVTOParsersym.TK_Set);
	  
	
        //
        // Rule 16:  KeyWord ::= B a g
        //
        
		keywordKind[16] = (QVTOParsersym.TK_Bag);
	  
	
        //
        // Rule 17:  KeyWord ::= S e q u e n c e
        //
        
		keywordKind[17] = (QVTOParsersym.TK_Sequence);
	  
	
        //
        // Rule 18:  KeyWord ::= C o l l e c t i o n
        //
        
		keywordKind[18] = (QVTOParsersym.TK_Collection);
	  
	
        //
        // Rule 19:  KeyWord ::= O r d e r e d S e t
        //
        
		keywordKind[19] = (QVTOParsersym.TK_OrderedSet);
	  
	
        //
        // Rule 20:  KeyWord ::= S t r i n g
        //
        
		keywordKind[20] = (QVTOParsersym.TK_String);
	  
	
        //
        // Rule 21:  KeyWord ::= I n t e g e r
        //
        
		keywordKind[21] = (QVTOParsersym.TK_Integer);
	  
	
        //
        // Rule 22:  KeyWord ::= U n l i m i t e d N a t u r a l
        //
        
		keywordKind[22] = (QVTOParsersym.TK_UnlimitedNatural);
	  
	
        //
        // Rule 23:  KeyWord ::= R e a l
        //
        
		keywordKind[23] = (QVTOParsersym.TK_Real);
	  
	
        //
        // Rule 24:  KeyWord ::= B o o l e a n
        //
        
		keywordKind[24] = (QVTOParsersym.TK_Boolean);
	  
	
        //
        // Rule 25:  KeyWord ::= T u p l e
        //
        
		keywordKind[25] = (QVTOParsersym.TK_Tuple);
	  
	
        //
        // Rule 26:  KeyWord ::= O c l A n y
        //
        
		keywordKind[26] = (QVTOParsersym.TK_OclAny);
	  
	
        //
        // Rule 27:  KeyWord ::= O c l V o i d
        //
        
		keywordKind[27] = (QVTOParsersym.TK_OclVoid);
	  
	
        //
        // Rule 28:  KeyWord ::= O c l I n v a l i d
        //
        
		keywordKind[28] = (QVTOParsersym.TK_OclInvalid);
	  
	
        //
        // Rule 29:  KeyWord ::= n u l l
        //
        
		keywordKind[29] = (QVTOParsersym.TK_null);
	  
	
        //
        // Rule 30:  KeyWord ::= i n v a l i d
        //
        
		keywordKind[30] = (QVTOParsersym.TK_invalid);
	  
	
        //
        // Rule 32:  ImperativeOCLKeyWord ::= D i c t
        //
        
		keywordKind[32] = (QVTOParsersym.TK_Dict);
	  
	
        //
        // Rule 33:  ImperativeOCLKeyWord ::= L i s t
        //
        
		keywordKind[33] = (QVTOParsersym.TK_List);
	  
	
        //
        // Rule 34:  ImperativeOCLKeyWord ::= b r e a k
        //
        
		keywordKind[34] = (QVTOParsersym.TK_break);
	  
	
        //
        // Rule 35:  ImperativeOCLKeyWord ::= s w i t c h
        //
        
		keywordKind[35] = (QVTOParsersym.TK_switch);
	  
	
        //
        // Rule 36:  ImperativeOCLKeyWord ::= c a s e
        //
        
		keywordKind[36] = (QVTOParsersym.TK_case);
	  
	
        //
        // Rule 37:  ImperativeOCLKeyWord ::= x s e l e c t
        //
        
		keywordKind[37] = (QVTOParsersym.TK_xselect);
	  
	
        //
        // Rule 38:  ImperativeOCLKeyWord ::= x c o l l e c t
        //
        
		keywordKind[38] = (QVTOParsersym.TK_xcollect);
	  
	
        //
        // Rule 39:  ImperativeOCLKeyWord ::= s e l e c t O n e
        //
        
		keywordKind[39] = (QVTOParsersym.TK_selectOne);
	  
	
        //
        // Rule 40:  ImperativeOCLKeyWord ::= c o l l e c t O n e
        //
        
		keywordKind[40] = (QVTOParsersym.TK_collectOne);
	  
	
        //
        // Rule 41:  ImperativeOCLKeyWord ::= c o l l e c t s e l e c t
        //
        
		keywordKind[41] = (QVTOParsersym.TK_collectselect);
	  
	
        //
        // Rule 42:  ImperativeOCLKeyWord ::= c o l l e c t s e l e c t O n e
        //
        
		keywordKind[42] = (QVTOParsersym.TK_collectselectOne);
	  
	
        //
        // Rule 43:  ImperativeOCLKeyWord ::= f o r E a c h
        //
        
		keywordKind[43] = (QVTOParsersym.TK_forEach);
	  
	
        //
        // Rule 44:  ImperativeOCLKeyWord ::= f o r O n e
        //
        
		keywordKind[44] = (QVTOParsersym.TK_forOne);
	  
	
        //
        // Rule 45:  ImperativeOCLKeyWord ::= c o m p u t e
        //
        
		keywordKind[45] = (QVTOParsersym.TK_compute);
	  
	
        //
        // Rule 46:  ImperativeOCLKeyWord ::= r e t u r n
        //
        
		keywordKind[46] = (QVTOParsersym.TK_return);
	  
	
        //
        // Rule 47:  ImperativeOCLKeyWord ::= v a r
        //
        
		keywordKind[47] = (QVTOParsersym.TK_var);
	  
	
        //
        // Rule 48:  ImperativeOCLKeyWord ::= w h i l e
        //
        
		keywordKind[48] = (QVTOParsersym.TK_while);
	  
	
        //
        // Rule 49:  ImperativeOCLKeyWord ::= c o n t i n u e
        //
        
		keywordKind[49] = (QVTOParsersym.TK_continue);
	  
	
        //
        // Rule 50:  ImperativeOCLKeyWord ::= l o g
        //
        
		keywordKind[50] = (QVTOParsersym.TK_log);
	  
	
        //
        // Rule 51:  ImperativeOCLKeyWord ::= a s s e r t
        //
        
		keywordKind[51] = (QVTOParsersym.TK_assert);
	  
	
        //
        // Rule 52:  ImperativeOCLKeyWord ::= w i t h
        //
        
		keywordKind[52] = (QVTOParsersym.TK_with);
	  
	
        //
        // Rule 53:  ImperativeOCLKeyWord ::= n e w
        //
        
		keywordKind[53] = (QVTOParsersym.TK_new);
	  
	
        //
        // Rule 55:  QVTOKeyWord ::= s t a t i c
        //
        
		keywordKind[55] = (QVTOParsersym.TK_static);
	  
	
        //
        // Rule 56:  QVTOKeyWord ::= i n i t
        //
        
		keywordKind[56] = (QVTOParsersym.TK_init);
	  
	
        //
        // Rule 57:  QVTOKeyWord ::= e n d
        //
        
		keywordKind[57] = (QVTOParsersym.TK_end);
	  
	
        //
        // Rule 58:  QVTOKeyWord ::= o u t
        //
        
		keywordKind[58] = (QVTOParsersym.TK_out);
	  
	
        //
        // Rule 59:  QVTOKeyWord ::= o b j e c t
        //
        
		keywordKind[59] = (QVTOParsersym.TK_object);
	  
	
        //
        // Rule 60:  QVTOKeyWord ::= t r a n s f o r m a t i o n
        //
        
		keywordKind[60] = (QVTOParsersym.TK_transformation);
	  
	
        //
        // Rule 61:  QVTOKeyWord ::= i m p o r t
        //
        
		keywordKind[61] = (QVTOParsersym.TK_import);
	  
	
        //
        // Rule 62:  QVTOKeyWord ::= l i b r a r y
        //
        
		keywordKind[62] = (QVTOParsersym.TK_library);
	  
	
        //
        // Rule 63:  QVTOKeyWord ::= m e t a m o d e l
        //
        
		keywordKind[63] = (QVTOParsersym.TK_metamodel);
	  
	
        //
        // Rule 64:  QVTOKeyWord ::= d i s j u n c t s
        //
        
		keywordKind[64] = (QVTOParsersym.TK_disjuncts);
	  
	
        //
        // Rule 65:  QVTOKeyWord ::= m e r g e s
        //
        
		keywordKind[65] = (QVTOParsersym.TK_merges);
	  
	
        //
        // Rule 66:  QVTOKeyWord ::= i n h e r i t s
        //
        
		keywordKind[66] = (QVTOParsersym.TK_inherits);
	  
	
        //
        // Rule 67:  QVTOKeyWord ::= r e n a m e
        //
        
		keywordKind[67] = (QVTOParsersym.TK_rename);
	  
	
        //
        // Rule 68:  QVTOKeyWord ::= m a p p i n g
        //
        
		keywordKind[68] = (QVTOParsersym.TK_mapping);
	  
	
        //
        // Rule 69:  QVTOKeyWord ::= q u e r y
        //
        
		keywordKind[69] = (QVTOParsersym.TK_query);
	  
	
        //
        // Rule 70:  QVTOKeyWord ::= h e l p e r
        //
        
		keywordKind[70] = (QVTOParsersym.TK_helper);
	  
	
        //
        // Rule 71:  QVTOKeyWord ::= i n o u t
        //
        
		keywordKind[71] = (QVTOParsersym.TK_inout);
	  
	
        //
        // Rule 72:  QVTOKeyWord ::= w h e n
        //
        
		keywordKind[72] = (QVTOParsersym.TK_when);
	  
	
        //
        // Rule 73:  QVTOKeyWord ::= c o n f i g u r a t i o n
        //
        
		keywordKind[73] = (QVTOParsersym.TK_configuration);
	  
	
        //
        // Rule 74:  QVTOKeyWord ::= p o p u l a t i o n
        //
        
		keywordKind[74] = (QVTOParsersym.TK_population);
	  
	
        //
        // Rule 75:  QVTOKeyWord ::= i n t e r m e d i a t e
        //
        
		keywordKind[75] = (QVTOParsersym.TK_intermediate);
	  
	
        //
        // Rule 76:  QVTOKeyWord ::= p r o p e r t y
        //
        
		keywordKind[76] = (QVTOParsersym.TK_property);
	  
	
        //
        // Rule 77:  QVTOKeyWord ::= o p p o s i t e s
        //
        
		keywordKind[77] = (QVTOParsersym.TK_opposites);
	  
	
        //
        // Rule 78:  QVTOKeyWord ::= c l a s s
        //
        
		keywordKind[78] = (QVTOParsersym.TK_class);
	  
	
        //
        // Rule 79:  QVTOKeyWord ::= m a p
        //
        
		keywordKind[79] = (QVTOParsersym.TK_map);
	  
	
        //
        // Rule 80:  QVTOKeyWord ::= x m a p
        //
        
		keywordKind[80] = (QVTOParsersym.TK_xmap);
	  
	
        //
        // Rule 81:  QVTOKeyWord ::= l a t e
        //
        
		keywordKind[81] = (QVTOParsersym.TK_late);
	  
	
        //
        // Rule 82:  QVTOKeyWord ::= r e s o l v e
        //
        
		keywordKind[82] = (QVTOParsersym.TK_resolve);
	  
	
        //
        // Rule 83:  QVTOKeyWord ::= r e s o l v e o n e
        //
        
		keywordKind[83] = (QVTOParsersym.TK_resolveone);
	  
	
        //
        // Rule 84:  QVTOKeyWord ::= r e s o l v e I n
        //
        
		keywordKind[84] = (QVTOParsersym.TK_resolveIn);
	  
	
        //
        // Rule 85:  QVTOKeyWord ::= r e s o l v e o n e I n
        //
        
		keywordKind[85] = (QVTOParsersym.TK_resolveoneIn);
	  
	
        //
        // Rule 86:  QVTOKeyWord ::= i n v r e s o l v e
        //
        
		keywordKind[86] = (QVTOParsersym.TK_invresolve);
	  
	
        //
        // Rule 87:  QVTOKeyWord ::= i n v r e s o l v e o n e
        //
        
		keywordKind[87] = (QVTOParsersym.TK_invresolveone);
	  
	
        //
        // Rule 88:  QVTOKeyWord ::= i n v r e s o l v e I n
        //
        
		keywordKind[88] = (QVTOParsersym.TK_invresolveIn);
	  
	
        //
        // Rule 89:  QVTOKeyWord ::= i n v r e s o l v e o n e I n
        //
        
		keywordKind[89] = (QVTOParsersym.TK_invresolveoneIn);
	  
	
        //
        // Rule 90:  QVTOKeyWord ::= m o d e l t y p e
        //
        
		keywordKind[90] = (QVTOParsersym.TK_modeltype);
	  
	
        //
        // Rule 91:  QVTOKeyWord ::= u s e s
        //
        
		keywordKind[91] = (QVTOParsersym.TK_uses);
	  
	
        //
        // Rule 92:  QVTOKeyWord ::= w h e r e
        //
        
		keywordKind[92] = (QVTOParsersym.TK_where);
	  
	
        //
        // Rule 93:  QVTOKeyWord ::= r e f i n e s
        //
        
		keywordKind[93] = (QVTOParsersym.TK_refines);
	  
	
        //
        // Rule 94:  QVTOKeyWord ::= a c c e s s
        //
        
		keywordKind[94] = (QVTOParsersym.TK_access);
	  
	
        //
        // Rule 95:  QVTOKeyWord ::= e x t e n d s
        //
        
		keywordKind[95] = (QVTOParsersym.TK_extends);
	  
	
        //
        // Rule 96:  QVTOKeyWord ::= b l a c k b o x
        //
        
		keywordKind[96] = (QVTOParsersym.TK_blackbox);
	  
	
        //
        // Rule 97:  QVTOKeyWord ::= a b s t r a c t
        //
        
		keywordKind[97] = (QVTOParsersym.TK_abstract);
	  
	
        //
        // Rule 98:  QVTOKeyWord ::= r e s u l t
        //
        
		keywordKind[98] = (QVTOParsersym.TK_result);
	  
	
        //
        // Rule 99:  QVTOKeyWord ::= m a i n
        //
        
		keywordKind[99] = (QVTOParsersym.TK_main);
	  
	
        //
        // Rule 100:  QVTOKeyWord ::= t h i s
        //
        
		keywordKind[100] = (QVTOParsersym.TK_this);
	  
	
        //
        // Rule 101:  QVTOKeyWord ::= c o m p o s e s
        //
        
		keywordKind[101] = (QVTOParsersym.TK_composes);
	  
	
        //
        // Rule 102:  QVTOKeyWord ::= c o n s t r u c t o r
        //
        
		keywordKind[102] = (QVTOParsersym.TK_constructor);
	  
	
        //
        // Rule 103:  QVTOKeyWord ::= d a t a t y p e
        //
        
		keywordKind[103] = (QVTOParsersym.TK_datatype);
	  
	
        //
        // Rule 104:  QVTOKeyWord ::= d e f a u l t
        //
        
		keywordKind[104] = (QVTOParsersym.TK_default);
	  
	
        //
        // Rule 105:  QVTOKeyWord ::= d e r i v e d
        //
        
		keywordKind[105] = (QVTOParsersym.TK_derived);
	  
	
        //
        // Rule 106:  QVTOKeyWord ::= d o
        //
        
		keywordKind[106] = (QVTOParsersym.TK_do);
	  
	
        //
        // Rule 107:  QVTOKeyWord ::= e l i f
        //
        
		keywordKind[107] = (QVTOParsersym.TK_elif);
	  
	
        //
        // Rule 108:  QVTOKeyWord ::= e n u m
        //
        
		keywordKind[108] = (QVTOParsersym.TK_enum);
	  
	
        //
        // Rule 109:  QVTOKeyWord ::= e x c e p t
        //
        
		keywordKind[109] = (QVTOParsersym.TK_except);
	  
	
        //
        // Rule 110:  QVTOKeyWord ::= e x c e p t i o n
        //
        
		keywordKind[110] = (QVTOParsersym.TK_exception);
	  
	
        //
        // Rule 111:  QVTOKeyWord ::= f r o m
        //
        
		keywordKind[111] = (QVTOParsersym.TK_from);
	  
	
        //
        // Rule 112:  QVTOKeyWord ::= l i t e r a l
        //
        
		keywordKind[112] = (QVTOParsersym.TK_literal);
	  
	
        //
        // Rule 113:  QVTOKeyWord ::= o r d e r e d
        //
        
		keywordKind[113] = (QVTOParsersym.TK_ordered);
	  
	
        //
        // Rule 114:  QVTOKeyWord ::= p r i m i t i v e
        //
        
		keywordKind[114] = (QVTOParsersym.TK_primitive);
	  
	
        //
        // Rule 115:  QVTOKeyWord ::= r a i s e
        //
        
		keywordKind[115] = (QVTOParsersym.TK_raise);
	  
	
        //
        // Rule 116:  QVTOKeyWord ::= r e a d o n l y
        //
        
		keywordKind[116] = (QVTOParsersym.TK_readonly);
	  
	
        //
        // Rule 117:  QVTOKeyWord ::= r e f e r e n c e s
        //
        
		keywordKind[117] = (QVTOParsersym.TK_references);
	  
	
        //
        // Rule 118:  QVTOKeyWord ::= t a g
        //
        
		keywordKind[118] = (QVTOParsersym.TK_tag);
	  
	
        //
        // Rule 119:  QVTOKeyWord ::= t r y
        //
        
		keywordKind[119] = (QVTOParsersym.TK_try);
	  
	
        //
        // Rule 120:  QVTOKeyWord ::= t y p e d e f
        //
        
		keywordKind[120] = (QVTOParsersym.TK_typedef);
	  
	
        //
        // Rule 121:  QVTOKeyWord ::= u n l i m i t e d
        //
        
		keywordKind[121] = (QVTOParsersym.TK_unlimited);
	  
	
        for (int i = 0; i < keywordKind.length; i++)
        {
            if (keywordKind[i] == 0)
                keywordKind[i] = identifierKind;
        }
    }
}

