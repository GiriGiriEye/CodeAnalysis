package com.nju.edu.CodeAnalysis.service.impl;

import java.net.URL;
import java.net.URLConnection;

import com.google.gson.*;

import java.io.*;


public class SonarTest {

	static String address = "http://localhost:9000/api/measures/component?componentKey=CodeAnalysis&metricKeys=bugs,vulnerabilities,code_smells,duplicated_lines_density,ncloc_language_distribution,coverage";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonParser parser = new JsonParser();
		try {
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
			System.out.println(array.toString());
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
