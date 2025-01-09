package com.glowTemp.com.serviceClassTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import com.glowTemp.com.entity.FilterDescriptionEntity;
import com.glowTemp.com.repository.FilterDescRepo;
import com.glowTemp.com.serviceClass.FilterDescriptionClass;



public class FilterDescriptionClassTests {
	
	@Mock
	private FilterDescRepo filterDescRepo;
	
	@InjectMocks
	private FilterDescriptionClass testService;
	
	@Mock
	private ModelMapper mapper;
	
	
	

	@BeforeEach
	void initilizeMock() {
		MockitoAnnotations.openMocks(this);
	}
	
	
	
	@ParameterizedTest
	@CsvSource({
		"canny_red.jpg",
		"canny.jpg",
		"cartoon.jpg",
		"Emboss.jpg",
		"GrayScale.jpg",
		"Lapsian.jpg",
		"negative.jpg",
		"sepia.jpg"
	})
	public void encodeImageToBase64Test(String imageName) {
		testService.setProperty("demoFilters/");
      assertNotNull(testService.encodeImageToBase64(imageName));
		
	}
	
	
	@Test
	public void  getAllFiltersTest() {
		List<FilterDescriptionEntity> list=new ArrayList<>();
		list.add(new FilterDescriptionEntity(1, "canny", "edge detction", "canny.jpg"));
		testService.setProperty("demoFilters/");
		when(filterDescRepo.findAll()).thenReturn(list);
		
		
		assertNotNull(testService.getAllFilters());
		
	}

}
