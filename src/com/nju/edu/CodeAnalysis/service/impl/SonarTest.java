package com.nju.edu.CodeAnalysis.service.impl;

import java.net.URL;
import java.net.URLConnection;
import java.io.*;
import net.sf.json.JSONObject;

public class SonarTest {

	static String address = "http://localhost:9000/api/measures/component?componentKey=CodeAnalysis&metricKeys=code_smells";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			JSONObject json =JSONObject.fromObject(document.toString()); 
			System.out.println(json);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
