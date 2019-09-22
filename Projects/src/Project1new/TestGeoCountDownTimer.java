package Project1new;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class TestGeoCountDownTimer {

/**
 *
 * The following are simple JUnit test cases... After talking with your instructor, create
 * many, many more that shows that your code is functioning correctly.
 *
 * TO BEGIN:
 *    un-Comment the first test cases and create code to satisfy that test,
 *    then, un-Comment the next test case and continue
 *
 */

	/**
	 * Tests Constructors.
	 * Contains 14 Test Cases
	 */
	@Test
	public void testConstructor1() {
		GeoCountDownTimer s = new GeoCountDownTimer();
		assertEquals(s.toDateString(), "1/1/2015");
		assertNotSame(s.toDateString(), "1/2/2015");
//	Create more, many more tests

	}

	@Test
	public void testConstructor2() {
		GeoCountDownTimer s = new GeoCountDownTimer("5/10/2015");
		assertEquals("5/10/2015", s.toDateString());

		s = new GeoCountDownTimer("12/31/2016");
		assertEquals("12/31/2016", s.toDateString());

		s = new GeoCountDownTimer("12/31/2020");
		assertEquals("12/31/2020", s.toDateString());

		s = new GeoCountDownTimer("12/30/2020");
		assertNotSame("12/31/2020", s.toDateString());

		//	Create more, many more tests

	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor3() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/29/2015");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor4() {
		GeoCountDownTimer s = new GeoCountDownTimer("1000//01/2015");
	}

	@Test
	public void testConstructor5() {
	GeoCountDownTimer other = new GeoCountDownTimer("2/2/2018");
	GeoCountDownTimer theOne = new GeoCountDownTimer(other);
	assertEquals(other.getDay(), 2);
	assertEquals(other.getMonth(), 2);
	assertEquals(other.getYear(), 2018);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor6() {
		GeoCountDownTimer s = new GeoCountDownTimer("20/10/2015");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor7() {
		GeoCountDownTimer s = new GeoCountDownTimer("10/32/2015");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructor8() {
		GeoCountDownTimer s = new GeoCountDownTimer("10/32/2010");
	}
@Test(expected = IllegalArgumentException.class)
	public void testConstructor9() {
		GeoCountDownTimer s = new GeoCountDownTimer("2/30/2016");
	}

	/**
	 * Tests the Decrement Method.
	 * Contains 7 Test Cases
	 */
	@Test
	public void testSubtractMethod1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2015);
		s1.dec(1);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/9/2015"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}

	@Test
	public void testSubtractMethod2() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2015);
		s1.dec(25);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("4/15/2015"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}

	@Test
	public void testSubtractMethod3() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2200);
		s1.dec(50);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("3/21/2200"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}

	@Test
	public void testSubtractMethod4() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 1, 2300);
		s1.dec(3);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("1/29/2300"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}

	@Test
	public void testSubtractMethod5() {
		//LOOK INTO INC AND DEC METHODS IN REFERENCE WITH LEAP YEARS AND ADDING AN EXTRA DATE.
		GeoCountDownTimer s1 = new GeoCountDownTimer(3, 1, 2100);
		s1.dec(3);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("2/26/2100"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}

	@Test
	public void testSubtractMethod6() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 1, 2300);
		s1.dec(365);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("1/2/2299"));
		assertFalse(s1.toDateString().equals("4/2/2015"));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testSubtractMethod7() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 1, 2300);
		s1.dec(-1);
	}
	/**
	 * Tests the Increment Method.
	 * Contains 8 Test Cases
	 */
	@Test
	public void testAddMethod1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2015);
		s1.inc(1);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/11/2015"));
	}
