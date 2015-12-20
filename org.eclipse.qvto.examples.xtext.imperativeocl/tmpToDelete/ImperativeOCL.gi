--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006-2008 Borland Inc.
-- * All rights reserved.   This program and the accompanying materials
-- * are made available under the terms of the Eclipse Public License v1.0
-- * which accompanies this distribution, and is available at
-- * http://www.eclipse.org/legal/epl-v10.html
-- *
-- * Contributors:
-- *   See Notice Declaration below
-- *
-- * </copyright>
-- *
-- * $Id: ImperativeOCL.gi,v 1.6 2010/02/03 18:18:51 sboyko Exp $ 
-- */
--
-- The Imperative OCL Parser
--

%Import
	EssentialOCL.gi

%DropRules
	-- Dropped due to 13.2 (OCL spec) and 6.4 (QVT-ImperativeOCL spec). These rules conflict with imperative iterator shorthands
	AssociationClassCallExpCS ::= simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt
	AssociationClassCallExpCS ::= primaryExpCS '.' simpleNameCS '[' argumentsCS ']' isMarkedPreCSopt

	-- Excessive rule in OCL grammar
	CollectionLiteralExpCS ::= collectionTypeCS '{' CollectionLiteralPartsCSopt '}'

	-- 'if' extension in Imperative OCL
	IfExpCS ::= if OclExpressionCS then OclExpressionCS else OclExpressionCS endif

%End

%Define
	-- Definition of macros used in the parser template
	--
	$super_parser_class /.AbstractQVTParser./
	$super_lexer_class /.QVTOLexer./
	$environment_class /.Environment<?,?,?,?,?,?,?,?,?,?,?,?>./

	$EMPTY_ELIST /.ourEmptyEList./
%End

%Globals
	/.	
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
	./
%End


%Notice
	/./**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 Borland Inc.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Borland - Initial API and implementation
 *   Adolfo Sanchez-Barbudo Herrera (Open Canarias) - LPG v 2.0.17 adoption (297966)
 *
 * </copyright>
 *
 */
	./
%End


%Headers
	/.
		@SuppressWarnings("unchecked")
		private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);								
								
		
		private void diagnozeErrorToken(int token_index) {
			//IToken token = getIToken(token_index);
			//if (token instanceof lpg.runtime.ErrorToken) {
			//	token = ((lpg.runtime.ErrorToken) token).getErrorToken();
			//}			
			//reportError(lpg.runtime.ParseErrorCodes.MISPLACED_CODE, token.getTokenIndex(), token.getTokenIndex(),  
			//		"'" + 
			//		token.toString() + "'");

			prsStream.reset(token_index); // point to error token
			DiagnoseParser diagnoseParser = new DiagnoseParser(prsStream, prsTable);
			diagnoseParser.diagnose(token_index);
			setResult(null);
		}
	./
%End

%KeyWords
	Dict
	List
	break
	switch
	case
	xselect
	xcollect
	selectOne
	collectOne
	collectselect
	collectselectOne
	return
	forEach
	forOne
	var
	while
	continue
	log
	assert
	with
	compute
	new

%End

%Terminals
	RESET_ASSIGN      ::= ':='
	ADD_ASSIGN        ::= '+='
	EXCLAMATION_MARK  ::= '!'
	COLONCOLONEQUAL   ::= '::='
	QUESTIONMARK      ::= '?'

	SINGLE_LINE_COMMENT MULTI_LINE_COMMENT
%End

