package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DirectorioArchivos extends Component{
	
	//public List<Archivo> archivos;
	//private HashMap<String, Integer> palabrasArchivo;
	private LinkedList<Archivo> arch;
	
	public DirectorioArchivos(File directorio) {
		
		super( directorio.getAbsolutePath());
		
		String [] allArchivos = directorio.list(); 		
		
		
		
		char barra = File.separatorChar;
		
		arch = new LinkedList<Archivo>();
		
		for(int i=0; i<allArchivos.length; i++) {
			
			
			arch.add( new Archivo (path+barra+allArchivos[i]) );
		}
	}
	
	
	@Override
	public void agregarArchivo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Archivo> obtenerArchivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarPalabras(HashMap<String, Integer> palabrasArchivo) {
		
		
		for( int h=0; h<arch.size(); h++) {
			Archivo a= arch.get(h);
			 a.cargarPalabras(palabrasArchivo);

		}
		
	}

	public String obtenerParabrasMasUsadasDirectorio(int cantidad, HashMap<String, Integer> palabrasArchivo ) {
		
		String masUsadas= " ";
		
		GestionPalabras gp = new GestionPalabras(palabrasArchivo.size());
		gp.ordenarHash(palabrasArchivo);	
	
		
		return gp.listaPalabras(cantidad);
	}
		
}
	
	
	
		
	


