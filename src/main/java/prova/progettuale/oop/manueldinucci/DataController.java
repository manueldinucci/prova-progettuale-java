package prova.progettuale.oop.manueldinucci;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.service.RicettaService;

@RestController
@RequestMapping("/data")
public class DataController {
	
	private final RicettaService ricettaService;

	public DataController(RicettaService ricettaService) {
		this.ricettaService = ricettaService;
	}
	/**
	 * @return Su richiesta, all'indirizzo localhost:8080/data restituisce la lista completa delle ricette, suddivise per specialità diagnostica,
	 *  erogate negli ambulatori lombardi ai soli residenti nel comune di Milano dal 2006 al 2012
	 */
	@GetMapping 	
	ArrayList<Ricetta> a() {
		ArrayList<Ricetta> data = new ArrayList<Ricetta>();
		try {
			data = ricettaService.stampa();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} return data;
	}
} 
