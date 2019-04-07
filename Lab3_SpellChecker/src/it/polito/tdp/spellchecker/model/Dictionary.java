package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {								//MODEL
	
	private List<String> dizionario;
	private List<RichWord> risultato;
	
	public void loadDictionary(String language) {
		
		dizionario=new ArrayList<String>();		
		
		//se la lingua è italiano carica su questo altrimenti nell'altro
		//tutto il dizionario del .txt è da aggiungere in una lista ogni volta
		
		if(language.contains("English")) {
			try {
				FileReader fr = new FileReader("rsc/English.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					dizionario.add(word);
				} br.close();
				System.out.println("Dizionario " + language + " loaded. Found " + dizionario.size() + " words.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Errore nella lettura del file");
			}
		} else if(language.contains("Italiano")) {
			try {
				FileReader fr = new FileReader("rsc/Italian.txt");
				BufferedReader br=new BufferedReader(fr);
				String word;
				while((word=br.readLine())!=null) {
					dizionario.add(word);
				} br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Errore nella lettura del file");
			}
		}
		
	}
	
	public List<RichWord> spellCheckTest(List<String> inputTextList){
		
		risultato=new ArrayList<RichWord>();
		
		for(String temp: inputTextList) {
			RichWord rw=new RichWord(temp, true);
			for(String load: dizionario) {
				if(!dizionario.contains(temp)) {
					rw.setCorretta(false);
					risultato.add(rw);
				}
			}
		}
		return risultato;
	}

}
