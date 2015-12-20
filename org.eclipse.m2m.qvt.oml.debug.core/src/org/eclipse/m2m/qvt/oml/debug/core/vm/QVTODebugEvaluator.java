/*******************************************************************************
 * Copyright (c) 2009,2014 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bugs 394498, 431082
 *******************************************************************************/
package org.eclipse.m2m.qvt.oml.debug.core.vm;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.m2m.internal.qvt.oml.ast.env.InternalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.evaluator.InternalEvaluator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtGenericVisitorDecorator;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtInterruptedExecutionException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitor;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtRuntimeException;
import org.eclipse.m2m.internal.qvt.oml.evaluator.TransformationInstance;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.expressions.Module;
import org.eclipse.m2m.internal.qvt.oml.expressions.OperationalTransformation;
import org.eclipse.m2m.qvt.oml.debug.core.DebugOptions;
import org.eclipse.m2m.qvt.oml.debug.core.QVTODebugCore;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResumeEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMResumeRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMStartEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMSuspendEvent;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMSuspendRequest;
import org.eclipse.m2m.qvt.oml.debug.core.vm.protocol.VMTerminateRequest;
import org.eclipse.m2m.qvt.oml.ecore.ImperativeOCL.AssignExp;
import org.eclipse.ocl.expressions.LoopExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.utilities.ASTNode;

public final class QVTODebugEvaluator extends QvtOperationalEvaluationVisitorImpl {

	private final IQVTODebuggerShell fDebugShell;
	private final VMBreakpointManager fBPM;
	private final IterateBreakpointHelper fIterateBPHelper;
	private final List<UnitLocation> fLocationStack;
	private UnitLocation fCurrentLocation;
	private int fCurrentStepMode;
	

	private QVTODebugEvaluator(QvtOperationalEvaluationVisitorImpl parent,
			QvtOperationalEvaluationEnv nestedEvalEnv) {
		super(parent, nestedEvalEnv);

		QVTODebugEvaluator debugParent = (QVTODebugEvaluator) parent;
		fDebugShell = debugParent.fDebugShell;
		fBPM = debugParent.fBPM;
		fIterateBPHelper = debugParent.fIterateBPHelper;
		fLocationStack = debugParent.fLocationStack;
		fCurrentLocation = debugParent.fCurrentLocation;
		fCurrentStepMode = debugParent.fCurrentStepMode;
	}

	public QVTODebugEvaluator(QvtOperationalEnv env,
			QvtOperationalEvaluationEnv evalEnv, IQVTODebuggerShell shell) {
		super(env, evalEnv);

		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentLocation = null;
		fCurrentStepMode = DebugEvent.UNSPECIFIED;


		fDebugShell.sessionStarted(this);

		VMRequest request = null; 
		try {
			// suspend to let others to wake up us on demand
			QVTODebugCore.TRACE.trace(DebugOptions.EVALUATOR,
			"Debug evaluator going to initial SUSPEND state"); //$NON-NLS-1$
			
			request = shell.waitAndPopRequest(new VMStartEvent(getMainModuleName(), true));
		} catch (InterruptedException e) {
			Thread.interrupted();
			terminate();
		}
		
		if(request instanceof VMResumeRequest == false) {
			// TODO - decide a set of request we can handle during initial SUSPEND mode,
			// or report fError
			terminate();
		}
	}

	public QvtOperationalEvaluationVisitor createDebugInterceptor() {
		return new DebugInterceptor(this);
	}
	
	@Override
	protected InternalEvaluator createNestedEvaluationVisitor(
			QvtOperationalEvaluationVisitorImpl parent,
			QvtOperationalEvaluationEnv nestedEvalEnv) {
		return new QVTODebugEvaluator(parent, nestedEvalEnv).createInterruptibleVisitor();
	}
	
	@Override
	protected void poppedStack() {
		popLocation();
	}
		
