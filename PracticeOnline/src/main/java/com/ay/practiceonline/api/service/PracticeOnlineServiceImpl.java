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
	public long save(Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Question get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Question> getAll() {
		return practiceOnlineDAO.getAll();
	}

	@Override
	public long update(long id, Question question) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
