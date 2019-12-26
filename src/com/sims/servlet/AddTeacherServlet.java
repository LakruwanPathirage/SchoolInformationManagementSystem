package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.model.Teacher;
import com.sims.service.ITeacherService;
import com.sims.service.TeacherServiceIMPL;



/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacherServlet() {
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

		Teacher teacher = new Teacher();
		
		teacher.setTeacherID(request.getParameter("teacherID"));
		teacher.setName(request.getParameter("teacherName"));
		teacher.setAddress(request.getParameter("address"));
		teacher.setClass_(request.getParameter("Class"));
		teacher.setSubject(request.getParameter("subject"));
		teacher.setSection(request.getParameter("section"));
		teacher.setQualifications(request.getParameter("qualification"));
		teacher.setGender(request.getParameter("gender"));

		ITeacherService iteacherService = new TeacherServiceIMPL();
		iteacherService.addTeacher(teacher);

		request.setAttribute("teacher", teacher);   
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListTeacher.jsp");
		dispatcher.forward(request, response);
	}

}
