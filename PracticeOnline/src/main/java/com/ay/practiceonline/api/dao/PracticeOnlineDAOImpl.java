package com.ay.practiceonline.api.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ay.practiceonline.api.model.Question;
import com.ay.practiceonline.api.model.SubjectMaster;
import com.ay.practiceonline.api.util.CommonProps;

@Repository
public class PracticeOnlineDAOImpl implements PracticeOnlineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String createQuestion(Question question) {
		sessionFactory.getCurrentSession().save(question);
		return question.getId();
	}

	@Override
	public Question getQuestion(String id) {
		return sessionFactory.getCurrentSession().get(Question.class, id);
	}

	@Override
	public List<Question> getAllQuestions() {
		List<Question> listQuestions = (List<Question>)sessionFactory.getCurrentSession().createQuery("from Question where active = true ").getResultList();
		return listQuestions;
	}

	@Override
	public void updateQuestion(String id, Question question) {
		//Check if saveOrUpdate to be used or any other update logic
		sessionFactory.getCurrentSession().saveOrUpdate(question);
	}

	@Override
	public void deleteQuestion(String id) {
		Session session = sessionFactory.getCurrentSession();
		Question question = session.byId(Question.class).load(id);
		session.delete(question);
	}

	
	@Override
	public String addMaster(String masterType, Object masterObject) {
		
		String returnId = "DAO_FAIL";
		
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				returnId = sessionFactory.getCurrentSession().save((SubjectMaster)masterObject).toString();
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
		return returnId;
	}

	@Override
	public Object getMaster(String masterType, String masterId) {
		
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				return sessionFactory.getCurrentSession().get(SubjectMaster.class, masterId);
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
		return null;
	}

	@Override
	public void updateMaster(String masterType, String masterId, Object masterObject) {

		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				sessionFactory.getCurrentSession().saveOrUpdate((SubjectMaster)masterObject);
				//TODO Check this. Created Date is nullified during update. 
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
	}

	@Override
	public void deleteMaster(String masterType, String masterId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				SubjectMaster subjectMaster = session.byId(SubjectMaster.class).load(masterId);
				session.delete(subjectMaster);
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
	}

	@Override
	public Object[] getAllMasterRecords(String masterType) {
		
		switch (masterType)
		{
			case CommonProps.MASTER_TYPE_SUBJECT:
			{
				return sessionFactory.getCurrentSession().createQuery("from SubjectMaster").getResultList().toArray();
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
		return null;
	}
	
	
	
	

}
