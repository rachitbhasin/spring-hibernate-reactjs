package com.rc.uam.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rc.uam.model.User;
import com.rc.uam.utility.CustomUtil;

@Controller
public class HomeController {
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	@RequestMapping(value = { "/*", "/*/*" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
		logger.info("User is Logged in: " + CustomUtil.isUserLoggedIn());
		User user = CustomUtil.getLoggedInUser();
		if(user!=null) {
			logger.info("Logged in as: " + user.getEmail());
		}
		
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        return "index";
    }
}
