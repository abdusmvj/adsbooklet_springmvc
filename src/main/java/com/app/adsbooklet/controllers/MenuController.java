package com.app.adsbooklet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.adsbooklet.dao.AdsbookletDao;
import com.app.adsbooklet.dao.MobilePostsDao;
import com.app.adsbooklet.dao.UserPopulatedDao;
import com.app.adsbooklet.model.CategoryList;
import com.app.adsbooklet.model.MobileBrand;
import com.app.adsbooklet.model.MobilePhone;
import com.app.adsbooklet.model.MobilePostedInfo;
import com.app.adsbooklet.model.SellerBuyerInfo;
import com.app.adsbooklet.model.SubCategory;
import com.app.adsbooklet.model.UserDetails;
//@Controller
@Component
@RequestMapping("/")
public class MenuController 
{
	
	@Autowired
	UserPopulatedDao userPopulatedDao;
	@Autowired
    AdsbookletDao adsBookletDao;    //will inject dao from xml file 
	
	@Autowired MobilePostsDao mobilePostsDao;
	
	
	 @RequestMapping(value="/mobiles&tablets")  
	    public ModelAndView showPostAddList() {  
	        return new ModelAndView("mobiletabletsview" ,"command", null);  
	    } 
	 
	 @RequestMapping(value="/mobilephone")  
	    public ModelAndView showMobilePhone() {  
		 List<MobileBrand> brandedlist = userPopulatedDao.getMobileBrandList();
	       return new ModelAndView("mobilephoneview" ,"listbrand", brandedlist);  
	    } 
	 
	 
	 @RequestMapping(value="/postmobile_phoneads", method=RequestMethod.POST)  
	    public ModelAndView saveMobilePhoneDetails(MobilePhone mp, HttpServletRequest req)
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
	    	         adsBookletDao.saveMobilePhone(mp, userId);
	    	         
	    	        
	    	         mv.addObject("myposts" , mobilePostsDao.getAll(userId));  //foe last row user id
	    	         mv.setViewName("my_mobile_posts");
	    	         return mv;
	    	         //changes made from here call to next page
	    	         //return "redirect:/mobile_sellerbuyer_info";
	    	     /*    
	    	         
	    	         //mv.addObject("myposts" ,mobilePostsDao.getAll()); //for all value 
	    	       //  return "redirect:/myMobilePosts";
	    	        
	    	        */
			          
	   } 
	 @RequestMapping("/viewMyMobilePosts")
	 public ModelAndView viewMyPost() {
		 ModelAndView mv = new ModelAndView();
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
	 
	 @RequestMapping("/show_details/{id}")
	 public ModelAndView show_SibcatDeatils(@PathVariable("id") String subcatid) {
		 //ModelAndView mv = new ModelAndView();
		  List<SubCategory> subcategory_list=mobilePostsDao.get_SubcatId(subcatid);
	      return new ModelAndView("show_subcat_list" ,"subcatvalue",subcategory_list); 
		// mv.addObject("subcatvalue" ,mobilePostsDao.get_SubcatId(subcatid));
		// mv.setViewName("show_subcat_list");
		// return mv;
	 }
	 
	 @RequestMapping(value="/mobile_sellerbuyer_info", method=RequestMethod.POST)  
	    public ModelAndView saveSellerBuyerDetails(MobilePostedInfo mpi, HttpServletRequest req)
	   {	       		
	    			 System.out.println("hello Register");
	    			 int userId1 = (int)req.getSession().getAttribute("user_id");
	    	         adsBookletDao.saveSellerBuyerInfo(mpi);
	    	        
	    	       //=adsBookletDao.getMobilePostedInfo();
	    	       return new ModelAndView("my_mobile_posts","myposts", mobilePostsDao.getAll(userId1)); 
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
