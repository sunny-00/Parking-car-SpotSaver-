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
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="map.LoginServlet" %>
<% if(LoginServlet.name0==null)
	{
	response.sendRedirect("login.jsp");
	}
	%>
	
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
       if (request.getAttribute("hash") != null) {
    	   HashMap<String, Integer> list = (HashMap<String, Integer>) request.getAttribute("hash");
    	   // Rest of the code
    	 
       int i=1;
       double Grandtotal=0;
       for(Map.Entry m : list.entrySet())
       {  
			String city= m.getKey().toString();
			int spot=Integer.parseInt(m.getValue().toString());
			String address;
			double totalprice=0;
			String query="select * from location where city="+"'"+city+"' and spot>='"+spot+"'"; 
			 ResultSet rs=stmt.executeQuery(query);

		       while(rs.next())
		       {
		    	   double price=rs.getDouble("price");
		    	   address=rs.getNString("address");
		    	   totalprice=rs.getDouble("price")*spot;

		   %>
		   		   <tr>
		   		   <td><%=i %></td>
		   		   <td><%=city %></td>
		   		   <td></td>
		   		   <td><%=address %></td>
		           <td><%=spot%></td>       
		           <td><%=price %></td>
		           <td><%= totalprice %></td>
		           
		           <td><form action="confirmbooking.jsp"><input type="hidden" name="address" value="<%=address.trim()+spot%>">  	<button type="submit" name=<%="address0" %> value=<%=address.trim()%>>Book</button></form></td>
					</tr>
					
		   <%
		   
		   i++; 	   
       }
		     
       }
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