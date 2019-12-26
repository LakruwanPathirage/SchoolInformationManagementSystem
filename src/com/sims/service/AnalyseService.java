//IT18061512,W.A.A.S weerathunga
package com.sims.service;

import java.util.ArrayList;

import com.sims.model.AllocateAssignment;
import com.sims.model.Assignment;
import com.sims.model.Periods;
//create interface called Analyseservices 
public interface AnalyseService {
	
	public void addAssignment(Assignment newassignmet);
	
	public ArrayList<Assignment> getAssignmentList();
	
	//public ArrayList<AllocateAssignment> getAllocateAssignmentList(ArrayList<String> tid);
	
	public ArrayList<AllocateAssignment> getAllocateAssignmentList();
	
	public String getAssignmentDescription(String classid);
	
	public ArrayList<String> getTeacherId();
	
	public Assignment getAssignmentById(String aID);
	
	public void updateAssignment(Assignment aID);
	
	public void deleteAssignmentById(String aID);
	
	

}
