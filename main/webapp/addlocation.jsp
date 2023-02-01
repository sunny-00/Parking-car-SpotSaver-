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
<form action="addlocation">
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
<button type="submit">add the location</button>
<br>
</form>
</body>
</html>