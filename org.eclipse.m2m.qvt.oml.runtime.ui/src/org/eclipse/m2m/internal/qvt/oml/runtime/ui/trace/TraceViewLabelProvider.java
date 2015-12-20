/*******************************************************************************
 * Copyright (c) 2007, 2015 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *   
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.m2m.internal.qvt.oml.common.ui.CommonPluginImages;
import org.eclipse.m2m.internal.qvt.oml.emf.util.ui.provider.EMFLabelProvider;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.trace.presentation.Node;
import org.eclipse.m2m.internal.qvt.oml.stdlib.AbstractQVTStdlib;
import org.eclipse.m2m.internal.qvt.oml.trace.EMappingOperation;
import org.eclipse.m2m.internal.qvt.oml.trace.ETuplePartValue;
import org.eclipse.m2m.internal.qvt.oml.trace.EValue;
import org.eclipse.m2m.internal.qvt.oml.trace.TracePackage;
import org.eclipse.m2m.internal.qvt.oml.trace.TraceRecord;
import org.eclipse.m2m.internal.qvt.oml.trace.VarParameterValue;
import org.eclipse.swt.graphics.Image;

/**
 * @author Aleksandr Igdalov
 */
public class TraceViewLabelProvider extends EMFLabelProvider {
	private final AdapterFactoryLabelProvider myLabelProvider;

	private boolean isQualified;
	
    public TraceViewLabelProvider() {
		super();
		ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		myLabelProvider = new AdapterFactoryLabelProvider(composedAdapterFactory);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof TraceRecord) {
			TraceRecord traceRecord = (TraceRecord) element;
			StringBuffer result = new StringBuffer();
            EMappingOperation mappingOperation = traceRecord.getMappingOperation();
            if (isQualified) {
                if (mappingOperation.getPackage().length() != 0) {
                    result.append(mappingOperation.getPackage() + '.');
                }
                result.append(mappingOperation.getModule() + '.');
            }
            result.append(mappingOperation.getName());
			result.append(" ("); //$NON-NLS-1$
			if (traceRecord.getContext().getContext() != null) {
				result.append("SELF: " + getValue(traceRecord.getContext().getContext().getValue())); //$NON-NLS-1$
			}
			appendValueList(traceRecord.getParameters().getParameters(), "PARAMS", result); //$NON-NLS-1$
			appendValueList(traceRecord.getResult().getResult(), "RESULT", result); //$NON-NLS-1$
			result.append(")"); //$NON-NLS-1$
			
			return result.toString();
		} else if (element instanceof VarParameterValue) {
			VarParameterValue varParameterValue = (VarParameterValue) element;
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(varParameterValue.getKind().getLiteral().toLowerCase() + ' ');
			stringBuffer.append(varParameterValue.getName() + " : "); //$NON-NLS-1$
			stringBuffer.append(varParameterValue.getType() + " = "); //$NON-NLS-1$
			stringBuffer.append(getValue(varParameterValue.getValue()));
			return stringBuffer.toString();
		} else if (element instanceof EValue) {
			return getValue((EValue) element);
		} else if (element instanceof Node) {
            Object object = ((Node) element).getObject();
            String text = myLabelProvider.getText(object);
            if (isContainedByTrace(object)) {
            	text = "[unbound] " + text; //$NON-NLS-1$
            }
            return text;
        }
        throw new RuntimeException("Unknown input:" + element.getClass()); //$NON-NLS-1$
	}
    
    @Override
	public Image getImage(Object element) {
    	if (element instanceof TraceRecord) {
            Image img = myLabelProvider.getImage(element);
    		Object[] elements = new TraceViewContentProvider().getElements((TraceRecord) element);
            for (Object obj : elements) {
            	Image newImage = getVarParameterImage(img, (VarParameterValue) obj);
        		if (newImage != img) {
                   	return newImage;
        		}
            }
            return img;
    	} else if (element instanceof VarParameterValue) {
   			return getVarParameterImage(myLabelProvider.getImage(element), (VarParameterValue) element);
    	} else if (element instanceof Node) {
            Object object = ((Node) element).getObject();
            Image img = myLabelProvider.getImage(object);
            if (isContainedByTrace(object)) {
            	return getDecoratedImage(img, CommonPluginImages.WARNING_CO);
            }
            return img;
        }
		return myLabelProvider.getImage(element);
	}

    private Image getVarParameterImage(Image baseImage, VarParameterValue varParamV) {
		if (varParamV.getValue() != null && varParamV.getValue().getModelElement() != null) {
			EObject modelElement = varParamV.getValue().getModelElement();
            if (isContainedByTrace(modelElement)) {
            	return getDecoratedImage(baseImage, CommonPluginImages.WARNING_CO);
            }
		}
        return baseImage;
    }

	public void setShowQualifiedNames(boolean isOn) {
        isQualified = isOn;
    }
	
	@Override
	public void dispose() {
		for (Image img : myImageCache) {
			img.dispose();
		}
		super.dispose();
	}
	
	private void appendValueList(EList<VarParameterValue> valueList, String prefix, StringBuffer result) {
		int size = valueList.size(); 
		if (size > 0) {
			if (result.charAt(result.length() - 1) != '(') {
				result.append(", "); //$NON-NLS-1$
			}
			result.append(prefix + ": "); //$NON-NLS-1$
			for (int i = 0, n = size - 1; i < n; i++) {
				result.append(getValue(valueList.get(i).getValue()) + ", "); //$NON-NLS-1$
			}
			result.append(getValue(valueList.get(size - 1).getValue()));
		}
	}
	
	private static String getValue(EValue eValue) {
	    if (eValue instanceof ETuplePartValue) {
	        ETuplePartValue tuplePartValue = (ETuplePartValue) eValue;
	        return '[' + tuplePartValue.getName() + "]: " + getValue(tuplePartValue.getValue());  //$NON-NLS-1$
	    } else if (eValue.getModelElement() != null) {
			return eValue.getModelElement().eClass().getName();
        } else if (eValue.getPrimitiveValue() != null) {
            return eValue.getPrimitiveValue();
        } else if (eValue.getIntermediateElement() != null) {
            return eValue.getIntermediateElement().eClass().getName();
        } else if (!eValue.getCollection().isEmpty()) {
            return eValue.getCollectionType() + '[' + eValue.getCollection().size() + ']';
		} else {
			return AbstractQVTStdlib.NULL_NAME;
		}
	}

	
	private boolean isContainedByTrace(Object element) {
		if (false == element instanceof EObject) {
			return false;
		}
		return EcoreUtil.getRootContainer(((EObject) element)).eClass().eContainer() == TracePackage.eINSTANCE; 
	}

    private Image getDecoratedImage(Image baseImage, String decoratorKey) {
        ImageDescriptor decoratorId = CommonPluginImages.getInstance().getImageDescriptor(decoratorKey);
        DecorationOverlayIcon decoratedIconId = new DecorationOverlayIcon(baseImage, decoratorId, IDecoration.TOP_LEFT);
        Image decoratedImage = decoratedIconId.createImage();
        myImageCache.add(decoratedImage);
        return decoratedImage;
    }
    
    private final List<Image> myImageCache = new ArrayList<Image>(2);

}