package src;

import java.util.HashMap;

public class TraductorEspa�ol implements TraductorIdiomas{

	private static TraductorEspa�ol singleton;
	
	private HashMap<PalabrasClave,String> dicc;
	
	private TraductorEspa�ol() {
		
		
		dicc= new HashMap<PalabrasClave,String>();
		
		dicc.put(PalabrasClave.CARGAR, "Cargar directorio");
		dicc.put(PalabrasClave.COMENZAR, "Comenzar");
		dicc.put(PalabrasClave.ELEGIR_ARCHIVO,"Elegir archivo");
		dicc.put(PalabrasClave.VER,"Ver todas");
		dicc.put(PalabrasClave.ARCHIVOS, "Archivos" );
	}
	
	public static TraductorEspa�ol getInstance() {
		
		if(singleton == null) {
			return new TraductorEspa�ol();
		}
		return singleton;		
	}
	
	public String obtenerTraduccion(PalabrasClave p) {
		
		return dicc.get(p);
	}

}
