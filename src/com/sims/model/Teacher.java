package com.sims.model;


public class Teacher {

	private String TeacherID;
	
	private String Name;

	private String Class_;

	private String Subject;

	private String Section;

	private String Address;
	
	private String Qualifications;
	
	private String Gender;

	/**
	 * @return the TeacherID
	 */
	public String getTeacherID() {
		return TeacherID;
	}

	/**
	 * @param TeacherID the TeacherID to set
	 */
	public void setTeacherID(String teacherID) {
		TeacherID = teacherID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}

	
	public String getClass_() {
		return Class_;
	}

	public void setClass_(String class_) {
		Class_ = class_;
	}

	public String getSubject() {
		return Subject;
	}

	/**
	 * @param Subject the Subject to set
	 */
	public void setSubject(String subject) {
		Subject = subject;
	}

	/**
	 * @return the Section
	 */
	public String getSection() {
		return Section;
	}

	/**
	 * @param Section the Section to set
	 */
	public void setSection(String section) {
		Section = section;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @return the qualifications
	 */
	public String getQualifications() {
		return Qualifications;
	}

	/**
	 * @param qualifications the qualifications to set
	 */
	public void setQualifications(String qualifications) {
		Qualifications = qualifications;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		
		return "Teacher ID = " + TeacherID + "\n" + "Emplyee Name = " + Name + "\n" + "Address = " + Address + "\n"
				+ "Faculty Name = " + Subject + "\n" + "Section = " + Section + "\n" + "Designation = "
				+ Class_ + "\n" + "Qualifications = " + Qualifications + "\n" + "Gender = " + Gender;
	}
}

