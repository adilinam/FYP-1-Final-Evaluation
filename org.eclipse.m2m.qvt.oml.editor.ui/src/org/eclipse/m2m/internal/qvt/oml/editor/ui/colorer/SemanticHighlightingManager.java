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


import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtConfiguration;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtConfiguration.QVTPresentationReconciler;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor.SrcViewer;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.ColorDescriptor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.Highlighting;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.IHighlightingChanged;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;

/**
 * Semantic highlighting manager
 */
public class SemanticHighlightingManager implements IPropertyChangeListener, IHighlightingChanged {

	static class HighlightedPosition extends Position {

		/**
		 * Highlighting of the position
		 */
		private Highlighting fStyle;

		/**
		 * Lock object
		 */
		private Object fLock;

		/**
		 * Initialize the styled positions with the given offset, length and foreground color.
		 */
		public HighlightedPosition(int offset, int length, Highlighting highlighting, Object lock) {
			super(offset, length);
			fStyle = highlighting;
			fLock = lock;
		}

		/**
		 * @return Returns a corresponding style range.
		 */
		public StyleRange createStyleRange() {
			int len = 0;
			if (fStyle.isEnabled())
				len = getLength();

			TextAttribute textAttribute = fStyle.getTextAttribute();
			int style = textAttribute.getStyle();
			int fontStyle = style & (SWT.ITALIC | SWT.BOLD | SWT.NORMAL);
			StyleRange styleRange = new StyleRange(getOffset(), len, textAttribute.getForeground(), textAttribute
					.getBackground(), fontStyle);
			styleRange.strikeout = (style & TextAttribute.STRIKETHROUGH) != 0;
			styleRange.underline = (style & TextAttribute.UNDERLINE) != 0;

			return styleRange;
		}

		/**
		 * Uses reference equality for the highlighting.
		 */
		public boolean isEqual(int off, int len, Highlighting highlighting) {
			synchronized (fLock) {
				return !isDeleted() && getOffset() == off && getLength() == len && fStyle == highlighting;
			}
		}

		/**
		 * Is this position contained in the given range (inclusive)? Synchronizes on position updater.
		 */
		public boolean isContained(int off, int len) {
			synchronized (fLock) {
				return !isDeleted() && off <= getOffset() && off + len >= getOffset() + getLength();
			}
		}

		public void update(int off, int len) {
			synchronized (fLock) {
				super.setOffset(off);
				super.setLength(len);
			}
		}

		@Override
		public void setLength(int length) {
			synchronized (fLock) {
				super.setLength(length);
			}
		}

		@Override
		public void setOffset(int offset) {
			synchronized (fLock) {
				super.setOffset(offset);
			}
		}

		@Override
		public void delete() {
			synchronized (fLock) {
				super.delete();
			}
		}

		@Override
		public void undelete() {
			synchronized (fLock) {
				super.undelete();
			}
		}

		/**
		 * @return Returns the highlighting.
		 */
		public Highlighting getHighlighting() {
			return fStyle;
		}

	}

	/**
	 * Highlighted ranges.
	 */
	public static class HighlightedRange extends Region {
		/**
		 * The highlighting key as returned by {@link Highlighting#getPreferenceKey()}.
		 */
		private String fKey;

		/**
		 * Initialize with the given offset, length and highlighting key.
		 */
		public HighlightedRange(int offset, int length, String key) {
			super(offset, length);
			fKey = key;
		}

		/**
		 * @return the highlighting key as returned by {@link Highlighting#getPreferenceKey()}
		 */
		public String getKey() {
			return fKey;
		}

		@Override
		public boolean equals(Object o) {
			return super.equals(o) && o instanceof HighlightedRange && fKey.equals(((HighlightedRange) o).getKey());
		}

		@Override
		public int hashCode() {
			return super.hashCode() | fKey.hashCode();
		}
	}

	/**
	 * Semantic highlighting presenter
	 */
	private SemanticHighlightingPresenter fPresenter;
	/**
	 * Semantic highlighting reconciler
	 */
	private SemanticHighlightingReconciler fReconciler;

	/**
	 * Semantic highlighting
	 */
	private ColorDescriptor[] fSemanticHighlightings;

	/**
	 * The editor
	 */
	private QvtEditor fEditor;
	/**
	 * The source viewer
	 */
	private SrcViewer fSourceViewer;
	/**
	 * The color manager
	 */
	private QVTColorManager fColorManager;
	/**
	 * The preference store
	 */
	private IPreferenceStore fPreferenceStore;
	/**
	 * The source viewer configuration
	 */
	private SourceViewerConfiguration fConfiguration;
	/**
	 * The presentation reconciler
	 */
	private QVTPresentationReconciler fPresentationReconciler;

