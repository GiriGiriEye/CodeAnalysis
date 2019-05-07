package com.nju.edu.CodeAnalysis.dao;

import java.util.List;
import java.util.LinkedList;

public interface AnalysisDao {
	public List<String> getAllAnalysisPath(String studentID);
	
	public LinkedList<String> getAllAnalysisByCourseNumberPath(String courseName, int number);
}
