package prova.progettuale.oop.manueldinucci.domain;

public class Stats {
	
	private String field;
	private int total;
	private double avg;
	private int max;
	private int min;
	private double std;

	public Stats(String field) {
		this.field=field;
	}
	
	/**
	 * @param field
	 * @param total
	 * @param avg
	 * @param max
	 * @param min
	 * @param std
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public Stats(String field, int total, double avg, int max, int min, double std) {
		this.field = field;
		this.total = total;
		this.avg = avg;
		this.max = max;
		this.min = min;
		this.std = std;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public double getStd() {
		return std;
	}

	public void setStd(double std) {
		this.std = std;
	}
	
}
