package com.nju.edu.CodeAnalysis.dao;

import com.nju.edu.CodeAnalysis.dao.impl.*;

public class DaoFactory {
	
	private UserDao userDao;
	
	private DaoFactory() {
		
	}
	
	private static class DaoFactoryInstance{
		private static final DaoFactory INSTANCE = new DaoFactory();
	}
	
	public static DaoFactory getInstance() {
		return DaoFactoryInstance.INSTANCE;
	}
	
	public UserDao getUserDao() {
		userDao = new UserDaoImpl();
		return userDao;
	}
}
