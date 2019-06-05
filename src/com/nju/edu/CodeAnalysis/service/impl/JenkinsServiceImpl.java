package com.nju.edu.CodeAnalysis.service.impl;

import java.util.LinkedList;
import java.util.ArrayList;

import com.nju.edu.CodeAnalysis.config.PropertiesLoader;
import com.nju.edu.CodeAnalysis.utils.JenkinsUtil;
import com.nju.edu.CodeAnalysis.thread.JenkinsThread;
import com.nju.edu.CodeAnalysis.service.JenkinsService;

public class JenkinsServiceImpl implements JenkinsService {
	
	private int cpuNumber;
	
	private String jobName;
	
	public JenkinsServiceImpl() {
		this.cpuNumber = PropertiesLoader.getInstance().getCPUNumber();
		this.jobName = PropertiesLoader.getInstance().getJobName();
	}

	@Override
	public void singleBuild(String projectPath) {
		// TODO Auto-generated method stub
		String jobName = "student";
		LinkedList<String> list = new LinkedList<String>();
		list.add(projectPath);
		JenkinsThread jthread = new JenkinsThread(jobName, list);
		jthread.run();
	}

	@Override
	public void multipleBuild(LinkedList<String> projectPathList) {
		// TODO Auto-generated method stub
		//创建一个动态数组，存放含有ProjectPath的LinkedList，数量是处理器的数量
		ArrayList<LinkedList<String>> listOflist = new ArrayList<LinkedList<String>>();
		
		for(int i = 0; i < cpuNumber; i++) {
			listOflist.add(new LinkedList<String>());
		}
		
		//将projectPathList中的数据按照处理器数量均分给LinkedList
		for(int i = 0; i < projectPathList.size() ; i++) {
			listOflist.get(i % cpuNumber).add(projectPathList.get(i));
		}
		
		JenkinsThread[] jthread = new JenkinsThread[cpuNumber];
		
		for(int i = 0; i < cpuNumber; i++) {
			jthread[i] = new JenkinsThread(jobName + String.valueOf(i+1), listOflist.get(i)); 
			jthread[i].run();
		}
	}
	
	@Override
	public void studentGitBuild(String gitPath) {
		String jobName = "studentGit";
		LinkedList<String> list = new LinkedList<String>();
		list.add(gitPath);
		JenkinsThread jthread = new JenkinsThread(jobName, list);
		jthread.run();
	}

}
