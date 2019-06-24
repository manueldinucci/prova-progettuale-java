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
