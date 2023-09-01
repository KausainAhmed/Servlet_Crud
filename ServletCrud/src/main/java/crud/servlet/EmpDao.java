package crud.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmpDao {
	
static Connection con;
	
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Crud", "root", "open6162");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
