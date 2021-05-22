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

	public void cargarPalabras(HashMap<String, Integer> palabrasArchivo) {
		
		for( int h=0; h<arch.size(); h++) {
			
			Archivo a= arch.get(h);
			a.cargarPalabras(palabrasArchivo);

		}
	}

	public String obtenerParabrasMasUsadasDirectorio(int cantidad, HashMap<String, Integer> palabrasArchivo ) {
		
		GestionPalabras gp = new GestionPalabras(palabrasArchivo.size());
		gp.ordenarHash(palabrasArchivo);
		
		return gp.listaPalabras(cantidad);
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
	
	
	
		
	


