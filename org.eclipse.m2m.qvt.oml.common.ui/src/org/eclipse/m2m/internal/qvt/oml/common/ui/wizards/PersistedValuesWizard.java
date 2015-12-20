/*******************************************************************************
 * Copyright (c) 2007, 2013 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.m2m.internal.qvt.oml.common.ui.wizards;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * An abstract base class for all wizads supporting persistent value storage 
 * opportunities: values enetered in last success wizard call might be stored and loaded
 * in further calls
 * 
 * Each wizard is thought about as started in some <i>context</i>, that is some environment
 * depending on which default values are loaded into wizard. For example if we start an Apply 
 * transformation wizard on a UML1.4 project we load last successful values for this type of 
 * projects. "project.type=UML1.4" is a key value identifying the context.
 * 
 * @author abreslav
 */
public abstract class PersistedValuesWizard extends Wizard {

    /**
     * @param plugin - UI plugin which ownes this wizard (used to store dialog settings)
     */
    public PersistedValuesWizard(AbstractUIPlugin plugin) {
        super();
        myPlugin = plugin;
    }
    
    /**
     * Called in {@link #performFinish <code>performFinish</code>} when result of 
     * {@link #performFinishBody <code>performFinishBody()</code>} is <code>true</code>
     * Override this method to save all the stored values into storage
     */
    protected abstract void saveValues();
    
    /**
     * Override this method instead of {@link #performFinish <code>performFinish</code>}
     */
    protected abstract boolean performFinishBody(); 

    /**
     * Final to force descendants to use saveValues on successful finish
     * override {@link #performFinishBody <code>performFinishBody</code>} 
     */
    @Override
	public final boolean performFinish() {
        boolean result = performFinishBody();
        if (result) {
            saveValues();
        }
        return result; 
    }
    
    /**
     * Loads a set of preferences corresponding to the given keys  
     * @param keys - a <code>Map</code> of type String => String (<code>key => value</code>) where the <code>key</code> is name of a key preference
     *               and <code>value</code> if it's value
     * @return a section with preferences which fits the key, if no section fits the key excatly
     *         but some section just doesn't have some of key entries this section is returned (with
     *         lost entries added), if none found a new section is created and with key values set 
     */
    public PreferenceSection loadValues(Map<String, ?> keys) {
        // The root section, corresponding to the wizard
        IDialogSettings section = myPlugin.getDialogSettings().getSection(getClass().getName());
        if (section == null) {
            section = myPlugin.getDialogSettings().addNewSection(getClass().getName());
        }
        // Different wizard configurations
        String name = "0"; //$NON-NLS-1$
        IDialogSettings[] sections = section.getSections();
        PreferenceSection result;
        if ((sections == null) || (sections.length == 0)) {
            result = new PreferenceSection(section, name);
        }
        else {
            IDialogSettings resSection = null;
            // Looking for a section satisfying the key with the latest timestamp 
            for (int i = 0; i < sections.length; i++) {
                int equal = checkSectionEquals(sections[i], keys);
                switch (equal) {
                case SECTIONS_EQUAL:
                    if ((resSection == null) || (resSection.getLong(TIMESTAMP) < sections[i].getLong(TIMESTAMP))) { 
                        resSection = sections[i];
                    }
                    break;
                case SECTIONS_EQUAL_WITH_IMPLIED:
                    if (resSection == null) {
                        resSection = sections[i];
                    }
                    break;
                }
            }
            if (resSection == null) {
                result = getFreeSubsection(section);
            }
            else {
                result = new PreferenceSection(resSection, PreferenceSection.DONT_ERASE_DATA);
            }
        }        
        initSection(result, keys);
        return result;
    }
    
    protected PreferenceSection loadValues(String key, String value) {
        Map<String, String> keys = new HashMap<String, String>();
        keys.put(key, value);
        return loadValues(keys);
    }
    
    protected PreferenceSection loadValues(String key1, String value1, String key2, String value2) {
        Map<String, String> keys = new HashMap<String, String>();
        keys.put(key1, value1);
        keys.put(key2, value2);
        return loadValues(keys);
    }
    
    /**
     * Finds a free subsection of the given section. If the maximum number of sections 
     * isn't reached, cretes a new subsection, otherwise returns the most old subsection
     * considering it to be replaced 
     * @param section - a root section
     * @return a reference to a free section object
     */
    private PreferenceSection getFreeSubsection(IDialogSettings section) {
        IDialogSettings[] subsections = section.getSections();
        if (subsections == null) {
            return new PreferenceSection(section, "0"); //$NON-NLS-1$
        }
        if (subsections.length < MAX_RECORDS) {
            return new PreferenceSection(section, String.valueOf(subsections.length)); 
        }
        IDialogSettings toReplace = subsections[0];
        for (int i = 1; i < subsections.length; i++) {
            if (toReplace.getLong(TIMESTAMP) > subsections[i].getLong(TIMESTAMP)) {
                toReplace = subsections[i];
            }
        }
        return new PreferenceSection(toReplace, PreferenceSection.ERASE_DATA);
    }
    
