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
package org.eclipse.m2m.internal.qvt.oml.common.ui.launch;

import org.eclipse.m2m.internal.qvt.oml.common.launch.TargetUriData;
import org.eclipse.m2m.internal.qvt.oml.common.ui.IModelParameterInfo;
import org.eclipse.swt.widgets.Shell;

/**
 * @author sboyko
 *
 */
public interface IUriGroup {

    public interface IModifyListener {
        void modified();
        void performValidation(boolean isLightweight);
    }
    
    void addModifyListener(IModifyListener listener);
    void removeModifyListener(IModifyListener listener);
    
   	void update(String moduleName, IModelParameterInfo paramInfo, Shell shell);

    void initializeFrom(TargetUriData uriData);
    TargetUriData getUriData();

}
