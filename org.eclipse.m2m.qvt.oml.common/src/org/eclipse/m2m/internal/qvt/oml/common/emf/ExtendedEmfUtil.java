/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.emf;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.Messages;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.emf.util.URIUtils;
import org.eclipse.osgi.util.NLS;


/**
 * @author pkobiakov
 */
public class ExtendedEmfUtil {
    private ExtendedEmfUtil() {}
    
    public static void saveModel(EObject eObject, URI uri, Map<Object, Object> options) throws MdaException {
        try {
			EmfUtil.saveModel(eObject, uri, options);
		} catch (EmfException e) {
			throw new MdaException(e);
		} catch (Exception e) {
			throw new MdaException(NLS.bind(Messages.InvalidFilePath, new Object[] {uri}), e);
		}
        
       	URIUtils.refresh(uri);
    }
}
