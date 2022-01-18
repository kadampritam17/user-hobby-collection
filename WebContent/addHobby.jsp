<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.java.miniproject.pojo.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hobby</title>
</head>
<body>
<%
User newUser = (User)session.getAttribute("user");
String full_user_name = newUser.getFirstName() + " " + newUser.getLastName();

%>
Welcome <%=full_user_name %>...!!!

<br>
<br>
Add hobby page

<br>
<br>
<form action="AddHobbyServlet" method="POST">
<pre>
 <label>Hobby : </label> <input type="text" id="hobby" name="hobby"/>
 
 <input type="submit" name="login" value="ADD"/>
</pre>
<br>

</form>
</body>
</html>