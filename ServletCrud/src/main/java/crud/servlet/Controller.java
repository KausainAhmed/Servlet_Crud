package crud.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s1")
public class Controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Emp e = new Emp();
		Service s = new Service();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("hello servlet");
		String sname = req.getParameter("b1");
		if (sname.equals("Save Employee")) {

			String name = req.getParameter("name");
			String password = req.getParameter("password");
			String email = req.getParameter("email");

			try {
				s.dataInsert(e, name, password, email);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		else if (sname.equals("View")) {
			try {
				List dataView = s.dataView();
				System.out.println(dataView);
				req.setAttribute("View", dataView);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RequestDispatcher rd = req.getRequestDispatcher("View.jsp");
			rd.forward(req, resp);

		} else if (sname.equals("Update")) {
			System.out.println("kucch bhi");
			e.setId(Integer.parseInt(req.getParameter("id")));
			e.setName(req.getParameter("name"));
			e.setPassword(req.getParameter("password"));
			e.setEmail(req.getParameter("email"));

			try {
				s.dataUpdate(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
