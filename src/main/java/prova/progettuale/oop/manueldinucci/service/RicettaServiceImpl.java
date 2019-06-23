package prova.progettuale.oop.manueldinucci.service;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import prova.progettuale.oop.manueldinucci.GetCSV;
import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

@Service
public class RicettaServiceImpl implements RicettaService { 
	/*
	private final RicettaRepository ricettaRepository;
	
	/**
	 * @param ricettaRepository
	 
	public RicettaServiceImpl(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public Ricetta cercaPerId(Long id) {
		return ricettaRepository.getOne(id);
	}
	
	@Override
	public List<Ricetta> findAll() {
		return ricettaRepository.findAll();
	} */
	
	@Override
	public ArrayList<Ricetta> stampa() throws MalformedURLException, IOException, ParseException {
		
			String url = "https://www.dati.gov.it/api/3/action"
					+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
			GetCSV getcsv = new GetCSV(url);
			String nomeFile="dataset_ricette2.csv";
			getcsv.analizzaUrl(nomeFile);
			ParsingCSV par = new ParsingCSV(nomeFile);
			ArrayList<Ricetta> lista = par.parseCsv();
			//System.out.println(lista);
			//for (Ricetta r : lista) {
			//	Ricetta ri = new Ricetta(r.getAnno(),r.getBranca(),r.getQtà());
			//	ri.setBranca(r.getBranca());
			//	ri.setQtà(r.getQtà());
			//	ricettaRepository.save(r);
			//}

			//for (Ricetta r : lista) {System.out.println(r.getBranca());}
			//System.out.println(lista.get(0).getBranca());
			return lista;
	}
}

