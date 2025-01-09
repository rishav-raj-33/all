package com.glowTemp.com.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.glowTemp.com.payloads.FilterDescriptionDto;
import com.glowTemp.com.serviceClass.FilterDescriptionClass;

@RestController
@RequestMapping("/api/filter")
public class FilterDescriptionController {
	
	
	@Autowired
	private FilterDescriptionClass Service;
	
	
	
	
	@GetMapping("/all")
	@CrossOrigin(origins = "http://localhost:5173")
	public ResponseEntity<List<FilterDescriptionDto>> findAll(){
		List<FilterDescriptionDto> list=this.Service.getAllFilters();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	

}
