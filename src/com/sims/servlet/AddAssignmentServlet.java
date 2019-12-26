
// IT18061512,W.A.A.S Weerathunge 
package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.model.Assignment;
import com.sims.service.AnalyseService;
import com.sims.service.AnalyseServiceIMPL;

/**
 * Servlet implementation class AddAssignmentServlet
 */
@WebServlet("/AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAssignmentServlet() {
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
		
		
				//getting user input into variables using request object
		//String assignmentId = request.getParameter("asid");
				String class_ = request.getParameter("class");	
				String description = request.getParameter("description");
				
				Assignment newassignment = new Assignment();	//crate Assignment object 
				
				//newassignment.setAssignmentId(assignmentId);
				/*setting user values to assignment object*/
				newassignment.setClass_(class_);
				newassignment.setDescpt(description);
				
				AnalyseService analyseService = new AnalyseServiceIMPL();//create database object to  create connection and execute query
				analyseService.addAssignment(newassignment);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListAssignment.jsp");	//direct into ListAssignment.jsp
				dispatcher.forward(request, response);
	}

}
