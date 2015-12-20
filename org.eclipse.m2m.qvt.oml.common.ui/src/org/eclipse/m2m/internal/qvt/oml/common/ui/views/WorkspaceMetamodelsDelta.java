/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.views;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;

/**
 * This class groups the information about metamodel files related changes in the workspace
 */
class WorkspaceMetamodelsDelta {
	private Map<IPath, IPath> movesMap = new HashMap<IPath, IPath>();
	private List<IPath> deletions = new ArrayList<IPath>();
	private List<IPath> additions = new ArrayList<IPath>();
	private List<IPath> modifications = new ArrayList<IPath>();

	WorkspaceMetamodelsDelta() {		
	}
	
	public boolean isEmpty() {
		return getAdditions().isEmpty() && getDeletions().isEmpty() && getModifications().isEmpty() && getMoves().isEmpty();
	}

	public List<IPath> getAdditions() {
		return additions != null ? Collections.unmodifiableList(additions) : Collections.<IPath>emptyList();
	}
	
	public void addAddition(IPath path) {
		if(additions == null) {
			additions = new ArrayList<IPath>();
		}
		additions.add(path);
	}
	
	public List<IPath> getDeletions() {
		return deletions != null ? Collections.unmodifiableList(deletions) : Collections.<IPath>emptyList();
	}
	
	public void addDeletion(IPath path) {
		if(deletions == null) {
			deletions = new ArrayList<IPath>();
		}
		deletions.add(path);
	}	
	
	public List<IPath> getModifications() {
		return modifications != null ? Collections.unmodifiableList(modifications) : Collections.<IPath>emptyList();
	}

	public void addModification(IPath path) {
		if(modifications == null) {
			modifications = new ArrayList<IPath>();
		}
		modifications.add(path);
	}	
		
	/**
	 * @return map having movedFrom paths as the key and movedTo paths as the value
	 */
	public Map<IPath, IPath> getMoves() {
		return movesMap != null ? Collections.unmodifiableMap(movesMap) : Collections.<IPath, IPath>emptyMap();
	}
	
	public void addMove(IPath source, IPath dest) {
		if(movesMap == null) {
			movesMap = new HashMap<IPath, IPath>();
		}
		movesMap.put(source, dest);
	}
}
