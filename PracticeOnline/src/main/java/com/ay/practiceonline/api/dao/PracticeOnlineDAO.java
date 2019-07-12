package com.ay.practiceonline.api.dao;

import java.util.List;

import com.ay.practiceonline.api.model.Question;

public interface PracticeOnlineDAO {
	
	//Save the record
	long save (Question question);
	
	//Get a single record
	Question get(long id);
	
	//Get all the records
	List<Question> getAll();
	
	//Update the record
	long update(long id, Question question);
	
	//Delete the record
	void delete (long id);
	

}
