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
		String dataBaseHost = System.getProperty("DATABASE_HOST");
		String dataBaseUser = System.getProperty("DATABASE_USER");
		String dataBasePassword = System.getProperty("DATABASE_USER");

		String dataBaseUrl = String.format("jdbc:mysql://%s/databasecftv?createDatabaseIfNotExist=true", dataBaseHost);

		Properties properties = new Properties();

		properties.setProperty("javax.persistence.jdbc.url", dataBaseUrl);
		properties.setProperty("javax.persistence.jdbc.user", dataBaseUser);
		properties.setProperty("javax.persistence.jdbc.password", dataBasePassword);
		properties.setProperty("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

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
