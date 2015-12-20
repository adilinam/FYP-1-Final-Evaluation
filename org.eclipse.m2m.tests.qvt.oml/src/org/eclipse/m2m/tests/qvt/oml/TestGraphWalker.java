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
package org.eclipse.m2m.tests.qvt.oml;

import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker;
import org.eclipse.m2m.internal.qvt.oml.evaluator.GraphWalker.NodeProvider;

import junit.framework.TestCase;

public class TestGraphWalker extends TestCase {
    Node A = new Node("A"); //$NON-NLS-1$
    Node B = new Node("B"); //$NON-NLS-1$
    Node C = new Node("C"); //$NON-NLS-1$
    Node D = new Node("D"); //$NON-NLS-1$
    Node E = new Node("E"); //$NON-NLS-1$
    Node F = new Node("F"); //$NON-NLS-1$
    Node G = new Node("G"); //$NON-NLS-1$
    Node H = new Node("H"); //$NON-NLS-1$
    
    NodeProvider NODE_PROVIDER = new NodeProvider() {
        public Object[] getLinkedNodes(Object node) {
            if(node == A) {
                return new Object[] {B, C, E, F};
            }
            else if(node == C) {
                return new Object[] {D};
            }
            else if(node == E) {
                return new Object[] {F};
            }
            else {
                return new Object[0];
            }
        }
    };

    public void testMinDistance() {
        GraphWalker walker = new GraphWalker(NODE_PROVIDER);
        
        Object[][] data = new Object[][] {
                new Object[] {B, C, new Integer(GraphWalker.MAX_WEIGHT)},
                new Object[] {A, B, new Integer(1)},
                new Object[] {A, D, new Integer(2)},
                new Object[] {A, F, new Integer(1)},
        };
        
        for (int i = 0; i < data.length; i++) {
            Object[] objects = data[i];
            
            Node a = (Node)objects[0];
            Node b = (Node)objects[1];
            int d = ((Integer)objects[2]).intValue();
            
            assertEquals("Wrong distance from " + a + " to " + b, d, walker.getMinimumDistance(a, b, 1));  //$NON-NLS-1$//$NON-NLS-2$
        }
    }

    static class Node {
        public Node(String name) { myName = name; }
        @Override
		public String toString() {return myName; } 
        private final String myName;
    }
}
