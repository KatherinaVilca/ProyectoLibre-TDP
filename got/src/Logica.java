package src;

import java.io.File;
import java.util.HashMap;

public class Logica {
	
	private DirectorioArchivos carpeta;
	private Archivo arch;
	public Logica() {
		
	}
	
	public String seleccionCarpeta(File file) {
		
		carpeta = new DirectorioArchivos(file);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		carpeta.cargarPalabras(palabrasArchivo);
		return carpeta.obtenerParabrasMasUsadasDirectorio(10, palabrasArchivo);
		
	}

	// Anda perfecto
	public String seleccionArchivo(File f) {
		
		arch = new Archivo( f);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		arch.cargarPalabras(palabrasArchivo);
		
		return arch.obtenerParabrasMasUsadasArchivo(10,palabrasArchivo);
	
	}
	
	
	public String[] cargarArchi() {
		return carpeta.obtenerArchivos();
	}
}
