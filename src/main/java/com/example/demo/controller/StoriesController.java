package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stories;
import com.example.demo.service.StoriesService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stories")
public class StoriesController {
	
	@Autowired
	private StoriesService storiesService;
	
	@PostMapping
	private Stories createStories(@RequestBody Stories stories )  {
		return storiesService.createStories(stories);
	}
	
	
}
