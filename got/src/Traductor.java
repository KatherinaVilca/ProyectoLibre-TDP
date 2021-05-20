package src;

public class Traductor {
	
	
	//SINGLETON
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
	
	public void changeE() {
		 tr = new TraductorIngles();
		 System.out.println(tr.obtenerTraduccion(PalabrasClave.VER));
	}
	
	public void changeS() {
		
		
		tr= new TraductorEspañol();	
		 System.out.println(tr.obtenerTraduccion(PalabrasClave.VER));
	
	}
}
