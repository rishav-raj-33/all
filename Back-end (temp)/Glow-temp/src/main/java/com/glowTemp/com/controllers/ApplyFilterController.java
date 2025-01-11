package com.glowTemp.com.controllers;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Value("${project.Images}")
	private String imgPath;
	
	private Logger log=LoggerFactory.getLogger(ApplyFilterController.class);
	
	@PostMapping("/image/{id}")
	@CrossOrigin(origins = "http://localhost:5173")
     public	 ResponseEntity<ImageResponse> metaDataExtractionTest(@RequestParam MultipartFile image,@PathVariable String id) throws ImageProcessingException, IOException, InterruptedException, ExecutionException{
		
		 ExecutorService executor = Executors.newFixedThreadPool(2);;
		 ImageResponse response=new ImageResponse();
		 String fileName=UUID.randomUUID().toString();
		 
		 
		   Future<String> future2 = executor.submit(() -> { 
			   this.applyFilterServiceClass.runCppScript(image,fileName).get();  
			   String txtFile=this.service.encodeImageToBase64(fileName, path);
			   log.info("Txt File Converted into base 64 Form");
        return  txtFile;
    });
		   
		   
		   
		   Future<String> future = executor.submit(() -> {
		   this.applyFilterServiceClass.runPythonScript(image, id, imgPath).get();
		   String imgFile=this.service.encodeImageToBase64("image.jpeg", imgPath);
		   log.info("Image File converted into base 64 Form");
            return  imgFile;
        });
		   			  
		  
		 response.setTxtFile(future2.get());
		 response.setFilterImage(future.get());
		 this.service.deleteFile(fileName, path);
		 log.info("Text File Deleted");
		 this.service.deleteFile("images", imgPath);
		 log.info("Filter File Deleted");
		 this.service.deleteFile("temp.jpeg", imgPath);
		 log.info("Uploaded File Deleted");
		 String fullPath=image.getOriginalFilename();
		 File file=new File(fullPath);
		 file.delete();
		 log.info("Temp File Deleted");
		   
		
		
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
	
	
	

	
	
	
	
	

}
