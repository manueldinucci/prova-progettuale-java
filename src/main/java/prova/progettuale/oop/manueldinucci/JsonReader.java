package prova.progettuale.oop.manueldinucci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.boot.configurationprocessor.json.JSONException;

//JsonReader - importa il contenuto del Json in una stringa
public class JsonReader {
	
	private String leggiTutto(Reader lettore) throws IOException {
		StringBuilder data = new StringBuilder();
		int datoLetto;
		while ((datoLetto=lettore.read()) != -1) { //Leggo tutti i caratteri
			data.append((char)datoLetto);
		}
		return data.toString(); //Restituisce una stringa contenente tutti i dati
	}
	
	public JSONObject leggiJsonDaUrl(String url) throws IOException, JSONException, ParseException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = leggiTutto(rd);
			JSONObject json = (JSONObject)JSONValue.parseWithException(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
/* COSA SAREBBE DOVUTO ANDARE NEL MAIN
 * 		try {
			JsonReader json = new JsonReader();
			JSONObject json2 = json.leggiJsonDaUrl("https://www.dati.gov.it/api/3/action/package_show?id=e2f33c10-303c-4cd6-9a23-e3e8f57caeb8");
			System.out.println(json2.toJSONString());
		} catch (IOException | JSONException | ParseException e) {
			e.printStackTrace();
		}
		
 */
}
