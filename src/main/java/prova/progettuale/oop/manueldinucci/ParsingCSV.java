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

public class ParsingCSV {
	public String nomeFile;
	private String riga;
	final static String PUNTOVIRGOLA = ";";
	ArrayList<Ricetta> v;

	public ParsingCSV(String nomeFile) {
		this.nomeFile=nomeFile;
		v = new ArrayList<Ricetta>();
	}
	
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
	
	public String[] getPrimaRiga() throws IOException {
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String[] primaRiga = br.readLine().split(PUNTOVIRGOLA);
		return primaRiga;
	}
	
	public ArrayList<Metadata> popMetadata() throws IOException {
		String[] primaRiga;
		ArrayList<Metadata> m = new ArrayList<Metadata>();
			primaRiga = getPrimaRiga();
			for (int i=0; i<primaRiga.length; i++) {
				m.add(new Metadata(primaRiga[i]));
			} return m;
	}

	public int totale(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int tot=0;
		for (Ricetta r : a) {
			if (r.getAnno()==anno)
			tot+=r.getQtà();
		}
		return tot;
	}
	public int numElem (int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int e=0;
		for (int i=0; i<a.size(); i++) {
			if (a.get(i).getAnno()==anno) e++;
		} return e;
	}
	
	public double media(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int totale = totale(anno);
		int n = numElem(anno);
		return totale/n;
	}
	
	public int max(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int max=0;
		if (a.get(0).getAnno()==anno) {a.get(0).getQtà();}
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {
				if (r.getQtà() > max) {
					max = r.getQtà();
				}
			}
		} return max;
	}
	
	public int min(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		int m = max(anno);
		if (a.get(0).getAnno()==anno) {a.get(0).getQtà();}
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {
				if (r.getQtà() < m) {
					m = r.getQtà();
				}
			}
		} return m;
	}
	
	public double devStd(int anno) throws FileNotFoundException, IOException {
		ArrayList<Ricetta> a = new ArrayList<Ricetta>();
		a = parseCsv();
		double m = media(anno);
		int tot = totale(anno);
		double e=0;
		for (Ricetta r : a) {
			if (r.getAnno()==anno) {e+=Math.pow(r.getQtà()-m, 2);}
		}
		double f = e/tot;
		double devStd = Math.sqrt(f);
		return devStd;
	} 
}