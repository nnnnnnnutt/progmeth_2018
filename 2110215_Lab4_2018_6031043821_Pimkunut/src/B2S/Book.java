package B2S;

public class Book extends Item{
	public static int idCount = 1;
	private boolean isRented;
	private String renterName;
	private int giveBackDate;
	private String statusString;
	private String buyableString = "NOT Buyable";
	
	public Book(String name, double price) {
		super(name, price);
		this.id = Book.idCount;
		Book.idCount += 1;
		this.isRented = false;
		this.renterName = "";
		this.giveBackDate = 0;
		this.statusString = "";
		this.buyableString = "";
	}
	
	public void rent(String renterName) {
		this.renterName = renterName;
		this.isInStock = false;
		this.isRented = true;
		this.giveBackDate = B2Splus.date;
		this.statusString = "rented by " + this.renterName;
	}
	
	public double returnItem() {
		this.renterName = "";
		this.isInStock = true;
		this.isRented = false;
		int date = this.giveBackDate;
		this.giveBackDate = 0;
		return this.price * 0.07 *(B2Splus.date - date +1);
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
