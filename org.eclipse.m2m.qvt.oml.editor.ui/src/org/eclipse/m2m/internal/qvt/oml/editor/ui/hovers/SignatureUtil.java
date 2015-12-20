/*******************************************************************************
 * Copyright (c) 2007, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.hovers;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.ocl.utilities.UMLReflection;

public class SignatureUtil {

	private SignatureUtil() {
		super();
	}
		
	
	public static String getPackageSignature(EcoreEnvironment env, EPackage ePackage) {
		String qname = env.getUMLReflection().getQualifiedName(ePackage);
		if(qname != null) {
			return qname + " - " + EcoreUtil.getURI(ePackage); //$NON-NLS-1$
		}
		return ePackage.getName();
	}
	
	public static String getOperationSignature(
		UMLReflection<?, EClassifier, EOperation, ?, ?, EParameter, ?, ?, ?, ?> uml, EOperation operation) {
		StringBuilder result = new StringBuilder();
		
		EClassifier owner = uml.getOwningClassifier(operation);
		if(owner != null && owner instanceof Module == false) {
			result.append(uml.getQualifiedName(owner));
			result.append("::"); //$NON-NLS-1$
		}
		
		result.append(uml.getName(operation));
		result.append('(');
		
		for (Iterator<EParameter> iter = uml.getParameters(operation).iterator(); iter.hasNext();) {
			EParameter next = iter.next();
			
			if (uml.getOCLType(next) != null) {
				result.append(getTypedElementSignature(uml, next));
			}
			
			if (iter.hasNext()) {
				result.append(", "); //$NON-NLS-1$
			}
		}
		
		EClassifier returnType = uml.getOCLType(operation); 
		if (returnType == null) {
			result.append(')');
		} else {			
			result.append(") : "); //$NON-NLS-1$
			if(isStdLibType(returnType)) {
				result.append(uml.getName(returnType));
			} else {
				result.append(uml.getQualifiedName(returnType));
			}
		}
		
		EPackage moduleOwner = QvtOperationalParserUtil.getOwningModule(operation);
		if(moduleOwner == null && operation.getEContainingClass() != null) {
			moduleOwner = operation.getEContainingClass().getEPackage();
		}
		
		if(moduleOwner != null) {
			result.append(" - "); //$NON-NLS-1$
			result.append(uml.getQualifiedName(moduleOwner));
		}
		
		return result.toString();
	}	
	
	public static String getTypedElementSignature(
			UMLReflection<?, EClassifier, EOperation, ?, ?, EParameter, ?, ?, ?, ?> uml, ETypedElement typedElement) {
		
		StringBuilder result = new StringBuilder();		
		result.append(uml.getName(typedElement));
		result.append(" : "); //$NON-NLS-1$
		
		EClassifier eType = uml.getOCLType(typedElement);
		if(eType != null) {
			if(isStdLibType(eType)) {
				result.append(uml.getName(eType));
			} else {
				result.append(uml.getQualifiedName(eType));
			}
		}
		
		return result.toString();
	}	
	
	public static String getVariableSignature(EcoreEnvironment env, Variable<EClassifier, EParameter> typedElement) {
		StringBuilder result = new StringBuilder();
		
		result.append(typedElement.getName());
		result.append(" : "); //$NON-NLS-1$
		
		EClassifier eType = env.getUMLReflection().getOCLType(typedElement.getType());
		if(eType != null) {
			if(isStdLibType(eType)) {
				result.append(env.getUMLReflection().getName(eType));
			} else {
				result.append(env.getUMLReflection().getQualifiedName(eType));
			}
		}
		
		return result.toString();
	}
	
	public static boolean isStdLibType(EClassifier type) {
		return type instanceof PredefinedType<?>;
	}


	public static String getPropertySignature(EStructuralFeature feature, EcoreEnvironment env) {
		if(feature != null) {
			String owner = null;
			String type = null;
			if(feature.getEContainingClass() != null) {					
				if(env != null) {
					UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = env.getUMLReflection();
					owner = uml.getQualifiedName(uml.getOCLType(feature.getEContainingClass()));
					type = uml.getQualifiedName(uml.getOCLType(feature));
				}
			}
			
			return feature.getName() + " : " + type + " - " + owner; //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		return null;
	}
}
