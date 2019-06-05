package com.nju.edu.CodeAnalysis.service;

import java.util.LinkedList;

public interface JenkinsService {
	
	public void singleBuild(String projectPath);
	
	public void multipleBuild(LinkedList<String> projectPathList);
	
	public void studentGitBuild(String gitPath);
	
}
