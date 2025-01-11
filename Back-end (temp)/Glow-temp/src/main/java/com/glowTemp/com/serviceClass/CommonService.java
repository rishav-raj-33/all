package com.glowTemp.com.serviceClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class CommonService {
	
	private Logger log=LoggerFactory.getLogger(CommonService.class);
	
	public String encodeImageToBase64(String imageName,String path) {
	      try {
	            byte[] imageBytes = Files.readAllBytes(Paths.get(path + imageName));
	            log.info("File Coverted into Base 64 form..");
	            return Base64.getEncoder().encodeToString(imageBytes);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            log.error("Exception occured while encoding File into base64 format");
	            return null;
	        }
	    
	}
	
	
	public boolean deleteFile(String imageName, String path) {
		String fullPath=path+File.separator+imageName;
		File file=new File(fullPath);
		if(file.exists()) {
			file.delete();
			log.info("File Deleted:",imageName);
			return true;
		}
	return false;
	}

}
