package org.eclipse.qvto.examples.xtext.imperativeocl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.qvto.examples.xtext.imperativeocl.services.ImperativeOCLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalImperativeOCLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SINGLE_QUOTED_STRING", "RULE_DOUBLE_QUOTED_STRING", "RULE_SIMPLE_ID", "RULE_ESCAPED_ID", "RULE_INT", "RULE_ACCESS_OP", "RULE_ASSIGN_OP", "RULE_CMP_OP", "RULE_MULT_OP", "RULE_MULTI_ITERATOR_OP", "RULE_RESOLVE_IN_KIND", "RULE_RESOLVE_KIND", "RULE_SIMPLE_ITERATOR_OP", "RULE_UNARY_OP", "RULE_ESCAPED_CHARACTER", "RULE_LETTER_CHARACTER", "RULE_ML_SINGLE_QUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'List'", "'('", "')'", "'Dict'", "','", "'{'", "'}'", "'='", "'return'", "'-'", "'not'", "'*'", "'/'", "'+'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'and'", "'or'", "'xor'", "'implies'", "'.'", "'->'", "'?.'", "'?->'", "'Map'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "':'", "'..'", "'++'", "'Lambda'", "'<-'", "'true'", "'false'", "'invalid'", "'null'", "'@'", "'pre'", "'['", "']'", "'in'", "'|'", "';'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'self'", "'|?'", "'|1'", "'?'", "'::'", "'extends'", "'&&'"
    };
    public static final int T__50=50;
    public static final int RULE_RESOLVE_IN_KIND=14;
    public static final int RULE_MULTI_ITERATOR_OP=13;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ACCESS_OP=9;
    public static final int RULE_INT=8;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=21;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_MULT_OP=12;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_SINGLE_QUOTED_STRING=4;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_DOUBLE_QUOTED_STRING=5;
    public static final int T__44=44;
    public static final int RULE_UNARY_OP=17;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_ASSIGN_OP=10;
    public static final int T__47=47;
    public static final int RULE_ESCAPED_ID=7;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__90=90;
    public static final int RULE_LETTER_CHARACTER=19;
    public static final int RULE_SIMPLE_ITERATOR_OP=16;
    public static final int RULE_ESCAPED_CHARACTER=18;
    public static final int T__95=95;
    public static final int RULE_ML_SINGLE_QUOTED_STRING=20;
    public static final int RULE_RESOLVE_KIND=15;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__25=25;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_SL_COMMENT=22;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int RULE_SIMPLE_ID=6;
    public static final int T__83=83;
    public static final int RULE_WS=23;
    public static final int RULE_ANY_OTHER=24;
    public static final int RULE_CMP_OP=11;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalImperativeOCLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalImperativeOCLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalImperativeOCLParser.tokenNames; }
    public String getGrammarFileName() { return "../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private ImperativeOCLGrammarAccess grammarAccess;
     	
        public InternalImperativeOCLParser(TokenStream input, ImperativeOCLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "GrammmarCS";	
       	}
       	
       	@Override
       	protected ImperativeOCLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleGrammmarCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:73:1: entryRuleGrammmarCS returns [EObject current=null] : iv_ruleGrammmarCS= ruleGrammmarCS EOF ;
    public final EObject entryRuleGrammmarCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGrammmarCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:74:2: (iv_ruleGrammmarCS= ruleGrammmarCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:75:2: iv_ruleGrammmarCS= ruleGrammmarCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGrammmarCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleGrammmarCS_in_entryRuleGrammmarCS81);
            iv_ruleGrammmarCS=ruleGrammmarCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGrammmarCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleGrammmarCS91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGrammmarCS"


    // $ANTLR start "ruleGrammmarCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:82:1: ruleGrammmarCS returns [EObject current=null] : this_ImperativeOCLExpCS_0= ruleImperativeOCLExpCS ;
    public final EObject ruleGrammmarCS() throws RecognitionException {
        EObject current = null;

        EObject this_ImperativeOCLExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:85:28: (this_ImperativeOCLExpCS_0= ruleImperativeOCLExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:87:2: this_ImperativeOCLExpCS_0= ruleImperativeOCLExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getGrammmarCSAccess().getImperativeOCLExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleImperativeOCLExpCS_in_ruleGrammmarCS140);
            this_ImperativeOCLExpCS_0=ruleImperativeOCLExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ImperativeOCLExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGrammmarCS"


    // $ANTLR start "entryRuleImperativeOCLExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:114:1: entryRuleImperativeOCLExpCS returns [EObject current=null] : iv_ruleImperativeOCLExpCS= ruleImperativeOCLExpCS EOF ;
    public final EObject entryRuleImperativeOCLExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImperativeOCLExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:115:2: (iv_ruleImperativeOCLExpCS= ruleImperativeOCLExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:116:2: iv_ruleImperativeOCLExpCS= ruleImperativeOCLExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImperativeOCLExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImperativeOCLExpCS_in_entryRuleImperativeOCLExpCS182);
            iv_ruleImperativeOCLExpCS=ruleImperativeOCLExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImperativeOCLExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImperativeOCLExpCS192); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImperativeOCLExpCS"


    // $ANTLR start "ruleImperativeOCLExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:123:1: ruleImperativeOCLExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleImperativeOCLExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:126:28: (this_ExpCS_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:128:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getImperativeOCLExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleImperativeOCLExpCS241);
            this_ExpCS_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImperativeOCLExpCS"


    // $ANTLR start "entryRuleTypeLiteralCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:147:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:148:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:149:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS275);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralCS285); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralCS"


    // $ANTLR start "ruleTypeLiteralCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:156:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS | this_ListTypeCS_4= ruleListTypeCS | this_DictTypeCS_5= ruleDictTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_MapTypeCS_2 = null;

        EObject this_TupleTypeCS_3 = null;

        EObject this_ListTypeCS_4 = null;

        EObject this_DictTypeCS_5 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:159:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS | this_ListTypeCS_4= ruleListTypeCS | this_DictTypeCS_5= ruleDictTypeCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:160:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS | this_ListTypeCS_4= ruleListTypeCS | this_DictTypeCS_5= ruleDictTypeCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:160:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_MapTypeCS_2= ruleMapTypeCS | this_TupleTypeCS_3= ruleTupleTypeCS | this_ListTypeCS_4= ruleListTypeCS | this_DictTypeCS_5= ruleDictTypeCS )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt1=1;
                }
                break;
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
                {
                alt1=2;
                }
                break;
            case 52:
                {
                alt1=3;
                }
                break;
            case 53:
                {
                alt1=4;
                }
                break;
            case 25:
                {
                alt1=5;
                }
                break;
            case 28:
                {
                alt1=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:161:2: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS335);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveTypeCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:174:2: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS365);
                    this_CollectionTypeCS_1=ruleCollectionTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionTypeCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:187:2: this_MapTypeCS_2= ruleMapTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getMapTypeCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS395);
                    this_MapTypeCS_2=ruleMapTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapTypeCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:200:2: this_TupleTypeCS_3= ruleTupleTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS425);
                    this_TupleTypeCS_3=ruleTupleTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleTypeCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:213:2: this_ListTypeCS_4= ruleListTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getListTypeCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleListTypeCS_in_ruleTypeLiteralCS455);
                    this_ListTypeCS_4=ruleListTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ListTypeCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:226:2: this_DictTypeCS_5= ruleDictTypeCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getDictTypeCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDictTypeCS_in_ruleTypeLiteralCS485);
                    this_DictTypeCS_5=ruleDictTypeCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DictTypeCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralCS"


    // $ANTLR start "entryRuleListTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:245:1: entryRuleListTypeCS returns [EObject current=null] : iv_ruleListTypeCS= ruleListTypeCS EOF ;
    public final EObject entryRuleListTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:246:2: (iv_ruleListTypeCS= ruleListTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:247:2: iv_ruleListTypeCS= ruleListTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListTypeCS_in_entryRuleListTypeCS520);
            iv_ruleListTypeCS=ruleListTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListTypeCS530); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTypeCS"


    // $ANTLR start "ruleListTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:254:1: ruleListTypeCS returns [EObject current=null] : (otherlv_0= 'List' otherlv_1= '(' ( (lv_type_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) ;
    public final EObject ruleListTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:257:28: ( (otherlv_0= 'List' otherlv_1= '(' ( (lv_type_2_0= ruleTypeExpCS ) ) otherlv_3= ')' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:258:1: (otherlv_0= 'List' otherlv_1= '(' ( (lv_type_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:258:1: (otherlv_0= 'List' otherlv_1= '(' ( (lv_type_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:258:3: otherlv_0= 'List' otherlv_1= '(' ( (lv_type_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleListTypeCS567); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListTypeCSAccess().getListKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleListTypeCS579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListTypeCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:266:1: ( (lv_type_2_0= ruleTypeExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:267:1: (lv_type_2_0= ruleTypeExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:267:1: (lv_type_2_0= ruleTypeExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:268:3: lv_type_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getListTypeCSAccess().getTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleListTypeCS600);
            lv_type_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getListTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleListTypeCS612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getListTypeCSAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTypeCS"


    // $ANTLR start "entryRuleDictTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:296:1: entryRuleDictTypeCS returns [EObject current=null] : iv_ruleDictTypeCS= ruleDictTypeCS EOF ;
    public final EObject entryRuleDictTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDictTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:297:2: (iv_ruleDictTypeCS= ruleDictTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:298:2: iv_ruleDictTypeCS= ruleDictTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDictTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDictTypeCS_in_entryRuleDictTypeCS648);
            iv_ruleDictTypeCS=ruleDictTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDictTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDictTypeCS658); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDictTypeCS"


    // $ANTLR start "ruleDictTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:305:1: ruleDictTypeCS returns [EObject current=null] : (otherlv_0= 'Dict' otherlv_1= '(' ( (lv_keyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' ) ;
    public final EObject ruleDictTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_keyType_2_0 = null;

        EObject lv_valueType_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:308:28: ( (otherlv_0= 'Dict' otherlv_1= '(' ( (lv_keyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:309:1: (otherlv_0= 'Dict' otherlv_1= '(' ( (lv_keyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:309:1: (otherlv_0= 'Dict' otherlv_1= '(' ( (lv_keyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:309:3: otherlv_0= 'Dict' otherlv_1= '(' ( (lv_keyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDictTypeCS695); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDictTypeCSAccess().getDictKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleDictTypeCS707); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDictTypeCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:317:1: ( (lv_keyType_2_0= ruleTypeExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:318:1: (lv_keyType_2_0= ruleTypeExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:318:1: (lv_keyType_2_0= ruleTypeExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:319:3: lv_keyType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDictTypeCSAccess().getKeyTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleDictTypeCS728);
            lv_keyType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDictTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"keyType",
                      		lv_keyType_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleDictTypeCS740); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDictTypeCSAccess().getCommaKeyword_3());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:339:1: ( (lv_valueType_4_0= ruleTypeExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:340:1: (lv_valueType_4_0= ruleTypeExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:340:1: (lv_valueType_4_0= ruleTypeExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:341:3: lv_valueType_4_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDictTypeCSAccess().getValueTypeTypeExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleDictTypeCS761);
            lv_valueType_4_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDictTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"valueType",
                      		lv_valueType_4_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleDictTypeCS773); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDictTypeCSAccess().getRightParenthesisKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDictTypeCS"


    // $ANTLR start "entryRulePrimaryExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:369:1: entryRulePrimaryExpCS returns [EObject current=null] : iv_rulePrimaryExpCS= rulePrimaryExpCS EOF ;
    public final EObject entryRulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:370:2: (iv_rulePrimaryExpCS= rulePrimaryExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:371:2: iv_rulePrimaryExpCS= rulePrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS809);
            iv_rulePrimaryExpCS=rulePrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimaryExpCS819); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpCS"


    // $ANTLR start "rulePrimaryExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:378:1: rulePrimaryExpCS returns [EObject current=null] : (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_ListLiteralExpCS_8= ruleListLiteralExpCS | this_DictLiteralExpCS_9= ruleDictLiteralExpCS | this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS | this_ReturnExpCS_11= ruleReturnExpCS | this_NameExpCS_12= ruleNameExpCS ) ;
    public final EObject rulePrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NestedExpCS_0 = null;

        EObject this_IfExpCS_1 = null;

        EObject this_SelfExpCS_2 = null;

        EObject this_PrimitiveLiteralExpCS_3 = null;

        EObject this_TupleLiteralExpCS_4 = null;

        EObject this_MapLiteralExpCS_5 = null;

        EObject this_CollectionLiteralExpCS_6 = null;

        EObject this_LambdaLiteralExpCS_7 = null;

        EObject this_ListLiteralExpCS_8 = null;

        EObject this_DictLiteralExpCS_9 = null;

        EObject this_TypeLiteralExpCS_10 = null;

        EObject this_ReturnExpCS_11 = null;

        EObject this_NameExpCS_12 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:381:28: ( (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_ListLiteralExpCS_8= ruleListLiteralExpCS | this_DictLiteralExpCS_9= ruleDictLiteralExpCS | this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS | this_ReturnExpCS_11= ruleReturnExpCS | this_NameExpCS_12= ruleNameExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:382:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_ListLiteralExpCS_8= ruleListLiteralExpCS | this_DictLiteralExpCS_9= ruleDictLiteralExpCS | this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS | this_ReturnExpCS_11= ruleReturnExpCS | this_NameExpCS_12= ruleNameExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:382:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_ListLiteralExpCS_8= ruleListLiteralExpCS | this_DictLiteralExpCS_9= ruleDictLiteralExpCS | this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS | this_ReturnExpCS_11= ruleReturnExpCS | this_NameExpCS_12= ruleNameExpCS )
            int alt2=13;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:383:2: this_NestedExpCS_0= ruleNestedExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNestedExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS869);
                    this_NestedExpCS_0=ruleNestedExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NestedExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:396:2: this_IfExpCS_1= ruleIfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getIfExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS899);
                    this_IfExpCS_1=ruleIfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_IfExpCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:409:2: this_SelfExpCS_2= ruleSelfExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getSelfExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS929);
                    this_SelfExpCS_2=ruleSelfExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_SelfExpCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:422:2: this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getPrimitiveLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS959);
                    this_PrimitiveLiteralExpCS_3=rulePrimitiveLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimitiveLiteralExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:435:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTupleLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS989);
                    this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TupleLiteralExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:448:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getMapLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS1019);
                    this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MapLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:461:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getCollectionLiteralExpCSParserRuleCall_6()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS1049);
                    this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionLiteralExpCS_6; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:474:2: this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getLambdaLiteralExpCSParserRuleCall_7()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS1079);
                    this_LambdaLiteralExpCS_7=ruleLambdaLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LambdaLiteralExpCS_7; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:487:2: this_ListLiteralExpCS_8= ruleListLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getListLiteralExpCSParserRuleCall_8()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleListLiteralExpCS_in_rulePrimaryExpCS1109);
                    this_ListLiteralExpCS_8=ruleListLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ListLiteralExpCS_8; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:500:2: this_DictLiteralExpCS_9= ruleDictLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getDictLiteralExpCSParserRuleCall_9()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDictLiteralExpCS_in_rulePrimaryExpCS1139);
                    this_DictLiteralExpCS_9=ruleDictLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_DictLiteralExpCS_9; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:513:2: this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getTypeLiteralExpCSParserRuleCall_10()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS1169);
                    this_TypeLiteralExpCS_10=ruleTypeLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralExpCS_10; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:526:2: this_ReturnExpCS_11= ruleReturnExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getReturnExpCSParserRuleCall_11()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleReturnExpCS_in_rulePrimaryExpCS1199);
                    this_ReturnExpCS_11=ruleReturnExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_ReturnExpCS_11; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:539:2: this_NameExpCS_12= ruleNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimaryExpCSAccess().getNameExpCSParserRuleCall_12()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS1229);
                    this_NameExpCS_12=ruleNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NameExpCS_12; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpCS"


    // $ANTLR start "entryRuleListLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:558:1: entryRuleListLiteralExpCS returns [EObject current=null] : iv_ruleListLiteralExpCS= ruleListLiteralExpCS EOF ;
    public final EObject entryRuleListLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:559:2: (iv_ruleListLiteralExpCS= ruleListLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:560:2: iv_ruleListLiteralExpCS= ruleListLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleListLiteralExpCS_in_entryRuleListLiteralExpCS1264);
            iv_ruleListLiteralExpCS=ruleListLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListLiteralExpCS1274); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListLiteralExpCS"


    // $ANTLR start "ruleListLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:567:1: ruleListLiteralExpCS returns [EObject current=null] : (otherlv_0= 'List' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleListLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedParts_3_0 = null;

        EObject lv_ownedParts_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:570:28: ( (otherlv_0= 'List' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_6= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:571:1: (otherlv_0= 'List' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_6= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:571:1: (otherlv_0= 'List' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_6= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:571:3: otherlv_0= 'List' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleListLiteralExpCS1311); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getListLiteralExpCSAccess().getListKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleListLiteralExpCS1323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getListLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:579:1: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:580:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getListLiteralExpCSAccess().getListLiteralExpCSAction_2(),
                          current);
                  
            }

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:588:2: ( ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_SINGLE_QUOTED_STRING && LA4_0<=RULE_INT)||(LA4_0>=25 && LA4_0<=26)||LA4_0==28||(LA4_0>=33 && LA4_0<=36)||(LA4_0>=52 && LA4_0<=67)||LA4_0==70||(LA4_0>=72 && LA4_0<=75)||LA4_0==83||(LA4_0>=88 && LA4_0<=89)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:588:3: ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:588:3: ( (lv_ownedParts_3_0= ruleCollectionLiteralPartCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:589:1: (lv_ownedParts_3_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:589:1: (lv_ownedParts_3_0= ruleCollectionLiteralPartCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:590:3: lv_ownedParts_3_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getListLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleListLiteralExpCS1357);
                    lv_ownedParts_3_0=ruleCollectionLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getListLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_3_0, 
                              		"CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:606:2: (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==29) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:606:4: otherlv_4= ',' ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListLiteralExpCS1370); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getListLiteralExpCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:610:1: ( (lv_ownedParts_5_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:611:1: (lv_ownedParts_5_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:611:1: (lv_ownedParts_5_0= ruleCollectionLiteralPartCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:612:3: lv_ownedParts_5_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getListLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleListLiteralExpCS1391);
                    	    lv_ownedParts_5_0=ruleCollectionLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getListLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_5_0, 
                    	              		"CollectionLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleListLiteralExpCS1407); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getListLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListLiteralExpCS"


    // $ANTLR start "entryRuleDictLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:640:1: entryRuleDictLiteralExpCS returns [EObject current=null] : iv_ruleDictLiteralExpCS= ruleDictLiteralExpCS EOF ;
    public final EObject entryRuleDictLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDictLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:641:2: (iv_ruleDictLiteralExpCS= ruleDictLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:642:2: iv_ruleDictLiteralExpCS= ruleDictLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDictLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDictLiteralExpCS_in_entryRuleDictLiteralExpCS1443);
            iv_ruleDictLiteralExpCS=ruleDictLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDictLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDictLiteralExpCS1453); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDictLiteralExpCS"


    // $ANTLR start "ruleDictLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:649:1: ruleDictLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Dict' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleDictLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedParts_3_0 = null;

        EObject lv_ownedParts_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:652:28: ( (otherlv_0= 'Dict' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )? otherlv_6= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:653:1: (otherlv_0= 'Dict' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )? otherlv_6= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:653:1: (otherlv_0= 'Dict' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )? otherlv_6= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:653:3: otherlv_0= 'Dict' otherlv_1= '{' () ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )? otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleDictLiteralExpCS1490); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getDictLiteralExpCSAccess().getDictKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleDictLiteralExpCS1502); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDictLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:661:1: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:662:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getDictLiteralExpCSAccess().getDictLiteralExpCSAction_2(),
                          current);
                  
            }

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:670:2: ( ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>=RULE_SINGLE_QUOTED_STRING && LA6_0<=RULE_DOUBLE_QUOTED_STRING)||LA6_0==RULE_INT||LA6_0==36||(LA6_0>=72 && LA6_0<=75)) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:670:3: ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) ) (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )*
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:670:3: ( (lv_ownedParts_3_0= ruleDictLiteralPartCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:671:1: (lv_ownedParts_3_0= ruleDictLiteralPartCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:671:1: (lv_ownedParts_3_0= ruleDictLiteralPartCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:672:3: lv_ownedParts_3_0= ruleDictLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDictLiteralExpCSAccess().getOwnedPartsDictLiteralPartCSParserRuleCall_3_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleDictLiteralPartCS_in_ruleDictLiteralExpCS1536);
                    lv_ownedParts_3_0=ruleDictLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDictLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_3_0, 
                              		"DictLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:688:2: (otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==29) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:688:4: otherlv_4= ',' ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) )
                    	    {
                    	    otherlv_4=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleDictLiteralExpCS1549); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getDictLiteralExpCSAccess().getCommaKeyword_3_1_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:692:1: ( (lv_ownedParts_5_0= ruleDictLiteralPartCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:693:1: (lv_ownedParts_5_0= ruleDictLiteralPartCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:693:1: (lv_ownedParts_5_0= ruleDictLiteralPartCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:694:3: lv_ownedParts_5_0= ruleDictLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getDictLiteralExpCSAccess().getOwnedPartsDictLiteralPartCSParserRuleCall_3_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleDictLiteralPartCS_in_ruleDictLiteralExpCS1570);
                    	    lv_ownedParts_5_0=ruleDictLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getDictLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_5_0, 
                    	              		"DictLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleDictLiteralExpCS1586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getDictLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDictLiteralExpCS"


    // $ANTLR start "entryRuleDictLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:722:1: entryRuleDictLiteralPartCS returns [EObject current=null] : iv_ruleDictLiteralPartCS= ruleDictLiteralPartCS EOF ;
    public final EObject entryRuleDictLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDictLiteralPartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:723:2: (iv_ruleDictLiteralPartCS= ruleDictLiteralPartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:724:2: iv_ruleDictLiteralPartCS= ruleDictLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDictLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDictLiteralPartCS_in_entryRuleDictLiteralPartCS1622);
            iv_ruleDictLiteralPartCS=ruleDictLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDictLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDictLiteralPartCS1632); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDictLiteralPartCS"


    // $ANTLR start "ruleDictLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:731:1: ruleDictLiteralPartCS returns [EObject current=null] : ( ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleDictLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_key_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:734:28: ( ( ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:735:1: ( ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:735:1: ( ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:735:2: ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:735:2: ( (lv_key_0_0= rulePrimitiveLiteralExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:736:1: (lv_key_0_0= rulePrimitiveLiteralExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:736:1: (lv_key_0_0= rulePrimitiveLiteralExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:737:3: lv_key_0_0= rulePrimitiveLiteralExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDictLiteralPartCSAccess().getKeyPrimitiveLiteralExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_ruleDictLiteralPartCS1678);
            lv_key_0_0=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDictLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"key",
                      		lv_key_0_0, 
                      		"PrimitiveLiteralExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleDictLiteralPartCS1690); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getDictLiteralPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:757:1: ( (lv_value_2_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:758:1: (lv_value_2_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:758:1: (lv_value_2_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:759:3: lv_value_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDictLiteralPartCSAccess().getValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleDictLiteralPartCS1711);
            lv_value_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDictLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"value",
                      		lv_value_2_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDictLiteralPartCS"


    // $ANTLR start "entryRuleReturnExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:783:1: entryRuleReturnExpCS returns [EObject current=null] : iv_ruleReturnExpCS= ruleReturnExpCS EOF ;
    public final EObject entryRuleReturnExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:784:2: (iv_ruleReturnExpCS= ruleReturnExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:785:2: iv_ruleReturnExpCS= ruleReturnExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleReturnExpCS_in_entryRuleReturnExpCS1747);
            iv_ruleReturnExpCS=ruleReturnExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturnExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReturnExpCS1757); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturnExpCS"


    // $ANTLR start "ruleReturnExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:792:1: ruleReturnExpCS returns [EObject current=null] : (otherlv_0= 'return' () ( (lv_value_2_0= ruleExpCS ) )? ) ;
    public final EObject ruleReturnExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:795:28: ( (otherlv_0= 'return' () ( (lv_value_2_0= ruleExpCS ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:796:1: (otherlv_0= 'return' () ( (lv_value_2_0= ruleExpCS ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:796:1: (otherlv_0= 'return' () ( (lv_value_2_0= ruleExpCS ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:796:3: otherlv_0= 'return' () ( (lv_value_2_0= ruleExpCS ) )?
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleReturnExpCS1794); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getReturnExpCSAccess().getReturnKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:800:1: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:801:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReturnExpCSAccess().getReturnExpCSAction_1(),
                          current);
                  
            }

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:809:2: ( (lv_value_2_0= ruleExpCS ) )?
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:810:1: (lv_value_2_0= ruleExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:810:1: (lv_value_2_0= ruleExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:811:3: lv_value_2_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReturnExpCSAccess().getValueExpCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleReturnExpCS1827);
                    lv_value_2_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReturnExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_2_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturnExpCS"


    // $ANTLR start "entryRuleStringLiteral"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:837:1: entryRuleStringLiteral returns [String current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final String entryRuleStringLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStringLiteral = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:838:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:839:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1867);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteral1878); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:846:1: ruleStringLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) ;
    public final AntlrDatatypeRuleToken ruleStringLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;
        Token this_DOUBLE_QUOTED_STRING_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:849:28: ( (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:850:1: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:850:1: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING | this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_DOUBLE_QUOTED_STRING) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:850:6: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
                    {
                    this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral1918); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SINGLE_QUOTED_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getStringLiteralAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:858:10: this_DOUBLE_QUOTED_STRING_1= RULE_DOUBLE_QUOTED_STRING
                    {
                    this_DOUBLE_QUOTED_STRING_1=(Token)match(input,RULE_DOUBLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleStringLiteral1944); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_DOUBLE_QUOTED_STRING_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DOUBLE_QUOTED_STRING_1, grammarAccess.getStringLiteralAccess().getDOUBLE_QUOTED_STRINGTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleEssentialOCLUnaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:877:1: entryRuleEssentialOCLUnaryOperatorName returns [String current=null] : iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF ;
    public final String entryRuleEssentialOCLUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnaryOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:878:2: (iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:879:2: iv_ruleEssentialOCLUnaryOperatorName= ruleEssentialOCLUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorName_in_entryRuleEssentialOCLUnaryOperatorName1994);
            iv_ruleEssentialOCLUnaryOperatorName=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorName2005); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnaryOperatorName"


    // $ANTLR start "ruleEssentialOCLUnaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:886:1: ruleEssentialOCLUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:889:28: ( (kw= '-' | kw= 'not' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:890:1: (kw= '-' | kw= 'not' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:890:1: (kw= '-' | kw= 'not' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==34) ) {
                alt9=1;
            }
            else if ( (LA9_0==35) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:891:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLUnaryOperatorName2043); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:898:2: kw= 'not'
                    {
                    kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEssentialOCLUnaryOperatorName2062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnaryOperatorNameAccess().getNotKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:911:1: entryRuleEssentialOCLInfixOperatorName returns [String current=null] : iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF ;
    public final String entryRuleEssentialOCLInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLInfixOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:912:2: (iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:913:2: iv_ruleEssentialOCLInfixOperatorName= ruleEssentialOCLInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorName_in_entryRuleEssentialOCLInfixOperatorName2103);
            iv_ruleEssentialOCLInfixOperatorName=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorName2114); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorName"


    // $ANTLR start "ruleEssentialOCLInfixOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:920:1: ruleEssentialOCLInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:923:28: ( (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:924:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:924:1: (kw= '*' | kw= '/' | kw= '+' | kw= '-' | kw= '>' | kw= '<' | kw= '>=' | kw= '<=' | kw= '=' | kw= '<>' | kw= 'and' | kw= 'or' | kw= 'xor' | kw= 'implies' )
            int alt10=14;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt10=1;
                }
                break;
            case 37:
                {
                alt10=2;
                }
                break;
            case 38:
                {
                alt10=3;
                }
                break;
            case 34:
                {
                alt10=4;
                }
                break;
            case 39:
                {
                alt10=5;
                }
                break;
            case 40:
                {
                alt10=6;
                }
                break;
            case 41:
                {
                alt10=7;
                }
                break;
            case 42:
                {
                alt10=8;
                }
                break;
            case 32:
                {
                alt10=9;
                }
                break;
            case 43:
                {
                alt10=10;
                }
                break;
            case 44:
                {
                alt10=11;
                }
                break;
            case 45:
                {
                alt10=12;
                }
                break;
            case 46:
                {
                alt10=13;
                }
                break;
            case 47:
                {
                alt10=14;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:925:2: kw= '*'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEssentialOCLInfixOperatorName2152); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAsteriskKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:932:2: kw= '/'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEssentialOCLInfixOperatorName2171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getSolidusKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:939:2: kw= '+'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEssentialOCLInfixOperatorName2190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getPlusSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:946:2: kw= '-'
                    {
                    kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEssentialOCLInfixOperatorName2209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getHyphenMinusKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:953:2: kw= '>'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleEssentialOCLInfixOperatorName2228); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:960:2: kw= '<'
                    {
                    kw=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleEssentialOCLInfixOperatorName2247); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:967:2: kw= '>='
                    {
                    kw=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleEssentialOCLInfixOperatorName2266); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getGreaterThanSignEqualsSignKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:974:2: kw= '<='
                    {
                    kw=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleEssentialOCLInfixOperatorName2285); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignEqualsSignKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:981:2: kw= '='
                    {
                    kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleEssentialOCLInfixOperatorName2304); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getEqualsSignKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:988:2: kw= '<>'
                    {
                    kw=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleEssentialOCLInfixOperatorName2323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getLessThanSignGreaterThanSignKeyword_9()); 
                          
                    }

                    }
                    break;
                case 11 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:995:2: kw= 'and'
                    {
                    kw=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleEssentialOCLInfixOperatorName2342); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getAndKeyword_10()); 
                          
                    }

                    }
                    break;
                case 12 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1002:2: kw= 'or'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleEssentialOCLInfixOperatorName2361); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getOrKeyword_11()); 
                          
                    }

                    }
                    break;
                case 13 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1009:2: kw= 'xor'
                    {
                    kw=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleEssentialOCLInfixOperatorName2380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getXorKeyword_12()); 
                          
                    }

                    }
                    break;
                case 14 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1016:2: kw= 'implies'
                    {
                    kw=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleEssentialOCLInfixOperatorName2399); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLInfixOperatorNameAccess().getImpliesKeyword_13()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLInfixOperatorName"


    // $ANTLR start "entryRuleEssentialOCLNavigationOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1029:1: entryRuleEssentialOCLNavigationOperatorName returns [String current=null] : iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF ;
    public final String entryRuleEssentialOCLNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLNavigationOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1030:2: (iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1031:2: iv_ruleEssentialOCLNavigationOperatorName= ruleEssentialOCLNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorName_in_entryRuleEssentialOCLNavigationOperatorName2440);
            iv_ruleEssentialOCLNavigationOperatorName=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorName2451); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLNavigationOperatorName"


    // $ANTLR start "ruleEssentialOCLNavigationOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1038:1: ruleEssentialOCLNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1041:28: ( (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1042:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1042:1: (kw= '.' | kw= '->' | kw= '?.' | kw= '?->' )
            int alt11=4;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt11=1;
                }
                break;
            case 49:
                {
                alt11=2;
                }
                break;
            case 50:
                {
                alt11=3;
                }
                break;
            case 51:
                {
                alt11=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1043:2: kw= '.'
                    {
                    kw=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleEssentialOCLNavigationOperatorName2489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getFullStopKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1050:2: kw= '->'
                    {
                    kw=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleEssentialOCLNavigationOperatorName2508); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1057:2: kw= '?.'
                    {
                    kw=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleEssentialOCLNavigationOperatorName2527); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkFullStopKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1064:2: kw= '?->'
                    {
                    kw=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleEssentialOCLNavigationOperatorName2546); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLNavigationOperatorNameAccess().getQuestionMarkHyphenMinusGreaterThanSignKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLNavigationOperatorName"


    // $ANTLR start "entryRuleBinaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1077:1: entryRuleBinaryOperatorName returns [String current=null] : iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF ;
    public final String entryRuleBinaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1078:2: (iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1079:2: iv_ruleBinaryOperatorName= ruleBinaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_entryRuleBinaryOperatorName2587);
            iv_ruleBinaryOperatorName=ruleBinaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperatorName2598); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOperatorName"


    // $ANTLR start "ruleBinaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1086:1: ruleBinaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_InfixOperatorName_0 = null;

        AntlrDatatypeRuleToken this_NavigationOperatorName_1 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1089:28: ( (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1090:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1090:1: (this_InfixOperatorName_0= ruleInfixOperatorName | this_NavigationOperatorName_1= ruleNavigationOperatorName )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32||LA12_0==34||(LA12_0>=36 && LA12_0<=47)) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=48 && LA12_0<=51)) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1091:5: this_InfixOperatorName_0= ruleInfixOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getInfixOperatorNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorName_in_ruleBinaryOperatorName2645);
                    this_InfixOperatorName_0=ruleInfixOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_InfixOperatorName_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1103:5: this_NavigationOperatorName_1= ruleNavigationOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getBinaryOperatorNameAccess().getNavigationOperatorNameParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorName_in_ruleBinaryOperatorName2678);
                    this_NavigationOperatorName_1=ruleNavigationOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_NavigationOperatorName_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperatorName"


    // $ANTLR start "entryRuleInfixOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1121:1: entryRuleInfixOperatorName returns [String current=null] : iv_ruleInfixOperatorName= ruleInfixOperatorName EOF ;
    public final String entryRuleInfixOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInfixOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1122:2: (iv_ruleInfixOperatorName= ruleInfixOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1123:2: iv_ruleInfixOperatorName= ruleInfixOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfixOperatorName_in_entryRuleInfixOperatorName2724);
            iv_ruleInfixOperatorName=ruleInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfixOperatorName2735); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOperatorName"


    // $ANTLR start "ruleInfixOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1130:1: ruleInfixOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName ;
    public final AntlrDatatypeRuleToken ruleInfixOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLInfixOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1133:28: (this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1135:5: this_EssentialOCLInfixOperatorName_0= ruleEssentialOCLInfixOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInfixOperatorNameAccess().getEssentialOCLInfixOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLInfixOperatorName_in_ruleInfixOperatorName2781);
            this_EssentialOCLInfixOperatorName_0=ruleEssentialOCLInfixOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLInfixOperatorName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOperatorName"


    // $ANTLR start "entryRuleNavigationOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1153:1: entryRuleNavigationOperatorName returns [String current=null] : iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF ;
    public final String entryRuleNavigationOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1154:2: (iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1155:2: iv_ruleNavigationOperatorName= ruleNavigationOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigationOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigationOperatorName_in_entryRuleNavigationOperatorName2826);
            iv_ruleNavigationOperatorName=ruleNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigationOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigationOperatorName2837); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperatorName"


    // $ANTLR start "ruleNavigationOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1162:1: ruleNavigationOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName ;
    public final AntlrDatatypeRuleToken ruleNavigationOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLNavigationOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1165:28: (this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1167:5: this_EssentialOCLNavigationOperatorName_0= ruleEssentialOCLNavigationOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigationOperatorNameAccess().getEssentialOCLNavigationOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLNavigationOperatorName_in_ruleNavigationOperatorName2883);
            this_EssentialOCLNavigationOperatorName_0=ruleEssentialOCLNavigationOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLNavigationOperatorName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOperatorName"


    // $ANTLR start "entryRuleUnaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1185:1: entryRuleUnaryOperatorName returns [String current=null] : iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF ;
    public final String entryRuleUnaryOperatorName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperatorName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1186:2: (iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1187:2: iv_ruleUnaryOperatorName= ruleUnaryOperatorName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOperatorNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_entryRuleUnaryOperatorName2928);
            iv_ruleUnaryOperatorName=ruleUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOperatorName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnaryOperatorName2939); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperatorName"


    // $ANTLR start "ruleUnaryOperatorName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1194:1: ruleUnaryOperatorName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName ;
    public final AntlrDatatypeRuleToken ruleUnaryOperatorName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnaryOperatorName_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1197:28: (this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1199:5: this_EssentialOCLUnaryOperatorName_0= ruleEssentialOCLUnaryOperatorName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryOperatorNameAccess().getEssentialOCLUnaryOperatorNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnaryOperatorName_in_ruleUnaryOperatorName2985);
            this_EssentialOCLUnaryOperatorName_0=ruleEssentialOCLUnaryOperatorName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnaryOperatorName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperatorName"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1217:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1218:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1219:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3030);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3041); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedName"


    // $ANTLR start "ruleEssentialOCLUnrestrictedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1226:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1229:28: (this_Identifier_0= ruleIdentifier )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1231:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3087);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Identifier_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1249:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1250:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1251:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3132);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnrestrictedName3143); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1258:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1261:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1263:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3189);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnrestrictedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1281:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1282:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1283:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3234);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3245); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnreservedName"


    // $ANTLR start "ruleEssentialOCLUnreservedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1290:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1293:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1294:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1294:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Map' | kw= 'Tuple' )
            int alt13=5;
            switch ( input.LA(1) ) {
            case RULE_SIMPLE_ID:
            case RULE_ESCAPED_ID:
                {
                alt13=1;
                }
                break;
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
                {
                alt13=2;
                }
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt13=3;
                }
                break;
            case 52:
                {
                alt13=4;
                }
                break;
            case 53:
                {
                alt13=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1295:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3292);
                    this_UnrestrictedName_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UnrestrictedName_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1307:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3325);
                    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CollectionTypeIdentifier_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1319:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3358);
                    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PrimitiveTypeIdentifier_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1331:2: kw= 'Map'
                    {
                    kw=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleEssentialOCLUnreservedName3382); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getMapKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1338:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleEssentialOCLUnreservedName3401); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRuleUnreservedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1351:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1352:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1353:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName3442);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnreservedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnreservedName3453); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1360:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1363:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1365:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName3499);
            this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnreservedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleURIFirstPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1385:1: entryRuleURIFirstPathElementCS returns [EObject current=null] : iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF ;
    public final EObject entryRuleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURIFirstPathElementCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1386:2: (iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1387:2: iv_ruleURIFirstPathElementCS= ruleURIFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS3545);
            iv_ruleURIFirstPathElementCS=ruleURIFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURIFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURIFirstPathElementCS3555); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURIFirstPathElementCS"


    // $ANTLR start "ruleURIFirstPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1394:1: ruleURIFirstPathElementCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) ;
    public final EObject ruleURIFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1397:28: ( ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1398:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1398:1: ( ( ( ruleUnrestrictedName ) ) | ( () ( ( ruleURI ) ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_SIMPLE_ID && LA14_0<=RULE_ESCAPED_ID)) ) {
                alt14=1;
            }
            else if ( (LA14_0==RULE_SINGLE_QUOTED_STRING) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1398:2: ( ( ruleUnrestrictedName ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1398:2: ( ( ruleUnrestrictedName ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1399:1: ( ruleUnrestrictedName )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1399:1: ( ruleUnrestrictedName )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1400:3: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS3607);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1417:6: ( () ( ( ruleURI ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1417:6: ( () ( ( ruleURI ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1417:7: () ( ( ruleURI ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1417:7: ()
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1418:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getURIFirstPathElementCSAccess().getPathElementWithURICSAction_1_0(),
                                  current);
                          
                    }

                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1426:2: ( ( ruleURI ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1427:1: ( ruleURI )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1427:1: ( ruleURI )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1428:3: ruleURI
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getURIFirstPathElementCSRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getURIFirstPathElementCSAccess().getReferredElementNamespaceCrossReference_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleURI_in_ruleURIFirstPathElementCS3653);
                    ruleURI();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURIFirstPathElementCS"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1452:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1453:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1454:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier3691);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier3702); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1461:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1464:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1465:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1465:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt15=8;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt15=1;
                }
                break;
            case 55:
                {
                alt15=2;
                }
                break;
            case 56:
                {
                alt15=3;
                }
                break;
            case 57:
                {
                alt15=4;
                }
                break;
            case 58:
                {
                alt15=5;
                }
                break;
            case 59:
                {
                alt15=6;
                }
                break;
            case 60:
                {
                alt15=7;
                }
                break;
            case 61:
                {
                alt15=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1466:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,54,FollowSets000.FOLLOW_54_in_rulePrimitiveTypeIdentifier3740); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1473:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,55,FollowSets000.FOLLOW_55_in_rulePrimitiveTypeIdentifier3759); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1480:2: kw= 'Real'
                    {
                    kw=(Token)match(input,56,FollowSets000.FOLLOW_56_in_rulePrimitiveTypeIdentifier3778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1487:2: kw= 'String'
                    {
                    kw=(Token)match(input,57,FollowSets000.FOLLOW_57_in_rulePrimitiveTypeIdentifier3797); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1494:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,58,FollowSets000.FOLLOW_58_in_rulePrimitiveTypeIdentifier3816); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1501:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,59,FollowSets000.FOLLOW_59_in_rulePrimitiveTypeIdentifier3835); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1508:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,60,FollowSets000.FOLLOW_60_in_rulePrimitiveTypeIdentifier3854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1515:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,61,FollowSets000.FOLLOW_61_in_rulePrimitiveTypeIdentifier3873); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRulePrimitiveTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1528:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1529:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1530:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS3913);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveTypeCS3923); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeCS"


    // $ANTLR start "rulePrimitiveTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1537:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1540:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1541:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1541:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1542:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1542:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1543:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS3968);
            lv_name_0_0=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"PrimitiveTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeCS"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1567:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1568:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1569:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier4004);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier4015); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1576:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1579:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1580:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1580:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 62:
                {
                alt16=1;
                }
                break;
            case 63:
                {
                alt16=2;
                }
                break;
            case 64:
                {
                alt16=3;
                }
                break;
            case 65:
                {
                alt16=4;
                }
                break;
            case 66:
                {
                alt16=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1581:2: kw= 'Set'
                    {
                    kw=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleCollectionTypeIdentifier4053); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1588:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleCollectionTypeIdentifier4072); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1595:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCollectionTypeIdentifier4091); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1602:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleCollectionTypeIdentifier4110); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1609:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleCollectionTypeIdentifier4129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1622:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1623:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1624:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS4169);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionTypeCS4179); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeCS"


    // $ANTLR start "ruleCollectionTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1631:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1634:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1635:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1635:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1635:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1635:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1636:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1636:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1637:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS4225);
            lv_name_0_0=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"CollectionTypeIdentifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1653:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1653:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCollectionTypeCS4238); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1657:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1658:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1658:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1659:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS4259);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCollectionTypeCS4271); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleMapTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1687:1: entryRuleMapTypeCS returns [EObject current=null] : iv_ruleMapTypeCS= ruleMapTypeCS EOF ;
    public final EObject entryRuleMapTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1688:2: (iv_ruleMapTypeCS= ruleMapTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1689:2: iv_ruleMapTypeCS= ruleMapTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS4309);
            iv_ruleMapTypeCS=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapTypeCS4319); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapTypeCS"


    // $ANTLR start "ruleMapTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1696:1: ruleMapTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) ;
    public final EObject ruleMapTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedKeyType_2_0 = null;

        EObject lv_ownedValueType_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1699:28: ( ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1700:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1700:1: ( ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1700:2: ( (lv_name_0_0= 'Map' ) ) (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1700:2: ( (lv_name_0_0= 'Map' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1701:1: (lv_name_0_0= 'Map' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1701:1: (lv_name_0_0= 'Map' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1702:3: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleMapTypeCS4362); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getMapTypeCSAccess().getNameMapKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMapTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Map");
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1715:2: (otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1715:4: otherlv_1= '(' ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) ) otherlv_3= ',' ( (lv_ownedValueType_4_0= ruleTypeExpCS ) ) otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleMapTypeCS4388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMapTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1719:1: ( (lv_ownedKeyType_2_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1720:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1720:1: (lv_ownedKeyType_2_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1721:3: lv_ownedKeyType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedKeyTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS4409);
                    lv_ownedKeyType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedKeyType",
                              		lv_ownedKeyType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMapTypeCS4421); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMapTypeCSAccess().getCommaKeyword_1_2());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1741:1: ( (lv_ownedValueType_4_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1742:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1742:1: (lv_ownedValueType_4_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1743:3: lv_ownedValueType_4_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapTypeCSAccess().getOwnedValueTypeTypeExpCSParserRuleCall_1_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS4442);
                    lv_ownedValueType_4_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapTypeCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedValueType",
                              		lv_ownedValueType_4_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleMapTypeCS4454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getMapTypeCSAccess().getRightParenthesisKeyword_1_4());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapTypeCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1771:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1772:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1773:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS4492);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleTypeCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleTypeCS4502); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleTypeCS"


    // $ANTLR start "ruleTupleTypeCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1780:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
    public final EObject ruleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1783:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1784:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1784:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1784:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1784:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1785:1: (lv_name_0_0= 'Tuple' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1785:1: (lv_name_0_0= 'Tuple' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1786:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleTypeCS4545); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTupleTypeCSRule());
              	        }
                     		setWithLastConsumed(current, "name", lv_name_0_0, "Tuple");
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1799:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==26) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1799:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTupleTypeCS4571); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1803:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( ((LA20_0>=RULE_SIMPLE_ID && LA20_0<=RULE_ESCAPED_ID)) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1803:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1803:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1804:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1804:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1805:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS4593);
                            lv_ownedParts_2_0=ruleTuplePartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedParts",
                                      		lv_ownedParts_2_0, 
                                      		"TuplePartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1821:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop19:
                            do {
                                int alt19=2;
                                int LA19_0 = input.LA(1);

                                if ( (LA19_0==29) ) {
                                    alt19=1;
                                }


                                switch (alt19) {
                            	case 1 :
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1821:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleTypeCS4606); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	          
                            	    }
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1825:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1826:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1826:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1827:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS4627);
                            	    lv_ownedParts_4_0=ruleTuplePartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedParts",
                            	              		lv_ownedParts_4_0, 
                            	              		"TuplePartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop19;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTupleTypeCS4643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleTypeCS"


    // $ANTLR start "entryRuleTuplePartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1855:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1856:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1857:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS4681);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTuplePartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTuplePartCS4691); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTuplePartCS"


    // $ANTLR start "ruleTuplePartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1864:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1867:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1868:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1868:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1868:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1868:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1869:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1869:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1870:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS4737);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleTuplePartCS4749); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1890:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1891:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1891:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1892:3: lv_ownedType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS4770);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTuplePartCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1916:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1917:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1918:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS4806);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS4816); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionLiteralExpCS"


    // $ANTLR start "ruleCollectionLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1925:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1928:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1929:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1929:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1929:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1929:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1930:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1930:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1931:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS4862);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCollectionLiteralExpCS4874); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1951:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( ((LA23_0>=RULE_SINGLE_QUOTED_STRING && LA23_0<=RULE_INT)||(LA23_0>=25 && LA23_0<=26)||LA23_0==28||(LA23_0>=33 && LA23_0<=36)||(LA23_0>=52 && LA23_0<=67)||LA23_0==70||(LA23_0>=72 && LA23_0<=75)||LA23_0==83||(LA23_0>=88 && LA23_0<=89)) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1951:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1951:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1952:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1952:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1953:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS4896);
                    lv_ownedParts_2_0=ruleCollectionLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"CollectionLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1969:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==29) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1969:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionLiteralExpCS4909); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1973:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1974:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1974:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:1975:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS4930);
                    	    lv_ownedParts_4_0=ruleCollectionLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"CollectionLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCollectionLiteralExpCS4946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2003:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2004:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2005:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS4982);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS4992); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionLiteralPartCS"


    // $ANTLR start "ruleCollectionLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2012:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedLastExpression_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2015:28: ( ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:1: ( ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? ) | ( (lv_ownedExpression_3_0= rulePatternExpCS ) ) )
            int alt25=2;
            switch ( input.LA(1) ) {
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_DOUBLE_QUOTED_STRING:
            case RULE_INT:
            case 25:
            case 26:
            case 28:
            case 33:
            case 34:
            case 35:
            case 36:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 83:
            case 88:
            case 89:
                {
                alt25=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==67) ) {
                    alt25=2;
                }
                else if ( (LA25_2==EOF||LA25_2==26||(LA25_2>=29 && LA25_2<=32)||LA25_2==34||(LA25_2>=36 && LA25_2<=51)||LA25_2==68||LA25_2==76||LA25_2==78||LA25_2==93) ) {
                    alt25=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA25_3 = input.LA(2);

                if ( (LA25_3==67) ) {
                    alt25=2;
                }
                else if ( (LA25_3==EOF||LA25_3==26||(LA25_3>=29 && LA25_3<=32)||LA25_3==34||(LA25_3>=36 && LA25_3<=51)||LA25_3==68||LA25_3==76||LA25_3==78||LA25_3==93) ) {
                    alt25=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 3, input);

                    throw nvae;
                }
                }
                break;
            case 67:
                {
                alt25=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:2: ( ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )? )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:3: ( (lv_ownedExpression_0_0= ruleExpCS ) ) (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2016:3: ( (lv_ownedExpression_0_0= ruleExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2017:1: (lv_ownedExpression_0_0= ruleExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2017:1: (lv_ownedExpression_0_0= ruleExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2018:3: lv_ownedExpression_0_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5039);
                    lv_ownedExpression_0_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_0_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2034:2: (otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==68) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2034:4: otherlv_1= '..' ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            {
                            otherlv_1=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCollectionLiteralPartCS5052); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_0_1_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2038:1: ( (lv_ownedLastExpression_2_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2039:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2039:1: (lv_ownedLastExpression_2_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2040:3: lv_ownedLastExpression_2_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedLastExpressionExpCSParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5073);
                            lv_ownedLastExpression_2_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedLastExpression",
                                      		lv_ownedLastExpression_2_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2057:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2057:6: ( (lv_ownedExpression_3_0= rulePatternExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2058:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2058:1: (lv_ownedExpression_3_0= rulePatternExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2059:3: lv_ownedExpression_3_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getOwnedExpressionPatternExpCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS5103);
                    lv_ownedExpression_3_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExpression",
                              		lv_ownedExpression_3_0, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleCollectionPatternCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2083:1: entryRuleCollectionPatternCS returns [EObject current=null] : iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF ;
    public final EObject entryRuleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionPatternCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2084:2: (iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2085:2: iv_ruleCollectionPatternCS= ruleCollectionPatternCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionPatternCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS5139);
            iv_ruleCollectionPatternCS=ruleCollectionPatternCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionPatternCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCollectionPatternCS5149); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionPatternCS"


    // $ANTLR start "ruleCollectionPatternCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2092:1: ruleCollectionPatternCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) ;
    public final EObject ruleCollectionPatternCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_restVariableName_6_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2095:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2096:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2096:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2096:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )? otherlv_7= '}'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2096:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2097:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2097:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2098:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS5195);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"CollectionTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCollectionPatternCS5207); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCollectionPatternCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2118:1: ( ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( ((LA27_0>=RULE_SIMPLE_ID && LA27_0<=RULE_ESCAPED_ID)||LA27_0==67) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2118:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )* (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2118:2: ( (lv_ownedParts_2_0= rulePatternExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2119:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2119:1: (lv_ownedParts_2_0= rulePatternExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2120:3: lv_ownedParts_2_0= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS5229);
                    lv_ownedParts_2_0=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2136:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==29) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2136:4: otherlv_3= ',' ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCollectionPatternCS5242); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getCollectionPatternCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2140:1: ( (lv_ownedParts_4_0= rulePatternExpCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2141:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2141:1: (lv_ownedParts_4_0= rulePatternExpCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2142:3: lv_ownedParts_4_0= rulePatternExpCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getOwnedPartsPatternExpCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS5263);
                    	    lv_ownedParts_4_0=rulePatternExpCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"PatternExpCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2158:4: (otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2158:6: otherlv_5= '++' ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    {
                    otherlv_5=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCollectionPatternCS5278); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getCollectionPatternCSAccess().getPlusSignPlusSignKeyword_2_2_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2162:1: ( (lv_restVariableName_6_0= ruleIdentifier ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2163:1: (lv_restVariableName_6_0= ruleIdentifier )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2163:1: (lv_restVariableName_6_0= ruleIdentifier )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2164:3: lv_restVariableName_6_0= ruleIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCollectionPatternCSAccess().getRestVariableNameIdentifierParserRuleCall_2_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS5299);
                    lv_restVariableName_6_0=ruleIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCollectionPatternCSRule());
                      	        }
                             		set(
                             			current, 
                             			"restVariableName",
                              		lv_restVariableName_6_0, 
                              		"Identifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCollectionPatternCS5314); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getCollectionPatternCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionPatternCS"


    // $ANTLR start "entryRuleShadowPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2192:1: entryRuleShadowPartCS returns [EObject current=null] : iv_ruleShadowPartCS= ruleShadowPartCS EOF ;
    public final EObject entryRuleShadowPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShadowPartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2193:2: (iv_ruleShadowPartCS= ruleShadowPartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2194:2: iv_ruleShadowPartCS= ruleShadowPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShadowPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS5350);
            iv_ruleShadowPartCS=ruleShadowPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShadowPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleShadowPartCS5360); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShadowPartCS"


    // $ANTLR start "ruleShadowPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2201:1: ruleShadowPartCS returns [EObject current=null] : ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) ;
    public final EObject ruleShadowPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedInitExpression_2_1 = null;

        EObject lv_ownedInitExpression_2_2 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2204:28: ( ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2205:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2205:1: ( ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2205:2: ( ( ruleUnrestrictedName ) ) otherlv_1= '=' ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2205:2: ( ( ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2206:1: ( ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2206:1: ( ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2207:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getShadowPartCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getReferredPropertyPropertyCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS5412);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleShadowPartCS5424); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getShadowPartCSAccess().getEqualsSignKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2227:1: ( ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2228:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2228:1: ( (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2229:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2229:1: (lv_ownedInitExpression_2_1= ruleExpCS | lv_ownedInitExpression_2_2= rulePatternExpCS )
            int alt28=2;
            switch ( input.LA(1) ) {
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_DOUBLE_QUOTED_STRING:
            case RULE_INT:
            case 25:
            case 26:
            case 28:
            case 33:
            case 34:
            case 35:
            case 36:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 83:
            case 88:
            case 89:
                {
                alt28=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==EOF||LA28_2==26||(LA28_2>=29 && LA28_2<=32)||LA28_2==34||(LA28_2>=36 && LA28_2<=51)||LA28_2==76||LA28_2==78||LA28_2==93) ) {
                    alt28=1;
                }
                else if ( (LA28_2==67) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA28_3 = input.LA(2);

                if ( (LA28_3==67) ) {
                    alt28=2;
                }
                else if ( (LA28_3==EOF||LA28_3==26||(LA28_3>=29 && LA28_3<=32)||LA28_3==34||(LA28_3>=36 && LA28_3<=51)||LA28_3==76||LA28_3==78||LA28_3==93) ) {
                    alt28=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 3, input);

                    throw nvae;
                }
                }
                break;
            case 67:
                {
                alt28=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2230:3: lv_ownedInitExpression_2_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleShadowPartCS5447);
                    lv_ownedInitExpression_2_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_1, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2245:8: lv_ownedInitExpression_2_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getShadowPartCSAccess().getOwnedInitExpressionPatternExpCSParserRuleCall_2_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleShadowPartCS5466);
                    lv_ownedInitExpression_2_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getShadowPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_2_2, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShadowPartCS"


    // $ANTLR start "entryRulePatternExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2271:1: entryRulePatternExpCS returns [EObject current=null] : iv_rulePatternExpCS= rulePatternExpCS EOF ;
    public final EObject entryRulePatternExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePatternExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2272:2: (iv_rulePatternExpCS= rulePatternExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2273:2: iv_rulePatternExpCS= rulePatternExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS5505);
            iv_rulePatternExpCS=rulePatternExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePatternExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePatternExpCS5515); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePatternExpCS"


    // $ANTLR start "rulePatternExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2280:1: rulePatternExpCS returns [EObject current=null] : ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject rulePatternExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_patternVariableName_0_0 = null;

        EObject lv_ownedPatternType_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2283:28: ( ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2284:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2284:1: ( ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2284:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )? otherlv_1= ':' ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2284:2: ( (lv_patternVariableName_0_0= ruleUnrestrictedName ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_SIMPLE_ID && LA29_0<=RULE_ESCAPED_ID)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2285:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2285:1: (lv_patternVariableName_0_0= ruleUnrestrictedName )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2286:3: lv_patternVariableName_0_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getPatternVariableNameUnrestrictedNameParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS5561);
                    lv_patternVariableName_0_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"patternVariableName",
                              		lv_patternVariableName_0_0, 
                              		"UnrestrictedName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_rulePatternExpCS5574); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getPatternExpCSAccess().getColonKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2306:1: ( (lv_ownedPatternType_2_0= ruleTypeExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2307:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2307:1: (lv_ownedPatternType_2_0= ruleTypeExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2308:3: lv_ownedPatternType_2_0= ruleTypeExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPatternExpCSAccess().getOwnedPatternTypeTypeExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_rulePatternExpCS5595);
            lv_ownedPatternType_2_0=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPatternExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPatternType",
                      		lv_ownedPatternType_2_0, 
                      		"TypeExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePatternExpCS"


    // $ANTLR start "entryRuleLambdaLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2332:1: entryRuleLambdaLiteralExpCS returns [EObject current=null] : iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF ;
    public final EObject entryRuleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2333:2: (iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2334:2: iv_ruleLambdaLiteralExpCS= ruleLambdaLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS5631);
            iv_ruleLambdaLiteralExpCS=ruleLambdaLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS5641); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaLiteralExpCS"


    // $ANTLR start "ruleLambdaLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2341:1: ruleLambdaLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) ;
    public final EObject ruleLambdaLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2344:28: ( (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2345:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2345:1: (otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2345:3: otherlv_0= 'Lambda' otherlv_1= '{' ( (lv_ownedExpressionCS_2_0= ruleExpCS ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleLambdaLiteralExpCS5678); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLambdaLiteralExpCSAccess().getLambdaKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleLambdaLiteralExpCS5690); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLambdaLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2353:1: ( (lv_ownedExpressionCS_2_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2354:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2354:1: (lv_ownedExpressionCS_2_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2355:3: lv_ownedExpressionCS_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLambdaLiteralExpCSAccess().getOwnedExpressionCSExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS5711);
            lv_ownedExpressionCS_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLambdaLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpressionCS",
                      		lv_ownedExpressionCS_2_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLambdaLiteralExpCS5723); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLambdaLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambdaLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2383:1: entryRuleMapLiteralExpCS returns [EObject current=null] : iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF ;
    public final EObject entryRuleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2384:2: (iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2385:2: iv_ruleMapLiteralExpCS= ruleMapLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS5759);
            iv_ruleMapLiteralExpCS=ruleMapLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralExpCS5769); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralExpCS"


    // $ANTLR start "ruleMapLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2392:1: ruleMapLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleMapLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2395:28: ( ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2396:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2396:1: ( ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2396:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2396:2: ( (lv_ownedType_0_0= ruleMapTypeCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2397:1: (lv_ownedType_0_0= ruleMapTypeCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2397:1: (lv_ownedType_0_0= ruleMapTypeCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2398:3: lv_ownedType_0_0= ruleMapTypeCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedTypeMapTypeCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS5815);
            lv_ownedType_0_0=ruleMapTypeCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"MapTypeCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleMapLiteralExpCS5827); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2418:1: ( ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )* )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=RULE_SINGLE_QUOTED_STRING && LA31_0<=RULE_INT)||(LA31_0>=25 && LA31_0<=26)||LA31_0==28||(LA31_0>=33 && LA31_0<=36)||(LA31_0>=52 && LA31_0<=66)||LA31_0==70||(LA31_0>=72 && LA31_0<=75)||LA31_0==83||(LA31_0>=88 && LA31_0<=89)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2418:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2418:2: ( (lv_ownedParts_2_0= ruleMapLiteralPartCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2419:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2419:1: (lv_ownedParts_2_0= ruleMapLiteralPartCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2420:3: lv_ownedParts_2_0= ruleMapLiteralPartCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS5849);
                    lv_ownedParts_2_0=ruleMapLiteralPartCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedParts",
                              		lv_ownedParts_2_0, 
                              		"MapLiteralPartCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2436:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==29) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2436:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleMapLiteralExpCS5862); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getMapLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2440:1: ( (lv_ownedParts_4_0= ruleMapLiteralPartCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2441:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2441:1: (lv_ownedParts_4_0= ruleMapLiteralPartCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2442:3: lv_ownedParts_4_0= ruleMapLiteralPartCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getMapLiteralExpCSAccess().getOwnedPartsMapLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS5883);
                    	    lv_ownedParts_4_0=ruleMapLiteralPartCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getMapLiteralExpCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedParts",
                    	              		lv_ownedParts_4_0, 
                    	              		"MapLiteralPartCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMapLiteralExpCS5899); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMapLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteralExpCS"


    // $ANTLR start "entryRuleMapLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2470:1: entryRuleMapLiteralPartCS returns [EObject current=null] : iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF ;
    public final EObject entryRuleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapLiteralPartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2471:2: (iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2472:2: iv_ruleMapLiteralPartCS= ruleMapLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMapLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS5935);
            iv_ruleMapLiteralPartCS=ruleMapLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMapLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMapLiteralPartCS5945); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapLiteralPartCS"


    // $ANTLR start "ruleMapLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2479:1: ruleMapLiteralPartCS returns [EObject current=null] : ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) ;
    public final EObject ruleMapLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedKey_0_0 = null;

        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2482:28: ( ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2483:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2483:1: ( ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2483:2: ( (lv_ownedKey_0_0= ruleExpCS ) ) otherlv_1= '<-' ( (lv_ownedValue_2_0= ruleExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2483:2: ( (lv_ownedKey_0_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2484:1: (lv_ownedKey_0_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2484:1: (lv_ownedKey_0_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2485:3: lv_ownedKey_0_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedKeyExpCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5991);
            lv_ownedKey_0_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedKey",
                      		lv_ownedKey_0_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleMapLiteralPartCS6003); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMapLiteralPartCSAccess().getLessThanSignHyphenMinusKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2505:1: ( (lv_ownedValue_2_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2506:1: (lv_ownedValue_2_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2506:1: (lv_ownedValue_2_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2507:3: lv_ownedValue_2_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMapLiteralPartCSAccess().getOwnedValueExpCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS6024);
            lv_ownedValue_2_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMapLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedValue",
                      		lv_ownedValue_2_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapLiteralPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2531:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2532:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2533:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6060);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6070); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveLiteralExpCS"


    // $ANTLR start "rulePrimitiveLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2540:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
    public final EObject rulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExpCS_0 = null;

        EObject this_StringLiteralExpCS_1 = null;

        EObject this_BooleanLiteralExpCS_2 = null;

        EObject this_UnlimitedNaturalLiteralExpCS_3 = null;

        EObject this_InvalidLiteralExpCS_4 = null;

        EObject this_NullLiteralExpCS_5 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2543:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2544:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2544:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt32=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt32=1;
                }
                break;
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_DOUBLE_QUOTED_STRING:
                {
                alt32=2;
                }
                break;
            case 72:
            case 73:
                {
                alt32=3;
                }
                break;
            case 36:
                {
                alt32=4;
                }
                break;
            case 74:
                {
                alt32=5;
                }
                break;
            case 75:
                {
                alt32=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2545:2: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6120);
                    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NumberLiteralExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2558:2: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6150);
                    this_StringLiteralExpCS_1=ruleStringLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_StringLiteralExpCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2571:2: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6180);
                    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_BooleanLiteralExpCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2584:2: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6210);
                    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_UnlimitedNaturalLiteralExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2597:2: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6240);
                    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_InvalidLiteralExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2610:2: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6270);
                    this_NullLiteralExpCS_5=ruleNullLiteralExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_NullLiteralExpCS_5; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2629:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2630:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2631:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6305);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6315); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteralExpCS"


    // $ANTLR start "ruleTupleLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2638:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2641:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2642:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2642:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2642:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleTupleLiteralExpCS6352); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTupleLiteralExpCS6364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2650:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2651:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2651:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2652:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6385);
            lv_ownedParts_2_0=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedParts",
                      		lv_ownedParts_2_0, 
                      		"TupleLiteralPartCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2668:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==29) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2668:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTupleLiteralExpCS6398); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2672:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2673:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2673:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2674:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6419);
            	    lv_ownedParts_4_0=ruleTupleLiteralPartCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedParts",
            	              		lv_ownedParts_4_0, 
            	              		"TupleLiteralPartCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            otherlv_5=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTupleLiteralExpCS6433); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2702:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2703:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2704:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6469);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTupleLiteralPartCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6479); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleLiteralPartCS"


    // $ANTLR start "ruleTupleLiteralPartCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2711:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2714:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2715:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2715:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2715:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2715:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2716:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2716:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2717:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS6525);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2733:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==67) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2733:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleTupleLiteralPartCS6538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2737:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2738:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2738:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2739:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS6559);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_2_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleTupleLiteralPartCS6573); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2759:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2760:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2760:1: (lv_ownedInitExpression_4_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2761:3: lv_ownedInitExpression_4_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedInitExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS6594);
            lv_ownedInitExpression_4_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_4_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleLiteralPartCS"


    // $ANTLR start "entryRuleNumberLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2785:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2786:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2787:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS6630);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberLiteralExpCS6640); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteralExpCS"


    // $ANTLR start "ruleNumberLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2794:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_symbol_0_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2797:28: ( ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2798:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2798:1: ( (lv_symbol_0_0= ruleNUMBER_LITERAL ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2799:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2799:1: (lv_symbol_0_0= ruleNUMBER_LITERAL )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2800:3: lv_symbol_0_0= ruleNUMBER_LITERAL
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getSymbolNUMBER_LITERALParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS6685);
            lv_symbol_0_0=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"symbol",
                      		lv_symbol_0_0, 
                      		"NUMBER_LITERAL");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteralExpCS"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2824:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2825:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2826:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS6720);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringLiteralExpCS6730); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2833:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_segments_0_0= ruleStringLiteral ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_segments_0_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2836:28: ( ( (lv_segments_0_0= ruleStringLiteral ) )+ )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2837:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2837:1: ( (lv_segments_0_0= ruleStringLiteral ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=RULE_SINGLE_QUOTED_STRING && LA35_0<=RULE_DOUBLE_QUOTED_STRING)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2838:1: (lv_segments_0_0= ruleStringLiteral )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2838:1: (lv_segments_0_0= ruleStringLiteral )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2839:3: lv_segments_0_0= ruleStringLiteral
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStringLiteralExpCSAccess().getSegmentsStringLiteralParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS6775);
            	    lv_segments_0_0=ruleStringLiteral();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStringLiteralExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"segments",
            	              		lv_segments_0_0, 
            	              		"StringLiteral");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2863:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2864:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2865:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS6811);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS6821); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2872:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2875:28: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2876:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2876:1: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==72) ) {
                alt36=1;
            }
            else if ( (LA36_0==73) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2876:2: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2876:2: ( (lv_symbol_0_0= 'true' ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2877:1: (lv_symbol_0_0= 'true' )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2877:1: (lv_symbol_0_0= 'true' )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2878:3: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleBooleanLiteralExpCS6864); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolTrueKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_0_0, "true");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2892:6: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2892:6: ( (lv_symbol_1_0= 'false' ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2893:1: (lv_symbol_1_0= 'false' )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2893:1: (lv_symbol_1_0= 'false' )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2894:3: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleBooleanLiteralExpCS6901); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getSymbolFalseKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "symbol", lv_symbol_1_0, "false");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRuleUnlimitedNaturalLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2915:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2916:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2917:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS6950);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS6960); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "ruleUnlimitedNaturalLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2924:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2927:28: ( ( () otherlv_1= '*' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2928:1: ( () otherlv_1= '*' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2928:1: ( () otherlv_1= '*' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2928:2: () otherlv_1= '*'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2928:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2929:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUnlimitedNaturalLiteralExpCS7009); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "entryRuleInvalidLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2949:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2950:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2951:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7045);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInvalidLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7055); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvalidLiteralExpCS"


    // $ANTLR start "ruleInvalidLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2958:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2961:28: ( ( () otherlv_1= 'invalid' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2962:1: ( () otherlv_1= 'invalid' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2962:1: ( () otherlv_1= 'invalid' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2962:2: () otherlv_1= 'invalid'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2962:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2963:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleInvalidLiteralExpCS7104); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvalidLiteralExpCS"


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2983:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2984:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2985:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7140);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNullLiteralExpCS7150); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullLiteralExpCS"


    // $ANTLR start "ruleNullLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2992:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2995:28: ( ( () otherlv_1= 'null' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2996:1: ( () otherlv_1= 'null' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2996:1: ( () otherlv_1= 'null' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2996:2: () otherlv_1= 'null'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2996:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:2997:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleNullLiteralExpCS7199); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullLiteralExpCS"


    // $ANTLR start "entryRuleTypeLiteralWithMultiplicityCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3017:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3018:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3019:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7235);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralWithMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7245); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "ruleTypeLiteralWithMultiplicityCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3026:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_ownedMultiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3029:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3030:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3030:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3031:2: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7295);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypeLiteralCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3042:1: ( (lv_ownedMultiplicity_1_0= ruleMultiplicityCS ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==78) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3043:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3043:1: (lv_ownedMultiplicity_1_0= ruleMultiplicityCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3044:3: lv_ownedMultiplicity_1_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7315);
                    lv_ownedMultiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_1_0, 
                              		"MultiplicityCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3068:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3069:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3070:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7352);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeLiteralExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7362); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeLiteralExpCS"


    // $ANTLR start "ruleTypeLiteralExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3077:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3080:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3081:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3081:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3082:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3082:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3083:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS7407);
            lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedType",
                      		lv_ownedType_0_0, 
                      		"TypeLiteralWithMultiplicityCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeLiteralExpCS"


    // $ANTLR start "entryRuleTypeNameExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3107:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3108:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3109:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS7442);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeNameExpCS7452); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeNameExpCS"


    // $ANTLR start "ruleTypeNameExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3116:1: ruleTypeNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedCurlyBracketedClause_1_0 = null;

        EObject lv_ownedPatternGuard_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3119:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3120:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3120:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3120:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3120:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3121:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3121:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3122:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS7498);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3138:2: ( ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )? )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==30) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3138:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) ) (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3138:3: ( (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3139:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3139:1: (lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3140:3: lv_ownedCurlyBracketedClause_1_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS7520);
                    lv_ownedCurlyBracketedClause_1_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_1_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3156:2: (otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}' )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==30) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3156:4: otherlv_2= '{' ( (lv_ownedPatternGuard_3_0= ruleExpCS ) ) otherlv_4= '}'
                            {
                            otherlv_2=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleTypeNameExpCS7533); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_2, grammarAccess.getTypeNameExpCSAccess().getLeftCurlyBracketKeyword_1_1_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3160:1: ( (lv_ownedPatternGuard_3_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3161:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3161:1: (lv_ownedPatternGuard_3_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3162:3: lv_ownedPatternGuard_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getOwnedPatternGuardExpCSParserRuleCall_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleTypeNameExpCS7554);
                            lv_ownedPatternGuard_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedPatternGuard",
                                      		lv_ownedPatternGuard_3_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_4=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleTypeNameExpCS7566); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getTypeNameExpCSAccess().getRightCurlyBracketKeyword_1_1_2());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3190:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3191:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3192:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7606);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeExpCS7616); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeExpCS"


    // $ANTLR start "ruleTypeExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3199:1: ruleTypeExpCS returns [EObject current=null] : ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject this_TypeLiteralCS_1 = null;

        EObject this_CollectionPatternCS_2 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3202:28: ( ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3203:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3203:1: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3203:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS ) ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3203:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )
            int alt40=3;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3204:2: this_TypeNameExpCS_0= ruleTypeNameExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS7667);
                    this_TypeNameExpCS_0=ruleTypeNameExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeNameExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3217:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeLiteralCSParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS7697);
                    this_TypeLiteralCS_1=ruleTypeLiteralCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypeLiteralCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3230:2: this_CollectionPatternCS_2= ruleCollectionPatternCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeExpCSAccess().getCollectionPatternCSParserRuleCall_0_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS7727);
                    this_CollectionPatternCS_2=ruleCollectionPatternCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_CollectionPatternCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3241:2: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==78) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3242:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3242:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3243:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS7748);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0, 
                              		"MultiplicityCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeExpCS"


    // $ANTLR start "entryRuleExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3267:1: entryRuleExpCS returns [EObject current=null] : iv_ruleExpCS= ruleExpCS EOF ;
    public final EObject entryRuleExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3268:2: (iv_ruleExpCS= ruleExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3269:2: iv_ruleExpCS= ruleExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_entryRuleExpCS7785);
            iv_ruleExpCS=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpCS7795); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpCS"


    // $ANTLR start "ruleExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3276:1: ruleExpCS returns [EObject current=null] : ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) ;
    public final EObject ruleExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;

        EObject this_PrefixedLetExpCS_4 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3279:28: ( ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )
            int alt43=2;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3281:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedPrimaryExpCSParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS7846);
                    this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedPrimaryExpCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
                    int alt42=2;
                    alt42 = dfa42.predict(input);
                    switch (alt42) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: ()
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3293:2: 
                            {
                            if ( state.backtracking==0 ) {
                               
                              	  /* */ 
                              	
                            }
                            if ( state.backtracking==0 ) {

                                      current = forceCreateModelElementAndSet(
                                          grammarAccess.getExpCSAccess().getInfixExpCSOwnedLeftAction_0_1_0(),
                                          current);
                                  
                            }

                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3301:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3303:3: lv_name_2_0= ruleBinaryOperatorName
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_ruleExpCS7879);
                            lv_name_2_0=ruleBinaryOperatorName();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_2_0, 
                                      		"BinaryOperatorName");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3319:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3321:3: lv_ownedRight_3_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleExpCS7900);
                            lv_ownedRight_3_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedRight",
                                      		lv_ownedRight_3_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3339:2: this_PrefixedLetExpCS_4= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getExpCSAccess().getPrefixedLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7934);
                    this_PrefixedLetExpCS_4=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrefixedLetExpCS_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpCS"


    // $ANTLR start "entryRulePrefixedLetExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3358:1: entryRulePrefixedLetExpCS returns [EObject current=null] : iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF ;
    public final EObject entryRulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedLetExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3359:2: (iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3360:2: iv_rulePrefixedLetExpCS= rulePrefixedLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7969);
            iv_rulePrefixedLetExpCS=rulePrefixedLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedLetExpCS7979); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedLetExpCS"


    // $ANTLR start "rulePrefixedLetExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3367:1: rulePrefixedLetExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) ;
    public final EObject rulePrefixedLetExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_LetExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3370:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) ) | this_LetExpCS_3= ruleLetExpCS )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=34 && LA44_0<=35)) ) {
                alt44=1;
            }
            else if ( (LA44_0==88) ) {
                alt44=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3371:3: ()
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3372:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedLetExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3380:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3381:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3381:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3382:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS8038);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3398:2: ( (lv_ownedRight_2_0= rulePrefixedLetExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3399:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3399:1: (lv_ownedRight_2_0= rulePrefixedLetExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3400:3: lv_ownedRight_2_0= rulePrefixedLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getOwnedRightPrefixedLetExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS8059);
                    lv_ownedRight_2_0=rulePrefixedLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedLetExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"PrefixedLetExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3418:2: this_LetExpCS_3= ruleLetExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedLetExpCSAccess().getLetExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS8091);
                    this_LetExpCS_3=ruleLetExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LetExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedLetExpCS"


    // $ANTLR start "entryRulePrefixedPrimaryExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3437:1: entryRulePrefixedPrimaryExpCS returns [EObject current=null] : iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF ;
    public final EObject entryRulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedPrimaryExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3438:2: (iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3439:2: iv_rulePrefixedPrimaryExpCS= rulePrefixedPrimaryExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS8126);
            iv_rulePrefixedPrimaryExpCS=rulePrefixedPrimaryExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixedPrimaryExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS8136); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefixedPrimaryExpCS"


    // $ANTLR start "rulePrefixedPrimaryExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3446:1: rulePrefixedPrimaryExpCS returns [EObject current=null] : ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) ;
    public final EObject rulePrefixedPrimaryExpCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_ownedRight_2_0 = null;

        EObject this_PrimaryExpCS_3 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3449:28: ( ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:1: ( ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) ) | this_PrimaryExpCS_3= rulePrimaryExpCS )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=34 && LA45_0<=35)) ) {
                alt45=1;
            }
            else if ( ((LA45_0>=RULE_SINGLE_QUOTED_STRING && LA45_0<=RULE_INT)||(LA45_0>=25 && LA45_0<=26)||LA45_0==28||LA45_0==33||LA45_0==36||(LA45_0>=52 && LA45_0<=66)||LA45_0==70||(LA45_0>=72 && LA45_0<=75)||LA45_0==83||LA45_0==89) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:2: ( () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:3: () ( (lv_name_1_0= ruleUnaryOperatorName ) ) ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3450:3: ()
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3451:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getPrefixedPrimaryExpCSAccess().getPrefixExpCSAction_0_0(),
                                  current);
                          
                    }

                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3459:2: ( (lv_name_1_0= ruleUnaryOperatorName ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3460:1: (lv_name_1_0= ruleUnaryOperatorName )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3460:1: (lv_name_1_0= ruleUnaryOperatorName )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3461:3: lv_name_1_0= ruleUnaryOperatorName
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getNameUnaryOperatorNameParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS8195);
                    lv_name_1_0=ruleUnaryOperatorName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"UnaryOperatorName");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3477:2: ( (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3478:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3478:1: (lv_ownedRight_2_0= rulePrefixedPrimaryExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3479:3: lv_ownedRight_2_0= rulePrefixedPrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getOwnedRightPrefixedPrimaryExpCSParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS8216);
                    lv_ownedRight_2_0=rulePrefixedPrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getPrefixedPrimaryExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRight",
                              		lv_ownedRight_2_0, 
                              		"PrefixedPrimaryExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3497:2: this_PrimaryExpCS_3= rulePrimaryExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPrefixedPrimaryExpCSAccess().getPrimaryExpCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS8248);
                    this_PrimaryExpCS_3=rulePrimaryExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_PrimaryExpCS_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefixedPrimaryExpCS"


    // $ANTLR start "entryRuleNameExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3516:1: entryRuleNameExpCS returns [EObject current=null] : iv_ruleNameExpCS= ruleNameExpCS EOF ;
    public final EObject entryRuleNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3517:2: (iv_ruleNameExpCS= ruleNameExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3518:2: iv_ruleNameExpCS= ruleNameExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNameExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS8283);
            iv_ruleNameExpCS=ruleNameExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNameExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNameExpCS8293); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNameExpCS"


    // $ANTLR start "ruleNameExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3525:1: ruleNameExpCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) ;
    public final EObject ruleNameExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_isPre_4_0=null;
        Token otherlv_5=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedSquareBracketedClauses_1_0 = null;

        EObject lv_ownedRoundBracketedClause_2_0 = null;

        EObject lv_ownedCurlyBracketedClause_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3528:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3529:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3529:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3529:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )* ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )? ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )? ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3529:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3530:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3530:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3531:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleNameExpCS8339);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3547:2: ( (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==78) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3548:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3548:1: (lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3549:3: lv_ownedSquareBracketedClauses_1_0= ruleSquareBracketedClauseCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedSquareBracketedClausesSquareBracketedClauseCSParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS8360);
            	    lv_ownedSquareBracketedClauses_1_0=ruleSquareBracketedClauseCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSquareBracketedClauses",
            	              		lv_ownedSquareBracketedClauses_1_0, 
            	              		"SquareBracketedClauseCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3565:3: ( (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==26) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3566:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3566:1: (lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3567:3: lv_ownedRoundBracketedClause_2_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS8382);
                    lv_ownedRoundBracketedClause_2_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_2_0, 
                              		"RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3583:3: ( (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==30) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3584:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3584:1: (lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3585:3: lv_ownedCurlyBracketedClause_3_0= ruleCurlyBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNameExpCSAccess().getOwnedCurlyBracketedClauseCurlyBracketedClauseCSParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS8404);
                    lv_ownedCurlyBracketedClause_3_0=ruleCurlyBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNameExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCurlyBracketedClause",
                              		lv_ownedCurlyBracketedClause_3_0, 
                              		"CurlyBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3601:3: ( ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==76) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3601:4: ( (lv_isPre_4_0= '@' ) ) otherlv_5= 'pre'
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3601:4: ( (lv_isPre_4_0= '@' ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3602:1: (lv_isPre_4_0= '@' )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3602:1: (lv_isPre_4_0= '@' )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3603:3: lv_isPre_4_0= '@'
                    {
                    lv_isPre_4_0=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleNameExpCS8424); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isPre_4_0, grammarAccess.getNameExpCSAccess().getIsPreCommercialAtKeyword_4_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNameExpCSRule());
                      	        }
                             		setWithLastConsumed(current, "isPre", true, "@");
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleNameExpCS8449); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getNameExpCSAccess().getPreKeyword_4_1());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNameExpCS"


    // $ANTLR start "entryRuleCurlyBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3628:1: entryRuleCurlyBracketedClauseCS returns [EObject current=null] : iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF ;
    public final EObject entryRuleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCurlyBracketedClauseCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3629:2: (iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3630:2: iv_ruleCurlyBracketedClauseCS= ruleCurlyBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCurlyBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS8487);
            iv_ruleCurlyBracketedClauseCS=ruleCurlyBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCurlyBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS8497); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCurlyBracketedClauseCS"


    // $ANTLR start "ruleCurlyBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3637:1: ruleCurlyBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) ;
    public final EObject ruleCurlyBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3640:28: ( ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3641:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3641:1: ( () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3641:2: () otherlv_1= '{' ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) ) otherlv_6= '}'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3641:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3642:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCurlyBracketedClauseCSAccess().getCurlyBracketedClauseCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleCurlyBracketedClauseCS8546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getCurlyBracketedClauseCSAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3654:1: ( ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )? | ( (lv_value_5_0= ruleStringLiteral ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=RULE_SIMPLE_ID && LA52_0<=RULE_ESCAPED_ID)||LA52_0==31) ) {
                alt52=1;
            }
            else if ( ((LA52_0>=RULE_SINGLE_QUOTED_STRING && LA52_0<=RULE_DOUBLE_QUOTED_STRING)) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3654:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3654:2: ( ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=RULE_SIMPLE_ID && LA51_0<=RULE_ESCAPED_ID)) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3654:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3654:3: ( (lv_ownedParts_2_0= ruleShadowPartCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3655:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3655:1: (lv_ownedParts_2_0= ruleShadowPartCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3656:3: lv_ownedParts_2_0= ruleShadowPartCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8569);
                            lv_ownedParts_2_0=ruleShadowPartCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedParts",
                                      		lv_ownedParts_2_0, 
                                      		"ShadowPartCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3672:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==29) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3672:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCurlyBracketedClauseCS8582); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getCurlyBracketedClauseCSAccess().getCommaKeyword_2_0_1_0());
                            	          
                            	    }
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3676:1: ( (lv_ownedParts_4_0= ruleShadowPartCS ) )
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3677:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    {
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3677:1: (lv_ownedParts_4_0= ruleShadowPartCS )
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3678:3: lv_ownedParts_4_0= ruleShadowPartCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getOwnedPartsShadowPartCSParserRuleCall_2_0_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8603);
                            	    lv_ownedParts_4_0=ruleShadowPartCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedParts",
                            	              		lv_ownedParts_4_0, 
                            	              		"ShadowPartCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3695:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3695:6: ( (lv_value_5_0= ruleStringLiteral ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3696:1: (lv_value_5_0= ruleStringLiteral )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3696:1: (lv_value_5_0= ruleStringLiteral )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3697:3: lv_value_5_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCurlyBracketedClauseCSAccess().getValueStringLiteralParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8634);
                    lv_value_5_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCurlyBracketedClauseCSRule());
                      	        }
                             		set(
                             			current, 
                             			"value",
                              		lv_value_5_0, 
                              		"StringLiteral");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleCurlyBracketedClauseCS8647); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getCurlyBracketedClauseCSAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCurlyBracketedClauseCS"


    // $ANTLR start "entryRuleRoundBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3725:1: entryRuleRoundBracketedClauseCS returns [EObject current=null] : iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF ;
    public final EObject entryRuleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoundBracketedClauseCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3726:2: (iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3727:2: iv_ruleRoundBracketedClauseCS= ruleRoundBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoundBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8683);
            iv_ruleRoundBracketedClauseCS=ruleRoundBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoundBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8693); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRoundBracketedClauseCS"


    // $ANTLR start "ruleRoundBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3734:1: ruleRoundBracketedClauseCS returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) ;
    public final EObject ruleRoundBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_8=null;
        EObject lv_ownedArguments_2_0 = null;

        EObject lv_ownedArguments_3_0 = null;

        EObject lv_ownedArguments_4_0 = null;

        EObject lv_ownedArguments_5_0 = null;

        EObject lv_ownedArguments_6_0 = null;

        EObject lv_ownedArguments_7_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3737:28: ( ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3738:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3738:1: ( () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3738:2: () otherlv_1= '(' ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )? otherlv_8= ')'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3738:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3739:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getRoundBracketedClauseCSAccess().getRoundBracketedClauseCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleRoundBracketedClauseCS8742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRoundBracketedClauseCSAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3751:1: ( ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )* )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( ((LA58_0>=RULE_SINGLE_QUOTED_STRING && LA58_0<=RULE_INT)||(LA58_0>=25 && LA58_0<=26)||LA58_0==28||(LA58_0>=33 && LA58_0<=36)||(LA58_0>=52 && LA58_0<=67)||LA58_0==70||(LA58_0>=72 && LA58_0<=75)||LA58_0==83||(LA58_0>=88 && LA58_0<=89)) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3751:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) ) ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )* ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )? ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3751:2: ( (lv_ownedArguments_2_0= ruleNavigatingArgCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3752:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3752:1: (lv_ownedArguments_2_0= ruleNavigatingArgCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3753:3: lv_ownedArguments_2_0= ruleNavigatingArgCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingArgCSParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8764);
                    lv_ownedArguments_2_0=ruleNavigatingArgCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedArguments",
                              		lv_ownedArguments_2_0, 
                              		"NavigatingArgCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3769:2: ( (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==29) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3770:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3770:1: (lv_ownedArguments_3_0= ruleNavigatingCommaArgCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3771:3: lv_ownedArguments_3_0= ruleNavigatingCommaArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8785);
                    	    lv_ownedArguments_3_0=ruleNavigatingCommaArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_3_0, 
                    	              		"NavigatingCommaArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3787:3: ( ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )* )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==82) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3787:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) ) ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3787:4: ( (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3788:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3788:1: (lv_ownedArguments_4_0= ruleNavigatingSemiArgCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3789:3: lv_ownedArguments_4_0= ruleNavigatingSemiArgCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingSemiArgCSParserRuleCall_2_2_0_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8808);
                            lv_ownedArguments_4_0=ruleNavigatingSemiArgCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"ownedArguments",
                                      		lv_ownedArguments_4_0, 
                                      		"NavigatingSemiArgCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3805:2: ( (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS ) )*
                            loop54:
                            do {
                                int alt54=2;
                                int LA54_0 = input.LA(1);

                                if ( (LA54_0==29) ) {
                                    alt54=1;
                                }


                                switch (alt54) {
                            	case 1 :
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3806:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    {
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3806:1: (lv_ownedArguments_5_0= ruleNavigatingCommaArgCS )
                            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3807:3: lv_ownedArguments_5_0= ruleNavigatingCommaArgCS
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8829);
                            	    lv_ownedArguments_5_0=ruleNavigatingCommaArgCS();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"ownedArguments",
                            	              		lv_ownedArguments_5_0, 
                            	              		"NavigatingCommaArgCS");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop54;
                                }
                            } while (true);


                            }
                            break;

                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3823:5: ( ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )* )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==81) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3823:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) ) ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3823:6: ( (lv_ownedArguments_6_0= ruleNavigatingBarArgCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3824:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3824:1: (lv_ownedArguments_6_0= ruleNavigatingBarArgCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3825:3: lv_ownedArguments_6_0= ruleNavigatingBarArgCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingBarArgCSParserRuleCall_2_3_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8854);
                    	    lv_ownedArguments_6_0=ruleNavigatingBarArgCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedArguments",
                    	              		lv_ownedArguments_6_0, 
                    	              		"NavigatingBarArgCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }

                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3841:2: ( (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS ) )*
                    	    loop56:
                    	    do {
                    	        int alt56=2;
                    	        int LA56_0 = input.LA(1);

                    	        if ( (LA56_0==29) ) {
                    	            alt56=1;
                    	        }


                    	        switch (alt56) {
                    	    	case 1 :
                    	    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3842:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    {
                    	    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3842:1: (lv_ownedArguments_7_0= ruleNavigatingCommaArgCS )
                    	    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3843:3: lv_ownedArguments_7_0= ruleNavigatingCommaArgCS
                    	    	    {
                    	    	    if ( state.backtracking==0 ) {
                    	    	       
                    	    	      	        newCompositeNode(grammarAccess.getRoundBracketedClauseCSAccess().getOwnedArgumentsNavigatingCommaArgCSParserRuleCall_2_3_1_0()); 
                    	    	      	    
                    	    	    }
                    	    	    pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8875);
                    	    	    lv_ownedArguments_7_0=ruleNavigatingCommaArgCS();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return current;
                    	    	    if ( state.backtracking==0 ) {

                    	    	      	        if (current==null) {
                    	    	      	            current = createModelElementForParent(grammarAccess.getRoundBracketedClauseCSRule());
                    	    	      	        }
                    	    	             		add(
                    	    	             			current, 
                    	    	             			"ownedArguments",
                    	    	              		lv_ownedArguments_7_0, 
                    	    	              		"NavigatingCommaArgCS");
                    	    	      	        afterParserOrEnumRuleCall();
                    	    	      	    
                    	    	    }

                    	    	    }


                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop56;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRoundBracketedClauseCS8892); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getRoundBracketedClauseCSAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRoundBracketedClauseCS"


    // $ANTLR start "entryRuleSquareBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3871:1: entryRuleSquareBracketedClauseCS returns [EObject current=null] : iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF ;
    public final EObject entryRuleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSquareBracketedClauseCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3872:2: (iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3873:2: iv_ruleSquareBracketedClauseCS= ruleSquareBracketedClauseCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSquareBracketedClauseCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8928);
            iv_ruleSquareBracketedClauseCS=ruleSquareBracketedClauseCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSquareBracketedClauseCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8938); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSquareBracketedClauseCS"


    // $ANTLR start "ruleSquareBracketedClauseCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3880:1: ruleSquareBracketedClauseCS returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) ;
    public final EObject ruleSquareBracketedClauseCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedTerms_1_0 = null;

        EObject lv_ownedTerms_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3883:28: ( (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3884:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3884:1: (otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3884:3: otherlv_0= '[' ( (lv_ownedTerms_1_0= ruleExpCS ) ) (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )* otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleSquareBracketedClauseCS8975); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSquareBracketedClauseCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3888:1: ( (lv_ownedTerms_1_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3889:1: (lv_ownedTerms_1_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3889:1: (lv_ownedTerms_1_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3890:3: lv_ownedTerms_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8996);
            lv_ownedTerms_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedTerms",
                      		lv_ownedTerms_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3906:2: (otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) ) )*
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==29) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3906:4: otherlv_2= ',' ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    {
            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleSquareBracketedClauseCS9009); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getSquareBracketedClauseCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3910:1: ( (lv_ownedTerms_3_0= ruleExpCS ) )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3911:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3911:1: (lv_ownedTerms_3_0= ruleExpCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3912:3: lv_ownedTerms_3_0= ruleExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSquareBracketedClauseCSAccess().getOwnedTermsExpCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS9030);
            	    lv_ownedTerms_3_0=ruleExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSquareBracketedClauseCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedTerms",
            	              		lv_ownedTerms_3_0, 
            	              		"ExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop59;
                }
            } while (true);

            otherlv_4=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleSquareBracketedClauseCS9044); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSquareBracketedClauseCSAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSquareBracketedClauseCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3940:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3941:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3942:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9080);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgCS9090); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingArgCS"


    // $ANTLR start "ruleNavigatingArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3949:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedNameExpression_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_ownedInitExpression_4_0 = null;

        EObject lv_ownedInitExpression_6_0 = null;

        EObject lv_ownedType_8_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3952:28: ( ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:1: ( ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? ) | (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=RULE_SINGLE_QUOTED_STRING && LA62_0<=RULE_INT)||(LA62_0>=25 && LA62_0<=26)||LA62_0==28||(LA62_0>=33 && LA62_0<=36)||(LA62_0>=52 && LA62_0<=66)||LA62_0==70||(LA62_0>=72 && LA62_0<=75)||LA62_0==83||(LA62_0>=88 && LA62_0<=89)) ) {
                alt62=1;
            }
            else if ( (LA62_0==67) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:2: ( ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )? )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) ) ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3953:3: ( (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3954:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3954:1: (lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3955:3: lv_ownedNameExpression_0_0= ruleNavigatingArgExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9137);
                    lv_ownedNameExpression_0_0=ruleNavigatingArgExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedNameExpression",
                              		lv_ownedNameExpression_0_0, 
                              		"NavigatingArgExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3971:2: ( (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? ) | (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) ) )?
                    int alt61=3;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==67) ) {
                        alt61=1;
                    }
                    else if ( (LA61_0==80) ) {
                        alt61=2;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3971:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3971:3: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )? )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3971:5: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            {
                            otherlv_1=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleNavigatingArgCS9151); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_0_1_0_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3975:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3976:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3976:1: (lv_ownedType_2_0= ruleTypeExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3977:3: lv_ownedType_2_0= ruleTypeExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_0_1_0_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9172);
                            lv_ownedType_2_0=ruleTypeExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedType",
                                      		lv_ownedType_2_0, 
                                      		"TypeExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3993:2: (otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) ) )?
                            int alt60=2;
                            int LA60_0 = input.LA(1);

                            if ( (LA60_0==32) ) {
                                alt60=1;
                            }
                            switch (alt60) {
                                case 1 :
                                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3993:4: otherlv_3= '=' ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    {
                                    otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingArgCS9185); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                          	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_0_1_0_2_0());
                                          
                                    }
                                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3997:1: ( (lv_ownedInitExpression_4_0= ruleExpCS ) )
                                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3998:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    {
                                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3998:1: (lv_ownedInitExpression_4_0= ruleExpCS )
                                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3999:3: lv_ownedInitExpression_4_0= ruleExpCS
                                    {
                                    if ( state.backtracking==0 ) {
                                       
                                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_0_2_1_0()); 
                                      	    
                                    }
                                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9206);
                                    lv_ownedInitExpression_4_0=ruleExpCS();

                                    state._fsp--;
                                    if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                                      	        }
                                             		set(
                                             			current, 
                                             			"ownedInitExpression",
                                              		lv_ownedInitExpression_4_0, 
                                              		"ExpCS");
                                      	        afterParserOrEnumRuleCall();
                                      	    
                                    }

                                    }


                                    }


                                    }
                                    break;

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4016:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4016:6: (otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4016:8: otherlv_5= 'in' ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            {
                            otherlv_5=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleNavigatingArgCS9228); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getNavigatingArgCSAccess().getInKeyword_0_1_1_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4020:1: ( (lv_ownedInitExpression_6_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4021:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4021:1: (lv_ownedInitExpression_6_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4022:3: lv_ownedInitExpression_6_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_0_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9249);
                            lv_ownedInitExpression_6_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_6_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4039:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4039:6: (otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4039:8: otherlv_7= ':' ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    {
                    otherlv_7=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleNavigatingArgCS9272); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4043:1: ( (lv_ownedType_8_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4044:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4044:1: (lv_ownedType_8_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4045:3: lv_ownedType_8_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9293);
                    lv_ownedType_8_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_8_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4069:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4070:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4071:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9330);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingBarArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9340); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingBarArgCS"


    // $ANTLR start "ruleNavigatingBarArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4078:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4081:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4082:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4082:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4082:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4082:2: ( (lv_prefix_0_0= '|' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4083:1: (lv_prefix_0_0= '|' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4083:1: (lv_prefix_0_0= '|' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4084:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleNavigatingBarArgCS9383); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, "|");
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4097:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4098:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4098:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4099:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9417);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4115:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==67) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4115:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleNavigatingBarArgCS9430); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4119:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4120:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4120:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4121:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS9451);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4137:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==32) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4137:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingBarArgCS9464); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4141:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4142:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4142:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4143:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS9485);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingBarArgCS"


    // $ANTLR start "entryRuleNavigatingCommaArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4167:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4168:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4169:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9525);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingCommaArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9535); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingCommaArgCS"


    // $ANTLR start "ruleNavigatingCommaArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4176:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;

        EObject lv_ownedInitExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4179:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4180:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4180:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4180:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4180:2: ( (lv_prefix_0_0= ',' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4181:1: (lv_prefix_0_0= ',' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4181:1: (lv_prefix_0_0= ',' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4182:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleNavigatingCommaArgCS9578); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ",");
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4195:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4196:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4196:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4197:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9612);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4213:2: ( (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? ) | (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) ) )?
            int alt66=3;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==67) ) {
                alt66=1;
            }
            else if ( (LA66_0==80) ) {
                alt66=2;
            }
            switch (alt66) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4213:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4213:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4213:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleNavigatingCommaArgCS9626); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4217:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4218:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4218:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4219:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS9647);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4235:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==32) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4235:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingCommaArgCS9660); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_0_2_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4239:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4240:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4240:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4241:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_0_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9681);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4258:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4258:6: (otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4258:8: otherlv_6= 'in' ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    {
                    otherlv_6=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleNavigatingCommaArgCS9703); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getNavigatingCommaArgCSAccess().getInKeyword_2_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4262:1: ( (lv_ownedInitExpression_7_0= ruleExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4263:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4263:1: (lv_ownedInitExpression_7_0= ruleExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4264:3: lv_ownedInitExpression_7_0= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9724);
                    lv_ownedInitExpression_7_0=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedInitExpression",
                              		lv_ownedInitExpression_7_0, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingCommaArgCS"


    // $ANTLR start "entryRuleNavigatingSemiArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4288:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4289:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4290:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9763);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingSemiArgCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9773); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingSemiArgCS"


    // $ANTLR start "ruleNavigatingSemiArgCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4297:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedNameExpression_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4300:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4301:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4301:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4301:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4301:2: ( (lv_prefix_0_0= ';' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4302:1: (lv_prefix_0_0= ';' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4302:1: (lv_prefix_0_0= ';' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4303:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleNavigatingSemiArgCS9816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());
                  
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ";");
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4316:2: ( (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4317:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4317:1: (lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4318:3: lv_ownedNameExpression_1_0= ruleNavigatingArgExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedNameExpressionNavigatingArgExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9850);
            lv_ownedNameExpression_1_0=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedNameExpression",
                      		lv_ownedNameExpression_1_0, 
                      		"NavigatingArgExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4334:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )? )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==67) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4334:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleNavigatingSemiArgCS9863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4338:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4339:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4339:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4340:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS9884);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4356:2: (otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==32) ) {
                        alt67=1;
                    }
                    switch (alt67) {
                        case 1 :
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4356:4: otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            {
                            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleNavigatingSemiArgCS9897); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                  
                            }
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4360:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4361:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            {
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4361:1: (lv_ownedInitExpression_5_0= ruleExpCS )
                            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4362:3: lv_ownedInitExpression_5_0= ruleExpCS
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedInitExpressionExpCSParserRuleCall_2_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9918);
                            lv_ownedInitExpression_5_0=ruleExpCS();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ownedInitExpression",
                                      		lv_ownedInitExpression_5_0, 
                                      		"ExpCS");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingSemiArgCS"


    // $ANTLR start "entryRuleNavigatingArgExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4386:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4387:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4388:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9958);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNavigatingArgExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9968); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigatingArgExpCS"


    // $ANTLR start "ruleNavigatingArgExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4395:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpCS_0= ruleExpCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4398:28: (this_ExpCS_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4400:2: this_ExpCS_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10017);
            this_ExpCS_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_ExpCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigatingArgExpCS"


    // $ANTLR start "entryRuleIfExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4419:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4420:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4421:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10051);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIfExpCS10061); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpCS"


    // $ANTLR start "ruleIfExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4428:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedCondition_1_1 = null;

        EObject lv_ownedCondition_1_2 = null;

        EObject lv_ownedThenExpression_3_0 = null;

        EObject lv_ownedIfThenExpressions_4_0 = null;

        EObject lv_ownedElseExpression_6_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4431:28: ( (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4432:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4432:1: (otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4432:3: otherlv_0= 'if' ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )* otherlv_5= 'else' ( (lv_ownedElseExpression_6_0= ruleExpCS ) ) otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleIfExpCS10098); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4436:1: ( ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4437:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4437:1: ( (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4438:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4438:1: (lv_ownedCondition_1_1= ruleExpCS | lv_ownedCondition_1_2= rulePatternExpCS )
            int alt69=2;
            switch ( input.LA(1) ) {
            case RULE_SINGLE_QUOTED_STRING:
            case RULE_DOUBLE_QUOTED_STRING:
            case RULE_INT:
            case 25:
            case 26:
            case 28:
            case 33:
            case 34:
            case 35:
            case 36:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 70:
            case 72:
            case 73:
            case 74:
            case 75:
            case 83:
            case 88:
            case 89:
                {
                alt69=1;
                }
                break;
            case RULE_SIMPLE_ID:
                {
                int LA69_2 = input.LA(2);

                if ( (LA69_2==26||LA69_2==30||LA69_2==32||LA69_2==34||(LA69_2>=36 && LA69_2<=51)||LA69_2==76||LA69_2==78||LA69_2==84||LA69_2==93) ) {
                    alt69=1;
                }
                else if ( (LA69_2==67) ) {
                    alt69=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ESCAPED_ID:
                {
                int LA69_3 = input.LA(2);

                if ( (LA69_3==67) ) {
                    alt69=2;
                }
                else if ( (LA69_3==26||LA69_3==30||LA69_3==32||LA69_3==34||(LA69_3>=36 && LA69_3<=51)||LA69_3==76||LA69_3==78||LA69_3==84||LA69_3==93) ) {
                    alt69=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 3, input);

                    throw nvae;
                }
                }
                break;
            case 67:
                {
                alt69=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4439:3: lv_ownedCondition_1_1= ruleExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10121);
                    lv_ownedCondition_1_1=ruleExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_1, 
                              		"ExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4454:8: lv_ownedCondition_1_2= rulePatternExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedConditionPatternExpCSParserRuleCall_1_0_1()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePatternExpCS_in_ruleIfExpCS10140);
                    lv_ownedCondition_1_2=rulePatternExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedCondition",
                              		lv_ownedCondition_1_2, 
                              		"PatternExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_2=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleIfExpCS10155); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4476:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4477:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4477:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4478:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10176);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4494:2: ( (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==87) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4495:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4495:1: (lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4496:3: lv_ownedIfThenExpressions_4_0= ruleElseIfThenExpCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedIfThenExpressionsElseIfThenExpCSParserRuleCall_4_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS10197);
            	    lv_ownedIfThenExpressions_4_0=ruleElseIfThenExpCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedIfThenExpressions",
            	              		lv_ownedIfThenExpressions_4_0, 
            	              		"ElseIfThenExpCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            otherlv_5=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleIfExpCS10210); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getIfExpCSAccess().getElseKeyword_5());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4516:1: ( (lv_ownedElseExpression_6_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4517:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4517:1: (lv_ownedElseExpression_6_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4518:3: lv_ownedElseExpression_6_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIfExpCSAccess().getOwnedElseExpressionExpCSParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleIfExpCS10231);
            lv_ownedElseExpression_6_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedElseExpression",
                      		lv_ownedElseExpression_6_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_7=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleIfExpCS10243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getIfExpCSAccess().getEndifKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpCS"


    // $ANTLR start "entryRuleElseIfThenExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4546:1: entryRuleElseIfThenExpCS returns [EObject current=null] : iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF ;
    public final EObject entryRuleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4547:2: (iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4548:2: iv_ruleElseIfThenExpCS= ruleElseIfThenExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfThenExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS10279);
            iv_ruleElseIfThenExpCS=ruleElseIfThenExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIfThenExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElseIfThenExpCS10289); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseIfThenExpCS"


    // $ANTLR start "ruleElseIfThenExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4555:1: ruleElseIfThenExpCS returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) ;
    public final EObject ruleElseIfThenExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedCondition_1_0 = null;

        EObject lv_ownedThenExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4558:28: ( (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4559:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4559:1: (otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4559:3: otherlv_0= 'elseif' ( (lv_ownedCondition_1_0= ruleExpCS ) ) otherlv_2= 'then' ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleElseIfThenExpCS10326); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getElseIfThenExpCSAccess().getElseifKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4563:1: ( (lv_ownedCondition_1_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4564:1: (lv_ownedCondition_1_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4564:1: (lv_ownedCondition_1_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4565:3: lv_ownedCondition_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedConditionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10347);
            lv_ownedCondition_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedCondition",
                      		lv_ownedCondition_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleElseIfThenExpCS10359); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getElseIfThenExpCSAccess().getThenKeyword_2());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4585:1: ( (lv_ownedThenExpression_3_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4586:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4586:1: (lv_ownedThenExpression_3_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4587:3: lv_ownedThenExpression_3_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getElseIfThenExpCSAccess().getOwnedThenExpressionExpCSParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10380);
            lv_ownedThenExpression_3_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getElseIfThenExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedThenExpression",
                      		lv_ownedThenExpression_3_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseIfThenExpCS"


    // $ANTLR start "entryRuleLetExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4611:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4612:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4613:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10416);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetExpCS10426); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetExpCS"


    // $ANTLR start "ruleLetExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4620:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_ownedVariables_1_0 = null;

        EObject lv_ownedVariables_3_0 = null;

        EObject lv_ownedInExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4623:28: ( (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4624:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4624:1: (otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4624:3: otherlv_0= 'let' ( (lv_ownedVariables_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            {
            otherlv_0=(Token)match(input,88,FollowSets000.FOLLOW_88_in_ruleLetExpCS10463); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4628:1: ( (lv_ownedVariables_1_0= ruleLetVariableCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4629:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4629:1: (lv_ownedVariables_1_0= ruleLetVariableCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4630:3: lv_ownedVariables_1_0= ruleLetVariableCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10484);
            lv_ownedVariables_1_0=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedVariables",
                      		lv_ownedVariables_1_0, 
                      		"LetVariableCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4646:2: (otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) ) )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==29) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4646:4: otherlv_2= ',' ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleLetExpCS10497); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	          
            	    }
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4650:1: ( (lv_ownedVariables_3_0= ruleLetVariableCS ) )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4651:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4651:1: (lv_ownedVariables_3_0= ruleLetVariableCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4652:3: lv_ownedVariables_3_0= ruleLetVariableCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedVariablesLetVariableCSParserRuleCall_2_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10518);
            	    lv_ownedVariables_3_0=ruleLetVariableCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedVariables",
            	              		lv_ownedVariables_3_0, 
            	              		"LetVariableCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            otherlv_4=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLetExpCS10532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4672:1: ( (lv_ownedInExpression_5_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4673:1: (lv_ownedInExpression_5_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4673:1: (lv_ownedInExpression_5_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4674:3: lv_ownedInExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetExpCSAccess().getOwnedInExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetExpCS10553);
            lv_ownedInExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInExpression",
                      		lv_ownedInExpression_5_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetExpCS"


    // $ANTLR start "entryRuleLetVariableCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4698:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4699:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4700:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10589);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetVariableCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLetVariableCS10599); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetVariableCS"


    // $ANTLR start "ruleLetVariableCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4707:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedRoundBracketedClause_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_ownedInitExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4710:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4711:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4711:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4711:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )? (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )? otherlv_4= '=' ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4711:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4712:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4712:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4713:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10645);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4729:2: ( (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==26) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4730:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4730:1: (lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4731:3: lv_ownedRoundBracketedClause_1_0= ruleRoundBracketedClauseCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedRoundBracketedClauseRoundBracketedClauseCSParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10666);
                    lv_ownedRoundBracketedClause_1_0=ruleRoundBracketedClauseCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedRoundBracketedClause",
                              		lv_ownedRoundBracketedClause_1_0, 
                              		"RoundBracketedClauseCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4747:3: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==67) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4747:5: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    {
                    otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleLetVariableCS10680); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getLetVariableCSAccess().getColonKeyword_2_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4751:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4752:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4752:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4753:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS10701);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedType",
                              		lv_ownedType_3_0, 
                              		"TypeExpCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLetVariableCS10715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_3());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4773:1: ( (lv_ownedInitExpression_5_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4774:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4774:1: (lv_ownedInitExpression_5_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4775:3: lv_ownedInitExpression_5_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedInitExpressionExpCSParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleLetVariableCS10736);
            lv_ownedInitExpression_5_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedInitExpression",
                      		lv_ownedInitExpression_5_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetVariableCS"


    // $ANTLR start "entryRuleNestedExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4799:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4800:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4801:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10772);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNestedExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNestedExpCS10782); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedExpCS"


    // $ANTLR start "ruleNestedExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4808:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4811:28: ( (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4812:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4812:1: (otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4812:3: otherlv_0= '(' ( (lv_ownedExpression_1_0= ruleExpCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleNestedExpCS10819); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4816:1: ( (lv_ownedExpression_1_0= ruleExpCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4817:1: (lv_ownedExpression_1_0= ruleExpCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4817:1: (lv_ownedExpression_1_0= ruleExpCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4818:3: lv_ownedExpression_1_0= ruleExpCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getOwnedExpressionExpCSParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_ruleNestedExpCS10840);
            lv_ownedExpression_1_0=ruleExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedExpression",
                      		lv_ownedExpression_1_0, 
                      		"ExpCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleNestedExpCS10852); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedExpCS"


    // $ANTLR start "entryRuleSelfExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4846:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4847:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4848:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10888);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSelfExpCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelfExpCS10898); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelfExpCS"


    // $ANTLR start "ruleSelfExpCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4855:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4858:28: ( ( () otherlv_1= 'self' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4859:1: ( () otherlv_1= 'self' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4859:1: ( () otherlv_1= 'self' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4859:2: () otherlv_1= 'self'
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4859:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4860:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,89,FollowSets000.FOLLOW_89_in_ruleSelfExpCS10947); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelfExpCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4880:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4881:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4882:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10983);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityBoundsCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10993); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4889:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4892:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4893:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4893:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4893:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4893:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4894:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4894:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4895:3: lv_lowerBound_0_0= ruleLOWER
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS11039);
            lv_lowerBound_0_0=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
              	        }
                     		set(
                     			current, 
                     			"lowerBound",
                      		lv_lowerBound_0_0, 
                      		"LOWER");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4911:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==68) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4911:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleMultiplicityBoundsCS11052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4915:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4916:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4916:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4917:3: lv_upperBound_2_0= ruleUPPER
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS11073);
                    lv_upperBound_2_0=ruleUPPER();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
                      	        }
                             		set(
                             			current, 
                             			"upperBound",
                              		lv_upperBound_2_0, 
                              		"UPPER");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4941:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4942:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4943:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS11111);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityCS11121); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4950:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token lv_isNullFree_4_0=null;
        Token otherlv_5=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4953:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4954:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4954:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']' )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4954:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMultiplicityCS11158); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4958:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_INT) ) {
                alt75=1;
            }
            else if ( (LA75_0==36||LA75_0==38||LA75_0==92) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4959:2: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS11184);
                    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MultiplicityBoundsCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4972:2: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS11214);
                    this_MultiplicityStringCS_2=ruleMultiplicityStringCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MultiplicityStringCS_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4983:2: (otherlv_3= '|?' | ( (lv_isNullFree_4_0= '|1' ) ) )?
            int alt76=3;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==90) ) {
                alt76=1;
            }
            else if ( (LA76_0==91) ) {
                alt76=2;
            }
            switch (alt76) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4983:4: otherlv_3= '|?'
                    {
                    otherlv_3=(Token)match(input,90,FollowSets000.FOLLOW_90_in_ruleMultiplicityCS11227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getVerticalLineQuestionMarkKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4988:6: ( (lv_isNullFree_4_0= '|1' ) )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4988:6: ( (lv_isNullFree_4_0= '|1' ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4989:1: (lv_isNullFree_4_0= '|1' )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4989:1: (lv_isNullFree_4_0= '|1' )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:4990:3: lv_isNullFree_4_0= '|1'
                    {
                    lv_isNullFree_4_0=(Token)match(input,91,FollowSets000.FOLLOW_91_in_ruleMultiplicityCS11251); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isNullFree_4_0, grammarAccess.getMultiplicityCSAccess().getIsNullFree1Keyword_2_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityCSRule());
                      	        }
                             		setWithLastConsumed(current, "isNullFree", true, "|1");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleMultiplicityCS11278); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5015:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5016:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5017:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS11314);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicityStringCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiplicityStringCS11324); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5024:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5027:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5028:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5028:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5029:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5029:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5030:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5030:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt77=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt77=1;
                }
                break;
            case 38:
                {
                alt77=2;
                }
                break;
            case 92:
                {
                alt77=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5031:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleMultiplicityStringCS11368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5043:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleMultiplicityStringCS11397); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5055:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleMultiplicityStringCS11426); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                      	        }
                             		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRulePathNameCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5078:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5079:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5080:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPathNameCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_entryRulePathNameCS11477);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePathNameCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePathNameCS11487); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5087:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedPathElements_0_0 = null;

        EObject lv_ownedPathElements_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5090:28: ( ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5091:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5091:1: ( ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )* )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5091:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5091:2: ( (lv_ownedPathElements_0_0= ruleFirstPathElementCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5092:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5092:1: (lv_ownedPathElements_0_0= ruleFirstPathElementCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5093:3: lv_ownedPathElements_0_0= ruleFirstPathElementCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsFirstPathElementCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11533);
            lv_ownedPathElements_0_0=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedPathElements",
                      		lv_ownedPathElements_0_0, 
                      		"FirstPathElementCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5109:2: (otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==93) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5109:4: otherlv_1= '::' ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,93,FollowSets000.FOLLOW_93_in_rulePathNameCS11546); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	          
            	    }
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5113:1: ( (lv_ownedPathElements_2_0= ruleNextPathElementCS ) )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5114:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5114:1: (lv_ownedPathElements_2_0= ruleNextPathElementCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5115:3: lv_ownedPathElements_2_0= ruleNextPathElementCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getPathNameCSAccess().getOwnedPathElementsNextPathElementCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11567);
            	    lv_ownedPathElements_2_0=ruleNextPathElementCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedPathElements",
            	              		lv_ownedPathElements_2_0, 
            	              		"NextPathElementCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5139:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5140:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5141:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11605);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFirstPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFirstPathElementCS11615); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5148:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5151:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5152:1: ( ( ruleUnrestrictedName ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5152:1: ( ( ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5153:1: ( ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5153:1: ( ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5154:3: ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getFirstPathElementCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11666);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5178:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5179:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5180:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11701);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNextPathElementCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNextPathElementCS11711); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5187:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5190:28: ( ( ( ruleUnreservedName ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5191:1: ( ( ruleUnreservedName ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5191:1: ( ( ruleUnreservedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5192:1: ( ruleUnreservedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5192:1: ( ruleUnreservedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5193:3: ruleUnreservedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getNextPathElementCSRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getReferredElementNamedElementCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11762);
            ruleUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRuleTemplateBindingCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5217:1: entryRuleTemplateBindingCS returns [EObject current=null] : iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF ;
    public final EObject entryRuleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBindingCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5218:2: (iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5219:2: iv_ruleTemplateBindingCS= ruleTemplateBindingCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateBindingCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11797);
            iv_ruleTemplateBindingCS=ruleTemplateBindingCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateBindingCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateBindingCS11807); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBindingCS"


    // $ANTLR start "ruleTemplateBindingCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5226:1: ruleTemplateBindingCS returns [EObject current=null] : ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTemplateBindingCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ownedSubstitutions_0_0 = null;

        EObject lv_ownedSubstitutions_2_0 = null;

        EObject lv_ownedMultiplicity_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5229:28: ( ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5230:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5230:1: ( ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5230:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) ) (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )* ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5230:2: ( (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5231:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5231:1: (lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5232:3: lv_ownedSubstitutions_0_0= ruleTemplateParameterSubstitutionCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11853);
            lv_ownedSubstitutions_0_0=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
              	        }
                     		add(
                     			current, 
                     			"ownedSubstitutions",
                      		lv_ownedSubstitutions_0_0, 
                      		"TemplateParameterSubstitutionCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5248:2: (otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) ) )*
            loop79:
            do {
                int alt79=2;
                int LA79_0 = input.LA(1);

                if ( (LA79_0==29) ) {
                    alt79=1;
                }


                switch (alt79) {
            	case 1 :
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5248:4: otherlv_1= ',' ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleTemplateBindingCS11866); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTemplateBindingCSAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5252:1: ( (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS ) )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5253:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    {
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5253:1: (lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS )
            	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5254:3: lv_ownedSubstitutions_2_0= ruleTemplateParameterSubstitutionCS
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedSubstitutionsTemplateParameterSubstitutionCSParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11887);
            	    lv_ownedSubstitutions_2_0=ruleTemplateParameterSubstitutionCS();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"ownedSubstitutions",
            	              		lv_ownedSubstitutions_2_0, 
            	              		"TemplateParameterSubstitutionCS");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop79;
                }
            } while (true);

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5270:4: ( (lv_ownedMultiplicity_3_0= ruleMultiplicityCS ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==78) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5271:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5271:1: (lv_ownedMultiplicity_3_0= ruleMultiplicityCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5272:3: lv_ownedMultiplicity_3_0= ruleMultiplicityCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTemplateBindingCSAccess().getOwnedMultiplicityMultiplicityCSParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMultiplicityCS_in_ruleTemplateBindingCS11910);
                    lv_ownedMultiplicity_3_0=ruleMultiplicityCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTemplateBindingCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedMultiplicity",
                              		lv_ownedMultiplicity_3_0, 
                              		"MultiplicityCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateBindingCS"


    // $ANTLR start "entryRuleTemplateParameterSubstitutionCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5296:1: entryRuleTemplateParameterSubstitutionCS returns [EObject current=null] : iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF ;
    public final EObject entryRuleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateParameterSubstitutionCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5297:2: (iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5298:2: iv_ruleTemplateParameterSubstitutionCS= ruleTemplateParameterSubstitutionCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS11947);
            iv_ruleTemplateParameterSubstitutionCS=ruleTemplateParameterSubstitutionCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTemplateParameterSubstitutionCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS11957); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateParameterSubstitutionCS"


    // $ANTLR start "ruleTemplateParameterSubstitutionCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5305:1: ruleTemplateParameterSubstitutionCS returns [EObject current=null] : ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) ;
    public final EObject ruleTemplateParameterSubstitutionCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedActualParameter_0_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5308:28: ( ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5309:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5309:1: ( (lv_ownedActualParameter_0_0= ruleTypeRefCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5310:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5310:1: (lv_ownedActualParameter_0_0= ruleTypeRefCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5311:3: lv_ownedActualParameter_0_0= ruleTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTemplateParameterSubstitutionCSAccess().getOwnedActualParameterTypeRefCSParserRuleCall_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS12002);
            lv_ownedActualParameter_0_0=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTemplateParameterSubstitutionCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedActualParameter",
                      		lv_ownedActualParameter_0_0, 
                      		"TypeRefCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTemplateParameterSubstitutionCS"


    // $ANTLR start "entryRuleTypeParameterCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5337:1: entryRuleTypeParameterCS returns [EObject current=null] : iv_ruleTypeParameterCS= ruleTypeParameterCS EOF ;
    public final EObject entryRuleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameterCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5338:2: (iv_ruleTypeParameterCS= ruleTypeParameterCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5339:2: iv_ruleTypeParameterCS= ruleTypeParameterCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS12039);
            iv_ruleTypeParameterCS=ruleTypeParameterCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameterCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeParameterCS12049); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeParameterCS"


    // $ANTLR start "ruleTypeParameterCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5346:1: ruleTypeParameterCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) ;
    public final EObject ruleTypeParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedExtends_2_0 = null;

        EObject lv_ownedExtends_4_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5349:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5350:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5350:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5350:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5350:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5351:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5351:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5352:3: lv_name_0_0= ruleUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS12095);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"UnrestrictedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5368:2: (otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )* )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==94) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5368:4: otherlv_1= 'extends' ( (lv_ownedExtends_2_0= ruleTypedRefCS ) ) (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    {
                    otherlv_1=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleTypeParameterCS12108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypeParameterCSAccess().getExtendsKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5372:1: ( (lv_ownedExtends_2_0= ruleTypedRefCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5373:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5373:1: (lv_ownedExtends_2_0= ruleTypedRefCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5374:3: lv_ownedExtends_2_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS12129);
                    lv_ownedExtends_2_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                      	        }
                             		add(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_2_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5390:2: (otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==95) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5390:4: otherlv_3= '&&' ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,95,FollowSets000.FOLLOW_95_in_ruleTypeParameterCS12142); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getTypeParameterCSAccess().getAmpersandAmpersandKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5394:1: ( (lv_ownedExtends_4_0= ruleTypedRefCS ) )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5395:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    {
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5395:1: (lv_ownedExtends_4_0= ruleTypedRefCS )
                    	    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5396:3: lv_ownedExtends_4_0= ruleTypedRefCS
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTypeParameterCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS12163);
                    	    lv_ownedExtends_4_0=ruleTypedRefCS();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTypeParameterCSRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"ownedExtends",
                    	              		lv_ownedExtends_4_0, 
                    	              		"TypedRefCS");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeParameterCS"


    // $ANTLR start "entryRuleTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5420:1: entryRuleTypeRefCS returns [EObject current=null] : iv_ruleTypeRefCS= ruleTypeRefCS EOF ;
    public final EObject entryRuleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRefCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5421:2: (iv_ruleTypeRefCS= ruleTypeRefCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5422:2: iv_ruleTypeRefCS= ruleTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS12203);
            iv_ruleTypeRefCS=ruleTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypeRefCS12213); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeRefCS"


    // $ANTLR start "ruleTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5429:1: ruleTypeRefCS returns [EObject current=null] : (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) ;
    public final EObject ruleTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedRefCS_0 = null;

        EObject this_WildcardTypeRefCS_1 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5432:28: ( (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5433:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5433:1: (this_TypedRefCS_0= ruleTypedRefCS | this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( ((LA83_0>=RULE_SIMPLE_ID && LA83_0<=RULE_ESCAPED_ID)) ) {
                alt83=1;
            }
            else if ( (LA83_0==92) ) {
                alt83=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5434:2: this_TypedRefCS_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getTypedRefCSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS12263);
                    this_TypedRefCS_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_TypedRefCS_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5447:2: this_WildcardTypeRefCS_1= ruleWildcardTypeRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTypeRefCSAccess().getWildcardTypeRefCSParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS12293);
                    this_WildcardTypeRefCS_1=ruleWildcardTypeRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_WildcardTypeRefCS_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeRefCS"


    // $ANTLR start "entryRuleTypedRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5466:1: entryRuleTypedRefCS returns [EObject current=null] : iv_ruleTypedRefCS= ruleTypedRefCS EOF ;
    public final EObject entryRuleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedRefCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5467:2: (iv_ruleTypedRefCS= ruleTypedRefCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5468:2: iv_ruleTypedRefCS= ruleTypedRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS12328);
            iv_ruleTypedRefCS=ruleTypedRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedRefCS12338); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedRefCS"


    // $ANTLR start "ruleTypedRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5475:1: ruleTypedRefCS returns [EObject current=null] : this_TypedTypeRefCS_0= ruleTypedTypeRefCS ;
    public final EObject ruleTypedRefCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypedTypeRefCS_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5478:28: (this_TypedTypeRefCS_0= ruleTypedTypeRefCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5480:2: this_TypedTypeRefCS_0= ruleTypedTypeRefCS
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getTypedRefCSAccess().getTypedTypeRefCSParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS12387);
            this_TypedTypeRefCS_0=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                      current = this_TypedTypeRefCS_0; 
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedRefCS"


    // $ANTLR start "entryRuleTypedTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5499:1: entryRuleTypedTypeRefCS returns [EObject current=null] : iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF ;
    public final EObject entryRuleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedTypeRefCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5500:2: (iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5501:2: iv_ruleTypedTypeRefCS= ruleTypedTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS12421);
            iv_ruleTypedTypeRefCS=ruleTypedTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTypedTypeRefCS12431); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedTypeRefCS"


    // $ANTLR start "ruleTypedTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5508:1: ruleTypedTypeRefCS returns [EObject current=null] : ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleTypedTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedPathName_0_0 = null;

        EObject lv_ownedBinding_2_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5511:28: ( ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5512:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5512:1: ( ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5512:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) ) (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5512:2: ( (lv_ownedPathName_0_0= rulePathNameCS ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5513:1: (lv_ownedPathName_0_0= rulePathNameCS )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5513:1: (lv_ownedPathName_0_0= rulePathNameCS )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5514:3: lv_ownedPathName_0_0= rulePathNameCS
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedPathNamePathNameCSParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS12477);
            lv_ownedPathName_0_0=rulePathNameCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
              	        }
                     		set(
                     			current, 
                     			"ownedPathName",
                      		lv_ownedPathName_0_0, 
                      		"PathNameCS");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5530:2: (otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==26) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5530:4: otherlv_1= '(' ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleTypedTypeRefCS12490); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTypedTypeRefCSAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5534:1: ( (lv_ownedBinding_2_0= ruleTemplateBindingCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5535:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5535:1: (lv_ownedBinding_2_0= ruleTemplateBindingCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5536:3: lv_ownedBinding_2_0= ruleTemplateBindingCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTypedTypeRefCSAccess().getOwnedBindingTemplateBindingCSParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS12511);
                    lv_ownedBinding_2_0=ruleTemplateBindingCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTypedTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedBinding",
                              		lv_ownedBinding_2_0, 
                              		"TemplateBindingCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleTypedTypeRefCS12523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTypedTypeRefCSAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedTypeRefCS"


    // $ANTLR start "entryRuleWildcardTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5564:1: entryRuleWildcardTypeRefCS returns [EObject current=null] : iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF ;
    public final EObject entryRuleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWildcardTypeRefCS = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5565:2: (iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5566:2: iv_ruleWildcardTypeRefCS= ruleWildcardTypeRefCS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWildcardTypeRefCSRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12561);
            iv_ruleWildcardTypeRefCS=ruleWildcardTypeRefCS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWildcardTypeRefCS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12571); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWildcardTypeRefCS"


    // $ANTLR start "ruleWildcardTypeRefCS"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5573:1: ruleWildcardTypeRefCS returns [EObject current=null] : ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) ;
    public final EObject ruleWildcardTypeRefCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_ownedExtends_3_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5576:28: ( ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5577:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5577:1: ( () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )? )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5577:2: () otherlv_1= '?' (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5577:2: ()
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5578:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getWildcardTypeRefCSAccess().getWildcardTypeRefCSAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,92,FollowSets000.FOLLOW_92_in_ruleWildcardTypeRefCS12620); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWildcardTypeRefCSAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5590:1: (otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==94) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5590:3: otherlv_2= 'extends' ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    {
                    otherlv_2=(Token)match(input,94,FollowSets000.FOLLOW_94_in_ruleWildcardTypeRefCS12633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getWildcardTypeRefCSAccess().getExtendsKeyword_2_0());
                          
                    }
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5594:1: ( (lv_ownedExtends_3_0= ruleTypedRefCS ) )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5595:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    {
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5595:1: (lv_ownedExtends_3_0= ruleTypedRefCS )
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5596:3: lv_ownedExtends_3_0= ruleTypedRefCS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getWildcardTypeRefCSAccess().getOwnedExtendsTypedRefCSParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS12654);
                    lv_ownedExtends_3_0=ruleTypedRefCS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getWildcardTypeRefCSRule());
                      	        }
                             		set(
                             			current, 
                             			"ownedExtends",
                              		lv_ownedExtends_3_0, 
                              		"TypedRefCS");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWildcardTypeRefCS"


    // $ANTLR start "entryRuleID"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5620:1: entryRuleID returns [String current=null] : iv_ruleID= ruleID EOF ;
    public final String entryRuleID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleID = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5621:2: (iv_ruleID= ruleID EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5622:2: iv_ruleID= ruleID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIDRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_entryRuleID12693);
            iv_ruleID=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleID.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleID12704); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleID"


    // $ANTLR start "ruleID"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5629:1: ruleID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) ;
    public final AntlrDatatypeRuleToken ruleID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SIMPLE_ID_0=null;
        Token this_ESCAPED_ID_1=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5632:28: ( (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5633:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5633:1: (this_SIMPLE_ID_0= RULE_SIMPLE_ID | this_ESCAPED_ID_1= RULE_ESCAPED_ID )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_SIMPLE_ID) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_ESCAPED_ID) ) {
                alt86=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5633:6: this_SIMPLE_ID_0= RULE_SIMPLE_ID
                    {
                    this_SIMPLE_ID_0=(Token)match(input,RULE_SIMPLE_ID,FollowSets000.FOLLOW_RULE_SIMPLE_ID_in_ruleID12744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_SIMPLE_ID_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_SIMPLE_ID_0, grammarAccess.getIDAccess().getSIMPLE_IDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5641:10: this_ESCAPED_ID_1= RULE_ESCAPED_ID
                    {
                    this_ESCAPED_ID_1=(Token)match(input,RULE_ESCAPED_ID,FollowSets000.FOLLOW_RULE_ESCAPED_ID_in_ruleID12770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ESCAPED_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ESCAPED_ID_1, grammarAccess.getIDAccess().getESCAPED_IDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleID"


    // $ANTLR start "entryRuleIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5656:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5657:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5658:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleIdentifier_in_entryRuleIdentifier12816);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifier12827); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5665:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= ruleID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_ID_0 = null;


         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5668:28: (this_ID_0= ruleID )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5670:5: this_ID_0= ruleID
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getIdentifierAccess().getIDParserRuleCall()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleID_in_ruleIdentifier12873);
            this_ID_0=ruleID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLOWER"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5688:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5689:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5690:2: iv_ruleLOWER= ruleLOWER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLOWERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLOWER_in_entryRuleLOWER12918);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLOWER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLOWER12929); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5697:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5700:28: (this_INT_0= RULE_INT )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5701:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleLOWER12968); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5716:1: entryRuleNUMBER_LITERAL returns [String current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final String entryRuleNUMBER_LITERAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNUMBER_LITERAL = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5717:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5718:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL13013);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNUMBER_LITERAL.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNUMBER_LITERAL13024); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5725:1: ruleNUMBER_LITERAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleNUMBER_LITERAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5728:28: (this_INT_0= RULE_INT )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5729:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL13063); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getNUMBER_LITERALAccess().getINTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleUPPER"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5744:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5745:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5746:2: iv_ruleUPPER= ruleUPPER EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUPPERRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleUPPER_in_entryRuleUPPER13108);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUPPER.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUPPER13119); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5753:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5756:28: ( (this_INT_0= RULE_INT | kw= '*' ) )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5757:1: (this_INT_0= RULE_INT | kw= '*' )
            {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5757:1: (this_INT_0= RULE_INT | kw= '*' )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_INT) ) {
                alt87=1;
            }
            else if ( (LA87_0==36) ) {
                alt87=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5757:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleUPPER13159); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5766:2: kw= '*'
                    {
                    kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleUPPER13183); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getUPPERAccess().getAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUPPER"


    // $ANTLR start "entryRuleURI"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5779:1: entryRuleURI returns [String current=null] : iv_ruleURI= ruleURI EOF ;
    public final String entryRuleURI() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURI = null;


        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5780:2: (iv_ruleURI= ruleURI EOF )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5781:2: iv_ruleURI= ruleURI EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getURIRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleURI_in_entryRuleURI13224);
            iv_ruleURI=ruleURI();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleURI.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleURI13235); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURI"


    // $ANTLR start "ruleURI"
    // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5788:1: ruleURI returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING ;
    public final AntlrDatatypeRuleToken ruleURI() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_SINGLE_QUOTED_STRING_0=null;

         enterRule(); 
            
        try {
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5791:28: (this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING )
            // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:5792:5: this_SINGLE_QUOTED_STRING_0= RULE_SINGLE_QUOTED_STRING
            {
            this_SINGLE_QUOTED_STRING_0=(Token)match(input,RULE_SINGLE_QUOTED_STRING,FollowSets000.FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI13274); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_SINGLE_QUOTED_STRING_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SINGLE_QUOTED_STRING_0, grammarAccess.getURIAccess().getSINGLE_QUOTED_STRINGTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURI"

    // $ANTLR start synpred10_InternalImperativeOCL
    public final void synpred10_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_TupleLiteralExpCS_4 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:435:2: (this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:435:2: this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTupleLiteralExpCS_in_synpred10_InternalImperativeOCL989);
        this_TupleLiteralExpCS_4=ruleTupleLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalImperativeOCL

    // $ANTLR start synpred11_InternalImperativeOCL
    public final void synpred11_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_MapLiteralExpCS_5 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:448:2: (this_MapLiteralExpCS_5= ruleMapLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:448:2: this_MapLiteralExpCS_5= ruleMapLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleMapLiteralExpCS_in_synpred11_InternalImperativeOCL1019);
        this_MapLiteralExpCS_5=ruleMapLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalImperativeOCL

    // $ANTLR start synpred12_InternalImperativeOCL
    public final void synpred12_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_CollectionLiteralExpCS_6 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:461:2: (this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:461:2: this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleCollectionLiteralExpCS_in_synpred12_InternalImperativeOCL1049);
        this_CollectionLiteralExpCS_6=ruleCollectionLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalImperativeOCL

    // $ANTLR start synpred14_InternalImperativeOCL
    public final void synpred14_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_ListLiteralExpCS_8 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:487:2: (this_ListLiteralExpCS_8= ruleListLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:487:2: this_ListLiteralExpCS_8= ruleListLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleListLiteralExpCS_in_synpred14_InternalImperativeOCL1109);
        this_ListLiteralExpCS_8=ruleListLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalImperativeOCL

    // $ANTLR start synpred15_InternalImperativeOCL
    public final void synpred15_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_DictLiteralExpCS_9 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:500:2: (this_DictLiteralExpCS_9= ruleDictLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:500:2: this_DictLiteralExpCS_9= ruleDictLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleDictLiteralExpCS_in_synpred15_InternalImperativeOCL1139);
        this_DictLiteralExpCS_9=ruleDictLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalImperativeOCL

    // $ANTLR start synpred16_InternalImperativeOCL
    public final void synpred16_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralExpCS_10 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:513:2: (this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:513:2: this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralExpCS_in_synpred16_InternalImperativeOCL1169);
        this_TypeLiteralExpCS_10=ruleTypeLiteralExpCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalImperativeOCL

    // $ANTLR start synpred22_InternalImperativeOCL
    public final void synpred22_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject lv_value_2_0 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:810:1: ( (lv_value_2_0= ruleExpCS ) )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:810:1: (lv_value_2_0= ruleExpCS )
        {
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:810:1: (lv_value_2_0= ruleExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:811:3: lv_value_2_0= ruleExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getReturnExpCSAccess().getValueExpCSParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred22_InternalImperativeOCL1827);
        lv_value_2_0=ruleExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred22_InternalImperativeOCL

    // $ANTLR start synpred86_InternalImperativeOCL
    public final void synpred86_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_TypeLiteralCS_1 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3217:2: (this_TypeLiteralCS_1= ruleTypeLiteralCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3217:2: this_TypeLiteralCS_1= ruleTypeLiteralCS
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_ruleTypeLiteralCS_in_synpred86_InternalImperativeOCL7697);
        this_TypeLiteralCS_1=ruleTypeLiteralCS();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_InternalImperativeOCL

    // $ANTLR start synpred88_InternalImperativeOCL
    public final void synpred88_InternalImperativeOCL_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
        {
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: ()
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3293:2: 
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }

        }

        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3301:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
        {
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3303:3: lv_name_2_0= ruleBinaryOperatorName
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred88_InternalImperativeOCL7879);
        lv_name_2_0=ruleBinaryOperatorName();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3319:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
        {
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3321:3: lv_ownedRight_3_0= ruleExpCS
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
          	    
        }
        pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred88_InternalImperativeOCL7900);
        lv_ownedRight_3_0=ruleExpCS();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred88_InternalImperativeOCL

    // $ANTLR start synpred89_InternalImperativeOCL
    public final void synpred89_InternalImperativeOCL_fragment() throws RecognitionException {   
        EObject this_PrefixedPrimaryExpCS_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedRight_3_0 = null;


        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:2: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        {
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3280:2: (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? )
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3281:2: this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        {
        if ( state.backtracking==0 ) {
           
          	  /* */ 
          	
        }
        pushFollow(FollowSets000.FOLLOW_rulePrefixedPrimaryExpCS_in_synpred89_InternalImperativeOCL7846);
        this_PrefixedPrimaryExpCS_0=rulePrefixedPrimaryExpCS();

        state._fsp--;
        if (state.failed) return ;
        // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?
        int alt98=2;
        int LA98_0 = input.LA(1);

        if ( (LA98_0==32||LA98_0==34||(LA98_0>=36 && LA98_0<=51)) ) {
            alt98=1;
        }
        switch (alt98) {
            case 1 :
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) )
                {
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3292:2: ()
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3293:2: 
                {
                if ( state.backtracking==0 ) {
                   
                  	  /* */ 
                  	
                }

                }

                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3301:2: ( (lv_name_2_0= ruleBinaryOperatorName ) )
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
                {
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3302:1: (lv_name_2_0= ruleBinaryOperatorName )
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3303:3: lv_name_2_0= ruleBinaryOperatorName
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getNameBinaryOperatorNameParserRuleCall_0_1_1_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleBinaryOperatorName_in_synpred89_InternalImperativeOCL7879);
                lv_name_2_0=ruleBinaryOperatorName();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3319:2: ( (lv_ownedRight_3_0= ruleExpCS ) )
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
                {
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3320:1: (lv_ownedRight_3_0= ruleExpCS )
                // ../../examples/org.eclipse.qvto.examples.xtext.imperativeocl/src-gen/org/eclipse/qvto/examples/xtext/imperativeocl/parser/antlr/internal/InternalImperativeOCL.g:3321:3: lv_ownedRight_3_0= ruleExpCS
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpCSAccess().getOwnedRightExpCSParserRuleCall_0_1_2_0()); 
                  	    
                }
                pushFollow(FollowSets000.FOLLOW_ruleExpCS_in_synpred89_InternalImperativeOCL7900);
                lv_ownedRight_3_0=ruleExpCS();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }


        }


        }
    }
    // $ANTLR end synpred89_InternalImperativeOCL

    // Delegated rules

    public final boolean synpred11_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred15_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalImperativeOCL() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalImperativeOCL_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA40 dfa40 = new DFA40(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA2_eotS =
        "\46\uffff";
    static final String DFA2_eofS =
        "\46\uffff";
    static final String DFA2_minS =
        "\1\4\13\uffff\7\0\1\uffff\2\0\20\uffff";
    static final String DFA2_maxS =
        "\1\131\13\uffff\7\0\1\uffff\2\0\20\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\16\uffff\1\10\2\uffff\1\13\7\uffff\1\14"+
        "\1\15\1\uffff\1\5\1\6\1\7\1\11\1\12";
    static final String DFA2_specialS =
        "\14\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7\1\10\20\uffff}>";
    static final String[] DFA2_transitionS = {
            "\2\4\2\37\1\4\20\uffff\1\24\1\1\1\uffff\1\25\4\uffff\1\36\2"+
            "\uffff\1\4\17\uffff\1\15\1\14\10\26\1\16\1\17\1\20\1\21\1\22"+
            "\3\uffff\1\23\1\uffff\4\4\7\uffff\1\2\5\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "382:1: (this_NestedExpCS_0= ruleNestedExpCS | this_IfExpCS_1= ruleIfExpCS | this_SelfExpCS_2= ruleSelfExpCS | this_PrimitiveLiteralExpCS_3= rulePrimitiveLiteralExpCS | this_TupleLiteralExpCS_4= ruleTupleLiteralExpCS | this_MapLiteralExpCS_5= ruleMapLiteralExpCS | this_CollectionLiteralExpCS_6= ruleCollectionLiteralExpCS | this_LambdaLiteralExpCS_7= ruleLambdaLiteralExpCS | this_ListLiteralExpCS_8= ruleListLiteralExpCS | this_DictLiteralExpCS_9= ruleDictLiteralExpCS | this_TypeLiteralExpCS_10= ruleTypeLiteralExpCS | this_ReturnExpCS_11= ruleReturnExpCS | this_NameExpCS_12= ruleNameExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_12 = input.LA(1);

                         
                        int index2_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_InternalImperativeOCL()) ) {s = 33;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred11_InternalImperativeOCL()) ) {s = 34;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_13);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalImperativeOCL()) ) {s = 35;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_14);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalImperativeOCL()) ) {s = 35;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_15);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA2_16 = input.LA(1);

                         
                        int index2_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalImperativeOCL()) ) {s = 35;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_16);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA2_17 = input.LA(1);

                         
                        int index2_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalImperativeOCL()) ) {s = 35;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_17);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred12_InternalImperativeOCL()) ) {s = 35;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_18);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_InternalImperativeOCL()) ) {s = 36;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_20);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA2_21 = input.LA(1);

                         
                        int index2_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred15_InternalImperativeOCL()) ) {s = 37;}

                        else if ( (synpred16_InternalImperativeOCL()) ) {s = 22;}

                         
                        input.seek(index2_21);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA7_eotS =
        "\103\uffff";
    static final String DFA7_eofS =
        "\1\44\102\uffff";
    static final String DFA7_minS =
        "\1\4\1\0\11\uffff\1\0\67\uffff";
    static final String DFA7_maxS =
        "\1\131\1\0\11\uffff\1\0\67\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\41\uffff\1\2\36\uffff";
    static final String DFA7_specialS =
        "\1\uffff\1\0\11\uffff\1\1\67\uffff}>";
    static final String[] DFA7_transitionS = {
            "\5\2\20\uffff\2\2\1\44\1\2\1\44\1\uffff\2\44\1\2\1\1\1\2\1"+
            "\13\17\44\17\2\2\44\1\uffff\1\2\1\44\4\2\3\uffff\4\44\1\2\4"+
            "\44\2\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "809:2: ( (lv_value_2_0= ruleExpCS ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_1 = input.LA(1);

                         
                        int index7_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalImperativeOCL()) ) {s = 2;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index7_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA7_11 = input.LA(1);

                         
                        int index7_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_InternalImperativeOCL()) ) {s = 2;}

                        else if ( (true) ) {s = 36;}

                         
                        input.seek(index7_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\25\uffff";
    static final String DFA40_eofS =
        "\25\uffff";
    static final String DFA40_minS =
        "\1\6\12\uffff\5\0\5\uffff";
    static final String DFA40_maxS =
        "\1\102\12\uffff\5\0\5\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\20\uffff\1\3";
    static final String DFA40_specialS =
        "\13\uffff\1\0\1\1\1\2\1\3\1\4\5\uffff}>";
    static final String[] DFA40_transitionS = {
            "\2\1\21\uffff\1\3\2\uffff\1\3\27\uffff\12\3\1\13\1\14\1\15"+
            "\1\16\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "3203:2: (this_TypeNameExpCS_0= ruleTypeNameExpCS | this_TypeLiteralCS_1= ruleTypeLiteralCS | this_CollectionPatternCS_2= ruleCollectionPatternCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_11 = input.LA(1);

                         
                        int index40_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index40_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_13 = input.LA(1);

                         
                        int index40_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index40_13);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_14 = input.LA(1);

                         
                        int index40_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index40_14);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA40_15 = input.LA(1);

                         
                        int index40_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 20;}

                         
                        input.seek(index40_15);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\44\uffff";
    static final String DFA43_eofS =
        "\44\uffff";
    static final String DFA43_minS =
        "\1\4\2\0\41\uffff";
    static final String DFA43_maxS =
        "\1\131\2\0\41\uffff";
    static final String DFA43_acceptS =
        "\3\uffff\1\1\37\uffff\1\2";
    static final String DFA43_specialS =
        "\1\uffff\1\0\1\1\41\uffff}>";
    static final String[] DFA43_transitionS = {
            "\5\3\20\uffff\2\3\1\uffff\1\3\4\uffff\1\3\1\1\1\2\1\3\17\uffff"+
            "\17\3\3\uffff\1\3\1\uffff\4\3\7\uffff\1\3\4\uffff\1\43\1\3",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "3280:1: ( (this_PrefixedPrimaryExpCS_0= rulePrefixedPrimaryExpCS ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )? ) | this_PrefixedLetExpCS_4= rulePrefixedLetExpCS )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA43_1 = input.LA(1);

                         
                        int index43_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index43_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA43_2 = input.LA(1);

                         
                        int index43_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred89_InternalImperativeOCL()) ) {s = 3;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index43_2);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\25\uffff";
    static final String DFA42_eofS =
        "\1\23\24\uffff";
    static final String DFA42_minS =
        "\1\33\22\0\2\uffff";
    static final String DFA42_maxS =
        "\1\127\22\0\2\uffff";
    static final String DFA42_acceptS =
        "\23\uffff\1\2\1\1";
    static final String DFA42_specialS =
        "\1\uffff\1\13\1\7\1\3\1\0\1\20\1\17\1\16\1\15\1\14\1\10\1\4\1\1"+
        "\1\21\1\5\1\11\1\6\1\2\1\12\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\23\1\uffff\1\23\1\uffff\1\23\1\11\1\uffff\1\4\1\uffff\1"+
            "\1\1\2\1\3\1\5\1\6\1\7\1\10\1\12\1\13\1\14\1\15\1\16\1\17\1"+
            "\20\1\21\1\22\17\uffff\2\23\2\uffff\1\23\7\uffff\4\23\1\uffff"+
            "\4\23",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "3292:1: ( () ( (lv_name_2_0= ruleBinaryOperatorName ) ) ( (lv_ownedRight_3_0= ruleExpCS ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_4 = input.LA(1);

                         
                        int index42_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_4);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_12 = input.LA(1);

                         
                        int index42_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_12);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_17 = input.LA(1);

                         
                        int index42_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_17);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_3 = input.LA(1);

                         
                        int index42_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_3);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA42_11 = input.LA(1);

                         
                        int index42_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_11);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA42_14 = input.LA(1);

                         
                        int index42_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_14);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA42_16 = input.LA(1);

                         
                        int index42_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_16);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA42_2 = input.LA(1);

                         
                        int index42_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_2);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA42_10 = input.LA(1);

                         
                        int index42_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA42_18 = input.LA(1);

                         
                        int index42_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_18);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA42_1 = input.LA(1);

                         
                        int index42_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_1);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA42_9 = input.LA(1);

                         
                        int index42_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_9);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA42_8 = input.LA(1);

                         
                        int index42_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_8);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA42_6 = input.LA(1);

                         
                        int index42_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_6);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA42_5 = input.LA(1);

                         
                        int index42_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_5);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA42_13 = input.LA(1);

                         
                        int index42_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred88_InternalImperativeOCL()) ) {s = 20;}

                        else if ( (true) ) {s = 19;}

                         
                        input.seek(index42_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleGrammmarCS_in_entryRuleGrammmarCS81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleGrammmarCS91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImperativeOCLExpCS_in_ruleGrammmarCS140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImperativeOCLExpCS_in_entryRuleImperativeOCLExpCS182 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImperativeOCLExpCS192 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleImperativeOCLExpCS241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS275 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS335 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleTypeLiteralCS395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTypeCS_in_ruleTypeLiteralCS455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictTypeCS_in_ruleTypeLiteralCS485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListTypeCS_in_entryRuleListTypeCS520 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListTypeCS530 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleListTypeCS567 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleListTypeCS579 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleListTypeCS600 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleListTypeCS612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictTypeCS_in_entryRuleDictTypeCS648 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDictTypeCS658 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleDictTypeCS695 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleDictTypeCS707 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleDictTypeCS728 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleDictTypeCS740 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleDictTypeCS761 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleDictTypeCS773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_entryRulePrimaryExpCS809 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpCS819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_rulePrimaryExpCS869 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_rulePrimaryExpCS899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_rulePrimaryExpCS929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_rulePrimaryExpCS959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_rulePrimaryExpCS989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_rulePrimaryExpCS1019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_rulePrimaryExpCS1049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_rulePrimaryExpCS1079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListLiteralExpCS_in_rulePrimaryExpCS1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictLiteralExpCS_in_rulePrimaryExpCS1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_rulePrimaryExpCS1169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReturnExpCS_in_rulePrimaryExpCS1199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_rulePrimaryExpCS1229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListLiteralExpCS_in_entryRuleListLiteralExpCS1264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListLiteralExpCS1274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleListLiteralExpCS1311 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleListLiteralExpCS1323 = new BitSet(new long[]{0xFFF0001E960001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleListLiteralExpCS1357 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleListLiteralExpCS1370 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleListLiteralExpCS1391 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_31_in_ruleListLiteralExpCS1407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictLiteralExpCS_in_entryRuleDictLiteralExpCS1443 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDictLiteralExpCS1453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleDictLiteralExpCS1490 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleDictLiteralExpCS1502 = new BitSet(new long[]{0x0000001080000130L,0x0000000000000F00L});
        public static final BitSet FOLLOW_ruleDictLiteralPartCS_in_ruleDictLiteralExpCS1536 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleDictLiteralExpCS1549 = new BitSet(new long[]{0x0000001000000130L,0x0000000000000F00L});
        public static final BitSet FOLLOW_ruleDictLiteralPartCS_in_ruleDictLiteralExpCS1570 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_31_in_ruleDictLiteralExpCS1586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictLiteralPartCS_in_entryRuleDictLiteralPartCS1622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDictLiteralPartCS1632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_ruleDictLiteralPartCS1678 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleDictLiteralPartCS1690 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleDictLiteralPartCS1711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReturnExpCS_in_entryRuleReturnExpCS1747 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReturnExpCS1757 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleReturnExpCS1794 = new BitSet(new long[]{0xFFF0001E160001F2L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleReturnExpCS1827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1878 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleStringLiteral1918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_DOUBLE_QUOTED_STRING_in_ruleStringLiteral1944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorName_in_entryRuleEssentialOCLUnaryOperatorName1994 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnaryOperatorName2005 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLUnaryOperatorName2043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleEssentialOCLUnaryOperatorName2062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorName_in_entryRuleEssentialOCLInfixOperatorName2103 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorName2114 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleEssentialOCLInfixOperatorName2152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEssentialOCLInfixOperatorName2171 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEssentialOCLInfixOperatorName2190 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleEssentialOCLInfixOperatorName2209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperatorName2228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleEssentialOCLInfixOperatorName2247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorName2266 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleEssentialOCLInfixOperatorName2285 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleEssentialOCLInfixOperatorName2304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleEssentialOCLInfixOperatorName2323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEssentialOCLInfixOperatorName2342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleEssentialOCLInfixOperatorName2361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleEssentialOCLInfixOperatorName2380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleEssentialOCLInfixOperatorName2399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorName_in_entryRuleEssentialOCLNavigationOperatorName2440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLNavigationOperatorName2451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleEssentialOCLNavigationOperatorName2489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleEssentialOCLNavigationOperatorName2508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleEssentialOCLNavigationOperatorName2527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleEssentialOCLNavigationOperatorName2546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_entryRuleBinaryOperatorName2587 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorName2598 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorName_in_ruleBinaryOperatorName2645 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorName_in_ruleBinaryOperatorName2678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfixOperatorName_in_entryRuleInfixOperatorName2724 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfixOperatorName2735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorName_in_ruleInfixOperatorName2781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigationOperatorName_in_entryRuleNavigationOperatorName2826 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorName2837 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLNavigationOperatorName_in_ruleNavigationOperatorName2883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_entryRuleUnaryOperatorName2928 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnaryOperatorName2939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnaryOperatorName_in_ruleUnaryOperatorName2985 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3030 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3087 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3132 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3234 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3358 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleEssentialOCLUnreservedName3382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleEssentialOCLUnreservedName3401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName3442 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName3453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName3499 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURIFirstPathElementCS_in_entryRuleURIFirstPathElementCS3545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURIFirstPathElementCS3555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleURIFirstPathElementCS3607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_ruleURIFirstPathElementCS3653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier3691 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier3702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_rulePrimitiveTypeIdentifier3740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_rulePrimitiveTypeIdentifier3759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_rulePrimitiveTypeIdentifier3778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_rulePrimitiveTypeIdentifier3797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_rulePrimitiveTypeIdentifier3816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_rulePrimitiveTypeIdentifier3835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_rulePrimitiveTypeIdentifier3854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_rulePrimitiveTypeIdentifier3873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS3913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS3923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS3968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier4004 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier4015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleCollectionTypeIdentifier4053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleCollectionTypeIdentifier4072 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleCollectionTypeIdentifier4091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleCollectionTypeIdentifier4110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleCollectionTypeIdentifier4129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS4169 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS4179 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS4225 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleCollectionTypeCS4238 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS4259 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleCollectionTypeCS4271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_entryRuleMapTypeCS4309 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapTypeCS4319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleMapTypeCS4362 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleMapTypeCS4388 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS4409 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleMapTypeCS4421 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleMapTypeCS4442 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleMapTypeCS4454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS4492 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS4502 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTupleTypeCS4545 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleTupleTypeCS4571 = new BitSet(new long[]{0x00000000080000C0L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS4593 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_29_in_ruleTupleTypeCS4606 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS4627 = new BitSet(new long[]{0x0000000028000000L});
        public static final BitSet FOLLOW_27_in_ruleTupleTypeCS4643 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS4681 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS4691 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS4737 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleTuplePartCS4749 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS4770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS4806 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS4816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS4862 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCollectionLiteralExpCS4874 = new BitSet(new long[]{0xFFF0001E960001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS4896 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleCollectionLiteralExpCS4909 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS4930 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_31_in_ruleCollectionLiteralExpCS4946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS4982 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS4992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5039 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleCollectionLiteralPartCS5052 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleCollectionLiteralPartCS5073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionLiteralPartCS5103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_entryRuleCollectionPatternCS5139 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCollectionPatternCS5149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionPatternCS5195 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleCollectionPatternCS5207 = new BitSet(new long[]{0xFFF0001E960001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS5229 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_29_in_ruleCollectionPatternCS5242 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleCollectionPatternCS5263 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCollectionPatternCS5278 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleIdentifier_in_ruleCollectionPatternCS5299 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleCollectionPatternCS5314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_entryRuleShadowPartCS5350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleShadowPartCS5360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleShadowPartCS5412 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleShadowPartCS5424 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleShadowPartCS5447 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleShadowPartCS5466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_entryRulePatternExpCS5505 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePatternExpCS5515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_rulePatternExpCS5561 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_rulePatternExpCS5574 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_rulePatternExpCS5595 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLambdaLiteralExpCS_in_entryRuleLambdaLiteralExpCS5631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLambdaLiteralExpCS5641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleLambdaLiteralExpCS5678 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleLambdaLiteralExpCS5690 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLambdaLiteralExpCS5711 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleLambdaLiteralExpCS5723 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_entryRuleMapLiteralExpCS5759 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralExpCS5769 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapTypeCS_in_ruleMapLiteralExpCS5815 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleMapLiteralExpCS5827 = new BitSet(new long[]{0xFFF0001E960001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS5849 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleMapLiteralExpCS5862 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_ruleMapLiteralExpCS5883 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_31_in_ruleMapLiteralExpCS5899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralPartCS_in_entryRuleMapLiteralPartCS5935 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMapLiteralPartCS5945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS5991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleMapLiteralPartCS6003 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleMapLiteralPartCS6024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS6060 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS6070 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS6120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS6150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS6180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS6210 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS6240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS6270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS6305 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS6315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleTupleLiteralExpCS6352 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleTupleLiteralExpCS6364 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6385 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleTupleLiteralExpCS6398 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS6419 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_31_in_ruleTupleLiteralExpCS6433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS6469 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS6479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS6525 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleTupleLiteralPartCS6538 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS6559 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleTupleLiteralPartCS6573 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTupleLiteralPartCS6594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS6630 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS6640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS6685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS6720 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS6730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringLiteralExpCS6775 = new BitSet(new long[]{0x0000000000000032L});
        public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS6811 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS6821 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleBooleanLiteralExpCS6864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleBooleanLiteralExpCS6901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS6950 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS6960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUnlimitedNaturalLiteralExpCS7009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS7045 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS7055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleInvalidLiteralExpCS7104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS7140 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS7150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleNullLiteralExpCS7199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7235 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7245 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7295 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7315 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS7352 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS7362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS7407 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS7442 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS7452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS7498 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleTypeNameExpCS7520 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleTypeNameExpCS7533 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleTypeNameExpCS7554 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleTypeNameExpCS7566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS7606 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS7616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS7667 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeExpCS7697 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleCollectionPatternCS_in_ruleTypeExpCS7727 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS7748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_entryRuleExpCS7785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpCS7795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_ruleExpCS7846 = new BitSet(new long[]{0x000FFFF500000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_ruleExpCS7879 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleExpCS7900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_ruleExpCS7934 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_entryRulePrefixedLetExpCS7969 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedLetExpCS7979 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedLetExpCS8038 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_rulePrefixedLetExpCS_in_rulePrefixedLetExpCS8059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrefixedLetExpCS8091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_entryRulePrefixedPrimaryExpCS8126 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrefixedPrimaryExpCS8136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnaryOperatorName_in_rulePrefixedPrimaryExpCS8195 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000002080F47L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_rulePrefixedPrimaryExpCS8216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrimaryExpCS_in_rulePrefixedPrimaryExpCS8248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNameExpCS_in_entryRuleNameExpCS8283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNameExpCS8293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleNameExpCS8339 = new BitSet(new long[]{0x0000000044000002L,0x0000000000005000L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_ruleNameExpCS8360 = new BitSet(new long[]{0x0000000044000002L,0x0000000000005000L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleNameExpCS8382 = new BitSet(new long[]{0x0000000040000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_ruleNameExpCS8404 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleNameExpCS8424 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleNameExpCS8449 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCurlyBracketedClauseCS_in_entryRuleCurlyBracketedClauseCS8487 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCurlyBracketedClauseCS8497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleCurlyBracketedClauseCS8546 = new BitSet(new long[]{0x00000000800000F0L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8569 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_29_in_ruleCurlyBracketedClauseCS8582 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleShadowPartCS_in_ruleCurlyBracketedClauseCS8603 = new BitSet(new long[]{0x00000000A0000000L});
        public static final BitSet FOLLOW_ruleStringLiteral_in_ruleCurlyBracketedClauseCS8634 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleCurlyBracketedClauseCS8647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_entryRuleRoundBracketedClauseCS8683 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoundBracketedClauseCS8693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleRoundBracketedClauseCS8742 = new BitSet(new long[]{0xFFF0001E1E0001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_ruleRoundBracketedClauseCS8764 = new BitSet(new long[]{0x0000000028000000L,0x0000000000060000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8785 = new BitSet(new long[]{0x0000000028000000L,0x0000000000060000L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_ruleRoundBracketedClauseCS8808 = new BitSet(new long[]{0x0000000028000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8829 = new BitSet(new long[]{0x0000000028000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_ruleRoundBracketedClauseCS8854 = new BitSet(new long[]{0x0000000028000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_ruleRoundBracketedClauseCS8875 = new BitSet(new long[]{0x0000000028000000L,0x0000000000020000L});
        public static final BitSet FOLLOW_27_in_ruleRoundBracketedClauseCS8892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSquareBracketedClauseCS_in_entryRuleSquareBracketedClauseCS8928 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSquareBracketedClauseCS8938 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleSquareBracketedClauseCS8975 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS8996 = new BitSet(new long[]{0x0000000020000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_29_in_ruleSquareBracketedClauseCS9009 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleSquareBracketedClauseCS9030 = new BitSet(new long[]{0x0000000020000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleSquareBracketedClauseCS9044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9080 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS9090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9137 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010008L});
        public static final BitSet FOLLOW_67_in_ruleNavigatingArgCS9151 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9172 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingArgCS9185 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleNavigatingArgCS9228 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgCS9249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_67_in_ruleNavigatingArgCS9272 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleNavigatingBarArgCS9383 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9417 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleNavigatingBarArgCS9430 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS9451 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingBarArgCS9464 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingBarArgCS9485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS9525 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS9535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleNavigatingCommaArgCS9578 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS9612 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010008L});
        public static final BitSet FOLLOW_67_in_ruleNavigatingCommaArgCS9626 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS9647 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingCommaArgCS9660 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleNavigatingCommaArgCS9703 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingCommaArgCS9724 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS9763 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS9773 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleNavigatingSemiArgCS9816 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS9850 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleNavigatingSemiArgCS9863 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS9884 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleNavigatingSemiArgCS9897 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingSemiArgCS9918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS9958 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS9968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNavigatingArgExpCS10017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10051 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS10061 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleIfExpCS10098 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F4FL});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10121 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_rulePatternExpCS_in_ruleIfExpCS10140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleIfExpCS10155 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_ruleIfExpCS10197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000A00000L});
        public static final BitSet FOLLOW_85_in_ruleIfExpCS10210 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleIfExpCS10231 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
        public static final BitSet FOLLOW_86_in_ruleIfExpCS10243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElseIfThenExpCS_in_entryRuleElseIfThenExpCS10279 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElseIfThenExpCS10289 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleElseIfThenExpCS10326 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
        public static final BitSet FOLLOW_84_in_ruleElseIfThenExpCS10359 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleElseIfThenExpCS10380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS10416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS10426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleLetExpCS10463 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10484 = new BitSet(new long[]{0x0000000020000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_29_in_ruleLetExpCS10497 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS10518 = new BitSet(new long[]{0x0000000020000000L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleLetExpCS10532 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetExpCS10553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS10589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS10599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS10645 = new BitSet(new long[]{0x0000000104000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_ruleRoundBracketedClauseCS_in_ruleLetVariableCS10666 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleLetVariableCS10680 = new BitSet(new long[]{0xFFF00000120000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS10701 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLetVariableCS10715 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleLetVariableCS10736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS10772 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS10782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleNestedExpCS10819 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_ruleNestedExpCS10840 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleNestedExpCS10852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS10888 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS10898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleSelfExpCS10947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS10983 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS10993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS11039 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleMultiplicityBoundsCS11052 = new BitSet(new long[]{0x0000001000000100L});
        public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS11073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS11111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS11121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleMultiplicityCS11158 = new BitSet(new long[]{0x0000005000000100L,0x0000000010000000L});
        public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS11184 = new BitSet(new long[]{0x0000000000000000L,0x000000000C008000L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS11214 = new BitSet(new long[]{0x0000000000000000L,0x000000000C008000L});
        public static final BitSet FOLLOW_90_in_ruleMultiplicityCS11227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_91_in_ruleMultiplicityCS11251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
        public static final BitSet FOLLOW_79_in_ruleMultiplicityCS11278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS11314 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS11324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleMultiplicityStringCS11368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleMultiplicityStringCS11397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleMultiplicityStringCS11426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS11477 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS11487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS11533 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_93_in_rulePathNameCS11546 = new BitSet(new long[]{0xFFF00000000000C0L,0x0000000000000007L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS11567 = new BitSet(new long[]{0x0000000000000002L,0x0000000020000000L});
        public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS11605 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS11615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS11666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS11701 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS11711 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS11762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_entryRuleTemplateBindingCS11797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBindingCS11807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11853 = new BitSet(new long[]{0x0000000020000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_29_in_ruleTemplateBindingCS11866 = new BitSet(new long[]{0x00000000000000C0L,0x0000000010000000L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_ruleTemplateBindingCS11887 = new BitSet(new long[]{0x0000000020000002L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTemplateBindingCS11910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTemplateParameterSubstitutionCS_in_entryRuleTemplateParameterSubstitutionCS11947 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTemplateParameterSubstitutionCS11957 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_ruleTemplateParameterSubstitutionCS12002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeParameterCS_in_entryRuleTypeParameterCS12039 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeParameterCS12049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTypeParameterCS12095 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleTypeParameterCS12108 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS12129 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
        public static final BitSet FOLLOW_95_in_ruleTypeParameterCS12142 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeParameterCS12163 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
        public static final BitSet FOLLOW_ruleTypeRefCS_in_entryRuleTypeRefCS12203 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypeRefCS12213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleTypeRefCS12263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_ruleTypeRefCS12293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_entryRuleTypedRefCS12328 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedRefCS12338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_ruleTypedRefCS12387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypedTypeRefCS_in_entryRuleTypedTypeRefCS12421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTypedTypeRefCS12431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypedTypeRefCS12477 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleTypedTypeRefCS12490 = new BitSet(new long[]{0x00000000000000C0L,0x0000000010000000L});
        public static final BitSet FOLLOW_ruleTemplateBindingCS_in_ruleTypedTypeRefCS12511 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleTypedTypeRefCS12523 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWildcardTypeRefCS_in_entryRuleWildcardTypeRefCS12561 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWildcardTypeRefCS12571 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleWildcardTypeRefCS12620 = new BitSet(new long[]{0x0000000000000002L,0x0000000040000000L});
        public static final BitSet FOLLOW_94_in_ruleWildcardTypeRefCS12633 = new BitSet(new long[]{0x00000000000000C0L});
        public static final BitSet FOLLOW_ruleTypedRefCS_in_ruleWildcardTypeRefCS12654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_entryRuleID12693 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleID12704 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SIMPLE_ID_in_ruleID12744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ESCAPED_ID_in_ruleID12770 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier12816 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier12827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleID_in_ruleIdentifier12873 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER12918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLOWER12929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER12968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL13013 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL13024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL13063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER13108 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUPPER13119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER13159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleUPPER13183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleURI_in_entryRuleURI13224 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleURI13235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_SINGLE_QUOTED_STRING_in_ruleURI13274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_synpred10_InternalImperativeOCL989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMapLiteralExpCS_in_synpred11_InternalImperativeOCL1019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_synpred12_InternalImperativeOCL1049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListLiteralExpCS_in_synpred14_InternalImperativeOCL1109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDictLiteralExpCS_in_synpred15_InternalImperativeOCL1139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_synpred16_InternalImperativeOCL1169 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred22_InternalImperativeOCL1827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTypeLiteralCS_in_synpred86_InternalImperativeOCL7697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred88_InternalImperativeOCL7879 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred88_InternalImperativeOCL7900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrefixedPrimaryExpCS_in_synpred89_InternalImperativeOCL7846 = new BitSet(new long[]{0x000FFFF500000002L});
        public static final BitSet FOLLOW_ruleBinaryOperatorName_in_synpred89_InternalImperativeOCL7879 = new BitSet(new long[]{0xFFF0001E160001F0L,0x0000000003080F47L});
        public static final BitSet FOLLOW_ruleExpCS_in_synpred89_InternalImperativeOCL7900 = new BitSet(new long[]{0x0000000000000002L});
    }


}