/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer;

import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.ocl.cst.CSTNode;

final class SemanticToken {

	private CSTNode fNode;

	private UnitCS fAst;
	
	SemanticToken() {
		super();
	}
	
	public CSTNode getNode() {
		return fNode;
	}

	public UnitCS getRoot() {
		return fAst;
	}

	void update(CSTNode node, UnitCS ast) {
		fNode = node;
		fAst = ast;
	}

	public void clear() {
		fNode = null;
		fAst = null;
	}
}
