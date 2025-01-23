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
	private static Session currentSession;
	private static EntityManager entityManager;

	private HibernateUtil() {
	}

	private static EntityManager createEntityManager() {
		if (entityManager == null ) {
			String dataBaseHost = System.getenv("DATABASE_HOST") != null ? System.getenv("DATABASE_HOST") : "localhost";
			String dataBaseUser = System.getenv("DATABASE_USER") != null ? System.getenv("DATABASE_USER") : "root";
			String dataBasePassword = System.getenv("DATABASE_PASSWORD") != null ? System.getenv("DATABASE_PASSWORD") : "1234";

			String dataBaseUrl = String.format("jdbc:mysql://%s/databasecftv?createDatabaseIfNotExist=true", dataBaseHost);

			Properties properties = new Properties();

			properties.setProperty("javax.persistence.jdbc.url", dataBaseUrl);
			properties.setProperty("javax.persistence.jdbc.user", dataBaseUser);
			properties.setProperty("javax.persistence.jdbc.password", dataBasePassword);
			properties.setProperty("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CFTV-PU", properties);
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		} 
		return entityManager;
	}

	public static Session getSession() {
		if(currentSession == null || !currentSession.isOpen() )  {
			Session session = createEntityManager().unwrap(Session.class);
			sessionFactory = session.getSessionFactory();
			try {
				return sessionFactory.getCurrentSession();
			} catch (HibernateException e) {
				currentSession = sessionFactory.openSession();
				return currentSession;
			}
		}
		return currentSession;
		
	}
}
