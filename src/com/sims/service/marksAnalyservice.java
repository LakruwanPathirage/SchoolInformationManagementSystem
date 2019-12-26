
//IT18053838,H.P Sumudu Lakruwan
package com.sims.service;

import java.util.ArrayList;

import com.sims.model.Marks;
//create interface called marksAnalyservice
public interface marksAnalyservice {
	
	public void addmarks(Marks mrks);
	
	public ArrayList<Marks> getstudentmarks();
	public Marks getmarksById(String ID);
	public void updatemarks(Marks ID);
	public void deletemarksById(String ID);
	
}
