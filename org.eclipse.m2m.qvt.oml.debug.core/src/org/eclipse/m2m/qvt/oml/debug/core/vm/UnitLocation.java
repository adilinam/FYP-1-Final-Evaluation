/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import org.eclipse.emf.common.util.URI;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.ASTBindingHelper;
import org.eclipse.m2m.internal.qvt.oml.ast.binding.IModuleSourceInfo;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.EvaluationUtil;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.ocl.utilities.ASTNode;

public class UnitLocation {
	
	private static final int UNDEF_LINE_NUM = -2;
	
	private int fLineNum = UNDEF_LINE_NUM;
	private final int fOffset;
	private final int fDepth;	
	
    private final ASTNode fElement;
    private final Module fModule;    
    private final ImperativeOperation fOperation;
    private final QvtOperationalEvaluationEnv fEvalEnv;    
	private IModuleSourceInfo fSrcInfo;
	
	public UnitLocation(int position, QvtOperationalEvaluationEnv evalEnv, ASTNode element) {
		fEvalEnv = evalEnv;
		fElement = element;
		fOffset = position;
		fDepth = calcStackDepth(evalEnv);
		fOperation = evalEnv.getOperation();
		
		InternalEvaluationEnv internEnv = fEvalEnv.getAdapter(InternalEvaluationEnv.class);
		if(internEnv.getCurrentModule() != null) {
			fModule = internEnv.getCurrentModule().getModule();			 
		} else if(element instanceof Module) {
			// TODO - debugging before module instance get created & initialized into evaluation
			// environment => for now, derive from the past AST element
			fModule = (Module) element;
		} else {
			throw new IllegalArgumentException("Module-less evaluation environment"); //$NON-NLS-1$
		}
	}
	
	public boolean isDeferredExecution() {
		return fEvalEnv.getAdapter(InternalEvaluationEnv.class).isDeferredExecution();
	}

    public URI getURI() {
    	return getSourceInfo().getSourceURI();
	}
    
    public Module getModule() {
    	return fModule;
    }
    
    public ImperativeOperation getOperation() {
        return fOperation;
    }
    
	public QvtOperationalEvaluationEnv getEvalEnv() {
		return fEvalEnv;
	} 
	
	public int getLineNum() {
		if(fLineNum == UNDEF_LINE_NUM) {
			int newLine = -1;
			if(fOffset >= 0) {
				newLine = getSourceInfo().getLineNumberProvider().getLineNumber(fOffset);				
			}
			
			return fLineNum = newLine;
		}

		return fLineNum;
	}
	
	public int getOffset() {
		return fOffset;
	}
	
	public int getStackDepth() {
		return fDepth;
	}
	
    public ASTNode getElement() {
        return fElement;
    }
	
    public boolean isTheSameLine(UnitLocation location) {
    	return fEvalEnv == location.fEvalEnv && getLineNum() == location.getLineNum();
    }
    
	@Override
	public boolean equals(Object another) {
		if(another instanceof UnitLocation == false) {
			return false;
		}
		
		UnitLocation location = (UnitLocation) another;
		return this == location || 
				(fOffset == location.fOffset
				&& fDepth == location.fDepth
				&& fEvalEnv == location.fEvalEnv
				&& fElement.equals(location.fElement));
	}	
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash = 37 * hash + fOffset;
		hash = 37 * hash + fDepth;		
		hash = 37 * hash + fElement.hashCode();		
		return hash;
	}
	
	@Override
	public String toString() {
		return fModule.getName() + " - line:" + getLineNum() + //$NON-NLS-1$
			" offset:" + fOffset  + " depth:" + fDepth + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	private IModuleSourceInfo getSourceInfo() {
    	if(fSrcInfo == null) {
    		fSrcInfo = ASTBindingHelper.getModuleSourceBinding(getModule());
    	}
    	return fSrcInfo;
	}
	
	private static int calcStackDepth(QvtOperationalEvaluationEnv currentEvalEnv) {
		// FIXME - move to core QVTO into EvaluationEnv
		int depth = 0;
		QvtOperationalEvaluationEnv evalEnv = currentEvalEnv;
		while(evalEnv != null) {			
			depth += evalEnv.getDepth();
			evalEnv = EvaluationUtil.getAggregatingContext(evalEnv);
		}
		return depth;
	}
}
