////////////////////////
//					  //
// No change required //
//					  //
////////////////////////

package logic;

public class Cannon {
	private boolean loaded;
	private final int POWER;
	
	public Cannon() {
		this.loaded = true;
		this.POWER = 1;
	}
	
	public Cannon(int power) {
		this.loaded = true;
		this.POWER = power;
	}
	
	public boolean fire() {
		if(this.loaded) {
			this.loaded = false;
			return true;
		}
		else {			
			return false;
		}
	}
	
	public boolean reload() {
		if(this.loaded) {
			return false;
		}
		else {
			this.loaded = true;
			return false;
		}
	}
	
	public int getPower() {
		return this.POWER;
	}
	
	public boolean isLoaded() {
		return this.loaded;
	}
}
