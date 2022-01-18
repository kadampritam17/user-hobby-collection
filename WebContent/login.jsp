<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>
<%
String successMsg = (String)request.getAttribute("success");
if(successMsg != null)
	response.getWriter().append(successMsg);

%>
</h3>
<form action="LoginServlet" method="POST">
<pre>
 <label>User name : </label> <input type="text" id="uname" name="uname"/>
 
 <label>Password : </label> <input type="password" id="pass" name="pass"/>
 
 <input type="submit" name="login" value="Login"/>
</pre>


</form>
</body>
</html>