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

import lpg.runtime.*;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;	
import org.eclipse.ocl.lpg.DerivedPrsStream;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.ILexStream;
import lpg.runtime.Monitor;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;	
	
import org.eclipse.ocl.ParserException;
import lpg.runtime.Token;
import lpg.runtime.BacktrackingParser;
import lpg.runtime.PrsStream;
import lpg.runtime.NotBacktrackParseTableException;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.AssignStatementCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.LogExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.BlockExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.ReturnExpCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchAltExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ScopedNameCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ForExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
	
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingBodyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingEndCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingInitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingExtensionCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingRuleCS;	
import org.eclipse.m2m.internal.qvt.oml.cst.MappingQueryCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ConstructorCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingSectionsCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ObjectExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ResolveOpArgsExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModuleRefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MultiplicityDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.OppositePropertyCS;
import org.eclipse.ocl.cst.PrimitiveLiteralExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;	
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.Environment;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParserprs;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;	
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	

public class LightweightParser extends AbstractQVTParser implements RuleAction
{
    private DerivedPrsStream prsStream = null;
    
    private boolean unimplementedSymbolsWarning = false;

    private static ParseTable prsTable = new LightweightParserprs();
    @Override
    public ParseTable getParseTable() { return prsTable; }

    private BacktrackingParser btParser = null;
    public BacktrackingParser getParser() { return btParser; }

    @Override
    protected void setResult(Object object) { btParser.setSym1(object); }
    @Override
    protected Object getRhsSym(int i) { return btParser.getSym(i); }

    @Override
    protected int getRhsTokenIndex(int i) { return btParser.getToken(i); }
    @Override
    protected IToken getRhsIToken(int i) { return prsStream.getIToken(getRhsTokenIndex(i)); }
    
    @Override
    protected int getRhsFirstTokenIndex(int i) { return btParser.getFirstToken(i); }
    @Override
    protected IToken getRhsFirstIToken(int i) { return prsStream.getIToken(getRhsFirstTokenIndex(i)); }

    @Override
    protected int getRhsLastTokenIndex(int i) { return btParser.getLastToken(i); }
    @Override
    protected IToken getRhsLastIToken(int i) { return prsStream.getIToken(getRhsLastTokenIndex(i)); }

    @Override
    protected int getLeftSpan() { return btParser.getFirstToken(); }
    @Override
    protected IToken getLeftIToken()  { return prsStream.getIToken(getLeftSpan()); }

    @Override
    protected int getRightSpan() { return btParser.getLastToken(); }
    @Override
    protected IToken getRightIToken() { return prsStream.getIToken(getRightSpan()); }

    @Override
    protected int getRhsErrorTokenIndex(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (err instanceof ErrorToken ? index : 0);
    }
    @Override
    protected ErrorToken getRhsErrorIToken(int i)
    {
        int index = btParser.getToken(i);
        IToken err = prsStream.getIToken(index);
        return (ErrorToken) (err instanceof ErrorToken ? err : null);
    }

