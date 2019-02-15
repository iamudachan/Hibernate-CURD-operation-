package com.jdbc.createstuden;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.DateUtils;
import com.jdbc.Student;

public class AutoIncreament {

	public static void main(String[] args) throws ParseException {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student st1 =  new Student("1q","1q","111111@qq",theDateOfBirth);
			Student st2 =  new Student("2q","2q","122221@qq",theDateOfBirth);
			Student st3 =  new Student("3q","3q","13331@qq",theDateOfBirth);
			s.beginTransaction();
			s.save(st1);
			s.save(st2);
			s.save(st3);
			s.getTransaction().commit();
		} finally {
			sf.close();
		}
	}

}
