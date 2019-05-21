package com.nju.edu.CodeAnalysis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nju.edu.CodeAnalysis.service.AuthenticationService;
import com.nju.edu.CodeAnalysis.service.impl.AuthenticationServiceImpl;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private AuthenticationService authenticationService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        authenticationService = new AuthenticationServiceImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");

		boolean verified = authenticationService.loginVarification(name, pwd);
		
		if(verified) {
			HttpSession session = request.getSession(true);         
			session.setAttribute("name", name);
			response.sendRedirect("/CodeAnalysis/html/moodle_config.html");
		}
	}

}
