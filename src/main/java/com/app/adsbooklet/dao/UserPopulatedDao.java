package com.app.adsbooklet.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.adsbooklet.model.District;
import com.app.adsbooklet.model.MobileBrand;

@Component
public class UserPopulatedDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate template) {
		this.jdbcTemplate = template;
	}
public List<District> getDistrictList(int state_id) {
		
	
		
		String sql = "SELECT * FROM district_table WHERE state_id = ?";
		try {
			return jdbcTemplate.query(sql, new Object[] { state_id }, (ResultSet rs, int row) -> {
				District dc = new District();
				dc.setDistrictid(rs.getInt("district_id"));
				dc.setDistrictname(rs.getString("district_name"));
				dc.setStateid(rs.getInt("state_id"));
				return dc;			
			});
		} catch (Exception e) {
			return null;
		}
		
	}


public List<MobileBrand> getMobileBrandList() {
	
	
	
	String sql = "SELECT * FROM mobi_brand_table ";
	try {
		return jdbcTemplate.query(sql, (ResultSet rs, int row) -> {
			MobileBrand mobb = new MobileBrand();
			mobb.setMobbrand_id(rs.getInt("brand_id"));
			mobb.setMobbrand_name(rs.getString("brand_name"));
			
			return mobb;			
		});
	} catch (Exception e) {
		return null;
	}
	
}

}
