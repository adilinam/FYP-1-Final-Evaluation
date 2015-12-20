/*******************************************************************************
 * Copyright (c) 2009, 2010 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lpg.runtime.IToken;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalModuleEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.parser.IntermediateClassFactory;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.cst.AssertExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierDefCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ClassifierPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ContextualPropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.MappingDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ModulePropertyCS;
import org.eclipse.m2m.internal.qvt.oml.cst.UnitCS;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.ColorDescriptor;
import org.eclipse.m2m.internal.qvt.oml.expressions.ContextualProperty;
import org.eclipse.m2m.internal.qvt.oml.expressions.EntryOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ExpressionsPackage;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Library;
import org.eclipse.m2m.internal.qvt.oml.expressions.MappingOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.ModelParameter;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.VarParameter;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.ImperativeIterateExp;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.Typedef;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.IteratorExp;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;


class QVTSemanticHighlighter {

	private final int INDEX_NUMBERS;
	private final int INDEX_INTERM_DATA;
	private final int INDEX_MODULE_ELEMENT;
	private final int INDEX_USER_MODEL_ELEMENT;
	private final int INDEX_MODEL_PARAMETER;	
	private final int INDEX_SELF_VARIABLE;
	private final int INDEX_RESULT_VARIABLE;
	private final int INDEX_FATAL_ASSERT;
	private final int INDEX_STDLIB_ELEMENT;	
	//private final int INDEX_OPERATION_PARAMETER;
	

	private SemanticHighlightingReconciler.PositionCollector fCollector;
		
	private EPackage fOCLStdlibPckg;
	
	private Library fQVTStdlib;
	

	QVTSemanticHighlighter(ColorDescriptor[] semanticHighlightings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int i = 0;
		for (ColorDescriptor colorDescriptor : semanticHighlightings) {			
			map.put(colorDescriptor.key(), i++);
		}

		INDEX_NUMBERS = getColorIndex(QVTColorManager.NUMBER, map);
		INDEX_INTERM_DATA = getColorIndex(QVTColorManager.INTERMEDIATE_DATA, map);
		INDEX_MODULE_ELEMENT = getColorIndex(QVTColorManager.MODULE_ELEMENT, map);
		INDEX_MODEL_PARAMETER = getColorIndex(QVTColorManager.MODEL_PARAMETER, map);
		INDEX_USER_MODEL_ELEMENT = getColorIndex(QVTColorManager.USER_MODEL_ELEMENT, map);
		INDEX_STDLIB_ELEMENT = getColorIndex(QVTColorManager.STDLIB_ELEMENT, map);
		INDEX_RESULT_VARIABLE = getColorIndex(QVTColorManager.RESULT_VARIABLE, map);
		INDEX_SELF_VARIABLE = getColorIndex(QVTColorManager.SELF_VARIABLE, map);
		INDEX_FATAL_ASSERT = getColorIndex(QVTColorManager.FATAL_ASSERT, map);
		//INDEX_OPERATION_PARAMETER = getColorIndex(QVTColorManager.OPERATION_PARAMETER, map);
	}
	
	void setCollector(SemanticHighlightingReconciler.PositionCollector positionCollector) {
		fCollector = positionCollector;
	}

	protected boolean visit(CompiledUnit unit) {
		UnitCS unitCST = unit.getUnitCST();
		if(unitCST == null) {
			return false;
		}
		try {
			boolean modelOK = setModel(unit);
			if(!modelOK) {
				return false;
			}
			
			TreeIterator<EObject> allContents = unitCST.eAllContents();			
			while (allContents.hasNext()) {
				CSTNode object = (CSTNode) allContents.next();
				if(object instanceof PathNameCS) {
					PathNameCS pathNameCS = (PathNameCS) object;
					visit(pathNameCS);
				} else if(object instanceof SimpleNameCS) {
					visit((SimpleNameCS) object);
				} else if(object instanceof IntegerLiteralExpCS) {
					visit((IntegerLiteralExpCS) object);
				} else if(object instanceof RealLiteralExpCS) {
					visit((RealLiteralExpCS) object); 						
				} else if(object instanceof FeatureCallExpCS) {
					visit((FeatureCallExpCS) object);
				} else if(object instanceof ClassifierDefCS) {
					visit((ClassifierDefCS) object);
				} else if(object instanceof VariableExpCS) {
					visit((VariableExpCS)object);
				} else if(object instanceof MappingDeclarationCS) {
					visit((MappingDeclarationCS) object);
				} else if(object instanceof AssertExpCS) {
					visit((AssertExpCS) object);
				} else if(object instanceof ModulePropertyCS) {
					visit((ModulePropertyCS) object);
				} else if(object instanceof IteratorExpCS) {
					visit((IteratorExpCS) object);
				} else if(object instanceof ImperativeIterateExpCS) {
					visit((ImperativeIterateExpCS) object);
				}
			}			
		} finally {
			setModel(null);			
		}
		
		return false;
	}
	
	protected boolean visit(MappingDeclarationCS n) {
		SimpleNameCS simpleNameCS = n.getSimpleNameCS();
		if(n.getAst() instanceof EntryOperation) {
			return false;
		}

		return fCollector.visitToken(simpleNameCS, INDEX_MODULE_ELEMENT);
	}
	
	
	protected boolean visit(SimpleNameCS n) {
		Object ast = n.getAst();
		if(ast instanceof EClassifier) {
			EClassifier type = (EClassifier) ast;
			if(type.eClass() == org.eclipse.ocl.ecore.EcorePackage.eINSTANCE.getVoidType()) {
				// may be unresolved type
				return false;
			}
			
			if(isStdlibElement(type)) {
				if(type instanceof CollectionType == false) {
					return fCollector.visitToken(n, INDEX_STDLIB_ELEMENT);
				}
			} else if(type instanceof Module && 
					n.eContainingFeature() != org.eclipse.ocl.cst.CSTPackage.eINSTANCE.getPathNameCS_SimpleNames()) {
				return fCollector.visitToken(n, INDEX_MODULE_ELEMENT);					
			} else if(type.eClass().getEPackage() != ExpressionsPackage.eINSTANCE) {
				return fCollector.visitToken(n, INDEX_USER_MODEL_ELEMENT);				
			} 
		} else if(ast instanceof EEnumLiteral) {
			return fCollector.visitToken(n, INDEX_USER_MODEL_ELEMENT);
		} else if(ast instanceof EPackage) {
			if(isStdlibElement((EPackage)ast)) {
				return fCollector.visitToken(n, INDEX_STDLIB_ELEMENT);
			} else {
				return fCollector.visitToken(n, INDEX_USER_MODEL_ELEMENT);
			}
		}
		
		if(ast instanceof ModelParameter) {
			return fCollector.visitToken(n, INDEX_MODEL_PARAMETER);			
		}

		return false;
	}
	
	protected boolean visit(PathNameCS n) {
		EClassifier type = null;
		Object ast = n.getAst();
		type = toType(type, ast);
		
		if(type != null) {
			if(type instanceof PrimitiveType) {
				return fCollector.visitToken(n, INDEX_STDLIB_ELEMENT);
			} else {
				if (type instanceof EClass
						&& IntermediateClassFactory.isIntermediateClass(type)) {
					return fCollector.visitToken(n, INDEX_INTERM_DATA);
				}
			}
		}
		
		return false;
	}

	protected boolean visit(FeatureCallExpCS callCS) {
		SimpleNameCS nameCS = callCS.getSimpleNameCS();
		if(nameCS == null) {
			return false;
		}
		
		Object ast = nameCS.getAst();		
		if(ast instanceof EOperation) {
			EOperation operation = (EOperation) ast;
			if(operation instanceof MappingOperation) {
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_MODULE_ELEMENT);
			} else if(operation instanceof ImperativeOperation) {
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_MODULE_ELEMENT);				
			}
			
			if(isStdlibElement(operation)) {
				int operCode = OCLStandardLibraryUtil.getOperationCode(operation.getName());
				switch(operCode) {
				case PredefinedType.NOT:
				case PredefinedType.OR:
				case PredefinedType.AND:
				case PredefinedType.XOR:
				case PredefinedType.DIVIDE:
				case PredefinedType.EQUAL:
				case PredefinedType.NOT_EQUAL:
				case PredefinedType.GREATER_THAN:
				case PredefinedType.GREATER_THAN_EQUAL:
				case PredefinedType.LESS_THAN:
				case PredefinedType.LESS_THAN_EQUAL:
				case PredefinedType.MINUS:
				case PredefinedType.PLUS:
				case PredefinedType.TIMES:
					return false;					
				}
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_STDLIB_ELEMENT);
			}
		} else if(ast instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) ast;
			if(IntermediateClassFactory.isIntermediateClass(feature.getEContainingClass())) {
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_INTERM_DATA);
			} else if(ast instanceof ContextualProperty) {
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_INTERM_DATA);
			}
			
			if(feature.getEContainingClass().eClass() == EcorePackage.eINSTANCE.getEClass()) {
				return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_USER_MODEL_ELEMENT);	
			}
			return fCollector.visitToken(callCS.getSimpleNameCS(), INDEX_MODULE_ELEMENT);
		}
		
		return true;
	}
	
	protected boolean visit(ClassifierDefCS classifierDefCS) {
		for(ClassifierPropertyCS next : classifierDefCS.getProperties()) {
			fCollector.visitToken(next.getSimpleNameCS(), INDEX_INTERM_DATA);
		}
		return fCollector.visitToken(classifierDefCS.getSimpleNameCS(), INDEX_INTERM_DATA);
	}

	protected boolean visit(ImperativeIterateExpCS iteratorExpCS) {
		IToken endToken = iteratorExpCS.getEndToken();
		if(endToken != null && "]".equals(endToken.toString())) { //$NON-NLS-1$
			return false;
		}
		Object ast = iteratorExpCS.getAst();
		if(ast instanceof ImperativeIterateExp) {			
			return fCollector.visitToken(iteratorExpCS.getSimpleNameCS(), INDEX_STDLIB_ELEMENT);
		}
		return false;		
	}
	
	protected boolean visit(IteratorExpCS iteratorExpCS) {
		Object ast = iteratorExpCS.getAst();
		if(ast instanceof IteratorExp) {
			return fCollector.visitToken(iteratorExpCS.getSimpleNameCS(), INDEX_STDLIB_ELEMENT);
		}
		return false;
	}
	protected boolean visit(ModulePropertyCS propertyCS) {
		SimpleNameCS simpleNameCS = propertyCS.getSimpleNameCS();
		if(simpleNameCS != null) {
			if (propertyCS instanceof ContextualPropertyCS
					|| propertyCS instanceof ClassifierPropertyCS) {
				return fCollector.visitToken(simpleNameCS, INDEX_INTERM_DATA);
			}
			return fCollector.visitToken(simpleNameCS, INDEX_MODULE_ELEMENT);
		}
		return false;
	}
	
	protected boolean visit(VariableExpCS variableExpCS) {
		SimpleNameCS simpleNameCS = variableExpCS.getSimpleNameCS();
		Object ast = simpleNameCS.getAst();
		if(ast instanceof ModelParameter) {
			fCollector.visitToken(simpleNameCS, INDEX_MODEL_PARAMETER);
		} else if(ast instanceof VarParameter) {
			final String varName = simpleNameCS.getValue();
			if("self".equals(varName)) { //$NON-NLS-1$
				fCollector.visitToken(simpleNameCS, INDEX_SELF_VARIABLE);
			} else if("result".equals(varName)) { //$NON-NLS-1$
				fCollector.visitToken(simpleNameCS, INDEX_RESULT_VARIABLE);
			}
		} else if(ast instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) ast;
			EClass ownerClass = feature.getEContainingClass();
			
			if(feature instanceof ContextualProperty || 
					IntermediateClassFactory.isIntermediateClass(ownerClass)) {
				return fCollector.visitToken(simpleNameCS, INDEX_INTERM_DATA);
			} else if(ownerClass.eClass() == EcorePackage.eINSTANCE.getEClass()) {
				return fCollector.visitToken(simpleNameCS, INDEX_USER_MODEL_ELEMENT);	
			}
			
			return fCollector.visitToken(simpleNameCS, INDEX_MODULE_ELEMENT);
		}

		return false;
	}
	
	protected boolean visit(AssertExpCS assertExpCS) {
		SimpleNameCS severity = assertExpCS.getSeverity();
		if(severity != null && "fatal".equals(severity.getValue())) { //$NON-NLS-1$
			return fCollector.visitToken(severity, INDEX_FATAL_ASSERT);
		}
		return false;
	}
	
	protected boolean visit(IntegerLiteralExpCS n) {
		return fCollector.visitToken(n, INDEX_NUMBERS);
	}

	protected boolean visit(RealLiteralExpCS n) {
		return fCollector.visitToken(n, INDEX_NUMBERS);
	}	
	
	private int getColorIndex(String colorKey, Map<String, Integer> map) {
		Integer index = map.get(colorKey);
		return index != null ? index.intValue() : -1;
	}	
	
	private boolean isStdlibElement(EClassifier type) {
		EPackage ePackage = type.getEPackage();
		return ePackage != null && isStdlibElement(ePackage) || type instanceof PredefinedType<?>;
	}
	
	private boolean isStdlibElement(EPackage ePackage) {
		EObject root = EcoreUtil.getRootContainer(ePackage);		
		return root == fQVTStdlib || root == fOCLStdlibPckg;
	}
	
	private boolean isStdlibElement(EOperation operation) {
		EClass eClass = operation.getEContainingClass();
		return eClass != null && isStdlibElement(eClass);
	}
		
	private boolean setModel(CompiledUnit model) {
		if(model != null) {
			List<QvtOperationalModuleEnv> envList = model.getModuleEnvironments();
			// get standard library instances from any of the available environments 
			if(envList != null && !envList.isEmpty()) {
				QvtOperationalModuleEnv env = envList.get(0);
				fQVTStdlib = env.getQVTStandardLibrary().getStdLibModule();
				fOCLStdlibPckg = env.getOCLStandardLibrary().getBoolean().getEPackage();
			} else {
				// NO stdlib available
				return false;
			}
		} else {
			fQVTStdlib = null;
			fOCLStdlibPckg = null;
		}

		return true;
	}
	
	private EClassifier toType(EClassifier type, Object ast) {
		if(ast instanceof Typedef) {
			type = ((Typedef) ast).getBase();
		} else if(ast instanceof EClassifier) {
			type = (EClassifier) ast; 
		}
		return type;
	}
	
}
