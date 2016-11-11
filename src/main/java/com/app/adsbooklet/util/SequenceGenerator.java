package com.app.adsbooklet.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SequenceGenerator 
{
	@Autowired private JdbcTemplate jdbcTemplate; 
	public String getSequence(String sequence) {
		try
		{
			String sql = "SELECT sequence FROM sequence WHERE name = '"+ sequence +"'";
			String seq = jdbcTemplate.queryForObject(sql, String.class);
			sequence += seq;
			return sequence;
		}
		catch(Exception eseq){
			System.out.println(eseq.getMessage());
			return null;
		}
	}
	
	public void updateSequence(String sequenceName) {
		try
		{
			String sql = "SELECT sequence FROM sequence WHERE name = '"+ sequenceName +"'";
			int seq = Integer.valueOf(jdbcTemplate.queryForObject(sql, String.class));
			seq++;
			sql = "UPDATE sequence SET sequence = '"+ seq +"' WHERE name = '"+ sequenceName +"'";
			jdbcTemplate.update(sql);
		}
		catch(Exception eseq_name)
		{
			System.out.println(eseq_name.getMessage());
		}
		
	}
}
