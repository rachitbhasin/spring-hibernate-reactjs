package com.rc.uam.service;

import java.util.List;

import com.rc.uam.exception.UamException;
import com.rc.uam.model.User;

/**
 * @author Rachit Bhasin
 *
 */
public interface UserService {
	long save(User user) throws UamException;
	User get(Long id) throws UamException;
	User findByField(String field, String value) throws UamException;
	List<User> list() throws UamException;
	void update(Long id, User user) throws UamException;
	void delete(Long id) throws UamException;
}