package com.nju.edu.CodeAnalysis.utils;

import com.offbytwo.jenkins.JenkinsServer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.HashMap;

/**
 * 调用Jenkins的api，处理Jenkins相关操作
 * @author zhr
 *
 */
public class JenkinsUtil {
	
	private static String url = "http://localhost:8000/";
	
	public void build(String jobName) {
		
	}
	
	/**
	 * 判断job是否空闲
	 * @param jobName
	 * @return Boolean
	 */
	public static boolean isJobFree(String jobName) {
		boolean isJobFree = false;
		
		try {
			String name = "admin";
			String pwd = "admin";
			JenkinsServer server = new JenkinsServer(new URI(url), name, pwd);
			
			if(server.getJob(jobName).isBuildable()) {
				isJobFree = true;
			}
			
			server.close();
			
			return isJobFree;
		}catch(URISyntaxException use) {
			use.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return isJobFree;
	}
	
	/**
	 * 构建job
	 * @param jobName
	 * @param projectPath
	 */
	public static void build(String jobName, String projectPath) {
		try {
			String name = "admin";
			String pwd = "admin";
			JenkinsServer server = new JenkinsServer(new URI(url), name, pwd);
			Map<String, String> map = new HashMap<String, String>();
			map.put("token", "testtoken");
			map.put("projectPath", projectPath);
			server.getJob(jobName).build(map);
			server.close();
		}catch(URISyntaxException use) {
			use.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * 获取一个空闲的job
	 * @return
	 */
	public static String getFreeJob() {
		String result = "";
		
		try {
			String name = "admin";
			String pwd = "admin";
			JenkinsServer server = new JenkinsServer(new URI(url), name, pwd);
			
			String jobName;
			for(int i = 1; i < 5; i++) {
				jobName = "sonartest" + i;
				if(server.getJob(jobName).isBuildable()) {
					result = jobName;
					server.close();
					return result;
				}
			}
			server.close();
//			return null;
		}catch(URISyntaxException use) {
			use.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		return result;
	}
}
