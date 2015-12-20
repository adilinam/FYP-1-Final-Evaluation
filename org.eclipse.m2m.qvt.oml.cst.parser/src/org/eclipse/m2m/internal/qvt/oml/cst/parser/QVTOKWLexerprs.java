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

public class QVTOKWLexerprs implements lpg.runtime.ParseTable, QVTOKWLexersym {
    public final static int ERROR_SYMBOL = 0;
    public final int getErrorSymbol() { return ERROR_SYMBOL; }

    public final static int SCOPE_UBOUND = 0;
    public final int getScopeUbound() { return SCOPE_UBOUND; }

    public final static int SCOPE_SIZE = 0;
    public final int getScopeSize() { return SCOPE_SIZE; }

    public final static int MAX_NAME_LENGTH = 0;
    public final int getMaxNameLength() { return MAX_NAME_LENGTH; }

    public final static int NUM_STATES = 461;
    public final int getNumStates() { return NUM_STATES; }

    public final static int NT_OFFSET = 56;
    public final int getNtOffset() { return NT_OFFSET; }

    public final static int LA_STATE_OFFSET = 709;
    public final int getLaStateOffset() { return LA_STATE_OFFSET; }

    public final static int MAX_LA = 1;
    public final int getMaxLa() { return MAX_LA; }

    public final static int NUM_RULES = 121;
    public final int getNumRules() { return NUM_RULES; }

    public final static int NUM_NONTERMINALS = 4;
    public final int getNumNonterminals() { return NUM_NONTERMINALS; }

    public final static int NUM_SYMBOLS = 60;
    public final int getNumSymbols() { return NUM_SYMBOLS; }

    public final static int SEGMENT_SIZE = 8192;
    public final int getSegmentSize() { return SEGMENT_SIZE; }

    public final static int START_STATE = 122;
    public final int getStartState() { return START_STATE; }

    public final static int IDENTIFIER_SYMBOL = 0;
    public final int getIdentifier_SYMBOL() { return IDENTIFIER_SYMBOL; }

    public final static int EOFT_SYMBOL = 40;
    public final int getEoftSymbol() { return EOFT_SYMBOL; }

    public final static int EOLT_SYMBOL = 57;
    public final int getEoltSymbol() { return EOLT_SYMBOL; }

    public final static int ACCEPT_ACTION = 587;
    public final int getAcceptAction() { return ACCEPT_ACTION; }

    public final static int ERROR_ACTION = 588;
    public final int getErrorAction() { return ERROR_ACTION; }

    public final static boolean BACKTRACK = false;
    public final boolean getBacktrack() { return BACKTRACK; }

    public final int getStartSymbol() { return lhs(0); }
    public final boolean isValidForParser() { return QVTOKWLexersym.isValidForParser; }


    public interface IsNullable {
        public final static byte isNullable[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0
        };
    };
    public final static byte isNullable[] = IsNullable.isNullable;
    public final boolean isNullable(int index) { return isNullable[index] != 0; }

    public interface ProsthesesIndex {
        public final static byte prosthesesIndex[] = {0,
            2,3,4,1
        };
    };
    public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;
    public final int prosthesesIndex(int index) { return prosthesesIndex[index]; }

    public interface IsKeyword {
        public final static byte isKeyword[] = {0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0
        };
    };
    public final static byte isKeyword[] = IsKeyword.isKeyword;
    public final boolean isKeyword(int index) { return isKeyword[index] != 0; }

    public interface BaseCheck {
        public final static byte baseCheck[] = {0,
            4,2,4,4,5,3,2,3,3,7,
            3,2,4,5,3,3,8,10,10,6,
            7,16,4,7,5,6,7,10,4,7,
            1,4,4,5,6,4,7,8,9,10,
            13,16,7,6,7,6,3,5,8,3,
            6,4,3,1,6,4,3,3,6,14,
            6,7,9,9,6,8,6,7,5,6,
            5,4,13,10,12,8,9,5,3,4,
            4,7,10,9,12,10,13,12,15,9,
            4,5,7,6,7,8,8,6,4,4,
            8,11,8,7,7,2,4,4,6,9,
            4,7,7,9,5,8,10,3,3,7,
            9
        };
    };
    public final static byte baseCheck[] = BaseCheck.baseCheck;
    public final int baseCheck(int index) { return baseCheck[index]; }
    public final static byte rhs[] = baseCheck;
    public final int rhs(int index) { return rhs[index]; };

