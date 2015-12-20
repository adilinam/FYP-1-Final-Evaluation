/*******************************************************************************
 * Copyright (c) 2007, 2009 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.m2m.internal.qvt.oml.runtime.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.DOMHandler;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.m2m.internal.qvt.oml.QvtMessage;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtModule;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.TransformationUtil;
import org.eclipse.m2m.internal.qvt.oml.runtime.util.Messages;
import org.eclipse.osgi.util.NLS;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/**
 * @author sboyko
 *
 */
public class QvtOperationalResourceImpl extends XMIResourceImpl {

    public QvtOperationalResourceImpl(URI uri) {
    	super(uri);
    }
	
    @Override
    public void load(Map<?, ?> options) throws IOException {
    	if (!isLoaded()) {
    		Notification notification = null;
    		isLoading = true;

			if (errors != null) {
				errors.clear();
			}
			if (warnings != null) {
				warnings.clear();
			}
    		
            try {
            	URI normalizedUri = getURIConverter().normalize(getURI());
            	QvtModule qvtModule = TransformationUtil.getQvtModule(normalizedUri);

            	QvtCompilerOptions qvtOptions = new QvtCompilerOptions();
            	qvtOptions.setModuleWithErrorAllowed(true);
            	qvtModule.setQvtCompilerOptions(qvtOptions);
            	
            	CompiledUnit unit = qvtModule.getUnit();
				fillCompilationDiagnostic(unit, normalizedUri);

				if (unit.getModules().isEmpty()) {
    				throw new IOException(NLS.bind(Messages.QvtResource_moduleCompilationErrors, 
    						normalizedUri, unit.getProblems()));
    			}

        		notification = setLoaded(true);
    			getContents().addAll(unit.getModules());
            }
            catch (MdaException e) {
				throw new IOWrappedException(e);
			}
            finally {
				isLoading = false;
				
				if (notification != null) {
					eNotify(notification);
				}
				
				setModified(false);
            }
    	}
    }
    
    private void fillCompilationDiagnostic(CompiledUnit unit, URI uri) {
    	warnings = getWarnings();
		for (QvtMessage msg : unit.getWarnings()) {
			warnings.add(new Diagnostic(msg.getMessage(), uri.toString(), msg.getLineNum()));
		}
		for (QvtMessage msg : unit.getErrors()) {
			warnings.add(new QvtCompilationErrorException(msg, uri.toString(), msg.getLineNum()));
		}
    }

	@Override
    public void doLoad(InputStream inputStream, Map<?, ?> options)
    		throws IOException {
    	throw new UnsupportedOperationException();
    }

    @Override
    public void doLoad(InputSource inputSource, Map<?, ?> options) throws IOException {
    	throw new UnsupportedOperationException();
    }

    @Override
    public void doLoad(Node node, Map<?, ?> options) throws IOException {
    	throw new UnsupportedOperationException();
    }
    
    @Override
    public Document save(Document doc, Map<?, ?> options, DOMHandler handler) {
    	throw new UnsupportedOperationException();
    }
    
    @Override
    public void save(Map<?, ?> options) throws IOException {
    	// resource operates as read-only
    }
    
    @Override
    public boolean isModified() {
    	return false;
    }
    
    @Override
    public boolean isTrackingModification() {
    	return false;
    }
    
	/**
	 * Just a marker for diagnostic notification messages
	 */
	private static class Diagnostic implements Resource.Diagnostic {
		private final String myMessage;
		private final String myLocation;
		private final int myLine;

		Diagnostic(String message, String  location, int line) {
			myMessage = message;
			myLocation = location;
			myLine = line;
		}

		public String getMessage() {
			return myMessage;
		}		

		public String getLocation() {
			return myLocation;
		}

		public int getColumn() {
			return 0;
		}

		public int getLine() {
			return myLine;
		}
	}

}
