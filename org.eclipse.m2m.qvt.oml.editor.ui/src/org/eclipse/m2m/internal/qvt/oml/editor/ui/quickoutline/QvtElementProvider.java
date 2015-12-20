/*******************************************************************************
 * Copyright (c) 2013 S. Boyko and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Sergey Boyko - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.quickoutline;

import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.information.IInformationProvider;
import org.eclipse.jface.text.information.IInformationProviderExtension;

public class QvtElementProvider implements IInformationProvider, IInformationProviderExtension {
    public static final Object FAKE_ROOT = new Object();

    /*
     * @see IInformationProvider#getSubject(ITextViewer, int)
     */
    public IRegion getSubject(ITextViewer textViewer, int offset) {
        if (textViewer != null) {
            return new Region(offset, 0);
        }
        return null;
    }

    /*
     * @see IInformationProvider#getInformation(ITextViewer, IRegion)
     */
    public String getInformation(ITextViewer textViewer, IRegion subject) {
        return getInformation2(textViewer, subject).toString();
    }

    /*
     * @see IInformationProviderExtension#getElement(ITextViewer, IRegion)
     */
    public Object getInformation2(ITextViewer textViewer, IRegion subject) {
        return FAKE_ROOT;
    }
}