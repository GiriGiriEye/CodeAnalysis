package com.nju.edu.CodeAnalysis.model;

public class ProjectPath {
	private String studentID;
	private String name;
	private String courseName;
	private int number;
	private String projectPath;
	
	public ProjectPath() {
		// TODO Auto-generated constructor stub
	}

	public ProjectPath(String studentID, String name, String courseName, int number, String projectPath) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.courseName = courseName;
		this.number = number;
		this.projectPath = projectPath;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}
	
	
}
