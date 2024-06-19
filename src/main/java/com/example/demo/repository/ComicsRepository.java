package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Comics;
import com.example.demo.model.Stories;

@Repository
public interface ComicsRepository extends  JpaRepository<Comics, Long> {
	
}
	
