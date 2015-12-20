package org.eclipse.m2m.qvt.oml.test.emof.all;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.qvt.declarative.test.emof.all.AllQVTDeclarativeConsistencyTests;

public class AllQVTConsistencyTests
{
	public static void buildSuite(TestSuite suite) {
		AllQVTDeclarativeConsistencyTests.buildSuite(suite);
		AllQVTOMLConsistencyTests.buildSuite(suite);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT Consistency Tests");
		buildSuite(suite);
		return suite;
	}
}
