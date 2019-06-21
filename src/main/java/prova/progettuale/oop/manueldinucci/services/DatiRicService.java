package prova.progettuale.oop.manueldinucci.services;

import prova.progettuale.oop.manueldinucci.domain.DatiRicette;
import prova.progettuale.oop.manueldinucci.repositories.DatiRicRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
//import java.util.Optional;

@Service
public class DatiRicService {
	@Autowired
	private DatiRicRepository datiRicRepository;
	
	public List<DatiRicette> getList() {
		return datiRicRepository.findAll();
	}
	
	/*public Optional<DatiRicette> getById(String id){
		return datiRicRepository.findById(id);
	} */
	
	public DatiRicette create(DatiRicette datiRicette) {
		return datiRicRepository.insert(datiRicette);
	}
	
	public DatiRicette update(DatiRicette datiRicette) {
		return datiRicRepository.save(datiRicette);
	}
	
	/*public void delete(String id) {
		datiRicRepository.deleteById(id);
	}*/
}
