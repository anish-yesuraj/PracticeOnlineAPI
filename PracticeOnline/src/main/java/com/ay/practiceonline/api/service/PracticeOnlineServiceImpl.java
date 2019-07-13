package com.ay.practiceonline.api.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.practiceonline.api.dao.PracticeOnlineDAO;
import com.ay.practiceonline.api.model.Question;

@Service
public class PracticeOnlineServiceImpl implements PracticeOnlineService{
	
	@Autowired
	private PracticeOnlineDAO practiceOnlineDAO;
	
	@Override
	@Transactional
	public int createQuestion(Question question) {
		return practiceOnlineDAO.createQuestion(question);
	}

	@Override
	@Transactional
	public Question getQuestion(int id) {
		return practiceOnlineDAO.getQuestion(id);
	}

	@Override
	@Transactional
	public List<Question> getAllQuestions() {
		return practiceOnlineDAO.getAllQuestions();
	}

	@Override
	@Transactional
	public int updateQuestion(int id, Question question) {
		return practiceOnlineDAO.updateQuestion(id, question);
	}

	@Override
	@Transactional
	public void deleteQuestion(int id) {
		practiceOnlineDAO.deleteQuestion(id);
		
	}

}
