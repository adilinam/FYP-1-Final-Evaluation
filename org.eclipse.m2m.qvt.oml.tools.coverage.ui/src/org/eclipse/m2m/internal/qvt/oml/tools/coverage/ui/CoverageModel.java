/*****************************************************************************
 * Copyright (c) 2014,2015 ASML Netherlands B.V. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  ASML Netherlands B.V. - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.tools.coverage.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.CoverageData;
import org.eclipse.m2m.internal.qvt.oml.tools.coverage.common.TransformationCoverageData;
import org.eclipse.ocl.utilities.ASTNode;

@SuppressWarnings("restriction")
public class CoverageModel {

    Map<IProject, ProjectCoverageModel> projectModels = new HashMap<IProject, ProjectCoverageModel>();

    public CoverageModel(CoverageData coverageData) {
        inflate(coverageData);
    }

    /**
     * The only method to deal with Data objects
     *
     * @param data
     */
    private void inflate(CoverageData data) {

    	Map<URI, TransformationCoverageModel> uriToTransModels = new HashMap<URI, TransformationCoverageModel>();

        for (TransformationCoverageData transformationData : data.getData()) {

            TransformationCoverageModel transformationModel;

            // If we've already seen this transformation, add to that model
            // rather than create a new one

            URI uri = transformationData.getURI();
            if (uriToTransModels.containsKey(uri)) {
                transformationModel = uriToTransModels.get(uri);
            } else {
                transformationModel = new TransformationCoverageModel(uri);
            }

            Module module = transformationModel.getModule();

            if (module != null) {

                // Cycle through all module contents
                Iterator<EObject> it = module.eAllContents();
                while (it.hasNext()) {
                    EObject o = it.next();
                    if (o instanceof ASTNode) {
                        ASTNode node = (ASTNode) o;

                        if (TransformationCoverageData.isIncluded(node)) {

                            NodeCoverageModel nodeModel = new NodeCoverageModel(node);
                            if (transformationModel.containsNode(nodeModel)) {
                                nodeModel = transformationModel.getNode(nodeModel);
                            }

                            // Check if node was touched
                            if (transformationData.containsNode(node)) {
                                nodeModel.setTouched(true);
                            }

                            transformationModel.addNode(nodeModel);
                        }
                    }

                }

                uriToTransModels.put(uri, transformationModel);
            }
        }

        // Now populate the projects (could probably be done more efficiently)

        for (TransformationCoverageModel transModel : uriToTransModels.values()) {
            IProject project = transModel.getProject();
            ProjectCoverageModel projectModel;
            if (projectModels.containsKey(project)) {
                projectModel = projectModels.get(project);
            } else {
                projectModel = new ProjectCoverageModel(project);
            }

            projectModel.addTransformationModel(transModel);
            projectModels.put(project, projectModel);
        }
    }

    public ProjectCoverageModel[] getProjectModels() {
        return projectModels.values().toArray(new ProjectCoverageModel[projectModels.size()]);
    }

}
