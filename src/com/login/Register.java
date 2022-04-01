package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("first name");
		String lname = request.getParameter("last name");
		String email = request.getParameter("mail");
		String name = request.getParameter("name");
		String pwd = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/web?" + "user=root&password=root");
			
			String sql = "insert into Register values(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, fname);
			st.setString(2, lname);
			st.setString(3, email);
			st.setString(4, name);
			st.setString(5, pwd);
			st.execute();
			
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}

