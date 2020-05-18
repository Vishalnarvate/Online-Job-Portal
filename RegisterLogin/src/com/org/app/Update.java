package com.org.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Update")
public class Update extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
	
		
		PrintWriter out=resp.getWriter();
		String password=req.getParameter("password");
		String cpassword=req.getParameter("cpassword");
		String name=req.getParameter("name");
		
		//JDBC Connections

		String url="jdbc:mysql://localhost:3306/student?user=root&password=1234";
		String query="update reglog set password=? where name=?";
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
		PreparedStatement st=con.prepareStatement(query);
		st.setString(2, name);
		st.setString(1, cpassword);
		int row=st.executeUpdate();
		if(row>0) {
			out.println(" password Updated  Successfully");
			RequestDispatcher dis=req.getRequestDispatcher("login.jsp");
			dis.include(req, resp);
		
		con.close();
		}
		else
		{
			out.println("Enter Correct username");
			RequestDispatcher dis=req.getRequestDispatcher("update.jsp");
			dis.include(req, resp);
		}
	}
			
		catch(Exception e) {
			System.err.println(e);
		}
	}


}
