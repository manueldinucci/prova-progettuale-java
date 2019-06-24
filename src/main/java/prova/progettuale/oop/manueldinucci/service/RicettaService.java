package prova.progettuale.oop.manueldinucci.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.domain.Stats;

public interface RicettaService { 
	ArrayList<Ricetta> stampa()throws MalformedURLException, IOException, ParseException;
	ArrayList<Stats> stats(int anno)throws MalformedURLException, IOException, ParseException;
	ArrayList<String> paginaAiuto() throws FileNotFoundException, IOException;
}