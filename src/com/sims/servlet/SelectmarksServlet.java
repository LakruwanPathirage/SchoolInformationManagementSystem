

//IT18053838,H.P Sumudu Lakruwan


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
 * Servlet implementation class SelectmarksServlet
 */
@WebServlet("/SelectmarksServlet")
public class SelectmarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectmarksServlet() {
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

 		String studentId = request.getParameter("studentId");		//fetching studentid and store in atrrribute called studentId	

 		marksAnalyservice service = new marksAnalyserviceIMPL();	//create marksAnalyserviceImpl object 
 		
		Marks mks = service.getmarksById(studentId);			//select query run using  getmarksById method in marksAnalyserviceIMP
 		
 		
		request.setAttribute("marks",mks);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Select.jsp");		//direct into select.jsp page
		dispatcher.forward(request, response);
	}

}
