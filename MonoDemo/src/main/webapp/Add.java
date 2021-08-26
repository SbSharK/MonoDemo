package com.mono;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			PreparedStatement ps = con.prepareStatement("insert into employee(eid,ename,salary) values(?,?,?)");
			ps.setInt(1,Integer.parseInt(request.getParameter("id")));
			ps.setString(2,request.getParameter("name"));
			ps.setFloat(3,Float.parseFloat(request.getParameter("salary")));
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
