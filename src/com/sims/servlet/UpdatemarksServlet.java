
//IT18053838,H.P Sumudu lakruwan

package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.model.Marks;
import com.sims.service.marksAnalyservice;
import com.sims.service.marksAnalyserviceIMPL;

/**
 * Servlet implementation class UpdatemarksServlet
 */
@WebServlet("/UpdatemarksServlet")
public class UpdatemarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatemarksServlet() {
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
		String studentId = request.getParameter("studentId");	//fetching values and store in to variables	
		String grade = request.getParameter("grade");	
		String marks = request.getParameter("marks");			
		String subject = request.getParameter("subject");	
		Marks mks = new Marks();//create Marks object using Marks class
		
		mks.setStudentId(studentId);
		mks.setGrade(grade);
		mks.setSubject(subject);
		mks.setMarks(marks);

 		marksAnalyservice service = new marksAnalyserviceIMPL();//create marksAnalyserviceIMPL object
 		
		service.updatemarks(mks);//calling updatemarks in marksAnalyserviceIMPL class

		request.setAttribute("mks", mks);//setattribute to send Listmarks.jsp 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Listmarks.jsp");
		dispatcher.forward(request, response);
	}

}
