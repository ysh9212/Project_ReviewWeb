package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	public static Connection getConnect() throws Exception {
		String user = "project";
		String password = "project";
		String url = "jdbc:oracle:thin:@211.238.142.44:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. driver 메모리에 로딩
		Class.forName(driver);
		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
				
				
		return con;
	}
	public static void disConnect(Connection con) throws Exception{
		con.close();
	}
	public static void disConnect(PreparedStatement st, Connection con) throws Exception{
		st.close();
		con.close();
	}
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception{
		rs.close();
		st.close();
		con.close();
	}
	
}
