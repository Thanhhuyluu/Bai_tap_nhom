package model.dao;



import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	public static Connection getConnection() {
		Connection c = null;		
		final String url="jdbc:mysql://localhost:3306/website_gt_dia_diem_du_lich"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			System.out.println("cant open database");
			e.printStackTrace();
		}
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!= null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}