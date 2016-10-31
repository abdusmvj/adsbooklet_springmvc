package com.app.adsbooklet.dao;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.app.adsbooklet.model.CategoryList;
import com.app.adsbooklet.model.MobilePostedInfo;
import com.app.adsbooklet.model.SubCategory;

@Component
public class MobilePostsDao {
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	public List<CategoryList> getAllCategoryList()
	{
		String query="Select * from classified_category";
		try{
				return jdbcTemplate.query(query,(ResultSet rs, int row)->
				
						{
								CategoryList cl=new CategoryList();
								cl.setCategory_id(rs.getInt("classified_category_id"));
								cl.setCategory_name(rs.getString("classified_category_name"));
								return cl;
						});
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public MobilePostedInfo get(int id) {
		String sql = "SELECT * FROM post_mobile_section WHERE user_id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, (ResultSet rs, int row) -> {
				MobilePostedInfo mpi = new MobilePostedInfo();
				mpi.setActualprice(rs.getString("actual_price"));
				mpi.setMobidescription(rs.getString("description"));
				mpi.setMobiOS(rs.getString("os"));
				mpi.setMobisimNo(rs.getString("no_of_sim"));
				mpi.setMobimodel(rs.getString("model"));
				mpi.setXpectmobiprice(rs.getString("exp_price"));
				System.out.println(mpi.getMobiOS());
				return mpi;
			});
		} catch (Exception e) {
			System.out.println("exceptin at MobilePostsDao.get(String id)");
			return null;
		}
	}
	
	public List<MobilePostedInfo> getAll(int id) {
		//String sql = "SELECT * FROM post_mobile_section";
		//String sql = "SELECT * FROM post_mobile_section WHERE user_id = ?";
		String sql="select a.user_fullname, a.user_mobile, a.user_name,a.user_address, "
				+ "b.image_id,b.mobile_title,b.type_of_add,b.mobile_condition,b.actual_price,b.exp_price,b.model,b.os,b.no_of_sim,b.posting_date,b.description, b.user_id "
				+ "from user_profile as a inner join post_mobile_section as b "
				+ "ON a.user_id=b.user_id WHERE b.user_id=?";
		try {
			return jdbcTemplate.query(sql,new Object[] { id },(ResultSet rs, int row) -> {
				MobilePostedInfo mpi = new MobilePostedInfo();
			
				mpi.setMobiOS(rs.getString("os"));
				//mpi.setName(rs.getString("brand"));
				mpi.setActualprice(rs.getString("actual_price"));
				mpi.setMobisimNo(rs.getString("no_of_sim"));
				mpi.setXpectmobiprice(rs.getString("exp_price"));
				mpi.setMobimodel(rs.getString("model"));
				mpi.setPost_date(rs.getString("posting_date"));
				mpi.setMobidescription(rs.getString("description"));
				mpi.setName(rs.getString("user_fullname"));
				mpi.setEmail(rs.getString("user_name"));  //user name as email here
				mpi.setMobileno(rs.getString("user_mobile"));
				mpi.setAddress(rs.getString("user_address"));
				System.out.println(mpi.getMobiOS());
				System.out.println(mpi.getName());
				return mpi;
			});
		} catch (Exception e) {
			System.out.println("exceptin at MobilePostsDao.getAll()"+e.getMessage());
			return null;
		}
	}
	
	
	public List<SubCategory> get_SubcatId(String id) {
		String sql = "SELECT * FROM classified_sub_category WHERE classified_category_id = ?";
		try {
			return jdbcTemplate.query(sql, new Object[] { id }, (ResultSet rs, int row) -> {
				SubCategory sb=new SubCategory();
				
				sb.setId(rs.getInt("classified_sub_category_id"));
				sb.setMainCategoryId(rs.getInt("classified_category_id"));
				sb.setName(rs.getString("classified_sub_category_name"));
				return sb;
			});
		} catch (Exception e) {
			System.out.println("exceptin at MobilePostsDao.get_SubcatId(String id)"+ e.getMessage());
			return null;
		}
	}
}
