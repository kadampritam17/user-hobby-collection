
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.java.miniproject.pojo.User"%>
<%@page import="com.java.miniproject.pojo.Hobby"%>
<%@page import="com.java.miniproject.db.DBManager"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Hobby</title>
</head>
<body>
<%
User newUser = (User)session.getAttribute("user");
String full_user_name = newUser.getFirstName() + " " + newUser.getLastName();

%>
Welcome <%=full_user_name %>...!!!
<br>
View hobby page
<%
DBManager db = new DBManager();
List<Hobby> list = db.getAllHobby(newUser);
%>
<table border="1">
  <tr>
    <th>HobbyID</th>
    <th>User ID</th>
    <th>Hobby Name</th>
  </tr>
  <%
 for(Hobby hobby : list)
 {
  %>
  <tr>
    <td><%=hobby.getId() %></td>
    <td><%=hobby.getUserId() %></td>
    <td><%=hobby.getHobby() %></td>
  </tr>
  <%
 }//end of for
  %>
</table>

</body>
</html>