package org.eclipse.qvto.examples.xtext.qvtoperational.utilities;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.qvto.examples.pivot.qvtoperational.QVTOperationalPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.utilities.ImperativeOCLCSResource;
import org.eclipse.qvto.examples.xtext.qvtoperational.cs2as.QVTOperationalCS2AS;

public class QVTOperationalCSResource
		extends ImperativeOCLCSResource {
	
	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull org.eclipse.ocl.pivot.resource.ASResource asResource) {
		return new QVTOperationalCS2AS(environmentFactory, this, asResource);
	}
	


	@Override
	public @NonNull String getASContentType() {
		return QVTOperationalPackage.eCONTENT_TYPE;
	}

	@Override
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return csURI.trimFileExtension().appendFileExtension("qvtoas");
	}

	@Override
	public @NonNull
	String getEditorName() {
		return "QVT Operational";
	}
}
