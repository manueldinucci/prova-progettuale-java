package prova.progettuale.oop.manueldinucci; 

import java.net.MalformedURLException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; 

@SpringBootApplication
public class ManuelDiNucciApplication {

	public static void main(String[] args) {

		SpringApplication.run(ManuelDiNucciApplication.class, args);

		String url = "https://www.dati.gov.it/api/3/action"
				+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";

		GetCSV getcsv = new GetCSV(url);
		try {
			getcsv.analizzaUrl("dataset_ricette.csv");
		} catch (MalformedURLException e) {
			System.out.println("Errore! URL errato!");
			e.printStackTrace();
		} catch (IOException | ParseException e) {
			System.out.println("Errore analisi url");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Errore analisi url");
			e.printStackTrace();
		}
	}
}
