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

import org.eclipse.osgi.util.NLS;

final class TextMessages extends NLS {

    private static final String BUNDLE_NAME= TextMessages.class.getName();

    private TextMessages() {
        // Do not instantiate
    }

    public static String AbstractInformationControl_viewMenu_toolTipText;
    public static String AbstractInformationControl_viewMenu_move_label;
    public static String AbstractInformationControl_viewMenu_resize_label;
    public static String AbstractInformationControl_viewMenu_remember_label;
    public static String QvtOutlineInformationControl_statusFieldText_hideInheritedMembers;
    public static String QvtOutlineInformationControl_statusFieldText_showInheritedMembers;

    static {
        NLS.initializeMessages(BUNDLE_NAME, TextMessages.class);
    }
}