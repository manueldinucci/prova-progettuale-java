package prova.progettuale.oop.manueldinucci.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@NoArgsConstructor
@Document(collection="dati ricette")
public class DatiRicette {
	private @NonNull int anno;
	private @NonNull String brancaSpecialistica;
	private @NonNull int numRicette;
	public void setAnno(int anno) {
	 this.anno=anno;
	}
	
	public void setBrancaSpecialistica(String brancaSpecialistica) {
		this.brancaSpecialistica=brancaSpecialistica;
	}
	public void setNumRicette(int numRicette) {
		this.numRicette=numRicette;
		
	}
}