    public interface BaseAction {
        public final static char baseAction[] = {
            1,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,2,2,2,2,2,2,2,2,2,
            2,3,3,3,3,3,3,3,3,3,
            3,3,3,3,3,3,3,3,3,3,
            3,3,3,3,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,
            1,1,1,126,31,54,178,27,134,17,
            212,60,45,215,229,106,223,145,26,66,
            146,57,77,65,93,102,76,87,149,231,
            156,105,90,115,116,159,233,235,240,241,
            154,243,244,246,166,248,152,251,169,168,
            252,253,254,255,258,261,264,171,266,267,
            175,268,270,274,271,41,176,180,275,277,
            119,132,40,278,279,280,284,287,289,292,
            293,298,183,290,303,306,190,309,310,47,
            311,312,316,313,317,322,324,326,124,327,
            328,334,332,339,340,342,343,344,345,347,
            349,352,350,359,356,366,367,355,357,368,
            369,370,372,376,378,384,385,121,389,391,
            392,394,393,395,399,401,406,408,404,410,
            411,412,415,417,421,419,424,429,423,431,
            329,186,84,433,375,436,439,441,443,445,
            434,195,448,446,447,196,199,449,450,454,
            203,457,459,460,464,461,128,463,473,474,
            477,480,205,471,483,484,485,488,489,491,
            494,495,497,125,498,501,500,504,507,505,
            508,514,516,517,518,519,520,525,528,532,
            535,536,539,540,541,542,543,544,545,549,
            551,524,554,552,561,562,563,564,565,569,
            571,572,580,582,584,578,587,573,589,590,
            588,591,596,598,600,603,606,604,609,610,
            612,209,617,615,620,621,622,623,624,625,
            626,629,633,634,637,638,640,644,647,651,
            645,652,657,655,659,661,664,662,666,667,
            668,675,676,669,680,681,685,683,687,689,
            688,690,700,695,699,703,705,704,708,710,
            715,717,719,709,722,724,725,720,731,729,
            734,733,735,736,741,737,742,744,746,749,
            751,754,755,759,756,763,760,764,766,768,
            769,775,772,776,779,781,784,788,787,793,
            789,794,796,799,801,802,804,807,808,811,
            812,813,810,816,824,823,828,817,830,831,
            825,834,836,838,841,843,844,847,849,851,
            852,853,858,854,860,861,863,867,865,871,
            876,878,874,880,881,885,883,887,884,891,
            208,895,896,898,902,890,210,905,907,909,
            910,913,914,915,912,918,922,924,919,928,
            930,932,934,935,939,941,942,947,936,950,
            952,956,958,948,953,960,963,965,967,968,
            970,975,973,978,977,984,986,987,988,214,
            55,991,992,994,998,999,1001,1004,1005,1006,
            1010,1011,959,1012,1013,1016,1015,1022,1023,1024,
            1025,1027,1029,1030,1031,1037,588,588
        };
    };
    public final static char baseAction[] = BaseAction.baseAction;
    public final int baseAction(int index) { return baseAction[index]; }
    public final static char lhs[] = baseAction;
    public final int lhs(int index) { return lhs[index]; };

