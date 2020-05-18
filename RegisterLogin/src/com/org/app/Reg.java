package com.org.app;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/Reg")
public class Reg extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		String city=req.getParameter("city");
		String password=req.getParameter("password");
		
		//JDBC Connections

		String url="jdbc:mysql://localhost:3306/student?user=root&password=1234";
		String query="insert into reglog values(?,?,?)";
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(1, name);
		st.setString(2, city);
		st.setString(3, password);
		int row=st.executeUpdate();
		if(row>0) {
			RequestDispatcher dis=req.getRequestDispatcher("login.jsp");
			dis.include(req, resp);
		out.println("Registration Successfully");
		con.close();
		}
	}
			
		catch(Exception e) {
			System.err.println(e);
		}
	}

}
