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
<form action="LoginServlet" method="post">
Username<input type="text" name="Luser" required>
<br>
Password<input type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" name="Lpass" placeholder="Must contains 8 or more" required>
More than 8 letters one number one lowercase and one uppercase
<br>
<button type="submit">Submit</button>
<button type="reset">clear</button>
</form>
<form action="signup.jsp">
<button type="submit">Create new Account</button>
</form>
</body>
</html>