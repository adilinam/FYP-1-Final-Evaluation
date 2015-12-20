package org.eclipse.qvto.examples.xtext.qvtoperational.ui.outline;

import org.eclipse.ocl.xtext.basecs.PivotableElementCS;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;

//TODO This should be auto generated in the src-gen folder
public class CS2ASOutlineTreeProvider extends DefaultOutlineTreeProvider {
		
	protected void _createNode(IOutlineNode parentNode, PivotableElementCS csElement) {
		super._createNode(parentNode, csElement.getPivot());
	}

}
