package com.ay.practiceonline.api.service;

import java.util.List;

import com.ay.practiceonline.api.model.Question;

public interface PracticeOnlineService {

	//Create the record
	String createQuestion (Question question);
	
	//Get a single record
	Question getQuestion(String id);
	
	//Get all the records
	List<Question> getAllQuestions();
	
	//Update the record
	void updateQuestion(String id, Question question);
	
	//Delete the record
	void deleteQuestion (String id);
	
	
	
	
	//Create a New Master
	String addMaster(String masterType, Object masterObject);
	
	//Read a Master
	Object getMaster(String masterType, String masterId);
	
	//Update a Master
	void updateMaster(String masterType, String masterId, Object masterObject);
	
	//Delete a Master
	void deleteMaster(String masterType, String masterId);
	
	//Get all Master records
	Object[] getAllMasterRecords(String masterType);

	
}
