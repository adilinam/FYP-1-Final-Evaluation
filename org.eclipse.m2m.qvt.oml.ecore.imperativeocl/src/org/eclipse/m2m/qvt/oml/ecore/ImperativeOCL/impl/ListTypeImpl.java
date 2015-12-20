/**
 * <copyright>
 * Copyright (c) 2008, 2009 Open Canarias S.L. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     A. Sanchez-Barbudo  - initial API and implementation
 * </copyright>
 *
 * $Id: ListTypeImpl.java,v 1.2 2009/01/25 23:10:43 radvorak Exp $
 */
package org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeOCLPackage;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ListType;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLPlugin;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.util.ImperativeOCLValidator;
import org.eclipse.ocl.ecore.impl.CollectionTypeImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ListTypeImpl extends CollectionTypeImpl implements ListType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected ListTypeImpl() {
		super();
		setInstanceClass(List.class);
 	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeOCLPackage.Literals.LIST_TYPE;
	}
	
	/**
	 *
	 * Overwriting of the method checkCollectionTypeName
	 * @generated NOT
	 */
	@Override
	public boolean checkCollectionTypeName(DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		
		boolean result=true;
		
		String name = getName();
    	EClassifier elementType = getElementType();    	
    	if (elementType != null) {
    		String elementTypeName = elementType.getName();    		
    		if (!("List(" + elementTypeName + ")").equals(name)) //$NON-NLS-1$ //$NON-NLS-2$
    			result = false;
    	}
    	
        if (!result) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                        ImperativeOCLValidator.DIAGNOSTIC_SOURCE,
                        0,
                        ImperativeOCLPlugin.INSTANCE.getString(
                        	"_UI_InvalidListTypeName_diagnostic", //$NON-NLS-1$ 
                        	new Object[] {ImperativeOCLValidator.getObjectLabel(this, context)}),
                        new Object [] { this }));
            }
        }
    	return result;
	}

} //ListTypeImpl
