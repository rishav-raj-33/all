package com.glowTemp.com.service;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageProcessingException;



public interface ApplyFilterService {
	
	
	
	public Future<String> runPythonScript(MultipartFile file,String id,String path)throws IOException ;	
   public Future<String> runCppScript(MultipartFile image,String fileName)throws IOException,ImageProcessingException;
   
   public Map<String, String> extractData(MultipartFile image)throws ImageProcessingException, IOException ; 
   
   
     

   
  
   
  
  


}
