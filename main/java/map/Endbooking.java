package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Endbooking
 */
@WebServlet("/Endbooking")
public class Endbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Endbooking() {
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
		String address=request.getParameter("address");
		int spot=Integer.parseInt(request.getParameter("spot"));
		LocalTime bookingtime = LocalTime.parse(request.getParameter("time"));
		LocalDateTime currentzone=LocalDateTime.now();
		Time t=Time.valueOf(currentzone.toLocalTime().getHour()+":"+currentzone.toLocalTime().getMinute()+":"+currentzone.toLocalTime().getSecond());
		out.print(t);
		 try
			{
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=null;
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
				
				
				Statement stmt=con.createStatement();
				
				String quer="update spotbooked set finishtime=? where address=? and user=? and status='pending'" ;
				PreparedStatement ptsm=con.prepareStatement(quer);
				ptsm.setTime(1, t);
				ptsm.setString(2, address);
				ptsm.setString(3, LoginServlet.name0);	
				ptsm.executeUpdate();
				
				String query1="update location set spot=spot+? where address=?";
				ptsm=con.prepareStatement(query1);
				ptsm.setInt(1, spot);
				ptsm.setString(2, address);
				ptsm.executeUpdate();
				
				String query="update spotbooked set status='paid' where address=? and user=?" ;
				ptsm=con.prepareStatement(query);
				ptsm.setString(1, address);
				ptsm.setString(2, LoginServlet.name0);
				ptsm.executeUpdate();
				
				LocalDateTime d2=LocalDateTime.of(currentzone.toLocalDate().minusDays(1), bookingtime);
				int diff=currentzone.getHour()-bookingtime.getHour();
				Duration duration;
				long hours = 0;
				String query01="select price from location where address='"+address+"'";
				double price=0.0;
				ResultSet rs=stmt.executeQuery(query01);
				while(rs.next())
				{
					price=rs.getDouble("price");
				}
				if(diff<0)
				{
				d2=LocalDateTime.of(currentzone.toLocalDate().minusDays(1), bookingtime);
				duration = Duration.between(d2, currentzone);
				 hours= duration.toHours();
				 out.println(hours);
				 out.print("hey");
				 int totalamount=(int) (price*spot*hours);
				    request.setAttribute("totalamount",totalamount );
					request.getRequestDispatcher("Endbooking.jsp").include(request, response);
				}
				if(diff>0) {
					int totalamount=(int) (price*spot*diff);
					 request.setAttribute("totalamount",totalamount );
					 request.getRequestDispatcher("Endbooking.jsp").include(request, response);
				}
				if(diff==0)
				{
					int totalamount=(int)(price*spot);
					 request.setAttribute("totalamount",totalamount );
					 request.getRequestDispatcher("Endbooking.jsp").include(request, response);
				}
				
			}
		 catch(Exception e)
		 {
			 
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
