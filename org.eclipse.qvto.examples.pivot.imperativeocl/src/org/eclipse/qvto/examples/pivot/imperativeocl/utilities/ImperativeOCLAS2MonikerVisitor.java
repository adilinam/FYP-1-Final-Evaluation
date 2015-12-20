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
package org.eclipse.qvto.examples.pivot.imperativeocl.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.qvto.examples.pivot.imperativeocl.util.AbstractImperativeOCLAS2MonikerVisitor;

public class ImperativeOCLAS2MonikerVisitor extends AbstractImperativeOCLAS2MonikerVisitor
{
	protected ImperativeOCLAS2MonikerVisitor(@NonNull AS2Moniker context) {
		super(context);
	}
}
