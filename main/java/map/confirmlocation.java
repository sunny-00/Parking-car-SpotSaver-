package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class confirmlocation
 */
@WebServlet("/confirmlocation")
public class confirmlocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmlocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String city=request.getParameter("city");
		String address=request.getParameter("address");
		int spot=Integer.parseInt(request.getParameter("spot"));
		double price=Double.parseDouble(request.getParameter("price"));
		String user=request.getParameter("user");
		try
		{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
		if(request.getParameter("Approve")!=null)
		{
			out.println("hey");
			String sqlquery="insert into approved(user,city,address,spot,price,date) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sqlquery);
			ps.setString(1, user);
			ps.setString(2, city);
			ps.setString(3, address);
			ps.setInt(4, spot);
			ps.setDouble(5, price);
			LocalDateTime currentzone=LocalDateTime.now();
			Date t=Date.valueOf(currentzone.toLocalDate());
			ps.setDate(6,t );
			ps.executeUpdate();
			
			
			String query="insert into location(city,address,spot,price,User) values(?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, city);
			ps.setString(2, address);
			ps.setInt(3, spot);
			ps.setDouble(4, price);
			ps.setString(5, user);
			ps.executeUpdate();
			
			String sql="delete from locationapproval where user=? and city=? and address=? and spot=? and price=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2,city);
			ps.setString(3, address);
			ps.setInt(4, spot);
			ps.setDouble(5, price);
			ps.executeUpdate();	
			response.sendRedirect("approve.jsp");	
		}
		if(request.getParameter("Deny")!=null)
		{
			String sql="delete from locationapproval where user=? and city=? and address=? and spot=? and price=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2,city);
			ps.setString(3, address);
			ps.setInt(4, spot);
			ps.setDouble(5, price);
			ps.executeUpdate();	
			response.sendRedirect("approve.jsp");
		}
	}
		catch(Exception e)
		{
			out.println(e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
