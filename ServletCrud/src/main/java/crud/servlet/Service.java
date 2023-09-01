package crud.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Service {

	void dataInsert(Emp e, String name, String password, String email) throws SQLException {

		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);

		Connection conn = EmpDao.getConnection(); 

		String q = "insert into servlet(name,password,email) values (?,?,?)";

		PreparedStatement ps = conn.prepareStatement(q);
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, email);
		ps.executeUpdate();

	}

	void dataUpdate(Emp e) throws SQLException {
		System.out.println("update.....");
		int status = 0;
		Connection conn = EmpDao.getConnection();
		PreparedStatement ps = conn.prepareStatement("update servlet set name=?,password=?,email=? where id=?");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setInt(4, e.getId());

		status = ps.executeUpdate();
		System.out.println(status );
		conn.close();
	}

	public List dataView() throws SQLException {

		ArrayList<Emp> al = new ArrayList<Emp>();
		Connection conn = EmpDao.getConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from servlet");
		while (rs.next()) {
			Emp ee = new Emp();
			ee.setId(rs.getInt(1));
			ee.setName(rs.getString(2));
			ee.setPassword(rs.getString(3));
			ee.setEmail(rs.getString(4));
			al.add(ee);
		}
		return al;
	}
}