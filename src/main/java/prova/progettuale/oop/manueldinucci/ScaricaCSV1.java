package prova.progettuale.oop.manueldinucci;

import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScaricaCSV1 {
	/**
	 * 
	 * @param url
	 * @param nomeFile
	 * @return 
	 * @throws Exception
	 */
	public void scarica (String url, String nomeFile)  throws Exception {
		try (InputStream in = URI.create(url).toURL().openStream()){
			Files.copy(in, Paths.get(nomeFile));
		}
	}

}
