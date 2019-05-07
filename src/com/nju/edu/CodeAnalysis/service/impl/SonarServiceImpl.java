package com.nju.edu.CodeAnalysis.service.impl;

import com.nju.edu.CodeAnalysis.service.SonarService;
import com.nju.edu.CodeAnalysis.bean.AnalysisBean;
import com.nju.edu.CodeAnalysis.service.JenkinsService;
import com.nju.edu.CodeAnalysis.dao.AnalysisDao;
import com.nju.edu.CodeAnalysis.dao.impl.AnalysisDaoImpl;
import com.nju.edu.CodeAnalysis.utils.PathNameUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

public class SonarServiceImpl implements SonarService {
	
	private static String forwardAddress = "http://localhost:9000/api/measures/component?componentKey=";
	private static String backAddress = "&metricKeys=bugs,vulnerabilities,code_smells,duplicated_lines_density,ncloc_language_distribution,coverage";
	
	private AnalysisDao ad;
	
	@Override
	public void test() {
		// TODO Auto-generated method stub
//		URL url=new URL(address);  
	}
	
	/**
	 * 假数据，标记
	 */
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
	
	@Override
	public void scan(LinkedList<String> projectPathList) {
		JenkinsService js = new JenkinsServiceImpl();
		js.multipleBuild(projectPathList);
	}
	
	/**
	 * AnalysisBean假数据，标记,应该在Dao层里搞一个完整的
	 */
	public LinkedList<AnalysisBean> getAllAnalysisOfOneAssignment(String courseName, int number){
		ad = new AnalysisDaoImpl();
		LinkedList<String> projectPathList = ad.getAllAnalysisByCourseNumberPath(courseName, number);
		projectPathList = PathNameUtil.convertPathName(projectPathList);
		System.out.println(projectPathList.toString());
		LinkedList<AnalysisBean> list = new LinkedList<AnalysisBean>();
		JsonParser parser = new JsonParser();
		try {
			for(int i = 0; i < projectPathList.size(); i++) {
				AnalysisBean ab = new AnalysisBean();
				String address = forwardAddress + projectPathList.get(i) + backAddress;
				System.out.println("address: "+address);
				URL url = new URL(address);
				URLConnection conn = url.openConnection(); 
				StringBuffer document = new StringBuffer();  
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
				String line = null;
				while ((line = reader.readLine()) != null){
					document.append(line);
				}
				reader.close();
				JsonObject object =(JsonObject)parser.parse(document.toString()); 
				JsonObject object1 = object.get("component").getAsJsonObject();
				JsonArray array = object1.get("measures").getAsJsonArray();
				for(int j = 0; j < array.size();j++) {
					JsonObject object2 = array.get(j).getAsJsonObject();
					switch(object2.get("metric").getAsString()) {
					case "vulnerabilities":{
						ab.setVulnerabilities(object2.get("value").getAsString());
					}
					case "bugs":{
						ab.setBugs(object2.get("value").getAsString());
					}
					case "code_smells":{
						ab.setCodeSmells(object2.get("value").getAsString());
					}
					case "coverage":{
						ab.setCoverage(object2.get("value").getAsString());
					}
					case "duplicated_lines_density":{
						ab.setDuplicated_lines_density(object2.get("value").getAsString());
					}
					}
				}
				ab.setSonarPath("http://localhost:9000/dashboard?id="+projectPathList.get(i));
				System.out.println(ab.getBugs());
				list.add(ab);
//				System.out.println("list"+list.toString());
			}

			return list;
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return list;
	}

}
