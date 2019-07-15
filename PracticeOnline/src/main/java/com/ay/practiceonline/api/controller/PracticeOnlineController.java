package com.ay.practiceonline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ay.practiceonline.api.model.Question;
import com.ay.practiceonline.api.model.SubjectMaster;
import com.ay.practiceonline.api.service.PracticeOnlineService;
import com.ay.practiceonline.api.util.CommonProps;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*") // To enable cross origin in Spring MVC to receive Http requests from Angular
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
		String id = practiceOnlineService.createQuestion(question);
		return ResponseEntity.ok().body("New Question Created with id : " + id);
	}
	
	//Get a Question based on the id
	@GetMapping("/GetQuestion/{id}")
	public ResponseEntity<Question> getQuestion(@PathVariable("id") String id){
		Question question = practiceOnlineService.getQuestion(id);
		System.out.println(question);
		return ResponseEntity.ok().body(question);
	}
	
	//Update a Question
	@PutMapping("/UpdateQuestion/{id}")
	public ResponseEntity<?> updateQuestion(@PathVariable String id, @RequestBody Question question) {
		practiceOnlineService.updateQuestion(id, question);
		return ResponseEntity.ok().body("Question # "+id+" Updated");
	}
	
	//Delete a Question
	@DeleteMapping("/DeleteQuestion/{id}")
	public ResponseEntity<?> deleteQuestion(@PathVariable String id){
		practiceOnlineService.deleteQuestion(id);
		return ResponseEntity.ok().body("Question # "+id+" Deleted");
	}
	
	//Create a new Master Record
	@PostMapping("/AddMaster/{masterType}")
	public ResponseEntity<?> addMaster(@PathVariable String masterType, @RequestBody String jsonMaster){
		
		System.out.println(jsonMaster);
		
		String resultId = "CTRL_FAIL";
	
		try 
		{
			switch (masterType) 
			{
				case CommonProps.MASTER_TYPE_SUBJECT:
				{
					ObjectMapper objectMapper = new ObjectMapper();
					SubjectMaster subjectMaster = objectMapper.readValue(jsonMaster, SubjectMaster.class);
					resultId = practiceOnlineService.addMaster(masterType, subjectMaster);
				}
				case CommonProps.MASTER_TYPE_TOPIC:
				{
				}
				case CommonProps.MASTER_TYPE_SOURCE:
				{
				}
				case CommonProps.MASTER_TYPE_EXAM:
				{
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("JsonParseException - Error Adding Master : "+masterType);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("JsonMappingException - Error Adding Master : "+masterType);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Exception - Error Adding Master : "+masterType);
		}		
		//TODO Custom Error handler is required in Controller 
		return ResponseEntity.ok().body("New "+masterType+" added with id : "+resultId);
	}
	
	//Get a particular Master Record
	@GetMapping("/GetMaster/{masterType}/{masterId}")
	public ResponseEntity<Object> getMaster(@PathVariable String masterType, @PathVariable String masterId)
	{
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				SubjectMaster subjectMaster = (SubjectMaster)practiceOnlineService.getMaster(masterType, masterId);
				return ResponseEntity.ok().body(subjectMaster);
			}
			case CommonProps.MASTER_TYPE_TOPIC:
			{
			}
			case CommonProps.MASTER_TYPE_SOURCE:
			{
			}
			case CommonProps.MASTER_TYPE_EXAM:
			{
			}
		}
		return ResponseEntity.badRequest().body("Error getting Master : "+masterType+" ["+masterId+"]");
	}

	//Update a particular Master Record
	@PutMapping("/UpdateMaster/{masterType}/{masterId}")
	public ResponseEntity<?> updateMaster(@PathVariable String masterType, @PathVariable String masterId, @RequestBody String jsonMaster)
	{
		try 
		{
			switch (masterType)
			{
				case CommonProps.MASTER_TYPE_SUBJECT:
				{
					ObjectMapper objectMapper = new ObjectMapper();
					SubjectMaster subjectMaster = objectMapper.readValue(jsonMaster, SubjectMaster.class);
					practiceOnlineService.updateMaster(masterType, masterId, subjectMaster);
				}
				case CommonProps.MASTER_TYPE_TOPIC:
				{
				}
				case CommonProps.MASTER_TYPE_SOURCE:
				{
				}
				case CommonProps.MASTER_TYPE_EXAM:
				{
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("JsonParseException - Error Updating Master : "+masterType+" ["+masterId+"]");
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("JsonMappingException - Error Updating Master : "+masterType+" ["+masterId+"]");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("Exception - Error Updating Master : "+masterType+" ["+masterId+"]");
		}	
		
		return ResponseEntity.ok().body("Master : "+masterType+" ["+masterId+"] is Updated");
	}

	//Delete a particular Master Record
	@DeleteMapping("/DeleteMaster/{masterType}/{masterId}")
	public ResponseEntity<?> deleteMaster(@PathVariable String masterType, @PathVariable String masterId)
	{
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				practiceOnlineService.deleteMaster(masterType, masterId);
			}
			case CommonProps.MASTER_TYPE_TOPIC:
			{
			}
			case CommonProps.MASTER_TYPE_SOURCE:
			{
			}
			case CommonProps.MASTER_TYPE_EXAM:
			{
			}
		}
		return ResponseEntity.ok().body("Master : "+masterType+" ["+masterId+"] is Deleted");
	}

	//Get All Master Records from a MasterType
	@GetMapping("/GetAllMasters/{masterType}")
	public ResponseEntity<Object[]> getAllMasters(@PathVariable String masterType)
	{
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				Object[] subjectMasters = practiceOnlineService.getAllMasterRecords(masterType);
				return ResponseEntity.ok().body(subjectMasters);
			}
			case CommonProps.MASTER_TYPE_TOPIC:
			{
			}
			case CommonProps.MASTER_TYPE_SOURCE:
			{
			}
			case CommonProps.MASTER_TYPE_EXAM:
			{
			}
		}
		return ResponseEntity.badRequest().body(new String []{"Error getting All Masters: "+masterType+""});
	}
	
}
