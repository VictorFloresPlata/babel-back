package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.contants.Constants;
import com.example.demo.dto.ComicsDTO;
import com.example.demo.model.Comics;
import com.example.demo.model.Stories;
import com.example.demo.repository.ComicsRepository;
import com.example.demo.repository.StoriesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ComicsService {
	@Autowired
	private ComicsRepository comicsRepository;
	private ObjectMapper mapper = new ObjectMapper();
	
	public String createComics() {
		 RestTemplate plantilla = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		
		 ComicsDTO comicsDto = new ComicsDTO();
		
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    
		    JSONObject personJsonObject = new JSONObject();
		    ObjectMapper objectMapper = new ObjectMapper();
		
		 String personResultAsJsonStr  = 
				 plantilla.getForObject(Constants.urlCarac, String.class);
		 JsonNode root2 =null;
		    try {
		    	
		    	 root2 = objectMapper.readTree(personResultAsJsonStr);
				
				
				 root2.get("data").get("results").forEach(method -> {
					 Comics comics = new Comics();
					 comics.setAvailable(method.get("comics").get("available").toString());
					 comics.setCollectionURI(method.get("comics").get("collectionURI").toString());
					 
					 
					 comicsRepository.save(comics);
					 
					 
				 });
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	//	ResponseEntity<StoriesDTO> restResul= plantilla.getForEntity(Constants.urlCarac, StoriesDTO.class);
		 
		    
		    
		return "exito";
		
	}
	
	public List<JsonNode> getAllComics(){
		List<JsonNode> listaComin = new ArrayList<JsonNode>();
		RestTemplate plantilla = new RestTemplate();
		 HttpHeaders headers = new HttpHeaders();
		
		 ComicsDTO comicsDto = new ComicsDTO();
		
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    
		    JSONObject personJsonObject = new JSONObject();
		    ObjectMapper objectMapper = new ObjectMapper();
		
		 String personResultAsJsonStr  = 
				 plantilla.getForObject(Constants.urlCarac, String.class);
		 JsonNode root2 =null;
		    try {
		    	
		    	 root2 = objectMapper.readTree(personResultAsJsonStr);
				
				
				 root2.get("data").get("results").forEach(method -> {
					 Comics comics = new Comics();
					 comics.setAvailable(method.get("comics").get("available").toString());
					 comics.setCollectionURI(method.get("comics").get("collectionURI").toString());
					 
					 
					 listaComin.add(method.get("comics"));
					 
					 
				 });
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	//	ResponseEntity<StoriesDTO> restResul= plantilla.getForEntity(Constants.urlCarac, StoriesDTO.class);
		 
		
		
		return listaComin;
	}
	
	

}
