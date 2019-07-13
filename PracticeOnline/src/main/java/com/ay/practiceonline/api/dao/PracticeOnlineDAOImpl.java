package com.ay.practiceonline.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ay.practiceonline.api.model.Question;

@Repository
public class PracticeOnlineDAOImpl implements PracticeOnlineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int createQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);
		return question.getId();
	}

	@Override
	public Question getQuestion(int id) {
		return sessionFactory.getCurrentSession().get(Question.class, id);
	}

	@Override
	public List<Question> getAllQuestions() {
		List<Question> listQuestions = (List<Question>)sessionFactory.getCurrentSession().createQuery("from Question where active = true ").getResultList();
		return listQuestions;
	}

	@Override
	public int updateQuestion(int id, Question question) {
		//Check if saveOrUpdate to be used or any other update logic
		sessionFactory.getCurrentSession().saveOrUpdate(question);
		return question.getId();
//		Session session = sessionFactory.getCurrentSession();
//		Question oldQuestion = session.byId(Question.class).load(id);
//		oldQuestion = question; // Check if this will work
//		session.flush();
//		return oldQuestion.getId();
	}

	@Override
	public void deleteQuestion(int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question = session.byId(Question.class).load(id);
		session.delete(question);
	}
	
	

}
