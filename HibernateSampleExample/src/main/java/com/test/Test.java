package com.test;

import java.util.Date;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUsername("Urvi");
		user.setCreatedBy("Yahoo");
		user.setCreatedDate(new Date());

		session.save(user);
		session.getTransaction().commit();

	}

}
