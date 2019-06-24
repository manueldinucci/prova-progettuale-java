package prova.progettuale.oop.manueldinucci.domain;

public class Metadata {

	private String sourceField;
	private String type;

	/**
	 * @param sourceField Nome campo 
	 * @param type Tipo restituito
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
