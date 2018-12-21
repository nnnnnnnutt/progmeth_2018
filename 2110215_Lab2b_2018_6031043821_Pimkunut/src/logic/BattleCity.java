package logic;

import java.util.ArrayList;

public class BattleCity {
	private ArrayList<Tank> tanks;

	public BattleCity() {
		this.tanks = new ArrayList<Tank>();
	}
	
	public boolean addTank( Tank tank ) {
		this.tanks.add(tank);
		return true;
	}

	public boolean addTank(String type, int health, int power, int special) {
		/*
		 * Type ( String )	special ( int )
		 * normal 			- 
		 * heavy  			armor
		 * yolt				-
		 */

		/* Fill your code here (4) */
		if (type == "normal") {
			this.tanks.add(new Tank(health, power));
			return true;
		}
		if (type == "heavy") {
			this.tanks.add(new HeavyTank(health, power, special));
			return true;
		}
		if (type == "yolt") {
			this.tanks.add(new YoltTank(health, power));
			return true;
		}
		return false;
		
	
		/////////////////////////////
	}

	public void update() {
		// Remove all destroyed Tanks and reload on every Tanks that survived //
		// Hint: Use ArrayList.remove(int index) to remove an element from ArrayList //
		for (int i = this.tanks.size() - 1; i >= 0; i--) {
			Tank tank = this.tanks.get(i);
			if (tank.getHealth() <= 0) {
				if (tank instanceof YoltTank) {
					if (((YoltTank) tank).isEmergencyFixAvailable()) {
						((YoltTank) tank).emergencyFix();
					}
					else {
						tanks.remove(i);
					}
				}
				else {
					tanks.remove(i);
				}
				/*
				 * Fill your code for checking if the Tank is 'YoltTank' then do emergencyFix() (5)
				 *
				 * note: emergencyFix is unique to 'YoltTank'; no other classes have it
				 * hint: If 'YoltTank' already did emergencyFix(), it shall return false and don't do it again
				 */
				
				/////////////////////////////////////////////////////////////////////////////////////////////
			} else {
				tank.reloadCannon();
			}
		}
	}

	public Tank getTanks(int index) {
		if (index < 0 || index >= this.tanks.size()) {
			return null;
		}
		return this.tanks.get(index);
	}

	public ArrayList<Tank> getTanks() {
		return tanks;
	}
	
	public static void main( String[] args ) {
		System.out.println("Do use JUnit to test.");
	}
}