	@SuppressWarnings("nls") //$NON-NLS-1$
    @Override
    public void reset(ILexStream lexStream)
    {
        prsStream = new DerivedPrsStream(getEnvironment(), lexStream);
        btParser.reset(prsStream);

        try
        {
            prsStream.remapTerminalSymbols(orderedTerminalSymbols(), prsTable.getEoftSymbol());
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e)
        {
            if (unimplementedSymbolsWarning) {
                java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
                System.out.println("The Lexer will not scan the following token(s):"); //$NON-NLS-1$
                for (int i = 0; i < unimplemented_symbols.size(); i++)
                {
                    Integer id = (Integer) unimplemented_symbols.get(i);
                    System.out.println("    " + LightweightParsersym.orderedTerminalSymbols[id.intValue()]);                //$NON-NLS-1$
                }
                System.out.println();
            }
        }
        catch(UndefinedEofSymbolException e)
        {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " + //$NON-NLS-1$
                                 LightweightParsersym.orderedTerminalSymbols[prsTable.getEoftSymbol()]));
        } 
    }
    
    @SuppressWarnings("nls") //$NON-NLS-1$
    public LightweightParser(QVTOLexer lexer)        
    {
    		super(lexer);
        try
        {
            btParser = new BacktrackingParser(prsStream, prsTable, this);
        }
        catch (NotBacktrackParseTableException e)
        {
            throw new Error(new NotBacktrackParseTableException
                                ("Regenerate LightweightParserprs.java with -BACKTRACK option")); //$NON-NLS-1$
        }
        catch (BadParseSymFileException e)
        {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- LightweightParsersym.java")); //$NON-NLS-1$
        }
        
        ILexStream lexStream = lexer.getILexStream();
        if (lexStream != null) {
        	reset(lexStream);
        }
    }
    
    @Override
    public int numTokenKinds() { return LightweightParsersym.numTokenKinds; }
    @Override
    public String[] orderedTerminalSymbols() { return LightweightParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return LightweightParsersym.orderedTerminalSymbols[kind]; }
    public int getEOFTokenKind() { return prsTable.getEoftSymbol(); }
    @Override
    public DerivedPrsStream getIPrsStream() { return prsStream; }

    @Override
    public CSTNode parser()
    {
        return parser(null, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(Monitor monitor)
    {
        return parser(monitor, getDefaultRepairCount());
    }
    
    @Override
    public CSTNode parser(int error_repair_count)
    {
        return parser(null, error_repair_count);
    }

    @Override
    public CSTNode parser(Monitor monitor, int error_repair_count)
    {
        btParser.setMonitor(monitor);
        
        try
        {
        	if (error_repair_count > 0)
            	return (CSTNode) btParser.fuzzyParse(error_repair_count);
            else
            	return (CSTNode) btParser.parse(error_repair_count);
        }
        catch (BadParseException e)
        {
            prsStream.reset(e.error_token); // point to error token

            DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
            diagnoseParser.diagnose(e.error_token);
        }

        return null;
    }

    //
    // Additional entry points, if any
    //
    


public Environment<?,?,?,?,?,?,?,?,?,?,?,?> getOCLEnvironment() {
	return getLexer().getOCLEnvironment();
}
	
@Override
public QVTOLexer getLexer() {
	return (QVTOLexer) super.getLexer();
}



// Some methods for backwards compatibility 
/**
* <p>
* Before 3.0, this method was used with the now-deprecated  "dollar"getToken macro (which //$NON-NLS-1$
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
*
* <p>
* In an action-block of a rule, instead of doing <code>getIToken("dollar"getToken(i))</code>  //$NON-NLS-1$
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @return the correspondent IToken.
*
* @since 3.0	
*/
@Deprecated
protected IToken getIToken(int i) {
	return prsStream.getIToken(i);
}

/**
* <p>
* Before 3.0, this method was used with the now-deprecated "dollar"getToken macro (which //$NON-NLS-1$
* provided token index in the prsStream) to obtain an IToken f a rule given the index of the
* right hand side token in the said rule. In 3.0 a convenience method has been introduced
* in order to directly return the IToken, given the index of the right hand side token in the rule.
* </p> 
* 
* <p>
* In an action-block of a rule, instead of doing <code>getTokenText("dollar"getToken(i))</code>  //$NON-NLS-1$
* you should do <code>getRhsTokenText(i)</code>
* </p>
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*/
@Deprecated
protected String getTokenText(int i) {
	return prsStream.getTokenText(i);
}

/**
* A convenience method to obtain the text of a right hand side IToken.
*  
* @param i the right hand side token index
* @result the text of the correspondent right hand side IToken.
*
* @since 3.0
*/
protected String getRhsTokenText(int i) { 
	return prsStream.getTokenText(getRhsTokenIndex(i));
}

	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);
							
	
	private void diagnozeErrorToken(int token_index) {
		//IToken token = getIToken(token_index);
		//if (token instanceof lpg.runtime.ErrorToken) {
		//	token = ((lpg.runtime.ErrorToken) token).getErrorToken();
		//}			
		//reportError(lpg.runtime.ParseErrorCodes.MISPLACED_CODE, token.getTokenIndex(), token.getTokenIndex(),  
		//		"'" +  //$NON-NLS-1$
		//		token.toString() + "'"); //$NON-NLS-1$

		prsStream.reset(token_index); // point to error token
		DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
		diagnoseParser.diagnose(token_index);
		setResult(null);
	}

	@SuppressWarnings("unchecked")
    public void ruleAction(int ruleNumber)
    {
        switch (ruleNumber)
        {

            //
            // Rule 16:  conceptualOperationNameCS ::= conceptualOperationName
            //
            case 16: {
               //#line 296 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createConceptualOperationNameCS(iToken);
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
     
            //
            // Rule 28:  tupleKeywordCS ::= Tuple
            //
            
            case 28:

            //
            // Rule 29:  reservedKeywordCS ::= reservedKeyword
            //
            case 29: {
               //#line 319 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            iToken
                        );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 33:  selfKeywordCS ::= self
            //
            case 33: {
               //#line 338 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.SELF_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 34:  simpleNameCS ::= IDENTIFIER
            //
            case 34: {
               //#line 350 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 36:  QuotedSimpleNameCS ::= QUOTED_IDENTIFIER
            //
            case 36: {
               //#line 362 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken iToken = getRhsIToken(1);
                SimpleNameCS result = createQuotedSimpleNameCS(
                        SimpleTypeEnum.IDENTIFIER_LITERAL,
                        iToken
                    );
                setOffsets(result, iToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 37:  QuotedSimpleNameCS ::= QuotedSimpleNameCS STRING_LITERAL
            //
            case 37: {
               //#line 373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS string = (SimpleNameCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                SimpleNameCS result = extendQuotedSimpleNameCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 40:  pathNameCS ::= simpleNameCS
            //
            case 40: {
               //#line 386 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleName = (SimpleNameCS)getRhsSym(1);
                PathNameCS result = createPathNameCS(simpleName);
                setOffsets(result, simpleName);
                setResult(result);
                      break;
            }
    
            //
            // Rule 41:  pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
            //
            case 41: {
               //#line 394 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS result = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                result = extendPathNameCS(result, simpleNameCS);
                setOffsets(result, result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 42:  primitiveTypeCS ::= Boolean
            //
            case 42: {
               //#line 407 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.BOOLEAN_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 43:  primitiveTypeCS ::= Integer
            //
            case 43: {
               //#line 417 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.INTEGER_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 44:  primitiveTypeCS ::= Real
            //
            case 44: {
               //#line 427 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.REAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 45:  primitiveTypeCS ::= String
            //
            case 45: {
               //#line 437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.STRING_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 46:  primitiveTypeCS ::= UnlimitedNatural
            //
            case 46: {
               //#line 447 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 47:  primitiveTypeCS ::= OclAny
            //
            case 47: {
               //#line 458 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_ANY_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 48:  primitiveTypeCS ::= OclInvalid
            //
            case 48: {
               //#line 468 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_INVALID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 49:  primitiveTypeCS ::= OclVoid
            //
            case 49: {
               //#line 478 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PrimitiveTypeCS result = createPrimitiveTypeCS(
                        SimpleTypeEnum.OCL_VOID_LITERAL,
                        getRhsTokenText(1)
                    );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 50:  CollectionTypeIdentifierCS ::= Set
            //
            case 50: {
               //#line 489 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 51:  CollectionTypeIdentifierCS ::= Bag
            //
            case 51: {
               //#line 499 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.BAG_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 52:  CollectionTypeIdentifierCS ::= Sequence
            //
            case 52: {
               //#line 509 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.SEQUENCE_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 53:  CollectionTypeIdentifierCS ::= Collection
            //
            case 53: {
               //#line 519 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.COLLECTION_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 54:  CollectionTypeIdentifierCS ::= OrderedSet
            //
            case 54: {
               //#line 529 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS result = createCollectionTypeCS(
                            CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL,
                            getRhsTokenText(1)
                        );
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 59:  collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS )
            //
            case 59: {
               //#line 545 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS result = (CollectionTypeCS)getRhsSym(1);
                result.setTypeCS((TypeCS)getRhsSym(3));
                setOffsets(result, result, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 60:  tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
            //
            case 60: {
               //#line 554 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                 TupleTypeCS result = createTupleTypeCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 61:  tupleTypePartsCSopt ::= $Empty
            //
            case 61: {
               //#line 562 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<VariableCS>());
                      break;
            }
    
            //
            // Rule 63:  tupleTypePartsCS ::= typedUninitializedVariableCS
            //
            case 63: {
               //#line 569 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 64:  tupleTypePartsCS ::= tupleTypePartsCS , typedUninitializedVariableCS
            //
            case 64: {
               //#line 576 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 65:  untypedUninitializedVariableCS ::= simpleNameCS
            //
            case 65: {
               //#line 587 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                VariableCS result = createVariableCS(name, null, null);
                setOffsets(result, name);
                setResult(result);
                      break;
            }
    
            //
            // Rule 66:  typedUninitializedVariableCS ::= simpleNameCS : typeCS
            //
            case 66: {
               //#line 596 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, type, null);
                setOffsets(result, name, type);
                setResult(result);
                      break;
            }
    
            //
            // Rule 67:  untypedInitializedVariableCS ::= simpleNameCS = OclExpressionCS
            //
            case 67: {
               //#line 606 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(3);
                VariableCS result = createVariableCS(name, null, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 68:  typedInitializedVariableCS ::= simpleNameCS : typeCS = OclExpressionCS
            //
            case 68: {
               //#line 616 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                TypeCS type = (TypeCS)getRhsSym(3);
                OCLExpressionCS initExpression = (OCLExpressionCS)getRhsSym(5);
                VariableCS result = createVariableCS(name, type, initExpression);
                setOffsets(result, name, initExpression);
                setResult(result);
                      break;
            }
    
            //
            // Rule 80:  CollectionLiteralExpCS ::= CollectionTypeIdentifierCS { CollectionLiteralPartsCSopt }
            //
            case 80: {
               //#line 649 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionTypeCS typeCS = (CollectionTypeCS)getRhsSym(1);
                CollectionLiteralExpCS result = createCollectionLiteralExpCS(
                        typeCS,
                        (EList<CollectionLiteralPartCS>)getRhsSym(3)
                    );
                setOffsets(result, typeCS, getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 81:  CollectionLiteralPartsCSopt ::= $Empty
            //
            case 81: {
               //#line 672 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<CollectionLiteralPartCS>());
                      break;
            }
    
            //
            // Rule 83:  CollectionLiteralPartsCS ::= CollectionLiteralPartCS
            //
            case 83: {
               //#line 679 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
                result.add((CollectionLiteralPartCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 84:  CollectionLiteralPartsCS ::= CollectionLiteralPartsCS , CollectionLiteralPartCS
            //
            case 84: {
               //#line 686 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>)getRhsSym(1);
                result.add((CollectionLiteralPartCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 86:  CollectionLiteralPartCS ::= OclExpressionCS
            //
            case 86: {
               //#line 695 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionLiteralPartCS(
                        (OCLExpressionCS)getRhsSym(1)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 87:  CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
            //
            case 87: {
               //#line 705 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CollectionLiteralPartCS result = createCollectionRangeCS(
                        (OCLExpressionCS)getRhsSym(1),
                        (OCLExpressionCS)getRhsSym(3)
                    );
                setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 95:  TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
            //
            case 95: {
               //#line 724 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>)getRhsSym(3));
                setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 96:  TupleLiteralPartsCS ::= initializedVariableCS
            //
            case 96: {
               //#line 732 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 97:  TupleLiteralPartsCS ::= TupleLiteralPartsCS , initializedVariableCS
            //
            case 97: {
               //#line 739 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 98:  IntegerLiteralExpCS ::= INTEGER_LITERAL
            //
            case 98: {
               //#line 747 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 99:  RealLiteralExpCS ::= REAL_LITERAL
            //
            case 99: {
               //#line 755 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 100:  StringLiteralExpCS ::= STRING_LITERAL
            //
            case 100: {
               //#line 763 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                IToken literalToken = getRhsIToken(1);
                StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
                setOffsets(result, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 101:  StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
            //
            case 101: {
               //#line 771 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                StringLiteralExpCS string = (StringLiteralExpCS)getRhsSym(1);
                IToken literalToken = getRhsIToken(2);
                StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
                setOffsets(result, string, literalToken);
                setResult(result);
                      break;
            }
    
            //
            // Rule 102:  BooleanLiteralExpCS ::= true
            //
            case 102: {
               //#line 781 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 103:  BooleanLiteralExpCS ::= false
            //
            case 103: {
               //#line 788 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 104:  UnlimitedNaturalLiteralExpCS ::= *
            //
            case 104: {
               //#line 796 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 105:  InvalidLiteralExpCS ::= invalid
            //
            case 105: {
               //#line 804 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 106:  NullLiteralExpCS ::= null
            //
            case 106: {
               //#line 812 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
                setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
     
            //
            // Rule 107:  TypeLiteralExpCS ::= primitiveTypeCS
            //
            
            case 107:
 
            //
            // Rule 108:  TypeLiteralExpCS ::= collectionTypeCS
            //
            
            case 108:

            //
            // Rule 109:  TypeLiteralExpCS ::= tupleTypeCS
            //
            case 109: {
               //#line 826 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 114:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS | OclExpressionCS )
            //
            case 114: {
               //#line 851 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 115:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 115: {
               //#line 868 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(5);
                VariableCS variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        variableCS,
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 116:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( typedUninitializedVariableCS , uninitializedVariableCS | OclExpressionCS )
            //
            case 116: {
               //#line 888 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IteratorExpCS result = createIteratorExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 117:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( typedInitializedVariableCS | OclExpressionCS )
            //
            case 117: {
               //#line 909 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        null,
                        (OCLExpressionCS)getRhsSym(7)
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 118:  IterateExpCS ::= primaryExpCS -> simpleNameCS ( uninitializedVariableCS ; typedInitializedVariableCS | OclExpressionCS )
            //
            case 118: {
               //#line 925 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IterateExpCS result = createIterateExpCS(
                        source,
                        simpleNameCS,
                        (VariableCS)getRhsSym(5),
                        (VariableCS)getRhsSym(7),
                        (OCLExpressionCS)getRhsSym(9)
                    );
                setOffsets(result, source, getRhsIToken(10));
                setResult(result);
                      break;
            }
    
            //
            // Rule 122:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
            //
            case 122: {
               //#line 947 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, source, getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 123:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( OclExpressionCS )
            //
            case 123: {
               //#line 961 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS arg = (OCLExpressionCS)getRhsSym(5);
                OCLExpressionCS result;
                if (isIterator(simpleNameCS.getValue())) {
                    result = createIteratorExpCS(
                            source,
                            simpleNameCS,
                            null,
                            null,
                            arg
                        );
                }
                else {
                    EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                    args.add(arg);
                    result = createArrowOperationCallExpCS(
                            source,
                            simpleNameCS,
                            null,
                            args
                        );
                }
                setOffsets(result, source, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 124:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( notNameExpressionCS , argumentsCS )
            //
            case 124: {
               //#line 991 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, (OCLExpressionCS)getRhsSym(5));
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
    
            //
            // Rule 125:  OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( simpleNameCS , argumentsCS )
            //
            case 125: {
               //#line 1007 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS variableExpCS = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(variableExpCS, simpleNameCS);
                EList<OCLExpressionCS> args = (EList<OCLExpressionCS>)getRhsSym(7);
                args.add(0, variableExpCS);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                OperationCallExpCS result = createArrowOperationCallExpCS(
                        source,
                        (SimpleNameCS)getRhsSym(3),
                        null,
                        args
                    );
                setOffsets(result, source, getRhsIToken(8));
                setResult(result);
                      break;
            }
     
            //
            // Rule 126:  OperationCallExpCS ::= primaryExpCS . conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            
            case 126:

            //
            // Rule 127:  OperationCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 127: {
               //#line 1033 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(4),
                        (EList<OCLExpressionCS>)getRhsSym(6)
                    );
                setOffsets(result, source, getRhsIToken(7));
                setResult(result);
                      break;
            }
    
            //
            // Rule 128:  OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 128: {
               //#line 1049 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        null,
                        (SimpleNameCS)getRhsSym(1),
                        (IsMarkedPreCS)getRhsSym(2),
                        (EList<OCLExpressionCS>)getRhsSym(4)
                    );
                setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 129:  OperationCallExpCS ::= pathNameCS :: unreservedSimpleNameCS ( argumentsCSopt )
            //
            case 129: {
               //#line 1063 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                OperationCallExpCS result = createDotOperationCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        null,
                        (EList<OCLExpressionCS>)getRhsSym(5)
                    );
                setOffsets(result, pathNameCS, getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 130:  OperationCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
            //
            case 130: {
               //#line 1081 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                CallExpCS result = createDotOperationCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        (IsMarkedPreCS)getRhsSym(6),
                        (EList<OCLExpressionCS>)getRhsSym(8)
                    );
                setOffsets(result, source, getRhsIToken(9));
                setResult(result);
                      break;
            }
    
            //
            // Rule 132:  PropertyCallExpCS ::= pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 132: {
               //#line 1105 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        null,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, pathNameCS, isMarkedPreCS);
                } else {
                    setOffsets(result, pathNameCS, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 133:  PropertyCallExpCS ::= primaryExpCS . pathNameCS :: unreservedSimpleNameCS isMarkedPreCSopt
            //
            case 133: {
               //#line 1126 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                PathNameCS pathNameCS = (PathNameCS)getRhsSym(3);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(5);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(6);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        pathNameCS,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 134:  AssociationClassCallExpCS ::= primaryExpCS . simpleNameCS isMarkedPreCSopt
            //
            case 134: {
               //#line 1149 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
                IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)getRhsSym(4);
                FeatureCallExpCS result = createFeatureCallExpCS(
                        source,
                        null,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        isMarkedPreCS
                    );
                if (isMarkedPreCS != null) {
                    setOffsets(result, source, isMarkedPreCS);
                } else {
                    setOffsets(result, source, simpleNameCS);
                }
                setResult(result);
                      break;
            }
    
            //
            // Rule 135:  isMarkedPreCSopt ::= $Empty
            //
            case 135: {
               //#line 1211 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(null);
                      break;
            }
    
            //
            // Rule 136:  argumentsCSopt ::= $Empty
            //
            case 136: {
               //#line 1217 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(new BasicEList<OCLExpressionCS>());
                      break;
            }
    
            //
            // Rule 138:  argumentsCS ::= OclExpressionCS
            //
            case 138: {
               //#line 1224 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
                result.add((OCLExpressionCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 139:  argumentsCS ::= argumentsCS , OclExpressionCS
            //
            case 139: {
               //#line 1231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<OCLExpressionCS> result = (EList<OCLExpressionCS>)getRhsSym(1);
                result.add((OCLExpressionCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 142:  VariableExpCS ::= selfKeywordCS
            //
            case 142: {
               //#line 1256 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
    
            //
            // Rule 143:  SimpleNameExpCS ::= simpleNameCS
            //
            case 143: {
               //#line 1271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(1);
                VariableExpCS result = createVariableExpCS(
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>(),
                        null
                    );
                setOffsets(result, simpleNameCS);
                setResult(result);
                      break;
            }
     
            //
            // Rule 149:  impliesNotNameNotLetCS ::= impliesNotLetCS implies xorNotLetCS
            //
            
            case 149:
 
            //
            // Rule 151:  impliesWithLetCS ::= impliesNotLetCS implies xorWithLetCS
            //
            
            case 151:
 
            //
            // Rule 155:  xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
            //
            
            case 155:
 
            //
            // Rule 157:  xorWithLetCS ::= xorNotLetCS xor orWithLetCS
            //
            
            case 157:
 
            //
            // Rule 161:  orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
            //
            
            case 161:
 
            //
            // Rule 163:  orWithLetCS ::= orNotLetCS or andWithLetCS
            //
            
            case 163:
 
            //
            // Rule 167:  andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
            //
            
            case 167:
 
            //
            // Rule 169:  andWithLetCS ::= andNotLetCS and equalityWithLetCS
            //
            
            case 169:
 
            //
            // Rule 173:  equalityNotNameNotLetCS ::= equalityNotLetCS = relationalNotLetCS
            //
            
            case 173:
 
            //
            // Rule 174:  equalityNotNameNotLetCS ::= equalityNotLetCS <> relationalNotLetCS
            //
            
            case 174:
 
            //
            // Rule 176:  equalityWithLetCS ::= equalityNotLetCS = relationalWithLetCS
            //
            
            case 176:
 
            //
            // Rule 177:  equalityWithLetCS ::= equalityNotLetCS <> relationalWithLetCS
            //
            
            case 177:
 
            //
            // Rule 181:  relationalNotNameNotLetCS ::= relationalNotLetCS > additiveNotLetCS
            //
            
            case 181:
 
            //
            // Rule 182:  relationalNotNameNotLetCS ::= relationalNotLetCS < additiveNotLetCS
            //
            
            case 182:
 
            //
            // Rule 183:  relationalNotNameNotLetCS ::= relationalNotLetCS >= additiveNotLetCS
            //
            
            case 183:
 
            //
            // Rule 184:  relationalNotNameNotLetCS ::= relationalNotLetCS <= additiveNotLetCS
            //
            
            case 184:
 
            //
            // Rule 186:  relationalWithLetCS ::= relationalNotLetCS > additiveWithLetCS
            //
            
            case 186:
 
            //
            // Rule 187:  relationalWithLetCS ::= relationalNotLetCS < additiveWithLetCS
            //
            
            case 187:
 
            //
            // Rule 188:  relationalWithLetCS ::= relationalNotLetCS >= additiveWithLetCS
            //
            
            case 188:
 
            //
            // Rule 189:  relationalWithLetCS ::= relationalNotLetCS <= additiveWithLetCS
            //
            
            case 189:
 
            //
            // Rule 193:  additiveNotNameNotLetCS ::= additiveNotLetCS + multiplicativeNotLetCS
            //
            
            case 193:
 
            //
            // Rule 194:  additiveNotNameNotLetCS ::= additiveNotLetCS - multiplicativeNotLetCS
            //
            
            case 194:
 
            //
            // Rule 196:  additiveWithLetCS ::= additiveNotLetCS + multiplicativeWithLetCS
            //
            
            case 196:
 
            //
            // Rule 197:  additiveWithLetCS ::= additiveNotLetCS - multiplicativeWithLetCS
            //
            
            case 197:
 
            //
            // Rule 201:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS * unaryNotLetCS
            //
            
            case 201:
 
            //
            // Rule 202:  multiplicativeNotNameNotLetCS ::= multiplicativeNotLetCS / unaryNotLetCS
            //
            
            case 202:
 
            //
            // Rule 204:  multiplicativeWithLetCS ::= multiplicativeNotLetCS * unaryWithLetCS
            //
            
            case 204:

            //
            // Rule 205:  multiplicativeWithLetCS ::= multiplicativeNotLetCS / unaryWithLetCS
            //
            case 205: {
               //#line 1380 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(2)
                        );
                setOffsets(simpleNameCS, getRhsIToken(2));
                OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
                OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
                EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
                args.add(right);
                OperationCallExpCS result = createOperationCallExpCS(
                        left,
                        simpleNameCS,
                        args
                    );
                setOffsets(result, left, right);
                setResult(result);
                      break;
            }
     
            //
            // Rule 209:  unaryNotNameNotLetCS ::= - unaryNotLetCS
            //
            
            case 209:
 
            //
            // Rule 210:  unaryNotNameNotLetCS ::= not unaryNotLetCS
            //
            
            case 210:
 
            //
            // Rule 212:  unaryWithLetCS ::= - unaryWithLetCS
            //
            
            case 212:

            //
            // Rule 213:  unaryWithLetCS ::= not unaryWithLetCS
            //
            case 213: {
               //#line 1411 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS simpleNameCS = createSimpleNameCS(
                            SimpleTypeEnum.KEYWORD_LITERAL,
                            getRhsIToken(1)
                        );
                setOffsets(simpleNameCS, getRhsIToken(1));
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
                OperationCallExpCS result = createOperationCallExpCS(
                        expr,
                        simpleNameCS,
                        new BasicEList<OCLExpressionCS>()
                    );
                setOffsets(result, simpleNameCS, expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 220:  primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 220: {
               //#line 1437 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
                if (result instanceof OperationCallExpCS) {
                    ((OperationCallExpCS)result).setIsAtomic(true);
                }
                setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 221:  LetExpCS ::= let letVariablesCS in OclExpressionCS
            //
            case 221: {
               //#line 1460 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(4);
                LetExpCS result = createLetExpCS(
                        (EList<VariableCS>)getRhsSym(2),
                        expr
                    );
                setOffsets(result, getRhsIToken(1), expr);
                setResult(result);
                      break;
            }
    
            //
            // Rule 222:  letVariablesCS ::= typedInitializedVariableCS
            //
            case 222: {
               //#line 1472 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = new BasicEList<VariableCS>();
                result.add((VariableCS)getRhsSym(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 223:  letVariablesCS ::= letVariablesCS , typedInitializedVariableCS
            //
            case 223: {
               //#line 1479 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                EList<VariableCS> result = (EList<VariableCS>)getRhsSym(1);
                result.add((VariableCS)getRhsSym(3));
                setResult(result);
                      break;
            }
    
            //
            // Rule 229:  listTypeCS ::= List ( typeCS )
            //
            case 229: {
               //#line 168 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListTypeCS(
						(TypeCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 230:  listLiteralCS ::= List { CollectionLiteralPartsCSopt }
            //
            case 230: {
               //#line 178 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createListLiteralExpCS((EList)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 232:  dictTypeCS ::= Dict ( typeCS , typeCS )
            //
            case 232: {
               //#line 187 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictTypeCS((TypeCS)getRhsSym(3), (TypeCS)getRhsSym(5));
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 233:  dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
            //
            case 233: {
               //#line 195 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 237:  dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
            //
            case 237: {
               //#line 207 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDictLiteralPartCS((LiteralExpCS)getRhsSym(1), (OCLExpressionCS)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 239:  dictLiteralPartListCSopt ::= $Empty
            //
            
            case 239:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 240:  dictLiteralPartListCS ::= dictLiteralPartCS
            //
            case 240: {
               //#line 219 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 241:  dictLiteralPartListCS ::= dictLiteralPartListCS , dictLiteralPartCS
            //
            case 241: {
               //#line 226 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 242:  dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
            //
            case 242: {
               //#line 233 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 245:  RaiseExpCS ::= raise pathNameCS raise_arg_opt
            //
            case 245: {
               //#line 244 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			CSTNode result = createRaiseExpCS((TypeCS)getRhsSym(2), (OCLExpressionCS)getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));			
			setResult(result);
	                  break;
            }
	
            //
            // Rule 246:  RaiseExpCS ::= raise StringLiteralExpCS
            //
            case 246: {
               //#line 252 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			CSTNode result = createRaiseExpCS(null, (OCLExpressionCS)getRhsSym(2));
			setOffsets(result, getRhsIToken(1), getRhsIToken(2));			
			setResult(result);
	                  break;
            }
	
            //
            // Rule 248:  raise_arg_opt ::= $Empty
            //
            case 248:
                setResult(null);
                break;

            //
            // Rule 249:  raise_arg ::= ( oclExpressionCSOpt )
            //
            case 249: {
               //#line 264 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 250:  TryExpCS ::= try expression_block CatchExp_list
            //
            case 250: {
               //#line 271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTryExpCS(
						(BlockExpCS)getRhsSym(2),
						(EList)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 251:  CatchExp_list ::= CatchExp
            //
            case 251: {
               //#line 282 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 252:  CatchExp_list ::= CatchExp_list CatchExp
            //
            case 252: {
               //#line 289 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 253:  CatchExp ::= except ( except_type_list_opt ) expression_block
            //
            case 253: {
               //#line 297 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createCatchExpCS(
						null,
						(EList)getRhsSym(3),
						(BlockExpCS)getRhsSym(5)							
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 254:  CatchExp ::= except ( IDENTIFIER : type_list ) expression_block
            //
            case 254: {
               //#line 309 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createCatchExpCS(
						getRhsIToken(3),
						(EList)getRhsSym(5),
						(BlockExpCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 256:  except_type_list_opt ::= $Empty
            //
            
            case 256:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 258:  returnExpCS ::= return oclExpressionCSOpt
            //
            case 258: {
               //#line 327 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)getRhsSym(2));
			CSTNode result = createExpressionStatementCS(returnExpCS);
			if(returnExpCS.getValue() != null) {
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(2));			
			} else {
				setOffsets(result, getRhsIToken(1));
			}
			setOffsets(returnExpCS, result);
			setResult(result);
	                  break;
            }
	
            //
            // Rule 260:  oclExpressionCSOpt ::= $Empty
            //
            case 260:
                setResult(null);
                break;

            //
            // Rule 262:  var_init_group_exp ::= var var_init_declarator_list
            //
            case 262: {
               //#line 347 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 263:  var_init_group_exp ::= var ( var_init_declarator_list )
            //
            case 263: {
               //#line 353 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 264:  var_init_group_exp ::= var ( var_init_declarator_list qvtErrorToken
            //
            case 264: {
               //#line 359 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 266:  var_init_exp ::= var var_init_declarator
            //
            case 266: {
               //#line 367 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 267:  var_init_exp ::= var ( var_init_declarator )
            //
            case 267: {
               //#line 373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 268:  var_init_exp ::= var ( var_init_declarator qvtErrorToken
            //
            case 268: {
               //#line 379 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 269:  var_init_exp ::= var qvtErrorToken
            //
            case 269: {
               //#line 385 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(ourEmptyEList);
	                  break;
            }
	
            //
            // Rule 270:  var_init_declarator_list ::= var_init_declarator , var_init_declarator
            //
            case 270: {
               //#line 391 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 271:  var_init_declarator_list ::= var_init_declarator_list , var_init_declarator
            //
            case 271: {
               //#line 399 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 272:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op OclExpressionCS
            //
            case 272: {
               //#line 408 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(Boolean)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 273:  var_init_declarator ::= IDENTIFIER : typeCS var_init_op qvtErrorToken
            //
            case 273: {
               //#line 420 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null,
						(Boolean)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 274:  var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
            //
            case 274: {
               //#line 432 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3),
						(Boolean)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 275:  var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
            //
            case 275: {
               //#line 444 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						null,
						(Boolean)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 276:  var_init_declarator ::= IDENTIFIER : typeCS
            //
            case 276: {
               //#line 456 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null,
						false
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 277:  var_init_declarator ::= IDENTIFIER : qvtErrorToken
            //
            case 277: {
               //#line 468 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableInitializationCS(
						getRhsIToken(1),
						null,
						null,
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 278:  var_init_op ::= =
            //
            
            case 278:

            //
            // Rule 279:  var_init_op ::= :=
            //
            case 279: {
               //#line 483 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(false);
	                  break;
            }
	
            //
            // Rule 280:  var_init_op ::= ::=
            //
            case 280: {
               //#line 488 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(true);
	                  break;
            }
	
            //
            // Rule 282:  assignStatementCS ::= primaryExpCS := OclExpressionCS
            //
            case 282: {
               //#line 496 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						(OCLExpressionCS)getRhsSym(3),
						false
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 283:  assignStatementCS ::= primaryExpCS := qvtErrorToken
            //
            case 283: {
               //#line 507 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						false
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 284:  assignStatementCS ::= primaryExpCS += OclExpressionCS
            //
            case 284: {
               //#line 519 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						(OCLExpressionCS)getRhsSym(3),
						true
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 285:  assignStatementCS ::= primaryExpCS += qvtErrorToken
            //
            case 285: {
               //#line 530 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createAssignStatementCS(
						(OCLExpressionCS)getRhsSym(1),
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
						true
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 287:  whileExpCS ::= while ( declarator1 ; OclExpressionCS ) whileBodyCS
            //
            case 287: {
               //#line 546 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						(VariableCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(BlockExpCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 288:  whileExpCS ::= while ( assignStatementCS ; OclExpressionCS ) whileBodyCS
            //
            case 288: {
               //#line 558 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				AssignStatementCS assignment = (AssignStatementCS)getRhsSym(3);
				CSTNode result = createWhileExpCS(
						getVariableFromAssignment(assignment),
						(OCLExpressionCS)getRhsSym(5),
						(BlockExpCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 289:  whileExpCS ::= while ( OclExpressionCS ) whileBodyCS
            //
            case 289: {
               //#line 571 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createWhileExpCS(
						null,
						(OCLExpressionCS)getRhsSym(3),
						(BlockExpCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 290:  IteratorExpCS ::= primaryExpCS -> forExpCS
            //
            case 290: {
               //#line 585 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				ForExpCS forExpCS = (ForExpCS)getRhsSym(3);
				forExpCS.setSource(source);
				setOffsets(forExpCS, source, forExpCS);
				setResult(forExpCS);
	                  break;
            }
	
            //
            // Rule 291:  IteratorExpCS ::= primaryExpCS -> simpleNameCS ( qvtErrorToken
            //
            case 291: {
               //#line 595 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
				OCLExpressionCS invalidBody = createInvalidLiteralExpCS(""); //$NON-NLS-1$
				setOffsets(invalidBody, getRhsIToken(4), getRhsIToken(5));
				CSTNode result = createIteratorExpCS(
						source,
						simpleNameCS,
						null,
						null,
						invalidBody
					);
				setOffsets(result, source, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 292:  argumentsCS ::= qvtErrorToken
            //
            
            case 292:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 296:  forExpDeclaratorList ::= IDENTIFIER
            //
            case 296: {
               //#line 621 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList<Object> result = new BasicEList<Object>();
		result.add(getRhsIToken(1));
		setResult(result);
                          break;
            }
    	
            //
            // Rule 297:  forExpDeclaratorList ::= forExpDeclaratorList , IDENTIFIER
            //
            case 297: {
               //#line 628 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		EList result = (EList)getRhsSym(1);
		result.add(getRhsIToken(3));
		setResult(result);
                          break;
            }
    	
            //
            // Rule 298:  forExpConditionOpt ::= $Empty
            //
            case 298:
                setResult(null);
                break;

            //
            // Rule 299:  forExpConditionOpt ::= | OclExpressionCS
            //
            case 299: {
               //#line 640 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
            	    setResult((OCLExpressionCS)getRhsSym(2));
                          break;
            }
    	
            //
            // Rule 300:  forExpConditionOpt ::= | qvtErrorToken
            //
            case 300:
                setResult(null);
                break;

            //
            // Rule 301:  forExpCS ::= forOpCode ( forExpDeclaratorList forExpConditionOpt ) expression_block
            //
            case 301: {
               //#line 649 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getRhsIToken(1),
						(EList)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(4),
						(BlockExpCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 302:  forExpCS ::= forOpCode qvtErrorToken
            //
            case 302: {
               //#line 662 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createForExpCS(
						getRhsIToken(1),
						null,
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 309:  ifElseOpt ::= $Empty
            //
            case 309:
                setResult(null);
                break;

            //
            // Rule 310:  ifElseOpt ::= else ifExpBodyCS
            //
            case 310: {
               //#line 692 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);
				setOffsets(result, getRhsIToken(1), result);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 311:  ifElif_listOpt ::= $Empty
            //
            
            case 311:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 313:  ifElif_listElem ::= elif OclExpressionCS then ifExpBodyCS
            //
            case 313: {
               //#line 704 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(2),
						(OCLExpressionCS) getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 314:  ifElif_list ::= ifElif_listElem
            //
            case 314: {
               //#line 715 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				Object element = getRhsSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 315:  ifElif_list ::= ifElif_list ifElif_listElem
            //
            case 315: {
               //#line 727 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				Object element = getRhsSym(2);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 316:  ifElif_list ::= ifElif_list qvtErrorToken
            //
            case 316: {
               //#line 739 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 317:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS ifElif_listOpt ifElseOpt endif
            //
            case 317: {
               //#line 747 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList elifPart = (EList)getRhsSym(5);
				CSTNode result = null;

				if (elifPart.isEmpty()) {
					result = createIfExpCS(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
						);
				}
				else {
					result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						elifPart,
						(OCLExpressionCS)getRhsSym(6)
						);
				}
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 318:  IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifElsePart
            //
            case 318: {
               //#line 772 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(2),
						(OCLExpressionCS)getRhsSym(4),
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 319:  IfExpCS ::= if OclExpressionCS then ifThenPart
            //
            case 319: {
               //#line 785 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(2),
						null,
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 320:  IfExpCS ::= if ifExpression
            //
            case 320: {
               //#line 798 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
				invalidCondition.setStartOffset(getRhsIToken(1).getEndOffset());
				invalidCondition.setEndOffset(getRhsIToken(1).getEndOffset());
				CSTNode result = createIfExpCSExt(
						invalidCondition,
						null,
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 321:  IfExpCS_ext ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS
            //
            case 321: {
               //#line 815 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 322:  IfExpCS_ext ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full endif
            //
            case 322: {
               //#line 827 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 323:  IfExpCS_ext ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full ifElif_ext_list endifOpt
            //
            case 323: {
               //#line 839 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(EList)getRhsSym(6),
						null
						);
				
				EList listElif = (EList)getRhsSym(6);
				CSTNode lastElif = (CSTNode)listElif.get(listElif.size()-1);
				CSTNode endifOptCS = (CSTNode)getRhsSym(7);
				CSTNode end = endifOptCS != null ? endifOptCS : lastElif; 

				setOffsets(result, getRhsIToken(1), end);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 324:  IfExpCS_ext ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full else notUMinus_ifExpBodyCS endifOptOpt
            //
            case 324: {
               //#line 857 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						ourEmptyEList,
						(OCLExpressionCS)getRhsSym(7)
						);

				CSTNode endifOptCS = (CSTNode)getRhsSym(8);
				CSTNode end = endifOptCS != null ? endifOptCS : (CSTNode)getRhsSym(7); 

				setOffsets(result, getRhsIToken(1), end);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 325:  IfExpCS_ext ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full ifElif_ext_list else notUMinus_ifExpBodyCS endifOptOpt
            //
            case 325: {
               //#line 873 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(EList)getRhsSym(6),
						(OCLExpressionCS)getRhsSym(8)
						);

				CSTNode endifOptCS = (CSTNode)getRhsSym(9);
				CSTNode end = endifOptCS != null ? endifOptCS : (CSTNode)getRhsSym(8); 

				setOffsets(result, getRhsIToken(1), end);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 326:  mandatory_elsePart ::= else notUMinus_ifExpBodyCS_full endifOptOpt
            //
            case 326: {
               //#line 890 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);

				CSTNode endifOptCS = (CSTNode)getRhsSym(3);
				CSTNode end = endifOptCS != null ? endifOptCS : (CSTNode)getRhsSym(2); 

				setOffsets(result, getRhsIToken(1), end);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 327:  IfExpCS_ext_full ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full mandatory_elsePart
            //
            case 327: {
               //#line 902 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						ourEmptyEList,
						(OCLExpressionCS)getRhsSym(6)
						);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 328:  IfExpCS_ext_full ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full ifElif_ext_list mandatory_elsePart
            //
            case 328: {
               //#line 914 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(EList)getRhsSym(6),
						(OCLExpressionCS)getRhsSym(7)
						);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 329:  IfExpCS_ext_full ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full endif
            //
            case 329: {
               //#line 926 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						ourEmptyEList,
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 330:  IfExpCS_ext_full ::= if ( OclExpressionCS ) notUMinus_ifExpBodyCS_full ifElif_ext_list endif
            //
            case 330: {
               //#line 938 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIfExpCSExt(
						(OCLExpressionCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5),
						(EList)getRhsSym(6),
						null
						);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 332:  ifElif_ext_listElem ::= elif ( OclExpressionCS ) notUMinus_ifExpBodyCS_full
            //
            case 332: {
               //#line 954 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(3),
						(OCLExpressionCS) getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 333:  ifElif_ext_list ::= ifElif_ext_listElem
            //
            case 333: {
               //#line 965 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				Object element = getRhsSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 334:  ifElif_ext_list ::= ifElif_ext_list ifElif_ext_listElem
            //
            case 334: {
               //#line 977 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				Object element = getRhsSym(2);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 335:  endifOpt ::= $Empty
            //
            case 335:
                setResult(null);
                break;

            //
            // Rule 336:  endifOpt ::= endif
            //
            case 336: {
               //#line 998 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 355:  notUMinus_impliesNotNameNotLetCS ::= notUMinus_impliesNotLetCS implies notUMinus_xorNotLetCS
            //
            
            case 355:
 
            //
            // Rule 357:  notUMinus_impliesWithLetCS ::= notUMinus_impliesNotLetCS implies notUMinus_xorWithLetCS
            //
            
            case 357:
 
            //
            // Rule 361:  notUMinus_xorNotNameNotLetCS ::= notUMinus_xorNotLetCS xor notUMinus_orNotLetCS
            //
            
            case 361:
 
            //
            // Rule 363:  notUMinus_xorWithLetCS ::= notUMinus_xorNotLetCS xor notUMinus_orWithLetCS
            //
            
            case 363:
 
            //
            // Rule 367:  notUMinus_orNotNameNotLetCS ::= notUMinus_orNotLetCS or notUMinus_andNotLetCS
            //
            
            case 367:
 
            //
            // Rule 369:  notUMinus_orWithLetCS ::= notUMinus_orNotLetCS or notUMinus_andWithLetCS
            //
            
            case 369:
 
            //
            // Rule 373:  notUMinus_andNotNameNotLetCS ::= notUMinus_andNotLetCS and notUMinus_equalityNotLetCS
            //
            
            case 373:
 
            //
            // Rule 375:  notUMinus_andWithLetCS ::= notUMinus_andNotLetCS and notUMinus_equalityWithLetCS
            //
            
            case 375:
 
            //
            // Rule 379:  notUMinus_equalityNotNameNotLetCS ::= notUMinus_equalityNotLetCS = notUMinus_relationalNotLetCS
            //
            
            case 379:
 
            //
            // Rule 380:  notUMinus_equalityNotNameNotLetCS ::= notUMinus_equalityNotLetCS <> notUMinus_relationalNotLetCS
            //
            
            case 380:
 
            //
            // Rule 382:  notUMinus_equalityWithLetCS ::= notUMinus_equalityNotLetCS = notUMinus_relationalWithLetCS
            //
            
            case 382:
 
            //
            // Rule 383:  notUMinus_equalityWithLetCS ::= notUMinus_equalityNotLetCS <> notUMinus_relationalWithLetCS
            //
            
            case 383:
 
            //
            // Rule 387:  notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS > notUMinus_additiveNotLetCS
            //
            
            case 387:
 
            //
            // Rule 388:  notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS < notUMinus_additiveNotLetCS
            //
            
            case 388:
 
            //
            // Rule 389:  notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS >= notUMinus_additiveNotLetCS
            //
            
            case 389:
 
            //
            // Rule 390:  notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS <= notUMinus_additiveNotLetCS
            //
            
            case 390:
 
            //
            // Rule 392:  notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS > notUMinus_additiveWithLetCS
            //
            
            case 392:
 
            //
            // Rule 393:  notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS < notUMinus_additiveWithLetCS
            //
            
            case 393:
 
            //
            // Rule 394:  notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS >= notUMinus_additiveWithLetCS
            //
            
            case 394:
 
            //
            // Rule 395:  notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS <= notUMinus_additiveWithLetCS
            //
            
            case 395:
 
            //
            // Rule 399:  notUMinus_additiveNotNameNotLetCS ::= notUMinus_additiveNotLetCS + notUMinus_multiplicativeNotLetCS
            //
            
            case 399:
 
            //
            // Rule 400:  notUMinus_additiveNotNameNotLetCS ::= notUMinus_additiveNotLetCS - notUMinus_multiplicativeNotLetCS
            //
            
            case 400:
 
            //
            // Rule 402:  notUMinus_additiveWithLetCS ::= notUMinus_additiveNotLetCS + notUMinus_multiplicativeWithLetCS
            //
            
            case 402:
 
            //
            // Rule 403:  notUMinus_additiveWithLetCS ::= notUMinus_additiveNotLetCS - notUMinus_multiplicativeWithLetCS
            //
            
            case 403:
 
            //
            // Rule 407:  notUMinus_multiplicativeNotNameNotLetCS ::= notUMinus_multiplicativeNotLetCS * notUMinus_unaryNotLetCS
            //
            
            case 407:
 
            //
            // Rule 408:  notUMinus_multiplicativeNotNameNotLetCS ::= notUMinus_multiplicativeNotLetCS / notUMinus_unaryNotLetCS
            //
            
            case 408:
 
            //
            // Rule 410:  notUMinus_multiplicativeWithLetCS ::= notUMinus_multiplicativeNotLetCS * notUMinus_unaryWithLetCS
            //
            
            case 410:

            //
            // Rule 411:  notUMinus_multiplicativeWithLetCS ::= notUMinus_multiplicativeNotLetCS / notUMinus_unaryWithLetCS
            //
            case 411: {
               //#line 1127 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(2)
						);
				setOffsets(simpleNameCS, getRhsIToken(2));
				OCLExpressionCS left = (OCLExpressionCS)getRhsSym(1);
				OCLExpressionCS right = (OCLExpressionCS)getRhsSym(3);
				EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
				args.add(right);
				OperationCallExpCS result = createOperationCallExpCS(
						left,
						simpleNameCS,
						args
					);
				setOffsets(result, left, right);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 415:  notUMinus_unaryNotNameNotLetCS ::= not notUMinus_unaryNotLetCS
            //
            
            case 415:

            //
            // Rule 417:  notUMinus_unaryWithLetCS ::= not notUMinus_unaryWithLetCS
            //
            case 417: {
               //#line 1156 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(1)
						);
				setOffsets(simpleNameCS, getRhsIToken(1));
				OCLExpressionCS expr = (OCLExpressionCS)getRhsSym(2);
				OperationCallExpCS result = createOperationCallExpCS(
						expr,
						simpleNameCS,
						new BasicEList<OCLExpressionCS>()
					);
				setOffsets(result, simpleNameCS, expr);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 422:  notUMinus_primaryNotNameCS ::= ( OclExpressionCS )
            //
            case 422: {
               //#line 1179 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
				if (result instanceof OperationCallExpCS) {
					((OperationCallExpCS)result).setIsAtomic(true);
				}
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 439:  blockExpCS ::= do expression_block
            //
            case 439: {
               //#line 1218 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				setOffsets(blockExpCS, getRhsIToken(1), blockExpCS);
				setResult(blockExpCS);
	                  break;
            }
	
            //
            // Rule 441:  switchExpCS ::= switch switchBodyExpCS
            //
            case 441: {
               //#line 1231 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[]) getRhsSym(2);

				CSTNode result = createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(result, getRhsIToken(1), (IToken) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(result, getRhsIToken(1), (CSTNode) switchBody[2]);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 443:  switchDeclaratorCS ::= IDENTIFIER
            //
            case 443: {
               //#line 1250 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 444:  switchDeclaratorCS ::= IDENTIFIER = OclExpressionCS
            //
            case 444: {
               //#line 1262 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 445:  IterateExpCS ::= primaryExpCS -> object ( uninitializedVariableCS ) objectDeclCS expression_block
            //
            case 445: {
               //#line 1276 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS  blockExpCS = (BlockExpCS) getRhsSym(8);
				ObjectExpCS objectExpCS = setupOutExpCS(
						(ObjectExpCS) getRhsSym(7),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(objectExpCS, getRhsIToken(3), blockExpCS);

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) getRhsSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
						iterators,
						null,
						objectExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS) getRhsSym(1));
				setOffsets(result, getRhsIToken(1), getRhsIToken(8));
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 446:  IterateExpCS ::= primaryExpCS -> switch ( switchDeclaratorCS ) switchBodyExpCS
            //
            case 446: {
               //#line 1308 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] switchBody = (Object[]) getRhsSym(7);

				OCLExpressionCS switchExpCS = (OCLExpressionCS) createSwitchExpCS(
						(EList<SwitchAltExpCS>) switchBody[0],
						(OCLExpressionCS) switchBody[1]							
					);
				if (switchBody[2] instanceof IToken) { // In case of correct and incorrect syntax
					setOffsets(switchExpCS, getRhsIToken(3), (IToken) switchBody[2]);
				} else if (switchBody[2] instanceof CSTNode) { // In case of errors in switchBody
					setOffsets(switchExpCS, getRhsIToken(3), (CSTNode) switchBody[2]);
				} else { // In case of errors in switchBody
					setOffsets(switchExpCS, getRhsIToken(3), getRhsIToken(6));
				}

				EList<VariableCS> iterators = new BasicEList<VariableCS>();
				iterators.add((VariableCS) getRhsSym(5));
				CallExpCS result = createImperativeIterateExpCS(
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
						iterators,
						null,
						switchExpCS,
						null
					);
					
				result.setSource((OCLExpressionCS) getRhsSym(1));
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 447:  switchExpCS ::= switch qvtErrorToken
            //
            case 447: {
               //#line 1341 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchExpCS(
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 448:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt }
            //
            case 448: {
               //#line 1352 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsIToken(4)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 449:  switchBodyExpCS ::= { switchAltExpCSList switchElseExpCSOpt qvtErrorToken
            //
            case 449: {
               //#line 1359 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsSym(3)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 450:  switchBodyExpCS ::= { qvtErrorToken
            //
            case 450: {
               //#line 1366 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] result = new Object[] {ourEmptyEList, null, getRhsIToken(1)};
				setResult(result);
	                  break;
            }
	
            //
            // Rule 451:  switchAltExpCSList ::= switchAltExpCS
            //
            case 451: {
               //#line 1373 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 452:  switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
            //
            case 452: {
               //#line 1380 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 453:  switchAltExpCS ::= case ( OclExpressionCS ) expression_statement
            //
            case 453: {
               //#line 1388 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(3),
						(OCLExpressionCS) getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 454:  switchAltExpCS ::= case ( OclExpressionCS ) qvtErrorToken
            //
            case 454: {
               //#line 1398 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCS(
						(OCLExpressionCS) getRhsSym(3),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 455:  switchElseExpCSOpt ::= $Empty
            //
            case 455:
                setResult(null);
                break;

            //
            // Rule 457:  switchElseExpCS ::= else expression_statement
            //
            case 457: {
               //#line 1413 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult((CSTNode)getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 458:  switchElseExpCS ::= else qvtErrorToken
            //
            case 458: {
               //#line 1418 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(null);
	                  break;
            }
	
            //
            // Rule 459:  OclExpressionCS ::= primaryOCLExpressionCS
            //
            case 459: {
               //#line 1426 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createExpressionStatementCS(
						(OCLExpressionCS)getRhsSym(1)
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 461:  logWhenExp ::= when OclExpressionCS
            //
            case 461: {
               //#line 1440 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(2);
			setResult(condition);
                      break;
            }
    
            //
            // Rule 463:  logWhenExpOpt ::= $Empty
            //
            case 463:
                setResult(null);
                break;

            //
            // Rule 464:  logExpCS ::= log ( argumentsCSopt ) logWhenExpOpt
            //
            case 464: {
               //#line 1451 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(5);
			LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)getRhsSym(3), condition);
			if(condition != null) {
				setOffsets(result, getRhsIToken(1), condition);
			} else {
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			}
			setResult(result);
                      break;
            }
    
            //
            // Rule 466:  severityKindCS ::= simpleNameCS
            //
            case 466: {
               //#line 1467 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			setResult(getRhsSym(1));
	                  break;
            }
	
            //
            // Rule 468:  severityKindCSOpt ::= $Empty
            //
            case 468:
                setResult(null);
                break;

            //
            // Rule 469:  assertWithLogExp ::= with logExpCS
            //
            case 469: {
               //#line 1479 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExp = (LogExpCS) getRhsSym(2);
			setOffsets(logExp, getRhsIToken(2), logExp);
			setResult(logExp);
                      break;
            }
    
            //
            // Rule 471:  assertWithLogExpOpt ::= $Empty
            //
            case 471:
                setResult(null);
                break;

            //
            // Rule 472:  assertExpCS ::= assert severityKindCSOpt ( OclExpressionCS ) assertWithLogExpOpt
            //
            case 472: {
               //#line 1491 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			LogExpCS logExpCS = (LogExpCS)getRhsSym(6);
			OCLExpressionCS condition = (OCLExpressionCS)getRhsSym(4);
			AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)getRhsSym(2), logExpCS);
	
			CSTNode end = logExpCS != null ? logExpCS : condition; 
			setOffsets(result, getRhsIToken(1), end);
			setResult(result);
                      break;
            }
    
            //
            // Rule 473:  computeExpCS ::= compute ( declarator ) expression_block
            //
            case 473: {
               //#line 1506 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createComputeExpCS(
					(VariableCS) getRhsSym(3),
					(OCLExpressionCS) getRhsSym(5)
				);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 475:  IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
            //
            case 475: {
               //#line 1524 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) getRhsSym(3);
				iterateExpCS.setSource(source);
				setOffsets(iterateExpCS, source, iterateExpCS);
				setResult(iterateExpCS);
	                  break;
            }
	 
            //
            // Rule 484:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
            //
            
            case 484:

            //
            // Rule 485:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
            //
            case 485: {
               //#line 1553 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				String opCode = getRhsTokenText(1);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(1)
						);
				setOffsets(simpleNameCS, getRhsIToken(1));
				Object[] iterContents = (Object[]) getRhsSym(3);
				OCLExpressionCS bodyCS = null;
				OCLExpressionCS conditionCS = null;
				if ("xcollect".equals(opCode)  //$NON-NLS-1$
					|| "collectOne".equals(opCode)) {  //$NON-NLS-1$
				    bodyCS = (OCLExpressionCS) iterContents[2];
				} else {
				    conditionCS = (OCLExpressionCS) iterContents[2];
				}
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						(EList<VariableCS>)iterContents[0],
						(VariableCS)iterContents[1],
						bodyCS,
						conditionCS
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 486:  imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
            //
            case 486: {
               //#line 1582 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getRhsIToken(1)
						);
				setOffsets(simpleNameCS, getRhsIToken(1));
				CSTNode result = createImperativeIterateExpCS(
						simpleNameCS,
						ourEmptyEList,
						null,
						null,
						null
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 487:  imperativeIterContents12 ::= OclExpressionCS
            //
            case 487: {
               //#line 1602 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {
						ourEmptyEList,
						null,
						getRhsSym(1)
					});
	                  break;
            }
	
            //
            // Rule 488:  imperativeIterContents12 ::= uninitializedVariableCS | OclExpressionCS
            //
            case 488: {
               //#line 1612 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> iters = new BasicEList<Object>();
				iters.add(getRhsSym(1));
				
				setResult(new Object[] {
						iters,
						null,
						getRhsSym(3)
					});
	                  break;
            }
	
            //
            // Rule 489:  imperativeIterContents12 ::= simpleNameCS , variableDeclarationListCS | OclExpressionCS
            //
            case 489: {
               //#line 1625 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                SimpleNameCS name = (SimpleNameCS)getRhsSym(1);
                CSTNode variableCS = createVariableCS(name, null, null);
                setOffsets(variableCS, name);

				EList iters = (EList) getRhsSym(3);
				iters.add(0, variableCS);
				
				setResult(new Object[] {
						iters,
						null,
						getRhsSym(5)
					});
	                  break;
            }
	
            //
            // Rule 490:  imperativeIterContents3 ::= variableDeclarationListCS ; initializedVariableCS | OclExpressionCS
            //
            case 490: {
               //#line 1642 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {
						getRhsSym(1),
						getRhsSym(3),
						getRhsSym(5)
					});
	                  break;
            }
	
            //
            // Rule 491:  variableDeclarationListCS ::= uninitializedVariableCS
            //
            case 491: {
               //#line 1652 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 492:  variableDeclarationListCS ::= variableDeclarationListCS , uninitializedVariableCS
            //
            case 492: {
               //#line 1659 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 493:  exclamationOpt ::= $Empty
            //
            case 493:
                setResult(null);
                break;

            //
            // Rule 495:  declarator_vsep ::= IDENTIFIER |
            //
            case 495: {
               //#line 1675 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		CSTNode result = createVariableCS(
					getRhsIToken(1),
                                            null,
					null
					);
                    setOffsets(result, getRhsIToken(1));
                    setResult(result);
                          break;
            }
    	
            //
            // Rule 496:  declarator_vsepOpt ::= $Empty
            //
            case 496:
                setResult(null);
                break;

            //
            // Rule 498:  IterateExpCS ::= primaryExpCS exclamationOpt [ declarator_vsepOpt OclExpressionCS ]
            //
            case 498: {
               //#line 1692 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
		if (source instanceof ImperativeIterateExpCS
			&& "xcollect".equals(((ImperativeIterateExpCS)source).getSimpleNameCS().getValue())) { //$NON-NLS-1$
			String opCode = isTokenOfType(getRhsIToken(2), LightweightParsersym.TK_EXCLAMATION_MARK) 
				?  "collectselectOne"  //$NON-NLS-1$
				: "collectselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));

			ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
			result.setSimpleNameCS(simpleNameCS);
			
			VariableCS variableCS = (VariableCS) getRhsSym(4);
			if (variableCS != null) {
				result.setTarget(variableCS);
			}
	        result.setCondition((OCLExpressionCS) getRhsSym(5));
			
			setOffsets(result, getRhsIToken(1), getRhsIToken(6));
			setResult(result);
		}
		else {
			String opCode = isTokenOfType(getRhsIToken(2), LightweightParsersym.TK_EXCLAMATION_MARK) 
				?  "selectOne"  //$NON-NLS-1$
				: "xselect";  //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);
			setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));
			
			EList<VariableCS> iterators = new BasicEList<VariableCS>();
			iterators.add((VariableCS) getRhsSym(4));
			
			CallExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					iterators,
					null,
					null,
					(OCLExpressionCS) getRhsSym(5)
					);
			result.setSource(source);
			setOffsets(result, getRhsIToken(1), getRhsIToken(6));
			setResult(result);
		}
	                  break;
            }
	
            //
            // Rule 499:  IterateExpCS ::= primaryExpCS -> simpleNameCS
            //
            case 499: {
               //#line 1746 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
		SimpleNameCS featureNameCS = (SimpleNameCS)getRhsSym(3);
		VariableExpCS variableCS = createVariableExpCS(
				featureNameCS,
				ourEmptyEList,
				null
		);
		setOffsets(variableCS, featureNameCS);

		ImperativeIterateExpCS result = createImperativeIterateExpCS(
				createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1 //$NON-NLS-1$
				ourEmptyEList,
				null,
				variableCS,
				null
				);
		result.setSource(source);
		setOffsets(result, getRhsIToken(1), getRhsIToken(3));
		setResult(result);
	                  break;
            }
	
            //
            // Rule 501:  newExpCS ::= new typespec ( argumentsCSopt )
            //
            case 501: {
               //#line 1772 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) getRhsSym(2), (EList) getRhsSym(4));
			setOffsets(result, getRhsIToken(1), getRhsIToken(5));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 502:  breakExpCS ::= break
            //
            case 502: {
               //#line 1783 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 503:  continueExpCS ::= continue
            //
            case 503: {
               //#line 1791 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
	                  break;
            }
	
            //
            // Rule 508:  declarator1 ::= IDENTIFIER : typeCS
            //
            case 508: {
               //#line 1809 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						null
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 509:  declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
            //
            case 509: {
               //#line 1821 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 510:  declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
            //
            case 510: {
               //#line 1833 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						(TypeCS)getRhsSym(3),
						(OCLExpressionCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 511:  declarator2 ::= IDENTIFIER := OclExpressionCS
            //
            case 511: {
               //#line 1845 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createVariableCS(
						getRhsIToken(1),
						null,
						(OCLExpressionCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 514:  expression_listOpt ::= $Empty
            //
            
            case 514:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 518:  expression_semi_list ::= expression_semi_list_element
            //
            case 518: {
               //#line 1868 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				Object element = getRhsSym(1);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 519:  expression_semi_list ::= expression_semi_list ; expression_semi_list_element
            //
            case 519: {
               //#line 1880 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				Object element = getRhsSym(3);
				if (element instanceof EList) {
					result.addAll((EList) element);
				} else {
					result.add(element);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 520:  expression_semi_list ::= expression_semi_list qvtErrorToken
            //
            case 520: {
               //#line 1892 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 521:  expression_block ::= { expression_listOpt }
            //
            case 521: {
               //#line 1899 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			EList bodyList = (EList) getRhsSym(2);
			CSTNode result = createBlockExpCS(
				bodyList
			);
			
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
                          break;
            }
	
            //
            // Rule 522:  expression_block ::= { qvtErrorToken
            //
            case 522: {
               //#line 1910 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			CSTNode result = createBlockExpCS(
				ourEmptyEList
			);
			
			setOffsets(result, getRhsIToken(1));
			setResult(result);
                          break;
            }
	
            //
            // Rule 525:  qvtErrorToken ::= ERROR_TOKEN
            //
            case 525: {
               //#line 1924 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				diagnozeErrorToken(getRhsTokenIndex(1));
	                  break;
            }
	
            //
            // Rule 526:  switchAltExpCS ::= ( OclExpressionCS ) ? OclExpressionCS ;
            //
            case 526: {
               //#line 1934 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) getRhsSym(2),
						(OCLExpressionCS) getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 527:  switchAltExpCS ::= ( OclExpressionCS ) qvtErrorToken
            //
            case 527: {
               //#line 1944 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						(OCLExpressionCS) getRhsSym(2),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 528:  switchAltExpCS ::= ( qvtErrorToken
            //
            case 528: {
               //#line 1954 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSwitchAltExpCSDeprecated(
						null,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 529:  switchElseExpCS ::= else ? OclExpressionCS ;
            //
            case 529: {
               //#line 1965 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getRhsIToken(1).getStartOffset();
		    	int endOffset = getRhsIToken(4).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				setResult((CSTNode)getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 530:  switchElseExpCS ::= else ? OclExpressionCS qvtErrorToken
            //
            case 530: {
               //#line 1974 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
		    	int startOffset = getRhsIToken(1).getStartOffset();
		    	int endOffset = getRhsIToken(3).getEndOffset();
				reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
				
				setResult((CSTNode)getRhsSym(3));
	                  break;
            }
	
            //
            // Rule 531:  topLevel ::= unit_elementList
            //
            case 531: {
               //#line 189 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<CSTNode> unitElements = (EList<CSTNode>)getRhsSym(1);
				setResult(setupTopLevel(unitElements));
	                  break;
            }
	
            //
            // Rule 533:  _import ::= import unit ;
            //
            case 533: {
               //#line 198 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createImportCS(
						(PathNameCS)getRhsSym(2)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 535:  _import ::= import importDeclaration
            //
            case 535: {
               //#line 210 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						createPathNameCS()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 537:  unit_elementList ::= unit_elementList unit_element
            //
            case 537: {
               //#line 224 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList)getRhsSym(1);
				list.add(getRhsSym(2));
				setResult(list);
	                  break;
            }
	 
            //
            // Rule 538:  unit_elementList ::= $Empty
            //
            
            case 538:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 549:  unit_element ::= qvtErrorToken
            //
            case 549:
                setResult(null);
                break;

            //
            // Rule 552:  transformation_decl ::= transformation_h ;
            //
            case 552: {
               //#line 253 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				setOffsets(headerCS, headerCS, getRhsIToken(2));
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 553:  transformation_def ::= transformation_h { module_elementList } semicolonOpt
            //
            case 553: {
               //#line 263 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				MappingModuleCS moduleCS = createMappingModuleCS(headerCS, (EList) getRhsSym(3));
				setOffsets(moduleCS, headerCS, getRhsIToken(4));
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 556:  library_decl ::= library_h ;
            //
            case 556: {
               //#line 275 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				setOffsets(headerCS, headerCS, getRhsIToken(2));
				MappingModuleCS moduleCS = createLibraryCS(headerCS, ourEmptyEList);
				setOffsets(moduleCS, headerCS);
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 557:  library_def ::= library_h { module_elementList } semicolonOpt
            //
            case 557: {
               //#line 285 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				TransformationHeaderCS headerCS = (TransformationHeaderCS) getRhsSym(1);
				MappingModuleCS moduleCS = createLibraryCS(headerCS, (EList) getRhsSym(3));
				setOffsets(moduleCS, headerCS, getRhsIToken(4));
				setResult(moduleCS);
	                  break;
            }
	
            //
            // Rule 558:  transformation_h ::= qualifierList transformation qualifiedNameCS transformation_signature transformation_usage_refineOpt
            //
            case 558: {
               //#line 297 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList transfUsages = ourEmptyEList;
				TransformationRefineCS transfRefine = null;
				Object transformation_usage_refineOpt = getRhsSym(5);
				if (transformation_usage_refineOpt instanceof TransformationRefineCS) {
					transfRefine = (TransformationRefineCS) transformation_usage_refineOpt;
				} else if (transformation_usage_refineOpt instanceof EList) {
					transfUsages = (EList) transformation_usage_refineOpt;
				}
				CSTNode result = createTransformationHeaderCS(
						(EList) getRhsSym(1),
						(PathNameCS)getRhsSym(3),
						(SimpleSignatureCS)getRhsSym(4),
						transfUsages,
						transfRefine
					);
				setOffsets(result, getRhsIToken(2));

				if (transfRefine == null) {
					if (transfUsages.isEmpty()) {
						setOffsets(result, result, (SimpleSignatureCS)getRhsSym(4));
					}
					else {
						setOffsets(result, result, (CSTNode) transfUsages.get(transfUsages.size()-1));
					}
				} else {
					setOffsets(result, result, transfRefine);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 559:  transformation_usage_refineOpt ::= $Empty
            //
            case 559:
                setResult(null);
                break;

            //
            // Rule 564:  transformation_refine ::= refines moduleref
            //
            case 564: {
               //#line 340 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationRefineCS(
						(ModuleRefCS)getRhsSym(2)
					);
				setOffsets(result, (ModuleRefCS)getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 565:  library_h ::= library qualifiedNameCS library_signatureOpt module_usageListOpt
            //
            case 565: {
               //#line 353 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS name = (PathNameCS)getRhsSym(2);
				SimpleSignatureCS signature = (getRhsSym(3) == null) ? createSimpleSignatureCS(ourEmptyEList) : (SimpleSignatureCS)getRhsSym(3);
				EList<ModuleUsageCS> moduleUsages = (EList<ModuleUsageCS>)getRhsSym(4);
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						name,
						signature,
						moduleUsages,
						null
					);
				CSTNode rightNode = name;
				if (!moduleUsages.isEmpty()) {
					rightNode = moduleUsages.get(moduleUsages.size() - 1);
				} else if (getRhsSym(3) != null) {
					rightNode = signature;
				}
				setOffsets(result, getRhsIToken(1), rightNode);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 567:  library_h ::= library libraryDeclaration
            //
            case 567: {
               //#line 378 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationHeaderCS(
						ourEmptyEList,
						createPathNameCS(),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 568:  library_signatureOpt ::= $Empty
            //
            case 568:
                setResult(null);
                break;

            //
            // Rule 571:  module_usageList ::= module_usage
            //
            case 571: {
               //#line 400 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 572:  module_usageList ::= module_usageList module_usage
            //
            case 572: {
               //#line 407 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 573:  module_usageListOpt ::= $Empty
            //
            
            case 573:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 577:  access_usage ::= access module_kindOpt moduleref_list
            //
            case 577: {
               //#line 422 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList)getRhsSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.ACCESS,
						(ModuleKindCS)getRhsSym(2),
						moduleRefList
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 578:  extends_usage ::= extends module_kindOpt moduleref_list
            //
            case 578: {
               //#line 434 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList moduleRefList = (EList)getRhsSym(3);
				CSTNode result = createModuleUsageCS(
						ImportKindEnum.EXTENSION,
						(ModuleKindCS)getRhsSym(2),
						moduleRefList
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)moduleRefList.get(moduleRefList.size()-1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 579:  module_kindOpt ::= $Empty
            //
            case 579:
                setResult(null);
                break;

            //
            // Rule 581:  module_kind ::= transformation
            //
            case 581: {
               //#line 451 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.TRANSFORMATION
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 582:  module_kind ::= library
            //
            case 582: {
               //#line 460 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createModuleKindCS(
						ModuleKindEnum.LIBRARY
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 583:  moduleref_list ::= moduleref
            //
            case 583: {
               //#line 470 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 584:  moduleref_list ::= moduleref_list , moduleref
            //
            case 584: {
               //#line 477 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 585:  moduleref_list ::= moduleref_list qvtErrorToken
            //
            case 585: {
               //#line 484 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 586:  moduleref ::= pathNameCS simple_signatureOpt
            //
            case 586: {
               //#line 491 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS)getRhsSym(2);
				CSTNode result = createModuleRefCS(
						(PathNameCS)getRhsSym(1),
						signature 
					);
				CSTNode rightNode = (signature == null) ? (CSTNode)getRhsSym(1) : signature;
				setOffsets(result, (CSTNode)getRhsSym(1), rightNode);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 587:  module_elementList ::= module_elementList module_element
            //
            case 587: {
               //#line 506 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList list = (EList)getRhsSym(1);
				list.add(getRhsSym(2));
				setResult(list);
	                  break;
            }
	 
            //
            // Rule 588:  module_elementList ::= $Empty
            //
            
            case 588:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 596:  module_element ::= qvtErrorToken
            //
            case 596:
                setResult(null);
                break;

            //
            // Rule 597:  _modeltype ::= modeltype IDENTIFIER compliance_kindOpt uses packageref_list modeltype_whereOpt ;
            //
            case 597: {
               //#line 529 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList whereList = (EList)getRhsSym(6);
				EList packageRefList = (EList)getRhsSym(5);
				ModelTypeCS result = createModelTypeCS(
						getRhsIToken(2),
						(StringLiteralExpCS)getRhsSym(3),
						packageRefList,
						whereList
					);
				if (whereList.isEmpty()) {
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				}
				else {
					CSTNode lastPackageRefCS = (CSTNode)packageRefList.get(packageRefList.size()-1);
					setOffsets(result, getRhsIToken(1), lastPackageRefCS);
					setBodyOffsets(result, lastPackageRefCS, getRhsIToken(7));
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 599:  _modeltype ::= modeltype modeltypeDeclaration
            //
            case 599: {
               //#line 553 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ModelTypeCS result = createModelTypeCS(
						new Token(0, 0, 0),
						null,
						ourEmptyEList,
						ourEmptyEList
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 600:  modeltype_whereOpt ::= $Empty
            //
            
            case 600:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 602:  modeltype_where ::= where expression_block
            //
            case 602: {
               //#line 570 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				setResult(blockExpCS.getBodyExpressions());
	                  break;
            }
	
            //
            // Rule 603:  packageref_list ::= packageref
            //
            case 603: {
               //#line 577 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 604:  packageref_list ::= packageref_list , packageref
            //
            case 604: {
               //#line 584 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 605:  packageref_list ::= packageref_list qvtErrorToken
            //
            case 605: {
               //#line 591 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 606:  packageref ::= pathNameCS
            //
            case 606: {
               //#line 598 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)getRhsSym(1),
						null
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 607:  packageref ::= pathNameCS ( uri )
            //
            case 607: {
               //#line 608 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						(PathNameCS)getRhsSym(1),
						(StringLiteralExpCS)getRhsSym(3)
					);
				setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 608:  packageref ::= uri
            //
            case 608: {
               //#line 618 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPackageRefCS(
						null,
						(StringLiteralExpCS)getRhsSym(1)
					);
				setOffsets(result, (CSTNode)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 609:  compliance_kindOpt ::= $Empty
            //
            case 609:
                setResult(null);
                break;

            //
            // Rule 613:  classifierDefCS ::= intermediate class qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
            //
            case 613: {
               //#line 641 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createIntermediateClassDefCS(
					getRhsIToken(3),
					(EList) getRhsSym(4),
					(EList) getRhsSym(6)
				);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 614:  classifierDefCS ::= exception qvtIdentifierCS classifierExtensionOpt { classifierFeatureListOpt } semicolonOpt
            //
            case 614: {
               //#line 653 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createExceptionDefCS(
					getRhsIToken(2),
					(EList) getRhsSym(3),
					(EList) getRhsSym(5)
				);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 615:  classifierExtensionOpt ::= $Empty
            //
            
            case 615:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 616:  classifierExtensionOpt ::= extends type_list
            //
            case 616: {
               //#line 667 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 617:  type_list ::= typeCS
            //
            case 617: {
               //#line 673 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 618:  type_list ::= type_list , typeCS
            //
            case 618: {
               //#line 680 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 619:  type_list ::= type_list qvtErrorToken
            //
            case 619: {
               //#line 687 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 620:  classifierFeatureListOpt ::= $Empty
            //
            
            case 620:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 622:  classifierFeatureList ::= classifierFeatureCS
            //
            case 622: {
               //#line 698 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 623:  classifierFeatureList ::= classifierFeatureList ; classifierFeatureCS
            //
            case 623: {
               //#line 705 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 624:  classifierFeatureList ::= classifierFeatureList qvtErrorToken
            //
            case 624: {
               //#line 712 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 625:  classifierFeatureCS ::= stereotype_qualifier_list feature_key_list qvtIdentifierCS : typeCS multiplicityOpt ordered_prop opposite_propertyOpt init_partOpt
            //
            case 625: {
               //#line 719 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList stereotypeQualifiers = (EList) getRhsSym(1);
				EList featureKeys = (EList) getRhsSym(2);
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) getRhsSym(6);
				OppositePropertyCS oppositeProperty = (OppositePropertyCS) getRhsSym(8);
				OCLExpressionCS initExpression = (OCLExpressionCS) getRhsSym(9);
				CSTNode result = createClassifierPropertyCS(
						stereotypeQualifiers,
						featureKeys,
						getRhsIToken(3),
						(TypeCS) getRhsSym(5),
						((BooleanLiteralExpCS) getRhsSym(7)).getBooleanSymbol().booleanValue(),
						initExpression,
						multiplicityDef,
						oppositeProperty
					);
				
				int startOffset = getRhsIToken(3).getStartOffset();
				if (!featureKeys.isEmpty()) {
					startOffset = ((CSTNode) featureKeys.get(0)).getStartOffset();
				}
				if (!stereotypeQualifiers.isEmpty()) {
					startOffset = ((IToken) stereotypeQualifiers.get(0)).getStartOffset();
				}
				
				CSTNode lastToken = (CSTNode) getRhsSym(5);
				if (initExpression != null) {
					lastToken = initExpression;
				}
				if (multiplicityDef != null) {
					lastToken = multiplicityDef;
				}
				if (oppositeProperty != null) {
					lastToken = oppositeProperty;
				}
				
				setOffsets(result, lastToken);
				result.setStartOffset(startOffset);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 627:  init_partOpt ::= $Empty
            //
            case 627:
                setResult(null);
                break;

            //
            // Rule 628:  init_partOpt ::= = OclExpressionCS
            //
            case 628: {
               //#line 765 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 629:  stereotype_qualifier_list ::= $Empty
            //
            
            case 629:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 630:  stereotype_qualifier_list ::= STEREOTYPE_QUALIFIER_OPEN identifier_list STEREOTYPE_QUALIFIER_CLOSE
            //
            case 630: {
               //#line 774 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 631:  identifier_list ::= qvtIdentifierCS
            //
            case 631: {
               //#line 781 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 632:  identifier_list ::= identifier_list , qvtIdentifierCS
            //
            case 632: {
               //#line 788 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 633:  identifier_list ::= identifier_list qvtErrorToken
            //
            case 633: {
               //#line 795 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 634:  feature_key_list ::= $Empty
            //
            
            case 634:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 635:  feature_key_list ::= feature_key_list feature_key
            //
            case 635: {
               //#line 804 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 636:  feature_key_list ::= feature_key_list qvtErrorToken
            //
            case 636: {
               //#line 811 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 637:  feature_key ::= composes
            //
            
            case 637:
 
            //
            // Rule 638:  feature_key ::= references
            //
            
            case 638:
 
            //
            // Rule 639:  feature_key ::= readonly
            //
            
            case 639:
 
            //
            // Rule 640:  feature_key ::= derived
            //
            
            case 640:

            //
            // Rule 641:  feature_key ::= static
            //
            case 641: {
               //#line 826 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 642:  multiplicityOpt ::= $Empty
            //
            case 642:
                setResult(null);
                break;

            //
            // Rule 643:  multiplicityOpt ::= LBRACKET multiplicity_range RBRACKET
            //
            case 643: {
               //#line 836 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = (CSTNode) getRhsSym(2);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 644:  multiplicity_range ::= IntegerLiteralExpCS
            //
            case 644: {
               //#line 843 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) getRhsSym(1),
						(PrimitiveLiteralExpCS) getRhsSym(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 645:  multiplicity_range ::= UnlimitedNaturalLiteralExpCS
            //
            case 645: {
               //#line 853 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PrimitiveLiteralExpCS lowerBound = createIntegerLiteralExpCS(Integer.toString(0));
				setOffsets(lowerBound, getRhsIToken(1));
				CSTNode result = createMultiplicityDefCS(
						lowerBound, 
						(PrimitiveLiteralExpCS) getRhsSym(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 646:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE IntegerLiteralExpCS
            //
            
            case 646:
 
            //
            // Rule 647:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT IntegerLiteralExpCS
            //
            
            case 647:
 
            //
            // Rule 648:  multiplicity_range ::= IntegerLiteralExpCS MULTIPLICITY_RANGE UnlimitedNaturalLiteralExpCS
            //
            
            case 648:

            //
            // Rule 649:  multiplicity_range ::= IntegerLiteralExpCS DOTDOT UnlimitedNaturalLiteralExpCS
            //
            case 649: {
               //#line 871 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMultiplicityDefCS(
						(PrimitiveLiteralExpCS) getRhsSym(1),
						(PrimitiveLiteralExpCS) getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 650:  ordered_prop ::= ordered
            //
            case 650: {
               //#line 882 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 651:  ordered_prop ::= $Empty
            //
            case 651: {
               //#line 889 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setResult(result);
	                  break;
            }
	
            //
            // Rule 652:  opposite_propertyOpt ::= $Empty
            //
            case 652:
                setResult(null);
                break;

            //
            // Rule 653:  opposite_propertyOpt ::= opposites navigable_prop qvtIdentifierCS multiplicityOpt
            //
            case 653: {
               //#line 898 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MultiplicityDefCS multiplicityDef = (MultiplicityDefCS) getRhsSym(4);
				CSTNode result = createOppositePropertyCS(
						getRhsIToken(3),
						((BooleanLiteralExpCS) getRhsSym(2)).getBooleanSymbol().booleanValue(),
						multiplicityDef
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				if (multiplicityDef != null) {
					result.setEndOffset(multiplicityDef.getEndOffset());
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 654:  navigable_prop ::= ~
            //
            case 654: {
               //#line 914 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.FALSE.toString());
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 655:  navigable_prop ::= $Empty
            //
            case 655: {
               //#line 921 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createBooleanLiteralExpCS(Boolean.TRUE.toString());
				setResult(result);
	                  break;
            }
	
            //
            // Rule 656:  _property ::= configuration property qvtIdentifierCS : typeCS ;
            //
            case 656: {
               //#line 930 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getRhsIToken(3),
						(TypeCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 657:  _property ::= configuration property qvtIdentifierCS : typeCS qvtErrorToken
            //
            case 657: {
               //#line 940 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createConfigPropertyCS(
						getRhsIToken(3),
						(TypeCS)getRhsSym(5)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 658:  _property ::= property qvtIdentifierCS : typeCS = OclExpressionCS ;
            //
            case 658: {
               //#line 950 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						(TypeCS)getRhsSym(4),
						(OCLExpressionCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 659:  _property ::= property qvtIdentifierCS = OclExpressionCS ;
            //
            case 659: {
               //#line 961 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						null,
						(OCLExpressionCS)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 660:  _property ::= property qvtIdentifierCS : typeCS ;
            //
            case 660: {
               //#line 972 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLocalPropertyCS(
						getRhsIToken(2),
						(TypeCS)getRhsSym(4),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 661:  _property ::= intermediate property scoped_identifier : typeCS ;
            //
            case 661: {
               //#line 983 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)getRhsSym(3),
						(TypeCS)getRhsSym(5),
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 662:  _property ::= intermediate property scoped_identifier : typeCS = OclExpressionCS ;
            //
            case 662: {
               //#line 994 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createContextualPropertyCS(
						(ScopedNameCS)getRhsSym(3),
						(TypeCS)getRhsSym(5),
						(OCLExpressionCS)getRhsSym(7)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(8));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 666:  helper_header ::= helper_info scoped_identifier complete_signature
            //
            case 666: {
               //#line 1012 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)getRhsSym(3);
				Object[] helperInfo = (Object[])getRhsSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS)getRhsSym(2),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				setOffsets(mappingDeclarationCS, (CSTNode)getRhsSym(2), (CSTNode)getRhsSym(3));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 667:  helper_header ::= helper_info qvtErrorToken
            //
            case 667: {
               //#line 1037 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] helperInfo = (Object[])getRhsSym(1);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				setOffsets(mappingDeclarationCS, (IToken) helperInfo[1]);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) helperInfo[0];
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				IToken helperKind = (IToken) helperInfo[1];
				mappingDeclarationCS.setIsQuery(helperKind.getKind() == LightweightParsersym.TK_query);
				mappingDeclarationCS.setStartOffset(helperKind.getStartOffset());

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 668:  helper_info ::= qualifierList helper_kind
            //
            case 668: {
               //#line 1061 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {getRhsSym(1), getRhsIToken(2)});
	                  break;
            }
	
            //
            // Rule 671:  helper_decl ::= helper_header ;
            //
            case 671: {
               //#line 1070 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						null
					);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 672:  helper_decl ::= helper_header qvtErrorToken
            //
            case 672: {
               //#line 1083 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						null
					);
				setOffsets(result, mappingDecl);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 673:  helper_simple_def ::= helper_header = OclExpressionCS ;
            //
            case 673: {
               //#line 1096 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				OCLExpressionCS expression = (OCLExpressionCS)getRhsSym(3);
				EList<OCLExpressionCS> expressionList = new BasicEList<OCLExpressionCS>();
				expressionList.add(expression);
				BlockExpCS blockExpCS = createBlockExpCS(expressionList);					
				setOffsets(blockExpCS, getRhsIToken(2), getRhsIToken(4));
				MappingQueryCS result = createMappingQueryCS(
						false,
						mappingDecl,
						blockExpCS
					);
				result.setIsSimpleDefinition(true);
				setOffsets(result, mappingDecl, getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 674:  helper_compound_def ::= helper_header expression_block semicolonOpt
            //
            case 674: {
               //#line 1115 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)getRhsSym(2);
				CSTNode result = createMappingQueryCS(
						false,
						mappingDecl,
						blockExpCS
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 677:  constructor_header ::= qualifierList constructor scoped_identifier simple_signature
            //
            case 677: {
               //#line 1134 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS signature = (SimpleSignatureCS) getRhsSym(4);					
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					(ScopedNameCS) getRhsSym(3),
					signature.getParams(),
					null
				);
				setOffsets(mappingDeclarationCS, getRhsIToken(2), signature);

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>) getRhsSym(1);
				if (!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 678:  constructor_decl ::= constructor_header ;
            //
            case 678: {
               //#line 1154 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						null
					);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 679:  constructor_decl ::= constructor_header qvtErrorToken
            //
            case 679: {
               //#line 1166 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						null
					);
				setOffsets(result, mappingDecl);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 680:  constructor_def ::= constructor_header expression_block semicolonOpt
            //
            case 680: {
               //#line 1178 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS) getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				ConstructorCS result = createConstructorCS(
						mappingDecl,
						blockExpCS
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 683:  entry_header ::= main simple_signature
            //
            case 683: {
               //#line 1197 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				IToken nameToken = getRhsIToken(1);				
				ScopedNameCS nameCS = createScopedNameCS(null, getRhsTokenText(1));								
				nameCS.setStartOffset(nameToken.getStartOffset());
				nameCS.setEndOffset(nameToken.getEndOffset());
	
				SimpleSignatureCS signature = (SimpleSignatureCS)getRhsSym(2);
				CSTNode result = createMappingDeclarationCS(
						null,
						nameCS,
						signature.getParams(),
						null
					);
				setOffsets(result, getRhsIToken(1), signature);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 684:  entry_header ::= main qvtErrorToken
            //
            case 684: {
               //#line 1216 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingDeclarationCS(
						null,
						createScopedNameCS(null, getRhsTokenText(1)),
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 685:  entry_decl ::= entry_header ;
            //
            case 685: {
               //#line 1229 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				MappingQueryCS result = createMappingQueryCS(
						true,
						mappingDecl,
						null
					);
				setOffsets(result, mappingDecl, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 686:  entry_def ::= entry_header expression_block semicolonOpt
            //
            case 686: {
               //#line 1242 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDecl = (MappingDeclarationCS)getRhsSym(1);
				BlockExpCS blockExpCS = (BlockExpCS)getRhsSym(2);
				CSTNode result = createMappingQueryCS(
						true,
						mappingDecl,
						blockExpCS
					);
				setOffsets(result, mappingDecl, blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 687:  _tag ::= tag StringLiteralExpCS scoped_identifier tag_valueOpt
            //
            case 687: {
               //#line 1260 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS valueExpression = (OCLExpressionCS) getRhsSym(4);
				CSTNode result = createTagCS(
						(StringLiteralExpCS) getRhsSym(2),
						(ScopedNameCS) getRhsSym(3),
						valueExpression
					);
				setOffsets(result, getRhsIToken(1), valueExpression != null ? valueExpression : (CSTNode) getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 688:  tag_valueOpt ::= $Empty
            //
            case 688:
                setResult(null);
                break;

            //
            // Rule 689:  tag_valueOpt ::= = OclExpressionCS
            //
            case 689: {
               //#line 1275 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 692:  mapping_decl ::= mapping_full_header ;
            //
            case 692: {
               //#line 1288 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(EList)mappingFullHeader[1],
						(EList)mappingFullHeader[2],
						null
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 693:  mapping_def ::= mapping_full_header { mapping_body } semicolonOpt
            //
            case 693: {
               //#line 1302 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingSectionsCS mappingSections = (MappingSectionsCS)getRhsSym(3);
				setOffsets(mappingSections, getRhsIToken(2), getRhsIToken(4));

				MappingBodyCS mappingBodyCS = mappingSections.getMappingBodyCS();
				if (mappingBodyCS != null) {
					if (mappingBodyCS.getStartOffset() < 0) {
						mappingBodyCS.setStartOffset(mappingSections.getStartOffset());
					}
					if (mappingBodyCS.getEndOffset() < 0) {
						mappingBodyCS.setEndOffset(mappingSections.getEndOffset());
					}
				}

				Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						(EList)mappingFullHeader[1],
						(EList)mappingFullHeader[2],
						mappingSections
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 694:  mapping_def ::= mapping_full_header { qvtErrorToken
            //
            case 694: {
               //#line 1329 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				Object[] mappingFullHeader = (Object[])getRhsSym(1);
				MappingRuleCS result = createMappingRuleCS(
						(MappingDeclarationCS)mappingFullHeader[0],
						ourEmptyEList,
						ourEmptyEList,
						null
					);
				setOffsets(result, (MappingDeclarationCS)mappingFullHeader[0], getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 695:  mapping_full_header ::= mapping_header _whenOpt _whereOpt
            //
            case 695: {
               //#line 1343 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(new Object[] {getRhsSym(1), getRhsSym(2), getRhsSym(3)});
	                  break;
            }
	
            //
            // Rule 696:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier complete_signature mapping_extraList
            //
            case 696: {
               //#line 1349 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS)getRhsSym(3);
				CompleteSignatureCS completeSignature = (CompleteSignatureCS)getRhsSym(5);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)getRhsSym(4),
					completeSignature.getSimpleSignature().getParams(),
					completeSignature.getResultParams()
				);
				
				mappingDeclarationCS.setStartOffset(directionKind == null ? getRhsIToken(2).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(completeSignature.getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				mappingDeclarationCS.getMappingExtension().addAll(((EList<MappingExtensionCS>)getRhsSym(6)));

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 697:  mapping_header ::= qualifierList mapping param_directionOpt scoped_identifier qvtErrorToken
            //
            case 697: {
               //#line 1374 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS directionKind = (DirectionKindCS)getRhsSym(3);
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					directionKind,
					(ScopedNameCS)getRhsSym(4),
					ourEmptyEList,
					ourEmptyEList
				);

				mappingDeclarationCS.setStartOffset(directionKind == null ? getRhsIToken(2).getStartOffset() : directionKind.getStartOffset());
				mappingDeclarationCS.setEndOffset(((CSTNode)getRhsSym(4)).getEndOffset());

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 698:  mapping_header ::= qualifierList mapping qvtErrorToken
            //
            case 698: {
               //#line 1396 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingDeclarationCS mappingDeclarationCS = createMappingDeclarationCS(
					null,
					createScopedNameCS(null, ""), //$NON-NLS-1$
					ourEmptyEList,
					ourEmptyEList
				);
				
				setOffsets(mappingDeclarationCS, getRhsIToken(2), getRhsIToken(2));

				EList<SimpleNameCS> qualifiers = (EList<SimpleNameCS>)getRhsSym(1);
				if(!qualifiers.isEmpty()) {
					mappingDeclarationCS.getQualifiers().addAll(createQualifiersListCS(qualifiers));
				}

				setResult(mappingDeclarationCS);
	                  break;
            }
	
            //
            // Rule 699:  mapping_extraList ::= mapping_extraList mapping_extra
            //
            case 699: {
               //#line 1417 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<MappingExtensionCS> extensionList = (EList<MappingExtensionCS>)getRhsSym(1);
				extensionList.add((MappingExtensionCS)getRhsSym(2));
				setResult(extensionList);
	                  break;
            }
	 
            //
            // Rule 700:  mapping_extraList ::= $Empty
            //
            
            case 700:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 702:  mapping_extension ::= mapping_extension_key scoped_identifier_list
            //
            case 702: {
               //#line 1430 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingExtensionCS result = createMappingExtension(getRhsTokenText(1), (EList<ScopedNameCS>)getRhsSym(2));

				result.setStartOffset(getRhsIToken(1).getStartOffset());
				result.setEndOffset(getEndOffset(getRhsIToken(1), (EList<ScopedNameCS>)getRhsSym(2)));
			
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 707:  _whenOpt ::= $Empty
            //
            
            case 707:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 708:  _when ::= when expression_block
            //
            case 708: {
               //#line 1449 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				setResult(blockExpCS.getBodyExpressions());
	                  break;
            }
	 
            //
            // Rule 709:  _when ::= when qvtErrorToken
            //
            
            case 709:
                setResult(new BasicEList<Object>());
                break;
 
            //
            // Rule 711:  _whereOpt ::= $Empty
            //
            
            case 711:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 712:  _where ::= where expression_block
            //
            case 712: {
               //#line 1462 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				setResult(blockExpCS.getBodyExpressions());
	                  break;
            }
	 
            //
            // Rule 713:  _where ::= where qvtErrorToken
            //
            
            case 713:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 714:  mapping_body ::= init_sectionOpt population_sectionOpt end_sectionOpt
            //
            case 714: {
               //#line 1471 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
	                        MappingInitCS mappingInitCS = (MappingInitCS)getRhsSym(1);
				MappingBodyCS mappingBodyCS = (MappingBodyCS)getRhsSym(2);
				MappingEndCS mappingEndCS = (MappingEndCS)getRhsSym(3);

				if (mappingBodyCS != null) {
					if ((mappingBodyCS.getStartOffset() < 0) && (mappingInitCS != null)) {
						mappingBodyCS.setStartOffset(mappingInitCS.getEndOffset() + 1);
					}
					if ((mappingBodyCS.getEndOffset() < 0) && (mappingEndCS != null)) {
						mappingBodyCS.setEndOffset(mappingEndCS.getStartOffset() - 1);
					}
					if (mappingBodyCS.getStartOffset() > mappingBodyCS.getEndOffset()) {
						mappingBodyCS.setEndOffset(mappingBodyCS.getStartOffset());
					}
				}
				
				CSTNode result = createMappingSectionsCS(
						mappingInitCS,
						mappingBodyCS,
						mappingEndCS
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 715:  init_sectionOpt ::= $Empty
            //
            case 715:
                setResult(null);
                break;

            //
            // Rule 717:  init_section ::= init expression_block
            //
            case 717: {
               //#line 1502 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				CSTNode result = createMappingInitCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 718:  init_section ::= init qvtErrorToken
            //
            case 718: {
               //#line 1515 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingInitCS(
						ourEmptyEList,
						getRhsIToken(1).getEndOffset(),
						getRhsIToken(1).getStartOffset()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 719:  population_sectionOpt ::= $Empty
            //
            case 719: {
               //#line 1528 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				MappingBodyCS result = createMappingBodyCS(
						ourEmptyEList,
						false
					);
				// offsets will be updated further in parent non-terminals
				result.setStartOffset(-1); 
				result.setEndOffset(-1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 721:  population_section ::= expression_list
            //
            case 721: {
               //#line 1542 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<OCLExpressionCS> expressionList = (EList<OCLExpressionCS>) getRhsSym(1);
				MappingBodyCS result = createMappingBodyCS(
						expressionList,
						false
					);
				if (expressionList.isEmpty()) {
					// offsets will be updated further in parent non-terminals
					result.setStartOffset(-1); 
					result.setEndOffset(-1);
				} else {
					CSTNode startExp = expressionList.get(0);
					CSTNode endExp = expressionList.get(expressionList.size() - 1);
					setOffsets(result, startExp, endExp);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 722:  population_section ::= population expression_block
            //
            case 722: {
               //#line 1562 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				MappingBodyCS result = createMappingBodyCS(
						blockExpCS.getBodyExpressions(),
						true
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 723:  population_section ::= population qvtErrorToken
            //
            case 723: {
               //#line 1574 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingBodyCS(
						ourEmptyEList,
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 724:  end_sectionOpt ::= $Empty
            //
            case 724:
                setResult(null);
                break;

            //
            // Rule 726:  end_section ::= end expression_block
            //
            case 726: {
               //#line 1589 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
				CSTNode result = createMappingEndCS(
						blockExpCS.getBodyExpressions(),
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					);
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 727:  end_section ::= end qvtErrorToken
            //
            case 727: {
               //#line 1602 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingEndCS(
						ourEmptyEList,
						getRhsIToken(1).getEndOffset(),
						getRhsIToken(1).getStartOffset()
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 728:  typespecOpt ::= $Empty
            //
            case 728:
                setResult(null);
                break;

            //
            // Rule 730:  objectDeclCS ::= typespec
            //
            case 730: {
               //#line 1620 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createOutExpCS(null, (TypeSpecCS)getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 734:  objectDeclCS ::= objectIdentifierCS : typespecOpt
            //
            case 734: {
               //#line 1631 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
			SimpleNameCS varName = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getRhsIToken(1));
			setOffsets(varName, getRhsIToken(1));
			CSTNode result = createOutExpCS(varName,(TypeSpecCS)getRhsSym(3));					
			setResult(result);
	                  break;
            }
	
            //
            // Rule 735:  outExpCS ::= object objectDeclCS expression_block
            //
            case 735: {
               //#line 1640 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(3);
				CSTNode result = setupOutExpCS(
						(ObjectExpCS) getRhsSym(2),					
						blockExpCS.getBodyExpressions(),
						// passing body positions
						blockExpCS.getStartOffset(),
						blockExpCS.getEndOffset()
					); 
				setOffsets(result, getRhsIToken(1), blockExpCS);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 736:  outExpCS ::= object objectDeclCS qvtErrorToken
            //
            case 736: {
               //#line 1654 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ObjectExpCS objectDeclCS = ((ObjectExpCS) getRhsSym(2));  
				CSTNode result = createOutExpCS(
						objectDeclCS.getSimpleNameCS(),						
						objectDeclCS.getTypeSpecCS()
					);
				if (objectDeclCS  == null) {
				    setOffsets(result, getRhsIToken(1), getRhsIToken(1));
				} else {
				    setOffsets(result, getRhsIToken(1), objectDeclCS);
				}
				setResult(result);
	                  break;
            }
	
            //
            // Rule 737:  featureMappingCallExpCS ::= map simpleNameCS ( argumentsCSopt )
            //
            case 737: {
               //#line 1670 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 738:  featureMappingCallExpCS ::= xmap simpleNameCS ( argumentsCSopt )
            //
            case 738: {
               //#line 1682 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						null,
						(SimpleNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 739:  featureMappingCallExpCS ::= map simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 739: {
               //#line 1695 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)getRhsSym(2),
						(SimpleNameCS)getRhsSym(4),
						(EList)getRhsSym(6),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 740:  featureMappingCallExpCS ::= xmap simpleNameCS :: simpleNameCS ( argumentsCSopt )
            //
            case 740: {
               //#line 1707 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createFeatureMappingCallExpCS(
						(SimpleNameCS)getRhsSym(2),
						(SimpleNameCS)getRhsSym(4),
						(EList)getRhsSym(6),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 741:  mappingCallExpCS ::= map pathNameCS ( argumentsCSopt )
            //
            case 741: {
               //#line 1720 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						false
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 742:  mappingCallExpCS ::= xmap pathNameCS ( argumentsCSopt )
            //
            case 742: {
               //#line 1731 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createMappingCallExpCS(
						(PathNameCS)getRhsSym(2),
						(EList)getRhsSym(4),
						true
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 743:  resolveConditionOpt ::= $Empty
            //
            case 743:
                setResult(null);
                break;

            //
            // Rule 744:  resolveConditionOpt ::= | OclExpressionCS
            //
            case 744: {
               //#line 1748 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult((OCLExpressionCS)getRhsSym(2));
                      break;
            }
    
            //
            // Rule 745:  resolveConditionOpt ::= | qvtErrorToken
            //
            case 745:
                setResult(null);
                break;

            //
            // Rule 746:  IDENTIFIEROpt ::= $Empty
            //
            case 746:
                setResult(null);
                break;

            //
            // Rule 747:  IDENTIFIEROpt ::= IDENTIFIER :
            //
            case 747: {
               //#line 1760 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                setResult(getRhsIToken(1));
                      break;
            }
    
            //
            // Rule 748:  resolveOpArgsExpCSOpt ::= $Empty
            //
            case 748:
                setResult(null);
                break;

            //
            // Rule 750:  resolveOpArgsExpCS ::= IDENTIFIEROpt typeCS resolveConditionOpt
            //
            case 750: {
               //#line 1771 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveOpArgsExpCS(
                        getRhsIToken(1),      // target_type_variable?
                        (TypeCS)getRhsSym(2),           // type?
                        (OCLExpressionCS)getRhsSym(3)); // condition?
                        setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                    setResult(result);
                      break;
            }
    
            //
            // Rule 755:  lateOpt ::= $Empty
            //
            case 755:
                setResult(null);
                break;

            //
            // Rule 757:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt )
            //
            case 757: {
               //#line 1791 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
                            (ResolveOpArgsExpCS)getRhsSym(4));
                            setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                    setResult(result);
                          break;
            }
        
            //
            // Rule 758:  resolveExpCS ::= lateOpt resolveOp ( resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 758: {
               //#line 1802 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
                        (ResolveOpArgsExpCS)getRhsSym(4));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 759:  resolveExpCS ::= lateOpt resolveOp qvtErrorToken
            //
            case 759: {
               //#line 1813 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        null);
                            setOffsets(result, getRhsIToken(1), getRhsIToken(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 760:  resolveExpCS ::= late qvtErrorToken
            //
            case 760: {
               //#line 1824 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
    			IToken lateToken = getRhsIToken(1);
                CSTNode result = createResolveExpCS(
                        lateToken,
                        new Token(lateToken.getEndOffset(), lateToken.getEndOffset(), LightweightParsersym.TK_resolve),
                        null);
                            setOffsets(result, getRhsIToken(1));
                setResult(result);
                      break;
            }
    
            //
            // Rule 765:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCS )
            //
            case 765: {
               //#line 1841 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        (ResolveOpArgsExpCS)getRhsSym(6));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(7));
                setResult(result);
                          break;
            }
        
            //
            // Rule 766:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier )
            //
            case 766: {
               //#line 1853 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(5));
                setResult(result);
                      break;
            }
    
            //
            // Rule 767:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier , resolveOpArgsExpCSOpt qvtErrorToken
            //
            case 767: {
               //#line 1866 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        (ResolveOpArgsExpCS)getRhsSym(6));
                        setOffsets(result, getRhsIToken(1), getRhsIToken(6));
                setResult(result);
                      break;
            }
    
            //
            // Rule 768:  resolveInExpCS ::= lateOpt resolveInOp ( scoped_identifier qvtErrorToken
            //
            case 768: {
               //#line 1878 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
                        (ScopedNameCS)getRhsSym(4),
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(4));
                setResult(result);
                      break;
            }
    
            //
            // Rule 769:  resolveInExpCS ::= lateOpt resolveInOp ( qvtErrorToken
            //
            case 769: {
               //#line 1890 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                    CSTNode result = createResolveInExpCS(
                            getRhsIToken(1),
                        getRhsIToken(2),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                            setOffsets(result, getRhsIToken(1), getRhsIToken(3));
                setResult(result);
                      break;
            }
        
            //
            // Rule 770:  resolveInExpCS ::= lateOpt resolveInOp qvtErrorToken
            //
            case 770: {
               //#line 1902 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
                CSTNode result = createResolveInExpCS(
                        getRhsIToken(1),
                        getRhsIToken(2),
							createScopedNameCS(null, ""),  //$NON-NLS-1$
                        null);
                        setOffsets(result, getRhsIToken(1), getRhsIToken(2));
                setResult(result);
                      break;
            }
    
            //
            // Rule 773:  OperationCallExpCS ::= primaryExpCS -> resolveResolveInExpCS
            //
            case 773: {
               //#line 1918 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 774:  OperationCallExpCS ::= primaryExpCS . resolveResolveInExpCS
            //
            case 774: {
               //#line 1927 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 776:  OperationCallExpCS ::= primaryExpCS -> featureMappingCallExpCS
            //
            case 776: {
               //#line 1944 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 777:  OperationCallExpCS ::= primaryExpCS . featureMappingCallExpCS
            //
            case 777: {
               //#line 1953 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
				CallExpCS result = (CallExpCS)getRhsSym(3);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				result.setSource(source);
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 780:  simpleNameCS ::= this
            //
            
            case 780:

            //
            // Rule 781:  simpleNameCS ::= result
            //
            case 781: {
               //#line 1969 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getRhsIToken(1)
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 782:  letExpSubCS3 ::= untypedInitializedVariableCS
            //
            case 782: {
               //#line 1983 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 783:  letExpSubCS3 ::= letExpSubCS3 , untypedInitializedVariableCS
            //
            case 783: {
               //#line 1990 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 784:  LetExpCS ::= let letExpSubCS3 in OclExpressionCS
            //
            case 784: {
               //#line 1998 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList)getRhsSym(2);
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)getRhsSym(4)
					);
				setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 785:  LetExpCS ::= let letExpSubCS3 in qvtErrorToken
            //
            case 785: {
               //#line 2009 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList variables = (EList)getRhsSym(2);
				CSTNode result = createLetExpCS(
						variables,
						createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 786:  equalityNotNameNotLetCS ::= equalityNotLetCS != relationalNotLetCS
            //
            
            case 786:

            //
            // Rule 787:  equalityWithLetCS ::= equalityNotLetCS != relationalWithLetCS
            //
            case 787: {
               //#line 2026 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getRhsIToken(2));
				EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
				args.add((OCLExpressionCS) getRhsSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)getRhsSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 788:  _import ::= import library unit ;
            //
            case 788: {
               //#line 2050 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createLibraryImportCS(
						(PathNameCS)getRhsSym(3)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 789:  transformation_h ::= qualifierList transformation qualifiedNameCS
            //
            case 789: {
               //#line 2060 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTransformationHeaderCS(
						(EList) getRhsSym(1),
						(PathNameCS)getRhsSym(3),
						createSimpleSignatureCS(ourEmptyEList),
						ourEmptyEList,
						null
					);
				setOffsets(result, getRhsIToken(2), (PathNameCS)getRhsSym(3));

				setResult(result);
	                  break;
            }
	
            //
            // Rule 791:  renaming ::= rename typeCS . qvtIdentifierCS = StringLiteralExpCS ;
            //
            case 791: {
               //#line 2076 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createRenameCS(
						(TypeCS)getRhsSym(2),
						getRhsIToken(4),
						(StringLiteralExpCS)getRhsSym(6)
					);
				setOffsets(result, getRhsIToken(1), getRhsIToken(7));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 792:  qualifierList ::= $Empty
            //
            
            case 792:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 793:  qualifierList ::= qualifierList qualifier
            //
            case 793: {
               //#line 2096 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList) getRhsSym(1);
				result.add(getRhsSym(2));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 794:  qualifier ::= blackbox
            //
            
            case 794:
 
            //
            // Rule 795:  qualifier ::= abstract
            //
            
            case 795:

            //
            // Rule 796:  qualifier ::= static
            //
            case 796: {
               //#line 2108 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 797:  colon_param_listOpt ::= $Empty
            //
            
            case 797:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 798:  colon_param_listOpt ::= : param_list
            //
            case 798: {
               //#line 2119 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				setResult(getRhsSym(2));
	                  break;
            }
	
            //
            // Rule 799:  complete_signature ::= simple_signature colon_param_listOpt
            //
            case 799: {
               //#line 2125 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				SimpleSignatureCS simpleSignatureCS = (SimpleSignatureCS)getRhsSym(1);
				EList<ParameterDeclarationCS> resultList = (EList<ParameterDeclarationCS>)getRhsSym(2);
				CSTNode result = createCompleteSignatureCS(simpleSignatureCS, resultList);
				result.setStartOffset(simpleSignatureCS.getStartOffset());
				result.setEndOffset(getEndOffset(simpleSignatureCS.getEndOffset(), resultList));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 800:  simple_signatureOpt ::= $Empty
            //
            case 800:
                setResult(null);
                break;

            //
            // Rule 802:  simple_signature ::= ( param_listOpt )
            //
            case 802: {
               //#line 2140 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createSimpleSignatureCS((EList<ParameterDeclarationCS>)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	 
            //
            // Rule 803:  param_listOpt ::= $Empty
            //
            
            case 803:
                setResult(new BasicEList<Object>());
                break;

            //
            // Rule 805:  param_list ::= param_list , param
            //
            case 805: {
               //#line 2152 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 806:  param_list ::= param_list , qvtErrorToken
            //
            case 806: {
               //#line 2159 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 807:  param_list ::= param
            //
            case 807: {
               //#line 2165 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 808:  param_list ::= qvtErrorToken
            //
            case 808: {
               //#line 2172 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				setResult(result);
	                  break;
            }
	
            //
            // Rule 809:  param ::= param_directionOpt IDENTIFIER : typespec
            //
            case 809: {
               //#line 2179 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS) getRhsSym(1);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						getRhsIToken(2),
						(TypeSpecCS)getRhsSym(4)
					);
				
				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : getRhsIToken(2).getStartOffset());
				result.setEndOffset(((CSTNode)getRhsSym(4)).getEndOffset());
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 810:  param ::= param_directionOpt typespec
            //
            case 810: {
               //#line 2195 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				DirectionKindCS paramDirectionCS = (DirectionKindCS) getRhsSym(1);
				TypeSpecCS paramTypeCS = (TypeSpecCS) getRhsSym(2);
				CSTNode result = createParameterDeclarationCS(
						paramDirectionCS,
						null,
						paramTypeCS
					);

				result.setStartOffset(paramDirectionCS != null ? paramDirectionCS.getStartOffset() : paramTypeCS.getStartOffset());
				result.setEndOffset(paramTypeCS.getEndOffset());
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 811:  param_directionOpt ::= $Empty
            //
            case 811:
                setResult(null);
                break;

            //
            // Rule 813:  param_direction ::= in
            //
            case 813: {
               //#line 2216 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.IN
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 814:  param_direction ::= out
            //
            case 814: {
               //#line 2225 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.OUT
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 815:  param_direction ::= inout
            //
            case 815: {
               //#line 2234 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createDirectionKindCS(
						DirectionKindEnum.INOUT
					);
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 816:  typespec ::= typeCS
            //
            case 816: {
               //#line 2245 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					null
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 817:  typespec ::= typeCS @ IDENTIFIER
            //
            case 817: {
               //#line 2254 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createTypeSpecCS(
					(TypeCS)getRhsSym(1),
					getRhsIToken(3)
					);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 823:  scoped_identifier ::= typeCS2 :: IDENTIFIER
            //
            case 823: {
               //#line 2271 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), getRhsTokenText(3));		
				setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 824:  scoped_identifier ::= typeCS2 :: qvtErrorToken
            //
            case 824: {
               //#line 2278 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				ScopedNameCS result = createScopedNameCS((TypeCS)getRhsSym(1), ""); 		 //$NON-NLS-1$
				setOffsets(result, (CSTNode) getRhsSym(1), getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 825:  scoped_identifier ::= scoped_identifier2
            //
            case 825: {
               //#line 2285 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS pathNameCS = (PathNameCS)getRhsSym(1);
				String name = pathNameCS.getSimpleNames().remove(pathNameCS.getSimpleNames().size() - 1).getValue();
				TypeCS typeCS = pathNameCS.getSimpleNames().isEmpty() ? null : pathNameCS;

				ScopedNameCS result = createScopedNameCS(typeCS, name);		

				setOffsets(result, pathNameCS);

                                    // reduce the region by the removed name element
				pathNameCS.setEndOffset(pathNameCS.getEndOffset() - (name != null ? name.length() : 0) - 2);
				
				setResult(result);
	                  break;
            }
	
            //
            // Rule 826:  scoped_identifier2 ::= IDENTIFIER
            //
            case 826: {
               //#line 2301 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 827:  scoped_identifier2 ::= main
            //
            case 827: {
               //#line 2308 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 828:  scoped_identifier2 ::= scoped_identifier2 :: IDENTIFIER
            //
            case 828: {
               //#line 2315 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 829:  scoped_identifier2 ::= scoped_identifier2 :: qvtErrorToken
            //
            case 829: {
               //#line 2323 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 830:  scoped_identifier_list ::= scoped_identifier
            //
            case 830: {
               //#line 2331 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList<Object> result = new BasicEList<Object>();
				result.add(getRhsSym(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 831:  scoped_identifier_list ::= scoped_identifier_list , scoped_identifier
            //
            case 831: {
               //#line 2338 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				result.add(getRhsSym(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 832:  scoped_identifier_list ::= scoped_identifier_list qvtErrorToken
            //
            case 832: {
               //#line 2345 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				EList result = (EList)getRhsSym(1);
				setResult(result);
	                  break;
            }
	
            //
            // Rule 833:  qualifiedNameCS ::= qvtIdentifierCS
            //
            case 833: {
               //#line 2352 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				CSTNode result = createPathNameCS(getRhsIToken(1));
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 834:  qualifiedNameCS ::= qualifiedNameCS . qvtIdentifierCS
            //
            case 834: {
               //#line 2359 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(3));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 835:  qualifiedNameCS ::= qualifiedNameCS . qvtErrorToken
            //
            case 835: {
               //#line 2367 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				result = extendPathNameCS(result, getRhsIToken(3));
				setOffsets(result, result, getRhsIToken(2));
				setResult(result);
	                  break;
            }
	
            //
            // Rule 836:  qualifiedNameCS ::= qualifiedNameCS qvtErrorToken
            //
            case 836: {
               //#line 2375 "../lpg/btParserTemplateF.gi" //$NON-NLS-1$
				
				PathNameCS result = (PathNameCS)getRhsSym(1);
				setResult(result);
	                  break;
            }	
	
    
            default:
                break;
        }
        return;
    }
}

