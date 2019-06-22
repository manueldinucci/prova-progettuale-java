package prova.progettuale.oop.manueldinucci.service;

import java.util.List;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public interface RicettaService { 
	Ricetta cercaPerId(Long id);
	List<Ricetta> ottieniList();
	List<Ricetta> findAll();
}
