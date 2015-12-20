/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import lpg.runtime.IPrsStream;
import lpg.runtime.IToken;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.WorkspaceMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.IMetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.ocl.lpg.AbstractLexer;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 5, 2007
 */

public class QvtCompletionData {

	public interface ITokenQualificator {
		boolean isSuited(IToken token);
	}
	
    public static final int[] MAPPING_DECLARATION_TRAILING_TOKEN_KINDS = new int[] {
        QVTOParsersym.TK_LBRACE, QVTOParsersym.TK_SEMICOLON,
        QVTOParsersym.TK_when, QVTOParsersym.TK_where,
        QVTOParsersym.TK_inherits, QVTOParsersym.TK_merges, QVTOParsersym.TK_disjuncts
    };

    private final ITextEditor myEditor;
    private final ITextViewer myViewer;
    private final IDocument myDocument;
    private final IMetamodelRegistryProvider myMetamodelProvider;
    private final int myOffset;
    private final Map<String, Object> myUserData = new HashMap<String, Object>();
    private IToken myLeftToken;
    private IToken myCurrentToken;
    private AbstractLexer myLexer;
    private IPrsStream myPrsStream;
    private Exception myException;
    private IFile myIFile;
    private UnitProxy myCFile;
    private String myCharSet;
    
    private QvtCompletionCompiler myQvtCompiler;

    private IToken myParentImperativeOperation;

    public QvtCompletionData(ITextEditor editor, ITextViewer viewer, UnitProxy unit, int offset) {
        myEditor = editor;
        myViewer = viewer;
        myDocument = viewer.getDocument();
        myOffset = offset;
        myMetamodelProvider = new WorkspaceMetamodelRegistryProvider();        
        try {
        	// FIXME - accept other editor inputs
            myIFile = ((FileEditorInput) myEditor.getEditorInput()).getFile();
            myCharSet = myIFile.getCharset();
            myCFile = unit;
            myQvtCompiler = createQvtCompiler();
            myLexer = myQvtCompiler.createLexer(unit);

            myPrsStream = myLexer.getILexStream().getIPrsStream();
            getLeftTokenAndCurrentToken();
        } catch (Exception ex) {
            myException = ex;
            Activator.log(ex);
        }
    }
    
    public String getCharacterSet() {
    	return myCharSet;
    }
    
    public MetamodelRegistry getMetamodelRegistry() {
    	return myMetamodelProvider.getRegistry(MetamodelRegistryProvider.createContext(myCFile.getURI()));
    }

    public ITextViewer getViewer() {
        return myViewer;
    }
    
    public IDocument getDocument() {
        return myDocument;
    }

    public int getOffset() {
        return myOffset;
    }

    public IToken getLeftToken() {
        return myLeftToken;
    }

    public IToken getCurrentToken() {
        return myCurrentToken;
    }

    public AbstractLexer getLexer() {
        return myLexer;
    }

    public IPrsStream getPrsStream() {
        return myPrsStream;
    }

    public Map<String, Object> getUserData() {
        return myUserData;
    }
    
    public UnitProxy getCFile() {
        return myCFile;
    }

    public QvtOperationalEnv getEnvironment() {
        return myQvtCompiler.compileAll();
    }

    public QvtCompletionCompiler getQvtCompiler() {
        return myQvtCompiler;
    }

    public IToken getLeftToken(int leftOffsetIndex) {
        int leftTokenIndex = myLeftToken.getTokenIndex();
        int targetTokenIndex = leftTokenIndex - leftOffsetIndex; 
        if (targetTokenIndex >= 1) {
            return myPrsStream.getTokenAt(targetTokenIndex);
        } 
        return null;
    }
    
    public boolean isValid() {
        return (myEditor != null) && (myViewer != null) 
        && (myOffset >= 0)
        && (myLexer != null) && (myPrsStream != null)
        && (myException == null);
    }

    public void showError(String message) {
        ErrorDialog.openError(myViewer.getTextWidget().getShell(),
                Messages.QvtCompletionData_ErrorPerformingCodeCompletion, null,
                new Status(IStatus.ERROR, Activator.PLUGIN_ID, message)); 
    }

