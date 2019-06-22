package prova.progettuale.oop.manueldinucci.bootstrap;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import prova.progettuale.oop.manueldinucci.GetCSV;
import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.repository.RicettaRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	/**
	 * @param ricettaRepository
	 */
	public BootStrapData(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	private final RicettaRepository ricettaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		String url = "https://www.dati.gov.it/api/3/action"
				+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
		
		GetCSV getcsv = new GetCSV(url);
		try {
			String nomeFile = getcsv.analizzaUrl();
			ParsingCSV par = new ParsingCSV(nomeFile);
			ArrayList<Ricetta> elenco = par.parseCsv();
			//for (Ricetta r : elenco) {System.out.println(r.getBranca());}
			//System.out.println(elenco.get(0).getBranca());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException | NumberFormatException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
