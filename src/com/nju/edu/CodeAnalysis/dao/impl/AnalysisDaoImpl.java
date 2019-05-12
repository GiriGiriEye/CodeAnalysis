package com.nju.edu.CodeAnalysis.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.LinkedList;

import com.nju.edu.CodeAnalysis.model.ProjectPath;
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
	public LinkedList<ProjectPath> getAllAnalysisByCourseNumberPath(String courseName, int number) {
		// TODO Auto-generated method stub
		Connection con = dh.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		LinkedList<ProjectPath> list = new LinkedList<ProjectPath>();
		try {
			pstmt = con.prepareStatement("select * from `projectPath` where courseName=? and number=?;");
			pstmt.setString(1, courseName);
			pstmt.setInt(2, number);
			result = pstmt.executeQuery();
			ProjectPath pp;
			while(result.next()) {
				pp = new ProjectPath();
				pp.setStudentID(result.getString("studentID"));
				pp.setName(result.getString("name"));
				pp.setCourseName(result.getString("courseName"));
				pp.setNumber(result.getInt("number"));
				pp.setProjectPath(result.getString("projectPath"));
				list.add(pp);
			}
			return list;
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