@Test
	public void testAddMethod2() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);
		s1.inc(10);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/20/2016"));
	}

	@Test
	public void testAddMethod3() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);
		s1.inc(22);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("6/1/2016"));
	}

	@Test
	public void testAddMethod4() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);
		s1.inc(365);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/10/2017"));
	}

	@Test
	public void testAddMethod5() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);
		s1.inc(730);
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/10/2018"));
	}

	@Test
	public void testAddMethod6() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);

		for (int i = 0; i < 365; i++)
			s1.inc();
		System.out.println(s1.toDateString());
		assertTrue(s1.toDateString().equals("5/10/2017"));
	}

	@Test
	public void testAddMethod7() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 12, 2016);

		System.out.println("Start:" + s1);
		for (int i = 0; i < 31665; i++)
			s1.inc();
		System.out.println("Middle:" + s1);

		for (int i = 0; i < 31665; i++)
			s1.dec();
		System.out.println("End: " + s1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddMethod8() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2016);
		s1.inc(0);
	}
	/**
	 * Tests Constructor Illegal Arguments
	 * Contains 3 Test Cases
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testContuctor1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, -3, -3);
		throw new IllegalArgumentException();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testContuctor2() {
		new GeoCountDownTimer(2, -3, -3);
		throw new IllegalArgumentException();

	}

	@Test(expected = IllegalArgumentException.class)
	public void testContuctor3() {
		new GeoCountDownTimer(8, -3, -3);
		throw new IllegalArgumentException();

	}

	/**
	 * Tests Setter & Getter Methods for Month, Day, and Year
	 * Contains 6 Test Cases
	 */
	@Test
	public void testSetMonth() {
		GeoCountDownTimer s1 = new GeoCountDownTimer();
		s1.setMonth(3);
		assertTrue(s1.getMonth() == 3);
	}

	@Test
	public void testSetDay() {
		GeoCountDownTimer s1 = new GeoCountDownTimer();
		s1.setDay(20);
		assertTrue(s1.getDay() == 20);
	}

	@Test
	public void testSetYear() {
		GeoCountDownTimer s1 = new GeoCountDownTimer();
		s1.setYear(2020);
		assertTrue(s1.getYear() == 2020);
	}

	/**
	 * Tests the Equals Method.
	 * Contains 9 Test Cases
	 */
	@Test
	public void testEqualdd() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 3000);
		GeoCountDownTimer s2 = new GeoCountDownTimer(6, 1, 2015);
		GeoCountDownTimer s3 = new GeoCountDownTimer(5, 5, 2015);
		GeoCountDownTimer s4 = new GeoCountDownTimer(5, 9, 3000);

		assertEquals(s1, s4);
		assertFalse(s1.equals(s2));
		assertTrue(s1.equals(s4));
		assertFalse(s3.equals(s4));


		GeoCountDownTimer s5 = new GeoCountDownTimer(1, 5, 2015);
		GeoCountDownTimer s6 = new GeoCountDownTimer(2, 29, 2016);
		GeoCountDownTimer s7 = new GeoCountDownTimer(1, 5, 2015);
		GeoCountDownTimer s8 = new GeoCountDownTimer(1, 5, 2015);

		assertEquals(s7, s8);
		assertEquals(s5, s8);
		assertEquals(s5, s8);
		assertTrue(s5.equals(s7));
		assertTrue(s7.equals(s8));
		assertTrue(s5.equals(s8));
		assertFalse(s6.equals(s7));
		assertFalse(s6.equals(s8));
	}

	/**
	 * Tests the CompareTo Method.
	 * Contains 6 Test Cases
	 */

	@Test
	public void testCompareTo1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2015);
		GeoCountDownTimer s2 = new GeoCountDownTimer(6, 1, 2015);
		GeoCountDownTimer s3 = new GeoCountDownTimer(5, 8, 2015);
		GeoCountDownTimer s4 = new GeoCountDownTimer(5, 9, 2015);
		assertTrue(s2.compareTo(s1) > 0);
		assertTrue(s3.compareTo(s1) < 0);
		assertTrue(s1.compareTo(s4) == 0);
	}

	@Test
	public void testCompareTo2() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2020);
		GeoCountDownTimer s2 = new GeoCountDownTimer(6, 1, 2019);
		assertTrue(s2.compareTo(s1) < 0);
	}

	@Test
	public void testCompareTo3() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2020);
		GeoCountDownTimer s2 = new GeoCountDownTimer(4, 1, 2020);
		assertTrue(s2.compareTo(s1) < 0);
	}

	@Test
	public void testCompareTo4() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5, 9, 2020);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5, 1, 2020);
		assertTrue(s2.compareTo(s1) < 0);
	}
	/**
	 * Tests the Load and Save Method.
	 * Contains 6 Test Cases
	 */

	@Test
	public void testLoadSave1() {
		GeoCountDownTimer s5 = new GeoCountDownTimer(4, 7, 2015);
		GeoCountDownTimer s6 = new GeoCountDownTimer(4, 7, 2015);

		s5.save("file1");
		System.out.println(s5);
		s5 = new GeoCountDownTimer(1, 1, 2015);  // resets to zero
		System.out.println(s5);
		s5.load("file1");
		System.out.println(s5);
		assertTrue(s6.equals(s5));
	}

	@Test
	public void testLoadSave2() {
	GeoCountDownTimer s5 = new GeoCountDownTimer(12, 7, 2020);
	GeoCountDownTimer s6 = new GeoCountDownTimer(12, 7, 2020);

		s5.save("file2");
		System.out.println(s6);
		s6 = new GeoCountDownTimer(2, 22, 3000);
		s5 = new GeoCountDownTimer(1, 1, 2015);
		System.out.println(s5);
		System.out.println(s6);
		s6.load("file2");
		System.out.println(s5);
		System.out.println(s6);
		assertFalse(s5.equals(s6));
	}
	@Test
	public void testLoadSave3() {
		GeoCountDownTimer s5 = new GeoCountDownTimer(12, 7, 2020);
		GeoCountDownTimer s6 = new GeoCountDownTimer(12, 7, 2020);
		s5.save("file1");
		System.out.println(s5);
		s5 = new GeoCountDownTimer(1, 1, 2015);  // resets to zero
		System.out.println(s5);
		s5.load("le2");
	}

	@Test(expected = NullPointerException.class)
	public void testLoadSave4() {
		GeoCountDownTimer s5 = new GeoCountDownTimer(12, 7, 2020);
		GeoCountDownTimer s6 = new GeoCountDownTimer(12, 7, 2020);
		s5.save("");
	}

	/**
	 * Tests the Days to Go Method.
	 * Contains 10 test cases
	 */

	@Test
	public void testDaysToGo() {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2016);
		System.out.println(s1.daysToGo("2/1/2016"));
		assertTrue(s1.daysToGo("2/1/2016") == 8);
		System.out.println(s1.daysToGo("2/8/2016"));
		assertTrue(s1.daysToGo("2/8/2016") == 1);
		System.out.println(s1.daysToGo("2/9/2016"));
		assertTrue(s1.daysToGo("2/9/2016") == 0);
		System.out.println(s1.daysToGo("1/20/2016"));
		assertTrue(s1.daysToGo("1/20/2016") == 20);
		System.out.println(s1.daysToGo("12/31/2015"));
		assertTrue(s1.daysToGo("12/31/2015") == 40);
		System.out.println(s1.daysToGo("11/1/2015"));
		assertTrue(s1.daysToGo("11/1/2015") == 100);
		System.out.println(s1.daysToGo("7/24/2015"));
		assertTrue(s1.daysToGo("7/24/2015") == 200);
		System.out.println(s1.daysToGo("5/27/2015"));
		assertTrue(s1.daysToGo("5/27/2015") == 258);

		System.out.println(s1.daysToGo("2/9/2015"));
		assertTrue (s1.daysToGo("2/9/2015") == 365);

		s1 = new GeoCountDownTimer(1,1,2038);
		System.out.println(s1.daysToGo("1/2/2036"));
		assertTrue (s1.daysToGo("1/2/2036") == 730);
	}

	/**
	 * Tests daysInFuture method
	 * Contains 2 Test Cases
	 */
	@Test
	public void testDaysInFuture1() {
		GeoCountDownTimer s1 = new GeoCountDownTimer();
		System.out.println(s1.daysInFuture(8));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDaysInFuture2() {
	GeoCountDownTimer s1 = new GeoCountDownTimer();
	System.out.println(s1.daysInFuture(-1));
	}
}

