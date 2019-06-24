package prova.progettuale.oop.manueldinucci;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prova.progettuale.oop.manueldinucci.domain.Metadata;
import prova.progettuale.oop.manueldinucci.service.MetadataService;

@RestController
@RequestMapping("/metadata")
public class MetadataController {
	
	private final MetadataService metadataService;
	
	public MetadataController(MetadataService metadataService) {
		this.metadataService = metadataService;
	}
	@GetMapping 	
	ArrayList<Metadata> b() {
		ArrayList<Metadata> meta = new ArrayList<Metadata>();
		try {
			meta = metadataService.stampa();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return meta;
	}
} 