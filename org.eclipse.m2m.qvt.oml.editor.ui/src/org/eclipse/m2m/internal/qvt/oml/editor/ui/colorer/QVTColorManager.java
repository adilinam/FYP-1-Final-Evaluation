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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;


public class QVTColorManager extends IQVTColors {

	public interface IHighlightingChanged {

		void highlightingChanged(ColorDescriptor cd);
	}

	public class ColorDescriptor {

		private TextAttribute fAttribute;

		private Highlighting fHighlighting;

		private Token fToken;

		private final String fDisplayName;

		private final String fEnabledKey;

		private final String fBoldKey;

		private final String fItalicKey;

		private final String fColorKey;

		private final String fStrikethroughKey;

		private final String fUnderlineKey;
		
		private final String fKey;		

		public ColorDescriptor(String key, String displayName, boolean canBeDisabled) {
			fKey = key;
			String baseKey = BASE_COLORS_KEY_PREFIX + key;
			fDisplayName = displayName;

			fBoldKey = baseKey + BOLD_SUFFIX;
			fItalicKey = baseKey + ITALIC_SUFFIX;
			fColorKey = baseKey + COLOR_SUFFIX;
			fStrikethroughKey = baseKey + STRIKETHROUGH_SUFFIX;
			fUnderlineKey = baseKey + UNDERLINE_SUFFIX;
			fEnabledKey = canBeDisabled ? baseKey + ENABLED_SUFFIX : null;
		}

		public String key() {
			return fKey;
		}
		
		public boolean canBeDisabled() {
			return fEnabledKey != null;
		}

		public String getDisplayName() {
			return fDisplayName;
		}

		public String getEnabledKey() {
			return fEnabledKey;
		}

		public String getBoldKey() {
			return fBoldKey;
		}

		public String getItalicKey() {
			return fItalicKey;
		}

		public String getStrikethroughKey() {
			return fStrikethroughKey;
		}

		public String getUnderlineKey() {
			return fUnderlineKey;
		}

		public String getColorKey() {
			return fColorKey;
		}

		public Highlighting getHighlighting() {
			return fHighlighting;
		}

		public boolean isAffectedBy(String property) {
			return property.equals(getColorKey()) || property.equals(getBoldKey()) || property.equals(getEnabledKey())
					|| property.equals(getItalicKey()) || property.equals(getStrikethroughKey())
					|| property.equals(getUnderlineKey());
		}

		/**
		 * UI thread only
		 */
		public TextAttribute createTextAttribute() {
			if (fAttribute != null) {
				return fAttribute;
			}

			addColor(getColorKey());

			int style = fStore.getBoolean(getBoldKey()) ? SWT.BOLD : SWT.NORMAL;

			if (fStore.getBoolean(getItalicKey()))
				style |= SWT.ITALIC;

			if (fStore.getBoolean(getStrikethroughKey()))
				style |= TextAttribute.STRIKETHROUGH;

			if (fStore.getBoolean(getUnderlineKey()))
				style |= TextAttribute.UNDERLINE;

			Color color = fColorManager.getColor(PreferenceConverter.getColor(fStore, getColorKey()));
			
			fAttribute = new TextAttribute(color, null, style);
			return fAttribute;
		}

		/**
		 * UI thread only
		 */
		public Highlighting createHighlighting() {
			if (fHighlighting != null) {
				return fHighlighting;
			}

			boolean isEnabled = canBeDisabled() ? fStore.getBoolean(getEnabledKey()) : true;
			fHighlighting = new Highlighting(createTextAttribute(), isEnabled);
			return fHighlighting;
		}

		public Token createToken() {
			if (fToken != null) {
				return fToken;
			}
			fToken = new Token(createTextAttribute());
			return fToken;
		}

		public void disposeColor() {
			if (fAttribute != null) {
				removeColor(getColorKey());
				fAttribute = null;
			}
		}

		public TextAttribute getTextAttribute() {
			return fAttribute;
		}

		public void setTextAttribute(TextAttribute ta) {
			fAttribute = ta;
			if (fHighlighting != null) {
				fHighlighting.setTextAttribute(ta);
			}
			if (fToken != null) {
				fToken.setData(ta);
			}
		}
	}

