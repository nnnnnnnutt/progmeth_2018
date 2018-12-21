import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegerSetTest {
	int[] empty, a, b, c, d;
	IntegerSet emptySet, setA, setB, setC, setD;
	
	@Before
	public void setUp() throws Exception {
		empty = new int[] {};
		emptySet = new IntegerSet(empty);

		a = new int[] { 1, 2, 3 };
		setA = new IntegerSet(a);

		b = new int[] { 1, 1, 2 };
		setB = new IntegerSet(b);
		
		c = new int[] { 3, 1, 2 };
		setC = new IntegerSet(c);
		
		d = new int[] { 1, 2 };
		setD = new IntegerSet(d);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsASet() {
		assertTrue(IntegerSet.isASet(a));
		assertFalse(IntegerSet.isASet(b));
		assertFalse(IntegerSet.isASet(empty));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(emptySet.isEmpty());
		assertFalse(setA.isEmpty());
	}
	
	@Test
	public void testEqualsIntegerSet() {
		assertTrue(setA.equals(setC));
		assertTrue(setB.equals(setD));
		assertFalse(setA.equals(setB));		
	}
	
	@Test(expected=NullPointerException.class)
	public void testGetMin() {
		assertTrue(setA.getMin() == 1);
		assertEquals(setA.getMin(), 1);
		
		assertEquals(emptySet.getMin(), 0);
	}

}
