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
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
	
<table border="2">
   <tr>
   		<td>ID</td>
        <td>City<td>
        <td>Address</td>
        <td>spots booked</td>
        <td>prices per spot per hour</td>
        <td>Total price  per hour </td>
   </tr>
   
   <%
   try
   {
	   HttpServletRequest req = (HttpServletRequest) pageContext.getAttribute("request");
       Class.forName("com.mysql.cj.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/parking";
       String username="root";
       String password="";
       
       Connection con=DriverManager.getConnection(url, username, password);
       Statement stmt=con.createStatement();
 	   String sqlquery="select * from location";
 	   ResultSet rs=stmt.executeQuery(sqlquery);
       int i=1;

		       while(rs.next())
		       {
				 String city=rs.getString("city");
				 String address=rs.getString("address");
				 int spot=rs.getInt("spot");
				 double price=rs.getDouble("price");
				 String user=rs.getString("User");

		   %>
		   		   <tr>
		   		   <td><%=i %></td>
		   		   <td><%=city %></td>
		   		   <td></td>
		   		   <td><%=address %></td>
		           <td><%=spot%></td>       
		           <td><%=price %></td>
		           <td><%= user %></td>
		           <td><form action="remove"><input type="hidden" name="address" value="<%=address.trim()%>">
		           <input type="hidden" name="city" value="<%=city%>">   
		           <input type="hidden" name="spot" value="<%=spot%>">
		           <button type="submit" name=<%="address0" %> value=<%=address.trim()%>>Remove</button></form></td>
				   </tr>
					
		   <%
		   
		   i++; 	   
       }
		     
       
    
		   %>
		     
		   </table>
		   <br>
		   <br>
		  
		   <%
		       
		   if(stmt!=null)
		   {
		        stmt.close();
		   }
		   if(con!=null)
		   {
		        con.close();
		   }
		   }
		   catch(Exception e)
		   {
		        e.printStackTrace();
		   }
		   
		     
   %>
</body>
</html>