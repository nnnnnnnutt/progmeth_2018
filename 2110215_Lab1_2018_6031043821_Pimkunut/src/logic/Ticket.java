package logic;

public class Ticket {
	private int theaterNumber;
	private String movieName;
	private int startTimeSlot;
	private int row;
	private int column;

	public Ticket(int theaterNumber, String movieName, int startTimeSlot, int row, int column) {
		this.theaterNumber = theaterNumber;
		this.movieName = movieName;
		this.startTimeSlot = startTimeSlot;
		this.row = row;
		this.column = column;
	}

	public String toString() {
		return "Theater: " + theaterNumber + ", Movie: " + movieName + ", Time: " + startTimeSlot + ", Seat: " + row
				+ "/" + column;
	}

}
