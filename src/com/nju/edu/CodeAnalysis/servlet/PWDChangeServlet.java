package com.nju.edu.CodeAnalysis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.edu.CodeAnalysis.service.AuthenticationService;
import com.nju.edu.CodeAnalysis.service.impl.AuthenticationServiceImpl;

/**
 * Servlet implementation class PWDChangeServlet
 */
@WebServlet("/PWDChange")
public class PWDChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AuthenticationService authenticationService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PWDChangeServlet() {
        super();
        authenticationService = new AuthenticationServiceImpl();
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
		// TODO Auto-generated method stub
		String pwd = request.getParameter("pwd");
		
		authenticationService.changePwd("admin", pwd);
		
		response.sendRedirect("/CodeAnalysis/success.html");
	}

}
