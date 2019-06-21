package prova.progettuale.oop.manueldinucci.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import prova.progettuale.oop.manueldinucci.domain.DatiRicette;

public interface DatiRicRepository extends MongoRepository<DatiRicette, String>{

}
