@echo off

set LPG_HOME=.\..\.externalTool\lpg.generator.win32_x86
set LPG_EXE=%LPG_HOME%\lpgexe\lpg-win32_x86.exe

set LPG_INCLUDE=%LPG_HOME%\include;.;
set LPG_TEMPLATE=%LPG_HOME%\templates;

set PERL_EXE=%LPG_HOME%\..\perl\perl.exe


rem --- QVTO Parser ---

%LPG_EXE% -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.parser QVTOParser.gi

FOR %%F IN (*.java) DO  %PERL_EXE% patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (*.java_nls) DO  move /Y %%F %%~nF.java

move /Y *.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\parser


rem --- QVTO Completion Parser ---

%LPG_EXE% -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.completion.parser completion/LightweightParser.gi
%LPG_EXE% -backtrack -list -package=org.eclipse.m2m.internal.qvt.oml.cst.completion.parser completion/LightweightTypeParser.gi

FOR %%F IN (completion\*.java) DO  %PERL_EXE% patch-non-nls.pl %%F > %%F_nls
FOR %%F IN (completion\*.java_nls) DO  move /Y %%F completion\%%~nF.java

move /Y completion\*.java .\..\src\org\eclipse\m2m\internal\qvt\oml\cst\completion\parser
