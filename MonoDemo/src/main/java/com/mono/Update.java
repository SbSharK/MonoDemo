package com.mono;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
			PreparedStatement ps = con.prepareStatement("update employee set ename=?,salary=? where eid=?");
			ps.setInt(3,Integer.parseInt(request.getParameter("id")));
			ps.setString(1,request.getParameter("name"));
			ps.setFloat(2,Float.parseFloat(request.getParameter("salary")));
			//ps.setInt(4, Integer.parseInt(request.getParameter("id")));
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
