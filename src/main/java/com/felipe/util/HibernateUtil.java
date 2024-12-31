package com.felipe.util;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	
	private HibernateUtil() {
	}

	private static EntityManager createEntityManager() {
		Properties properties = new Properties();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CFTV-PU", properties);
		return entityManagerFactory.createEntityManager();
	}

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
