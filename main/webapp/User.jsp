<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="map.LoginServlet" %>
<% if(LoginServlet.name0==null)
	{
	response.sendRedirect("login.jsp");
	}
	%>
<%@ include file="navbar2.jsp" %>
<form action="book.jsp">
<button type="submit">book you spot!</button>
</form>
<form action="rent.jsp">
<button type="submit">Rent your spot.</button>
</form>
<form action="currentlybooked">
<button type="submit">Currently booked</button>
</form>
</body>
</html>