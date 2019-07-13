package com.ay.practiceonline.api.dao;

import java.util.List;

import com.ay.practiceonline.api.model.Question;

public interface PracticeOnlineDAO {
	
	//Create the record
	int createQuestion (Question question);
	
	//Get a single record
	Question getQuestion(int id);
	
	//Get all the records
	List<Question> getAllQuestions();
	
	//Update the record
	int updateQuestion(int id, Question question);
	
	//Delete the record
	void deleteQuestion (int id);
	

}
