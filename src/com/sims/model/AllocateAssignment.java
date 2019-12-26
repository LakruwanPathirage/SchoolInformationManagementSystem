//IT18061512,W.A.A.S weerathunga
package com.sims.model;

//create class to allocate assignment 
public class AllocateAssignment {
	private String teacherName;
	private String className;
	private int Period;
	private String AssignmentDes;

	//returns  teacherName from the current object
	public String getTeacherName() {
		return teacherName;
	}
	//setting teacher name
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	//return the class name
	public String getClassName() {
		return className;
	}

	//set class name
	public void setClassName(String className) {
		this.className = className;
	}
//get period which returns the period number having interger value
	public int getPeriod() {
		return Period;
	}
//setting period
	public void setPeriod(int period) {
		Period = period;
	}
	//get Assignment description
	public String getAssignmentDes() {
		return AssignmentDes;
	}
//setting Assignment description
	public void setAssignmentDes(String assignmentDes) {
		AssignmentDes = assignmentDes;
	}

}
