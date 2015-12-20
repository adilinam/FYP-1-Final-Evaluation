package org.eclipse.qvto.examples.build.utilities;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.generator.AbstractGenModelHelper;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;


/**
 * FIXME [MERGE] Merge these methods into AbstractGenModelHelper
 * 
 * @author asbh
 */
public class QVToGenModelHelper extends AbstractGenModelHelper {

	public QVToGenModelHelper(PivotMetamodelManager metaModelManager) {
		super(metaModelManager);
	}
		
	/**
	 * 
	 * @param class a class
	 * @return the name of the java package name of the java interface 
	 * corresponding to the given Type
	 */
	public @Nullable String getInterfacePackageName(Class type) {
		GenPackage genPackage = getGenPackage(type);
		return genPackage.getClassPackageName(); 
	}
}