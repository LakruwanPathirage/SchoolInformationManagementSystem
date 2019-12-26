//IT18062816
//M.G.R.Wijethilaka

package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.model.Notice;
import com.sims.service.NoticeServiceImpl;




/**
 * Servlet implementation class AddNoticesServlet
 */
@WebServlet("/AddNoticesServlet")
public class AddNoticesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNoticesServlet() {
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

		Notice n = new Notice();
		
		n.setNoticeID(request.getParameter("noticeID"));
		n.setNoticeName(request.getParameter("noticeName"));
		n.setTeacherID(request.getParameter("teacherID"));
		n.setTeacherName(request.getParameter("teacherName"));
		n.setGrade_class(request.getParameter("grade_class"));
		n.setNotice_des(request.getParameter("notice_des"));
		
		NoticeServiceImpl noticeservice = new NoticeServiceImpl();
		noticeservice.addNotice(n);

		request.setAttribute("notice", n);
		
		//WEB-INF/views/ListNotice.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListNotice.jsp");
		dispatcher.forward(request, response);
	
	}

}
