package prova.progettuale.oop.manueldinucci.domain;

public class Metadata {
	
	private String sourceField;
	private String type;

	/**
	 * @param sourceField
	 * @param type
	 */
	public Metadata(String sourceField) {
		this.sourceField = sourceField;
		this.type = getType();
	}

	public Metadata() {}

	public String getSourceField() {
		return sourceField;
	}
	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	
	public String getType () {
		type = sourceField.getClass().getSimpleName();
		return type;
	}

}
