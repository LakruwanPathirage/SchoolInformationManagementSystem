//IT18061512,W.A.A.S weerathunga
package com.sims.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sims.model.AllocateAssignment;
import com.sims.model.Assignment;
import com.sims.model.Periods;
import com.sims.util.ConstantValues;
import com.sims.util.DBconection;
import com.sims.util.GenarateIDs;
import com.sun.org.apache.bcel.internal.classfile.ConstantValue;


//implements the AnalyseService interface
public class AnalyseServiceIMPL implements AnalyseService {

	private static Connection connection;//create connection type variable

	private static Connection connection2;//create connection type variable

	// create DBDBconection object to get connect with SIMSDB database
	private static DBconection conect = new DBconection();

	private static PreparedStatement preparedStatement;

	private static PreparedStatement preparedStatement2;

	private static ResultSet resultSet;

	private static ResultSet resultSet2;
	
	static {
		createTable();
	}
	
	public static void createTable() {
		try {
			connection = conect.getConection();//create connection
			
			preparedStatement = connection.prepareStatement(ConstantValues.create_assignment_table);/*create assignment table if not exist*/
			

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

	/**
	 * this method will add assignment details to assignment table which in SIMSDB database
	 * 
	 **/
	
	public void addAssignment(Assignment newassignmet) {
		String aid = GenarateIDs.generateassignmentID(GetIds());
		newassignmet.setAssignmentId(aid);

		try {
			connection = conect.getConection();//create connection
			
			preparedStatement = connection.prepareStatement(ConstantValues.insert_Assignment_value_query);/*insert query is implemented in constantValues class and
			insert_Assignment_value_query is static attribute implemented inside the constantavlues class*/
			
			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, newassignmet.getAssignmentId());
			preparedStatement.setString(ConstantValues.COLUMN_INDEX_TWO, newassignmet.getClass_());
			preparedStatement.setString(ConstantValues.COLUMN_INDEX_THREE, newassignmet.getDescpt());

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

	
	/**
	 * this method returns assignment arraylist object
	 * get inputs from assignment table from SIMSDB database
	 */
	public ArrayList<Assignment> getAssignmentList() {
	 
		ArrayList<Assignment> assignmentList = new ArrayList<>();//create ArrayList object to add assignments

		connection = conect.getConection();
		try {
			preparedStatement = connection.prepareStatement(ConstantValues.select_All_Assignment);//select all assignment in constantvalues class and "select_all_assignment" is static variable inside the constant values class

			resultSet = preparedStatement.executeQuery();//execute the select_all_assignment query

			while (resultSet.next()) {
				Assignment assignment = new Assignment();	//create Assignment object
				assignment.setAssignmentId(resultSet.getString(ConstantValues.COLUMN_INDEX_ONE));/*setting all data to Assignment object taking from database*/
				assignment.setClass_(resultSet.getString(ConstantValues.COLUMN_INDEX_TWO));
				assignment.setDescpt(resultSet.getString(ConstantValues.COLUMN_INDEX_THREE));
				assignment.setState(resultSet.getInt(ConstantValues.COLUMN_INDEX_FOUR));

				assignmentList.add(assignment);
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

		return assignmentList; //return assignmentList object

	}

	/**
	 * this will return list of AllocateAssignment objects which contain details about allocated assignment to particular class
	 */
	public ArrayList<AllocateAssignment> getAllocateAssignmentList() {

		ArrayList<AllocateAssignment> allocateassignment = new ArrayList<>();

		try {
			connection = conect.getConection();

			preparedStatement = connection
					.prepareStatement(ConstantValues.select_absence_Teachers);//"select_absence_Teachers" query is implemened inside the constantValues class and "select_absence_Teachers" is static attribute

			resultSet = preparedStatement.executeQuery();//execute the query

			while (resultSet.next()) {

				connection2 = conect.getConection();

				preparedStatement2 = connection2.prepareStatement(ConstantValues.get_time_table);//"get_time_table" query is implemened inside the constantValues class and "get_time_table" is static attribute

				preparedStatement2.setString(ConstantValues.COLUMN_INDEX_ONE, resultSet.getString(1));

				resultSet2 = preparedStatement2.executeQuery();

				resultSet2.first();
				/* setting all data to Allocateassignment object using for loop*/
				for (int i = 2; i < 10; i++) {
					AllocateAssignment aAssignment = new AllocateAssignment();//create AllocateAssignment object

					aAssignment.setTeacherName(resultSet2.getString(ConstantValues.COLUMN_INDEX_ONE));/*use methods 
					of the
					 AllocateAssignment class*/ 

					aAssignment.setClassName(resultSet2.getString(i));

					aAssignment.setPeriod(i - 1);//i-1 means because i is start with value 2

					aAssignment.setAssignmentDes(getAssignmentDescription(resultSet2.getString(i)));

					allocateassignment.add(aAssignment);//add method is method of ArrayList
				}

				resultSet.next();
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

		return allocateassignment;//return allocateassignment ArrayList object
	}

	/**
	 * this will return absent teacher's IDs list 
	 */
	public ArrayList<String> getTeacherId() {

		ArrayList<String> list = new ArrayList<>();

		connection = conect.getConection();

		try {

			preparedStatement = connection
					.prepareStatement(ConstantValues.select_absence_Teachers);//"select_absence_Teachers" query is implemened inside the constantValues class and "select_absence_Teachers" is static attribute

			resultSet = preparedStatement.executeQuery();//execute the query

			while (resultSet.next()) {
				list.add(resultSet.getString(ConstantValues.COLUMN_INDEX_ONE));
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

		return list;
	}


	public String getAssignmentDescription(String classid) {
		connection = conect.getConection();

		String descp = null;
		try {

			preparedStatement = connection
					.prepareStatement(ConstantValues.get_assignment_description);//"get_assignment_description" query is implemened inside the constantValues class and "get_assignment_description" is static attribute


			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, classid);

			resultSet = preparedStatement.executeQuery();//execute the query

			resultSet.first();

			descp = resultSet.getString(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return descp;
	}

	/**
	 * this return teacher's names from teacher taable using teacherid
	 * @param teacherid
	 * @return
	 */
	public String getTeacherName(String teacherid) {
		connection = conect.getConection();

		String name = "name";

		try {
			preparedStatement = connection.prepareStatement(ConstantValues.get_teacher_Name);//"get_teacher_Name" query is implemened inside the constantValues class and "get_teacher_Name" is static attribute

			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, teacherid);

			resultSet = preparedStatement.executeQuery();//execute the query

			resultSet.first();

			name = resultSet.getString(ConstantValues.COLUMN_INDEX_ONE);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return name;
	}

	/**
	 * this will return Assignment object when give Assignment id as a parameter
	 */
	public Assignment getAssignmentById(String aID) {

		Assignment assignment = new Assignment();//create Assignment object

		try {
			connection = conect.getConection();

			preparedStatement = connection.prepareStatement(ConstantValues.get_assignment_details);/*get_assignment_details" query is implemened 
			inside the constantValues class and "get_assignment_details" is static attribute*/

			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, aID);

			resultSet = preparedStatement.executeQuery();//execute the query

			resultSet.first();
			//setting values to Assignment object
			assignment.setAssignmentId(resultSet.getString(ConstantValues.COLUMN_INDEX_ONE));
			assignment.setClass_(resultSet.getString(ConstantValues.COLUMN_INDEX_TWO));
			assignment.setDescpt(resultSet.getString(ConstantValues.COLUMN_INDEX_THREE));
			// assignment.setState(resultSet.getInt(4));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return assignment;//return Assignment object
	}

	/**
	 * this method will update assignment table with newly input details
	 */
	public void updateAssignment(Assignment aID) {
		try {
			connection = conect.getConection();//crate connection

			preparedStatement = connection
					.prepareStatement(ConstantValues.update_assment);//"update_assment" query is implemened inside the constantValues class and "update_assment" is static attribute

			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, aID.getClass_());
			preparedStatement.setString(ConstantValues.COLUMN_INDEX_TWO, aID.getDescpt());
			preparedStatement.setString(ConstantValues.COLUMN_INDEX_THREE, aID.getAssignmentId());

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

	/**
	 * this method will delete row of given assignment id from assignment table
	 */
	public void deleteAssignmentById(String aID) {
		try {
			connection = conect.getConection();

			preparedStatement = connection.prepareStatement(ConstantValues.delete_assignment);////"delete_assignment" query is implemened inside the constantValues class and "delete_assignment" is static attribute


			preparedStatement.setString(ConstantValues.COLUMN_INDEX_ONE, aID);

			preparedStatement.execute();

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
	/*this method returns ArrayList of Ids*/
	private ArrayList<String> GetIds(){
		ArrayList<String> IDs = new ArrayList<>();//create ArrayList object
		try {
			connection = conect.getConection();

			preparedStatement = connection.prepareStatement("select assignmentId from assignment;");

			resultSet = preparedStatement.executeQuery();//execute the query
			
			while(resultSet.next()) {
				IDs.add(resultSet.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();//close the connection
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return IDs;
	}
}