	/**
	 * Install the semantic highlighting on the given editor infrastructure
	 */
	public void install(QvtEditor editor, SrcViewer sourceViewer, QVTColorManager colorManager, IPreferenceStore preferenceStore) {
		fEditor = editor;
		fSourceViewer = sourceViewer;
		fColorManager = colorManager;
		fPreferenceStore = preferenceStore;

		fSemanticHighlightings = colorManager.getSemanticHighlightings();

		if (fEditor != null) {
			fConfiguration = new QvtConfiguration(fEditor, colorManager, preferenceStore);
			fPresentationReconciler = (QVTPresentationReconciler) fConfiguration
					.getPresentationReconciler(fSourceViewer);
		} else {
			fConfiguration = new QvtConfiguration(colorManager, preferenceStore);
			fPresentationReconciler = (QVTPresentationReconciler) fConfiguration
					.getPresentationReconciler(fSourceViewer);			
		}
		
		if(fPreferenceStore != null) {
			fPreferenceStore.addPropertyChangeListener(this);
		}
		colorManager.addHighlightingChangedListener(this);
 
		if (isSemanticHighlightingEnabled()) {
			enable();
		}
	}

	/**
	 * Install the semantic highlighting on the given source viewer infrastructure. No reconciliation will be performed.
	 */
	public void install(SrcViewer sourceViewer, QVTColorManager colorManager, IPreferenceStore preferenceStore) {
		install(null, sourceViewer, colorManager, preferenceStore);
	}

	/**
	 * Enable semantic highlighting.
	 */
	private void enable() {
		for (int i = 0; i < fSemanticHighlightings.length; i++) {
			fSemanticHighlightings[i].createHighlighting();
		}

		fPresenter = new SemanticHighlightingPresenter();
		fPresenter.install(fSourceViewer, fPresentationReconciler);

		fReconciler = createReconciler();
		fReconciler.install(fEditor, fSourceViewer, fPresenter, fSemanticHighlightings);
	}
	
	protected SemanticHighlightingReconciler createReconciler() {
		return new SemanticHighlightingReconciler();
	}

	/**
	 * Uninstall the semantic highlighting
	 */
	public void uninstall() {
		disable();

		if (fPreferenceStore != null) {
			fPreferenceStore.removePropertyChangeListener(this);
			fPreferenceStore = null;
		}
		if (fColorManager != null) {
			fColorManager.removeHighlightingChangedListener(this);
		}

		fEditor = null;
		fSourceViewer = null;
		fColorManager = null;
		fConfiguration = null;
		fPresentationReconciler = null;
	}

	/**
	 * Disable semantic highlighting.
	 */
	private void disable() {
		if (fReconciler != null) {
			fReconciler.uninstall();
			fReconciler = null;
		}

		if (fPresenter != null) {
			fPresenter.uninstall();
			fPresenter = null;
		}
	}

	private boolean isSemanticHighlightingEnabled() {
		for (int i = 0; i < fSemanticHighlightings.length; i++) {
			String enabledKey = fSemanticHighlightings[i].getEnabledKey();
			if (fPreferenceStore != null && enabledKey != null && fPreferenceStore.getBoolean(enabledKey)) {
				return true;
			}
		}

		return false;

	}

	public void propertyChange(PropertyChangeEvent event) {
		handlePropertyChangeEvent(event);
	}

	/**
	 * Handle the given property change event
	 */
	private void handlePropertyChangeEvent(PropertyChangeEvent event) {
		if (fPreferenceStore == null)
			return; // Uninstalled during event notification

		if (fConfiguration != null) {
			// FIXME - as soon as we handle preferences!!!!
			//fConfiguration.handlePropertyChangeEvent(event);
		}

		if (affectsEnablement(fPreferenceStore, event)) {
			if (isSemanticHighlightingEnabled()) {
				enable();
				if (fReconciler != null) {
					fReconciler.refresh();
				}
			} else {
				disable();
			}
		}
	}

	public boolean affectsEnablement(IPreferenceStore store, PropertyChangeEvent event) {
		String relevantKey = null;
		ColorDescriptor[] highlightings = fSemanticHighlightings;
		for (int i = 0; i < highlightings.length; i++) {
			if (event.getProperty().equals(highlightings[i].getEnabledKey())) {
				relevantKey = event.getProperty();
				break;
			}
		}
		if (relevantKey == null)
			return false;

		for (int i = 0; i < highlightings.length; i++) {
			String key = highlightings[i].getEnabledKey();
			if (key != null && key.equals(relevantKey))
				continue;
			if (key != null && store.getBoolean(key))
				return false; // another is still enabled or was enabled before
		}

		// all others are disabled, so toggling relevantKey affects the enablement
		return true;
	}

	public void highlightingChanged(ColorDescriptor cd) {
		if (fPresenter != null && cd.getHighlighting() != null) {
			fPresenter.highlightingStyleChanged(cd.getHighlighting());
		}
		if (fReconciler != null) {
			fReconciler.refresh();
		}
	}

	public SemanticHighlightingReconciler getReconciler() {
		return fReconciler;
	}
}
