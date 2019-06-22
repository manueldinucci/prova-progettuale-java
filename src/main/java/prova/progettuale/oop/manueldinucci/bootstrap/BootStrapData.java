package prova.progettuale.oop.manueldinucci.bootstrap;


import java.io.IOException;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import prova.progettuale.oop.manueldinucci.GetCSV;
import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.ArrListRicetta;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.repository.RicettaRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	public BootStrapData(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	private final RicettaRepository ricettaRepository;
	@Override
	public void run(String... args) throws Exception {

		try {
			String url = "https://www.dati.gov.it/api/3/action"
					+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
			GetCSV getcsv = new GetCSV(url);
			String nomeFile="dataset_ricette2.csv";
			getcsv.analizzaUrl(nomeFile);
			ParsingCSV par = new ParsingCSV(nomeFile);
			ArrayList<Ricetta> lista = par.parseCsv();
			ArrListRicetta alr = new ArrListRicetta(lista);
			ricettaRepository.save(alr);
			//for (Ricetta r : lista) {System.out.println(r.getBranca());}
			//System.out.println(lista.get(0).getBranca());
		} catch (IOException e) {
			System.out.println("Dataset non trovato!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
