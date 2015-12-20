%options escape=$
%options la=2
%options fp=LightweightTypeParser,prefix=TK_
%options noserialize
--%options import_terminals=../QVTOLexer.gi
%options ast_type=CSTNode
%options template=btParserTemplateF.gi
%options include_directory=".;../lpg;../../lpg"

%Start
    QvtLwGoal
%End

%Import
	../QVTOParser.gi
%End

%Globals
	/.
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParserprs;
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOLexer;	
	import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;	
	./
%End


%Rules
	QvtLwGoal -> typespec
%End