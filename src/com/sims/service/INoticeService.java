//IT18062816
//M.G.R.Wijethilaka

package com.sims.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.sims.model.Notice;







public interface INoticeService {

	public static final Logger log = Logger.getLogger(INoticeService.class.getName());
	
	public void addNotice(Notice notice);
	
	public Notice getNoticeByID(String noticeID);
	
	public ArrayList<Notice> getNotice();
	
	public Notice updateNotice(String noticeID, Notice notice);
	
	public void removeNotice(String noticeID);
	
}
