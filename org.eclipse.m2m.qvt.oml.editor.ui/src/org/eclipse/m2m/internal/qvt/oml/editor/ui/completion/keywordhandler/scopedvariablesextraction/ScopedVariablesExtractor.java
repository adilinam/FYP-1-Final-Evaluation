/*******************************************************************************
 * Copyright (c) 2008, 2013 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.keywordhandler.scopedvariablesextraction;

import lpg.runtime.IToken;

import org.eclipse.m2m.internal.qvt.oml.cst.parser.QVTOParsersym;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.LightweightParserUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;

/**
 * @author aigdalov
 * Created on Nov 21, 2007
 */
public class ScopedVariablesExtractor {
    private static final int NOT_A_TOKEN = -1;
    
    // starting from ')'
    public String extractVariables(IToken startToken, QvtCompletionData data) {
        Scope scope = new Scope(null);
        IToken currentToken = startToken;
        if (QvtCompletionData.isKindOf(data.getParentImperativeOperation(), QVTOParsersym.TK_mapping)) {
            while ((currentToken = getNextToken(currentToken, data)) != null) {
                if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_LBRACE)) {
                    break;
                }
            }
        }
        if (currentToken != null) {
            while ((currentToken = getNextToken(currentToken, data)) != null) {
                Result innerScopeResult = null;
                if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_init, QVTOParsersym.TK_end, QVTOParsersym.TK_population)) {
                    currentToken = LightweightParserUtil.getNextToken(currentToken);
                    if (currentToken == null) {
                        break;
                    }
                    if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_LBRACE)) {
                        innerScopeResult = analyseScopedVarVariables(currentToken, data, scope, true);
                    }
                } else if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_var)) {
                	innerScopeResult = analyseScopedVarVariables(LightweightParserUtil.getPreviousToken(currentToken), data, scope, true);
                } else {
                    innerScopeResult = analyseVariableDeclaringExpressions(currentToken, data, scope);
                }
                if (innerScopeResult != null) {
                    scope = innerScopeResult.getScope();
                    currentToken = innerScopeResult.getEndToken();
                }
            }
        }
        return scope.toString();
    }
    
    // starting from '{' or from any token within the '{' scope 
    private Result analyseScopedVarVariables(IToken startToken, QvtCompletionData data, Scope scope, boolean isMandatoryScope) {
        IToken currentToken = startToken;
        Scope varScope = new Scope(scope);
        IToken nextToken;
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RBRACE)) {
                if (isMandatoryScope) {
                    return new Result(startToken, nextToken, null, varScope);
                }
                return new Result(startToken, nextToken, null, scope);
            }
            if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_var)) {
                nextToken = getNextToken(nextToken, data);
                if (nextToken == null) {
                    break;
                }
                Result extractVarVariableResult = extractVariable(nextToken, null, data, varScope, 
                        new int[] {QVTOParsersym.TK_RESET_ASSIGN}, NOT_A_TOKEN, QVTOParsersym.TK_SEMICOLON, QVTOParsersym.TK_RBRACE);
                if (extractVarVariableResult.getScope() != varScope) {
                    return extractVarVariableResult;
                }
                nextToken = extractVarVariableResult.getEndToken();
                varScope.addVariable(extractVarVariableResult.getString());
            } else {
                Result innerScopeResult = analyseVariableDeclaringExpressions(nextToken, data, varScope);
                if (innerScopeResult != null) {
                    if (innerScopeResult.getScope() != varScope) {
                        return innerScopeResult;
                    }
                    nextToken = innerScopeResult.getEndToken();
                }
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, varScope);
    }
    
    private Result analyseVariableDeclaringExpressions(IToken currentToken, QvtCompletionData data, Scope scope) {
        if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_let)) {
            return analyseLetExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.QVTO_ITERATOR_TERMINALS)
        		|| QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.OCL_ITERATOR_TERMINALS)
                || QvtCompletionData.isKindOf(currentToken, "iterate")) { //$NON-NLS-1$
            return analyseIteratorExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.RESOLVE_FAMILY_TERMINALS)) {
            return analyseResolveExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_while)) {
            return analyseWhileExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_switch)) {
            return analyseSwitchExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, LightweightParserUtil.FOR_EXP_TERMINALS)) {
            return analyseForExpression(currentToken, data, scope);
        } else if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_LBRACE)) {
            return analyseScopedVarVariables(currentToken, data, scope, false);
        } else if (QvtCompletionData.isKindOf(currentToken, QVTOParsersym.TK_compute)) {
            return analyseComputeExpression(currentToken, data, scope);
        }
        return null;
    }
    
    // starting 1 token before ')'
    private Result analyseWhileLikeBody(IToken startToken, IToken preParenToken, IToken lastKnownGoodToken,
            QvtCompletionData data, Scope whileLikeScope) {
        IToken nextToken = getNextToken(preParenToken, data); // ')' expected
        if (nextToken != null) {
            lastKnownGoodToken = nextToken;
            if (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN)) {
                return new Result(startToken, nextToken, null, whileLikeScope.getParent());
            }
            
            nextToken = getNextToken(nextToken, data); // '{' expected
            
            if (nextToken != null) {
                lastKnownGoodToken = nextToken;
                if (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LBRACE)) {
                    return new Result(startToken, nextToken, null, whileLikeScope.getParent());
                }
                
                Result forBodyExpResult = analyseScopedVarVariables(nextToken, data, whileLikeScope, false);
                if (forBodyExpResult.getScope() != whileLikeScope) {
                    return forBodyExpResult;
                }
                return new Result(startToken, forBodyExpResult.getEndToken(), null, whileLikeScope.getParent());
            }
        }
        
        return new Result(startToken, lastKnownGoodToken, null, whileLikeScope);        
    }

    // starting from 'compute'
    private Result analyseComputeExpression(IToken startToken, QvtCompletionData data, Scope scope) {        
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        IToken currentToken = nextToken;
        nextToken = getNextToken(nextToken, data);
        if (nextToken == null) {
            return new Result(startToken, currentToken, null, new Scope(null));
        }

        Scope computeExpScope = new Scope(scope);
        Result extractVarVariableResult = extractVariable(nextToken, null, data, computeExpScope, 
                new int[] {QVTOParsersym.TK_RESET_ASSIGN, QVTOParsersym.TK_EQUAL}, NOT_A_TOKEN, QVTOParsersym.TK_RBRACE);
        if (extractVarVariableResult.getScope() != computeExpScope) {
            return extractVarVariableResult;
        }
        
        computeExpScope.addVariable(extractVarVariableResult.getString());
        nextToken = extractVarVariableResult.getEndToken();
        
        return analyseWhileLikeBody(startToken, nextToken, nextToken, data, computeExpScope);
    }

    // starting from 'forEach' or 'forOne'
    private Result analyseForExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        Scope forExpScope = new Scope(scope);
        Result addVariableListResult = addVariableList(nextToken, startToken, data, forExpScope, 
                new int[] {QVTOParsersym.TK_BAR, QVTOParsersym.TK_RPAREN},
                NOT_A_TOKEN, QVTOParsersym.TK_COMMA, QVTOParsersym.TK_BAR, QVTOParsersym.TK_RPAREN);
        if (addVariableListResult.getScope() != forExpScope) {
            return addVariableListResult;
        }
        
        nextToken = addVariableListResult.getEndToken(); // Either '|' or ')' expected - optional condition
        
        // extracting condition if available 
        if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_BAR)) {
            IToken currentToken = nextToken;
            nextToken = getNextToken(nextToken, data);
            if (nextToken == null) {
                return new Result(startToken, currentToken, null, forExpScope);
            }
            Result oclExpressionResult = extractOclExpression(nextToken, data, forExpScope);
            if (oclExpressionResult.getScope() != forExpScope) {
                return oclExpressionResult;
            }
            nextToken = oclExpressionResult.getEndToken();
        } else { // see analyseWhileLikeBody contract 
            nextToken = LightweightParserUtil.getPreviousToken(nextToken);
        }
        
        return analyseWhileLikeBody(startToken, nextToken, nextToken, data, forExpScope);
    }

    // starting from 'while'
    private Result analyseWhileExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        Scope whileScope = new Scope(scope);
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        nextToken = getNextToken(nextToken, data);
        if (nextToken == null) {
            return null;
        }

        if (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_IDENTIFIER)) {
            return null;
        }
        Result variableResult = extractVariable(nextToken, null,
                data, whileScope, new int[] {QVTOParsersym.TK_EQUAL, QVTOParsersym.TK_RESET_ASSIGN}, NOT_A_TOKEN, QVTOParsersym.TK_SEMICOLON);
        if (variableResult == null) {
            return null;
        }
        if (variableResult.getScope() != whileScope) {
            return variableResult;
        } else {
            whileScope.addVariable(variableResult.getString());
            nextToken = variableResult.getEndToken();
        }
        
        nextToken = getNextToken(nextToken, data);
        
        assert QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_SEMICOLON);
        
        IToken lastKnownGoodToken = nextToken;
        
        nextToken = getNextToken(nextToken, data); // whileExp condition start
        if (nextToken != null) {
            Result whileConditionExpResult = extractOclExpression(nextToken, data, whileScope);
            if (whileConditionExpResult.getScope() != whileScope) {
                return whileConditionExpResult;
            }
            
            nextToken = whileConditionExpResult.getEndToken();
            lastKnownGoodToken = nextToken;
            
            return analyseWhileLikeBody(startToken, nextToken, lastKnownGoodToken, data, whileScope);
        }
        
        return new Result(startToken, lastKnownGoodToken, null, whileScope);
    }

    // starting from 'switch'
    private Result analyseSwitchExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        Scope switchScope = new Scope(scope);
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        nextToken = getNextToken(nextToken, data);
        if (nextToken == null) {
            return null;
        }

        if (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_IDENTIFIER)) {
            return null;
        }
        Result variableResult = extractVariable(nextToken, startToken,
                data, switchScope, new int[] {QVTOParsersym.TK_EQUAL, QVTOParsersym.TK_RESET_ASSIGN}, NOT_A_TOKEN, QVTOParsersym.TK_RPAREN);
        if (variableResult == null) {
            return null;
        }
        if (variableResult.getScope() != switchScope) {
            return variableResult;
        } else {
            switchScope.addVariable(variableResult.getString());
            nextToken = variableResult.getEndToken();
        }
        
        nextToken = getNextToken(nextToken, data);
        
        assert QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN);
        
        IToken lastKnownGoodToken = nextToken;
        
        nextToken = getNextToken(nextToken, data); // '{' expected
        if (nextToken != null) {
            lastKnownGoodToken = nextToken;
            if (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LBRACE)) {
                return new Result(startToken, nextToken, null, scope);
            }

            Result switchBodyExpResult = analyseScopedVarVariables(nextToken, data, switchScope, false);
            if (switchBodyExpResult.getScope() != switchScope) {
                return switchBodyExpResult;
            }
            return new Result(startToken, switchBodyExpResult.getEndToken(), null, scope);
        }

        return new Result(startToken, lastKnownGoodToken, null, switchScope);
    }
    
    // starting from 'let'
    private Result analyseLetExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        return analyseLetLikeExpression(startToken, null, data, scope, new int[] {QVTOParsersym.TK_in}, NOT_A_TOKEN,
                QVTOParsersym.TK_COMMA, QVTOParsersym.TK_in);
    }
    
    // starting from 'iteratorExpCSToken' or 'iterate'
    private Result analyseIteratorExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        Result letLikeExpressionResult = analyseLetLikeExpression(nextToken, startToken, data, scope,
        		new int[] {QVTOParsersym.TK_BAR, QVTOParsersym.TK_RPAREN}, NOT_A_TOKEN, QVTOParsersym.TK_COMMA,
                QVTOParsersym.TK_SEMICOLON, QVTOParsersym.TK_BAR);
        if (letLikeExpressionResult.getScope() != scope) {
            return letLikeExpressionResult;
        }
        nextToken = getNextToken(letLikeExpressionResult.getEndToken(), data);
        if (nextToken == null) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN)) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, scope);
        }        
        return new Result(startToken, nextToken, null, scope);
    }

    // starting from 'resolveOp' or 'resolveInOp'
    private Result analyseResolveExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken nextToken = getNextToken(startToken, data);
        if (nextToken == null) {
            return new Result(startToken, startToken, null, new Scope(null));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            return null;
        }
        if (QvtCompletionData.isKindOf(startToken, LightweightParserUtil.RESOLVEIN_FAMILY_TERMINALS)) {
            while ((nextToken = getNextToken(nextToken, data)) != null) {
                if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_COMMA)) {
                    break;
                }
                if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN)) {
                    return new Result(startToken, nextToken, null, scope);
                }
            }
        }
        if (nextToken == null) {
            return null;
        }
        Result letLikeExpressionResult = analyseLetLikeExpression(nextToken, null, data, scope,
        		new int[] {QVTOParsersym.TK_BAR}, QVTOParsersym.TK_RPAREN, QVTOParsersym.TK_BAR);
        if (letLikeExpressionResult.getScope() != scope) {
            return letLikeExpressionResult;
        }
        nextToken = getNextToken(letLikeExpressionResult.getEndToken(), data);
        if (nextToken == null) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, new Scope(scope));
        }
        if  (!QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN)) {
            return new Result(startToken, letLikeExpressionResult.getEndToken(), null, scope);
        }        
        return new Result(startToken, nextToken, null, scope);
    }
    
    private Result addVariableList(IToken startToken, IToken iteratorExpressionStart, 
            QvtCompletionData data, Scope updatedScope, int[] varDeclTerminators, int unexpectedTerminator, int... delimiters) {
        IToken nextToken = startToken;
        IToken lastKnownGoodToken = startToken;
        do {
            nextToken = getNextToken(nextToken, data);
            if (nextToken != null) {
                Result variableResult = extractVariable(nextToken, iteratorExpressionStart,
                        data, updatedScope, new int[] {QVTOParsersym.TK_EQUAL}, unexpectedTerminator, delimiters);
                if (variableResult == null) {
                	IToken followToken = getNextToken(nextToken, data);
                    return new Result(startToken, followToken != null ? followToken : nextToken, null, updatedScope.getParent());
                }
                if (variableResult.getScope() != updatedScope) {
                    return variableResult;
                } else {
                    updatedScope.addVariable(variableResult.getString());
                    nextToken = variableResult.getEndToken();
                    lastKnownGoodToken = nextToken;
                }
                nextToken = getNextToken(nextToken, data);
            }
        } while ((nextToken != null) && !QvtCompletionData.isKindOf(nextToken, varDeclTerminators) && QvtCompletionData.isKindOf(nextToken, delimiters));
        if (nextToken == null) {
            return new Result(startToken, nextToken, null, new Scope(updatedScope), lastKnownGoodToken);
        }
        return new Result(startToken, nextToken, null, updatedScope, lastKnownGoodToken);
    }

    // starting from 'let'-like token
    private Result analyseLetLikeExpression(IToken startToken, IToken iteratorExpressionStart, 
            QvtCompletionData data, Scope scope, int[] varDeclTerminators, int unexpectedTerminator, int... delimiters) {
        Scope letLikeScope = new Scope(scope);
        Result addVariableListResult = addVariableList(startToken, iteratorExpressionStart, data, letLikeScope, varDeclTerminators, unexpectedTerminator, delimiters);
        if (addVariableListResult.getScope() != letLikeScope) {
            return addVariableListResult;
        }
        IToken nextToken = addVariableListResult.getEndToken();
        if ((nextToken != null) && QvtCompletionData.isKindOf(nextToken, varDeclTerminators)) {
            nextToken = getNextToken(nextToken, data);
            if (nextToken != null) {
                Result oclExpressionResult = extractOclExpression(nextToken, data, letLikeScope);
                if (oclExpressionResult.getScope() != letLikeScope) {
                    return oclExpressionResult;
                }
                return new Result(startToken, oclExpressionResult.getEndToken(), null, scope);
            }
        }
        return new Result(startToken, addVariableListResult.getLastKnownGoodToken(), null, letLikeScope);
    }
    
    // starting from 'IDENTIFIER'
    private Result extractVariable(IToken startToken, IToken iteratorExpressionStart, QvtCompletionData data,
            Scope scope, int[] initializers, int  unexpectedTerminator, int... delimiters) {
    	int parenCount = 0;
        boolean isTypeDefined = false;
        IToken currentToken = startToken;
        IToken nextToken;
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            if (QvtCompletionData.isKindOf(nextToken, unexpectedTerminator)) {
                return null;
            }
            if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_COLON)) {
                isTypeDefined = true;
            }
            if (QvtCompletionData.isKindOf(nextToken, delimiters)) {
                if (isTypeDefined) {
                    return new Result(startToken, currentToken,
                            "var " + LightweightParserUtil.getText(startToken, currentToken) + ';', scope); //$NON-NLS-1$
                }
                // Implicit types may be in iterator-variables of iterating expressions
                String deducedType = deduceImplicitCollectionElementType(iteratorExpressionStart, data);
                if (deducedType == null) {
                    return new Result(startToken, currentToken, "", scope); //$NON-NLS-1$ 
                }
                String varText = "var " + LightweightParserUtil.getText(startToken, currentToken) //$NON-NLS-1$
                    + " := " + deducedType + ';'; //$NON-NLS-1$
                return new Result(startToken, currentToken, varText, scope); 
            }
            if (QvtCompletionData.isKindOf(currentToken, initializers)) {
                isTypeDefined = true;
                Result oclExpressionResult = extractOclExpression(nextToken, data, scope);
                if (oclExpressionResult.getScope() != scope) {
                    return oclExpressionResult;
                }
                IToken previousToken = LightweightParserUtil.getPreviousToken(currentToken);
                String identifierAndOrType = ((previousToken != null) && (startToken.getTokenIndex() <= previousToken.getTokenIndex())) 
                        ? LightweightParserUtil.getText(startToken, previousToken) : ""; //$NON-NLS-1$
                return new Result(startToken, oclExpressionResult.getEndToken(),
                        "var " + identifierAndOrType //$NON-NLS-1$ 
                        + " := " + oclExpressionResult.getString() + ';', scope); //$NON-NLS-1$
            }
            if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_LPAREN)) {
            	parenCount++;
            }
            if (QvtCompletionData.isKindOf(nextToken, QVTOParsersym.TK_RPAREN)) {
            	parenCount--;
            	if (parenCount < 0) {
            		return new Result(startToken, startToken, "", scope);  //$NON-NLS-1$
            	}
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, new Scope(scope));
    }

    private String deduceImplicitCollectionElementType(IToken iteratorExpressionStart, QvtCompletionData data) {
        if (iteratorExpressionStart == null) {
            return null;
        }
        IToken accessorToken = LightweightParserUtil.getPreviousToken(iteratorExpressionStart);
        if ((accessorToken != null) && QvtCompletionData.isKindOf(accessorToken, 
                QVTOParsersym.TK_DOT, QVTOParsersym.TK_ARROW)) {
            IToken[] oclExpressionCSTokens = LightweightParserUtil.extractOclExpressionCSTokens(accessorToken, data);
            if (oclExpressionCSTokens != null) {
                String collectionType = LightweightParserUtil.getText(oclExpressionCSTokens);
                return collectionType + "->any(true)"; //$NON-NLS-1$
            }
        }
        return null;
    }

    // starting from the first token of the OCL expression
    private Result extractOclExpression(IToken startToken, QvtCompletionData data, Scope scope) {
        IToken currentToken = startToken;
        int bracingMode = -1;
        int depth = 0;
        IToken nextToken; 
        while ((nextToken = getNextToken(currentToken, data)) != null) {
            Result innerScopeResult = analyseVariableDeclaringExpressions(currentToken, data, scope);
            if (innerScopeResult != null) {
                if (innerScopeResult.getScope() != scope) {
                    return innerScopeResult;
                }
                currentToken = innerScopeResult.getEndToken();
                nextToken = getNextToken(currentToken, data);
                if (nextToken == null) {
                    return new Result(startToken, currentToken, null, new Scope(scope));
                }
            } else {
                int bracingPairKind = LightweightParserUtil.getBracingPairKind(currentToken, true);
                if (depth == 0) {
                    if (bracingPairKind >= 0) {
                        bracingMode = bracingPairKind;
                        depth++;
                    }
                } else {
                    if (bracingPairKind == bracingMode) {
                        depth++;
                    } else {
                        if (bracingMode == LightweightParserUtil.getBracingPairKind(currentToken, false)) {
                            depth--;
                        }
                    }
                }
            }
            if ((depth == 0) && QvtCompletionData.isKindOf(nextToken, LightweightParserUtil.OCLEXPRESSION_END_TOKENS)) {
                return new Result(startToken, currentToken, LightweightParserUtil.getText(startToken, currentToken), scope);
            }
            currentToken = nextToken;
        }
        return new Result(startToken, currentToken, null, new Scope(scope));
    }

    private static IToken getNextToken(IToken token, QvtCompletionData data) {
        if (token == null) {
            // we mustn't be here; however, in case we are - that
            // won't be a problem
            return null;
        }
        if (token == data.getLeftToken()) {
            return null;
        }
        IToken nextToken = LightweightParserUtil.getNextToken(token);
        if (nextToken == null) {
            return null;
        }
        return nextToken;
    }
}