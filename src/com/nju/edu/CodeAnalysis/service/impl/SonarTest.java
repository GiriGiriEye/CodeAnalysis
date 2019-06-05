package com.nju.edu.CodeAnalysis.service.impl;

import java.net.URL;
import java.net.URLConnection;

import com.google.gson.*;
import com.nju.edu.CodeAnalysis.bean.AnalysisBean;

import java.io.*;


public class SonarTest {

	static String address = "http://localhost:9000/api/measures/component?componentKey=student&metricKeys=bugs,cognitive_complexity,code_smells,duplicated_lines_density,ncloc";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonParser parser = new JsonParser();
		try {
			AnalysisBean ab = new AnalysisBean();
//			String address = forwardAddress + projectPathList.get(i) + backAddress;
			URL url = new URL(address);
			URLConnection conn = url.openConnection(); 
			StringBuffer document = new StringBuffer();  
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String line = null;
			while ((line = reader.readLine()) != null){
				document.append(line);
			}
			reader.close();
			System.out.println(document.toString());
			/*
			JsonObject object =(JsonObject)parser.parse(document.toString()); 
			System.out.println(document.toString());
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
			System.out.println(ab.getCodeSmells());
//			list.add(ab);
 * 
     		*/
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
