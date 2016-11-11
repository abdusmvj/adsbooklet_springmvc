package com.app.adsbooklet.controllers;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/")
public class UploadFileController 
{
	private static final Logger logger = LoggerFactory
			.getLogger(UploadFileController.class);
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/uploadfile", method=RequestMethod.POST)
	public String handleFormUpload(@RequestParam("file") MultipartFile file, @RequestParam("postId") String postId) throws IOException
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
				
				return "redirect:/uploadSuccess";
			}
			catch (Exception e) 
			{
				logger.debug(e.getMessage());
			}
		}
		return "redirect:/uploadFail";
	}
	
	@RequestMapping("/uploadSuccess")
	public ModelAndView uploadSuccess(HttpServletRequest request) {
	
		request.setAttribute("msg-success", "File Uploaded Successfully");
		return new ModelAndView("mobilephoneview");
	}
	
	@RequestMapping("/uploadFail")
	public ModelAndView uploadFail(HttpServletRequest request) {
		request.setAttribute("msg-fail", "File upload failed");
		return new ModelAndView("mobilephoneview");
	}

	
}
