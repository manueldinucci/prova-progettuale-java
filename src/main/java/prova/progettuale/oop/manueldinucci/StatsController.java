package prova.progettuale.oop.manueldinucci;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prova.progettuale.oop.manueldinucci.domain.Stats;
import prova.progettuale.oop.manueldinucci.service.RicettaService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	private final RicettaService ricettaService;

	public StatsController(RicettaService ricettaService) {
		this.ricettaService = ricettaService;
	}
	
	@GetMapping
	ArrayList<String> a() {
		ArrayList<String> branche = new ArrayList<String>();
		try {
			branche = ricettaService.paginaAiuto();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return branche;
	}
	
	@GetMapping(path="2006")
	ArrayList<Stats> getStats2006() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2006);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2007")
	ArrayList<Stats> getStats2007() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2007);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2008")
	ArrayList<Stats> getStats2008() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2008);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2009")
	ArrayList<Stats> getStats2009() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2009);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2010")
	ArrayList<Stats> getStats2010() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2010);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2011")
	ArrayList<Stats> getStats2011() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2011);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
	
	@GetMapping(path="2012")
	ArrayList<Stats> getStats2012() {
		ArrayList<Stats> statistiche = new ArrayList<Stats>();
		try {
			statistiche = ricettaService.stats(2012);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return statistiche;
	}
}