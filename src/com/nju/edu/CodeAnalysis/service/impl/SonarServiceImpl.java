package com.nju.edu.CodeAnalysis.service.impl;

import com.nju.edu.CodeAnalysis.service.SonarService;

import java.net.URL;
import java.util.Map;
import java.util.HashMap;

public class SonarServiceImpl implements SonarService {
	
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
//		URL url=new URL(address);  
	}
	
	@Override
	public HashMap<String, String> getAnalysis(String studentID, String courseName, int number){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("coverage", "0.0");
		map.put("duplicated_lines_density", "0.0");
		map.put("coverage", "0.0");
		map.put("vulnerabilities", "0.0");
		map.put("ncloc_language_distribution", "java=232;xml=122");
		map.put("bugs", "0");
		map.put("code_smells", "49");
		return map;
	}

}
