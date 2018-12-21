////////////////////////////////////////
//									  //
// EVERY TESTCASES REQUIRES NO CHANGE //
//									  //
////////////////////////////////////////

package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Tank;

class TankTest {

	@Test
	void testTank() {
		Tank tank = new Tank();
		assertEquals(1, tank.getHealth());
		assertEquals(1, tank.getCannon().getPower());
	}

	@Test
	void testTankIntInt() {
		
		// Normal test
		Tank tank = new Tank(2,2);
		assertEquals(2, tank.getHealth());
		assertEquals(2, tank.getCannon().getPower());
		
		// Test if parameters are < 1
		tank = new Tank(-1,0);
		assertEquals(1, tank.getHealth());
		assertEquals(1, tank.getCannon().getPower());
	}

	@Test
	void testFireAt() {
		Tank test = new Tank(2,2);
		Tank target = new Tank(3,1);
		
		// Fire successful, target should take damage but still not destroyed
		assertTrue(test.fireAt(target));
		assertEquals(1, target.getHealth());
		
		// Cannon is unloaded, so firing should be unsuccessful. 
		assertFalse(test.fireAt(target));
		assertEquals(1, target.getHealth());
		
		// Reload and fire again, target should be destroyed right now.
		test.reloadCannon();
		assertTrue(test.fireAt(target));
		assertEquals(-1, target.getHealth());
	}
}
