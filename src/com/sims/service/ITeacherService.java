package com.sims.service;



import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.sims.model.Teacher;


public interface ITeacherService {
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ITeacherService.class.getName());


	/**
	 * Add teachers for teacher table
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher);

	/**
	 * Get a particular Teacher
	 * 
	 * @param teacherID
	 * @return Teacher
	 */
	public Teacher getTeacherByID(String teacherID);
	
	/**
	 * Get all list of teachers
	 * 
	 * @return ArrayList<teacher>
	 */
	public ArrayList<Teacher> getTeachers();
	
	/**
	 * Update existing teacher
	 * @param teacherID
	 * @param teacher
	 * 
	 * @return
	 */
	public void UpdateTeacher(Teacher teacher);

	/**
	 * Remove existing teacher
	 * 
	 * @param teacherID
	 */
	public void removeTeacher(String teacherID);

	public Teacher updateTeachers(String teacherID, Teacher teacher);
	
	
}
