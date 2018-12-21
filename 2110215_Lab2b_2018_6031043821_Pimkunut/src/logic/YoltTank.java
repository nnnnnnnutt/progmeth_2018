////////////////////////
//					  //
// No change required //
//					  //
////////////////////////

package logic;

// YOLT = You Only Live Twice
public class YoltTank extends Tank {
	private boolean emergencyFixAvailable;
	private int maxHealth;
	
	public YoltTank() {
		this.emergencyFixAvailable = true;
		this.maxHealth = 1;
	}

	public YoltTank(int health, int power) {
		super(health, power);
		this.emergencyFixAvailable = true;
		this.maxHealth = health;
	}
	
	public boolean isEmergencyFixAvailable() {
		return emergencyFixAvailable;
	}

	public boolean emergencyFix() {
		if(emergencyFixAvailable) {
			this.emergencyFixAvailable = false;
			this.health = this.maxHealth;
			return true;
		}
		else return false;
	}
}
