package com.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test2 {

	public static User retrieveFromId(int idValue) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		String queryString = "from User where id = :id";
		Query query = session.createQuery(queryString);
		query.setInteger("id", idValue);
		Object queryResult = query.uniqueResult();
		User user = (User) queryResult;
		session.getTransaction().commit();
		return user;
	}

	public static void retrieve() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Query queryResult = session.createQuery("from User");
		List allUsers = queryResult.list();
		for (int i = 0; i < allUsers.size(); i++) {
			User user = (User) allUsers.get(i);
			System.out.println(user.getUserId() + user.getUsername());
		}
		System.out.println("Database contents delivered...");
	}

	public static void main(String[] args) {

		User user = retrieveFromId(1);
		System.out.println(user.getUserId() + user.getUsername());

		retrieve();
	}

}
