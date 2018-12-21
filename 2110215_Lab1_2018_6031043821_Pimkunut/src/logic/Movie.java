package logic;

public class Movie {
	private String name;
	private int length;

	public Movie(String name, int length) {
		super();
		this.name = name;
		this.length = length;
		if (name.equals("")) {
			name = "No Name";
			this.name = name;
		}
		if (length < 1) {
			this.length = 1;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getLength() {
		return this.length;
	}

}
