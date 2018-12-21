package logic;

import java.util.ArrayList;

/*
This class is just one of many theaters in a cinema complex.
It contains the information about the movie showing in this theater, showtime, and seats of each showtime.
This class is like a low-level worker when compared to the boss that is CinemaComplex Class.
It receives the order like... book a ticket for this man please!.. 
and then it checks if that seat of that showtime is occupied or not. If not, this class books that seat and tell the boss DONE!!!
Something like that... 
*/

public class Theater {

	private class ShowtimeInfo {
		int startTimeSlot;
		int endTimeSlot;
		boolean isFull;
		boolean[][] seats;

		/// implement the constructor here ///
		public ShowtimeInfo(int startTimeSlot, int endTimeSlot) {
			super();
			this.startTimeSlot = startTimeSlot;
			this.endTimeSlot = endTimeSlot;
			isFull = false;
			seats = new boolean[totalRow][totalColumn];
		}

	}

	private int theaterNumber;
	private int totalRow;
	private int totalColumn;
	private Movie movie;
	private boolean[] occupiedTimeSlot;
	private ArrayList<ShowtimeInfo> showtimeInfos;

	public Theater(int theaterNumber, int totalRow, int totalColumn) {
		this.theaterNumber = theaterNumber;
		this.totalRow = totalRow;
		this.totalColumn = totalColumn;
		occupiedTimeSlot = new boolean[CinemaComplex.TIMESLOT];
		showtimeInfos = new ArrayList<ShowtimeInfo>();
	}

	public void showAllNotFullShowtime() {
		System.out.println("Theater " + theaterNumber + ":");
		for (int i = 0; i < showtimeInfos.size(); i++) {
			ShowtimeInfo showtimeInfo = showtimeInfos.get(i);
			if (!showtimeInfo.isFull) {
				System.out.println(showtimeInfo.startTimeSlot + "-" + showtimeInfo.endTimeSlot);
			}
		}
	}

	/// implement method addShowtime here ///
	public void addShowtime(int startTimeSlot, int endTimeSlot) {
		if (movie == null) {
			return;
		}
		if (endTimeSlot < startTimeSlot || startTimeSlot < 1 || endTimeSlot > CinemaComplex.TIMESLOT) {
			return;
		}
		if (getMovie().getLength() != (endTimeSlot - startTimeSlot + 1)) {
			return;
		}
		for (int i = 0; i < showtimeInfos.size(); i++) {
			if (startTimeSlot >= showtimeInfos.get(i).startTimeSlot
					&& startTimeSlot <= showtimeInfos.get(i).endTimeSlot)
				return;
		}
		ShowtimeInfo tmp = new ShowtimeInfo(startTimeSlot, endTimeSlot);
		showtimeInfos.add(tmp);

	}

	/// implement method bookSeat here ///
	public boolean bookSeat(int startTimeSlot, int row, int column) {
		if (row < 1 || row > totalRow || column < 1 || column > totalColumn) {
			return false;
		}
		ShowtimeInfo showTime = getShowtimeInfo(startTimeSlot);
		if (showTime == null) {
			return false;
		}
		if (startTimeSlot < 1 || startTimeSlot > CinemaComplex.TIMESLOT) {
			return false;
		}
		if (showTime.isFull) {
			return false;
		}
		if (showTime.seats[row - 1][column - 1]) {
			return false;
		}
		showTime.seats[row - 1][column - 1] = true;
		return true;
	}

	//////////////////////////////////////

	public boolean displaySeats(int startTimeSlot) {
		// check if startTimeSlot are valid
		ShowtimeInfo showtimeInfo = getShowtimeInfo(startTimeSlot);
		if (showtimeInfo == null) {
			return false;
		}
		if (showtimeInfo.isFull) {
			return false;
		}

		boolean[][] seats = showtimeInfo.seats;
		for (int r = 0; r < seats.length; r++) {
			for (int c = 0; c < seats[r].length; c++) {
				if (seats[r][c]) {
					System.out.print("X");
				} else {
					System.out.print("O");
				}
				System.out.print(" ");
			}
			System.out.println("");
		}
		return true;
	}

	public int getTheaterNumber() {
		return theaterNumber;
	}

	public Movie getMovie() {
		return movie;
	}

	public boolean isSeatOccupied(int startTimeSlot, int row, int column) {
		// check if row & column are valid
		row--;
		column--;
		if (row < 0 || row >= totalRow) {
			return false;
		}
		if (column < 0 || column >= totalColumn) {
			return false;
		}

		// check if startTimeSlot are valid
		ShowtimeInfo showtimeInfo = getShowtimeInfo(startTimeSlot);
		if (showtimeInfo == null) {
			return false;
		}

		return showtimeInfo.seats[row][column];
	}

	public void setMovie(Movie movie) {
		clearMovie();
		this.movie = movie;
	}

	public void clearMovie() {
		this.movie = null;
		showtimeInfos.clear();
		for (int i = 0; i < CinemaComplex.TIMESLOT; i++) {
			occupiedTimeSlot[i] = false;
		}
	}

	public int howManyShowtime() {
		return showtimeInfos.size();
	}

	public int howManyShowtimeLeft() {
		int leftShowtime = 0;
		for (int i = 0; i < showtimeInfos.size(); i++) {
			if (!showtimeInfos.get(i).isFull) {
				leftShowtime++;
			}
		}
		return leftShowtime;
	}

	public boolean isValidShowtime(int startTimeSlot, int endTimeSlot) {
		for (int i = 0; i < showtimeInfos.size(); i++) {
			if (startTimeSlot == showtimeInfos.get(i).startTimeSlot
					&& endTimeSlot == showtimeInfos.get(i).endTimeSlot) {
				return true;
			}
		}
		return false;
	}

	private ShowtimeInfo getShowtimeInfo(int startTimeSlot) {
		for (int i = 0; i < showtimeInfos.size(); i++) {
			if (startTimeSlot == showtimeInfos.get(i).startTimeSlot) {
				return showtimeInfos.get(i);
			}
		}
		return null;
	}
}