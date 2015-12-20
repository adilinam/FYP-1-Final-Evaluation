package org.eclipse.m2m.qvt.oml.emof.QVTOperational.facade;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.QVTOperationalPackage;
import org.eclipse.m2m.qvt.oml.emof.QVTOperational.util.QVTOperationalMappingMetaData;
import org.eclipse.qvt.declarative.ecore.mappings.IMappingMetaData;

/**
 * QVTOperationalFacade provides definitions in a distinct package that can be
 * imported avoiding the exposure of all EMOF-based definitions as would
 * be the case for import of the entire bundle.
 */
public interface QVTOperationalFacade
{
	String CONTENT_TYPE = QVTOperationalPackage.eCONTENT_TYPE;
	EPackage PACKAGE = QVTOperationalPackage.eINSTANCE;
	IMappingMetaData MAPPING_META_DATA = QVTOperationalMappingMetaData.INSTANCE;
}
