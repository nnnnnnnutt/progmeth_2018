package logic;

public class Cashier {
	private int galleon;
	private int sickle;
	private int knut;
	private static final int SICKLE_TO_GALLEON = 17;
	private static final int KNUT_TO_SICKLE = 29;
	
	public Cashier() {
		this.galleon = 0;
		this.sickle = 0;
		this.knut = 0;
		
	}

	public Cashier(int galleon, int sickle, int knut) {
		if (galleon < 0) {
			this.galleon = 0;
		}
		else {
			this.galleon = galleon;
		}
		if (sickle < 0) {
			this.sickle = 0;
		}
		else {
			this.sickle = sickle;
		}
		if (knut < 0) {
			this.knut = 0;
		}
		else {
			this.knut = knut;
		}
			
	}
	
	public void addCoin (int galleon, int sickle, int knut) {
		if( galleon < 0 ) galleon = 0;
		if( sickle < 0 ) sickle = 0;
		if( knut < 0 ) knut = 0;
		this.galleon += galleon;
		this.sickle += sickle;
		this.knut += knut;
	}
	
	public boolean makeChange(int galleon, int sickle, int knut) {
		if(galleon < 0 || sickle < 0 || knut < 0)
			return false;
		if(galleon <= this.galleon && sickle <= this.sickle && knut <= this.knut){
			this.galleon -= galleon;
			this.sickle -= sickle;
			this.knut -= knut;
			return true;
		}
		return false;
	}
	
	public void exchange() {
		this.sickle += Math.floor(knut / KNUT_TO_SICKLE);
		this.knut -= Math.floor(knut / KNUT_TO_SICKLE) * KNUT_TO_SICKLE;
		this.galleon += Math.floor(sickle / SICKLE_TO_GALLEON);
		this.sickle -= Math.floor(sickle / SICKLE_TO_GALLEON) * SICKLE_TO_GALLEON;
	}
	
	public boolean steal() {
		if( !this.isEmpty()) {
			this.galleon = 0;
			this.sickle = 0;
			this.knut = 0;
			return true;
		}	
		else return false;
	}

	public int getGalleon() {
		return galleon;
	}

	public int getSickle() {
		return sickle;
	}

	public int getKnut() {
		return knut;
	}
	
	public boolean isEmpty() {
		return this.galleon == 0 && this.sickle == 0 && this.knut == 0;
	}

	public static void main( String[] args ) {
		System.out.println("Do use JUnit to test.");
	}
}