	public class Highlighting {

		private TextAttribute fTextAttribute;

		private boolean fIsEnabled;

		public Highlighting(TextAttribute textAttribute, boolean isEnabled) {
			setTextAttribute(textAttribute);
			setEnabled(isEnabled);
		}

		public TextAttribute getTextAttribute() {
			return fTextAttribute;
		}

		public void setTextAttribute(TextAttribute textAttribute) {
			fTextAttribute = textAttribute;
		}

		public boolean isEnabled() {
			return fIsEnabled;
		}

		public void setEnabled(boolean isEnabled) {
			fIsEnabled = isEnabled;
		}
	}

	ListenerList fColorChangedListeners = new ListenerList();

	private final List<ColorDescriptor> fDescriptors;
	
	private final Map<String, DefaultColoring> fKey2Default;

	private final Map<String, ColorDescriptor> fKey2Descriptor;


	private IPreferenceStore fStore;

	private ColorManager fColorManager;


	public QVTColorManager(IPreferenceStore store, ColorManager manager) {
		fStore = store;
		fColorManager = manager;
		fDescriptors = new ArrayList<ColorDescriptor>();
		fKey2Descriptor = new HashMap<String, ColorDescriptor>();
		fKey2Default = new HashMap<String, DefaultColoring>();
		initDescriptors();
	}
	
	void forceInitialize() {
		for (ColorDescriptor next : fDescriptors) {
			next.createToken();
		}		
	}

	public ColorDescriptor getColor(String id) {
		return fKey2Descriptor.get(id);
	}

	private int addDescriptor(String key, String name, boolean canBeDisabled, DefaultColoring defaultSettings) {
		assert key != null && name != null && defaultSettings != null;
		
		ColorDescriptor cd = new ColorDescriptor(key, name, canBeDisabled);
		fKey2Descriptor.put(key, cd);
		fDescriptors.add(cd);

		fKey2Default.put(key, defaultSettings);
		
		return fDescriptors.size();
	}

	private void initDescriptors() {
		addDescriptor(MULTILINE_COMMENT, Messages.SemanticKey_multiLineComment, false,
				new DefaultColoring(new RGB(63, 127, 95), false, true, false, false));		
		addDescriptor(LINE_COMMENT, Messages.SemanticKey_singleLineComment, false,	
				new DefaultColoring(new RGB(63, 127, 95), false, true, false, false));
		addDescriptor(TASK_TAG, Messages.SemanticKey_taskTags, false,
				new DefaultColoring(new RGB(127, 159, 191), true, false, false, false));		
		addDescriptor(DOC_OTHERS, Messages.SemanticKey_Others, true,
				new DefaultColoring(new RGB(63, 95, 191), false, false, false, false));		
		addDescriptor(DOC_TAG, Messages.SemanticKey_DocTags, true,
				new DefaultColoring(new RGB(63, 95, 191), false, false, false, false));		
		addDescriptor(FATAL_ASSERT, Messages.SemanticKey_FatalAssertion, true,
				new DefaultColoring(new RGB(255, 0, 0), false, false, false, false));
		addDescriptor(KEYWORD, Messages.SemanticKey_Keywords, false,
				new DefaultColoring(new RGB(127, 0, 85), true, false, false, false));

		addDescriptor(STRING, Messages.SemanticKey_Strings, false,
				new DefaultColoring(new RGB(42, 0, 255), false, false, false, false));
		addDescriptor(NUMBER, Messages.SemanticKey_Numbers, false,
				new DefaultColoring(new RGB(0, 128, 0), false, false, false, false));
		addDescriptor(DEFAULT, Messages.SemanticKey_Others, false,
				new DefaultColoring(new RGB(0, 0, 0), false, false, false, false));
		// TODO - no urgent now 
//		addDescriptor(VARIABLE, "Local variable", true,
//				new DefaultColoring(new RGB(13, 100, 0), false, false, false, false));		
//		addDescriptor(OPERATION_PARAMETER, "Operation parameter", true,				
//				new DefaultColoring(new RGB(13, 100, 0), false, false, false, false));
		addDescriptor(MODEL_PARAMETER, Messages.SemanticKey_ModelParameters, true,
				new DefaultColoring(new RGB(128, 128, 0), false, false, false, false));
		addDescriptor(MODULE_ELEMENT, Messages.SemanticKey_ModuleElements, true, 
				new DefaultColoring(new RGB(111, 0, 74), false, false, false, false));
		addDescriptor(RESULT_VARIABLE, Messages.SemanticKey_ResultVar, true, 
				new DefaultColoring(new RGB(0, 0, 160), true, false, false, false));
		addDescriptor(SELF_VARIABLE, Messages.SemanticKey_SelfVar, true, 
				new DefaultColoring(new RGB(0, 0, 160), true, false, false, false));
		
		addDescriptor(INTERMEDIATE_DATA, Messages.SemanticKey_IntermData, true,
				new DefaultColoring(new RGB(108, 108, 108), false, false, false, false));
		
		addDescriptor(USER_MODEL_ELEMENT, Messages.SemanticKey_UserModelElements, true,
				new DefaultColoring(new RGB(0, 0, 192), false, false, false, false));
		
		addDescriptor(STDLIB_ELEMENT, Messages.SemanticKey_StdlibElements, true,
				new DefaultColoring(new RGB(0, 0, 0), false, true, false, false));
	}

