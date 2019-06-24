package prova.progettuale.oop.manueldinucci.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import prova.progettuale.oop.manueldinucci.domain.Metadata;

public interface MetadataService {
	ArrayList<Metadata> stampa() throws MalformedURLException, IOException, ParseException;
}
