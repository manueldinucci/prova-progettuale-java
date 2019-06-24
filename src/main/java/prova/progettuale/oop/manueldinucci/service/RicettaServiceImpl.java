package prova.progettuale.oop.manueldinucci.service;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import prova.progettuale.oop.manueldinucci.GetCSV;
import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.domain.Stats;

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
			ParsingCSV par = new ParsingCSV("dataset_ricette.csv");
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

	@Override
	public ArrayList<String> paginaAiuto() throws FileNotFoundException, IOException {
		ArrayList<String> a = new ArrayList<String>();
		String b = "Benvenuto nella pagina delle statistiche,"
				+ " aggiungi / all'url e subito dopo scrivi"
				+ "  l'anno (tra il 2006 e il 2012) di cui vorresti"
				+ " conoscerne le statistiche. ";
		a.add(b);
		return a;
	} 
	
	public ArrayList<Stats> stats(int anno) throws MalformedURLException, IOException, ParseException {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		ParsingCSV par = new ParsingCSV("dataset_ricette.csv");
		String field = "RicetteStat" + anno;
		int tot = par.totale(anno);
		double media = par.media(anno);
		int max = par.max(anno);
		int min = par.min(anno);
		double devStd = par.devStd(anno);
		Stats s = new Stats(field,tot,media,max,min,devStd);
		statistiche.add(s);
		return statistiche;
	}
}

