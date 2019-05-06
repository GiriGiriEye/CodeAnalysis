package com.nju.edu.CodeAnalysis.service;

public interface AuthenticationService {
	public boolean loginVarification(String name, String pwd);
	
	public boolean changePwd(String name, String pwd);
}
