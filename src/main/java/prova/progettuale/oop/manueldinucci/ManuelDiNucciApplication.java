package prova.progettuale.oop.manueldinucci; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
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
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8";
		if(args.length == 1)
			url = args[0]; 
 
		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User Agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
			InputStream in = openConnection.getInputStream();

			String data = "";
			String line = "";
			try {
				InputStreamReader inR = new InputStreamReader(in); //Legge i byte e li trasforma in caratteri
				BufferedReader buf = new BufferedReader(inR);

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
					System.out.println(format + " | " + urlD);
					if (format.equals("csv")) {
						download(urlD,"t1.csv");
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
	}

}
