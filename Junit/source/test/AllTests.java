package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(MyTestCase.class);
		suite.addTestSuite(TestFailure.class);
		//$JUnit-END$
		return suite;
	}

}
