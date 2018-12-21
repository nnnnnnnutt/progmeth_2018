package B2S;

public class Stationary extends Item implements Saleable {
	public static int idCount = 1;
	String buyerName;
	boolean isBought;
	boolean isBuyable;
	private String statusString;
	private String buyableString;
	
	public Stationary(String name, double price) {
		super(name, price);
		this.id = Stationary.idCount;
		Stationary.idCount += 1;
		this.buyerName = "";
		this.isBought = false;
		this.isBuyable = true;
		this.buyableString = "Buyable\t";
		this.statusString = "";
	}
	
	public double buy(String buyerName) {
		this.buyerName = buyerName;
		this.isInStock = false;
		this.isBought = true;
		this.isBuyable = false;
		this.buyableString = "NOT Buyable";
		this.statusString = "bought by " + this.buyerName;
		return this.price;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public boolean isBought() {
		return isBought;
	}

	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}

	public boolean isBuyable() {
		return isBuyable;
	}

	public void setBuyable(boolean isBuyable) {
		this.isBuyable = isBuyable;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}

	public String getBuyableString() {
		return buyableString;
	}

	public void setBuyableString(String buyableString) {
		this.buyableString = buyableString;
	}
	
	@Override
	public String toString() {
		return String.format("#%d\t%s\t$%.2f\t%s\t%s", id, name, price, 
				buyableString, statusString);	
	}
}
