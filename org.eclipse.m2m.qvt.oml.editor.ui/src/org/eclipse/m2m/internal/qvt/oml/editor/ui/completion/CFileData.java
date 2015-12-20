/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.completion;

import org.eclipse.m2m.internal.qvt.oml.cst.MappingModuleCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.cst.parser.AbstractQVTParser;
import org.eclipse.ocl.lpg.AbstractLexer;

/**
 * @author Aleksandr Igdalov
 * Created on Oct 23, 2007
 */
public class CFileData {
	
    private AbstractLexer myLexer;
    private AbstractQVTParser myParser;
    private UnitCS myUnitCS;
    private String myLightweightScript;
 
    public CFileData() {
    }
    
    public AbstractLexer getLexer() {
        return myLexer;
    }

    public void setLexer(AbstractLexer lexer) {
        myLexer = lexer;
    }
    
	public void setParser(AbstractQVTParser myParser) {
		this.myParser = myParser;
	}

	public AbstractQVTParser getParser() {
		return myParser;
	}

	public MappingModuleCS getMappingModuleCS() {
    	if(myUnitCS == null || myUnitCS.getModules().isEmpty()) {
    		return null;
    	}
    	// FIXME - we just follow the contract need to be adjusted to 
    	// the fact that UnitCS is the root CST
    	return myUnitCS.getModules().get(0);
    }
    
    public UnitCS getUnitCS() {
        return myUnitCS;
    }

    public void setUnitCS(UnitCS unitCS) {
        myUnitCS = unitCS;
    }
    
    public String getLightweightScript() {
        return myLightweightScript;
    }

    public void setLightweightScript(String lightweightScript) {
        myLightweightScript = lightweightScript;
    }

}