////////////////////////////////////////
//									  //

// EVERY TESTCASES REQUIRES NO CHANGE //
//									  //
////////////////////////////////////////

package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.*;

class BattleCityTest {
	private BattleCity battlecity;
	
	@BeforeEach
	void setUp() {
		battlecity = new BattleCity();
	}

	@Test
	void testAddTank() {
		
		// Add Tank
		battlecity.addTank("normal", 0, 0, 0);
		assertTrue(battlecity.getTanks(0) instanceof Tank);
		assertEquals(1, battlecity.getTanks(0).getHealth());
		assertEquals(1, battlecity.getTanks(0).getCannon().getPower());
		
		// Add HeavyTank
		battlecity.addTank("heavy", 2, 2, 2);
		assertTrue(battlecity.getTanks(1) instanceof HeavyTank);
		assertEquals(2, battlecity.getTanks(1).getHealth());
		assertEquals(2, battlecity.getTanks(1).getCannon().getPower());
		assertEquals(2, ((HeavyTank) battlecity.getTanks(1)).getArmor());
		
		// Add another HeavyTank
		battlecity.addTank("heavy", -1, -1, -1);
		assertTrue(battlecity.getTanks(2) instanceof HeavyTank);
		assertEquals(1, battlecity.getTanks(2).getHealth());
		assertEquals(1, battlecity.getTanks(2).getCannon().getPower());
		assertEquals(1, ((HeavyTank) battlecity.getTanks(2)).getArmor());
		
		// Add YoltTank
		battlecity.addTank("yolt", 3, 3, 1);

		assertEquals(3, battlecity.getTanks(3).getHealth());
		assertEquals(3, battlecity.getTanks(3).getCannon().getPower());
		
		// Invalid input
		assertFalse(battlecity.addTank("siege",175,15,1));
		assertEquals(4, battlecity.getTanks().size());
	}

	@Test
	void testUpdate() {
		Tank tank0 = new Tank(1,1);
		Tank tank1 = new Tank(1,1);
		Tank tank2 = new Tank(1,1);
		YoltTank yolt = new YoltTank(1,1);
		battlecity.addTank(tank0);
		battlecity.addTank(tank1);
		battlecity.addTank(tank2);
		battlecity.addTank(yolt);
		
		// Destroy a Tank and YoltTank, only one Tank is removed because YoltTank do emergencyFix
		tank2.fireAt(tank1);
		tank0.fireAt(yolt);
		battlecity.update();
		assertEquals(3, battlecity.getTanks().size());
		assertTrue(tank2.getCannon().isLoaded());
		assertTrue(tank0.getCannon().isLoaded());
		assertFalse(battlecity.getTanks().contains(tank1));
		assertTrue(battlecity.getTanks().contains(yolt));
		
		// Destroy YoltTank again, it should be removed right now
		tank0.fireAt(yolt);
		battlecity.update();
		assertEquals(2, battlecity.getTanks().size());
		assertFalse(battlecity.getTanks().contains(yolt));
	}

}
