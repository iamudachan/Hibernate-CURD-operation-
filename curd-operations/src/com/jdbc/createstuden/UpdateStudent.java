package com.jdbc.createstuden;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class UpdateStudent {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class).buildSessionFactory();

		Session s = sf.getCurrentSession();
		int id = 12;
		try {
			s.beginTransaction();
			Student st = s.get(Student.class,15);
			st.setFirstName("raju");
			st.setDateOfBirth(new Date("12/01/1222"));
//			s.createQuery("update Student s set s.email = '123' where s.id='12' ").executeUpdate();
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
