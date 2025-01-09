package com.glowTemp.com.service;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageProcessingException;

import com.glowTemp.com.payloads.ImageResponse;

public interface ApplyFilterService {
	
	
	
	public void runPythonScript(String path,MultipartFile file,ImageResponse response)throws IOException ;	
   public Future<String> runCppScript(MultipartFile image,String fileName)throws IOException,ImageProcessingException;
   
   public Map<String, String> extractData(MultipartFile image)throws ImageProcessingException, IOException ; 
   
     

   
  
   
  
  


}
