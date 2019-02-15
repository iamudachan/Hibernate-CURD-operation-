package com.jdbc.createstuden;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.Student;

public class ListOfStudent {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session s = sf.getCurrentSession();
		try {
		s.beginTransaction();
		List<Student> ls = s.createQuery("from     Student s where s.lastName like '%q' ").list();
		displayStruden(ls);

		List<Student> ls1 = s.createQuery("from     Student s  ").list();
		displayStruden(ls1);
		
		s.getTransaction().commit();
		System.out.println(ls.toString());
		} finally {
		sf.close();
		}
	}

	private static void displayStruden(List<Student> ls1) {
		for(Student s11 : ls1)
		{ 
			System.out.println(s11);
		}
	}
}
