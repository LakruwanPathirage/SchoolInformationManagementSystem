//IT18062816
//M.G.R.Wijethilaka

package com.sims.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListNoticeServlet  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ListNoticeServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListNotice.jsp");
		dispatcher.forward(request, response);
	}
	
	

}
