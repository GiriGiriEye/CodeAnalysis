package com.nju.edu.CodeAnalysis.model;

public class User {
	private String name;
	
	private String pwd;
	
	public User() {
		
	}
	
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return this.pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
