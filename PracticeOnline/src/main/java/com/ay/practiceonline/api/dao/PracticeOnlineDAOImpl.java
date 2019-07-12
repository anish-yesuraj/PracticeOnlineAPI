package com.ay.practiceonline.api.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ay.practiceonline.api.model.Question;

@Repository
public class PracticeOnlineDAOImpl implements PracticeOnlineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
	public List<Question> getAll() {
		
		List<Question> listQuestions = sessionFactory.getCurrentSession().createQuery("from Question").getResultList();
		return listQuestions;
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
