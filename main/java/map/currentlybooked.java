package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class currentlybooked
 */
@WebServlet("/currentlybooked")
public class currentlybooked extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public currentlybooked() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int count=0;
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
				String query="select * from spotbooked where user='"+LoginServlet.name0+"' and status='pending'";
				PreparedStatement ptsm=con.prepareStatement(query);
				ResultSet rs=ptsm.executeQuery();
				while(rs.next())
				{
					count++;
				}
				if(count!=0)
				{
					String user=LoginServlet.name0;
					request.setAttribute("user",user );
					request.getRequestDispatcher("currentlybooked.jsp").include(request, response);
				}
				if(count==0)
				{
					
					out.print("No spots are currently booked");
					request.getRequestDispatcher("User.jsp").include(request, response);
				}
	}
		 catch(Exception e) {
			 
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
