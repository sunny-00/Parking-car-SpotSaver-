package map;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class booked
 */
@WebServlet("/booked")
public class booked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booked() {
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
		String add=request.getParameter("address");
		int spot = Integer.parseInt(add.substring(add.length()-1));
	    String location = add.substring(0, add.length()-1);
	    out.print(spot);
	    out.print(location);
	    if(LoginServlet.name0==null)
	    {
	    	response.sendRedirect("login.jsp");
	    }
	    if(LoginServlet.name0!=null) {
	    try
		{
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
			String query="update location set spot=spot-? where address=?";
			PreparedStatement ptsm=con.prepareStatement(query);
			ptsm.setInt(1, spot);
			ptsm.setString(2, location);
			ptsm.executeUpdate();
			HttpSession session=request.getSession();  
			String name=(String) session.getAttribute("name");
			String sqlquery="insert into spotbooked(user,address,spot,bookingtime,status) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sqlquery);
			ps.setString(1, LoginServlet.name0);
			out.println(LoginServlet.name0);
			ps.setString(2, location);
			ps.setInt(3, spot);
			LocalDateTime currentzone=LocalDateTime.now();
			Time t=Time.valueOf(currentzone.toLocalTime().getHour()+":"+currentzone.toLocalTime().getMinute()+":"+currentzone.toLocalTime().getSecond());
			ps.setTime(4,t );
			out.print(t);
			ps.setString(5, "pending");
			ps.executeUpdate();
			response.sendRedirect("User.jsp");
		}
	    
	    catch(Exception e)
	    {
	    	
	    }
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
