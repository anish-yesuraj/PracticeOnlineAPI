package com.ay.practiceonline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ay.practiceonline.api.model.Question;
import com.ay.practiceonline.api.service.PracticeOnlineService;

@RestController
public class PracticeOnlineController {
	
	@Autowired
	private PracticeOnlineService practiceOnlineService;
	
	
	//Get all the Question
	@GetMapping("/book")
	public ResponseEntity<List<Question>> getAll(){
		
		List<Question> listQuestions = practiceOnlineService.getAll();
		System.out.println(listQuestions);
		return ResponseEntity.ok().body(listQuestions);
		
	}

}
