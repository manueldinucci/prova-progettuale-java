package prova.progettuale.oop.manueldinucci.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import prova.progettuale.oop.manueldinucci.domain.ArrListRicetta;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public interface RicettaRepository extends JpaRepository<ArrListRicetta, Long> {

}