    private void getLeftTokenAndCurrentToken() throws BadLocationException {
        if ((myOffset == 0) || (myPrsStream.getTokens().isEmpty())) {
            return;
        }

        // We might be at the end of some identifier
        char previousChar = myViewer.getDocument().getChar(myOffset - 1);
        if (Character.isJavaIdentifierPart(previousChar)) { 
            int tokenIndex = myPrsStream.getTokenIndexAtCharacter(myOffset - 1);
            // getTokenIndexAtCharacter() may produce wrong results on first tokens
            myLeftToken = (tokenIndex == 1) ? null : myPrsStream.getTokenAt(tokenIndex - 1);
            myCurrentToken = myPrsStream.getTokenAt(tokenIndex);
        } else {
            int tokenIndex = myPrsStream.getTokenIndexAtCharacter(myOffset);
            int leftTokenIndex = (tokenIndex <= 0)  ? -tokenIndex : tokenIndex - 1;
            if (leftTokenIndex != 0) {
                myLeftToken = myPrsStream.getTokenAt(leftTokenIndex);
            }
            if (myPrsStream.getTokens().size() >= leftTokenIndex + 2) {
                IToken next = myPrsStream.getTokenAt(leftTokenIndex + 1);
                myCurrentToken = (next.getStartOffset() < myOffset) ? next : null;
            }
        }
    }
    
    /* Completion performed */
    public MappingModuleCS[] getAllMappingModulesCS() {
        myQvtCompiler.compileAll();
        List<MappingModuleCS> modules = new ArrayList<MappingModuleCS>();
        for (CFileData cFileData : myQvtCompiler.getCFileDataMap().values()) {
            UnitCS unitCS = cFileData.getUnitCS();
            if(unitCS != null) {
            	modules.addAll(unitCS.getModules());
            }
        }
        return modules.toArray(new MappingModuleCS[modules.size()]);
    }
    
    public MappingModuleCS getCurrentMappingModuleCS() {
        myQvtCompiler.compileAll();
        CFileData cFileData = myQvtCompiler.getCFileDataMap().get(myCFile.getURI());
        if (cFileData != null) {
            return cFileData.getMappingModuleCS();
        }
        
        return null;
    }
    
    public MappingMethodCS[] getAllImperativeOperationsCS() {
        MappingModuleCS[] allMappingModulesCS = getAllMappingModulesCS();
        List<MappingMethodCS> methods = new ArrayList<MappingMethodCS>();
        for (MappingModuleCS mappingModuleCS : allMappingModulesCS) {
            methods.addAll(mappingModuleCS.getMethods());
        }
        return methods.toArray(new MappingMethodCS[methods.size()]);
    }
    
    public boolean isWithin(int[] keywordTokenKinds, int[] unexpectedTokenKinds) {
        for (int i = myLeftToken.getTokenIndex(); i >= 0; i--) {
            IToken token = myPrsStream.getTokenAt(i);
            if (QvtCompletionData.isKindOf(token, keywordTokenKinds)) {
                return true;
            }
            for (int unexpectedTokenKind : unexpectedTokenKinds) {
                if (token.getKind() == unexpectedTokenKind) {
                    return false;
                }
            }
        }
        return false;
    }

