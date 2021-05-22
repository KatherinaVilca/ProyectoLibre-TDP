package src;

public class Traductor {
	

	private static Traductor singleton;
	private TraductorIdiomas tr ;
	
	private Traductor() {
		tr= new TraductorIngles();
	}
	
	public static Traductor getInstance() {
		
		if(singleton==null) {
			return new Traductor();
		}
		return singleton;
	}

	public String obtenerPalabra(PalabrasClave p) {
	
		return tr.obtenerTraduccion(p);
	}
	
	public void changeIngles() {
		
		 tr = new TraductorIngles();
	}
	
	public void changeEspa�ol() {
		
		tr= new TraductorEspa�ol();	
	
	}
}
