package com.nju.edu.CodeAnalysis.service;

import java.util.HashMap;
import java.util.LinkedList;
import com.nju.edu.CodeAnalysis.bean.AnalysisBean;

public interface SonarService {
	public void test();
	
	public HashMap<String, String> getAnalysis(String studentID, String courseName, int number);
	
	public void scan(LinkedList<String> projectPathList);
	
	public LinkedList<AnalysisBean> getAllAnalysisOfOneAssignment(String courseName, int number);
}
