package prova.progettuale.oop.manueldinucci.service;

import java.util.ArrayList;
import java.util.List;

import prova.progettuale.oop.manueldinucci.domain.ArrListRicetta;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public interface RicettaService { 
	ArrListRicetta cercaPerId(Long id);
	List<ArrListRicetta> findAll();
}
