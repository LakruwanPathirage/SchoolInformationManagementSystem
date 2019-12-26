//IT18062816
//M.G.R.Wijethilaka

package com.sims.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sims.model.Notice;
import com.sims.util.CommonConstant;
import com.sims.util.ConstantValues;
import com.sims.util.DBConnectionUtil;
import com.sims.util.QueryUtil;

public class NoticeServiceImpl implements INoticeService {
	
	public static final Logger log = Logger.getLogger(NoticeServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;
	
	
	static {
		createTable();
	}
	
	public static void createTable() {
		try {
				connection = DBConnectionUtil.getDBConnection();
			
			statement = connection.prepareStatement(CommonConstant.create_notice_table);
			

			


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
	
	@Override
	public void addNotice(Notice notice) {

		//String noticeID = CommonUtil.generateIDs(getNoticeIDs());
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMSDB","root","root");
			
			//connection = DriverManager.getConnection(url)
			
			/*
			 * Query is available in NoticeQuery.xml file and use
			 * insert_notice key to extract value of it
			 */
			preparedStatement = connection.prepareStatement("insert into notice (noticeID , noticeName ,teacherID , teacherName , grade_class , notice_des) values (?, ?, ?, ?, ? , ?);");
			connection.setAutoCommit(false);
			
			//Generate notice IDs
			//notice.setNoticeID(noticeID);
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, notice.getNoticeID());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_TWO, notice.getNoticeName());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_THREE, notice.getTeacherID());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FOUR, notice.getTeacherName());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_FIVE, notice.getGrade_class());
			preparedStatement.setString(CommonConstant.COLUMN_INDEX_SIX, notice.getNotice_des());
			
			// Add notice
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

	public Notice getNoticeByID(String noticeID) {

		return actionOnNotice(noticeID).get(0);
	}
	
	public ArrayList<Notice> getNotice() {
		
		return actionOnNotice(null);
	}
		

	
	public void removeNotice(String noticeID) {

		// Before deleting check whether employee ID is available
		if (noticeID != null && !noticeID.isEmpty()) {
			/*
			 * Remove employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				Class.forName("com.mysql.jdbc.Driver");
		
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMSDB","root","root");
				preparedStatement = connection.prepareStatement("delete from notice where noticeID=?;");
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, noticeID);
				preparedStatement.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
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
		
	private ArrayList<Notice> actionOnNotice(String noticeID) {

		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
				
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMSDB","root","root");
			//connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			if (noticeID != null && !noticeID.isEmpty()) {
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement("select * from notice where noticeID=?");
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, noticeID);
			}
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			else {
				preparedStatement = connection.prepareStatement("select * from notice;");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Notice notice = new Notice();
				notice.setNoticeID(resultSet.getString(CommonConstant.COLUMN_INDEX_ONE));
				notice.setNoticeName(resultSet.getString(CommonConstant.COLUMN_INDEX_TWO));
				notice.setTeacherID(resultSet.getString(CommonConstant.COLUMN_INDEX_THREE));
				notice.setTeacherName(resultSet.getString(CommonConstant.COLUMN_INDEX_FOUR));
				notice.setGrade_class(resultSet.getString(CommonConstant.COLUMN_INDEX_FIVE));
				notice.setNotice_des(resultSet.getString(CommonConstant.COLUMN_INDEX_SIX));
		
				noticeList.add(notice);
			}

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
		return noticeList;
	}
	
	
	public Notice updateNotice(String noticeID, Notice notice) {

		/*
		 * Before fetching employee it checks whether employee ID is available
		 */
		if (noticeID != null && !noticeID.isEmpty()) {
			/*
			 * Update employee query will be retrieved from EmployeeQuery.xml
			 */
			try {
				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMSDB", "root", "root");
				
				preparedStatement = connection.prepareStatement("update notice set noticeName=?,teacherID=?, teacherName=?,grade_class=?,notice_des=? where noticeID=?;");
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_ONE, notice.getNoticeName());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_TWO, notice.getTeacherID());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_THREE, notice.getTeacherName());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_FOUR, notice.getGrade_class());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_FIVE, notice.getNotice_des());
				preparedStatement.setString(CommonConstant.COLUMN_INDEX_SIX, notice.getNoticeID());

				preparedStatement.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
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
		// Get the updated employee
		return getNoticeByID(noticeID);
	}
	
private ArrayList<String> getNoticeIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of employee IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstant.QUERY_ID_GET_NOTICE_IDS));
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
