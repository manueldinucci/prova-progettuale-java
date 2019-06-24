package prova.progettuale.oop.manueldinucci.service;

import java.io.IOException;
import java.net.MalformedURLException;

import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import prova.progettuale.oop.manueldinucci.ParsingCSV;
import prova.progettuale.oop.manueldinucci.domain.Metadata;

@Service
public class MetadataServiceImpl implements MetadataService {

	@Override
	public ArrayList<Metadata> stampa() throws MalformedURLException, IOException, ParseException {
		ArrayList<Metadata> m = new ArrayList<Metadata>();
		ParsingCSV p = new ParsingCSV("dataset_ricette.csv");
		m = p.popMetadata();
		return m;
	} 


} 
