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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class ColorManager {

	protected Map<String, RGB> fKeyTable = new HashMap<String, RGB>(10);
	protected Map<Display, Map<RGB, Color>> fDisplayTable = new HashMap<Display, Map<RGB, Color>>(2);

	/**
	 * Flag which tells if the colors are automatically disposed when the current display gets disposed
	 */
	private boolean fAutoDisposeOnDisplayDispose;

	/**
	 * Creates a new color manager which automatically disposes the allocated colors when the current display gets disposed
	 */
	public ColorManager() {
		this(true);
	}

	/**
	 * Creates a new color manager.
	 * 
	 * @param autoDisposeOnDisplayDispose	if <code>true</code>the color manager automatically disposes all managed colors when the current display gets disposed and all calls to {@link ISharedTextColors#dispose()} are ignored
	 */
	public ColorManager(boolean autoDisposeOnDisplayDispose) {
		fAutoDisposeOnDisplayDispose = autoDisposeOnDisplayDispose;
	}

	public void dispose(Display display) {
		Map<RGB, Color> colorTable = fDisplayTable.get(display);
		if (colorTable != null) {
			Iterator<Color> e = colorTable.values().iterator();
			while (e.hasNext()) {
				Color color = e.next();
				if (color != null && !color.isDisposed())
					color.dispose();
			}
		}
	}

	/**
	 * Returns the color object for the value represented by the given <code>org.eclipse.swt.graphics.RGB</code> object.
	 */
	public Color getColor(RGB rgb) {

		if (rgb == null)
			return null;

		final Display display = Display.getCurrent();
		Map<RGB, Color> colorTable = fDisplayTable.get(display);
		if (colorTable == null) {
			colorTable = new HashMap<RGB, Color>(10);
			fDisplayTable.put(display, colorTable);
			if (fAutoDisposeOnDisplayDispose) {
				display.disposeExec(new Runnable() {
					public void run() {
						dispose(display);
					}
				});
			}
		}

		Color color = colorTable.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb);
			colorTable.put(rgb, color);
		}

		return color;
	}

	/**
	 * Tells this object to dispose all its managed colors.
	 */
	public void dispose() {
		if (!fAutoDisposeOnDisplayDispose)
			dispose(Display.getCurrent());
	}

	/**
	 * Returns a color object for the given key. The color objects are remembered internally; the same color object is returned for equal keys.
	 */
	public Color getColor(String key) {

		if (key == null)
			return null;

		RGB rgb = fKeyTable.get(key);
		return getColor(rgb);
	}

	public void bindColor(String key, RGB rgb) {
		Object value = fKeyTable.get(key);
		if (value != null)
			throw new IllegalArgumentException("Color already bound: " + key); //$NON-NLS-1$

		fKeyTable.put(key, rgb);
	}

	public void unbindColor(String key) {
		fKeyTable.remove(key);
	}
}
