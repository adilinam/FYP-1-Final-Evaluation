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
package org.eclipse.m2m.internal.qvt.oml.runtime.project;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.PrimitiveType;


public class QvtPrimitiveType extends PrimitiveType {

    public QvtPrimitiveType(EClassifier classifier) {
        super(classifier.getInstanceClass());
        if (!QvtOperationalUtil.isPrimitiveType(classifier)) {
            throw new IllegalArgumentException("Non-primitive type passed"); //$NON-NLS-1$
        }
        if (false == classifier.getInstanceClass() instanceof Class<?>) {
            throw new IllegalArgumentException("Invalid delegate"); //$NON-NLS-1$
        }
        myClassifier = classifier;
    }
    
    @Override
    public String getName() {
        return myClassifier.getName();
    }

    private final EClassifier myClassifier;
}
