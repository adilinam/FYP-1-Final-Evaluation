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
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvto.examples.pivot.imperativeocl.utilities;

import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.xmi.impl.RootXMLContentHandlerImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrintVisitor;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.internal.resource.ASResourceFactory;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.ocl.pivot.internal.resource.AbstractASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.AS2Moniker;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.ocl.pivot.utilities.AS2MonikerVisitor;
import org.eclipse.ocl.pivot.utilities.AS2XMIidVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverLocateVisitor;
import org.eclipse.ocl.pivot.utilities.ASSaverResolveVisitor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;

/**
 * ImperativeOCLASResourceFactory supports creation of a ImperativeOCL AS resource and associated artefacts.
 */
public class ImperativeOCLASResourceFactory extends AbstractASResourceFactory
{
	private static final @NonNull String AS_FILE_EXTENSION = "imperativeoclas";
	private static final @NonNull String CS_FILE_EXTENSION = "iocl";
	private static ImperativeOCLASResourceFactory INSTANCE;

	private static final @NonNull ContentHandler CONTENT_HANDLER = new RootXMLContentHandlerImpl(
		ImperativeOCLPackage.eCONTENT_TYPE, new String[]{AS_FILE_EXTENSION},
		RootXMLContentHandlerImpl.XMI_KIND, ImperativeOCLPackage.eNS_URI, null);
	
	static {
		installContentHandler(ContentHandler.Registry.NORMAL_PRIORITY, CONTENT_HANDLER);
	}
	
	public static synchronized @NonNull ImperativeOCLASResourceFactory getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ImperativeOCLASResourceFactory();	// Create our own singleton
			INSTANCE.install(CS_FILE_EXTENSION, null);
		}
		return INSTANCE;
	}
	/**
	 * Creates an instance of the resource factory.
	 */
	public ImperativeOCLASResourceFactory() {
		super(ImperativeOCLPackage.eCONTENT_TYPE);
	}

	@Override
	public @NonNull AS2MonikerVisitor createAS2MonikerVisitor(@NonNull AS2Moniker as2moniker) {
		return new ImperativeOCLAS2MonikerVisitor(as2moniker);
	}

	@Override
	public @NonNull AS2XMIidVisitor createAS2XMIidVisitor(@NonNull AS2XMIid as2id) {
		return new ImperativeOCLAS2XMIidVisitor(as2id);
	}

	@Override
	public @NonNull ASSaverLocateVisitor createASSaverLocateVisitor(@NonNull ASSaver asSaver) {
		return new ImperativeOCLASSaverLocateVisitor(asSaver);
	}

	@Override
	public @NonNull ASSaverResolveVisitor createASSaverResolveVisitor(@NonNull ASSaver asSaver) {
		return new ImperativeOCLASSaverResolveVisitor(asSaver);
	}

	@Override
	public @NonNull PrettyPrintVisitor createPrettyPrintVisitor(@NonNull PrettyPrinter printer) {
		return new ImperativeOCLPrettyPrintVisitor(printer);
	}

	@Override
	public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
		return new ImperativeOCLToStringVisitor(s);
	}

	@Override
	@NonNull
	public ASResourceFactory getASResourceFactory() {
		return getInstance();
	}
}
