package com.glowTemp.com.serviceClass;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.glowTemp.com.entity.FilterDescriptionEntity;
import com.glowTemp.com.payloads.FilterDescriptionDto;
import com.glowTemp.com.repository.FilterDescRepo;
import com.glowTemp.com.service.FilterDescription;

@Service
public class FilterDescriptionClass implements FilterDescription {
	
	@Autowired
	private FilterDescRepo filterDescRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Value("${project.filters}")
	private String path;

	private Logger log=LoggerFactory.getLogger(FilterDescriptionClass.class);
	
	@Autowired
	private CommonService service;


	@Override
	public List<FilterDescriptionDto> getAllFilters() {
		
		List<FilterDescriptionEntity> list=this.filterDescRepo.findAll();
		List<FilterDescriptionDto> list2=list.stream().map((obj)->{
			obj.setFilterImagePath(encodeImageToBase64(obj.getFilterImagePath()));
		return	this.mapper.map(obj, FilterDescriptionDto.class);
			}).toList();
		log.info("Filter List is ready to send......");
		return list2;
	}

	





	@Override
	public String encodeImageToBase64(String imageName) {
	    return this.service.encodeImageToBase64(imageName, path);
	}
	
	
	//For Testing Purpose...
	
 public	void setProperty(String a) {
		this.path=a;
	}
	
	

}
