package com.nju.edu.CodeAnalysis.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;
import com.nju.edu.CodeAnalysis.bean.*;
import com.nju.edu.CodeAnalysis.utils.*;
import java.io.*;
/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/show")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("111");
		AnalysisBean ab = new AnalysisBean("1","2","3","4","5","6","7","8");
		AnalysisBean ab1 = new AnalysisBean("1a","2a","3a","4a","5a","6a","7a","8a");
		LinkedList ll = new LinkedList();
		ll.add(ab);
		ll.add(ab1);
		String json = JSONUtil.JavaToJson(ll);
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