    public interface TermCheck {
        public final static byte termCheck[] = {0,
            0,1,2,3,4,5,6,7,8,9,
            10,11,12,13,14,15,0,1,18,19,
            20,21,22,23,24,0,0,27,28,3,
            30,31,32,8,34,9,36,37,38,0,
            0,2,2,4,0,1,0,8,2,3,
            10,7,8,7,0,9,0,18,19,0,
            1,15,6,4,0,0,7,8,12,13,
            6,7,7,8,20,0,0,21,3,3,
            16,5,18,0,9,10,0,1,5,0,
            4,8,0,7,8,3,21,8,9,10,
            24,0,1,14,0,0,14,15,3,8,
            6,7,8,12,0,0,1,2,0,5,
            0,7,8,0,0,7,3,0,5,2,
            12,0,1,0,16,4,9,14,23,6,
            20,8,15,19,0,0,1,2,0,29,
            6,0,4,0,10,0,1,4,0,39,
            9,8,7,5,6,0,18,0,0,2,
            0,6,4,6,0,0,2,0,8,0,
            15,13,0,4,2,0,11,12,9,0,
            1,6,7,4,0,0,1,3,0,4,
            6,27,0,21,0,1,8,0,0,0,
            12,0,0,0,0,8,8,40,9,15,
            12,8,0,12,22,3,12,20,0,1,
            0,22,0,20,0,33,4,7,4,0,
            0,1,0,0,5,0,1,0,5,2,
            0,0,0,0,0,13,2,0,5,7,
            0,11,5,0,13,0,0,0,5,0,
            0,11,6,0,0,2,0,0,0,0,
            13,11,17,0,5,2,0,13,0,0,
            13,0,0,17,25,9,0,0,10,2,
            9,23,0,11,2,0,17,2,0,0,
            0,0,0,4,6,0,0,6,8,7,
            5,0,1,0,8,0,0,0,0,6,
            2,0,7,0,7,9,5,4,0,0,
            1,0,0,0,0,7,0,4,0,0,
            9,0,10,9,0,0,0,1,0,4,
            14,13,13,12,6,0,0,0,0,0,
            3,0,7,7,0,0,2,0,7,25,
            5,13,5,0,0,1,17,4,0,1,
            0,0,0,0,0,5,5,4,0,1,
            0,1,8,0,12,0,1,0,1,0,
            0,0,1,4,0,1,0,14,0,3,
            0,1,0,0,0,15,3,9,0,1,
            0,1,0,0,12,0,1,5,0,1,
            0,1,0,1,0,0,0,0,0,0,
            6,18,5,0,9,7,0,11,0,0,
            0,12,0,0,5,9,0,14,5,9,
            0,13,0,0,1,13,0,5,2,0,
            10,2,0,0,0,2,2,0,0,7,
            0,1,4,0,0,1,0,0,5,0,
            0,14,2,0,0,1,0,0,5,12,
            4,12,16,0,1,0,0,0,0,0,
            3,14,3,0,0,2,8,0,1,14,
            6,0,1,17,0,0,1,3,0,0,
            0,0,0,0,0,3,6,9,0,10,
            0,0,1,0,13,11,6,9,15,6,
            0,0,0,0,0,5,4,6,0,6,
            0,0,0,9,6,3,6,0,7,0,
            1,0,1,0,1,8,0,0,0,0,
            0,0,6,5,5,0,6,0,3,0,
            1,14,0,0,7,0,1,5,0,0,
            2,0,9,4,0,4,0,1,4,0,
            0,0,0,0,0,0,2,4,0,10,
            10,6,0,0,1,7,0,0,6,0,
            0,5,3,0,0,2,0,26,26,3,
            0,0,8,16,0,4,0,1,0,9,
            0,0,4,0,1,0,0,0,0,1,
            3,10,7,19,0,0,16,2,4,0,
            0,2,0,17,0,1,0,0,0,0,
            0,11,4,4,0,1,9,15,0,0,
            14,2,0,0,0,7,2,0,0,0,
            7,9,3,6,0,1,0,1,0,0,
            2,0,1,0,0,1,3,19,0,10,
            0,1,0,0,0,0,0,3,10,6,
            0,0,2,0,9,0,10,2,0,17,
            0,10,2,0,0,0,2,4,0,0,
            2,18,0,0,2,0,11,0,0,21,
            0,0,13,10,0,0,2,6,0,11,
            0,16,7,0,17,2,0,0,0,11,
            3,11,0,0,2,0,10,4,0,11,
            0,0,1,0,9,2,0,0,8,0,
            0,0,0,15,8,0,0,5,11,9,
            5,10,0,0,0,16,3,0,1,0,
            0,9,2,0,18,0,12,0,1,10,
            0,1,0,0,2,12,0,12,0,1,
            0,0,0,0,8,2,4,0,1,0,
            0,1,0,1,0,22,0,16,0,19,
            0,5,13,0,4,0,1,0,1,0,
            0,8,0,0,0,6,0,5,2,0,
            0,11,28,9,0,0,2,0,9,16,
            10,0,1,6,0,10,0,3,0,0,
            1,0,0,0,0,1,5,0,0,11,
            8,0,9,0,1,4,8,0,11,0,
            24,0,3,0,0,0,9,4,0,1,
            0,0,7,3,3,14,0,0,2,0,
            1,0,0,19,3,0,1,0,0,0,
            3,2,0,11,0,3,0,0,1,0,
            12,7,0,7,0,1,0,0,9,2,
            8,5,35,0,1,0,0,0,2,2,
            0,0,7,0,1,4,6,0,0,2,
            0,1,4,0,0,0,3,3,3,0,
            0,0,0,1,0,0,2,8,3,8,
            10,0,0,0,0,3,0,6,0,0,
            0,3,3,7,0,5,0,1,0,0,
            0,0,0,20,0,0,22,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0,0,0,0,0,0,0,0,
            0,0,0
        };
    };
    public final static byte termCheck[] = TermCheck.termCheck;
    public final int termCheck(int index) { return termCheck[index]; }

