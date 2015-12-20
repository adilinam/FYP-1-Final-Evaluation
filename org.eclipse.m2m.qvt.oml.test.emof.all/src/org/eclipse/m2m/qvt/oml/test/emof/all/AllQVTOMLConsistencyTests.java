package org.eclipse.m2m.qvt.oml.test.emof.all;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.m2m.qvt.oml.test.emof.imperativeocl.ImperativeOCLConsistencyTest;
import org.eclipse.m2m.qvt.oml.test.emof.qvtoperational.QVTOperationalConsistencyTest;

public class AllQVTOMLConsistencyTests
{
	public static void buildSuite(TestSuite suite) {
		suite.addTestSuite(ImperativeOCLConsistencyTest.class);
		suite.addTestSuite(QVTOperationalConsistencyTest.class);
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("All QVT OML Consistency Tests");
		buildSuite(suite);
		return suite;
	}
}
