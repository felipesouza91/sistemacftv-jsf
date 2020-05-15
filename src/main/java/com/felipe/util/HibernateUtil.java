package com.felipe.util;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	public static EntityManager createEntityManager() {
		Properties properties = new Properties();
		properties.setProperty("Teste", "logal");
		return Persistence.createEntityManagerFactory("CFTV-PU", properties).createEntityManager();
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
