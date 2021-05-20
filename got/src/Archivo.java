package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Archivo extends Component {

	public String archivo;
	//HashMap<String, Integer> palabrasArchivo;
	
	public Archivo(File f) {
		
		super(f.getAbsolutePath());
		//palabrasArchivo = new HashMap<String,Integer>();
		
		
	}

	@Override
	public void agregarArchivo() {
		// TODO Auto-generated method stub
		
	}


	public String obtenerParabrasMasUsadasArchivo(int cantidad,HashMap<String, Integer> palabrasArchivo) {
		
		String masUsadas=" ";
		
		GestionPalabras gp = new GestionPalabras (totalPalabras);
		gp.ordenarHash(palabrasArchivo);
		
	return gp.listaPalabras(cantidad);
		
	}
	
	public String getP() {
		return path;
	}
	
	public void cargarPalabras(HashMap<String, Integer> palabrasArchivo) {
		
		boolean encontre = false;
		
	try {	
			BufferedReader br= new BufferedReader(new FileReader(path));
		
			String linea= br.readLine();
			
			
			
			while(linea != null) {
				
				String[] palabras= linea.split(" "); // ver que hacer con los puntos y comas.
								
				for(int j = 0; j< palabras.length ; j++) { // voy leyendo la linea y saco palabras.
					
					String palabra= palabras[j];
					
					totalPalabras= totalPalabras+1;  // cuenta todas las palabras
					
					for( int i= 0; i < palabrasArchivo.keySet().toArray().length && !encontre; i++) { //recorro las claves contenidas en el map
				
						String key= (String) palabrasArchivo.keySet().toArray()[i];
						char arrayPalabra[ ] = palabra.toCharArray();
						char arrayKey[] = key.toCharArray();
						
						
						if ( arrayPalabra.length == arrayKey.length ) {
							
							encontre = sonIguales(arrayPalabra,arrayKey);
													
							if( encontre ) {
								int valor= palabrasArchivo.get(key); // retorna el valor que tiene la clave
								palabrasArchivo.replace(key, valor+1); // reemplazo y cargo el nuevo valor

								
							}
						}
	
					}
					
					if (!encontre) { 
		
						palabrasArchivo.put(palabra,1); 
						
			
					}
					
					encontre= false;
				} 
				
				linea= br.readLine(); 
				
				} 
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
	}

	}


	private boolean sonIguales (char [] arrayPalabra, char[]arrayKey) {
	
		boolean ret= true;
		char a1 = Character.toLowerCase( arrayPalabra[0]);
		char a2 = Character.toUpperCase( arrayPalabra[0]);
		
		if( a1 == (arrayKey[0]) || a2 == arrayKey[0] ) {
		
			for(int i= 1 ; ret && i<arrayPalabra.length ;i++){
			
				char letra1 = arrayPalabra[i];
				char letra2 = arrayKey[i];
			
				if( letra1 != letra2) {
					ret = false;
				}
			}
			
		} else ret  = false;
		
		return ret;
	}
	

	
	
	
	
	
	
	
}
