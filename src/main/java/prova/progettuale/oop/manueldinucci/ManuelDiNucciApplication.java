package prova.progettuale.oop.manueldinucci; 

import static org.hamcrest.CoreMatchers.containsString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
//import org.springframework.boot.SpringApplication; //Import iniziali
//import org.springframework.boot.autoconfigure.SpringBootApplication; //Import iniziali



//@SpringBootApplication //Commento iniziale
public class ManuelDiNucciApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ManuelDiNucciApplication.class, args); //Riga iniziale
		//DOWNLOAD JSON
		String url = "https://www.dati.gov.it/api/3/action"
				+ "/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
		/*if(args.length == 1)
			url = args[0]; */  //STAVA AL JSON PARSE DI MANCINI

		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in); //Legge i byte e li trasforma in caratteri
				BufferedReader buf = new BufferedReader(inR);
				//Leggo una riga alla volta
				while ((line=buf.readLine()) != null) { 
					data += line;
					System.out.println(line);
				}
			} finally {
				in.close();
			}
			JSONObject obj = (JSONObject)JSONValue.parseWithException(data);
			JSONObject objI = (JSONObject) (obj.get("result"));
			JSONArray objA = (JSONArray) (objI.get("resources"));

			for(Object o: objA) {
				if (o instanceof JSONObject) {
					JSONObject o1 = (JSONObject)o;
					String format = (String)o1.get("format");
					String urlD = (String)o1.get("url");
					//System.out.println(format + " | " + urlD);
					String file = "dataset_ricette.csv";
					if (format.equals("csv")) {
						download(urlD,file);
					}
				}
			}
			System.out.println("Ok");
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static void download(String url, String fileName) throws Exception {
		try (InputStream in = URI.create(url).toURL().openStream()){
			Files.copy(in, Paths.get(fileName));
		}

		//CSV CREATO

		//PARSE CSV
		final String PUNTOVIRGOLA = ";"; //DIVENTA BLU NELLA CLASSE !!AGGIUNGI STATIC!!
		List<List<String>> records = new ArrayList<>();
		Vector<RicetteErogate_Data> v = new Vector<RicetteErogate_Data>();

		try (BufferedReader br = new BufferedReader(new FileReader("dataset_ricette.csv"))){
			String riga;
			br.readLine(); //IGNORA LA PRIMA RIGA
			while ((riga = br.readLine()) != null) {
				String[] valori = riga.split(PUNTOVIRGOLA);
				//System.out.println(valori.length);
				records.add(Arrays.asList(valori));
				String sp = valori[2].replace(".", "");
				//System.out.println(sp);
				v.add(new RicetteErogate_Data(Integer.parseInt(valori[0]),valori[1],Integer.parseInt(sp)));
			}
			//METODO VISUALIZZA
			//System.out.println(v);
			br.close();
		} catch (IOException|NumberFormatException e) {
			System.out.println("ERRORE");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); 
		}

	}

}
