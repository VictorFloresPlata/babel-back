package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;

import com.example.demo.model.Stories;
import com.example.demo.repository.StoriesRepository;
import com.example.demo.service.StoriesService;

@Service
public class StoriesServiceTest {
	
	@Mock
	private StoriesRepository storiesRepository;
	
	@InjectMocks
	 StoriesService  storiesService;
	
	@Before(value = "")
	public void init() {
	    MockitoAnnotations.openMocks(this);
	}
	
	 @Test
	public void getAllStories(){
		 List<Stories> str = new ArrayList<Stories>();
		 List<Stories> esperado = new ArrayList<Stories>();
		 Mockito.when(storiesRepository.findAll()).thenReturn(str);
		
		 esperado= storiesService.getAllStories();
	        Assertions.assertEquals(esperado, str);
	}
	

}
