package logic;

public class Tank {
	protected int health;
	protected Cannon cannon;
	// Tank without a Cannon is not a Tank
	
	public Tank () {
		// Default value of health is 1 and have default cannon
		/* Fill your code here (1) */
		this.health = 1;
		this.cannon = new Cannon();
		/////////////////////////////
	}
	
	public Tank (int health, int power) {
		// If any parameters < 1, use default value
		/* Fill your code here (2) */
		if (health < 1) {
			this.health = 1;
		}
		else {
			this.health = health;
		}
		if (power < 1) {
			this.cannon = new Cannon(1);
		}
		else {
			this.cannon = new Cannon(power);
		}
	
		/////////////////////////////
	}
	
	public boolean fireAt(Tank target) {
		// Fire if the cannon is loaded, return true if it fires successfully
		// hint: if you fire() an unloaded cannon, it shall return false
		/* Fill your code here (3) */
		if (this.cannon.isLoaded()) {
			if (cannon.fire()) {
				target.takeDamage(cannon.getPower());
				return true;
			}
		}
		return false;
		/////////////////////////////
		
	}
	
	public boolean reloadCannon () {
		return this.cannon.reload();
	}
	
	public boolean takeDamage(int damage) {
		if(damage < 0) damage = 0;
		this.health -= damage;
		if( this.health <= 0 ) return true;
		return false;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public Cannon getCannon() {
		return this.cannon;
	}

}
