package com.ay.practiceonline.api.model;

import org.hibernate.Session;

public class TestApp {

	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = null ;//= AppConfig.getSessionFactory().openSession();

		session.beginTransaction();
		//TODO Test COmmit
	
		Question q0 = new Question("Maths", "Add", "Easy", "Q0 : 1 + 3 = ", "Addition");
		
		AnswerChoice q0a1 = new AnswerChoice("Ans : 4", "1 + 3 = 4", true);
		q0a1.setImagePath("q0a1 ImagePath");
		q0a1.setImageTip("q0a1 ImageTip");
		q0a1.setQuestion(q0);
		session.save(q0a1);

		AnswerChoice q0a2 = new AnswerChoice("Ans : 15", "1 + 3 = 4", false);
		q0a2.setQuestion(q0);
		session.save(q0a2);

		q0.getAnswerChoices().add(q0a1);
		q0.getAnswerChoices().add(q0a2);
		session.save(q0);

		
		
		Question q1 = new Question("Maths", "Sub", "Easy", "Q1 : 10 - 3 = ", "Subraction");
		q1.setImagePath("Q1ImagePath");
		q1.setImageTip("Q1ImageTip");
		
		AnswerChoice q1a1 = new AnswerChoice("Ans : 13", "10 - 3 = 7", false);
		q1a1.setImagePath("AnswerImagePath");
		q1a1.setImageTip("AnswerImageTip");
		q1a1.setQuestion(q1);
		session.save(q1a1);

		AnswerChoice q1a2 = new AnswerChoice("Ans : 7", "10 - 3 = 7", true);
		q1a2.setImagePath("q1a2ImagePath");
		q1a2.setImageTip("q1a2ImageTip");
		q1a2.setQuestion(q1);
		session.save(q1a2);

		q1.getAnswerChoices().add(q1a1);
		q1.getAnswerChoices().add(q1a2);
		session.save(q1);

		session.getTransaction().commit();
		
		System.out.println("Done");
		
	}

}
