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
package org.eclipse.m2m.internal.qvt.oml.common.launch;

import org.eclipse.m2m.internal.qvt.oml.common.launch.BaseProcess.IRunnable;


public class SafeRunner {
    public static interface IRunner {
        public void run(BaseProcess.IRunnable r) throws Exception;
    }
    
    public static BaseProcess.IRunnable getSafeRunnable(final BaseProcess.IRunnable r) {
        final IRunner runner = SameThreadRunner.INSTANCE;
        return new BaseProcess.IRunnable() {
            public void run() throws Exception {
                runner.run(r);
            }
        };
    }

    static class SameThreadRunner implements IRunner {
        public void run(IRunnable r) throws Exception {
            r.run();
        }
        
        static IRunner INSTANCE = new SameThreadRunner();
    }
}