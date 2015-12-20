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
-- * $Id: QVTOKWLexer.gi,v 1.2 2010/01/24 13:59:57 sboyko Exp $ 
-- */
--
-- The QVTo KeyWord Lexer
--

%options slr
%options fp=QVTOKWLexer,prefix=Char_
%options noserialize
%options template=../lpg/KeywordTemplateF.gi
%options export_terminals=("QVTOParsersym.java", "TK_")
%options include_directory=".;../lpg"


%Import
	ImperativeOCLKWLexer.gi
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
	static
	init
	end
	out
	object
	transformation
	import
	library
	metamodel
	mapping
	query
	helper
	inout
	when
	configuration
	intermediate
	property
	opposites
	class
	population	
	map
	xmap
	late
	resolve
	resolveone
	resolveIn
	resolveoneIn
	invresolve
	invresolveone
	invresolveIn
	invresolveoneIn
	modeltype
	uses
	where
	refines
	access
	extends
	blackbox
	abstract
	result
	main
	this
	rename
	disjuncts
	merges
	inherits	
        composes
        constructor
        datatype
        default
        derived
        do
        elif
        enum
        except
        exception
        from
        literal
        ordered
        primitive
        raise
        readonly
        references
        tag
        try
        typedef
        unlimited

%End

%Start
	QVTOKeyWord
%End

