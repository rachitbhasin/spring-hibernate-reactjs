package com.rc.uam.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Rachit Bhasin
 *
 */
public class UamAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	      return new Class[] { WebConfig.class };
	   }

	   @Override
	   protected Class<?>[] getServletConfigClasses() {
	      return null;
	   }

	   @Override
	   protected String[] getServletMappings() {
	      return new String[] { "/" };
	   }
	}
