/*******************************************************************************
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.project.config;

public class QvtConfigurationProperty {

    public QvtConfigurationProperty(String name,
            QvtConfigurationPropertyType type) {
        myName = name;
        myType = type;
    }

    public String getName() {
        return myName;
    }

    public QvtConfigurationPropertyType getType() {
        return myType;
    }

    @Override
    public int hashCode() {
        return (myName != null) ? myName.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof QvtConfigurationProperty == false) {
            return false;
        }
        QvtConfigurationProperty other = (QvtConfigurationProperty) obj;
        return myName.equals(other.getName()) && myType.equals(other.getType());
    }

    private final String myName;

    private final QvtConfigurationPropertyType myType;
}
