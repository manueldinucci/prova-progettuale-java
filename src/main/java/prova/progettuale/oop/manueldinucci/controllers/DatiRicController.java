package prova.progettuale.oop.manueldinucci.controllers;

import prova.progettuale.oop.manueldinucci.domain.DatiRicette;
import prova.progettuale.oop.manueldinucci.services.DatiRicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prova")
public class DatiRicController{
	@Autowired
	private DatiRicService datiRicService;
	
	@GetMapping
	public List<DatiRicette> getAll(){
		return datiRicService.getList();
	}
	
	/*@GetMapping("/{id}")
	public DatiRicette getById(@PathVariable("id") String id) {
		return datiRicService.getById(id).orElse(null);
	}*/
	
	@PostMapping
	public DatiRicette create(@RequestBody DatiRicette datiRicette) {
		return datiRicService.create(datiRicette);
	}
	
	/*@PutMapping("/{id}")
	public DatiRicette update(@PathVariable("id") String id, @RequestBody DatiRicette) {
		return datiRicService.update(datiRicette);
	}*/
	
	/*@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		datiRicService.delete(id);
	}*/
}
//server.port: 8080
//server.servlet.context-path:/metadata DA METTERE AD application.properties