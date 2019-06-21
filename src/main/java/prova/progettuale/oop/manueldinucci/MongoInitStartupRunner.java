package prova.progettuale.oop.manueldinucci;

import org.springframework.stereotype.Component;

import prova.progettuale.oop.manueldinucci.domain.DatiRicette;
import prova.progettuale.oop.manueldinucci.repositories.DatiRicRepository;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

@Component
public class MongoInitStartupRunner implements ApplicationRunner {
	@Autowired
	private DatiRicRepository datiRicRepository;
	
	@Override
	public void run(ApplicationArguments args) {
		if(datiRicRepository.findAll().isEmpty()) {
			DatiRicette datiRicette1 = new DatiRicette();
			datiRicette1.setAnno(2000);
			datiRicette1.setBrancaSpecialistica("mo vedo");
			datiRicette1.setNumRicette(12042);
			
			datiRicRepository.saveAll(Arrays.asList(datiRicette1));
		}
	}
	
}
