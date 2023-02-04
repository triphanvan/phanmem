package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.jdbc.Driver;

public class jdbcutil {
	private static java.sql.DatabaseMetaData mtdt;
	public static Connection getconnection()
	{
		Connection c=null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url="jdbc:mySQl://localhost:3306/quanlydoanhthuveso";
			String username="root";
			String password="";
			
			c=DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c)
	{
		try {
			if(c!=null)
			{
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void printinfo(Connection c) {
		try {
			if(c!=null)
			{
				 mtdt=c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
