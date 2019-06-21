package prova.progettuale.oop.manueldinucci.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import prova.progettuale.oop.manueldinucci.Ricetta;

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
public class DatiRicController {
   @RequestMapping(value="/ricetta", method = RequestMethod.GET)
   public ModelAndView ricette() {
	   return new ModelAndView("ricetta", "command", new Ricetta());
   }
   @RequestMapping(value="/addRicetta",method=RequestMethod.POST)
   public String addRicetta(@ModelAttribute("SALUTM")Ricetta red,
		   ModelMap model) {
	   model.addAttribute("year", red.getAnno());
	   model.addAttribute("branca", red.getBranca());
	   model.addAttribute("qty", red.getQtà());
	   return "result";
   }
}