%Rules
	-- opt = optional
	-- m = multiple

	typeCS -> listTypeCS
	listTypeCS ::= List '(' typeCS ')'
		/.$BeginCode
					CSTNode result = createListTypeCS(
							(TypeCS)getRhsSym(3)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

	listLiteralCS ::= List '{' CollectionLiteralPartsCSopt '}'
		/.$BeginCode
					CSTNode result = createListLiteralExpCS((EList)getRhsSym(3));
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./ 
	
	typeCS -> dictTypeCS
	dictTypeCS ::= Dict '(' typeCS ',' typeCS ')'
		/.$BeginCode
					CSTNode result = createDictTypeCS((TypeCS)getRhsSym(3), (TypeCS)getRhsSym(5));
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./	

	dictLiteralCS ::= Dict '{' dictLiteralPartListCSopt '}'
		/.$BeginCode
					CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>)getRhsSym(3));
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./ 
	
	literalSimpleCS -> PrimitiveLiteralExpCS
	LiteralExpCS -> listLiteralCS
	LiteralExpCS -> dictLiteralCS
	
	dictLiteralPartCS ::= literalSimpleCS '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createDictLiteralPartCS((LiteralExpCS)getRhsSym(1), (OCLExpressionCS)getRhsSym(3));
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	
	dictLiteralPartListCSopt -> dictLiteralPartListCS	
	dictLiteralPartListCSopt ::= %empty
		/.$EmptyListAction./
		
	dictLiteralPartListCS ::= dictLiteralPartCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS ',' dictLiteralPartCS
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	dictLiteralPartListCS ::= dictLiteralPartListCS qvtErrorToken
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./

	OclExpressionCS -> returnExpCS 	
	returnExpCS ::= return oclExpressionCSOpt
		/.$BeginCode
				ReturnExpCS returnExpCS = createReturnExpCS((OCLExpressionCS)getRhsSym(2));
				CSTNode result = createExpressionStatementCS(returnExpCS);
				if(returnExpCS.getValue() != null) {
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(2));			
				} else {
					setOffsets(result, getRhsIToken(1));
				}
				setOffsets(returnExpCS, result);
				setResult(result);
		  $EndCode
		./

	oclExpressionCSOpt -> OclExpressionCS 
	oclExpressionCSOpt ::= %empty
		/.$NullAction./
	 
	expression_semi_list_element -> var_init_group_exp

	var_init_group_exp ::= var var_init_declarator_list
		/.$BeginCode
					setResult(getRhsSym(2));
		  $EndCode
		./

	var_init_group_exp ::= var '(' var_init_declarator_list ')'
		/.$BeginCode
					setResult(getRhsSym(3));
		  $EndCode
		./

	var_init_group_exp ::= var '(' var_init_declarator_list qvtErrorToken
		/.$BeginCode
					setResult(getRhsSym(3));
		  $EndCode
		./

	OclExpressionCS -> var_init_exp

	var_init_exp ::= var var_init_declarator
		/.$BeginCode
					setResult(getRhsSym(2));
		  $EndCode
		./

	var_init_exp ::= var '(' var_init_declarator ')'
		/.$BeginCode
					setResult(getRhsSym(3));
		  $EndCode
		./

	var_init_exp ::= var '(' var_init_declarator qvtErrorToken
		/.$BeginCode
					setResult(getRhsSym(3));
		  $EndCode
		./

	var_init_exp ::= var qvtErrorToken
		/.$BeginCode
					setResult($EMPTY_ELIST);
		  $EndCode
		./

	var_init_declarator_list ::= var_init_declarator ',' var_init_declarator
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	var_init_declarator_list ::= var_init_declarator_list ',' var_init_declarator
		/.$BeginCode
					EList result = (EList) getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./


	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							(Boolean)getRhsSym(4)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS var_init_op qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							null,
							(Boolean)getRhsSym(4)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER var_init_op OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							null,
							(OCLExpressionCS)getRhsSym(3),
							(Boolean)getRhsSym(2)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER var_init_op qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							null,
							null,
							(Boolean)getRhsSym(2)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' typeCS
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							null,
							false
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	var_init_declarator ::= IDENTIFIER ':' qvtErrorToken
		/.$BeginCode
					CSTNode result = createVariableInitializationCS(
							getRhsIToken(1),
							null,
							null,
							false
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./
		
	var_init_op ::= '='
		/.$NewCase./
	var_init_op ::= ':='
		/.$BeginCode
					setResult(false);
		  $EndCode
		./
	var_init_op ::= '::='
		/.$BeginCode
					setResult(true);
		  $EndCode
		./

	OclExpressionCS -> assignStatementCS

	assignStatementCS ::= primaryExpCS ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)getRhsSym(1),
							(OCLExpressionCS)getRhsSym(3),
							false
						);
					setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	assignStatementCS ::= primaryExpCS ':=' qvtErrorToken
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)getRhsSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
							false
						);
					setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./

	assignStatementCS ::= primaryExpCS '+=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)getRhsSym(1),
							(OCLExpressionCS)getRhsSym(3),
							true
						);
					setOffsets(result, (CSTNode)getRhsSym(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	assignStatementCS ::= primaryExpCS '+=' qvtErrorToken
		/.$BeginCode
					CSTNode result = createAssignStatementCS(
							(OCLExpressionCS)getRhsSym(1),
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, (IToken) null),
							true
						);
					setOffsets(result, (CSTNode)getRhsSym(1), getRhsIToken(2));
					setResult(result);
		  $EndCode
		./


	whileBodyCS -> expression_block


	whileExpCS ::= while '(' declarator1 ';' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					CSTNode result = createWhileExpCS(
							(VariableCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							(BlockExpCS)getRhsSym(7)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
					setResult(result);
		  $EndCode
		./

	whileExpCS ::= while '(' assignStatementCS ';' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					AssignStatementCS assignment = (AssignStatementCS)getRhsSym(3);
					CSTNode result = createWhileExpCS(
							getVariableFromAssignment(assignment),
							(OCLExpressionCS)getRhsSym(5),
							(BlockExpCS)getRhsSym(7)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
					setResult(result);
		  $EndCode
		./

	whileExpCS ::= while '(' OclExpressionCS ')' whileBodyCS
		/.$BeginCode
					CSTNode result = createWhileExpCS(
							null,
							(OCLExpressionCS)getRhsSym(3),
							(BlockExpCS)getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./
	
	-- ForExp begin

	IteratorExpCS ::= primaryExpCS '->' forExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
					ForExpCS forExpCS = (ForExpCS)getRhsSym(3);
					forExpCS.setSource(source);
					setOffsets(forExpCS, source, forExpCS);
					setResult(forExpCS);
		  $EndCode
		./

	IteratorExpCS ::= primaryExpCS '->' simpleNameCS '(' qvtErrorToken
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
					SimpleNameCS simpleNameCS = (SimpleNameCS)getRhsSym(3);
					CSTNode result = createIteratorExpCS(
							source,
							simpleNameCS,
							null,
							null,
							null
						);
					setOffsets(result, source, getRhsIToken(4));
					setResult(result);
		  $EndCode
		./

	argumentsCS ::= qvtErrorToken
		/.$EmptyListAction./	
	argumentsCS -> argumentsCS ',' qvtErrorToken


	forOpCode -> forEach
	forOpCode -> forOne

	forExpDeclaratorList ::= IDENTIFIER
        	/.$BeginCode
			EList result = new BasicEList();
			result.add(getRhsIToken(1));
			setResult(result);
	          $EndCode
        	./
	forExpDeclaratorList ::= forExpDeclaratorList ',' IDENTIFIER
        	/.$BeginCode
			EList result = (EList)getRhsSym(1);
			result.add(getRhsIToken(3));
			setResult(result);
	          $EndCode
        	./


	forExpConditionOpt ::= %empty
        	/.$NullAction./
        
	forExpConditionOpt ::= '|' OclExpressionCS
        	/.$BeginCode
                	    setResult((OCLExpressionCS)getRhsSym(2));
	          $EndCode
        	./

	forExpConditionOpt ::= '|' qvtErrorToken
        	/.$NullAction./

	forExpCS ::= forOpCode '(' forExpDeclaratorList forExpConditionOpt ')' expression_block
		/.$BeginCode
					CSTNode result = createForExpCS(
							getRhsIToken(1),
							(EList)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(4),
							(BlockExpCS)getRhsSym(6)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
					setResult(result);
		  $EndCode
		./

	forExpCS ::= forOpCode qvtErrorToken
		/.$BeginCode
					CSTNode result = createForExpCS(
							getRhsIToken(1),
							null,
							null,
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	-- ForExp end

	-- operation call and expression extension in QVT

	primaryNotNameCS -> whileExpCS
	

	----- ifExp (start) -----
	ifExpBodyCS -> OclExpressionCS
	ifExpBodyCS -> expression_block

	ifThenPart -> qvtErrorToken
	ifElsePart -> qvtErrorToken
	ifExpression -> qvtErrorToken

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifExpBodyCS endif
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							(OCLExpressionCS)getRhsSym(6)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
					setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifElsePart
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifThenPart
		/.$BeginCode
					CSTNode result = createIfExpCS(
							(OCLExpressionCS)getRhsSym(2),
							null,
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./

	IfExpCS ::= if ifExpression
		/.$BeginCode
					OCLExpressionCS invalidCondition = createInvalidLiteralExpCS("");
					invalidCondition.setStartOffset(getRhsIToken(1).getEndOffset());
					invalidCondition.setEndOffset(getRhsIToken(1).getEndOffset());
					CSTNode result = createIfExpCS(
							invalidCondition,
							null,
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	----- ifExp (end) -----

	----- switch -----

	primaryNotNameCS -> switchExpCS

	switchExpCS ::= switch switchBodyExpCS
		/.$BeginCode
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
		  $EndCode
		./

	switchDeclaratorCS -> declarator

	switchDeclaratorCS ::= IDENTIFIER
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							null,
							null
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	switchDeclaratorCS ::= IDENTIFIER '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							null,
							(OCLExpressionCS)getRhsSym(3)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./

	-- 'collect' shorthand for switch keyword 
	IterateExpCS ::= primaryExpCS '->' switch '(' switchDeclaratorCS ')' switchBodyExpCS
		/.$BeginCode
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
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), 
							iterators,
							null,
							switchExpCS,
							null
						);
						
					result.setSource((OCLExpressionCS) getRhsSym(1));
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
					
					setResult(result);
		  $EndCode
		./

	switchExpCS ::= switch qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchExpCS(
							new BasicEList(),
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt '}'
		/.$BeginCode
					Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsIToken(4)};
					setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' switchAltExpCSList switchElseExpCSOpt qvtErrorToken
		/.$BeginCode
					Object[] result = new Object[] {getRhsSym(2), getRhsSym(3), getRhsSym(3)};
					setResult(result);
		  $EndCode
		./

	switchBodyExpCS ::= '{' qvtErrorToken
		/.$BeginCode
					Object[] result = new Object[] {new BasicEList(), null, getRhsIToken(1)};
					setResult(result);
		  $EndCode
		./

	switchAltExpCSList ::= switchAltExpCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	switchAltExpCSList ::= switchAltExpCSList switchAltExpCS
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(2));
					setResult(result);
		  $EndCode
		./

	switchAltExpCS ::= case '(' OclExpressionCS ')' expression_statement
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) getRhsSym(3),
							(OCLExpressionCS) getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= case '(' OclExpressionCS ')' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) getRhsSym(3),
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
					setResult(result);
		  $EndCode
		./
	
	switchElseExpCSOpt ::= %empty
		/.$NullAction./
	switchElseExpCSOpt -> switchElseExpCS

	switchElseExpCS ::= else expression_statement
		/.$BeginCode
					setResult((CSTNode)getRhsSym(2));
		  $EndCode
		./
	switchElseExpCS ::= else qvtErrorToken
		/.$BeginCode
					setResult(null);
		  $EndCode
		./

	----- switch -----

	OclExpressionCS ::= primaryOCLExpressionCS 
		/.$BeginCode
					CSTNode result = createExpressionStatementCS(
							(OCLExpressionCS)getRhsSym(1)
						);
					setOffsets(result, (CSTNode)getRhsSym(1));
					setResult(result);
		  $EndCode
		./

	-- log expression call
	primaryOCLExpressionCS -> logExpCS
	
		
	logWhenExp ::= when OclExpressionCS
        /.$BeginCode
				OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(2);
				setResult(condition);
          $EndCode
        ./	
	
	logWhenExpOpt -> logWhenExp			
	logWhenExpOpt ::= %empty
	/.$NullAction./		
		
	logExpCS ::= log '(' argumentsCSopt ')' logWhenExpOpt
        /.$BeginCode
				OCLExpressionCS condition = (OCLExpressionCS) getRhsSym(5);
				LogExpCS result = (LogExpCS)createLogExpCS((EList<OCLExpressionCS>)getRhsSym(3), condition);
				if(condition != null) {
					setOffsets(result, getRhsIToken(1), condition);
				} else {
					setOffsets(result, getRhsIToken(1), getRhsIToken(4));
				}
				setResult(result);
          $EndCode
        ./

	-- assertion support	
	primaryOCLExpressionCS -> assertExpCS

	severityKindCS ::= simpleNameCS
		/.$BeginCode
				setResult(getRhsSym(1));
		  $EndCode
		./
		
	
	severityKindCSOpt -> severityKindCS
	
	severityKindCSOpt ::= %empty
	/.$NullAction./
	
	assertWithLogExp ::= with logExpCS
        /.$BeginCode
				LogExpCS logExp = (LogExpCS) getRhsSym(2);
				setOffsets(logExp, getRhsIToken(2), logExp);
				setResult(logExp);
          $EndCode
        ./	
	
	assertWithLogExpOpt -> assertWithLogExp
	assertWithLogExpOpt ::= %empty
	/.$NullAction./
		        
	assertExpCS ::= assert severityKindCSOpt '(' OclExpressionCS ')' assertWithLogExpOpt
        /.$BeginCode
				LogExpCS logExpCS = (LogExpCS)getRhsSym(6);
				OCLExpressionCS condition = (OCLExpressionCS)getRhsSym(4);
				AssertExpCS result = (AssertExpCS)createAssertExpCS(condition, (SimpleNameCS)getRhsSym(2), logExpCS);
		
				CSTNode end = logExpCS != null ? logExpCS : condition; 
				setOffsets(result, getRhsIToken(1), end);
				setResult(result);
          $EndCode
        ./


	-- ComputeExp start --

	computeExpCS ::= compute '(' declarator ')' expression_block
		/.$BeginCode
					CSTNode result = createComputeExpCS(
						(VariableCS) getRhsSym(3),
						(OCLExpressionCS) getRhsSym(5)
					);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./


	primaryNotNameCS -> computeExpCS

	-- ComputeExp end --

	-- imperative iterators

	IterateExpCS ::= primaryExpCS '->' imperativeIterateExpCS
		/.$BeginCode
					OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
					ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) getRhsSym(3);
					iterateExpCS.setSource(source);
					setOffsets(iterateExpCS, source, iterateExpCS);
					setResult(iterateExpCS);
		  $EndCode
		./

        -- here x12 means full notation in the 1 and 2 forms, x3 - in the 3 form
	-- <source> -> <collector-name> (<body_or_condition>) ;                              (1)
	-- <source> -> <collector-name> (<iterator-list> | <body_or_condition>) ;            (2)
	-- <source> -> <collector-name> (<iterator-list>; <target> = <body> | <condition>) ; (3)

	imperativeIteratorExpCSToken12 -> xselect
	imperativeIteratorExpCSToken12 -> xcollect
	imperativeIteratorExpCSToken12 -> selectOne
	imperativeIteratorExpCSToken12 -> collectOne

	imperativeIteratorExpCSToken3 -> collectselect
	imperativeIteratorExpCSToken3 -> collectselectOne

	imperativeIteratorExpCSToken -> imperativeIteratorExpCSToken12
	imperativeIteratorExpCSToken -> imperativeIteratorExpCSToken3


	imperativeIterateExpCS ::= imperativeIteratorExpCSToken12 '(' imperativeIterContents12 ')'
		/.$NewCase./
	imperativeIterateExpCS ::= imperativeIteratorExpCSToken3 '(' imperativeIterContents3 ')'
		/.$BeginCode
					String opCode = getRhsTokenText(1);
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getRhsIToken(1)
							);
					setOffsets(simpleNameCS, getRhsIToken(1));
					Object[] iterContents = (Object[]) getRhsSym(3);
					OCLExpressionCS bodyCS = null;
					OCLExpressionCS conditionCS = null;
					if ("xcollect".equals(opCode) 
						|| "collectOne".equals(opCode)) { 
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
		  $EndCode
		./

	imperativeIterateExpCS ::= imperativeIteratorExpCSToken qvtErrorToken
		/.$BeginCode
					SimpleNameCS simpleNameCS = createSimpleNameCS(
								SimpleTypeEnum.KEYWORD_LITERAL,
								getRhsIToken(1)
							);
					setOffsets(simpleNameCS, getRhsIToken(1));
					CSTNode result = createImperativeIterateExpCS(
							simpleNameCS,
							$EMPTY_ELIST,
							null,
							null,
							null
						);
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./
		

	imperativeIterContents12 ::= OclExpressionCS
		/.$BeginCode
					setResult(new Object[] {
							$EMPTY_ELIST,
							null,
							getRhsSym(1)
						});
		  $EndCode
		./
	
	imperativeIterContents12 ::= uninitializedVariableCS '|' OclExpressionCS
		/.$BeginCode
					EList iters = new BasicEList();
					iters.add(getRhsSym(1));
					
					setResult(new Object[] {
							iters,
							null,
							getRhsSym(3)
						});
		  $EndCode
		./

	imperativeIterContents12 ::= simpleNameCS ',' variableDeclarationListCS '|' OclExpressionCS
		/.$BeginCode
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
		  $EndCode
		./

	imperativeIterContents3 ::= variableDeclarationListCS ';' initializedVariableCS '|' OclExpressionCS
		/.$BeginCode
					setResult(new Object[] {
							getRhsSym(1),
							getRhsSym(3),
							getRhsSym(5)
						});
		  $EndCode
		./

	variableDeclarationListCS ::= uninitializedVariableCS
		/.$BeginCode
					EList result = new BasicEList();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	variableDeclarationListCS ::= variableDeclarationListCS ',' uninitializedVariableCS
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(3));
					setResult(result);
		  $EndCode
		./

	-- imperative iterators shorthand notation

	exclamationOpt ::= %empty
	        /.$NullAction./
	exclamationOpt -> '!'

	
	-- collectselect shorthand
	declarator_vsep ::= IDENTIFIER '|'
        	/.$BeginCode
			CSTNode result = createVariableCS(
						getRhsIToken(1),
                                                null,
						null
						);
                        setOffsets(result, getRhsIToken(1));
                        setResult(result);
	          $EndCode
        	./

	declarator_vsepOpt ::= %empty
	        /.$NullAction./
	declarator_vsepOpt -> declarator_vsep

	-- xselect/collectselect shorthand
	IterateExpCS ::= primaryExpCS exclamationOpt '[' declarator_vsepOpt OclExpressionCS ']'
		/.$BeginCode
			OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
			if (source instanceof ImperativeIterateExpCS) {
				String opCode = isTokenOfType(getRhsIToken(2), $sym_type.TK_EXCLAMATION_MARK) 
					?  "collectselectOne" 
					: "collectselect"; 
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
				String opCode = isTokenOfType(getRhsIToken(2), $sym_type.TK_EXCLAMATION_MARK) 
					?  "selectOne" 
					: "xselect"; 
				SimpleNameCS simpleNameCS = createSimpleNameCS(
						SimpleTypeEnum.KEYWORD_LITERAL,
						opCode
						);
				setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));
				
				CallExpCS result = createImperativeIterateExpCS(
						simpleNameCS,
						$EMPTY_ELIST,
						(VariableCS) getRhsSym(4),
						null,
						(OCLExpressionCS) getRhsSym(5)
						);
				result.setSource(source);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
			}
		  $EndCode
		./

	-- xcollect shorthand
	IterateExpCS ::= primaryExpCS '->' simpleNameCS
		/.$BeginCode
			String opCode = "xcollect"; 
			SimpleNameCS simpleNameCS = createSimpleNameCS(
					SimpleTypeEnum.KEYWORD_LITERAL,
					opCode
					);

			OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
			SimpleNameCS featureNameCS = (SimpleNameCS)getRhsSym(3);
			OCLExpressionCS featureCallExpCS = createFeatureCallExpCS(
					source,
					null,
					featureNameCS,
					new BasicEList(),
					null
					);
			setOffsets(featureCallExpCS, source, featureNameCS);

			ImperativeIterateExpCS result = createImperativeIterateExpCS(
					simpleNameCS,
					$EMPTY_ELIST,
					null,
					null,
					null
					);
			result.setSource(featureCallExpCS);
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
		  $EndCode
		./

	primaryNotNameCS -> newExpCS
	newExpCS ::= new newTypespecCS '(' argumentsCSopt ')' 
		/.$BeginCode
				OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) getRhsSym(2), (EList) getRhsSym(4));
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
		  $EndCode
		./	

	newTypespecCS ::= pathNameCS
		/.$BeginCode
					CSTNode result = createTypeSpecCS(
						(TypeCS)getRhsSym(1),
						null
						);
					setResult(result);
		  $EndCode
		./
	
		
	-- imperative BreakExp and ContinueExp registration
		
	primaryNotNameCS ::= break
		/.$BeginCode
				OCLExpressionCS result = createBreakCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
		  $EndCode
		./	
	
	primaryNotNameCS ::= continue
		/.$BeginCode
				OCLExpressionCS result = createContinueCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
		  $EndCode
		./	


	--=== General purpose grammar rules (start) ===--

	declarator -> declarator1
	declarator -> declarator2

	declarator1 ::= IDENTIFIER ':' typeCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							null
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./
	
	declarator1 ::= IDENTIFIER ':' typeCS '=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./

	declarator1 ::= IDENTIFIER ':' typeCS ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							(TypeCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./
		
	declarator2 ::= IDENTIFIER ':=' OclExpressionCS
		/.$BeginCode
					CSTNode result = createVariableCS(
							getRhsIToken(1),
							null,
							(OCLExpressionCS)getRhsSym(3)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(3));
					setResult(result);
		  $EndCode
		./


	semicolonOpt -> ';'
	semicolonOpt -> %empty

	expression_listOpt ::= %empty
		/.$EmptyListAction./
	expression_listOpt -> expression_list

	expression_list -> expression_semi_list semicolonOpt

	expression_semi_list_element -> OclExpressionCS
	expression_semi_list ::= expression_semi_list_element
		/.$BeginCode
					EList result = new BasicEList();
					Object element = getRhsSym(1);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	expression_semi_list ::= expression_semi_list ';' expression_semi_list_element 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					Object element = getRhsSym(3);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	expression_semi_list ::= expression_semi_list qvtErrorToken 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./

	expression_block ::= '{' expression_listOpt '}'
		/.$BeginCode
				EList bodyList = (EList) getRhsSym(2);
				CSTNode result = createBlockExpCS(
					bodyList
				);
				
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));
				setResult(result);
	          $EndCode
		./
	expression_block ::= '{' qvtErrorToken
		/.$BeginCode
				CSTNode result = createBlockExpCS(
					$EMPTY_ELIST
				);
				
				setOffsets(result, getRhsIToken(1));
				setResult(result);
	          $EndCode
		./

	expression_statement -> OclExpressionCS ';'
	expression_statement -> expression_block semicolonOpt

	qvtErrorToken ::= ERROR_TOKEN
		/.$BeginCode
					diagnozeErrorToken(getRhsTokenIndex(1));
		  $EndCode
		./

	--=== General purpose grammar rules (end) ===--


	--=== Non-standard extensions and legacy support (start) ===--
	switchAltExpCS ::= '(' OclExpressionCS ')' '?' OclExpressionCS ';'
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) getRhsSym(2),
							(OCLExpressionCS) getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= '(' OclExpressionCS ')' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							(OCLExpressionCS) getRhsSym(2),
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	switchAltExpCS ::= '(' qvtErrorToken
		/.$BeginCode
					CSTNode result = createSwitchAltExpCSDeprecated(
							null,
							null
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	switchElseExpCS ::= else '?' OclExpressionCS ';'
		/.$BeginCode
			    	int startOffset = getRhsIToken(1).getStartOffset();
			    	int endOffset = getRhsIToken(4).getEndOffset();
					reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					setResult((CSTNode)getRhsSym(3));
		  $EndCode
		./
	switchElseExpCS ::= else '?' OclExpressionCS qvtErrorToken
		/.$BeginCode
			    	int startOffset = getRhsIToken(1).getStartOffset();
			    	int endOffset = getRhsIToken(3).getEndOffset();
					reportWarning(org.eclipse.m2m.internal.qvt.oml.cst.parser.NLS.bind(org.eclipse.m2m.internal.qvt.oml.cst.parser.Messages.AbstractQVTParser_DeprecatedSwitchElseExp, null), startOffset, endOffset);
					
					setResult((CSTNode)getRhsSym(3));
		  $EndCode
		./
	--=== Non-standard extensions and legacy support (end) ===--

%End
