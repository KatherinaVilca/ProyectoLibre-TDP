package src;

import java.util.HashMap;

public class TraductorIngles implements TraductorIdiomas{
	
	private HashMap<PalabrasClave,String> dicc;
	
	public TraductorIngles() {
		dicc= new HashMap<PalabrasClave,String>();
		
		dicc.put(PalabrasClave.CARGAR, "Select directories");
		dicc.put(PalabrasClave.COMENZAR, "Start");
		dicc.put(PalabrasClave.ELEGIR_ARCHIVO,"Choose file");
		dicc.put(PalabrasClave.VER,"Show all");
		dicc.put(PalabrasClave.ARCHIVOS, "Files");
	}
	
	public String obtenerTraduccion(PalabrasClave p) {
		
		return dicc.get(p);
	}
	
}
