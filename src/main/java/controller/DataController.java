package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import prova.progettuale.oop.manueldinucci.domain.ArrListRicetta;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;
import prova.progettuale.oop.manueldinucci.service.RicettaService;

//@RestController
//public class DatiRicController {
	//@RequestMapping("/")
//	public String hosta(String a) {
//		return a;
//	} 
//} 

//server.port: 8080
//server.servlet.context-path:/metadata DA METTERE AD application.properties

@RestController
@RequestMapping(DataController.BASE_URL)
public class DataController {
	
	public static final String BASE_URL = "/data";
	private final RicettaService ricettaService;

	public DataController(RicettaService ricettaService) {
		this.ricettaService = ricettaService;
	}
	
	@GetMapping 	
	List<ArrListRicetta> getTuttiIDati(){
		return ricettaService.findAll();
	}
}