	public void initializeDefaults() {
		
		for (String nextColorKey : fKey2Default.keySet()) {
			DefaultColoring settings = fKey2Default.get(nextColorKey);
			initDefault(nextColorKey, settings);
		}
	}

	private static class DefaultColoring {
		private RGB rgb;
		private boolean bold;
		private boolean italic;
		private boolean underline;
		private boolean strikethrough;

		public DefaultColoring(RGB rgb, boolean bold, boolean italic,
				boolean underline, boolean strikethrough) {
			this.rgb = rgb;
			this.bold = bold;
			this.italic = italic;
			this.underline = underline;
			this.strikethrough = strikethrough;
		}

		public RGB getRgb() {
			return rgb;
		}

		public boolean isBold() {
			return bold;
		}

		public boolean isItalic() {
			return italic;
		}

		public boolean isUnderline() {
			return underline;
		}

		public boolean isStrikethrough() {
			return strikethrough;
		}
	}


	private void initDefault(String id, DefaultColoring defaultSettings) {
		ColorDescriptor cd = getColor(id);
		assert cd != null;
		
		PreferenceConverter.setDefault(fStore, cd.getColorKey(), defaultSettings.getRgb());
		fStore.setDefault(cd.getBoldKey(), defaultSettings.isBold());
		fStore.setDefault(cd.getItalicKey(), defaultSettings.isItalic());
		fStore.setDefault(cd.getUnderlineKey(), defaultSettings.isUnderline());
		fStore.setDefault(cd.getStrikethroughKey(), defaultSettings.isStrikethrough());
		if (cd.canBeDisabled()) {
			fStore.setDefault(cd.getEnabledKey(), true);
		}
	}

	public void dispose() {
		for (ColorDescriptor cd : fDescriptors) {
			cd.disposeColor();
		}
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (fStore == null) {
			return;
		}

		String property = event.getProperty();

		for (ColorDescriptor cd : fDescriptors) {
			if (cd.getColorKey().equals(property)) {
				adaptToTextForegroundChange(cd, event);
				notifyStyleChanged(cd);
				break;
			}

			if (cd.getBoldKey().equals(property)) {
				adaptToTextStyleChange(cd, event, SWT.BOLD);
				notifyStyleChanged(cd);
				break;
			}

			if (cd.getItalicKey().equals(property)) {
				adaptToTextStyleChange(cd, event, SWT.ITALIC);
				notifyStyleChanged(cd);
				break;
			}

			if (cd.getStrikethroughKey().equals(property)) {
				adaptToTextStyleChange(cd, event, TextAttribute.STRIKETHROUGH);
				notifyStyleChanged(cd);
				break;
			}

			if (cd.getUnderlineKey().equals(property)) {
				adaptToTextStyleChange(cd, event, TextAttribute.UNDERLINE);
				notifyStyleChanged(cd);
				break;
			}

			if (cd.canBeDisabled() && cd.getEnabledKey().equals(property)) {
				adaptToEnablementChange(cd.getHighlighting(), event);
				notifyStyleChanged(cd);
				break;
			}
		}
	}

