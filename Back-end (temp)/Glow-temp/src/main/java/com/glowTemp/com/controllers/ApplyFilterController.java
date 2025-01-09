package com.glowTemp.com.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageProcessingException;
import com.glowTemp.com.payloads.ImageResponse;
import com.glowTemp.com.service.ApplyFilterService;
import com.glowTemp.com.serviceClass.CommonService;

@RestController
@RequestMapping("/api/apply")
public class ApplyFilterController {
	
	@Autowired
	private ApplyFilterService applyFilterServiceClass;
	
	@Autowired
	private CommonService service;
	
	@Value("${project.getimage}")
	private String path;
	
	private Logger log=LoggerFactory.getLogger(ApplyFilterController.class);
	
	@GetMapping("/run/image")
     public	 ResponseEntity<ImageResponse> metaDataExtractionTest(@RequestParam MultipartFile image) throws ImageProcessingException, IOException, InterruptedException, ExecutionException{
		
		 ExecutorService executor = Executors.newFixedThreadPool(2);;
		 ImageResponse response=new ImageResponse();
		 String fileName=UUID.randomUUID().toString();
		 
		 
		   Future<String> future2 = executor.submit(() -> { 
			   this.applyFilterServiceClass.runCppScript(image,fileName).get();  
			   String txtFile=this.service.encodeImageToBase64(fileName, path);
			   log.info("Txt File Converted into base 64 Form");
        return  txtFile;
    });
		   
		   
		   
		  
			  
			  
		  
		 response.setTxtFile(future2.get());  
		 this.service.deleteFile(fileName, path);
		 String fullPath=image.getOriginalFilename();
		 log.info(fullPath);
		 File file=new File(fullPath);
		 file.delete();
		 
		   
		   
		   
		 
//		   Future<String> future = executor.submit(() -> {
//			   this.applyFilterServiceClass.Record();
//			   String status="True";
//	            return  status;
//	        });
		 

		   
//future2.get().toString()
		   
		   
		
		
		
		
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	
	

}
