package org.eclipse.qvto.examples.xtext.imperativeocl.utilities;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.xtext.base.cs2as.CS2AS;
import org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource;
import org.eclipse.qvto.examples.pivot.imperativeocl.ImperativeOCLPackage;
import org.eclipse.qvto.examples.xtext.imperativeocl.cs2as.ImperativeOCLCS2AS;

public class ImperativeOCLCSResource extends EssentialOCLCSResource {


	@Override
	public @NonNull CS2AS createCS2AS(@NonNull EnvironmentFactoryInternal environmentFactory,
			@NonNull ASResource asResource) {
		return new ImperativeOCLCS2AS(environmentFactory, this, asResource);
	}
	@Override
	public @NonNull String getASContentType() {
		return ImperativeOCLPackage.eCONTENT_TYPE;
	}

	@Override
	public @NonNull URI getASURI(@NonNull URI csURI) {
		return URI.createURI(csURI.toString() + "as");
	}

	@Override
	public @NonNull String getEditorName() {
		return "Imperative OCL";
	}
	
//	/* (non-Javadoc)
//	 * @see org.eclipse.ocl.xtext.essentialocl.utilities.EssentialOCLCSResource#createMetaModelManager()
//	 */
//	@Override
//	public final @NonNull MetaModelManager createMetaModelManager() {
//		// FIXME move this to EssentialOCLCS Resource		
//		ResourceSet resourceSet = getResourceSet();
//		if (resourceSet != null) {
//			MetaModelManagerResourceSetAdapter resourceSetAdapter = MetaModelManagerResourceSetAdapter.findAdapter(resourceSet);
//			if (resourceSetAdapter != null) {
//				return resourceSetAdapter.getMetaModelManager();
//			}
//		}
//		return doCreateMetamodeManager();
//	}
//
//	protected MetaModelManager doCreateMetamodeManager() {
//		return new ImperativeOCLMetamodelManager();
//	}
}
