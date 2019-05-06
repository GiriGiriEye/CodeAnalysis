package com.nju.edu.CodeAnalysis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nju.edu.CodeAnalysis.dao.DaoHelper;


public class DaoHelperImpl implements DaoHelper {
private static DaoHelperImpl instance;
	
	private InitialContext jndiContext = null;
	private Connection connection = null;
	private DataSource datasource = null;
	
	private static final String databaseName = "java:comp/env/jdbc/codeanalysis";
	
	private DaoHelperImpl() {
		try {
			jndiContext = new InitialContext();
			datasource = (DataSource)jndiContext.lookup(databaseName);
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized DaoHelperImpl getInstance() {
		if(instance == null) {
			instance = new DaoHelperImpl();
		}
		return instance;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		try {
			connection = datasource.getConnection();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void closeConnection(Connection con) {
		// TODO Auto-generated method stub
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				System.out.println("JDBC exception encounted: "+e);
		    	System.out.println("SQL State String: "+e.getSQLState());
		    	System.out.println("Database specific error code: "+e.getErrorCode());
			}
		}
	}

	@Override
	public void closePreparedStatement(PreparedStatement pstmt) {
		// TODO Auto-generated method stub
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				System.out.println("JDBC exception encounted: "+e);
		    	System.out.println("SQL State String: "+e.getSQLState());
		    	System.out.println("Database specific error code: "+e.getErrorCode());
			}
		}
	}

	@Override
	public void closeResultSet(ResultSet result) {
		// TODO Auto-generated method stub
		if(result != null) {
			try {
				result.close();
			}catch(SQLException e) {
				System.out.println("JDBC exception encounted: "+e);
		    	System.out.println("SQL State String: "+e.getSQLState());
		    	System.out.println("Database specific error code: "+e.getErrorCode());
			}
		}
	}
	
}
