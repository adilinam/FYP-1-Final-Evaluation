/**
* Essential OCL Grammar
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
*   E.D.Willink - Elimination of some shift-reduce conflicts
*   E.D.Willink - Remove unnecessary warning suppression
*   E.D.Willink - Bugs 184048, 225493, 243976, 259818, 282882, 287993, 288040, 292112, 295166
*   Borland - Bug 242880
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias):
*        - 242153: LPG v 2.0.17 adoption.
*        - 299396: Introducing new LPG templates
*        - 300534: Removing the use of deprecated macros.
* </copyright>
*
* $Id: EssentialOCL.gi,v 1.5 2010/02/11 15:40:41 sboyko Exp $
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2013 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*   Alex Paperno - bugs 314443, 274105, 274505, 419299 
*
* </copyright>
*
*/
/**
* <copyright>
*
* Copyright (c) 2006, 2013 Borland Inc.
* All rights reserved.   This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*   Borland - Initial API and implementation
*   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
*   Alex Paperno - bugs 392429, 419299 
*
* </copyright>
*
*/

package org.eclipse.m2m.internal.qvt.oml.cst.completion.parser;

public interface LightweightTypeParsersym {
    public final static int
      TK_QUOTED_IDENTIFIER = 2,
      TK_INTEGER_LITERAL = 29,
      TK_REAL_LITERAL = 30,
      TK_STRING_LITERAL = 22,
      TK_PLUS = 31,
      TK_MINUS = 32,
      TK_MULTIPLY = 33,
      TK_DIVIDE = 34,
      TK_GREATER = 35,
      TK_LESS = 36,
      TK_EQUAL = 37,
      TK_GREATER_EQUAL = 38,
      TK_LESS_EQUAL = 39,
      TK_NOT_EQUAL = 40,
      TK_LPAREN = 3,
      TK_RPAREN = 4,
      TK_LBRACE = 41,
      TK_RBRACE = 42,
      TK_LBRACKET = 43,
      TK_RBRACKET = 44,
      TK_ARROW = 45,
      TK_BAR = 46,
      TK_COMMA = 7,
      TK_COLON = 23,
      TK_COLONCOLON = 24,
      TK_SEMICOLON = 47,
      TK_DOT = 48,
      TK_DOTDOT = 49,
      TK_RESET_ASSIGN = 50,
      TK_ADD_ASSIGN = 51,
      TK_EXCLAMATION_MARK = 52,
      TK_COLONCOLONEQUAL = 53,
      TK_QUESTIONMARK = 54,
      TK_SINGLE_LINE_COMMENT = 55,
      TK_MULTI_LINE_COMMENT = 56,
      TK_STEREOTYPE_QUALIFIER_OPEN = 57,
      TK_STEREOTYPE_QUALIFIER_CLOSE = 58,
      TK_MULTIPLICITY_RANGE = 59,
      TK_TILDE_SIGN = 60,
      TK_NOT_EQUAL_EXEQ = 61,
      TK_AT_SIGN = 25,
      TK_and = 62,
      TK_implies = 63,
      TK_not = 64,
      TK_or = 65,
      TK_xor = 66,
      TK_if = 67,
      TK_then = 68,
      TK_else = 69,
      TK_endif = 70,
      TK_let = 71,
      TK_in = 72,
      TK_false = 73,
      TK_true = 74,
      TK_null = 75,
      TK_invalid = 76,
      TK_self = 77,
      TK_Bag = 8,
      TK_Collection = 9,
      TK_OrderedSet = 10,
      TK_Sequence = 11,
      TK_Set = 12,
      TK_Tuple = 13,
      TK_Boolean = 14,
      TK_Integer = 15,
      TK_Real = 16,
      TK_String = 17,
      TK_UnlimitedNatural = 18,
      TK_OclAny = 19,
      TK_OclInvalid = 20,
      TK_OclVoid = 21,
      TK_Dict = 26,
      TK_List = 27,
      TK_break = 78,
      TK_switch = 79,
      TK_case = 80,
      TK_xselect = 81,
      TK_xcollect = 82,
      TK_selectOne = 83,
      TK_collectOne = 84,
      TK_collectselect = 85,
      TK_collectselectOne = 86,
      TK_return = 87,
      TK_forEach = 88,
      TK_forOne = 89,
      TK_var = 90,
      TK_while = 91,
      TK_continue = 92,
      TK_log = 93,
      TK_assert = 94,
      TK_with = 95,
      TK_compute = 96,
      TK_new = 97,
      TK_init = 98,
      TK_static = 99,
      TK_end = 100,
      TK_out = 101,
      TK_object = 102,
      TK_transformation = 103,
      TK_import = 104,
      TK_library = 105,
      TK_metamodel = 106,
      TK_mapping = 107,
      TK_query = 108,
      TK_helper = 109,
      TK_inout = 110,
      TK_when = 111,
      TK_configuration = 112,
      TK_intermediate = 113,
      TK_property = 114,
      TK_opposites = 115,
      TK_class = 116,
      TK_population = 117,
      TK_map = 118,
      TK_xmap = 119,
      TK_late = 120,
      TK_resolve = 121,
      TK_resolveone = 122,
      TK_resolveIn = 123,
      TK_resolveoneIn = 124,
      TK_invresolve = 125,
      TK_invresolveone = 126,
      TK_invresolveIn = 127,
      TK_invresolveoneIn = 128,
      TK_modeltype = 129,
      TK_uses = 130,
      TK_where = 131,
      TK_refines = 132,
      TK_access = 133,
      TK_extends = 134,
      TK_blackbox = 135,
      TK_abstract = 136,
      TK_result = 5,
      TK_main = 137,
      TK_this = 6,
      TK_rename = 138,
      TK_disjuncts = 139,
      TK_merges = 140,
      TK_inherits = 141,
      TK_composes = 142,
      TK_constructor = 143,
      TK_datatype = 144,
      TK_default = 145,
      TK_derived = 146,
      TK_do = 147,
      TK_elif = 148,
      TK_enum = 149,
      TK_except = 150,
      TK_exception = 151,
      TK_from = 152,
      TK_literal = 153,
      TK_ordered = 154,
      TK_primitive = 155,
      TK_raise = 156,
      TK_readonly = 157,
      TK_references = 158,
      TK_tag = 159,
      TK_try = 160,
      TK_typedef = 161,
      TK_unlimited = 162,
      TK_ERROR_TOKEN = 163,
      TK_IDENTIFIER = 1,
      TK_EOF_TOKEN = 28;

