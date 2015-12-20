/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.outline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LocalPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModelTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TagCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.PathNameCS;

public class QvtOutlineInput {

	public QvtOutlineInput() {
		this(null);
	}

	public QvtOutlineInput(CompiledUnit unit) {
		myUnit = unit;
	}
	
	public void compilationUnitUpdated(CompiledUnit unit) {
		myUnit = unit;	
		myChildren = null;
	}

	public Object[] getChildren() {
		if (myChildren == null) {
			List<Object> children = new ArrayList<Object>();
			
			if(getUnitCST() != null) {
				children.addAll(Arrays.asList(
						new ImportsNode(), 
						new MetamodelsNode(), 
						new TagsNode()));
				
				for (MappingModuleCS nextModule : getUnitCST().getModules()) {
					children.add(new ModuleNode(nextModule, getModuleNodeIdentity(nextModule)));
				}
			}			
			
			myChildren = children.toArray();
		}
		
		return myChildren;
	}

	private static String getModuleNodeIdentity(MappingModuleCS moduleCS) {
		return moduleCS != null ? QvtOutlineLabelProvider.getMappingModuleLabel(moduleCS) : ""; //$NON-NLS-1$
	}
	
	private UnitCS getUnitCST() {
		return myUnit != null ? myUnit.getUnitCST() : null;
	}	
	
	private abstract class ModuleDependentNode extends OutlineNode {
		
		protected ModuleDependentNode(String identity, Object parent, int type) {
			super(identity, parent, type);			
		}
		
		protected ModuleDependentNode(String identity, Object parent, int type, CSTNode syntaxElement) {
			super(identity, parent, type, syntaxElement);
		}
		
		@Override
		public final List<OutlineNode> getChildren() {
			if (getUnitCST() == null) {
				return Collections.emptyList();
			}
			return doGetChildren();
		}
		
		protected abstract List<OutlineNode> doGetChildren();
		
	}

	private final class ModuleNode extends ModuleDependentNode {
		
		private MappingModuleCS moduleCS;
		
		public ModuleNode(MappingModuleCS moduleCS, String identity) {
			super(identity, QvtOutlineInput.this, QvtOutlineNodeType.MAPPING_MODULE);
			
			this.moduleCS = moduleCS;
		}

		@Override
		public CSTNode getSyntaxElement() {
			return moduleCS.getHeaderCS();
		}
		
		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			if(myUnit == null) {
				return result;
			}

			for (ClassifierDefCS classifierDefCS : moduleCS.getClassifierDefCS()) {
				OwnedClassNode childNode = new OwnedClassNode(classifierDefCS);
				result.add(childNode);				
			}
			
			for (ModulePropertyCS prop : moduleCS.getProperties()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getPropertyLabel(prop), this,
						QvtOutlineNodeType.PROPERTY, prop);
				result.add(childNode);
			}
			
			
			for (MappingMethodCS method : moduleCS.getMethods()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getMappingRuleLabel(method), this,
						QvtOutlineNodeType.MAPPING_RULE, method);
				result.add(childNode);
			}

			return result;
		}

	}

	private final class ImportsNode extends ModuleDependentNode {

		public ImportsNode() {
			super(QvtOutlineLabelProvider.IMPORTS_NODE, QvtOutlineInput.this, QvtOutlineNodeType.IMPORTED_MODULES);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();			
			if(getUnitCST() == null) {
				return result;
			}
						
			for (ImportCS nextImportCS : QvtOperationalParserUtil.getImports(getUnitCST())) {
		    	PathNameCS importQName = nextImportCS.getPathNameCS();
				if (importQName == null) {
		    		continue;
		    	}
		    	
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getImportLabel(importQName),
						this, QvtOutlineNodeType.UNIT, importQName);

				result.add(childNode);
			}

			return result;
		}

	}
	

	private final class MetamodelsNode extends ModuleDependentNode {

		public MetamodelsNode() {
			super(QvtOutlineLabelProvider.METAMODELS_NODE, QvtOutlineInput.this, QvtOutlineNodeType.IMPORTED_METAMODELS);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			if(myUnit.getUnitCST() == null) {
				return result;
			}
			
			for (ModelTypeCS modelTypeCS : QvtOperationalParserUtil.getModelTypes(getUnitCST())) {
		    	if (modelTypeCS == null || modelTypeCS.getPackageRefs().isEmpty()) {
		    		continue;
		    	}
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getMetamodelLabel(modelTypeCS), this,
						QvtOutlineNodeType.METAMODEL, modelTypeCS);
				result.add(childNode);
			}

			return result;
		}

	}
	
	private final class OwnedClassNode extends ModuleDependentNode {
		
		private ClassifierDefCS fClassifier;
		
		public OwnedClassNode(ClassifierDefCS classifierCS) {
			super(QvtOutlineLabelProvider.getClassifierLabel(classifierCS), 
					QvtOutlineInput.this, QvtOutlineNodeType.TYPE, classifierCS);
			fClassifier = classifierCS;
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			if(myUnit.getUnitCST() == null) {
				return result;
			}
			
			for (LocalPropertyCS prop : fClassifier.getProperties()) {
				OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getPropertyLabel(prop), 
						this, QvtOutlineNodeType.PROPERTY, prop);
				result.add(childNode);
			}
			
			return result;
		}

	}
	

	private final class TagsNode extends ModuleDependentNode {

		public TagsNode() {
			super(QvtOutlineLabelProvider.TAGS_NODE, QvtOutlineInput.this, QvtOutlineNodeType.TAGS);
		}

		@Override
		protected List<OutlineNode> doGetChildren() {
			List<OutlineNode> result = new ArrayList<OutlineNode>();
			if(getUnitCST() == null) {
				return result;
			}

			for(MappingModuleCS moduleCS : getUnitCST().getModules()) {
				for (TagCS next : moduleCS.getTags()) {
					OutlineNode childNode = new OutlineNode(QvtOutlineLabelProvider.getTagLabel(next), this,
							QvtOutlineNodeType.TAG, next);
					result.add(childNode);
				}
			}

			return result;
		}

	}

	private CompiledUnit myUnit;
	
	private Object[] myChildren;
	
}
