package com.nju.edu.CodeAnalysis.dao.impl;

import com.nju.edu.CodeAnalysis.dao.UserDao;
import com.nju.edu.CodeAnalysis.model.User;
import com.nju.edu.CodeAnalysis.dao.DaoHelper;
import com.nju.edu.CodeAnalysis.dao.impl.DaoHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
	
	private DaoHelper dh;
	
	public UserDaoImpl() {
		this.dh = DaoHelperImpl.getInstance();
	}
	
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		Connection con = dh.getConnection();
		PreparedStatement pstmt = null;
		ResultSet result = null;
		User user = new User();
		try {
			pstmt = con.prepareStatement("select * from `user` where user_name=?;");
			pstmt.setString(1, name);
			result = pstmt.executeQuery();
			while(result.next()) {
				user.setName(result.getString("user_name"));
				user.setPwd(result.getString("user_pwd"));
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
		return user;
	}

	@Override
	public void insertUser(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection con = dh.getConnection();
		PreparedStatement pstmt = null;
//		ResultSet result = null;
		try {
			pstmt = con.prepareStatement("insert into `user`(pkid,user_name,user_pwd) values(?,?,?);");
			pstmt.setInt(1, 0);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("JDBC exception encounted: "+e);
	    	System.out.println("SQL State String: "+e.getSQLState());
	    	System.out.println("Database specific error code: "+e.getErrorCode());
		}finally {
			dh.closeConnection(con);
			dh.closePreparedStatement(pstmt);
//			dh.closeResultSet(result);
		}
	}

	@Override
	public void modifyUser(String name, String pwd) {
		// TODO Auto-generated method stub
		Connection con = dh.getConnection();
		PreparedStatement pstmt = null;
//		ResultSet result = null;
		try {
			pstmt = con.prepareStatement("update `user` set pwd=? where name=?;");
			pstmt.setString(1, pwd);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("JDBC exception encounted: "+e);
	    	System.out.println("SQL State String: "+e.getSQLState());
	    	System.out.println("Database specific error code: "+e.getErrorCode());
		}finally {
			dh.closeConnection(con);
			dh.closePreparedStatement(pstmt);
//			dh.closeResultSet(result);
		}
	}

	@Override
	public void deleteUser(String name) {
		// TODO Auto-generated method stub
		
	}

}
