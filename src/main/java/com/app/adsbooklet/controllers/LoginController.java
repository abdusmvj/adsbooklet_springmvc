package com.app.adsbooklet.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.adsbooklet.dao.UserPopulatedDao;
import com.app.adsbooklet.model.District;
import com.app.adsbooklet.model.UserLoginCredential;
import com.app.adsbooklet.services.UserLoginService;

@Component
@RequestMapping("/")
public class LoginController 
{
	
	@Autowired
	UserLoginService userLoginService;
	
	@Autowired
	UserPopulatedDao userPopulatedDao;
	
	 @RequestMapping(value ="/signin")  
    public ModelAndView showSignin() {  
        return new ModelAndView("signinview" ,"command", new UserLoginCredential());  
    } 
	 
	 @RequestMapping("/logout")
		public String logout(HttpServletRequest request) {
			HttpSession session = request.getSession(false);
			
			
			session.setAttribute("logout-msg", "You have Successfully logged out!");
			session.removeAttribute("user_id");
			session.removeAttribute("username");
			session.removeAttribute("user_fullname");
			return "redirect:/signin";
		}
	 
	 @RequestMapping("/forgotPassword")
		public ModelAndView forgotPassword() {
			return new ModelAndView("forgotPasswordview", "command", null);
		}

	@RequestMapping(value = "/userauth", method = RequestMethod.POST)
	public String checkCredentials(@RequestParam("username") String username,
								   @RequestParam("password") String password,
								   HttpServletRequest request) {
	
		System.out.println("The name is"+username);	

		//session.setAttribute("msg1","Invalid Username & Password!");
		//return (!userLoginService.checkLoginCredentials(username, password, session)) ? "redirect:/signin":"redirect:/xyz";  //this ternary operator login
		if(userLoginService.checkLoginCredentials(username, password, request.getSession(true))==true)
		{
			request.getSession().setAttribute("loginsuccess-flashmsg","You have successfully Loged in!");
			return "redirect:/home";
		}
		
		request.getSession().setAttribute("logininvalid-flashmsg","Invalid Username & Password!");
		return "redirect:/signin";
	}
	
	@RequestMapping(value="/getDistrictList/{state}", method = RequestMethod.GET, produces = "text/plain")
	@ResponseBody
	public String districtlist(@PathVariable("state") int state, HttpServletResponse response)
	{
		response.setContentType("application/json");
		List<District> list = userPopulatedDao.getDistrictList(state);
		String str = "";
		for(District d: list) {
			str += "<option value=\""+ d.getDistrictid() +"\">"+d.getDistrictname()+"</option>";
		}
		
		return str;
	}
		/*JSONArray array = new JSONArray();
		
		List<District> ls=userPopulatedDao.getDistrictList(state);	
		for(int i = 0; i < ls.size(); i++) 
		{
			JSONObject obj = new JSONObject();
			obj.put("distid", ls.get(i).getDistrictid());
			obj.put("distname", ls.get(i).getDistrictname());
			obj.put("stateid", ls.get(i).getStateid());
			array.add(obj);
		}
		return array.toJSONString();*/
		
	
	
	
}
