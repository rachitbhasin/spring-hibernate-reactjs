package com.rc.uam.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rc.uam.exception.UamException;
import com.rc.uam.model.Book;
import com.rc.uam.model.User;
import com.rc.uam.service.UserService;

/**
 * @author Rachit Bhasin
 *
 */
@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {
	@Autowired
	UserService userService;
	
	/*---Add new User---*/
	   @PostMapping("/user")
	   @PreAuthorize("hasRole('ADMIN')")
	   public ResponseEntity<String> save(@RequestBody User user) throws UamException {
	      long id = userService.save(user);
	      return ResponseEntity.ok().body("New User has been saved with ID:" + id);
	   }
	   
	   /*---Get a User by id---*/
	   @GetMapping("/user/{id}")
	   @PreAuthorize("hasAnyRole('ADMIN','USER')")
	   public ResponseEntity<?> get(@PathVariable("id") long id) throws UamException {
	      User user = userService.get(id);
	      if(user == null) {
	    	  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	      }
	      return ResponseEntity.ok().body(user);
	   }
	   
	   /*---Update a user by id---*/
	   @PutMapping("/user/{id}")
	   @PreAuthorize("hasRole('ADMIN')")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody User user) throws UamException {
	      userService.update(id, user);
	      return ResponseEntity.ok().body("Book has been updated successfully.");
	   }

	   /*---Delete a user by id---*/
	   @DeleteMapping("/user/{id}")
	   @PreAuthorize("hasRole('ADMIN')")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) throws UamException {
	      userService.delete(id);
	      return ResponseEntity.ok().body("Book has been deleted successfully.");
	   }
}
