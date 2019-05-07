package com.nju.edu.CodeAnalysis.service;

import java.util.HashMap;

public interface SonarService {
	public void test();
	
	public HashMap<String, String> getAnalysis(String studentID, String courseName, int number);
}
