package com.jdbc.createstuden;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.DateUtils;
import com.jdbc.Student;

public class CreateStudent {

	public static void main(String[] args) throws ParseException {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
		
//			Student st =  new Student("1q","2q","11@qq");
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            
            Student st = new Student("Paully", "Doe", "paul@luv.com", theDateOfBirth);
			s.beginTransaction();
			s.save(st);
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
