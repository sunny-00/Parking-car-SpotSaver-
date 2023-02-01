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
<form action="rent">
<select name="city">City
<option >Thane</option>
<option >Mumbai</option>
<option >kalyan</option>
<option >Dadar</option>
</select>
<br>
address<input type="text" name="address" required>
<br>
number of spots<input type="number" name="spot" required max="10" min="1" value="1">
<br>
price per hour<input type="number" name="price" required max="2000" min="250" value="250">
<br>
<button type="submit">Register your place</button>
<br>
<h4> Your place will be listed once it is approved by us. </h4>
</form>
</body>
</html>