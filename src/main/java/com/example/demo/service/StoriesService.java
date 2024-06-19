package com.example.demo.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.contants.Constants;
import com.example.demo.dto.StoriesDTO;
import com.example.demo.model.Stories;
import com.example.demo.repository.StoriesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StoriesService {
	
	@Autowired
	private StoriesRepository storiesRepository;
	
	
	public Stories createStories(Stories stories) {
		 RestTemplate plantilla = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    JSONObject personJsonObject = new JSONObject();
		    ObjectMapper objectMapper = new ObjectMapper();
		    HttpEntity<String> request = 
		    	      new HttpEntity<String>(personJsonObject.toString(), headers);
		 String personResultAsJsonStr  = 
				 plantilla.getForObject(Constants.urlCarac, String.class);
		 JsonNode root2 =null;
		    try {
				 root2 = objectMapper.readTree(personResultAsJsonStr);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	//	ResponseEntity<StoriesDTO> restResul= plantilla.getForEntity(Constants.urlCarac, StoriesDTO.class);
		 
		return storiesRepository.save(stories);
		
	}
	
	public List<Stories> getAllStories(){
		return storiesRepository.findAll();
	}
	

}
