package com.app.adsbooklet.dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.app.adsbooklet.model.MobileBrand;
import com.app.adsbooklet.model.MobilePhone;
import com.app.adsbooklet.model.MobilePostedInfo;
import com.app.adsbooklet.model.SellerBuyerInfo;
import com.app.adsbooklet.model.UserDetails;

@Component
public class AdsbookletDao
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	 
	
	
	public int addSave(UserDetails ud)
	  {  
		
		
	
			System.out.println("hi.........");
			   // String sql="insert into user_profile(firstname,lastname,email,password,phone,userrole) values('"+re.getFirstname()+"','"+ud.getLastname()+"','"+ud.getEmail()+"','"+re.getPassword()+"','"+re.getTelephone()+"','"+re.getUserrole()+"')";
				
			String sql="insert into user_profile(user_fullname,user_mobile,user_gender,user_nationality,user_name,user_password,user_dob,user_address,user_state,user_district,user_pincode) "
					+ "values('"+ud.getFullname()+"','"+ud.getMob()+"','"+ud.getGender()+"','"+ud.getNationality()+"','"+ud.getUsername()+"','"+ud.getPassword()+"','"+ud.getDob()+"','"+ud.getAddress()+"','"+ud.getStateid()+"','"+ud.getDistrictid()+"','"+ud.getPincode()+"')";
			
			/*String sql = "INSERT INTO user_profile SET "
					
						+ "user_fullname = ?,"
						+ "user_mobile = ?,"
						+ "user_gender = ?,"
						+ "user_nationality = ?,"
						+ "user_name = ?,"
						+ "user_password = ?,"
						+ "user_dob= ?,"
						+ "user_address = ?,"
						+ "user_state = ?,"
						+ "user_district = ?,"
						+ "user_pincode= ?,";
				Object params[] = { 
						
						ud.getFullname(),
						ud.getMob(),
						ud.getGender(),
						ud.getNationality(),
						ud.getUsername(),
						ud.getPassword(),
						ud.getDob(),
						ud.getAddress(),
						ud.getStateid(),
						ud.getDistrictid(),
						ud.getPincode()
						}; */
				System.out.println(sql);
				
	
		     return jdbcTemplate.update(sql);
		  
	  }
	
	
	public int saveMobilePhone(MobilePhone mp,int userId)
	  {  			 
			   System.out.println("hi.........kkkkkk");
			  // String sql="insert into post_mobile_section values(null,'"+mp.getImageid()+"','"+mp.getMobileadTitle()+"','"+mp.getTypeofAd()+"','"+mp.getMobicondition()+"','"+mp.getActualprice()+"','"+mp.getXpectmobiprice()+"','"+mp.getMobibrand()+"','"+mp.getMobimodel()+"','"+mp.getMobiOS()+"','"+mp.getMobisimNo()+"','"+mp.getMobidescription()+"','"+mp.getPost_date()+"',"+userId+")";
		//String sql="insert into post_mobile_section values(null,'"+mp.getImageid()+"','"+mp.getMobileadTitle()+"','"+mp.getTypeofAd()+"','"+mp.getMobicondition()+"','"+mp.getActualprice()+"','"+mp.getXpectmobiprice()+"','"+mp.getMobibrand()+"','"+mp.getMobimodel()+"','"+mp.getMobiOS()+"','"+mp.getMobisimNo()+"','"+mp.getMobidescription()+"','"+mp.getPost_date()+"','userId')";
			String sql = "INSERT INTO post_mobile_section SET "
						
						+ "image_id = ?,"
						+ "mobile_title = ?,"
						+ "type_of_add = ?,"
						+ "mobile_condition = ?,"
						+ "actual_price = ?,"
						+ "exp_price = ?,"
						+ "brand = ?,"
						+ "model = ?,"
						+ "os = ?,"
						+ "no_of_sim = ?,"
						+ "description = ?,"
						+ "posting_date = ?,"
						+ "user_id = ?";
				Object params[] = { 
						
						mp.getImageid(),
						mp.getMobileadTitle(),
						mp.getTypeofAd(),
						mp.getMobicondition(),
						mp.getActualprice(),
						mp.getXpectmobiprice(),
						mp.getMobibrand(),
						mp.getMobimodel(),
						mp.getMobiOS(),
						mp.getMobisimNo(),
						mp.getMobidescription(),
						mp.getPost_date(),
						userId
						}; 
				System.out.println(sql);
				try {
					//int row = jdbcTemplate.update(sql,params);
					//System.out.println(row +" row inserted!");
				} catch (Exception e) {
				    System.out.println("exception at AdsBookletDao.insert(MobilePhoneInfo)"+ e.getMessage());
				}
			   
			   System.out.println("hi.........");
			   
				System.out.println(sql);
			   return jdbcTemplate.update(sql,params); 
			      	
	  }
	
	
	public int saveSellerBuyerInfo(MobilePostedInfo mpi)
	  {  			 
			     System.out.println("hi.........");
			   // String sql="insert into user_profile(firstname,lastname,email,password,phone,userrole) values('"+re.getFirstname()+"','"+ud.getLastname()+"','"+ud.getEmail()+"','"+re.getPassword()+"','"+re.getTelephone()+"','"+re.getUserrole()+"')";
				String sql="insert into user_profile (you_are,user_name,email,phone,address,state,district,pincode)"
						+ " values('"+mpi.getYou_are()+"','"+mpi.getName()+"','"+mpi.getEmail()+"','"+mpi.getMobileno()+"','"+mpi.getAddress()+"','"+mpi.getStateid()+"','"+mpi.getDistrictid()+"','"+mpi.getPincode()+"')";
				System.out.println(sql);
			    return jdbcTemplate.update(sql);  	
	  }
	
	
	public MobilePostedInfo getMobilePostedInfo() {  //for here we have used queryForOject method
		
		
		
		String sql = "select a.mobile_adv_id, a.actual_price,"
				+ " a.exp_price,a.brand, a.model, a.os, a.posting_date, a.description,"
				+ " b.your_name, b.email, b.mobile_no, b.address, b.city, b.pincode"
				+ " from post_mobile_section as a inner join post_seller_buyer_info_tb as b"
				+ " ON a.mobile_adv_id =b.mobile_adv_id where a.mobile_adv_id=?" ;
		try {
			return jdbcTemplate.queryForObject(sql, (ResultSet rs, int row) -> {
				MobilePostedInfo mpi = new MobilePostedInfo();
				mpi.setMobile_adv_id(rs.getInt("mobile_adv_id"));
				mpi.setActualprice(rs.getString("actual_price"));
				mpi.setXpectmobiprice(rs.getString("exp_price"));
				mpi.setMobibrand(rs.getString("brand"));
				mpi.setMobimodel(rs.getString("model"));
			    mpi.setMobiOS(rs.getString("os"));
			    mpi.setPost_date(rs.getString("posting_date"));
			    mpi.setMobidescription(rs.getString("description"));
			    mpi.setName(rs.getString("your_name"));
			    mpi.setEmail(rs.getString("email"));
			   
			    mpi.setMobileno(rs.getString("mobile_no"));
			    mpi.setAddress(rs.getString("address"));
			    mpi.setCity(rs.getString("city"));
			    mpi.setPincode(rs.getInt("pincode"));
				return mpi;			
			});
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
	
	  
