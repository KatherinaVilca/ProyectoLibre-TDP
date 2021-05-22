package src;

import java.io.File;
import java.util.HashMap;

public class Logica {
	
	private DirectorioArchivos carpeta;
	private Archivo arch;
	private HashMap<String, Integer> palabrasArchivosCarpeta;
	private int cantidadPalabrasCarpeta ;
	private int cantidadPalabrasArchivo;
	
	public Logica() {	}
	
	public boolean esValido(File file) {
		
		carpeta = new DirectorioArchivos(file);
		boolean esValido = carpeta.contieneTxt();
			
		
		if( esValido) {
			
			palabrasArchivosCarpeta = new HashMap<String,Integer>();
			cantidadPalabrasCarpeta = carpeta.cargarPalabras(palabrasArchivosCarpeta);
		}
		
		return esValido;			
	}
	
	public String obtenerPalabrasMasUsadasDirectorio(int cantidad) {
		return carpeta.obtenerParabrasMasUsadasDirectorio(5, palabrasArchivosCarpeta,cantidadPalabrasCarpeta);
	}


	public String seleccionArchivo(File f) {
		
		arch = new Archivo( f);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		cantidadPalabrasArchivo = arch.cargarPalabras(palabrasArchivo);
		
		return arch.obtenerPalabrasMasUsadasArchivo(5,palabrasArchivo, cantidadPalabrasArchivo );
	
	}
	
	
	public String[] cargarArchi() {
	
		return carpeta.obtenerArchivos();
	}
}
