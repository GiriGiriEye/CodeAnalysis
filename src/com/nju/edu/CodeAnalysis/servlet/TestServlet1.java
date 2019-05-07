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
import com.nju.edu.CodeAnalysis.service.*;
import com.nju.edu.CodeAnalysis.service.impl.*;
import java.io.*;
/**
 * Servlet implementation class TestServlet1
 */
@WebServlet("/show")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SonarService ss = new SonarServiceImpl();
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
		LinkedList<AnalysisBean> ll = ss.getAllAnalysisOfOneAssignment("operating_system", 1);
		ll.get(0).setStudentID("151250001");
		ll.get(0).setName("李雷");
		ll.get(1).setStudentID("151250002");
		ll.get(1).setName("韩梅梅");
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
