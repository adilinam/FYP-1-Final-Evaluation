--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006, 2013 Borland Inc.
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

	LiteralExpCS -> TypeLiteralExpCS

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
	import org.eclipse.m2m.internal.qvt.oml.cst.SwitchExpCS;
	./
%End


%Notice
	/./**
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
	./
%End


%Headers
	/.
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

	LiteralExpCS -> primitiveTypeCS
	LiteralExpCS -> collectionTypeCS
	LiteralExpCS -> tupleTypeCS

	primaryNotNameCS -> ImperativeExpCS


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
					EList<Object> result = new BasicEList<Object>();
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


	ImperativeExpCS -> RaiseExpCS
	ImperativeExpCS -> TryExpCS	

	RaiseExpCS ::= raise pathNameCS raise_arg_opt
		/.$BeginCode
				CSTNode result = createRaiseExpCS((TypeCS)getRhsSym(2), (OCLExpressionCS)getRhsSym(3));
				setOffsets(result, getRhsIToken(1), getRhsIToken(3));			
				setResult(result);
		  $EndCode
		./
		
	RaiseExpCS ::= raise StringLiteralExpCS
		/.$BeginCode
				CSTNode result = createRaiseExpCS(null, (OCLExpressionCS)getRhsSym(2));
				setOffsets(result, getRhsIToken(1), getRhsIToken(2));			
				setResult(result);
		  $EndCode
		./

	raise_arg_opt -> raise_arg
	raise_arg_opt ::= %empty
		/.$NullAction./
		
	raise_arg ::= '(' oclExpressionCSOpt ')'
		/.$BeginCode
					setResult(getRhsSym(2));
		  $EndCode
		./


	TryExpCS ::= try expression_block CatchExp_list
		/.$BeginCode
					CSTNode result = createTryExpCS(
							(BlockExpCS)getRhsSym(2),
							(EList)getRhsSym(3)
						);
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./
	
	CatchExp_list ::= CatchExp
		/.$BeginCode
					EList<Object> result = new BasicEList<Object>();
					result.add(getRhsSym(1));
					setResult(result);
		  $EndCode
		./
	CatchExp_list ::= CatchExp_list CatchExp
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					result.add(getRhsSym(2));
					setResult(result);
		  $EndCode
		./

	CatchExp ::= except '(' except_type_list_opt ')' expression_block
		/.$BeginCode
					CSTNode result = createCatchExpCS(
							null,
							(EList)getRhsSym(3),
							(BlockExpCS)getRhsSym(5)							
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./

	CatchExp ::= except '(' IDENTIFIER ':' type_list ')' expression_block
		/.$BeginCode
					CSTNode result = createCatchExpCS(
							getRhsIToken(3),
							(EList)getRhsSym(5),
							(BlockExpCS)getRhsSym(7)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
					setResult(result);
		  $EndCode
		./

	except_type_list_opt -> type_list 
	except_type_list_opt ::= %empty
		/.$EmptyListAction./
		

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
					EList<Object> result = new BasicEList<Object>();
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
					OCLExpressionCS invalidBody = createInvalidLiteralExpCS("");
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
		  $EndCode
		./

	argumentsCS ::= qvtErrorToken
		/.$EmptyListAction./	
	argumentsCS -> argumentsCS ',' qvtErrorToken


	forOpCode -> forEach
	forOpCode -> forOne

	forExpDeclaratorList ::= IDENTIFIER
        	/.$BeginCode
			EList<Object> result = new BasicEList<Object>();
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

	ImperativeExpCS -> whileExpCS
	

	----- ifExp (start) -----
	ifExpBodyCS -> OclExpressionCS
	ifExpBodyCS -> expression_block

	ifThenPart -> qvtErrorToken
	ifElsePart -> qvtErrorToken
	ifExpression -> qvtErrorToken

	ifElseOpt ::= %empty
		/.$NullAction./
	ifElseOpt ::= else ifExpBodyCS
		/.$BeginCode
					CSTNode result = (CSTNode) getRhsSym(2);
					setOffsets(result, getRhsIToken(1), result);
					setResult(result);
		  $EndCode
		./

	ifElif_listOpt ::= %empty
		/.$EmptyListAction./
	ifElif_listOpt -> ifElif_list

	ifElif_listElem ::= elif OclExpressionCS then ifExpBodyCS
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) getRhsSym(2),
							(OCLExpressionCS) getRhsSym(4)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(4));
					setResult(result);
		  $EndCode
		./

	ifElif_list ::= ifElif_listElem
		/.$BeginCode
					EList<Object> result = new BasicEList<Object>();
					Object element = getRhsSym(1);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	ifElif_list ::= ifElif_list ifElif_listElem 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					Object element = getRhsSym(2);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	ifElif_list ::= ifElif_list qvtErrorToken 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					setResult(result);
		  $EndCode
		./


	IfExpCS ::= if OclExpressionCS then ifExpBodyCS ifElif_listOpt ifElseOpt endif
		/.$BeginCode
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
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifExpBodyCS else ifElsePart
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(2),
							(OCLExpressionCS)getRhsSym(4),
							$EMPTY_ELIST,
							null
							);
					setOffsets(result, getRhsIToken(1), getRhsIToken(5));
					setResult(result);
		  $EndCode
		./

	IfExpCS ::= if OclExpressionCS then ifThenPart
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(2),
							null,
							$EMPTY_ELIST,
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
					CSTNode result = createIfExpCSExt(
							invalidCondition,
							null,
							$EMPTY_ELIST,
							null
							);
					setOffsets(result, getRhsIToken(1), getRhsIToken(1));
					setResult(result);
		  $EndCode
		./


	IfExpCS_ext ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							$EMPTY_ELIST,
							null
							);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full endif
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							$EMPTY_ELIST,
							null
							);
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full ifElif_ext_list endifOpt
		/.$BeginCode
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
		  $EndCode
		./
	IfExpCS_ext ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full else notUMinus_ifExpBodyCS endifOptOpt
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							$EMPTY_ELIST,
							(OCLExpressionCS)getRhsSym(7)
							);

					CSTNode endifOptCS = (CSTNode)getRhsSym(8);
					CSTNode end = endifOptCS != null ? endifOptCS : (CSTNode)getRhsSym(7); 

					setOffsets(result, getRhsIToken(1), end);
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full ifElif_ext_list else notUMinus_ifExpBodyCS endifOptOpt
		/.$BeginCode
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
		  $EndCode
		./

	mandatory_elsePart ::= else notUMinus_ifExpBodyCS_full endifOptOpt
		/.$BeginCode
					CSTNode result = (CSTNode) getRhsSym(2);

					CSTNode endifOptCS = (CSTNode)getRhsSym(3);
					CSTNode end = endifOptCS != null ? endifOptCS : (CSTNode)getRhsSym(2); 

					setOffsets(result, getRhsIToken(1), end);
					setResult(result);
		  $EndCode
		./

	IfExpCS_ext_full ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full mandatory_elsePart
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							$EMPTY_ELIST,
							(OCLExpressionCS)getRhsSym(6)
							);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(6));
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext_full ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full ifElif_ext_list mandatory_elsePart
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							(EList)getRhsSym(6),
							(OCLExpressionCS)getRhsSym(7)
							);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(7));
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext_full ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full endif
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							$EMPTY_ELIST,
							null
							);
					setOffsets(result, getRhsIToken(1), getRhsIToken(6));
					setResult(result);
		  $EndCode
		./
	IfExpCS_ext_full ::= if '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full ifElif_ext_list endif
		/.$BeginCode
					CSTNode result = createIfExpCSExt(
							(OCLExpressionCS)getRhsSym(3),
							(OCLExpressionCS)getRhsSym(5),
							(EList)getRhsSym(6),
							null
							);
					setOffsets(result, getRhsIToken(1), getRhsIToken(7));
					setResult(result);
		  $EndCode
		./

	expression_semi_list_element -> IfExpCS_ext


	ifElif_ext_listElem ::= elif '(' OclExpressionCS ')' notUMinus_ifExpBodyCS_full
		/.$BeginCode
					CSTNode result = createSwitchAltExpCS(
							(OCLExpressionCS) getRhsSym(3),
							(OCLExpressionCS) getRhsSym(5)
						);
					setOffsets(result, getRhsIToken(1), (CSTNode)getRhsSym(5));
					setResult(result);
		  $EndCode
		./

	ifElif_ext_list ::= ifElif_ext_listElem
		/.$BeginCode
					EList<Object> result = new BasicEList<Object>();
					Object element = getRhsSym(1);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	 ifElif_ext_list ::= ifElif_ext_list ifElif_ext_listElem 
		/.$BeginCode
					EList result = (EList)getRhsSym(1);
					Object element = getRhsSym(2);
					if (element instanceof EList) {
						result.addAll((EList) element);
					} else {
						result.add(element);
					}
					setResult(result);
		  $EndCode
		./
	--ifElif_ext_list ::= ifElif_ext_list qvtErrorToken 
	--	/.$BeginCode
	--				EList result = (EList)getRhsSym(1);
	--				setResult(result);
	--	  $EndCode
	--	./

	endifOpt ::= %empty
		/.$NullAction./
	endifOpt ::= endif
		/.$BeginCode
					SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getRhsIToken(1));
					setOffsets(result, getRhsIToken(1));
					setResult(result);
		  $EndCode
		./

	-- The rule below results in 3 reduce/reduce conflicts and 5 shift/reduce conflicts during grammar generation.
	-- However generated grammar is correct since all conflicts are reduced to optional 'endif' keyword.
	-- In order to generate grammar without warnings uncomment the following two lines and comment the third.
	-- In order to generate 'endif'-tolerant grammar do the opposite.
	--endifOptOpt ::= %empty
	--	/.$NullAction./
	endifOptOpt -> endifOpt

	notUMinus_statement -> notUMinus_OclExpressionCS
	notUMinus_statement -> expression_block

	notUMinus_ifExpBodyCS -> notUMinus_statement
	notUMinus_ifExpBodyCS -> IfExpCS_ext

	notUMinus_ifExpBodyCS_full -> notUMinus_statement
	notUMinus_ifExpBodyCS_full -> IfExpCS_ext_full


	notUMinus_OclExpressionCS -> notUMinus_notNameExpressionCS
	notUMinus_OclExpressionCS -> SimpleNameExpCS
	notUMinus_OclExpressionCS -> returnExpCS
	notUMinus_OclExpressionCS -> var_init_exp
	notUMinus_OclExpressionCS -> assignStatementCS
	notUMinus_OclExpressionCS -> primaryOCLExpressionCS

	notUMinus_notNameExpressionCS -> notUMinus_impliesNotNameNotLetCS
	notUMinus_notNameExpressionCS -> notUMinus_impliesWithLetCS

	notUMinus_impliesNotLetCS -> notUMinus_impliesNotNameNotLetCS
	notUMinus_impliesNotLetCS -> SimpleNameExpCS
	notUMinus_impliesNotNameNotLetCS -> notUMinus_xorNotNameNotLetCS
	notUMinus_impliesNotNameNotLetCS ::= notUMinus_impliesNotLetCS implies notUMinus_xorNotLetCS
		/.$NewCase./
	notUMinus_impliesWithLetCS -> notUMinus_xorWithLetCS
	notUMinus_impliesWithLetCS ::= notUMinus_impliesNotLetCS implies notUMinus_xorWithLetCS
		/.$NewCase./

	notUMinus_xorNotLetCS -> notUMinus_xorNotNameNotLetCS
	notUMinus_xorNotLetCS -> SimpleNameExpCS
	notUMinus_xorNotNameNotLetCS -> notUMinus_orNotNameNotLetCS
	notUMinus_xorNotNameNotLetCS ::= notUMinus_xorNotLetCS xor notUMinus_orNotLetCS
		/.$NewCase./
	notUMinus_xorWithLetCS -> notUMinus_orWithLetCS
	notUMinus_xorWithLetCS ::= notUMinus_xorNotLetCS xor notUMinus_orWithLetCS
		/.$NewCase./

	notUMinus_orNotLetCS -> notUMinus_orNotNameNotLetCS
	notUMinus_orNotLetCS -> SimpleNameExpCS
	notUMinus_orNotNameNotLetCS -> notUMinus_andNotNameNotLetCS
	notUMinus_orNotNameNotLetCS ::= notUMinus_orNotLetCS or notUMinus_andNotLetCS
		/.$NewCase./
	notUMinus_orWithLetCS -> notUMinus_andWithLetCS
	notUMinus_orWithLetCS ::= notUMinus_orNotLetCS or notUMinus_andWithLetCS
		/.$NewCase./

	notUMinus_andNotLetCS -> notUMinus_andNotNameNotLetCS
	notUMinus_andNotLetCS -> SimpleNameExpCS
	notUMinus_andNotNameNotLetCS -> notUMinus_equalityNotNameNotLetCS
	notUMinus_andNotNameNotLetCS ::= notUMinus_andNotLetCS and notUMinus_equalityNotLetCS
		/.$NewCase./
	notUMinus_andWithLetCS -> notUMinus_equalityWithLetCS
	notUMinus_andWithLetCS ::= notUMinus_andNotLetCS and notUMinus_equalityWithLetCS
		/.$NewCase./

	notUMinus_equalityNotLetCS -> notUMinus_equalityNotNameNotLetCS
	notUMinus_equalityNotLetCS -> SimpleNameExpCS
	notUMinus_equalityNotNameNotLetCS -> notUMinus_relationalNotNameNotLetCS
	notUMinus_equalityNotNameNotLetCS ::= notUMinus_equalityNotLetCS '=' notUMinus_relationalNotLetCS
		/.$NewCase./
	notUMinus_equalityNotNameNotLetCS ::= notUMinus_equalityNotLetCS '<>' notUMinus_relationalNotLetCS
		/.$NewCase./
	notUMinus_equalityWithLetCS -> notUMinus_relationalWithLetCS
	notUMinus_equalityWithLetCS ::= notUMinus_equalityNotLetCS '=' notUMinus_relationalWithLetCS
		/.$NewCase./
	notUMinus_equalityWithLetCS ::= notUMinus_equalityNotLetCS '<>' notUMinus_relationalWithLetCS
		/.$NewCase./

	notUMinus_relationalNotLetCS -> notUMinus_relationalNotNameNotLetCS
	notUMinus_relationalNotLetCS -> SimpleNameExpCS
	notUMinus_relationalNotNameNotLetCS -> notUMinus_additiveNotNameNotLetCS
	notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS '>' notUMinus_additiveNotLetCS
		/.$NewCase./
	notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS '<' notUMinus_additiveNotLetCS
		/.$NewCase./
	notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS '>=' notUMinus_additiveNotLetCS
		/.$NewCase./
	notUMinus_relationalNotNameNotLetCS ::= notUMinus_relationalNotLetCS '<=' notUMinus_additiveNotLetCS
		/.$NewCase./
	notUMinus_relationalWithLetCS -> notUMinus_additiveWithLetCS
	notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS '>' notUMinus_additiveWithLetCS
		/.$NewCase./
	notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS '<' notUMinus_additiveWithLetCS
		/.$NewCase./
	notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS '>=' notUMinus_additiveWithLetCS
		/.$NewCase./
	notUMinus_relationalWithLetCS ::= notUMinus_relationalNotLetCS '<=' notUMinus_additiveWithLetCS
		/.$NewCase./

	notUMinus_additiveNotLetCS -> notUMinus_additiveNotNameNotLetCS
	notUMinus_additiveNotLetCS -> SimpleNameExpCS
	notUMinus_additiveNotNameNotLetCS -> notUMinus_multiplicativeNotNameNotLetCS
	notUMinus_additiveNotNameNotLetCS ::= notUMinus_additiveNotLetCS '+' notUMinus_multiplicativeNotLetCS
		/.$NewCase./
	notUMinus_additiveNotNameNotLetCS ::= notUMinus_additiveNotLetCS '-' notUMinus_multiplicativeNotLetCS
		/.$NewCase./
	notUMinus_additiveWithLetCS -> notUMinus_multiplicativeWithLetCS
	notUMinus_additiveWithLetCS ::= notUMinus_additiveNotLetCS '+' notUMinus_multiplicativeWithLetCS
		/.$NewCase./
	notUMinus_additiveWithLetCS ::= notUMinus_additiveNotLetCS '-' notUMinus_multiplicativeWithLetCS
		/.$NewCase./

	notUMinus_multiplicativeNotLetCS -> notUMinus_multiplicativeNotNameNotLetCS
	notUMinus_multiplicativeNotLetCS -> SimpleNameExpCS
	notUMinus_multiplicativeNotNameNotLetCS -> notUMinus_unaryNotNameNotLetCS
	notUMinus_multiplicativeNotNameNotLetCS ::= notUMinus_multiplicativeNotLetCS '*' notUMinus_unaryNotLetCS
		/.$NewCase./
	notUMinus_multiplicativeNotNameNotLetCS ::= notUMinus_multiplicativeNotLetCS '/' notUMinus_unaryNotLetCS
		/.$NewCase./
	notUMinus_multiplicativeWithLetCS -> notUMinus_unaryWithLetCS
	notUMinus_multiplicativeWithLetCS ::= notUMinus_multiplicativeNotLetCS '*' notUMinus_unaryWithLetCS
		/.$NewCase./
	notUMinus_multiplicativeWithLetCS ::= notUMinus_multiplicativeNotLetCS '/' notUMinus_unaryWithLetCS
		/.$BeginCode
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
		  $EndCode
		./

	notUMinus_unaryNotLetCS -> notUMinus_unaryNotNameNotLetCS
	notUMinus_unaryNotLetCS -> SimpleNameExpCS
	notUMinus_unaryNotNameNotLetCS -> notUMinus_primaryNotNameCS
	-- notUMinus_unaryNotNameNotLetCS ::= '-' unaryNotLetCS
	--     /.$NewCase./
	notUMinus_unaryNotNameNotLetCS ::= not notUMinus_unaryNotLetCS
		/.$NewCase./
	notUMinus_unaryWithLetCS -> LetExpCS             -- OclExpressionCS[D]
	notUMinus_unaryWithLetCS ::= not notUMinus_unaryWithLetCS
		/.$BeginCode
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
		  $EndCode
		./

	notUMinus_primaryNotNameCS -> CallExpCS       -- OclExpressionCS[A]
	notUMinus_primaryNotNameCS -> VariableExpCS   -- OclExpressionCS[B]
	notUMinus_primaryNotNameCS -> notUMinus_LiteralExpCS    -- OclExpressionCS[C]
	-- notUMinus_primaryNotNameCS -> OclMessageExpCS -- OclExpressionCS[E] is added by Complete OCL
	notUMinus_primaryNotNameCS -> IfExpCS         -- OclExpressionCS[F]
	notUMinus_primaryNotNameCS ::= '(' OclExpressionCS ')'
		/.$BeginCode
					OCLExpressionCS result = (OCLExpressionCS)getRhsSym(2);
					if (result instanceof OperationCallExpCS) {
						((OperationCallExpCS)result).setIsAtomic(true);
					}
					setOffsets(result, getRhsIToken(1), getRhsIToken(3));
					setResult(result);
		  $EndCode
		./

	notUMinus_primaryNotNameCS -> ImperativeExpCS

	-- notUMinus_LiteralExpCS -> EnumLiteralExpCS
	notUMinus_LiteralExpCS -> CollectionLiteralExpCS
	notUMinus_LiteralExpCS -> TupleLiteralExpCS
	notUMinus_LiteralExpCS -> notUMinus_PrimitiveLiteralExpCS
	-- notUMinus_LiteralExpCS -> TypeLiteralExpCS
	notUMinus_LiteralExpCS -> listLiteralCS
	notUMinus_LiteralExpCS -> dictLiteralCS

	notUMinus_LiteralExpCS -> primitiveTypeCS
	notUMinus_LiteralExpCS -> collectionTypeCS
	notUMinus_LiteralExpCS -> tupleTypeCS

	notUMinus_PrimitiveLiteralExpCS -> IntegerLiteralExpCS
	notUMinus_PrimitiveLiteralExpCS -> RealLiteralExpCS
	notUMinus_PrimitiveLiteralExpCS -> StringLiteralExpCS
	notUMinus_PrimitiveLiteralExpCS -> BooleanLiteralExpCS
	-- notUMinus_PrimitiveLiteralExpCS -> UnlimitedNaturalLiteralExpCS
	notUMinus_PrimitiveLiteralExpCS -> InvalidLiteralExpCS
	notUMinus_PrimitiveLiteralExpCS -> NullLiteralExpCS

	----- ifExp (end) -----

	----- do ---------

	ImperativeExpCS -> blockExpCS

	blockExpCS ::= do expression_block
		/.$BeginCode
					BlockExpCS blockExpCS = (BlockExpCS) getRhsSym(2);
					setOffsets(blockExpCS, getRhsIToken(1), blockExpCS);
					setResult(blockExpCS);
		  $EndCode
		./


	----- switch -----

	ImperativeExpCS -> switchExpCS

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


	-- 'xcollect' shorthand for object keyword
	IterateExpCS ::= primaryExpCS '->' object '(' uninitializedVariableCS ')' objectDeclCS expression_block
		/.$BeginCode
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
							createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"), 
							iterators,
							null,
							objectExpCS,
							null
						);
						
					result.setSource((OCLExpressionCS) getRhsSym(1));
					setOffsets(result, getRhsIToken(1), getRhsIToken(8));
					
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
							$EMPTY_ELIST,
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
					Object[] result = new Object[] {$EMPTY_ELIST, null, getRhsIToken(1)};
					setResult(result);
		  $EndCode
		./

	switchAltExpCSList ::= switchAltExpCS
		/.$BeginCode
					EList<Object> result = new BasicEList<Object>();
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


	ImperativeExpCS -> computeExpCS

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
					EList<Object> iters = new BasicEList<Object>();
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
					EList<Object> result = new BasicEList<Object>();
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
			if (source instanceof ImperativeIterateExpCS
				&& "xcollect".equals(((ImperativeIterateExpCS)source).getSimpleNameCS().getValue())) {
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
		  $EndCode
		./

	-- xcollect shorthand
	IterateExpCS ::= primaryExpCS '->' simpleNameCS
		/.$BeginCode
			OCLExpressionCS source = (OCLExpressionCS)getRhsSym(1);
			SimpleNameCS featureNameCS = (SimpleNameCS)getRhsSym(3);
			VariableExpCS variableCS = createVariableExpCS(
					featureNameCS,
					$EMPTY_ELIST,
					null
			);
			setOffsets(variableCS, featureNameCS);

			ImperativeIterateExpCS result = createImperativeIterateExpCS(
					createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "xcollect"),  //$NON-NLS-1$
					$EMPTY_ELIST,
					null,
					variableCS,
					null
					);
			result.setSource(source);
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
		  $EndCode
		./

	ImperativeExpCS -> newExpCS

	newExpCS ::= new typespec '(' argumentsCSopt ')' 
		/.$BeginCode
				OCLExpressionCS result = createNewRuleCallExpCS((TypeSpecCS) getRhsSym(2), (EList) getRhsSym(4));
				setOffsets(result, getRhsIToken(1), getRhsIToken(5));
				setResult(result);
		  $EndCode
		./	

		
	-- imperative BreakExp and ContinueExp registration
		
	breakExpCS ::= break
		/.$BeginCode
				OCLExpressionCS result = createBreakCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
		  $EndCode
		./	
	
	continueExpCS ::= continue
		/.$BeginCode
				OCLExpressionCS result = createContinueCS();
				setOffsets(result, getRhsIToken(1));
				setResult(result);
		  $EndCode
		./	

	ImperativeExpCS -> breakExpCS

	ImperativeExpCS -> continueExpCS


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
					EList<Object> result = new BasicEList<Object>();
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
