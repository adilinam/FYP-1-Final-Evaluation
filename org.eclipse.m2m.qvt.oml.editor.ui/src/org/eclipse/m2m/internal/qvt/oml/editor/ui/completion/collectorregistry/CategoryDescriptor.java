/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectorregistry;

public class CategoryDescriptor {
	private final String myId;
	private final String myLabel;
	private final int myPriority;
	
	public CategoryDescriptor(String id, String label, int priority) {
		myId = id;
		myLabel = label;
		myPriority = priority;
	}

	public String getId() {
		return myId;
	}

	public String getLabel() {
		return myLabel;
	}

	public int getPriority() {
		return myPriority;
	}
}