	public void addHighlightingChangedListener(IHighlightingChanged listener) {
		fColorChangedListeners.add(listener);
	}

	public void removeHighlightingChangedListener(IHighlightingChanged listener) {
		fColorChangedListeners.remove(listener);
	}

	private void notifyStyleChanged(ColorDescriptor cd) {
		Object[] listeners = fColorChangedListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			((IHighlightingChanged) listeners[i]).highlightingChanged(cd);
		}
	}

	private void adaptToEnablementChange(Highlighting highlighting, PropertyChangeEvent event) {
		if (highlighting == null) {
			return;
		}
		Object value = event.getNewValue();
		boolean eventValue;
		if (value instanceof Boolean)
			eventValue = ((Boolean) value).booleanValue();
		else if (IPreferenceStore.TRUE.equals(value))
			eventValue = true;
		else
			eventValue = false;
		highlighting.setEnabled(eventValue);
	}

	private void adaptToTextForegroundChange(ColorDescriptor descriptor, PropertyChangeEvent event) {
		if (descriptor.getTextAttribute() == null) {
			return;
		}
		RGB rgb = null;

		Object value = event.getNewValue();
		if (value instanceof RGB)
			rgb = (RGB) value;
		else if (value instanceof String)
			rgb = StringConverter.asRGB((String) value);

		if (rgb != null) {

			String property = event.getProperty();
			Color color = fColorManager.getColor(property);

			if ((color == null || !rgb.equals(color.getRGB()))) {
				fColorManager.unbindColor(property);
				fColorManager.bindColor(property, rgb);
				color = fColorManager.getColor(property);
			}

			TextAttribute oldAttr = descriptor.getTextAttribute();
			descriptor.setTextAttribute(new TextAttribute(color, oldAttr.getBackground(), oldAttr.getStyle()));
		}
	}

	private void adaptToTextStyleChange(ColorDescriptor descriptor, PropertyChangeEvent event, int styleAttribute) {
		if (descriptor.getTextAttribute() == null) {
			return;
		}
		boolean eventValue = false;
		Object value = event.getNewValue();
		if (value instanceof Boolean)
			eventValue = ((Boolean) value).booleanValue();
		else if (IPreferenceStore.TRUE.equals(value))
			eventValue = true;

		TextAttribute oldAttr = descriptor.getTextAttribute();
		boolean activeValue = (oldAttr.getStyle() & styleAttribute) == styleAttribute;

		if (activeValue != eventValue)
			descriptor.setTextAttribute(new TextAttribute(oldAttr.getForeground(), oldAttr.getBackground(),
					eventValue ? oldAttr.getStyle() | styleAttribute : oldAttr.getStyle() & ~styleAttribute));
	}

	private void addColor(String colorKey) {
		if (fColorManager != null && colorKey != null && fColorManager.getColor(colorKey) == null) {
			RGB rgb = PreferenceConverter.getColor(fStore, colorKey);
			fColorManager.unbindColor(colorKey);
			fColorManager.bindColor(colorKey, rgb);
		}
	}

	private void removeColor(String colorKey) {
		fColorManager.unbindColor(colorKey);
	}

	public boolean isAffected(PropertyChangeEvent event) {
		String property = event.getProperty();
		for (ColorDescriptor cd : fDescriptors) {
			if (cd.isAffectedBy(property)) {
				return true;
			}
		}
		return false;
	}
		
	public ColorDescriptor[] getSemanticHighlightings() {
		return fDescriptors.toArray(new ColorDescriptor[fDescriptors.size()]);				
	}
	
	int getDescriptorIndex(ColorDescriptor colorDescriptor) {
		return fDescriptors.indexOf(colorDescriptor);
	}
}
