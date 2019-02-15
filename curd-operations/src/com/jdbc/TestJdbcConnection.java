package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestJdbcConnection {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:postgresql://localhost:5432/nmc?useSSL=false";
		String user="postgres";
		String pw="";
		Connection con = null;
		PreparedStatement stm = null;
		try{
			System.out.println("Strart");
			//Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(jdbcUrl,user,pw);
			stm = con.prepareStatement("insert into nmc.student(first_name,last_name,email) values('kwwwk','lol','dd@dd.com');");
			boolean t = stm.execute();
			System.out.println(t);
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
