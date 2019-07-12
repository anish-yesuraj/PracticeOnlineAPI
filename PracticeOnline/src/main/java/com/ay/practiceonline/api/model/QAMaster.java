package com.ay.practiceonline.api.model;

import java.io.Serializable;

public class QAMaster implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String key; // Enum
	private String value;
	private boolean active;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "QAMaster [id=" + id + ", key=" + key + ", value=" + value + ", active=" + active + "]";
	}
	
	

}
