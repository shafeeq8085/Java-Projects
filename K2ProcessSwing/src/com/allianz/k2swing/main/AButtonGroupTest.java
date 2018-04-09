/**
 * 
 */
package com.allianz.k2swing.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ofiburc
 *
 */
public class AButtonGroupTest {
	
	int a,b,c=0;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		a=10;
		b=30;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.allianz.k2swing.main.AButtonGroup#main(java.lang.String[])}.
	 */
	@Test
	public final void testMain() {
//		fail("Not yet implemented"); // TODO
		c = a + b;
		assertTrue(c == 30);
	}

}
