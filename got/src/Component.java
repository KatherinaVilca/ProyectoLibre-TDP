package src;

import java.util.HashMap;

public abstract class Component {
	
	protected int totalPalabras;

	protected String path;
	
	public Component(String file) {

		totalPalabras = 0;
		this.path= file;
		 
	}
	
	protected abstract void cargarPalabras(HashMap<String, Integer> palabrasArchivo);

}
