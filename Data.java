public class Data {
	private int year;
	private int month;
	private int day;

	public Data(int year, int month, int day) {
		this.year = year;
		if (month > 12 || month < 1) {
			throw new IllegalArgumentException("Month value is invalid: " + month);
		}
		this.month = month;
		if (day > 31 || day < 1) {
			throw new IllegalArgumentException("Day value is invalid: " + day);
		}
		this.day = day;
	}

	public Data() {
		year = 0;
		month = 0;
		day = 0;
	}

	public int GetYear() {
		return year;
	}

	public int GetMonth() {
		return month;
	}

	public int GetDay() {
		return day;
	}
}
