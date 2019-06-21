package prova.progettuale.oop.manueldinucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GetCSV {
	
	private String url;

	/**
	 * @param url Prende il link da 
	 */
	public GetCSV(String url) {
		this.url = url;
		System.out.println("Analizzo url -> " + url);
	}
	
	private void analizzaUrl() throws MalformedURLException, IOException {
		URLConnection oc = new URL(url).openConnection();
		oc.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; "
				+ "Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
		InputStream in = oc.getInputStream();
		copiaDati(in);
		in.close();
	}
	
	private String copiaDati(InputStream in) throws IOException {
		String datiCopiati = "";
		String riga = "";
		InputStreamReader a = new InputStreamReader(in);
		BufferedReader b = new BufferedReader(a);
		while ((riga=b.readLine()) != null) { 
			datiCopiati += riga;		
		} return datiCopiati;
	}
}	

}