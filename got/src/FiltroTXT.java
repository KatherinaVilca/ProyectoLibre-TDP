package src;
import java.io.File;
import java.util.LinkedList;

import javax.swing.filechooser.FileFilter;

public class FiltroTXT {
	
	public LinkedList<Archivo> accept (File fichero) {
		
		String [] archivos = fichero.list(); 		
	
		LinkedList<Archivo> listaArch = new LinkedList<Archivo>();
		char barra = File.separatorChar;
		String path = fichero.getAbsolutePath();
		   
		
		for( int i = 0; ( i<archivos.length) ; i++) {
			
			String extension = getExtension(archivos[i]);
			
		   if ( extension.equals("txt") ) {
			   
				  listaArch.add( new Archivo( new File( path+barra+archivos[i])));
				  
		   }
		
		}
		
		return listaArch;
	}

	
	private String getExtension(String path) {
		
		String ex = " ";
		
		int i = path.lastIndexOf('.');
		
		if (i > 0) {
		    ex = path.substring(i+1);
		}
		
	return ex;
		
	}


}