    /**
     * Checks whether the section given has the same key values as set by #putKey()
     * calls.
     * @param section - the section to be checked
     * @return <code>true</code> for equal keys, <code>false</code> - otherwise
     */
    private static final int SECTIONS_DIFFERENT = -1;
    private static final int SECTIONS_EQUAL = 0;
    private static final int SECTIONS_EQUAL_WITH_IMPLIED = 1;
    private int checkSectionEquals(IDialogSettings section, Map<String,?> keys) {
        int result = SECTIONS_EQUAL;
        for (Iterator<String> i = keys.keySet().iterator(); i.hasNext();) {
            String key = (String) i.next();
            String value = section.get(key);
            if (!keys.get(key).equals(value)) {
                if (value == null) {
                    result = SECTIONS_EQUAL_WITH_IMPLIED;
                }
                else {
                    return SECTIONS_DIFFERENT;
                }
            }
        }
        return result;
    }
    
    /**
     * Initializes newly loaded section: stores key valus and sets a time stamp
     * @param section
     */
    private void initSection(PreferenceSection section, Map<String, ?> keys) {
        section.put(TIMESTAMP, new Date().getTime());
        for (Iterator<String> i = keys.keySet().iterator(); i.hasNext();) {
            String key = (String) i.next();
            section.put(key, (String) keys.get(key));
        }        
    }
    
    /**
     * A wrapper class for IDialogSettings
     * @author abreslav
     */
    protected class PreferenceSection {
        
        private PreferenceSection(IDialogSettings section, boolean eraseData) {
            mySection = section;
            myErased = eraseData;
        }
        
        private PreferenceSection(IDialogSettings parent, String name) {
            myParent = parent;
            myName = name;
            mySection = null;
            myErased = false; 
        }
        
        public void put(String key, String value) {
            myCache.put(key, value);
        }
        
        public void put(String key, boolean value) {
            myCache.put(key, new Boolean(value));
        }
        
        public void put(String key, long value) {
            myCache.put(key, new Long(value));
        }
        
        public void put(String key, Map<String, String> value) {
            String[] values = new String[value.size() * 2];
            int i = 0;
            for (Entry<String, String> entry : value.entrySet()) {
                values[i] = entry.getKey();
                values[i + 1] = entry.getValue();
                i += 2;
            }
            myCache.put(key, values);
        }
        
        public String get(String key) {
        	return get(key, null);
        }
        
        public String get(String key, String defaultValue) {
            String result = defaultValue;
            if (!myCache.containsKey(key)) {
                if (!myErased && mySection != null) {
                    result = mySection.get(key);
                    myCache.put(key, result);
                }
            } else {
                result = (String) myCache.get(key);
            }
            return result;
        }
        
        public boolean getBoolean(String key) {
        	return getBoolean(key, false);
        }
        
        public boolean getBoolean(String key, boolean defaultValue) {
            boolean result = defaultValue;
            if (!myCache.containsKey(key)) {
                if (!myErased && mySection != null) {
                    result = mySection.getBoolean(key);
                    myCache.put(key, new Boolean(result));
                }
            } else {
                result = ((Boolean) myCache.get(key)).booleanValue();
            }
            return result;
        }
        
        @SuppressWarnings("unchecked")
        public Map<String, String> getStringMap(String key) {
            Map<String, String> result = Collections.<String, String>emptyMap();
            if (!myCache.containsKey(key)) {
                if (!myErased && mySection != null) {
                    String[] values = mySection.getArray(key);
                    if (values != null) {
                        result = new HashMap<String, String>();
                        for (int i = 0; i < values.length; i += 2) {
                            result.put(values[i], (i + 1 < values.length) ?  values[i + 1] : null);
                        }
                        myCache.put(key, result);
                    }
                }
            } else {
                result = (Map<String, String>) myCache.get(key);
            }
            return result;
        }
        
        public void save() {
            if (mySection == null) {
                mySection = myParent.addNewSection(myName);
            }
            for (Entry<String, Object> entry : myCache.entrySet()) {
                if (entry.getValue() instanceof String[]) {
                    String[] values = (String[]) entry.getValue();
                    mySection.put(entry.getKey(), values);
                } else if (entry.getValue() != null) {
                    mySection.put(entry.getKey().toString(), entry.getValue().toString());
                }
            }
        }
        
        private IDialogSettings myParent;
        private String myName;
        private IDialogSettings mySection;
        private final Map<String, Object> myCache = new HashMap<String, Object>();
        private final boolean myErased;
        public static final boolean ERASE_DATA = true;
        public static final boolean DONT_ERASE_DATA = false;
    }
    
    private final AbstractUIPlugin myPlugin;
    
    public final String TIMESTAMP = "org.eclipse.m2m.internal.qvt.oml.common.wizards.PersistedValuesWizard.timestamp"; //$NON-NLS-1$
    
    /**
     * Maximum number of records for a single wizard type
     */
    public final int MAX_RECORDS = 20;
}
