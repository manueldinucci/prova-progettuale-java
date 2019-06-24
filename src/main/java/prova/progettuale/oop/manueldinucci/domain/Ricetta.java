package prova.progettuale.oop.manueldinucci.domain;

public class Ricetta {
	private int anno;
	private String branca;
	private int qty;

	public Ricetta() {}
	/**
	 * @param anno Anno
	 * @param branca Branca specialistica
	 * @param qty Quantità di ricette emesse 
	 */

	public Ricetta(int anno, String branca, int qty) {
		this.anno = anno;
		this.branca = branca;
		this.qty = qty;
	}

	/**
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	/**
	 * @return the branca
	 */
	public String getBranca() {
		return branca;
	}

	/**
	 * @param branca the branca to set
	 */
	public void setBranca(String branca) {
		this.branca = branca;
	}

	/**
	 * @return the qty
	 */
	public int getQty() {
		return qty;
	}

	/**
	 * @param qty the qtà to set
	 */
	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "\n Anno: " + anno + " -- Branca specialistica: " +
				branca + " -- Numero di ricette: " +
				qty;
	}	

}
