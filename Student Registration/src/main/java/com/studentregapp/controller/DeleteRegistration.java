package com.studentregapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentregapp.model.DAOService;
import com.studentregapp.model.DAOServiceImpl;
 
@WebServlet("/delete")
public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DeleteRegistration() {
        super();
     }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String email = request.getParameter("email");
	 
	 DAOService service = new DAOServiceImpl();
			 service.connectionDB();
			 service.deleteByEmail(email);
			 
			 ResultSet result = service.listRegistrations();
				request.setAttribute("result", result);
			 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/listall_reg.jsp");
			 rd.forward(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

}
