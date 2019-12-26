//IT18061512,W.A.A.S weerathunga
package com.sims.model;

public class Assignment {

	private String assignmentId;
	private String class_;
	private String descpt;
	private int state;
	
	//get AssignmentId
	public String getAssignmentId() {
		return assignmentId;
	}
	
	//set assignmentId
	public void setAssignmentId(String assignmentId) {
		this.assignmentId = assignmentId;
	}
	//get class
	public String getClass_() {
		return class_;
	}
	
	//set class
	public void setClass_(String class_) {
		this.class_ = class_;
	}

	//get Assignment Description
	public String getDescpt() {
		return descpt;
	}

	//set Assignment Description
	public void setDescpt(String descpt) {
		this.descpt = descpt;
	}
	
	//get Assignment state whether assignment is already allocated or not
	public int getState() {
		return state;
	}

	//set assignment state as zero or one
	public void setState(int state) {
		this.state = state;
	}
	
	

}
