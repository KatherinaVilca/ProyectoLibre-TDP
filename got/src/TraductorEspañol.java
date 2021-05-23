package src;

import java.util.HashMap;

public class TraductorEspañol implements TraductorIdiomas{

	private static TraductorEspañol singleton;
	
	private HashMap<PalabrasClave,String> dicc;
	
	private TraductorEspañol() {
		
		
		dicc= new HashMap<PalabrasClave,String>();
		
		dicc.put(PalabrasClave.CARGAR, "Cargar directorio");
		dicc.put(PalabrasClave.COMENZAR, "Comenzar");
		dicc.put(PalabrasClave.ELEGIR_ARCHIVO,"Elegir archivo");
		dicc.put(PalabrasClave.VER,"Ver todas");
		dicc.put(PalabrasClave.ARCHIVOS, "Archivos" );
	}
	
	public static TraductorEspañol getInstance() {
		
		if(singleton == null) {
			return new TraductorEspañol();
		}
		return singleton;		
	}
	
	public String obtenerTraduccion(PalabrasClave p) {
		
		return dicc.get(p);
	}

}
