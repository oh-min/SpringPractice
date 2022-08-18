package org.ohm.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class JDBCTest {
	// Driver 로드 정보
	String driver = "com.mysql.jdbc.Driver";
	// url 정보
	String url = "jdbc:mysql://localhost:3306/exam?serverTimezone=Asia/Seoul";
	// userID 정보
	String user = "root";
	// password 정보
	String password = "1234";
	
	// JDBC 연결 테스트 하기 위한 메소드
	@Test
	public void testConnection() throws Exception{
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url, user, password)){
			System.out.println("DB연결성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
