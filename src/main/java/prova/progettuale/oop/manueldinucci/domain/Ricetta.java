package prova.progettuale.oop.manueldinucci.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Ricetta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int anno;
	private String branca;
	private int qtà;

	public Ricetta() {};
	/**
	 * @param anno Anno
	 * @param branca Branca specialistica
	 * @param qtà Quantità di ricette emesse 
	 */
	
	public Ricetta(int anno, String branca, int qtà) {
		this.anno = anno;
		this.branca = branca;
		this.qtà = qtà;
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
	 * @return the qtà
	 */
	public int getQtà() {
		return qtà;
	}
	
	/**
	 * @param qtà the qtà to set
	 */
	public void setQtà(int qtà) {
		this.qtà = qtà;
	}

	@Override
	public String toString() {
		return "\n Anno: " + anno + " -- Branca specialistica: " +
				branca + " -- Numero di ricette: " +
				qtà;
	}	

}
