/*******************************************************************************
 * Copyright (c) 2009 Borland Software Corporation and others.
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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.m2m.internal.qvt.oml.blackbox.CompilationUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.IQVTReconcilingListener;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.ColorDescriptor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.Highlighting;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.SemanticHighlightingManager.HighlightedPosition;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;

/**
 * Semantic highlighting reconciler - Background thread implementation.
 */
class SemanticHighlightingReconciler implements IQVTReconcilingListener, ITextInputListener {

	public class PositionCollector {

		private SemanticToken fToken = new SemanticToken();

		private final QVTSemanticHighlighter fHighlighter;

		private PositionCollector(QVTSemanticHighlighter highlighter) {
			fHighlighter = highlighter;
			fHighlighter.setCollector(this);
		}

		public boolean isEnabled(int highlighting) {
			if (highlighting >= 0 && highlighting < fJobSemanticHighlightings.length) {
				ColorDescriptor semanticHighlighting = fJobSemanticHighlightings[highlighting];
				Highlighting hl = semanticHighlighting.getHighlighting();
				return hl.isEnabled();
			}
			return false;
		}

		private boolean isValidNode(CSTNode node) {
			int offset = node.getStartOffset();
			return !(offset == 0 && node.eContainer() != null);
		}
		
		public boolean visitToken(CSTNode node, int highlighting) {
			if(!isValidNode(node)) {
				return false;
			}
			
			fToken.update(node, null);

			if (highlighting >= 0 && highlighting < fJobSemanticHighlightings.length) {
				ColorDescriptor semanticColor = fJobSemanticHighlightings[highlighting];
				Highlighting hl = semanticColor.getHighlighting();
				if (hl.isEnabled()) {
					int offset = node.getStartOffset();
					int length = node.getEndOffset() - offset + 1;
					if (offset > -1 && length > 0) {
						addPosition(offset, length, hl);
					}
				}
			}
			fToken.clear();
			return false;
		}
		
		public boolean visitToken(CSTNode node, int offset, int length, int highlighting) {
			if(!isValidNode(node)) {
				return false;
			}

			fToken.update(node, null);

			if (highlighting >= 0 && highlighting < fJobSemanticHighlightings.length) {
				ColorDescriptor semanticColor = fJobSemanticHighlightings[highlighting];
				Highlighting hl = semanticColor.getHighlighting();
				if (hl.isEnabled()) {
					if (offset > -1 && length > 0) {
						addPosition(offset, length, hl);
					}
				}
			}
			fToken.clear();
			return false;
		}		

		/**
		 * Add a position with the given range and highlighting if it does not exist already.
		 */
		public void addPosition(int offset, int length, Highlighting highlighting) {
			boolean isExisting = false;
			// TODO: use binary search
			for (int i = 0, n = fRemovedPositions.size(); i < n; i++) {
				HighlightedPosition position = fRemovedPositions.get(i);
				if (position == null) {
					continue;
				}
				if (position.isEqual(offset, length, highlighting)) {
					isExisting = true;
					fRemovedPositions.set(i, null);
					fNOfRemovedPositions--;
					break;
				}
			}

			if (!isExisting) {
				HighlightedPosition position = fJobPresenter.createHighlightedPosition(offset, length, highlighting);
				if (fAddedPositions.size() == 0 || fAddedPositions.get(fAddedPositions.size() - 1).offset < offset) {
					fAddedPositions.add(position);
				} else {
					int insertIndex = fAddedPositions.size();
					while (insertIndex > 0 && fAddedPositions.get(insertIndex - 1).getOffset() > offset) {
						insertIndex--;
					}
					fAddedPositions.add(insertIndex, position);
				}
			}
		}

		/**
		 * Retain the positions completely contained in the given range.
		 */
		public void retainPositions(int offset, int length) {
			// TODO: use binary search
			for (int i = 0, n = fRemovedPositions.size(); i < n; i++) {
				HighlightedPosition position = fRemovedPositions.get(i);
				if (position != null && position.isContained(offset, length)) {
					fRemovedPositions.set(i, null);
					fNOfRemovedPositions--;
				}
			}
		}

		public void enumerate(CompiledUnit unit) {
			fHighlighter.visit(unit);
		}
	}
 
	private PositionCollector fCollector;

	private QvtEditor fEditor;

	/**
	 * The semantic highlighting presenter
	 */
	private SemanticHighlightingPresenter fPresenter;
	/**
	 * Semantic highlighting
	 */
	private ColorDescriptor[] fSemanticHighlightings;

	/**
	 * Background job's added highlighted positions
	 */
	private final ArrayList<HighlightedPosition> fAddedPositions = new ArrayList<HighlightedPosition>();
	/**
	 * Background job's removed highlighted positions
	 */
	private List<HighlightedPosition> fRemovedPositions = new ArrayList<HighlightedPosition>();
	/**
	 * Number of removed positions
	 */
	private int fNOfRemovedPositions;

	/**
	 * Background job
	 */
	private Job fJob;
	/**
	 * Background job lock
	 */
	private final Object fJobLock = new Object();
	/**
	 * Reconcile operation lock
	 */
	private final Object fReconcileLock = new Object();
	/**
	 * <code>true</code> if any thread is executing
	 */
	private boolean fIsReconciling = false;

	/**
	 * The semantic highlighting presenter - cache for background thread, only valid during {@link #reconciled(CompilationUnit, boolean, IProgressMonitor)}
	 */
	private SemanticHighlightingPresenter fJobPresenter;
	/**
	 * Semantic highlightings - cache for background thread, only valid during {@link #reconciled(CompilationUnit, boolean, IProgressMonitor)}
	 */
	private ColorDescriptor[] fJobSemanticHighlightings;

	public SemanticHighlightingReconciler() {
		super();
	}
	
