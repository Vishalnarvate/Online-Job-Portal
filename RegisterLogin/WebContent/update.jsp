<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:wheat;">
<h1>Welcome To Global Jobs</h1>
<form action="Update">
<h3><marquee direction="right" style="color:red;">Apply for a job</marquee></h3>
<table>
<tr><td>name:</td><td><input type="text" name="name"></td> </tr>
<tr><td>password:</td><td><input type="password" name="password"></td>     </tr>
<tr><td>Confirm password:</td><td><input type="password" name="cpassword"></td> </tr>

</table>
<input type="submit" value="Update">
New User ? :<a href="register.jsp">Register</a>

</body>
</html>