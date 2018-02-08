package com.rc.uam.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.rc.uam.model.ResponseError;

/*
 *  @ControllerAdvice will enable exception handling on all controllers inside the package that the class (or interface) lives in
 */
@ControllerAdvice(basePackageClasses = AuthenticationController.class)
public class RestExceptionController {
	@ExceptionHandler
	@ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseError handleConflict(Exception ex) {     
        return new ResponseError(
        		HttpStatus.INTERNAL_SERVER_ERROR.value(), 
        		ex.getMessage(), ex.getClass().getName(), 
        		ex.getStackTrace()[0].getMethodName(), 
        		ex.getStackTrace()[0].getFileName(), 
        		ex.getStackTrace()[0].getLineNumber());
    }
}
