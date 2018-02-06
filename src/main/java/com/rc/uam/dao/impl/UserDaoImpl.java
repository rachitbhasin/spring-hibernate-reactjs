package com.rc.uam.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.rc.uam.dao.AbstractDao;
import com.rc.uam.dao.UserDao;
import com.rc.uam.model.User;

@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	@Override
	public long save(User user) {
		save(user);
		return user.getId();
	}

	@Override
	public User get(Long id) {
		return getByKey(id);
	}

	@Override
	public User getByField(String field, String value) {
		//**creating CriteriaBuilder**
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		criteria.select(userRoot);

		//**Adding where clause**
		criteria.where(builder.equal(userRoot.get(field), value));
		
		return getSession().createQuery(criteria).uniqueResult();
	}

	@Override
	public List<User> list() {
		CriteriaBuilder builder = getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		
		Root<User> root = criteria.from(User.class);
		criteria.select(root);
		
		Query<User> query = getSession().createQuery(criteria);
		
		return query.getResultList();
	}

	@Override
	public void update(Long id, User user) {
		@SuppressWarnings("unused")
		User user2 = loadByKey(id);
		user2 = user;
		flush();
	}

	@Override
	public void delete(Long id) {
		User user = loadByKey(id);
		delete(user);
	}
}
