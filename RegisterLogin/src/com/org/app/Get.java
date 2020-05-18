package com.org.app;

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

@WebServlet("/Get")
public class Get extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String name="name";
		String city="city";
		String password="password";
		
		//JDBC Connections
   
		String url="jdbc:mysql://localhost:3306/student?user=root&password=1234";
		String query="select * from reglog";
		try {
	         Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url);
		PreparedStatement st=con.prepareStatement(query);
		ResultSet rs=st.executeQuery();
		while(rs.next())
		{
			RequestDispatcher dis=req.getRequestDispatcher("result.jsp");
			dis.include(req, resp);
		
			//out.print(rs.getString(1));
			//out.println(rs.getString(2));
			//out.println(rs.getString(3));
				
		}
		con.close();
		out.println("Values Got Successfully");
		
	}
		catch(Exception e) {
			System.err.println(e);
		}
	}

}
