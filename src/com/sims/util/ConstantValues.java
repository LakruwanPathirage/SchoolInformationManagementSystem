//IT18061512,W.A.A.S weerathunga
package com.sims.util;

/*this class is created to use common queries and those common queries are stored in as static varibles*/
public class ConstantValues {

	public static final String insert_Assignment_value_query = "insert into assignment values(?,?,?,NULL);";

	public static final String select_All_Assignment = "select * from assignment";

	public static final String select_absence_Teachers = "select teacherid from teacherDallyAttend where attend is null;";

	public static final String get_time_table = "select * from timetable where teacherid=?;";

	public static final String get_assignment_description = "select despt from assignment  where classId=? and allocateState is null;";
	public static final String get_teacher_Name = "select name from teacher  where teacherId=?;";
	public static final String get_assignment_details = "select * from assignment where assignmentId=?;";
	public static final String update_assment = "update assignment set classId=?,despt=? where assignmentId=?;";
	public static final String delete_assignment = "DELETE FROM assignment WHERE assignmentId=?;";

	public static final String create_assignment_table = "create table IF NOT EXISTS assignment(assignmentId varchar(10) not null,classId varchar(10),despt varchar(100),allocateState int,primary key(assignmentId));";

	public static final int COLUMN_INDEX_ONE = 1;

	
	public static final int COLUMN_INDEX_TWO = 2;

	
	public static final int COLUMN_INDEX_THREE = 3;

	
	public static final int COLUMN_INDEX_FOUR = 4;

	
	public static final int COLUMN_INDEX_FIVE = 5;

	
	public static final int COLUMN_INDEX_SIX = 6;

	
	public static final int COLUMN_INDEX_SEVEN = 7;

	
	public static final int COLUMN_INDEX_EIGHT = 8;
}