	public void aboutToBeReconciled() {
		// Do nothing
	}

	public void reconciled(CompiledUnit model, IProgressMonitor progressMonitor) {
		// ensure at most one thread can be reconciling at any time
		synchronized (fReconcileLock) {
			if (fIsReconciling) {
				return;
			} else {
				fIsReconciling = true;
			}
		}
		fJobPresenter = fPresenter;
		fJobSemanticHighlightings = fSemanticHighlightings;

		try {
			if (fJobPresenter == null || fJobSemanticHighlightings == null) {
				return;
			}

			fJobPresenter.setCanceled(progressMonitor.isCanceled());

			if (model == null || fJobPresenter.isCanceled()) {
				return;
			}

			startReconcilingPositions();

			if (!fJobPresenter.isCanceled()) {
				reconcilePositions(model);
			}

			TextPresentation textPresentation = null;
			if (!fJobPresenter.isCanceled()) {
				textPresentation = fJobPresenter.createPresentation(fAddedPositions, fRemovedPositions);
			}

			if (!fJobPresenter.isCanceled()) {
				updatePresentation(textPresentation, fAddedPositions, fRemovedPositions);
			}

			stopReconcilingPositions();
		} catch(RuntimeException e) {
			Activator.log(e);
		} finally {
			fJobPresenter = null;
			fJobSemanticHighlightings = null;
			synchronized (fReconcileLock) {
				fIsReconciling = false;
			}
		}
	}

	/**
	 * Start reconciling positions
	 */
	private void startReconcilingPositions() {
		fJobPresenter.addAllPositions(fRemovedPositions);
		fNOfRemovedPositions = fRemovedPositions.size();
	}

	/**
	 * Reconcile positions based on the AST subtrees
	 */
	private void reconcilePositions(CompiledUnit model) {
		if (model.getUnitCST() == null || fCollector == null) {
			return;
		}
		fCollector.enumerate(model);
		List<HighlightedPosition> oldPositions = fRemovedPositions;
		List<HighlightedPosition> newPositions = new ArrayList<HighlightedPosition>(fNOfRemovedPositions);
		for (int i = 0, n = oldPositions.size(); i < n; i++) {
			HighlightedPosition current = oldPositions.get(i);
			if (current != null) {
				newPositions.add(current);
			}
		}
		fRemovedPositions = newPositions;
	}

	/**
	 * Update the presentation.
	 */
	private void updatePresentation(TextPresentation textPresentation, List<HighlightedPosition> addedPositions,
			List<HighlightedPosition> removedPositions) {
		Runnable runnable = fJobPresenter.createUpdateRunnable(textPresentation, addedPositions, removedPositions);
		if (runnable == null) {
			return;
		}

		Display display = null;		
		QvtEditor editor = fEditor;
		if (editor != null) {
			IWorkbenchPartSite site = editor.getSite();
			if (site != null) {
				Shell shell = site.getShell();
				if (shell == null || shell.isDisposed()) {
					return;
				}
				display = shell.getDisplay();			
			} 			
		}

		if(display == null) {
			display = PlatformUI.getWorkbench().getDisplay();
		}
		
		if (display == null || display.isDisposed()) {
			return;
		}

		display.asyncExec(runnable);
	}

	/**
	 * Stop reconciling positions.
	 */
	private void stopReconcilingPositions() {
		fRemovedPositions.clear();
		fNOfRemovedPositions = 0;
		fAddedPositions.clear();
	}

	/**
	 * Install this reconciler on the given editor, presenter and highlightings.
	 */
	public void install(QvtEditor editor, SourceViewer sourceViewer,
			SemanticHighlightingPresenter presenter,
			ColorDescriptor[] semanticHighlightings) {
		
		fPresenter = presenter;
		fSemanticHighlightings = semanticHighlightings;

		fEditor = editor;
		fCollector = new PositionCollector(new QVTSemanticHighlighter(semanticHighlightings));
		
		if (fEditor != null) {			
			fEditor.addReconcilingListener(this);
		}
	}

	/**
	 * Uninstall this reconciler from the editor
	 */
	public void uninstall() {
		if (fPresenter != null) {
			fPresenter.setCanceled(true);
		}

		if (fEditor != null) {
			fEditor.removeReconcilingListener(this);
			fEditor = null;
		}

		fCollector = null;
		fSemanticHighlightings = null;
		fPresenter = null;
	}

	/**
	 * Schedule a background job for retrieving the AST and reconciling the Semantic Highlighting model.
	 */
	private void scheduleJob() {
		synchronized (fJobLock) {
			final Job oldJob = fJob;
			if (fJob != null) {
				fJob.cancel();
				fJob = null;
			}

			fJob = new Job(Messages.SemanticHighlightingReconciler_JobName0) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					if (oldJob != null) {
						try {
							oldJob.join();
						} catch (InterruptedException e) {
							Activator.log(e);
							return Status.CANCEL_STATUS;
						}
					}
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					CompiledUnit model = getModel();
					reconciled(model, monitor);
					synchronized (fJobLock) {
						// allow the job to be gc'ed
						if (fJob == this) {
							fJob = null;
						}
					}
					return Status.OK_STATUS;
				}
			};
			fJob.setSystem(true);
			fJob.setPriority(Job.DECORATE);
			fJob.schedule();
		}
	}

	public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
		synchronized (fJobLock) {
			if (fJob != null) {
				fJob.cancel();
				fJob = null;
			}
		}
	}

	public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
		if (newInput != null) {
			scheduleJob();
		}
	}

	/**
	 * Refreshes the highlighting.
	 */
	public void refresh() {
		scheduleJob();
	}
	
	protected CompiledUnit getModel() {
		return fEditor.getValidCompiledModule(5000);
	}
}
