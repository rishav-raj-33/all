package com.glowTemp.com.serviceClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.glowTemp.com.Resources.AppConstants;
import com.glowTemp.com.Resources.MetaData;
import com.glowTemp.com.service.ApplyFilterService;



@Service
public class ApplyFilterServiceClass implements ApplyFilterService {
	
	private Logger log=LoggerFactory.getLogger(ApplyFilterServiceClass.class);
	
   
   
   
	
    @Async("Excutor-Config")
	@Override
	public Future<String> runPythonScript(MultipartFile file,String id,String path) throws IOException {
	this.uploadImage(path, file);
	String output=this.pythonScript(id);
		return CompletableFuture.completedFuture(output);
	}

	
	
	@Async("Excutor-Config")
	@Override
	public Future<String> runCppScript(MultipartFile image,String fileName) throws IOException, ImageProcessingException {
		String cleanName="NA";
		Map<String, String> imageMetaData=this.extractData(image);
		String dimension=imageMetaData.get("Image Width") + "x" +imageMetaData.get("Image Height");
		MetaData saveData=new MetaData("NA","NA" ,"NA","NA","NA","NA");
		saveData.setFileName(fileName);
        saveData.setLastModifiedDate(imageMetaData.get("File Modified Date"));
        if(imageMetaData.get("File Name")!=null) {
        	cleanName=this.DataClean(imageMetaData.get("File Name"));
        }
        saveData.setImageName(cleanName);
        saveData.setOriginalSize(imageMetaData.get("File Size"));
        saveData.setImageTpe(imageMetaData.get("Detected File Type Name"));
        saveData.setOriginalSize(imageMetaData.get("File Size"));
        if(!dimension.equals("x")) saveData.setDimension(dimension);
        String output=compileCppCode(saveData);	
	return  CompletableFuture.completedFuture(output);
	}

	
	private String compileCppCode( MetaData data) {
        String sourceFilePath =AppConstants.CPP_DIRECTORY+"metaData.cpp";
        String outputFilePath = AppConstants.CPP_DIRECTORY+"metaData";
        List<String> command = new ArrayList<>();
        command.add("g++");
        command.add("-o");
        command.add(outputFilePath);
        command.add(sourceFilePath);
        File workingDirectory = new File(AppConstants.CPP_DIRECTORY);

        // Execute the compile command
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            processBuilder.directory(workingDirectory);

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

           
            
            if (exitCode == 0) {
            	log.info("Compilation Successful c++ script");
                return runExecutable(data.getFileName(),data.getImageName(),data.getOriginalSize(),data.getDimension(),data.getImageTpe(),data.getLastModifiedDate());
            } else {
            	log.error("Exception Occured in Compile Method while compiling c++ script");
                return "Compilation failed with exit code " + exitCode + "\n" ;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            log.error("Exception Occured in Compile Method while compiling c++ script",e.getMessage());
            return "Error during compilation: " + e.getMessage();
        }
    }

	private String runExecutable(String... args) {
	    String executablePath = "scripts/metaData.exe";
	    try {
	        // Combine the executable path and the arguments into a single list
	        List<String> command = new ArrayList<>();
	        command.add(executablePath);
	        command.addAll(Arrays.asList(args));

	        ProcessBuilder runProcessBuilder = new ProcessBuilder(command);
	        runProcessBuilder.directory(new java.io.File(AppConstants.CPP_DIRECTORY));

	        Process runProcess = runProcessBuilder.start();
	        int runExitCode = runProcess.waitFor();

	        // Capture the output
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()))) {
	            StringBuilder output = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                output.append(line).append("\n");
	            }

	            if (runExitCode == 0) {
	            	log.info("Excution Successful c++ script");
	                return output.toString();
	            } else {
	            	log.error("Excution Failed c++ Scipt with exit code:",runExitCode);
	                return "Execution failed with exit code " + runExitCode;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        log.error("Exception Occured in Run Excutable Method while running c++ script",e.getMessage());
	    }
		return "Exception";
	}
	
	
	private String DataClean(String Data) {
		 String outputString = Data.replaceAll("[\\d\\s]", "");
		 log.info("Data Cleaned...");
		return outputString;
	}

	@Override
	public Map<String, String> extractData(MultipartFile image) throws ImageProcessingException, IOException {
		  Map<String, String> metadataMap = new HashMap<>();
		  File imgFile=this.convert(image);
	        Metadata metadata = ImageMetadataReader.readMetadata(imgFile);
	        for (Directory directory : metadata.getDirectories()) {
	            for (Tag tag : directory.getTags()) {
	                metadataMap.put(tag.getTagName(), tag.getDescription());
	            }
	        }
	        log.info("Meta Data Extracted...");
	        return metadataMap;
	}
	
	 private  File convert(MultipartFile file) throws IOException {
	        File convFile = new File(file.getOriginalFilename());

	        FileOutputStream fos = new FileOutputStream(convFile);
	        InputStream is = file.getInputStream();

	        byte[] buffer = new byte[1024];
	        int bytesRead = -1;

	        while ((bytesRead = is.read(buffer)) != -1) {
	            fos.write(buffer, 0, bytesRead);
	        }

	        fos.close();
	        is.close();
             log.info("Multipart File Converted into File Type ");
	        return convFile;
	    }
	 
	 
		private String uploadImage(String path, MultipartFile file) throws IOException {
			
			String filePath=path+File.separator+"temp.jpeg";
			File fileFolder=new File(path);
			if(!fileFolder.exists()) {
				fileFolder.mkdir();
			}
			Files.copy(file.getInputStream(),Paths.get(filePath));
			return filePath;
		}
		
		
		

		
		
		
		private String pythonScript(String id) {
			
		    StringBuilder errorOutput = new StringBuilder();
			
			String pythonScriptPath = "scripts/ImageProcessor.py"; 
		        List<String> command = new ArrayList<>();
		        
		        command.add("python"); 
		        command.add(pythonScriptPath);
		        command.add(id); // Add arguments

		        try {
		            ProcessBuilder processBuilder = new ProcessBuilder(command);
		     
		            processBuilder.redirectErrorStream(false);
		            Process process = processBuilder.start();
		            
		            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		            String line1;
		            while ((line1 = errorReader.readLine()) != null) {
		                errorOutput.append(line1).append("\n");
		            }
		            // Capture output
		            StringBuilder output = new StringBuilder();
		            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
		                String line;
		                while ((line = reader.readLine()) != null) {
		                    output.append(line).append("\n");
		                }
		                
		                
		            }

		            // Wait for the process to finish
		            int exitCode = process.waitFor();
		            if (exitCode == 0) {
		            	log.info("Python script excuted....");
		                return "Python script output:\n" + output.toString();  
		            } else {
		            	 log.error("Python script failed with exit code {}. Error output: {}", exitCode, errorOutput.toString());
		                return "Python script failed with exit code " + exitCode;
		                
		            }

		        } catch (Exception e) {
		        	log.error("Exception Occured while Running Python Scripts....");
		            return "Error running Python script: " + e.getMessage();
		        }
		    }
		
		
		}
	 
	 

	 
	 
	 
	 
   
	 
	  






