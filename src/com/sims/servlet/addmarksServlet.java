
//IT 18053838,H.P Sumudu Lakruwan
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
 * Servlet implementation class addmarksServlet
 */
@WebServlet("/addmarksServlet")
public class addmarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmarksServlet() {
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
		//fetching form details such as studentId,grade,subject,marks using request object and store them in attributes
		String studentId = request.getParameter("studentId");
		String grade = request.getParameter("grade");
		String subject = request.getParameter("subject");
		String marks=request.getParameter("marks");
		
	Marks m = new Marks();//create Marks object
	
		m.setStudentId(studentId);	//set studentid to Marks object
		m.setGrade(grade);			//set grade to Marks object
		m.setSubject(subject);		//set Subject to Marks object
		m.setMarks(marks);			//setmarks to Marks object
		
	marksAnalyservice analyseService = new marksAnalyserviceIMPL();//create marksAnalyserviceImpl object to communicate with database
		analyseService.addmarks(m);//calling addmark method in markanalyserviceImpl class
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/marksview.jsp");//redirec page in to index.jsp
		dispatcher.forward(request, response);
		
	}

}
