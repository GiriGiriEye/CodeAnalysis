package com.nju.edu.CodeAnalysis.service.impl;

import com.nju.edu.CodeAnalysis.service.AuthenticationService;
import com.nju.edu.CodeAnalysis.dao.UserDao;
import com.nju.edu.CodeAnalysis.dao.DaoFactory;
import com.nju.edu.CodeAnalysis.utils.EncryptUtil;

public class AuthenticationServiceImpl implements AuthenticationService {

	private UserDao userDao;
	
	public AuthenticationServiceImpl() {
		userDao = DaoFactory.getInstance().getUserDao();
	}
	
	@Override
	public boolean loginVarification(String name, String pwd) {
		// TODO Auto-generated method stub
		boolean varified = false;
		
		String pwdSaved = userDao.getUser(name).getPwd();
		String pwdReadyForCheck = EncryptUtil.encodeByMD5(pwd);
		
		if(pwdSaved.equals(pwdReadyForCheck)) {
			varified = true;
		}
		
		return varified;
	}

	@Override
	public boolean changePwd(String name, String pwd) {
		// TODO Auto-generated method stub
		boolean changeSucceed = false;
		String pwdEncrypted = EncryptUtil.encodeByMD5(pwd);
		userDao.insertUser(name, pwdEncrypted);
		if(userDao.getUser(name) != null) {
			changeSucceed = true;
		}
		return changeSucceed;
	}

}