    public final static String orderedTerminalSymbols[] = {
                 "", //$NON-NLS-1$
                 "IDENTIFIER", //$NON-NLS-1$
                 "QUOTED_IDENTIFIER", //$NON-NLS-1$
                 "LPAREN", //$NON-NLS-1$
                 "RPAREN", //$NON-NLS-1$
                 "result", //$NON-NLS-1$
                 "this", //$NON-NLS-1$
                 "COMMA", //$NON-NLS-1$
                 "Bag", //$NON-NLS-1$
                 "Collection", //$NON-NLS-1$
                 "OrderedSet", //$NON-NLS-1$
                 "Sequence", //$NON-NLS-1$
                 "Set", //$NON-NLS-1$
                 "Tuple", //$NON-NLS-1$
                 "Boolean", //$NON-NLS-1$
                 "Integer", //$NON-NLS-1$
                 "Real", //$NON-NLS-1$
                 "String", //$NON-NLS-1$
                 "UnlimitedNatural", //$NON-NLS-1$
                 "OclAny", //$NON-NLS-1$
                 "OclInvalid", //$NON-NLS-1$
                 "OclVoid", //$NON-NLS-1$
                 "STRING_LITERAL", //$NON-NLS-1$
                 "COLON", //$NON-NLS-1$
                 "COLONCOLON", //$NON-NLS-1$
                 "AT_SIGN", //$NON-NLS-1$
                 "Dict", //$NON-NLS-1$
                 "List", //$NON-NLS-1$
                 "EOF_TOKEN", //$NON-NLS-1$
                 "INTEGER_LITERAL", //$NON-NLS-1$
                 "REAL_LITERAL", //$NON-NLS-1$
                 "PLUS", //$NON-NLS-1$
                 "MINUS", //$NON-NLS-1$
                 "MULTIPLY", //$NON-NLS-1$
                 "DIVIDE", //$NON-NLS-1$
                 "GREATER", //$NON-NLS-1$
                 "LESS", //$NON-NLS-1$
                 "EQUAL", //$NON-NLS-1$
                 "GREATER_EQUAL", //$NON-NLS-1$
                 "LESS_EQUAL", //$NON-NLS-1$
                 "NOT_EQUAL", //$NON-NLS-1$
                 "LBRACE", //$NON-NLS-1$
                 "RBRACE", //$NON-NLS-1$
                 "LBRACKET", //$NON-NLS-1$
                 "RBRACKET", //$NON-NLS-1$
                 "ARROW", //$NON-NLS-1$
                 "BAR", //$NON-NLS-1$
                 "SEMICOLON", //$NON-NLS-1$
                 "DOT", //$NON-NLS-1$
                 "DOTDOT", //$NON-NLS-1$
                 "RESET_ASSIGN", //$NON-NLS-1$
                 "ADD_ASSIGN", //$NON-NLS-1$
                 "EXCLAMATION_MARK", //$NON-NLS-1$
                 "COLONCOLONEQUAL", //$NON-NLS-1$
                 "QUESTIONMARK", //$NON-NLS-1$
                 "SINGLE_LINE_COMMENT", //$NON-NLS-1$
                 "MULTI_LINE_COMMENT", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_OPEN", //$NON-NLS-1$
                 "STEREOTYPE_QUALIFIER_CLOSE", //$NON-NLS-1$
                 "MULTIPLICITY_RANGE", //$NON-NLS-1$
                 "TILDE_SIGN", //$NON-NLS-1$
                 "NOT_EQUAL_EXEQ", //$NON-NLS-1$
                 "and", //$NON-NLS-1$
                 "implies", //$NON-NLS-1$
                 "not", //$NON-NLS-1$
                 "or", //$NON-NLS-1$
                 "xor", //$NON-NLS-1$
                 "if", //$NON-NLS-1$
                 "then", //$NON-NLS-1$
                 "else", //$NON-NLS-1$
                 "endif", //$NON-NLS-1$
                 "let", //$NON-NLS-1$
                 "in", //$NON-NLS-1$
                 "false", //$NON-NLS-1$
                 "true", //$NON-NLS-1$
                 "null", //$NON-NLS-1$
                 "invalid", //$NON-NLS-1$
                 "self", //$NON-NLS-1$
                 "break", //$NON-NLS-1$
                 "switch", //$NON-NLS-1$
                 "case", //$NON-NLS-1$
                 "xselect", //$NON-NLS-1$
                 "xcollect", //$NON-NLS-1$
                 "selectOne", //$NON-NLS-1$
                 "collectOne", //$NON-NLS-1$
                 "collectselect", //$NON-NLS-1$
                 "collectselectOne", //$NON-NLS-1$
                 "return", //$NON-NLS-1$
                 "forEach", //$NON-NLS-1$
                 "forOne", //$NON-NLS-1$
                 "var", //$NON-NLS-1$
                 "while", //$NON-NLS-1$
                 "continue", //$NON-NLS-1$
                 "log", //$NON-NLS-1$
                 "assert", //$NON-NLS-1$
                 "with", //$NON-NLS-1$
                 "compute", //$NON-NLS-1$
                 "new", //$NON-NLS-1$
                 "init", //$NON-NLS-1$
                 "static", //$NON-NLS-1$
                 "end", //$NON-NLS-1$
                 "out", //$NON-NLS-1$
                 "object", //$NON-NLS-1$
                 "transformation", //$NON-NLS-1$
                 "import", //$NON-NLS-1$
                 "library", //$NON-NLS-1$
                 "metamodel", //$NON-NLS-1$
                 "mapping", //$NON-NLS-1$
                 "query", //$NON-NLS-1$
                 "helper", //$NON-NLS-1$
                 "inout", //$NON-NLS-1$
                 "when", //$NON-NLS-1$
                 "configuration", //$NON-NLS-1$
                 "intermediate", //$NON-NLS-1$
                 "property", //$NON-NLS-1$
                 "opposites", //$NON-NLS-1$
                 "class", //$NON-NLS-1$
                 "population", //$NON-NLS-1$
                 "map", //$NON-NLS-1$
                 "xmap", //$NON-NLS-1$
                 "late", //$NON-NLS-1$
                 "resolve", //$NON-NLS-1$
                 "resolveone", //$NON-NLS-1$
                 "resolveIn", //$NON-NLS-1$
                 "resolveoneIn", //$NON-NLS-1$
                 "invresolve", //$NON-NLS-1$
                 "invresolveone", //$NON-NLS-1$
                 "invresolveIn", //$NON-NLS-1$
                 "invresolveoneIn", //$NON-NLS-1$
                 "modeltype", //$NON-NLS-1$
                 "uses", //$NON-NLS-1$
                 "where", //$NON-NLS-1$
                 "refines", //$NON-NLS-1$
                 "access", //$NON-NLS-1$
                 "extends", //$NON-NLS-1$
                 "blackbox", //$NON-NLS-1$
                 "abstract", //$NON-NLS-1$
                 "main", //$NON-NLS-1$
                 "rename", //$NON-NLS-1$
                 "disjuncts", //$NON-NLS-1$
                 "merges", //$NON-NLS-1$
                 "inherits", //$NON-NLS-1$
                 "composes", //$NON-NLS-1$
                 "constructor", //$NON-NLS-1$
                 "datatype", //$NON-NLS-1$
                 "default", //$NON-NLS-1$
                 "derived", //$NON-NLS-1$
                 "do", //$NON-NLS-1$
                 "elif", //$NON-NLS-1$
                 "enum", //$NON-NLS-1$
                 "except", //$NON-NLS-1$
                 "exception", //$NON-NLS-1$
                 "from", //$NON-NLS-1$
                 "literal", //$NON-NLS-1$
                 "ordered", //$NON-NLS-1$
                 "primitive", //$NON-NLS-1$
                 "raise", //$NON-NLS-1$
                 "readonly", //$NON-NLS-1$
                 "references", //$NON-NLS-1$
                 "tag", //$NON-NLS-1$
                 "try", //$NON-NLS-1$
                 "typedef", //$NON-NLS-1$
                 "unlimited", //$NON-NLS-1$
                 "ERROR_TOKEN" //$NON-NLS-1$
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
