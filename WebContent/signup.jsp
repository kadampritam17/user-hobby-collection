<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>
</head>
<body>

<h3>
<%

String errorMsg = (String)request.getAttribute("error");
if(errorMsg != null)
	response.getWriter().append(errorMsg);

%>
</h3>
	<form action="AddUserServlet" method="POST">
		<pre>

<label>First Name : </label> <input type="text" id="first_name" name="first_name" />
 
 <label>Last Name : </label> <input type="text" id="last_name" name="last_name" />
 
 <label>Email : </label> <input type="email" id="email" name="email" />
 
 <label>Mobile : </label> <input type="text" id="mob" name="mob" />
 
 <label>User name : </label> <input type="text" id="uname" name="uname" />
 
 <label>Password : </label> <input type="password" id="pass" name="pass" />
 
 <input type="submit" name="login" value="Login" />
</pre>


	</form>
</body>
</html>