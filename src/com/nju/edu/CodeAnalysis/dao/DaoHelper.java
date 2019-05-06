package com.nju.edu.CodeAnalysis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DaoHelper {
	
	public Connection getConnection();
	
	public void closeConnection(Connection con);
	
	public void closePreparedStatement(PreparedStatement pstmt);
	
	public void closeResultSet(ResultSet result);
	
}
