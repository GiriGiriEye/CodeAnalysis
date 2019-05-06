package com.nju.edu.CodeAnalysis.dao;

import java.util.List;

public interface AnalysisDao {
	public List<String> getAllAnalysisPath(String studentID);
	
	public String getParticularPath(String studentID, String assignment);
}
