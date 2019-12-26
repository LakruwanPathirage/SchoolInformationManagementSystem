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
 * Servlet implementation class SelectAssignmentServlet
 */
@WebServlet("/SelectAssignmentServlet")
public class SelectAssignmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAssignmentServlet() {
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

		//fetching assignment id from List.jsp and value is stored in a variable
 		String assignmentID = request.getParameter("assignmentID");			

 		AnalyseService service = new AnalyseServiceIMPL();	//craete AnalyseServiceImpl object
 		
		Assignment assignment = service.getAssignmentById(assignmentID);//calling getassignmentById method in AnalyseServiceImpl which return all values of with regards to assignment Id
 		
 		//Assignment assignment = new Assignment();
 		
 		/*assignment.setAssignmentId("fasf");
		assignment.setClass_("fsf");
		assignment.setDescpt("sdff");
		assignment.setState(0);*/

		request.setAttribute("assignment", assignment);//set attribute values
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/SelectAssignment.jsp");
		dispatcher.forward(request, response);
	}

}
