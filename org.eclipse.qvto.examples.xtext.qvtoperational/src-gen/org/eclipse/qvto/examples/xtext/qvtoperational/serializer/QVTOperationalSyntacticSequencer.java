/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.qvtoperational.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvto.examples.xtext.qvtoperational.services.QVTOperationalGrammarAccess;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class QVTOperationalSyntacticSequencer extends AbstractSyntacticSequencer {

	protected QVTOperationalGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ClassCS_SemicolonKeyword_1_q;
	protected AbstractElementAlias match_ClassifierPropertyCS_TildeKeyword_6_1_q;
	protected AbstractElementAlias match_EnumerationCS_SemicolonKeyword_3_q;
	protected AbstractElementAlias match_LibraryDefCS_SemicolonKeyword_4_q;
	protected AbstractElementAlias match_MetamodelCS_SemicolonKeyword_5_q;
	protected AbstractElementAlias match_ModelTypeCS___WhereKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_2__q;
	protected AbstractElementAlias match_TransformationDefCS_SemicolonKeyword_4_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (QVTOperationalGrammarAccess) access;
		match_ClassCS_SemicolonKeyword_1_q = new TokenAlias(false, true, grammarAccess.getClassCSAccess().getSemicolonKeyword_1());
		match_ClassifierPropertyCS_TildeKeyword_6_1_q = new TokenAlias(false, true, grammarAccess.getClassifierPropertyCSAccess().getTildeKeyword_6_1());
		match_EnumerationCS_SemicolonKeyword_3_q = new TokenAlias(false, true, grammarAccess.getEnumerationCSAccess().getSemicolonKeyword_3());
		match_LibraryDefCS_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getLibraryDefCSAccess().getSemicolonKeyword_4());
		match_MetamodelCS_SemicolonKeyword_5_q = new TokenAlias(false, true, grammarAccess.getMetamodelCSAccess().getSemicolonKeyword_5());
		match_ModelTypeCS___WhereKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getModelTypeCSAccess().getWhereKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getModelTypeCSAccess().getLeftCurlyBracketKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getModelTypeCSAccess().getRightCurlyBracketKeyword_6_2()));
		match_TransformationDefCS_SemicolonKeyword_4_q = new TokenAlias(false, true, grammarAccess.getTransformationDefCSAccess().getSemicolonKeyword_4());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ClassCS_SemicolonKeyword_1_q.equals(syntax))
				emit_ClassCS_SemicolonKeyword_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ClassifierPropertyCS_TildeKeyword_6_1_q.equals(syntax))
				emit_ClassifierPropertyCS_TildeKeyword_6_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_EnumerationCS_SemicolonKeyword_3_q.equals(syntax))
				emit_EnumerationCS_SemicolonKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_LibraryDefCS_SemicolonKeyword_4_q.equals(syntax))
				emit_LibraryDefCS_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_MetamodelCS_SemicolonKeyword_5_q.equals(syntax))
				emit_MetamodelCS_SemicolonKeyword_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ModelTypeCS___WhereKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_2__q.equals(syntax))
				emit_ModelTypeCS___WhereKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TransformationDefCS_SemicolonKeyword_4_q.equals(syntax))
				emit_TransformationDefCS_SemicolonKeyword_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=UnrestrictedName (ambiguity) (rule end)
	 *     ownedAnnotations+=TagCS ';' '}' (ambiguity) (rule end)
	 *     ownedOperations+=ClassifierOperationCS ';' '}' (ambiguity) (rule end)
	 *     ownedProperties+=ClassifierPropertyCS ';' '}' (ambiguity) (rule end)
	 *     ownedSuperTypes+=TypedRefCS (ambiguity) (rule end)
	 */
	protected void emit_ClassCS_SemicolonKeyword_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     '~'?
	 *
	 * This ambiguous syntax occurs at:
	 *     default=SINGLE_QUOTED_STRING 'opposites' (ambiguity) opposite=Identifier
	 *     ownedType=TypedMultiplicityRef2CS 'opposites' (ambiguity) opposite=Identifier
	 */
	protected void emit_ClassifierPropertyCS_TildeKeyword_6_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     ownedLiterals+=EnumerationLiteralCS '}' (ambiguity) (rule end)
	 */
	protected void emit_EnumerationCS_SemicolonKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     moduleUsages+=ModuleUsageCS '{' '}' (ambiguity) (rule end)
	 *     ownedOperations+=ModuleOperationCS '}' (ambiguity) (rule end)
	 *     ownedProperties+=ModulePropertyCS '}' (ambiguity) (rule end)
	 *     parameters+=ModelTypeRefCS ')' '{' '}' (ambiguity) (rule end)
	 */
	protected void emit_LibraryDefCS_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=UnrestrictedName '{' '}' (ambiguity) (rule end)
	 *     ownedAnnotations+=TagCS '}' (ambiguity) (rule end)
	 *     ownedClasses+=ClassCS '}' (ambiguity) (rule end)
	 *     ownedClasses+=EnumerationCS '}' (ambiguity) (rule end)
	 */
	protected void emit_MetamodelCS_SemicolonKeyword_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('where' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     packageRefs+=PackageRefCS (ambiguity) ';' (rule end)
	 */
	protected void emit_ModelTypeCS___WhereKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ';'?
	 *
	 * This ambiguous syntax occurs at:
	 *     moduleUsages+=ModuleUsageCS '{' '}' (ambiguity) (rule end)
	 *     ownedOperations+=ModuleOperationCS '}' (ambiguity) (rule end)
	 *     ownedProperties+=ModulePropertyCS '}' (ambiguity) (rule end)
	 *     parameters+=ParameterDeclarationCS ')' '{' '}' (ambiguity) (rule end)
	 *     refines=ModuleRefCS '{' '}' (ambiguity) (rule end)
	 */
	protected void emit_TransformationDefCS_SemicolonKeyword_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Ambiguous syntax:
	 *     ('(' ')')?
	 *
	 * This ambiguous syntax occurs at:
	 *     name='Tuple' (ambiguity) (rule end)
	 *     name='Tuple' (ambiguity) ownedMultiplicity=MultiplicityCS
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
