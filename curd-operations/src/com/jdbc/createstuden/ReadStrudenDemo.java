package com.jdbc.createstuden;

import java.sql.Struct;
import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.DateUtils;
import com.jdbc.Student;

public class ReadStrudenDemo {
	public static void main(String[] args) throws ParseException {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
											   .addAnnotatedClass(Student.class)
											   .buildSessionFactory();
		System.out.println(sf.getProperties().get("hibernate.default_schema"));
		
		Session s = sf.getCurrentSession();
		try {
			String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			Student st3 =  new Student("5555","5551q","55555@qq",theDateOfBirth);
			s.beginTransaction();
			s.save(st3);
			s.getTransaction().commit();
			
			s = sf.getCurrentSession();
			s.beginTransaction();
			
			Student st = s.get(Student.class, st3.getId());
			System.out.println(st.getId());
			
			s.getTransaction().commit();
			
		} finally {
			sf.close();
		}
	}

}