%Rules
	-- The Goal for the parser is a single keyword
	QVTOKeyWord ::=

		ImperativeOCLKeyWord
		
		| s t a t i c
		/.$BeginAction
			$setResult($_static);
		  $EndAction
		./

		| i n i t
		/.$BeginAction
			$setResult($_init);
		  $EndAction
		./
		
		| e n d
		/.$BeginAction
			$setResult($_end);
		  $EndAction
		./
		
		| o u t
		/.$BeginAction
			$setResult($_out);
		  $EndAction
		./
		
		| o  b j e c t
		/.$BeginAction
			$setResult($_object);
		  $EndAction
		./
		
		| t r a n s f o r m a t i o n
		/.$BeginAction
			$setResult($_transformation);
		  $EndAction
		./
		
		| i m p o r t
		/.$BeginAction
			$setResult($_import);
		  $EndAction
		./
		
		| l i b r a r y
		/.$BeginAction
			$setResult($_library);
		  $EndAction
		./
		
		| m e t a m o d e l
		/.$BeginAction
			$setResult($_metamodel);
		  $EndAction
		./
		
		| d i s j u n c t s
		/.$BeginAction
			$setResult($_disjuncts);
		  $EndAction
		./
		
		| m e r g e s
		/.$BeginAction
			$setResult($_merges);
		  $EndAction
		./
		
		| i n h e r i t s
		/.$BeginAction
			$setResult($_inherits);
		  $EndAction
		./		

		| r e n a m e
		/.$BeginAction
			$setResult($_rename);
		  $EndAction
		./
		
		| m a p p i n g
		/.$BeginAction
			$setResult($_mapping);
		  $EndAction
		./
		
		| q u e r y
		/.$BeginAction
			$setResult($_query);
		  $EndAction
		./
		
		| h e l p e r
		/.$BeginAction
			$setResult($_helper);
		  $EndAction
		./		

		| i n o u t
		/.$BeginAction
			$setResult($_inout);
		  $EndAction
		./
		
		| w h e n
		/.$BeginAction
			$setResult($_when);
		  $EndAction
		./
		
		| c o n f i g u r a t i o n
		/.$BeginAction
			$setResult($_configuration);
		  $EndAction
		./
		
		| p o p u l a  t i o n		
		/.$BeginAction
			$setResult($_population);
		  $EndAction
		./
		
		| i n t e r m e d i a t e
		/.$BeginAction
			$setResult($_intermediate);
		  $EndAction
		./
		
		| p r o p e r t y
		/.$BeginAction
			$setResult($_property);
		  $EndAction
		./
		
		| o p p o s i t e s
		/.$BeginAction
			$setResult($_opposites);
		  $EndAction
		./
		
		| c l a s s
		/.$BeginAction
			$setResult($_class);
		  $EndAction
		./
		
		| m a p
		/.$BeginAction
			$setResult($_map);
		  $EndAction
		./
		
		| x m a p
		/.$BeginAction
			$setResult($_xmap);
		  $EndAction
		./

		| l a t e
		/.$BeginAction
			$setResult($_late);
		  $EndAction
		./

		| r e s o l v e
		/.$BeginAction
			$setResult($_resolve);
		  $EndAction
		./
		
		| r e s o l v e o n e
		/.$BeginAction
			$setResult($_resolveone);
		  $EndAction
		./
		
		| r e s o l v e I n
		/.$BeginAction
			$setResult($_resolveIn);
		  $EndAction
		./
		
		| r e s o l v e o n e I n
		/.$BeginAction
			$setResult($_resolveoneIn);
		  $EndAction
		./
		
		| i n v r e s o l v e
		/.$BeginAction
			$setResult($_invresolve);
		  $EndAction
		./
		
		| i n v r e s o l v e o n e
		/.$BeginAction
			$setResult($_invresolveone);
		  $EndAction
		./
		
		| i n v r e s o l v e I n
		/.$BeginAction
			$setResult($_invresolveIn);
		  $EndAction
		./
		
		| i n v r e s o l v e o n e I n
		/.$BeginAction
			$setResult($_invresolveoneIn);
		  $EndAction
		./

		| m o d e l t y p e
		/.$BeginAction
			$setResult($_modeltype);
		  $EndAction
		./
		
		| u s e s
		/.$BeginAction
			$setResult($_uses);
		  $EndAction
		./
		
		| w h e r e
		/.$BeginAction
			$setResult($_where);
		  $EndAction
		./
		
		| r e f i n e s
		/.$BeginAction
			$setResult($_refines);
		  $EndAction
		./
		
		| a c c e s s
		/.$BeginAction
			$setResult($_access);
		  $EndAction
		./
		
		| e x t e n d s
		/.$BeginAction
			$setResult($_extends);
		  $EndAction
		./
		
		| b l a c k b o x
		/.$BeginAction
			$setResult($_blackbox);
		  $EndAction
		./
		
		| a b s t r a c t
		/.$BeginAction
			$setResult($_abstract);
		  $EndAction
		./
		
		| r e s u l t
		/.$BeginAction
			$setResult($_result);
		  $EndAction
		./
		
		| m a i n
		/.$BeginAction
			$setResult($_main);
		  $EndAction
		./
		
		| t h i s
		/.$BeginAction
			$setResult($_this);
		  $EndAction
		./
		
		| c o m p o s e s 
		/.$BeginAction
			$setResult($_composes);
		  $EndAction
		./
		
		| c o n s t r u c t o r 
		/.$BeginAction
			$setResult($_constructor);
		  $EndAction
		./
		
		| d a t a t y p e 
		/.$BeginAction
			$setResult($_datatype);
		  $EndAction
		./
		
		| d e f a u l t 
		/.$BeginAction
			$setResult($_default);
		  $EndAction
		./
		
		| d e r i v e d 
		/.$BeginAction
			$setResult($_derived);
		  $EndAction
		./
		
		| d o 
		/.$BeginAction
			$setResult($_do);
		  $EndAction
		./
		
		| e l i f 
		/.$BeginAction
			$setResult($_elif);
		  $EndAction
		./
		
		| e n u m 
		/.$BeginAction
			$setResult($_enum);
		  $EndAction
		./
		
		| e x c e p t 
		/.$BeginAction
			$setResult($_except);
		  $EndAction
		./
		
		| e x c e p t i o n 
		/.$BeginAction
			$setResult($_exception);
		  $EndAction
		./
		
		| f r o m 
		/.$BeginAction
			$setResult($_from);
		  $EndAction
		./
		
		| l i t e r a l 
		/.$BeginAction
			$setResult($_literal);
		  $EndAction
		./
		
		| o r d e r e d 
		/.$BeginAction
			$setResult($_ordered);
		  $EndAction
		./
		
		| p r i m i t i v e 
		/.$BeginAction
			$setResult($_primitive);
		  $EndAction
		./
		
		| r a i s e 
		/.$BeginAction
			$setResult($_raise);
		  $EndAction
		./
		
		| r e a d o n l y 
		/.$BeginAction
			$setResult($_readonly);
		  $EndAction
		./
		
		| r e f e r e n c e s 
		/.$BeginAction
			$setResult($_references);
		  $EndAction
		./
		
		| t a g 
		/.$BeginAction
			$setResult($_tag);
		  $EndAction
		./
		
		| t r y 
		/.$BeginAction
			$setResult($_try);
		  $EndAction
		./
		
		| t y p e d e f 
		/.$BeginAction
			$setResult($_typedef);
		  $EndAction
		./
		
		| u n l i m i t e d 
		/.$BeginAction
			$setResult($_unlimited);
		  $EndAction
		./

%End
