package prova.progettuale.oop.manueldinucci;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import prova.progettuale.oop.manueldinucci.domain.Metadata;
import prova.progettuale.oop.manueldinucci.domain.Ricetta;


public class CsvParser {
	public String nomeFile;
	private String riga;
	final static String PUNTOVIRGOLA = ";";
	ArrayList<Ricetta> v;

	/**
	 * Costruttore CsvParser
	 * @param nomeFile Nome del file .csv da parsare.
	 */
	public CsvParser(String nomeFile) {
		this.nomeFile=nomeFile;
		v = new ArrayList<Ricetta>();
	}
	
	/**
	 * @return ArrayList contentente i dati del file .csv organizzati nella classe Ricetta.
	 */
	public ArrayList<Ricetta> parseCsv() throws FileNotFoundException, IOException {
		List<List<String>> records = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		br.readLine().split(PUNTOVIRGOLA);
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
	
	/**
	 * @return Prima riga del file .csv che contiene i Metadata.
	 */
	public String[] getPrimaRiga() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String[] primaRiga = br.readLine().split(PUNTOVIRGOLA);
		return primaRiga;
	}
	
	/**
	 * @return Popola la classe Metadata con i metadati del relativo file .csv e la restituisce in un ArrayList.
	 */
	public ArrayList<Metadata> popMetadata() throws IOException {
		String[] primaRiga;
		ArrayList<Metadata> m = new ArrayList<Metadata>();
			primaRiga = getPrimaRiga();
			for (int i=0; i<primaRiga.length; i++) {
				m.add(new Metadata(primaRiga[i]));
			} return m;
	}
	
	/**
	 * @return numero di branche specialistiche 
	 */
	public int numElem (int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int e=0;
		for (int i=0; i<a.size(); i++) {
			if (a.get(i).getAnno()==anno) e++;
		} return e;
	}

	/**
	 * @param anno Anno dal quale calcolare il totale delle ricette emesse 
	 * @return totale delle ricette emesse in un dato anno
	 */
	public int totale(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int tot=0;
		for (Ricetta r : a) {
			if (r.getAnno()==anno)
			tot+=r.getQty();
		}
		return tot;
	}
	
	/**
	 * @param anno Anno dal quale calcolare la media delle ricette emesse tra le varie branche specialistiche
	 * @return Media delle ricette emesse tra le varie branche specialistiche in un dato anno 
	 */
	public double media(int anno) throws FileNotFoundException, IOException {
		@SuppressWarnings("unused")
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int totale = totale(anno);
		int n = numElem(anno);
		return totale/n;
	}
	
	/**
	 * @param anno Anno dal quale calcolare il massimo delle ricette emesse tra le varie branche specialistiche
	 * @return Numero massimo di ricette emesse tra le varie branche specialistiche
	 */
	public int max(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int max=0;
		if (a.get(0).getAnno()==anno) {a.get(0).getQty();}
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {
				if (r.getQty() > max) {
					max = r.getQty();
				}
			}
		} return max;
	}
	
	/**
	 * @param anno Anno dal quale calcolare il minimo delle ricette emesse tra le varie branche specialistiche
	 * @return Numero minimo di ricette emesse tra le varie branche specialistiche
	 */
	public int min(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int m = max(anno);
		if (a.get(0).getAnno()==anno) {a.get(0).getQty();}
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {
				if (r.getQty() < m) {
					m = r.getQty();
				}
			}
		} return m;
	}
	
	/**
	 * @param anno Anno dal quale calcolare la deviazione standard
	 * @return Deviazione standard del numero di ricette emesse in un dato anno
	 */
	public double devStd(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		double m = media(anno);
		int tot = totale(anno);
		double e=0;
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {e+=Math.pow(r.getQty()-m, 2);}
		}
		double f = e/tot;
		double devStd = Math.sqrt(f);
		return devStd;
	} 
}