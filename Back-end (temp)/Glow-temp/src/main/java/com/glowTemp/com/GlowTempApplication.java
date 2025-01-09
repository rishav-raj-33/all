package com.glowTemp.com;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import com.glowTemp.com.Resources.AppConstants;
import com.glowTemp.com.entity.FilterDescriptionEntity;
import com.glowTemp.com.repository.FilterDescRepo;

@SpringBootApplication
@EnableAsync
public class GlowTempApplication implements CommandLineRunner {
	
	
	@Autowired
	private FilterDescRepo repo;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(GlowTempApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<FilterDescriptionEntity> lists=new ArrayList<>();
		
		
		try {
			FilterDescriptionEntity filters=new FilterDescriptionEntity();
			filters.setId(AppConstants.Id1);
			filters.setFilterName(AppConstants.CANNY_Filter_NAME);
			filters.setFilterDescription(AppConstants.CANNY_Filter_CONTENT);
			filters.setFilterImagePath("canny.jpg");
			lists.add(filters);
			
			
			filters.setId(AppConstants.Id2);
			filters.setFilterName(AppConstants.CANNY_Filter_RED_NAME);
			filters.setFilterDescription(AppConstants.CANNY_Filter_RED_CONTENT);
			filters.setFilterImagePath("canny_red.jpg");
			lists.add(filters);
			
			filters.setId(AppConstants.Id3);
			filters.setFilterName(AppConstants.CARTOON_NAME);
			filters.setFilterDescription(AppConstants.CARTOON_CONTENT);
			filters.setFilterImagePath("cartoon.jpg");
			lists.add(filters);
			
			filters.setId(AppConstants.Id4);
			filters.setFilterName(AppConstants.EMBOSS_NAME);
			filters.setFilterDescription(AppConstants.EMBOSS_CONTENT);
			filters.setFilterImagePath("Emboss.jpg");
			lists.add(filters);
			
			
			filters.setId(AppConstants.Id5);
			filters.setFilterName(AppConstants.LAPLACIAN_NAME);
			filters.setFilterDescription(AppConstants.LAPLACIAN_CONTENT);
			filters.setFilterImagePath("Lapsian.jpg");
			lists.add(filters);
			
			
			filters.setId(AppConstants.Id6);
			filters.setFilterName(AppConstants.GRAY_SCALE_NAME);
			filters.setFilterDescription(AppConstants.GRAY_SCALE_CONTENT);
			filters.setFilterImagePath("GrayScale.jpg");
			lists.add(filters);
			
			
			filters.setId(AppConstants.Id7);
			filters.setFilterName(AppConstants.SEPIA_NAME);
			filters.setFilterDescription(AppConstants.SEPIA_CONTENT);
			filters.setFilterImagePath("sepia.jpg");
			lists.add(filters);
			
			
			filters.setId(AppConstants.Id8);
			filters.setFilterName(AppConstants.NEGATIVE_NAME);
			filters.setFilterDescription(AppConstants.NEGATIVE_CONTENT);
			filters.setFilterImagePath("negative.jpg");
			lists.add(filters);
			this.repo.saveAll(lists);
			
			
			
		} catch (Exception e) {
		}
		
		
		
		
		
	}
	
	
	

}
