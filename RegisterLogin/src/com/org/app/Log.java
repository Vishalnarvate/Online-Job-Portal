package com.org.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Log")
public class Log extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		//JDBC Connections

		String url="jdbc:mysql://localhost:3306/student?user=root&password=1234";
		String query="select name, password from reglog where name=? and password=?";
		String un=null;
		String up=null;
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			un=rs.getString(1);
			up=rs.getString(2);
		}
		if(name.equalsIgnoreCase(un)&&password.equalsIgnoreCase(up)) {
			RequestDispatcher dis=req.getRequestDispatcher("Get");
			dis.include(req, resp);
			out.println("<h1> login success<h1>");
			
		}
		else {
			RequestDispatcher dis=req.getRequestDispatcher("login1.jsp");
			dis.include(req, resp);
		}
	}
		catch(Exception e) {
			System.err.println(e);
		}
		
	}

}
