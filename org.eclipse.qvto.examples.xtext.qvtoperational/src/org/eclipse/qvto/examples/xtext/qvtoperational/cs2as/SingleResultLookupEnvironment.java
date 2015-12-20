package org.eclipse.qvto.examples.xtext.qvtoperational.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.qvto.examples.xtext.qvtoperationalcs.PathElement2CS;

public class SingleResultLookupEnvironment extends org.eclipse.ocl.pivot.lookup.SingleResultLookupEnvironment {

	
	public SingleResultLookupEnvironment(@NonNull Executor executor, @NonNull String name) {
		super(executor, name);
	}
	
	public SingleResultLookupEnvironment(Executor executor, String name, Boolean isLocal) {
		super(executor, name, isLocal);
	}
	
	public SingleResultLookupEnvironment(Executor executor, PathElement2CS pathElem, Boolean isLocal) {
		super(executor, pathElem.getName(), isLocal);
	}

}
