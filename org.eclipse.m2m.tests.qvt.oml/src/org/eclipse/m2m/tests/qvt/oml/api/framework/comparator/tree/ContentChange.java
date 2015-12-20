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
package org.eclipse.m2m.tests.qvt.oml.api.framework.comparator.tree;

/**
 * @author pkobiakov
 */
public interface ContentChange {
	int getCmp();
	int getCost();

	abstract class Adapter implements ContentChange {
		public int getCost() {
			int cmp = getCmp();
			return cmp >= 0 ? cmp : -cmp;
		}
	}

	ContentChange NULL_CHANGE = new ContentChange.Adapter() {
		public int getCmp() { return 0; }
		@Override
		public String toString() { return ""; } //$NON-NLS-1$
	};
}
