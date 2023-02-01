<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbar2.jsp" %>
<%@ page import="map.LoginServlet" %>
<% if(LoginServlet.name0==null)
	{
	response.sendRedirect("login.jsp");
	}
	%>
<form action="book">
<select name="city">City
<option >Thane</option>
<option >Mumbai</option>
<option >kalyan</option>
<option >Dadar</option>
</select>
<input type="number" name="spotcount" max="5" min="1" value="1">


<button type="submit">Find your spot</button>
</form>
</body>
</html>