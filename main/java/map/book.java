package map;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class book
 */
@WebServlet("/book")
public class book extends HttpServlet {
	HashMap<String,Integer> list=new HashMap<String,Integer>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		list.clear();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String city=request.getParameter("city");
		int spot=Integer.parseInt(request.getParameter("spotcount"));
		list.put(city, spot);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=null;
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","");
			String sqlquery00="select * from location where city="+"'"+city+"' and spot>='"+spot+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlquery00);
			int count=0;
			while(rs.next())
			{
				count++;
			}
			if(count!=0)
			{
				request.setAttribute("hash",list);
				request.getRequestDispatcher("bookresult.jsp").forward(request, response);
			}
			if(count==0)
			{
				out.println("currently all the areas are booked in the location try decreasing the spot or changing the city as per your need");
				request.getRequestDispatcher("book.jsp").include(request, response);
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
