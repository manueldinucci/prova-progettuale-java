package prova.progettuale.oop.manueldinucci.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import prova.progettuale.oop.manueldinucci.MetadataService;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public interface RicettaService { 
	//Ricetta cercaPerId(Long id);
	//List<Ricetta> findAll();
	ArrayList<Ricetta> stampa()throws MalformedURLException, IOException, ParseException;
}