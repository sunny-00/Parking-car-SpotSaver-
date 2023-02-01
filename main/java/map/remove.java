package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class remove
 */
@WebServlet("/remove")
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public remove() {
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
		int spot = Integer.parseInt(request.getParameter("spot"));
		String city=request.getParameter("city");
		
		 try
		   {
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       String url="jdbc:mysql://localhost:3306/parking";
		       String username="root";
		       String password=""; 
		       Connection con=DriverManager.getConnection(url, username, password);
		       String sql="delete from location where city=? and address=? and spot=?";      
		       PreparedStatement ps=con.prepareStatement(sql);
		       ps.setString(1,city);
		       ps.setString(2, address);
		       ps.setDouble(3, spot);
		       ps.executeUpdate();	
		       response.sendRedirect("remove.jsp");
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
