package prova.progettuale.oop.manueldinucci;

public class RicetteErogate_Data {

	private int anno;
	private String brancaSpecialistica;
	private double numRicette;

	/**
	 * @param anno
	 * @param brancaSpecialistica
	 * @param numRicette
	 */
	public RicetteErogate_Data(int anno, String brancaSpecialistica, double numRicette) {
		this.anno = anno;
		this.brancaSpecialistica = brancaSpecialistica;
		this.numRicette = numRicette;
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
	 * @return the brancaSpecialistica
	 */
	public String getBrancaSpecialistica() {
		return brancaSpecialistica;
	}

	/**
	 * @param brancaSpecialistica the brancaSpecialistica to set
	 */
	public void setBrancaSpecialistica(String brancaSpecialistica) {
		this.brancaSpecialistica = brancaSpecialistica;
	}

	/**
	 * @return the numRicette
	 */
	public double getNumRicette() {
		return numRicette;
	}

	/**
	 * @param numRicette the numRicette to set
	 */
	public void setNumRicette(double numRicette) {
		this.numRicette = numRicette;
	}

	@Override
	public String toString() {
		return "RicetteErogate_Data [anno=" + anno + ", brancaSpecialistica=" + brancaSpecialistica + ", numRicette="
				+ numRicette + "]";
	}
	

}
