package com.glowTemp.com.controllersTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import com.glowTemp.com.controllers.FilterDescriptionController;
import com.glowTemp.com.payloads.FilterDescriptionDto;
import com.glowTemp.com.repository.FilterDescRepo;
import com.glowTemp.com.serviceClass.FilterDescriptionClass;




@ExtendWith(MockitoExtension.class)
public class FilterDescriptionControllersTest {
	
	
	 @Mock
	private FilterDescRepo filterDescRepo;
	
	 @Mock
	private FilterDescriptionClass testService;
	
	@Mock
	private ModelMapper mapper;
	
	@InjectMocks
	private FilterDescriptionController controller;
	
	 
	 
	 
	 @BeforeEach
		void initilizeMock() {
			MockitoAnnotations.openMocks(this);
		}
	
	
	@Test
	public void findAllTest() throws Exception {
		
		
		ResponseEntity<List<FilterDescriptionDto>> list2=controller.findAll();
		  assertEquals(200, list2.getStatusCode().value());
		
	
		
		 
		
	}

}
