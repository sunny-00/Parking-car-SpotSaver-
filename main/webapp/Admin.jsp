<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="adminnavbar.jsp" %>
<form action="addlocation.jsp">
<button type="submit">Add a new spot or location</button>
</form>
<form action="remove.jsp">
<button type="submit">Remove a location</button>
</form>
<form action="approve.jsp">
<button type="submit">approve pending spots</button>
</form>
<form action="view.jsp">
<button type="submit">View all locations</button>
</form>
</body>
</html>