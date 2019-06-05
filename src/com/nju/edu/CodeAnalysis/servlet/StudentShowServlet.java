package com.nju.edu.CodeAnalysis.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nju.edu.CodeAnalysis.service.*;
import com.nju.edu.CodeAnalysis.service.impl.*;
import com.nju.edu.CodeAnalysis.utils.JSONUtil;

/**
 * Servlet implementation class StudentShowServlet
 */
@WebServlet("/StudentShow")
public class StudentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SonarService ss;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ss = new SonarServiceImpl();
		String projectPath = "student";
		String json = JSONUtil.JavaToJson(ss.getAnalysisOfStudent(projectPath));
		System.out.println(json);
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write(json);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
