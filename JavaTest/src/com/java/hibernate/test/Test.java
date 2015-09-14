package com.java.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.java.hibernate.domain.UserInfo;

@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();
		
		ServiceRegistry serviceRegistry =  new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		
		UserInfo userInfo = new UserInfo();
		userInfo.setName("gao");
		userInfo.setBirthday("1990-10-13");
		
		org.hibernate.Transaction transaction = session.beginTransaction();
		try {
			session.save(userInfo);
			transaction.commit();
			System.out.println("Success");
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Error");
		}finally{
			session.close();
			sessionFactory.close();
			System.out.println("Finished");
		}
		
	}
}
