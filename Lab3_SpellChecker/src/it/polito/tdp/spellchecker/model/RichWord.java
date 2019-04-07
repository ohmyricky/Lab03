package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String parola;
	private Boolean corretta;
	
	public RichWord(String parola, Boolean corretta) {
		super();
		this.parola = parola;
		this.corretta = corretta;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public Boolean getCorretta() {
		return corretta;
	}
	public void setCorretta(Boolean corretta) {
		this.corretta = corretta;
	}
	@Override
	public String toString() {
		return String.format("%s/n", parola);
	}
	
	

}
