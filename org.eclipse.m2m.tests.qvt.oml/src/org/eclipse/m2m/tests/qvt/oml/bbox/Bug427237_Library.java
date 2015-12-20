/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.tests.qvt.oml.bbox;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.m2m.qvt.oml.blackbox.java.JavaModelInstance;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.m2m.qvt.oml.util.IContext;

public class Bug427237_Library {

	@Operation(contextual = false, kind = Kind.TRANSFORMATION, withExecutionContext = true)
	public void bug427237(IContext context, JavaModelInstance in, JavaModelInstance out) {
		EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName("root" + context.getConfigProperties().get("prop"));
		out.getExtent().addObject(rootPackage);
		
		for (int i = 0; i < in.getExtent().getRootObjects().size(); ++i) {
			EClass cls = EcoreFactory.eINSTANCE.createEClass();
			cls.setName("cls" + i);
			rootPackage.getEClassifiers().add(cls);
			out.getExtent().addObject(cls);
		}
	}

	@Operation(contextual = false, kind = Kind.TRANSFORMATION, withExecutionContext = true)
	public void bug427237_javaless(IContext context, JavaModelInstance in, JavaModelInstance out) {
		bug427237(context, in, out);
	}
	
}
