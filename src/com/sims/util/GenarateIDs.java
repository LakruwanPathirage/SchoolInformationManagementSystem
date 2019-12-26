package com.sims.util;

import java.util.ArrayList;

public class GenarateIDs {
	
	public static String generateassignmentID(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = "AS300" + next;
		while(arrayList.contains(id)) {
			next++;
			id = "AS300" + next;
		}
		return id;
	}

}
