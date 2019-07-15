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
	public String createQuestion(Question question) {
		return practiceOnlineDAO.createQuestion(question);
	}

	@Override
	@Transactional
	public Question getQuestion(String id) {
		return practiceOnlineDAO.getQuestion(id);
	}

	@Override
	@Transactional
	public List<Question> getAllQuestions() {
		return practiceOnlineDAO.getAllQuestions();
	}

	@Override
	@Transactional
	public void updateQuestion(String id, Question question) {
		practiceOnlineDAO.updateQuestion(id, question);
	}

	@Override
	@Transactional
	public void deleteQuestion(String id) {
		practiceOnlineDAO.deleteQuestion(id);
	}

	@Override
	@Transactional
	public String addMaster(String masterType, Object masterObject) {
		return practiceOnlineDAO.addMaster(masterType, masterObject);
	}

	@Override
	@Transactional
	public Object getMaster(String masterType, String masterId) {
		return practiceOnlineDAO.getMaster(masterType, masterId);
	}

	@Override
	@Transactional
	public void updateMaster(String masterType, String masterId, Object masterObject) {
		practiceOnlineDAO.updateMaster(masterType, masterId, masterObject);
	}

	@Override
	@Transactional
	public void deleteMaster(String masterType, String masterId) {
		practiceOnlineDAO.deleteMaster(masterType, masterId);
	}

	@Override
	@Transactional
	public Object[] getAllMasterRecords(String masterType) {
		return practiceOnlineDAO.getAllMasterRecords(masterType);
	}
	
	

}
