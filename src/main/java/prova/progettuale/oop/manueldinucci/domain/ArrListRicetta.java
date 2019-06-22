package prova.progettuale.oop.manueldinucci.domain;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ArrListRicetta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ArrayList<Ricetta> al;

	public ArrListRicetta(ArrayList<Ricetta> al) {
		this.al = al;
	}

	public ArrayList<Ricetta> getAl() {
		return al;
	}

	public void setAl(ArrayList<Ricetta> al) {
		this.al = al;
	}


	

}