	@Override
	protected void pushedStack(QvtOperationalEvaluationEnv env) {
		InternalEvaluationEnv internEnv = env.getAdapter(InternalEvaluationEnv.class);
		ASTNode currentIP = (ASTNode) internEnv.getCurrentIP();

		UnitLocation startLocation = newLocalLocation(env, currentIP, currentIP.getStartPosition(), 
				currentIP.getEndPosition() - currentIP.getStartPosition());

		pushLocation(startLocation);
	}


	@Override
	protected void addToEnv(String varName, Object value, EClassifier declaredType) {
		getOperationalEvaluationEnv().add(varName, value, declaredType);
	}

	@Override
	protected void replaceInEnv(String varName, Object value, EClassifier declaredType) {
		getOperationalEvaluationEnv().replace(varName, value, declaredType);
	}

	@Override
	protected void processDeferredTasks() {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
		TransformationInstance transformation = evalEnv.getAdapter(
				InternalEvaluationEnv.class).getCurrentTransformation();
		Module module = transformation.getModule();
		UnitLocation startLocation = newLocalLocation(evalEnv, module, module
				.getEndPosition(), 0);
		try {
			pushLocation(startLocation);

			super.processDeferredTasks();
		} finally {
			popLocation();
		}
	}

	@Override
	public void notifyAfterDeferredAssign(AssignExp asssignExp,
			Object assignLeftValue) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();

