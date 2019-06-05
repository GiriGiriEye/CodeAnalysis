package com.nju.edu.CodeAnalysis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.edu.CodeAnalysis.service.*;
import com.nju.edu.CodeAnalysis.service.impl.*;

/**
 * Servlet implementation class StudentScanServlet
 */
@WebServlet("/StudentScan")
public class StudentScanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SonarService ss;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ss = new SonarServiceImpl();
		String projectPath = (String)request.getParameter("projectPath");
		String gitPath = (String)request.getParameter("gitPath");
		if(projectPath != null && !projectPath.equals(""))
			ss.scan(projectPath);
		else if(gitPath != null && !gitPath.equals("")) {
			response.sendRedirect("/CodeAnalysis/html/ShowStudentGitAnalysis.html");
			ss.studentGitScan(gitPath);
		}
	}

}
