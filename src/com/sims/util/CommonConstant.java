package com.sims.util;



public class CommonConstant {

	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in TeacherQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in TeacherQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for teacher id prefix */
	public static final String TEACHER_ID_PREFIX = "E300";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in TeacherQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in TeacherQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_teacher_table";

	/** Constant for query id of insert teachers in TeacherQuery.xml */
	public static final String QUERY_ID_INSERT_TEACHERS = "insert_teacher";

	/** Constant for query id of get an teacher in TeacherQuery.xml */
	public static final String QUERY_ID_GET_TEACHER = "teacher_by_id";

	/** Constant for query id of get all teachers in TeacherQuery.xml */
	public static final String QUERY_ID_ALL_TEACHERS = "all_teachers";

	/** Constant for query id of remove a teacher in TeacherQuery.xml */
	public static final String QUERY_ID_REMOVE_TEACHER = "remove_teacher";

	/** Constant for query id of update a teacher in TeacherQuery.xml */
	public static final String QUERY_ID_UPDATE_TEACHER = "update_teacher";

	/** Constant for query id of get all teacher ids in TeacherQuery.xml */
	public static final String QUERY_ID_GET_TEACHER_IDS = "teacher_ids";
	
	public static final String QUERY_ID_GET_NOTICE_IDS = "notice_ids";
	
	public static final String insert_Assignment_value_query ="insert into assignment values(?,?,?,NULL);";
	
	public static final String select_All_Assignment ="select * from assignment";
	
	public static final String select_absence_Teachers ="select teacherid from teacherDallyAttend where attend is null;";
	
	public static final String get_time_table  ="select * from timetable where teacherid=?;";
	
	public static final String get_assignment_description ="select despt from assignment  where classId=? and allocateState is null;";
	public static final String get_teacher_Name ="select name from teacher  where teacherId=?;";
	public static final String get_assignment_details ="select * from assignment where assignmentId=?;";
	public static final String update_assment ="update assignment set classId=?,despt=? where assignmentId=?;";
	public static final String delete_assignment ="DELETE FROM assignment WHERE assignmentId=?;";
	
	public static final String create_notice_table = "CREATE TABLE IF NOT EXISTS notice(noticeID varchar(10) not null,noticeName varchar(50),"
			+ "teacherID varchar(10),teacherName varchar(20),grade_class varchar(15),notice_des varchar(255),primary key (noticeID));";
	
	
	public static final String create_teacher_table ="create table IF NOT EXISTS teacher(teacherId varchar(10),name varchar(20),address varchar(30),class varchar(10),primary key(teacherId),foreign key(class) references class(classId));";
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
}

