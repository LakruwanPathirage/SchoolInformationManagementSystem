package com.sims.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool2.impl.NoOpCallStack;

import com.sims.model.AllocateAssignment;
import com.sims.model.Periods;
import com.sims.service.AnalyseService;
import com.sims.service.AnalyseServiceIMPL;

/**
 * Servlet implementation class AnalyseServlet
 */
@WebServlet("/AnalyseServlet")
public class AnalyseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalyseServlet() {
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
		
		AnalyseService service = new AnalyseServiceIMPL();
		
		ArrayList<String> tid = service.getTeacherId();
		
		ArrayList<AllocateAssignment> allocateassignment = service.getAllocateAssignmentList();
		/*ArrayList<AllocateAssignment> allocateassignment = new ArrayList<>();
		
		AllocateAssignment nno = new AllocateAssignment();
		
	
		nno.setTeacherName("rani");
		nno.setClassName("10A");
		nno.setPeriod(1);
		nno.setAssignmentDes("assignmentDes");
		
		AllocateAssignment noo = new AllocateAssignment();
		
		
		noo.setTeacherName("rani");
		noo.setClassName("10A");
		noo.setPeriod(1);
		noo.setAssignmentDes("assignmentDes");
		
		allocateassignment.add(nno);
		allocateassignment.add(noo);*/
		
		
		
		request.setAttribute("allocateAssignment", allocateassignment);
		//request.setAttribute("tid", tid);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/AnalyseAssignment.jsp");
		dispatcher.forward(request, response);
		
	}

}
