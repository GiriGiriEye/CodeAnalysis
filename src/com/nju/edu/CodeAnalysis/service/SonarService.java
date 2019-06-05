package com.nju.edu.CodeAnalysis.service;

import java.util.HashMap;
import java.util.LinkedList;
import com.nju.edu.CodeAnalysis.bean.AnalysisBean;

public interface SonarService {
	public void test();
	
	public HashMap<String, String> getAnalysis(String projectPath);
	
	public void scan(LinkedList<String> projectPathList);
	
	public void scan(String projectPath);
	
	public LinkedList<AnalysisBean> getAllAnalysisOfOneAssignment(String courseName, int number);
	
	public AnalysisBean getAnalysisOfStudent(String projectPath);
	
	public void studentGitScan(String gitPath);
}
