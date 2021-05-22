package src;

import java.util.HashMap;

public class TraductorEspañol implements TraductorIdiomas{


	private HashMap<PalabrasClave,String> dicc;
	
	public TraductorEspañol() {
		
		
		dicc= new HashMap<PalabrasClave,String>();
		
		dicc.put(PalabrasClave.CARGAR, "Cargar directorio");
		dicc.put(PalabrasClave.COMENZAR, "Comenzar");
		dicc.put(PalabrasClave.ELEGIR_ARCHIVO,"Elegir archivo");
		dicc.put(PalabrasClave.VER,"Ver todas");
		dicc.put(PalabrasClave.ARCHIVOS, "Archivos" );
	}
	
	public String obtenerTraduccion(PalabrasClave p) {
		
		return dicc.get(p);
	}

}
