package com.jdbc.createstuden;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class DeleteStudent {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		try {
			s.beginTransaction();
			Student st = s.get(Student.class,14);
			st.setFirstName("raju");
			s.delete(st);
			s.createQuery("delete from Student  where id='13' ").executeUpdate();
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
