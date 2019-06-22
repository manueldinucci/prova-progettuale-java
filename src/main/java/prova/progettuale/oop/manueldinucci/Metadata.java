package prova.progettuale.oop.manueldinucci;

public class Metadata {
	private String sourceField;
	private String campo2;
	private String campo3;
	/**
	 * @param campo1
	 * @param campo2
	 * @param campo3
	 */
	public Metadata(String campo1, String campo2, String campo3) {
		this.sourceField = campo1;
		this.campo2 = campo2;
		this.campo3 = campo3;
	}
	/**
	 * @return the campo1
	 */
	public String getCampo1() {
		return sourceField;
	}
	/**
	 * @param campo1 the campo1 to set
	 */
	public void setCampo1(String campo1) {
		this.sourceField = campo1;
	}
	/**
	 * @return the campo2
	 */
	public String getCampo2() {
		return campo2;
	}
	/**
	 * @param campo2 the campo2 to set
	 */
	public void setCampo2(String campo2) {
		this.campo2 = campo2;
	}
	/**
	 * @return the campo3
	 */
	public String getCampo3() {
		return campo3;
	}
	/**
	 * @param campo3 the campo3 to set
	 */
	public void setCampo3(String campo3) {
		this.campo3 = campo3;
	}
	
	@Override
	public String toString() {
		return "Metadata [campo1=" + sourceField + ", campo2=" + campo2 + ", campo3=" + campo3 + "]";
	}

	

}
