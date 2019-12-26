package com.sims.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sims.service.ITeacherService;






public class CommonUtil {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ITeacherService.class.getName());

	public static final Properties properties = new Properties();

	static {
		try {
			
			// Read the property only once when load the class
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstant.PROPERTY_FILE));
			
		} catch (IOException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	/**
	 * Add new Teacher ID
	 * 
	 * @param arrayList
	 * @return
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstant.TEACHER_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstant.TEACHER_ID_PREFIX + next;
		}
		return id;
	}
}
