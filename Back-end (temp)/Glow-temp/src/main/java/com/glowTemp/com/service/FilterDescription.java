package com.glowTemp.com.service;


import java.util.List;

import com.glowTemp.com.payloads.FilterDescriptionDto;

public interface FilterDescription {
	

    public	List<FilterDescriptionDto> getAllFilters();
	public String encodeImageToBase64(String imageName);


	
	
	

}
