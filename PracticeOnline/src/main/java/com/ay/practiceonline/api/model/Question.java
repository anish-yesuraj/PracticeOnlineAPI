package com.ay.practiceonline.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "QUESTION")
@SecondaryTable(name = "QIMAGE", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id"))
public class Question implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qn_generator")
	@SequenceGenerator(name="qn_generator", sequenceName = "qn_seq", allocationSize=1)
	@Column(unique=true, nullable =false)
	private Long id;
	private String subject;
	private String topic;
	private String level;
	private String text;
	private String tip;
	private boolean active;
	
	@Column(table = "QIMAGE")
	private String imagePath;

	@Column(table = "QIMAGE")
	private String imageTip;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value= {"question"})
	private List<AnswerChoice> answerChoices = new ArrayList<AnswerChoice>();

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String subject, String topic, String level, String text, String tip) {
		super();
		this.subject = subject;
		this.topic = topic;
		this.level = level;
		this.text = text;
		this.tip = tip;
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<AnswerChoice> getAnswerChoices() {
		return answerChoices;
	}

	public void setAnswerChoices(List<AnswerChoice> answerChoices) {
		this.answerChoices = answerChoices;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", subject=" + subject + ", topic=" + topic + ", level=" + level + ", text="
				+ text + ", tip=" + tip + ", active=" + active + ", imagePath=" + imagePath + ", imageTip=" + imageTip
				+ ", answerChoices=" + answerChoices + "]";
	}


}
