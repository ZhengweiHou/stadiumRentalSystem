package com.hzw.StadiumRentalSystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao {

	// @PersistenceContext
	// protected EntityManager em;

	@Autowired
	protected SessionFactory sessionFactory;

	protected Session session() {
		return this.sessionFactory.getCurrentSession();
	}

	public void flush() {
		this.session().flush();
	}
	
	public void close(){
		this.session().close();
	}
}
