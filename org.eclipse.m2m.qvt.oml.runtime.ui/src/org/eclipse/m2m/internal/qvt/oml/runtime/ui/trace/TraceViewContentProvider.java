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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.EObjectNode;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.Node;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.NodeContentProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.StringNode;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingContext;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingParameters;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingResults;
import org.eclipse.m2m.internal.qvt.oml.trace.ETuplePartValue;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.Trace;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;


public class TraceViewContentProvider implements ITreeContentProvider {
    private final NodeContentProvider myNodeContentProvider = new NodeContentProvider();

    public Object[] getChildren(Object parentElement) {
        return getElements(parentElement);
    }

    public Object getParent(Object element) {
        if (element instanceof Node) {
            Object parent = myNodeContentProvider.getParent(element);
            if (parent instanceof EValue) {
            	if (((EValue) parent).eContainer() instanceof EValue) {
            		return parent;
            	}
            	else {
            		return getParent(parent);
            	}
            }
            return parent;
        }
        EObject container = ((EObject) element).eContainer();
        if (container instanceof EMappingParameters) {
        	return getParent(container);
        }
        if (container instanceof EMappingContext) {
        	return getParent(container);
        }
        if (container instanceof EMappingResults) {
        	return getParent(container);
        }
        if (container instanceof ETuplePartValue) {
        	return getParent(container);
        }
        if (container instanceof EValue) {
        	if (container.eContainer() instanceof EValue) {
        		return container;
        	}
        	else {
        		return getParent(container);
        	}
        }
        return container;
    }

    public boolean hasChildren(Object element) {
        return getElements(element).length != 0;
    }

    public Object[] getElements(Object element) {
        if (element instanceof Trace) {
            Trace trace = (Trace) element;
            return trace.getTraceRecords().toArray();
        } else if (element instanceof TraceRecord) {
            TraceRecord traceRecord = (TraceRecord) element;
            List<Object> children = new ArrayList<Object>();
            if (traceRecord.getContext().getContext() != null) {
                children.add(traceRecord.getContext().getContext());
            }
            for (VarParameterValue varParameterValue : traceRecord.getParameters().getParameters()) {
                children.add(varParameterValue);
            }
            for (VarParameterValue varParameterValue : traceRecord.getResult().getResult()) {
                children.add(varParameterValue);
            }
            return children.toArray();
        } else if (element instanceof VarParameterValue) {
            VarParameterValue varParameterValue = (VarParameterValue) element;
            return getElements(varParameterValue.getValue());
        } else if (element instanceof ETuplePartValue) {
            ETuplePartValue tuplePartValue = (ETuplePartValue) element;
            return getElements(tuplePartValue.getValue());
        } else if (element instanceof EValue) {
        	EValue eValue = (EValue) element;
            if (eValue.getModelElement() != null) {
                return new Object[] {new EObjectNode(element, eValue.getModelElement())};
            } else if (eValue.getPrimitiveValue() != null) {
                return new Object[] {new StringNode(element, eValue.getPrimitiveValue())};
            } else if (eValue.getIntermediateElement() != null) {
                return new Object[] {new EObjectNode(element, eValue.getIntermediateElement())};
            } else if (!eValue.getCollection().isEmpty()) {
            	return eValue.getCollection().toArray();
            }
            return new Object[0]; 
        }
        return myNodeContentProvider.getElements(element);  
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
}