package com.nju.edu.CodeAnalysis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

import com.nju.edu.CodeAnalysis.dao.AnalysisDao;
import com.nju.edu.CodeAnalysis.dao.DaoHelper;

public class AnalysisDaoImpl implements AnalysisDao {

	private DaoHelper dh;
	
	public AnalysisDaoImpl() {
		this.dh = DaoHelperImpl.getInstance();
	}
	
	@Override
	public List<String> getAllAnalysisPath(String studentID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedList<String> getAllAnalysisByCourseNumberPath(String courseName, int number) {
		// TODO Auto-generated method stub
		Connection con = dh.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		LinkedList<String> list = new LinkedList<String>();
		try {
			pstmt = con.prepareStatement("select * from `projectPath` where courseName=? and number=?;");
			pstmt.setString(1, courseName);
			pstmt.setInt(2, number);
			result = pstmt.executeQuery();
			
			while(result.next()) {
				list.add(result.getString("projectPath"));
			}
		}catch(SQLException e) {
			System.out.println("JDBC exception encounted: "+e);
	    	System.out.println("SQL State String: "+e.getSQLState());
	    	System.out.println("Database specific error code: "+e.getErrorCode());
		}finally {
			dh.closeConnection(con);
			dh.closePreparedStatement(pstmt);
			dh.closeResultSet(result);
		}
		return list;
	}

}
