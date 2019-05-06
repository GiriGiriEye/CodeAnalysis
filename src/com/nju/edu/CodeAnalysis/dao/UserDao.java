package com.nju.edu.CodeAnalysis.dao;

import com.nju.edu.CodeAnalysis.model.User;

public interface UserDao {
	public User getUser(String name);
	
	public void insertUser(String name, String pwd);
	
	public void modifyUser(String name, String pwd);
	
	public void deleteUser(String name);
}
