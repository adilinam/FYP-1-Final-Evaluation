/*******************************************************************************
 * Copyright (c) 2008, 2015 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *     Alex Paperno - bugs 416584
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.ExternalUnitElementsProvider;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalParserUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.QvtOperationalVisitorCS;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingMethodCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.ocl.SemanticException;
import org.eclipse.ocl.ecore.EcoreEnvironment;

/**
 * @author aigdalov
 * Created on Nov 7, 2007
 */
public class QvtCompletionVisitorCS extends QvtOperationalVisitorCS {
    private QvtOperationalEnv myEnv; 

    public QvtCompletionVisitorCS(AbstractQVTParser parser, QvtCompilerOptions options, Monitor monitor) {
        super(parser, options, monitor);
        myEnv = (QvtOperationalEnv) parser.getEnvironment();
    }

    protected void setEnv(QvtOperationalEnv env) {
    	myEnv = env;
    }
    
    public QvtOperationalEnv getEnv() {
        return myEnv;
    }
    
    @Override
	public void visitModuleHeaders(MappingModuleCS moduleCS, URI unitURI, QvtOperationalModuleEnv env, ExternalUnitElementsProvider importResolver, ResourceSet resSet) throws SemanticException {        
        setEnv(env);
        super.visitModuleHeaders(moduleCS, unitURI, env, importResolver, resSet);
    }

    @Override
    protected void visitMappingMethodCS(MappingMethodCS methodCS, QvtOperationalModuleEnv env, ImperativeOperation operation) throws SemanticException {
        if (methodCS.getMappingDeclarationCS() != null && QvtOperationalParserUtil.hasOperationBody(methodCS)) {
            super.visitMappingMethodCS(methodCS, env, operation);
            EcoreEnvironment resolvedEnvironment = ASTBindingHelper.resolveEnvironment(operation);
            if (resolvedEnvironment instanceof QvtOperationalEnv) {
                setEnv((QvtOperationalEnv) resolvedEnvironment);
            }
        }
    }
}