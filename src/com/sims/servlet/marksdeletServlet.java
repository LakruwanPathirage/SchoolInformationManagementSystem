
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
 * Servlet implementation class marksdeletServlet
 */
@WebServlet("/marksdeletServlet")
public class marksdeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public marksdeletServlet() {
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
	
 		String studentId = request.getParameter("studentId");			//fetching studentid from select.jsp

 		marksAnalyservice service = new marksAnalyserviceIMPL();		//create marksAnalyserviceIMPL object
 		
 		service.deletemarksById(studentId);//calling deletemarksById method in marksAnalyserviceIMPL class
 		
 		

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Listmarks.jsp");	//directed in to Listmarks.jsp
		dispatcher.forward(request, response);
	}

}
