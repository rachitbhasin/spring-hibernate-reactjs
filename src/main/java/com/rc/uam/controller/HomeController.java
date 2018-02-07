package com.rc.uam.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Rachit Bhasin
 *
 */
@Controller
public class HomeController {
	
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = { "/app/*", "/app/*/*" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
		logger.info("Loading index page for SPA application");
		
        return "index";
    }
}
