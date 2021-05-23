package src;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

public class DirectorioArchivos extends Component{
	
	private File directorio;
	
	private LinkedList<Archivo> arch;
	
	public DirectorioArchivos(File directorio) {
		
		super(directorio.getAbsolutePath());
		this.directorio = directorio;
		
	}
	
	public String []  obtenerArchivos() {
	
		String [] archivos = new String [ arch.size()];
		
		for( int index = 0; index<arch.size(); index++) {
			
			archivos[index] = arch.get(index).getPath();			 
		}  
		
		return archivos;
	}

	public int cargarPalabras(HashMap<String, Integer> palabrasArchivo) {
		int cantidadPalabras = 0; 
		
		for( int h=0; h<arch.size(); h++) {
			
			Archivo a= arch.get(h);
			cantidadPalabras = a.cargarPalabras(palabrasArchivo)+ cantidadPalabras;

		}
		return cantidadPalabras;
	}

	public String obtenerParabrasMasUsadasDirectorio(int cantidad, HashMap<String, Integer> palabrasArchivo, int cantidadPalabrasCarpeta ) {
		
		GestionPalabras gp = new GestionPalabras();
		gp.ordenarHash(palabrasArchivo);
		
		return gp.listaPalabras(cantidad,cantidadPalabrasCarpeta);
	}
	
	public boolean contieneTxt() {
		
		FiltroTXT filtro = new FiltroTXT();
		arch = filtro.accept(directorio);
		boolean ret = true;
		
		if( arch.isEmpty()) {
			
			ret = false;
		}
		
		return ret;
	}
}
	
	
	
		
	


