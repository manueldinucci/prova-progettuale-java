package prova.progettuale.oop.manueldinucci;

public class RicetteErogate_Data {

	private int anno;
	private String brancaSpecialistica;
	private String numRicette;

	/**
	 * @param anno
	 * @param brancaSpecialistica
	 * @param numRicette
	 */
	public RicetteErogate_Data(int anno, String brancaSpecialistica, String numRicette) {
		this.anno = anno;
		this.brancaSpecialistica = brancaSpecialistica;
		this.numRicette = numRicette;
	}

	/**
	 * @param anno
	 * @param brancaSpecialistica
	 * @param numRicette
	 */

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
	public String getNumRicette() {
		return numRicette;
	}

	/**
	 * @param numRicette the numRicette to set
	 */
	public void setNumRicette(String numRicette) {
		this.numRicette = numRicette;
	}

	@Override
	public String toString() {
		return anno + " " + brancaSpecialistica + " " + numRicette ;
	}
	

}
