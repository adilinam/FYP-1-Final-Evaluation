/*******************************************************************************
 * Copyright (c) 2008, 2014 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.collectors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lpg.runtime.IToken;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceProxy;
import org.eclipse.core.resources.IResourceProxyVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CategoryImageConstants;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.CompletionProposalUtil;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionData;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.completion.QvtCompletionProposal;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.MetamodelRegistry;
import org.eclipse.m2m.internal.qvt.oml.emf.util.mmregistry.WorkspaceMetamodelProvider;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapFactory;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MModelURIMapPackage;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MappingContainer;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.MetamodelURIMappingHelper;
import org.eclipse.m2m.internal.qvt.oml.emf.util.urimap.URIMapping;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;

/**
 * @author Aleksandr Igdalov
 * Created on Jul 4, 2007
 */

public class WorkspaceMetamodelCollector extends AbstractMetamodelCollector {
	public void addPropoposals(Collection<ICompletionProposal> proposals, QvtCompletionData data) {
		List<IPath> workspaceMetamodels = collectWorkspaceMetamodels();
		for (IPath workspaceMetamodel : workspaceMetamodels) {
			QvtCompletionProposal proposal = createCompletionProposal(workspaceMetamodel, data);
			proposals.add(proposal);
		}
		
	}
	
    public static final QvtCompletionProposal createCompletionProposal(final IPath workspaceMetamodelPath, final QvtCompletionData data) {
        IToken currentToken = data.getCurrentToken();
		int offset = data.getOffset();
        int replacementOffset = (currentToken == null) ? offset : currentToken.getStartOffset();
        int replacementLength = offset - replacementOffset;
        String displayString = workspaceMetamodelPath.toString();
        Image image = CompletionProposalUtil.getImage(CategoryImageConstants.PACKAGE);
        return new QvtCompletionProposal(null, replacementOffset, replacementLength, -1, image,
        		displayString, null, null) {
					@Override
					public void apply(IDocument document) {
						URI resURI = URI.createPlatformResourceURI(workspaceMetamodelPath.toString(), false);
						EPackage pack = loadPackage(resURI);
						if (pack == null) {
							data.showError(NLS.bind(Messages.WorkspaceMetamodelCollector_EPackageLoadError, workspaceMetamodelPath));
						} else if ((pack.getName() == null) || (pack.getNsURI() == null)) {
							data.showError(NLS.bind(Messages.WorkspaceMetamodelCollector_EPackageNameOrNsUriIsNull, workspaceMetamodelPath));
						} else {
							addToSettings(data, resURI, pack);
							String replacementString = getProposalString(data, pack);
							setReplacementString(replacementString);
							setCursorPosition(replacementString.length());
							super.apply(document);
						}
					}
        };
    }
    
    private static List<IPath> collectWorkspaceMetamodels() {
    	final List<IPath> result = new ArrayList<IPath>();
    
    	try {
			ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceProxyVisitor() {
				public boolean visit(IResourceProxy proxy) throws CoreException {
					if(proxy.getType() == IResource.FILE && MetamodelRegistry.isMetamodelFileName(proxy.getName())) {
						result.add(proxy.requestFullPath());
					}
					return true;
				}
			}, IResource.NONE);
		} catch (CoreException e) {
			Activator.log(e);
		}
		
		return result;
    }
    
	private static EPackage loadPackage(URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.getResource(uri, true);
		return WorkspaceMetamodelProvider.getFirstEPackageContent(res);
	}
	
	private static void addToSettings(QvtCompletionData data, URI resURI, EPackage pack) {
		URI cFile = data.getCFile().getURI();		
		if(!cFile.isPlatformResource()) {
			return;
		}

		String wsRelativePath = cFile.toPlatformString(true);
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(wsRelativePath));
		if (resource != null) {
			IProject project = resource.getProject();
			if (project != null) {
				MappingContainer uriMap = loadMappings(project);
				URIMapping mapping = createMapping(resURI, pack);
				removeOldMapping(uriMap, mapping);
				uriMap.getMapping().add(mapping);
				saveMappings(uriMap, project);
			}
		}
	}

	private static URIMapping createMapping(URI resURI, EPackage pack) {
		URIMapping mapping = MModelURIMapFactory.eINSTANCE.createURIMapping();
		mapping.setSourceURI(pack.getNsURI());
		mapping.setTargetURI(resURI.toString());
		return mapping;
	}
	
	private static void removeOldMapping(MappingContainer uriMap, URIMapping pattern) {
		for (URIMapping mapping : uriMap.getMapping()) {
			if ((pattern.getSourceURI().equals(mapping.getSourceURI()))
					|| (pattern.getTargetURI().equals(mapping.getTargetURI()))) {
				uriMap.getMapping().remove(mapping);
				break;
			}
		}
	}

	private static MappingContainer loadMappings(IProject project) {
    	// ensure mapping package gets into registry before loading
    	MModelURIMapPackage.eINSTANCE.getNsURI();

		Resource res = MetamodelURIMappingHelper.createMappingResource(project);
		try {
			if(MetamodelURIMappingHelper.hasMappingResource(project)) {
				res.load(null);
			}
		} catch (IOException e) {
			Activator.log(e);
		}
		
		return res.getContents().isEmpty() ? 
				MetamodelURIMappingHelper.createNewMappings(res)
				: MetamodelURIMappingHelper.getMappings(res);
	}
	
	private static void saveMappings(MappingContainer uriMap, IProject project) {
		Resource res = uriMap.eResource();
		try {
			res.save(null);
		} catch (IOException e) {
			Activator.log(e);
		}
    	if(project != null) {
    		try {
    			IFile mappingFile = MetamodelURIMappingHelper.getMappingFileHandle(project);
    			mappingFile.refreshLocal(IResource.DEPTH_ZERO, null);
			} catch (CoreException e) {
				Activator.log(e);
			}
    	}
	}
}