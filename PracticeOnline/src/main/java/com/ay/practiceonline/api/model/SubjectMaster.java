package com.ay.practiceonline.api.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.ay.practiceonline.api.util.StringPrefixedSequenceIdGenerator;

@Entity
@Table(name = "SUBJECT_MASTER")
public class SubjectMaster implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_seq")
	@GenericGenerator(
			name = "subject_seq",
			strategy = "com.ay.practiceonline.api.util.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SUB"),
					@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
			})
	private String subjectId;
	private String subjectName;
	private String subjectDesc;
	private String applicableExams;
	private boolean active;
	private String createdId;
	@CreationTimestamp
	private LocalDateTime createdDate;
	private String updatedId;
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	
	public SubjectMaster() {
		super();
	}
	
	
	public SubjectMaster(String subjectName, String subjectDesc, String applicableExams, boolean active,
			String createdId, String updatedId) {
		super();
		this.subjectName = subjectName;
		this.subjectDesc = subjectDesc;
		this.applicableExams = applicableExams;
		this.active = active;
		this.createdId = createdId;
		this.updatedId = updatedId;
	}


	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public String getApplicableExams() {
		return applicableExams;
	}
	public void setApplicableExams(String applicableExams) {
		this.applicableExams = applicableExams;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getCreatedId() {
		return createdId;
	}
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedId() {
		return updatedId;
	}
	public void setUpdatedId(String updatedId) {
		this.updatedId = updatedId;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "SubjectMaster [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectDesc=" + subjectDesc
				+ ", applicableExams=" + applicableExams + ", active=" + active + ", createdId=" + createdId
				+ ", createdDate=" + createdDate + ", updatedId=" + updatedId + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	
}
