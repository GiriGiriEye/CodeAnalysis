package com.nju.edu.CodeAnalysis.dao;

import java.util.List;
import java.util.LinkedList;

import com.nju.edu.CodeAnalysis.model.ProjectPath;

public interface AnalysisDao {
	public List<String> getAllAnalysisPath(String studentID);
	
	public LinkedList<ProjectPath> getAllAnalysisByCourseNumberPath(String courseName, int number);
}
