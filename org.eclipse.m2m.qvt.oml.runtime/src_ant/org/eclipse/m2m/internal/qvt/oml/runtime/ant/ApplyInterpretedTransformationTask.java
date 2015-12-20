/*******************************************************************************
 * Copyright (c) 2007, 2008 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ant;

import org.apache.tools.ant.BuildException;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.emf.util.EmfUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtInterpretedTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.osgi.util.NLS;


/**
 * @author abreslav
 *
 *  Applies the given interpreted transformation 
 */
public class ApplyInterpretedTransformationTask extends AbstractApplyTransformationTask {
    
    @Override
	protected QvtTransformation getTransformationObject() {
        try {
			return new QvtInterpretedTransformation(TransformationUtil.getQvtModule(EmfUtil.makeUri(getTransformation())));
		} catch (MdaException e) {
            throw new BuildException(
                    NLS.bind(
                            org.eclipse.m2m.internal.qvt.oml.runtime.ant.Messages.AbstractApplyTransformationTask_File_not_found, 
                            getTransformation()
                        )
                    );
		}
    }
}
