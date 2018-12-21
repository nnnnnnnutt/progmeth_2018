package B2S;

public class Game extends Item implements Rentable,Saleable{
	public static int idCount = 1;
	private boolean isRented;
	private String renterName ;
	private int giveBackDate;
	private String buyerName;
	private boolean isBought;
	private boolean isBuyable;
	private String statusString;
	private String buyableString;
	
	public Game(String name, double price) {
		super(name, price);
		// TODO Auto-generated constructor stub
		this.id = Game.idCount;
		Game.idCount += 1;
		this.isRented = false;
		this.renterName = "";
		this.giveBackDate = 0;
		this.buyerName = "";
		this.isBought = false;
		this.isBuyable = true;
		this.statusString = "";
		this.buyableString = "Buyable\t";
	}
	
	public void rent(String renterName) {
		this.renterName = renterName;
		this.isInStock = false;
		this.isRented = true;
		this.isBuyable = false;
		this.giveBackDate = B2Splus.date;
		this.statusString = "rented by " + this.renterName;
		this.buyableString = "NOT Buyable";
	}

	public double returnItem() {
		this.renterName = "";
		this.isInStock = true;
		this.isRented = false;
		int date = this.giveBackDate;
		this.giveBackDate = 0;
		return this.price * 0.07 *(B2Splus.date - date +1);
	}
	
	public double buy(String buyerName) {
		this.buyerName = buyerName;
		this.isInStock = false;
		this.isBought = true;
		this.isBuyable = false;
		this.statusString = "Bought by " + this.buyerName;
		this.buyableString = "NOT Buyable";
		return this.price;
	}
	
	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

	public String getRenterName() {
		return renterName;
	}

	public void setRenterName(String renterName) {
		this.renterName = renterName;
	}

	public int getGiveBackDate() {
		return giveBackDate;
	}

	public void setGiveBackDate(int giveBackDate) {
		this.giveBackDate = giveBackDate;
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
