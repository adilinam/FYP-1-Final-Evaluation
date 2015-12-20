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
package org.eclipse.m2m.internal.qvt.oml.cst.parser;


/**
 * @author Aleksandr Igdalov
 * Created on Nov 27, 2008
 */

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.m2m.internal.qvt.oml.cst.parser.messages"; //$NON-NLS-1$
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}

	public static String NoModulesDeclared;
	public static String ModuleDeclarationMustPrecedeThisElement;
	public static String MultipleModulesExtraUnitElements;
	public static String IdentifierExpectedOnLeftSide;
	public static String ImportMustBeFirstInCompilationUnit;
	public static String InvalidAdditiveAssignmentUsage;
	public static String AbstractQVTParser_DeprecatedSwitchAltExp;
	public static String AbstractQVTParser_DeprecatedSwitchElseExp;
	public static String EntryOp_DisallowedDeclAsHelper;
    
}
