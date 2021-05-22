package src;

import java.io.File;
import java.util.HashMap;

public class Logica {
	
	private DirectorioArchivos carpeta;
	private Archivo arch;
	private HashMap<String, Integer> palabrasArchivosCarpeta;
	
	public Logica() {	}
	
	public boolean esValido(File file) {
		
		carpeta = new DirectorioArchivos(file);
		boolean esValido = carpeta.contieneTxt();
			
		
		if( esValido) {
			
			palabrasArchivosCarpeta = new HashMap<String,Integer>();
			carpeta.cargarPalabras(palabrasArchivosCarpeta);
		}
		
		return esValido;			
	}
	
	public String obtenerPalabrasMasUsadasDirectorio(int cantidad) {
		return carpeta.obtenerParabrasMasUsadasDirectorio(5, palabrasArchivosCarpeta);
	}


	public String seleccionArchivo(File f) {
		
		arch = new Archivo( f);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		arch.cargarPalabras(palabrasArchivo);
		
		return arch.obtenerParabrasMasUsadasArchivo(100,palabrasArchivo);
	
	}
	
	
	public String[] cargarArchi() {
	
		return carpeta.obtenerArchivos();
	}
}
