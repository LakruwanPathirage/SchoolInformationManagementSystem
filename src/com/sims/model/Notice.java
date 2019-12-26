package com.sims.model;
//M.G.R.Wijethilaka

public class Notice {
	
	private String noticeID;
	private String noticeName;
	private String teacherID;
	private String teacherName;
	private String grade_class;
	private String notice_des;
	
	
	/**
	 * @return the noticeID
	 */
	public String getNoticeID() {
		return noticeID;
	}

	/**
	 * @param noticeID the noticeID to set
	 */
	public void setNoticeID(String noticeID) {
		this.noticeID = noticeID;
	}

	/**
	 * @return the noticeName
	 */
	public String getNoticeName() {
		return noticeName;
	}

	/**
	 * @param name the name to set
	 */
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}

	/**
	 * @return the teacherID
	 */
	public String getTeacherID() {
		return teacherID;
	}

	/**
	 * @param teacherID the teacherID to set
	 */
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the grade_class
	 */
	public String getGrade_class() {
		return grade_class;
	}

	/**
	 * @param grade_class the grade_class to set
	 */
	public void setGrade_class(String grade_class) {
		this.grade_class = grade_class;
	}

	/**
	 * @return the notice_des
	 */
	public String getNotice_des() {
		return notice_des;
	}

	/**
	 * @param notice_des the notice_des to set
	 */
	public void setNotice_des(String notice_des) {
		this.notice_des = notice_des;
	}

	
	@Override
	public String toString() {
		
		return "Notice ID = " + noticeID + "\n" + "Notice Name = " + noticeName + "\n" + "Teacher ID = " + teacherID + "\n"
				+ "Teacher Name = " + teacherName + "\n" + "Grade & Class = " + grade_class + "\n" + "Notice = "
				+ notice_des ;
	}


}