    public IToken getParentBracingExpression(ITokenQualificator tokenQualif, int leftBraceKind, int rightBraceKind,
            int maxDepth, int[] zeroDepthTerminatorKinds, int[] unexpectedTokenKinds, int[] ignoredClauses) {
        int depth = 0;
        Stack<Integer> maxCurrentDepthStack = new Stack<Integer>();
        maxCurrentDepthStack.push(Integer.MIN_VALUE);
        if (myLeftToken == null) {
            return null;
        }
        for (int i = myLeftToken.getTokenIndex(); i >= 0; i--) {
            IToken token = myPrsStream.getTokenAt(i);
            if (tokenQualif.isSuited(token)) {
                if ((depth >= 1) && (depth > maxCurrentDepthStack.peek())) {
                    return token;
                }
            } else if (token.getKind() == leftBraceKind) {
                depth++;
                if (depth > maxDepth) {
                    return null;
                }
            } else if (token.getKind() == rightBraceKind) {
                if (depth >= maxCurrentDepthStack.peek()) {
                    maxCurrentDepthStack.push(depth);
                }
                depth--;
            } else {
                if ((depth == 0) && QvtCompletionData.isKindOf(token, zeroDepthTerminatorKinds)) {
                    return null;
                }
                if (QvtCompletionData.isKindOf(token, unexpectedTokenKinds)) {
                    return null;
                }
            }
            if (QvtCompletionData.isKindOf(token, ignoredClauses)) {
                IToken nextToken = LightweightParserUtil.getNextToken(token);
                if ((nextToken != null) && QvtCompletionData.isKindOf(nextToken, leftBraceKind)
                        && (depth == maxCurrentDepthStack.peek())) {
                    assert maxCurrentDepthStack.size() > 1;
                    if (maxCurrentDepthStack.size() > 1) {
                        maxCurrentDepthStack.pop();
                    }
                }
            }
        }
        return null;
    }
    
    private QvtCompletionCompiler createQvtCompiler() {
        return new QvtCompletionCompiler(myMetamodelProvider, this);
    }
    
    // utility methods
    public static final boolean isKindOf(IToken token, int... tokenKinds) {
        if (tokenKinds != null) {
            for (int tokenKind : tokenKinds) {
                if (token.getKind() == tokenKind) {
                    return true;
                }
            }
        }
        return false;
    }    
    
    public static final boolean isKindOf(IToken token, String... tokenKinds) {
        if (tokenKinds != null) {
            for (String tokenText : tokenKinds) {
                if (tokenText.equals(token.toString())) {
                    return true;
                }
            }
        }
        return false;
    }    
    
    public static final IToken[] extractTokens(IToken startToken, int... endTokenKinds) {
        List<IToken> tokens = new ArrayList<IToken>();
        IToken currentToken = startToken;
        IPrsStream prsStream = startToken.getIPrsStream();
        while (true) {
            if (QvtCompletionData.isKindOf(currentToken, endTokenKinds)) {
                return tokens.toArray(new IToken[tokens.size()]);
            }
            tokens.add(currentToken);
            int currentTokenIndex = currentToken.getTokenIndex();
            int nextTokenIndex = currentTokenIndex + 1;
            if (nextTokenIndex < prsStream.getSize()) {
                currentToken = prsStream.getTokenAt(nextTokenIndex);
            } else {
                return null;
            }
        }
    }
    
    public IToken getParentImperativeOperation() {
        if (myParentImperativeOperation == null) {
            myParentImperativeOperation = getParentBracingExpression(new ITokenQualificator() {
		            	public boolean isSuited(IToken token) {
		            		return QvtCompletionData.isKindOf(token, LightweightParserUtil.IMPERATIVE_OPERATION_TOKENS);        		
		            	}
		            },
                    QVTOParsersym.TK_LBRACE, QVTOParsersym.TK_RBRACE, Integer.MAX_VALUE, null, null, LightweightParserUtil.MAPPING_CLAUSE_TOKENS);
            if (myParentImperativeOperation != null) {
                if (QvtCompletionData.isKindOf(myParentImperativeOperation, QVTOParsersym.TK_main)) {
                    IToken previousToken = LightweightParserUtil.getPreviousToken(myParentImperativeOperation);
                    if ((previousToken != null)
                            && QvtCompletionData.isKindOf(previousToken, 
                                    QVTOParsersym.TK_mapping, QVTOParsersym.TK_query)) {
                        // The "mapping main" or "query main" cases - backward compatibility
                        myParentImperativeOperation = previousToken;
                    }
                }
            }
        }
        return myParentImperativeOperation;
    }

    public void setParentImperativeOperation(IToken parentImperativeOperation) {
        myParentImperativeOperation = parentImperativeOperation;
    }
}