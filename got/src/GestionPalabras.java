package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GestionPalabras {
	
	private List<Map.Entry<String, Integer>> lista;
	private int total;

	public GestionPalabras(int totalPalabras) {
		total= totalPalabras;
	}
	

	@SuppressWarnings("unchecked")
	public void ordenarHash( HashMap<String,Integer> palabrasArchivo){
		
		lista= new LinkedList<Map.Entry<String, Integer>> (palabrasArchivo.entrySet());
		Collections.sort(lista, new Comparador() );

	}
	
	public String listaPalabras(int cantidad) {
	
		String masUsadas=" ";
		
		int index=0;
		
		Iterator<Entry<String, Integer>> iterador = lista.iterator();
		
		
		while (iterador.hasNext() && index<cantidad )  { 
		
			
			 Map.Entry<String,Integer> entrada =  iterador.next ();  
			 masUsadas+= entrada.getKey()+ " aparece un total de: "+ porcentaje( entrada.getValue(), total)+" % ";
			 masUsadas+= '\n';
			 index= index+1;
			 
		}  
		
		return masUsadas;

	}
	
	private double porcentaje(Integer cant, int total) {
		return (cant*100) / total;
	}
	
	
}
