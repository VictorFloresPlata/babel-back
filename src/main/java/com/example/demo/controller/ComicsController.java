package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Comics;
import com.example.demo.service.ComicsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comics")
public class ComicsController {
	@Autowired
	private ComicsService comicsService;
	/* Metodo que guarda los comics al consultar */
	@PostMapping
	private String createComics( )  {
		return comicsService.createComics();
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public ResponseEntity<List<JsonNode>> getlistarComics() {

		return ResponseEntity.ok(comicsService.getAllComics());

	}

}
