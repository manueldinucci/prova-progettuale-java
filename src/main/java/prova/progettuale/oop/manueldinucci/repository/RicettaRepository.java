package prova.progettuale.oop.manueldinucci.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public interface RicettaRepository extends JpaRepository<Ricetta, Long> {

}
