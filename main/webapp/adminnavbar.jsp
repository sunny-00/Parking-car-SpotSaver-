<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
  background-color:lightgrey;
  color:black;
}
button{
color:black;
}
  </style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Admin.jsp">SpotSaver</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="addlocation.jsp">Add</a></li>
      <li><a href="remove.jsp">Remove location</a></li>
      <li><a href="approve.jsp">Approve</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Adminlogout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
    </ul>
  </div>
</nav>

</body>
</html>