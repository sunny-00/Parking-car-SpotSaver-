<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<form action="signupServlet" method="post">
Username<input type="text" name="Sname" required>
<br>
Password<input type="password" name="Spass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" placeholder="Must contains 8 or more" required>
More than 8 letters one number one lowercase and one uppercase
<br>
Confirm password<input type="password" name="Scpass" placeholder="confirm password" required>
<br>
<button type="submit">Submit</button>
<button type="reset">Clear</button>
</form>
<form action="login.jsp">
<button type="submit">BACK</button>
</form>
</body>
</html>