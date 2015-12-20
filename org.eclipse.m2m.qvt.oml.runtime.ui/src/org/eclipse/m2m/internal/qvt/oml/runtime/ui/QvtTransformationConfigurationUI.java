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
package org.eclipse.m2m.internal.qvt.oml.runtime.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.m2m.internal.qvt.oml.common.MdaException;
import org.eclipse.m2m.internal.qvt.oml.common.launch.ISetMessage;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.QvtTransformation;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationProperty;
import org.eclipse.m2m.internal.qvt.oml.runtime.project.config.QvtConfigurationPropertyType;
import org.eclipse.m2m.internal.qvt.oml.runtime.ui.wizards.ApplyTransformationData;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class QvtTransformationConfigurationUI {

    public QvtTransformationConfigurationUI(ApplyTransformationData data, ISetMessage sm) {
        mySetMessage = sm;
        myData = data;
    }
    
    public void createControl(Composite parent) {
        int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
                    SWT.FULL_SELECTION | SWT.HIDE_SELECTION;

        myTableViewer = new TableViewer(parent, style);
        GridData gridData = new GridData(GridData.FILL_HORIZONTAL | GridData.FILL_VERTICAL);
        myTableViewer.getControl().setLayoutData(gridData);
        myTableViewer.setContentProvider(CONTENT_PROVIDER);
        myTableViewer.setLabelProvider(LABEL_PROVIDER);
        Table table = myTableViewer.getTable();
        TableLayout layout = new TableLayout();
        table.setLayout(layout);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        hookContextMenu();
        
        createColumn(table, layout, Messages.QvtTransformationConfigurationUI_PropertyColumn);
        createColumn(table, layout, Messages.QvtTransformationConfigurationUI_TypeColumn);
        createColumn(table, layout, Messages.QvtTransformationConfigurationUI_ValueColumn);
        
        myEditors = new CellEditor[3];
        myTextCellEditor = new TextCellEditor(myTableViewer.getTable());
        myComboBoxCellEditor = new ComboBoxCellEditor(myTableViewer.getTable(), BOOLEAN_ITEMS, SWT.READ_ONLY | SWT.DROP_DOWN);
        myEditors[2] = myTextCellEditor;
        
        myTableViewer.setCellEditors(myEditors);
        myTableViewer.setColumnProperties(new String[] {"0", "1", "2"});   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
        
        myTableViewer.setInput(myProperties);
        myTableViewer.setCellModifier(CELL_MODIFIER);
    }

    protected void hookContextMenu() {
        MenuManager menuManager = new MenuManager("#PopupMenu"); //$NON-NLS-1$
        menuManager.setRemoveAllWhenShown(true);
        menuManager.addMenuListener(new IMenuListener() {
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new ContributionItem() {
                    @Override
                    public void fill(Menu menu, int index) {
                        if (myUnsetMenuItem == null) {
                            createUnsetMenuItem(menu);
                        }
                        myUnsetMenuItem.setEnabled(!myTableViewer.getSelection().isEmpty());
                    }

                    private void createUnsetMenuItem(Menu menu) {
                        myUnsetMenuItem = new MenuItem(menu, SWT.PUSH);
                        myUnsetMenuItem.setText(Messages.QvtTransformationConfigurationUI_UnsetMenuItem);
                        myUnsetMenuItem.addSelectionListener( new SelectionListener() {

                            public void widgetSelected(SelectionEvent e) {
                                ISelection selection = myTableViewer.getSelection();
                                if (selection instanceof IStructuredSelection) {
                                    IStructuredSelection sel = (IStructuredSelection) selection;
                                    ConfigurationPropertyValue firstElement = (ConfigurationPropertyValue) sel.getFirstElement();
                                    if (firstElement != null) {
                                        firstElement.setValue(QvtConfigurationPropertyType.NOT_SET);
                                        myTableViewer.update(firstElement, COLUMNS_TO_UPDATE);
                                        notifyListeners(firstElement.getProperty());
                                    }
                                }
                            }
                            
                            public void widgetDefaultSelected(SelectionEvent e) {
                                widgetSelected(e);                
                            }

                        });
                    }
                    
                    private MenuItem myUnsetMenuItem;
                });
            }
        });
        Menu menu = menuManager.createContextMenu(myTableViewer.getControl());
        myTableViewer.getControl().setMenu(menu);
    }

    private void createColumn(Table table, TableLayout layout, String name) {
        TableColumn nameColumn = new TableColumn(table, SWT.NONE);
        layout.addColumnData(new ColumnWeightData(3, true));
        nameColumn.setText(name);
    }
    
    public void loadValues() {
        myTransformation = myData.getTransformation();
        
        Map<String, String> valueMap = myData.getConfiguration();
        
        myProperties.clear();
        if (myTransformation != null) {
            Set<QvtConfigurationProperty> configurationProperties;
            try {
                configurationProperties = myTransformation.getConfigurationProperties();
                for (QvtConfigurationProperty property : configurationProperties) {
                    myProperties.addProperty(property, valueMap.get(property.getName()));
                }
            } catch (MdaException e) {
            	// Error is already reported in UI, no need for duplication in log
                //QvtRuntimeUIPlugin.getDefault().getLog().log(MiscUtil.makeErrorStatus(e));
            }
        }
        myTableViewer.refresh();
    }

    public void performApply() {
        myData.getConfiguration().clear();
        myProperties.fillMap(myData.getConfiguration());
   }

    public void validate() {
        mySetMessage.setMessage(null);
        ConfigurationPropertyValue error = myProperties.getFirstError();
        if (error != null) {
            mySetMessage.setErrorMessage(NLS.bind(Messages.QvtTransformationConfigurationUI_InvalidProperyValue, String.valueOf(error.getValue()), error.getProperty().getName())); 
            myValid = false;
            return;
        }
        mySetMessage.setErrorMessage(null);
        myValid = true;
    }

    public boolean isValid() {
        return myValid;
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        myListeners.add(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        myListeners.remove(listener);
    }
    
    private void notifyListeners(QvtConfigurationProperty property) {
        for (PropertyChangeListener listener : myListeners) {
            listener.changePerformed(property);
        }
    }    
    
    private static class ConfigurationPropertyValueList {
        
        public void addProperty(QvtConfigurationProperty property, String value) {
            myValues.add(new ConfigurationPropertyValue(property, property.getType().valueOf(value)));
        }
        
        public void clear() {
            myValues.clear();
        }
        
        public ConfigurationPropertyValue[] getAll() {
            return myValues.toArray(new ConfigurationPropertyValue[] {});
        }
        
        public void fillMap(Map<String, String> valueMap) {
            for (ConfigurationPropertyValue value : myValues) {
                if (value.getValue() != QvtConfigurationPropertyType.NOT_SET) {
                    valueMap.put(
                            value.getProperty().getName(), 
                            value.getProperty().getType().stringValueOf(value.getValue())
                    );
                }
            }
        }
        
        public ConfigurationPropertyValue getFirstError() {
            for (ConfigurationPropertyValue value: myValues) {
                if (value.getValue() instanceof QvtConfigurationPropertyType.ErrorValue) {
                    return value;
                }
            }
            return null;
        }
        
        private List<ConfigurationPropertyValue> myValues = new ArrayList<ConfigurationPropertyValue>(); 
    }
    
    private static class ConfigurationPropertyValue {
        
        public ConfigurationPropertyValue(QvtConfigurationProperty prop) {
            myProperty = prop;
        }
        
        public ConfigurationPropertyValue(QvtConfigurationProperty prop, Object value) {
            this(prop);
            myValue = value;
        }
        
        public Object getValue() {
            return myValue;
        }
        
        public void setValue(Object value) {
            myValue = value;
        }
        
        public QvtConfigurationProperty getProperty() {
            return myProperty;
        }
        
        @Override
        public String toString() {
            return myValue.toString();
        }
        
        private final QvtConfigurationProperty myProperty;
        private Object myValue;
    }
    
    protected static final IStructuredContentProvider CONTENT_PROVIDER = new IStructuredContentProvider() {

        public Object[] getElements(Object inputElement) {
            if (inputElement instanceof ConfigurationPropertyValueList == false) {
                return null;
            }
            return ((ConfigurationPropertyValueList) inputElement).getAll();            
        }

        public void dispose() {
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }
        
    };
    private class MyLabelProvider extends LabelProvider implements ITableLabelProvider {

        public Image getColumnImage(Object element, int columnIndex) {
            if (columnIndex == 2) {
                ConfigurationPropertyValue value = (ConfigurationPropertyValue) element;
                if (value.getValue() == QvtConfigurationPropertyType.NOT_SET) {
                    return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_WARN_TSK);
                } else if (value.getValue() instanceof QvtConfigurationPropertyType.ErrorValue) {
                    return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
                } 
                return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);        
            }
            return null;
        }

        public String getColumnText(Object element, int columnIndex) {
            if (element instanceof String) {
                return element.toString();
            }
            ConfigurationPropertyValue value = (ConfigurationPropertyValue) element;
            switch (columnIndex) {
            case 0:
                return value.getProperty().getName();
            case 1:
                return value.getProperty().getType().getName();
            case 2:
                return value.toString();
            default:
                return null;
            }
        }

    }
    protected final MyLabelProvider LABEL_PROVIDER = new MyLabelProvider();
    
    private ComboBoxCellEditor getBooleanComboBox() {
        myComboBoxCellEditor.setItems(BOOLEAN_ITEMS);
        return myComboBoxCellEditor;
    }
    
    private void setCellEditor(CellEditor e) {
        myEditors[2] = e;
        myTableViewer.setCellEditors(myEditors);
    }
    
    private boolean isBooleanValue(ConfigurationPropertyValue value) {
        return (value.getProperty().getType().getImplementation() == Boolean.class) || 
            (value.getProperty().getType().getImplementation() == Boolean.TYPE);
    }

    private boolean isEnumValue(ConfigurationPropertyValue value) {        
        return (value.getProperty().getType().getImplementation() instanceof EEnum);
    }

    private CellEditor getEnumComboBox(EEnum eEnum) {
        EList<?> literals = eEnum.getELiterals();
        String[] items = new String[literals.size()];
        int  i = 0;
        for (Iterator<?> iter = literals.iterator(); iter.hasNext(); i++) {
            EEnumLiteral literal = (EEnumLiteral) iter.next();
            items[i] = literal.getLiteral();
        }
        myComboBoxCellEditor.setItems(items);
        return myComboBoxCellEditor;
    }

    protected final ICellModifier CELL_MODIFIER = new ICellModifier() {

        public boolean canModify(Object element, String property) {
            boolean result = "2".equals(property); //$NON-NLS-1$
            if (result) {
                ConfigurationPropertyValue value = (ConfigurationPropertyValue) element;
                
                if (isBooleanValue(value)) {
                    setCellEditor(getBooleanComboBox());
                } else if (isEnumValue(value)) {
                    setCellEditor(getEnumComboBox((EEnum) value.getProperty().getType().getImplementation()));
                } else {
                    setCellEditor(myTextCellEditor);
                }                
            }
            return result;
        }

        public Object getValue(Object element, String property) {
            ConfigurationPropertyValue value = (ConfigurationPropertyValue) element;
            if (isBooleanValue(value)) {
                return (value.getValue() == Boolean.TRUE) ? Integer.valueOf(1) : Integer.valueOf(0);
            }
            if (isEnumValue(value)) {
                EEnum eEnum = (EEnum) value.getProperty().getType().getImplementation();
                return eEnum.getELiterals().indexOf(value.getValue());
            }
            if (value.getValue() == QvtConfigurationPropertyType.NOT_SET) {
                return ""; //$NON-NLS-1$
            } else {
                return value.getProperty().getType().stringValueOf(value.getValue());
            }
        }

        public void modify(Object element, String property, Object value) {
            if (element instanceof Item) {
                element = ((Item) element).getData();                
            }
            ConfigurationPropertyValue cpValue = (ConfigurationPropertyValue) element;
            
            Object valueToBeSet;
            if (isBooleanValue(cpValue)) {
                valueToBeSet = Boolean.valueOf(((Integer) value).intValue() == 1);
            } else if (isEnumValue(cpValue)) {
                EEnum eEnum = (EEnum) cpValue.getProperty().getType().getImplementation();
                valueToBeSet = eEnum.getEEnumLiteral(myComboBoxCellEditor.getItems()[(Integer) value]);
            } else {
                valueToBeSet = cpValue.getProperty().getType().valueOf(value.toString());
            }
            cpValue.setValue(valueToBeSet);
            myTableViewer.refresh();
            notifyListeners(cpValue.getProperty());
        }

    };
  
    public interface PropertyChangeListener {
        void changePerformed(QvtConfigurationProperty property);
    }
    
    private ISetMessage mySetMessage;
    private final ConfigurationPropertyValueList myProperties = new ConfigurationPropertyValueList();
    private TableViewer myTableViewer;
    private QvtTransformation myTransformation;
    private final ApplyTransformationData myData;
    private final Set<PropertyChangeListener> myListeners = new HashSet<PropertyChangeListener>();
    private boolean myValid;
    private CellEditor[] myEditors;
    private TextCellEditor myTextCellEditor;
    private ComboBoxCellEditor myComboBoxCellEditor;
    private static final String[] BOOLEAN_ITEMS = new String[] {Boolean.FALSE.toString(), Boolean.TRUE.toString()};    
    private static final String[] COLUMNS_TO_UPDATE = new String[] {"2"}; //$NON-NLS-1$
}
