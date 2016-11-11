package com.app.adsbooklet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.adsbooklet.dao.AdsbookletDao;
import com.app.adsbooklet.dao.MobilePostsDao;
import com.app.adsbooklet.model.CategoryList;
import com.app.adsbooklet.model.Contact;
import com.app.adsbooklet.model.UserDetails;







@Component
@RequestMapping("/")
public class WelcomeHome {
	
	
	@Autowired
    AdsbookletDao adsBookletDao;    //will inject dao from xml file 
	@Autowired MobilePostsDao mobilePostsDao;
	
	public AdsbookletDao getAdsdao() {
		return adsBookletDao;
	}

	public void setAdsdao(AdsbookletDao adsdao) {
		this.adsBookletDao = adsdao;
	}
	
	@RequestMapping("/welcomehomecontroller")  
    public ModelAndView showContacts() {  
        return new ModelAndView("contact", "command", new Contact());  
    }  
	
	@RequestMapping(value={"/home", "/","xyz"})  
    public ModelAndView homepage() {  
        ModelAndView mv = new ModelAndView();
        mv.setViewName("homepage");
        return mv;
    } 

	@RequestMapping(value = "/addContact")  
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {  
        //write the code here to add contact  
        return "redirect:contact.jsp";  
    }  
	
//	@RequestMapping("/signin")
//	public Object showSignin() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("signinview" );
//		return mv;
//	}

	
	 @RequestMapping(value = "/postads")  
	    public Object showPostAddList(HttpServletRequest request) { 
		 HttpSession session =request.getSession();
		 	if(session.getAttribute("username")==null)
		 	{
		 		session.setAttribute("fls-msg-user", "Please Login before Posting Your Add!");
		 		return  "redirect:/signin";	
		 	}
		 	
		    List<CategoryList> category_list=mobilePostsDao.getAllCategoryList();
	        return new ModelAndView("postadsview" ,"cat_list", category_list);  
	    } 
	 
	  @RequestMapping(value ="/contactus")  
	    public ModelAndView showContactUs() {  
	        return new ModelAndView("contactusview","command", null);  
	    } 
      
    
    
    @RequestMapping("/register")  
    public ModelAndView showRegister() {  
        return new ModelAndView("register", "command", new UserDetails());  
    } 
    
    @RequestMapping(value="/addRegister" , method=RequestMethod.POST)  
    public ModelAndView addRegister(UserDetails ud, HttpServletRequest request)
   {	        
    	        //HttpSession sson= request.getSession(true);
    			 System.out.println("hello Register");
    	         adsBookletDao.addSave(ud);
    	        
    	        // sson.setAttribute("signup_msg", "You have Successfully Sign up.");
		         return new ModelAndView("registersuccess","command", new UserDetails()); 
   } 

}
