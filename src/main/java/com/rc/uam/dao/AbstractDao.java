package com.rc.uam.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao<PK extends Serializable, T> {
     
    private final Class<T> persistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }
 
    public T loadByKey(PK key) {
    	return getSession().byId(persistentClass).load(key);
    }
    
    public void persist(T entity) {
        getSession().persist(entity);
    }
    
    public void flush() {
    	getSession().flush();
    }
 
    public void update(T entity) {
        getSession().update(entity);
    }
 
    public void delete(T entity) {
        getSession().delete(entity);
    }
    
    public CriteriaBuilder getCriteriaBuilder(){
    	return getSession().getCriteriaBuilder();
    }
}
