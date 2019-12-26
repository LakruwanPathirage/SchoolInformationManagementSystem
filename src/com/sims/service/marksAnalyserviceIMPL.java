
//IT18053838,H.P Sumudu Lakruwan
package com.sims.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.sims.model.Marks;
import com.sims.util.ConstantValues;
import com.sims.util.DBconection;
//implement the interface using marksAnalyservice
public class marksAnalyserviceIMPL implements marksAnalyservice  {

	private static Connection connection;	//create connection attribute

	private static DBconection conect = new DBconection();//create Dbconnction attribute

	private static PreparedStatement preparedStatement;	

	private ResultSet resultSet;

	static {
		createTable();
	}

	public static void createTable() {
		try {
			connection = conect.getConection();//create connection
			
			/*create assignment table if not exist*/
			preparedStatement = connection.prepareStatement("create table IF NOT EXISTS marks (studentId varchar(10) not null, grade varchar(10),marks varchar(10),subject varchar(10), primary key(studentId)");
			
			preparedStatement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();//close the connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//create addmarks method to add marks to the database
	public void addmarks(Marks mrks) {

		connection = conect.getConection();

		try {
			preparedStatement = connection.prepareStatement("insert into marks values(?,?,?,?);");//implementation of insert query
			
			preparedStatement.setString(1, mrks.getStudentId());//setting values
			preparedStatement.setString(2, mrks.getGrade());//setting values
			preparedStatement.setString(3, mrks.getMarks());//setting values
			preparedStatement.setString(4, mrks.getSubject());//setting values
			

			preparedStatement.execute();//executing query

			connection.close();//finally close the databse connection

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
		//returns Arraylisst of marks
	public ArrayList<Marks> getstudentmarks() {
		ArrayList<Marks> getstudentmarks = new ArrayList<>();//Marks generic type ArrayList implementation

		connection = conect.getConection();//get connection
		try {
			preparedStatement = connection.prepareStatement("select * from marks;");//select query that take all values from marks table implemented in database

			resultSet = preparedStatement.executeQuery();
				
				//resultset.next() is used to cursor down to next line of table
			while (resultSet.next()) {
				Marks show= new Marks();	//create Marks object
				show.setStudentId(resultSet.getString(1));   //setting values to Marks object
				show.setGrade(resultSet.getString(2));       //setting values to Marks object
				show.setMarks(resultSet.getString(3));		//setting values to Marks object
				show.setSubject(resultSet.getString(4));    //setting values to Marks object
				
				getstudentmarks.add(show);//called add method in ArrayList collection class
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return getstudentmarks;			//return List of students marks

	}
	
	
	
	
	
	//return Marks object after setting all the values only taking studentId as argument
	public Marks getmarksById(String ID) {
		
		Marks mks = new Marks();		//create Marks object
		
		try {
		connection = conect.getConection();
		
		preparedStatement = connection.prepareStatement("select * from marks where studentId=?;");    //select query that takes all values from marks tables 
		
		preparedStatement.setString(1, ID);

		resultSet = preparedStatement.executeQuery();	//execute the query
		
		resultSet.first();
		
		mks.setStudentId(resultSet.getString(1));	/*setting values to Marks
	 												object from database*/
		mks.setGrade(resultSet.getString(2));
		mks.setMarks(resultSet.getString(3));	
		mks.setSubject(resultSet.getString(4));
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mks;			
}
	

	
	
			//update is done in here
	public void updatemarks(Marks ID) {
		try {
			connection = conect.getConection();		//create connection
			
			preparedStatement = connection.prepareStatement("update marks set grade=?,marks=?,subject=? where studentId=?;");//update query that set values to marks table
			
			preparedStatement.setString(1,ID.getGrade());
			preparedStatement.setString(2, ID.getMarks());
			preparedStatement.setString(3, ID.getSubject());
			preparedStatement.setString(4, ID.getStudentId());
			
			
			preparedStatement.execute();		//execute query
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}

		//delete record by using only studentId
	public void deletemarksById(String ID) {
		try {
			connection = conect.getConection();		//create connection
			
			preparedStatement = connection.prepareStatement("delete from marks where studentId=?;");
			
			preparedStatement.setString(1, ID);	//set studentId
			
			preparedStatement.execute();	//execute query
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
	}
}
	
	
	
	
	
	
