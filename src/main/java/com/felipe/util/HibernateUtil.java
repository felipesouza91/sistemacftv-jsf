package com.felipe.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	public static EntityManager createEntityManager() {
		return Persistence.createEntityManagerFactory("CFTV-PU").createEntityManager();
	}

	public static SessionFactory sessionFactory;

	public static Session getSession() {
		Session session = createEntityManager().unwrap(Session.class);
		sessionFactory = session.getSessionFactory();
		try {
			return sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			return sessionFactory.openSession();
		}

	}
}
