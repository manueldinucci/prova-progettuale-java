package prova.progettuale.oop.manueldinucci;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import prova.progettuale.oop.manueldinucci.domain.Ricetta;

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
	public static final String BASE_URL = "/metadata";
	@GetMapping
	//CHIAMO LE CLASSI
	ArrayList<Ricetta> ottlis(){
		Ricetta s =  new Ricetta(1998, "O", 126);
		ArrayList<Ricetta> v = new ArrayList<Ricetta>();
		v.add(s);
		return v;
	}
	
}