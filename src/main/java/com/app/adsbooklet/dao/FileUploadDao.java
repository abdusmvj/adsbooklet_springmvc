package com.app.adsbooklet.dao;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.adsbooklet.controllers.UploadFileController;


@Component
public class FileUploadDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadDao.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean handleFormUpload(MultipartFile file, String postId)
	{
		if (!file.isEmpty()) 
		{
			logger.info("file is not empty");
			try {
				byte[] bytes = file.getBytes();
				
				// Creating the directory to store file
				String rootPath = "F:/uploads";
				File dir = new File(rootPath + File.separator);
				
				if (!dir.exists())
				{
					dir.mkdirs();
				}
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());
				
				jdbcTemplate.update("UPDATE post_mobile_section SET image = ? WHERE mobile_adv_id = ?", new Object[] {serverFile.getAbsolutePath(), postId });
				return true;
			
			}
			catch (Exception e) 
			{
				logger.debug(e.getMessage());
				return false;
			}
		}
		return false;
	}
}
