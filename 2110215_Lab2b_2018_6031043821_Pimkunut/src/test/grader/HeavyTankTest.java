package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.HeavyTank;
import logic.Tank;

class HeavyTankTest {

	@Test
	void testTakeDamage() {
		HeavyTank dummy = new HeavyTank(1,1,2);
		Tank tank1 = new Tank(1,1);
		Tank tank2 = new Tank(1,2);
		Tank tank3 = new Tank(1,3);
		tank1.fireAt(dummy);
		assertEquals(1, dummy.getHealth());
		tank2.fireAt(dummy);
		assertEquals(1, dummy.getHealth());
		tank3.fireAt(dummy);
		assertEquals(0, dummy.getHealth());
	}

	@Test
	void testHeavyTank() {
		HeavyTank dummy = new HeavyTank();
		assertEquals(1, dummy.getHealth());
		assertEquals(1, dummy.getCannon().getPower());
		assertEquals(1, dummy.getArmor());
	}

	@Test
	void testHeavyTankIntIntInt() {
		
		// Normal test
		HeavyTank dummy = new HeavyTank(2,3,4);
		assertEquals(2, dummy.getHealth());
		assertEquals(3, dummy.getCannon().getPower());
		assertEquals(4, dummy.getArmor());
		
		// Test if parameters are < 1
		dummy = new HeavyTank(-2,-3,0);
		assertEquals(1, dummy.getHealth());
		assertEquals(1, dummy.getCannon().getPower());
		assertEquals(1, dummy.getArmor());
	}
	
	@Test
	void testGetArmor() {
		HeavyTank dummy = new HeavyTank(2,2,2);
		assertEquals(2, dummy.getArmor());
	}

}
