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
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2m.qvt.oml.tools.coverage.Activator;

import com.google.common.collect.Range;
import com.google.common.collect.RangeSet;

public class CoverageAnnotator {

    final public static String TOUCHED_MARKER_TYPE = "org.eclipse.m2m.qvt.oml.tools.coverage.markers.touchedMarker";
    final public static String UNTOUCHED_MARKER_TYPE = "org.eclipse.m2m.qvt.oml.tools.coverage.markers.untouchedMarker";

    public boolean BUSY = false;

	public void annotate(IFile file, RangeSet<Integer> ranges, String markerType, String message) {

        for (Range<Integer> range : ranges.asRanges()) {

            int start = range.lowerEndpoint();
            int end = range.upperEndpoint();

            try {
                IMarker m = file.createMarker(markerType);
                m.setAttribute(IMarker.CHAR_START, start);
                m.setAttribute(IMarker.CHAR_END, end);
                if (message.length() > 0) {
                    m.setAttribute(IMarker.MESSAGE, message);
                }

            } catch (Exception e) {
            	Activator.error("Failed to setup coverage marker", e);
            }
        }
    }

    public void annotateTouched(IFile file, RangeSet<Integer> ranges) {
        removeAnnotations(file, TOUCHED_MARKER_TYPE);
        annotate(file, ranges, TOUCHED_MARKER_TYPE, "");
    }

    public void annotateUntouched(IFile file, RangeSet<Integer> ranges) {
        removeAnnotations(file, UNTOUCHED_MARKER_TYPE);
        annotate(file, ranges, UNTOUCHED_MARKER_TYPE, "");
    }

	public void removeAnnotations(IFile file, String markerType) {
        try {
            file.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
        } catch (CoreException e) {
        	Activator.error("Failed to clear coverage markers", e);
        }
    }

    public void removeAnnotations(IFile file) {
        removeAnnotations(file, TOUCHED_MARKER_TYPE);
        removeAnnotations(file, UNTOUCHED_MARKER_TYPE);
    }

}
