package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class Archivo extends Component {

	public String archivo;
	
	public Archivo(File f) {
		
		super(f.getAbsolutePath());
		totalPalabras = 0;
	}

	public String obtenerPalabrasMasUsadasArchivo(int cantidad,HashMap<String, Integer> palabrasArchivo,int  cantidadPalabrasArchivo) {
		
		GestionPalabras gp = new GestionPalabras ();
		gp.ordenarHash(palabrasArchivo);
		return gp.listaPalabras(cantidad, cantidadPalabrasArchivo);	
	}
		
	public int cargarPalabras(HashMap<String, Integer> palabrasArchivo) {
		
		boolean encontre = false;
		int cantidadPalabras = 0;
		
	try {	
			BufferedReader br= new BufferedReader(new FileReader(path));
			String linea= br.readLine();
			
			
			while(linea != null) {
				
				LinkedList<String> palabras = soloPalabra(linea);
				int j=0;
				
				while ( j< palabras.size()) {
			
					String palabra = palabras.get(j);
					cantidadPalabras = cantidadPalabras+1;  
					
					for( int i= 0; i < palabrasArchivo.keySet().toArray().length && !encontre; i++) { 
				
					
						String key= (String) palabrasArchivo.keySet().toArray()[i];
						char arrayPalabra[ ] = palabra.toCharArray();
						char arrayKey[] = key.toCharArray();
												
					
						if ( arrayPalabra.length == arrayKey.length ) {
							
							encontre = sonIguales(arrayPalabra,arrayKey);
													
							if( encontre ) {
								
								int valor= palabrasArchivo.get(key); 
								palabrasArchivo.replace(key, valor+1);
							}
						}
	
					}
					
					if (!encontre) { 
					
						palabrasArchivo.put(palabra,1); 
					}
					
					encontre= false;
					j++;
				} 
				
				linea= br.readLine(); 
				
				} 
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				}
	
		return cantidadPalabras;
	}

	private boolean sonIguales (char [] arrayPalabra, char[]arrayKey) {
	
		boolean ret= true;
		
	
		if( arrayPalabra.length != 0 ||  arrayKey.length !=0 ) {
			
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
		} else ret= false;
		
		return ret;
	}
	
	private LinkedList<String> soloPalabra(String cadena) {
			
		boolean s = true;
		char[] c = cadena.toCharArray();
		LinkedList<String> palabra = new LinkedList<String>();
		int i=0;
		
		while (i<c.length ) {
			
			String p="";
			
			for ( ; ( s && i<c.length); i++) {
				
				char leido = c[i];
				//System.out.println("leido: "+leido);
				if( esCaracterValido( leido )) {
					
					p+= Character.toString(leido);	
					
				} else s = false;
				
			}
				
			s = true;
			
			if( p!= "") {
			
				palabra.add(p);	
			}
		
		}
	return palabra;
	
	}
		
	private boolean esCaracterValido(char c) {
		
		boolean ret = true;
		
		 if (! (   (c>= 'Ç' && c<='Ü' ) || (c>= 'á' && c<='Ñ' ) || (c>= 'Á' && c<='À' ) || (c== 'ã' || c=='Ã' ) || (c>= 'ð' && c<='Ï' ) || (c>= 'Ú' && c<='Ý' ) || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') )   ) { 
			 ret = false;
		 }
		return ret;
	}
	
	public String getPath() {
		return path;
	}
	
}
