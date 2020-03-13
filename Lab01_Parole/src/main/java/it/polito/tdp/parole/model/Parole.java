package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		
	List <String> listaParole = new LinkedList<String>();
	
	public Parole() {
		//TODO
	}
	
	public void addParola(String p) {
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		//Elenco in ordine alfabetico
		Collections.sort(listaParole);
		return listaParole;
	}
	
	public void reset() {
		listaParole.clear(); 
	}

}
