package prova.progettuale.oop.manueldinucci;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova.progettuale.oop.manueldinucci.service.MetadataService;

@RestController
@RequestMapping("/metadata")
public class MetadataController {
	
	private final MetadataService metadataService;
	
	public MetadataController(MetadataService metadataService) {
		this.metadataService = metadataService;
	}
	@GetMapping 	
	List<Ricetta> a() throws MalformedURLException, IOException, ParseException{
		return ricettaService.stampa();
	}
} 