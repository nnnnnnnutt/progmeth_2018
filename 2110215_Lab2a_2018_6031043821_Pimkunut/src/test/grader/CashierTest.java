package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Cashier;

class CashierTest {

	@Test
	void testCashier() {
		Cashier cashier = new Cashier();
		assertEquals(0, cashier.getGalleon());
		assertEquals(0, cashier.getSickle());
		assertEquals(0, cashier.getKnut());
	}

	@Test
	void testCashierIntIntInt() {
		
		// Normal case
		Cashier cashier = new Cashier(10, 20, 30);
		assertEquals(10, cashier.getGalleon());
		assertEquals(20, cashier.getSickle());
		assertEquals(30, cashier.getKnut());
		
		// If parameters < 1
		cashier = new Cashier(-1, -2, 3);
		assertEquals(0, cashier.getGalleon());
		assertEquals(0, cashier.getSickle());
		assertEquals(3, cashier.getKnut());
	}
	
	@Test
	void testAddCoin() {
		Cashier cashier = new Cashier(10, 10, 10);
		
		// add positive coins
		cashier.addCoin(20, 10, 0);
		assertEquals(30, cashier.getGalleon());
		assertEquals(20, cashier.getSickle());
		assertEquals(10, cashier.getKnut());
		
		// add negative coins
		cashier.addCoin(20, -10, 40);
		assertEquals(50, cashier.getGalleon());
		assertEquals(20, cashier.getSickle());
		assertEquals(50, cashier.getKnut());
	}

	@Test
	void testMakeChange() {
		
		// Normal case
		Cashier cashier = new Cashier(30, 20, 10);
		assertTrue(cashier.makeChange(10, 10, 10));
		assertEquals(20, cashier.getGalleon());
		assertEquals(10, cashier.getSickle());
		assertEquals(0, cashier.getKnut());
		
		// Not enough coins
		cashier = new Cashier(0, 20, 10);
		assertFalse(cashier.makeChange(10, 10, 10));
		assertEquals(0, cashier.getGalleon());
		assertEquals(20, cashier.getSickle());
		assertEquals(10, cashier.getKnut());
		
		// Negative coins
		assertFalse(cashier.makeChange(10, -10, 10));
		assertEquals(0, cashier.getGalleon());
		assertEquals(20, cashier.getSickle());
		assertEquals(10, cashier.getKnut());
	}

	@Test
	void testExchange() {
		Cashier cashier = new Cashier(100,100,100);
		cashier.exchange();
		assertEquals(106, cashier.getGalleon());
		assertEquals(1, cashier.getSickle());
		assertEquals(13, cashier.getKnut());
	}

	//////////////////// DO THIS FIRST ////////////////////
	@Test
	void testSteal() {
		/* Fill your test here */
		Cashier cashier = new Cashier(100,100,100);
		assertTrue(cashier.steal());
		assertEquals(0, cashier.getGalleon());
		assertEquals(0, cashier.getSickle());
		assertEquals(0, cashier.getKnut());
		assertFalse(cashier.steal());
	}
	///////////////////////////////////////////////////////

	@Test
	void isEmpty() {
		Cashier cashier = new Cashier(0,0,0);
		assertTrue(cashier.isEmpty());
		cashier = new Cashier(1,1,0);
		assertFalse(cashier.isEmpty());
	}
	
	@Test
	void testGetGalleon() {
		Cashier cashier = new Cashier(20,0,0);
		assertEquals(20, cashier.getGalleon());
	}

	@Test
	void testGetSickle() {
		Cashier cashier = new Cashier(0,20,0);
		assertEquals(20, cashier.getSickle());
	}

	@Test
	void testGetKnut() {
		Cashier cashier = new Cashier(0,0,20);
		assertEquals(20, cashier.getKnut());
	}
	
}
