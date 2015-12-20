/*
 * generated by Xtext
 */
package org.eclipse.qvto.examples.xtext.imperativeocl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.eclipse.qvto.examples.xtext.imperativeocl.ui.internal.ImperativeOCLActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ImperativeOCLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ImperativeOCLActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ImperativeOCLActivator.getInstance().getInjector(ImperativeOCLActivator.ORG_ECLIPSE_QVTO_EXAMPLES_XTEXT_IMPERATIVEOCL_IMPERATIVEOCL);
	}
	
}
