package logic;

public class HeavyTank extends Tank {
	private int armor;
	
	public HeavyTank(){
		this.armor = 1;
	}
	
	public HeavyTank(int health, int power, int armor) {
		super(health, power);
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
		if (armor < 1) {
			this.armor = 1;
		}
		else {
			this.armor = armor;
		}
	}
	
	@Override
	public boolean takeDamage(int damage) {
		damage -= armor;
		if(damage < 0) damage = 0;
		this.health -= damage;
		if( this.health <= 0 ) return true;
		return false;
	}

	public int getArmor() {
		return armor;
	}

}