package src;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltroTXT extends FileFilter {
	
	public boolean accept (File fichero) {
		   
		String extension = getExtension(fichero.getAbsolutePath());
	      
	   if (extension.equals("txt"))
	         return true;
	      else
	         return false;
		   
	   }	  

	
	private String getExtension(String path) {
		
		String ex = " ";
		
		int i = path.lastIndexOf('.');
		
		if (i > 0) {
		    ex = path.substring(i+1);
		}
		
	return ex;
		
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
}
