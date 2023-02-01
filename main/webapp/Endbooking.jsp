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
<p>Total amount to be paid</p>
<p>${totalamount}</p>
<form action="User.jsp">
<button>proceed to pay</button>
</form>
</body>
</html>