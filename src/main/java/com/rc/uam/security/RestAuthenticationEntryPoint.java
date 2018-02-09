/**
 * 
 */
package com.rc.uam.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rc.uam.model.ResponseError;

/**
 * @author Rachit Bhasin
 *
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			            HttpServletResponse response,
			            AuthenticationException authException) throws IOException, ServletException {
		// This is invoked when user tries to access a secured REST resource without supplying any credentials
        // We should just send a 401 Unauthorized response because there is no 'login page' to redirect to
		response.setStatus(HttpStatus.FORBIDDEN.value());
    	response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        String message;
        if(authException.getCause() != null) {
            message = authException.getCause().getMessage();
        } else {
            message = authException.getMessage();
        }
        byte[] body = new ObjectMapper()
                .writeValueAsBytes(new ResponseError(
                		HttpStatus.INTERNAL_SERVER_ERROR.value(), 
                		authException.getStackTrace()[0].getLineNumber(),
                		message, 
                		authException.getClass().getName(), 
                		authException.getStackTrace()[0].getMethodName(), 
                		authException.getStackTrace()[0].getFileName(),
                		authException.getStackTrace()
                		));
        response.getOutputStream().write(body);

	}

}
