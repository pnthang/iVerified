package ca.gtem.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;

public class ImageUtil {	
			
	public static String storeImage(String fileName, String rootDir,String destinationDir) {			
		
		  if (fileName.contains("/")) {
			  return fileName;
		  }
		  fileName = fileName.replace(" ", "");
	      try
	      {	        
	         Path sourceFile = Paths.get(rootDir + "/tmp/" + fileName );	 
	         Path destinationPath = Paths.get(rootDir + destinationDir);
	         
	         if (!Files.exists(destinationPath)) {
	        	 Files.createDirectories(destinationPath);
	         }
	         Path destinationFile = Paths.get(rootDir + destinationDir  + fileName);
	         if (Files.exists(sourceFile)) {
	        	 Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
	        	//Delete file on exit
	             Files.deleteIfExists(sourceFile);
	        	 return destinationDir + fileName ;
	         }	          
	         
	      } catch (IOException e)
	      {
	         e.printStackTrace();
	      }		
		return "";
	}
	
	public static void deleteImage(String fileName, String locationDir ) {
		Path file = Paths.get(locationDir + fileName );
		try {
			Files.deleteIfExists(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