		UnitLocation startLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition(), getNodeLength(asssignExp));
		setCurrentLocation(asssignExp, startLocation, false);

		processDebugRequest(startLocation);

		UnitLocation endLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition() + getNodeLength(asssignExp) - 1,
				1);
		setCurrentLocation(asssignExp, endLocation, true);
	}

	public Object navigateProperty(EStructuralFeature property, Object target) {
		OCLExpression<EClassifier> body = getPropertyBody(property);
		if (body != null) {
			return super.navigate(property, body, target);
		}
		return getEvaluationEnvironment().navigateProperty(property, null, target);
	}

	@Override
	public Object visitVariable(Variable<EClassifier, EParameter> vd) {
		Object result = super.visitVariable(vd);

		EClassifier declaredType = vd.getType();
		String name = vd.getName();
		QvtOperationalEvaluationEnv env = getOperationalEvaluationEnv();
		env.replace(name, env.getValueOf(name), declaredType);

		return result;
	}

	public List<UnitLocation> getLocationStack() {
		return fLocationStack;
	}

	
	protected Object preElementVisit(ASTNode element) {
		setCurrentEnvInstructionPointer(element);
		
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
		
		if (element instanceof Module) {
			fCurrentLocation = newLocalLocation(evalEnv, element, element
					.getStartPosition(), getNodeLength(element));
		} else if (element instanceof ImperativeOperation) {
			// nothing to do before visit
			// only end location visit supported
		} else if (element instanceof EStructuralFeature) {
			// result = null;
		} else if (element instanceof LoopExp<?, ?>) {
			@SuppressWarnings("unchecked")
			LoopExp<EClassifier, EParameter> loop = (LoopExp<EClassifier, EParameter>) element;

			UnitLocation topLocation = getCurrentLocation();
			boolean skipIterate = (fCurrentStepMode == DebugEvent.UNSPECIFIED)
					|| ((fCurrentStepMode == DebugEvent.STEP_OVER) && 
						(topLocation.getStackDepth() > fCurrentLocation.getStackDepth()));

			if (!skipIterate) {
				return fIterateBPHelper.stepIterateElement(loop, topLocation);
			}
			
		} else if (ValidBreakpointLocator.isBreakpointableElementStart(element)) {
			UnitLocation startLocation = newLocalLocation(evalEnv, element,
					element.getStartPosition(), getNodeLength(element));

			setCurrentLocation(element, startLocation, false);
			// FIXME - review, should process the debug request in all cases
			processDebugRequest(startLocation);

		} else {
			setCurrentLocation(element, newLocalLocation(evalEnv, element,
					element.getStartPosition(), getNodeLength(element)),
					false);
		}

		return result;
	}

	protected Object postElementVisit(ASTNode element, Object preState, Object result) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();
		if (element instanceof Module) {
			// 
		} else if (element instanceof ImperativeOperation) {
			UnitLocation endLocation = newLocalLocation(evalEnv, element,
					element.getStartPosition() + getNodeLength(element), 1);
			setCurrentLocation(element, endLocation, true);
		} else if (element instanceof EStructuralFeature) {
			// result = null;
		} else if (element instanceof LoopExp<?, ?>) {
			if (preState instanceof VMBreakpoint) {
				fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
			}
		} else {
			UnitLocation el = newLocalLocation(
					evalEnv, element, element
							.getStartPosition()
							+ getNodeLength(element) - 1, 1);
			
			setCurrentLocation(element, el, true);
		}

		return result;
	}




	private void processDebugRequest(UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}
	
	private void doProcessRequest(UnitLocation location, VMRequest request) {
		if (request instanceof VMResumeRequest) {
			VMResumeRequest resumeRequest = (VMResumeRequest) request;
			fCurrentLocation = getCurrentLocation();
			fCurrentStepMode = resumeRequest.detail;
			if (fCurrentStepMode == DebugEvent.UNSPECIFIED) {
				fIterateBPHelper.removeAllIterateBreakpoints();
			}
		} else if (request instanceof VMSuspendRequest) {
			VMSuspendRequest suspendRequest = (VMSuspendRequest) request;
			suspendAndWaitForResume(location, suspendRequest.detail);
		} else if (request instanceof VMTerminateRequest) {
			terminate();
		} else {
			throw new IllegalArgumentException(
					"Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	
	protected void handleLocationChanged(ASTNode element, UnitLocation location, boolean isElementEnd) {
		if (fCurrentLocation == null) {
			return;
		}
		
		if(false == (!isElementEnd ? ValidBreakpointLocator.isBreakpointableElementStart(element) : 
			ValidBreakpointLocator.isBreakpointableElementEnd(element))) {
			return;
		}

		switch (fCurrentStepMode) {
		case DebugEvent.STEP_OVER:
			if (location.getStackDepth() <= fCurrentLocation.getStackDepth()
					&& (!location.isTheSameLine(fCurrentLocation)
						/*|| repeatedInIterator(location, fCurrentLocation)*/ )) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_INTO:
			if (!location.isTheSameLine(fCurrentLocation) /*|| repeatedInIterator(location, fCurrentLocation)*/) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_RETURN:
			if (location.getStackDepth() < fCurrentLocation.getStackDepth()) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		}

		// check if we trigger a registered breakpoint
		for (VMBreakpoint breakpoint : fBPM.getBreakpoints(element)) {			
			if (breakpoint.getLineNumber() != location.getLineNum()) {
				 //TODO - faster to indicate in and or beginning enablement in VMBreakpoint ?
				//|| !((!isElementEnd) ? ValidBreakpointLocator.isBreakpointableElementStart(element) : 
					//ValidBreakpointLocator.isBreakpointableElementEnd(element))) {
				// no breakpoint can be triggered
				continue;
			}
					
			Boolean isTriggered = null;
			try {
				isTriggered = Boolean.valueOf(breakpoint.hitAndCheckIfTriggered(this));
			} catch(CoreException e) {
				IStatus status = e.getStatus();
				String reason = null; //$NON-NLS-1$
				if(status.getCode() == ConditionChecker.ERR_CODE_COMPILATION) {
					reason = "Breakpoint condition compilation failed";
				} else if(status.getCode() == ConditionChecker.ERR_CODE_EVALUATION) {
					reason = "Breakpoint condition evaluation failed";
				}
				
				if(reason != null) {
					// breakpoint condition parsing or evaluation failed, notify the debug client
					VMSuspendEvent suspendOnBpConditionErrr = createVMSuspendEvent(VMSuspendEvent.BREAKPOINT_CONDITION_ERR);
					suspendOnBpConditionErrr.setBreakpointID(breakpoint.getID());
					suspendOnBpConditionErrr.setReason(reason, status.getMessage());
					// suspend VM and wait for resolution by the debug client
					suspendAndWaitForResume(location, suspendOnBpConditionErrr);
				} else {
					QVTODebugCore.log(e.getStatus());
				}
				
				continue;
			}
			
			if (Boolean.TRUE.equals(isTriggered)) {
				boolean isIterateBp = fIterateBPHelper.isIterateBreakpoint(breakpoint);
				int eventDetail = isIterateBp ? fCurrentStepMode : DebugEvent.BREAKPOINT;
				
				// let the VM suspend and wait for resume request
				suspendAndWaitForResume(location, eventDetail);

				if (isIterateBp) {
					fBPM.removeBreakpoint(breakpoint);
				}
			}
		}
		
	}

	private VMSuspendEvent createVMSuspendEvent(int eventDetail) {
		// build the VM stack frames
		VMStackFrame[] vmStack = VMStackFrame.create(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, eventDetail);
	}
	
	private void suspendAndWaitForResume(UnitLocation location, int eventDetail) {
		suspendAndWaitForResume(location, createVMSuspendEvent(eventDetail));
	}
	
	private void suspendAndWaitForResume(UnitLocation location, VMSuspendEvent suspendEvent) {		
		try {			
			VMSuspendEvent vmSuspend = suspendEvent;
			
			// send to the client runner, wait for resume
			VMRequest nextRequest = fDebugShell.waitAndPopRequest(vmSuspend);			
			assert nextRequest != null;
			
			if(nextRequest instanceof VMResumeRequest) {
				fDebugShell.handleVMEvent(new VMResumeEvent());
			}

			doProcessRequest(location, nextRequest);
			
		} catch (InterruptedException e) {
			terminate();
		}
	}

	private UnitLocation newLocalLocation(QvtOperationalEvaluationEnv evalEnv,
			ASTNode node, int offset, int length) {
		return new UnitLocation(offset, evalEnv, node);
	}

	private void setCurrentLocation(ASTNode element, UnitLocation newLocation,
			boolean atEnd) {
		if (fLocationStack.isEmpty()) {
			return;
		}

		// do not change to position-less locations
		if (newLocation.getOffset() < 0) {
			return;
		}

		fLocationStack.set(0, newLocation);
		handleLocationChanged(element, newLocation, atEnd);
	}

	private void pushLocation(UnitLocation location) {
		fLocationStack.add(0, location);
	}

	private UnitLocation popLocation() {
		UnitLocation removed = fLocationStack.remove(0);
		return removed;
	}

	UnitLocation getCurrentLocation() {
		return (!fLocationStack.isEmpty()) ? fLocationStack.get(0) : null;
	}

	static int getNodeLength(ASTNode element) {
		return element.getEndPosition() - element.getStartPosition();
	}

	private void terminate() throws QvtInterruptedExecutionException {
		InternalEvaluationEnv currentEnv = getOperationalEvaluationEnv().getAdapter(InternalEvaluationEnv.class);
		currentEnv.throwQVTException(new QvtInterruptedExecutionException("User termination request"));
	}
	
	private String getMainModuleName() {
		CompiledUnit mainUnit = fBPM.getUnitManager().getMainUnit();
		if(mainUnit.getModules().isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		return mainUnit.getModules().get(0).getName();
	}
	
	@Override
	protected InternalEvaluator createInterruptibleVisitor() {
		return (DebugInterceptor)createDebugInterceptor();
	}
	
	private final class DebugInterceptor extends QvtGenericVisitorDecorator {
		
		private DebugInterceptor(QVTODebugEvaluator qvtExtVisitor) {
			super(qvtExtVisitor);
		}

		public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
			fCurrentLocation = newLocalLocation(getOperationalEvaluationEnv(), transformation, transformation
					.getStartPosition(), getNodeLength(transformation));
			
			return getInternalEvalDelegate().execute(transformation);
		}

		@Override
		protected Object genericPreVisitAST(ASTNode visited) {
			if (getContext().getProgressMonitor() != null && getContext().getProgressMonitor().isCanceled()) {    				
				throwQVTException(new QvtInterruptedExecutionException());    				
			}
			return preElementVisit(visited);
		}

		@Override
		protected Object genericPostVisitAST(ASTNode element, Object preVisitState, Object result) {
			return postElementVisit(element, preVisitState, result);
		}
	}

}
