<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<body>
<%@ include file="navbar2.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.sql.Time" %>
<%@ page import="map.LoginServlet" %>
<% if(LoginServlet.name0==null)
	{
	response.sendRedirect("login.jsp");
	}
	%>
<table border="2">
   <tr>
   		<td>ID</td>
        <td>address<td>
        <td>spot</td>
        <td>booking time</td>
   </tr>
   
   <%
   try
	{
	   LoginServlet ls=new LoginServlet();
  	 	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
		String query="select * from spotbooked where user='"+ls.name0+"' and status='pending'";
		PreparedStatement ptsm=con.prepareStatement(query);
		ResultSet rs=ptsm.executeQuery();
		int i=1;
		while(rs.next())
		{
		    	   String address=rs.getString("address");
		    	   int spot=rs.getInt("spot");
		    	   Time bookingtime=rs.getTime("bookingtime");
		   %>
		   		   <tr>
		   		   <td><%=i %></td>
		   		   <td><%=address %></td>
		   		   <td></td>
		   		   <td><%=spot %></td>
		           <td><%=bookingtime%></td>       
		           <td><form action="Endbooking">
		          		 <input type="hidden" name="address" value="<%=address.trim()%>"> 
		           		 <input type="hidden" name="spot" value="<%=spot%>"> 
		           		 <input type="hidden" name="time" value="<%=bookingtime %>">
		            	 <button type="submit" name=<%="address0" %> value=<%=address.trim()%>>End</button>
		            	 </form>
		                 </td>
					     </tr>
					
		   <%
		   
		   i++; 	   
       }
		     
       
   
		   %>
		     
		   </table>
		   <br>
		   <br>
		  
		   <%
		       
		   if(ptsm!=null)
		   {
			   ptsm.close();
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
</head>
</html>