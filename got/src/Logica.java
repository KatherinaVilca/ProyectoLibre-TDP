package src;

import java.io.File;
import java.util.HashMap;

public class Logica {
	
	public Logica() {
		
	}
	
	public String seleccionCarpeta(File file) {
		
		DirectorioArchivos carpeta = new DirectorioArchivos(file);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		carpeta.cargarPalabras(palabrasArchivo);
		return carpeta.obtenerParabrasMasUsadasDirectorio(10, palabrasArchivo);
		
	}

	// Anda perfecto
	public String seleccionArchivo(File file) {
		String c= file.getAbsolutePath();
		Archivo arch = new Archivo(c);
		HashMap<String, Integer> palabrasArchivo = new HashMap<String,Integer>();
		arch.cargarPalabras(palabrasArchivo);
		
		return arch.obtenerParabrasMasUsadasArchivo(10,palabrasArchivo);
	
	}
	
	
	public String cargarArchi() {
		return null;
	}
}
