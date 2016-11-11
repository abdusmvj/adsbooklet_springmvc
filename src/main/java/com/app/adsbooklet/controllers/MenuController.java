package com.app.adsbooklet.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.app.adsbooklet.dao.AdsbookletDao;
import com.app.adsbooklet.dao.FileUploadDao;
import com.app.adsbooklet.dao.MobilePostsDao;
import com.app.adsbooklet.dao.UserPopulatedDao;
import com.app.adsbooklet.model.CategoryList;
import com.app.adsbooklet.model.MobileBrand;
import com.app.adsbooklet.model.MobilePhone;
import com.app.adsbooklet.model.MobilePostedInfo;
import com.app.adsbooklet.model.SellerBuyerInfo;
import com.app.adsbooklet.model.SubCategory;
import com.app.adsbooklet.model.UserDetails;

@Component
@RequestMapping("/")
public class MenuController 
{
	private static final Logger logger = LoggerFactory
			.getLogger(MenuController.class);
	@Autowired JdbcTemplate jdbcTemplate;
	@Autowired UserPopulatedDao userPopulatedDao;
	@Autowired AdsbookletDao adsBookletDao;    //will inject dao from xml file 
	
	@Autowired MobilePostsDao mobilePostsDao;
	
	@Autowired FileUploadDao fileUploadDao;
	
	 @RequestMapping(value="/mobiles&tablets")  
	    public ModelAndView showPostAddList() {  
	        return new ModelAndView("mobiletabletsview" ,"command", null);  
	    } 
	 
	 @RequestMapping(value="/mobilephone",method = RequestMethod.GET)  
	    public ModelAndView showMobilePhone() {  
		 List<MobileBrand> brandedlist = userPopulatedDao.getMobileBrandList();
	       return new ModelAndView("mobilephoneview" ,"listbrand", brandedlist);  
	    } 
	 
	 
	 
	 
	 @RequestMapping(value="/mobilephone", method=RequestMethod.POST)  
	    public String saveMobilePhoneDetails(@RequestParam("file") MultipartFile file, MobilePhone mp, HttpServletRequest req)
	   {	       
		              System.out.println("hello Register");
		              int userId = (int)req.getSession().getAttribute("user_id");
		              String user_fullname=(String)req.getSession().getAttribute("user_fullname");
		              
		              String uemail=(String)req.getSession().getAttribute("username");  //no need 
		              String mob_no=(String)req.getSession().getAttribute("mobile_no"); //no nedd
		              
	    			 System.out.println(userId);
	    			 System.out.println(user_fullname);
	    			 System.out.println(uemail);
	    			 System.out.println(mob_no);
	    			 
//	    			 mp.setSubCat(43);
	    			 ModelAndView mv=new ModelAndView();
	    	         String post_id = adsBookletDao.saveMobilePhone(mp, userId);
	    	         
	    	         fileUploadDao.handleFormUpload(file, post_id);
	    	         
	    	         return "redirect:/viewPost/"+post_id;
	    	        
	    	        			          
	   } 
	 
	 //this is  for Accessory controller link
	 @RequestMapping(value="/accessories_form")  
	    public ModelAndView showAccessoryForm() {  
		  ModelAndView mv=new ModelAndView();
		  mv.setViewName("accessory");
	      // return new ModelAndView("accessory_form");  
		  return mv;
	    }
	 
	//this is  for tablets controller link
		 @RequestMapping(value="/tablets_form")  
		    public ModelAndView showTabletForm() {  
			  ModelAndView mv=new ModelAndView();
			  mv.setViewName("tablets");
		     
			  return mv;
		    }
	 
	 @RequestMapping("/viewPost/{postId}")
	 public ModelAndView viewMyPost(@PathVariable("postId") String postId) {
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("post" , mobilePostsDao.getByAdId(postId));
		 mv.setViewName("my_mobile_posts");
		 return mv;
	 }
	 @RequestMapping("/mobile_sellerbuyer_info")
	 public ModelAndView myPost() {
		 ModelAndView mv = new ModelAndView();
		// mv.addObject("mobile_seller_buyerinfo", mobilePostsDao.getAll());
		 mv.setViewName("mobile_seller_buyerinfo");
		 return mv;
	 }
	 //this the caregory controller action list when click on this then subcateory list will be show  
	 @RequestMapping("/show_details/{id}")
	 public ModelAndView show_SibcatDeatils(@PathVariable("id") String subcatid) {
		 //ModelAndView mv = new ModelAndView();
		  List<SubCategory> subcategory_list=mobilePostsDao.get_SubcatId(subcatid);
	      return new ModelAndView("show_subcat_list" ,"subcatvalue",subcategory_list); 
		// mv.addObject("subcatvalue" ,mobilePostsDao.get_SubcatId(subcatid));
		// mv.setViewName("show_subcat_list");
		// return mv;
	 }
	 
	 @RequestMapping("/showImage/{post_id}")
	 @ResponseBody
	 public void downloadFile(@PathVariable("post_id") String post_id, HttpServletResponse response) {
		 String filepath = jdbcTemplate.queryForObject("SELECT image FROM post_mobile_section WHERE mobile_adv_id = ?", new Object[] { post_id }, String.class);
		 logger.info("filepath = "+ filepath);
		 File file = new File(filepath);
		 
		 try {
			FileInputStream inputStream = new FileInputStream(file);
			String mimeType = URLConnection.guessContentTypeFromStream(inputStream);
			response.setContentType(mimeType);
			response.setContentLength((int) file.length());
			byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            response.getOutputStream().write(buffer, 0, bytesRead);
	        }
	        inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				response.getWriter().println("hello");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	 }
	 
	 @ExceptionHandler(Exception.class)
		public ModelAndView handleAllException(Exception ex) {

			ModelAndView model = new ModelAndView("error/generic_error");
			model.setViewName("errMsg");
			model.addObject("errMsg", ex.getMessage());

			return model;

		}
	 
	 
	 
	 //for testing your json data fron database in url browser
	/* @RequestMapping(value="/fetchMobileBrand", method = RequestMethod.GET, produces ="application/json")
		@ResponseBody
		public List<MobileBrand> mobbrandlist(HttpServletResponse response)
		{
		   // ModelAndView mv=new ModelAndView();
			//response.setContentType("application/json");
			List<MobileBrand> listbrand = userPopulatedDao.getMobileBrandList();	
			return  listbrand;
			
		}*/
}
