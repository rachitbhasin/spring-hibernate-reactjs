/**
 * 
 */
package com.rc.uam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rc.uam.dao.UserDao;
import com.rc.uam.exception.UamException;
import com.rc.uam.model.User;
import com.rc.uam.service.UserService;

/**
 * @author Rachit Bhasin
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public long save(User user) throws UamException {
		return userDao.save(user);
	}

	@Override
	public User find(Long id) throws UamException {
		return userDao.get(id);
	}
	
	@Override
	public User findByField(String field, String value) throws UamException {
		return userDao.findByField(field, value);
	}
	
	@Override
	public List<User> list() throws UamException {
		return userDao.list();
	}

	@Transactional
	@Override
	public void update(Long id, User user) throws UamException {
		userDao.update(id, user);
	}

	@Transactional
	@Override
	public void delete(Long id) throws UamException {
		userDao.delete(id);
	}
}
