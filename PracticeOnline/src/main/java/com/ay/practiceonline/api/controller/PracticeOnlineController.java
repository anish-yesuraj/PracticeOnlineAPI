package com.ay.practiceonline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ay.practiceonline.api.model.Question;
import com.ay.practiceonline.api.service.PracticeOnlineService;

@RestController
public class PracticeOnlineController {
	
	@Autowired
	private PracticeOnlineService practiceOnlineService;
	
	
	//Get all the Questions
	@GetMapping("/GetAllQuestions")
	public ResponseEntity<List<Question>> getAllQuestions(){
		List<Question> listQuestions = practiceOnlineService.getAllQuestions();
		System.out.println(listQuestions);
		return ResponseEntity.ok().body(listQuestions);
	}
	
	//Create a New Question
	@PostMapping("/CreateNewQuestion")
	public ResponseEntity<?> createQuestion(@RequestBody Question question){
		System.out.println(question);
		int id = practiceOnlineService.createQuestion(question);
		return ResponseEntity.ok().body("New Question Created with id : " + id);
	}
	
	//Get a Question based on the id
	@GetMapping("/GetQuestion/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable("id") int id){
		Question question = practiceOnlineService.getQuestion(id);
		System.out.println(question);
		return ResponseEntity.ok().body(question);
	}
	
	//Update a Question
	@PutMapping("/UpdateQuestion/{id}")
	public ResponseEntity<?> updateQuestion(@PathVariable int id, @RequestBody Question question) {
		int qid = practiceOnlineService.updateQuestion(id, question);
		return ResponseEntity.ok().body("Question # "+qid+" Updated");
	}
	
	//Delete a Question
	@DeleteMapping("/DeleteQuestion/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable int id){
		practiceOnlineService.deleteQuestion(id);
		return ResponseEntity.ok().body("Question # "+id+" Deleted");
	}

}
