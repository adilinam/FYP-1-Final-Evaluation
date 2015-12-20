--/**
-- * <copyright>
-- *
-- * Copyright (c) 2006, 2007 Borland Inc.
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
-- * $Id: ImperativeOCLLexer.gi,v 1.4 2010/01/29 15:27:08 sboyko Exp $
-- */
--
-- The Imperative OCL Lexer
--

%options escape=$
%options la=2
%options fp=ImperativeOCLLexer,prefix=Char_
%options single-productions
%options noserialize
%options template=../lpg/LexerTemplateF.gi
%options filter=ImperativeOCLKWLexer.gi
%options export_terminals=("ImperativeOCLParsersym.java", "TK_")
%options include_directory=".;../lpg"


%Import
	EssentialOCLLexer.gi

%DropRules
	Token ::= '"' SLNotDQ '"'

%End

%Define
	$kw_lexer_class /.ImperativeOCLKWLexer./

%End


%Notice
	/./**
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
	./
%End


%Export
	RESET_ASSIGN
	ADD_ASSIGN
	EXCLAMATION_MARK
	COLONCOLONEQUAL
	QUESTIONMARK

%End

%Rules
	Token ::= ':' '='
		/.$BeginAction
					makeToken($_RESET_ASSIGN);
		  $EndAction
		./

	Token ::= '+' '='
		/.$BeginAction
					makeToken($_ADD_ASSIGN);
		  $EndAction
		./

	Token ::= '!'
		/.$BeginAction
					makeToken($_EXCLAMATION_MARK);
		  $EndAction
		./

	Token ::= ':' ':' '='
		/.$BeginAction
					makeToken($_COLONCOLONEQUAL);
		  $EndAction
		./

	Token ::= '?'
		/.$BeginAction
					makeToken($_QUESTIONMARK);
		  $EndAction
		./

	NotSQ -> HT
	NotSQ -> LF
	NotSQ -> CR
	
	NotDQ -> HT
	NotDQ -> LF
	NotDQ -> CR

	Token ::= DoubleQuote SLNotDQOpt DoubleQuote
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	SLNotDQOpt -> %empty
			| SLNotDQ

	SLC -> '/' '/'

%End
