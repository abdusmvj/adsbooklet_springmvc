package com.app.adsbooklet.dao;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.app.adsbooklet.model.UserLoginCredential;

@Component
public class UserLoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
	
	public UserLoginCredential getLoginData(String username, String password) {
		
		String sql = "select * from user_profile where user_name = ? and user_password = ?";
		
		return jdbcTemplate.query(sql, new Object[]{username, password,}, (ResultSet rs) -> {
			
				if(rs.next()){
					UserLoginCredential user = new UserLoginCredential();
					user.setUserId(rs.getInt("user_id"));
					//user.setEmailAddress(rs.getString("EMAIL_ADDRESS"));
					user.setFullName(rs.getString("user_fullname"));
					user.setUsername(rs.getString("user_name"));
					user.setPassword(rs.getString("user_password"));
					user.setMob(rs.getString("user_mobile"));
					return user;
				}
				return null;			
		});
		
	}
}
