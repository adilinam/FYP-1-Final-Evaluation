package org.eclipse.qvto.examples.xtext.imperativeocl.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.essentialocl.cs2as.EssentialOCLCS2AS;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;

public class ImperativeOCLCS2AS extends EssentialOCLCS2AS {

	public ImperativeOCLCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull BaseCSResource csResource, @NonNull ASResource asResource) {
		super(environmentFactory, csResource, asResource);
	}
	
	@Override
	protected @NonNull CS2ASConversion createConversion(@NonNull IDiagnosticConsumer diagnosticsConsumer,
			@NonNull BaseCSResource csResource) {
		return new NewCS2AS(this, diagnosticsConsumer);
	}
}
