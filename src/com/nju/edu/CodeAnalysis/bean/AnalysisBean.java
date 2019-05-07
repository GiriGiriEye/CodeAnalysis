package com.nju.edu.CodeAnalysis.bean;

import java.io.Serializable;

public class AnalysisBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String studentID = null;
	private String name = null;
	private String score = null;
	private String bugs = null;
	private String vulnerabilities= null;
	private String codeSmells = null;
	private String coverage = null;
	private String duplicated_lines_density = null;
	private String sonarPath = null;
	
	public AnalysisBean() {
		// TODO Auto-generated constructor stub
	}

	public AnalysisBean(String studentID, String name, String score, String bugs, String vulnerabilities,
			String codeSmells, String coverage, String duplicated_lines_density,String sonarPath) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.score = score;
		this.bugs = bugs;
		this.vulnerabilities = vulnerabilities;
		this.codeSmells = codeSmells;
		this.coverage = coverage;
		this.duplicated_lines_density = duplicated_lines_density;
		this.sonarPath = sonarPath;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getBugs() {
		return bugs;
	}

	public void setBugs(String bugs) {
		this.bugs = bugs;
	}

	public String getVulnerabilities() {
		return vulnerabilities;
	}

	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	public String getCodeSmells() {
		return codeSmells;
	}

	public void setCodeSmells(String codeSmells) {
		this.codeSmells = codeSmells;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getDuplicated_lines_density() {
		return duplicated_lines_density;
	}

	public void setDuplicated_lines_density(String duplicated_lines_density) {
		this.duplicated_lines_density = duplicated_lines_density;
	}
	
	public String getSonarPath() {
		return sonarPath;
	}

	public void setSonarPath(String sonarPath) {
		this.sonarPath = sonarPath;
	}
	
	
}
