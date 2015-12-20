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
-- * $Id: ImperativeOCLKWLexer.gi,v 1.2 2010/01/24 13:59:56 sboyko Exp $ 
-- */
--
-- The Imperative OCL KeyWord Lexer
--

%options slr
%options fp=ImperativeOCLKWLexer,prefix=Char_
%options noserialize
%options template=../lpg/KeywordTemplateF.gi
%options export_terminals=("ImperativeOCLParsersym.java", "TK_")
%options include_directory=".;../lpg"


%Import
	EssentialOCLKWLexer.gi
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
	forEach
	forOne
	compute
	return
	var
	while
	continue
	log
	assert
	with
	new

%End

%Start
	ImperativeOCLKeyWord
%End

%Rules
	-- The Goal for the parser is a single keyword
	ImperativeOCLKeyWord ::=

		KeyWord
		
		| D i c t 
		/.$BeginAction
			$setResult($_Dict);
		  $EndAction
		./
		
		| L i s t 
		/.$BeginAction
			$setResult($_List);
		  $EndAction
		./
		
		| b r e a k 
		/.$BeginAction
			$setResult($_break);
		  $EndAction
		./
		
		| s w i t c h
		/.$BeginAction
			$setResult($_switch);
		  $EndAction
		./
		
		| c a s e
		/.$BeginAction
			$setResult($_case);
		  $EndAction
		./
		
		| x s e l e c t
		/.$BeginAction
			$setResult($_xselect);
		  $EndAction
		./
		
		| x c o l l e c t
		/.$BeginAction
			$setResult($_xcollect);
		  $EndAction
		./
		
		| s e l e c t O n e
		/.$BeginAction
			$setResult($_selectOne);
		  $EndAction
		./
		
		| c o l l e c t O n e
		/.$BeginAction
			$setResult($_collectOne);
		  $EndAction
		./
		
		| c o l l e c t s e l e c t
		/.$BeginAction
			$setResult($_collectselect);
		  $EndAction
		./
		
		| c o l l e c t s e l e c t O n e
		/.$BeginAction
			$setResult($_collectselectOne);
		  $EndAction
		./

		| f o r E a c h
		/.$BeginAction
			$setResult($_forEach);
		  $EndAction
		./
		
		| f o r O n e
		/.$BeginAction
			$setResult($_forOne);
		  $EndAction
		./
		
		| c o m p u t e
		/.$BeginAction
			$setResult($_compute);
		  $EndAction
		./
		
		| r e t u r n
		/.$BeginAction
			$setResult($_return);
		  $EndAction
		./		
		
		| v a r
		/.$BeginAction
			$setResult($_var);
		  $EndAction
		./
		
		| w h i l e
		/.$BeginAction
			$setResult($_while);
		  $EndAction
		./
		
		| c o n t i n u e 
		/.$BeginAction
			$setResult($_continue);
		  $EndAction
		./
		
		| l o g
		/.$BeginAction
			$setResult($_log);
		  $EndAction
		./
		
		| a s s e r t
		/.$BeginAction
			$setResult($_assert);
		  $EndAction
		./

		| w i t h
		/.$BeginAction
			$setResult($_with);
		  $EndAction
		./

		| n e w
		/.$BeginAction
			$setResult($_new);
		  $EndAction
		./
		
%End
