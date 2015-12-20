package org.eclipse.qvto.examples.pivot.qvtoperational.utilities;
/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */


import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvto.examples.pivot.qvtoperational.util.AbstractQVTOperationalAS2XMIidVisitor;

public class QVTOperationalAS2XMIidVisitor extends AbstractQVTOperationalAS2XMIidVisitor
{
	protected QVTOperationalAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}
}
