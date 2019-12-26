package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.model.Notice;
import com.sims.service.INoticeService;
import com.sims.service.NoticeServiceImpl;



/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/UpdateNoticeServlet")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		Notice notice = new Notice();
		String noticeID = request.getParameter("noticeID");	
		notice.setNoticeID(noticeID);
		notice.setNoticeName(request.getParameter("noticeName"));
		notice.setTeacherID(request.getParameter("teacherID"));
		notice.setTeacherName(request.getParameter("TeacherName"));
		notice.setGrade_class(request.getParameter("getGrade_class"));
		notice.setNotice_des(request.getParameter("Notice_des"));
		
		INoticeService iNoticeService = new NoticeServiceImpl();
		iNoticeService.updateNotice(noticeID, notice);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListNotice.jsp");
		dispatcher.forward(request, response);
	}

}
