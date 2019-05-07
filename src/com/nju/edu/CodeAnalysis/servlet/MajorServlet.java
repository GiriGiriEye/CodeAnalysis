package com.nju.edu.CodeAnalysis.servlet;

import java.util.LinkedList;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.edu.CodeAnalysis.dao.*;
import com.nju.edu.CodeAnalysis.dao.impl.*;

/**
 * Servlet implementation class MajorServlet
 */
@WebServlet("/MajorServlet")
public class MajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LinkedList<String> projectPathList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AnalysisDao ad = new AnalysisDaoImpl();
		System.out.println(ad.getAllAnalysisByCourseNumberPath("operating system", 1).toString());
		response.getWriter().append(ad.getAllAnalysisByCourseNumberPath("operating system", 1).toString()).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
