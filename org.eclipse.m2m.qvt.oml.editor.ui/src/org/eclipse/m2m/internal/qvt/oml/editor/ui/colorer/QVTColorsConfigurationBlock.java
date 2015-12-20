/*******************************************************************************
 * Copyright (c) 2009, 2014 Borland Software Corporation and others.
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

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.compiler.CompiledUnit;
import org.eclipse.m2m.internal.qvt.oml.compiler.MetamodelRegistryProvider;
import org.eclipse.m2m.internal.qvt.oml.compiler.QVTOCompiler;
import org.eclipse.m2m.internal.qvt.oml.compiler.QvtCompilerOptions;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitProxy;
import org.eclipse.m2m.internal.qvt.oml.compiler.UnitResolverFactory;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.Activator;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtConfiguration;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtDocumentSetupParticipant;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.QvtEditor;
import org.eclipse.m2m.internal.qvt.oml.editor.ui.colorer.QVTColorManager.ColorDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;


class QVTColorsConfigurationBlock {

	private class ColorListLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof String) {
				return (String) element;
			}
			return ((ColorDescriptor) element).getDisplayName();
		}
	}

	private class ColorListContentProvider implements ITreeContentProvider {

		public Object[] getElements(Object inputElement) {
			return new String[] { fMain, fDocumentation, fComments };
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof String) {
				String entry = (String) parentElement;
				if (fMain.equals(entry)) {
					return fMainColors;
				} else if (fComments.equals(entry)) {
					return fCommentColors;
				} else if(fDocumentation.equals(entry)) {
					return fDocColors;
				}
			}
			return new Object[0];
		}

		public Object getParent(Object element) {
			if (element instanceof String) {
				return null;
			}
			if (fColorList.indexOf(element) < fSyntaxColorListModel.length) {
				return fMain;
			}
			return fComments;
		}

		public boolean hasChildren(Object element) {
			return element instanceof String;
		}
	}

	private final String fMain = Messages.ColorConfigBlock_QVTCategory;

	private final Object[] fMainColors;

	private final String fDocumentation = Messages.ColorConfigBlock_DocCategory;	

	private final ColorDescriptor[] fDocColors;
	
	private final String fComments = Messages.ColorConfigBlock_CommentsCategory;

	private final Object[] fCommentColors;

	private ColorSelector fSyntaxForegroundColorEditor;

	private Label fColorEditorLabel;

	private Button fBoldCheckBox;

	private Button fEnableCheckbox;

	private Button fItalicCheckBox;

	private Button fStrikethroughCheckBox;

	private Button fUnderlineCheckBox;

	private TreeViewer fTreeViewer;

	private FontMetrics fFontMetrics;

	private ColorManager fColorManager;

	private QVTColorManager fQVTColorManager;

	private QvtEditor.SrcViewer fPreviewViewer;	
	
	private List<ColorDescriptor> fColorList = new ArrayList<ColorDescriptor>();


	private String[] fSyntaxColorListModel = new String[] { IQVTColors.DEFAULT,
			IQVTColors.KEYWORD, IQVTColors.STRING, IQVTColors.NUMBER,
			IQVTColors.MODEL_PARAMETER, IQVTColors.RESULT_VARIABLE,
			IQVTColors.SELF_VARIABLE, IQVTColors.MODULE_ELEMENT,
			IQVTColors.USER_MODEL_ELEMENT, IQVTColors.STDLIB_ELEMENT,
			IQVTColors.INTERMEDIATE_DATA, IQVTColors.FATAL_ASSERT, };

	private String[] fDocColorListModel = new String[] { 
			IQVTColors.DOC_TAG,
			IQVTColors.DOC_OTHERS };
	
	private String[] fCommentColorListModel = new String[] {
			IQVTColors.MULTILINE_COMMENT, 
			IQVTColors.LINE_COMMENT,
			IQVTColors.TASK_TAG, };

	private IPreferenceStore fStore;

	public QVTColorsConfigurationBlock(OverlayPreferenceStore store) {
		fStore = store;
		fColorManager = new ColorManager(false);
		fQVTColorManager = new QVTColorManager(fStore, fColorManager);

		for (String nextKey : fSyntaxColorListModel) {
			ColorDescriptor color = fQVTColorManager.getColor(nextKey);
			if(color != null) {
				fColorList.add(color);
			} else {
				// FIXME - go to error log
				System.err.println("Missing syntax color key: " + nextKey); //$NON-NLS-1$
			}
		}
		
		fMainColors = fColorList.toArray();
		for (String nextKey: fCommentColorListModel) {
			ColorDescriptor color = fQVTColorManager.getColor(nextKey);
			if(color != null) {
				fColorList.add(color);
			}
		}
		fCommentColors = fColorList.subList(fSyntaxColorListModel.length,
				fColorList.size()).toArray(
				new ColorDescriptor[fCommentColorListModel.length]);

		for (String nextKey: fDocColorListModel) {
			ColorDescriptor color = fQVTColorManager.getColor(nextKey);
			if(color != null) {
				fColorList.add(color);
			}
		}
		fDocColors = fColorList.subList(
				fSyntaxColorListModel.length + fDocColorListModel.length + 1,
				fColorList.size()).toArray(
				new ColorDescriptor[fDocColorListModel.length]);
		
		store.addKeys(createOverlayStoreKeys());
	}

	private OverlayPreferenceStore.OverlayKey[] createOverlayStoreKeys() {
		ArrayList<OverlayPreferenceStore.OverlayKey> overlayKeys = new ArrayList<OverlayPreferenceStore.OverlayKey>();

		for (int i = 0, n = fColorList.size(); i < n; i++) {
			ColorDescriptor item = fColorList.get(i);
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.STRING, item.getColorKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getBoldKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item.getItalicKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item
					.getStrikethroughKey()));
			overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item
					.getUnderlineKey()));

			if (item.canBeDisabled()) {
				overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, item
						.getEnabledKey()));
			}
		}

		OverlayPreferenceStore.OverlayKey[] keys = new OverlayPreferenceStore.OverlayKey[overlayKeys.size()];
		overlayKeys.toArray(keys);
		return keys;
	}

	/**
	 * Creates page for hover preferences
	 */
	public Control createControl(Composite parent) {
		initializeDialogUnits(parent);

		return createSyntaxPage(parent);
	}

	/**
	 * Returns the number of pixels corresponding to the width of the given number of characters. <p>This method may only be called after <code>initializeDialogUnits</code> has been called.</p><p>Clients may call this framework method, but should not override it.</p>
	 */
	private int convertWidthInCharsToPixels(int chars) {
		// test for failure to initialize for backward compatibility
		if (fFontMetrics == null) {
			return 0;
		}
		return Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
	}

	/**
	 * Returns the number of pixels corresponding to the height of the given number of characters. <p>This method may only be called after <code>initializeDialogUnits</code> has been called.</p> <p>Clients may call this framework method, but should not override it.</p>
	 */
	private int convertHeightInCharsToPixels(int chars) {
		// test for failure to initialize for backward compatibility
		if (fFontMetrics == null) {
			return 0;
		}
		return Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
	}

	public void initialize() {
		fTreeViewer.setInput(fColorList);
		fTreeViewer.setSelection(new StructuredSelection(fMain));
	}

	public void performDefaults() {
		handleSyntaxColorListSelection();

		// FIXME ?
		//fPreviewViewer.invalidateTextPresentation();
	}

	public void dispose() {
		fQVTColorManager.dispose();
		fColorManager.dispose();
	}

	private void handleSyntaxColorListSelection() {
		ColorDescriptor item = getColorDescriptor();
		if (item == null) {
			fEnableCheckbox.setEnabled(false);
			fSyntaxForegroundColorEditor.getButton().setEnabled(false);
			fColorEditorLabel.setEnabled(false);
			fBoldCheckBox.setEnabled(false);
			fItalicCheckBox.setEnabled(false);
			fStrikethroughCheckBox.setEnabled(false);
			fUnderlineCheckBox.setEnabled(false);
			return;
		}
		RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), item.getColorKey());
		fSyntaxForegroundColorEditor.setColorValue(rgb);
		fBoldCheckBox.setSelection(getPreferenceStore().getBoolean(item.getBoldKey()));
		fItalicCheckBox.setSelection(getPreferenceStore().getBoolean(item.getItalicKey()));
		fStrikethroughCheckBox.setSelection(getPreferenceStore().getBoolean(item.getStrikethroughKey()));
		fUnderlineCheckBox.setSelection(getPreferenceStore().getBoolean(item.getUnderlineKey()));
		if (item.canBeDisabled()) {
			fEnableCheckbox.setEnabled(true);
			boolean enable = getPreferenceStore().getBoolean(item.getEnabledKey());
			fEnableCheckbox.setSelection(enable);
			fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
			fColorEditorLabel.setEnabled(enable);
			fBoldCheckBox.setEnabled(enable);
			fItalicCheckBox.setEnabled(enable);
			fStrikethroughCheckBox.setEnabled(enable);
			fUnderlineCheckBox.setEnabled(enable);
		} else {
			fSyntaxForegroundColorEditor.getButton().setEnabled(true);
			fColorEditorLabel.setEnabled(true);
			fBoldCheckBox.setEnabled(true);
			fItalicCheckBox.setEnabled(true);
			fStrikethroughCheckBox.setEnabled(true);
			fUnderlineCheckBox.setEnabled(true);
			fEnableCheckbox.setEnabled(false);
			fEnableCheckbox.setSelection(true);
		}
	}

	private Button createCheckBox(Composite composite, String text) {
		Button result = new Button(composite, SWT.CHECK);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).indent(20, 0).span(2, 1).applyTo(result);
		result.setText(text);
		return result;
	}

	private Control createSyntaxPage(final Composite parent) {
		final Composite colorComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().hint(100, 100).applyTo(colorComposite);
		GridLayoutFactory.fillDefaults().applyTo(colorComposite);

		createHeader(colorComposite);

		Label label = new Label(colorComposite, SWT.LEFT);
		label.setText(Messages.ColorConfigBlock_Element);
		label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		createEditorControls(colorComposite);

		label= new Label(colorComposite, org.eclipse.swt.SWT.LEFT);
		label.setText(Messages.ColorConfigBlock_Preview);
		label.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL));

		Control previewer= createPreviewer(colorComposite);
		GridData gd= new org.eclipse.swt.layout.GridData(GridData.FILL_BOTH);
		gd.widthHint= convertWidthInCharsToPixels(35);
		gd.heightHint= convertHeightInCharsToPixels(25);
		previewer.setLayoutData(gd);

		return colorComposite;
	}

	private void createEditorControls(final Composite colorComposite) {
		Composite editorComposite = new Composite(colorComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(editorComposite);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(editorComposite);

		createViewer(editorComposite);
		createSylesControls(editorComposite);
	}

	private void createViewer(Composite editorComposite) {
		fTreeViewer = new TreeViewer(editorComposite, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(fTreeViewer.getControl());
		fTreeViewer.setLabelProvider(new ColorListLabelProvider());
		fTreeViewer.setContentProvider(new ColorListContentProvider());
		fTreeViewer.setAutoExpandLevel(1);
		fTreeViewer.setComparator(new ViewerComparator() {
			@Override
			public int category(Object element) {
				// don't sort the top level categories
				if (fMain.equals(element)) {
					return 0;
				}
				if(fDocumentation.equals(element)) {
					return 1;
				}
				if (fComments.equals(element)) {
					return 2;
				}				
				return 0;
			}
		});
		installDoubleClickListener();

		fTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				handleSyntaxColorListSelection();
			}
		});
	}


	private void createSylesControls(Composite editorComposite) {
		Composite stylesComposite = new Composite(editorComposite, SWT.NONE);
		GridLayoutFactory.fillDefaults().numColumns(2).applyTo(stylesComposite);
		GridDataFactory.fillDefaults().align(SWT.END, SWT.BEGINNING).applyTo(stylesComposite);

		fEnableCheckbox = new Button(stylesComposite, SWT.CHECK);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).span(2, 1).applyTo(fEnableCheckbox);
		fEnableCheckbox.setText(Messages.ColorConfigBlock_Enable);

		fColorEditorLabel = new Label(stylesComposite, SWT.LEAD);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).indent(20, 1).applyTo(fColorEditorLabel);
		fColorEditorLabel.setText(Messages.ColorConfigBlock_Color);

		fSyntaxForegroundColorEditor = new ColorSelector(stylesComposite);
		GridDataFactory.fillDefaults().align(SWT.BEGINNING, SWT.CENTER).applyTo(
				fSyntaxForegroundColorEditor.getButton());

		fBoldCheckBox = createCheckBox(stylesComposite, Messages.ColorConfigBlock_FontBold);
		fItalicCheckBox = createCheckBox(stylesComposite, Messages.ColorConfigBlock_FontItalic);
		fStrikethroughCheckBox = createCheckBox(stylesComposite, Messages.ColorConfigBlock_FontStrike);
		fUnderlineCheckBox = createCheckBox(stylesComposite, Messages.ColorConfigBlock_FontUnderLine);

		fSyntaxForegroundColorEditor.getButton().addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				PreferenceConverter.setValue(getPreferenceStore(), item.getColorKey(), fSyntaxForegroundColorEditor
						.getColorValue());				
			}
		});

		fEnableCheckbox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				if (item.canBeDisabled()) {
					boolean enable = fEnableCheckbox.getSelection();
					getPreferenceStore().setValue(item.getEnabledKey(), enable);
					fEnableCheckbox.setSelection(enable);
					fSyntaxForegroundColorEditor.getButton().setEnabled(enable);
					fColorEditorLabel.setEnabled(enable);
					fBoldCheckBox.setEnabled(enable);
					fItalicCheckBox.setEnabled(enable);
					fStrikethroughCheckBox.setEnabled(enable);
					fUnderlineCheckBox.setEnabled(enable);
				}
			}
		});

		fBoldCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				getPreferenceStore().setValue(item.getBoldKey(), fBoldCheckBox.getSelection());
			}
		});

		fItalicCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				getPreferenceStore().setValue(item.getItalicKey(), fItalicCheckBox.getSelection());
			}
		});

		fStrikethroughCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				getPreferenceStore().setValue(item.getStrikethroughKey(), fStrikethroughCheckBox.getSelection());
			}
		});

		fUnderlineCheckBox.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				ColorDescriptor item = getColorDescriptor();
				getPreferenceStore().setValue(item.getUnderlineKey(), fUnderlineCheckBox.getSelection());
			}
		});
	}

	private void createHeader(final Composite colorComposite) {
		Link link = new Link(colorComposite, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, false).hint(150, SWT.DEFAULT).applyTo(link);
		link
				.setText(Messages.ColorConfigBlock_PageMainText);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PreferencesUtil.createPreferenceDialogOn(colorComposite.getShell(), e.text, null, null);
			}
		});

		addFiller(colorComposite, 1);
	}

	private void installDoubleClickListener() {
		fTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection s = (IStructuredSelection) event.getSelection();
				Object element = s.getFirstElement();
				if (fTreeViewer.isExpandable(element)) {
					fTreeViewer.setExpandedState(element, !fTreeViewer.getExpandedState(element));
				}
			}
		});
	}

	private void addFiller(Composite composite, int horizontalSpan) {
		PixelConverter pixelConverter = new PixelConverter(composite);
		Label filler = new Label(composite, SWT.LEFT);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd.horizontalSpan = horizontalSpan;
		gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
		filler.setLayoutData(gd);
	}

	private ColorDescriptor getColorDescriptor() {
		IStructuredSelection selection = (IStructuredSelection) fTreeViewer.getSelection();
		Object element = selection.getFirstElement();
		if (element instanceof String) {
			return null;
		}
		return (ColorDescriptor) element;
	}

	private void initializeDialogUnits(Control testControl) {
		// Compute and store a font metric
		GC gc = new GC(testControl);
		gc.setFont(JFaceResources.getDialogFont());
		fFontMetrics = gc.getFontMetrics();
		gc.dispose();
	}
	
	private Control createPreviewer(Composite parent) {

		IPreferenceStore store= new ChainedPreferenceStore(
				new IPreferenceStore[] {
						getPreferenceStore(),						
						Activator.getDefault().getPreferenceStore(),
						EditorsUI.getPreferenceStore()		
				} 
		);
		
		fPreviewViewer = new QvtEditor.SrcViewer(parent, null, null, false, 
				SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
				
		QvtConfiguration configuration = new QvtConfiguration(fQVTColorManager, store);
		fPreviewViewer.configure(configuration);
				
		fPreviewViewer.getTextWidget().setFont(JFaceResources.getTextFont());
		fPreviewViewer.setEditable(false);
		fPreviewViewer.getTextWidget().setCursor(
				fPreviewViewer.getTextWidget().getDisplay().getSystemCursor(
						SWT.CURSOR_ARROW));
		fPreviewViewer.getTextWidget().setCaret(null);

		URI uri = URI.createPlatformPluginURI("/org.eclipse.m2m.qvt.oml.editor.ui/preview/ColorSettingPreviewCode.qvto", true); //$NON-NLS-1$				
		IDocument document = createPreviewDocument(uri);
		new QvtDocumentSetupParticipant().setup(document);
		fPreviewViewer.configure(configuration);	
		fPreviewViewer.setDocument(document);

		final UnitProxy findUnit = UnitResolverFactory.Registry.INSTANCE.getUnit(uri);
		assert findUnit != null;
		try {			
			// TODO - log error on compilation errors
			QVTOCompiler compiler = new QVTOCompiler(new MetamodelRegistryProvider());
			final CompiledUnit compiledPreviewUnit = compiler.compile(findUnit, new QvtCompilerOptions(), new BasicMonitor());
			
			final SemanticHighlightingManager semanticHighlightingManager = new SemanticHighlightingManager() {
				@Override
				protected SemanticHighlightingReconciler createReconciler() {
					return new SemanticHighlightingReconciler() {
						@Override
						protected CompiledUnit getModel() {						
							return compiledPreviewUnit;
						}
					};
				}
			};
			
			semanticHighlightingManager.install(fPreviewViewer, fQVTColorManager, store);
			semanticHighlightingManager.getReconciler().reconciled(compiledPreviewUnit, new NullProgressMonitor());
				
			fPreviewViewer.invalidateTextPresentation();			
			hookPreviewUpdater(fPreviewViewer, store, fQVTColorManager);
			
		} catch (MdaException e) {
			Activator.log(e);
		}

		return fPreviewViewer.getControl();
	}

	/* 
	 * TODO - consider separation into a reusable updater class 
	 */
	private void hookPreviewUpdater(final SourceViewer viewer, final IPreferenceStore preferenceStore, final QVTColorManager colorManager) {
		final  org.eclipse.jface.util.IPropertyChangeListener fontChangeListener= new  org.eclipse.jface.util.IPropertyChangeListener() {
			/*
			 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
			 */
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(JFaceResources.TEXT_FONT)) {
					Font font = JFaceResources.getTextFont();
					viewer.getTextWidget().setFont(font);
				}
			}
		};
		
		final org.eclipse.jface.util.IPropertyChangeListener propertyChangeListener= new org.eclipse.jface.util.IPropertyChangeListener() {
			/*
			 * @see org.eclipse.jface.util.IPropertyChangeListener#propertyChange(org.eclipse.jface.util.PropertyChangeEvent)
			 */
			public void propertyChange(final PropertyChangeEvent event) {
				colorManager.propertyChange(event);
				viewer.invalidateTextPresentation();
			}
		};
		viewer.getTextWidget().addDisposeListener(new DisposeListener() {
			/*
			 * @see org.eclipse.swt.events.DisposeListener#widgetDisposed(org.eclipse.swt.events.DisposeEvent)
			 */
			public void widgetDisposed(DisposeEvent e) {
				preferenceStore.removePropertyChangeListener(propertyChangeListener);
				JFaceResources.getFontRegistry().removeListener(fontChangeListener);
			}
		});
		
		JFaceResources.getFontRegistry().addListener(fontChangeListener);
		preferenceStore.addPropertyChangeListener(propertyChangeListener);
	}
	
	private IDocument createPreviewDocument(URI uri) {
		StringWriter wr = new StringWriter();		
		try {
			InputStream is = URIConverter.INSTANCE.createInputStream(uri);
			InputStreamReader reader = new InputStreamReader(new BufferedInputStream(is));
			int c = 0;
			while((c = reader.read()) != -1) {
				wr.write((char)c);	
			}
			
		} catch (IOException e) {
			e.printStackTrace(new PrintWriter(wr));
		}
		
		return new Document(wr.getBuffer().toString());		
	}

	protected final IPreferenceStore getPreferenceStore() {
		return fStore;
	}

	static class PixelConverter {

		private final FontMetrics fFontMetrics;

		public PixelConverter(Control control) {
			this(control.getFont());
		}

		public PixelConverter(Font font) {
			GC gc = new GC(font.getDevice());
			gc.setFont(font);
			fFontMetrics = gc.getFontMetrics();
			gc.dispose();
		}

		public int convertHeightInCharsToPixels(int chars) {
			return Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
		}

		public int convertHorizontalDLUsToPixels(int dlus) {
			return Dialog.convertHorizontalDLUsToPixels(fFontMetrics, dlus);
		}

		public int convertVerticalDLUsToPixels(int dlus) {
			return Dialog.convertVerticalDLUsToPixels(fFontMetrics, dlus);
		}

		public int convertWidthInCharsToPixels(int chars) {
			return Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
		}
	}
}
