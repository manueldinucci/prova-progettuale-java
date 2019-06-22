package prova.progettuale.oop.manueldinucci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import prova.progettuale.oop.manueldinucci.domain.Ricetta;

public class ParsingCSV {
	private String nomeFile;
	private String riga;
	private Metadata md;
	final static String PUNTOVIRGOLA = ";";
	List<List<String>> records;
	ArrayList<Ricetta> v;

	public ParsingCSV(String nomeFile) {
		this.setNomeFile(nomeFile);
		records = new ArrayList<>();
		v = new ArrayList<Ricetta>();
	}
	
	public ArrayList<Ricetta> parseCsv() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String[] metaData = br.readLine().split(PUNTOVIRGOLA);
		setMetadata(metaData[0],metaData[1],metaData[2]);
		while ((riga = br.readLine()) != null) {
			String[] valori = riga.split(PUNTOVIRGOLA);
			records.add(Arrays.asList(valori));
			String valori2corretto = valori[2].replace(".", "");
			v.add(new Ricetta(Integer.parseInt(valori[0]),valori[1],
					Integer.parseInt(valori2corretto)));
		}
		br.close();
		return v;
	}

	public void setMetadata(String a, String b, String c) {
		setMd(new Metadata(a,b,c));
	}

	/**
	 * @return the md
	 */
	public Metadata getMd() {
		return md;
	}

	/**
	 * @param md the md to set
	 */
	public void setMd(Metadata md) {
		this.md = md;
	}

	/**
	 * @return the nomeFile
	 */
	public String getNomeFile() {
		return nomeFile;
	}

	/**
	 * @param nomeFile the nomeFile to set
	 */
	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}
}
