package prova.progettuale.oop.manueldinucci.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import prova.progettuale.oop.manueldinucci.GetCSV;
import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.Metadata;

public class MetadataServiceImpl implements MetadataService {

	@Override
	public ArrayList<Metadata> stampa() throws MalformedURLException, IOException, ParseException {
		Metadata m1 = new Metadata();
		Metadata m2 = new Metadata();
		Metadata m3 = new Metadata();
		ArrayList<Metadata> m = new ArrayList<Metadata>();
		String url = "https://www.dati.gov.it/api/3/action"
				+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
		GetCSV getcsv = new GetCSV(url);
		String nomeFile="dataset_ricette3.csv";
		getcsv.analizzaUrl(nomeFile);
		ParsingCSV p = new ParsingCSV(nomeFile);
		String[] meta = p.getPrimaRiga();
		m.add(m1.setSourceField(meta[0]));
		m.add(m2.setSourceField(meta[1]));
		m.add(m3.setSourceField(meta[2]));		
		return m;
	} 

}