    public interface TermAction {
        public final static char termAction[] = {0,
            588,142,143,145,144,147,150,146,141,154,
            153,131,127,128,132,151,588,162,129,149,
            136,155,137,148,152,588,588,130,140,158,
            139,138,157,176,156,159,134,133,135,12,
            588,267,257,270,588,169,588,268,288,287,
            256,168,167,284,83,286,588,269,271,588,
            164,285,184,166,588,588,165,694,183,181,
            190,189,178,177,569,588,588,182,200,186,
            188,187,191,588,199,198,588,204,346,588,
            202,345,588,201,203,192,197,216,215,214,
            185,588,194,213,588,588,193,590,172,196,
            210,212,211,195,588,588,222,220,588,217,
            588,219,218,588,588,263,296,588,298,370,
            264,588,266,588,707,265,368,297,221,160,
            324,161,369,383,588,588,180,179,588,326,
            175,588,205,588,174,588,209,229,588,325,
            237,230,208,223,224,588,206,588,588,242,
            588,234,239,241,588,588,603,588,250,588,
            235,240,588,260,278,588,259,258,261,588,
            281,343,344,282,588,588,356,660,588,357,
            352,252,588,279,588,375,359,82,588,588,
            358,588,588,86,588,536,433,587,539,589,
            434,568,588,163,362,173,170,535,588,171,
            588,540,588,567,588,363,225,207,226,588,
            588,228,588,588,227,588,233,588,232,236,
            588,588,588,588,588,231,246,588,245,244,
            588,238,247,588,243,588,588,588,249,588,
            7,248,251,588,588,646,588,588,588,588,
            253,255,604,588,273,597,588,262,588,588,
            272,588,588,706,254,274,588,588,275,277,
            276,641,588,594,599,588,638,280,588,588,
            588,588,588,283,635,588,588,290,289,292,
            291,588,294,588,293,588,588,588,588,596,
            644,588,295,588,300,299,302,301,588,588,
            304,588,588,588,588,303,588,307,588,588,
            305,588,306,679,588,588,588,317,588,313,
            308,309,311,310,312,588,588,588,79,588,
            687,588,314,315,588,588,347,588,320,316,
            321,318,611,588,588,323,319,322,588,327,
            588,588,588,588,588,328,329,330,588,333,
            588,334,332,588,331,588,335,588,336,57,
            588,588,592,337,588,338,588,696,588,339,
            588,601,588,588,588,695,591,688,588,340,
            588,342,588,588,341,588,348,617,588,349,
            588,669,588,350,588,588,588,588,588,588,
            351,640,353,588,354,360,588,355,588,588,
            588,361,588,588,365,364,588,699,366,367,
            588,668,588,588,624,371,588,372,373,588,
            376,374,588,588,588,621,620,588,588,377,
            588,380,379,588,588,382,588,588,381,588,
            588,378,385,588,588,389,588,588,387,384,
            388,386,657,588,613,588,588,588,588,588,
            393,390,395,588,588,659,394,588,397,391,
            396,588,398,392,588,588,400,399,588,588,
            588,588,588,588,588,405,403,401,588,402,
            588,588,410,588,404,406,408,407,593,409,
            588,588,588,588,588,411,413,412,588,414,
            588,588,588,415,416,421,417,588,418,588,
            680,588,636,588,703,419,588,588,588,588,
            588,588,420,422,423,588,425,588,426,588,
            602,424,588,588,427,588,429,428,588,588,
            430,588,666,431,588,432,588,435,436,588,
            588,588,588,588,588,588,441,440,588,437,
            438,442,588,588,444,443,588,588,658,588,
            588,445,447,588,588,448,588,439,622,449,
            588,588,450,446,588,451,588,452,588,653,
            588,588,454,588,455,588,588,588,588,460,
            458,456,457,453,588,588,614,647,459,588,
            588,461,588,608,588,463,588,588,588,588,
            588,462,466,468,588,469,467,464,588,588,
            465,649,588,588,588,470,639,588,588,588,
            471,682,473,472,588,474,588,475,588,588,
            686,588,655,588,588,632,634,476,588,477,
            588,478,588,588,588,588,588,482,479,480,
            588,588,484,588,483,588,485,486,588,481,
            588,643,488,588,588,588,490,489,588,588,
            491,623,588,588,692,588,693,588,588,487,
            588,588,492,493,588,588,496,609,588,495,
            588,494,497,588,656,499,588,588,588,615,
            612,498,588,109,501,588,500,502,588,701,
            588,588,504,588,683,505,588,588,503,588,
            588,588,588,708,506,588,588,700,618,598,
            508,507,588,588,588,650,509,588,510,588,
            588,681,625,588,631,588,512,588,515,511,
            588,633,588,588,516,513,588,514,588,519,
            588,588,588,588,518,522,521,588,691,588,
            588,524,588,525,588,517,588,664,588,520,
            588,526,523,588,528,588,605,588,529,588,
            588,530,588,588,588,531,588,533,685,588,
            588,532,527,654,588,588,626,588,689,704,
            534,588,637,538,588,537,588,541,588,588,
            702,588,588,588,588,678,651,588,588,709,
            542,588,652,588,545,544,546,588,543,588,
            684,588,698,588,588,588,665,548,588,550,
            588,588,553,672,551,547,588,588,552,588,
            554,588,588,549,555,588,627,588,588,588,
            662,607,588,616,588,606,588,588,559,588,
            577,557,588,558,588,560,588,588,705,562,
            561,563,556,588,628,588,588,588,565,566,
            588,588,564,588,571,570,690,588,588,572,
            588,663,573,588,588,588,676,574,673,588,
            588,588,588,579,588,588,580,575,661,578,
            576,588,588,87,41,648,588,581,588,588,
            588,677,585,584,588,610,588,630,588,588,
            588,588,588,582,588,588,583
        };
    };
    public final static char termAction[] = TermAction.termAction;
    public final int termAction(int index) { return termAction[index]; }
    public final int asb(int index) { return 0; }
    public final int asr(int index) { return 0; }
    public final int nasb(int index) { return 0; }
    public final int nasr(int index) { return 0; }
    public final int terminalIndex(int index) { return 0; }
    public final int nonterminalIndex(int index) { return 0; }
    public final int scopePrefix(int index) { return 0;}
    public final int scopeSuffix(int index) { return 0;}
    public final int scopeLhs(int index) { return 0;}
    public final int scopeLa(int index) { return 0;}
    public final int scopeStateSet(int index) { return 0;}
    public final int scopeRhs(int index) { return 0;}
    public final int scopeState(int index) { return 0;}
    public final int inSymb(int index) { return 0;}
    public final String name(int index) { return null; }
    public final int originalState(int state) { return 0; }
    public final int asi(int state) { return 0; }
    public final int nasi(int state) { return 0; }
    public final int inSymbol(int state) { return 0; }

    /**
     * assert(! goto_default);
     */
    public final int ntAction(int state, int sym) {
        return baseAction[state + sym];
    }

    /**
     * assert(! shift_default);
     */
    public final int tAction(int state, int sym) {
        int i = baseAction[state],
            k = i + sym;
        return termAction[termCheck[k] == sym ? k : i];
    }
    public final int lookAhead(int la_state, int sym) {
        int k = la_state + sym;
        return termAction[termCheck[k] == sym ? k : la_state];
    }
}
