package com.studentregapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentregapp.model.DAOService;
import com.studentregapp.model.DAOServiceImpl;
 
@WebServlet("/NewReg")
public class NewRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public NewRegController() {
        super();
        
    }
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") !=null) {
			
 		RequestDispatcher rd = request.getRequestDispatcher( "WEB-INF/views/New_Registration.jsp");
		rd.forward(request, response);
		
		}else {
			RequestDispatcher rd = request.getRequestDispatcher( "login.jsp");
			rd.forward(request, response);
		}
	} 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
		HttpSession session = request.getSession(false);
		if (session.getAttribute("email") !=null) {
			
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOService service = new DAOServiceImpl();
		
		service.connectionDB();
		service.saveReg(name,city, email, mobile);
		request.setAttribute("msg", "Your Record Is Saved");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/New_Registration.jsp");
		rd.forward(request, response);
		
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
} catch (Exception e) {
	RequestDispatcher rd = request.getRequestDispatcher( "login.jsp");
	rd.forward(request, response);
		}
	}

}
