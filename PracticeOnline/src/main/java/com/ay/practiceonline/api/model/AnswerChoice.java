package com.ay.practiceonline.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ANSWERCHOICE")
public class AnswerChoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ac_generator")
	@SequenceGenerator(name="ac_generator", sequenceName = "ac_seq", allocationSize=1)
	@Column(unique=true, nullable =false)
	private int id;
	private String text;
	private String tip;
	private boolean result;
	private boolean active;
	private String imagePath;
	private String imageTip;
	
	/** ManyToOne - Bidirectional (Mapped by 'question_id' in AnswerChoice) 
	 *  JoinColumn - question_id will have 'id' from Question **/
	@ManyToOne//(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	/** JSON - To ignore loading the 'AnswerChoices' again in the 'Question' Object **/
	@JsonIgnoreProperties(value= {"answerChoices"}) 
	private Question question;
	
	public AnswerChoice() {
		super();
	}

	public AnswerChoice(String text, String tip, boolean result) {
		super();
		this.text = text;
		this.tip = tip;
		this.result = result;
		this.active = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getImageTip() {
		return imageTip;
	}

	public void setImageTip(String imageTip) {
		this.imageTip = imageTip;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "AnswerChoice [id=" + id + ", text=" + text + ", tip=" + tip + ", result=" + result + ", active="
				+ active + ", imagePath=" + imagePath + ", imageTip=" + imageTip + "]";
	}

}
