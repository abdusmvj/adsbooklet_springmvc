package com.app.adsbooklet.services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.adsbooklet.dao.UserLoginDao;
import com.app.adsbooklet.model.UserLoginCredential;

@Component
public class UserLoginService 
{
	@Autowired
	private UserLoginDao userLoginDao;
   public UserLoginDao getUserLoginDao() {
		return userLoginDao;
	}
	public void setUserLoginDao(UserLoginDao userLoginDao) {
		this.userLoginDao = userLoginDao;
	}
	public boolean checkLoginCredentials(String username, String password, HttpSession session) {
		
		UserLoginCredential user = userLoginDao.getLoginData(username, password);
		if(user != null) {
			
			session.setAttribute("user_id", user.getUserId());
			session.setAttribute("username", user.getUsername()); //username as a email address here
			session.setAttribute("user_fullname", user.getFullName());
			session.setAttribute("mobile_no", user.getMob());
			//session.setAttribute("msg3", "You are successfully logged in!");		
			return true;
		}
		return false;
	}
}
