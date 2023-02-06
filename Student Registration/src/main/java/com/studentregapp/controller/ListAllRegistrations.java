package com.studentregapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentregapp.model.DAOService;
import com.studentregapp.model.DAOServiceImpl;

 
@WebServlet("/listall")
public class ListAllRegistrations extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListAllRegistrations() {
        super();
     }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") !=null) {
		
		DAOService service = new DAOServiceImpl();
		service.connectionDB();
		ResultSet result = service.listRegistrations();
		System.out.println(result);
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listall_reg.jsp");
		rd.forward(request, response);	
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);	
		}
		
	} catch (Exception e) {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);	
	}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
	}

}
