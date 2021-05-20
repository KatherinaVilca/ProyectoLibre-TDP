package src;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class Component {
	
	private int porcentaje;

	protected int totalPalabras;
	//protected HashMap<String, Integer> palabrasArchivo;
	protected String path;
	
	public Component(String file) {

		//palabrasArchivo= new HashMap<String, Integer>();
		totalPalabras = 0;
		this.path= file;
		 
	}

	
	protected abstract void agregarArchivo();
	
	protected abstract List<Archivo> obtenerArchivos();
	
	protected abstract void cargarPalabras(HashMap<String, Integer> palabrasArchivo);

}
