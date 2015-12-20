/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CoverageData implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<TransformationCoverageData> transformations;

    public CoverageData() {
        transformations = new ArrayList<TransformationCoverageData>(2);
    }

    public void add(TransformationCoverageData data) {
        transformations.add(data);
    }

    public Collection<TransformationCoverageData> getData() {
        return transformations;
    }

    public void clear() {
        transformations.clear();
    }
}
