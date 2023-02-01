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
<form action="booked">

<button>Proceed to Book</button>

<%@ page import="java.util.*,javax.servlet.*" %>
<%
    String address=request.getParameter("address");
%>
<input type="hidden" name="address" value="<%=address%>">
</form>
</body>
</html>