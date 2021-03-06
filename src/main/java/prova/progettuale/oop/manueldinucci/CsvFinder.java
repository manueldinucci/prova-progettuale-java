package prova.progettuale.oop.manueldinucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class CsvFinder {
	
	private String url;

	/**
	 * @param url Prende il link da analizzare
	 */
	public CsvFinder(String url) {
		this.url=url;
	}	

	/**
	 * @param nomeFile Nome da assegnare al file .csv 
	 * @return Analizza il json della pagina web ed effettua il download del file.csv. 
	 * Ritorna il nome assegnato al file .csv
	 */
	public String analizzaUrl(String nomeFile) throws MalformedURLException, 
		IOException, ParseException {
		String datiCopiati;
		URLConnection oc = new URL(url).openConnection();
		oc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; "
				+ "Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
		InputStream in = oc.getInputStream();
		try {
			datiCopiati = copiaDati(in);
		} finally {in.close();}
		JSONObject obj = (JSONObject)JSONValue.parseWithException(datiCopiati);
		JSONObject objI = (JSONObject) (obj.get("result"));
		JSONArray objA = (JSONArray) (objI.get("resources"));
		for(Object o: objA) {
			if (o instanceof JSONObject) {
				JSONObject o1 = (JSONObject)o;
				String format = (String)o1.get("format");
				String url2 = (String)o1.get("url");
				if (format.equals("csv")) {
					System.out.println("File .csv trovato!");
					download(url2,nomeFile);
				}
			}
		} return nomeFile;
	}

	/**
	 * @return Copia i dati contenuti nella pagina web e li inserisce in un'unica stringa
	 */
	public static String copiaDati(InputStream in) throws IOException {
		String datiCopiati = "";
		String riga = "";
		InputStreamReader a = new InputStreamReader(in);
		BufferedReader b = new BufferedReader(a);
		while ((riga=b.readLine()) != null) { 
			datiCopiati += riga;		
		} return datiCopiati;
	}
	
	/**
	 * @param url URL da utilizzare per il download
	 * @param nomeFile Nome da assegnare al file scaricato
	 */
	public static void download(String url, String nomeFile) 
			throws MalformedURLException, IOException {
		try (InputStream in = URI.create(url).toURL().openStream()){
			Files.copy(in, Paths.get(nomeFile));
			System.out.println("Download file " + nomeFile + " completato!");
		}  
	}
}	