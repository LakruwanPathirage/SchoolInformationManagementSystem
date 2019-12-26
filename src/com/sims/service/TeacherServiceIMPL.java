package com.sims.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sims.model.Teacher;
import com.sims.util.CommonConstant;
import com.sims.util.DBConnectionUtil;
import com.sims.util.QueryUtil;




public class TeacherServiceIMPL implements ITeacherService {

	

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(TeacherServiceIMPL.class.getName());

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	static {
		createTable();
	}
	
	public static void createTable() {
		try {
				connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.prepareStatement(CommonConstant.create_teacher_table);
			

			


		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();//close the connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Add set of teachers for as a batch from the selected teacher List
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * 
	 */
	@Override
	public void addTeacher(Teacher teacher) {

		//String teacherID = CommonUtil.generateIDs(getTeacherIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Query is available in TeacherQuery.xml file and use
			 * insert_teacher key to extract value of it
			 */
			preparedStatement = connection.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?)");
			
			connection.setAutoCommit(false);
			
			//Generate teacher IDs
			//teacher.setTeacherID(teacherID);
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, teacher.getTeacherID());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_TWO, teacher.getName());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_THREE, teacher.getAddress());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FOUR, teacher.getClass_());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FIVE, teacher.getSubject());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_SIX, teacher.getSection());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_SEVEN, teacher.getQualifications());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_EIGHT, teacher.getGender());
			// Add teacher
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * Teacher details can be retrieved based on the provided Teacher ID
	 * 
	 * @param TeacherID
	 *            - Teacher details are filtered based on the ID
	 * 
	 * @see #actionOnTeacher()
	 */
	@Override
	public Teacher getTeacherByID(String teacherID)
	{

		return actionOnTeacher(teacherID).get(0);
	}
	
	/**
	 * Get all list of Teachers
	 * 
	 * @return ArrayList<Teacher> 
	 * 						- Array of Teacher list will be return
	 * 
	 * @see #actionOnTeacher()
	 */
	@Override
	public ArrayList<Teacher>getTeachers() {
		
		return actionOnTeacher(null);
	}
	//updateTeacher
	
	public void UpdateTeacher(Teacher teacher) {
		
		try {
			connection = DBConnectionUtil.getDBConnection();
		
			preparedStatement = connection.prepareStatement("update teacher set name = ?,address = ?,class = ?,Subject = ?,teacherSection = ?,Qualifications = ?,Gender = ? where teacherID = ?");
	
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, teacher.getName());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_TWO, teacher.getAddress());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_THREE, teacher.getClass_());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FOUR, teacher.getSubject());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FIVE, teacher.getSection());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_SIX, teacher.getQualifications());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_SEVEN, teacher.getGender());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_EIGHT, teacher.getTeacherID());
			
			preparedStatement.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
		

	/**
	 * This method delete an Teacher based on the provided ID
	 * 
	 * @param TeacherID
	 *            - Delete Teacher according to the filtered Teacher details
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	@Override
	public void removeTeacher(String teacherID){

		// Before deleting check whether Teacher ID is available
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Remove Teacher query will be retrieved from TeacherQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_REMOVE_TEACHER));
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, teacherID);
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	/**
	 * This performs GET teacher by ID and Display all teachers
	 * 
	 * @param teacherID
	 *            ID of the teacher to remove or select from the list

	 * @return ArrayList<Teacher> Array of teacher list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 * 
	 * @see #getTeachers()
	 * @see #getTeacherByID(String)
	 */
	private ArrayList<Teacher> actionOnTeacher(String teacherID) {

		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching teacher it checks whether teacher ID is
			 * available
			 */
			if (teacherID != null && !teacherID.isEmpty()) {
				/*
				 * Get teacher by ID query will be retrieved from
				 * TeacherQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_GET_TEACHER));
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, teacherID);
			}
			/*
			 * If teacher ID is not provided for get teacher option it display
			 * all teachers
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_ALL_TEACHERS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherID(resultSet.getString(CommonConstant.COLUMN_INDEX_ONE));
				teacher.setName(resultSet.getString(CommonConstant.COLUMN_INDEX_TWO));
				teacher.setAddress(resultSet.getString(CommonConstant.COLUMN_INDEX_THREE));
				teacher.setSubject(resultSet.getString(CommonConstant.COLUMN_INDEX_FOUR));
				teacher.setSection(resultSet.getString(CommonConstant.COLUMN_INDEX_FIVE));
				teacher.setClass_(resultSet.getString(CommonConstant.COLUMN_INDEX_SIX));
				teacher.setQualifications(resultSet.getString(CommonConstant.COLUMN_INDEX_SEVEN));
				teacher.setGender(resultSet.getString(CommonConstant.COLUMN_INDEX_EIGHT));
				teacherList.add(teacher);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return teacherList;
	}

	/**
	 * Get the updated teacher
	 * 
	 * @param teacherID
	 *            ID of the teacher to remove or select from the list
	 * 
	 * @return return the Teacher object
	 * 
	 */
	@Override
	public Teacher updateTeachers(String teacherID, Teacher teacher) {

		/*
		 * Before fetching teacher it checks whether teacher ID is available
		 */
		if (teacherID != null && !teacherID.isEmpty()) {
			/*
			 * Update teacher query will be retrieved from TeacherQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_UPDATE_TEACHER));
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, teacher.getName());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_TWO, teacher.getClass_());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_THREE, teacher.getSubject());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_FOUR, teacher.getSection());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_FIVE, teacher.getAddress());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_SIX, teacher.getQualifications());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_SEVEN, teacher.getGender());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_EIGHT, teacher.getTeacherID());

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated teacher
		return getTeacherByID(teacherID);
	}
	
	/**
	 *
	 * @return ArrayList<String> Array of teacher id list will be return
	 * 
	 * @throws SQLException
	 *             - Thrown when database access error occurs or this method is
	 *             called on a closed connection
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class through
	 *             its string name using
	 * @throws SAXException
	 *             - Encapsulate a general SAX error or warning
	 * @throws IOException
	 *             - Exception produced by failed or interrupted I/O operations.
	 * @throws ParserConfigurationException
	 *             - Indicates a serious configuration error.
	 * @throws NullPointerException
	 *             - Service is not available
	 */
	private ArrayList<String> getTeacherIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of teacher IDs will be retrieved from TeacherQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_GET_TEACHER_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstant.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
