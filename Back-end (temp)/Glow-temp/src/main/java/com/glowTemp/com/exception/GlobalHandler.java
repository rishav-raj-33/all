package com.glowTemp.com.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.drew.imaging.ImageProcessingException;

@ControllerAdvice
public class GlobalHandler {
	
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<ErrorResponse> ioException(IOException e){	
		return new ResponseEntity<>(new ErrorResponse("Uploading Error: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(ImageProcessingException.class)
	public ResponseEntity<ErrorResponse> imageProssing(ImageProcessingException e){	
		return new ResponseEntity<>(new ErrorResponse("Image Processing Error: "+e.getMessage(), false),HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
