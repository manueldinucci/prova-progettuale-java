package prova.progettuale.oop.manueldinucci.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import prova.progettuale.oop.manueldinucci.CsvParser;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.domain.Stats;

@Service
public class RicettaServiceImpl implements RicettaService { 

	/**
	 * @return Lista completa
	 */
	@Override
	public ArrayList<Ricetta> stampa() throws MalformedURLException, IOException, ParseException {
		CsvParser par = new CsvParser("dataset_ricette.csv");
		ArrayList<Ricetta> lista = par.parseCsv();
		return lista;
	}

	/**
	 * @return Pagina statistiche
	 */
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

	/**
	 *@return Statistiche di un dato anno
	 */
	@Override
	public ArrayList<Stats> stats(int anno) throws MalformedURLException, IOException, ParseException {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		CsvParser par = new CsvParser("dataset_ricette.csv");
		String field = "RicetteStatAnno" + anno;
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

